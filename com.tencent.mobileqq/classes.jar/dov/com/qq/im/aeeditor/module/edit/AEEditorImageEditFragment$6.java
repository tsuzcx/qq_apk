package dov.com.qq.im.aeeditor.module.edit;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.aeeditor.module.clip.image.AEEditorCropperPanel;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;

class AEEditorImageEditFragment$6
  implements View.OnClickListener
{
  AEEditorImageEditFragment$6(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public void onClick(View paramView)
  {
    AEEditorImageEditFragment.a(this.a).a(AEEditorImageEditFragment.a(this.a), AEEditorImageEditFragment.a(this.a), AEEditorImageEditFragment.a(this.a).getWidth(), AEEditorImageEditFragment.a(this.a).getHeight());
    this.a.a.a();
    AEReportUtils.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.6
 * JD-Core Version:    0.7.0.1
 */