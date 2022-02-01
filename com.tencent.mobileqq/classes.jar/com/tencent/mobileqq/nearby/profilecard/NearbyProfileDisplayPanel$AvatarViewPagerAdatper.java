package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.widget.GridView;
import java.util.Collection;
import java.util.Map;

public class NearbyProfileDisplayPanel$AvatarViewPagerAdatper
  extends AvatarWallPagerAdapter<GridView>
{
  protected LinearLayout.LayoutParams a;
  
  public NearbyProfileDisplayPanel$AvatarViewPagerAdatper(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel, AvatarWallViewPager paramAvatarWallViewPager)
  {
    super(paramAvatarWallViewPager);
  }
  
  public View a(int paramInt, GridView paramGridView)
  {
    paramGridView = this.b;
    return NearbyProfileDisplayPanel.a(paramGridView, paramGridView.k, paramInt);
  }
  
  public View a(boolean paramBoolean, int paramInt)
  {
    View localView = new View(this.b.b);
    if (this.a == null)
    {
      this.a = new LinearLayout.LayoutParams(UIUtils.a(this.b.b, 30.0F), UIUtils.a(this.b.b, 1.5F));
      this.a.leftMargin = UIUtils.a(this.b.b, 2.0F);
      this.a.rightMargin = UIUtils.a(this.b.b, 2.0F);
    }
    localView.setLayoutParams(this.a);
    if (paramBoolean)
    {
      localView.setBackgroundColor(-1);
      return localView;
    }
    localView.setBackgroundColor(1728053247);
    return localView;
  }
  
  public void a(int paramInt, View paramView)
  {
    this.b.d.values().remove(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.AvatarViewPagerAdatper
 * JD-Core Version:    0.7.0.1
 */