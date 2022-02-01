package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFileConfigManager$2
  implements Runnable
{
  QFileConfigManager$2(QFileConfigManager paramQFileConfigManager, Bundle paramBundle) {}
  
  public void run()
  {
    if ((this.a.containsKey("troop_video_preivew")) && (this.a.containsKey("troop_video_preivew_for_svip")) && (this.a.containsKey("troop_video_preivew_for_yearsvip")))
    {
      if (!this.a.containsKey("enable_file_media_platform")) {
        return;
      }
      QFileConfigManager.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
      QFileConfigManager.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
      QFileConfigManager.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
      QFileConfigManager.d(this.this$0, this.a.getBoolean("enable_file_media_platform", false));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFileCommonConfig: set common config. enableTroopVidePreview[");
      localStringBuilder.append(QFileConfigManager.a(this.this$0));
      localStringBuilder.append("] enableTroopVidePreviewForSVIP[");
      localStringBuilder.append(QFileConfigManager.b(this.this$0));
      localStringBuilder.append("] enableTroopVidePreviewForYearSVIP[");
      localStringBuilder.append(QFileConfigManager.c(this.this$0));
      localStringBuilder.append("] UseMediaPlatform enabled[");
      localStringBuilder.append(QFileConfigManager.d(this.this$0));
      localStringBuilder.append("]");
      QLog.i("QFileConfigManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */