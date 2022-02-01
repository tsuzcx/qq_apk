package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.os.Bundle;

class ForwardQFavBatchOption$1
  implements Runnable
{
  ForwardQFavBatchOption$1(ForwardQFavBatchOption paramForwardQFavBatchOption, Bundle paramBundle, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, String paramString4, Intent paramIntent) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("qfavType");
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 6: 
    case 8: 
      ForwardQFavBatchOption.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, i, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      return;
    case 1: 
      ForwardQFavBatchOption.b(this.this$0, this.jdField_a_of_type_AndroidOsBundle, i, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      return;
    case 2: 
      ForwardQFavBatchOption.c(this.this$0, this.jdField_a_of_type_AndroidOsBundle, i, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      return;
    case 7: 
      ForwardQFavBatchOption.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.d, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      return;
    case 5: 
      ForwardQFavBatchOption.a(this.this$0, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_AndroidOsBundle, this.d, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      return;
    }
    ForwardQFavBatchOption.a(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.1
 * JD-Core Version:    0.7.0.1
 */