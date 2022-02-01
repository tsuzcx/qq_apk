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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.NickWrapper.NickString;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
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
  NickWrapper.NickString jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString;
  ETTextViewPlus jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus;
  ColorNickTextView jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
  String jdField_a_of_type_JavaLangString = "";
  protected boolean a;
  protected int b;
  ColorNickTextView b;
  private int c;
  private int d = 0;
  private int e;
  private int f;
  
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    paramContext = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramContext.density;
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = 0.1F;
    }
    this.jdField_a_of_type_Int = (Math.min(paramContext.widthPixels, paramContext.heightPixels) - ScreenUtil.dip2px(188.0F));
    this.jdField_b_of_type_Int = getResources().getColor(2131167222);
    this.e = 24;
    this.f = 20;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561375, this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368796));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)findViewById(2131368797));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus = ((ETTextViewPlus)findViewById(2131368798));
    this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376601));
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
    this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, ViewGroup paramViewGroup, TextView paramTextView)
  {
    if ((paramProfileCardInfo.isTroopMemberCard) && (paramViewGroup != null))
    {
      if (paramTextView == null) {
        return;
      }
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (TroopMemberCardUtils.a(localTroopManager.b(paramProfileCardInfo.troopUin), paramProfileCardInfo.troopMemberCard, paramTextView))
      {
        paramViewGroup.setVisibility(0);
        paramTextView.setPadding(10, 2, 10, 2);
        if (localTroopManager.m(paramProfileCardInfo.troopUin))
        {
          TroopRankConfig.a().a(paramProfileCardInfo.troopUin, paramProfileCardInfo.allInOne.uin, false);
        }
        else
        {
          int i = paramProfileCardInfo.troopMemberCard.memberRole;
          if ((i == 1) || (i == 2) || (i == 3)) {
            paramViewGroup.setOnClickListener(new ProfileNameView.TroopRankClick(paramQQAppInterface, paramProfileCardInfo));
          }
          if ((TroopRankConfig.a().a(paramProfileCardInfo.troopUin, paramProfileCardInfo.allInOne.uin)) && (this.jdField_a_of_type_AndroidWidgetImageView == null))
          {
            this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
            paramQQAppInterface = new RelativeLayout.LayoutParams(-2, -2);
            paramQQAppInterface.addRule(7, paramTextView.getId());
            paramQQAppInterface.setMargins(0, 0, 0, 0);
            this.jdField_a_of_type_AndroidWidgetImageView.setId(2131376320);
            this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramQQAppInterface);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850767);
            paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView);
          }
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          TroopRankConfig.a("grp_data", "exp_medal");
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        paramViewGroup.setVisibility(8);
        paramTextView.setText(null);
        paramTextView.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, TroopHonorView paramTroopHonorView, float paramFloat)
  {
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.troopMemberCard != null))
    {
      paramQQAppInterface = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
      if (!paramQQAppInterface.isSupportTroopHonor(paramProfileCardInfo.troopUin))
      {
        paramTroopHonorView.setHonorList(null);
        paramTroopHonorView.setVisibility(8);
        return;
      }
      paramQQAppInterface = paramQQAppInterface.convertToHonorList(paramProfileCardInfo.troopMemberCard.honorList, Byte.valueOf(paramProfileCardInfo.troopMemberCard.honorRichTag));
      paramTroopHonorView.setHonorList(paramQQAppInterface, paramFloat);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        paramTroopHonorView.setVisibility(0);
        paramTroopHonorView.setOnClickListener(new ProfileNameView.1(this, paramProfileCardInfo));
      }
      else
      {
        paramTroopHonorView.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.card", 2, String.format("updateTroopHonorView, honorList: %s", new Object[] { paramQQAppInterface }));
      }
    }
    else
    {
      paramTroopHonorView.setHonorList(null);
      paramTroopHonorView.setVisibility(8);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, TroopMemberNewLevelView paramTroopMemberNewLevelView)
  {
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null))
    {
      if (paramTroopMemberNewLevelView == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("call updateTroopMemberNewLevelView troopUin : ");
        ((StringBuilder)localObject1).append(paramProfileCardInfo.troopUin);
        QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject1 = ((TroopManager)localObject2).c(paramProfileCardInfo.troopUin);
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("updateTroopMemberNewLevelView troopInfo is null. troopUin : ");
          paramQQAppInterface.append(paramProfileCardInfo.troopUin);
          QLog.d("ProfileNameView", 2, paramQQAppInterface.toString());
        }
        return;
      }
      int j = paramProfileCardInfo.troopMemberCard.newRealLevel;
      int i = j;
      if (j == 0) {
        i = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertOldLevelToNewLevel(paramProfileCardInfo.troopMemberCard.realLevel);
      }
      localObject1 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem((TroopInfo)localObject1, paramProfileCardInfo.allInOne.uin, i, paramProfileCardInfo.troopMemberCard.titleId, paramProfileCardInfo.troopMemberCard.mUniqueTitle, paramProfileCardInfo.troopMemberCard.honorRichTag);
      if ((localObject1 != null) && (paramTroopMemberNewLevelView != null))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("troopMemberRankItem :");
          ((StringBuilder)localObject2).append(((TroopMemberRankItem)localObject1).toString());
          QLog.d("ProfileNameView", 2, ((StringBuilder)localObject2).toString());
        }
        paramTroopMemberNewLevelView.setTroopMemberNewLevel((TroopMemberRankItem)localObject1);
        paramTroopMemberNewLevelView.setOnClickListener(new ProfileNameView.2(this, paramProfileCardInfo, paramQQAppInterface));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("updateTroopMemberNewLevelView failed - troopUin : ");
        paramQQAppInterface.append(paramProfileCardInfo.troopUin);
        QLog.d("ProfileNameView", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public float a(TextView paramTextView, String paramString, Paint paramPaint)
  {
    return new NickWrapper.NickString(paramString, (int)(paramTextView.getTextSize() / this.jdField_a_of_type_Float)).b(4).a(paramPaint);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor();
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyNickSpanText: ");
      localStringBuilder.append(paramString);
      QLog.d("ProfileNameView", 2, localStringBuilder.toString());
    }
    if ((paramTextView != null) && (paramString != null))
    {
      paramTextView.setTextColor(this.jdField_b_of_type_Int);
      paramString = new ColorNickText(paramString, (int)(paramTextView.getTextSize() / this.jdField_a_of_type_Float)).a();
      paramTextView.setText(paramString);
      ColorNickManager.a(paramQQAppInterface, paramTextView, paramString);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo)
  {
    int i;
    if ((paramQQAppInterface != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null) && (paramProfileCardInfo.profileName != null))
    {
      this.c = 3;
      setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.e);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
      i = getMeasuredWidth();
      if (i > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = i;
      }
    }
    try
    {
      localObject2 = paramProfileCardInfo.profileName.a.jdField_a_of_type_JavaLangString;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label97:
      Object localObject1;
      NickWrapper.NickString localNickString;
      String str;
      Resources localResources;
      float f1;
      ViewGroup localViewGroup;
      TextView localTextView;
      float f2;
      boolean bool;
      float f3;
      int j;
      float f4;
      int k;
      break label97;
    }
    localObject2 = null;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else if (ProfilePAUtils.isPaTypeShowAccount(paramProfileCardInfo.allInOne))
    {
      localObject1 = String.valueOf(paramProfileCardInfo.allInOne.uin);
    }
    else
    {
      localObject1 = " ";
    }
    if ((paramProfileCardInfo.card != null) && (!paramProfileCardInfo.card.isNoCover()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(ScreenUtil.dip2px(1.0F), 0.0F, 0.0F, -16777216);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(ScreenUtil.dip2px(1.0F), 0.0F, 0.0F, -16777216);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getCurrentTextColor());
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
      ((ColorNickTextView)localObject2).setShadowLayer(0.0F, 0.0F, 0.0F, ((ColorNickTextView)localObject2).getCurrentTextColor());
    }
    this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString = new NickWrapper.NickString((String)localObject1, (int)(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize() / this.jdField_a_of_type_Float));
    localNickString = this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b(4);
    this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.a(4);
    str = String.format("%s:%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131691173), this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString });
    if ((!Utils.b(paramProfileCardInfo.allInOne.uin)) && (!paramProfileCardInfo.isTroopMemberCard))
    {
      this.c = 3;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.toString();
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setMaxLines(1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
      paramQQAppInterface = paramProfileCardInfo;
      if (paramProfileCardInfo == null)
      {
        paramQQAppInterface = new TextPaint(1);
        paramQQAppInterface.density = this.jdField_a_of_type_Float;
        paramQQAppInterface.setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
      }
      if (paramQQAppInterface.measureText((String)localObject1) >= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
      }
    }
    else
    {
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131363064);
      if (Utils.b(paramProfileCardInfo.allInOne.uin))
      {
        ((View)localObject1).setVisibility(0);
        f1 = localResources.getDimensionPixelSize(2131297601) + 0.0F;
      }
      else
      {
        ((View)localObject1).setVisibility(8);
        f1 = 0.0F;
      }
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364346);
      if (paramProfileCardInfo.isTroopMemberCard)
      {
        if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramProfileCardInfo.troopUin))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("call old level troopUin : ");
            ((StringBuilder)localObject1).append(paramProfileCardInfo.troopUin);
            QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
          }
          localTextView = (TextView)localViewGroup.findViewById(2131364345);
          a(paramQQAppInterface, paramProfileCardInfo, localViewGroup, localTextView);
          localObject2 = localTextView.getPaint();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new TextPaint(1);
            ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
          }
          f2 = f1;
          if (localViewGroup.getVisibility() != 0) {
            break label935;
          }
          f2 = f1 + ((TextPaint)localObject1).measureText(localTextView.getText().toString()) + localTextView.getPaddingLeft();
          f1 = localTextView.getPaddingRight();
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("call new level troopUin : ");
            ((StringBuilder)localObject1).append(paramProfileCardInfo.troopUin);
            QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = (TroopMemberNewLevelView)findViewById(2131379300);
          f2 = f1;
          if (localObject1 == null) {
            break label935;
          }
          a(paramQQAppInterface, paramProfileCardInfo, (TroopMemberNewLevelView)localObject1);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("call old level troopUin : ");
            ((StringBuilder)localObject2).append(paramProfileCardInfo.troopUin);
            if (((TroopMemberNewLevelView)localObject1).getVisibility() == 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((StringBuilder)localObject2).append(String.valueOf(bool));
            QLog.d("ProfileNameView", 2, ((StringBuilder)localObject2).toString());
          }
          f2 = f1;
          if (((TroopMemberNewLevelView)localObject1).getVisibility() != 0) {
            break label935;
          }
          f3 = ((TroopMemberNewLevelView)localObject1).a() + ViewUtils.a(2.0F);
          f2 = f1;
          f1 = f3;
        }
        f2 += f1;
        label935:
        localObject1 = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364349);
        a(paramQQAppInterface, paramProfileCardInfo, (TroopHonorView)localObject1, this.jdField_a_of_type_Int - f2);
        f1 = f2;
        if (((TroopHonorView)localObject1).getVisibility() == 0) {
          f1 = f2 + ((TroopHonorView)localObject1).a();
        }
      }
      else
      {
        localViewGroup.setVisibility(8);
      }
      j = localResources.getDimensionPixelSize(2131297602);
      f2 = f1 + j;
      this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setSingleLine();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.jdField_a_of_type_Float;
        ((TextPaint)localObject1).setTextSize(this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getTextSize());
      }
      f3 = localNickString.a((Paint)localObject1);
      if (f3 + f2 < this.jdField_a_of_type_Int)
      {
        a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b());
        this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
        paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
        if (QLog.isColorLevel()) {
          QLog.i("ProfileNameView", 2, String.format("update 1 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
        }
        this.c = 1;
      }
      else
      {
        ((TextPaint)localObject1).setTextSize(ScreenUtil.dip2px(this.f));
        f1 = localNickString.a((Paint)localObject1);
        i = this.jdField_a_of_type_Int;
        if (f1 + f2 < i)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
          a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b());
          this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
          paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 2 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
          }
          this.c = 1;
        }
        else if (f3 < i)
        {
          a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b());
          this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
          paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 3 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
          }
          this.c = 2;
        }
        else if (f1 < i)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
          a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b());
          this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
          paramQQAppInterface = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
          if (QLog.isColorLevel()) {
            QLog.i("ProfileNameView", 2, String.format("update 4 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
          }
          this.c = 2;
        }
        else if (paramProfileCardInfo.isTroopMemberCard)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b();
          if ((!((String)localObject1).contains("<")) && (paramProfileCardInfo.troopMemberCard.colorCardId <= 0))
          {
            this.c = 2;
            paramProfileCardInfo = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
            this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
            this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(null);
            this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
            this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(0);
            f4 = this.jdField_a_of_type_Int - ScreenUtil.dip2px(4.0F);
            i = 1;
            for (f1 = 0.0F; (f1 <= f4) && (i < ((String)localObject1).length()); f1 = a((TextView)localObject2, ((String)localObject1).substring(0, i), this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint()))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
              i += 1;
            }
            localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView;
            k = i - 1;
            f1 = a((TextView)localObject2, ((String)localObject1).substring(k), this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint()) + this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaddingLeft() + this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaddingRight();
            if (f1 + f2 > f4)
            {
              f1 = f4 - f2;
              if (f1 < a(this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, ((String)localObject1).substring(k, i + 1), this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.getPaint()))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
                this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setVisibility(8);
                a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
              }
              else
              {
                this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)f1);
                localObject2 = ((String)localObject1).substring(0, k);
                localObject1 = ((String)localObject1).substring(k);
                a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject2);
                a(paramQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
              }
            }
            else
            {
              this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)f1);
              localObject2 = ((String)localObject1).substring(0, k);
              localObject1 = ((String)localObject1).substring(k);
              a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject2);
              a(paramQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
            }
            paramQQAppInterface = paramProfileCardInfo;
            if (QLog.isColorLevel())
            {
              QLog.i("ProfileNameView", 2, String.format("update 5 [n: %s, r: %s, max: %s]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Integer.valueOf(this.jdField_a_of_type_Int) }));
              paramQQAppInterface = paramProfileCardInfo;
            }
          }
          else
          {
            this.c = 1;
            a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (String)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setCustomCloth(paramProfileCardInfo.troopMemberCard.colorCardId);
          }
        }
        else
        {
          this.c = 2;
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setTextSize(1, this.f);
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setEllipsize(TextUtils.TruncateAt.END);
          this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setWidth((int)(this.jdField_a_of_type_Int - f2));
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
          a(paramQQAppInterface, paramProfileCardInfo, this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.b());
          paramQQAppInterface = paramProfileCardInfo;
        }
      }
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      paramProfileCardInfo = (ProfileCardInfo)localObject1;
      if (localObject1 == null) {
        paramProfileCardInfo = new RelativeLayout.LayoutParams(-2, -2);
      }
      if (paramQQAppInterface.getVisibility() == 0)
      {
        paramProfileCardInfo.addRule(1, paramQQAppInterface.getId());
        paramProfileCardInfo.addRule(3, 0);
        paramProfileCardInfo.addRule(8, paramQQAppInterface.getId());
        paramProfileCardInfo.addRule(6, paramQQAppInterface.getId());
        paramProfileCardInfo.topMargin = 0;
        paramProfileCardInfo.leftMargin = j;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramProfileCardInfo);
      }
      else if (paramQQAppInterface == this.jdField_b_of_type_ComTencentMobileqqWidgetColorNickTextView)
      {
        paramProfileCardInfo.addRule(1, 0);
        paramProfileCardInfo.addRule(3, this.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.getId());
        paramProfileCardInfo.addRule(8, 0);
        paramProfileCardInfo.addRule(6, 0);
        paramProfileCardInfo.topMargin = j;
        paramProfileCardInfo.leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramProfileCardInfo);
      }
      else
      {
        paramProfileCardInfo.addRule(1, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramProfileCardInfo.addRule(3, 0);
        paramProfileCardInfo.addRule(8, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramProfileCardInfo.addRule(6, this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getId());
        paramProfileCardInfo.topMargin = 0;
        paramProfileCardInfo.leftMargin = j;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramProfileCardInfo);
      }
    }
    setContentDescription(str);
    setTag(new DataTag(88, this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.toString()));
    setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    LongClickCopyAction.attachCopyAction(this, getResources().getString(2131691294), this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.toString());
    if (QLog.isColorLevel()) {
      QLog.i("ProfileNameView", 2, String.format("update 6 [max: %s, title: %s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqTextNickWrapper$NickString.toString() }));
    }
    return;
    setVisibility(8);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("update failed troopUin : ");
      if (paramProfileCardInfo != null) {
        paramQQAppInterface = paramProfileCardInfo.troopUin;
      } else {
        paramQQAppInterface = "";
      }
      ((StringBuilder)localObject1).append(paramQQAppInterface);
      QLog.d("ProfileNameView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public int b()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingLeft() + (int)this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaint().measureText(this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getText().toString()) + this.jdField_a_of_type_ComTencentMobileqqVipDiyETTextViewPlus.getPaddingRight();
    Object localObject = (TextView)findViewById(2131364345);
    int i = j;
    if (((TextView)localObject).getVisibility() == 0)
    {
      i = j;
      if (!TextUtils.isEmpty(((TextView)localObject).getText())) {
        i = (int)(j + (ViewUtils.b(4.0F) + ((TextView)localObject).getPaddingLeft() + ((TextView)localObject).getPaint().measureText(((TextView)localObject).getText().toString()) + ((TextView)localObject).getPaddingRight()));
      }
    }
    localObject = (TroopHonorView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131364349);
    j = i;
    if (((TroopHonorView)localObject).getVisibility() == 0) {
      j = i + (((TroopHonorView)localObject).getPaddingLeft() + ((TroopHonorView)localObject).a() + ((TroopHonorView)localObject).getPaddingRight());
    }
    localObject = (TroopMemberNewLevelView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131379300);
    i = j;
    if (localObject != null)
    {
      i = j;
      if (((TroopMemberNewLevelView)localObject).getVisibility() == 0) {
        i = (int)(j + (((TroopMemberNewLevelView)localObject).a() + ViewUtils.a(2.0F)));
      }
    }
    return i;
  }
  
  public int c()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileNameView
 * JD-Core Version:    0.7.0.1
 */