package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import aqud;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$2
  implements Runnable
{
  public QFileConfigManager$2(aqud paramaqud, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.a.containsKey("troop_video_preivew")) || (!this.a.containsKey("troop_video_preivew_for_svip")) || (!this.a.containsKey("troop_video_preivew_for_yearsvip"))) {
      return;
    }
    aqud.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
    aqud.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
    aqud.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + aqud.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + aqud.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + aqud.c(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */