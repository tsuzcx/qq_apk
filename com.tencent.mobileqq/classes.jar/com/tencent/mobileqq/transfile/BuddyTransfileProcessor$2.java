package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import azuj;
import barl;
import bass;
import bdin;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(barl parambarl, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    bass localbass;
    if ((azuj.b(this.this$0.jdField_a_of_type_Bass.c) != 0) && (!this.this$0.e))
    {
      localbass = this.this$0.jdField_a_of_type_Bass;
      barl localbarl = this.this$0;
      long l = System.nanoTime();
      localbarl.k = l;
      localbass.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, barl.a(this.this$0), this.this$0.jdField_a_of_type_Bass.c, this.jdField_a_of_type_Short, barl.a(this.this$0), barl.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, bdin.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, azuj.a(this.this$0.jdField_a_of_type_Bass.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localbass = this.this$0.jdField_a_of_type_Bass;
      localbass.e += azuj.a(this.this$0.jdField_a_of_type_Bass.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */