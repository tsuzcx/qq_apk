package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import axug;
import ayph;
import ayqo;
import bbfj;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(ayph paramayph, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    ayqo localayqo;
    if ((axug.b(this.this$0.jdField_a_of_type_Ayqo.c) != 0) && (!this.this$0.e))
    {
      localayqo = this.this$0.jdField_a_of_type_Ayqo;
      ayph localayph = this.this$0;
      long l = System.nanoTime();
      localayph.k = l;
      localayqo.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, ayph.a(this.this$0), this.this$0.jdField_a_of_type_Ayqo.c, this.jdField_a_of_type_Short, ayph.a(this.this$0), ayph.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, bbfj.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, axug.a(this.this$0.jdField_a_of_type_Ayqo.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localayqo = this.this$0.jdField_a_of_type_Ayqo;
      localayqo.e += axug.a(this.this$0.jdField_a_of_type_Ayqo.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */