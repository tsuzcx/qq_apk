package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.adapter.contact.GroupTag;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnGroupClickListener;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class TroopDiscussionMemSelectAdapter
  extends TroopListBaseAdapter
  implements ExpandableListView.OnGroupClickListener
{
  private View.OnClickListener o;
  private LayoutInflater p;
  private View.OnClickListener q = new TroopDiscussionMemSelectAdapter.1(this);
  private View.OnClickListener r = new TroopDiscussionMemSelectAdapter.2(this);
  
  public TroopDiscussionMemSelectAdapter(Context paramContext, AppInterface paramAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramAppInterface, paramExpandableListView);
    this.o = paramOnClickListener;
    this.p = LayoutInflater.from(paramContext);
  }
  
  private void a(GroupTag paramGroupTag)
  {
    int i;
    if (this.d.size() == 1) {
      i = 0;
    } else {
      i = paramGroupTag.a;
    }
    if (this.n.isGroupExpanded(i))
    {
      this.n.collapseGroup(i);
      this.k.remove(this.d.get(i));
      return;
    }
    this.n.expandGroup(i);
    this.k.add(this.d.get(i));
  }
  
  private void a(GroupTag paramGroupTag, int paramInt, boolean paramBoolean)
  {
    if (paramGroupTag != null)
    {
      if ((paramInt >= 0) && (paramInt < this.d.size()))
      {
        i = ((Integer)this.d.get(paramInt)).intValue();
        if (i != 0)
        {
          if (i != 2)
          {
            if (i != 4)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  if (i == 13)
                  {
                    str = HardCodeUtil.a(2131912562);
                    i = this.j.size();
                    break label213;
                  }
                }
                else
                {
                  str = HardCodeUtil.a(2131912560);
                  i = this.i.size();
                  break label213;
                }
              }
              else
              {
                str = HardCodeUtil.a(2131912558);
                i = this.g.size();
                break label213;
              }
            }
            else
            {
              str = HardCodeUtil.a(2131912561);
              i = this.f.size();
              break label213;
            }
          }
          else
          {
            str = HardCodeUtil.a(2131912559);
            i = this.h.size();
            break label213;
          }
        }
        else
        {
          str = HardCodeUtil.a(2131912557);
          i = this.e.size();
          break label213;
        }
      }
      String str = "";
      int i = 0;
      label213:
      Object localObject = paramGroupTag.g;
      if (AppSetting.e)
      {
        if (localObject == null) {
          localObject = new StringBuilder(24);
        } else {
          ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" 分组");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
      }
      paramGroupTag.a = paramInt;
      paramGroupTag.d.setText(str);
      paramGroupTag.e.setVisibility(8);
      paramGroupTag.c.setVisibility(8);
      paramGroupTag.f.setText(String.valueOf(i));
      paramGroupTag.b.setVisibility(0);
      paramGroupTag.b.setChecked(paramBoolean);
      ViewCompat.setImportantForAccessibility(paramGroupTag.b, 2);
      ViewCompat.setImportantForAccessibility(paramGroupTag.d, 1);
      if (paramBoolean) {
        localObject = "已展开 ";
      } else {
        localObject = "已收起 ";
      }
      paramGroupTag = paramGroupTag.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf(i));
      paramGroupTag.setContentDescription(localStringBuilder.toString());
    }
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (this.d.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof GroupTag))
    {
      localObject = new GroupTag();
      ((GroupTag)localObject).b = ((CheckBox)paramView.findViewById(2131436369));
      ((GroupTag)localObject).d = ((SingleLineTextView)paramView.findViewById(2131434435));
      ((GroupTag)localObject).d.setDefaultTextColor(-8355712);
      ((GroupTag)localObject).e = ((SingleLineTextView)paramView.findViewById(2131448697));
      ((GroupTag)localObject).f = ((SimpleTextView)paramView.findViewById(2131431254));
      ((GroupTag)localObject).f.setDefaultTextColor(1711276032);
      ((GroupTag)localObject).c = ((ProgressBar)paramView.findViewById(2131436506));
      paramView.setTag(localObject);
      paramView = (View)localObject;
    }
    else
    {
      paramView = (GroupTag)paramView.getTag();
    }
    if (ThemeUtil.isNowThemeIsDefaultCache(this.a, false))
    {
      paramView.f.setTextColor(-5196865);
    }
    else
    {
      localObject = this.b.getResources().getColorStateList(2131168122);
      paramView.f.setTextColor((ColorStateList)localObject);
    }
    a(paramView, paramInt, this.n.isGroupExpanded(paramInt));
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (paramView.getTag() != null))
    {
      paramViewGroup = (TroopDiscussionMemSelectAdapter.TroopViewHolder)paramView.getTag();
    }
    else
    {
      paramView = this.p.inflate(2131629272, this.n, false);
      paramViewGroup = new TroopDiscussionMemSelectAdapter.TroopViewHolder(this);
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131432714));
      paramViewGroup.f = ((ImageView)paramView.findViewById(2131432739));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131448053));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131448039));
      paramViewGroup.g = ((ImageView)paramView.findViewById(2131428774));
      paramView.setTag(paramViewGroup);
    }
    TroopListBaseAdapter.ItemInfo localItemInfo = a(paramInt1, paramInt2);
    if ((localItemInfo != null) && (localItemInfo.a != null))
    {
      Object localObject;
      if ((localItemInfo.a instanceof TroopInfo))
      {
        TroopInfo localTroopInfo = (TroopInfo)localItemInfo.a;
        paramViewGroup.y = localTroopInfo.troopuin;
        paramViewGroup.z = 4;
        if (!TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
          localObject = localTroopInfo.getTroopDisplayName();
        } else {
          localObject = localTroopInfo.troopuin;
        }
        paramViewGroup.y = localTroopInfo.troopuin;
        paramViewGroup.a.setText((CharSequence)localObject);
        paramViewGroup.c = localTroopInfo;
        paramViewGroup.d = null;
        paramViewGroup.e = localItemInfo.b;
        if ((!localTroopInfo.hasSetTroopName()) && (localTroopInfo.wMemberNumClient > 0))
        {
          paramViewGroup.b.setVisibility(0);
          paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
        }
        else
        {
          paramViewGroup.b.setVisibility(8);
        }
        a(paramViewGroup, null);
        paramView.setOnClickListener(this.o);
        return paramView;
      }
      if ((localItemInfo.a instanceof DiscussionInfo))
      {
        localObject = (DiscussionInfo)localItemInfo.a;
        paramViewGroup.y = ((DiscussionInfo)localObject).uin;
        paramViewGroup.z = 101;
        paramViewGroup.a.setText(CommonUtils.a(this.b, (DiscussionInfo)localObject));
        if (!((DiscussionInfo)localObject).hasRenamed())
        {
          paramViewGroup.b.setVisibility(0);
          paramViewGroup.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(((IDiscussionService)this.a.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject).uin)) }));
        }
        paramView.setOnClickListener(this.o);
        a(paramViewGroup, null);
        paramViewGroup.d = ((DiscussionInfo)localObject);
        paramViewGroup.c = null;
        paramViewGroup.e = localItemInfo.b;
        return paramView;
      }
      if (QLog.isColorLevel())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append("getChildView data:");
        paramViewGroup.append(localItemInfo.a);
        paramViewGroup.append(" groupPosition:");
        paramViewGroup.append(paramInt1);
        paramViewGroup.append(" childPosition:");
        paramViewGroup.append(paramInt2);
        QLog.d("TroopDiscussionMemSelectAdapter", 2, paramViewGroup.toString());
        return paramView;
      }
    }
    else if (QLog.isColorLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("getChildView itemInfo data null");
      paramViewGroup.append(paramInt1);
      paramViewGroup.append(" childPosition:");
      paramViewGroup.append(paramInt2);
      QLog.d("TroopDiscussionMemSelectAdapter", 2, paramViewGroup.toString());
    }
    return paramView;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2131624548, paramViewGroup, false);
      paramViewGroup = new GroupTag();
      paramViewGroup.d = ((SingleLineTextView)paramView.findViewById(2131434435));
      paramViewGroup.d.setDefaultTextColor(-8355712);
      paramViewGroup.b = ((CheckBox)paramView.findViewById(2131436369));
      paramViewGroup.f = ((SimpleTextView)paramView.findViewById(2131431254));
      paramViewGroup.f.setDefaultTextColor(1711276032);
      paramViewGroup.c = ((ProgressBar)paramView.findViewById(2131436506));
      paramViewGroup.e = ((SingleLineTextView)paramView.findViewById(2131448697));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (GroupTag)paramView.getTag();
    }
    if (this.d.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.l));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.a, false))
    {
      paramViewGroup.f.setTextColor(-5196865);
    }
    else
    {
      ColorStateList localColorStateList = this.b.getResources().getColorStateList(2131168122);
      paramViewGroup.f.setTextColor(localColorStateList);
    }
    a(paramViewGroup, paramInt, paramBoolean);
    paramView.setOnClickListener(this.q);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131624548;
  }
  
  public boolean needHideBackgroundGroup()
  {
    return true;
  }
  
  public boolean onGroupClick(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof GroupTag)) {
      a((GroupTag)paramExpandableListView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionMemSelectAdapter
 * JD-Core Version:    0.7.0.1
 */