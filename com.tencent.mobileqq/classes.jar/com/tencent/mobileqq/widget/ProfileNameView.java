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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aykg;
import aymg;
import aynd;
import aytm;
import bczs;
import bczz;
import beda;
import bepr;
import bewy;
import bewz;
import bfms;
import bfmt;
import bftf;
import bgdk;
import bhhc;
import bhhd;
import bhhe;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ProfileNameView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bczz jdField_a_of_type_Bczz;
  ETTextViewPlus jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  String jdField_a_of_type_JavaLangString = "";
  protected boolean a;
  protected int b;
  ColorNickTextView b;
  private int c;
  private int d;
  private int e;
  
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
    this.jdField_a_of_type_Int = (Math.min(paramContext.widthPixels, paramContext.heightPixels) - ScreenUtil.dip2px(188.0F));
    this.jdField_b_of_type_Int = getResources().getColor(2131167176);
    this.d = 24;
    this.e = 20;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561365, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368683));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368684));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus = ((ETTextViewPlus)findViewById(2131368685));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376474));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
  }
  
  private void a(QQAppInterface paramQQAppInterface, aymg paramaymg, ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((!paramaymg.b) || (paramViewGroup == null) || (paramTextView == null)) {
      return;
    }
    if (aynd.a(((TroopManager)paramQQAppInterface.getManager(52)).b(paramaymg.jdField_a_of_type_JavaLangString), paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard, paramTextView))
    {
      paramViewGroup.setVisibility(0);
      paramTextView.setPadding(10, 2, 10, 2);
      if (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramaymg.jdField_a_of_type_JavaLangString)) {
        beda.a().a(paramaymg.jdField_a_of_type_JavaLangString, paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      label276:
      while (!this.jdField_a_of_type_Boolean)
      {
        beda.a("grp_data", "exp_medal");
        this.jdField_a_of_type_Boolean = true;
        return;
        switch (paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole)
        {
        }
        for (;;)
        {
          if ((!beda.a().a(paramaymg.jdField_a_of_type_JavaLangString, paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
            break label276;
          }
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
          paramQQAppInterface.addRule(7, paramTextView.getId());
          paramQQAppInterface.setMargins(0, 0, 0, 0);
          this.jdField_a_of_type_AndroidWidgetImageView.setId(2131376186);
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramQQAppInterface);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850322);
          paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          break;
          paramViewGroup.setOnClickListener(new bhhe(paramQQAppInterface, paramaymg));
        }
      }
    }
    paramViewGroup.setVisibility(8);
    paramTextView.setText(null);
    paramTextView.setBackgroundDrawable(null);
  }
  
  private void a(QQAppInterface paramQQAppInterface, aymg paramaymg, TroopHonorView paramTroopHonorView, float paramFloat)
  {
    if ((paramaymg != null) && (paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
    {
      paramQQAppInterface = (bepr)paramQQAppInterface.getManager(346);
      if (!paramQQAppInterface.b(paramaymg.jdField_a_of_type_JavaLangString))
      {
        paramTroopHonorView.setHonorList(null);
        paramTroopHonorView.setVisibility(8);
      }
      for (;;)
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.honorList);
        paramTroopHonorView.setHonorList(paramQQAppInterface, paramFloat);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
        {
          paramTroopHonorView.setVisibility(0);
          paramTroopHonorView.setOnClickListener(new bhhc(this, paramaymg));
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
  
  private void a(QQAppInterface paramQQAppInterface, aymg paramaymg, TroopMemberNewLevelView paramTroopMemberNewLevelView)
  {
    if ((paramQQAppInterface == null) || (paramaymg == null) || (paramTroopMemberNewLevelView == null)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileNameView", 2, "call updateTroopMemberNewLevelView troopUin : " + paramaymg.jdField_a_of_type_JavaLangString);
        }
        TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
        localObject = null;
        if (localTroopManager != null) {
          localObject = localTroopManager.c(paramaymg.jdField_a_of_type_JavaLangString);
        }
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileNameView", 2, "updateTroopMemberNewLevelView troopInfo is null. troopUin : " + paramaymg.jdField_a_of_type_JavaLangString);
      return;
      int j = paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.newRealLevel;
      int i = j;
      if (j == 0) {
        i = bewy.b(paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.realLevel);
      }
      Object localObject = bewy.a((TroopInfo)localObject, paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId, paramaymg.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle);
      if ((localObject != null) && (paramTroopMemberNewLevelView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileNameView", 2, "troopMemberRankItem :" + ((bewz)localObject).toString());
        }
        paramTroopMemberNewLevelView.setTroopMemberNewLevel((bewz)localObject);
        paramTroopMemberNewLevelView.setOnClickListener(new bhhd(this, paramaymg, paramQQAppInterface));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProfileNameView", 2, "updateTroopMemberNewLevelView failed - troopUin : " + paramaymg.jdField_a_of_type_JavaLangString);
  }
  
  public float a(TextView paramTextView, String paramString, Paint paramPaint)
  {
    return new bczz(paramString, (int)(paramTextView.getTextSize() / this.jdField_a_of_type_Float)).b(4).a(paramPaint);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingLeft();
    int j = (int)this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaint().measureText(this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getText().toString());
    j = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingRight() + (i + j);
    Object localObject = (TextView)findViewById(2131364270);
    i = j;
    float f1;
    if (((TextView)localObject).getVisibility() == 0)
    {
      i = j;
      if (!TextUtils.isEmpty(((TextView)localObject).getText()))
      {
        f1 = j;
        float f2 = ViewUtils.dpToPx(4.0F) + ((TextView)localObject).getPaddingLeft();
        float f3 = ((TextView)localObject).getPaint().measureText(((TextView)localObject).getText().toString());
        i = (int)(((TextView)localObject).getPaddingRight() + (f2 + f3) + f1);
      }
    }
    localObject = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364274);
    j = i;
    if (((TroopHonorView)localObject).getVisibility() == 0)
    {
      j = ((TroopHonorView)localObject).getPaddingLeft();
      int k = ((TroopHonorView)localObject).a();
      j = i + (((TroopHonorView)localObject).getPaddingRight() + (j + k));
    }
    localObject = (TroopMemberNewLevelView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379244);
    i = j;
    if (localObject != null)
    {
      i = j;
      if (((TroopMemberNewLevelView)localObject).getVisibility() == 0)
      {
        f1 = j;
        i = (int)(((TroopMemberNewLevelView)localObject).a() + ViewUtils.dip2px(2.0F) + f1);
      }
    }
    return i;
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
      paramString = new bczs(paramString, (int)(paramTextView.getTextSize() / this.jdField_a_of_type_Float)).a();
      paramTextView.setText(paramString);
      bgdk.a(paramQQAppInterface, paramTextView, paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, aymg paramaymg)
  {
    if ((paramQQAppInterface == null) || (paramaymg == null) || (paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (paramaymg.jdField_a_of_type_Bfmt == null))
    {
      setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("update failed troopUin : ");
        if (paramaymg == null) {
          break label75;
        }
      }
      label75:
      for (paramQQAppInterface = paramaymg.jdField_a_of_type_JavaLangString;; paramQQAppInterface = "")
      {
        QLog.d("ProfileNameView", 2, paramQQAppInterface);
        return;
      }
    }
    this.c = 3;
    setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
    int i = getMeasuredWidth();
    if (i > this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Int = i;
    }
    Object localObject1 = null;
    label157:
    label196:
    label1226:
    try
    {
      localObject2 = paramaymg.jdField_a_of_type_Bfmt.a.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label247:
      bczz localbczz;
      String str;
      Resources localResources;
      float f2;
      ViewGroup localViewGroup;
      TextView localTextView;
      float f1;
      label626:
      int j;
      float f3;
      label1000:
      break label157;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      if (!ProfileActivity.AllInOne.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label1000;
      }
      localObject2 = String.valueOf(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    if ((paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(ScreenUtil.dip2px(1.0F), 0.0F, 0.0F, -16777216);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(ScreenUtil.dip2px(1.0F), 0.0F, 0.0F, -16777216);
      this.jdField_a_of_type_Bczz = new bczz((String)localObject2, (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize() / this.jdField_a_of_type_Float));
      localbczz = this.jdField_a_of_type_Bczz.b(4);
      this.jdField_a_of_type_Bczz.a(4);
      str = String.format("%s:%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131691060), this.jdField_a_of_type_Bczz });
      if ((!bftf.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!paramaymg.b)) {
        break label2211;
      }
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363063);
      if (!bftf.b(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label1045;
      }
      ((View)localObject1).setVisibility(0);
      f2 = 0.0F + localResources.getDimensionPixelSize(2131297542);
      label405:
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364271);
      if (!paramaymg.b) {
        break label1216;
      }
      if (bewy.a(paramaymg.jdField_a_of_type_JavaLangString)) {
        break label1058;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileNameView", 2, "call old level troopUin : " + paramaymg.jdField_a_of_type_JavaLangString);
      }
      localTextView = (TextView)localViewGroup.findViewById(2131364270);
      a(paramQQAppInterface, paramaymg, localViewGroup, localTextView);
      localObject2 = localTextView.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
      }
      f1 = f2;
      if (localViewGroup.getVisibility() == 0) {
        f1 = ((TextPaint)localObject1).measureText(localTextView.getText().toString()) + f2 + localTextView.getPaddingLeft() + localTextView.getPaddingRight();
      }
      label575:
      localObject1 = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364274);
      a(paramQQAppInterface, paramaymg, (TroopHonorView)localObject1, this.jdField_a_of_type_Int - f1);
      f2 = f1;
      if (((TroopHonorView)localObject1).getVisibility() == 0) {
        f2 = f1 + ((TroopHonorView)localObject1).a();
      }
      j = localResources.getDimensionPixelSize(2131297543);
      f2 += j;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
        ((TextPaint)localObject1).setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
      }
      f3 = localbczz.a((Paint)localObject1);
      if (f3 + f2 >= this.jdField_a_of_type_Int) {
        break label1226;
      }
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bczz.b());
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      this.c = 1;
      label807:
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramaymg = (aymg)localObject1;
      if (localObject1 == null) {
        paramaymg = new RelativeLayout.LayoutParams(-2, -2);
      }
      if (paramQQAppInterface.getVisibility() != 0) {
        break label2075;
      }
      paramaymg.addRule(1, paramQQAppInterface.getId());
      paramaymg.addRule(3, 0);
      paramaymg.addRule(8, paramQQAppInterface.getId());
      paramaymg.addRule(6, paramQQAppInterface.getId());
      paramaymg.topMargin = 0;
      paramaymg.leftMargin = j;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramaymg);
    }
    for (;;)
    {
      setContentDescription(str);
      setTag(new aykg(88, this.jdField_a_of_type_Bczz.toString()));
      setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      aytm.a(this, getResources().getString(2131691179), this.jdField_a_of_type_Bczz.toString());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileNameView", 2, String.format("update 6 [max: %s, title: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bczz.toString() }));
      return;
      localObject2 = " ";
      break label196;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      break label247;
      label1045:
      ((View)localObject1).setVisibility(8);
      f2 = 0.0F;
      break label405;
      label1058:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileNameView", 2, "call new level troopUin : " + paramaymg.jdField_a_of_type_JavaLangString);
      }
      localObject1 = (TroopMemberNewLevelView)findViewById(2131379244);
      f1 = f2;
      if (localObject1 == null) {
        break label575;
      }
      a(paramQQAppInterface, paramaymg, (TroopMemberNewLevelView)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("call old level troopUin : ").append(paramaymg.jdField_a_of_type_JavaLangString);
        if (((TroopMemberNewLevelView)localObject1).getVisibility() != 0) {
          break label1210;
        }
      }
      label1210:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ProfileNameView", 2, String.valueOf(bool));
        f1 = f2;
        if (((TroopMemberNewLevelView)localObject1).getVisibility() != 0) {
          break;
        }
        f1 = f2 + (((TroopMemberNewLevelView)localObject1).a() + ViewUtils.dip2px(2.0F));
        break;
      }
      label1216:
      localViewGroup.setVisibility(8);
      break label626;
      ((TextPaint)localObject1).setTextSize(ScreenUtil.dip2px(this.e));
      f1 = localbczz.a((Paint)localObject1);
      if ((f1 <= f3) || (f1 + f2 < this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bczz.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        this.c = 1;
        break label807;
      }
      if (f3 < this.jdField_a_of_type_Int)
      {
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bczz.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        this.c = 2;
        break label807;
      }
      if (f1 < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bczz.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        this.c = 2;
        break label807;
      }
      if (paramaymg.b)
      {
        this.c = 2;
        paramaymg = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(null);
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
        localObject1 = this.jdField_a_of_type_Bczz.b();
        f1 = 0.0F;
        float f4 = this.jdField_a_of_type_Int - ScreenUtil.dip2px(4.0F);
        i = 1;
        while ((f1 <= f4) && (i < ((String)localObject1).length()))
        {
          f1 = a(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, ((String)localObject1).substring(0, i + 1), this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint());
          i += 1;
        }
        f1 = a(this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, ((String)localObject1).substring(i - 1), this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint()) + this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaddingLeft() + this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaddingRight();
        if (f1 + f2 > f4) {
          if (f4 - f2 < a(this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, ((String)localObject1).substring(i - 1, i + 1), this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint()))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
            a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 5 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
          }
          paramQQAppInterface = paramaymg;
          break;
          this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)(f4 - f2));
          localObject2 = ((String)localObject1).substring(0, i - 1);
          localObject1 = ((String)localObject1).substring(i - 1);
          a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject2);
          a(paramQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
          continue;
          this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)f1);
          localObject2 = ((String)localObject1).substring(0, i - 1);
          localObject1 = ((String)localObject1).substring(i - 1);
          a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject2);
          a(paramQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
        }
      }
      this.c = 2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)(this.jdField_a_of_type_Int - f2));
      paramaymg = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bczz.b());
      paramQQAppInterface = paramaymg;
      break label807;
      label2075:
      if (paramQQAppInterface == this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView)
      {
        paramaymg.addRule(1, 0);
        paramaymg.addRule(3, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getId());
        paramaymg.addRule(8, 0);
        paramaymg.addRule(6, 0);
        paramaymg.topMargin = j;
        paramaymg.leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramaymg);
      }
      else
      {
        paramaymg.addRule(1, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramaymg.addRule(3, 0);
        paramaymg.addRule(8, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramaymg.addRule(6, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramaymg.topMargin = 0;
        paramaymg.leftMargin = j;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramaymg);
        continue;
        label2211:
        this.c = 3;
        localObject1 = this.jdField_a_of_type_Bczz.toString();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setMaxLines(1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramaymg = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
        paramQQAppInterface = paramaymg;
        if (paramaymg == null)
        {
          paramQQAppInterface = new TextPaint(1);
          paramQQAppInterface.density = this.jdField_a_of_type_Float;
          paramQQAppInterface.setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
        }
        if (paramQQAppInterface.measureText((String)localObject1) >= this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
        }
      }
    }
  }
  
  public int b()
  {
    return this.c;
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
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView
 * JD-Core Version:    0.7.0.1
 */