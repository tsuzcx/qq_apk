package com.tencent.mobileqq.profilecard.vas.component.accountinfo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VasProfileAccountInfoComponent
  extends AbsQQProfileContentComponent
  implements View.OnClickListener
{
  private static final String TAG = "VasProfileAccountInfoComponent";
  private float mDensity;
  private float mItemInfoWidth;
  private float mLeftSpace;
  private float mRightSpace;
  private float mScreenWidth;
  
  public VasProfileAccountInfoComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private ViewGroup addAccountBaseInfoItem(ViewGroup paramViewGroup, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    View localView = null;
    Object localObject = localView;
    if (paramViewGroup != null)
    {
      localObject = localView;
      if (paramInt1 > 0)
      {
        localObject = localView;
        if (!TextUtils.isEmpty(paramCharSequence))
        {
          localObject = (ViewGroup)this.mActivity.getLayoutInflater().inflate(2131627695, null);
          localView = ((ViewGroup)localObject).findViewById(2131435219);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131435692);
          localView.setBackgroundResource(paramInt1);
          if ((paramCharSequence instanceof String)) {
            localTextView.setText(((String)paramCharSequence).trim());
          } else {
            localTextView.setText(paramCharSequence);
          }
          paramViewGroup.addView((View)localObject);
          if (paramInt2 == 1) {
            LongClickCopyAction.attachCopyAction(localTextView);
          }
          updateItemTheme(null, null, localTextView, null);
        }
      }
    }
    return localObject;
  }
  
  private ViewGroup addAccountPrettyItem(ViewGroup paramViewGroup, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if (!isShowAccountPrettyItem(paramViewGroup, paramInt1, paramCharSequence)) {
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)this.mActivity.getLayoutInflater().inflate(2131627698, null);
    Object localObject = localViewGroup.findViewById(2131435219);
    TextView localTextView = (TextView)localViewGroup.findViewById(2131435692);
    ((View)localObject).setBackgroundResource(paramInt1);
    if (checkProfile((ProfileCardInfo)this.mData)) {
      paramInt1 = ((ProfileCardInfo)this.mData).card.lhLevel;
    } else {
      paramInt1 = -1;
    }
    if (checkProfile((ProfileCardInfo)this.mData)) {
      localObject = ((ProfileCardInfo)this.mData).card.uin;
    } else {
      localObject = "";
    }
    if ((paramCharSequence instanceof String)) {
      paramCharSequence = PrettyAccountUtil.a(PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), paramInt1, ((String)paramCharSequence).trim(), (String)localObject);
    } else {
      paramCharSequence = PrettyAccountUtil.a(PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), paramInt1, paramCharSequence, (String)localObject);
    }
    localTextView.setText(paramCharSequence);
    PrettyAccountUtil.a(localTextView, PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), paramInt1);
    paramViewGroup.addView(localViewGroup);
    if (paramInt2 == 1) {
      LongClickCopyAction.attachCopyAction(localTextView);
    }
    if (PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card) != 1) {
      updateItemTheme(null, null, localTextView, null);
    }
    paramViewGroup = getQidView(localViewGroup);
    if (!paramViewGroup.a((ProfileCardInfo)this.mData)) {
      updateItemTheme(null, null, paramViewGroup, null);
    }
    paramViewGroup = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
    if (paramViewGroup.isDiy()) {
      paramViewGroup.updateAccountInfoForDeepDiy((View)this.mViewContainer);
    }
    return localViewGroup;
  }
  
  private boolean clearViewContainer()
  {
    if (this.mViewContainer != null)
    {
      this.mViewContainer = null;
      return true;
    }
    return false;
  }
  
  private String combineNickNameAndNumber(TextView paramTextView1, TextView paramTextView2, Card paramCard)
  {
    if ((paramTextView1 != null) && (paramTextView2 != null) && (!TextUtils.isEmpty(paramCard.uin)) && (!TextUtils.isEmpty(paramCard.strNick)))
    {
      Object localObject = paramTextView1.getPaint();
      paramTextView1 = (TextView)localObject;
      if (localObject == null)
      {
        paramTextView1 = new TextPaint(1);
        paramTextView1.density = this.mDensity;
      }
      localObject = paramTextView2.getPaint();
      paramTextView2 = (TextView)localObject;
      if (localObject == null)
      {
        paramTextView2 = new TextPaint(1);
        paramTextView2.density = this.mDensity;
      }
      float f2 = paramTextView1.measureText("...");
      float f3 = this.mDensity;
      float f4 = paramTextView1.measureText(String.format("(%s)", new Object[] { paramCard.uin }));
      if (TextUtils.isEmpty(paramCard.qid)) {
        localObject = "";
      } else {
        localObject = paramCard.qid;
      }
      float f5 = paramTextView2.measureText((String)localObject);
      float f6 = this.mItemInfoWidth;
      float f1;
      if (isDIYTemplateProfile()) {
        f1 = this.mDensity * 40.0F;
      } else {
        f1 = 0.0F;
      }
      paramTextView2 = TextUtils.ellipsize(paramCard.strNick, paramTextView1, f6 - f4 - (f2 + f3 * 5.0F) - f5 - f1, TextUtils.TruncateAt.END);
      paramTextView1 = paramTextView2;
      if (TextUtils.isEmpty(paramTextView2)) {
        paramTextView1 = "...";
      }
      return String.format("%s(%s)", new Object[] { paramTextView1, paramCard.uin });
    }
    return null;
  }
  
  private View getAccountBaseInfoView()
  {
    View localView2 = (View)this.mViewContainer;
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = this.mActivity.getLayoutInflater().inflate(2131627694, null);
    }
    if (localView1 != null) {
      this.mViewContainer = localView1;
    }
    return localView1;
  }
  
  private QidCoolTextView getQidView(ViewGroup paramViewGroup)
  {
    paramViewGroup = (QidCoolTextView)paramViewGroup.findViewById(2131442038);
    paramViewGroup.a(this.mQQAppInterface, (ProfileCardInfo)this.mData);
    paramViewGroup.setTag(new DataTag(105, null));
    paramViewGroup.setOnClickListener(this);
    return paramViewGroup;
  }
  
  private void init(Context paramContext)
  {
    paramContext = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = paramContext.getDisplayMetrics();
    this.mDensity = localDisplayMetrics.density;
    this.mScreenWidth = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    this.mLeftSpace = (paramContext.getDimensionPixelSize(2131297677) + paramContext.getDimensionPixelSize(2131298261) + paramContext.getDimensionPixelSize(2131298262));
    float f = this.mDensity;
    int i = paramContext.getDimensionPixelSize(2131298258);
    int j = paramContext.getDimensionPixelSize(2131298259);
    this.mRightSpace = (f * 7.0F + i + j);
    this.mItemInfoWidth = (this.mScreenWidth - this.mLeftSpace - this.mRightSpace);
  }
  
  private boolean isDIYTemplateProfile()
  {
    if (this.mData != null) {
      return ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy();
    }
    return false;
  }
  
  private boolean isDefaultProfile()
  {
    Object localObject = this.mData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((ProfileCardInfo)this.mData).curUseStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isQVipV5TemplateProfile()
  {
    Object localObject = this.mData;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((ProfileCardInfo)this.mData).curUseStyleId == ProfileCardTemplate.PROFILE_CARD_STYLE_NEW_V800) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean isShowAccountInfo(Card paramCard)
  {
    boolean bool;
    if ((paramCard != null) && (ProfilePAUtils.isPaTypeShowAccount(((ProfileCardInfo)this.mData).allInOne))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((isDefaultProfile()) || (isQVipV5TemplateProfile())) {
      bool = false;
    }
    return bool;
  }
  
  private boolean isShowAccountPrettyItem(ViewGroup paramViewGroup, int paramInt, CharSequence paramCharSequence)
  {
    return (paramViewGroup != null) && (paramInt > 0) && (!TextUtils.isEmpty(paramCharSequence));
  }
  
  private boolean isValidForAccountBaseInfoThirdLine(TroopManager paramTroopManager)
  {
    return (!paramTroopManager.Z(((ProfileCardInfo)this.mData).troopUin)) && (!isDIYTemplateProfile());
  }
  
  private boolean makeOrRefreshAccountBaseInfoView(Card paramCard, boolean paramBoolean)
  {
    boolean bool1 = isShowAccountInfo(paramCard);
    boolean bool2 = QLog.isColorLevel();
    paramBoolean = false;
    if (bool2) {
      QLog.d("VasProfileAccountInfoComponent", 2, String.format("makeOrRefreshAccountBaseInfoView bShowAccountInfo=%s", new Object[] { Boolean.valueOf(bool1) }));
    }
    if (!bool1) {
      return clearViewContainer();
    }
    View localView = getAccountBaseInfoView();
    Object localObject = (ViewGroup)localView;
    ViewGroup localViewGroup1 = (ViewGroup)((ViewGroup)localObject).findViewById(2131427428);
    ViewGroup localViewGroup2 = (ViewGroup)((ViewGroup)localObject).findViewById(2131427431);
    localViewGroup1.removeAllViews();
    if ((!ProfilePAUtils.isFromWholePeopleVote(((ProfileCardInfo)this.mData).allInOne)) && (!ProfilePAUtils.isFromExtendFriend(((ProfileCardInfo)this.mData).allInOne))) {
      localObject = " ";
    } else {
      localObject = null;
    }
    refreshAccountBaseInfoFirstLine(paramCard, localViewGroup1, (String)localObject);
    refreshAccountBaseInfoSecondLine(localViewGroup1);
    refreshAccountBaseInfoThirdLine(paramCard, localViewGroup1);
    refreshAccountBaseInfoLastLine(paramCard, localViewGroup2);
    if (localView != null) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private void refreshAccountBaseInfoFirstLine(Card paramCard, ViewGroup paramViewGroup, String paramString)
  {
    int j = 0;
    paramViewGroup = addAccountPrettyItem(paramViewGroup, 2130847425, paramString, 0);
    if (paramViewGroup == null) {
      return;
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131435692);
    paramViewGroup = (QidCoolTextView)paramViewGroup.findViewById(2131442038);
    paramString = null;
    if (localTextView == null) {
      return;
    }
    if (((ProfileCardInfo)this.mData).isTroopMemberCard)
    {
      updateNickForTroopMemberCard(paramCard, localTextView, paramViewGroup);
      return;
    }
    int i = j;
    if (((ProfileCardInfo)this.mData).nameArray != null)
    {
      i = j;
      if (!TextUtils.isEmpty(((ProfileCardInfo)this.mData).nameArray[5]))
      {
        i = j;
        if (!TextUtils.equals(((ProfileCardInfo)this.mData).nameArray[5], paramCard.strNick)) {
          i = 1;
        }
      }
    }
    if ((TextUtils.isEmpty(paramCard.strReMark)) && (i == 0))
    {
      paramViewGroup = paramCard.uin;
    }
    else
    {
      String str2 = combineNickNameAndNumber(localTextView, paramViewGroup, paramCard);
      String str1 = paramCard.strNick;
      paramString = str1;
      paramViewGroup = str2;
      if (TextUtils.isEmpty(str2))
      {
        paramViewGroup = paramCard.uin;
        paramString = str1;
      }
    }
    localTextView.setText(PrettyAccountUtil.a(PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), ((ProfileCardInfo)this.mData).card.lhLevel, paramViewGroup, ((ProfileCardInfo)this.mData).card.uin));
    PrettyAccountUtil.a(localTextView, PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), ((ProfileCardInfo)this.mData).card.lhLevel);
    ProfileCardUtil.a(localTextView, paramCard.uin, paramString);
  }
  
  private void refreshAccountBaseInfoLastLine(Card paramCard, ViewGroup paramViewGroup)
  {
    paramViewGroup.setTag(new DataTag(66, paramCard.uin));
    paramViewGroup.setOnClickListener(this);
    updateItemTheme(null, (TextView)paramViewGroup.findViewById(2131427432), (ImageView)paramViewGroup.findViewById(2131428774), null);
  }
  
  private void refreshAccountBaseInfoSecondLine(ViewGroup paramViewGroup)
  {
    if (isDIYTemplateProfile()) {
      addAccountBaseInfoItem(paramViewGroup, 2130847436, ProfileCardUtil.b(this.mActivity, (ProfileCardInfo)this.mData), 1);
    }
  }
  
  private void refreshAccountBaseInfoThirdLine(Card paramCard, ViewGroup paramViewGroup)
  {
    if (!isValidForAccountBaseInfoThirdLine((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER))) {
      return;
    }
    int i = 0;
    for (int j = paramViewGroup.getChildCount(); (j < 4) && (i < 3); j = paramViewGroup.getChildCount())
    {
      if (i != 0)
      {
        String str;
        if (i != 1)
        {
          if (i == 2)
          {
            str = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getHometownWithPrivacy((ProfileCardInfo)this.mData);
            if (!TextUtils.isEmpty(str)) {
              addAccountBaseInfoItem(paramViewGroup, 2130847435, str, 1);
            }
          }
        }
        else
        {
          str = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getCompanyWithPrivacy((ProfileCardInfo)this.mData);
          if (!TextUtils.isEmpty(str)) {
            refreshCompanyInfo(paramViewGroup, str);
          }
        }
      }
      else
      {
        refreshSchoolInfo(paramCard, paramViewGroup);
      }
      i += 1;
    }
  }
  
  private void refreshCompanyInfo(ViewGroup paramViewGroup, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    paramString = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfessionTagWithPrivacy((ProfileCardInfo)this.mData);
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, com.tencent.mobileqq.util.NearbyProfileUtil.e[14])))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(paramString);
    }
    addAccountBaseInfoItem(paramViewGroup, 2130847440, localStringBuilder.toString(), 1);
  }
  
  private void refreshSchoolInfo(Card paramCard, ViewGroup paramViewGroup)
  {
    String str = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getSchoolWithPrivacy((ProfileCardInfo)this.mData);
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = str;
      if (paramCard.schoolVerifiedFlag) {
        localObject = ProfileCardUtil.a(str, true, 2130846620, 2131298961, 2131298960, this.mActivity, this.mQQAppInterface);
      }
      addAccountBaseInfoItem(paramViewGroup, 2130847445, (CharSequence)localObject, 1);
    }
  }
  
  private void updateNickForTroopMemberCard(Card paramCard, TextView paramTextView, QidCoolTextView paramQidCoolTextView)
  {
    TroopManager localTroopManager = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = localTroopManager.g(((ProfileCardInfo)this.mData).troopUin, paramCard.uin);
    if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(paramCard.strReMark))) {
      localObject1 = paramCard.strNick;
    } else if (TextUtils.isEmpty(paramCard.strReMark)) {
      localObject1 = paramCard.strNick;
    } else {
      localObject1 = paramCard.strReMark;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = ContactUtils.a(this.mQQAppInterface, paramCard.uin, false);
    }
    if (localTroopManager.Z(((ProfileCardInfo)this.mData).troopUin)) {
      paramQidCoolTextView = (QidCoolTextView)localObject2;
    } else {
      paramQidCoolTextView = combineNickNameAndNumber(paramTextView, paramQidCoolTextView, paramCard);
    }
    paramTextView.setText(PrettyAccountUtil.a(PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), ((ProfileCardInfo)this.mData).card.lhLevel, paramQidCoolTextView, ((ProfileCardInfo)this.mData).card.uin));
    PrettyAccountUtil.a(paramTextView, PrettyAccountUtil.a(((ProfileCardInfo)this.mData).card), ((ProfileCardInfo)this.mData).card.lhLevel);
    ProfileCardUtil.a(paramTextView, paramCard.uin, (String)localObject2);
  }
  
  public boolean checkProfile(ProfileCardInfo paramProfileCardInfo)
  {
    return (paramProfileCardInfo != null) && (paramProfileCardInfo.card != null);
  }
  
  public String getComponentName()
  {
    return "VasProfileAccountInfoComponent";
  }
  
  public int getComponentType()
  {
    return 1032;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_account_info_vas";
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof DataTag))
    {
      int i = ((DataTag)localObject).a;
      if (i != 66)
      {
        if (i == 105) {
          VipQidHelper.a(this.mActivity, (ProfileCardInfo)this.mData);
        }
      }
      else
      {
        ProfileCardUtil.a((ProfileCardInfo)this.mData, this.mQQAppInterface, this.mActivity);
        if ((((ProfileCardInfo)this.mData).allInOne != null) && (((ProfileCardInfo)this.mData).allInOne.pa == 0)) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(this.mApp, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    init(this.mActivity);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshAccountBaseInfoView(paramProfileCardInfo.card, paramProfileCardInfo.isNetRet) | bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.accountinfo.VasProfileAccountInfoComponent
 * JD-Core Version:    0.7.0.1
 */