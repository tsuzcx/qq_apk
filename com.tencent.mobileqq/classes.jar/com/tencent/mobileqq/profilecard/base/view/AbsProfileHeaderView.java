package com.tencent.mobileqq.profilecard.base.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.SigTopicConfig;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.TopicInfo;
import com.tencent.mobileqq.config.business.sigtopic.SigTopicConfProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.view.ProfileViewUpdate;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ITemplateUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.topic.StateColorMovementMethod;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.mobileqq.text.ITopic.OnTopicClickListener;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.qid.QidCoolTextView;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProfileNameView;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView.MotionEventInterceptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem;
import tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.RspBody;

public abstract class AbsProfileHeaderView
  extends RelativeLayout
  implements ProfileViewUpdate, ITopic.OnTopicClickListener, XListView.MotionEventInterceptor
{
  private static final int MSG_CHECK_TIPS = 1000;
  private static final int MSG_UPDATE_PENDANT = 1003;
  private static final int PROFILE_FLAG_SET_CARD = 2;
  public static String TAG = "AbsProfileHeaderView";
  protected QBaseActivity mActivity;
  protected QQAppInterface mApp;
  protected ProfileCardInfo mCardInfo;
  public int mCoverTimeStamp = 0;
  public String mCoverUrl;
  protected float mDensity;
  protected BusinessObserver mDiyPendantObserver = new AbsProfileHeaderView.AvatarUpdateObserver(this);
  private boolean mHasSendUpdateTips = false;
  private float mHeaderAvailableWidth;
  protected HashMap<String, View> mHeaderChildMap = new HashMap();
  protected NewVoteAnimHelper mNewVoteAnimHelper;
  protected View.OnClickListener mOnClickListener;
  protected long mPendantId;
  protected float mScreenHeight;
  protected float mScreenWidth;
  private AtomicBoolean mSetCardChecked = new AtomicBoolean(false);
  private int mTipsFlags = 0;
  private Handler.Callback mUICallback = new AbsProfileHeaderView.1(this);
  protected MqqWeakReferenceHandler mUIHandler;
  protected ITemplateUtils templateUtils;
  
  public AbsProfileHeaderView(QBaseActivity paramQBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramQBaseActivity);
    this.mActivity = paramQBaseActivity;
    this.mApp = ((QQAppInterface)this.mActivity.getAppRuntime());
    this.mCardInfo = paramProfileCardInfo;
    this.mUIHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    paramQBaseActivity = getResources().getDisplayMetrics();
    this.mDensity = paramQBaseActivity.density;
    this.mScreenWidth = Math.min(paramQBaseActivity.widthPixels, paramQBaseActivity.heightPixels);
    this.mScreenHeight = Math.max(paramQBaseActivity.widthPixels, paramQBaseActivity.heightPixels);
    this.mPendantId = 0L;
    this.mHeaderAvailableWidth = (this.mScreenWidth - ScreenUtil.dip2px(127.0F));
  }
  
  private void checkTips()
  {
    if (this.mSetCardChecked.get())
    {
      Object localObject = this.mUIHandler;
      if ((localObject != null) && (!this.mHasSendUpdateTips))
      {
        this.mHasSendUpdateTips = true;
        localObject = ((MqqWeakReferenceHandler)localObject).obtainMessage(1000);
        if (localObject != null) {
          this.mUIHandler.sendMessage((Message)localObject);
        }
      }
    }
  }
  
  private void clearAvatarMask(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof FaceDrawable)) {
        ((FaceDrawable)paramImageView).setSupportMaskView(false);
      }
    }
  }
  
  private SpannableStringBuilder constructSignSpan(ProfileCardInfo paramProfileCardInfo, SpannableString paramSpannableString, TextView paramTextView)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableString);
    if (paramProfileCardInfo.allInOne.pa == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramProfileCardInfo = null;
      try
      {
        paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130846045);
        paramProfileCardInfo = paramSpannableString;
      }
      catch (Throwable paramSpannableString)
      {
        paramSpannableString.printStackTrace();
      }
      catch (OutOfMemoryError paramSpannableString)
      {
        paramSpannableString.printStackTrace();
      }
      paramProfileCardInfo = new StatableBitmapDrawable(getResources(), paramProfileCardInfo, false, false);
      int i = (int)(paramTextView.getTextSize() + 0.5F);
      paramProfileCardInfo.setBounds(0, 0, i, i);
      paramProfileCardInfo = new OffsetableImageSpan(paramProfileCardInfo, 0);
      paramProfileCardInfo.setOffset(-0.1F);
      localSpannableStringBuilder.setSpan(paramProfileCardInfo, 0, 3, 17);
    }
    return localSpannableStringBuilder;
  }
  
  private String handleNickNameAndNumber(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleNickNameAndNumber");
    }
    updateNickInfo(paramString1);
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString2))) {
      return String.format("QQ：%s", new Object[] { paramString2 });
    }
    return null;
  }
  
  private void makeAccountDetailInfo(TextView paramTextView, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfo");
    }
    if (paramProfileCardInfo != null)
    {
      if (paramTextView == null) {
        return;
      }
      List localList = ProfileCardUtil.a(this.mApp, this.mActivity, paramProfileCardInfo);
      boolean bool = localList.isEmpty();
      int i;
      if ((paramProfileCardInfo.allInOne != null) && (paramProfileCardInfo.allInOne.pa == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((bool) && (i != 0)) {
        localList.add(new SpannableString(this.mActivity.getString(2131699164)));
      }
      if (!localList.isEmpty())
      {
        SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder();
        int n = localList.size();
        SpannableStringBuilder localSpannableStringBuilder1 = ProfileCardUtil.a(localList, 0, n, "  ", localSpannableStringBuilder2);
        Object localObject2 = paramTextView.getPaint();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new TextPaint(1);
          ((TextPaint)localObject1).density = this.mDensity;
        }
        localObject2 = localSpannableStringBuilder1;
        if (((TextPaint)localObject1).measureText(localSpannableStringBuilder1, 0, localSpannableStringBuilder1.length() - 1) > this.mHeaderAvailableWidth)
        {
          localSpannableStringBuilder1 = new SpannableStringBuilder();
          int j = 0;
          i = 1;
          int k;
          int m;
          for (;;)
          {
            localObject2 = ProfileCardUtil.a(localList, j, i, "  ", localSpannableStringBuilder2);
            if (((TextPaint)localObject1).measureText((CharSequence)localObject2, 0, ((SpannableStringBuilder)localObject2).length() - 1) < this.mHeaderAvailableWidth)
            {
              i += 1;
            }
            else
            {
              if (i - j == 1)
              {
                localObject1 = ProfileCardUtil.a(localList, j, n, "  ", localSpannableStringBuilder2);
                if (localSpannableStringBuilder1.length() > 0) {
                  localSpannableStringBuilder1.append("\n");
                }
                localSpannableStringBuilder1.append((CharSequence)localObject1);
                k = j;
                m = i;
                break;
              }
              k = i - 1;
              localObject2 = ProfileCardUtil.a(localList, j, k, "  ", localSpannableStringBuilder2);
              if (localSpannableStringBuilder1.length() > 0) {
                localSpannableStringBuilder1.append("\n");
              }
              localSpannableStringBuilder1.append((CharSequence)localObject2);
              j = k;
            }
            k = j;
            m = i;
            if (j < 0) {
              break;
            }
            k = j;
            m = i;
            if (i > n) {
              break;
            }
            if (j >= i)
            {
              k = j;
              m = i;
              break;
            }
          }
          localObject2 = localSpannableStringBuilder1;
          if (m > 1)
          {
            i = m - 1;
            localObject2 = localSpannableStringBuilder1;
            if (k < i)
            {
              localObject2 = localSpannableStringBuilder1;
              if (i == n)
              {
                localObject1 = ProfileCardUtil.a(localList, k, i, "  ", localSpannableStringBuilder2);
                if (localSpannableStringBuilder1.length() > 0) {
                  localSpannableStringBuilder1.append("\n");
                }
                localSpannableStringBuilder1.append((CharSequence)localObject1);
                localObject2 = localSpannableStringBuilder1;
              }
            }
          }
        }
        localObject1 = (ViewGroup.MarginLayoutParams)((View)paramTextView.getParent()).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = 0;
        ((View)paramTextView.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        paramTextView.setText((CharSequence)localObject2);
        paramTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramTextView.setOnTouchListener(UITools.a);
        paramTextView.setOnClickListener(new AbsProfileHeaderView.9(this, paramProfileCardInfo));
        if (!bool) {
          ProfileCardUtil.a(paramTextView, null, null);
        }
      }
      else
      {
        paramTextView.setVisibility(8);
      }
    }
  }
  
  private void makeAccountDetailInfoForQQCircle(LinearLayout paramLinearLayout, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle");
    }
    if (paramProfileCardInfo != null)
    {
      if (paramLinearLayout == null) {
        return;
      }
      paramLinearLayout.removeAllViews();
      List localList = ProfileCardUtil.a(this.mActivity, paramProfileCardInfo);
      boolean bool = localList.isEmpty();
      int i;
      if ((paramProfileCardInfo.allInOne != null) && (paramProfileCardInfo.allInOne.pa == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((bool) && (i != 0)) {
        localList.add(android.util.Pair.create(this.mActivity.getString(2131699164), ""));
      }
      if (!localList.isEmpty())
      {
        int j = localList.size();
        i = 0;
        while (i < j)
        {
          android.util.Pair localPair = (android.util.Pair)localList.get(i);
          String str1 = (String)localPair.first;
          TextView localTextView = new TextView(this.mActivity);
          localTextView.setText(str1);
          localTextView.setTextColor(getResources().getColor(2131167056));
          if (!TextUtils.isEmpty((CharSequence)localPair.second))
          {
            localTextView.setBackgroundResource(2130844138);
            localTextView.setPadding(ViewUtils.b(8.0F), ViewUtils.b(4.5F), ViewUtils.b(8.0F), ViewUtils.b(4.5F));
          }
          localTextView.setTextSize(14.0F);
          paramLinearLayout.addView(localTextView);
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = ViewUtils.b(6.0F);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          paramLinearLayout.measure(0, 0);
          String str2 = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("makeAccountDetailInfoForQQCircle ");
          localStringBuilder.append(str1);
          localStringBuilder.append(", ");
          localStringBuilder.append(this.mHeaderAvailableWidth);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramLinearLayout.getMeasuredWidth());
          QLog.d(str2, 2, localStringBuilder.toString());
          if (paramLinearLayout.getMeasuredWidth() > this.mHeaderAvailableWidth)
          {
            paramLinearLayout.removeView(localTextView);
            break;
          }
          if (!bool) {
            ProfileCardUtil.a(localTextView, null, null);
          }
          i += 1;
        }
        paramLinearLayout.setOnTouchListener(UITools.a);
        paramLinearLayout.setOnClickListener(new AbsProfileHeaderView.10(this, paramProfileCardInfo));
        return;
      }
      paramLinearLayout.setVisibility(8);
    }
  }
  
  private void makeAccountSimpleInfo(TextView paramTextView, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    Object localObject2 = null;
    Card localCard;
    if (paramProfileCardInfo == null) {
      localCard = null;
    } else {
      localCard = paramProfileCardInfo.card;
    }
    if ((paramProfileCardInfo != null) && (localCard != null) && (!ProfilePAUtils.isFromWholePeopleVote(paramProfileCardInfo.allInOne)) && (!ProfilePAUtils.isFromExtendFriend(paramProfileCardInfo.allInOne)))
    {
      paramTextView.setVisibility(0);
      Object localObject1;
      Object localObject3;
      if (paramProfileCardInfo.isTroopMemberCard)
      {
        localObject1 = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramProfileCardInfo.troopUin, localCard.uin);
        if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark))) {
          localObject2 = localCard.strNick;
        } else if (TextUtils.isEmpty(localCard.strReMark)) {
          localObject2 = localCard.strNick;
        } else {
          localObject2 = localCard.strReMark;
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = ContactUtils.a(this.mApp, localCard.uin, false);
        }
        if (((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).m(paramProfileCardInfo.troopUin))
        {
          localObject3 = localObject1;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
        else
        {
          localObject3 = handleNickNameAndNumber(paramTextView, (String)localObject1, localCard.uin, localCard.isNoCover() ^ true);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      else
      {
        int i;
        if ((paramProfileCardInfo.nameArray != null) && (!TextUtils.isEmpty(paramProfileCardInfo.nameArray[5])) && (!TextUtils.equals(paramProfileCardInfo.nameArray[5], localCard.strNick))) {
          i = 1;
        } else {
          i = 0;
        }
        if ((TextUtils.isEmpty(localCard.strReMark)) && (i == 0))
        {
          localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
        }
        else
        {
          String str = handleNickNameAndNumber(paramTextView, localCard.strNick, localCard.uin, localCard.isNoCover() ^ true);
          localObject3 = localCard.strNick;
          localObject2 = localObject3;
          localObject1 = str;
          if (TextUtils.isEmpty(str))
          {
            localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
            localObject2 = localObject3;
          }
        }
      }
      paramTextView.setVisibility(0);
      paramTextView.setSingleLine(true);
      PrettyAccountUtil.a(paramTextView, PrettyAccountUtil.a(localCard), localCard.lhLevel, (CharSequence)localObject1, localCard.uin);
      paramTextView.setOnTouchListener(UITools.a);
      paramTextView.setOnClickListener(new AbsProfileHeaderView.8(this, paramProfileCardInfo));
      ProfileCardUtil.a(paramTextView, localCard.uin, (String)localObject2);
      return;
    }
    this.mHeaderChildMap.remove("map_key_uin_info");
    paramTextView.setVisibility(8);
  }
  
  private void openMoreDetailActivity(ProfileCardInfo paramProfileCardInfo)
  {
    if (paramProfileCardInfo != null)
    {
      ProfileCardUtil.a(paramProfileCardInfo, this.mApp, this.mActivity);
      int i;
      if ((paramProfileCardInfo.allInOne != null) && (paramProfileCardInfo.allInOne.pa == 0)) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X8009999", "0X8009999", i, 0, "", "", "", "");
    }
  }
  
  private void recommendTopicViewControl(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(8);
      return;
    }
    if (!SigTopicManager.a().c(this.mApp))
    {
      paramView.setVisibility(8);
      return;
    }
    Object localObject = SigTopicConfProcessor.a();
    if ((localObject != null) && (!((SigTopicConfBean)localObject).a()))
    {
      int i = 0;
      paramView.setVisibility(0);
      TextView localTextView = (TextView)paramView.findViewById(2131379733);
      ImageView localImageView = (ImageView)paramView.findViewById(2131369319);
      int j = -1;
      ArrayList localArrayList = ((SigTopicConfBean)localObject).a().a;
      localTextView.setText(SigTopicManager.a().a((SigTopicConfBean)localObject));
      while (i < ((SigTopicConfBean)localObject).a().a.size()) {
        if (TextUtils.isEmpty(((SigTopicConfBean.TopicInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString))
        {
          i += 1;
        }
        else
        {
          j = ((SigTopicConfBean.TopicInfo)localArrayList.get(i)).jdField_a_of_type_Int;
          localObject = ((SigTopicConfBean.TopicInfo)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
          i = j;
          break label202;
        }
      }
      localObject = "";
      i = j;
      label202:
      if (paramBoolean) {
        paramView.setOnClickListener(new AbsProfileHeaderView.11(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new AbsProfileHeaderView.12(this, paramView));
      ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
    }
    paramView.setVisibility(8);
  }
  
  private void updateSetCardBar(ProfileCardInfo paramProfileCardInfo)
  {
    this.mTipsFlags &= 0xFFFFFFFD;
    this.mSetCardChecked.set(false);
    Object localObject2 = (View)this.mHeaderChildMap.get("map_key_tips_set_card");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = View.inflate(this.mActivity, 2131562020, null);
    }
    if ((localObject1 != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.card != null))
    {
      this.mHeaderChildMap.put("map_key_tips_set_card", localObject1);
      if ((paramProfileCardInfo.allInOne.pa != 0) && (!this.mApp.getCurrentAccountUin().equals(paramProfileCardInfo.allInOne.uin)))
      {
        ThreadManager.post(new AbsProfileHeaderView.UpdateProfileSetCardTask(this), 5, null, true);
        return;
      }
      long l1 = paramProfileCardInfo.card.lCurrentStyleId;
      long l2 = paramProfileCardInfo.card.lCurrentBgId;
      int i = paramProfileCardInfo.card.templateRet;
      paramProfileCardInfo = paramProfileCardInfo.card.getBgTypeArray();
      if (QLog.isColorLevel())
      {
        localObject2 = TAG;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateSetCardBar bgtype = ");
        ((StringBuilder)localObject3).append(paramProfileCardInfo);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      paramProfileCardInfo = getResources();
      localObject2 = (TextView)((View)localObject1).findViewById(2131367926);
      Object localObject3 = (ImageView)((View)localObject1).findViewById(2131367911);
      Object localObject4 = this.mApp.getPreferences();
      boolean bool;
      if (localObject4 != null) {
        bool = ((SharedPreferences)localObject4).getBoolean("svip_profile_use_guide_shown_flag", false);
      } else {
        bool = false;
      }
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isShowTips");
        localStringBuilder.append(bool);
        localStringBuilder.append(",templateRet=");
        localStringBuilder.append(i);
        localStringBuilder.append(",myTemplateId=");
        localStringBuilder.append(l1);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (((101107 == i) || (101108 == i)) && (!bool) && (localObject4 != null))
      {
        ((SharedPreferences)localObject4).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
        localObject4 = this.mActivity;
        if (101107 == i) {
          paramProfileCardInfo = paramProfileCardInfo.getString(2131695136);
        } else {
          paramProfileCardInfo = paramProfileCardInfo.getString(2131719393);
        }
        paramProfileCardInfo = ((QBaseActivity)localObject4).getString(2131718137, new Object[] { paramProfileCardInfo });
        ((TextView)localObject2).setText(paramProfileCardInfo);
        ((ImageView)localObject3).setContentDescription(paramProfileCardInfo);
        ((View)localObject1).setTag(new DataTag(24, Integer.valueOf(i)));
        ((View)localObject1).setOnClickListener(this.mOnClickListener);
        this.mTipsFlags |= 0x2;
      }
      this.mSetCardChecked.set(true);
      checkTips();
      return;
    }
    this.mSetCardChecked.set(true);
    checkTips();
  }
  
  private void updateSignTopic(ProfileCardInfo paramProfileCardInfo, View paramView, TextView paramTextView, RichStatus paramRichStatus, int paramInt, SpannableString paramSpannableString)
  {
    boolean bool2;
    boolean bool1;
    if (paramSpannableString.length() > 0)
    {
      if ((!SigTopicManager.a().a(this.mApp)) && (paramRichStatus.topics != null) && (paramRichStatus.topics.size() > 0)) {
        paramTextView.post(new AbsProfileHeaderView.5(this, paramRichStatus, paramTextView, paramInt));
      }
      SigTopicManager.a().a(this.mApp, paramRichStatus);
      bool2 = SigTopicManager.a().b(this.mApp);
      if (paramView != null)
      {
        if (paramProfileCardInfo.allInOne.pa == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramTextView = (TextView)paramView.findViewById(2131379733);
        paramRichStatus = (ImageView)paramView.findViewById(2131369319);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((paramProfileCardInfo.card == null) || (paramProfileCardInfo.card.vLongNickTopicInfo == null)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramSpannableString.mergeFrom(paramProfileCardInfo.card.vLongNickTopicInfo);
        paramProfileCardInfo = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramProfileCardInfo == null) {
          break label433;
        }
        paramProfileCardInfo = paramProfileCardInfo.rpt_topic_item.get();
        if ((!bool2) && (!SigTopicManager.a().a(this.mApp, SigTopicManager.a().a(paramProfileCardInfo))))
        {
          recommendTopicViewControl(paramView, bool1);
          return;
        }
        if ((paramProfileCardInfo != null) && (paramProfileCardInfo.size() > 0) && (SigTopicManager.a().a(paramProfileCardInfo) > 0))
        {
          paramView.setTag(new DataTag(97, SigTopicManager.a().a(paramProfileCardInfo)));
          paramView.setOnClickListener(this.mOnClickListener);
          paramSpannableString = new StringBuilder();
          paramSpannableString.append(HardCodeUtil.a(2131708484));
          paramSpannableString.append(SigTopicManager.a().a(paramProfileCardInfo));
          paramSpannableString.append(HardCodeUtil.a(2131708482));
          paramTextView.setText(paramSpannableString.toString());
          paramRichStatus.setOnClickListener(new AbsProfileHeaderView.6(this, paramView));
          paramView.setVisibility(0);
          ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
          return;
        }
        recommendTopicViewControl(paramView, bool1);
        return;
      }
      catch (Exception paramProfileCardInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, paramProfileCardInfo.toString());
        }
        recommendTopicViewControl(paramView, bool1);
        return;
      }
      recommendTopicViewControl(paramView, bool1);
      return;
      label433:
      paramProfileCardInfo = null;
    }
  }
  
  private void updateStaticAvatarInner(int paramInt, AllInOne paramAllInOne, String paramString)
  {
    int i = getResources().getDimensionPixelSize(2131297229);
    Object localObject1 = (AvatarLayout)this.mHeaderChildMap.get("map_key_face");
    Object localObject2 = null;
    BitmapFactory.Options localOptions = null;
    Bitmap localBitmap = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((AvatarLayout)localObject1).a(0);
    }
    localObject1 = (ImageView)localObject1;
    if ((3 != paramInt) && ((localObject1 instanceof DynamicAvatarView))) {
      ((DynamicAvatarView)localObject1).e = "";
    }
    if (paramInt == 0)
    {
      localObject1 = localObject2;
      if (paramAllInOne.pa == 0)
      {
        localObject1 = localObject2;
        if (FaceUtil.a())
        {
          paramAllInOne = localBitmap;
          try
          {
            localObject1 = FaceUtil.b();
            paramAllInOne = localBitmap;
            localObject2 = new File((String)localObject1);
            paramAllInOne = localBitmap;
            localOptions = new BitmapFactory.Options();
            paramAllInOne = localBitmap;
            localObject2 = new FileInputStream((File)localObject2);
            paramAllInOne = localBitmap;
            localOptions.inSampleSize = ((int)ImageUtil.a((InputStream)localObject2, i, i));
            paramAllInOne = localBitmap;
            ((InputStream)localObject2).close();
            paramAllInOne = localBitmap;
            localBitmap = BitmapManager.a((String)localObject1, localOptions);
            localObject1 = localBitmap;
            if (localBitmap != null)
            {
              paramAllInOne = localBitmap;
              localObject1 = this.mApp;
              paramAllInOne = localBitmap;
              localObject1 = QQAppInterface.getCircleFaceBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
            }
          }
          catch (Exception localException)
          {
            localObject1 = paramAllInOne;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.FrdProfileCard", 2, localException.toString());
              localObject1 = paramAllInOne;
            }
          }
        }
      }
      paramAllInOne = (AllInOne)localObject1;
      if (localObject1 == null) {
        paramAllInOne = this.mApp.getFaceBitmap(paramString, true);
      }
    }
    else if (1 == paramInt)
    {
      paramAllInOne = this.mApp.getFaceBitmap(11, paramString, (byte)3, true, 0);
    }
    else if (3 == paramInt)
    {
      if ((localObject1 instanceof DynamicAvatarView))
      {
        paramAllInOne = (DynamicAvatarView)localObject1;
        paramAllInOne.e = ContactUtils.a(this.mCardInfo.allInOne.contactName);
        if (ContactUtils.a(paramAllInOne.e)) {
          paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131299121));
        } else {
          paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131299122));
        }
      }
    }
    try
    {
      paramAllInOne = BitmapFactory.decodeResource(getContext().getResources(), 2130842159);
    }
    catch (OutOfMemoryError paramAllInOne)
    {
      label410:
      break label410;
    }
    paramAllInOne = localOptions;
    break label432;
    if (2 == paramInt) {
      paramAllInOne = ImageUtil.b();
    } else {
      paramAllInOne = ImageUtil.f();
    }
    label432:
    if (paramAllInOne != null) {
      this.mActivity.runOnUiThread(new AbsProfileHeaderView.4(this, paramAllInOne));
    }
  }
  
  public void addChildView(String paramString, View paramView)
  {
    this.mHeaderChildMap.put(paramString, paramView);
  }
  
  public boolean containChildView(String paramString)
  {
    return this.mHeaderChildMap.containsKey(paramString);
  }
  
  public View getChildView(String paramString)
  {
    return (View)this.mHeaderChildMap.get(paramString);
  }
  
  public int getHorizontalMargin()
  {
    return 0;
  }
  
  public long getPendantId()
  {
    return this.mPendantId;
  }
  
  public boolean intercept(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected boolean isShowZan(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = paramProfileCardInfo.card;
    boolean bool4 = false;
    boolean bool2;
    if (localObject != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool5 = TextUtils.equals(paramProfileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
    boolean bool6 = ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne);
    boolean bool3;
    if ((!bool5) && (!bool6))
    {
      boolean bool1;
      if ((bool2) && (paramProfileCardInfo.card.strangerVoteOpen)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool3 = bool1 & bool2;
    }
    else
    {
      bool3 = bool2;
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      String str = paramProfileCardInfo.allInOne.uin;
      if (bool2) {
        bool4 = paramProfileCardInfo.card.strangerVoteOpen;
      }
      QLog.d((String)localObject, 2, String.format("isShowZan updateLike show=%b uin=%sself=%b frd=%b cardOk=%b open=%b ", new Object[] { Boolean.valueOf(bool3), str, Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
    }
    return bool3;
  }
  
  public void onApolloExpand(int paramInt) {}
  
  public void onClick(ITopic paramITopic, View paramView)
  {
    paramITopic = paramITopic.getData();
    if ((paramITopic instanceof com.tencent.util.Pair))
    {
      paramITopic = (com.tencent.util.Pair)paramITopic;
      TopicUtil.a(this.mActivity, TopicUtil.a(((Integer)paramITopic.first).intValue(), (String)paramITopic.second), -1);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    this.mDensity = paramConfiguration.density;
    this.mScreenWidth = Math.min(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
    this.mScreenHeight = Math.max(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
  }
  
  public void onDestroy()
  {
    Object localObject = this.mApp;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.mDiyPendantObserver);
    }
    localObject = this.mUIHandler;
    if (localObject != null) {
      ((MqqWeakReferenceHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = (View)this.mHeaderChildMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView)) {
      ((QzonePhotoView)localObject).a();
    }
  }
  
  public void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_qzonecover");
    String str;
    StringBuilder localStringBuilder;
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel())
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("QzonePhotoView onGetQZoneCover isSuccess=");
        localStringBuilder.append(String.valueOf(paramBoolean));
        localStringBuilder.append(",uin=");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
      return;
    }
    if ((localObject instanceof VipPhotoViewForSimple))
    {
      localObject = (VipPhotoViewForSimple)localObject;
      if (QLog.isColorLevel())
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("VipPhotoViewForSimple onGetQZoneCover isSuccess=");
        localStringBuilder.append(String.valueOf(paramBoolean));
        localStringBuilder.append(",uin=");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
    }
  }
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ProfileHeaderView onInit");
    }
    if (paramProfileCardInfo.currentTemplate != null) {
      updateSetCardBar(paramProfileCardInfo);
    }
    this.mApp.addObserver(this.mDiyPendantObserver);
  }
  
  public void onInit(ITemplateUtils paramITemplateUtils)
  {
    this.templateUtils = paramITemplateUtils;
    onInit(this.mCardInfo);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public abstract void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void updateAvatar(AllInOne paramAllInOne)
  {
    if (paramAllInOne.pa == 33)
    {
      updateAvatar(paramAllInOne, 2, paramAllInOne.uin, false);
      return;
    }
    boolean bool = ProfilePAUtils.isPaTypeHasUin(paramAllInOne);
    int i = 1;
    if (bool)
    {
      if (((paramAllInOne.pa == 41) || (paramAllInOne.pa == 86)) && (!TextUtils.isEmpty(paramAllInOne.uin)) && (paramAllInOne.uin.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.uid)))
      {
        updateAvatar(paramAllInOne, 0, paramAllInOne.uid, false);
        return;
      }
      updateAvatar(paramAllInOne, 0, paramAllInOne.uin, true);
      return;
    }
    String str = ProfileCardUtil.a(paramAllInOne);
    if ((str != null) && (str.length() > 0))
    {
      if (paramAllInOne.pa == 53)
      {
        if (!paramAllInOne.bindQQ) {
          i = 3;
        }
        updateAvatar(paramAllInOne, i, str, false);
        return;
      }
      updateAvatar(paramAllInOne, 1, str, false);
      return;
    }
    updateAvatar(paramAllInOne, 2, paramAllInOne.uin, false);
  }
  
  public void updateAvatar(AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("updateAvatar type=%s kye=%s isDynamicMode=%s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      this.mActivity.runOnUiThread(new AbsProfileHeaderView.3(this, paramAllInOne, paramInt, paramString));
      return;
    }
    ThreadManager.post(new AbsProfileHeaderView.2(this, paramInt, paramAllInOne, paramString), 8, null, true);
  }
  
  protected void updateAvatarPendantImage(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.mPendantId = 0L;
        return;
      }
      ThreadManager.post(new AbsProfileHeaderView.7(this, paramProfileCardInfo, paramBoolean), 8, null, true);
    }
  }
  
  public void updateDetail(ProfileCardInfo paramProfileCardInfo)
  {
    View localView = (View)this.mHeaderChildMap.get("map_key_details");
    if ((localView instanceof TextView))
    {
      makeAccountDetailInfo((TextView)localView, paramProfileCardInfo);
      return;
    }
    if ((localView instanceof LinearLayout)) {
      makeAccountDetailInfoForQQCircle((LinearLayout)localView, paramProfileCardInfo);
    }
  }
  
  public void updateHead(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.mHeaderChildMap.get("map_key_profile_nick_name");
    if (localObject1 != null) {
      ((View)localObject1).setBackgroundResource(2130845924);
    }
    if ((localObject1 instanceof TextView))
    {
      TextView localTextView = (TextView)localObject1;
      Object localObject2 = paramProfileCardInfo.allInOne;
      localObject1 = paramProfileCardInfo.profileName.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append("updateHead titleName = ");
        paramProfileCardInfo.append(Utils.a((String)localObject1));
        QLog.i("Q.profilecard.FrdProfileCard", 2, paramProfileCardInfo.toString());
      }
      if (localObject1 != null)
      {
        paramProfileCardInfo = (ProfileCardInfo)localObject1;
        if (((String)localObject1).length() != 0) {}
      }
      else if (ProfilePAUtils.isPaTypeShowAccount((AllInOne)localObject2))
      {
        paramProfileCardInfo = String.valueOf(((AllInOne)localObject2).uin);
      }
      else
      {
        paramProfileCardInfo = " ";
      }
      localTextView.setText(paramProfileCardInfo);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mActivity.getString(2131691173));
      ((StringBuilder)localObject1).append(":");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramProfileCardInfo);
      localTextView.setContentDescription(((StringBuilder)localObject2).toString());
      localTextView.setTag(new DataTag(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(this.mOnClickListener);
      LongClickCopyAction.attachCopyAction(localTextView);
      return;
    }
    if ((localObject1 instanceof ProfileNameView)) {
      ((ProfileNameView)localObject1).a(this.mApp, paramProfileCardInfo);
    }
  }
  
  public void updateJueban(ProfileCardInfo paramProfileCardInfo)
  {
    View localView1 = (View)this.mHeaderChildMap.get("map_key_tag_jueban");
    View localView2 = (View)this.mHeaderChildMap.get("map_key_like");
    if (((localView1 instanceof ImageView)) && (localView2 != null) && (paramProfileCardInfo.card != null) && (isShowZan(paramProfileCardInfo)) && (ProfileCardUtil.a(paramProfileCardInfo.card.getBgTypeArray())))
    {
      localView1.setTag(new DataTag(34, null));
      localView1.setOnClickListener(this.mOnClickListener);
      localView1.setVisibility(0);
      if (paramProfileCardInfo.allInOne.pa == 0) {
        paramProfileCardInfo = "0";
      } else {
        paramProfileCardInfo = "1";
      }
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, paramProfileCardInfo, "", "", "");
    }
  }
  
  public void updateLike(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo.isTroopMemberCard) && (((TroopManager)localObject).m(paramProfileCardInfo.troopUin))) {
      return;
    }
    localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      VoteView localVoteView = (VoteView)localObject;
      boolean bool1 = isShowZan(paramProfileCardInfo);
      boolean bool2 = TextUtils.equals(paramProfileCardInfo.allInOne.uin, this.mApp.getCurrentAccountUin());
      if (bool1)
      {
        if (localVoteView.getVisibility() != 0) {
          localVoteView.setVisibility(0);
        }
        localObject = null;
        int j;
        int i;
        if (paramProfileCardInfo.card == null)
        {
          paramProfileCardInfo = this.mActivity.getString(2131691244);
          bool1 = false;
          j = 0;
          i = 0;
        }
        else
        {
          if (this.mNewVoteAnimHelper == null) {
            this.mNewVoteAnimHelper = new NewVoteAnimHelper(this.mActivity, this.mApp, 1, 1);
          }
          j = (int)paramProfileCardInfo.card.lVoteCount;
          i = paramProfileCardInfo.card.iVoteIncrement;
          this.mNewVoteAnimHelper.a = paramProfileCardInfo.card.getLastPraiseInfoList();
          if (i <= this.mNewVoteAnimHelper.a.size())
          {
            localObject = this.mNewVoteAnimHelper;
            ((NewVoteAnimHelper)localObject).a = ((NewVoteAnimHelper)localObject).a.subList(0, i);
          }
          localObject = this.mNewVoteAnimHelper;
          ((NewVoteAnimHelper)localObject).a = PraiseConfigHelper.a(((NewVoteAnimHelper)localObject).a);
          if (1 == paramProfileCardInfo.card.bVoted) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localObject = new DataTag(10, paramProfileCardInfo.card);
          if (bool2)
          {
            paramProfileCardInfo = String.format(this.mActivity.getString(2131691242), new Object[] { String.valueOf(j) });
          }
          else
          {
            String str = String.format(this.mActivity.getString(2131691155), new Object[] { String.valueOf(j) });
            if (paramProfileCardInfo.card.bAvailVoteCnt == 0) {
              localVoteView.a();
            }
            paramProfileCardInfo = str;
          }
        }
        localVoteView.a(bool2, bool1, j, i, this.mNewVoteAnimHelper, false);
        localVoteView.setTag(localObject);
        localVoteView.setOnClickListener(this.mOnClickListener);
        localVoteView.setContentDescription(paramProfileCardInfo);
        return;
      }
      localVoteView.setVisibility(4);
    }
  }
  
  public void updateLiked(ProfileCardInfo paramProfileCardInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
      }
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteView)localObject).jdField_a_of_type_Int;
      }
      if ((paramProfileCardInfo.card != null) && (paramProfileCardInfo.card.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(this.mOnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.mActivity.getString(2131691167), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void updateNickInfo(String paramString)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_profile_remark_name");
    if (localObject == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      ((View)localObject).setVisibility(8);
      return;
    }
    ((View)localObject).setVisibility(0);
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mActivity.getString(2131693338));
      localStringBuilder.append(paramString);
      ((TextView)localObject).setText(localStringBuilder.toString());
      paramString = (View)this.mHeaderChildMap.get("map_key_profile_nick_name");
      if ((paramString instanceof ProfileNameView)) {
        ((TextView)localObject).setTextColor(((ProfileNameView)paramString).a());
      }
    }
  }
  
  public void updateQidInfo(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_qid_info");
    if ((localObject instanceof QidCoolTextView))
    {
      localObject = (QidCoolTextView)localObject;
      ((QidCoolTextView)localObject).a(this.mApp, paramProfileCardInfo);
      ((QidCoolTextView)localObject).setTag(new DataTag(105, null));
    }
  }
  
  public void updateSexAgeArea(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_sex_age_area");
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      String str = ProfileCardUtil.c(this.mActivity, paramProfileCardInfo);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSexAgeArea strInfo=");
        localStringBuilder.append(Utils.a(str));
        QLog.d("Q.profilecard.FrdProfileCard", 2, localStringBuilder.toString());
      }
      if (paramProfileCardInfo.allInOne.pa == 33)
      {
        paramProfileCardInfo = this.mActivity.getString(2131699155);
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 10, 0, 0);
        ((TextView)localObject).setText(paramProfileCardInfo);
        ((TextView)localObject).setContentDescription(paramProfileCardInfo);
        return;
      }
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        paramProfileCardInfo = new StringBuilder();
        paramProfileCardInfo.append(this.mActivity.getString(2131691152));
        paramProfileCardInfo.append(":");
        paramProfileCardInfo.append(str);
        ((TextView)localObject).setContentDescription(paramProfileCardInfo.toString());
        ((TextView)localObject).setClickable(true);
        return;
      }
      if (((TextView)localObject).getVisibility() != 8) {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
  
  public void updateSign(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.isTroopMemberCard) && (((TroopManager)localObject1).m(paramProfileCardInfo.troopUin))) {
      return;
    }
    localObject1 = (View)this.mHeaderChildMap.get("map_key_sign");
    View localView = (View)this.mHeaderChildMap.get("map_key_sign_common_topic");
    if (((localObject1 instanceof TextView)) && (paramProfileCardInfo != null) && (paramProfileCardInfo.allInOne != null))
    {
      TextView localTextView = (TextView)localObject1;
      if (paramProfileCardInfo.card == null)
      {
        localTextView.setVisibility(8);
        if (localView != null) {
          localView.setVisibility(8);
        }
        return;
      }
      RichStatus localRichStatus = RichStatusUtils.Companion.getRichStatus(paramProfileCardInfo.card);
      boolean bool = ProfilePAUtils.isPaTypeHasUin(paramProfileCardInfo.allInOne);
      String str = "";
      if ((bool) && (localRichStatus != null))
      {
        if (paramProfileCardInfo.allInOne.pa == 0)
        {
          localTextView.setTag(new DataTag(3, ""));
          localTextView.setOnClickListener(this.mOnClickListener);
        }
        SpannableString localSpannableString = new SpannableString(localRichStatus.toSpannableStringWithTopic("", -8947849, -2039584, this));
        int i;
        if (!TextUtils.isEmpty(localRichStatus.actionText))
        {
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
          localSpannableStringBuilder.insert(0, "[S] ");
          localObject1 = (StatusManager)this.mApp.getManager(QQManagerFactory.STATUS_MANAGER);
          if (localObject1 != null)
          {
            localObject1 = ((StatusManager)localObject1).a(localRichStatus.actionId, 200);
          }
          else
          {
            try
            {
              localObject1 = BitmapFactory.decodeResource(getResources(), 2130849881);
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              localOutOfMemoryError.printStackTrace();
            }
            localObject2 = null;
          }
          localObject2 = new StatableBitmapDrawable(getResources(), (Bitmap)localObject2, false, false);
          i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
          ((BitmapDrawable)localObject2).setBounds(0, 0, i, i);
          localObject2 = new OffsetableImageSpan((Drawable)localObject2, 0);
          ((OffsetableImageSpan)localObject2).setOffset(-0.1F);
          localSpannableStringBuilder.setSpan(localObject2, 0, 3, 17);
          if (paramProfileCardInfo.allInOne.pa == 0) {
            localTextView.setCompoundDrawablesWithIntrinsicBounds(2130846045, 0, 0, 0);
          }
          localTextView.setText(new QQText(localSpannableStringBuilder, 1, 14));
        }
        else
        {
          localTextView.setText(new QQText(constructSignSpan(paramProfileCardInfo, localSpannableString, localTextView), 1, 14));
          i = 0;
        }
        localTextView.setMovementMethod(StateColorMovementMethod.a());
        localTextView.setVisibility(0);
        updateSignTopic(paramProfileCardInfo, localView, localTextView, localRichStatus, i, localSpannableString);
        if ((paramProfileCardInfo.allInOne.pa == 0) || (ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne))) {
          localTextView.setOnClickListener(this.mOnClickListener);
        }
        if ((ProfilePAUtils.isPaTypeFriend(paramProfileCardInfo.allInOne)) && (paramProfileCardInfo.allInOne.pa != 0)) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130846046, 0);
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mActivity.getString(2131691233));
        ((StringBuilder)localObject2).append(":");
        paramProfileCardInfo = str;
        if (!TextUtils.isEmpty(localSpannableString)) {
          paramProfileCardInfo = localSpannableString.toString();
        }
        ((StringBuilder)localObject2).append(paramProfileCardInfo);
        localTextView.setContentDescription(((StringBuilder)localObject2).toString());
        return;
      }
      if (paramProfileCardInfo.allInOne.pa == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130846045, 0, 0, 0);
        localTextView.setText(HardCodeUtil.a(2131708485));
        localTextView.setVisibility(0);
        localTextView.setTag(new DataTag(3, ""));
        localTextView.setOnClickListener(this.mOnClickListener);
        localTextView.setContentDescription(this.mActivity.getString(2131691233));
        recommendTopicViewControl(localView, true);
        return;
      }
      localTextView.setVisibility(8);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void updateTagCloud(ProfileCardInfo paramProfileCardInfo) {}
  
  public void updateTips(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.mHeaderChildMap.get("map_key_tips");
    if ((localObject instanceof LinearLayout))
    {
      localObject = (LinearLayout)localObject;
      if ((this.mTipsFlags & 0x2) != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "ProfileHeaderView updateTips setcard");
        }
        View localView = (View)this.mHeaderChildMap.get("map_key_tips_set_card");
        if (localView != null)
        {
          ((LinearLayout)localObject).removeAllViews();
          ((LinearLayout)localObject).addView(localView);
          ((LinearLayout)localObject).setVisibility(0);
          if (paramProfileCardInfo.isTroopMemberCard) {
            VasWebviewUtil.a(this.mApp.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          }
        }
      }
    }
  }
  
  public void updateUinInfo(ProfileCardInfo paramProfileCardInfo, String paramString)
  {
    paramString = (View)this.mHeaderChildMap.get("map_key_uin_info");
    if ((paramString instanceof TextView)) {
      makeAccountSimpleInfo((TextView)paramString, paramProfileCardInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */