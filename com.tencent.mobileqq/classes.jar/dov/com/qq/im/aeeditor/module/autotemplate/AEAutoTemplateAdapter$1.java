package dov.com.qq.im.aeeditor.module.autotemplate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEAutoTemplateAdapter$1
  implements View.OnClickListener
{
  AEAutoTemplateAdapter$1(AEAutoTemplateAdapter paramAEAutoTemplateAdapter) {}
  
  public void onClick(View paramView)
  {
    if (AEAutoTemplateAdapter.a(this.a) != null) {
      AEAutoTemplateAdapter.a(this.a).c();
    }
    this.a.a(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateAdapter.1
 * JD-Core Version:    0.7.0.1
 */