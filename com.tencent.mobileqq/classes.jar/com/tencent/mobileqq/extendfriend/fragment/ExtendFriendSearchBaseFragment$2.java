package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendMultiLinesTagsView.OnItemClickListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

class ExtendFriendSearchBaseFragment$2
  implements ExtendFriendMultiLinesTagsView.OnItemClickListener
{
  ExtendFriendSearchBaseFragment$2(ExtendFriendSearchBaseFragment paramExtendFriendSearchBaseFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    ExtendFriendSearchBaseFragment.a(this.a).setText(paramString);
    ExtendFriendSearchBaseFragment.a(this.a).setSelection(ExtendFriendSearchBaseFragment.a(this.a).length());
    ExtendFriendSearchBaseFragment.a(this.a, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */