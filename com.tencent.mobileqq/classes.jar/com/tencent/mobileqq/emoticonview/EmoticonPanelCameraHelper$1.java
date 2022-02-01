package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmoticonPanelCameraHelper$1
  implements View.OnClickListener
{
  EmoticonPanelCameraHelper$1(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - EmoticonPanelCameraHelper.access$000(this.this$0) > 1000L)
    {
      EmoticonPanelCameraHelper.access$002(this.this$0, l);
      Bundle localBundle = new Bundle();
      localBundle.putInt("AECAMERA_MODE", 202);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.i.a());
      ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAECameraUnit((Activity)((EmoticonPanelController)this.this$0.mPanelController).context, 120, localBundle);
      ReportController.b(this.this$0.app.getAppRuntime(), "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.1
 * JD-Core Version:    0.7.0.1
 */