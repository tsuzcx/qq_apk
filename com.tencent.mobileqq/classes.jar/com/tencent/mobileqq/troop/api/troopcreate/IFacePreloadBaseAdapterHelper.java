package com.tencent.mobileqq.troop.api.troopcreate;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFacePreloadBaseAdapterHelper
  extends IRuntimeService
{
  public abstract View getBuddyListRelationTroopView(View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, Entity paramEntity);
  
  public abstract View getContactListRelationTroopView(View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, Entity paramEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.IFacePreloadBaseAdapterHelper
 * JD-Core Version:    0.7.0.1
 */