package dov.com.qq.im.aeeditor.module.autotemplate;

import android.arch.lifecycle.MutableLiveData;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEEditorAutoTemplatePanel$4
  implements View.OnClickListener
{
  AEEditorAutoTemplatePanel$4(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void onClick(View paramView)
  {
    if (AEEditorAutoTemplatePanel.c(this.a))
    {
      AEEditorAutoTemplatePanel.a(this.a).postValue(new AEAutoTemplateRet(5L, null));
      if (AEEditorAutoTemplatePanel.a(this.a) != null) {
        AEEditorAutoTemplatePanel.a(this.a).setImageResource(2130837911);
      }
      if (AEEditorAutoTemplatePanel.a(this.a) != null) {
        AEEditorAutoTemplatePanel.a(this.a).a(-1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.4
 * JD-Core Version:    0.7.0.1
 */