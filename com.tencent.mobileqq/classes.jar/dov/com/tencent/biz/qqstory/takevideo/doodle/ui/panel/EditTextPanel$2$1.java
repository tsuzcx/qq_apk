package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import bqqe;
import bqqf;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import mqq.os.MqqHandler;

public class EditTextPanel$2$1
  implements Runnable
{
  public EditTextPanel$2$1(bqqf parambqqf, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bqqf.a.a == null) || (this.jdField_a_of_type_Bqqf.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_Bqqf.a.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_Bqqf.a.a.a.getChildAt(i);
        localObject = (bqqe)this.jdField_a_of_type_Bqqf.a.a.getChildViewHolder((View)localObject);
        if ((((bqqe)localObject).a.isContainsResUrl(this.jdField_a_of_type_JavaLangString)) && (((bqqe)localObject).a.text_id == this.jdField_a_of_type_Int)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.1.1(this, (bqqe)localObject));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.1
 * JD-Core Version:    0.7.0.1
 */