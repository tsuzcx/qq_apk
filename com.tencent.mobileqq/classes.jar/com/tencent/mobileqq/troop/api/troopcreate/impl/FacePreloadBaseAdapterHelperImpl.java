package com.tencent.mobileqq.troop.api.troopcreate.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.selectmember.SelectBuddyChildTag;
import com.tencent.mobileqq.troop.api.troopcreate.IFacePreloadBaseAdapterHelper;
import com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter.SelectBuddyChildTag;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import mqq.app.AppRuntime;

public class FacePreloadBaseAdapterHelperImpl
  implements IFacePreloadBaseAdapterHelper
{
  public static final String TAG = "RelationFriendsTroopViewHelper";
  private AppInterface mApp;
  
  public View getBuddyListRelationTroopView(View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, Entity paramEntity)
  {
    paramEntity = (RelationTroopEntity)paramEntity;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131626500, paramViewGroup, false);
      paramViewGroup = new SelectBuddyChildTag();
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131435219));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439121));
      paramViewGroup.g = ((CheckBox)paramView.findViewById(2131430688));
      paramViewGroup.a = paramView.findViewById(2131448716);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131448537).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    paramViewGroup.g.setVisibility(8);
    paramViewGroup.a.setVisibility(8);
    paramViewGroup.h = paramEntity;
    paramViewGroup.y = paramEntity.troopInfo.troopuin;
    int i;
    if (paramEntity.troopInfo.hasSetTroopHead()) {
      i = 4;
    } else {
      i = 113;
    }
    paramContext = FaceDrawable.getFaceDrawable(this.mApp, i, paramEntity.troopInfo.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
    paramViewGroup.A.setImageDrawable(paramContext);
    paramContext = paramEntity.troopInfo.getTroopDisplayName();
    paramViewGroup.e.setText(paramContext);
    return paramView;
  }
  
  public View getContactListRelationTroopView(View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, Entity paramEntity)
  {
    paramEntity = (RelationTroopEntity)paramEntity;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131626500, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.SelectBuddyChildTag();
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131435219));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439121));
      paramViewGroup.g = ((CheckBox)paramView.findViewById(2131430688));
      paramViewGroup.a = paramView.findViewById(2131448716);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131448537).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    paramViewGroup.g.setVisibility(8);
    paramViewGroup.a.setVisibility(8);
    paramViewGroup.h = paramEntity;
    paramViewGroup.y = paramEntity.troopInfo.troopuin;
    int i;
    if (paramEntity.troopInfo.hasSetTroopHead()) {
      i = 4;
    } else {
      i = 113;
    }
    paramContext = FaceDrawable.getFaceDrawable(this.mApp, i, paramEntity.troopInfo.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
    paramViewGroup.A.setImageDrawable(paramContext);
    paramContext = paramEntity.troopInfo.getTroopDisplayName();
    paramViewGroup.e.setText(paramContext);
    return paramView;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.FacePreloadBaseAdapterHelperImpl
 * JD-Core Version:    0.7.0.1
 */