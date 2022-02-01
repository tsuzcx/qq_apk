package com.tencent.mobileqq.selectmember;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.statistics.ReportController;

class SelectMemberActivity$9
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  SelectMemberActivity$9(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void a(Editable paramEditable)
  {
    paramEditable = paramEditable.toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.a.mSearchResultLayout.setVisibility(8);
    } else {
      this.a.mSearchResultLayout.setVisibility(0);
    }
    if (this.a.contactSearchFragment != null) {
      this.a.contactSearchFragment.a(paramEditable);
    }
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    String str = paramResultRecord.uin;
    if (this.a.isResultListContainFriend(str))
    {
      this.a.removeFriendFromResultList(str);
      this.a.updateMultiAddState(paramResultRecord, false);
      this.a.setupDoneBtn();
      int i = this.a.mInnerFrameManager.getCurrentPage();
      if ((i == 6) || (i == 7) || (i == 5) || (i == 4) || (i == 1) || (i == 0) || (i == 8) || (i == 9)) {
        ((SelectMemberInnerFrame)this.a.mInnerFrameManager.getCurrentView()).f();
      }
      SelectMemberActivity.access$300(this.a, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.a.lastInerFrame == 6) || (this.a.lastInerFrame == 7) || (this.a.lastInerFrame != this.a.mInnerFrameManager.getCurrentPage())))
    {
      ContactSearchFragment localContactSearchFragment = ((SelectMemberInnerFrame)this.a.mInnerFrameManager.getCurrentView()).getContactSearchFragment();
      if (localContactSearchFragment != null)
      {
        localContactSearchFragment.d(this.a.mFilterRobot);
        localContactSearchFragment.a(this.a.getResultUins(), this.a.mUinsSelectedDefault);
        FragmentTransaction localFragmentTransaction = this.a.getSupportFragmentManager().beginTransaction();
        if (this.a.contactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.contactSearchFragment);
        }
        localFragmentTransaction.add(2131444724, localContactSearchFragment);
        localFragmentTransaction.commitAllowingStateLoss();
        this.a.contactSearchFragment = localContactSearchFragment;
      }
      if (this.a.mSubType == 0)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 1, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X800543F", "0X800543F", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.9
 * JD-Core Version:    0.7.0.1
 */