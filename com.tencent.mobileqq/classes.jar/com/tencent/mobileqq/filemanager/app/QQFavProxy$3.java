package com.tencent.mobileqq.filemanager.app;

import atto;
import attq;
import java.util.HashSet;
import java.util.Iterator;

public class QQFavProxy$3
  implements Runnable
{
  public QQFavProxy$3(atto paramatto, long paramLong, int paramInt, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = atto.a(this.this$0).iterator();
    while (localIterator.hasNext()) {
      ((attq)localIterator.next()).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QQFavProxy.3
 * JD-Core Version:    0.7.0.1
 */