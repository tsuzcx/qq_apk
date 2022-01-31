package com.tencent.open.downloadnew;

import bdht;
import bdia;
import bdlc;
import bdlg;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

public class MyAppApi$15$2
  implements Runnable
{
  public MyAppApi$15$2(bdlg parambdlg) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_Bdia.a();
    if (this.a.jdField_a_of_type_Bdlc.a != null)
    {
      if (this.a.jdField_a_of_type_Bdlc.a() <= 2) {
        ((TMAssistantCallYYB_V1)this.a.jdField_a_of_type_Bdlc.a()).startToAuthorized(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Bdlc.a, "2");
      }
      for (;;)
      {
        this.a.jdField_a_of_type_Bdlc.a = null;
        return;
        ((TMAssistantCallYYB_V2)this.a.jdField_a_of_type_Bdlc.a()).startToAuthorized(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Bdlc.a, "2");
      }
    }
    bdht.e("MyAppApi", "startToAuthorizedDirect->onGetA1Fail mLastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.15.2
 * JD-Core Version:    0.7.0.1
 */