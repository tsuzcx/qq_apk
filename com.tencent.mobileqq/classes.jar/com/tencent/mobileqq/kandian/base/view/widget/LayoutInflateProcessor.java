package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ArrayBlockingQueue;

public class LayoutInflateProcessor
{
  private LayoutInflater a;
  private SparseArray<ArrayBlockingQueue<View>> b;
  
  public LayoutInflateProcessor(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    this.b = new SparseArray();
  }
  
  private void a(LayoutInflateProcessor.InflateParams paramInflateParams)
  {
    if (paramInflateParams == null) {
      return;
    }
    ArrayBlockingQueue localArrayBlockingQueue2 = (ArrayBlockingQueue)this.b.get(LayoutInflateProcessor.InflateParams.a(paramInflateParams));
    ArrayBlockingQueue localArrayBlockingQueue1;
    if (localArrayBlockingQueue2 == null)
    {
      localArrayBlockingQueue1 = new ArrayBlockingQueue(9);
      this.b.put(LayoutInflateProcessor.InflateParams.a(paramInflateParams), localArrayBlockingQueue1);
    }
    else
    {
      localArrayBlockingQueue1 = localArrayBlockingQueue2;
      if (localArrayBlockingQueue2.size() == 9) {
        return;
      }
    }
    paramInflateParams.a = localArrayBlockingQueue1;
  }
  
  @NonNull
  public View a(int paramInt, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    Object localObject = (ArrayBlockingQueue)this.b.get(paramInt);
    if (localObject != null)
    {
      localObject = (View)((ArrayBlockingQueue)localObject).poll();
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("inflate: hit cache! resid=");
          localStringBuilder.append(this.a.getContext().getResources().getResourceEntryName(paramInt));
          QLog.d("LayoutPreloadInflater", 2, localStringBuilder.toString());
        }
        ((View)localObject).setLayoutParams(paramLayoutParams);
        return localObject;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("inflate: miss cache, resid=");
      ((StringBuilder)localObject).append(this.a.getContext().getResources().getResourceEntryName(paramInt));
      ((StringBuilder)localObject).append(" faultTolerant=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("LayoutPreloadInflater", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.a.inflate(paramInt, null, false);
      ((View)localObject).setLayoutParams(paramLayoutParams);
      return localObject;
    }
    return null;
  }
  
  @UiThread
  public void a()
  {
    this.b.clear();
  }
  
  @UiThread
  public void a(LayoutInflateProcessor.InflateParams[] paramArrayOfInflateParams)
  {
    int j = paramArrayOfInflateParams.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfInflateParams[i]);
      i += 1;
    }
    ThreadManager.excute(new LayoutInflateProcessor.InflateTask(paramArrayOfInflateParams, this.a), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.LayoutInflateProcessor
 * JD-Core Version:    0.7.0.1
 */