package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import alud;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import awqt;
import azqs;
import bddf;
import bdow;
import bdox;
import bdoy;
import bdvk;
import betl;
import bibv;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class ProfileQQLevelView
  extends LinearLayout
{
  private double jdField_a_of_type_Double;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public URLImageView a;
  public AnimationTextView a;
  public ThemeImageView a;
  private final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(200);
  public ImageView b;
  
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
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561213, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373897));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368324));
    this.b = ((ImageView)findViewById(2131380029));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131368312));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131368256));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131370129));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)findViewById(2131369846));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bibv.b);
    setVisibility(8);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return;
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
    if (i < str1.length())
    {
      paramString = null;
      String str2 = str1.substring(i, i + 1);
      if ("N".equals(str2))
      {
        paramString = localResources.getDrawable(2130845424);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, i + 1, 33);
        }
        if ((paramString != null) && ((paramString instanceof URLDrawable))) {
          ((URLDrawable)paramString).setURLDrawableListener(new betl(paramTextView));
        }
        i += 1;
        break;
        if ("B".equals(str2))
        {
          paramString = localResources.getDrawable(2130845464);
          paramString.setBounds(0, 0, (int)(10.0D * this.jdField_a_of_type_Double), paramString.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845436);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845435);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
      }
    }
    paramTextView.setText(localSpannableString);
  }
  
  public void a(awqt paramawqt, boolean paramBoolean)
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
    Object localObject1;
    if (paramawqt == null)
    {
      localCard = null;
      if (localCard == null) {
        break label1659;
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
      if (!ProfileActivity.AllInOne.a(paramawqt.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label166;
      }
      bool1 = true;
      if (paramBoolean) {
        bool1 = false;
      }
      paramBoolean = a(localCard);
      l = localCard.uCurMulType;
      localObject1 = localCard.uin;
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
        localCard = paramawqt.jdField_a_of_type_ComTencentMobileqqDataCard;
        break;
        label154:
        bool2 = false;
        break label57;
        label160:
        bool3 = false;
        break label76;
        label166:
        if ((!bool5) && (!bool6) && (localCard.iQQLevel < 0)) {
          break label1653;
        }
        bool1 = true;
        break label89;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      setVisibility(0);
      label225:
      QQAppInterface localQQAppInterface;
      label336:
      boolean bool7;
      Object localObject2;
      int j;
      int i;
      int k;
      if ((localCard == null) || (localCard.isHidePrettyGroutIdentity))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramawqt = a(this.jdField_a_of_type_JavaLangStringBuilder, bool3, bool5, bool6, localCard);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.b);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentImageURLImageView);
        QLog.e("ProfileQQLevelView", 1, "update level view :" + paramawqt + " , " + l);
        if (TextUtils.isEmpty(paramawqt)) {
          break label1075;
        }
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramawqt);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        int[] arrayOfInt = bdow.a(localQQAppInterface, localCard.uin);
        bool7 = bdow.a(arrayOfInt[0]);
        localObject2 = null;
        j = 0;
        i = j;
        paramawqt = (awqt)localObject2;
        if (bool7) {
          if (!localCard.uin.equals(localQQAppInterface.getCurrentAccountUin()))
          {
            i = j;
            paramawqt = (awqt)localObject2;
            if (bdow.b(arrayOfInt[1])) {}
          }
          else
          {
            paramawqt = bdow.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, bdox.a(arrayOfInt[0]), bdow.b(arrayOfInt[1]));
            i = bdow.a(bdox.a(arrayOfInt[0]));
          }
        }
        k = 0;
        localObject2 = null;
        if (bool7) {
          break label1643;
        }
        if ((l != 1L) && (l != 2L)) {
          break label1122;
        }
        if (!bool6) {
          break label1087;
        }
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        paramawqt = bdow.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.d("ProfileQQLevelView", 1, "vip member icon show :" + paramawqt);
        }
        i = 2130846611;
        j = 1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        label579:
        k = i;
        localObject2 = paramawqt;
        if (!bool7)
        {
          k = i;
          localObject2 = paramawqt;
          if (j == 0)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1507;
            }
            QLog.e("ProfileQQLevelView", 1, (String)localObject1);
            label618:
            if (!bool5) {
              break label1538;
            }
            i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            localObject2 = bdow.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
            k = 2130846610;
          }
        }
        label673:
        if ((localObject2 != null) && (k != 0))
        {
          VipUtils.a(getResources(), this.b, (String)localObject2, getResources().getDrawable(k));
          this.b.setVisibility(0);
          this.b.setContentDescription(alud.a(2131717202));
          this.b.setFocusableInTouchMode(true);
          paramawqt = bdoy.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, "VIA_PROFILECARD");
          paramawqt.a();
          this.b.setOnTouchListener(paramawqt);
          if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView.getText() != null) && ("N".equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          label816:
          bdvk.a().a(this.jdField_a_of_type_ComTencentImageURLImageView, bool5, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
          if (localCard.iQQLevel < 0) {
            break label1618;
          }
          i = localCard.mQQLevelType;
          paramawqt = bddf.a(getContext(), 10, i, localCard.iQQLevel, true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(paramawqt, TextView.BufferType.SPANNABLE);
          this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 ").append(localCard.iQQLevel).append("级 ");
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
          if (paramBoolean) {
            break label1630;
          }
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850138);
        }
        for (;;)
        {
          label928:
          setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
          return;
          if (localCard.isPrettyGroupOwner)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
            break label225;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label225;
          label1075:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label336;
          label1087:
          localObject1 = "occur error: curMulType=" + l + " but bQQVipOpen is false";
          j = 0;
          break label579;
          label1122:
          if ((l == 3L) || (l == 4L))
          {
            if (bool5)
            {
              i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
              paramawqt = bdow.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
              if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
                QLog.d("ProfileQQLevelView", 1, "svip member icon show :" + paramawqt);
              }
              i = 2130846610;
              j = 1;
              localObject1 = localObject2;
              break label579;
            }
            localObject1 = "occur error: curMulType=" + l + " but bSuperVipOpen is false";
            j = 0;
            break label579;
          }
          if (l != 6L) {
            break label1643;
          }
          if (bool4)
          {
            j = VipUtils.a(localQQAppInterface, (String)localObject1, false);
            if (j >> 8 == 3) {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
                paramawqt = bdow.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130846612;
                label1360:
                localObject1 = null;
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
              i = VipUtils.a(localQQAppInterface, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
              paramawqt = bdow.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
              i = 2130846610;
              break label1360;
              localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen userStatus=" + j;
              j = i;
            }
          }
          localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen is false";
          j = 0;
          break label579;
          label1507:
          QLog.e("ProfileQQLevelView", 1, "it have not handle curMulType=" + l);
          break label618;
          label1538:
          k = i;
          localObject2 = paramawqt;
          if (!bool6) {
            break label673;
          }
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          localObject2 = bdow.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
          k = 2130846611;
          break label673;
          this.b.setVisibility(8);
          this.b.setOnTouchListener(null);
          break label816;
          label1618:
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(8);
          break label928;
          label1630:
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850139);
        }
        label1643:
        j = 0;
        localObject1 = localObject2;
      }
      label1653:
      bool1 = false;
      break label89;
      label1659:
      localObject1 = "";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */