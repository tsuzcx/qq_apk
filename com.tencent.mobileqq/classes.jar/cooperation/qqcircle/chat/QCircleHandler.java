package cooperation.qqcircle.chat;

import AvatarInfo.QQHeadInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.qqcircle.picload.avatar.IAvatarListener;
import cooperation.qqcircle.picload.avatar.QCircleAvatarInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleHandler
  extends BusinessHandler
{
  private static final String TAG = "QCircleHandler";
  public static final int TYPE_UPDATE_RED_POINT_DISPLAY = 1;
  private ConcurrentHashMap<String, IAvatarListener> mAvatarListener = new ConcurrentHashMap();
  
  public QCircleHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private QQHeadInfo getAvatarInfo(String paramString, byte paramByte, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp)
  {
    Iterator localIterator = paramQQHeadUrlRsp.dstHeadInfos.get().iterator();
    if (localIterator.hasNext())
    {
      QQHeadUrl.RspHeadInfo localRspHeadInfo = (QQHeadUrl.RspHeadInfo)localIterator.next();
      Object localObject;
      if (paramQQHeadUrlRsp.dstEncryptType.get() == 1)
      {
        localObject = localRspHeadInfo.dstUid.get();
        label57:
        if (!paramString.equals(localObject)) {
          break label235;
        }
        localObject = new QQHeadInfo();
        if (paramQQHeadUrlRsp.dstEncryptType.get() != 1) {
          break label237;
        }
        ((QQHeadInfo)localObject).phoneNum = localRspHeadInfo.dstUid.get();
        label99:
        ((QQHeadInfo)localObject).dwTimestamp = localRspHeadInfo.timestamp.get();
        ((QQHeadInfo)localObject).cHeadType = ((byte)localRspHeadInfo.faceType.get());
        ((QQHeadInfo)localObject).dstUsrType = paramByte;
        ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
        ((QQHeadInfo)localObject).downLoadUrl = (localRspHeadInfo.url.get() + "140");
        ((QQHeadInfo)localObject).systemHeadID = ((short)localRspHeadInfo.sysid.get());
        if (!localRspHeadInfo.headVerify.has()) {
          break label253;
        }
      }
      label235:
      label237:
      label253:
      for (paramString = localRspHeadInfo.headVerify.get();; paramString = "")
      {
        ((QQHeadInfo)localObject).headVerify = paramString;
        return localObject;
        localObject = String.valueOf(localRspHeadInfo.dstUin.get());
        break label57;
        break;
        ((QQHeadInfo)localObject).uin = localRspHeadInfo.dstUin.get();
        break label99;
      }
    }
    return null;
  }
  
  private void handleAvatarError(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IAvatarListener localIAvatarListener = (IAvatarListener)this.mAvatarListener.get(paramString);
      if (localIAvatarListener != null)
      {
        localIAvatarListener.onAvatarBack(false, paramInt, null);
        this.mAvatarListener.remove(paramString);
      }
    }
  }
  
  private void handleAvatarReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label157;
        }
        QQHeadUrl.QQHeadUrlRsp localQQHeadUrlRsp = new QQHeadUrl.QQHeadUrlRsp();
        localQQHeadUrlRsp.mergeFrom((byte[])paramObject);
        paramObject = localQQHeadUrlRsp;
      }
      catch (Exception paramObject)
      {
        int i;
        paramObject = localObject;
        continue;
      }
      paramToServiceMsg = paramToServiceMsg.extraData.getString("dstUin", "");
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          handleAvatarError(paramToServiceMsg, i);
          return;
        }
        if (paramFromServiceMsg == null) {
          continue;
        }
        i = paramFromServiceMsg.getResultCode();
        continue;
      }
      paramFromServiceMsg = getAvatarInfo(paramToServiceMsg, (byte)1, paramObject);
      if (paramFromServiceMsg != null)
      {
        handleAvatarSuccess(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      handleAvatarError(paramToServiceMsg, -1);
      return;
      label157:
      paramObject = null;
    }
  }
  
  private void handleAvatarSuccess(String paramString, QQHeadInfo paramQQHeadInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      IAvatarListener localIAvatarListener = (IAvatarListener)this.mAvatarListener.get(paramString);
      if (localIAvatarListener != null)
      {
        QCircleAvatarInfo localQCircleAvatarInfo = new QCircleAvatarInfo();
        localQCircleAvatarInfo.setTimestamp(String.valueOf(System.currentTimeMillis())).setDownLoadUrl(paramQQHeadInfo.downLoadUrl).setUin(paramString);
        localIAvatarListener.onAvatarBack(true, 0, localQCircleAvatarInfo);
        this.mAvatarListener.remove(paramString);
      }
    }
  }
  
  public void clearAvatarListener()
  {
    this.mAvatarListener.clear();
  }
  
  public void clearPedPoint()
  {
    QLog.d("QCircleHandler", 1, "clearRedPoint");
    QCircleChatBoxHelper.getInstance().clearUnReadInfo();
    notifyUI(1, true, Integer.valueOf(0));
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("IncreaseURLSvr.QQHeadUrlReq");
    }
    return this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return QCircleObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((msgCmdFilter(paramToServiceMsg.getServiceCmd())) && ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd())) && (paramToServiceMsg.extraData.getBoolean("qcircle"))) {
      handleAvatarReceive(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void registerAvatarListener(String paramString, IAvatarListener paramIAvatarListener)
  {
    this.mAvatarListener.put(paramString, paramIAvatarListener);
  }
  
  public void updateRedPoint()
  {
    Pair localPair = QCircleChatBoxHelper.getInstance().getUnReadInfo();
    if (localPair != null)
    {
      QLog.d("QCircleHandler", 1, "updateRedPoint:" + localPair.first);
      notifyUI(1, true, localPair.first);
      return;
    }
    QLog.e("QCircleHandler", 1, "updateRedPoint null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.chat.QCircleHandler
 * JD-Core Version:    0.7.0.1
 */