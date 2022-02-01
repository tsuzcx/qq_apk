package com.tencent.mobileqq.profilecard.vas.view;

import SummaryCardTaf.summaryCardWzryInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig.WZRYHonorItem;
import com.tencent.mobileqq.profile.VipWZRYTemplateConfig.WZRYResourceItem;
import com.tencent.mobileqq.profile.VipWZRYTemplateHelper;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class VasProfileWZRYView
  extends AbsProfileHeaderView
{
  private static final String NUMBER_PLACE_HOLDER = "[num]";
  private static final int WZRY_HEADER_HEIGHT = 160;
  private ImageView mAddIcon;
  private View mBlankView;
  private HorizontalScrollView mGameInfoLayout;
  private ShimmerLinearLayout mGameInfoShimmerLayout;
  private LayoutInflater mInflater = null;
  private ImageView mLogo;
  private ImageView mLogoBg;
  private float mOldScreenHeight = 0.0F;
  private int mOriginalBlankViewHeight;
  
  public VasProfileWZRYView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity, paramProfileCardInfo);
  }
  
  private void addHonorView(ProfileCardInfo paramProfileCardInfo, List<summaryCardWzryInfo> paramList, LinearLayout.LayoutParams paramLayoutParams, VipWZRYTemplateConfig paramVipWZRYTemplateConfig, int paramInt1, int paramInt2, ColorStateList paramColorStateList1, ColorStateList paramColorStateList2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (summaryCardWzryInfo)paramList.next();
      Object localObject1;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("honor data: id=");
        ((StringBuilder)localObject3).append(((summaryCardWzryInfo)localObject2).honorId);
        ((StringBuilder)localObject3).append(", record=");
        ((StringBuilder)localObject3).append(((summaryCardWzryInfo)localObject2).strRecord);
        QLog.d((String)localObject1, 4, ((StringBuilder)localObject3).toString());
      }
      if (!TextUtils.isEmpty(((summaryCardWzryInfo)localObject2).strRecord)) {
        localObject1 = ((summaryCardWzryInfo)localObject2).strRecord.split("_");
      } else {
        localObject1 = null;
      }
      VipWZRYTemplateConfig.WZRYHonorItem localWZRYHonorItem = (VipWZRYTemplateConfig.WZRYHonorItem)paramVipWZRYTemplateConfig.b.get(((summaryCardWzryInfo)localObject2).honorId);
      if (localWZRYHonorItem != null)
      {
        View localView = this.mInflater.inflate(2131628464, null);
        ImageView localImageView = (ImageView)localView.findViewById(2131450340);
        TextView localTextView1 = (TextView)localView.findViewById(2131450342);
        TextView localTextView2 = (TextView)localView.findViewById(2131450341);
        if (ProfileCardTemplate.wzryTTFChn != null)
        {
          localTextView1.setTypeface(ProfileCardTemplate.wzryTTFChn);
          localTextView2.setTypeface(ProfileCardTemplate.wzryTTFChn);
        }
        int i;
        if (localWZRYHonorItem.d == 2) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          localObject2 = localWZRYHonorItem.c;
        } else {
          localObject2 = localWZRYHonorItem.b;
        }
        if (i != 0) {
          localObject3 = localWZRYHonorItem.b;
        } else {
          localObject3 = localWZRYHonorItem.c;
        }
        localTextView1.setText(getSpannableString((String)localObject2, (String[])localObject1, calcTopNumTextSize(localTextView1, paramInt2, (String)localObject2, (String[])localObject1), 0.0F, paramColorStateList2));
        localTextView2.setText(getSpannableString((String)localObject3, (String[])localObject1, paramInt1, localTextView2.getTextSize(), paramColorStateList1));
        if ((localWZRYHonorItem.e != null) && (!TextUtils.isEmpty(localWZRYHonorItem.e.a)))
        {
          localImageView.setVisibility(0);
          localTextView1.setVisibility(8);
          localObject2 = localWZRYHonorItem.e.a;
          localObject1 = localObject2;
          if (((String)localObject2).contains("/")) {
            localObject1 = ((String)localObject2).substring(((String)localObject2).lastIndexOf("/"));
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(VipWZRYTemplateHelper.a());
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
          if (paramProfileCardInfo.currentTemplate != null) {
            localImageView.setImageDrawable(this.templateUtils.getTemplateDrawable(paramProfileCardInfo.currentTemplate, true, true, (String)localObject1));
          }
        }
        else
        {
          localImageView.setVisibility(8);
          localTextView1.setVisibility(0);
        }
        this.mGameInfoShimmerLayout.addView(localView, paramLayoutParams);
      }
    }
  }
  
  private View initMainView()
  {
    this.mInflater = LayoutInflater.from(getContext());
    return this.mInflater.inflate(2131628463, this, true);
  }
  
  private void prepareForEnterAnimation()
  {
    int i = getResources().getDimensionPixelSize(2131297461);
    int j = ProfileCardUtil.a(getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    localLayoutParams.height = ((int)this.mScreenHeight - ProfileCardUtil.b(this.mActivity, 160) - i - j);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localLayoutParams.height += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rl.height: ");
      localStringBuilder.append(localLayoutParams.height);
      QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
    }
    this.mOriginalBlankViewHeight = localLayoutParams.height;
    this.mBlankView.setLayoutParams(localLayoutParams);
    this.mBlankView.setFocusable(true);
    this.mBlankView.setFocusableInTouchMode(true);
  }
  
  private void updateAvatarArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)paramView.findViewById(2131450333);
    localAvatarLayout.setVisibility(0);
    DataTag localDataTag = new DataTag(1, null);
    localAvatarLayout.setTag(localDataTag);
    localAvatarLayout.setOnClickListener(this.mOnClickListener);
    String str;
    if (paramProfileCardInfo.allInOne.pa == 0) {
      str = getContext().getString(2131888143);
    } else {
      str = getContext().getString(2131888142);
    }
    localAvatarLayout.setContentDescription(str);
    localAvatarLayout.a(0, localAvatarLayout.findViewById(2131429335), false);
    this.mHeaderChildMap.put("map_key_face", localAvatarLayout);
    super.updateAvatar(paramProfileCardInfo.allInOne);
    paramView = (ImageView)paramView.findViewById(2131450331);
    paramView.setVisibility(4);
    paramView.setOnClickListener(this.mOnClickListener);
    paramView.setTag(localDataTag);
    this.mHeaderChildMap.put("map_key_avatar_pendant", paramView);
    super.updateAvatarPendantImage(paramProfileCardInfo, true);
  }
  
  private void updateBaseInfoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (TextView)paramView.findViewById(2131450337);
    this.mHeaderChildMap.put("map_key_sex_age_area", paramView);
    super.updateSexAgeArea(paramProfileCardInfo);
  }
  
  private void updateHeadArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    paramView = (ProfileNameView)paramView.findViewById(2131450335);
    paramView.setVisibility(0);
    paramView.setClickable(true);
    paramView.setClickListener(this.mOnClickListener);
    this.mHeaderChildMap.put("map_key_profile_nick_name", paramView);
    super.updateHead(paramProfileCardInfo);
  }
  
  private void updateLikeArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    HeartLayout localHeartLayout = (HeartLayout)paramView.findViewById(2131450329);
    localHeartLayout.setEnabled(false);
    paramView = (VoteView)paramView.findViewById(2131450344);
    paramView.setHeartLayout(this.mApp, localHeartLayout);
    this.mHeaderChildMap.put("map_key_like", paramView);
    super.updateLike(paramProfileCardInfo);
  }
  
  private void updateLogoArea(ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    this.mLogo = ((ImageView)paramView.findViewById(2131450338));
    this.templateUtils.updateViewAttr(this.mLogo, "apngDrawable", paramProfileCardInfo.currentTemplate, "wzryLogo");
    ApngImage.playByTag(7);
    this.mLogoBg = ((ImageView)paramView.findViewById(2131450339));
    this.templateUtils.updateViewAttr(this.mLogoBg, "background", paramProfileCardInfo.currentTemplate, "wzryLogoBg");
  }
  
  int calcTopNumTextSize(TextView paramTextView, int paramInt, String paramString, String[] paramArrayOfString)
  {
    TextPaint localTextPaint = new TextPaint(paramTextView.getPaint());
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      String str = paramString;
      if (paramString.endsWith("[num]"))
      {
        paramTextView = new StringBuilder();
        paramTextView.append(paramString);
        paramTextView.append("\r\n");
        str = paramTextView.toString();
      }
      int j = str.split("\\[num\\]").length - 1;
      int i = j;
      if (j > paramArrayOfString.length) {
        i = paramArrayOfString.length;
      }
      if (i > 0)
      {
        paramTextView = "";
        int k = 0;
        j = 0;
        while (k < i)
        {
          j += paramArrayOfString[k].length();
          paramString = new StringBuilder();
          paramString.append(paramTextView);
          paramString.append(paramArrayOfString[k]);
          paramTextView = paramString.toString();
          k += 1;
        }
        if (j > 0)
        {
          paramString = str.replace("[num]", "");
          i = 0;
          while (i < j - 1)
          {
            paramArrayOfString = new StringBuilder();
            paramArrayOfString.append(paramString);
            paramArrayOfString.append(" ");
            paramString = paramArrayOfString.toString();
            i += 1;
          }
          float f2 = paramInt - localTextPaint.measureText(paramString);
          for (float f1 = f2; f1 > 0.0F; f1 -= 1.0F)
          {
            localTextPaint.setTextSize(f1);
            if (localTextPaint.measureText(paramTextView) < f2)
            {
              paramInt /= 2;
              if (f1 > paramInt) {
                return paramInt;
              }
              return (int)f1;
            }
          }
        }
      }
    }
    return 0;
  }
  
  void generateLogoAnimation()
  {
    this.mUIHandler.postDelayed(new VasProfileWZRYView.2(this), 1000L);
  }
  
  public SpannableStringBuilder getSpannableString(String paramString, String[] paramArrayOfString, int paramInt, float paramFloat, ColorStateList paramColorStateList)
  {
    String str = paramString;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (TextUtils.isEmpty(paramString)) {
      return localSpannableStringBuilder;
    }
    if (str.contains("[num]"))
    {
      if (str.equals("[num]"))
      {
        paramString = new StringBuilder();
        paramString.append(str);
        paramString.append(" ");
        paramString = paramString.toString();
      }
      else
      {
        paramString = str;
        if (str.endsWith("[num]"))
        {
          paramString = new StringBuilder();
          paramString.append(str);
          paramString.append("\r\n");
          paramString = paramString.toString();
        }
      }
      paramString = paramString.split("\\[num\\]");
      int i = 0;
      while (i < paramString.length)
      {
        str = paramString[i];
        if ((i != 0) && (!"\r\n".equals(str))) {
          localSpannableStringBuilder.append(" ");
        }
        if (!"\r\n".equals(str)) {
          localSpannableStringBuilder.append(str);
        }
        if (i < paramString.length - 1)
        {
          int k = localSpannableStringBuilder.length();
          int j;
          if ((paramArrayOfString != null) && (i < paramArrayOfString.length))
          {
            j = paramArrayOfString[i].length() + k;
            localSpannableStringBuilder.append(paramArrayOfString[i]);
          }
          else
          {
            j = k + 5;
            localSpannableStringBuilder.append("[num]");
          }
          if (ProfileCardTemplate.wzryTTFNum != null) {
            localSpannableStringBuilder.setSpan(new VasProfileWZRYView.CustomTypefaceSpan("", ProfileCardTemplate.wzryTTFNum), k, j, 17);
          }
          localSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 3, paramInt, paramColorStateList, null), k, j, 17);
          localSpannableStringBuilder.setSpan(new VasProfileWZRYView.VerticalCenterTextSpan(paramInt, -2.0F), k, j, 17);
        }
        i += 1;
      }
    }
    localSpannableStringBuilder.append(str);
    return localSpannableStringBuilder;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    float f = this.mScreenHeight;
    if (this.mOldScreenHeight != this.mScreenHeight)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
      paramConfiguration.height = ((int)(paramConfiguration.height + (this.mScreenHeight - this.mOldScreenHeight)));
      this.mBlankView.setLayoutParams(paramConfiguration);
      this.mOriginalBlankViewHeight = ((int)(this.mOriginalBlankViewHeight + (this.mScreenHeight - this.mOldScreenHeight)));
      this.mOldScreenHeight = this.mScreenHeight;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i(TAG, 1, "VipProfileWZRYView.onDestroy");
    ShimmerLinearLayout localShimmerLinearLayout = this.mGameInfoShimmerLayout;
    if (localShimmerLinearLayout != null) {
      localShimmerLinearLayout.c();
    }
  }
  
  public void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    this.mOldScreenHeight = this.mScreenHeight;
    Object localObject = initMainView();
    updateLogoArea(paramProfileCardInfo, (View)localObject);
    this.mBlankView = ((View)localObject).findViewById(2131450332);
    this.mGameInfoShimmerLayout = ((ShimmerLinearLayout)((View)localObject).findViewById(2131450327));
    this.mAddIcon = ((ImageView)((View)localObject).findViewById(2131450326));
    this.mGameInfoLayout = ((HorizontalScrollView)((View)localObject).findViewById(2131450328));
    this.templateUtils.updateViewAttr(this.mGameInfoLayout, "background", paramProfileCardInfo.currentTemplate, "wzryGameInfoBackground");
    prepareForEnterAnimation();
    updateAvatarArea(paramProfileCardInfo, (View)localObject);
    updateHeadArea(paramProfileCardInfo, (View)localObject);
    updateBaseInfoArea(paramProfileCardInfo, (View)localObject);
    updateLikeArea(paramProfileCardInfo, (View)localObject);
    updateGameInfo(paramProfileCardInfo);
    super.onInit(paramProfileCardInfo);
    super.updateJueban(paramProfileCardInfo);
    generateLogoAnimation();
    if (this.mApp.getCurrentAccountUin().equals(paramProfileCardInfo.allInOne.uin)) {
      localObject = "PV_owner";
    } else {
      localObject = "PV_visitor";
    }
    VasWebviewUtil.a("", "card_gameking", (String)localObject, "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(paramProfileCardInfo.card.lCurrentBgId), String.valueOf(paramProfileCardInfo.card.lCurrentStyleId));
  }
  
  public void onPause()
  {
    super.onPause();
    this.mGameInfoShimmerLayout.b();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(7);
  }
  
  public void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.updateLike(paramProfileCardInfo);
    super.updateHead(paramProfileCardInfo);
    super.updateSexAgeArea(paramProfileCardInfo);
    super.updateAvatarPendantImage(paramProfileCardInfo, false);
    updateGameInfo(paramProfileCardInfo);
  }
  
  public void updateGameInfo(ProfileCardInfo paramProfileCardInfo)
  {
    this.mGameInfoShimmerLayout.b();
    this.mGameInfoShimmerLayout.removeAllViews();
    ArrayList localArrayList = paramProfileCardInfo.card.getWzryHonorInfo();
    Object localObject = (RelativeLayout.LayoutParams)this.mBlankView.getLayoutParams();
    if (localArrayList.isEmpty())
    {
      this.mGameInfoLayout.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).height = (this.mOriginalBlankViewHeight - ProfileCardUtil.b(this.mActivity, 67));
      return;
    }
    this.mGameInfoLayout.setVisibility(0);
    ((RelativeLayout.LayoutParams)localObject).height = (this.mOriginalBlankViewHeight - ProfileCardUtil.b(this.mActivity, 132));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(getContext(), 5.0F), 0);
    VipWZRYTemplateConfig localVipWZRYTemplateConfig = VipWZRYTemplateConfig.a;
    int i = getResources().getDimensionPixelSize(2131300116);
    int j = getResources().getDimensionPixelSize(2131300118);
    ColorStateList localColorStateList1 = getResources().getColorStateList(2131168535);
    ColorStateList localColorStateList2 = getResources().getColorStateList(2131168537);
    if (localVipWZRYTemplateConfig != null) {
      addHonorView(paramProfileCardInfo, localArrayList, (LinearLayout.LayoutParams)localObject, localVipWZRYTemplateConfig, i, j, localColorStateList1, localColorStateList2);
    }
    if ((paramProfileCardInfo.allInOne.pa == 0) || (paramProfileCardInfo.allInOne.uin.equals(this.mApp.getCurrentAccountUin())))
    {
      this.mAddIcon.setVisibility(0);
      this.templateUtils.updateViewAttr(this.mAddIcon, "background", paramProfileCardInfo.currentTemplate, "addIcon");
      this.mAddIcon.setOnClickListener(new VasProfileWZRYView.1(this, paramProfileCardInfo));
    }
    if (this.mGameInfoShimmerLayout.a == null) {
      this.templateUtils.updateViewAttr(this.mGameInfoShimmerLayout, "shimmer_mask", paramProfileCardInfo.currentTemplate, "wzryShimmer");
    }
    this.mGameInfoShimmerLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileWZRYView
 * JD-Core Version:    0.7.0.1
 */