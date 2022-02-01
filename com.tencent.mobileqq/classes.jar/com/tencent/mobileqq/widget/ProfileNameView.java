package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
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
import azde;
import azfe;
import azgc;
import azml;
import bclx;
import bdnf;
import bdnn;
import beui;
import bfgp;
import bfnl;
import bfnm;
import bgdf;
import bgdg;
import bgjw;
import bgtn;
import bgwv;
import biad;
import biae;
import biaf;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
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
  bdnn jdField_a_of_type_Bdnn;
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
    this.jdField_a_of_type_Int = (Math.min(paramContext.widthPixels, paramContext.heightPixels) - bclx.a(188.0F));
    this.jdField_b_of_type_Int = getResources().getColor(2131167143);
    this.c = 24;
    this.d = 20;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561440, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368586));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368587));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus = ((ETTextViewPlus)findViewById(2131368588));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376574));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.c);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
  }
  
  private void a(QQAppInterface paramQQAppInterface, azfe paramazfe, ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((!paramazfe.b) || (paramViewGroup == null) || (paramTextView == null)) {
      return;
    }
    if (azgc.a(((TroopManager)paramQQAppInterface.getManager(52)).b(paramazfe.jdField_a_of_type_JavaLangString), paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard, paramTextView))
    {
      paramViewGroup.setVisibility(0);
      paramTextView.setPadding(10, 2, 10, 2);
      if (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramazfe.jdField_a_of_type_JavaLangString)) {
        beui.a().a(paramazfe.jdField_a_of_type_JavaLangString, paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
      }
      label276:
      while (!this.jdField_a_of_type_Boolean)
      {
        beui.a("grp_data", "exp_medal");
        this.jdField_a_of_type_Boolean = true;
        return;
        switch (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.memberRole)
        {
        }
        for (;;)
        {
          if ((!beui.a().a(paramazfe.jdField_a_of_type_JavaLangString, paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
            break label276;
          }
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
          paramQQAppInterface.addRule(7, paramTextView.getId());
          paramQQAppInterface.setMargins(0, 0, 0, 0);
          this.jdField_a_of_type_AndroidWidgetImageView.setId(2131376278);
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramQQAppInterface);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850389);
          paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          break;
          paramViewGroup.setOnClickListener(new biaf(paramQQAppInterface, paramazfe));
        }
      }
    }
    paramViewGroup.setVisibility(8);
    paramTextView.setText(null);
    paramTextView.setBackgroundDrawable(null);
  }
  
  private void a(QQAppInterface paramQQAppInterface, azfe paramazfe, TroopHonorView paramTroopHonorView)
  {
    if ((paramazfe != null) && (paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard != null))
    {
      paramQQAppInterface = (bfgp)paramQQAppInterface.getManager(346);
      if (!paramQQAppInterface.b(paramazfe.jdField_a_of_type_JavaLangString))
      {
        paramTroopHonorView.setHonorList(null);
        paramTroopHonorView.setVisibility(8);
      }
      for (;;)
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.honorList);
        paramTroopHonorView.setHonorList(paramQQAppInterface);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
        {
          paramTroopHonorView.setVisibility(0);
          paramTroopHonorView.setOnClickListener(new biad(this, paramazfe));
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
  
  private void a(QQAppInterface paramQQAppInterface, azfe paramazfe, TroopMemberNewLevelView paramTroopMemberNewLevelView)
  {
    if ((paramQQAppInterface == null) || (paramazfe == null) || (paramTroopMemberNewLevelView == null)) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileNameView", 2, "call updateTroopMemberNewLevelView troopUin : " + paramazfe.jdField_a_of_type_JavaLangString);
        }
        TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
        localObject = null;
        if (localTroopManager != null) {
          localObject = localTroopManager.c(paramazfe.jdField_a_of_type_JavaLangString);
        }
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProfileNameView", 2, "updateTroopMemberNewLevelView troopInfo is null. troopUin : " + paramazfe.jdField_a_of_type_JavaLangString);
      return;
      int j = paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.newRealLevel;
      int i = j;
      if (j == 0) {
        i = bfnl.b(paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.realLevel);
      }
      Object localObject = bfnl.a((TroopInfo)localObject, paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, i, paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.titleId, paramazfe.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mUniqueTitle);
      if ((localObject != null) && (paramTroopMemberNewLevelView != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileNameView", 2, "troopMemberRankItem :" + ((bfnm)localObject).toString());
        }
        paramTroopMemberNewLevelView.setTroopMemberNewLevel((bfnm)localObject);
        paramTroopMemberNewLevelView.setOnClickListener(new biae(this, paramazfe, paramQQAppInterface));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProfileNameView", 2, "updateTroopMemberNewLevelView failed - troopUin : " + paramazfe.jdField_a_of_type_JavaLangString);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingLeft();
    int j = (int)this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaint().measureText(this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getText().toString());
    j = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingRight() + (i + j);
    Object localObject = (TextView)findViewById(2131364207);
    i = j;
    float f1;
    if (((TextView)localObject).getVisibility() == 0)
    {
      i = j;
      if (!TextUtils.isEmpty(((TextView)localObject).getText()))
      {
        f1 = j;
        float f2 = bgtn.b(4.0F) + ((TextView)localObject).getPaddingLeft();
        float f3 = ((TextView)localObject).getPaint().measureText(((TextView)localObject).getText().toString());
        i = (int)(((TextView)localObject).getPaddingRight() + (f2 + f3) + f1);
      }
    }
    localObject = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364210);
    j = i;
    if (((TroopHonorView)localObject).getVisibility() == 0)
    {
      j = ((TroopHonorView)localObject).getPaddingLeft();
      int k = ((TroopHonorView)localObject).a();
      j = i + (((TroopHonorView)localObject).getPaddingRight() + (j + k));
    }
    localObject = (TroopMemberNewLevelView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379307);
    i = j;
    if (localObject != null)
    {
      i = j;
      if (((TroopMemberNewLevelView)localObject).getVisibility() == 0)
      {
        f1 = j;
        i = (int)(((TroopMemberNewLevelView)localObject).a() + bgtn.a(2.0F) + f1);
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
      paramString = new bdnf(paramString, (int)(paramTextView.getTextSize() / this.jdField_a_of_type_Float)).a();
      paramTextView.setText(paramString);
      bgwv.a(paramQQAppInterface, paramTextView, paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, azfe paramazfe)
  {
    if ((paramQQAppInterface == null) || (paramazfe == null) || (paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (paramazfe.jdField_a_of_type_Bgdg == null))
    {
      setVisibility(8);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("update failed troopUin : ");
        if (paramazfe == null) {
          break label75;
        }
      }
      label75:
      for (paramQQAppInterface = paramazfe.jdField_a_of_type_JavaLangString;; paramQQAppInterface = "")
      {
        QLog.d("ProfileNameView", 2, paramQQAppInterface);
        return;
      }
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
      localObject2 = paramazfe.jdField_a_of_type_Bgdg.a.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label152:
      bdnn localbdnn;
      String str;
      Resources localResources;
      float f2;
      ViewGroup localViewGroup;
      TextView localTextView;
      float f1;
      break label152;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).length() != 0) {}
    }
    else
    {
      if (!ProfileActivity.AllInOne.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label975;
      }
      localObject2 = String.valueOf(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    }
    label191:
    if ((paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (!paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.isNoCover()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(bclx.a(1.0F), 0.0F, 0.0F, -16777216);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(bclx.a(1.0F), 0.0F, 0.0F, -16777216);
      label242:
      this.jdField_a_of_type_Bdnn = new bdnn((String)localObject2, (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize() / this.jdField_a_of_type_Float));
      localbdnn = this.jdField_a_of_type_Bdnn.b(4);
      this.jdField_a_of_type_Bdnn.a(4);
      str = String.format("%s:%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131691020), this.jdField_a_of_type_Bdnn });
      if ((!bgjw.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!paramazfe.b)) {
        break label1734;
      }
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363025);
      if (!bgjw.b(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        break label1020;
      }
      ((View)localObject1).setVisibility(0);
      f2 = localResources.getDimensionPixelSize(2131297475) + 0.0F;
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364208);
      if (!paramazfe.b) {
        break label1191;
      }
      if (bfnl.a(paramazfe.jdField_a_of_type_JavaLangString)) {
        break label1033;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileNameView", 2, "call old level troopUin : " + paramazfe.jdField_a_of_type_JavaLangString);
      }
      localTextView = (TextView)localViewGroup.findViewById(2131364207);
      a(paramQQAppInterface, paramazfe, localViewGroup, localTextView);
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
      localObject1 = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364210);
      a(paramQQAppInterface, paramazfe, (TroopHonorView)localObject1);
      f2 = f1;
      if (((TroopHonorView)localObject1).getVisibility() == 0) {
        f2 = f1 + ((TroopHonorView)localObject1).a();
      }
      label614:
      i = localResources.getDimensionPixelSize(2131297476);
      f1 = f2 + i;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
      paramazfe = (azfe)localObject1;
      if (localObject1 == null)
      {
        paramazfe = new TextPaint(1);
        paramazfe.density = this.jdField_a_of_type_Float;
        paramazfe.setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
      }
      f2 = localbdnn.a(paramazfe);
      if (f2 + f1 >= this.jdField_a_of_type_Int) {
        break label1201;
      }
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bdnn.b());
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
      paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      if (QLog.isColorLevel()) {
        QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramazfe = (azfe)localObject1;
      if (localObject1 == null) {
        paramazfe = new RelativeLayout.LayoutParams(-2, -2);
      }
      if (paramQQAppInterface.getVisibility() != 0) {
        break label1598;
      }
      paramazfe.addRule(1, paramQQAppInterface.getId());
      paramazfe.addRule(3, 0);
      paramazfe.addRule(8, paramQQAppInterface.getId());
      paramazfe.addRule(6, paramQQAppInterface.getId());
      paramazfe.topMargin = 0;
      paramazfe.leftMargin = i;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramazfe);
    }
    for (;;)
    {
      label400:
      label570:
      setContentDescription(str);
      label782:
      setTag(new azde(88, this.jdField_a_of_type_Bdnn.toString()));
      setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      azml.a(this, getResources().getString(2131691140), this.jdField_a_of_type_Bdnn.toString());
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ProfileNameView", 2, String.format("update 6 [max: %s, title: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_Bdnn.toString() }));
      return;
      label975:
      localObject2 = " ";
      break label191;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      break label242;
      label1020:
      ((View)localObject1).setVisibility(8);
      f2 = 0.0F;
      break label400;
      label1033:
      if (QLog.isColorLevel()) {
        QLog.d("ProfileNameView", 2, "call new level troopUin : " + paramazfe.jdField_a_of_type_JavaLangString);
      }
      localObject1 = (TroopMemberNewLevelView)findViewById(2131379307);
      f1 = f2;
      if (localObject1 == null) {
        break label570;
      }
      a(paramQQAppInterface, paramazfe, (TroopMemberNewLevelView)localObject1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("call old level troopUin : ").append(paramazfe.jdField_a_of_type_JavaLangString);
        if (((TroopMemberNewLevelView)localObject1).getVisibility() != 0) {
          break label1185;
        }
      }
      label1185:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ProfileNameView", 2, String.valueOf(bool));
        f1 = f2;
        if (((TroopMemberNewLevelView)localObject1).getVisibility() != 0) {
          break;
        }
        f1 = f2 + (((TroopMemberNewLevelView)localObject1).a() + bgtn.a(2.0F));
        break;
      }
      label1191:
      localViewGroup.setVisibility(8);
      break label614;
      label1201:
      paramazfe.setTextSize(bclx.a(this.d));
      float f3 = localbdnn.a(paramazfe);
      if ((f3 <= f2) || (f3 + f1 < this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bdnn.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        break label782;
      }
      if (f2 < this.jdField_a_of_type_Int)
      {
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bdnn.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        break label782;
      }
      if (f3 < this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bdnn.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f1), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        break label782;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)(this.jdField_a_of_type_Int - f1));
      paramazfe = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_Bdnn.b());
      paramQQAppInterface = paramazfe;
      break label782;
      label1598:
      if (paramQQAppInterface == this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView)
      {
        paramazfe.addRule(1, 0);
        paramazfe.addRule(3, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getId());
        paramazfe.addRule(8, 0);
        paramazfe.addRule(6, 0);
        paramazfe.topMargin = i;
        paramazfe.leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramazfe);
      }
      else
      {
        paramazfe.addRule(1, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramazfe.addRule(3, 0);
        paramazfe.addRule(8, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramazfe.addRule(6, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramazfe.topMargin = 0;
        paramazfe.leftMargin = i;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramazfe);
        continue;
        label1734:
        localObject1 = this.jdField_a_of_type_Bdnn.toString();
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setMaxLines(1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        paramazfe = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
        paramQQAppInterface = paramazfe;
        if (paramazfe == null)
        {
          paramQQAppInterface = new TextPaint(1);
          paramQQAppInterface.density = this.jdField_a_of_type_Float;
          paramQQAppInterface.setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
        }
        if (paramQQAppInterface.measureText((String)localObject1) >= this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.d);
        }
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