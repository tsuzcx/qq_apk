package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import apmh;
import apml;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import java.util.ArrayList;
import org.json.JSONObject;

class RedTouchWebviewHandler$1$1
  implements Runnable
{
  RedTouchWebviewHandler$1$1(RedTouchWebviewHandler.1 param1, String paramString1, JSONObject paramJSONObject, BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    Object localObject = "";
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) {
      localObject = RedTouchWebviewHandler.access$100(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0, this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.buffer.get());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", String.valueOf(this.jdField_a_of_type_Int));
    localBundle.putString("buffer", (String)localObject);
    localBundle.putString("red", String.valueOf(this.jdField_b_of_type_Int));
    localBundle.putStringArrayList("missions", this.jdField_a_of_type_JavaUtilArrayList);
    localBundle.putString("path", this.jdField_b_of_type_JavaLangString);
    localBundle.putString("serial", this.c);
    localBundle.putString("callback", this.jdField_a_of_type_JavaLangString);
    localObject = apml.a("redTouch_getAppInfo_report", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0.mOnRemoteResp.key, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0.sendRemoteReq((Bundle)localObject, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1.1
 * JD-Core Version:    0.7.0.1
 */