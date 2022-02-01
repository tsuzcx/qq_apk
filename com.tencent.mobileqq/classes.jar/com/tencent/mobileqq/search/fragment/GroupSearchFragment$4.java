package com.tencent.mobileqq.search.fragment;

import com.tencent.common.app.AppInterface;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;

class GroupSearchFragment$4
  implements Runnable
{
  GroupSearchFragment$4(GroupSearchFragment paramGroupSearchFragment, AppInterface paramAppInterface) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    FavoriteSearchEngine.a(this.a);
    GroupSearchFragment.b(this.this$0, System.currentTimeMillis() - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment.4
 * JD-Core Version:    0.7.0.1
 */