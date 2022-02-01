package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import java.util.List;

class NearbyTabBarView
  extends TabBarView
{
  public NearbyTabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotTextView a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      Object localObject = LayoutInflater.from(getContext()).inflate(1946484751, this, false);
      RedDotTextView localRedDotTextView = (RedDotTextView)((View)localObject).findViewById(1946419231);
      localRedDotTextView.setId(2131447153);
      localObject = (LinearLayout)((View)localObject).findViewById(1946419226);
      if (!TextUtils.isEmpty(paramString)) {
        localRedDotTextView.setOnClickListener(new NearbyTabBarView.1(this, paramInt));
      }
      ViewCompat.setAccessibilityDelegate(localRedDotTextView, new NearbyTabBarView.2(this));
      this.v.add(localRedDotTextView);
      this.w.add(localObject);
      this.x.add(paramString);
      addView((View)localObject, paramInt);
      return localRedDotTextView;
    }
    throw new IllegalArgumentException("position is not legal, please check!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyTabBarView
 * JD-Core Version:    0.7.0.1
 */