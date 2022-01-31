package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import apjk;
import apjm;
import com.tencent.kwstudio.office.preview.TdsReaderView;

class SimpleFileViewer$8
  implements Runnable
{
  SimpleFileViewer$8(SimpleFileViewer paramSimpleFileViewer, String paramString, apjm paramapjm) {}
  
  public void run()
  {
    TdsReaderView localTdsReaderView = apjk.a().a(this.this$0.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Apjm);
    if ((SimpleFileViewer.a(this.this$0) != null) && (SimpleFileViewer.a(this.this$0, SimpleFileViewer.a(this.this$0), localTdsReaderView, false))) {
      SimpleFileViewer.a(this.this$0, localTdsReaderView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.8
 * JD-Core Version:    0.7.0.1
 */