package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonPanel
  extends SystemEmoticonPanel
{
  public SystemAndEmojiEmoticonPanel(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    super(paramContext, paramEmoticonCallback);
  }
  
  protected void initUI(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.pageRadioGroup = ((EmoticonPagerRadioGroup)this.root.findViewById(2131375962));
    this.viewPager = ((ViewPager)this.root.findViewById(2131380822));
    this.pageAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    paramContext = new ClassicEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 9);
    localArrayList.add(paramContext);
    this.pageAdapter.setViewBinderList(localArrayList);
    this.viewPager.setAdapter(this.pageAdapter);
    this.pageRadioGroup.setViewPager(this.viewPager);
    this.pageRadioGroup.synClassicButton(paramContext.getSystemPageCount());
    this.viewPager.setCurrentItem(9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */