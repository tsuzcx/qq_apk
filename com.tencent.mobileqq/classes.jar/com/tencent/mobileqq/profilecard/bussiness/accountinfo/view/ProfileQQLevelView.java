package com.tencent.mobileqq.profilecard.bussiness.accountinfo.view;

import QQService.EVIPSPEC;
import amtj;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import aymg;
import bcef;
import bfrj;
import bgan;
import bgao;
import bgap;
import bgff;
import bghc;
import bhhg;
import bjuk;
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
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561361, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374506));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368729));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380889));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131368717));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131368679));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)findViewById(2131370355));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bjuk.jdField_b_of_type_Int);
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
        paramString = localResources.getDrawable(2130845736);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, i + 1, 33);
        }
        if ((paramString != null) && ((paramString instanceof URLDrawable))) {
          ((URLDrawable)paramString).setURLDrawableListener(new bhhg(paramTextView));
        }
        i += 1;
        break;
        if ("B".equals(str2))
        {
          paramString = localResources.getDrawable(2130845776);
          paramString.setBounds(0, 0, (int)(10.0D * this.jdField_a_of_type_Double), paramString.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845748);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
          bool = true;
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845747);
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
    SpannableString localSpannableString = bfrj.a(getContext(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  public void a(aymg paramaymg, boolean paramBoolean)
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
    if (paramaymg == null)
    {
      localCard = null;
      if (localCard == null) {
        break label1672;
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
      if (!ProfileActivity.AllInOne.a(paramaymg.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
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
        localCard = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard;
        break;
        label154:
        bool2 = false;
        break label57;
        label160:
        bool3 = false;
        break label76;
        label166:
        if ((!bool5) && (!bool6) && (localCard.iQQLevel < 0)) {
          break label1666;
        }
        bool1 = true;
        break label89;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      setVisibility(0);
      label225:
      boolean bool7;
      label350:
      QQAppInterface localQQAppInterface;
      Object localObject2;
      int j;
      int i;
      int k;
      if ((localCard == null) || (localCard.isHidePrettyGroutIdentity))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaymg = a(this.jdField_a_of_type_JavaLangStringBuilder, bool3, bool5, bool6, localCard);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_b_of_type_AndroidWidgetImageView);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentImageURLImageView);
        QLog.e("ProfileQQLevelView", 1, "update level view :" + paramaymg + " , " + l);
        if (TextUtils.isEmpty(paramaymg)) {
          break label1088;
        }
        bool7 = a(this.jdField_a_of_type_AndroidWidgetTextView, paramaymg);
        if ((!bgff.a()) || (!bool7)) {
          break label1077;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        int[] arrayOfInt = bgan.a(localQQAppInterface, localCard.uin);
        bool7 = bgan.a(arrayOfInt[0]);
        localObject2 = null;
        j = 0;
        i = j;
        paramaymg = (aymg)localObject2;
        if (bool7) {
          if (!localCard.uin.equals(localQQAppInterface.getCurrentAccountUin()))
          {
            i = j;
            paramaymg = (aymg)localObject2;
            if (bgan.b(arrayOfInt[1])) {}
          }
          else
          {
            paramaymg = bgan.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, bgao.a(arrayOfInt[0]), bgan.b(arrayOfInt[1]));
            i = bgan.a(bgao.a(arrayOfInt[0]));
          }
        }
        k = 0;
        localObject2 = null;
        if (bool7) {
          break label1656;
        }
        if ((l != 1L) && (l != 2L)) {
          break label1135;
        }
        if (!bool6) {
          break label1100;
        }
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        paramaymg = bgan.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.d("ProfileQQLevelView", 1, "vip member icon show :" + paramaymg);
        }
        i = 2130846978;
        j = 1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        label593:
        k = i;
        localObject2 = paramaymg;
        if (!bool7)
        {
          k = i;
          localObject2 = paramaymg;
          if (j == 0)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1520;
            }
            QLog.e("ProfileQQLevelView", 1, (String)localObject1);
            label632:
            if (!bool5) {
              break label1551;
            }
            i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            localObject2 = bgan.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
            k = 2130846977;
          }
        }
        label687:
        if ((localObject2 != null) && (k != 0))
        {
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2, getResources().getDrawable(k));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(amtj.a(2131715822));
          this.jdField_b_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
          paramaymg = bgap.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, "VIA_PROFILECARD");
          paramaymg.a();
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(paramaymg);
          if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView.getText() != null) && ("N".equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          label830:
          bghc.a().a(this.jdField_a_of_type_ComTencentImageURLImageView, bool5, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
          if (localCard.iQQLevel < 0) {
            break label1631;
          }
          this.jdField_b_of_type_Int = localCard.mQQLevelType;
          this.c = localCard.iQQLevel;
          b();
          this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 ").append(localCard.iQQLevel).append("级 ");
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
          if (paramBoolean) {
            break label1643;
          }
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850680);
        }
        for (;;)
        {
          label930:
          setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
          return;
          if (localCard.isPrettyGroupOwner)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            bcef.b(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
            break label225;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label225;
          label1077:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          break label350;
          label1088:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label350;
          label1100:
          localObject1 = "occur error: curMulType=" + l + " but bQQVipOpen is false";
          j = 0;
          break label593;
          label1135:
          if ((l == 3L) || (l == 4L))
          {
            if (bool5)
            {
              i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
              paramaymg = bgan.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
              if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
                QLog.d("ProfileQQLevelView", 1, "svip member icon show :" + paramaymg);
              }
              i = 2130846977;
              j = 1;
              localObject1 = localObject2;
              break label593;
            }
            localObject1 = "occur error: curMulType=" + l + " but bSuperVipOpen is false";
            j = 0;
            break label593;
          }
          if (l != 6L) {
            break label1656;
          }
          if (bool4)
          {
            j = VipUtils.a(localQQAppInterface, (String)localObject1, false);
            if (j >> 8 == 3) {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
                paramaymg = bgan.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130846979;
                label1373:
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
              paramaymg = bgan.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
              i = 2130846977;
              break label1373;
              localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen userStatus=" + j;
              j = i;
            }
          }
          localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen is false";
          j = 0;
          break label593;
          label1520:
          QLog.e("ProfileQQLevelView", 1, "it have not handle curMulType=" + l);
          break label632;
          label1551:
          k = i;
          localObject2 = paramaymg;
          if (!bool6) {
            break label687;
          }
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          localObject2 = bgan.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
          k = 2130846978;
          break label687;
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(null);
          break label830;
          label1631:
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(8);
          break label930;
          label1643:
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850681);
        }
        label1656:
        j = 0;
        localObject1 = localObject2;
      }
      label1666:
      bool1 = false;
      break label89;
      label1672:
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
      this.jdField_a_of_type_Int = Math.min((paramInt2 - paramInt1 - paramInt3) / (int)getResources().getDimension(2131297225) - 1, 10);
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */