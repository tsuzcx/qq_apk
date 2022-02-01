package com.tencent.mobileqq.filemanager.app;

import asfy;
import asga;
import java.util.HashSet;
import java.util.Iterator;

public class QQFavProxy$4
  implements Runnable
{
  public QQFavProxy$4(asfy paramasfy, long paramLong, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = asfy.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((asga)localIterator.next()).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QQFavProxy.4
 * JD-Core Version:    0.7.0.1
 */