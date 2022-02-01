package com.tencent.mobileqq.troop.troopgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopMemberGradeLevelView
  extends LinearLayout
{
  private static final int c = ViewUtils.a(16.0F);
  private static final int d = ViewUtils.a(16.0F);
  private int jdField_a_of_type_Int = -1;
  private final String jdField_a_of_type_JavaLangString = ".png";
  private final int b = 8;
  
  public TroopMemberGradeLevelView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopMemberGradeLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
  }
  
  public TroopMemberGradeLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
  }
  
  private String a(int paramInt1, int paramInt2, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 8: 
      if (paramInt2 > 5)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("8");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("7");
      return localStringBuilder.toString();
    case 7: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("6");
      return localStringBuilder.toString();
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("5");
      return localStringBuilder.toString();
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("4");
      return localStringBuilder.toString();
    case 4: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("3");
      return localStringBuilder.toString();
    case 3: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("2");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("1");
    return localStringBuilder.toString();
  }
  
  private String a(int paramInt, String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 9: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("1");
        return ((StringBuilder)localObject).toString();
      case 8: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("2");
        return ((StringBuilder)localObject).toString();
      case 7: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("3");
        return ((StringBuilder)localObject).toString();
      case 6: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("4");
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("5");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public Bitmap a()
  {
    int j = this.jdField_a_of_type_Int;
    if (j <= 0) {
      return null;
    }
    int i = j / 100000;
    j = j % 100000 / 10000;
    Object localObject1 = TroopGameCardResDownloadManager.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("aio_game_grade_");
    localObject2 = a(i, j, ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return null;
    }
    localObject1 = localObject2;
    if (i != 8)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("_");
      localObject2 = a(j, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return null;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".png");
    localObject1 = ((StringBuilder)localObject2).toString();
    return ((ITroopGameCardUtilsApi)QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap((String)localObject1);
  }
  
  public void setTroopMemberGradeLevel(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel no change");
      }
      setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    removeAllViews();
    setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(c, d);
    ImageView localImageView = new ImageView(getContext());
    Bitmap localBitmap = a();
    if (localBitmap != null)
    {
      localImageView.setImageBitmap(localBitmap);
      addView(localImageView, localLayoutParams);
      setVisibility(0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel bitmap is null");
    }
  }
  
  public void setTroopMemberGradeLevel(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    if (paramMemberGradeLevelInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel info is null");
      }
      setVisibility(8);
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTroopMemberGradeLevel memUin: ");
      localStringBuilder.append(paramMemberGradeLevelInfo.memberuin);
      localStringBuilder.append("grade: ");
      localStringBuilder.append(paramMemberGradeLevelInfo.gradeLevel);
      QLog.d("TroopMemberGradeLevelView", 2, localStringBuilder.toString());
    }
    setTroopMemberGradeLevel(paramMemberGradeLevelInfo.gradeLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView
 * JD-Core Version:    0.7.0.1
 */