package com.tencent.mobileqq.leba.more;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.leba.observer.LebaSettingObserver;
import com.tencent.qphone.base.util.QLog;

class LebaMoreFragment$5
  extends LebaSettingObserver
{
  LebaMoreFragment$5(LebaMoreFragment paramLebaMoreFragment) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.getActivity() != null)
    {
      if (this.a.getActivity().isFinishing()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLebaSettingChanged isSuccess=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(",setting=");
      localStringBuilder.append(paramBoolean2);
      QLog.i("LebaMoreFragment", 1, localStringBuilder.toString());
      this.a.t();
      if (paramBoolean1)
      {
        this.a.d.c(this.a.r());
        if (this.a.y) {
          this.a.getActivity().runOnUiThread(new LebaMoreFragment.5.1(this));
        } else {
          this.a.getActivity().runOnUiThread(new LebaMoreFragment.5.2(this));
        }
      }
      else
      {
        this.a.getActivity().runOnUiThread(new LebaMoreFragment.5.3(this));
      }
      this.a.y = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.5
 * JD-Core Version:    0.7.0.1
 */