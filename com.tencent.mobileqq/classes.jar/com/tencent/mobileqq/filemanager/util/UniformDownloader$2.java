package com.tencent.mobileqq.filemanager.util;

import android.os.Bundle;
import apwh;
import apwk;
import java.util.Iterator;
import java.util.List;

public class UniformDownloader$2
  implements Runnable
{
  public UniformDownloader$2(apwh paramapwh, Bundle paramBundle, int paramInt, String paramString) {}
  
  public void run()
  {
    if (apwh.a(this.this$0, false, apwh.b(this.this$0))) {
      this.this$0.a();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putBundle("_CB_USERDATA", apwh.a(this.this$0));
      }
      Iterator localIterator = apwh.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        apwk localapwk = (apwk)localIterator.next();
        if (localapwk != null) {
          localapwk.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloader.2
 * JD-Core Version:    0.7.0.1
 */