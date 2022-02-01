package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ExpandCampusNewFragment$6
  implements Runnable
{
  ExpandCampusNewFragment$6(ExpandCampusNewFragment paramExpandCampusNewFragment) {}
  
  public void run()
  {
    if (this.this$0.a == null)
    {
      localObject = this.this$0;
      ((ExpandCampusNewFragment)localObject).a = DialogUtil.a(ExpandCampusNewFragment.a((ExpandCampusNewFragment)localObject), 230);
    }
    Object localObject = ((IExpandForbiddenUtils)QRoute.api(IExpandForbiddenUtils.class)).getForbidDialogMessage(ExpandCampusNewFragment.a(this.this$0), ExpandCampusNewFragment.a(this.this$0), false, ExpandCampusNewFragment.a(this.this$0), ExpandCampusNewFragment.a(this.this$0));
    int i;
    if (ExpandCampusNewFragment.a(this.this$0)) {
      i = 2131698821;
    } else {
      i = 2131698793;
    }
    this.this$0.a.setTitle(ExpandCampusNewFragment.a(this.this$0).getString(i)).setMessage((CharSequence)localObject).setPositiveButton(ExpandCampusNewFragment.a(this.this$0).getString(2131698818), new ExpandCampusNewFragment.6.2(this)).setOnKeyListener(new ExpandCampusNewFragment.6.1(this));
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment.6
 * JD-Core Version:    0.7.0.1
 */