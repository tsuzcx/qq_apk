package cooperation.qzone.contentbox;

import NS_MOBILE_OPERATION.operation_like_rsp;
import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import android.os.Bundle;
import android.text.TextUtils;
import aqru;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.contentbox.model.MQLikeCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgInteractData;
import cooperation.qzone.contentbox.model.QZoneLikeReq;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.contentbox.model.QZoneMsgReq;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class QZoneMsgManager
  implements Manager, BusinessObserver
{
  public static final int DEFAULT_LOAD_NUM = 2;
  public static final String ENTITY_PUSHTIME_KEY = "entity_pushtime";
  public static final String LIKE_KEY = "like_key";
  public static final String TAG = "QZoneMsgManager";
  public static final int TYPE_LIKEFEED = 100;
  public static final int TYPE_LOADMORE = 2;
  public static final int TYPE_PRELOAD = 0;
  public static final int TYPE_REFRESH = 1;
  String loadNumConfig = null;
  private WeakReference<QQAppInterface> mAppRef;
  private ArrayList<QZoneMsgEntityNew> msgEntity;
  private String traceInfo;
  
  public QZoneMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.mAppRef = new WeakReference(paramQQAppInterface);
  }
  
  public void dropMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "dropMsg()");
    }
    this.msgEntity = null;
    this.traceInfo = null;
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "dropMsg error app == null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.3(this, localQQAppInterface));
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef != null) {
      return (QQAppInterface)this.mAppRef.get();
    }
    return null;
  }
  
  public int getLoadNum(int paramInt)
  {
    if (this.loadNumConfig == null) {
      this.loadNumConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", "contentbox_load_num", "1_1_1");
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(this.loadNumConfig))
    {
      arrayOfString = this.loadNumConfig.split("_");
      if (arrayOfString.length == 3) {
        break label51;
      }
    }
    label51:
    while (TextUtils.isEmpty(arrayOfString[paramInt])) {
      return 2;
    }
    try
    {
      paramInt = Integer.parseInt(arrayOfString[paramInt]);
      return paramInt;
    }
    catch (Exception localException)
    {
      QZLog.e("QZoneMsgManager", "getLoadNum error", localException);
    }
    return 2;
  }
  
  public void likeFeed(MQLikeCell paramMQLikeCell, long paramLong)
  {
    boolean bool = true;
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "likeFeed()");
    }
    if ((paramMQLikeCell == null) || (TextUtils.isEmpty(paramMQLikeCell.likeKey))) {
      return;
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "likeFeed app == null");
      return;
    }
    long l = localQQAppInterface.getLongAccountUin();
    Object localObject1 = paramMQLikeCell.likeKey;
    Object localObject2 = paramMQLikeCell.likeKey;
    int i;
    Bundle localBundle;
    if (!paramMQLikeCell.liked)
    {
      i = 0;
      localObject1 = new QZoneLikeReq(Long.valueOf(l), (String)localObject1, (String)localObject2, i, paramMQLikeCell.appid);
      ((QZoneLikeReq)localObject1).setType(100);
      localObject2 = new QzoneCommonIntent(localQQAppInterface.getApplication(), aqru.class);
      localBundle = new Bundle();
      if (paramMQLikeCell.liked) {
        break label194;
      }
    }
    for (;;)
    {
      localBundle.putBoolean("like_key", bool);
      localBundle.putLong("entity_pushtime", paramLong);
      ((QzoneCommonIntent)localObject2).putExtras(localBundle);
      ((QzoneCommonIntent)localObject2).setRequest((QZoneCommonRequest)localObject1);
      ((QzoneCommonIntent)localObject2).setObserver(this);
      localQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      i = 1;
      break;
      label194:
      bool = false;
    }
  }
  
  public void loadMoreMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "loadMoreMsg()");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "loadMoreMsg app == null");
      return;
    }
    QZoneMsgReq localQZoneMsgReq = new QZoneMsgReq(localQQAppInterface.getLongAccountUin(), this.traceInfo, getLoadNum(2), 3);
    localQZoneMsgReq.setType(2);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), aqru.class);
    localQzoneCommonIntent.setRequest(localQZoneMsgReq);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
  
  /* Error */
  public ArrayList<QZoneMsgEntityNew> loadMsgFromDB()
  {
    // Byte code:
    //   0: invokestatic 58	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   3: ifeq +10 -> 13
    //   6: ldc 21
    //   8: ldc 239
    //   10: invokestatic 64	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 66	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   17: ifnull +8 -> 25
    //   20: aload_0
    //   21: getfield 66	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 72	cooperation/qzone/contentbox/QZoneMsgManager:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnonnull +12 -> 43
    //   34: ldc 21
    //   36: ldc 241
    //   38: invokestatic 77	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_2
    //   44: invokevirtual 245	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   47: invokevirtual 251	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: ldc 253
    //   54: iconst_0
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: ldc 255
    //   61: ldc_w 257
    //   64: invokevirtual 263	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   67: astore_3
    //   68: aload_0
    //   69: new 265	java/util/ArrayList
    //   72: dup
    //   73: invokespecial 266	java/util/ArrayList:<init>	()V
    //   76: putfield 66	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   79: aload_3
    //   80: ifnull +68 -> 148
    //   83: aload_3
    //   84: invokeinterface 272 1 0
    //   89: ifle +59 -> 148
    //   92: iconst_1
    //   93: istore_1
    //   94: iload_1
    //   95: aload_3
    //   96: invokeinterface 272 1 0
    //   101: if_icmpge +47 -> 148
    //   104: aload_3
    //   105: iload_1
    //   106: invokeinterface 275 2 0
    //   111: checkcast 253	cooperation/qzone/contentbox/model/QZoneMsgEntityNew
    //   114: astore 4
    //   116: aload 4
    //   118: ifnull +23 -> 141
    //   121: aload 4
    //   123: invokevirtual 278	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readArkNewsFromBuffer	()V
    //   126: aload 4
    //   128: invokevirtual 281	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readBottomItemsFromBuffer	()V
    //   131: aload_0
    //   132: getfield 66	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   135: aload 4
    //   137: invokevirtual 285	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   140: pop
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: goto -51 -> 94
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   156: aload_0
    //   157: getfield 66	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   160: areturn
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_2
    //   164: ldc 21
    //   166: iconst_1
    //   167: aload_3
    //   168: iconst_0
    //   169: anewarray 4	java/lang/Object
    //   172: invokestatic 291	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   175: aload_2
    //   176: ifnull -20 -> 156
    //   179: aload_2
    //   180: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   183: goto -27 -> 156
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_2
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   197: aload_3
    //   198: athrow
    //   199: astore_3
    //   200: goto -11 -> 189
    //   203: astore_3
    //   204: goto -15 -> 189
    //   207: astore_3
    //   208: goto -44 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	QZoneMsgManager
    //   93	52	1	i	int
    //   29	165	2	localObject1	Object
    //   67	38	3	localList	java.util.List
    //   161	7	3	localThrowable1	java.lang.Throwable
    //   186	12	3	localObject2	Object
    //   199	1	3	localObject3	Object
    //   203	1	3	localObject4	Object
    //   207	1	3	localThrowable2	java.lang.Throwable
    //   114	22	4	localQZoneMsgEntityNew	QZoneMsgEntityNew
    // Exception table:
    //   from	to	target	type
    //   43	51	161	java/lang/Throwable
    //   43	51	186	finally
    //   51	79	199	finally
    //   83	92	199	finally
    //   94	116	199	finally
    //   121	141	199	finally
    //   164	175	203	finally
    //   51	79	207	java/lang/Throwable
    //   83	92	207	java/lang/Throwable
    //   94	116	207	java/lang/Throwable
    //   121	141	207	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    this.msgEntity = null;
    this.traceInfo = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QZLog.e("QZoneMsgManager", "onReceive app == null");
    }
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = (JceStruct)paramBundle.getSerializable("key_response");
      int i = paramBundle.getInt("key_response_code");
      localObject2 = paramBundle.getString("key_response_msg");
      if (QLog.isColorLevel()) {
        QLog.i("QZoneMsgManager", 2, String.format("type :%d, success:%b, code:%d, msg:%s, bundle:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Integer.valueOf(i), localObject2, paramBundle.toString() }));
      }
      if ((localObject1 instanceof QzoneMessageBoxRsp))
      {
        localObject1 = QZoneMsgEntityNew.readFrom((QzoneMessageBoxRsp)localObject1);
        if (localObject1 != null)
        {
          paramBundle.putSerializable("key_response", (Serializable)localObject1);
          localQQAppInterface.notifyObservers(QZoneMsgObserver.class, paramInt, true, paramBundle);
          saveMsgToDB((QZoneMsgEntityNew)localObject1, paramInt);
          return;
        }
        localQQAppInterface.notifyObservers(QZoneMsgObserver.class, paramInt, false, paramBundle);
        QZLog.e("QZoneMsgManager", "onReceive entity == null");
        return;
      }
      if (!(localObject1 instanceof operation_like_rsp)) {
        break;
      }
    } while (((operation_like_rsp)localObject1).ret != 0);
    paramBoolean = paramBundle.getBoolean("like_key");
    long l = paramBundle.getLong("entity_pushtime");
    if ((l > 0L) && (this.msgEntity != null))
    {
      localObject1 = this.msgEntity.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QZoneMsgEntityNew)((Iterator)localObject1).next();
        if ((((QZoneMsgEntityNew)localObject2).pushTime == l) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec != null) && (((QZoneMsgEntityNew)localObject2).ArkNes_vec.size() > 0))
        {
          ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell.liked = paramBoolean;
          MQLikeCell localMQLikeCell;
          if (paramBoolean) {
            localMQLikeCell = ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell;
          }
          for (localMQLikeCell.totalLike += 1;; localMQLikeCell.totalLike -= 1)
          {
            saveMsgToDB((QZoneMsgEntityNew)localObject2, paramInt);
            break;
            localMQLikeCell = ((MQMsg)((QZoneMsgEntityNew)localObject2).ArkNes_vec.get(0)).msgInteractData.likeCell;
          }
        }
      }
    }
    localQQAppInterface.notifyObservers(QZoneMsgObserver.class, paramInt, true, paramBundle);
    return;
    localQQAppInterface.notifyObservers(QZoneMsgObserver.class, paramInt, false, paramBundle);
    QZLog.e("QZoneMsgManager", "onReceive jceStruct error");
  }
  
  public void preLoadQZoneMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "preLoadQZoneMsg()");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      QZLog.e("QZoneMsgManager", "preLoadQZoneMsg app == null");
    }
    do
    {
      return;
      if (this.msgEntity == null) {
        break;
      }
    } while (!QZLog.isColorLevel());
    QZLog.i("QZoneMsgManager", "msgEntity != null, not need preLoadQZoneMsg");
    return;
    QZoneMsgReq localQZoneMsgReq = new QZoneMsgReq(localQQAppInterface.getLongAccountUin(), "", getLoadNum(0), 1);
    localQZoneMsgReq.setType(0);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), aqru.class);
    localQzoneCommonIntent.setRequest(localQZoneMsgReq);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
  
  public void refreshQZoneMsg()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("QZoneMsgManager", "refreshQZoneMsg()");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "refreshQZoneMsg app == null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.1(this, localQQAppInterface));
  }
  
  public void saveMsgToDB(MQMsg paramMQMsg)
  {
    if ((paramMQMsg == null) || (paramMQMsg.msgInteractData == null) || (paramMQMsg.msgInteractData.likeCell == null) || (TextUtils.isEmpty(paramMQMsg.msgInteractData.likeCell.likeKey))) {}
    String str;
    do
    {
      return;
      str = paramMQMsg.msgInteractData.likeCell.likeKey;
    } while (this.msgEntity == null);
    int i = 0;
    label58:
    QZoneMsgEntityNew localQZoneMsgEntityNew;
    MQMsg localMQMsg;
    if (i < this.msgEntity.size())
    {
      localQZoneMsgEntityNew = (QZoneMsgEntityNew)this.msgEntity.get(i);
      if ((localQZoneMsgEntityNew != null) && (localQZoneMsgEntityNew.ArkNes_vec != null) && (localQZoneMsgEntityNew.ArkNes_vec.get(0) != null))
      {
        localMQMsg = (MQMsg)localQZoneMsgEntityNew.ArkNes_vec.get(0);
        if ((localMQMsg != null) && (localMQMsg.msgInteractData != null) && (localMQMsg.msgInteractData.likeCell != null) && (!TextUtils.isEmpty(localMQMsg.msgInteractData.likeCell.likeKey))) {
          break label169;
        }
      }
    }
    label169:
    while (!str.equals(localMQMsg.msgInteractData.likeCell.likeKey))
    {
      i += 1;
      break label58;
      break;
    }
    localMQMsg.msgInteractData.likeCell.totalLike = paramMQMsg.msgInteractData.likeCell.totalLike;
    localMQMsg.msgInteractData.totalComment = paramMQMsg.msgInteractData.totalComment;
    localMQMsg.msgInteractData.likeCell.liked = paramMQMsg.msgInteractData.likeCell.liked;
    saveMsgToDB(localQZoneMsgEntityNew, 0);
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
      if (paramInt >= this.msgEntity.size()) {
        break label185;
      }
      if (((QZoneMsgEntityNew)this.msgEntity.get(paramInt)).pushTime == paramQZoneMsgEntityNew.pushTime)
      {
        paramQZoneMsgEntityNew.setId(((QZoneMsgEntityNew)this.msgEntity.get(paramInt)).getId());
        paramQZoneMsgEntityNew.setStatus(((QZoneMsgEntityNew)this.msgEntity.get(paramInt)).getStatus());
        this.msgEntity.set(paramInt, paramQZoneMsgEntityNew);
      }
    }
    label185:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        this.msgEntity.add(0, paramQZoneMsgEntityNew);
      }
      for (;;)
      {
        ThreadManager.getFileThreadHandler().post(new QZoneMsgManager.2(this, paramQZoneMsgEntityNew));
        return;
        paramInt += 1;
        break;
        this.msgEntity = new ArrayList();
        this.msgEntity.add(paramQZoneMsgEntityNew);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager
 * JD-Core Version:    0.7.0.1
 */