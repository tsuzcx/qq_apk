package com.tencent.mobileqq.extendfriend;

import aoey;
import aofa;
import aofe;
import ayrx;
import aysa;
import com.tencent.qphone.base.util.QLog;
import lch;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(aofa paramaofa, aoey paramaoey) {}
  
  public void run()
  {
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_JavaLangString = this.a.b;
    localayrx.jdField_a_of_type_Int = 0;
    String str = aofa.a(this.this$0, this.a.c);
    aofa.a(this.this$0, str);
    localayrx.c = str;
    localayrx.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localayrx.c);
    localayrx.jdField_a_of_type_Aysc = new aofe(this);
    lch.a().a(localayrx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */