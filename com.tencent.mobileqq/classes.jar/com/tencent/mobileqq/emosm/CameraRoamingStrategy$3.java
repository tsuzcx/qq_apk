package com.tencent.mobileqq.emosm;

import android.text.TextUtils;
import anrf;
import asct;
import asda;
import aseg;
import bdla;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CameraRoamingStrategy$3
  implements Runnable
{
  public CameraRoamingStrategy$3(asct paramasct, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.a.get(i);
      if (!TextUtils.isEmpty(localCameraEmotionData.resid))
      {
        localCameraEmotionData.RomaingType = "needDel";
        this.this$0.a().b(localCameraEmotionData);
        bdla.b(this.this$0.a, "dc00898", "", "", "0X800A372", "0X800A372", 0, 0, "", "", localCameraEmotionData.resid, "");
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("CameraRoamingStrategy", 2, "delete from local, Roma Type: " + localCameraEmotionData.RomaingType);
        }
        this.this$0.a().a(localCameraEmotionData);
      }
    }
    ((aseg)this.this$0.a.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).c();
    ((anrf)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER)).a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.3
 * JD-Core Version:    0.7.0.1
 */