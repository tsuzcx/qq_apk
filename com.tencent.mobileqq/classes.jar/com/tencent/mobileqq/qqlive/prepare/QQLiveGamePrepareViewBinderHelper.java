package com.tencent.mobileqq.qqlive.prepare;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import java.util.Map;

public class QQLiveGamePrepareViewBinderHelper
  extends BaseViewBinder
{
  public static void a(Context paramContext, LifecycleOwner paramLifecycleOwner, PrepareFragmentViewModel paramPrepareFragmentViewModel, IGameListView paramIGameListView, Map<String, String> paramMap)
  {
    paramContext = new GameListAdapter(paramContext);
    paramContext.a(new QQLiveGamePrepareViewBinderHelper.8(paramPrepareFragmentViewModel, paramIGameListView, paramMap));
    paramPrepareFragmentViewModel.c.removeObservers(paramLifecycleOwner);
    paramIGameListView.a(paramContext);
    paramPrepareFragmentViewModel.c.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.9(paramContext));
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, PrepareFragmentViewModel paramPrepareFragmentViewModel, IQQLivePrepareView paramIQQLivePrepareView)
  {
    paramPrepareFragmentViewModel.g.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.g.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.1(paramIQQLivePrepareView, paramPrepareFragmentViewModel));
    paramPrepareFragmentViewModel.d.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.d.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.2(paramIQQLivePrepareView));
    paramPrepareFragmentViewModel.e.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.e.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.3(paramIQQLivePrepareView));
    paramPrepareFragmentViewModel.h.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.h.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.4(paramIQQLivePrepareView));
    paramPrepareFragmentViewModel.f.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.f.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.5(paramIQQLivePrepareView, paramPrepareFragmentViewModel));
    paramPrepareFragmentViewModel.i.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.i.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.6(paramIQQLivePrepareView));
    paramPrepareFragmentViewModel.j.removeObservers(paramLifecycleOwner);
    paramPrepareFragmentViewModel.j.observe(paramLifecycleOwner, new QQLiveGamePrepareViewBinderHelper.7(paramIQQLivePrepareView, paramPrepareFragmentViewModel));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLiveGamePrepareViewBinderHelper
 * JD-Core Version:    0.7.0.1
 */