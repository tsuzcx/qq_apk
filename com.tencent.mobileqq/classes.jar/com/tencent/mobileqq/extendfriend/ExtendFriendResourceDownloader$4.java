package com.tencent.mobileqq.extendfriend;

import anoi;
import anok;
import anoo;
import axro;
import axrr;
import com.tencent.qphone.base.util.QLog;
import kry;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(anok paramanok, anoi paramanoi) {}
  
  public void run()
  {
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_JavaLangString = this.a.b;
    localaxro.jdField_a_of_type_Int = 0;
    String str = anok.a(this.this$0, this.a.c);
    anok.a(this.this$0, str);
    localaxro.c = str;
    localaxro.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localaxro.c);
    localaxro.jdField_a_of_type_Axrt = new anoo(this);
    kry.a().a(localaxro);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */