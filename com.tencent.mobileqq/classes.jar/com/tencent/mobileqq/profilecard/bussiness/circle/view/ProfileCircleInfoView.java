package com.tencent.mobileqq.profilecard.bussiness.circle.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ProfileCircleInfoView
  extends LinearLayout
{
  private static final String INFO_DIVISION = "  ";
  private static final long LONG_ANIMATION_DURATION = 2000L;
  private static final long SHORT_ANIMATION_DURATION = 1200L;
  public static final int STYLE_VALUE_EFFECT = 1;
  public static final int STYLE_VALUE_NONE = 0;
  private static final String TAG = "ProfileCircleInfoView";
  private DynamicEffectTextView mEffectTextView;
  private String mFansText;
  private int mFansValueStyle = 0;
  private String mFuelText;
  private int mFuelValueStyle = 0;
  private TextView mTextView;
  
  public ProfileCircleInfoView(Context paramContext)
  {
    super(paramContext);
    initialized();
  }
  
  public ProfileCircleInfoView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialized();
  }
  
  public ProfileCircleInfoView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialized();
  }
  
  private void addEffectTextView(String paramString, long paramLong)
  {
    if (this.mEffectTextView == null) {}
    CharSequence localCharSequence;
    do
    {
      return;
      localCharSequence = this.mEffectTextView.getText();
    } while ((localCharSequence != null) && (TextUtils.equals(paramString, localCharSequence)));
    this.mEffectTextView.setText(paramString);
    this.mEffectTextView.setDuration(paramLong);
    addView(this.mEffectTextView);
  }
  
  private void addNormalTextView(String paramString)
  {
    if (this.mTextView == null) {}
    CharSequence localCharSequence;
    do
    {
      return;
      localCharSequence = this.mTextView.getText();
    } while ((localCharSequence != null) && (TextUtils.equals(paramString, localCharSequence)));
    this.mTextView.setText(paramString);
    addView(this.mTextView);
  }
  
  private DynamicEffectTextView buildEffectTextView()
  {
    DynamicEffectTextView localDynamicEffectTextView = new DynamicEffectTextView(getContext());
    localDynamicEffectTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localDynamicEffectTextView.setSingleLine(true);
    localDynamicEffectTextView.setTextColor(-13604865);
    localDynamicEffectTextView.setTextSize(2, 12.0F);
    localDynamicEffectTextView.setDrawableResource(2130844236);
    return localDynamicEffectTextView;
  }
  
  private TextView buildNormalTextView()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localTextView.setSingleLine(true);
    localTextView.setTextColor(-7894119);
    localTextView.setTextSize(2, 12.0F);
    return localTextView;
  }
  
  private StringBuilder createStringBuilder(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append("  ");
      return localStringBuilder;
    }
    localStringBuilder.append(paramString);
    return localStringBuilder;
  }
  
  private void initialized()
  {
    this.mTextView = buildNormalTextView();
    this.mEffectTextView = buildEffectTextView();
  }
  
  private boolean isTextChange(String paramString1, String paramString2)
  {
    return (!TextUtils.equals(paramString1, this.mFansText)) || (!TextUtils.equals(paramString2, this.mFuelText));
  }
  
  private boolean isValueStyleChange(int paramInt1, int paramInt2)
  {
    return (paramInt1 != this.mFansValueStyle) || (paramInt2 != this.mFuelValueStyle);
  }
  
  private void refreshCircleInfoLayout()
  {
    if ((TextUtils.isEmpty(this.mFansText)) && (TextUtils.isEmpty(this.mFuelText))) {
      QLog.w("ProfileCircleInfoView", 1, "[buildCircleInfoLayout] fans text and fuel text not is empty.");
    }
    do
    {
      do
      {
        return;
        release();
        if ((this.mFansValueStyle == 1) && (this.mFuelValueStyle == 1))
        {
          addEffectTextView(this.mFuelText, 2000L);
          return;
        }
        if (this.mFansValueStyle != 1) {
          break;
        }
        addEffectTextView(this.mFansText, 1200L);
      } while (TextUtils.isEmpty(this.mFuelText));
      addNormalTextView(this.mFuelText);
      return;
      if (this.mFuelValueStyle == 1)
      {
        if (!TextUtils.isEmpty(this.mFansText)) {
          addNormalTextView(createStringBuilder(this.mFansText, true).toString());
        }
        addEffectTextView(this.mFuelText, 1200L);
        return;
      }
      if ((!TextUtils.isEmpty(this.mFansText)) && (!TextUtils.isEmpty(this.mFuelText)))
      {
        addNormalTextView(this.mFuelText);
        return;
      }
      if (!TextUtils.isEmpty(this.mFansText))
      {
        addNormalTextView(createStringBuilder(this.mFansText, false).toString());
        return;
      }
    } while (TextUtils.isEmpty(this.mFuelText));
    addNormalTextView(createStringBuilder(this.mFuelText, false).toString());
  }
  
  private void release()
  {
    if (this.mEffectTextView != null) {
      this.mEffectTextView.cancelAnimation();
    }
    removeAllViews();
  }
  
  public void onDestroy()
  {
    release();
  }
  
  public void updateCircleInfo(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if ((isTextChange(paramString1, paramString2)) || (isValueStyleChange(paramInt1, paramInt2)))
    {
      QLog.d("ProfileCircleInfoView", 1, new Object[] { "updateCircleInfo fansValueStyle: ", Integer.valueOf(paramInt1), " | fuelValueStyle: ", Integer.valueOf(paramInt2), " | fansText: ", paramString1, " | fuelText: ", paramString2 });
      this.mFansValueStyle = paramInt1;
      this.mFuelValueStyle = paramInt2;
      this.mFansText = paramString1;
      this.mFuelText = paramString2;
      refreshCircleInfoLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.circle.view.ProfileCircleInfoView
 * JD-Core Version:    0.7.0.1
 */