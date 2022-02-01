package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.NoScrollGridView;
import java.util.ArrayList;
import java.util.List;

public class AppsGridViewBuilder
  extends AppsBaseBuilder
{
  protected int a = 0;
  protected boolean l = false;
  protected List<TroopAppShortcutContainer.TroopAppInfo> m = new ArrayList();
  
  public AppsGridViewBuilder(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramContext, paramQQAppInterface, paramBaseActivity, null, paramBundle);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new AppsGridViewBuilder.ItemViewHolder();
      paramView = new NoScrollGridView(this.f);
      paramView.setNumColumns(4);
      paramView.setVerticalSpacing(AIOUtils.b(10.0F, this.f.getResources()));
      paramView.setHorizontalSpacing(AIOUtils.b(13.0F, this.f.getResources()));
      paramView.setPadding(AIOUtils.b(16.0F, this.f.getResources()), AIOUtils.b(6.0F, this.f.getResources()), AIOUtils.b(16.0F, this.f.getResources()), AIOUtils.b(20.0F, this.f.getResources()));
      paramView.setColumnWidth(this.a);
      paramView.setSelector(new ColorDrawable(0));
      paramView.setVerticalScrollBarEnabled(false);
      paramView.setStretchMode(0);
      paramViewGroup.a = new AppsGridViewBuilder.AppsGridViewAdapter(this, this.a);
      paramViewGroup.a.a(this.m);
      paramView.setAdapter(paramViewGroup.a);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      ((AppsGridViewBuilder.ItemViewHolder)paramView.getTag()).a.a(this.m);
    }
    paramView.setClickable(false);
    return paramView;
  }
  
  public void a_(Object paramObject)
  {
    if ((paramObject instanceof ArrayList)) {
      this.m = ((List)paramObject);
    }
  }
  
  public Object b()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsGridViewBuilder
 * JD-Core Version:    0.7.0.1
 */