package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import cooperation.qzone.api.FeedListView.ExpandHead;

class ExtendFriendCampusFragment$3
  implements FeedListView.ExpandHead
{
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = true;
  
  ExtendFriendCampusFragment$3(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  private boolean a()
  {
    long l = System.nanoTime();
    if (l - this.jdField_a_of_type_Long < 400000000L) {
      return true;
    }
    this.jdField_a_of_type_Long = l;
    return false;
  }
  
  public void hide()
  {
    if ((!this.jdField_a_of_type_Boolean) || (a())) {
      return;
    }
    ExtendFriendCampusFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.nanoTime();
  }
  
  public void show()
  {
    if ((this.jdField_a_of_type_Boolean) || (a())) {
      return;
    }
    ExtendFriendCampusFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment.3
 * JD-Core Version:    0.7.0.1
 */