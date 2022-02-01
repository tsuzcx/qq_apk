package com.tencent.mobileqq.fts.operator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.data.msg.FTSMessageDelete;
import com.tencent.mobileqq.fts.data.msg.FTSMessageForDel;
import com.tencent.mobileqq.fts.data.msg.FTSMessageSync;
import com.tencent.mobileqq.fts.interfaces.IFTSConfig;
import com.tencent.mobileqq.fts.interfaces.IFTSMsgInterface;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.fts.v1.FTSMsgCounter;
import com.tencent.mobileqq.fts.v1.FTSQueryArgs;
import com.tencent.mobileqq.fts.v1.utils.FTSMessageCodec;
import com.tencent.mobileqq.fts.v1.utils.MsgExts;
import com.tencent.mobileqq.fts.v1.utils.TextMsgExts;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSMsgOperator
  extends FTSIndexOperator
  implements IFTSMsgInterface
{
  public static long m = 86400000L;
  long n = 0L;
  long o = 0L;
  private CopyOnWriteArrayList<FTSEntity> p = new CopyOnWriteArrayList();
  private HashMap<String, FTSMsgCounter> q = new HashMap(20);
  private EntityManager r = null;
  private int s = 0;
  private int t = 0;
  
  public FTSMsgOperator(AppRuntime paramAppRuntime, FTSSyncHandler paramFTSSyncHandler)
  {
    super(paramAppRuntime, paramFTSSyncHandler);
    CaughtExceptionReport.a(getClass().getName());
  }
  
  private ArrayList<FTSEntity> a(ArrayList<FTSEntity> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (((IFTSDBRuntimeService)this.a.getRuntimeService(IFTSDBRuntimeService.class, "")).getIFTSConfig().b()) {
      localObject = b(paramArrayList);
    }
    return localObject;
  }
  
  private void a(long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_last_msg_time", paramLong).commit();
  }
  
  private void a(FTSMessage paramFTSMessage, int paramInt)
  {
    try
    {
      Object localObject1 = (IFriendDataService)this.a.getRuntimeService(IFriendDataService.class, "");
      Object localObject2 = MessageRecord.getTableName(paramFTSMessage.senderuin, paramFTSMessage.msgtype);
      if ((paramFTSMessage.istroop == 0) && (!((IFriendDataService)localObject1).isFriend(paramFTSMessage.senderuin)) && (!this.a.getCurrentAccountUin().equals(paramFTSMessage.senderuin)) && (!MessageDBUtils.a((String)localObject2, this.a.getReadableDatabase())))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("selfuin", this.a.getCurrentAccountUin());
        ((HashMap)localObject1).put("senderuin", paramFTSMessage.senderuin);
        ((HashMap)localObject1).put("frienduin", String.valueOf(paramFTSMessage.uin));
        ((HashMap)localObject1).put("type", String.valueOf(paramInt));
        if ((paramFTSMessage.msgExts instanceof MsgExts))
        {
          localObject2 = (TextMsgExts)paramFTSMessage.msgExts;
          ((HashMap)localObject1).put("time", String.valueOf(((TextMsgExts)localObject2).time));
          ((HashMap)localObject1).put("seq", String.valueOf(((TextMsgExts)localObject2).shmsgseq));
        }
        QLog.d("Q.fts.FTSMsgOperator", 1, new Object[] { "reportStrangerInsert ", Long.valueOf(paramFTSMessage.uin), " senderuin:", paramFTSMessage.senderuin });
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(null, "actStrangerFtsMsg", true, 0L, 0L, (HashMap)localObject1, "");
        return;
      }
    }
    catch (Throwable paramFTSMessage)
    {
      QLog.d("Q.fts.FTSMsgOperator", 1, paramFTSMessage, new Object[0]);
    }
  }
  
  private void a(FTSMessageDelete paramFTSMessageDelete)
  {
    Object localObject = this.a.getPreferences();
    long l = System.currentTimeMillis();
    if ((l - ((SharedPreferences)localObject).getLong("fts_delete_db_last_report_time", -1L) > m) && (paramFTSMessageDelete.getId() < this.g))
    {
      ((SharedPreferences)localObject).edit().putLong("fts_delete_db_last_report_time", l).apply();
      localObject = new Throwable("FTS Query exception deleteMessageSync");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSyncCursor: ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" maxId: ");
      localStringBuilder.append(paramFTSMessageDelete.getId());
      CaughtExceptionReport.a((Throwable)localObject, localStringBuilder.toString());
      QLog.e("Q.fts.FTSMsgOperator", 1, new Object[] { "deleteMessageSync mSyncCursor:", Integer.valueOf(this.f), " maxId:", Long.valueOf(paramFTSMessageDelete.getId()) });
    }
  }
  
  private boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    if ((this.b != null) && (this.b.a())) {
      localArrayList = new ArrayList(50);
    }
    for (;;)
    {
      synchronized (this.p)
      {
        if (this.p.isEmpty()) {
          break label711;
        }
        Object localObject3 = this.p.iterator();
        i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          FTSEntity localFTSEntity = (FTSEntity)((Iterator)localObject3).next();
          localFTSEntity.preWrite();
          try
          {
            localArrayList.add(localFTSEntity);
            i += localFTSEntity.mSegmentCount;
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase failure: ", localThrowable);
            }
            return false;
          }
        }
        this.p.clear();
        if (localThrowable.isEmpty()) {
          break label709;
        }
        int j = this.b.a(localThrowable, paramInt1, paramInt2);
        if (j != -1)
        {
          if (paramInt1 == 2) {
            this.g = j;
          } else {
            this.f = j;
          }
        }
        else
        {
          if (paramInt1 == 2) {
            this.g += paramInt2;
          } else {
            this.f += paramInt2;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMsgOperator", 2, String.format("write fts failed mode=%d, cursorStep=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
          }
        }
        paramLong = System.currentTimeMillis() - paramLong;
        this.k += localThrowable.size();
        this.l += paramLong;
        if ((!QLog.isColorLevel()) && (paramLong <= 60000L)) {
          break label709;
        }
        paramInt2 = this.s;
        long l = paramInt2;
        if (paramInt2 == 0) {
          this.s = this.b.d("IndexContent");
        }
        localObject3 = new StringBuilder(50);
        ((StringBuilder)localObject3).append(getClass().getSimpleName());
        if (paramInt1 == 2) {
          ??? = " Delete";
        } else {
          ??? = " Insert";
        }
        ((StringBuilder)localObject3).append((String)???);
        ((StringBuilder)localObject3).append(" count:");
        ((StringBuilder)localObject3).append(localThrowable.size());
        ((StringBuilder)localObject3).append(" cost:");
        ((StringBuilder)localObject3).append(paramLong);
        ((StringBuilder)localObject3).append(" indexCnt:");
        ((StringBuilder)localObject3).append(this.s);
        ((StringBuilder)localObject3).append(" preIndexCnt:");
        ((StringBuilder)localObject3).append(l);
        ((StringBuilder)localObject3).append(" segmentTotal:");
        ((StringBuilder)localObject3).append(i);
        if (paramInt1 == 1)
        {
          ((StringBuilder)localObject3).append(" assistTroopCount:");
          ((StringBuilder)localObject3).append(this.t);
        }
        l = q();
        if ((paramLong > 30000L) && (System.currentTimeMillis() - l > 86400000L))
        {
          QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
          localObject3 = new HashMap();
          if (paramInt1 == 2) {
            ??? = " Delete";
          } else {
            ??? = " Insert";
          }
          ((HashMap)localObject3).put("param_type", ???);
          ((HashMap)localObject3).put("param_count", String.valueOf(localThrowable.size()));
          ((HashMap)localObject3).put("param_stotal", String.valueOf(i));
          if (paramInt1 == 1) {
            ??? = String.valueOf(this.t);
          } else {
            ??? = "0";
          }
          ((HashMap)localObject3).put("param_assist_cnt", ???);
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actFTSMsgCost", true, paramLong, 0L, (HashMap)localObject3, null, false);
          a(System.currentTimeMillis());
          return true;
        }
        QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase ftsDatabase not init");
      }
      label709:
      return true;
      label711:
      int i = 0;
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    Object localObject = this.a.getEntityManagerFactory().createEntityManager();
    boolean bool1 = a((EntityManager)localObject);
    int j = paramSQLiteDatabase.delete("msg_sync_log", "_id<=?", new String[] { String.valueOf(this.f) });
    List localList = ((EntityManager)localObject).query(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.f) }, null, null, "_id", String.valueOf(300));
    ((EntityManager)localObject).close();
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transToDBForInsert size: ");
      if (localList != null) {
        i = localList.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.fts.FTSMsgOperator", 2, new Object[] { ((StringBuilder)localObject).toString(), " delNum:", Integer.valueOf(j), " mSyncCursor:", Integer.valueOf(this.f) });
    }
    this.t = 0;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      while (i < localList.size())
      {
        localObject = FTSMessageCodec.a((FTSMessageSync)localList.get(i));
        if ((((FTSMessage)localObject).mType != -1) && ((((FTSMessage)localObject).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessage)localObject).mContent))) && (((FTSMessage)localObject).mOId != -1L))
        {
          ((FTSMessage)localObject).msgCounter = a(String.valueOf(((FTSMessage)localObject).uin));
          try
          {
            this.p.add(localObject);
            if (((ITroopManagerService)this.a.getRuntimeService(ITroopManagerService.class, "")).getTroopMask(String.valueOf(((FTSMessage)localObject).uin)) == 2) {
              this.t += 1;
            }
          }
          catch (Throwable paramSQLiteDatabase)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.fts.FTSMsgOperator", 2, "transToDBForInsert failure: ", paramSQLiteDatabase);
            }
            return false;
          }
        }
        i += 1;
      }
      boolean bool2 = a(l, 1, localList.size());
      if (bool1) {
        QLog.d("Q.fts.FTSMsgOperator", 1, new Object[] { "FIX: transToDBForInsert delNum:", Integer.valueOf(paramSQLiteDatabase.delete("msg_sync_log", "_id<=?", new String[] { String.valueOf(this.f) })), " mSyncCursor:", Integer.valueOf(this.f) });
      }
      return bool2;
    }
    return false;
  }
  
  private boolean a(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(FTSMessageSync.class, "msg_sync_log", false, null, null, null, null, "_id desc", "10");
    if ((paramEntityManager != null) && (paramEntityManager.size() > 0))
    {
      paramEntityManager = (FTSMessageSync)paramEntityManager.get(0);
      if (paramEntityManager.getId() < this.f)
      {
        Object localObject = this.a.getPreferences();
        long l = System.currentTimeMillis();
        if (l - ((SharedPreferences)localObject).getLong("fts_insert_cursor_last_report_time", -1L) > m)
        {
          ((SharedPreferences)localObject).edit().putLong("fts_insert_cursor_last_report_time", l).apply();
          localObject = new Throwable("FTS Query exception");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mSyncCursor: ");
          localStringBuilder.append(this.f);
          localStringBuilder.append(" maxId: ");
          localStringBuilder.append(paramEntityManager.getId());
          CaughtExceptionReport.a((Throwable)localObject, localStringBuilder.toString());
        }
        QLog.e("Q.fts.FTSMsgOperator", 1, new Object[] { "checkLogTableForInsert mSyncCursor:", Integer.valueOf(this.f), " maxId:", Long.valueOf(paramEntityManager.getId()) });
      }
    }
    return false;
  }
  
  private ArrayList<FTSEntity> b(ArrayList<FTSEntity> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = new HashSet(10);
      Object localObject2 = new HashSet(10);
      int i;
      if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
      {
        IFriendDataService localIFriendDataService = (IFriendDataService)this.a.getRuntimeService(IFriendDataService.class, "");
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
          Object localObject3 = (FTSMessage)localFTSEntity;
          if ((localObject3 != null) && (((FTSMessage)localObject3).msgExts != null))
          {
            i = ((FTSMessage)localObject3).istroop;
            localObject3 = String.valueOf(((FTSMessage)localObject3).uin);
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("zZz");
            ((StringBuilder)localObject4).append(i);
            localObject4 = ((StringBuilder)localObject4).toString();
            if (localIFriendDataService.isFriend((String)localObject3)) {
              localArrayList.add(localFTSEntity);
            } else if (!((HashSet)localObject1).contains(localObject4)) {
              if (((HashSet)localObject2).contains(localObject4))
              {
                localArrayList.add(localFTSEntity);
              }
              else if (MessageDBUtils.a(MessageRecord.getTableName((String)localObject3, i), this.a.getReadableDatabase()))
              {
                localArrayList.add(localFTSEntity);
                ((HashSet)localObject2).add(localObject4);
              }
              else
              {
                ((HashSet)localObject1).add(localObject4);
              }
            }
          }
        }
      }
      localObject2 = new StringBuilder();
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ((StringBuilder)localObject2).append((String)((Iterator)localObject1).next());
        ((StringBuilder)localObject2).append(" ");
      }
      if (QLog.isColorLevel())
      {
        if (paramArrayList == null) {
          i = 0;
        } else {
          i = paramArrayList.size();
        }
        QLog.d("Q.fts.FTSMsgOperator", 2, new Object[] { "filterEnityByCheckRelation before:", Integer.valueOf(i), " filtered:", Integer.valueOf(localArrayList.size()), "\nfilterUin:", ((StringBuilder)localObject2).toString() });
        return localArrayList;
      }
    }
    catch (Throwable paramArrayList)
    {
      QLog.d("Q.fts.FTSMsgOperator", 1, paramArrayList, new Object[0]);
    }
    return localArrayList;
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.a.getEntityManagerFactory().createEntityManager();
    boolean bool1 = b((EntityManager)localObject1);
    int j = paramSQLiteDatabase.delete("msg_del_log", "_id<=?", new String[] { String.valueOf(this.g) });
    List localList = ((EntityManager)localObject1).query(FTSMessageDelete.class, "msg_del_log", false, "_id>?", new String[] { String.valueOf(this.g) }, null, null, "_id", String.valueOf(50));
    ((EntityManager)localObject1).close();
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("transToDBForDelete size: ");
      if (localList != null) {
        i = localList.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.fts.FTSMsgOperator", 2, new Object[] { ((StringBuilder)localObject1).toString(), " delNum:", Integer.valueOf(j), " mDelCursor:", Integer.valueOf(this.g) });
    }
    if ((localList != null) && (!localList.isEmpty()))
    {
      localObject1 = new ArrayList(localList.size());
      i = 0;
      Object localObject2;
      Object localObject3;
      while (i < localList.size())
      {
        localObject2 = (FTSMessageDelete)localList.get(i);
        if ((((FTSMessageDelete)localObject2).mType != -1) && ((((FTSMessageDelete)localObject2).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessageDelete)localObject2).mContent))) && (((FTSMessageDelete)localObject2).mOId != -1L))
        {
          if (((FTSMessageDelete)localObject2).mode == 2)
          {
            if ((!this.p.isEmpty()) || (!((ArrayList)localObject1).isEmpty())) {
              break;
            }
            localObject3 = FTSMessageCodec.b((FTSMessageSync)localObject2);
            ((FTSMessageForDel)localObject3).mode = ((FTSMessageDelete)localObject2).mode;
            ((FTSMessageForDel)localObject3).msgCounter = ((FTSMessageDelete)localObject2).delCounter;
            this.p.add(localObject3);
            break;
          }
          if (((FTSMessageDelete)localObject2).mode == 4)
          {
            localObject3 = FTSMessageCodec.b((FTSMessageSync)localObject2);
            ((FTSMessageForDel)localObject3).mode = ((FTSMessageDelete)localObject2).mode;
            ((FTSMessageForDel)localObject3).deleteOpt();
            this.p.add(localObject3);
          }
          else if (((FTSMessageDelete)localObject2).mOId == -9223372036854775808L)
          {
            localObject2 = FTSMessageCodec.a((FTSMessageSync)localObject2);
            this.p.add(localObject2);
          }
          else
          {
            ((ArrayList)localObject1).add(localObject2);
          }
        }
        i += 1;
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = new HashMap(10);
        i = 0;
        while (i < ((ArrayList)localObject1).size())
        {
          localObject3 = FTSMessageCodec.a((FTSMessageSync)((ArrayList)localObject1).get(i));
          String str = FTSMessage.getExt1(((FTSMessage)localObject3).uin, ((FTSMessage)localObject3).istroop);
          if (((HashMap)localObject2).containsKey(str))
          {
            ((FTSMessageForDel)((HashMap)localObject2).get(str)).appendOId((FTSMessageDelete)((ArrayList)localObject1).get(i));
          }
          else
          {
            FTSMessageForDel localFTSMessageForDel = new FTSMessageForDel();
            localFTSMessageForDel.mOpt = ((FTSMessage)localObject3).mOpt;
            localFTSMessageForDel.mType = ((FTSMessage)localObject3).mType;
            localFTSMessageForDel.msgtype = ((FTSMessage)localObject3).msgtype;
            localFTSMessageForDel.mExt1Key = str;
            localFTSMessageForDel.mode = 1;
            localFTSMessageForDel.appendOId((FTSMessageDelete)((ArrayList)localObject1).get(i));
            ((HashMap)localObject2).put(str, localFTSMessageForDel);
          }
          i += 1;
        }
        localObject1 = ((HashMap)localObject2).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          this.p.add(((Map.Entry)localObject2).getValue());
        }
      }
      boolean bool2 = a(l, 2, localList.size());
      if (bool1) {
        QLog.d("Q.fts.FTSMsgOperator", 1, new Object[] { "FIX: transToDBForDelete delNum:", Integer.valueOf(paramSQLiteDatabase.delete("msg_del_log", "_id<=?", new String[] { String.valueOf(this.g) })), " mSyncCursor:", Integer.valueOf(this.f) });
      }
      return bool2;
    }
    return false;
  }
  
  private boolean b(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(FTSMessageDelete.class, "msg_del_log", false, null, null, null, null, "_id desc", "10");
    if ((paramEntityManager != null) && (paramEntityManager.size() > 0))
    {
      paramEntityManager = (FTSMessageDelete)paramEntityManager.get(0);
      if (paramEntityManager.getId() < this.g)
      {
        Object localObject = this.a.getPreferences();
        long l = System.currentTimeMillis();
        if (l - ((SharedPreferences)localObject).getLong("fts_delete_cursor_last_report_time", -1L) > m)
        {
          ((SharedPreferences)localObject).edit().putLong("fts_delete_cursor_last_report_time", l).apply();
          localObject = new Throwable("FTS Query exception");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("mDelCursor: ");
          localStringBuilder.append(this.g);
          localStringBuilder.append(" maxId: ");
          localStringBuilder.append(paramEntityManager.getId());
          CaughtExceptionReport.a((Throwable)localObject, localStringBuilder.toString());
        }
        QLog.e("Q.fts.FTSMsgOperator", 1, new Object[] { "checkLogTableForDel mDelCursor:", Integer.valueOf(this.g), " maxId:", Long.valueOf(paramEntityManager.getId()) });
      }
    }
    return false;
  }
  
  private long q()
  {
    return BaseApplication.getContext().getSharedPreferences("fts_sp_file", 0).getLong("key_last_msg_time", 0L);
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.s = this.b.d("IndexContent");
    }
    return this.s;
  }
  
  public long a(String paramString)
  {
    long l2;
    long l1;
    StringBuilder localStringBuilder;
    if (this.q.containsKey(paramString))
    {
      l2 = ((FTSMsgCounter)this.q.get(paramString)).mCounter;
      l1 = l2;
      if (System.currentTimeMillis() - this.n > 30000L)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMsgCounterForInsert uin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" ret:");
          localStringBuilder.append(l2);
          QLog.d("Q.fts.FTSMsgOperator", 2, localStringBuilder.toString());
          this.n = System.currentTimeMillis();
          return l2;
        }
      }
    }
    else
    {
      l2 = 0L;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMsgCounterForInsert uin:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" not exist? why?");
        QLog.d("Q.fts.FTSMsgOperator", 2, localStringBuilder.toString());
        l1 = l2;
      }
    }
    return l1;
  }
  
  public ArrayList<FTSEntity> a(FTSQueryArgs paramFTSQueryArgs)
  {
    if ((this.b != null) && (this.b.a())) {
      return a(this.b.a(paramFTSQueryArgs));
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList<FTSEntity> a(FTSQueryArgs paramFTSQueryArgs, Pair<CharSequence, CharSequence> paramPair)
  {
    if ((this.b != null) && (this.b.a()))
    {
      paramFTSQueryArgs = this.b.a(paramFTSQueryArgs);
      if ((paramPair != null) && (paramFTSQueryArgs != null) && (!paramFTSQueryArgs.isEmpty()))
      {
        Iterator localIterator = paramFTSQueryArgs.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (FTSEntity)localIterator.next();
          if ((localObject instanceof FTSMessage))
          {
            localObject = (FTSMessage)localObject;
            ((FTSMessage)localObject).matchTitle = ((CharSequence)paramPair.first);
            ((FTSMessage)localObject).matchSecondTitle = ((CharSequence)paramPair.second);
          }
        }
      }
      return a(paramFTSQueryArgs);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: getstatic 691	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:ENABLE	Z
    //   3: ifne +80 -> 83
    //   6: aload_0
    //   7: getfield 75	com/tencent/mobileqq/fts/operator/FTSMsgOperator:a	Lmqq/app/AppRuntime;
    //   10: invokestatic 696	com/tencent/mobileqq/fts/utils/FTSUtils:k	(Lmqq/app/AppRuntime;)Z
    //   13: ifeq +70 -> 83
    //   16: invokestatic 363	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +63 -> 82
    //   22: new 286	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   29: astore 8
    //   31: aload 8
    //   33: ldc_w 698
    //   36: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 8
    //   42: getstatic 691	com/tencent/mobileqq/fts/api/impl/FTSDBRuntimeServiceImpl:ENABLE	Z
    //   45: invokevirtual 701	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 8
    //   51: ldc_w 703
    //   54: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 8
    //   60: aload_0
    //   61: getfield 75	com/tencent/mobileqq/fts/operator/FTSMsgOperator:a	Lmqq/app/AppRuntime;
    //   64: invokestatic 696	com/tencent/mobileqq/fts/utils/FTSUtils:k	(Lmqq/app/AppRuntime;)Z
    //   67: invokevirtual 701	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 215
    //   73: iconst_2
    //   74: aload 8
    //   76: invokevirtual 307	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 429	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: return
    //   83: aload_0
    //   84: getfield 75	com/tencent/mobileqq/fts/operator/FTSMsgOperator:a	Lmqq/app/AppRuntime;
    //   87: invokevirtual 706	mqq/app/AppRuntime:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   90: astore 10
    //   92: aload_0
    //   93: getfield 75	com/tencent/mobileqq/fts/operator/FTSMsgOperator:a	Lmqq/app/AppRuntime;
    //   96: invokevirtual 453	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   99: invokevirtual 459	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   102: astore 9
    //   104: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   107: lstore_3
    //   108: aload 10
    //   110: ldc_w 464
    //   113: ldc_w 466
    //   116: iconst_1
    //   117: anewarray 161	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: getfield 296	com/tencent/mobileqq/fts/operator/FTSMsgOperator:f	I
    //   126: invokestatic 196	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   129: aastore
    //   130: invokevirtual 472	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   133: pop
    //   134: aload_0
    //   135: getfield 296	com/tencent/mobileqq/fts/operator/FTSMsgOperator:f	I
    //   138: istore_1
    //   139: aload 9
    //   141: ldc_w 474
    //   144: ldc_w 464
    //   147: iconst_0
    //   148: ldc_w 476
    //   151: iconst_1
    //   152: anewarray 161	java/lang/String
    //   155: dup
    //   156: iconst_0
    //   157: iload_1
    //   158: invokestatic 196	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   161: aastore
    //   162: aconst_null
    //   163: aconst_null
    //   164: ldc_w 478
    //   167: aconst_null
    //   168: invokevirtual 484	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   171: astore 8
    //   173: aload 10
    //   175: ldc_w 576
    //   178: ldc_w 466
    //   181: iconst_1
    //   182: anewarray 161	java/lang/String
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 277	com/tencent/mobileqq/fts/operator/FTSMsgOperator:g	I
    //   191: invokestatic 196	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: aastore
    //   195: invokevirtual 472	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   198: pop
    //   199: aload 9
    //   201: ldc_w 271
    //   204: ldc_w 576
    //   207: iconst_0
    //   208: ldc_w 476
    //   211: iconst_1
    //   212: anewarray 161	java/lang/String
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: getfield 277	com/tencent/mobileqq/fts/operator/FTSMsgOperator:g	I
    //   221: invokestatic 196	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   224: aastore
    //   225: aconst_null
    //   226: aconst_null
    //   227: ldc_w 478
    //   230: aconst_null
    //   231: invokevirtual 484	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   234: astore 10
    //   236: new 592	com/tencent/mobileqq/fts/data/msg/FTSMessageForDel
    //   239: dup
    //   240: invokespecial 617	com/tencent/mobileqq/fts/data/msg/FTSMessageForDel:<init>	()V
    //   243: astore 11
    //   245: aload 11
    //   247: iconst_4
    //   248: putfield 593	com/tencent/mobileqq/fts/data/msg/FTSMessageForDel:mode	I
    //   251: aload 11
    //   253: invokevirtual 600	com/tencent/mobileqq/fts/data/msg/FTSMessageForDel:deleteOpt	()V
    //   256: aload_0
    //   257: getfield 326	com/tencent/mobileqq/fts/operator/FTSMsgOperator:b	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   260: ifnull +320 -> 580
    //   263: aload_0
    //   264: getfield 326	com/tencent/mobileqq/fts/operator/FTSMsgOperator:b	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   267: invokevirtual 330	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()Z
    //   270: ifeq +310 -> 580
    //   273: new 332	java/util/ArrayList
    //   276: dup
    //   277: bipush 10
    //   279: invokespecial 333	java/util/ArrayList:<init>	(I)V
    //   282: astore 12
    //   284: aload 12
    //   286: aload 11
    //   288: invokevirtual 357	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   291: pop
    //   292: aload 8
    //   294: ifnull +300 -> 594
    //   297: aload 8
    //   299: invokeinterface 492 1 0
    //   304: istore_1
    //   305: goto +3 -> 308
    //   308: aload_0
    //   309: getfield 326	com/tencent/mobileqq/fts/operator/FTSMsgOperator:b	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   312: aload 12
    //   314: iconst_1
    //   315: iload_1
    //   316: invokevirtual 375	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   319: istore_2
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 296	com/tencent/mobileqq/fts/operator/FTSMsgOperator:f	I
    //   325: iload_1
    //   326: iadd
    //   327: putfield 296	com/tencent/mobileqq/fts/operator/FTSMsgOperator:f	I
    //   330: invokestatic 363	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: istore 7
    //   335: iload 7
    //   337: ifeq +39 -> 376
    //   340: ldc 215
    //   342: iconst_2
    //   343: iconst_4
    //   344: anewarray 55	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc_w 708
    //   352: aastore
    //   353: dup
    //   354: iconst_1
    //   355: iload_1
    //   356: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   359: aastore
    //   360: dup
    //   361: iconst_2
    //   362: ldc_w 710
    //   365: aastore
    //   366: dup
    //   367: iconst_3
    //   368: iload_2
    //   369: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   372: aastore
    //   373: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   376: aload 10
    //   378: ifnull +221 -> 599
    //   381: aload 10
    //   383: invokeinterface 492 1 0
    //   388: istore_1
    //   389: goto +3 -> 392
    //   392: aload_0
    //   393: getfield 326	com/tencent/mobileqq/fts/operator/FTSMsgOperator:b	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   396: aload 12
    //   398: iconst_2
    //   399: iload_1
    //   400: invokevirtual 375	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   403: istore_2
    //   404: aload_0
    //   405: aload_0
    //   406: getfield 277	com/tencent/mobileqq/fts/operator/FTSMsgOperator:g	I
    //   409: iload_1
    //   410: iadd
    //   411: putfield 277	com/tencent/mobileqq/fts/operator/FTSMsgOperator:g	I
    //   414: invokestatic 363	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   417: ifeq +39 -> 456
    //   420: ldc 215
    //   422: iconst_2
    //   423: iconst_4
    //   424: anewarray 55	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: ldc_w 712
    //   432: aastore
    //   433: dup
    //   434: iconst_1
    //   435: iload_1
    //   436: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: aastore
    //   440: dup
    //   441: iconst_2
    //   442: ldc_w 710
    //   445: aastore
    //   446: dup
    //   447: iconst_3
    //   448: iload_2
    //   449: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   452: aastore
    //   453: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   456: aload_0
    //   457: getfield 41	com/tencent/mobileqq/fts/operator/FTSMsgOperator:s	I
    //   460: i2l
    //   461: lstore 5
    //   463: aload_0
    //   464: aload_0
    //   465: getfield 326	com/tencent/mobileqq/fts/operator/FTSMsgOperator:b	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   468: ldc_w 398
    //   471: invokevirtual 401	com/tencent/mobileqq/persistence/fts/FTSDatatbase:d	(Ljava/lang/String;)I
    //   474: putfield 41	com/tencent/mobileqq/fts/operator/FTSMsgOperator:s	I
    //   477: invokestatic 363	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq +100 -> 580
    //   483: ldc 215
    //   485: iconst_2
    //   486: bipush 6
    //   488: anewarray 55	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: ldc_w 714
    //   496: aastore
    //   497: dup
    //   498: iconst_1
    //   499: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   502: lload_3
    //   503: lsub
    //   504: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   507: aastore
    //   508: dup
    //   509: iconst_2
    //   510: ldc_w 415
    //   513: aastore
    //   514: dup
    //   515: iconst_3
    //   516: aload_0
    //   517: getfield 41	com/tencent/mobileqq/fts/operator/FTSMsgOperator:s	I
    //   520: invokestatic 317	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   523: aastore
    //   524: dup
    //   525: iconst_4
    //   526: ldc_w 417
    //   529: aastore
    //   530: dup
    //   531: iconst_5
    //   532: lload 5
    //   534: invokestatic 222	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   537: aastore
    //   538: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   541: goto +39 -> 580
    //   544: astore 8
    //   546: goto +10 -> 556
    //   549: astore 8
    //   551: goto +35 -> 586
    //   554: astore 8
    //   556: ldc 215
    //   558: iconst_1
    //   559: iconst_2
    //   560: anewarray 55	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: ldc_w 716
    //   568: aastore
    //   569: dup
    //   570: iconst_1
    //   571: aload 8
    //   573: invokevirtual 717	java/lang/Exception:toString	()Ljava/lang/String;
    //   576: aastore
    //   577: invokestatic 322	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   580: aload 9
    //   582: invokevirtual 487	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   585: return
    //   586: aload 9
    //   588: invokevirtual 487	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   591: aload 8
    //   593: athrow
    //   594: iconst_0
    //   595: istore_1
    //   596: goto -288 -> 308
    //   599: iconst_0
    //   600: istore_1
    //   601: goto -209 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	FTSMsgOperator
    //   138	463	1	i	int
    //   319	130	2	j	int
    //   107	396	3	l1	long
    //   461	72	5	l2	long
    //   333	3	7	bool	boolean
    //   29	269	8	localObject1	Object
    //   544	1	8	localException1	java.lang.Exception
    //   549	1	8	localObject2	Object
    //   554	38	8	localException2	java.lang.Exception
    //   102	485	9	localEntityManager	EntityManager
    //   90	292	10	localObject3	Object
    //   243	44	11	localFTSMessageForDel	FTSMessageForDel
    //   282	115	12	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   139	292	544	java/lang/Exception
    //   297	305	544	java/lang/Exception
    //   308	335	544	java/lang/Exception
    //   340	376	544	java/lang/Exception
    //   381	389	544	java/lang/Exception
    //   392	456	544	java/lang/Exception
    //   456	541	544	java/lang/Exception
    //   108	139	549	finally
    //   139	292	549	finally
    //   297	305	549	finally
    //   308	335	549	finally
    //   340	376	549	finally
    //   381	389	549	finally
    //   392	456	549	finally
    //   456	541	549	finally
    //   556	580	549	finally
    //   108	139	554	java/lang/Exception
  }
  
  public void a(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager, List<MessageRecord> paramList)
  {
    if ((paramMsgQueueItem.whereClause != null) && (!TextUtils.isEmpty(paramMsgQueueItem.whereClause)))
    {
      if (paramMsgQueueItem.value == null) {
        return;
      }
      if ((paramList != null) && (FTSUtils.a(paramMsgQueueItem.value))) {
        paramMsgQueueItem = paramList.iterator();
      }
    }
    while (paramMsgQueueItem.hasNext())
    {
      paramList = (MessageRecord)paramMsgQueueItem.next();
      if ((paramList.isSupportFTS()) && (paramList.isValid) && (paramList.msgtype != -2006) && (!paramList.isMultiMsg))
      {
        paramList = FTSMessageCodec.a(paramList);
        paramList.deleteOpt();
        paramEntityManager.persistOrReplace(FTSMessageCodec.a(paramList));
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateMessageSync 1 msg:");
          ((StringBuilder)localObject1).append(paramList.toString());
          QLog.d("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject1).toString());
        }
        a(paramList, 2);
        continue;
        if ((paramList != null) && (FTSUtils.b(paramMsgQueueItem.value)))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            Object localObject2 = (MessageRecord)paramList.next();
            if ((((MessageRecord)localObject2).isSupportFTS()) && (((MessageRecord)localObject2).isValid) && (((MessageRecord)localObject2).msgtype != -2006) && (!((MessageRecord)localObject2).isMultiMsg))
            {
              localObject1 = FTSMessageCodec.a((MessageRecord)localObject2);
              ((FTSMessage)localObject1).deleteOpt();
              paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject1));
              localObject2 = FTSUtils.a(paramMsgQueueItem.value, (MessageRecord)localObject2);
              ((FTSMessage)localObject2).insertOpt();
              paramEntityManager.persistOrReplace(FTSMessageCodec.a((FTSMessage)localObject2));
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("updateMessageSync 2 msg:");
                ((StringBuilder)localObject2).append(((FTSMessage)localObject1).toString());
                QLog.d("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject2).toString());
              }
              a((FTSMessage)localObject1, 3);
              continue;
              if (QLog.isColorLevel()) {
                QLog.w("Q.fts.FTSMsgOperator", 2, "UPDATE MESSAGE, whereClause null");
              }
            }
          }
        }
      }
    }
  }
  
  public void a(Entity paramEntity)
  {
    if ((paramEntity instanceof MessageRecord))
    {
      paramEntity = (MessageRecord)paramEntity;
      if (paramEntity.isSupportFTS()) {
        paramEntity.saveExtInfoToExtStr("ExtraFTSMsgCounter", String.valueOf(b(paramEntity.frienduin)));
      }
    }
  }
  
  public void a(Entity paramEntity, EntityManager paramEntityManager)
  {
    if ((paramEntity instanceof MessageRecord))
    {
      paramEntity = (MessageRecord)paramEntity;
      if ((paramEntity.isSupportFTS()) && (paramEntity.isValid) && (paramEntity.msgtype != -2006) && (!paramEntity.isMultiMsg))
      {
        paramEntity = FTSMessageCodec.a(paramEntity);
        paramEntity.insertOpt();
        FTSMessageSync localFTSMessageSync = FTSMessageCodec.a(paramEntity);
        paramEntityManager.persistOrReplace(localFTSMessageSync);
        if (QLog.isColorLevel())
        {
          paramEntityManager = new StringBuilder();
          paramEntityManager.append("insertMessageSync msg:");
          paramEntityManager.append(paramEntity.toString());
          QLog.d("Q.fts.FTSMsgOperator", 2, new Object[] { paramEntityManager.toString(), "ftsMessage: ", Long.valueOf(localFTSMessageSync.getId()) });
        }
        if (localFTSMessageSync.getId() < this.f)
        {
          paramEntityManager = this.a.getPreferences();
          long l = System.currentTimeMillis();
          if (l - paramEntityManager.getLong("fts_insert_db_last_report_time", -1L) > m)
          {
            paramEntityManager.edit().putLong("fts_insert_db_last_report_time", l).apply();
            paramEntityManager = new Throwable("FTS Query exception insertMessageSync");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mSyncCursor: ");
            localStringBuilder.append(this.f);
            localStringBuilder.append(" curId: ");
            localStringBuilder.append(localFTSMessageSync.getId());
            CaughtExceptionReport.a(paramEntityManager, localStringBuilder.toString());
            QLog.e("Q.fts.FTSMsgOperator", 1, new Object[] { "insertMessageSync mSyncCursor:", Integer.valueOf(this.f), " maxId:", Long.valueOf(localFTSMessageSync.getId()) });
          }
        }
        a(paramEntity, 1);
      }
    }
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    this.e = new FTSMsgUpgrader(this.a, this);
    return this.b.a("IndexContent", true);
  }
  
  public long b(String paramString)
  {
    if (this.q.containsKey(paramString))
    {
      localFTSMsgCounter = (FTSMsgCounter)this.q.get(paramString);
      localFTSMsgCounter.mMsgCnt += 1L;
      if (localFTSMsgCounter.mMsgCnt > 1000L)
      {
        localFTSMsgCounter.mCounter += 1L;
        localFTSMsgCounter.mMsgCnt = 0L;
        this.r.update(localFTSMsgCounter);
      }
      else if (localFTSMsgCounter.mMsgCnt % 300L == 0L)
      {
        this.r.update(localFTSMsgCounter);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getMsgCounter update curCounter msgCnt:");
          ((StringBuilder)localObject).append(localFTSMsgCounter.mMsgCnt);
          QLog.d("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject).toString());
        }
      }
      long l = localFTSMsgCounter.mCounter;
      if ((System.currentTimeMillis() - this.o > 30000L) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getMsgCounter uin:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" counter:");
        ((StringBuilder)localObject).append(localFTSMsgCounter.mCounter);
        ((StringBuilder)localObject).append(" msgCnt:");
        ((StringBuilder)localObject).append(localFTSMsgCounter.mMsgCnt);
        QLog.d("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject).toString());
        this.o = System.currentTimeMillis();
      }
      return l;
    }
    Object localObject = this.a.getEntityManagerFactory().createEntityManager();
    FTSMsgCounter localFTSMsgCounter = new FTSMsgCounter();
    localFTSMsgCounter.mMsgUin = paramString;
    localFTSMsgCounter.mCounter = 0L;
    localFTSMsgCounter.mMsgCnt = 1L;
    this.q.put(paramString, localFTSMsgCounter);
    ((EntityManager)localObject).persistOrReplace(localFTSMsgCounter);
    ((EntityManager)localObject).close();
    if ((System.currentTimeMillis() - this.o > 30000L) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMsgCounter uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" counter:");
      ((StringBuilder)localObject).append(localFTSMsgCounter.mCounter);
      ((StringBuilder)localObject).append(" msgCnt:");
      ((StringBuilder)localObject).append(localFTSMsgCounter.mMsgCnt);
      QLog.d("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject).toString());
      this.o = System.currentTimeMillis();
    }
    return 0L;
  }
  
  public void b()
  {
    if (FTSUtils.b(this.a) == 1) {
      if (e())
      {
        if (f()) {
          h();
        }
      }
      else {
        h();
      }
    }
  }
  
  public void b(MsgQueueItem paramMsgQueueItem, EntityManager paramEntityManager, List<MessageRecord> paramList)
  {
    if ((paramMsgQueueItem.whereClause != null) && (!TextUtils.isEmpty(paramMsgQueueItem.whereClause)))
    {
      if (paramList != null) {
        paramMsgQueueItem = paramList.iterator();
      }
    }
    else {
      while (paramMsgQueueItem.hasNext())
      {
        paramList = (MessageRecord)paramMsgQueueItem.next();
        if ((paramList.isSupportFTS()) && (paramList.isValid) && (paramList.msgtype != -2006))
        {
          paramList = FTSMessageCodec.a(paramList);
          paramList.deleteOpt();
          paramList = FTSMessageCodec.b(paramList);
          paramEntityManager.persistOrReplace(paramList);
          a(paramList);
          continue;
          paramList = new FTSMessage();
          paramList.mType = 1;
          paramList.mContent = "DELETE TABLE";
          paramList.mOId = -9223372036854775808L;
        }
      }
    }
    try
    {
      paramList.uin = CharacterUtil.b(paramMsgQueueItem.frindUin);
      paramList.istroop = paramMsgQueueItem.type;
      paramList.deleteOpt();
      paramMsgQueueItem = FTSMessageCodec.b(paramList);
      paramEntityManager.persistOrReplace(paramMsgQueueItem);
      a(paramMsgQueueItem);
      return;
    }
    catch (NumberFormatException paramMsgQueueItem) {}
  }
  
  public void d()
  {
    super.d();
    EntityManager localEntityManager = this.r;
    if ((localEntityManager != null) && (localEntityManager.isOpen())) {
      this.r.close();
    }
  }
  
  public boolean g()
  {
    if (!this.h) {
      try
      {
        boolean bool1 = this.b.b("SyncCursor");
        boolean bool2 = this.b.b("DeleteCursor");
        if (!bool1)
        {
          if (!this.b.a("SyncCursor")) {
            return false;
          }
          i = 0;
        }
        else
        {
          i = -1;
        }
        int j;
        if (!bool2)
        {
          if (!this.b.a("DeleteCursor")) {
            return false;
          }
          j = 0;
        }
        else
        {
          j = -1;
        }
        int k = i;
        if (i != 1) {
          k = this.b.c("SyncCursor");
        }
        this.f = k;
        if (k == -1) {
          return false;
        }
        int i = j;
        if (j != 1) {
          i = this.b.c("DeleteCursor");
        }
        this.g = i;
        if (i == -1) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("startSyncStep: syncCursor = ");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(" delCursor = ");
          ((StringBuilder)localObject1).append(i);
          QLog.d("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject1).toString());
        }
        this.h = true;
        Object localObject1 = this.a.getEntityManagerFactory().createEntityManager();
        Object localObject2 = ((EntityManager)localObject1).query(FTSMsgCounter.class, false, null, null, null, null, null, null);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            FTSMsgCounter localFTSMsgCounter = (FTSMsgCounter)((Iterator)localObject2).next();
            this.q.put(localFTSMsgCounter.mMsgUin, localFTSMsgCounter);
          }
        }
        ((EntityManager)localObject1).close();
        try
        {
          if (this.s != 0) {
            return true;
          }
          this.s = this.b.d("IndexContent");
          return true;
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("Q.fts.FTSMsgOperator", 1, localThrowable1, new Object[0]);
          return true;
        }
        return true;
      }
      catch (Throwable localThrowable2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgOperator", 2, "mWokerThread: failure ", localThrowable2);
        }
        FTSDBRuntimeServiceImpl.ENABLE = false;
        return false;
      }
    }
  }
  
  public void h()
  {
    super.h();
    if (1 == FTSUtils.b(this.a)) {
      this.d.obtainMessage(1, this).sendToTarget();
    }
  }
  
  protected boolean j()
  {
    return true;
  }
  
  public void k()
  {
    if ((!FTSDBRuntimeServiceImpl.ENABLE) && (FTSUtils.k(this.a)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("transToDatabase ENABLE = ");
        ((StringBuilder)localObject).append(FTSDBRuntimeServiceImpl.ENABLE);
        ((StringBuilder)localObject).append(", FTSUpgradeFlag = ");
        ((StringBuilder)localObject).append(FTSUtils.k(this.a));
        QLog.e("Q.fts.FTSMsgOperator", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    Object localObject = this.a.getWritableDatabase();
    if (!a((SQLiteDatabase)localObject)) {
      b((SQLiteDatabase)localObject);
    }
  }
  
  public boolean m()
  {
    return false;
  }
  
  public String n()
  {
    return "IndexContent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSMsgOperator
 * JD-Core Version:    0.7.0.1
 */