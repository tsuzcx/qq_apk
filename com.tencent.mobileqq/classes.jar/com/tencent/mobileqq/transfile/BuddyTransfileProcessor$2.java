package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import awuc;
import axoy;
import axqf;
import badq;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(axoy paramaxoy, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    axqf localaxqf;
    if ((awuc.b(this.this$0.jdField_a_of_type_Axqf.c) != 0) && (!this.this$0.e))
    {
      localaxqf = this.this$0.jdField_a_of_type_Axqf;
      axoy localaxoy = this.this$0;
      long l = System.nanoTime();
      localaxoy.k = l;
      localaxqf.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, axoy.a(this.this$0), this.this$0.jdField_a_of_type_Axqf.c, this.jdField_a_of_type_Short, axoy.a(this.this$0), axoy.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, badq.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, awuc.a(this.this$0.jdField_a_of_type_Axqf.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localaxqf = this.this$0.jdField_a_of_type_Axqf;
      localaxqf.e += awuc.a(this.this$0.jdField_a_of_type_Axqf.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */