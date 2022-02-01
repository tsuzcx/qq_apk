package com.tencent.open.downloadnew;

import android.content.Context;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.ArrayList;

class MyAppApi$9
  implements Runnable
{
  MyAppApi$9(MyAppApi paramMyAppApi, Context paramContext, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void run()
  {
    TMAssistantCallYYB_V2.getInstance().startBatchOperation(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.9
 * JD-Core Version:    0.7.0.1
 */