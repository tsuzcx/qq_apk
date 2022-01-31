package com.tencent.qqmini.sdk.runtime.core.page;

import bgid;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class NativeViewContainer$6
  implements Runnable
{
  NativeViewContainer$6(NativeViewContainer paramNativeViewContainer, int paramInt, JSONObject paramJSONObject1, bgid parambgid, JSONObject paramJSONObject2) {}
  
  public void run()
  {
    try
    {
      this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_OrgJsonJSONObject, this.jdField_a_of_type_Bgid);
      this.jdField_a_of_type_Bgid.a(this.b);
      this.this$0.b(this.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("NativeViewContainer", this.jdField_a_of_type_Bgid.a + " error.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer.6
 * JD-Core Version:    0.7.0.1
 */