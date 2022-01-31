package com.tencent.qqmini.sdk.runtime.core.page;

import bgmk;
import org.json.JSONObject;

class NativeViewContainer$10
  implements Runnable
{
  NativeViewContainer$10(NativeViewContainer paramNativeViewContainer, JSONObject paramJSONObject1, int paramInt1, int paramInt2, JSONObject paramJSONObject2, String paramString, bgmk parambgmk, JSONObject paramJSONObject3) {}
  
  public void run()
  {
    Boolean localBoolean = null;
    if (this.jdField_a_of_type_OrgJsonJSONObject.opt("disableScroll") != null) {
      localBoolean = Boolean.valueOf(this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("disableScroll"));
    }
    this.this$0.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_OrgJsonJSONObject, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("hide"), this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("useHardwareAccelerate"), localBoolean, this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("gesture"));
    this.jdField_a_of_type_Bgmk.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.core.page.NativeViewContainer.10
 * JD-Core Version:    0.7.0.1
 */