package dov.com.qq.im.aeeditor.module.clip.video;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.session.TAVCutVideoSession;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;

class AEEditorVideoClipFragment$4
  implements View.OnClickListener
{
  AEEditorVideoClipFragment$4(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().a(1);
    String str1;
    String str2;
    label33:
    String str3;
    if (AEEditorVideoClipFragment.a(this.a))
    {
      str1 = "video_edit_clip_start_time";
      if (!AEEditorVideoClipFragment.a(this.a)) {
        break label220;
      }
      str2 = "video_edit_clip_end_time";
      if (!AEEditorVideoClipFragment.a(this.a)) {
        break label226;
      }
      str3 = "video_edit_clip_speed";
      label47:
      if (AEEditorVideoClipFragment.a(this.a) == null) {
        break label233;
      }
      this.a.getArguments().putLong(str1, AEEditorVideoClipFragment.a(this.a).getStartUs());
      this.a.getArguments().putLong(str2, AEEditorVideoClipFragment.a(this.a).getEndUs());
    }
    for (;;)
    {
      Bundle localBundle = new Bundle(this.a.getArguments());
      localBundle.putString("select_path", AEEditorVideoClipFragment.a(this.a));
      if (this.a.a != null) {
        localBundle.putFloat(str3, this.a.a.floatValue());
      }
      this.a.getArguments().putString("editor_filter_id", "");
      this.a.a().b(this.a.a(), localBundle);
      AEReportUtils.a(1, localBundle.getLong(str2) - localBundle.getLong(str1));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = "starttime";
      break;
      label220:
      str2 = "endtime";
      break label33;
      label226:
      str3 = "speed";
      break label47;
      label233:
      if (AEEditorVideoClipFragment.a(this.a) != null)
      {
        this.a.getArguments().putLong(str1, 0L);
        this.a.getArguments().putLong(str2, Math.min(60000000L, AEEditorVideoClipFragment.a(this.a).getDuration().getTimeUs()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment.4
 * JD-Core Version:    0.7.0.1
 */