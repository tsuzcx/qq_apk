package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import bcvj;
import bdtd;
import bduk;
import bgnt;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(bdtd parambdtd, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    bduk localbduk;
    if ((bcvj.b(this.this$0.jdField_a_of_type_Bduk.c) != 0) && (!this.this$0.e))
    {
      localbduk = this.this$0.jdField_a_of_type_Bduk;
      bdtd localbdtd = this.this$0;
      long l = System.nanoTime();
      localbdtd.k = l;
      localbduk.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, bdtd.a(this.this$0), this.this$0.jdField_a_of_type_Bduk.c, this.jdField_a_of_type_Short, bdtd.a(this.this$0), bdtd.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, bgnt.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, bcvj.a(this.this$0.jdField_a_of_type_Bduk.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localbduk = this.this$0.jdField_a_of_type_Bduk;
      localbduk.e += bcvj.a(this.this$0.jdField_a_of_type_Bduk.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */