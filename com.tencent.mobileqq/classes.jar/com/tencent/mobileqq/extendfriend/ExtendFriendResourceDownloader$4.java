package com.tencent.mobileqq.extendfriend;

import asvs;
import asvu;
import asvy;
import beum;
import beuo;
import com.tencent.qphone.base.util.QLog;
import lbk;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(asvu paramasvu, asvs paramasvs) {}
  
  public void run()
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_JavaLangString = this.a.b;
    localbeum.jdField_a_of_type_Int = 0;
    String str = asvu.a(this.this$0, this.a.c);
    asvu.a(this.this$0, str);
    localbeum.c = str;
    localbeum.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localbeum.c);
    localbeum.jdField_a_of_type_Beuq = new asvy(this);
    lbk.a().a(localbeum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */