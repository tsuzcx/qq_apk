package com.tencent.mobileqq.selectmember;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TroopMemberListInnerFrame$TroopMemberListAdapter
  extends CharDividedFacePreloadBaseAdapter
{
  public TroopMemberListInnerFrame$TroopMemberListAdapter(TroopMemberListInnerFrame paramTroopMemberListInnerFrame)
  {
    super(paramTroopMemberListInnerFrame.f, paramTroopMemberListInnerFrame.h, paramTroopMemberListInnerFrame.d, true);
  }
  
  public int a()
  {
    if (this.a.r.length > 0) {
      return 2131625258;
    }
    return 0;
  }
  
  public void a(View paramView, int paramInt)
  {
    Arrays.binarySearch(this.a.q, paramInt);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.a.q, paramInt) >= 0;
  }
  
  public int b()
  {
    Iterator localIterator = this.a.p.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((List)this.a.p.get(localIterator.next())).size();
    }
    return i;
  }
  
  public int b(String paramString)
  {
    if (this.a.r != null)
    {
      int i = 0;
      while (i < this.a.r.length)
      {
        if (this.a.r[i].equals(paramString)) {
          break label52;
        }
        i += 1;
      }
      i = -1;
      label52:
      if (i >= 0) {
        return this.a.q[i];
      }
    }
    return -1;
  }
  
  public int getCount()
  {
    int[] arrayOfInt = this.a.q;
    int i = 0;
    if (arrayOfInt != null)
    {
      if (this.a.p == null) {
        return 0;
      }
      if (this.a.q.length == 0) {
        return 0;
      }
      i = this.a.q[(this.a.q.length - 1)] + ((List)this.a.p.get(this.a.r[(this.a.r.length - 1)])).size() + 1;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.a.q, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (TroopMemberInfo)((List)this.a.p.get(this.a.r[i])).get(paramInt - this.a.q[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.a.q, paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.a.i.inflate(2131629265, paramViewGroup, false);
      paramView = new TroopMemberListInnerFrame.ViewHolder(this.a, null);
      localView.setTag(paramView);
      paramView.g = ((RelativeLayout)localView.findViewById(2131444983));
      paramView.h = ((TextView)localView.findViewById(2131448537));
      paramView.a = ((CheckBox)localView.findViewById(2131430688));
      paramView.A = ((ImageView)localView.findViewById(2131435219));
      paramView.i = ((TextView)localView.findViewById(2131439121));
      paramView.j = localView.findViewById(2131448716);
      paramView.b = ((TextView)localView.findViewById(2131448620));
      paramView.c = ((ImageView)localView.findViewById(2131448779));
      paramView.d = ((TextView)localView.findViewById(2131448627));
    }
    else
    {
      localView = paramView;
    }
    TroopMemberListInnerFrame.ViewHolder localViewHolder = (TroopMemberListInnerFrame.ViewHolder)localView.getTag();
    if (i < 0)
    {
      i = -(i + 1) - 1;
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((List)this.a.p.get(this.a.r[i])).get(paramInt - this.a.q[i] - 1);
      if (this.a.f.isResultListContainFriend(localTroopMemberInfo.memberuin)) {
        localViewHolder.a.setChecked(true);
      } else {
        localViewHolder.a.setChecked(false);
      }
      localViewHolder.g.setVisibility(0);
      localViewHolder.h.setVisibility(8);
      localViewHolder.A.setImageBitmap(a(localTroopMemberInfo.memberuin));
      String str = CommonUtils.a(this.a.h, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin);
      if (this.a.f.mEntrance == 21)
      {
        if ((TroopMemberListInnerFrame.b(this.a) != null) && (TroopMemberListInnerFrame.b(this.a).isTroopOwner(localTroopMemberInfo.memberuin)) && (this.a.w != null) && (this.a.w.getTag() != null))
        {
          paramView = new StringBuilder();
          paramView.append("[tag]");
          paramView.append(" ");
          paramView.append(str);
          paramView = new SpannableString(paramView.toString());
          paramView.setSpan(new ImageSpan(this.a.f, (Bitmap)this.a.w.getTag()), 0, 5, 18);
        }
        else if ((this.a.v != null) && (this.a.v.getTag() != null))
        {
          paramView = new StringBuilder();
          paramView.append("[tag]");
          paramView.append(" ");
          paramView.append(str);
          paramView = new SpannableString(paramView.toString());
          paramView.setSpan(new ImageSpan(this.a.f, (Bitmap)this.a.v.getTag()), 0, 5, 18);
        }
        else
        {
          paramView = null;
        }
        localViewHolder.i.setText(paramView);
      }
      else
      {
        localViewHolder.i.setText(CommonUtils.a(this.a.h, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin));
      }
      localViewHolder.y = localTroopMemberInfo.memberuin;
      if (localViewHolder.j != null) {
        if (CommonUtils.c(this.a.h, localTroopMemberInfo.memberuin)) {
          localViewHolder.j.setVisibility(0);
        } else {
          localViewHolder.j.setVisibility(8);
        }
      }
      if ((this.a.f.mUinsSelectedDefault != null) && (this.a.f.mUinsSelectedDefault.contains(localTroopMemberInfo.memberuin))) {
        localViewHolder.a.setEnabled(false);
      } else {
        localViewHolder.a.setEnabled(true);
      }
      if ((AppSetting.e) && (localViewHolder.a.isEnabled()))
      {
        if (localViewHolder.a.isChecked())
        {
          paramView = new StringBuilder();
          paramView.append(str);
          paramView.append(HardCodeUtil.a(2131912806));
          localView.setContentDescription(paramView.toString());
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append(str);
          paramView.append(HardCodeUtil.a(2131912829));
          localView.setContentDescription(paramView.toString());
        }
      }
      else if ((this.a.f.mEntrance == 14) && (!localViewHolder.a.isEnabled()))
      {
        paramView = new StringBuilder();
        paramView.append(str);
        paramView.append(HardCodeUtil.a(2131912819));
        localView.setContentDescription(paramView.toString());
      }
      localView.setOnClickListener(this.a);
      if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.a.f)) {
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).updateGameView(this.a.h, this.a.f, localTroopMemberInfo, localViewHolder.b, localViewHolder.c, localViewHolder.d);
      }
    }
    else
    {
      localViewHolder.g.setVisibility(8);
      localViewHolder.h.setVisibility(0);
      paramView = String.valueOf(this.a.r[i]);
      localViewHolder.h.setText(paramView);
      localViewHolder.h.setContentDescription(String.format(this.a.f.getString(2131888769), new Object[] { paramView.toLowerCase() }));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.TroopMemberListAdapter
 * JD-Core Version:    0.7.0.1
 */