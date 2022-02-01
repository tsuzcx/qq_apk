package com.tencent.mobileqq.fragment;

import android.text.Editable;
import com.tencent.mobileqq.adapter.QQGuildForwardSelectionGuildListAdapter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.qphone.base.util.QLog;

class QQGuildForwardGuildListFragment$1
  implements SelectedAndSearchBar.ISelectedAndSearchBarCallback
{
  QQGuildForwardGuildListFragment$1(QQGuildForwardGuildListFragment paramQQGuildForwardGuildListFragment) {}
  
  public void a(Editable paramEditable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardGuildListActivity", 2, "mSelectedAndSearchBarCallback afterTextChanged");
    }
    QQGuildForwardGuildListFragment.a("暂时不可搜索频道列表", 1);
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardGuildListActivity", 2, "mSelectedAndSearchBarCallback onItemDeleted");
    }
    if (paramResultRecord != null) {
      QQGuildForwardGuildListFragment.a(this.a, paramResultRecord.uin, paramResultRecord.getUinType());
    }
    QQGuildForwardGuildListFragment.a(this.a).notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ForwardGuildListActivity", 2, "mSelectedAndSearchBarCallback onEditTextFocusChanged");
    }
    QQGuildForwardGuildListFragment.a("暂时不可搜索频道列表", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQGuildForwardGuildListFragment.1
 * JD-Core Version:    0.7.0.1
 */