package dov.com.qq.im.aeeditor.module.clip.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;

class AEEditorVideoClipFragment$3
  implements View.OnClickListener
{
  AEEditorVideoClipFragment$3(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a().a(this.a.getActivity(), true);
    AEReportUtils.t();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment.3
 * JD-Core Version:    0.7.0.1
 */