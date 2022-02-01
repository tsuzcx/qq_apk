package com.tencent.mobileqq.kandian.base.view;

import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class ReadInJoyLottieDrawable$4
  implements Runnable
{
  ReadInJoyLottieDrawable$4(ReadInJoyLottieDrawable paramReadInJoyLottieDrawable, File[] paramArrayOfFile, File paramFile, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      LottieComposition.Factory.fromInputStream(BaseApplication.getContext(), new FileInputStream(this.jdField_a_of_type_ArrayOfJavaIoFile[0]), new ReadInJoyLottieDrawable.4.1(this));
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyLottieDrawable", 2, "loadFromFile", localFileNotFoundException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.4
 * JD-Core Version:    0.7.0.1
 */