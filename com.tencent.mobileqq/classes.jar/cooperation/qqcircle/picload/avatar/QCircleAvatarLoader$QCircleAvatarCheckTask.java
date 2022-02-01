package cooperation.qqcircle.picload.avatar;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleHandler;
import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.concurrent.ConcurrentHashMap;

class QCircleAvatarLoader$QCircleAvatarCheckTask
  implements Runnable
{
  private EntityManager mEm;
  private AvatarOption mOption;
  
  public QCircleAvatarLoader$QCircleAvatarCheckTask(QCircleAvatarLoader paramQCircleAvatarLoader, AvatarOption paramAvatarOption, EntityManager paramEntityManager)
  {
    this.mOption = paramAvatarOption;
    this.mEm = paramEntityManager;
  }
  
  private void addToTogether(AvatarOption paramAvatarOption)
  {
    if (QCircleAvatarLoader.access$200(this.this$0).get(paramAvatarOption.getUin()) != null)
    {
      ((ConcurrentHashMap)QCircleAvatarLoader.access$200(this.this$0).get(paramAvatarOption.getUin())).put(Integer.valueOf(paramAvatarOption.hashCode()), paramAvatarOption);
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put(Integer.valueOf(paramAvatarOption.hashCode()), paramAvatarOption);
    QCircleAvatarLoader.access$200(this.this$0).put(paramAvatarOption.getUin(), localConcurrentHashMap);
  }
  
  private void callFailed(String paramString, Option paramOption)
  {
    if (QCircleAvatarLoader.access$200(this.this$0).containsKey(paramString)) {
      ((ConcurrentHashMap)QCircleAvatarLoader.access$200(this.this$0).get(paramString)).clear();
    }
    QCircleAvatarLoader.access$800(this.this$0).remove(paramString);
  }
  
  private void callSuccess(String paramString, Option paramOption)
  {
    QCircleAvatarLoader.access$800(this.this$0).remove(paramString);
    QLog.d("QCircleAvatar", 1, "seq = " + this.mOption.getSeq() + "  all cost times:" + (System.currentTimeMillis() - paramOption.mStartTime.longValue()));
  }
  
  private long computeTimeSpan(QCircleAvatarInfo paramQCircleAvatarInfo)
  {
    if (paramQCircleAvatarInfo == null) {
      return System.currentTimeMillis();
    }
    long l = 0L;
    paramQCircleAvatarInfo = paramQCircleAvatarInfo.getTimestamp();
    if (!TextUtils.isEmpty(paramQCircleAvatarInfo)) {
      l = Long.parseLong(paramQCircleAvatarInfo);
    }
    return System.currentTimeMillis() - l;
  }
  
  private IAvatarListener createListener(AvatarOption paramAvatarOption)
  {
    return new QCircleAvatarLoader.QCircleAvatarCheckTask.1(this, paramAvatarOption);
  }
  
  private void loadPicByPicLoad(AvatarOption paramAvatarOption, QCircleAvatarInfo paramQCircleAvatarInfo)
  {
    if ((paramQCircleAvatarInfo == null) || (paramAvatarOption == null)) {
      return;
    }
    paramAvatarOption.setUrl(paramQCircleAvatarInfo.getDownLoadUrl());
    QCircleFeedPicLoader.g().loadImage(paramAvatarOption, new QCircleAvatarLoader.QCircleAvatarCheckTask.2(this, paramQCircleAvatarInfo));
  }
  
  private QCircleAvatarInfo queryInfoFromDataBase(AvatarOption paramAvatarOption)
  {
    if (paramAvatarOption == null) {
      return null;
    }
    synchronized (this.mEm)
    {
      paramAvatarOption = (QCircleAvatarInfo)this.mEm.find(QCircleAvatarInfo.class, paramAvatarOption.getUin());
      return paramAvatarOption;
    }
  }
  
  private void requestServer(AvatarOption paramAvatarOption)
  {
    if (paramAvatarOption == null) {}
    QCircleHandler localQCircleHandler;
    do
    {
      return;
      if (QCircleAvatarLoader.access$100(this.this$0).containsKey(paramAvatarOption.getUin()))
      {
        addToTogether(paramAvatarOption);
        QLog.d("QCircleAvatar", 1, "seq = " + this.mOption.getSeq() + "  on requesting return ");
        return;
      }
      QCircleAvatarLoader.access$100(this.this$0).put(paramAvatarOption.getUin(), paramAvatarOption.getUin());
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localQCircleHandler = (QCircleHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.QCIRCLE_HANDLER);
    } while (localQCircleHandler == null);
    ToServiceMsg localToServiceMsg = localQCircleHandler.createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq");
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
    localQQHeadUrlReq.srcUsrType.set(1);
    localQQHeadUrlReq.srcUin.set(Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin()));
    localQQHeadUrlReq.dstUsrType.set(1);
    Object localObject = new QQHeadUrl.ReqUsrInfo();
    try
    {
      ((QQHeadUrl.ReqUsrInfo)localObject).dstUin.set(Long.parseLong(paramAvatarOption.getUin()));
      label184:
      ((QQHeadUrl.ReqUsrInfo)localObject).timestamp.set(0);
      localQQHeadUrlReq.dstUsrInfos.add((MessageMicro)localObject);
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("dstUsrType", 1);
      localToServiceMsg.extraData.putString("dstUin", paramAvatarOption.getUin());
      localToServiceMsg.extraData.putBoolean("qcircle", true);
      localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
      localQCircleHandler.registerAvatarListener(paramAvatarOption.getUin(), createListener(paramAvatarOption));
      localQCircleHandler.sendPbReq(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      break label184;
    }
  }
  
  private void updateToDataBase(QCircleAvatarInfo paramQCircleAvatarInfo)
  {
    if (paramQCircleAvatarInfo == null) {
      return;
    }
    synchronized (this.mEm)
    {
      paramQCircleAvatarInfo.setStatus(1000);
      this.mEm.persistOrReplace(paramQCircleAvatarInfo);
      return;
    }
  }
  
  public void run()
  {
    Object localObject2 = (QCircleAvatarInfo)QCircleAvatarLoader.access$000(this.this$0).get(this.mOption.getUin());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = queryInfoFromDataBase(this.mOption);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        QLog.d("QCircleAvatar", 1, "seq = " + this.mOption.getSeq() + "  query from dataBase success:" + ((QCircleAvatarInfo)localObject2).toString());
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null)
    {
      QLog.d("QCircleAvatar", 1, "seq = " + this.mOption.getSeq() + "  query from dataBase null to server");
      requestServer(this.mOption);
      return;
    }
    if ((computeTimeSpan(localObject1) < 86400000L) && (!TextUtils.isEmpty(localObject1.getDownLoadUrl())))
    {
      QLog.d("QCircleAvatar", 1, "seq = " + this.mOption.getSeq() + "  query from dataBase success ,timSpan is validate ");
      loadPicByPicLoad(this.mOption, localObject1);
      return;
    }
    QLog.d("QCircleAvatar", 1, "seq = " + this.mOption.getSeq() + "  query from dataBase success ,timSpan is unValidate to server ");
    localObject2 = this.mOption;
    if (TextUtils.isEmpty(localObject1.getTimestamp())) {}
    for (long l = 0L;; l = Long.parseLong(localObject1.getTimestamp()))
    {
      ((AvatarOption)localObject2).setTimeStamp(l);
      requestServer(this.mOption);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader.QCircleAvatarCheckTask
 * JD-Core Version:    0.7.0.1
 */