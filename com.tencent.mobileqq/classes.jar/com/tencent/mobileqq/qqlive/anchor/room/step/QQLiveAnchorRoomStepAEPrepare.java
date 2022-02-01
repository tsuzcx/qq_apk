package com.tencent.mobileqq.qqlive.anchor.room.step;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;

public class QQLiveAnchorRoomStepAEPrepare
  extends QQLiveAnchorRoomStepBase
  implements IAEDownloadCallBack
{
  private boolean a;
  private boolean b;
  
  private void a()
  {
    boolean bool = FeatureManager.loadBasicFeatures();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[loadAERes] loadSuccess:");
    localStringBuilder.append(bool);
    QLog.d("QQLiveAnchorRoomStepAEPrepare", 4, localStringBuilder.toString());
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramAEResInfo.description.equals("AEBasePackage")) {
      this.a = true;
    }
    if (paramAEResInfo.description.equals("LightBasePackage")) {
      this.b = true;
    }
    if ((this.a) && (this.b)) {
      if (paramInt == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLiveAnchorRoomStepAEPrepare", 4, "[onAEDownloadFinish] success");
        }
      }
      else
      {
        paramAEResInfo = new StringBuilder();
        paramAEResInfo.append("[onAEDownloadFinish] error :");
        paramAEResInfo.append(paramInt);
        QLog.e("QQLiveAnchorRoomStepAEPrepare", 4, paramAEResInfo.toString());
      }
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("[onAEProgressUpdate] currentOffset:");
      paramAEResInfo.append(paramLong1);
      QLog.d("QQLiveAnchorRoomStepAEPrepare", 4, paramAEResInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.step.QQLiveAnchorRoomStepAEPrepare
 * JD-Core Version:    0.7.0.1
 */