package com.tencent.mobileqq.filemanageraux.fileviewer.FileView;

import com.tencent.mobileqq.config.business.tendoc.tds.TdsReaderConfigProcessor;
import java.lang.ref.WeakReference;

final class TdsReaderGlobal$RunnableImpl
  implements Runnable
{
  private final int jdField_a_of_type_Int;
  private final WeakReference<TdsReaderGlobal> jdField_a_of_type_JavaLangRefWeakReference;
  private final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  
  private TdsReaderGlobal$RunnableImpl(TdsReaderGlobal paramTdsReaderGlobal, int paramInt, Object... paramVarArgs)
  {
    if (paramTdsReaderGlobal == null) {
      paramTdsReaderGlobal = null;
    } else {
      paramTdsReaderGlobal = new WeakReference(paramTdsReaderGlobal);
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = paramTdsReaderGlobal;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangObject = paramVarArgs;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (TdsReaderGlobal)((WeakReference)localObject).get();
    }
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (localObject != null) {
            TdsReaderGlobal.c((TdsReaderGlobal)localObject, this.jdField_a_of_type_ArrayOfJavaLangObject);
          }
        }
        else if (localObject != null)
        {
          TdsReaderGlobal.b((TdsReaderGlobal)localObject, this.jdField_a_of_type_ArrayOfJavaLangObject);
        }
      }
      else if (localObject != null) {
        TdsReaderGlobal.a((TdsReaderGlobal)localObject, this.jdField_a_of_type_ArrayOfJavaLangObject);
      }
    }
    else {
      TdsReaderConfigProcessor.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal.RunnableImpl
 * JD-Core Version:    0.7.0.1
 */