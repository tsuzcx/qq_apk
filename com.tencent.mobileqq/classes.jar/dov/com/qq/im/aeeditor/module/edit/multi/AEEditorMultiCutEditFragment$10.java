package dov.com.qq.im.aeeditor.module.edit.multi;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.MediaModel;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;
import dov.com.qq.im.aeeditor.module.edit.multi.data.SpeedFloatUtil;
import dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView;
import java.util.ArrayList;
import java.util.List;

class AEEditorMultiCutEditFragment$10
  implements View.OnClickListener
{
  AEEditorMultiCutEditFragment$10(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    long l = this.a.a.a();
    AEBaseDataReporter.a().a(l / 1000L, AEEditorMultiCutEditFragment.a(this.a).size(), SpeedFloatUtil.a(AEEditorMultiCutEditFragment.a(this.a)));
    if (l < 2000L)
    {
      QQToast.a(this.a.getActivity(), 2131689727, 0).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.a.getArguments().putString("editor_filter_id", "");
    String str1;
    if (AEEditorMultiCutEditFragment.b(this.a))
    {
      str1 = "video_edit_clip_start_time";
      label107:
      if (!AEEditorMultiCutEditFragment.b(this.a)) {
        break label317;
      }
    }
    label317:
    for (String str2 = "video_edit_clip_end_time";; str2 = "endtime")
    {
      this.a.getArguments().putLong(str1, 0L);
      this.a.getArguments().putLong(str2, Math.min(60000000L, AEEditorMultiCutEditFragment.a(this.a).getDuration().getTimeUs()));
      if ((AEEditorMultiCutEditFragment.a(this.a) != null) && (AEEditorMultiCutEditFragment.a(this.a).getMediaModel() != null)) {
        this.a.getArguments().putSerializable("resource_model", AEEditorMultiCutEditFragment.a(this.a).getMediaModel().getMediaResourceModel());
      }
      if (AEEditorMultiCutEditFragment.a(this.a) != null)
      {
        this.a.getArguments().putSerializable("resource_aealbummediabasemodel", AEEditorMultiCutEditFragment.a(this.a));
        i = AEEditorMultiCutEditFragment.a(this.a).size();
      }
      Bundle localBundle = new Bundle(this.a.getArguments());
      this.a.a().c(this.a.a(), localBundle);
      AEReportUtils.a(i, localBundle.getLong(str2) - localBundle.getLong(str1));
      break;
      str1 = "starttime";
      break label107;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.10
 * JD-Core Version:    0.7.0.1
 */