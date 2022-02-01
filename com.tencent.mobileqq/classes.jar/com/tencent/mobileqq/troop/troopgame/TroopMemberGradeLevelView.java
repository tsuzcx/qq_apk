package com.tencent.mobileqq.troop.troopgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.util.TroopGameCardUtil;
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
    case 2: 
      return paramString + "1";
    case 3: 
      return paramString + "2";
    case 4: 
      return paramString + "3";
    case 5: 
      return paramString + "4";
    case 6: 
      return paramString + "5";
    case 7: 
      return paramString + "6";
    }
    if (paramInt2 > 5) {
      return paramString + "8";
    }
    return paramString + "7";
  }
  
  private String a(int paramInt, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {}
    switch (paramInt)
    {
    default: 
      str = null;
      return str;
    case 9: 
      return paramString + "1";
    case 8: 
      return paramString + "2";
    case 7: 
      return paramString + "3";
    case 6: 
      return paramString + "4";
    }
    return paramString + "5";
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      return null;
    }
    int i = this.jdField_a_of_type_Int / 100000;
    int j = this.jdField_a_of_type_Int % 100000 / 10000;
    Object localObject = TroopGameCardResDownloadManager.a();
    String str = a(i, j, (String)localObject + "aio_game_grade_");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    localObject = str;
    if (i != 8)
    {
      str = a(j, str + "_");
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        return null;
      }
    }
    return TroopGameCardUtil.a((String)localObject + ".png");
  }
  
  public void setTroopMemberGradeLevel(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel no change");
      }
      setVisibility(0);
    }
    do
    {
      return;
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
    } while (!QLog.isColorLevel());
    QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel bitmap is null");
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
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel memUin: " + paramMemberGradeLevelInfo.memberuin + "grade: " + paramMemberGradeLevelInfo.gradeLevel);
    }
    setTroopMemberGradeLevel(paramMemberGradeLevelInfo.gradeLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgame.TroopMemberGradeLevelView
 * JD-Core Version:    0.7.0.1
 */