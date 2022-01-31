package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import azqa;
import banc;
import baoj;
import bdee;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(banc parambanc, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    baoj localbaoj;
    if ((azqa.b(this.this$0.jdField_a_of_type_Baoj.c) != 0) && (!this.this$0.e))
    {
      localbaoj = this.this$0.jdField_a_of_type_Baoj;
      banc localbanc = this.this$0;
      long l = System.nanoTime();
      localbanc.k = l;
      localbaoj.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, banc.a(this.this$0), this.this$0.jdField_a_of_type_Baoj.c, this.jdField_a_of_type_Short, banc.a(this.this$0), banc.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, bdee.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, azqa.a(this.this$0.jdField_a_of_type_Baoj.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localbaoj = this.this$0.jdField_a_of_type_Baoj;
      localbaoj.e += azqa.a(this.this$0.jdField_a_of_type_Baoj.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */