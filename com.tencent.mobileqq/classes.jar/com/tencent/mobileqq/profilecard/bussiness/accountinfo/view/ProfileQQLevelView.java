package com.tencent.mobileqq.profilecard.bussiness.accountinfo.view;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import anvx;
import azrb;
import bdla;
import bhaa;
import bhjf;
import bhjg;
import bhjh;
import bhnz;
import bhpw;
import bibb;
import biry;
import blfw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class ProfileQQLevelView
  extends LinearLayout
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = 10;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public ImageView a;
  public TextView a;
  public URLImageView a;
  public VasPagView a;
  public AnimationTextView a;
  public ThemeImageView a;
  private final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(200);
  private int b;
  public ImageView b;
  private int c;
  
  public ProfileQQLevelView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ProfileQQLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileQQLevelView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Double = getResources().getDisplayMetrics().density;
    a();
  }
  
  private String a(StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Card paramCard)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1)
    {
      localStringBuilder.append("P");
      i = 1;
    }
    int j;
    if (paramBoolean2)
    {
      j = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
      i = j;
      if (j < 1) {
        i = 1;
      }
      if (paramCard.iQQVipType == 1) {
        paramStringBuilder.append("年费超级会员").append(i).append("级");
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      paramStringBuilder.append("超级会员").append(i).append("级");
      continue;
      if (!paramBoolean3) {
        break;
      }
      j = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
      i = j;
      if (j < 1) {
        i = 1;
      }
      if (paramCard.iQQVipType == 1) {
        paramStringBuilder.append("年费QQ会员").append(i).append("级");
      } else {
        paramStringBuilder.append("QQ会员").append(i).append("级");
      }
    }
    if (i == 0) {}
    for (paramStringBuilder = "N";; paramStringBuilder = "BN")
    {
      localStringBuilder.append(paramStringBuilder);
      break;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561423, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374744));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368888));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381241));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131368876));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131368838));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)findViewById(2131370538));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(blfw.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = ((VasPagView)findViewById(2131372386));
    setVisibility(8);
  }
  
  private boolean a(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return false;
    }
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    Resources localResources = getResources();
    SpannableString localSpannableString = new SpannableString(str1);
    int j = str1.lastIndexOf(")");
    int i = j;
    if (j == -1) {
      i = 0;
    }
    boolean bool = false;
    if (i < str1.length())
    {
      paramString = null;
      String str2 = str1.substring(i, i + 1);
      if ("N".equals(str2))
      {
        paramString = localResources.getDrawable(2130845824);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, i + 1, 33);
        }
        if ((paramString != null) && ((paramString instanceof URLDrawable))) {
          ((URLDrawable)paramString).setURLDrawableListener(new biry(paramTextView));
        }
        i += 1;
        break;
        if ("B".equals(str2))
        {
          paramString = localResources.getDrawable(2130845864);
          paramString.setBounds(0, 0, (int)(10.0D * this.jdField_a_of_type_Double), paramString.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845836);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
          bool = true;
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845835);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
          bool = true;
        }
      }
    }
    paramTextView.setText(localSpannableString);
    return bool;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileQQLevelView", 2, String.format("updateQQLevelContent level=%s levelType=%s iconLength=%s", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    SpannableString localSpannableString = bhaa.a(getContext(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  public void a(azrb paramazrb)
  {
    if (paramazrb == null) {}
    for (paramazrb = null; (paramazrb == null) || (this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView == null); paramazrb = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard) {
      return;
    }
    bibb.a(this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView, paramazrb.uin, "card");
  }
  
  public void a(azrb paramazrb, boolean paramBoolean)
  {
    Card localCard;
    boolean bool6;
    boolean bool5;
    boolean bool4;
    boolean bool2;
    label57:
    boolean bool3;
    label76:
    boolean bool1;
    label89:
    long l;
    Object localObject2;
    if (paramazrb == null)
    {
      localCard = null;
      if (localCard == null) {
        break label1705;
      }
      bool6 = localCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool5 = localCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      bool4 = localCard.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
      if ((localCard.lUserFlag & 1L) != 1L) {
        break label154;
      }
      bool2 = true;
      if ((localCard.lUserFlag & 0x400) != 1024L) {
        break label160;
      }
      bool3 = true;
      if (!ProfileActivity.AllInOne.a(paramazrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label166;
      }
      bool1 = true;
      if (paramBoolean) {
        bool1 = false;
      }
      paramBoolean = a(localCard);
      l = localCard.uCurMulType;
      localObject2 = localCard.uin;
    }
    for (;;)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "update not show account info");
        }
        setVisibility(8);
        return;
        localCard = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard;
        break;
        label154:
        bool2 = false;
        break label57;
        label160:
        bool3 = false;
        break label76;
        label166:
        if ((!bool5) && (!bool6) && (localCard.iQQLevel < 0)) {
          break label1699;
        }
        bool1 = true;
        break label89;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      setVisibility(0);
      Object localObject1;
      boolean bool7;
      label354:
      QQAppInterface localQQAppInterface;
      Object localObject3;
      int j;
      int i;
      int k;
      if ((localCard == null) || (localCard.isHidePrettyGroutIdentity))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject1 = a(this.jdField_a_of_type_JavaLangStringBuilder, bool3, bool5, bool6, localCard);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_b_of_type_AndroidWidgetImageView);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentImageURLImageView);
        QLog.e("ProfileQQLevelView", 1, "update level view :" + (String)localObject1 + " , " + l);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1116;
        }
        bool7 = a(this.jdField_a_of_type_AndroidWidgetTextView, (String)localObject1);
        if ((!bhnz.a()) || (!bool7)) {
          break label1105;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        int[] arrayOfInt = bhjf.a(localQQAppInterface, localCard.uin);
        bool7 = bhjf.a(arrayOfInt[0]);
        localObject3 = null;
        j = 0;
        i = j;
        localObject1 = localObject3;
        if (bool7) {
          if (!localCard.uin.equals(localQQAppInterface.getCurrentAccountUin()))
          {
            i = j;
            localObject1 = localObject3;
            if (bhjf.b(arrayOfInt[1])) {}
          }
          else
          {
            localObject1 = bhjf.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, bhjg.a(arrayOfInt[0]), bhjf.b(arrayOfInt[1]));
            i = bhjf.a(bhjg.a(arrayOfInt[0]));
          }
        }
        k = 0;
        localObject3 = null;
        if (bool7) {
          break label1689;
        }
        if ((l != 1L) && (l != 2L)) {
          break label1163;
        }
        if (!bool6) {
          break label1128;
        }
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        localObject1 = bhjf.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.d("ProfileQQLevelView", 1, "vip member icon show :" + (String)localObject1);
        }
        i = 2130847075;
        j = 1;
        localObject2 = localObject3;
      }
      for (;;)
      {
        label602:
        k = i;
        localObject3 = localObject1;
        if (!bool7)
        {
          k = i;
          localObject3 = localObject1;
          if (j == 0)
          {
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1552;
            }
            QLog.e("ProfileQQLevelView", 1, (String)localObject2);
            label643:
            if (!bool5) {
              break label1583;
            }
            i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            localObject3 = bhjf.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
            k = 2130847074;
          }
        }
        label698:
        if ((localObject3 != null) && (k != 0))
        {
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject3, getResources().getDrawable(k));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131716170));
          this.jdField_b_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
          localObject1 = bhjh.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, "VIA_PROFILECARD");
          ((bhjh)localObject1).a();
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener((View.OnTouchListener)localObject1);
          if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView.getText() != null) && ("N".equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          label844:
          bhpw.a().a(this.jdField_a_of_type_ComTencentImageURLImageView, bool5, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
          if (localCard.iQQLevel < 0) {
            break label1664;
          }
          this.jdField_b_of_type_Int = localCard.mQQLevelType;
          this.c = localCard.iQQLevel;
          b();
          this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 ").append(localCard.iQQLevel).append("级 ");
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
          if (paramBoolean) {
            break label1676;
          }
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850822);
        }
        for (;;)
        {
          label944:
          setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
          }
          this.jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.setVisibility(8);
          a(paramazrb);
          return;
          if (localCard.isPrettyGroupOwner)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          label1105:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          break label354;
          label1116:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label354;
          label1128:
          localObject2 = "occur error: curMulType=" + l + " but bQQVipOpen is false";
          j = 0;
          break label602;
          label1163:
          if ((l == 3L) || (l == 4L))
          {
            if (bool5)
            {
              i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
              localObject1 = bhjf.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
              if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
                QLog.d("ProfileQQLevelView", 1, "svip member icon show :" + (String)localObject1);
              }
              i = 2130847074;
              j = 1;
              localObject2 = localObject3;
              break label602;
            }
            localObject2 = "occur error: curMulType=" + l + " but bSuperVipOpen is false";
            j = 0;
            break label602;
          }
          if (l != 6L) {
            break label1689;
          }
          if (bool4)
          {
            j = VipUtils.a(localQQAppInterface, (String)localObject2, false);
            if (j >> 8 == 3) {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject2, EVIPSPEC.E_SP_BIGCLUB);
                localObject1 = bhjf.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130847076;
                label1404:
                localObject2 = null;
                k = 1;
                j = i;
              }
            }
            for (i = k;; i = k)
            {
              k = i;
              i = j;
              j = k;
              break;
              i = VipUtils.a(localQQAppInterface, (String)localObject2, EVIPSPEC.E_SP_BIGCLUB);
              localObject1 = bhjf.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
              i = 2130847074;
              break label1404;
              localObject2 = "occur error: curMulType=" + l + " but bBigClubVipOpen userStatus=" + j;
              j = i;
            }
          }
          localObject2 = "occur error: curMulType=" + l + " but bBigClubVipOpen is false";
          j = 0;
          break label602;
          label1552:
          QLog.e("ProfileQQLevelView", 1, "it have not handle curMulType=" + l);
          break label643;
          label1583:
          k = i;
          localObject3 = localObject1;
          if (!bool6) {
            break label698;
          }
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          localObject3 = bhjf.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
          k = 2130847075;
          break label698;
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(null);
          break label844;
          label1664:
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(8);
          break label944;
          label1676:
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850823);
        }
        label1689:
        j = 0;
        localObject2 = localObject3;
      }
      label1699:
      bool1 = false;
      break label89;
      label1705:
      localObject2 = "";
      paramBoolean = true;
      l = 0L;
      bool1 = false;
      bool3 = false;
      bool2 = false;
      bool4 = false;
      bool5 = false;
      bool6 = false;
    }
  }
  
  public boolean a(Card paramCard)
  {
    QLog.i("ProfileQQLevelView", 1, "getDarenIconIsLight");
    if (paramCard == null) {}
    for (;;)
    {
      return false;
      if (paramCard.lQQMasterLogindays > 0L) {}
      for (FriendProfileCardActivity.a = paramCard.lQQMasterLogindays; paramCard.lLoginDays >= FriendProfileCardActivity.a; FriendProfileCardActivity.a = 30L) {
        return true;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt2 = getWidth();
      if (this.jdField_a_of_type_ComTencentWidgetThemeImageView.getVisibility() != 0) {
        break label126;
      }
    }
    label126:
    for (paramInt1 = this.jdField_a_of_type_ComTencentWidgetThemeImageView.getWidth();; paramInt1 = 0)
    {
      paramInt3 = this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.getLeft();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQQLevelView", 2, String.format("onLayout totalWidth=%s darenWidth=%s levelLeft=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) }));
      }
      this.jdField_a_of_type_Int = Math.min((paramInt2 - paramInt1 - paramInt3) / (int)getResources().getDimension(2131297226) - 1, 10);
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */