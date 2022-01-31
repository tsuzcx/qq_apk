package com.tencent.mobileqq.emosm;

import alks;
import android.text.TextUtils;
import aphs;
import aphz;
import apjf;
import azmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class CameraRoamingStrategy$3
  implements Runnable
{
  public CameraRoamingStrategy$3(aphs paramaphs, List paramList) {}
  
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
        azmj.b(this.this$0.a, "dc00898", "", "", "0X800A372", "0X800A372", 0, 0, "", "", localCameraEmotionData.resid, "");
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
    ((apjf)this.this$0.a.getManager(334)).c();
    ((alks)this.this$0.a.a(160)).a(3, true, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CameraRoamingStrategy.3
 * JD-Core Version:    0.7.0.1
 */