package com.tencent.mobileqq.util;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;

class ImageWorker$BitmapWorkerTask
  extends AsyncTask<Object, Void, Drawable>
{
  private Object jdField_a_of_type_JavaLangObject;
  private final WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  private View a()
  {
    View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!this.jdField_a_of_type_Boolean) {
      return localView;
    }
    if (this == ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker, localView)) {
      return localView;
    }
    return null;
  }
  
  protected Drawable a(Object... paramVarArgs)
  {
    this.jdField_a_of_type_JavaLangObject = paramVarArgs[0];
    String str = String.valueOf(this.jdField_a_of_type_JavaLangObject);
    ImageCreator localImageCreator = (ImageCreator)paramVarArgs[1];
    this.jdField_a_of_type_Boolean = ((Boolean)paramVarArgs[2]).booleanValue();
    if ((ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker) != null) && (!isCancelled()) && (a() != null)) {
      ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker);
    }
    if ((!isCancelled()) && (a() != null) && (!ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker))) {}
    try
    {
      paramVarArgs = localImageCreator.a();
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label101:
      break label101;
    }
    if (ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker) != null) {
      ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).a();
    }
    System.gc();
    Thread.yield();
    try
    {
      paramVarArgs = localImageCreator.a();
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      label137:
      break label137;
    }
    QLog.w("ImageWorker", 2, "OutOfMemoryError!!!!!");
    paramVarArgs = null;
    if ((ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker) != null) && (paramVarArgs != null)) {
      ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).a(str, paramVarArgs);
    }
    return paramVarArgs;
  }
  
  protected void a(Drawable paramDrawable)
  {
    View localView = a();
    ImageWorker.Tag localTag = (ImageWorker.Tag)ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker).remove(localView);
    if ((isCancelled()) || (ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker))) {
      paramDrawable = null;
    }
    if (localView != null) {
      if (paramDrawable == null)
      {
        if ((localTag != null) && (localTag.a != null)) {
          localTag.a.a(localView, null);
        }
      }
      else {
        ImageWorker.a(this.jdField_a_of_type_ComTencentMobileqqUtilImageWorker, this.jdField_a_of_type_Boolean, localView, paramDrawable, localTag);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker.BitmapWorkerTask
 * JD-Core Version:    0.7.0.1
 */