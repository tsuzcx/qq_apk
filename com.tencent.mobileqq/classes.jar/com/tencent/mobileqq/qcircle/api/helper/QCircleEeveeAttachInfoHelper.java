package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class QCircleEeveeAttachInfoHelper
{
  public static final String QCIRCLE_EEVEE_ATTACH_INFO_SP_KEY = "qcircle_eevee_attach_info_sp_key";
  private static final String TAG = "QCircleEeveeAttachInfoHelper";
  private static volatile QCircleEeveeAttachInfoHelper sInstance;
  private List<FeedCloudEeveeBase.StEeveeAttachInfo> mEeveeAttachInfos = new ArrayList();
  
  public static QCircleEeveeAttachInfoHelper getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleEeveeAttachInfoHelper();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public List<FeedCloudEeveeBase.StEeveeAttachInfo> getEeveeAttachInfos()
  {
    try
    {
      if ((this.mEeveeAttachInfos != null) && (this.mEeveeAttachInfos.size() != 0))
      {
        localObject1 = this.mEeveeAttachInfos;
        return localObject1;
      }
      Object localObject1 = new FeedCloudEeveeUndealmsg.FcUndealMsgsRsp();
      if (Proto2JsonUtil.a(SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_eevee_attach_info_sp_key"), (MessageMicro)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("eeveeAttachInfos size = ");
        localStringBuilder.append(((FeedCloudEeveeUndealmsg.FcUndealMsgsRsp)localObject1).attachInfo.size());
        QLog.d("QCircleEeveeAttachInfoHelper", 1, localStringBuilder.toString());
        localObject1 = ((FeedCloudEeveeUndealmsg.FcUndealMsgsRsp)localObject1).attachInfo.get();
        return localObject1;
      }
      localObject1 = new ArrayList();
      return localObject1;
    }
    finally {}
  }
  
  public void setEeveeAttachInfos(List<FeedCloudEeveeBase.StEeveeAttachInfo> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
          this.mEeveeAttachInfos.clear();
          this.mEeveeAttachInfos.addAll(paramList);
          paramList = new FeedCloudEeveeUndealmsg.FcUndealMsgsRsp();
          paramList.attachInfo.set(this.mEeveeAttachInfos);
          SharePreferenceUtils.a(MobileQQ.sMobileQQ.getApplicationContext(), "qcircle_eevee_attach_info_sp_key", Proto2JsonUtil.a(paramList));
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleEeveeAttachInfoHelper
 * JD-Core Version:    0.7.0.1
 */