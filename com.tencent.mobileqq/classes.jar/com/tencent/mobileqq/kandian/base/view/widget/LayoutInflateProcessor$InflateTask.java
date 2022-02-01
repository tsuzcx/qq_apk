package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;

class LayoutInflateProcessor$InflateTask
  implements Runnable
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LayoutInflateProcessor.InflateParams[] jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor$InflateParams;
  
  public LayoutInflateProcessor$InflateTask(LayoutInflateProcessor.InflateParams[] paramArrayOfInflateParams, LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor$InflateParams = paramArrayOfInflateParams;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
  }
  
  private boolean a(LayoutInflateProcessor.InflateParams paramInflateParams)
  {
    if (paramInflateParams.a != null)
    {
      if (paramInflateParams.a.size() >= 9) {
        return false;
      }
      Object localObject2 = null;
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("preload start: resid=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidViewLayoutInflater.getContext().getResources().getResourceEntryName(LayoutInflateProcessor.InflateParams.a(paramInflateParams)));
        QLog.d("LayoutPreloadInflater", 2, ((StringBuilder)localObject1).toString());
      }
      try
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(LayoutInflateProcessor.InflateParams.a(paramInflateParams), LayoutInflateProcessor.InflateParams.a(paramInflateParams), false);
      }
      catch (RuntimeException localRuntimeException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("LayoutPreloadInflater", 2, "Failed to inflate resource in the background! Retrying on the UI thread", localRuntimeException);
          localObject1 = localObject2;
        }
      }
      if (localObject1 != null)
      {
        if (LayoutInflateProcessor.InflateParams.a(paramInflateParams) != null) {
          LayoutInflateProcessor.InflateParams.a(paramInflateParams).a((View)localObject1);
        }
        if ((paramInflateParams.a != null) && (paramInflateParams.a.size() < 9))
        {
          paramInflateParams.a.add(localObject1);
          return true;
        }
      }
    }
    return false;
  }
  
  public void run()
  {
    LayoutInflateProcessor.InflateParams[] arrayOfInflateParams = this.jdField_a_of_type_ArrayOfComTencentMobileqqKandianBaseViewWidgetLayoutInflateProcessor$InflateParams;
    int k = arrayOfInflateParams.length;
    int i = 0;
    while (i < k)
    {
      LayoutInflateProcessor.InflateParams localInflateParams = arrayOfInflateParams[i];
      if (localInflateParams != null)
      {
        int j = 0;
        while ((j < LayoutInflateProcessor.InflateParams.b(localInflateParams)) && (a(localInflateParams))) {
          j += 1;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor.InflateTask
 * JD-Core Version:    0.7.0.1
 */