package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import aofy;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$2
  implements Runnable
{
  public QFileConfigManager$2(aofy paramaofy, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.a.containsKey("troop_video_preivew")) || (!this.a.containsKey("troop_video_preivew_for_svip")) || (!this.a.containsKey("troop_video_preivew_for_yearsvip"))) {
      return;
    }
    aofy.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
    aofy.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
    aofy.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + aofy.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + aofy.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + aofy.c(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */