package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import aqll;
import java.lang.ref.WeakReference;

final class TdsReaderGlobal$RunnableImpl
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final WeakReference<TdsReaderGlobal> jdField_a_of_type_JavaLangRefWeakReference;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  private TdsReaderGlobal$RunnableImpl(TdsReaderGlobal paramTdsReaderGlobal, int paramInt, Object... paramVarArgs)
  {
    if (paramTdsReaderGlobal == null) {}
    for (paramTdsReaderGlobal = null;; paramTdsReaderGlobal = new WeakReference(paramTdsReaderGlobal))
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = paramTdsReaderGlobal;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
      return;
    }
  }
  
  public void run()
  {
    TdsReaderGlobal localTdsReaderGlobal;
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      localTdsReaderGlobal = null;
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          localTdsReaderGlobal = (TdsReaderGlobal)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          break;
          aqll.a();
          return;
        } while (localTdsReaderGlobal == null);
        TdsReaderGlobal.a(localTdsReaderGlobal, this.jdField_a_of_type_ArrayOfJavaLangObject);
        return;
      } while (localTdsReaderGlobal == null);
      TdsReaderGlobal.b(localTdsReaderGlobal, this.jdField_a_of_type_ArrayOfJavaLangObject);
      return;
    } while (localTdsReaderGlobal == null);
    TdsReaderGlobal.c(localTdsReaderGlobal, this.jdField_a_of_type_ArrayOfJavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.RunnableImpl
 * JD-Core Version:    0.7.0.1
 */