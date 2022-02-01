package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import java.util.Collection;
import java.util.Map;

public class NearbyProfileDisplayTribePanel$AvatarWallAdapter
  extends AvatarWallPagerAdapter<PicInfo>
{
  protected LinearLayout.LayoutParams a;
  
  public NearbyProfileDisplayTribePanel$AvatarWallAdapter(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel, AvatarWallViewPager paramAvatarWallViewPager)
  {
    super(paramAvatarWallViewPager);
  }
  
  public View a(int paramInt, PicInfo paramPicInfo)
  {
    return this.b.a(paramInt, paramPicInfo);
  }
  
  public View a(boolean paramBoolean, int paramInt)
  {
    View localView = new View(this.b.e);
    Object localObject;
    if (this.a == null)
    {
      paramInt = UIUtils.a(this.b.e, 5.0F);
      this.a = new LinearLayout.LayoutParams(paramInt, paramInt);
      paramInt = UIUtils.a(this.b.e, 4.0F);
      localObject = this.a;
      paramInt /= 2;
      ((LinearLayout.LayoutParams)localObject).leftMargin = paramInt;
      ((LinearLayout.LayoutParams)localObject).rightMargin = paramInt;
    }
    if (paramBoolean) {
      localObject = BizTroopUtil.a(this.b.e.getResources(), Color.parseColor("#CC12B7F5"), this.b.e.getResources().getDrawable(2130844829));
    } else {
      localObject = BizTroopUtil.a(this.b.e.getResources(), Color.parseColor("#66FFFFFF"), this.b.e.getResources().getDrawable(2130844829));
    }
    localView.setLayoutParams(this.a);
    localView.setBackgroundDrawable((Drawable)localObject);
    return localView;
  }
  
  public void a(int paramInt, View paramView)
  {
    this.b.d.values().remove(paramView);
  }
  
  public boolean a(PicInfo paramPicInfo1, PicInfo paramPicInfo2)
  {
    return this.b.e.picInfoIsEqual(paramPicInfo1, paramPicInfo2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.AvatarWallAdapter
 * JD-Core Version:    0.7.0.1
 */