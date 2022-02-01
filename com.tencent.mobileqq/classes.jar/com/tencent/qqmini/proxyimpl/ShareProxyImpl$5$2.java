package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import bglp;
import bgpa;
import bjys;
import bjyu;
import com.tencent.mobileqq.widget.QQToast;

public class ShareProxyImpl$5$2
  implements Runnable
{
  public ShareProxyImpl$5$2(bjys parambjys, long paramLong, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Long == -100070004L) || (this.jdField_a_of_type_Long == -1000710003L))
    {
      bglp.a(this.jdField_a_of_type_Bjys.a, 233, this.jdField_a_of_type_Bjys.a.getString(2131718010), this.jdField_a_of_type_JavaLangString, new bjyu(this), null).show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Bjys.a, 1, 2131693704, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5.2
 * JD-Core Version:    0.7.0.1
 */