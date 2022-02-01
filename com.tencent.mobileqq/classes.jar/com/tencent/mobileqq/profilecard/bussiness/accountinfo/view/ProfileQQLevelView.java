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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import anni;
import azfe;
import bcst;
import bghy;
import bgtv;
import bgtw;
import bgtx;
import bham;
import biah;
import bkpg;
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
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561436, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374601));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368632));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380990));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131368620));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131368582));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView = ((ThemeImageView)findViewById(2131370286));
    this.jdField_a_of_type_ComTencentWidgetThemeImageView.setMaskShape(bkpg.jdField_b_of_type_Int);
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
        paramString = localResources.getDrawable(2130845821);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
          localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, i + 1, 33);
        }
        if ((paramString != null) && ((paramString instanceof URLDrawable))) {
          ((URLDrawable)paramString).setURLDrawableListener(new biah(paramTextView));
        }
        i += 1;
        break;
        if ("B".equals(str2))
        {
          paramString = localResources.getDrawable(2130845861);
          paramString.setBounds(0, 0, (int)(10.0D * this.jdField_a_of_type_Double), paramString.getIntrinsicHeight());
        }
        else if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845833);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
        else if ("G".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130845832);
          j = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), j);
        }
      }
    }
    paramTextView.setText(localSpannableString);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileQQLevelView", 2, String.format("updateQQLevelContent level=%s levelType=%s iconLength=%s", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    SpannableString localSpannableString = bghy.a(getContext(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  public void a(azfe paramazfe, boolean paramBoolean)
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
    if (paramazfe == null)
    {
      localCard = null;
      if (localCard == null) {
        break label1647;
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
      if (!ProfileActivity.AllInOne.a(paramazfe.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
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
        localCard = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard;
        break;
        label154:
        bool2 = false;
        break label57;
        label160:
        bool3 = false;
        break label76;
        label166:
        if ((!bool5) && (!bool6) && (localCard.iQQLevel < 0)) {
          break label1641;
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
        paramazfe = a(this.jdField_a_of_type_JavaLangStringBuilder, bool3, bool5, bool6, localCard);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_b_of_type_AndroidWidgetImageView);
        ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentImageURLImageView);
        QLog.e("ProfileQQLevelView", 1, "update level view :" + paramazfe + " , " + l);
        if (TextUtils.isEmpty(paramazfe)) {
          break label1063;
        }
        a(this.jdField_a_of_type_AndroidWidgetTextView, paramazfe);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        int[] arrayOfInt = bgtv.a(localQQAppInterface, localCard.uin);
        bool7 = bgtv.a(arrayOfInt[0]);
        localObject2 = null;
        j = 0;
        i = j;
        paramazfe = (azfe)localObject2;
        if (bool7) {
          if (!localCard.uin.equals(localQQAppInterface.getCurrentAccountUin()))
          {
            i = j;
            paramazfe = (azfe)localObject2;
            if (bgtv.b(arrayOfInt[1])) {}
          }
          else
          {
            paramazfe = bgtv.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, bgtw.a(arrayOfInt[0]), bgtv.b(arrayOfInt[1]));
            i = bgtv.a(bgtw.a(arrayOfInt[0]));
          }
        }
        k = 0;
        localObject2 = null;
        if (bool7) {
          break label1631;
        }
        if ((l != 1L) && (l != 2L)) {
          break label1110;
        }
        if (!bool6) {
          break label1075;
        }
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        paramazfe = bgtv.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
          QLog.d("ProfileQQLevelView", 1, "vip member icon show :" + paramazfe);
        }
        i = 2130847053;
        j = 1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        label579:
        k = i;
        localObject2 = paramazfe;
        if (!bool7)
        {
          k = i;
          localObject2 = paramazfe;
          if (j == 0)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1495;
            }
            QLog.e("ProfileQQLevelView", 1, (String)localObject1);
            label618:
            if (!bool5) {
              break label1526;
            }
            i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
            localObject2 = bgtv.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
            k = 2130847052;
          }
        }
        label673:
        if ((localObject2 != null) && (k != 0))
        {
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2, getResources().getDrawable(k));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(anni.a(2131715479));
          this.jdField_b_of_type_AndroidWidgetImageView.setFocusableInTouchMode(true);
          paramazfe = bgtx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, "VIA_PROFILECARD");
          paramazfe.a();
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(paramazfe);
          if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetTextView.getText() != null) && ("N".equals(this.jdField_a_of_type_AndroidWidgetTextView.getText().toString()))) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          label816:
          bham.a().a(this.jdField_a_of_type_ComTencentImageURLImageView, bool5, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
          if (localCard.iQQLevel < 0) {
            break label1606;
          }
          this.jdField_b_of_type_Int = localCard.mQQLevelType;
          this.c = localCard.iQQLevel;
          b();
          this.jdField_a_of_type_JavaLangStringBuilder.append(" 等级 ").append(localCard.iQQLevel).append("级 ");
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(0);
          if (paramBoolean) {
            break label1618;
          }
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850732);
        }
        for (;;)
        {
          label916:
          setContentDescription(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
          return;
          if (localCard.isPrettyGroupOwner)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            bcst.b(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
            break label225;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break label225;
          label1063:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label336;
          label1075:
          localObject1 = "occur error: curMulType=" + l + " but bQQVipOpen is false";
          j = 0;
          break label579;
          label1110:
          if ((l == 3L) || (l == 4L))
          {
            if (bool5)
            {
              i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
              paramazfe = bgtv.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
              if ((QLog.isDebugVersion()) || (QLog.isColorLevel())) {
                QLog.d("ProfileQQLevelView", 1, "svip member icon show :" + paramazfe);
              }
              i = 2130847052;
              j = 1;
              localObject1 = localObject2;
              break label579;
            }
            localObject1 = "occur error: curMulType=" + l + " but bSuperVipOpen is false";
            j = 0;
            break label579;
          }
          if (l != 6L) {
            break label1631;
          }
          if (bool4)
          {
            j = VipUtils.a(localQQAppInterface, (String)localObject1, false);
            if (j >> 8 == 3) {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
                paramazfe = bgtv.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130847054;
                label1348:
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
              paramazfe = bgtv.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
              i = 2130847052;
              break label1348;
              localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen userStatus=" + j;
              j = i;
            }
          }
          localObject1 = "occur error: curMulType=" + l + " but bBigClubVipOpen is false";
          j = 0;
          break label579;
          label1495:
          QLog.e("ProfileQQLevelView", 1, "it have not handle curMulType=" + l);
          break label618;
          label1526:
          k = i;
          localObject2 = paramazfe;
          if (!bool6) {
            break label673;
          }
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          localObject2 = bgtv.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
          k = 2130847053;
          break label673;
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setOnTouchListener(null);
          break label816;
          label1606:
          this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setVisibility(8);
          break label916;
          label1618:
          this.jdField_a_of_type_ComTencentWidgetThemeImageView.setBackgroundResource(2130850733);
        }
        label1631:
        j = 0;
        localObject1 = localObject2;
      }
      label1641:
      bool1 = false;
      break label89;
      label1647:
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
      this.jdField_a_of_type_Int = Math.min((paramInt2 - paramInt1 - paramInt3) / (int)getResources().getDimension(2131297158) - 1, 10);
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */