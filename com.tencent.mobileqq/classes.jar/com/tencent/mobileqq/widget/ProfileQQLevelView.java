package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import amis;
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
import atwx;
import awqx;
import azyk;
import bajr;
import bapw;
import bbmf;
import beog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.Card;
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
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495432, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131307682));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302547));
    this.b = ((ImageView)findViewById(2131313431));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131302535));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131302487));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131304169));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)findViewById(2131303891));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(beog.b);
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
        paramString = localResources.getDrawable(2130844905);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, i + 1, 33);
        }
        if ((paramString != null) && ((paramString instanceof URLDrawable))) {
          ((URLDrawable)paramString).setURLDrawableListener(new bbmf(paramTextView));
        }
        i += 1;
        break;
        if ("B".equals(str2))
        {
          paramString = localResources.getDrawable(2130844939);
          paramString.setBounds(0, 0, (int)(10.0D * this.jdField_a_of_type_Double), paramString.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130844916);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130844915);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
      }
    }
    paramTextView.setText(localSpannableString);
  }
  
  public void a(atwx paramatwx, boolean paramBoolean)
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
    String str;
    if (paramatwx == null)
    {
      localCard = null;
      if (localCard == null) {
        break label1740;
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
      if (!ProfileActivity.AllInOne.a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label166;
      }
      bool1 = true;
      if (paramBoolean) {
        bool1 = false;
      }
      paramBoolean = a(localCard);
      l = localCard.uCurMulType;
      str = localCard.uin;
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
        localCard = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard;
        break;
        label154:
        bool2 = false;
        break label57;
        label160:
        bool3 = false;
        break label76;
        label166:
        if ((!bool5) && (!bool6) && (localCard.iQQLevel < 0)) {
          break label1734;
        }
        bool1 = true;
        break label89;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      setVisibility(0);
      label225:
      QVipBigClubSVIP9Config localQVipBigClubSVIP9Config;
      label336:
      int j;
      Object localObject;
      int i;
      if ((localCard == null) || (localCard.isHidePrettyGroutIdentity))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramatwx = a(this.jdField_a_of_type_JavaLangStringBuilder, bool3, bool5, bool6, localCard);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.b);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentImageURLImageView);
        QLog.e("ProfileQQLevelView", 1, "update level view :" + paramatwx + " , " + l);
        if (TextUtils.isEmpty(paramatwx)) {
          break label906;
        }
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramatwx);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localQVipBigClubSVIP9Config = amis.c();
        j = 0;
        localObject = null;
        if ((l != 1L) && (l != 2L)) {
          break label952;
        }
        if (!bool6) {
          break label918;
        }
        i = bajr.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        str = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i & 0xF) << 8 | i >> 8), Integer.valueOf(localCard.iQQVipLevel), Integer.valueOf(0) });
        bajr.a(getResources(), this.b, str, getResources().getDrawable(2130845972));
        this.b.setVisibility(0);
        j = 1;
        if (!QLog.isDebugVersion())
        {
          paramatwx = localObject;
          i = j;
          if (!QLog.isColorLevel()) {}
        }
        else
        {
          QLog.d("ProfileQQLevelView", 1, "vip member icon show :" + str);
          i = j;
          paramatwx = localObject;
        }
        label522:
        if (i == 0)
        {
          if (TextUtils.isEmpty(paramatwx)) {
            break label1561;
          }
          QLog.e("ProfileQQLevelView", 1, paramatwx);
          label541:
          if (!bool5) {
            break label1592;
          }
          i = bajr.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          paramatwx = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i & 0xF) << 8 | i >> 8), Integer.valueOf(localCard.iSuperVipLevel), Long.valueOf(localCard.lSuperVipTemplateId) });
          bajr.a(getResources(), this.b, paramatwx, getResources().getDrawable(2130845971));
          this.b.setVisibility(0);
        }
        label647:
        bapw.a().a(this.jdField_a_of_type_ComTencentImageURLImageView, bool5, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
        if (localCard.iQQLevel < 0) {
          break label1709;
        }
        i = localCard.mQQLevelType;
        paramatwx = azyk.a(getContext(), 10, i, localCard.iQQLevel, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(paramatwx, TextView.BufferType.SPANNABLE);
        this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 ").append(localCard.iQQLevel).append("级 ");
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
        label759:
        if (paramBoolean) {
          break label1721;
        }
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130849386);
      }
      for (;;)
      {
        setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
        return;
        if (localCard.isPrettyGroupOwner)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
          break label225;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label225;
        label906:
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label336;
        label918:
        paramatwx = "occur error: curMulType=" + l + " but bQQVipOpen is false";
        i = j;
        break label522;
        label952:
        if ((l == 3L) || (l == 4L))
        {
          if (bool5)
          {
            i = bajr.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            str = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i & 0xF) << 8 | i >> 8), Integer.valueOf(localCard.iSuperVipLevel), Long.valueOf(localCard.lSuperVipTemplateId) });
            bajr.a(getResources(), this.b, str, getResources().getDrawable(2130845971));
            this.b.setVisibility(0);
            j = 1;
            if (!QLog.isDebugVersion())
            {
              paramatwx = localObject;
              i = j;
              if (!QLog.isColorLevel()) {
                break label522;
              }
            }
            QLog.d("ProfileQQLevelView", 1, "svip member icon show :" + str);
            paramatwx = localObject;
            i = j;
            break label522;
          }
          paramatwx = "occur error: curMulType=" + l + " but bSuperVipOpen is false";
          i = j;
          break label522;
        }
        paramatwx = localObject;
        i = j;
        if (l != 6L) {
          break label522;
        }
        if (bool4)
        {
          paramatwx = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          i = bajr.a(paramatwx, str, false);
          if (i >> 8 == 3) {
            if ((i & 0xF) == 1)
            {
              i = bajr.a(paramatwx, str, EVIPSPEC.E_SP_BIGCLUB);
              paramatwx = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i & 0xF) << 8 | i >> 8), Integer.valueOf(localCard.iBigClubVipLevel), Long.valueOf(localCard.lBigClubTemplateId) });
              bajr.a(getResources(), this.b, paramatwx, getResources().getDrawable(2130845973));
              if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
                QLog.d("ProfileQQLevelView", 1, "big vip year member icon show :" + paramatwx);
              }
              label1348:
              this.b.setVisibility(0);
              i = 1;
              paramatwx = null;
            }
          }
          for (;;)
          {
            break;
            i = bajr.a(paramatwx, str, EVIPSPEC.E_SP_BIGCLUB);
            paramatwx = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i & 0xF) << 8 | i >> 8), Integer.valueOf(localCard.iBigClubVipLevel), Long.valueOf(localCard.lBigClubTemplateId) });
            bajr.a(getResources(), this.b, paramatwx, getResources().getDrawable(2130845971));
            if ((!QLog.isDebugVersion()) && (!QLog.isColorLevel())) {
              break label1348;
            }
            QLog.d("ProfileQQLevelView", 1, "big vip member icon show :" + paramatwx);
            break label1348;
            paramatwx = "occur error: curMulType=" + l + " but bBigClubVipOpen userStatus=" + i;
            i = 0;
          }
        }
        paramatwx = "occur error: curMulType=" + l + " but bBigClubVipOpen is false";
        i = j;
        break label522;
        label1561:
        QLog.e("ProfileQQLevelView", 1, "it have not handle curMulType=" + l);
        break label541;
        label1592:
        if (bool6)
        {
          i = bajr.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          paramatwx = String.format(localQVipBigClubSVIP9Config.mAPngIconUrl, new Object[] { Integer.valueOf((i & 0xF) << 8 | i >> 8), Integer.valueOf(localCard.iQQVipLevel), Integer.valueOf(0) });
          bajr.a(getResources(), this.b, paramatwx, getResources().getDrawable(2130845972));
          this.b.setVisibility(0);
          break label647;
        }
        this.b.setVisibility(8);
        break label647;
        label1709:
        this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(8);
        break label759;
        label1721:
        this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130849387);
      }
      label1734:
      bool1 = false;
      break label89;
      label1740:
      str = "";
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