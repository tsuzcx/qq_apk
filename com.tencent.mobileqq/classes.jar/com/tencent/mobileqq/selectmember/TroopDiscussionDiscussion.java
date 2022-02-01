package com.tencent.mobileqq.selectmember;

import android.os.Bundle;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.selectmember.adapter.DiscussionListAdapter2.DiscussionListListener;
import com.tencent.widget.XListView;

public class TroopDiscussionDiscussion
  extends TroopDiscussionBaseV
  implements DiscussionListAdapter2.DiscussionListListener
{
  private XListView a;
  private DiscussionListAdapter2 b;
  
  public TroopDiscussionDiscussion(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  public void a(Bundle paramBundle)
  {
    setContentView(2131629275);
    this.a = ((XListView)findViewById(2131450345));
    this.a.setSelector(2131168376);
    this.b = new DiscussionListAdapter2(this.d, this, this.a, this.f, false);
    this.b.a(true);
    this.a.setAdapter(this.b);
    this.b.notifyDataSetChanged();
  }
  
  public void a(DiscussionInfo paramDiscussionInfo)
  {
    if (paramDiscussionInfo != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("group_uin", paramDiscussionInfo.uin);
      localBundle.putString("group_name", paramDiscussionInfo.discussionName);
      this.g.a(7, localBundle);
    }
  }
  
  public void b()
  {
    super.b();
    this.b.a();
  }
  
  public void b(Bundle paramBundle) {}
  
  public String getGroupUin()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionDiscussion
 * JD-Core Version:    0.7.0.1
 */