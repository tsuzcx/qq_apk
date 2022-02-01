package com.tencent.mobileqq.flashshow.part;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.AppConstants.Key;
import com.tencent.biz.qcircleshadow.lib.variation.HostFaceUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.flashshow.utils.FSTransUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneShareApi;
import java.util.ArrayList;
import java.util.List;

class FSSharePart$8
  implements VSDispatchObserver.onVSRspCallBack<QQHeadUrl.QQHeadUrlRsp>
{
  FSSharePart$8(FSSharePart paramFSSharePart, String paramString, Bundle paramBundle) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp)
  {
    paramString = this.a;
    if ((paramBoolean) && (paramQQHeadUrlRsp != null))
    {
      Object localObject = paramQQHeadUrlRsp.dstHeadInfos.get();
      paramBaseRequest = paramString;
      if (localObject != null)
      {
        paramBaseRequest = paramString;
        if (((List)localObject).size() > 0)
        {
          QQHeadUrl.RspHeadInfo localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((List)localObject).get(0);
          paramBaseRequest = paramString;
          if (localRspHeadInfo != null)
          {
            localObject = localRspHeadInfo.url.get();
            paramBaseRequest = paramString;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramBaseRequest = paramString;
              try
              {
                paramString = HostFaceUtils.getQQAvatarDownLoadUrl((String)localObject, (byte)localRspHeadInfo.faceFlag.get(), (byte)paramQQHeadUrlRsp.dstUsrType.get(), 0);
                paramBaseRequest = paramString;
                paramString = HostStaticInvokeHelper.insertMtypeByMsfSdkUtils("QQHeadIcon", paramString);
                paramBaseRequest = paramString;
                paramQQHeadUrlRsp = Uri.parse((String)localObject).getHost();
                paramBaseRequest = paramString;
                paramString = paramString.replace(Uri.parse(paramString).getHost(), paramQQHeadUrlRsp);
                paramBaseRequest = paramString;
              }
              catch (Exception paramString)
              {
                QLog.e("FSSharePart", 1, "shareToQZone() process icon url error! Use default cover url instead!", paramString);
              }
            }
          }
        }
      }
    }
    else
    {
      QLog.w("FSSharePart", 1, "shareToQZone() get user icon url error! Use default cover url instead!");
      paramBaseRequest = paramString;
    }
    paramString = new ArrayList(1);
    paramString.add(paramBaseRequest);
    this.b.putStringArrayList(QCircleHostConstants.AppConstants.Key.SHARE_REQ_IMAGE_URL(), paramString);
    try
    {
      FSSharePart.c(this.c, true);
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).jumpToQzoneShare(FSTransUtils.a(), this.c.c(), this.b, null, -1);
      if (QLog.isColorLevel())
      {
        QLog.d("FSSharePart", 1, "shareToQZone  success");
        return;
      }
    }
    catch (Exception paramBaseRequest)
    {
      QLog.e("FSSharePart", 1, "shareToQZone() jumpToQzoneShare error!", paramBaseRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.8
 * JD-Core Version:    0.7.0.1
 */