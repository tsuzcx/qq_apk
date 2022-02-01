package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView;
import cooperation.qzone.api.FeedListView.ExpandHead;

class ExpandCampusNewFragment$3
  implements FeedListView.ExpandHead
{
  private boolean b = true;
  private long c = 0L;
  
  ExpandCampusNewFragment$3(ExpandCampusNewFragment paramExpandCampusNewFragment) {}
  
  private boolean a()
  {
    long l = System.nanoTime();
    if (l - this.c < 400000000L) {
      return true;
    }
    this.c = l;
    return false;
  }
  
  public void hide()
  {
    if (this.b)
    {
      if (a()) {
        return;
      }
      ExpandCampusNewFragment.b(this.a).b();
      this.b = false;
      this.c = System.nanoTime();
    }
  }
  
  public void show()
  {
    if (!this.b)
    {
      if (a()) {
        return;
      }
      ExpandCampusNewFragment.b(this.a).a();
      this.b = true;
      this.c = System.nanoTime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment.3
 * JD-Core Version:    0.7.0.1
 */