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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.OnVipClubPendantClickListener;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.VipIconTouchListener;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ProfileURLDrawableListener;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class ProfileQQLevelView
  extends LinearLayout
{
  private static final int MAX_QQ_LEVEL_LENGTH = 10;
  public static final String TAG = "ProfileQQLevelView";
  private Context mContext;
  public ThemeImageView mDarenIcon;
  private double mDensity;
  private int mIconLength = 10;
  private LayoutInflater mInflater;
  public URLImageView mKingInfo;
  public AnimationTextView mLevelInfo;
  public QQValuePagView mPagLayout;
  public ImageView mPrettyOwner;
  private int mQQLevel;
  private int mQQLevelType;
  private final StringBuilder mSB = new StringBuilder(200);
  public ImageView mVipExtIcon;
  public ImageView mVipIcon;
  public TextView mVipInfo;
  
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
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mDensity = getResources().getDisplayMetrics().density;
    initViews();
  }
  
  private String checkVip(StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Card paramCard)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    if (paramBoolean1)
    {
      localStringBuilder.append("P");
      i = 1;
    }
    else
    {
      i = 0;
    }
    int j;
    if (paramBoolean2)
    {
      j = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
      i = j;
      if (j < 1) {
        i = 1;
      }
      if (paramCard.iQQVipType == 1)
      {
        paramStringBuilder.append("年费超级会员");
        paramStringBuilder.append(i);
        paramStringBuilder.append("级");
      }
      else
      {
        paramStringBuilder.append("超级会员");
        paramStringBuilder.append(i);
        paramStringBuilder.append("级");
      }
    }
    else if (paramBoolean3)
    {
      j = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
      i = j;
      if (j < 1) {
        i = 1;
      }
      if (paramCard.iQQVipType == 1)
      {
        paramStringBuilder.append("年费QQ会员");
        paramStringBuilder.append(i);
        paramStringBuilder.append("级");
      }
      else
      {
        paramStringBuilder.append("QQ会员");
        paramStringBuilder.append(i);
        paramStringBuilder.append("级");
      }
    }
    else
    {
      if (i == 0) {
        paramStringBuilder = "N";
      } else {
        paramStringBuilder = "BN";
      }
      localStringBuilder.append(paramStringBuilder);
    }
    return localStringBuilder.toString();
  }
  
  private boolean decorateVipToken(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return false;
    }
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    } else {
      str1 = paramString;
    }
    Resources localResources = getResources();
    SpannableString localSpannableString = new SpannableString(str1);
    int j = str1.lastIndexOf(")");
    int i = j;
    if (j == -1) {
      i = 0;
    }
    boolean bool = false;
    while (i < str1.length())
    {
      paramString = null;
      j = i + 1;
      String str2 = str1.substring(i, j);
      if ("N".equals(str2))
      {
        paramString = localResources.getDrawable(2130846023);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      else if ("B".equals(str2))
      {
        paramString = localResources.getDrawable(2130846061);
        paramString.setBounds(0, 0, (int)(this.mDensity * 10.0D), paramString.getIntrinsicHeight());
      }
      else
      {
        int k;
        if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130846033);
          k = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), k);
        }
        for (;;)
        {
          bool = true;
          break;
          if (!"G".equalsIgnoreCase(str2)) {
            break;
          }
          paramString = getResources().getDrawable(2130846032);
          k = paramString.getIntrinsicHeight();
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), k);
        }
      }
      if ((!TextUtils.isEmpty(str2)) && (paramString != null)) {
        localSpannableString.setSpan(new VerticalCenterImageSpan(paramString, 1), i, j, 33);
      }
      if ((paramString != null) && ((paramString instanceof URLDrawable))) {
        ((URLDrawable)paramString).setURLDrawableListener(new ProfileURLDrawableListener(paramTextView));
      }
      i = j;
    }
    paramTextView.setText(localSpannableString);
    return bool;
  }
  
  private void initViews()
  {
    this.mInflater.inflate(2131561371, this);
    this.mPrettyOwner = ((ImageView)findViewById(2131374631));
    this.mVipInfo = ((TextView)findViewById(2131368853));
    this.mVipIcon = ((ImageView)findViewById(2131380936));
    this.mVipExtIcon = ((ImageView)findViewById(2131380943));
    this.mKingInfo = ((URLImageView)findViewById(2131368831));
    this.mLevelInfo = ((AnimationTextView)findViewById(2131368792));
    this.mDarenIcon = ((ThemeImageView)findViewById(2131370454));
    this.mDarenIcon.setMaskShape(ThemeImageWrapper.MODE_SQURE);
    this.mPagLayout = ((QQValuePagView)findViewById(2131372274));
    setVisibility(8);
  }
  
  private void updateQQLevelContent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileQQLevelView", 2, String.format("updateQQLevelContent level=%s levelType=%s iconLength=%s", new Object[] { Integer.valueOf(this.mQQLevel), Integer.valueOf(this.mQQLevelType), Integer.valueOf(this.mIconLength) }));
    }
    SpannableString localSpannableString = LevelUtil.a(getContext(), this.mIconLength, this.mQQLevelType, this.mQQLevel, true);
    this.mLevelInfo.setText(localSpannableString, TextView.BufferType.SPANNABLE);
  }
  
  public boolean getDarenIconIsLight(Card paramCard)
  {
    QLog.i("ProfileQQLevelView", 1, "getDarenIconIsLight");
    if (paramCard == null) {
      return false;
    }
    if (paramCard.lQQMasterLogindays > 0L) {
      QQDarenUtils.sQQDarenLoginDays = paramCard.lQQMasterLogindays;
    } else {
      QQDarenUtils.sQQDarenLoginDays = 30L;
    }
    return paramCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt2 = getWidth();
      if (this.mDarenIcon.getVisibility() == 0) {
        paramInt1 = this.mDarenIcon.getWidth();
      } else {
        paramInt1 = 0;
      }
      paramInt3 = this.mLevelInfo.getLeft();
      if (QLog.isColorLevel()) {
        QLog.d("ProfileQQLevelView", 2, String.format("onLayout totalWidth=%s darenWidth=%s levelLeft=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) }));
      }
      this.mIconLength = Math.min((paramInt2 - paramInt1 - paramInt3) / (int)getResources().getDimension(2131297240) - 1, 10);
      updateQQLevelContent();
    }
  }
  
  public void update(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Card localCard;
    if (paramProfileCardInfo == null) {
      localCard = null;
    } else {
      localCard = paramProfileCardInfo.card;
    }
    boolean bool5;
    boolean bool6;
    boolean bool4;
    boolean bool2;
    boolean bool1;
    boolean bool3;
    long l;
    if (localCard != null)
    {
      bool5 = localCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool6 = localCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      bool4 = localCard.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
      if ((localCard.lUserFlag & 1L) == 1L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((localCard.lUserFlag & 0x400) == 1024L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (ProfilePAUtils.isPaTypeShowAccount(paramProfileCardInfo.allInOne)) {}
      while ((bool6) || (bool5) || (localCard.iQQLevel >= 0))
      {
        bool3 = true;
        break;
      }
      bool3 = false;
      if (paramBoolean) {
        bool3 = false;
      }
      bool7 = getDarenIconIsLight(localCard);
      l = localCard.uCurMulType;
      localObject2 = localCard.uin;
      paramBoolean = bool4;
      bool4 = bool7;
      bool7 = bool1;
      bool1 = bool3;
      bool3 = bool7;
    }
    else
    {
      localObject2 = "";
      l = 0L;
      bool1 = false;
      bool3 = false;
      bool5 = false;
      bool6 = false;
      paramBoolean = false;
      bool4 = true;
      bool2 = false;
    }
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "update not show account info");
      }
      setVisibility(8);
      return;
    }
    this.mSB.setLength(0);
    setVisibility(0);
    if ((localCard != null) && (!localCard.isHidePrettyGroutIdentity))
    {
      if (localCard.isPrettyGroupOwner)
      {
        this.mPrettyOwner.setVisibility(0);
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A580", 0, 0, "", "", "", "");
      }
      else
      {
        this.mPrettyOwner.setVisibility(8);
      }
    }
    else {
      this.mPrettyOwner.setVisibility(8);
    }
    Object localObject1 = checkVip(this.mSB, bool3, bool6, bool5, localCard);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mVipIcon);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mVipExtIcon);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mKingInfo);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("update level view :");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" , ");
    ((StringBuilder)localObject3).append(l);
    QLog.e("ProfileQQLevelView", 1, ((StringBuilder)localObject3).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      bool7 = decorateVipToken(this.mVipInfo, (String)localObject1);
      if ((PrettyAccountUtil.a()) && (bool7)) {
        this.mVipInfo.setVisibility(8);
      } else {
        this.mVipInfo.setVisibility(0);
      }
    }
    else
    {
      this.mVipInfo.setVisibility(8);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int[] arrayOfInt = VipUtils.VipIconUtils.a(localQQAppInterface, localCard.uin);
    boolean bool7 = VipUtils.VipIconUtils.a(arrayOfInt[0]);
    int i;
    if ((bool7) && ((localCard.uin.equals(localQQAppInterface.getCurrentAccountUin())) || (!VipUtils.VipIconUtils.b(arrayOfInt[1]))))
    {
      localObject3 = VipUtils.VipIconUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(arrayOfInt[0]), VipUtils.VipIconUtils.b(arrayOfInt[1]));
      j = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(arrayOfInt[0]));
      localObject1 = localObject3;
      i = j;
      if (VipUtils.a(arrayOfInt[0]))
      {
        VipUtils.VipIconUtils.a(this.mContext, this.mVipExtIcon, localCard.nameplateExtId, 2);
        this.mVipExtIcon.setOnClickListener(new VipUtils.OnVipClubPendantClickListener());
        localObject1 = localObject3;
        i = j;
      }
    }
    else
    {
      localObject1 = null;
      i = 0;
    }
    if (!bool7)
    {
      if ((l != 1L) && (l != 2L))
      {
        if ((l != 3L) && (l != 4L))
        {
          if (l != 6L) {
            break label1318;
          }
          if (paramBoolean)
          {
            j = VipUtils.a(localQQAppInterface, (String)localObject2, false);
            if (j >> 8 == 3)
            {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject2, EVIPSPEC.E_SP_BIGCLUB);
                localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130847300;
              }
              else
              {
                i = VipUtils.a(localQQAppInterface, (String)localObject2, EVIPSPEC.E_SP_BIGCLUB);
                localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130847298;
              }
              VipUtils.VipIconUtils.a(this.mContext, this.mVipExtIcon, localCard.nameplateExtId, 2);
              localObject2 = localObject1;
              localObject1 = null;
              j = 1;
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("occur error: curMulType=");
              ((StringBuilder)localObject2).append(l);
              ((StringBuilder)localObject2).append(" but bBigClubVipOpen userStatus=");
              ((StringBuilder)localObject2).append(j);
              localObject3 = ((StringBuilder)localObject2).toString();
              j = 0;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label1324;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("occur error: curMulType=");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" but bBigClubVipOpen is false");
          localObject2 = ((StringBuilder)localObject2).toString();
          break label1315;
        }
        if (bool6)
        {
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
          localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
          if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("svip member icon show :");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("ProfileQQLevelView", 1, ((StringBuilder)localObject2).toString());
          }
          i = 2130847298;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("occur error: curMulType=");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" but bSuperVipOpen is false");
          localObject2 = ((StringBuilder)localObject2).toString();
          break label1315;
        }
      }
      else
      {
        if (!bool5) {
          break label1273;
        }
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("vip member icon show :");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("ProfileQQLevelView", 1, ((StringBuilder)localObject2).toString());
        }
        i = 2130847299;
      }
      localObject2 = null;
      j = 1;
      break label1324;
      label1273:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("occur error: curMulType=");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(" but bQQVipOpen is false");
      localObject2 = ((StringBuilder)localObject2).toString();
      label1315:
      break label1321;
    }
    label1318:
    Object localObject2 = null;
    label1321:
    int j = 0;
    label1324:
    if ((!bool7) && (j == 0))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("ProfileQQLevelView", 1, (String)localObject2);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("it have not handle curMulType=");
        ((StringBuilder)localObject2).append(l);
        QLog.e("ProfileQQLevelView", 1, ((StringBuilder)localObject2).toString());
      }
      if (bool6)
      {
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
        localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
        i = 2130847298;
      }
      else if (bool5)
      {
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        i = 2130847299;
      }
    }
    if ((localObject1 != null) && (i != 0))
    {
      VipUtils.a(getResources(), this.mVipIcon, (String)localObject1, getResources().getDrawable(i));
      this.mVipIcon.setVisibility(0);
      this.mVipIcon.setContentDescription(HardCodeUtil.a(2131716291));
      this.mVipIcon.setFocusableInTouchMode(true);
      localObject1 = VipUtils.VipIconUtils.VipIconTouchListener.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, "VIA_PROFILECARD");
      ((VipUtils.VipIconUtils.VipIconTouchListener)localObject1).a();
      this.mVipIcon.setOnTouchListener((View.OnTouchListener)localObject1);
      if ((this.mVipInfo.getVisibility() == 0) && (this.mVipInfo.getText() != null) && ("N".equals(this.mVipInfo.getText().toString()))) {
        this.mVipInfo.setVisibility(8);
      }
    }
    else
    {
      this.mVipIcon.setVisibility(8);
      this.mVipIcon.setOnTouchListener(null);
    }
    VipGrayConfigHelper.a().a(this.mKingInfo, bool6, localCard.namePlateOfKingLoginTime, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.uin);
    if (localCard.iQQLevel >= 0)
    {
      this.mQQLevelType = localCard.mQQLevelType;
      this.mQQLevel = localCard.iQQLevel;
      updateQQLevelContent();
      localObject1 = this.mSB;
      ((StringBuilder)localObject1).append(" 等级 ");
      ((StringBuilder)localObject1).append(localCard.iQQLevel);
      ((StringBuilder)localObject1).append("级 ");
      this.mLevelInfo.setVisibility(0);
    }
    else
    {
      this.mLevelInfo.setVisibility(8);
    }
    if (!bool4) {
      this.mDarenIcon.setBackgroundResource(2130851162);
    } else {
      this.mDarenIcon.setBackgroundResource(2130851163);
    }
    setContentDescription(this.mSB.toString());
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) }));
    }
    this.mPagLayout.setVisibility(8);
    updateQQValueCard(paramProfileCardInfo);
  }
  
  public void updateQQValueCard(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo == null) {
      paramProfileCardInfo = null;
    } else {
      paramProfileCardInfo = paramProfileCardInfo.card;
    }
    if (paramProfileCardInfo != null)
    {
      QQValuePagView localQQValuePagView = this.mPagLayout;
      if (localQQValuePagView == null) {
        return;
      }
      localQQValuePagView.a(paramProfileCardInfo.uin, "card", ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */