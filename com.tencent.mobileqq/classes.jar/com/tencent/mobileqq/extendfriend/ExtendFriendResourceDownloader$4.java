package com.tencent.mobileqq.extendfriend;

import aqbk;
import aqbm;
import aqbq;
import baub;
import baue;
import com.tencent.qphone.base.util.QLog;
import lel;

public class ExtendFriendResourceDownloader$4
  implements Runnable
{
  public ExtendFriendResourceDownloader$4(aqbm paramaqbm, aqbk paramaqbk) {}
  
  public void run()
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_JavaLangString = this.a.b;
    localbaub.jdField_a_of_type_Int = 0;
    String str = aqbm.a(this.this$0, this.a.c);
    aqbm.a(this.this$0, str);
    localbaub.c = str;
    localbaub.a(this.a);
    QLog.d("ExtendFriendResourceDownloader", 2, "Limitchatres start download : " + this.a.jdField_a_of_type_JavaLangString + " url: " + this.a.b + " w:" + localbaub.c);
    localbaub.jdField_a_of_type_Baug = new aqbq(this);
    lel.a().a(localbaub);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendResourceDownloader.4
 * JD-Core Version:    0.7.0.1
 */