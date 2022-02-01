package com.tencent.mobileqq.emosm;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CameraRoamingStrategy$3
  implements Runnable
{
  CameraRoamingStrategy$3(CameraRoamingStrategy paramCameraRoamingStrategy, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.size())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.a.get(i);
      if (!TextUtils.isEmpty(localCameraEmotionData.resid))
      {
        localCameraEmotionData.RomaingType = "needDel";
        this.this$0.n().updateCustomEmotion(localCameraEmotionData);
        ReportController.b(this.this$0.a, "dc00898", "", "", "0X800A372", "0X800A372", 0, 0, "", "", localCameraEmotionData.resid, "");
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delete from local, Roma Type: ");
          localStringBuilder.append(localCameraEmotionData.RomaingType);
          QLog.d("CameraRoamingStrategy", 2, localStringBuilder.toString());
        }
        this.this$0.n().deleteCustomEmotion(localCameraEmotionData);
      }
      i += 1;
    }
    ((ICameraEmoRoamingManagerService)this.this$0.a.getRuntimeService(ICameraEmoRoamingManagerService.class)).syncLocalDel();
    ((CameraEmoRoamingHandler)this.this$0.a.getBusinessHandler(CameraEmoRoamingHandler.a)).a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.3
 * JD-Core Version:    0.7.0.1
 */