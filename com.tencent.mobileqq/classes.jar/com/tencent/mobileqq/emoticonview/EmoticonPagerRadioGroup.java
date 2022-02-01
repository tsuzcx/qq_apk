package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
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
    EmoticonPagerRadioGroup.1 local1 = new EmoticonPagerRadioGroup.1(this, getContext());
    if (paramInt == 2)
    {
      local1.setButtonDrawable(2130850878);
    }
    else if (paramInt == 3)
    {
      local1.setButtonDrawable(2130850879);
    }
    else if (paramInt == 4)
    {
      local1.setButtonDrawable(2130850891);
    }
    else
    {
      i = this.indicatorDrawable;
      if (i == 0) {
        local1.setButtonDrawable(2130850890);
      } else {
        local1.setButtonDrawable(i);
      }
    }
    local1.setGravity(17);
    Resources localResources = super.getContext().getResources();
    float f1 = 13.0F;
    float f2 = 10.0F;
    if (paramInt == 2)
    {
      f1 = 15.0F;
      f2 = 15.0F;
    }
    else if (paramInt == 3)
    {
      f1 = 24.0F;
    }
    else if (paramInt == 4)
    {
      f2 = 13.0F;
    }
    else
    {
      f1 = 10.0F;
    }
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
  }
  
  public ViewPager getViewPager()
  {
    return this.viewPager;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mOnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.mOnPageChangeListener;
    if (localOnPageChangeListener != null) {
      localOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.mOnPageChangeListener;
    if (localObject != null) {
      ((ViewPager.OnPageChangeListener)localObject).onPageSelected(paramInt);
    }
    if (super.getChildCount() > paramInt)
    {
      if (this.mIsClassicPage)
      {
        int j = SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT;
        int k = this.EMOTICON_SYSTEM_PAGE_COUNT;
        if (((this.lastClassicPageIndex == j) && (paramInt == j - 1)) || (paramInt == 0))
        {
          this.emojiButton.setVisibility(8);
          this.systemButton.setVisibility(0);
          if (j > k)
          {
            i = k + 1;
            while (i <= j)
            {
              localObject = (RadioButton)super.getChildAt(i);
              if (localObject != null) {
                ((RadioButton)localObject).setVisibility(0);
              }
              i += 1;
            }
          }
          if (j < k)
          {
            i = j + 1;
            while (i <= k)
            {
              localObject = (RadioButton)super.getChildAt(i);
              if (localObject != null) {
                ((RadioButton)localObject).setVisibility(8);
              }
              i += 1;
            }
          }
          this.mClassicMode = MODE_EMOJI;
        }
        else if ((paramInt == j) || (paramInt == j + k - 1))
        {
          this.emojiButton.setVisibility(0);
          this.systemButton.setVisibility(8);
          if (j > k)
          {
            i = k + 1;
            while (i <= j)
            {
              localObject = (RadioButton)super.getChildAt(i);
              if (localObject != null) {
                ((RadioButton)localObject).setVisibility(8);
              }
              i += 1;
            }
          }
          if (j < k)
          {
            i = j + 1;
            while (i <= k)
            {
              localObject = (RadioButton)super.getChildAt(i);
              if (localObject != null) {
                ((RadioButton)localObject).setVisibility(0);
              }
              i += 1;
            }
          }
          this.mClassicMode = MODE_SYSTEM;
        }
        if (this.mClassicMode == MODE_EMOJI) {
          i = paramInt + 1;
        } else {
          i = paramInt - (j - 1);
        }
        this.lastClassicPageIndex = paramInt;
        paramInt = i;
      }
      else
      {
        this.lastClassicPageIndex = -1;
      }
      int i = paramInt;
      if (paramInt >= super.getChildCount()) {
        i = super.getChildCount() - 1;
      }
      localObject = (RadioButton)super.getChildAt(i);
      if (localObject != null) {
        ((RadioButton)localObject).setChecked(true);
      }
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
    if ((paramInt > 0) && (this.viewPager != null))
    {
      RadioButton localRadioButton = (RadioButton)super.getChildAt(0);
      if (!paramBoolean)
      {
        paramInt = this.indicatorDrawable;
        if (paramInt == 0) {
          localRadioButton.setButtonDrawable(2130850890);
        } else {
          localRadioButton.setButtonDrawable(paramInt);
        }
      }
      localRadioButton = (RadioButton)super.getChildAt(this.viewPager.getCurrentItem());
      if (localRadioButton != null) {
        localRadioButton.setChecked(true);
      }
    }
    paramInt = 0;
    while (paramInt < getChildCount())
    {
      ((RadioButton)super.getChildAt(paramInt)).setVisibility(0);
      paramInt += 1;
    }
    this.mIsClassicPage = false;
  }
  
  public void synClassicButton(int paramInt)
  {
    this.EMOTICON_SYSTEM_PAGE_COUNT = paramInt;
    if (!this.mIsClassicPage)
    {
      removeAllViews();
      int k = SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT;
      int m = Math.max(SystemAndEmojiEmoticonInfo.EMOTICON_EMOJI_PAGE_COUNT, paramInt);
      super.addView(this.emojiButton);
      int j = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerRadioGroup
 * JD-Core Version:    0.7.0.1
 */