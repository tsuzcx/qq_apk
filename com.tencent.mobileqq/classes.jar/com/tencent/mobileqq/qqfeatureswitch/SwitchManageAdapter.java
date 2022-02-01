package com.tencent.mobileqq.qqfeatureswitch;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class SwitchManageAdapter
  extends BaseAdapter
{
  private List<FeatureSwitch> a;
  private QBaseActivity b;
  
  public SwitchManageAdapter(QBaseActivity paramQBaseActivity)
  {
    this.b = paramQBaseActivity;
  }
  
  private void a(int paramInt, FormSwitchItem paramFormSwitchItem)
  {
    b(paramFormSwitchItem);
    FeatureSwitch localFeatureSwitch = (FeatureSwitch)this.a.get(paramInt);
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setText(localFeatureSwitch.mSwitchName);
    paramFormSwitchItem.setChecked(localFeatureSwitch.mSwitchEnable);
    paramFormSwitchItem.setOnCheckedChangeListener(new SwitchManageAdapter.1(this, localFeatureSwitch));
  }
  
  private void a(FormSwitchItem paramFormSwitchItem)
  {
    paramFormSwitchItem = paramFormSwitchItem.getTextView();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramFormSwitchItem.getLayoutParams();
    localLayoutParams.addRule(0, 2131433632);
    localLayoutParams.rightMargin = BaseApplication.getContext().getResources().getDimensionPixelSize(2131298976);
    paramFormSwitchItem.setLayoutParams(localLayoutParams);
  }
  
  private void b(FormSwitchItem paramFormSwitchItem)
  {
    paramFormSwitchItem.setEnabled(false);
    paramFormSwitchItem.setClickable(false);
  }
  
  public void a(List<FeatureSwitch> paramList)
  {
    this.a = paramList;
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.b).inflate(2131629364, paramViewGroup, false);
      a((FormSwitchItem)localView);
    }
    a(paramInt, (FormSwitchItem)localView);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.SwitchManageAdapter
 * JD-Core Version:    0.7.0.1
 */