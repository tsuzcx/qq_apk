package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import audj;
import audo;
import com.tencent.tbs.reader.TbsReaderView;

class SimpleFileViewer$6
  implements Runnable
{
  SimpleFileViewer$6(SimpleFileViewer paramSimpleFileViewer, String paramString, audo paramaudo) {}
  
  public void run()
  {
    TbsReaderView localTbsReaderView = audj.a().a(this.this$0.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Audo);
    if ((SimpleFileViewer.a(this.this$0) != null) && (SimpleFileViewer.a(this.this$0, SimpleFileViewer.a(this.this$0), localTbsReaderView, true))) {
      SimpleFileViewer.a(this.this$0, localTbsReaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.6
 * JD-Core Version:    0.7.0.1
 */