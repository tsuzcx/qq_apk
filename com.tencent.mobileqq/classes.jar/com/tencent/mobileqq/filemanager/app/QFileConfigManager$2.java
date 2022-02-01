package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import atix;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$2
  implements Runnable
{
  public QFileConfigManager$2(atix paramatix, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.a.containsKey("troop_video_preivew")) || (!this.a.containsKey("troop_video_preivew_for_svip")) || (!this.a.containsKey("troop_video_preivew_for_yearsvip")) || (!this.a.containsKey("enable_file_media_platform"))) {
      return;
    }
    atix.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
    atix.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
    atix.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
    atix.d(this.this$0, this.a.getBoolean("enable_file_media_platform", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + atix.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + atix.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + atix.c(this.this$0) + "] UseMediaPlatform enabled[" + atix.d(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */