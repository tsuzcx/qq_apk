package com.tencent.mobileqq.extendfriend;

import aoet;
import aoev;
import aoez;
import ayrv;
import ayry;
import com.tencent.qphone.base.util.QLog;
import lcm;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(aoev paramaoev, aoet paramaoet) {}
  
  public void run()
  {
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_JavaLangString = this.a.b;
    localayrv.jdField_a_of_type_Int = 0;
    String str = aoev.a(this.this$0, this.a.c);
    aoev.a(this.this$0, str);
    localayrv.c = str;
    localayrv.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localayrv.c);
    localayrv.jdField_a_of_type_Aysa = new aoez(this);
    lcm.a().a(localayrv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */