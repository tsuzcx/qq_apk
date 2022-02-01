package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.Context;
import android.content.res.Resources;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ExpandableListView;
import java.util.List;

public class ReadInJoySelectMemberAQAdapter
  extends SelectMemberBuddyListAdapter
{
  private SelectMemberLimit c;
  
  public ReadInJoySelectMemberAQAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean, SelectMemberLimit paramSelectMemberLimit)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView, paramBoolean);
    this.c = paramSelectMemberLimit;
  }
  
  protected void a()
  {
    if ((this.c != null) && (this.b != null) && (this.b.size() >= this.c.b()))
    {
      String str = this.a.getResources().getString(2131915511, new Object[] { String.valueOf(this.c.d()) });
      QQToast.makeText(this.a, str, 0).show();
      return;
    }
    QQToast.makeText(this.a, this.a.getResources().getString(2131915505), 0).show();
  }
  
  protected void a(SelectMemberBuddyListAdapter.SelectBuddyChildTag paramSelectBuddyChildTag, Friends paramFriends)
  {
    if (paramFriends != null)
    {
      SelectMemberLimit localSelectMemberLimit = this.c;
      if ((localSelectMemberLimit != null) && (localSelectMemberLimit.c() != null))
      {
        if (this.c.c().isEmpty()) {
          return;
        }
        paramSelectBuddyChildTag.g.setBackgroundResource(2130851400);
        if (this.c.c().contains(paramFriends.uin))
        {
          paramSelectBuddyChildTag.g.setEnabled(false);
          return;
        }
        paramSelectBuddyChildTag.g.setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQAdapter
 * JD-Core Version:    0.7.0.1
 */