package com.tencent.mobileqq.forward;

import android.os.Bundle;

class ForwardQFavBatchOption$2
  implements Runnable
{
  ForwardQFavBatchOption$2(ForwardQFavBatchOption paramForwardQFavBatchOption, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("qfavType") != 3) {
      return;
    }
    ForwardQFavBatchOption.b(this.this$0, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardQFavBatchOption.2
 * JD-Core Version:    0.7.0.1
 */