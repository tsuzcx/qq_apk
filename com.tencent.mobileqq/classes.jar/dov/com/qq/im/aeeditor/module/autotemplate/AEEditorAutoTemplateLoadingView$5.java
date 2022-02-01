package dov.com.qq.im.aeeditor.module.autotemplate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorAutoTemplateLoadingView$5
  implements View.OnClickListener
{
  AEEditorAutoTemplateLoadingView$5(AEEditorAutoTemplateLoadingView paramAEEditorAutoTemplateLoadingView) {}
  
  public void onClick(View paramView)
  {
    AEEditorAutoTemplateLoadingView.a(this.a).setVisibility(8);
    if (AEEditorAutoTemplateLoadingView.a(this.a) != null) {
      AEEditorAutoTemplateLoadingView.a(this.a).a();
    }
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView.5
 * JD-Core Version:    0.7.0.1
 */