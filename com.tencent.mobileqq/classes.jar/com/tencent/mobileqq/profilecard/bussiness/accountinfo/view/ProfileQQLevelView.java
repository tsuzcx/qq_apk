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
import com.tencent.mobileqq.profilecard.data.AllInOne;
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
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ProfileURLDrawableListener;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;
import mqq.app.AppRuntime;

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
        paramString = localResources.getDrawable(2130847493);
        paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
      }
      else if ("B".equals(str2))
      {
        paramString = localResources.getDrawable(2130847531);
        paramString.setBounds(0, 0, (int)(this.mDensity * 10.0D), paramString.getIntrinsicHeight());
      }
      else
      {
        int k;
        if ("P".equalsIgnoreCase(str2))
        {
          paramString = getResources().getDrawable(2130847503);
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
          paramString = getResources().getDrawable(2130847502);
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
    this.mInflater.inflate(2131627727, this);
    this.mPrettyOwner = ((ImageView)findViewById(2131442801));
    this.mVipInfo = ((TextView)findViewById(2131435787));
    this.mVipIcon = ((ImageView)findViewById(2131449926));
    this.mVipExtIcon = ((ImageView)findViewById(2131449933));
    this.mKingInfo = ((URLImageView)findViewById(2131435762));
    this.mLevelInfo = ((AnimationTextView)findViewById(2131435713));
    this.mDarenIcon = ((ThemeImageView)findViewById(2131437724));
    this.mDarenIcon.setMaskShape(ThemeImageWrapper.MODE_SQURE);
    this.mPagLayout = ((QQValuePagView)findViewById(2131439784));
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
      this.mIconLength = Math.min((paramInt2 - paramInt1 - paramInt3) / (int)getResources().getDimension(2131297671) - 1, 10);
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
    boolean bool4;
    boolean bool6;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    long l;
    boolean bool5;
    if (localCard != null)
    {
      bool4 = localCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool7 = localCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      bool6 = localCard.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
      if ((localCard.lUserFlag & 1L) == 1L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((localCard.lUserFlag & 0x400) == 1024L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (((!ProfilePAUtils.isPaTypeShowAccount(paramProfileCardInfo.allInOne)) || (ProfilePAUtils.isFromGuild(paramProfileCardInfo.allInOne.pa))) && (!bool7) && (!bool4) && (localCard.iQQLevel < 0)) {
        bool3 = false;
      } else {
        bool3 = true;
      }
      if (paramBoolean) {
        bool3 = false;
      }
      boolean bool8 = getDarenIconIsLight(localCard);
      l = localCard.uCurMulType;
      localObject1 = localCard.uin;
      paramBoolean = bool4;
      bool5 = bool2;
      bool4 = bool3;
      bool3 = bool7;
      bool2 = bool6;
      bool6 = bool8;
    }
    else
    {
      localObject1 = "";
      bool1 = false;
      bool2 = false;
      bool3 = false;
      l = 0L;
      bool4 = false;
      bool5 = false;
      paramBoolean = false;
      bool6 = true;
    }
    if (!bool4)
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
    Object localObject2 = checkVip(this.mSB, bool5, bool3, paramBoolean, localCard);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mVipIcon);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mVipExtIcon);
    ProfileCardUtils.setNightModeFilterForImageView((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mKingInfo);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("update level view :");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(" , ");
    ((StringBuilder)localObject3).append(l);
    QLog.e("ProfileQQLevelView", 1, ((StringBuilder)localObject3).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      bool7 = decorateVipToken(this.mVipInfo, (String)localObject2);
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
    localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject4 = VipUtils.VipIconUtils.a((AppRuntime)localObject3, localCard.uin);
    boolean bool7 = VipUtils.VipIconUtils.a(localObject4[0]);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("update data bQQVipOpen = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(" bSuperVipOpen = ");
    ((StringBuilder)localObject2).append(bool3);
    ((StringBuilder)localObject2).append(" bBigClubVipOpen");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append(" bEnterprise = ");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(" bPrettyNumber = ");
    ((StringBuilder)localObject2).append(bool5);
    ((StringBuilder)localObject2).append(" curMulType = ");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(" isDiy = ");
    ((StringBuilder)localObject2).append(bool7);
    ((StringBuilder)localObject2).append(" nameplateVipType = ");
    ((StringBuilder)localObject2).append(localObject4[0]);
    QLog.e("ProfileQQLevelView", 1, ((StringBuilder)localObject2).toString());
    int i;
    if ((bool7) && ((localCard.uin.equals(((QQAppInterface)localObject3).getCurrentAccountUin())) || (!VipUtils.VipIconUtils.b(localObject4[1]))))
    {
      localObject2 = VipUtils.VipIconUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, VipUtils.VipIconUtils.NamePlateVipTpye.a(localObject4[0]), VipUtils.VipIconUtils.b(localObject4[1]));
      i = VipUtils.VipIconUtils.a(VipUtils.VipIconUtils.NamePlateVipTpye.a(localObject4[0]));
      if (VipUtils.a(localObject4[0]))
      {
        localObject4 = this.mContext;
        ImageView localImageView = this.mVipExtIcon;
        j = localCard.nameplateExtId;
        VipUtils.VipIconUtils.a((Context)localObject4, localImageView, j, 2);
        this.mVipExtIcon.setOnClickListener(new VipUtils.OnVipClubPendantClickListener());
      }
    }
    else
    {
      localObject2 = null;
      i = 0;
    }
    if (!bool7)
    {
      if ((l != 1L) && (l != 2L))
      {
        if ((l != 3L) && (l != 4L))
        {
          if (l != 6L) {
            break label1481;
          }
          if (bool2)
          {
            j = VipUtils.a((AppRuntime)localObject3, (String)localObject1, false);
            if (j >> 8 == 3)
            {
              if ((j & 0xF) == 1)
              {
                i = VipUtils.a((AppRuntime)localObject3, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
                localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130848951;
              }
              else
              {
                i = VipUtils.a((AppRuntime)localObject3, (String)localObject1, EVIPSPEC.E_SP_BIGCLUB);
                localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iBigClubVipLevel, localCard.lBigClubTemplateId);
                i = 2130848949;
              }
              VipUtils.VipIconUtils.a(this.mContext, this.mVipExtIcon, localCard.nameplateExtId, 2);
              j = 1;
              break label1488;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("occur error: curMulType=");
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append(" but bBigClubVipOpen userStatus=");
            ((StringBuilder)localObject1).append(j);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("occur error: curMulType=");
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append(" but bBigClubVipOpen is false");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          if (bool3)
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
            j = 1;
            localObject3 = null;
            i = 2130848949;
            break label1491;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("occur error: curMulType=");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(" but bSuperVipOpen is false");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        if (paramBoolean)
        {
          i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
          localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
          if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("vip member icon show :");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("ProfileQQLevelView", 1, ((StringBuilder)localObject2).toString());
          }
          j = 1;
          localObject3 = null;
          i = 2130848950;
          break label1491;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("occur error: curMulType=");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(" but bQQVipOpen is false");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      j = 0;
      localObject3 = localObject1;
      localObject1 = localObject2;
      break label1491;
    }
    label1481:
    int j = 0;
    Object localObject1 = localObject2;
    label1488:
    localObject3 = null;
    label1491:
    if ((!bool7) && (j == 0))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        QLog.e("ProfileQQLevelView", 1, (String)localObject3);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("it have not handle curMulType=");
        ((StringBuilder)localObject2).append(l);
        QLog.e("ProfileQQLevelView", 1, ((StringBuilder)localObject2).toString());
      }
      if (bool3)
      {
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_SUPERVIP);
        localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iSuperVipLevel, localCard.lSuperVipTemplateId);
        i = 2130848949;
      }
      else if (paramBoolean)
      {
        i = VipUtils.a(BaseApplicationImpl.getApplication().getRuntime(), localCard.uin, EVIPSPEC.E_SP_QQVIP);
        localObject1 = VipUtils.VipIconUtils.a((i & 0xF) << 8 | i >> 8, localCard.iQQVipLevel, 0L);
        i = 2130848950;
      }
    }
    if ((localObject1 != null) && (i != 0))
    {
      VipUtils.a(getResources(), this.mVipIcon, (String)localObject1, getResources().getDrawable(i));
      this.mVipIcon.setVisibility(0);
      this.mVipIcon.setContentDescription(HardCodeUtil.a(2131913733));
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
    localObject1 = new IGameCardManager.GameCardInfo(localCard.uin, localCard.namePlateOfKingGameId, localCard.namePlateOfKingDan, localCard.namePlateOfKingDanDisplatSwitch, localCard.gameCardId);
    ((IGameCardManager.GameCardInfo)localObject1).a = "ziliaoka";
    VipGrayConfigHelper.a().a(this.mKingInfo, bool3, localCard.namePlateOfKingLoginTime, (IGameCardManager.GameCardInfo)localObject1);
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
    if (!bool6) {
      this.mDarenIcon.setBackgroundResource(2130853416);
    } else {
      this.mDarenIcon.setBackgroundResource(2130853417);
    }
    setContentDescription(this.mSB.toString());
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("showQQLevelInfo bQQVipOpen=%s, bSuperVipOpen=%s, bEnterprise=%s, bPrettyNumber=%s, bShowAccountInfo=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool4) }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountinfo.view.ProfileQQLevelView
 * JD-Core Version:    0.7.0.1
 */