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
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.mobileqq.troop.honor.config.TroopHonorConfig;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

public class TroopHonorView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = ViewUtils.a(16.0F);
  private static final int b = ViewUtils.a(16.0F);
  private static final int c = ViewUtils.a(1.0F);
  private String jdField_a_of_type_JavaLangString = "";
  private List<TroopHonor> jdField_a_of_type_JavaUtilList;
  
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
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() * jdField_a_of_type_Int + (this.jdField_a_of_type_JavaUtilList.size() - 1) * c + getPaddingLeft() + getPaddingRight();
  }
  
  public String a()
  {
    return TroopHonorUtils.c(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void setHonorList(List<TroopHonor> paramList)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(TroopHonorUtils.b(paramList))) {}
    for (;;)
    {
      return;
      if (paramList != null) {
        Collections.sort(paramList);
      }
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_JavaLangString = TroopHonorUtils.b(this.jdField_a_of_type_JavaUtilList);
      removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        int k;
        for (int j = 0; i < paramList.size(); j = k)
        {
          TroopHonor localTroopHonor = (TroopHonor)paramList.get(i);
          k = j;
          if (!TextUtils.isEmpty(localTroopHonor.b))
          {
            URLDrawable localURLDrawable = VasApngFactory.a(localTroopHonor.b);
            k = j;
            if (localURLDrawable != null)
            {
              LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(jdField_a_of_type_Int, b);
              ImageView localImageView = new ImageView(getContext());
              localURLDrawable.setURLDrawableListener(new TroopHonorView.WeakViewDownloadListener(localImageView));
              localImageView.setImageDrawable(localURLDrawable);
              localImageView.setContentDescription(localTroopHonor.jdField_a_of_type_JavaLangString);
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
  }
  
  public void setHonorList(List<TroopHonor> paramList, float paramFloat)
  {
    if (paramList == null) {
      return;
    }
    int i = (int)((paramFloat - getPaddingLeft() - getPaddingRight() + c) / (jdField_a_of_type_Int + c));
    Collections.sort(paramList);
    setHonorList(paramList.subList(0, Math.min(i, paramList.size())));
  }
  
  public void setHonorList(List<TroopHonor> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    TroopHonorConfig localTroopHonorConfig;
    if ((paramInt == 1) || (paramInt == 2))
    {
      localTroopHonorConfig = (TroopHonorConfig)QConfigManager.a().a(544);
      if (localTroopHonorConfig == null) {
        break label114;
      }
    }
    label114:
    for (paramInt = localTroopHonorConfig.jdField_a_of_type_Int;; paramInt = 3)
    {
      Collections.sort(paramList);
      setHonorList(paramList.subList(0, Math.min(paramInt, paramList.size())));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonorView", 2, "maxNumberOfAIOIcon = " + paramInt + ",honorList.size = " + paramList.size());
      return;
      setHonorList(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.widget.TroopHonorView
 * JD-Core Version:    0.7.0.1
 */