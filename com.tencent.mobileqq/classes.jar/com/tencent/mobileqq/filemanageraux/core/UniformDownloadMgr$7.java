package com.tencent.mobileqq.filemanageraux.core;

import android.os.Bundle;
import atdm;

public class UniformDownloadMgr$7
  implements Runnable
{
  public UniformDownloadMgr$7(atdm paramatdm, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = this.this$0.a(this.jdField_a_of_type_JavaLangString, 4);
    this.jdField_a_of_type_AndroidOsBundle.putLong("_filesize_from_dlg", l);
    atdm.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle);
    atdm.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.UniformDownloadMgr.7
 * JD-Core Version:    0.7.0.1
 */