package cooperation.qzone.contentbox;

import NS_MOBILE_OPERATION.operation_like_rsp;
import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QZoneCommonServlet;
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
  public static final int DEFAULT_LOAD_NUM = 10;
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
  private String traceInfo = null;
  
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
      this.loadNumConfig = QzoneConfig.getInstance().getConfig("QZoneSetting", "contentbox_load_num", "10_10_10");
    }
    String[] arrayOfString;
    if (!TextUtils.isEmpty(this.loadNumConfig))
    {
      arrayOfString = this.loadNumConfig.split("_");
      if (arrayOfString.length == 3) {
        break label52;
      }
    }
    label52:
    while (TextUtils.isEmpty(arrayOfString[paramInt])) {
      return 10;
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
    return 10;
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
      localObject2 = new QzoneCommonIntent(localQQAppInterface.getApplication(), QZoneCommonServlet.class);
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
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), QZoneCommonServlet.class);
    localQzoneCommonIntent.setRequest(localQZoneMsgReq);
    localQzoneCommonIntent.setObserver(this);
    localQQAppInterface.startServlet(localQzoneCommonIntent);
  }
  
  /* Error */
  public ArrayList<QZoneMsgEntityNew> loadMsgFromDB()
  {
    // Byte code:
    //   0: invokestatic 61	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   3: ifeq +10 -> 13
    //   6: ldc 21
    //   8: ldc 240
    //   10: invokestatic 67	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 69	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   17: ifnull +8 -> 25
    //   20: aload_0
    //   21: getfield 69	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 73	cooperation/qzone/contentbox/QZoneMsgManager:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnonnull +12 -> 43
    //   34: ldc 21
    //   36: ldc 242
    //   38: invokestatic 78	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aconst_null
    //   42: areturn
    //   43: aload_2
    //   44: invokevirtual 246	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   47: invokevirtual 252	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   50: astore_2
    //   51: aload_2
    //   52: ldc 254
    //   54: iconst_0
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: ldc_w 256
    //   62: ldc_w 258
    //   65: invokevirtual 264	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   68: astore_3
    //   69: aload_0
    //   70: new 266	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 267	java/util/ArrayList:<init>	()V
    //   77: putfield 69	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   80: aload_3
    //   81: ifnull +68 -> 149
    //   84: aload_3
    //   85: invokeinterface 273 1 0
    //   90: ifle +59 -> 149
    //   93: iconst_1
    //   94: istore_1
    //   95: iload_1
    //   96: aload_3
    //   97: invokeinterface 273 1 0
    //   102: if_icmpge +47 -> 149
    //   105: aload_3
    //   106: iload_1
    //   107: invokeinterface 276 2 0
    //   112: checkcast 254	cooperation/qzone/contentbox/model/QZoneMsgEntityNew
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +23 -> 142
    //   122: aload 4
    //   124: invokevirtual 279	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readArkNewsFromBuffer	()V
    //   127: aload 4
    //   129: invokevirtual 282	cooperation/qzone/contentbox/model/QZoneMsgEntityNew:readBottomItemsFromBuffer	()V
    //   132: aload_0
    //   133: getfield 69	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   136: aload 4
    //   138: invokevirtual 286	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   141: pop
    //   142: iload_1
    //   143: iconst_1
    //   144: iadd
    //   145: istore_1
    //   146: goto -51 -> 95
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 289	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   157: aload_0
    //   158: getfield 69	cooperation/qzone/contentbox/QZoneMsgManager:msgEntity	Ljava/util/ArrayList;
    //   161: areturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: ldc 21
    //   167: iconst_1
    //   168: aload_3
    //   169: iconst_0
    //   170: anewarray 4	java/lang/Object
    //   173: invokestatic 292	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   176: aload_2
    //   177: ifnull -20 -> 157
    //   180: aload_2
    //   181: invokevirtual 289	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   184: goto -27 -> 157
    //   187: astore_3
    //   188: aconst_null
    //   189: astore_2
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 289	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   198: aload_3
    //   199: athrow
    //   200: astore_3
    //   201: goto -11 -> 190
    //   204: astore_3
    //   205: goto -15 -> 190
    //   208: astore_3
    //   209: goto -44 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	QZoneMsgManager
    //   94	52	1	i	int
    //   29	166	2	localObject1	Object
    //   68	38	3	localList	java.util.List
    //   162	7	3	localThrowable1	java.lang.Throwable
    //   187	12	3	localObject2	Object
    //   200	1	3	localObject3	Object
    //   204	1	3	localObject4	Object
    //   208	1	3	localThrowable2	java.lang.Throwable
    //   115	22	4	localQZoneMsgEntityNew	QZoneMsgEntityNew
    // Exception table:
    //   from	to	target	type
    //   43	51	162	java/lang/Throwable
    //   43	51	187	finally
    //   51	80	200	finally
    //   84	93	200	finally
    //   95	117	200	finally
    //   122	142	200	finally
    //   165	176	204	finally
    //   51	80	208	java/lang/Throwable
    //   84	93	208	java/lang/Throwable
    //   95	117	208	java/lang/Throwable
    //   122	142	208	java/lang/Throwable
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
    if (localQQAppInterface == null)
    {
      QZLog.e("QZoneMsgManager", "preLoadQZoneMsg app == null");
      return;
    }
    QZoneMsgReq localQZoneMsgReq = new QZoneMsgReq(localQQAppInterface.getLongAccountUin(), "", getLoadNum(0), 1);
    localQZoneMsgReq.setType(0);
    QzoneCommonIntent localQzoneCommonIntent = new QzoneCommonIntent(localQQAppInterface.getApplication(), QZoneCommonServlet.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager
 * JD-Core Version:    0.7.0.1
 */