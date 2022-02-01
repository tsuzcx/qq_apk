package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class LabelBaseCtrl
{
  public static final int[] e = { 5, 6, 7, 1, 2, 3, 4, 8 };
  public static final int[] f = { 2130842260, 2130842269, 2130842255, 2130842263, 2130842251, 2130842245, 2130842268 };
  public static final String[] g = { "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#F1F1F5", "#DCEBFF" };
  public static final String[] h = { "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#777777", "#4B83D3" };
  public static final String[] i = { HardCodeUtil.a(2131903927), HardCodeUtil.a(2131903929), HardCodeUtil.a(2131903923), HardCodeUtil.a(2131903928), HardCodeUtil.a(2131903926), HardCodeUtil.a(2131903924), HardCodeUtil.a(2131903925) };
  public static final String[] j = { "0X800554B", "0X800554C", "0X800554D", "0X800554E", "0X800554F", "0X8005550", "0X8005551" };
  protected LinearLayout a;
  protected Context b;
  protected LayoutInflater c;
  protected InterestTag d;
  
  public static int a(int paramInt)
  {
    int k = 0;
    for (;;)
    {
      int[] arrayOfInt = e;
      if (k >= arrayOfInt.length) {
        break;
      }
      if (paramInt == arrayOfInt[k]) {
        return k;
      }
      k += 1;
    }
    return -1;
  }
  
  protected View a(int paramInt1, InterestTag paramInterestTag, int paramInt2)
  {
    View localView = this.c.inflate(b(), this.a, false);
    a(paramInt1, a(localView, paramInt1, paramInterestTag, paramInt2), paramInterestTag.b);
    return localView;
  }
  
  protected abstract LabelContainer a(View paramView, int paramInt1, InterestTag paramInterestTag, int paramInt2);
  
  protected void a(int paramInt, LabelContainer paramLabelContainer, ArrayList<InterestTagInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int m = DisplayUtil.a(this.b, 10.0F);
      int n = DisplayUtil.a(this.b, 5.0F);
      int i1 = DisplayUtil.a(this.b, 2.0F);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramArrayList.next();
        TextView localTextView = new TextView(this.b);
        int k = 0;
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColor(Color.parseColor(g[paramInt]));
        localGradientDrawable.setCornerRadius(i1);
        localTextView.setBackgroundDrawable(localGradientDrawable);
        localTextView.setTextColor(Color.parseColor(h[paramInt]));
        if (this.d != null) {
          while (k < this.d.b.size())
          {
            if (((InterestTagInfo)this.d.b.get(k)).tagName.equals(localInterestTagInfo.tagName))
            {
              localTextView.setTextColor(Color.parseColor(h[7]));
              localTextView.setBackgroundColor(Color.parseColor(g[7]));
              this.d.b.remove(k);
            }
            k += 1;
          }
        }
        if (localInterestTagInfo.tagName != null)
        {
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\005", "");
          localInterestTagInfo.tagName = localInterestTagInfo.tagName.replaceAll("\006", "");
        }
        localTextView.setText(localInterestTagInfo.tagName);
        localTextView.setPadding(m, n, m, n);
        localTextView.setGravity(17);
        paramLabelContainer.addView(localTextView);
      }
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout)
  {
    this.b = paramContext;
    this.a = paramLinearLayout;
    this.c = LayoutInflater.from(paramContext);
  }
  
  public void a(InterestTag paramInterestTag)
  {
    this.d = paramInterestTag;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(InterestTag[] paramArrayOfInterestTag)
  {
    this.a.removeAllViews();
    if (paramArrayOfInterestTag != null)
    {
      if (paramArrayOfInterestTag.length == 0) {
        return false;
      }
      int k = 0;
      boolean bool2;
      for (boolean bool1 = false; k < e.length; bool1 = bool2)
      {
        int m = 0;
        for (;;)
        {
          bool2 = bool1;
          if (m >= paramArrayOfInterestTag.length) {
            break;
          }
          if ((e[k] == paramArrayOfInterestTag[m].a) && ((a()) || ((paramArrayOfInterestTag[m].b != null) && (paramArrayOfInterestTag[m].b.size() > 0))))
          {
            View localView = a(k, paramArrayOfInterestTag[m], paramArrayOfInterestTag.length);
            this.a.addView(localView);
            bool2 = true;
            break;
          }
          m += 1;
        }
        k += 1;
      }
      return bool1;
    }
    return false;
  }
  
  protected abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelBaseCtrl
 * JD-Core Version:    0.7.0.1
 */