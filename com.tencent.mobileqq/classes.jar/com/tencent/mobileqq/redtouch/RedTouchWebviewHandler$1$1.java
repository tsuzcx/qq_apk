package com.tencent.mobileqq.redtouch;

import android.os.Bundle;
import ascz;
import asdd;
import java.util.HashMap;

class RedTouchWebviewHandler$1$1
  implements Runnable
{
  RedTouchWebviewHandler$1$1(RedTouchWebviewHandler.1 param1, HashMap paramHashMap) {}
  
  public void run()
  {
    Object localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get("callbackId");
    Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilHashMap.get("req");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("jsonResult");
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0.callJs((String)localObject, new String[] { str });
    localObject = asdd.a("redTouch_getAppInfo_report", (String)localObject, this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0.mOnRemoteResp.key, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchWebviewHandler$1.this$0.sendRemoteReq((Bundle)localObject, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler.1.1
 * JD-Core Version:    0.7.0.1
 */