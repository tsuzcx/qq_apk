package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import aqhk;
import aqhl;

public class DeleteFaceFragment$2$1$1
  implements Runnable
{
  public DeleteFaceFragment$2$1$1(aqhl paramaqhl) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.a.a.a.getActivity();
    if (localFragmentActivity != null)
    {
      this.a.a.a.b();
      localFragmentActivity.setResult(-1);
      localFragmentActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment.2.1.1
 * JD-Core Version:    0.7.0.1
 */