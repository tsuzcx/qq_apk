package com.tencent.mobileqq.shortvideo.util.videoconverter;

import android.annotation.TargetApi;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(18)
class JBMR2VideoConverterImpl
  implements VideoConverter.VideoConverterImpl
{
  private WeakReference<Thread> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public boolean cancel()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Thread localThread = (Thread)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localThread != null) {
        localThread.interrupt();
      }
    }
    return true;
  }
  
  public boolean start(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      paramFile = new Thread(new JBMR2VideoConverterImpl.Converter(this, paramFile, paramProcessor), "VideoConvert");
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFile);
      paramFile.start();
      if (paramBoolean) {}
      try
      {
        paramFile.join();
        return true;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
        return true;
      }
    }
    return false;
  }
  
  public boolean stop()
  {
    if ((this.jdField_a_of_type_Boolean) && (!this.b))
    {
      this.b = true;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.videoconverter.JBMR2VideoConverterImpl
 * JD-Core Version:    0.7.0.1
 */