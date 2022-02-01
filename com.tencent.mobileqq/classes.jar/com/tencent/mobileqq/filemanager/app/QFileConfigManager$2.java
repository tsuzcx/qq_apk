package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class QFileConfigManager$2
  implements Runnable
{
  QFileConfigManager$2(QFileConfigManager paramQFileConfigManager, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.a.containsKey("troop_video_preivew")) || (!this.a.containsKey("troop_video_preivew_for_svip")) || (!this.a.containsKey("troop_video_preivew_for_yearsvip")) || (!this.a.containsKey("enable_file_media_platform"))) {
      return;
    }
    QFileConfigManager.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
    QFileConfigManager.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
    QFileConfigManager.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
    QFileConfigManager.d(this.this$0, this.a.getBoolean("enable_file_media_platform", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + QFileConfigManager.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + QFileConfigManager.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + QFileConfigManager.c(this.this$0) + "] UseMediaPlatform enabled[" + QFileConfigManager.d(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */