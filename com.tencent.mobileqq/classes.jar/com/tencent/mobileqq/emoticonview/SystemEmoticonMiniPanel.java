package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class SystemEmoticonMiniPanel
  extends SystemEmoticonPanel
{
  public SystemEmoticonMiniPanel(Context paramContext, EmoticonCallback paramEmoticonCallback, boolean paramBoolean)
  {
    super(paramContext, paramEmoticonCallback, paramBoolean);
  }
  
  protected void initUI(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.pageRadioGroup = ((EmoticonPagerRadioGroup)this.root.findViewById(2131444153));
    this.viewPager = ((ViewPager)this.root.findViewById(2131449793));
    this.pageRadioGroup.setViewPager(this.viewPager);
    this.pageAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new SystemEmoticonPanelMiniBinder(paramContext, paramEmoticonCallback, 0, this.mIsHighDifinition));
    this.pageAdapter.setViewBinderList(localArrayList);
    this.viewPager.setAdapter(this.pageAdapter);
    this.viewPager.setCurrentItem(0);
    this.pageRadioGroup.synButton(this.pageAdapter.getCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonMiniPanel
 * JD-Core Version:    0.7.0.1
 */