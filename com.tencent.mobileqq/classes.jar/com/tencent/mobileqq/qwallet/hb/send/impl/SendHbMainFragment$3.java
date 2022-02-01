package com.tencent.mobileqq.qwallet.hb.send.impl;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.List;

class SendHbMainFragment$3
  extends FragmentPagerAdapter
{
  SendHbMainFragment$3(SendHbMainFragment paramSendHbMainFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public QBaseFragment a(int paramInt)
  {
    return ((SendHbMainFragment.HbHolder)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_ComTencentMobileqqQwalletHbSendImplBaseHbFragment;
  }
  
  public int getCount()
  {
    return SendHbMainFragment.a(this.a).size();
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return ((SendHbMainFragment.HbHolder)SendHbMainFragment.a(this.a).get(paramInt)).jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.SendHbMainFragment.3
 * JD-Core Version:    0.7.0.1
 */