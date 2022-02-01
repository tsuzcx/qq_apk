package cooperation.qqcircle.picload.avatar;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCircleAvatarUrlListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.IAvatarListener;
import com.tencent.mobileqq.qcircle.tempapi.avatar.QCircleAvatarInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
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
    paramString = new StringBuilder();
    paramString.append("seq = ");
    paramString.append(this.mOption.getSeq());
    paramString.append("  all cost times:");
    paramString.append(System.currentTimeMillis() - paramOption.mStartTime.longValue());
    QLog.d("QCircleAvatar", 1, paramString.toString());
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
    if (paramQCircleAvatarInfo != null)
    {
      if (paramAvatarOption == null) {
        return;
      }
      paramAvatarOption.setUrl(paramQCircleAvatarInfo.getDownLoadUrl());
      if (paramAvatarOption.getUrlListener() != null) {
        paramAvatarOption.getUrlListener().onAvatarUrl(paramQCircleAvatarInfo.getDownLoadUrl());
      }
      QCircleFeedPicLoader.g().loadImage(paramAvatarOption, new QCircleAvatarLoader.QCircleAvatarCheckTask.2(this, paramQCircleAvatarInfo));
    }
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
    if (paramAvatarOption == null) {
      return;
    }
    if (QCircleAvatarLoader.access$100(this.this$0).containsKey(paramAvatarOption.getUin()))
    {
      addToTogether(paramAvatarOption);
      paramAvatarOption = new StringBuilder();
      paramAvatarOption.append("seq = ");
      paramAvatarOption.append(this.mOption.getSeq());
      paramAvatarOption.append("  on requesting return ");
      QLog.d("QCircleAvatar", 1, paramAvatarOption.toString());
      return;
    }
    QCircleAvatarLoader.access$100(this.this$0).put(paramAvatarOption.getUin(), paramAvatarOption.getUin());
    QCircleHandler localQCircleHandler = QCircleHandler.d();
    ToServiceMsg localToServiceMsg;
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq;
    QQHeadUrl.ReqUsrInfo localReqUsrInfo;
    if (localQCircleHandler != null)
    {
      localToServiceMsg = localQCircleHandler.createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq");
      localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
      localQQHeadUrlReq.srcUsrType.set(1);
      localQQHeadUrlReq.srcUin.set(QCircleHostStubUtil.getCurrentAccountLongUin());
      localQQHeadUrlReq.dstUsrType.set(1);
      localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
    }
    try
    {
      localReqUsrInfo.dstUin.set(Long.parseLong(paramAvatarOption.getUin()));
      label168:
      localReqUsrInfo.timestamp.set(0);
      localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("dstUsrType", 1);
      localToServiceMsg.extraData.putString("dstUin", paramAvatarOption.getUin());
      localToServiceMsg.extraData.putBoolean("qcircle", true);
      localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
      localQCircleHandler.a(paramAvatarOption.getUin(), createListener(paramAvatarOption));
      localQCircleHandler.sendPbReq(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      break label168;
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
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("seq = ");
        ((StringBuilder)localObject1).append(this.mOption.getSeq());
        ((StringBuilder)localObject1).append("  query from dataBase success:");
        ((StringBuilder)localObject1).append(((QCircleAvatarInfo)localObject2).toString());
        QLog.d("QCircleAvatar", 1, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("seq = ");
      ((StringBuilder)localObject1).append(this.mOption.getSeq());
      ((StringBuilder)localObject1).append("  query from dataBase null to server");
      QLog.d("QCircleAvatar", 1, ((StringBuilder)localObject1).toString());
      requestServer(this.mOption);
      return;
    }
    if ((computeTimeSpan((QCircleAvatarInfo)localObject1) < 86400000L) && (!TextUtils.isEmpty(((QCircleAvatarInfo)localObject1).getDownLoadUrl())))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("seq = ");
      ((StringBuilder)localObject2).append(this.mOption.getSeq());
      ((StringBuilder)localObject2).append("  query from dataBase success ,timSpan is validate ");
      QLog.d("QCircleAvatar", 1, ((StringBuilder)localObject2).toString());
      loadPicByPicLoad(this.mOption, (QCircleAvatarInfo)localObject1);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("seq = ");
    ((StringBuilder)localObject2).append(this.mOption.getSeq());
    ((StringBuilder)localObject2).append("  query from dataBase success ,timSpan is unValidate to server ");
    QLog.d("QCircleAvatar", 1, ((StringBuilder)localObject2).toString());
    localObject2 = this.mOption;
    long l;
    if (TextUtils.isEmpty(((QCircleAvatarInfo)localObject1).getTimestamp())) {
      l = 0L;
    } else {
      l = Long.parseLong(((QCircleAvatarInfo)localObject1).getTimestamp());
    }
    ((AvatarOption)localObject2).setTimeStamp(l);
    requestServer(this.mOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.picload.avatar.QCircleAvatarLoader.QCircleAvatarCheckTask
 * JD-Core Version:    0.7.0.1
 */