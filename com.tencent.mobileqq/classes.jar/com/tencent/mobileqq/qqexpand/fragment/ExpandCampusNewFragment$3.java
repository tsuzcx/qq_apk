package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView;
import cooperation.qzone.api.FeedListView.ExpandHead;

class ExpandCampusNewFragment$3
  implements FeedListView.ExpandHead
{
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean = true;
  
  ExpandCampusNewFragment$3(ExpandCampusNewFragment paramExpandCampusNewFragment) {}
  
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
    if (this.jdField_a_of_type_Boolean)
    {
      if (a()) {
        return;
      }
      ExpandCampusNewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment).b();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Long = System.nanoTime();
    }
  }
  
  public void show()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (a()) {
        return;
      }
      ExpandCampusNewFragment.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment).a();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Long = System.nanoTime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment.3
 * JD-Core Version:    0.7.0.1
 */