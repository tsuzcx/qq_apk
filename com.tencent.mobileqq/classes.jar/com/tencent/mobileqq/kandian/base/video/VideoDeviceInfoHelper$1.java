package com.tencent.mobileqq.kandian.base.video;

import com.tencent.mobileqq.vip.TMSManager.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class VideoDeviceInfoHelper$1
  implements TMSManager.Callback
{
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = VideoDeviceInfoHelper.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryKingCardType()#callback postQuery, sucess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isKingCard=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" product=");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject1, 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      VideoDeviceInfoHelper.a(paramInt);
      try
      {
        localObject1 = VideoDeviceInfoHelper.a();
        if (localObject1 != null)
        {
          try
          {
            VideoDeviceInfoHelper.a().put("simCardType", VideoDeviceInfoHelper.a());
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(VideoDeviceInfoHelper.a, 2, "queryKingCardType()#callback postQuery, update json error ", localJSONException);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(VideoDeviceInfoHelper.a, 2, "queryKingCardType()#callback postQuery, update jsonStr ");
          }
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */