package com.tencent.mobileqq.emoticonview;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.entry.AECameraLauncher;

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
      AECameraLauncher.a((BaseActivity)this.this$0.mPanelController.context, 120, localBundle);
      ReportController.b(((BaseActivity)this.this$0.mPanelController.context).app, "dc00898", "", "", "0X800A36E", "0X800A36E", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.1
 * JD-Core Version:    0.7.0.1
 */