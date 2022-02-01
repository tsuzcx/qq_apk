package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ToggleButton;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ProfileLabelPanelAdapter
  extends PagerAdapter
  implements View.OnClickListener
{
  protected List<ProfileLabelTypeInfo> a;
  protected PanelRecycleBin b = new PanelRecycleBin();
  protected Context c;
  protected int d;
  protected float e;
  protected ProfileLabelCallBack f;
  protected ProfileLabelPanelAdapter.AllLabelGridViewAdapter g;
  protected SparseArray<ProfileLabelPanelAdapter.AllLabelGridViewAdapter> h;
  protected ProfileLabelPanel.LabelStatusManager i;
  
  public ProfileLabelPanelAdapter(Context paramContext, List<ProfileLabelTypeInfo> paramList)
  {
    this.c = paramContext;
    this.a = paramList;
    this.e = paramContext.getResources().getDisplayMetrics().density;
    this.d = this.a.size();
  }
  
  protected GridView a()
  {
    GridView localGridView = new GridView(this.c);
    float f1 = this.e;
    localGridView.setPadding((int)(f1 * 10.0F), 0, (int)(f1 * 10.0F), 0);
    localGridView.setNumColumns(4);
    localGridView.setHorizontalSpacing((int)(this.e * 4.0F));
    localGridView.setVerticalSpacing((int)(this.e * 4.0F));
    return localGridView;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (this.h == null) {
      this.h = new SparseArray();
    }
    this.g = ((ProfileLabelPanelAdapter.AllLabelGridViewAdapter)this.h.get(paramInt));
    if (this.g == null)
    {
      this.g = new ProfileLabelPanelAdapter.AllLabelGridViewAdapter(this, null);
      this.h.put(paramInt, this.g);
    }
    paramView = (GridView)paramView;
    this.g.a(((ProfileLabelTypeInfo)this.a.get(paramInt)).labels);
    paramView.setAdapter(this.g);
  }
  
  public void a(ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this.f = paramProfileLabelCallBack;
  }
  
  public void a(ProfileLabelPanel.LabelStatusManager paramLabelStatusManager)
  {
    this.i = paramLabelStatusManager;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    GridView localGridView = (GridView)paramObject;
    ((ViewGroup)paramView).removeView(localGridView);
    this.b.addScrapView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.d;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    GridView localGridView2 = (GridView)this.b.getScrapView();
    GridView localGridView1 = localGridView2;
    if (localGridView2 == null) {
      localGridView1 = a();
    }
    a(localGridView1, paramInt);
    if ((localGridView1.getParent() != paramView) && (paramInt < getCount())) {
      ((ViewGroup)paramView).addView(localGridView1);
    }
    return localGridView1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onClick(View paramView)
  {
    ToggleButton localToggleButton = (ToggleButton)paramView;
    localToggleButton.toggle();
    ProfileLabelInfo localProfileLabelInfo = (ProfileLabelInfo)paramView.getTag();
    if (localProfileLabelInfo != null)
    {
      ProfileLabelCallBack localProfileLabelCallBack = this.f;
      boolean bool;
      if (localProfileLabelInfo.labelStatus == ProfileLabelInfo.STATUS_CHECKED) {
        bool = false;
      } else {
        bool = true;
      }
      localProfileLabelCallBack.a(localProfileLabelInfo, localToggleButton, Boolean.valueOf(bool));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanelAdapter
 * JD-Core Version:    0.7.0.1
 */