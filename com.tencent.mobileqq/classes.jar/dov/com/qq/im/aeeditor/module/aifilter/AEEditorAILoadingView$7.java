package dov.com.qq.im.aeeditor.module.aifilter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorAILoadingView$7
  implements View.OnClickListener
{
  AEEditorAILoadingView$7(AEEditorAILoadingView paramAEEditorAILoadingView) {}
  
  public void onClick(View paramView)
  {
    AEEditorAILoadingView.a(this.a).setVisibility(8);
    if (AEEditorAILoadingView.a(this.a) != null) {
      AEEditorAILoadingView.a(this.a).a();
    }
    ((ViewGroup)this.a.getParent()).removeAllViews();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView.7
 * JD-Core Version:    0.7.0.1
 */