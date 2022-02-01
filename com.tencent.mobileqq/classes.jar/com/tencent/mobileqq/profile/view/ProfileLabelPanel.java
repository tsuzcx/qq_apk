package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.CirclePageIndicator;
import java.util.List;

public class ProfileLabelPanel
  extends RelativeLayout
  implements ViewPager.OnPageChangeListener
{
  protected ViewPager a;
  protected CirclePageIndicator b;
  protected View c;
  protected TextView d;
  protected TextView e;
  protected ProfileLabelPanelAdapter f;
  protected List<ProfileLabelTypeInfo> g;
  protected ProfileLabelPanel.LabelStatusManager h;
  
  public ProfileLabelPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProfileLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProfileLabelPanel(Context paramContext, ProfileLabelPanel.LabelStatusManager paramLabelStatusManager, List<ProfileLabelTypeInfo> paramList, ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this(paramContext);
    this.c = LayoutInflater.from(paramContext).inflate(2131628448, this);
    this.g = paramList;
    this.h = paramLabelStatusManager;
    a(paramContext, paramProfileLabelCallBack);
  }
  
  protected void a(Context paramContext, ProfileLabelCallBack paramProfileLabelCallBack)
  {
    this.e = ((TextView)this.c.findViewById(2131446780));
    this.d = ((TextView)this.c.findViewById(2131446783));
    this.e.setText(((ProfileLabelTypeInfo)this.g.get(0)).typeInfo);
    this.d.setText(((ProfileLabelTypeInfo)this.g.get(0)).typeName);
    this.b = ((CirclePageIndicator)this.c.findViewById(2131439785));
    this.a = ((ViewPager)this.c.findViewById(2131449793));
    this.f = new ProfileLabelPanelAdapter(paramContext, this.g);
    this.f.a(paramProfileLabelCallBack);
    this.f.a(this.h);
    this.a.setAdapter(this.f);
    this.a.setCurrentItem(0);
    this.b.setViewPager(this.a);
    this.b.setOnPageChangeListener(this);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReportController.b(null, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "3", "", "", "");
    ProfileLabelTypeInfo localProfileLabelTypeInfo = (ProfileLabelTypeInfo)this.g.get(paramInt);
    this.e.setText(localProfileLabelTypeInfo.typeInfo);
    this.d.setText(localProfileLabelTypeInfo.typeName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileLabelPanel
 * JD-Core Version:    0.7.0.1
 */