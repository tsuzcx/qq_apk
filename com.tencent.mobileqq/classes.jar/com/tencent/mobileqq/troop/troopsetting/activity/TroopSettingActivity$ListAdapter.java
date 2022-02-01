package com.tencent.mobileqq.troop.troopsetting.activity;

import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.text.Spannable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopSettingActivity$ListAdapter
  extends BaseAdapter
{
  private boolean b = true;
  
  public TroopSettingActivity$ListAdapter(TroopSettingActivity paramTroopSettingActivity)
  {
    a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("construct ListAdapter  memberUins.size = ");
      localStringBuilder.append(paramTroopSettingActivity.C);
      int i;
      if (localStringBuilder.toString() != null) {
        i = paramTroopSettingActivity.C.size();
      } else {
        i = -1;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i) });
    }
  }
  
  private void a()
  {
    boolean bool;
    if ((TroopInfo.hasPayPrivilege(this.a.i.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.i.mTroopPrivilegeFlag, 512))) {
      bool = true;
    } else {
      bool = false;
    }
    if (((!this.a.i.mMemberInvitingFlag) && (!this.a.i.isOwnerOrAdim())) || ((!this.a.i.isOwnerOrAdim()) && (this.a.i.cGroupOption == 3) && (!bool)))
    {
      this.b = false;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("隐藏邀请按钮：mMemberInvitingFlag=");
        localStringBuilder.append(this.a.i.mMemberInvitingFlag);
        localStringBuilder.append(", mTroopInfoData.isOwnerOrAdim() = ");
        localStringBuilder.append(this.a.i.isOwnerOrAdim());
        localStringBuilder.append(", mTroopInfoData.cGroupOption=");
        localStringBuilder.append(this.a.i.cGroupOption);
        localStringBuilder.append(", isPayToJoinTroop=");
        localStringBuilder.append(bool);
        QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
      }
    }
    else
    {
      this.b = true;
    }
  }
  
  public int getCount()
  {
    int i;
    if (this.a.C == null) {
      i = 0;
    } else {
      i = this.a.C.size();
    }
    int j = i;
    if (this.b)
    {
      j = i;
      if (i != 0) {
        j = i + 1;
      }
    }
    return Math.min(5, j);
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.a.C != null) && (paramInt < this.a.C.size())) {
      return this.a.C.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    TroopSettingActivity.ViewHolder localViewHolder;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.a.getLayoutInflater().inflate(2131624461, null);
      localView.setMinimumHeight(ViewUtils.dpToPx(57.0F));
      localViewHolder = new TroopSettingActivity.ViewHolder();
      localViewHolder.a = ((ImageView)localView.findViewById(2131435219));
      localObject1 = (RelativeLayout.LayoutParams)localViewHolder.a.getLayoutParams();
      int i = ViewUtils.dpToPx(35.0F);
      ((RelativeLayout.LayoutParams)localObject1).height = i;
      ((RelativeLayout.LayoutParams)localObject1).width = i;
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ViewUtils.dpToPx(7.0F);
      localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localViewHolder.b = ((TextView)localView.findViewById(2131439121));
      localView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (TroopSettingActivity.ViewHolder)paramView.getTag();
      localView = paramView;
    }
    localView.setVisibility(0);
    localView.setFocusable(false);
    TextView localTextView = localViewHolder.b;
    ImageView localImageView = localViewHolder.a;
    if ((this.b) && (paramInt == getCount() - 1))
    {
      localTextView.setText(this.a.getString(2131891027));
      localTextView.setTextColor(this.a.getResources().getColor(2131167997));
      localImageView.setBackgroundDrawable(null);
      localImageView.setImageResource(2130839320);
      localImageView.setOnTouchListener(this.a.ba);
      localImageView.setEnabled(true);
      localImageView.setTag(Integer.valueOf(2));
      localViewHolder.c = "";
    }
    else if (paramInt < this.a.C.size())
    {
      localImageView.setImageResource(2130846392);
      localTextView.setTextColor(this.a.getResources().getColor(2131167997));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.a.C.get(paramInt));
      ((StringBuilder)localObject1).append("");
      String str = ((StringBuilder)localObject1).toString();
      localViewHolder.c = str;
      if (TextUtils.isEmpty(str))
      {
        localTextView.setText("");
        localImageView.setImageDrawable(BaseImageUtil.j());
      }
      else
      {
        Object localObject2;
        if (((ITroopMemberInfoService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopMemberInfoService.class, "")).isMemberInCache(this.a.t.troopuin, str))
        {
          localObject2 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopMemberName(TroopSettingActivity.a(this.a), this.a.t.troopuin, str, true);
        }
        else
        {
          ((ITroopMemberNameService)TroopSettingActivity.a(this.a).getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberNameAsync(this.a.t.troopuin, str, new TroopSettingActivity.ListAdapter.1(this, localViewHolder, str, localTextView));
          localObject2 = str;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = str;
          }
          localObject2 = localObject1;
          if (this.a.u)
          {
            localObject2 = localObject1;
            if (TextUtils.isDigitsOnly((CharSequence)localObject1)) {
              localObject2 = HardCodeUtil.a(2131899985);
            }
          }
          localObject1 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText((CharSequence)localObject2, 12);
          localTextView.setText((CharSequence)localObject1);
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(TroopSettingActivity.a(this.a), localTextView, (Spannable)localObject1);
        }
        this.a.a(localViewHolder, null, true);
        localImageView.setTag(2131446818, str);
        localImageView.setTag(Integer.valueOf(3));
      }
    }
    if (AppSetting.e) {
      ViewCompat.setImportantForAccessibility(localImageView, 2);
    }
    localImageView.setOnClickListener(this.a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "notifyDataSetChanged");
    }
    a();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */