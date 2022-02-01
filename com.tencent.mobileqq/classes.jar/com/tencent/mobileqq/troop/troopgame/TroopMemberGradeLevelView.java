package com.tencent.mobileqq.troop.troopgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bgfz;
import bhbt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class TroopMemberGradeLevelView
  extends LinearLayout
{
  private static final int b = ViewUtils.dip2px(16.0F);
  private static final int c = ViewUtils.dip2px(16.0F);
  private int a = -1;
  
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
  
  public TroopMemberGradeLevelView(Context paramContext, LinearLayout paramLinearLayout)
  {
    super(paramContext);
    setId(2131364559);
    if (paramLinearLayout != null) {
      paramLinearLayout.addView(this);
    }
  }
  
  public Bitmap a()
  {
    Object localObject2 = null;
    if (this.a <= 0) {
      return null;
    }
    int i = this.a / 100000;
    Object localObject1 = bgfz.a();
    localObject1 = (String)localObject1 + "aio_game_grade_";
    switch (i)
    {
    default: 
      localObject1 = null;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        switch (this.a % 100000 / 10000)
        {
        default: 
          localObject1 = localObject2;
        }
      }
      break;
    }
    for (;;)
    {
      return bhbt.a((String)localObject1);
      localObject1 = (String)localObject1 + "1_";
      break;
      localObject1 = (String)localObject1 + "2_";
      break;
      localObject1 = (String)localObject1 + "3_";
      break;
      localObject1 = (String)localObject1 + "4_";
      break;
      localObject1 = (String)localObject1 + "5_";
      break;
      localObject1 = (String)localObject1 + "6_";
      break;
      localObject1 = (String)localObject1 + "1.png";
      continue;
      localObject1 = (String)localObject1 + "2.png";
      continue;
      localObject1 = (String)localObject1 + "3.png";
      continue;
      localObject1 = (String)localObject1 + "4.png";
      continue;
      localObject1 = (String)localObject1 + "5.png";
    }
  }
  
  public void setTroopMemberGradeLevel(int paramInt)
  {
    if (this.a == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel no change");
      }
      setVisibility(0);
      return;
    }
    this.a = paramInt;
    removeAllViews();
    setVisibility(8);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(b, c);
    ImageView localImageView = new ImageView(getContext());
    Bitmap localBitmap = a();
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      addView(localImageView, localLayoutParams);
      setVisibility(0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberGradeLevelView", 2, "setTroopMemberGradeLevel bitmap is null");
      }
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