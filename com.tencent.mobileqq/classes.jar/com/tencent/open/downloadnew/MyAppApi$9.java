package com.tencent.open.downloadnew;

import android.content.Context;
import bdlr;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import java.util.ArrayList;

public class MyAppApi$9
  implements Runnable
{
  public MyAppApi$9(bdlr parambdlr, Context paramContext, ArrayList paramArrayList, int paramInt, String paramString) {}
  
  public void run()
  {
    TMAssistantCallYYB_V2.getInstance().startBatchOperation(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.9
 * JD-Core Version:    0.7.0.1
 */