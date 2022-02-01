package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import bdoc;
import berv;
import bete;
import bhnv;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class BuddyTransfileProcessor$2
  implements Runnable
{
  public BuddyTransfileProcessor$2(berv paramberv, String paramString, short paramShort, long paramLong, Bundle paramBundle, boolean paramBoolean) {}
  
  public void run()
  {
    bete localbete;
    if ((bdoc.b(this.this$0.jdField_a_of_type_Bete.c) != 0) && (!this.this$0.e))
    {
      localbete = this.this$0.jdField_a_of_type_Bete;
      berv localberv = this.this$0;
      long l = System.nanoTime();
      localberv.k = l;
      localbete.g = l;
      this.this$0.e = true;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, berv.a(this.this$0), this.this$0.jdField_a_of_type_Bete.c, this.jdField_a_of_type_Short, berv.a(this.this$0), berv.a(this.this$0), this.this$0.r, this.this$0.s, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidOsBundle);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, bhnv.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, bdoc.a(this.this$0.jdField_a_of_type_Bete.c, this.jdField_a_of_type_Short));
    if (!this.jdField_a_of_type_Boolean)
    {
      localbete = this.this$0.jdField_a_of_type_Bete;
      localbete.e += bdoc.a(this.this$0.jdField_a_of_type_Bete.c, this.jdField_a_of_type_Short);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2
 * JD-Core Version:    0.7.0.1
 */