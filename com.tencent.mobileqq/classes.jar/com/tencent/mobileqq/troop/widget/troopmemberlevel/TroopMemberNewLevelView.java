package com.tencent.mobileqq.troop.widget.troopmemberlevel;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

public class TroopMemberNewLevelView
  extends RelativeLayout
{
  private static final int[] k = { 2130847864, 2130847865, 2130847866, 2130847867, 2130847868, 2130847869, 2130847870, 2130847871, 2130847872, 2130847873, 2130847874 };
  private boolean a = false;
  private boolean b = false;
  private int c = 0;
  private String d = "";
  private float e = 0.0F;
  private int[] f = null;
  private int[] g = null;
  private int h = 0;
  private int i = 0;
  private String j;
  
  public TroopMemberNewLevelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopMemberNewLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopMemberNewLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      paramView.setId(View.generateViewId());
    } else {
      paramView.setId(getChildCount() + 1);
    }
    paramLayoutParams.addRule(15);
  }
  
  private void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    int m = getChildCount();
    if (m >= 1)
    {
      View localView = getChildAt(m - 1);
      if (localView == null) {
        return;
      }
      if (localView.getId() == -1) {
        return;
      }
      paramLayoutParams.addRule(1, localView.getId());
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public float getExpectedWidth()
  {
    Object localObject = String.valueOf(this.c).toCharArray();
    boolean bool = this.b;
    float f1 = 0.0F;
    float f2;
    if ((bool) && (this.a))
    {
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return 0.0F;
        }
        f2 = localObject.length * 5.0F + 14.5F + (localObject.length - 1) * 0.0F + 3.0F;
        f1 = ViewUtils.pxToDp(this.e);
      }
      else
      {
        return 0.0F;
      }
    }
    else
    {
      if (!this.a) {
        break label119;
      }
      f2 = localObject.length * 5.0F + 14.5F;
      f1 = (localObject.length - 1) * 0.0F;
    }
    f1 = f2 + f1 + 4.0F + 1.0F;
    break label145;
    label119:
    if (this.b) {
      f1 = 0.0F + (ViewUtils.pxToDp(this.e) + 4.0F + 4.0F + 1.0F);
    }
    label145:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("width:");
      ((StringBuilder)localObject).append(f1);
      QLog.d("TroopMemberNewLevelView", 2, ((StringBuilder)localObject).toString());
    }
    return ViewUtils.dip2px(f1);
  }
  
  public void setTroopMemberNewLevel(TroopMemberRankItem paramTroopMemberRankItem)
  {
    if (paramTroopMemberRankItem == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel item is null");
      }
      return;
    }
    setTroopMemberNewLevel(paramTroopMemberRankItem.f, paramTroopMemberRankItem.g, paramTroopMemberRankItem.b, paramTroopMemberRankItem.c, paramTroopMemberRankItem.e, paramTroopMemberRankItem.d, paramTroopMemberRankItem.i, paramTroopMemberRankItem.h, paramTroopMemberRankItem.j);
  }
  
  public void setTroopMemberNewLevel(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, String paramString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramBoolean1) && (!paramBoolean2) && ((paramInt1 < 1) || (paramArrayOfInt1 == null) || (paramArrayOfInt1.length < 2)))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("setTroopMemberNewLevel error isShowLevel : ");
        paramString1.append(paramBoolean1);
        paramString1.append(", isShowRank:");
        paramString1.append(paramBoolean2);
        paramString1.append(",newLevel:");
        paramString1.append(paramInt1);
        QLog.d("TroopMemberNewLevelView", 2, paramString1.toString());
      }
      return;
    }
    if ((paramBoolean2) && ((TextUtils.isEmpty(paramString1)) || (paramArrayOfInt2 == null) || (paramArrayOfInt2.length < 2)))
    {
      if (QLog.isColorLevel())
      {
        paramArrayOfInt1 = new StringBuilder();
        paramArrayOfInt1.append("setTroopMemberNewLevel error isShowRank:");
        paramArrayOfInt1.append(paramBoolean2);
        paramArrayOfInt1.append(",rankTitle:");
        paramArrayOfInt1.append(paramString1);
        QLog.d("TroopMemberNewLevelView", 2, paramArrayOfInt1.toString());
      }
      return;
    }
    if ((this.a == paramBoolean1) && (this.b == paramBoolean2) && (this.c == paramInt1) && (this.d.equals(paramString1)) && (Arrays.equals(paramArrayOfInt1, this.f)) && (Arrays.equals(paramArrayOfInt2, this.g)) && (this.h == paramInt2) && (this.i == paramInt3) && (TextUtils.equals(this.j, paramString2)))
    {
      setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberNewLevelView", 2, "setTroopMemberNewLevel normal");
      }
      return;
    }
    removeAllViews();
    setVisibility(8);
    this.c = paramInt1;
    this.d = paramString1;
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.f = paramArrayOfInt1;
    this.g = paramArrayOfInt2;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = paramString2;
    if ((!paramBoolean1) && (!paramBoolean2)) {
      return;
    }
    Object localObject;
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramArrayOfInt1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt2);
      paramArrayOfInt1.setCornerRadius(ViewUtils.dpToPx(3.0F));
      setBackgroundDrawable(paramArrayOfInt1);
      setGravity(16);
      paramArrayOfInt1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(10.0F), ViewUtils.dip2px(6.0F));
      paramArrayOfInt1.leftMargin = ViewUtils.dip2px(4.0F);
      paramArrayOfInt1.rightMargin = ViewUtils.dip2px(0.5F);
      paramArrayOfInt2 = new ImageView(getContext());
      paramArrayOfInt2.setImageResource(k[10]);
      paramArrayOfInt2.setColorFilter(paramInt2);
      paramArrayOfInt2.setContentDescription(HardCodeUtil.a(2131897533));
      a(paramArrayOfInt2, paramArrayOfInt1);
      addView(paramArrayOfInt2, paramArrayOfInt1);
      paramArrayOfInt2 = String.valueOf(paramInt1).toCharArray();
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt2.length)
      {
        int m = paramArrayOfInt2[paramInt1] - '0';
        if ((m >= 0) && (m < 10))
        {
          localObject = new RelativeLayout.LayoutParams(ViewUtils.dip2px(5.0F), ViewUtils.dip2px(7.0F));
          ImageView localImageView = new ImageView(getContext());
          localImageView.setImageResource(k[m]);
          localImageView.setColorFilter(paramInt2);
          if (paramInt1 != paramArrayOfInt2.length - 1) {
            ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(0.0F);
          }
          localImageView.setContentDescription(String.valueOf(m));
          a(localImageView, (RelativeLayout.LayoutParams)localObject);
          a((RelativeLayout.LayoutParams)localObject);
          addView(localImageView, (ViewGroup.LayoutParams)localObject);
        }
        paramInt1 += 1;
      }
      paramArrayOfInt2 = new TextView(getContext());
      paramArrayOfInt2.setText(paramString1);
      paramArrayOfInt2.setGravity(48);
      paramArrayOfInt2.setTextSize(2, 12.0F);
      paramArrayOfInt2.setIncludeFontPadding(false);
      paramArrayOfInt2.setEllipsize(TextUtils.TruncateAt.END);
      paramArrayOfInt2.setSingleLine();
      paramArrayOfInt2.setTypeface(Typeface.defaultFromStyle(1));
      paramArrayOfInt2.setTextColor(paramInt3);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = ViewUtils.dip2px(3.0F);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = ViewUtils.dip2px(4.0F);
      a(paramArrayOfInt2, (RelativeLayout.LayoutParams)localObject);
      a((RelativeLayout.LayoutParams)localObject);
      paramArrayOfInt1.topMargin = ViewUtils.dip2px(0.5F);
      paramArrayOfInt1.bottomMargin = ViewUtils.dip2px(0.5F);
      this.e = paramArrayOfInt2.getPaint().measureText(paramString1);
      addView(paramArrayOfInt2, (ViewGroup.LayoutParams)localObject);
      setVisibility(0);
    }
    else if (paramBoolean1)
    {
      paramString1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt1);
      paramString1.setCornerRadius(ViewUtils.dpToPx(3.0F));
      setBackgroundDrawable(paramString1);
      setGravity(16);
      paramArrayOfInt1 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(10.0F), ViewUtils.dip2px(6.0F));
      paramArrayOfInt1.leftMargin = ViewUtils.dip2px(4.0F);
      paramArrayOfInt1.rightMargin = ViewUtils.dip2px(0.5F);
      paramString1 = new ImageView(getContext());
      paramString1.setColorFilter(paramInt2);
      paramString1.setImageResource(k[10]);
      paramString1.setContentDescription(HardCodeUtil.a(2131897533));
      a(paramString1, paramArrayOfInt1);
      addView(paramString1, paramArrayOfInt1);
      paramArrayOfInt1 = String.valueOf(paramInt1).toCharArray();
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt1.length)
      {
        paramInt3 = paramArrayOfInt1[paramInt1] - '0';
        if ((paramInt3 >= 0) && (paramInt3 < 10))
        {
          paramArrayOfInt2 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(5.0F), ViewUtils.dip2px(7.0F));
          localObject = new ImageView(getContext());
          ((ImageView)localObject).setImageResource(k[paramInt3]);
          paramString1.setColorFilter(paramInt2);
          if (paramInt1 == paramArrayOfInt1.length - 1) {
            paramArrayOfInt2.rightMargin = ViewUtils.dip2px(4.0F);
          } else {
            paramArrayOfInt2.rightMargin = ViewUtils.dip2px(0.0F);
          }
          paramArrayOfInt2.bottomMargin = ViewUtils.dip2px(3.0F);
          paramArrayOfInt2.topMargin = ViewUtils.dip2px(3.0F);
          ((ImageView)localObject).setContentDescription(String.valueOf(paramInt3));
          a((View)localObject, paramArrayOfInt2);
          a(paramArrayOfInt2);
          addView((View)localObject, paramArrayOfInt2);
        }
        paramInt1 += 1;
      }
      setVisibility(0);
    }
    else if (paramBoolean2)
    {
      paramArrayOfInt1 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, paramArrayOfInt2);
      paramArrayOfInt1.setCornerRadius(ViewUtils.dpToPx(3.0F));
      setBackgroundDrawable(paramArrayOfInt1);
      paramArrayOfInt1 = new TextView(getContext());
      paramArrayOfInt1.setText(paramString1);
      paramArrayOfInt1.setGravity(48);
      paramArrayOfInt1.setTextSize(2, 12.0F);
      paramArrayOfInt1.setIncludeFontPadding(false);
      paramArrayOfInt1.setEllipsize(TextUtils.TruncateAt.END);
      paramArrayOfInt1.setSingleLine();
      paramArrayOfInt1.setTypeface(Typeface.defaultFromStyle(1));
      paramArrayOfInt1.setTextColor(paramInt3);
      paramArrayOfInt2 = new RelativeLayout.LayoutParams(-2, -2);
      paramArrayOfInt2.leftMargin = ViewUtils.dip2px(4.0F);
      paramArrayOfInt2.rightMargin = ViewUtils.dip2px(4.0F);
      paramArrayOfInt2.topMargin = ViewUtils.dip2px(0.5F);
      paramArrayOfInt2.bottomMargin = ViewUtils.dip2px(0.5F);
      this.e = paramArrayOfInt1.getPaint().measureText(paramString1);
      a(paramArrayOfInt1, paramArrayOfInt2);
      addView(paramArrayOfInt1, paramArrayOfInt2);
      setVisibility(0);
    }
    ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).clothEffectView(getContext(), this, (int)getExpectedWidth(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView
 * JD-Core Version:    0.7.0.1
 */