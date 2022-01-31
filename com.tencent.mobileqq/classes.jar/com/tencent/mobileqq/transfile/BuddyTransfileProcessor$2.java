package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import axue;
import aypf;
import ayqm;
import bbev;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(aypf paramaypf, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    ayqm localayqm;
    if ((axue.b(this.this$0.jdField_a_of_type_Ayqm.c) != 0) && (!this.this$0.e))
    {
      localayqm = this.this$0.jdField_a_of_type_Ayqm;
      aypf localaypf = this.this$0;
      long l = System.nanoTime();
      localaypf.k = l;
      localayqm.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, aypf.a(this.this$0), this.this$0.jdField_a_of_type_Ayqm.c, this.jdField_a_of_type_Short, aypf.a(this.this$0), aypf.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, bbev.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, axue.a(this.this$0.jdField_a_of_type_Ayqm.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localayqm = this.this$0.jdField_a_of_type_Ayqm;
      localayqm.e += axue.a(this.this$0.jdField_a_of_type_Ayqm.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */