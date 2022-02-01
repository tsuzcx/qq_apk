package com.tencent.mobileqq.werewolves;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.reflect.Method;

class WerewolvesHostInterface$3
  implements ActionSheet.OnButtonClickListener
{
  WerewolvesHostInterface$3(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ReflectUtils.a(this.jdField_a_of_type_JavaLangObject.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHostInterface.3
 * JD-Core Version:    0.7.0.1
 */