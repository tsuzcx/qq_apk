package com.tencent.mobileqq.selectmember;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class TroopAddFrdsInnerFrame$ListAdapter
  extends CharDividedFacePreloadBaseAdapter
  implements View.OnClickListener
{
  public List<ResultRecord> a = new ArrayList();
  boolean b = false;
  
  public TroopAddFrdsInnerFrame$ListAdapter(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame)
  {
    super(paramTroopAddFrdsInnerFrame.f, paramTroopAddFrdsInnerFrame.h, paramTroopAddFrdsInnerFrame.e, true);
    paramTroopAddFrdsInnerFrame.o = paramTroopAddFrdsInnerFrame.f.getResources().getDimensionPixelOffset(2131298918);
    paramTroopAddFrdsInnerFrame.p = paramTroopAddFrdsInnerFrame.f.getResources().getDimensionPixelOffset(2131298919);
  }
  
  private boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ResultRecord localResultRecord = (ResultRecord)this.a.get(i);
      if (TextUtils.equals(paramTroopMemberInfo.memberuin, localResultRecord.uin)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public int a()
  {
    if (this.c.n.length > 0) {
      return 2131625258;
    }
    return 0;
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.c.m, paramInt);
  }
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ResultRecord localResultRecord = (ResultRecord)this.a.get(i);
      if (TextUtils.equals(paramResultRecord.uin, localResultRecord.uin)) {
        break label57;
      }
      i += 1;
    }
    i = -1;
    label57:
    if (paramBoolean)
    {
      if (i == -1)
      {
        this.a.add(paramResultRecord);
        notifyDataSetChanged();
      }
    }
    else if (i != -1)
    {
      this.a.remove(i);
      notifyDataSetChanged();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.c.m, paramInt) >= 0;
  }
  
  public int b(String paramString)
  {
    if (this.c.n != null)
    {
      int i = 0;
      while (i < this.c.n.length)
      {
        if (this.c.n[i].equals(paramString)) {
          break label52;
        }
        i += 1;
      }
      i = -1;
      label52:
      if (i >= 0) {
        return this.c.m[i];
      }
    }
    return -1;
  }
  
  public int getCount()
  {
    int[] arrayOfInt = this.c.m;
    int i = 0;
    if (arrayOfInt != null)
    {
      if (this.c.l == null) {
        return 0;
      }
      if (this.c.m.length == 0) {
        return 0;
      }
      i = this.c.m[(this.c.m.length - 1)] + ((List)this.c.l.get(this.c.n[(this.c.n.length - 1)])).size() + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.c.m, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.c.l.get(this.c.n[i])).get(paramInt - this.c.m[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.c.m, paramInt);
    boolean bool2 = true;
    int j = 0;
    View localView = paramView;
    Object localObject1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramView == null)
    {
      localView = this.c.i.inflate(2131627367, paramViewGroup, false);
      paramView = new TroopAddFrdsInnerFrame.AddFrdHolder();
      paramView.d = localView.findViewById(2131444724);
      paramView.d.setId(2131447915);
      localObject1 = localView.findViewById(2131446713);
      localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      localLayoutParams.addRule(0, 2131447915);
      localLayoutParams.rightMargin = CommonUtils.a(10.0F, this.c.getResources());
      ((View)localObject1).setLayoutParams(localLayoutParams);
      paramView.A = ((ImageView)localView.findViewById(2131427337));
      paramView.b = ((TextView)localView.findViewById(2131444728));
      paramView.a = ((TextView)localView.findViewById(2131439320));
      paramView.c = ((TextView)localView.findViewById(2131446184));
      paramView.e = ((Button)localView.findViewById(2131444718));
      paramView.f = ((TextView)localView.findViewById(2131444726));
      paramView.h = ((CheckBox)localView.findViewById(2131430682));
      paramView.j = ((TextView)localView.findViewById(2131448537));
      paramView.i = localView.findViewById(2131442295);
      paramView.j.setFocusableInTouchMode(false);
      paramView.i.setFocusableInTouchMode(false);
      paramView.j.setFocusable(false);
      paramView.i.setFocusable(false);
      paramView.d.setDuplicateParentStateEnabled(false);
      paramView.e.setDuplicateParentStateEnabled(true);
      paramView.f.setDuplicateParentStateEnabled(false);
      paramView.e.setClickable(false);
      paramView.b.setPadding(0, CommonUtils.a(2.0F, this.c.getResources()), 0, 0);
      if ((TroopAddFrdsInnerFrame.b(this.c) != null) && (TroopAddFrdsInnerFrame.b(this.c).getVisibility() == 0)) {
        localView.findViewById(2131447915).setPadding(0, 0, this.c.o, 0);
      } else {
        localView.findViewById(2131447915).setPadding(0, 0, this.c.p, 0);
      }
      localView.setTag(paramView);
    }
    TroopAddFrdsInnerFrame.AddFrdHolder localAddFrdHolder = (TroopAddFrdsInnerFrame.AddFrdHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      Object localObject2 = (TroopMemberInfo)((List)this.c.l.get(this.c.n[i])).get(paramInt - this.c.m[i] - 1);
      localAddFrdHolder.g = ((TroopMemberInfo)localObject2);
      if (this.c.f.isResultListContainFriend(((TroopMemberInfo)localObject2).memberuin)) {
        localAddFrdHolder.h.setChecked(true);
      } else {
        localAddFrdHolder.h.setChecked(false);
      }
      boolean bool1 = AppSetting.e;
      localLayoutParams = null;
      if (bool1)
      {
        paramView = new StringBuilder(256);
        paramView.append("群成员");
      }
      else
      {
        paramView = null;
      }
      localAddFrdHolder.i.setVisibility(0);
      localAddFrdHolder.j.setVisibility(8);
      localAddFrdHolder.A.setImageBitmap(a(((TroopMemberInfo)localObject2).memberuin));
      Object localObject3 = CommonUtils.a(this.c.h, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(((TroopMemberInfo)localObject2).recommendRemark))
      {
        localObject1 = localObject3;
        if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, ((TroopMemberInfo)localObject2).memberuin))
        {
          localObject1 = localObject3;
          if (!TextUtils.equals(((TroopMemberInfo)localObject2).recommendRemark, (CharSequence)localObject3))
          {
            localObject1 = localObject3;
            if (!SearchUtils.b(this.c.h, ((TroopMemberInfo)localObject2).memberuin))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append(" (");
              ((StringBuilder)localObject1).append(((TroopMemberInfo)localObject2).recommendRemark);
              ((StringBuilder)localObject1).append(")");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
        }
      }
      localAddFrdHolder.a.setText((CharSequence)localObject1);
      localAddFrdHolder.y = ((TroopMemberInfo)localObject2).memberuin;
      localAddFrdHolder.c.setVisibility(8);
      if (AppSetting.e) {
        paramView.append((String)localObject1);
      }
      if (((TroopMemberInfo)localObject2).commonFrdCnt > 0)
      {
        localAddFrdHolder.b.setText(this.c.getResources().getString(2131886303, new Object[] { Integer.valueOf(((TroopMemberInfo)localObject2).commonFrdCnt) }));
        localAddFrdHolder.b.setVisibility(0);
        if (AppSetting.e) {
          paramView.append(localAddFrdHolder.b.getText());
        }
      }
      else
      {
        localAddFrdHolder.b.setVisibility(8);
      }
      if (!this.b) {
        localAddFrdHolder.i.setEnabled(true);
      }
      if (((TroopMemberInfo)localObject2).addState == 1) {
        i = TroopAddFrdsInnerFrame.a(this.c, ((TroopMemberInfo)localObject2).memberuin);
      } else {
        i = ((TroopMemberInfo)localObject2).addState;
      }
      if (i == 4)
      {
        localAddFrdHolder.e.setVisibility(8);
        localAddFrdHolder.f.setVisibility(0);
        localAddFrdHolder.f.setText(HardCodeUtil.a(2131912430));
        if (this.b)
        {
          localAddFrdHolder.i.setEnabled(false);
          localAddFrdHolder.h.setEnabled(false);
          localAddFrdHolder.h.setChecked(false);
        }
        if (AppSetting.e) {
          localAddFrdHolder.f.setContentDescription(HardCodeUtil.a(2131912432));
        }
      }
      else
      {
        if (i != 3) {
          break label1114;
        }
        localAddFrdHolder.e.setVisibility(8);
        localAddFrdHolder.f.setVisibility(0);
        localAddFrdHolder.f.setText(HardCodeUtil.a(2131912428));
        if (this.b)
        {
          localAddFrdHolder.i.setEnabled(false);
          localAddFrdHolder.h.setEnabled(false);
          localAddFrdHolder.h.setChecked(false);
        }
        if (AppSetting.e) {
          localAddFrdHolder.f.setContentDescription(HardCodeUtil.a(2131912427));
        }
      }
      bool1 = false;
      break label1240;
      label1114:
      if (this.b)
      {
        localAddFrdHolder.i.setEnabled(true);
        localAddFrdHolder.e.setVisibility(8);
        localAddFrdHolder.h.setEnabled(true);
        localAddFrdHolder.h.setChecked(a((TroopMemberInfo)localObject2));
        localAddFrdHolder.h.setTag(localAddFrdHolder);
        bool1 = false;
      }
      else
      {
        localAddFrdHolder.e.setVisibility(0);
        localAddFrdHolder.e.setText(HardCodeUtil.a(2131886199));
        bool1 = bool2;
        if (AppSetting.e)
        {
          localAddFrdHolder.e.setContentDescription(HardCodeUtil.a(2131886199));
          bool1 = bool2;
        }
      }
      localAddFrdHolder.f.setVisibility(8);
      label1240:
      localObject3 = localAddFrdHolder.d;
      if (bool1) {
        localObject1 = localObject2;
      } else {
        localObject1 = null;
      }
      ((View)localObject3).setTag(localObject1);
      localObject2 = localAddFrdHolder.d;
      localObject1 = localLayoutParams;
      if (bool1) {
        localObject1 = this;
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
      localAddFrdHolder.d.setClickable(bool1);
      localObject1 = localAddFrdHolder.h;
      if (this.b) {
        i = j;
      } else {
        i = 8;
      }
      ((CheckBox)localObject1).setVisibility(i);
      localAddFrdHolder.i.setOnClickListener(this);
      localAddFrdHolder.i.setTag(localAddFrdHolder);
      if (AppSetting.e) {
        localView.setContentDescription(paramView.toString());
      }
    }
    else
    {
      localAddFrdHolder.i.setVisibility(8);
      if (this.c.z == TroopAddFrdsInnerFrame.x)
      {
        localAddFrdHolder.j.setVisibility(0);
        paramView = String.valueOf(this.c.n[i]);
        localAddFrdHolder.j.setText(paramView);
        localAddFrdHolder.j.setContentDescription(String.format(this.c.f.getString(2131888769), new Object[] { paramView.toLowerCase() }));
      }
      else
      {
        localAddFrdHolder.j.setVisibility(8);
        localView.setBackgroundResource(0);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 != null)
    {
      int i = paramView.getId();
      if (i == 2131447915)
      {
        localObject1 = (TroopMemberInfo)localObject1;
        TroopAddFrdsInnerFrame.a(this.c.f, (TroopMemberInfo)localObject1, TroopAddFrdsInnerFrame.c(this.c), false);
      }
      else if (i == 2131442295)
      {
        Object localObject2;
        if (this.b)
        {
          localObject1 = (TroopAddFrdsInnerFrame.AddFrdHolder)localObject1;
          boolean bool = a(((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).g);
          localObject2 = new ResultRecord();
          ((ResultRecord)localObject2).uin = ((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).g.memberuin;
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(localObject2);
          if (!bool)
          {
            this.c.f.addFriendResults(localArrayList, false);
          }
          else
          {
            this.c.f.removeFriendFromResultList(((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).g.memberuin);
            this.c.f.updateMultiAddState((ResultRecord)localObject2, false);
            this.c.f.mSelectedAndSearchBar.a(false);
            this.c.f.setupDoneBtn();
          }
          notifyDataSetChanged();
        }
        else
        {
          localObject1 = ((TroopAddFrdsInnerFrame.AddFrdHolder)localObject1).g;
          localObject2 = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this.c.f, null);
          ((Intent)localObject2).putExtra("troopUin", ((TroopMemberInfo)localObject1).troopuin);
          ((Intent)localObject2).putExtra("memberUin", ((TroopMemberInfo)localObject1).memberuin);
          ((Intent)localObject2).putExtra("fromFlag", 1);
          ((Intent)localObject2).putExtra("selfSet_leftViewText", this.c.f.getString(2131917557));
          ((Intent)localObject2).putExtra("custom_leftbackbutton_name", this.c.f.getString(2131887625));
          ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).joinFriendProfileIntentWithTroopMemberCardIntent(this.c.f, this.c.h, (Intent)localObject2, 9);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.ListAdapter
 * JD-Core Version:    0.7.0.1
 */