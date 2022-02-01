package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.IDynamicTextResDownloadCallback;
import mqq.os.MqqHandler;

class EditTextPanel$2
  implements DynamicTextConfigManager.IDynamicTextResDownloadCallback
{
  EditTextPanel$2(EditTextPanel paramEditTextPanel) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    this.a.post(new EditTextPanel.2.1(this, paramString, paramInt));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.a.a == null) || (this.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.a.a.a.getChildCount();
      DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)QIMManager.a(7);
      int i = 0;
      while (i < j)
      {
        Object localObject = this.a.a.a.getChildAt(i);
        localObject = (EditTextEffectView.EditTextHolder)this.a.a.getChildViewHolder((View)localObject);
        if (((EditTextEffectView.EditTextHolder)localObject).a.isContainsResUrl(paramString)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.2(this, paramBoolean, (EditTextEffectView.EditTextHolder)localObject, localDynamicTextConfigManager));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2
 * JD-Core Version:    0.7.0.1
 */