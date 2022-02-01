package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscussionMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  PinnedDividerListView a;
  List<DiscussionMemberInfo> b = new ArrayList();
  RelativeLayout c;
  CheckBox d;
  boolean e;
  private String j = "";
  private String k;
  private String l;
  private DiscussionMemberListInnerFrame.DiscussionMemberListAdapter m;
  private IndexView n;
  private Handler o = new DiscussionMemberListInnerFrame.2(this);
  
  public DiscussionMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DiscussionMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.c;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      boolean bool = false;
      if ((paramString != null) && (!paramBoolean) && (this.d.isChecked()))
      {
        paramBoolean = bool;
      }
      else
      {
        int i1 = this.m.getCount();
        int i = 0;
        while (i < i1)
        {
          paramString = (DiscussionMemberInfo)this.m.getItem(i);
          if ((paramString != null) && (!this.f.isResultListContainFriend(paramString.memberUin)))
          {
            paramBoolean = bool;
            break label108;
          }
          i += 1;
        }
        paramBoolean = true;
      }
      label108:
      this.d.setChecked(paramBoolean);
    }
  }
  
  private void g()
  {
    this.a = ((PinnedDividerListView)findViewById(2131430527));
    this.n = ((IndexView)findViewById(2131435678));
    this.n.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.n.setOnIndexChangedListener(this);
    this.a.setSelector(2131168376);
    this.a.setOnLayoutListener(this);
    this.c = ((RelativeLayout)findViewById(2131445020));
    LinearLayout localLinearLayout = (LinearLayout)this.c.findViewById(2131437552);
    this.d = ((CheckBox)findViewById(2131430406));
    localLinearLayout.setOnClickListener(this);
  }
  
  private void getDiscussionMembers()
  {
    this.b.clear();
    Object localObject = (ArrayList)((IDiscussionService)this.h.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberInfoListByUin(this.k);
    if (localObject != null)
    {
      String str = this.h.getCurrentAccountUin();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
        if ((localDiscussionMemberInfo != null) && ((this.f.mShowMyself) || (!str.equalsIgnoreCase(localDiscussionMemberInfo.memberUin))) && (!this.f.mUinsToHide.contains(localDiscussionMemberInfo.memberUin)))
        {
          localDiscussionMemberInfo.displayedNamePinyinFirst = ChnToSpell.b(CommonUtils.a(localDiscussionMemberInfo, this.h), 2);
          this.b.add(localDiscussionMemberInfo);
        }
      }
    }
    this.f.afterMemberFilter(this.b.size());
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131629255);
    g();
    this.m = new DiscussionMemberListInnerFrame.DiscussionMemberListAdapter(this);
    this.a.setAdapter(this.m);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.a.getFirstVisiblePosition() > 0) || ((this.a.getFirstVisiblePosition() == 0) && (this.a.getChildCount() < this.m.getCount() + this.a.getHeaderViewsCount()))) && (!this.f.isSoftInputShowing()))
    {
      this.n.setVisibility(0);
      this.o.sendEmptyMessage(1);
      return;
    }
    this.n.setVisibility(4);
    this.o.sendEmptyMessage(2);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f.mSelectedAndSearchBar.c();
    this.k = paramBundle.getString("group_uin");
    this.l = paramBundle.getString("group_name");
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.c;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
    if ((TextUtils.isEmpty(this.l)) && (!TextUtils.isEmpty(this.k)))
    {
      paramBundle = (DiscussionInfo)((IDiscussionService)this.h.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(this.k);
      if (paramBundle != null) {
        this.l = paramBundle.discussionName;
      }
    }
    if (this.f.mOnlyDiscussionMember) {
      this.f.setupTitleBar(false, "", this.l);
    } else {
      this.f.setupTitleBar(true, HardCodeUtil.a(2131901480), this.l);
    }
    if ((!TextUtils.isEmpty(this.k)) && (!this.k.equals(this.j)))
    {
      getDiscussionMembers();
      this.m.b();
      this.a.setSelection(0);
      this.j = this.k;
    }
    else
    {
      this.m.notifyDataSetChanged();
    }
    if ((!this.e) && (this.f.mIsSelectAllMembers))
    {
      this.e = true;
      this.d.setChecked(true);
      paramBundle = this.d;
      onCheckedChanged(paramBundle, paramBundle.isChecked());
    }
  }
  
  public void d()
  {
    DiscussionMemberListInnerFrame.DiscussionMemberListAdapter localDiscussionMemberListAdapter = this.m;
    if (localDiscussionMemberListAdapter != null) {
      localDiscussionMemberListAdapter.d();
    }
    super.d();
  }
  
  public void f()
  {
    this.m.notifyDataSetChanged();
    a(null, false);
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return ContactSearchFragment.a(-1, 4096, this.k, this.f.mUinsToHide, this.f);
  }
  
  public String getGroupUin()
  {
    return this.k;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131430406 == paramCompoundButton.getId())
    {
      if (paramBoolean)
      {
        ArrayList localArrayList = new ArrayList();
        int i1 = this.m.getCount();
        int i = 0;
        while (i < i1)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)this.m.getItem(i);
          if (localDiscussionMemberInfo != null)
          {
            SelectMemberActivity localSelectMemberActivity = this.f;
            localArrayList.add(SelectMemberActivity.constructAResultRecord(localDiscussionMemberInfo.memberUin, CommonUtils.a(localDiscussionMemberInfo, this.h), 2, this.k));
          }
          i += 1;
        }
        if (this.f.mEntrance == 31) {
          ReportController.b(this.h, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
        }
        this.f.addFriendResults(localArrayList, false, true);
      }
      else
      {
        this.f.removeAllFriendResult();
      }
      this.m.notifyDataSetChanged();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if (2131437552 != paramView.getId())
    {
      localObject1 = (DiscussionMemberListInnerFrame.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).a != null) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).i != null) && (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).a.isEnabled()))
      {
        boolean bool = this.f.onListViewItemClick(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).y, ((DiscussionMemberListInnerFrame.ViewHolder)localObject1).i.getText().toString(), 2, this.k);
        ((DiscussionMemberListInnerFrame.ViewHolder)localObject1).a.setChecked(bool);
        a(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).y, bool);
        if (AppSetting.e) {
          if (((DiscussionMemberListInnerFrame.ViewHolder)localObject1).a.isChecked())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).i.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901453));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((DiscussionMemberListInnerFrame.ViewHolder)localObject1).i.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131901469));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    else if (((this.f.mEntrance == 32) || (this.f.mEntrance == 43)) && (!this.d.isChecked()) && (this.f.mMaxSelectNumber < this.m.c()))
    {
      localObject1 = new DiscussionMemberListInnerFrame.1(this);
      localObject2 = MessageFormat.format(this.f.getString(2131916219), new Object[] { Integer.valueOf(this.f.mMaxSelectNumber) });
      localObject1 = DialogUtil.a(this.f, 232, this.f.getResources().getString(2131917233), (String)localObject2, 2131887648, 2131896937, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
    }
    try
    {
      ((Dialog)localObject1).show();
    }
    catch (Throwable localThrowable)
    {
      break label424;
    }
    Object localObject1 = this.d;
    ((CheckBox)localObject1).setChecked(true ^ ((CheckBox)localObject1).isChecked());
    localObject1 = this.d;
    onCheckedChanged((CompoundButton)localObject1, ((CheckBox)localObject1).isChecked());
    if (this.f.mEntrance == 32)
    {
      localObject2 = (IQWalletApi)QRoute.api(IQWalletApi.class);
      if (this.d.isChecked()) {
        localObject1 = "friendsfinder.all.confirm";
      } else {
        localObject1 = "friendsfinder.all.cancel";
      }
      ((IQWalletApi)localObject2).reportTenpay(0, (String)localObject1);
    }
    label424:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.a.setSelection(0);
      return;
    }
    int i = this.m.b(paramString);
    if (i != -1)
    {
      paramString = this.a;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.DiscussionMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */