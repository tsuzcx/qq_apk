package cooperation.qzone.contentbox;

import NS_MOBILE_OPERATION.operation_like_rsp;
import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import com.tencent.qzonehub.api.impl.QzoneReqImpl;
import com.tencent.qzonehub.model.QZoneMsgEntityNew;
import common.config.service.QzoneConfig;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.MsgEntityConverter;
import cooperation.qzone.contentbox.model.QZoneMsgReq;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class QZoneMsgManager
  implements Manager, BusinessObserver
{
  public static final int DEFAULT_LOAD_NUM = 10;
  public static final String ENTITY_PUSHTIME_KEY = "entity_pushtime";
  public static final String LIKE_KEY = "like_key";
  public static final String TAG = "QZoneMsgManager";
  public static final int TYPE_LIKEFEED = 100;
  public static final int TYPE_LOADMORE = 2;
  public static final int TYPE_PRELOAD = 0;
  public static final int TYPE_REFRESH = 1;
  String loadNumConfig = null;
  private WeakReference<AppRuntime> mAppRef;
  private ArrayList<QZoneMsgEntityNew> msgEntity;
  private String traceInfo = null;
  
  public QZoneMsgManager(AppRuntime paramAppRuntime)
  {
    this.mAppRef = new WeakReference(paramAppRuntime);
  }
  
  static MQMsg getMqMsg(IMQMsg paramIMQMsg)
  {
    if (paramIMQMsg == null) {
      return null;
    }
    if ((paramIMQMsg instanceof MQMsg)) {
      return (MQMsg)paramIMQMsg;
    }
    return null;
  }
  
  public void dropMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "dropMsg()");
    }
    this.msgEntity = null;
    this.traceInfo = null;
    AppRuntime localAppRuntime = getApp();
    if (localAppRuntime == null)
    {
      QZLog.e("QZoneMsgManager", "dropMsg error app == null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.3(this, localAppRuntime));
  }
  
  public AppRuntime getApp()
  {
    WeakReference localWeakReference = this.mAppRef;
    if (localWeakReference != null) {
      return (AppRuntime)localWeakReference.get();
    }
    return null;
  }
  
  public int getLoadNum(int paramInt)
  {
    if (this.loadNumConfig == null) {
      this.loadNumConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", "contentbox_load_num", "10_10_10");
    }
    if (!TextUtils.isEmpty(this.loadNumConfig))
    {
      String[] arrayOfString = this.loadNumConfig.split("_");
      if (arrayOfString.length != 3) {
        return 10;
      }
      if (!TextUtils.isEmpty(arrayOfString[paramInt])) {
        try
        {
          paramInt = Integer.parseInt(arrayOfString[paramInt]);
          return paramInt;
        }
        catch (Exception localException)
        {
          QZLog.e("QZoneMsgManager", "getLoadNum error", localException);
        }
      }
    }
    return 10;
  }
  
  public void likeFeed(MQLikeCell paramMQLikeCell, long paramLong)
  {
    if (paramMQLikeCell == null) {
      return;
    }
    likeFeed(paramMQLikeCell.likeKey, paramMQLikeCell.appid, paramMQLikeCell.liked, paramLong);
  }
  
  public void likeFeed(String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void loadMoreMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "loadMoreMsg()");
    }
    AppRuntime localAppRuntime = getApp();
    if (localAppRuntime == null)
    {
      QZLog.e("QZoneMsgManager", "loadMoreMsg app == null");
      return;
    }
    QZoneMsgReq localQZoneMsgReq = new QZoneMsgReq(localAppRuntime.getLongAccountUin(), this.traceInfo, getLoadNum(2), 3);
    localQZoneMsgReq.setType(2);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localAppRuntime.getApplication(), QZoneCommonServlet.class);
    localQzoneCommonIntent.setRequest(localQZoneMsgReq);
    localQzoneCommonIntent.setObserver(this);
    localAppRuntime.startServlet(localQzoneCommonIntent);
  }
  
  /* Error */
  public ArrayList<QZoneMsgEntityNew> loadMsgFromDB()
  {
    // Byte code:
    //   0: invokestatic 65	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   3: ifeq +10 -> 13
    //   6: ldc 21
    //   8: ldc 225
    //   10: invokestatic 71	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 73	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnull +5 -> 24
    //   22: aload_2
    //   23: areturn
    //   24: aload_0
    //   25: invokevirtual 77	cooperation/qzone/contentbox/QZoneMsgManager:getApp	()Lmqq/app/AppRuntime;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +12 -> 42
    //   33: ldc 21
    //   35: ldc 227
    //   37: invokestatic 82	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aconst_null
    //   41: areturn
    //   42: aload_2
    //   43: invokevirtual 231	mqq/app/AppRuntime:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   46: invokevirtual 237	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   49: astore_2
    //   50: aload_2
    //   51: astore_3
    //   52: aload_2
    //   53: ldc 239
    //   55: iconst_0
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: ldc 241
    //   62: ldc 243
    //   64: invokevirtual 249	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   67: astore 4
    //   69: aload_2
    //   70: astore_3
    //   71: aload_0
    //   72: new 251	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 252	java/util/ArrayList:<init>	()V
    //   79: putfield 73	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   82: aload 4
    //   84: ifnull +83 -> 167
    //   87: aload_2
    //   88: astore_3
    //   89: aload 4
    //   91: invokeinterface 258 1 0
    //   96: ifle +71 -> 167
    //   99: iconst_1
    //   100: istore_1
    //   101: aload_2
    //   102: astore_3
    //   103: iload_1
    //   104: aload 4
    //   106: invokeinterface 258 1 0
    //   111: if_icmpge +56 -> 167
    //   114: aload_2
    //   115: astore_3
    //   116: aload 4
    //   118: iload_1
    //   119: invokeinterface 261 2 0
    //   124: checkcast 239	com/tencent/qzonehub/model/QZoneMsgEntityNew
    //   127: astore 5
    //   129: aload 5
    //   131: ifnull +29 -> 160
    //   134: aload_2
    //   135: astore_3
    //   136: aload 5
    //   138: invokestatic 267	cooperation/qzone/contentbox/model/MsgEntityConverter:readArkNewsFromBuffer	(Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;)V
    //   141: aload_2
    //   142: astore_3
    //   143: aload 5
    //   145: invokestatic 270	cooperation/qzone/contentbox/model/MsgEntityConverter:readBottomItemsFromBuffer	(Lcom/tencent/qzonehub/model/QZoneMsgEntityNew;)V
    //   148: aload_2
    //   149: astore_3
    //   150: aload_0
    //   151: getfield 73	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   154: aload 5
    //   156: invokevirtual 274	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   159: pop
    //   160: iload_1
    //   161: iconst_1
    //   162: iadd
    //   163: istore_1
    //   164: goto -63 -> 101
    //   167: aload_2
    //   168: ifnull +47 -> 215
    //   171: goto +40 -> 211
    //   174: astore_2
    //   175: goto +45 -> 220
    //   178: astore 4
    //   180: goto +13 -> 193
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_3
    //   186: goto +34 -> 220
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: astore_3
    //   195: ldc 21
    //   197: iconst_1
    //   198: aload 4
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 277	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   207: aload_2
    //   208: ifnull +7 -> 215
    //   211: aload_2
    //   212: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   215: aload_0
    //   216: getfield 73	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   219: areturn
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 280	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   228: goto +5 -> 233
    //   231: aload_2
    //   232: athrow
    //   233: goto -2 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	QZoneMsgManager
    //   100	64	1	i	int
    //   17	151	2	localObject1	Object
    //   174	1	2	localObject2	Object
    //   183	1	2	localObject3	Object
    //   192	40	2	localObject4	Object
    //   51	174	3	localObject5	Object
    //   67	50	4	localList	java.util.List
    //   178	1	4	localThrowable1	java.lang.Throwable
    //   189	10	4	localThrowable2	java.lang.Throwable
    //   127	28	5	localQZoneMsgEntityNew	QZoneMsgEntityNew
    // Exception table:
    //   from	to	target	type
    //   52	69	174	finally
    //   71	82	174	finally
    //   89	99	174	finally
    //   103	114	174	finally
    //   116	129	174	finally
    //   136	141	174	finally
    //   143	148	174	finally
    //   150	160	174	finally
    //   195	207	174	finally
    //   52	69	178	java/lang/Throwable
    //   71	82	178	java/lang/Throwable
    //   89	99	178	java/lang/Throwable
    //   103	114	178	java/lang/Throwable
    //   116	129	178	java/lang/Throwable
    //   136	141	178	java/lang/Throwable
    //   143	148	178	java/lang/Throwable
    //   150	160	178	java/lang/Throwable
    //   42	50	183	finally
    //   42	50	189	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    this.msgEntity = null;
    this.traceInfo = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    AppRuntime localAppRuntime = getApp();
    if (localAppRuntime == null)
    {
      QZLog.e("QZoneMsgManager", "onReceive app == null");
      return;
    }
    Object localObject1 = (JceStruct)paramBundle.getSerializable("key_response");
    int i = paramBundle.getInt("key_response_code");
    Object localObject2 = paramBundle.getString("key_response_msg");
    if (QLog.isColorLevel()) {
      QLog.i("QZoneMsgManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), localObject2, paramBundle.toString() }));
    }
    if ((localObject1 instanceof QzoneMessageBoxRsp))
    {
      localObject1 = MsgEntityConverter.readFrom((QzoneMessageBoxRsp)localObject1);
      if (localObject1 != null)
      {
        paramBundle.putSerializable("key_response", (Serializable)localObject1);
        localAppRuntime.notifyObservers(QZoneMsgObserver.class, paramInt, true, paramBundle);
        saveMsgToDB((QZoneMsgEntityNew)localObject1, paramInt);
        return;
      }
      localAppRuntime.notifyObservers(QZoneMsgObserver.class, paramInt, false, paramBundle);
      QZLog.e("QZoneMsgManager", "onReceive entity == null");
      return;
    }
    if ((localObject1 instanceof operation_like_rsp))
    {
      if (((operation_like_rsp)localObject1).ret == 0)
      {
        paramBoolean = paramBundle.getBoolean("like_key");
        long l = paramBundle.getLong("entity_pushtime");
        if (l > 0L)
        {
          localObject1 = this.msgEntity;
          if (localObject1 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (QZoneMsgEntityNew)((Iterator)localObject1).next();
              if ((((QZoneMsgEntityNew)localObject2).pushTime == l) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec.size() > 0))
              {
                Object localObject3 = getMqMsg((IMQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0));
                if (localObject3 != null)
                {
                  ((MQMsg)localObject3).msgInteractData.likeCell.liked = paramBoolean;
                  if (paramBoolean)
                  {
                    localObject3 = ((MQMsg)localObject3).msgInteractData.likeCell;
                    ((MQLikeCell)localObject3).totalLike += 1;
                  }
                  else
                  {
                    localObject3 = ((MQMsg)localObject3).msgInteractData.likeCell;
                    ((MQLikeCell)localObject3).totalLike -= 1;
                  }
                  saveMsgToDB((QZoneMsgEntityNew)localObject2, paramInt);
                }
              }
            }
          }
        }
        localAppRuntime.notifyObservers(QZoneMsgObserver.class, paramInt, true, paramBundle);
      }
    }
    else
    {
      localAppRuntime.notifyObservers(QZoneMsgObserver.class, paramInt, false, paramBundle);
      QZLog.e("QZoneMsgManager", "onReceive jceStruct error");
    }
  }
  
  public void preLoadQZoneMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "preLoadQZoneMsg()");
    }
    AppRuntime localAppRuntime = getApp();
    if (localAppRuntime == null)
    {
      QZLog.e("QZoneMsgManager", "preLoadQZoneMsg app == null");
      return;
    }
    localAppRuntime.startServlet(((QzoneReqImpl)QRoute.api(QzoneReqImpl.class)).getMsgIntent(localAppRuntime.getApplication(), this, localAppRuntime.getLongAccountUin(), getLoadNum(0), 1, 0));
  }
  
  public void refreshQZoneMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "refreshQZoneMsg()");
    }
    AppRuntime localAppRuntime = getApp();
    if (localAppRuntime == null)
    {
      QZLog.e("QZoneMsgManager", "refreshQZoneMsg app == null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.1(this, localAppRuntime));
  }
  
  public void saveMsgToDB(IMQMsg paramIMQMsg)
  {
    paramIMQMsg = getMqMsg(paramIMQMsg);
    if ((paramIMQMsg != null) && (paramIMQMsg.msgInteractData != null) && (paramIMQMsg.msgInteractData.likeCell != null))
    {
      if (TextUtils.isEmpty(paramIMQMsg.msgInteractData.likeCell.likeKey)) {
        return;
      }
      String str = paramIMQMsg.msgInteractData.likeCell.likeKey;
      if (this.msgEntity != null)
      {
        int i = 0;
        while (i < this.msgEntity.size())
        {
          QZoneMsgEntityNew localQZoneMsgEntityNew = (QZoneMsgEntityNew)this.msgEntity.get(i);
          if ((localQZoneMsgEntityNew != null) && (localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.size() > 0) && (localQZoneMsgEntityNew.ArkNes_vec.get(0) != null))
          {
            MQMsg localMQMsg = getMqMsg((IMQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0));
            if ((localMQMsg != null) && (localMQMsg.msgInteractData != null) && (localMQMsg.msgInteractData.likeCell != null) && (!TextUtils.isEmpty(localMQMsg.msgInteractData.likeCell.likeKey)) && (str.equals(localMQMsg.msgInteractData.likeCell.likeKey)))
            {
              localMQMsg.msgInteractData.likeCell.totalLike = paramIMQMsg.msgInteractData.likeCell.totalLike;
              localMQMsg.msgInteractData.totalComment = paramIMQMsg.msgInteractData.totalComment;
              localMQMsg.msgInteractData.likeCell.liked = paramIMQMsg.msgInteractData.likeCell.liked;
              saveMsgToDB(localQZoneMsgEntityNew, 0);
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void saveMsgToDB(QZoneMsgEntityNew paramQZoneMsgEntityNew, int paramInt)
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "saveMsgToDB()");
    }
    if (paramQZoneMsgEntityNew == null)
    {
      QZLog.e("QZoneMsgManager", "saveMsgToDB error entity==null");
      return;
    }
    this.traceInfo = paramQZoneMsgEntityNew.trace_info;
    if (this.msgEntity != null)
    {
      paramInt = 0;
      while (paramInt < this.msgEntity.size())
      {
        QZoneMsgEntityNew localQZoneMsgEntityNew = (QZoneMsgEntityNew)this.msgEntity.get(paramInt);
        if ((localQZoneMsgEntityNew != null) && (localQZoneMsgEntityNew.pushTime == paramQZoneMsgEntityNew.pushTime))
        {
          paramQZoneMsgEntityNew.setId(localQZoneMsgEntityNew.getId());
          paramQZoneMsgEntityNew.setStatus(localQZoneMsgEntityNew.getStatus());
          this.msgEntity.set(paramInt, paramQZoneMsgEntityNew);
          paramInt = 1;
          break label123;
        }
        paramInt += 1;
      }
      paramInt = 0;
      label123:
      if (paramInt == 0) {
        this.msgEntity.add(0, paramQZoneMsgEntityNew);
      }
    }
    else
    {
      this.msgEntity = new ArrayList();
      this.msgEntity.add(paramQZoneMsgEntityNew);
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.2(this, paramQZoneMsgEntityNew));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager
 * JD-Core Version:    0.7.0.1
 */