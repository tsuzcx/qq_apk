package com.tencent.open.agent;

import android.support.v4.app.FragmentActivity;
import bdbq;
import com.tencent.qphone.base.util.QLog;

public class OpenAuthorityFragment$9$6
  implements Runnable
{
  public OpenAuthorityFragment$9$6(bdbq parambdbq) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenAuthorityFragment", 2, "--> handler message UPDATE_DROP_DOWN_VIEWS");
    }
    this.a.a.a.a.c();
    this.a.a.getActivity().runOnUiThread(new OpenAuthorityFragment.9.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.9.6
 * JD-Core Version:    0.7.0.1
 */