package com.tencent.mobileqq.troop.honor.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfig;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class TroopHonorView
  extends LinearLayout
{
  private static final int a = ViewUtils.dip2px(16.0F);
  private static final int b = ViewUtils.dip2px(16.0F);
  private static final int c = ViewUtils.dip2px(1.0F);
  private List<TroopHonor> d;
  private String e = "";
  
  public TroopHonorView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopHonorView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopHonorView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  public String getContentDesc()
  {
    return TroopHonorUtils.c(this.d);
  }
  
  public int getExpectedWidth()
  {
    List localList = this.d;
    if ((localList != null) && (localList.size() != 0)) {
      return this.d.size() * a + (this.d.size() - 1) * c + getPaddingLeft() + getPaddingRight();
    }
    return 0;
  }
  
  public void setHonorList(List<TroopHonor> paramList)
  {
    if (this.e.equals(TroopHonorUtils.b(paramList))) {
      return;
    }
    if (paramList != null) {
      Collections.sort(paramList);
    }
    this.d = paramList;
    this.e = TroopHonorUtils.b(this.d);
    removeAllViews();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        TroopHonor localTroopHonor = (TroopHonor)paramList.get(i);
        k = j;
        if (!TextUtils.isEmpty(localTroopHonor.c))
        {
          URLDrawable localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(localTroopHonor.c);
          k = j;
          if (localURLDrawable != null)
          {
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a, b);
            ImageView localImageView = new ImageView(getContext());
            localURLDrawable.setURLDrawableListener(new TroopHonorView.WeakViewDownloadListener(localImageView));
            localImageView.setImageDrawable(localURLDrawable);
            localImageView.setContentDescription(localTroopHonor.b);
            if (j != 0) {
              localLayoutParams.leftMargin = c;
            }
            addView(localImageView, localLayoutParams);
            k = j + 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public void setHonorList(List<TroopHonor> paramList, float paramFloat)
  {
    if (paramList == null) {
      return;
    }
    float f1 = getPaddingLeft();
    float f2 = getPaddingRight();
    int i = c;
    i = (int)((paramFloat - f1 - f2 + i) / (a + i));
    Collections.sort(paramList);
    setHonorList(paramList.subList(0, Math.min(i, paramList.size())));
  }
  
  public void setHonorList(List<TroopHonor> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    if ((paramInt != 1) && (paramInt != 2))
    {
      setHonorList(paramList);
      return;
    }
    paramInt = 3;
    Object localObject = (TroopHonorConfig)QConfigManager.b().b(544);
    if (localObject != null) {
      paramInt = ((TroopHonorConfig)localObject).b;
    }
    Collections.sort(paramList);
    setHonorList(paramList.subList(0, Math.min(paramInt, paramList.size())));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("maxNumberOfAIOIcon = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",honorList.size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("TroopHonorView", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.widget.TroopHonorView
 * JD-Core Version:    0.7.0.1
 */