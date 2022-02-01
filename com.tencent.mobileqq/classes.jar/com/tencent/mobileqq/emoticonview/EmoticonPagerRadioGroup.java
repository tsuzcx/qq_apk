package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.tencent.common.config.AppSetting;

public class EmoticonPagerRadioGroup
  extends RadioGroup
  implements ViewPager.OnPageChangeListener
{
  private static int MODE_EMOJI = 2;
  private static int MODE_SYSTEM = 1;
  private static final int RADIO_BUTOON_TYPE_RECENT = 4;
  private static final int RADIO_BUTTON_TYPE_EMOJI = 3;
  private static final int RADIO_BUTTON_TYPE_NORMAL = 1;
  private static final int RADIO_BUTTON_TYPE_SYSTEM = 2;
  private int EMOTICON_SYSTEM_PAGE_COUNT;
  RadioButton emojiButton = createButton(3);
  private int indicatorDrawable;
  private int lastClassicPageIndex = -1;
  private int mClassicMode;
  private boolean mIsClassicPage;
  private ViewPager.OnPageChangeListener mOnPageChangeListener;
  RadioButton recentButton = createButton(4);
  RadioButton systemButton = createButton(2);
  ViewPager viewPager;
  
  public EmoticonPagerRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPagerRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private RadioButton createButton(int paramInt)
  {
    float f1 = 13.0F;
    float f2 = 10.0F;
    EmoticonPagerRadioGroup.1 local1 = new EmoticonPagerRadioGroup.1(this, getContext());
    Resources localResources;
    if (paramInt == 2)
    {
      local1.setButtonDrawable(2130850938);
      local1.setGravity(17);
      localResources = super.getContext().getResources();
      if (paramInt != 2) {
        break label228;
      }
      f1 = 15.0F;
      f2 = 15.0F;
    }
    for (;;)
    {
      RadioGroup.LayoutParams localLayoutParams = new RadioGroup.LayoutParams((int)TypedValue.applyDimension(1, f1, localResources.getDisplayMetrics()), (int)TypedValue.applyDimension(1, f2, localResources.getDisplayMetrics()));
      localLayoutParams.gravity = 17;
      int i = (int)TypedValue.applyDimension(1, 3.0F, localResources.getDisplayMetrics());
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      local1.setLayoutParams(localLayoutParams);
      local1.setClickable(true);
      if ((AppSetting.d) && (paramInt != 3) && (paramInt != 2))
      {
        local1.setClickable(false);
        local1.setFocusable(false);
      }
      return local1;
      if (paramInt == 3)
      {
        local1.setButtonDrawable(2130850939);
        break;
      }
      if (paramInt == 4)
      {
        local1.setButtonDrawable(2130850951);
        break;
      }
      if (this.indicatorDrawable == 0)
      {
        local1.setButtonDrawable(2130850950);
        break;
      }
      local1.setButtonDrawable(this.indicatorDrawable);
      break;
      label228:
      if (paramInt == 3) {
        f1 = 24.0F;
      } else if (paramInt == 4) {
        f2 = 13.0F;
      } else {
        f1 = 10.0F;
      }
    }
  }
  
  public ViewPager getViewPager()
  {
    return this.viewPager;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.mOnPageChangeListener != null) {
      this.mOnPageChangeListener.onPageSelected(paramInt);
    }
    int j;
    int k;
    int i;
    RadioButton localRadioButton;
    if (super.getChildCount() > paramInt)
    {
      if (!this.mIsClassicPage) {
        break label372;
      }
      j = SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT;
      k = this.EMOTICON_SYSTEM_PAGE_COUNT;
      if (((this.lastClassicPageIndex != j) || (paramInt != j - 1)) && (paramInt != 0)) {
        break label232;
      }
      this.emojiButton.setVisibility(8);
      this.systemButton.setVisibility(0);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      this.mClassicMode = MODE_EMOJI;
      if (this.mClassicMode != MODE_EMOJI) {
        break label363;
      }
      i = paramInt + 1;
      label188:
      this.lastClassicPageIndex = paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i >= super.getChildCount()) {
        paramInt = super.getChildCount() - 1;
      }
      localRadioButton = (RadioButton)super.getChildAt(paramInt);
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      return;
      label232:
      if ((paramInt != j) && (paramInt != j + k - 1)) {
        break;
      }
      this.emojiButton.setVisibility(0);
      this.systemButton.setVisibility(8);
      if (j > k)
      {
        i = k + 1;
        while (i <= j)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(8);
          }
          i += 1;
        }
      }
      if (j < k)
      {
        i = j + 1;
        while (i <= k)
        {
          localRadioButton = (RadioButton)super.getChildAt(i);
          if (localRadioButton != null) {
            localRadioButton.setVisibility(0);
          }
          i += 1;
        }
      }
      this.mClassicMode = MODE_SYSTEM;
      break;
      label363:
      i = paramInt - (j - 1);
      break label188;
      label372:
      this.lastClassicPageIndex = -1;
      i = paramInt;
    }
  }
  
  public void reset()
  {
    this.lastClassicPageIndex = -1;
  }
  
  public void setIndicatorDrawable(int paramInt)
  {
    this.indicatorDrawable = paramInt;
  }
  
  public void setPagerChangedListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.viewPager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.setOnPageChangeListener(this);
    }
  }
  
  public void synButton(int paramInt)
  {
    synButton(paramInt, false);
  }
  
  public void synButton(int paramInt, boolean paramBoolean)
  {
    super.removeView(this.systemButton);
    super.removeView(this.emojiButton);
    removeAllViews();
    if (paramBoolean) {
      super.addView(this.recentButton);
    }
    this.lastClassicPageIndex = -1;
    int j = getChildCount();
    int i;
    if (paramInt > j)
    {
      i = 0;
      while (i < paramInt - j)
      {
        super.addView(createButton(1));
        i += 1;
      }
    }
    if (paramInt < j)
    {
      i = j - 1;
      while (i >= paramInt)
      {
        super.removeViewAt(i);
        i -= 1;
      }
    }
    RadioButton localRadioButton;
    if ((paramInt > 0) && (this.viewPager != null))
    {
      localRadioButton = (RadioButton)super.getChildAt(0);
      if (!paramBoolean)
      {
        if (this.indicatorDrawable != 0) {
          break label198;
        }
        localRadioButton.setButtonDrawable(2130850950);
      }
    }
    for (;;)
    {
      localRadioButton = (RadioButton)super.getChildAt(this.viewPager.getCurrentItem());
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
      paramInt = 0;
      while (paramInt < getChildCount())
      {
        ((RadioButton)super.getChildAt(paramInt)).setVisibility(0);
        paramInt += 1;
      }
      label198:
      localRadioButton.setButtonDrawable(this.indicatorDrawable);
    }
    this.mIsClassicPage = false;
  }
  
  public void synClassicButton(int paramInt)
  {
    int j = 0;
    this.EMOTICON_SYSTEM_PAGE_COUNT = paramInt;
    if (!this.mIsClassicPage)
    {
      removeAllViews();
      int k = SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT;
      int m = Math.max(SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT, paramInt);
      super.addView(this.emojiButton);
      int i = 0;
      while (i < m)
      {
        super.addView(createButton(1));
        i += 1;
      }
      super.addView(this.systemButton);
      i = j;
      while (i < k + paramInt - m - 2)
      {
        RadioButton localRadioButton = createButton(1);
        localRadioButton.setVisibility(8);
        super.addView(localRadioButton);
        i += 1;
      }
    }
    this.mIsClassicPage = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */