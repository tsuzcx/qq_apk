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
  
  private static void a(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment) != null)
    {
      paramReadInJoySecondCommentListFragment = ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment).getPerformanceData();
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
  
  private void b(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment) != null)
    {
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment, true);
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment);
      if (ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment) != null) {
        paramReadInJoySecondCommentListFragment.a(ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment), ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment), ReadInJoySecondCommentListFragment.b(paramReadInJoySecondCommentListFragment), ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment));
      }
    }
  }
  
  private void c(ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment)
  {
    if (ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment) != null)
    {
      if (ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment) != null)
      {
        try
        {
          FragmentTransaction localFragmentTransaction = paramReadInJoySecondCommentListFragment.getChildFragmentManager().beginTransaction();
          localFragmentTransaction.remove(ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment));
          localFragmentTransaction.commitAllowingStateLoss();
        }
        catch (Throwable localThrowable)
        {
          ReadInJoyHelper.a("ReadInJoySecondCommentListFragment", localThrowable);
        }
        ((FrameLayout)ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment).findViewById(2131368189)).setVisibility(8);
        ReadInJoySecondCommentListFragment.b(paramReadInJoySecondCommentListFragment);
      }
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment).getTKDHippyEventDispatcher().clear();
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment, null);
    }
    if (!ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment)) {
      ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment, ReadInJoySecondCommentListFragment.a(paramReadInJoySecondCommentListFragment));
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
      b((ReadInJoySecondCommentListFragment)localObject);
    } else {
      c((ReadInJoySecondCommentListFragment)localObject);
    }
    a((ReadInJoySecondCommentListFragment)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoySecondCommentListFragment.MyHippyCommentPageListener
 * JD-Core Version:    0.7.0.1
 */