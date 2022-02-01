package com.tencent.mobileqq.filemanageraux.util;

import android.os.Bundle;
import aucp;
import aucs;
import java.util.Iterator;
import java.util.List;

public class UniformDownloader$2
  implements Runnable
{
  public UniformDownloader$2(aucp paramaucp, Bundle paramBundle, int paramInt, String paramString) {}
  
  public void run()
  {
    if (aucp.a(this.this$0, false, aucp.b(this.this$0))) {
      this.this$0.a();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_AndroidOsBundle.putBundle("_CB_USERDATA", aucp.a(this.this$0));
      }
      Iterator localIterator = aucp.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        aucs localaucs = (aucs)localIterator.next();
        if (localaucs != null) {
          localaucs.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.util.UniformDownloader.2
 * JD-Core Version:    0.7.0.1
 */