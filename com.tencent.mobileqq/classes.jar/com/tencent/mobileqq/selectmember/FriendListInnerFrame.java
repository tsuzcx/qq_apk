package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  List<Friends> a = new ArrayList();
  PinnedDividerListView b;
  RelativeLayout c;
  private FriendListInnerFrame.FriendListAdapter d;
  private IndexView e;
  private int j = -2147483648;
  private int k;
  private String l;
  private EditText m;
  private Handler n = new FriendListInnerFrame.1(this);
  
  public FriendListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FriendListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  static String a(Friends paramFriends)
  {
    String str = paramFriends.getFriendNick();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("-");
    localStringBuilder.append(paramFriends.uin);
    return localStringBuilder.toString();
  }
  
  private void g()
  {
    this.b = ((PinnedDividerListView)findViewById(2131430527));
    this.e = ((IndexView)findViewById(2131435678));
    this.e.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.e.setOnIndexChangedListener(this);
    this.b.setSelector(2131168376);
    this.b.setOnLayoutListener(this);
    this.c = ((RelativeLayout)this.f.getLayoutInflater().inflate(2131629215, this.b, false));
    this.m = ((EditText)this.c.findViewById(2131432634));
    ((Button)this.c.findViewById(2131429816)).setVisibility(8);
    this.b.addHeaderView(this.c);
  }
  
  private void getFriendsInTeam()
  {
    this.a.clear();
    String str = this.h.getCurrentAccountUin();
    Object localObject1 = SearchUtils.a(this.h, String.valueOf(this.k));
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Entity)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject2 = (Friends)localObject2;
          if (((this.f.mShowMyself) || (!((Friends)localObject2).uin.equals(str))) && (!this.f.mUinsToHide.contains(((Friends)localObject2).uin))) {
            this.a.add(localObject2);
          }
        }
      }
    }
    if ((this.f.mShowMyself) && (this.k == 0))
    {
      int i1 = 0;
      localObject1 = SearchUtils.a(this.h);
      int i = i1;
      if (localObject1 != null)
      {
        i = i1;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          do
          {
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                i = i1;
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = (Groups)((Iterator)localObject1).next();
                localObject2 = SearchUtils.a(this.h, String.valueOf(((Groups)localObject2).group_id));
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
          } while (!((Friends)((Iterator)localObject2).next()).uin.equals(str));
          i = 1;
        }
      }
      if (i == 0)
      {
        localObject1 = new Friends();
        ((Friends)localObject1).uin = str;
        ((Friends)localObject1).name = this.h.getCurrentNickname();
        ((Friends)localObject1).mCompareSpell = ChnToSpell.b(a((Friends)localObject1), 1);
        this.a.add(localObject1);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131629255);
    g();
    this.d = new FriendListInnerFrame.FriendListAdapter(this);
    this.b.setAdapter(this.d);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.b.getFirstVisiblePosition() > 0) || ((this.b.getFirstVisiblePosition() == 0) && (this.b.getChildCount() < this.d.getCount() + this.b.getHeaderViewsCount()))) && (!this.f.isSoftInputShowing()))
    {
      this.e.setVisibility(0);
      this.n.sendEmptyMessage(1);
      return;
    }
    this.e.setVisibility(4);
    this.n.sendEmptyMessage(2);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.k = paramBundle.getInt("friend_team_id");
    this.l = paramBundle.getString("group_name");
    this.f.setupTitleBar(true, this.f.getString(2131916220), this.l);
    if (this.k != this.j)
    {
      getFriendsInTeam();
      this.d.b();
      this.b.setSelection(0);
      this.j = this.k;
      return;
    }
    paramBundle = this.d;
    if (paramBundle != null) {
      paramBundle.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    FriendListInnerFrame.FriendListAdapter localFriendListAdapter = this.d;
    if (localFriendListAdapter != null) {
      localFriendListAdapter.d();
    }
    super.d();
  }
  
  public void f()
  {
    this.d.notifyDataSetChanged();
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return ((SelectMemberInnerFrame)this.g.getChildAt(1)).getContactSearchFragment();
  }
  
  public String getGroupUin()
  {
    return "-1";
  }
  
  public void onClick(View paramView)
  {
    FriendListInnerFrame.ViewHolder localViewHolder = (FriendListInnerFrame.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && (localViewHolder.a != null) && (localViewHolder.i != null) && (localViewHolder.a.isEnabled()))
    {
      boolean bool = this.f.onListViewItemClick(localViewHolder.y, localViewHolder.i.getText().toString(), 0, "-1");
      localViewHolder.a.setChecked(bool);
      if (AppSetting.e)
      {
        StringBuilder localStringBuilder;
        if (localViewHolder.a.isChecked())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.i.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131902865));
          paramView.setContentDescription(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.i.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131902868));
          paramView.setContentDescription(localStringBuilder.toString());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.b.setSelection(0);
      return;
    }
    int i = this.d.b(paramString);
    if (i != -1)
    {
      paramString = this.b;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendListInnerFrame
 * JD-Core Version:    0.7.0.1
 */