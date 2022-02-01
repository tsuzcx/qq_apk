package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import aser;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$2
  implements Runnable
{
  public QFileConfigManager$2(aser paramaser, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.a.containsKey("troop_video_preivew")) || (!this.a.containsKey("troop_video_preivew_for_svip")) || (!this.a.containsKey("troop_video_preivew_for_yearsvip")) || (!this.a.containsKey("enable_file_media_platform"))) {
      return;
    }
    aser.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
    aser.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
    aser.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
    aser.d(this.this$0, this.a.getBoolean("enable_file_media_platform", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + aser.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + aser.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + aser.c(this.this$0) + "] UseMediaPlatform enabled[" + aser.d(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */