package com.tencent.mobileqq.qqlive.end;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;

public class QQLiveGameEndViewBinder
  extends BaseViewBinder
{
  public void a(LifecycleOwner paramLifecycleOwner, EndFragmentViewModel paramEndFragmentViewModel, IQQLiveEndView paramIQQLiveEndView)
  {
    paramEndFragmentViewModel.a.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.a.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.1(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.b.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.b.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.2(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.c.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.c.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.3(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.d.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.d.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.4(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.e.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.e.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.5(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.h.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.h.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.6(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.f.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.f.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.7(this, paramIQQLiveEndView));
    paramEndFragmentViewModel.g.removeObservers(paramLifecycleOwner);
    paramEndFragmentViewModel.g.observe(paramLifecycleOwner, new QQLiveGameEndViewBinder.8(this, paramIQQLiveEndView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.end.QQLiveGameEndViewBinder
 * JD-Core Version:    0.7.0.1
 */