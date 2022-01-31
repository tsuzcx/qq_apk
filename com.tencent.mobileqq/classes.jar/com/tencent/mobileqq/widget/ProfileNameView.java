package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awor;
import awqt;
import awrt;
import azkz;
import bamb;
import bamj;
import bbtx;
import bcgc;
import bcyw;
import bcyx;
import bdeu;
import bdoo;
import bdrv;
import beti;
import betj;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfileNameView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bamj jdField_a_of_type_Bamj;
  ETTextViewPlus jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  String jdField_a_of_type_JavaLangString = "";
  protected boolean a;
  protected int b;
  ColorNickTextView b;
  private int c;
  private int d;
  
  public ProfileNameView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileNameView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileNameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    paramContext = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramContext.density;
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = 0.1F;
    }
    this.jdField_a_of_type_Int = (Math.min(paramContext.widthPixels, paramContext.heightPixels) - azkz.a(188.0F));
    this.jdField_b_of_type_Int = getResources().getColor(2131167059);
    this.c = 24;
    this.d = 20;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561217, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368261));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368262));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus = ((ETTextViewPlus)findViewById(2131368263));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375840));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.c);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
  }
  
  private void a(QQAppInterface paramQQAppInterface, awqt paramawqt, ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((!paramawqt.b) || (paramViewGroup == null) || (paramTextView == null)) {
      return;
    }
    if (awrt.a(((TroopManager)paramQQAppInterface.getManager(52)).b(paramawqt.jdField_a_of_type_JavaLangString), paramawqt.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard, paramTextView))
    {
      paramViewGroup.setVisibility(0);
      paramTextView.setPadding(10, 2, 10, 2);
      if (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramawqt.jdField_a_of_type_JavaLangString)) {
        bbtx.a().a(paramawqt.jdField_a_of_type_JavaLangString, paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      label276:
      while (!this.jdField_a_of_type_Boolean)
      {
        bbtx.a("grp_data", "exp_medal");
        this.jdField_a_of_type_Boolean = true;
        return;
        switch (paramawqt.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole)
        {
        }
        for (;;)
        {
          if ((!bbtx.a().a(paramawqt.jdField_a_of_type_JavaLangString, paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
            break label276;
          }
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
          paramQQAppInterface.addRule(7, paramTextView.getId());
          paramQQAppInterface.setMargins(0, 0, 0, 0);
          this.jdField_a_of_type_AndroidWidgetImageView.setId(2131375551);
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramQQAppInterface);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849802);
          paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          break;
          paramViewGroup.setOnClickListener(new betj(paramQQAppInterface, paramawqt));
        }
      }
    }
    paramViewGroup.setVisibility(8);
    paramTextView.setText(null);
    paramTextView.setBackgroundDrawable(null);
  }
  
  private void a(QQAppInterface paramQQAppInterface, awqt paramawqt, TroopHonorView paramTroopHonorView)
  {
    if ((paramawqt != null) && (paramawqt.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
    {
      paramQQAppInterface = (bcgc)paramQQAppInterface.getManager(346);
      if (!paramQQAppInterface.b(paramawqt.jdField_a_of_type_JavaLangString))
      {
        paramTroopHonorView.setHonorList(null);
        paramTroopHonorView.setVisibility(8);
      }
      for (;;)
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(paramawqt.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.honorList);
        paramTroopHonorView.setHonorList(paramQQAppInterface);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
        {
          paramTroopHonorView.setVisibility(0);
          paramTroopHonorView.setOnClickListener(new beti(this, paramawqt));
        }
        while (QLog.isColorLevel())
        {
          QLog.d("TroopHonor.card", 2, String.format("updateTroopHonorView, honorList: %s", new Object[] { paramQQAppInterface }));
          return;
          paramTroopHonorView.setVisibility(8);
        }
      }
    }
    paramTroopHonorView.setHonorList(null);
    paramTroopHonorView.setVisibility(8);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingLeft();
    int j = (int)this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaint().measureText(this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getText().toString());
    j = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingRight() + (i + j);
    Object localObject = (TextView)findViewById(2131364006);
    i = j;
    if (((TextView)localObject).getVisibility() == 0)
    {
      i = j;
      if (!TextUtils.isEmpty(((TextView)localObject).getText()))
      {
        float f1 = j;
        float f2 = bdoo.b(4.0F) + ((TextView)localObject).getPaddingLeft();
        float f3 = ((TextView)localObject).getPaint().measureText(((TextView)localObject).getText().toString());
        i = (int)(((TextView)localObject).getPaddingRight() + (f2 + f3) + f1);
      }
    }
    localObject = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364009);
    j = i;
    if (((TroopHonorView)localObject).getVisibility() == 0)
    {
      j = ((TroopHonorView)localObject).getPaddingLeft();
      int k = ((TroopHonorView)localObject).a();
      j = i + (((TroopHonorView)localObject).getPaddingRight() + (j + k));
    }
    return j;
  }
  
  public ETTextViewPlus a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(0);
      return this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus;
    }
    return null;
  }
  
  public void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable TextView paramTextView, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileNameView", 2, "applyNickSpanText: " + paramString);
    }
    if ((paramTextView != null) && (paramString != null))
    {
      paramTextView.setTextColor(this.jdField_b_of_type_Int);
      paramString = new bamb(paramString, (int)(paramTextView.getTextSize() / this.jdField_a_of_type_Float)).a();
      paramTextView.setText(paramString);
      bdrv.a(paramQQAppInterface, paramTextView, paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, awqt paramawqt)
  {
    if ((paramQQAppInterface == null) || (paramawqt == null) || (paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (paramawqt.jdField_a_of_type_Bcyx == null))
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.c);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
    int i = getMeasuredWidth();
    if (i > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = i;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = paramawqt.jdField_a_of_type_Bcyx.a.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label100:
      bamj localbamj;
      String str;
      Resources localResources;
      float f1;
      ViewGroup localViewGroup;
      TextView localTextView;
      float f2;
      int j;
      break label100;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      if (!ProfileActivity.AllInOne.a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label927;
      }
      localObject2 = String.valueOf(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    label139:
    if ((paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(azkz.a(1.0F), 0.0F, 0.0F, -16777216);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(azkz.a(1.0F), 0.0F, 0.0F, -16777216);
      label190:
      this.jdField_a_of_type_Bamj = new bamj((String)localObject2, (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize() / this.jdField_a_of_type_Float));
      localbamj = this.jdField_a_of_type_Bamj.b(4);
      this.jdField_a_of_type_Bamj.a(4);
      str = String.format("%s:%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131691216), this.jdField_a_of_type_Bamj });
      if ((!bdeu.b(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!paramawqt.b)) {
        break label1557;
      }
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131362912);
      if (!bdeu.b(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label972;
      }
      ((View)localObject1).setVisibility(0);
      f1 = localResources.getDimensionPixelSize(2131297396) + 0.0F;
      label347:
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364007);
      if (!paramawqt.b) {
        break label984;
      }
      localTextView = (TextView)localViewGroup.findViewById(2131364006);
      a(paramQQAppInterface, paramawqt, localViewGroup, localTextView);
      localObject2 = localTextView.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
      }
      f2 = f1;
      if (localViewGroup.getVisibility() == 0) {
        f2 = ((TextPaint)localObject1).measureText(localTextView.getText().toString()) + f1 + localTextView.getPaddingLeft() + localTextView.getPaddingRight();
      }
      localObject1 = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364009);
      a(paramQQAppInterface, paramawqt, (TroopHonorView)localObject1);
      f1 = f2;
      if (((TroopHonorView)localObject1).getVisibility() == 0) {
        f1 = f2 + ((TroopHonorView)localObject1).a();
      }
      j = localResources.getDimensionPixelSize(2131297397);
      f1 += j;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
        ((TextPaint)localObject1).setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
      }
      f2 = localbamj.a((Paint)localObject1);
      if (f2 + f1 >= this.jdField_a_of_type_Int) {
        break label994;
      }
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bamj.b());
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      i = 1;
      label690:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      if (paramQQAppInterface.getVisibility() != 0) {
        break label1407;
      }
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, paramQQAppInterface.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, paramQQAppInterface.getId());
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, paramQQAppInterface.getId());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = j;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    label515:
    label1557:
    for (;;)
    {
      setContentDescription(str);
      paramQQAppInterface = new awor(88, this.jdField_a_of_type_Bamj.toString());
      if ((i == 1) && (f1 > 0.0F))
      {
        localObject1 = new HashMap(1);
        ((Map)localObject1).put("xoff", Integer.valueOf(-(int)(f1 / 2.0F)));
        paramQQAppInterface.a = localObject1;
      }
      setTag(paramQQAppInterface);
      setOnClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnClickListener);
      setOnLongClickListener(paramawqt.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileNameView", 2, String.format("update 6 [max: %s, title: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bamj.toString() }));
      return;
      label927:
      localObject2 = " ";
      break label139;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      break label190;
      label972:
      ((View)localObject1).setVisibility(8);
      f1 = 0.0F;
      break label347;
      label984:
      localViewGroup.setVisibility(8);
      break label515;
      label994:
      ((TextPaint)localObject1).setTextSize(azkz.a(this.d));
      float f3 = localbamj.a((Paint)localObject1);
      if ((f3 <= f2) || (f3 + f1 < this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bamj.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        i = 1;
        break label690;
      }
      if (f2 < this.jdField_a_of_type_Int)
      {
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bamj.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        i = 2;
        break label690;
      }
      if (f3 < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bamj.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        i = 2;
        break label690;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)(this.jdField_a_of_type_Int - f1));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bamj.b());
      paramQQAppInterface = (QQAppInterface)localObject1;
      i = 2;
      break label690;
      label1407:
      if (paramQQAppInterface == this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, 0);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = j;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(8, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        ((RelativeLayout.LayoutParams)localObject1).addRule(6, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = j;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        continue;
        i = 3;
        localObject2 = this.jdField_a_of_type_Bamj.toString();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setMaxLines(1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (localObject1 == null)
        {
          paramQQAppInterface = new TextPaint(1);
          paramQQAppInterface.density = this.jdField_a_of_type_Float;
          paramQQAppInterface.setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
        }
        if (paramQQAppInterface.measureText((String)localObject2) >= this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
        }
        f1 = 0.0F;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof View))
    {
      paramInt1 = ((View)localViewParent).getMeasuredWidth();
      if (this.jdField_a_of_type_Int < paramInt1) {
        this.jdField_a_of_type_Int = paramInt1;
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView
 * JD-Core Version:    0.7.0.1
 */