package com.tencent.mobileqq.kandian.biz.comment;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.subcomment.TKDTuWenSubCommentFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ReadInJoySecondCommentListFragment$MyHippyCommentPageListener
  implements HippyCommentPageListener
{
  private final WeakReference<ReadInJoySecondCommentListFragment> a;
  
  private ReadInJoySecondCommentListFragment$MyHippyCommentPageListener(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    this.a = new WeakReference(paramReadInJoySecondCommentListFragment);
  }
  
  private static boolean a(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (paramReadInJoySecondCommentListFragment == null)
    {
      QLog.d("ReadInJoySecondCommentListFragment", 1, "onHippyPageLoaded: fragment detached");
      return true;
    }
    QBaseActivity localQBaseActivity = paramReadInJoySecondCommentListFragment.getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()) && (!paramReadInJoySecondCommentListFragment.isDetached())) {
      return false;
    }
    QLog.d("ReadInJoySecondCommentListFragment", 1, "activity not exists or fragment detached");
    return true;
  }
  
  private static void b(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (ReadInJoySecondCommentListFragment.d(paramReadInJoySecondCommentListFragment) != null)
    {
      paramReadInJoySecondCommentListFragment = ReadInJoySecondCommentListFragment.d(paramReadInJoySecondCommentListFragment).getPerformanceData();
      if (paramReadInJoySecondCommentListFragment != null)
      {
        long l1 = ((Long)paramReadInJoySecondCommentListFragment.get("openPageStart")).longValue();
        long l2 = ((Long)paramReadInJoySecondCommentListFragment.get("loadModuleEnd")).longValue();
        paramReadInJoySecondCommentListFragment = new StringBuilder();
        paramReadInJoySecondCommentListFragment.append("hippy cost: ");
        paramReadInJoySecondCommentListFragment.append(l2 - l1);
        QLog.d("ReadInJoySecondCommentListFragment", 1, paramReadInJoySecondCommentListFragment.toString());
      }
    }
  }
  
  private void c(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (ReadInJoySecondCommentListFragment.d(paramReadInJoySecondCommentListFragment) != null)
    {
      ReadInJoySecondCommentListFragment.b(paramReadInJoySecondCommentListFragment, true);
      ReadInJoySecondCommentListFragment.e(paramReadInJoySecondCommentListFragment);
      if (ReadInJoySecondCommentListFragment.f(paramReadInJoySecondCommentListFragment) != null) {
        paramReadInJoySecondCommentListFragment.a(ReadInJoySecondCommentListFragment.f(paramReadInJoySecondCommentListFragment), ReadInJoySecondCommentListFragment.g(paramReadInJoySecondCommentListFragment), ReadInJoySecondCommentListFragment.h(paramReadInJoySecondCommentListFragment), ReadInJoySecondCommentListFragment.i(paramReadInJoySecondCommentListFragment));
      }
    }
  }
  
  private void d(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (ReadInJoySecondCommentListFragment.d(paramReadInJoySecondCommentListFragment) != null)
    {
      if (ReadInJoySecondCommentListFragment.j(paramReadInJoySecondCommentListFragment) != null)
      {
        try
        {
          FragmentTransaction localFragmentTransaction = paramReadInJoySecondCommentListFragment.getChildFragmentManager().beginTransaction();
          localFragmentTransaction.remove(ReadInJoySecondCommentListFragment.d(paramReadInJoySecondCommentListFragment));
          localFragmentTransaction.commitAllowingStateLoss();
        }
        catch (Throwable localThrowable)
        {
          ReadInJoyHelper.a("ReadInJoySecondCommentListFragment", localThrowable);
        }
        ((FrameLayout)ReadInJoySecondCommentListFragment.j(paramReadInJoySecondCommentListFragment).findViewById(2131435054)).setVisibility(8);
        ReadInJoySecondCommentListFragment.k(paramReadInJoySecondCommentListFragment);
      }
      ReadInJoySecondCommentListFragment.d(paramReadInJoySecondCommentListFragment).getTKDHippyEventDispatcher().clear();
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment, null);
    }
    if (!ReadInJoySecondCommentListFragment.l(paramReadInJoySecondCommentListFragment)) {
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment, ReadInJoySecondCommentListFragment.j(paramReadInJoySecondCommentListFragment));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onHippyPageLoaded: ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.d("ReadInJoySecondCommentListFragment", 1, ((StringBuilder)localObject).toString());
    localObject = (ReadInJoySecondCommentListFragment)this.a.get();
    if (a((ReadInJoySecondCommentListFragment)localObject)) {
      return;
    }
    if (paramBoolean) {
      c((ReadInJoySecondCommentListFragment)localObject);
    } else {
      d((ReadInJoySecondCommentListFragment)localObject);
    }
    b((ReadInJoySecondCommentListFragment)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment.MyHippyCommentPageListener
 * JD-Core Version:    0.7.0.1
 */