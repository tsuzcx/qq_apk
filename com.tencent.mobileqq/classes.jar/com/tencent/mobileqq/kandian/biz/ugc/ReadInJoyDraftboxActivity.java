package com.tencent.mobileqq.kandian.biz.ugc;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.view.widget.TopEdgeGestureLayout;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;

public class ReadInJoyDraftboxActivity
  extends IphoneTitleBarActivity
{
  protected QQAppInterface a;
  protected ReadInJoyDraftboxFragment b;
  
  private void a()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    ReadInJoyWebDataManager.a().d(this.a.getCurrentAccountUin());
    setContentView(2131624037);
    setTitle(HardCodeUtil.a(2131910406));
    this.leftView.setText(HardCodeUtil.a(2131901576));
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new TopEdgeGestureLayout(this));
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.b = new ReadInJoyDraftboxFragment();
    localFragmentTransaction.add(2131433667, this.b);
    localFragmentTransaction.show(this.b);
    localFragmentTransaction.commit();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = ((QQAppInterface)ReadInJoyUtils.b());
    a();
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDraftboxActivity
 * JD-Core Version:    0.7.0.1
 */