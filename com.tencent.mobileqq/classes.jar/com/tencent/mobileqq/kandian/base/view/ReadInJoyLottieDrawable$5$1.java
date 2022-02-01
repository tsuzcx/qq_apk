package com.tencent.mobileqq.kandian.base.view;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import mqq.util.WeakReference;

class ReadInJoyLottieDrawable$5$1
  implements Runnable
{
  ReadInJoyLottieDrawable$5$1(ReadInJoyLottieDrawable.5 param5) {}
  
  public void run()
  {
    if (FileUtils.unzip(this.this$0.jdField_a_of_type_JavaIoFile, this.this$0.b)) {}
    try
    {
      localObject = (ReadInJoyLottieDrawable)this.this$0.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localObject != null) {
        ReadInJoyLottieDrawable.a((ReadInJoyLottieDrawable)localObject, this.this$0.b);
      }
      this.this$0.jdField_a_of_type_JavaIoFile.delete();
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      label61:
      break label61;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(" download lottie resource fail!");
      QLog.e("ReadInJoyLottieDrawable", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable.5.1
 * JD-Core Version:    0.7.0.1
 */