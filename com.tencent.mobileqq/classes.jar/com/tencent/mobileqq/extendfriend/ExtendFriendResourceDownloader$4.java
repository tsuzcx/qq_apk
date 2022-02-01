package com.tencent.mobileqq.extendfriend;

import asge;
import asgg;
import asgk;
import bdvs;
import bdvu;
import com.tencent.qphone.base.util.QLog;
import lbd;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(asgg paramasgg, asge paramasge) {}
  
  public void run()
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_JavaLangString = this.a.b;
    localbdvs.jdField_a_of_type_Int = 0;
    String str = asgg.a(this.this$0, this.a.c);
    asgg.a(this.this$0, str);
    localbdvs.c = str;
    localbdvs.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localbdvs.c);
    localbdvs.jdField_a_of_type_Bdvw = new asgk(this);
    lbd.a().a(localbdvs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */