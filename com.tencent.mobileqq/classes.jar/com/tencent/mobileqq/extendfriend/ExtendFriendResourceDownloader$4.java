package com.tencent.mobileqq.extendfriend;

import apxb;
import apxd;
import apxh;
import baps;
import bapv;
import com.tencent.qphone.base.util.QLog;
import lel;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(apxd paramapxd, apxb paramapxb) {}
  
  public void run()
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_JavaLangString = this.a.b;
    localbaps.jdField_a_of_type_Int = 0;
    String str = apxd.a(this.this$0, this.a.c);
    apxd.a(this.this$0, str);
    localbaps.c = str;
    localbaps.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localbaps.c);
    localbaps.jdField_a_of_type_Bapx = new apxh(this);
    lel.a().a(localbaps);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */