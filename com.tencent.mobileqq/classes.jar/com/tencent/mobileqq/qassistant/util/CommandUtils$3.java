package com.tencent.mobileqq.qassistant.util;

import android.app.Activity;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import java.util.ArrayList;
import java.util.List;

final class CommandUtils$3
  implements ShareAppLogHelper.OnGetLocalLogListener
{
  CommandUtils$3(List paramList, Activity paramActivity) {}
  
  public void a(int paramInt)
  {
    CommandUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    if (paramString != null) {
      localArrayList.add(paramString);
    }
    CommandUtils.a(localArrayList, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public void b(int paramInt)
  {
    CommandUtils.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.CommandUtils.3
 * JD-Core Version:    0.7.0.1
 */