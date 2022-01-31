package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import artu;
import artx;
import java.util.Iterator;
import java.util.List;

public class UniformDownloader$2
  implements Runnable
{
  public UniformDownloader$2(artu paramartu, Bundle paramBundle, int paramInt, String paramString) {}
  
  public void run()
  {
    if (artu.a(this.this$0, false, artu.b(this.this$0))) {
      this.this$0.a();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putBundle("_CB_USERDATA", artu.a(this.this$0));
      }
      Iterator localIterator = artu.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        artx localartx = (artx)localIterator.next();
        if (localartx != null) {
          localartx.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloader.2
 * JD-Core Version:    0.7.0.1
 */