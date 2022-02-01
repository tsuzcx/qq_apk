package com.tencent.mobileqq.text.style;

import android.content.Context;
import com.tencent.util.Thrower.Action;
import com.tencent.widget.ActionSheet;

final class LinkSpan$3
  implements Thrower.Action<Integer>
{
  LinkSpan$3(Context paramContext, String paramString, ActionSheet paramActionSheet) {}
  
  public void a(Integer paramInteger)
  {
    int i = paramInteger.intValue();
    if (i != 0)
    {
      if (i == 1) {
        LinkSpan.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      LinkSpan.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan.3
 * JD-Core Version:    0.7.0.1
 */