package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import aoww;
import com.tencent.qphone.base.util.QLog;

public class QFileConfigManager$2
  implements Runnable
{
  public QFileConfigManager$2(aoww paramaoww, Bundle paramBundle) {}
  
  public void run()
  {
    if ((!this.a.containsKey("troop_video_preivew")) || (!this.a.containsKey("troop_video_preivew_for_svip")) || (!this.a.containsKey("troop_video_preivew_for_yearsvip"))) {
      return;
    }
    aoww.a(this.this$0, this.a.getBoolean("troop_video_preivew", false));
    aoww.b(this.this$0, this.a.getBoolean("troop_video_preivew_for_svip", false));
    aoww.c(this.this$0, this.a.getBoolean("troop_video_preivew_for_yearsvip", false));
    QLog.i("QFileConfigManager", 1, "setFileCommonConfig: set common config. enableTroopVidePreview[" + aoww.a(this.this$0) + "] enableTroopVidePreviewForSVIP[" + aoww.b(this.this$0) + "] enableTroopVidePreviewForYearSVIP[" + aoww.c(this.this$0) + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileConfigManager.2
 * JD-Core Version:    0.7.0.1
 */