package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.SigTopicConfig;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.TopicInfo;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.CircleBoarderImageView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.UinItem;

public class ProfileContentSignComponent
  extends AbsProfileContentComponent
  implements View.OnClickListener, DecodeTaskCompletionListener, ITopic.OnTopicClickListener, AbsListView.OnScrollListener
{
  private static final String TAG = "ProfileContentSignComponent";
  private String mActionText;
  private Map<String, CircleBoarderImageView> mCommonTopicFriendAvatar;
  private IFaceDecoder mDecoder;
  private int mDrawableSize;
  private FriendListObserver mFriendListObserver = new ProfileContentSignComponent.1(this);
  private boolean mFromExtendFriend;
  private TextView mInfo;
  private String mPlainText;
  private int mPos;
  private ProfileContentSignComponent.RichStatusIconListener mStatusIconListener;
  private String mTopic;
  
  public ProfileContentSignComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean makeOrRefreshSign(Card paramCard, boolean paramBoolean)
  {
    boolean bool;
    Object localObject1;
    int i;
    int j;
    label72:
    Object localObject2;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      paramBoolean = true;
      bool = ProfileActivity.AllInOne.g(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      localObject1 = this.mActivity.getResources();
      if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
        break label234;
      }
      i = ((Resources)localObject1).getColor(2131167033);
      j = ((Resources)localObject1).getColor(2131167033);
      localObject2 = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramCard != null) {
          localObject1 = RichStatusUtils.Companion.getRichStatus(paramCard);
        }
      }
      if (localObject1 == null) {
        break label506;
      }
    }
    label234:
    label504:
    label506:
    for (paramCard = new SpannableString(((RichStatus)localObject1).toSpannableStringWithTopic(null, i, j, this));; paramCard = null)
    {
      localObject2 = paramCard;
      if (paramCard == null) {
        localObject2 = new SpannableString("");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileContentSignComponent", 2, String.format("makeOrRefreshSign isHost=%s isPaTypeHasUin=%s length=%s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(((SpannableString)localObject2).length()) }));
      }
      if ((!paramBoolean) && ((!bool) || (((SpannableString)localObject2).length() == 0)))
      {
        if (this.mViewContainer == null) {
          break label504;
        }
        this.mViewContainer = null;
        return true;
        paramBoolean = false;
        break;
        j = ((Resources)localObject1).getColor(2131165357);
        i = -8947849;
        break label72;
      }
      Object localObject3;
      if (this.mViewContainer == null)
      {
        localObject3 = this.mDiyHelper.getDiyView(getProfileContentKey());
        paramCard = (Card)localObject3;
        if (localObject3 == null) {
          paramCard = this.mActivity.getLayoutInflater().inflate(2131561528, null);
        }
        this.mViewContainer = paramCard;
      }
      for (bool = true;; bool = false)
      {
        View localView = (View)this.mViewContainer;
        paramCard = localView.findViewById(2131374760);
        localObject3 = (TextView)localView.findViewById(2131369051);
        LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131370673);
        ((TextView)localObject3).setTextColor(i);
        StatusManager localStatusManager = (StatusManager)this.mApp.getManager(QQManagerFactory.STATUS_MANAGER);
        updateSignInfo(paramBoolean, (SpannableString)localObject2, (RichStatus)localObject1, (TextView)localObject3, localLinearLayout, localStatusManager);
        updateSignTopic(paramBoolean, (SpannableString)localObject2, (RichStatus)localObject1, localView, (TextView)localObject3, localLinearLayout);
        updateSignContentDescription((RichStatus)localObject1, paramCard);
        updateRichStatusIconListener((RichStatus)localObject1, localStatusManager);
        localObject1 = (ImageView)localView.findViewById(2131363027);
        if ((paramBoolean) || (ProfileActivity.AllInOne.b(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
        {
          ((ImageView)localObject1).setVisibility(0);
          paramCard.setTag(new DataTag(3, null));
          paramCard.setOnClickListener(this);
        }
        while (paramBoolean)
        {
          updateItemTheme(null, (View)localObject1);
          return bool;
          ((ImageView)localObject1).setVisibility(4);
        }
        updateItemTheme((TextView)localObject3, (View)localObject1);
        return bool;
      }
      return false;
    }
  }
  
  private void setAvatar(String paramString, CircleBoarderImageView paramCircleBoarderImageView)
  {
    Object localObject = null;
    if (this.mDecoder != null)
    {
      Bitmap localBitmap = this.mDecoder.getBitmapFromCache(1, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.mDecoder.isPausing())
        {
          this.mDecoder.requestDecodeFace(paramString, 1, true);
          this.mCommonTopicFriendAvatar.put(paramString, paramCircleBoarderImageView);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = ImageUtil.c();
    }
    paramString = new BitmapDrawable(paramString);
    if (ThemeUtil.isInNightMode(this.mApp)) {
      paramString.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
    }
    paramCircleBoarderImageView.setImageDrawable(paramString);
  }
  
  private void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    int i;
    EntityManager localEntityManager;
    Object localObject;
    if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      i = 1;
      if (i != 0)
      {
        localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        localObject = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject != null) {
          break label153;
        }
        localObject = null;
        label59:
        if (localObject != null) {
          break label176;
        }
        localObject = new Card();
        ((Card)localObject).uin = ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        ((Card)localObject).vRichSign = paramArrayOfByte;
        ((Card)localObject).lSignModifyTime = paramLong;
        localEntityManager.persist((Entity)localObject);
      }
    }
    for (paramArrayOfByte = (byte[])localObject;; paramArrayOfByte = (byte[])localObject)
    {
      ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = RichStatusUtils.Companion.getRichStatus(paramArrayOfByte);
      makeOrRefreshSign(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, false);
      return;
      i = 0;
      break;
      label153:
      localObject = ((FriendsManager)localObject).a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break label59;
      label176:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.update((Entity)localObject);
    }
  }
  
  private void updateRichStatusIconListener(RichStatus paramRichStatus, StatusManager paramStatusManager)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if ((this.mStatusIconListener == null) && (paramStatusManager != null))
      {
        this.mStatusIconListener = new ProfileContentSignComponent.RichStatusIconListener(this);
        paramStatusManager.a(this.mStatusIconListener);
      }
    }
    do
    {
      return;
      ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
    } while ((this.mStatusIconListener == null) || (paramStatusManager == null));
    paramStatusManager.b(this.mStatusIconListener);
    this.mStatusIconListener = null;
  }
  
  private void updateSignContentDescription(RichStatus paramRichStatus, View paramView)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramRichStatus != null)
    {
      if (paramRichStatus.actionText != null) {
        localStringBuilder.append(paramRichStatus.actionText);
      }
      if (paramRichStatus.dataText != null) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      int i;
      if (paramRichStatus.topics != null)
      {
        i = 0;
        if (i < paramRichStatus.topics.size())
        {
          if (TextUtils.isEmpty((CharSequence)((Pair)paramRichStatus.topics.get(i)).second)) {}
          for (;;)
          {
            i += 1;
            break;
            localStringBuilder.append((String)((Pair)paramRichStatus.topics.get(i)).second);
          }
        }
      }
      if (paramRichStatus.plainText != null) {
        i = paramRichStatus.plainText.size();
      }
      while (j < i)
      {
        String str = (String)paramRichStatus.plainText.get(j);
        if (!TextUtils.isEmpty(str)) {
          localStringBuilder.append(str);
        }
        j += 1;
        continue;
        i = 0;
      }
    }
    paramView.setContentDescription(HardCodeUtil.a(2131708465) + localStringBuilder);
  }
  
  private void updateSignInfo(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, TextView paramTextView, LinearLayout paramLinearLayout, StatusManager paramStatusManager)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Resources localResources = this.mActivity.getResources();
      paramLinearLayout = new SpannableStringBuilder(paramSpannableString);
      paramLinearLayout.insert(0, "[S] ");
      if (paramStatusManager != null) {}
      for (paramSpannableString = paramStatusManager.a(paramRichStatus.actionId, 200);; paramSpannableString = BitmapManager.a(localResources, 2130849983))
      {
        int i = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramSpannableString = new StatableBitmapDrawable(localResources, paramSpannableString, false, false);
        paramSpannableString.setBounds(0, 0, i, i);
        paramSpannableString = new OffsetableImageSpan(paramSpannableString, 0);
        paramSpannableString.setOffset(-0.1F);
        paramLinearLayout.setSpan(paramSpannableString, 0, "[S]".length(), 17);
        this.mDrawableSize = i;
        paramTextView.setText(new QQText(paramLinearLayout, 1, 20));
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
    }
    this.mDrawableSize = 0;
    if ((paramSpannableString.length() == 0) && (paramBoolean))
    {
      paramTextView.setText(2131699117);
      recommendTopicViewControl(paramLinearLayout, paramBoolean);
      return;
    }
    paramTextView.setText(new QQText(paramSpannableString, 1, 20));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void updateSignTopic(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, View paramView, TextView paramTextView, LinearLayout paramLinearLayout)
  {
    int i;
    if (paramSpannableString.length() >= 0) {
      if ((paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0))
      {
        if (!paramBoolean) {
          break label468;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i, 0, "" + i, "0", "", "");
      label156:
      label208:
      label239:
      boolean bool1;
      if ((!SigTopicManager.a().a(this.mApp)) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.mFromExtendFriend))
      {
        if ((paramRichStatus.plainText != null) && (paramRichStatus.plainText.size() > 0))
        {
          paramSpannableString = (String)paramRichStatus.plainText.get(0);
          this.mPlainText = paramSpannableString;
          paramRichStatus.sortTopicPos();
          if ((paramRichStatus.topicsPos == null) || (paramRichStatus.topicsPos.size() <= 0)) {
            break label479;
          }
          i = ((Integer)((Pair)paramRichStatus.topicsPos.get(0)).second).intValue();
          this.mPos = i;
          if (!ProfileCardMoreInfoView.a(paramTextView)) {
            break label485;
          }
          paramTextView.post(new ProfileContentSignComponent.3(this, paramTextView, paramRichStatus));
        }
      }
      else
      {
        SigTopicManager.a().a(this.mApp, paramRichStatus);
        bool1 = SigTopicManager.a().b(this.mApp);
        paramRichStatus = (ImageView)paramView.findViewById(2131379549);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard == null) || (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {
          break label557;
        }
      }
      try
      {
        paramSpannableString.mergeFrom(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
        paramSpannableString = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramSpannableString != null) {}
        for (paramSpannableString = paramSpannableString.rpt_topic_item.get();; paramSpannableString = null)
        {
          long l = SigTopicManager.a().a(paramSpannableString);
          boolean bool2 = SigTopicManager.a().a(this.mApp, l);
          if ((!bool1) && (!bool2)) {
            break label549;
          }
          i = SigTopicManager.a().a(paramSpannableString);
          if ((paramSpannableString == null) || (paramSpannableString.size() <= 0) || (i <= 0)) {
            break label530;
          }
          paramLinearLayout.setTag(new DataTag(97, SigTopicManager.a().a(paramSpannableString)));
          paramLinearLayout.setOnClickListener(this);
          commonSigTopicViewControl(paramLinearLayout, paramSpannableString);
          paramRichStatus.setOnTouchListener(UITools.a);
          paramRichStatus.setOnClickListener(new ProfileContentSignComponent.4(this, paramLinearLayout));
          return;
          label468:
          i = 2;
          break;
          paramSpannableString = null;
          break label156;
          label479:
          i = 0;
          break label208;
          label485:
          this.mInfo = paramTextView;
          this.mTopic = ((String)((Pair)paramRichStatus.topics.get(0)).second);
          this.mActionText = paramRichStatus.actionText;
          break label239;
        }
        label530:
        recommendTopicViewControl(paramLinearLayout, paramBoolean);
        return;
      }
      catch (Exception paramSpannableString)
      {
        QLog.e("ProfileContentSignComponent", 1, "", paramSpannableString);
        return;
      }
    }
    label549:
    recommendTopicViewControl(paramLinearLayout, paramBoolean);
    return;
    label557:
    recommendTopicViewControl(paramLinearLayout, paramBoolean);
  }
  
  public void commonSigTopicViewControl(View paramView, List<oidb_0xd9f.TopicItem> paramList)
  {
    if (paramView != null)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        paramView.setVisibility(8);
      }
    }
    else {
      return;
    }
    paramView.setVisibility(0);
    ((RelativeLayout)paramView.findViewById(2131367062)).setVisibility(0);
    Object localObject = (CircleBoarderImageView)paramView.findViewById(2131364759);
    CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131364760);
    CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131364761);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localArrayList.add(localCircleBoarderImageView1);
    localArrayList.add(localCircleBoarderImageView2);
    localObject = (TextView)paramView.findViewById(2131380280);
    Collections.sort(paramList, new ProfileContentSignComponent.5(this));
    int j = SigTopicManager.a().a(paramList);
    paramList = SigTopicManager.a().a(paramList);
    if (paramList.size() > localArrayList.size())
    {
      i = 0;
      while (i < localArrayList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
        setAvatar(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
        i += 1;
      }
    }
    int i = 0;
    if (i < localArrayList.size())
    {
      if (i < paramList.size())
      {
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
        setAvatar(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(8);
      }
    }
    if (j <= 3)
    {
      paramList = j + HardCodeUtil.a(2131708462);
      ((TextView)localObject).setText(paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        break label463;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
      return;
      paramList = HardCodeUtil.a(2131708432) + j + HardCodeUtil.a(2131708411);
      break;
      label463:
      if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
        paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130846167));
      } else {
        paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130846166));
      }
    }
  }
  
  public String getComponentName()
  {
    return "ProfileContentSignComponent";
  }
  
  public int getComponentType()
  {
    return 1011;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_sig";
  }
  
  public void hideCommonTopicFriendAvatarControl(View paramView)
  {
    if (paramView != null)
    {
      Object localObject = (RelativeLayout)paramView.findViewById(2131367062);
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      localObject = (CircleBoarderImageView)paramView.findViewById(2131364759);
      CircleBoarderImageView localCircleBoarderImageView = (CircleBoarderImageView)paramView.findViewById(2131364760);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131364761);
      if (localObject != null) {
        ((CircleBoarderImageView)localObject).setVisibility(8);
      }
      if (localCircleBoarderImageView != null) {
        localCircleBoarderImageView.setVisibility(8);
      }
      if (paramView != null) {
        paramView.setVisibility(8);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof DataTag))
    {
      localObject = (DataTag)paramView.getTag();
      switch (((DataTag)localObject).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ProfileSignatureUtils.handleSignatureClick((ProfileCardInfo)this.mData, this.mActivity, this.mApp);
      continue;
      localObject = (Pair)((DataTag)localObject).jdField_a_of_type_JavaLangObject;
      ProfileSignatureUtils.handleSignatureCommonClick(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.mActivity, this.mApp);
    }
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    int j = 1;
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof Pair))
    {
      paramITopic = (Pair)paramITopic;
      TopicUtil.a(this.mActivity, TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
      if (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label121;
      }
      i = 1;
      if (i == 0) {
        break label126;
      }
    }
    label121:
    label126:
    for (int i = j;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i, 0, "" + i, "0", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = this.mActivity.getIntent();
    if (paramBaseActivity != null) {
      this.mFromExtendFriend = paramBaseActivity.getBooleanExtra("key_from_extends_friend", false);
    }
    this.mDecoder = ((IQQAvatarService)this.mApp.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.mApp);
    this.mDecoder.setDecodeTaskCompletionListener(this);
    this.mCommonTopicFriendAvatar = new HashMap();
    this.mApp.addObserver(this.mFriendListObserver);
    if (this.mDelegate != null) {
      this.mDelegate.addProfileScrollListener(this);
    }
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshSign(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard, ((ProfileCardInfo)this.mData).d) | bool;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (CircleBoarderImageView)this.mCommonTopicFriendAvatar.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
  
  public void onDestroy()
  {
    this.mApp.removeObserver(this.mFriendListObserver);
    if (this.mDelegate != null) {
      this.mDelegate.removeProfileScrollListener(this);
    }
    if (this.mStatusIconListener != null)
    {
      ((StatusManager)this.mApp.getManager(QQManagerFactory.STATUS_MANAGER)).b(this.mStatusIconListener);
      this.mStatusIconListener = null;
    }
    if (this.mDecoder != null)
    {
      this.mDecoder.destory();
      this.mDecoder = null;
    }
    if (this.mCommonTopicFriendAvatar != null)
    {
      this.mCommonTopicFriendAvatar.clear();
      this.mCommonTopicFriendAvatar = null;
    }
    super.onDestroy();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!SigTopicManager.a().a(this.mApp)) && (ProfileCardMoreInfoView.a(this.mInfo))) {
      this.mInfo.post(new ProfileContentSignComponent.2(this));
    }
  }
  
  public void recommendTopicViewControl(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (!paramBoolean) {
        paramView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (!SigTopicManager.a().c(this.mApp))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = SigTopicConfProcessor.a();
    if ((localObject == null) || (((SigTopicConfBean)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    hideCommonTopicFriendAvatarControl(paramView);
    paramView.setVisibility(0);
    ArrayList localArrayList = ((SigTopicConfBean)localObject).a().a;
    TextView localTextView = (TextView)paramView.findViewById(2131380280);
    ImageView localImageView = (ImageView)paramView.findViewById(2131379549);
    localTextView.setText(SigTopicManager.a().a((SigTopicConfBean)localObject));
    int i = 0;
    int j;
    while (i < ((SigTopicConfBean)localObject).a().a.size()) {
      if (TextUtils.isEmpty(((SigTopicConfBean.TopicInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        j = ((SigTopicConfBean.TopicInfo)localArrayList.get(i)).jdField_a_of_type_Int;
        localObject = ((SigTopicConfBean.TopicInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
      }
    }
    for (i = j;; i = -1)
    {
      if (paramBoolean) {
        paramView.setOnClickListener(new ProfileContentSignComponent.6(this, (String)localObject, i, paramView));
      }
      localImageView.setOnTouchListener(UITools.a);
      localImageView.setOnClickListener(new ProfileContentSignComponent.7(this, paramView));
      if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
        paramView.setBackgroundDrawable(null);
      }
      for (;;)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
        if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
          paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130846167));
        } else {
          paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130846166));
        }
      }
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
 * JD-Core Version:    0.7.0.1
 */