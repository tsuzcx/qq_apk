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
import androidx.annotation.Nullable;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
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
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.base.utils.ProfileSignatureUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
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
  extends AbsQQProfileContentComponent
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
  private RichStatus richStatus = null;
  
  public ProfileContentSignComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean makeOrRefreshSign(Card paramCard, boolean paramBoolean)
  {
    boolean bool;
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramBoolean = ProfilePAUtils.isPaTypeHasUin(((ProfileCardInfo)this.mData).allInOne);
    Object localObject1 = this.mActivity.getResources();
    int j;
    int i;
    if (ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData))
    {
      j = ((Resources)localObject1).getColor(2131167993);
      i = ((Resources)localObject1).getColor(2131167993);
    }
    else
    {
      j = -8947849;
      i = ((Resources)localObject1).getColor(2131165564);
    }
    localObject1 = this.richStatus;
    if ((localObject1 == null) && (paramCard != null)) {
      localObject1 = RichStatusUtils.Companion.getRichStatus(paramCard);
    }
    if (localObject1 != null) {
      paramCard = new SpannableString(((RichStatus)localObject1).toSpannableStringWithTopic(null, j, i, this));
    } else {
      paramCard = null;
    }
    Object localObject2 = paramCard;
    if (paramCard == null) {
      localObject2 = new SpannableString("");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileContentSignComponent", 2, String.format("makeOrRefreshSign isHost=%s isPaTypeHasUin=%s length=%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Integer.valueOf(((SpannableString)localObject2).length()) }));
    }
    if ((!bool) && ((!paramBoolean) || (((SpannableString)localObject2).length() == 0)))
    {
      if (this.mViewContainer != null)
      {
        this.mViewContainer = null;
        paramBoolean = true;
      }
      else
      {
        paramBoolean = false;
      }
    }
    else
    {
      if (this.mViewContainer == null)
      {
        this.mViewContainer = this.mActivity.getLayoutInflater().inflate(2131627725, null);
        paramBoolean = true;
      }
      else
      {
        paramBoolean = false;
      }
      View localView = (View)this.mViewContainer;
      paramCard = localView.findViewById(2131442459);
      TextView localTextView = (TextView)localView.findViewById(2131435692);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131437563);
      localTextView.setTextColor(j);
      StatusManager localStatusManager = (StatusManager)this.mApp.getManager(QQManagerFactory.STATUS_MANAGER);
      updateSignInfo(bool, (SpannableString)localObject2, (RichStatus)localObject1, localTextView, localLinearLayout, localStatusManager);
      updateSignTopic(bool, (SpannableString)localObject2, (RichStatus)localObject1, localView, localTextView, localLinearLayout);
      updateSignContentDescription((RichStatus)localObject1, paramCard);
      updateRichStatusIconListener((RichStatus)localObject1, localStatusManager);
      localObject1 = (ImageView)localView.findViewById(2131428774);
      if ((!bool) && (!ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)this.mData).allInOne)))
      {
        ((ImageView)localObject1).setVisibility(4);
      }
      else
      {
        ((ImageView)localObject1).setVisibility(0);
        paramCard.setTag(new DataTag(3, null));
        paramCard.setOnClickListener(this);
      }
      updateItemTheme(paramCard, localTextView, null, (ImageView)localObject1);
    }
    paramCard = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
    if (paramCard.isDiy())
    {
      if (this.mViewContainer != null) {
        ((View)this.mViewContainer).setBackgroundResource(2130839624);
      }
      paramCard.updateSignForDeepDiy((View)this.mViewContainer);
    }
    return paramBoolean;
  }
  
  private void setAvatar(String paramString, CircleBoarderImageView paramCircleBoarderImageView)
  {
    Object localObject = this.mDecoder;
    if (localObject != null)
    {
      Bitmap localBitmap = ((IFaceDecoder)localObject).getBitmapFromCache(1, paramString);
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
    else
    {
      localObject = null;
    }
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = ImageUtil.k();
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
    if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      Object localObject = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((FriendsManager)localObject).f(((ProfileCardInfo)this.mData).allInOne.uin);
      }
      if (localObject == null)
      {
        localObject = new Card();
        ((Card)localObject).uin = ((ProfileCardInfo)this.mData).allInOne.uin;
        ((Card)localObject).vRichSign = paramArrayOfByte;
        ((Card)localObject).lSignModifyTime = paramLong;
        localEntityManager.persist((Entity)localObject);
      }
      else
      {
        ((Card)localObject).vRichSign = paramArrayOfByte;
        ((Card)localObject).lSignModifyTime = paramLong;
        localEntityManager.update((Entity)localObject);
      }
      this.richStatus = RichStatusUtils.Companion.getRichStatus((Card)localObject);
      makeOrRefreshSign(((ProfileCardInfo)this.mData).card, false);
    }
  }
  
  private void updateRichStatusIconListener(RichStatus paramRichStatus, StatusManager paramStatusManager)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      this.richStatus = paramRichStatus;
      if ((this.mStatusIconListener == null) && (paramStatusManager != null))
      {
        this.mStatusIconListener = new ProfileContentSignComponent.RichStatusIconListener(this);
        paramStatusManager.a(this.mStatusIconListener);
      }
    }
    else
    {
      this.richStatus = null;
      paramRichStatus = this.mStatusIconListener;
      if ((paramRichStatus != null) && (paramStatusManager != null))
      {
        paramStatusManager.b(paramRichStatus);
        this.mStatusIconListener = null;
      }
    }
  }
  
  private void updateSignContentDescription(RichStatus paramRichStatus, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramRichStatus != null)
    {
      if (paramRichStatus.actionText != null) {
        localStringBuilder.append(paramRichStatus.actionText);
      }
      if (paramRichStatus.dataText != null) {
        localStringBuilder.append(paramRichStatus.dataText);
      }
      Object localObject = paramRichStatus.topics;
      int j = 0;
      int i;
      if (localObject != null)
      {
        i = 0;
        while (i < paramRichStatus.topics.size())
        {
          if (!TextUtils.isEmpty((CharSequence)((Pair)paramRichStatus.topics.get(i)).second)) {
            localStringBuilder.append((String)((Pair)paramRichStatus.topics.get(i)).second);
          }
          i += 1;
        }
      }
      if (paramRichStatus.plainText != null) {
        i = paramRichStatus.plainText.size();
      } else {
        i = 0;
      }
      while (j < i)
      {
        localObject = (String)paramRichStatus.plainText.get(j);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localStringBuilder.append((String)localObject);
        }
        j += 1;
      }
    }
    paramRichStatus = new StringBuilder();
    paramRichStatus.append(HardCodeUtil.a(2131906257));
    paramRichStatus.append(localStringBuilder);
    paramView.setContentDescription(paramRichStatus.toString());
  }
  
  private void updateSignInfo(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, TextView paramTextView, LinearLayout paramLinearLayout, StatusManager paramStatusManager)
  {
    if ((paramRichStatus != null) && (!TextUtils.isEmpty(paramRichStatus.actionText)))
    {
      Resources localResources = this.mActivity.getResources();
      paramLinearLayout = new SpannableStringBuilder(paramSpannableString);
      paramLinearLayout.insert(0, "[S] ");
      if (paramStatusManager != null) {
        paramSpannableString = paramStatusManager.a(paramRichStatus.actionId, 200);
      } else {
        paramSpannableString = BitmapManager.a(localResources, 2130851609);
      }
      int i = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramSpannableString = new StatableBitmapDrawable(localResources, paramSpannableString, false, false);
      paramSpannableString.setBounds(0, 0, i, i);
      paramSpannableString = new OffsetableImageSpan(paramSpannableString, 0);
      paramSpannableString.setOffset(-0.1F);
      paramLinearLayout.setSpan(paramSpannableString, 0, 3, 17);
      this.mDrawableSize = i;
      paramTextView.setText(new QQText(paramLinearLayout, 1, 20));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    this.mDrawableSize = 0;
    if ((paramSpannableString.length() == 0) && (paramBoolean))
    {
      paramTextView.setText(2131897237);
      recommendTopicViewControl(paramLinearLayout, paramBoolean);
      return;
    }
    paramTextView.setText(new QQText(paramSpannableString, 1, 20));
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private void updateSignTopic(boolean paramBoolean, SpannableString paramSpannableString, RichStatus paramRichStatus, View paramView, TextView paramTextView, LinearLayout paramLinearLayout)
  {
    if (paramSpannableString.length() >= 0)
    {
      int i;
      if ((paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0))
      {
        if (paramBoolean) {
          i = 1;
        } else {
          i = 2;
        }
        paramSpannableString = new StringBuilder();
        paramSpannableString.append("");
        paramSpannableString.append(i);
        ReportController.b(null, "dc00898", "", "", "0X800A4D2", "0X800A4D2", i, 0, paramSpannableString.toString(), "0", "", "");
      }
      boolean bool1 = SigTopicManager.a().a(this.mQQAppInterface);
      Object localObject = null;
      if ((!bool1) && (paramRichStatus != null) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0) && (!this.mFromExtendFriend))
      {
        if ((paramRichStatus.plainText != null) && (paramRichStatus.plainText.size() > 0)) {
          paramSpannableString = (String)paramRichStatus.plainText.get(0);
        } else {
          paramSpannableString = null;
        }
        this.mPlainText = paramSpannableString;
        paramRichStatus.sortTopicPos();
        if ((paramRichStatus.topicsPos != null) && (paramRichStatus.topicsPos.size() > 0)) {
          i = ((Integer)((Pair)paramRichStatus.topicsPos.get(0)).second).intValue();
        } else {
          i = 0;
        }
        this.mPos = i;
        if (ProfileUtils.isVisible(paramTextView))
        {
          paramTextView.post(new ProfileContentSignComponent.3(this, paramTextView, paramRichStatus));
        }
        else
        {
          this.mInfo = paramTextView;
          this.mTopic = ((String)((Pair)paramRichStatus.topics.get(0)).second);
          this.mActionText = paramRichStatus.actionText;
        }
      }
      SigTopicManager.a().a(this.mQQAppInterface, paramRichStatus);
      bool1 = SigTopicManager.a().d(this.mQQAppInterface);
      paramRichStatus = (ImageView)paramView.findViewById(2131447598);
      paramSpannableString = new oidb_0xd9f.RspBody();
      if ((((ProfileCardInfo)this.mData).card != null) && (((ProfileCardInfo)this.mData).card.vLongNickTopicInfo != null)) {
        try
        {
          paramSpannableString.mergeFrom(((ProfileCardInfo)this.mData).card.vLongNickTopicInfo);
          paramView = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
          paramSpannableString = localObject;
          if (paramView != null) {
            paramSpannableString = paramView.rpt_topic_item.get();
          }
          long l = SigTopicManager.a().d(paramSpannableString);
          boolean bool2 = SigTopicManager.a().b(this.mQQAppInterface, l);
          if ((!bool1) && (!bool2))
          {
            recommendTopicViewControl(paramLinearLayout, paramBoolean);
            return;
          }
          i = SigTopicManager.a().c(paramSpannableString);
          if ((paramSpannableString != null) && (paramSpannableString.size() > 0) && (i > 0))
          {
            paramLinearLayout.setTag(new DataTag(97, SigTopicManager.a().b(paramSpannableString)));
            paramLinearLayout.setOnClickListener(this);
            commonSigTopicViewControl(paramLinearLayout, paramSpannableString);
            paramRichStatus.setOnTouchListener(UITools.a);
            paramRichStatus.setOnClickListener(new ProfileContentSignComponent.4(this, paramLinearLayout));
            return;
          }
          recommendTopicViewControl(paramLinearLayout, paramBoolean);
          return;
        }
        catch (Exception paramSpannableString)
        {
          QLog.e("ProfileContentSignComponent", 1, "", paramSpannableString);
          return;
        }
      }
      recommendTopicViewControl(paramLinearLayout, paramBoolean);
    }
  }
  
  public void commonSigTopicViewControl(View paramView, List<oidb_0xd9f.TopicItem> paramList)
  {
    if (paramView != null)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        paramView.setVisibility(0);
        ((RelativeLayout)paramView.findViewById(2131433246)).setVisibility(0);
        Object localObject = (CircleBoarderImageView)paramView.findViewById(2131430736);
        CircleBoarderImageView localCircleBoarderImageView1 = (CircleBoarderImageView)paramView.findViewById(2131430737);
        CircleBoarderImageView localCircleBoarderImageView2 = (CircleBoarderImageView)paramView.findViewById(2131430738);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        localArrayList.add(localCircleBoarderImageView1);
        localArrayList.add(localCircleBoarderImageView2);
        localObject = (TextView)paramView.findViewById(2131448350);
        Collections.sort(paramList, new ProfileContentSignComponent.5(this));
        int j = SigTopicManager.a().c(paramList);
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
        while (i < localArrayList.size())
        {
          if (i < paramList.size())
          {
            ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(0);
            setAvatar(String.valueOf(((oidb_0xd9f.UinItem)paramList.get(i)).uint64_uin.get()), (CircleBoarderImageView)localArrayList.get(i));
          }
          else
          {
            ((CircleBoarderImageView)localArrayList.get(i)).setVisibility(8);
          }
          i += 1;
        }
        if (j <= 3)
        {
          paramList = new StringBuilder();
          paramList.append(j);
          paramList.append(HardCodeUtil.a(2131906254));
          paramList = paramList.toString();
        }
        else
        {
          paramList = new StringBuilder();
          paramList.append(HardCodeUtil.a(2131906224));
          paramList.append(j);
          paramList.append(HardCodeUtil.a(2131906203));
          paramList = paramList.toString();
        }
        ((TextView)localObject).setText(paramList);
        if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
          paramView.setBackgroundDrawable(null);
        } else if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
          paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130847513));
        } else {
          paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130847512));
        }
        ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
        return;
      }
      paramView.setVisibility(8);
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
    return "map_key_personal_sign";
  }
  
  public void hideCommonTopicFriendAvatarControl(View paramView)
  {
    if (paramView != null)
    {
      Object localObject = (RelativeLayout)paramView.findViewById(2131433246);
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      localObject = (CircleBoarderImageView)paramView.findViewById(2131430736);
      CircleBoarderImageView localCircleBoarderImageView = (CircleBoarderImageView)paramView.findViewById(2131430737);
      paramView = (CircleBoarderImageView)paramView.findViewById(2131430738);
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
    if ((paramView.getTag() instanceof DataTag))
    {
      Object localObject = (DataTag)paramView.getTag();
      int i = ((DataTag)localObject).a;
      if (i != 3)
      {
        if (i == 97)
        {
          localObject = (Pair)((DataTag)localObject).b;
          ProfileSignatureUtils.handleSignatureCommonClick(paramView, ((Integer)((Pair)localObject).first).intValue(), (String)((Pair)localObject).second, this.mActivity, this.mQQAppInterface);
        }
      }
      else {
        ProfileSignatureUtils.handleSignatureClick((ProfileCardInfo)this.mData, this.mActivity, this.mQQAppInterface);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof Pair))
    {
      paramITopic = (Pair)paramITopic;
      TopicUtil.a(this.mActivity, TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
      int i;
      if (((ProfileCardInfo)this.mData).allInOne.pa == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        i = 1;
      } else {
        i = 2;
      }
      paramITopic = new StringBuilder();
      paramITopic.append("");
      paramITopic.append(i);
      ReportController.b(null, "dc00898", "", "", "0X800A4D3", "0X800A4D3", i, 0, paramITopic.toString(), "0", "", "");
    }
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = this.mActivity.getIntent();
    if (paramQBaseActivity != null) {
      this.mFromExtendFriend = paramQBaseActivity.getBooleanExtra("key_from_extends_friend", false);
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
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshSign(((ProfileCardInfo)this.mData).card, ((ProfileCardInfo)this.mData).isNetRet);
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
    Object localObject = this.mDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).destory();
      this.mDecoder = null;
    }
    localObject = this.mCommonTopicFriendAvatar;
    if (localObject != null)
    {
      ((Map)localObject).clear();
      this.mCommonTopicFriendAvatar = null;
    }
    super.onDestroy();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (!SigTopicManager.a().a(this.mQQAppInterface)) && (ProfileUtils.isVisible(this.mInfo))) {
      this.mInfo.post(new ProfileContentSignComponent.2(this));
    }
  }
  
  public void recommendTopicViewControl(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      if (!paramBoolean)
      {
        paramView.setVisibility(8);
        return;
      }
      if (!SigTopicManager.a().e(this.mQQAppInterface))
      {
        paramView.setVisibility(8);
        return;
      }
      Object localObject = SigTopicConfProcessor.a();
      if ((localObject != null) && (!((SigTopicConfBean)localObject).b()))
      {
        hideCommonTopicFriendAvatarControl(paramView);
        paramView.setVisibility(0);
        ArrayList localArrayList = ((SigTopicConfBean)localObject).a().b;
        TextView localTextView = (TextView)paramView.findViewById(2131448350);
        ImageView localImageView = (ImageView)paramView.findViewById(2131447598);
        localTextView.setText(SigTopicManager.a().a((SigTopicConfBean)localObject));
        int j = -1;
        int i = 0;
        while (i < ((SigTopicConfBean)localObject).a().b.size()) {
          if (TextUtils.isEmpty(((SigTopicConfBean.TopicInfo)localArrayList.get(i)).b))
          {
            i += 1;
          }
          else
          {
            j = ((SigTopicConfBean.TopicInfo)localArrayList.get(i)).a;
            localObject = ((SigTopicConfBean.TopicInfo)localArrayList.get(i)).b;
            i = j;
            break label205;
          }
        }
        localObject = "";
        i = j;
        label205:
        if (paramBoolean) {
          paramView.setOnClickListener(new ProfileContentSignComponent.6(this, (String)localObject, i, paramView));
        }
        localImageView.setOnTouchListener(UITools.a);
        localImageView.setOnClickListener(new ProfileContentSignComponent.7(this, paramView));
        if (ThemeUtil.isNowThemeIsNight(this.mApp, false, null)) {
          paramView.setBackgroundDrawable(null);
        } else if (!ProfileCardUtils.isDefaultProfile((ProfileCardInfo)this.mData)) {
          paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130847513));
        } else {
          paramView.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130847512));
        }
        ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
        return;
      }
      paramView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent
 * JD-Core Version:    0.7.0.1
 */