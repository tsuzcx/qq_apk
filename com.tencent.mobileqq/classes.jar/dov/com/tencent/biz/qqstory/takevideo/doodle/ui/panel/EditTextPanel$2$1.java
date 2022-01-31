package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import bmsr;
import bmss;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import mqq.os.MqqHandler;

public class EditTextPanel$2$1
  implements Runnable
{
  public EditTextPanel$2$1(bmss parambmss, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bmss.a.a == null) || (this.jdField_a_of_type_Bmss.a.a.a == null)) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_Bmss.a.a.a.getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = this.jdField_a_of_type_Bmss.a.a.a.getChildAt(i);
        localObject = (bmsr)this.jdField_a_of_type_Bmss.a.a.getChildViewHolder((View)localObject);
        if ((((bmsr)localObject).a.isContainsResUrl(this.jdField_a_of_type_JavaLangString)) && (((bmsr)localObject).a.text_id == this.jdField_a_of_type_Int)) {
          ThreadManager.getUIHandler().post(new EditTextPanel.2.1.1(this, (bmsr)localObject));
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.panel.EditTextPanel.2.1
 * JD-Core Version:    0.7.0.1
 */