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
      paramView = LayoutInflater.from(paramContext).inflate(2131560455, paramViewGroup, false);
      paramViewGroup = new SelectBuddyChildTag();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368343));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371697));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379859);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131379732).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_JavaLangObject = paramEntity;
    paramViewGroup.jdField_a_of_type_JavaLangString = paramEntity.troopInfo.troopuin;
    int i;
    if (paramEntity.troopInfo.hasSetTroopHead()) {
      i = 4;
    } else {
      i = 113;
    }
    paramContext = FaceDrawable.getFaceDrawable(this.mApp, i, paramEntity.troopInfo.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
    paramViewGroup.c.setImageDrawable(paramContext);
    paramContext = paramEntity.troopInfo.getTroopDisplayName();
    paramViewGroup.d.setText(paramContext);
    return paramView;
  }
  
  public View getContactListRelationTroopView(View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, Entity paramEntity)
  {
    paramEntity = (RelationTroopEntity)paramEntity;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramContext).inflate(2131560455, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.SelectBuddyChildTag();
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131368343));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371697));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379859);
      if (paramOnClickListener != null) {
        paramView.setOnClickListener(paramOnClickListener);
      }
      paramView.findViewById(2131379732).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramViewGroup.jdField_a_of_type_JavaLangObject = paramEntity;
    paramViewGroup.jdField_a_of_type_JavaLangString = paramEntity.troopInfo.troopuin;
    int i;
    if (paramEntity.troopInfo.hasSetTroopHead()) {
      i = 4;
    } else {
      i = 113;
    }
    paramContext = FaceDrawable.getFaceDrawable(this.mApp, i, paramEntity.troopInfo.troopuin, 3, FaceDrawable.getDefaultDrawable(4, 3), FaceDrawable.getDefaultDrawable(4, 3));
    paramViewGroup.c.setImageDrawable(paramContext);
    paramContext = paramEntity.troopInfo.getTroopDisplayName();
    paramViewGroup.d.setText(paramContext);
    return paramView;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.impl.FacePreloadBaseAdapterHelperImpl
 * JD-Core Version:    0.7.0.1
 */