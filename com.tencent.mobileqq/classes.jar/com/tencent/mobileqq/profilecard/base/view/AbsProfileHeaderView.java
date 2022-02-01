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
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.profile.like.PraiseConfigHelper;
import com.tencent.mobileqq.profile.view.ProfileViewUpdate;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils;
import com.tencent.mobileqq.profilecard.bussiness.personalitysign.utils.RichStatusUtils.Companion;
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
import com.tencent.mobileqq.vas.PrettyAccountUtil;
import com.tencent.mobileqq.vas.QidCoolTextView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
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
  public BaseActivity mActivity;
  public QQAppInterface mApp;
  public ProfileCardInfo mCardInfo;
  public int mCoverTimeStamp = 0;
  public String mCoverUrl;
  protected float mDensity;
  public BusinessObserver mDiyPendantObserver = new AbsProfileHeaderView.AvatarUpdateObserver(this);
  private boolean mHasSendUpdateTips = false;
  private float mHeaderAvailableWidth;
  protected HashMap<String, View> mHeaderChildMap = new HashMap();
  protected NewVoteAnimHelper mNewVoteAnimHelper;
  public View.OnClickListener mOnClickListener;
  public long mPendantId;
  protected float mScreenHeight;
  protected float mScreenWidth;
  private AtomicBoolean mSetCardChecked = new AtomicBoolean(false);
  private int mTipsFlags = 0;
  private Handler.Callback mUICallback = new AbsProfileHeaderView.1(this);
  protected MqqWeakReferenceHandler mUIHandler;
  
  public AbsProfileHeaderView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity);
    this.mActivity = paramBaseActivity;
    this.mApp = this.mActivity.app;
    this.mCardInfo = paramProfileCardInfo;
    this.mUIHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this.mUICallback);
    paramBaseActivity = getResources().getDisplayMetrics();
    this.mDensity = paramBaseActivity.density;
    this.mScreenWidth = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.mScreenHeight = Math.max(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.mPendantId = 0L;
    this.mHeaderAvailableWidth = (this.mScreenWidth - ScreenUtil.dip2px(127.0F));
  }
  
  private void checkTips()
  {
    if ((this.mSetCardChecked.get()) && (this.mUIHandler != null) && (!this.mHasSendUpdateTips))
    {
      this.mHasSendUpdateTips = true;
      Message localMessage = this.mUIHandler.obtainMessage(1000);
      if (localMessage != null) {
        this.mUIHandler.sendMessage(localMessage);
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
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localSpannableStringBuilder.insert(0, "[S] ");
      paramProfileCardInfo = null;
    }
    try
    {
      paramSpannableString = BitmapFactory.decodeResource(getResources(), 2130846169);
      paramProfileCardInfo = paramSpannableString;
    }
    catch (OutOfMemoryError paramSpannableString)
    {
      for (;;)
      {
        int i;
        paramSpannableString.printStackTrace();
      }
    }
    catch (Throwable paramSpannableString)
    {
      for (;;)
      {
        paramSpannableString.printStackTrace();
      }
    }
    paramProfileCardInfo = new StatableBitmapDrawable(getResources(), paramProfileCardInfo, false, false);
    i = (int)(paramTextView.getTextSize() + 0.5F);
    paramProfileCardInfo.setBounds(0, 0, i, i);
    paramProfileCardInfo = new OffsetableImageSpan(paramProfileCardInfo, 0);
    paramProfileCardInfo.setOffset(-0.1F);
    localSpannableStringBuilder.setSpan(paramProfileCardInfo, 0, "[S]".length(), 17);
    return localSpannableStringBuilder;
  }
  
  private String handleNickNameAndNumber(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleNickNameAndNumber");
    }
    updateNickInfo(paramString1);
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return String.format("QQ：%s", new Object[] { paramString2 });
  }
  
  private void makeAccountDetailInfo(TextView paramTextView, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfo");
    }
    if ((paramProfileCardInfo == null) || (paramTextView == null)) {
      return;
    }
    List localList = ProfileCardUtil.a(this.mApp, this.mActivity, paramProfileCardInfo);
    boolean bool = localList.isEmpty();
    int i;
    label67:
    SpannableStringBuilder localSpannableStringBuilder;
    int n;
    Object localObject2;
    Object localObject3;
    int m;
    int j;
    int k;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(new SpannableString(this.mActivity.getString(2131699059)));
      }
      if (localList.isEmpty()) {
        break label577;
      }
      localSpannableStringBuilder = new SpannableStringBuilder();
      n = localList.size();
      localObject2 = ProfileCardUtil.a(localList, 0, n, "  ", localSpannableStringBuilder);
      localObject3 = paramTextView.getPaint();
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new TextPaint(1);
        ((TextPaint)localObject1).density = this.mDensity;
      }
      if (((TextPaint)localObject1).measureText((CharSequence)localObject2, 0, ((SpannableStringBuilder)localObject2).length() - 1) <= this.mHeaderAvailableWidth) {
        break label584;
      }
      localObject2 = new SpannableStringBuilder();
      i = 0;
      m = 1;
      label262:
      do
      {
        localObject3 = ProfileCardUtil.a(localList, i, m, "  ", localSpannableStringBuilder);
        if (((TextPaint)localObject1).measureText((CharSequence)localObject3, 0, ((SpannableStringBuilder)localObject3).length() - 1) >= this.mHeaderAvailableWidth) {
          break label471;
        }
        j = m + 1;
        k = i;
        m = j;
        i = k;
        if (k < 0) {
          break;
        }
        m = j;
        i = k;
        if (j > n) {
          break;
        }
        m = j;
        i = k;
      } while (k < j);
      i = k;
      m = j;
      label309:
      if ((m > 1) && (i < m - 1) && (m - 1 == n))
      {
        localObject1 = ProfileCardUtil.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
      }
    }
    label577:
    label584:
    for (Object localObject1 = localObject2;; localObject1 = localObject2)
    {
      localObject2 = (ViewGroup.MarginLayoutParams)((View)paramTextView.getParent()).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
      ((View)paramTextView.getParent()).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramTextView.setVisibility(0);
      paramTextView.setSingleLine(true);
      paramTextView.setText((CharSequence)localObject1);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
      paramTextView.setOnTouchListener(UITools.a);
      paramTextView.setOnClickListener(new AbsProfileHeaderView.9(this, paramProfileCardInfo));
      if (bool) {
        break;
      }
      ProfileCardUtil.a(paramTextView, null, null);
      return;
      i = 0;
      break label67;
      label471:
      if (m - i == 1)
      {
        localObject1 = ProfileCardUtil.a(localList, i, n, "  ", localSpannableStringBuilder);
        if (((SpannableStringBuilder)localObject2).length() > 0) {
          ((SpannableStringBuilder)localObject2).append("\n");
        }
        ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
        break label309;
      }
      localObject3 = ProfileCardUtil.a(localList, i, m - 1, "  ", localSpannableStringBuilder);
      if (((SpannableStringBuilder)localObject2).length() > 0) {
        ((SpannableStringBuilder)localObject2).append("\n");
      }
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject3);
      k = m - 1;
      j = m;
      break label262;
      paramTextView.setVisibility(8);
      return;
    }
  }
  
  private void makeAccountDetailInfoForQQCircle(LinearLayout paramLinearLayout, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle");
    }
    if ((paramProfileCardInfo == null) || (paramLinearLayout == null)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    List localList = ProfileCardUtil.a(this.mActivity, paramProfileCardInfo);
    boolean bool = localList.isEmpty();
    int i;
    int j;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      i = 1;
      if ((bool) && (i != 0)) {
        localList.add(android.util.Pair.create(this.mActivity.getString(2131699059), ""));
      }
      if (!localList.isEmpty())
      {
        j = localList.size();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        for (;;)
        {
          String str;
          TextView localTextView;
          if (i < j)
          {
            android.util.Pair localPair = (android.util.Pair)localList.get(i);
            str = (String)localPair.first;
            localTextView = new TextView(this.mActivity);
            localTextView.setText(str);
            localTextView.setTextColor(getResources().getColor(2131167033));
            if (!TextUtils.isEmpty((CharSequence)localPair.second))
            {
              localTextView.setBackgroundResource(2130844234);
              localTextView.setPadding(ViewUtils.b(8.0F), ViewUtils.b(4.5F), ViewUtils.b(8.0F), ViewUtils.b(4.5F));
            }
            localTextView.setTextSize(14.0F);
            paramLinearLayout.addView(localTextView);
          }
          try
          {
            ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).rightMargin = ViewUtils.b(6.0F);
            paramLinearLayout.measure(0, 0);
            QLog.d(TAG, 2, "makeAccountDetailInfoForQQCircle " + str + ", " + this.mHeaderAvailableWidth + ", " + paramLinearLayout.getMeasuredWidth());
            if (paramLinearLayout.getMeasuredWidth() > this.mHeaderAvailableWidth)
            {
              paramLinearLayout.removeView(localTextView);
              paramLinearLayout.setOnTouchListener(UITools.a);
              paramLinearLayout.setOnClickListener(new AbsProfileHeaderView.10(this, paramProfileCardInfo));
              return;
              i = 0;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
            if (!bool) {
              ProfileCardUtil.a(localTextView, null, null);
            }
            i += 1;
          }
        }
      }
    }
    paramLinearLayout.setVisibility(8);
  }
  
  private void makeAccountSimpleInfo(TextView paramTextView, ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "makeAccountDetailInfo");
    }
    if (paramTextView == null) {
      return;
    }
    if (paramProfileCardInfo == null) {}
    for (Card localCard = null; (paramProfileCardInfo == null) || (localCard == null) || (ProfileActivity.AllInOne.j(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.k(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)); localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard)
    {
      this.mHeaderChildMap.remove("map_key_uin_info");
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setVisibility(0);
    Object localObject1;
    if (paramProfileCardInfo.b)
    {
      localObject1 = ((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramProfileCardInfo.jdField_a_of_type_JavaLangString, localCard.uin);
      if ((localObject1 != null) && (TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) && (!TextUtils.isEmpty(localCard.strReMark)))
      {
        localObject1 = localCard.strNick;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label527;
        }
        localObject1 = ContactUtils.c(this.mApp, localCard.uin, false);
      }
    }
    label527:
    for (;;)
    {
      if (((TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))
      {
        localObject2 = localObject1;
        paramTextView.setVisibility(0);
        paramTextView.setSingleLine(true);
        PrettyAccountUtil.a(paramTextView, PrettyAccountUtil.a(localCard), localCard.lhLevel, (CharSequence)localObject1, localCard.uin);
        paramTextView.setOnTouchListener(UITools.a);
        paramTextView.setOnClickListener(new AbsProfileHeaderView.8(this, paramProfileCardInfo));
        ProfileCardUtil.a(paramTextView, localCard.uin, (String)localObject2);
        return;
        if (TextUtils.isEmpty(localCard.strReMark))
        {
          localObject1 = localCard.strNick;
          break;
        }
        localObject1 = localCard.strReMark;
        break;
      }
      Object localObject2 = localCard.uin;
      if (!localCard.isNoCover()) {}
      String str1;
      for (boolean bool = true;; bool = false)
      {
        str1 = handleNickNameAndNumber(paramTextView, (String)localObject1, (String)localObject2, bool);
        localObject2 = localObject1;
        localObject1 = str1;
        break;
      }
      if ((paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5])) && (!TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[5], localCard.strNick))) {}
      for (int i = 1;; i = 0)
      {
        if ((!TextUtils.isEmpty(localCard.strReMark)) || (i != 0))
        {
          localObject1 = localCard.strNick;
          localObject2 = localCard.uin;
          if (!localCard.isNoCover()) {}
          for (bool = true;; bool = false)
          {
            String str2 = handleNickNameAndNumber(paramTextView, (String)localObject1, (String)localObject2, bool);
            str1 = localCard.strNick;
            localObject2 = str1;
            localObject1 = str2;
            if (!TextUtils.isEmpty(str2)) {
              break;
            }
            localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
            localObject2 = str1;
            break;
          }
        }
        localObject1 = String.format("QQ：%s", new Object[] { localCard.uin });
        localObject2 = null;
        break;
      }
    }
  }
  
  private void openMoreDetailActivity(ProfileCardInfo paramProfileCardInfo)
  {
    int j = 2;
    if (paramProfileCardInfo != null)
    {
      ProfileCardUtil.a(paramProfileCardInfo, this.mApp, this.mActivity);
      int i = j;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
      {
        i = j;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          i = 1;
        }
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
    if ((localObject == null) || (((SigTopicConfBean)localObject).a()))
    {
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
    TextView localTextView = (TextView)paramView.findViewById(2131380421);
    ImageView localImageView = (ImageView)paramView.findViewById(2131369611);
    ArrayList localArrayList = ((SigTopicConfBean)localObject).a().a;
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
        paramView.setOnClickListener(new AbsProfileHeaderView.11(this, (String)localObject, i, paramView));
      }
      localImageView.setOnClickListener(new AbsProfileHeaderView.12(this, paramView));
      ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "2", "0", "", "");
      return;
      localObject = "";
    }
  }
  
  private void updateSetCardBar(ProfileCardInfo paramProfileCardInfo)
  {
    this.mTipsFlags &= 0xFFFFFFFD;
    this.mSetCardChecked.set(false);
    View localView = (View)this.mHeaderChildMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.mActivity, 2131562183, null);
    }
    for (;;)
    {
      if ((localView == null) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null))
      {
        this.mSetCardChecked.set(true);
        checkTips();
        return;
      }
      this.mHeaderChildMap.put("map_key_tips_set_card", localView);
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.mApp.getCurrentAccountUin().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
      {
        long l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        long l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        int i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "updateSetCardBar bgtype = " + paramProfileCardInfo);
        }
        paramProfileCardInfo = getResources();
        TextView localTextView = (TextView)localView.findViewById(2131368173);
        ImageView localImageView = (ImageView)localView.findViewById(2131368158);
        Object localObject = this.mApp.getPreferences();
        boolean bool = false;
        if (localObject != null) {
          bool = ((SharedPreferences)localObject).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "isShowTips" + bool + ",templateRet=" + i + ",myTemplateId=" + l1);
        }
        if (((101107 == i) || (101108 == i)) && (!bool) && (localObject != null))
        {
          ((SharedPreferences)localObject).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject = this.mActivity;
          if (101107 != i) {
            break label451;
          }
        }
        label451:
        for (paramProfileCardInfo = paramProfileCardInfo.getString(2131695146);; paramProfileCardInfo = paramProfileCardInfo.getString(2131719674))
        {
          paramProfileCardInfo = ((BaseActivity)localObject).getString(2131718472, new Object[] { paramProfileCardInfo });
          localTextView.setText(paramProfileCardInfo);
          localImageView.setContentDescription(paramProfileCardInfo);
          localView.setTag(new DataTag(24, Integer.valueOf(i)));
          localView.setOnClickListener(this.mOnClickListener);
          this.mTipsFlags |= 0x2;
          this.mSetCardChecked.set(true);
          checkTips();
          return;
        }
      }
      ThreadManager.post(new AbsProfileHeaderView.UpdateProfileSetCardTask(this), 5, null, true);
      return;
    }
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
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label408;
        }
        bool1 = true;
        paramTextView = (TextView)paramView.findViewById(2131380421);
        paramRichStatus = (ImageView)paramView.findViewById(2131369611);
        paramSpannableString = new oidb_0xd9f.RspBody();
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo == null)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramSpannableString.mergeFrom(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vLongNickTopicInfo);
        paramProfileCardInfo = (oidb_0xd9f.LongNickItem)paramSpannableString.longnick_item.get();
        if (paramProfileCardInfo == null) {
          break label414;
        }
        paramProfileCardInfo = paramProfileCardInfo.rpt_topic_item.get();
        if ((bool2) || (SigTopicManager.a().a(this.mApp, SigTopicManager.a().a(paramProfileCardInfo))))
        {
          if ((paramProfileCardInfo != null) && (paramProfileCardInfo.size() > 0) && (SigTopicManager.a().a(paramProfileCardInfo) > 0))
          {
            paramView.setTag(new DataTag(97, SigTopicManager.a().a(paramProfileCardInfo)));
            paramView.setOnClickListener(this.mOnClickListener);
            paramTextView.setText(HardCodeUtil.a(2131708478) + SigTopicManager.a().a(paramProfileCardInfo) + HardCodeUtil.a(2131708476));
            paramRichStatus.setOnClickListener(new AbsProfileHeaderView.6(this, paramView));
            paramView.setVisibility(0);
            ReportController.b(null, "dc00898", "", "", "0X800A4D4", "0X800A4D4", 0, 0, "1", "0", "", "");
            return;
          }
          recommendTopicViewControl(paramView, bool1);
          return;
        }
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
      recommendTopicViewControl(paramView, bool1);
      return;
      label408:
      bool1 = false;
      break;
      label414:
      paramProfileCardInfo = null;
    }
  }
  
  private void updateStaticAvatarInner(int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    int i = getResources().getDimensionPixelSize(2131297240);
    Object localObject1 = (AvatarLayout)this.mHeaderChildMap.get("map_key_face");
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = (ImageView)localObject1;
      if ((3 != paramInt) && ((localObject1 instanceof DynamicAvatarView))) {
        ((DynamicAvatarView)localObject1).e = "";
      }
      if (paramInt != 0) {
        break label280;
      }
      localObject1 = localObject4;
      if (paramAllInOne.jdField_a_of_type_Int == 0)
      {
        localObject1 = localObject4;
        if (!FaceUtil.a()) {}
      }
    }
    for (;;)
    {
      try
      {
        paramAllInOne = FaceUtil.b();
        localObject3 = new File(paramAllInOne);
        localObject1 = new BitmapFactory.Options();
        localObject3 = new FileInputStream((File)localObject3);
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)ImageUtil.a((InputStream)localObject3, i, i));
        ((InputStream)localObject3).close();
        paramAllInOne = BitmapManager.a(paramAllInOne, (BitmapFactory.Options)localObject1);
        localObject1 = paramAllInOne;
        if (paramAllInOne == null) {}
      }
      catch (Exception localException1)
      {
        paramAllInOne = localObject2;
        localObject2 = localException1;
      }
      try
      {
        localObject1 = this.mApp;
        localObject1 = QQAppInterface.getCircleFaceBitmap(paramAllInOne, paramAllInOne.getWidth(), paramAllInOne.getHeight());
        paramAllInOne = (ProfileActivity.AllInOne)localObject1;
        if (localObject1 == null) {
          paramAllInOne = this.mActivity.app.getFaceBitmap(paramString, true);
        }
        if (paramAllInOne != null) {
          this.mActivity.runOnUiThread(new AbsProfileHeaderView.4(this, paramAllInOne));
        }
        return;
      }
      catch (Exception localException2)
      {
        ProfileActivity.AllInOne localAllInOne;
        break label253;
      }
      localObject1 = ((AvatarLayout)localObject1).a(0);
      break;
      label253:
      localAllInOne = paramAllInOne;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, localObject2.toString());
        localAllInOne = paramAllInOne;
        continue;
        label280:
        if (1 == paramInt)
        {
          paramAllInOne = this.mApp.getFaceBitmap(11, paramString, (byte)3, true, 0);
        }
        else
        {
          if (3 == paramInt)
          {
            if ((localAllInOne instanceof DynamicAvatarView))
            {
              paramAllInOne = (DynamicAvatarView)localAllInOne;
              paramAllInOne.e = ContactUtils.a(this.mCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k);
              if (!ContactUtils.a(paramAllInOne.e)) {
                break label382;
              }
              paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131299116));
            }
            for (;;)
            {
              try
              {
                paramAllInOne = BitmapFactory.decodeResource(getContext().getResources(), 2130842261);
              }
              catch (OutOfMemoryError paramAllInOne)
              {
                label382:
                paramAllInOne = (ProfileActivity.AllInOne)localObject3;
              }
              paramAllInOne.setTextSize(getContext().getResources().getDimensionPixelSize(2131299117));
            }
          }
          if (2 == paramInt) {
            paramAllInOne = ImageUtil.e();
          } else {
            paramAllInOne = ImageUtil.c();
          }
        }
      }
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
    boolean bool4 = false;
    boolean bool2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null)
    {
      bool2 = true;
      bool5 = TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp.getCurrentAccountUin());
      bool6 = ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      if ((bool5) || (bool6)) {
        break label174;
      }
      if ((!bool2) || (!paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen)) {
        break label169;
      }
      bool1 = true;
    }
    label66:
    for (boolean bool3 = bool1 & bool2;; bool3 = bool2)
    {
      if (QLog.isColorLevel())
      {
        String str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (bool2) {
          bool4 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.strangerVoteOpen;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format("isShowZan updateLike show=%b uin=%sself=%b frd=%b cardOk=%b open=%b ", new Object[] { Boolean.valueOf(bool3), str, Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool2), Boolean.valueOf(bool4) }));
      }
      return bool3;
      bool2 = false;
      break;
      bool1 = false;
      break label66;
    }
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
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getResources().getDisplayMetrics();
    this.mDensity = paramConfiguration.density;
    this.mScreenWidth = Math.min(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
    this.mScreenHeight = Math.max(paramConfiguration.widthPixels, paramConfiguration.heightPixels);
  }
  
  public void onDestroy()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.mDiyPendantObserver);
    }
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
    View localView = (View)this.mHeaderChildMap.get("map_key_qzonecover");
    if ((localView instanceof QzonePhotoView)) {
      ((QzonePhotoView)localView).a();
    }
  }
  
  public void onGetQZoneCover(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_qzonecover");
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
      }
      ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
    }
    while (!(localObject instanceof VipPhotoViewForSimple)) {
      return;
    }
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_photo_wall_rsp);
  }
  
  public void onInit()
  {
    onInit(this.mCardInfo);
  }
  
  protected void onInit(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "ProfileHeaderView onInit");
    }
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) {
      updateSetCardBar(paramProfileCardInfo);
    }
    this.mApp.addObserver(this.mDiyPendantObserver);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public abstract void onUpdate(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnClickListener = paramOnClickListener;
  }
  
  public void updateAvatar(ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 1;
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      updateAvatar(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
      return;
    }
    if (ProfileActivity.AllInOne.g(paramAllInOne))
    {
      if (((paramAllInOne.jdField_a_of_type_Int == 41) || (paramAllInOne.jdField_a_of_type_Int == 86)) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.p)))
      {
        updateAvatar(paramAllInOne, 0, paramAllInOne.p, false);
        return;
      }
      updateAvatar(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString, true);
      return;
    }
    String str = ProfileCardUtil.a(paramAllInOne);
    if ((str != null) && (str.length() > 0))
    {
      if (paramAllInOne.jdField_a_of_type_Int == 53)
      {
        if (paramAllInOne.b) {}
        for (;;)
        {
          updateAvatar(paramAllInOne, i, str, false);
          return;
          i = 3;
        }
      }
      updateAvatar(paramAllInOne, 1, str, false);
      return;
    }
    updateAvatar(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString, false);
  }
  
  public void updateAvatar(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, String.format("updateAvatar type=%s kye=%s isDynamicMode=%s", new Object[] { Integer.valueOf(paramInt), paramString, Boolean.valueOf(paramBoolean) }));
    }
    if ((!paramBoolean) || (paramInt != 0))
    {
      ThreadManager.post(new AbsProfileHeaderView.2(this, paramInt, paramAllInOne, paramString), 8, null, true);
      return;
    }
    this.mActivity.runOnUiThread(new AbsProfileHeaderView.3(this, paramAllInOne, paramInt, paramString));
  }
  
  protected void updateAvatarPendantImage(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_avatar_pendant");
    if ((localObject instanceof ImageView))
    {
      localObject = (ImageView)localObject;
      if (!ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        ((ImageView)localObject).setVisibility(4);
        this.mPendantId = 0L;
      }
    }
    else
    {
      return;
    }
    ThreadManager.post(new AbsProfileHeaderView.7(this, paramProfileCardInfo, paramBoolean), 8, null, true);
  }
  
  public void updateDetail(ProfileCardInfo paramProfileCardInfo)
  {
    View localView = (View)this.mHeaderChildMap.get("map_key_details");
    if ((localView instanceof TextView)) {
      makeAccountDetailInfo((TextView)localView, paramProfileCardInfo);
    }
    while (!(localView instanceof LinearLayout)) {
      return;
    }
    makeAccountDetailInfoForQQCircle((LinearLayout)localView, paramProfileCardInfo);
  }
  
  public void updateHead(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_profile_nick_name");
    if (localObject != null) {
      ((View)localObject).setBackgroundResource(2130846050);
    }
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + Utils.a((String)localObject));
      }
      if (localObject != null)
      {
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label213;
        }
        paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);
      }
      localTextView.setText(paramProfileCardInfo);
      localObject = this.mActivity.getString(2131691252) + ":";
      localTextView.setContentDescription((String)localObject + paramProfileCardInfo);
      localTextView.setTag(new DataTag(88, localTextView.getText().toString()));
      localTextView.setOnClickListener(this.mOnClickListener);
      LongClickCopyAction.attachCopyAction(localTextView);
    }
    label213:
    while (!(localObject instanceof ProfileNameView)) {
      for (;;)
      {
        TextView localTextView;
        ProfileActivity.AllInOne localAllInOne;
        return;
        paramProfileCardInfo = " ";
      }
    }
    ((ProfileNameView)localObject).a(this.mApp, paramProfileCardInfo);
  }
  
  public void updateJueban(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_tag_jueban");
    View localView = (View)this.mHeaderChildMap.get("map_key_like");
    if (((localObject instanceof ImageView)) && (localView != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (isShowZan(paramProfileCardInfo)) && (ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      ((View)localObject).setTag(new DataTag(34, null));
      ((View)localObject).setOnClickListener(this.mOnClickListener);
      ((View)localObject).setVisibility(0);
      localObject = "1";
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
        localObject = "0";
      }
      ReportController.b(this.mApp, "CliOper", "", "", "card_mall", "0X8007A47", 0, 0, (String)localObject, "", "", "");
    }
  }
  
  public void updateLike(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo.b) && (((TroopManager)localObject).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      localObject = (View)this.mHeaderChildMap.get("map_key_like");
    } while (!(localObject instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject;
    boolean bool1 = isShowZan(paramProfileCardInfo);
    boolean bool2 = TextUtils.equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.mApp.getCurrentAccountUin());
    if (bool1)
    {
      if (localVoteView.getVisibility() != 0) {
        localVoteView.setVisibility(0);
      }
      int i;
      int j;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)
      {
        paramProfileCardInfo = this.mActivity.getString(2131691323);
        localObject = null;
        i = 0;
        j = 0;
        bool1 = false;
      }
      for (;;)
      {
        localVoteView.a(bool2, bool1, i, j, this.mNewVoteAnimHelper, false);
        localVoteView.setTag(localObject);
        localVoteView.setOnClickListener(this.mOnClickListener);
        localVoteView.setContentDescription(paramProfileCardInfo);
        return;
        if (this.mNewVoteAnimHelper == null) {
          this.mNewVoteAnimHelper = new NewVoteAnimHelper(this.mActivity, this.mApp, 1, 1);
        }
        i = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
        j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
        this.mNewVoteAnimHelper.a = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getLastPraiseInfoList();
        if (j <= this.mNewVoteAnimHelper.a.size()) {
          this.mNewVoteAnimHelper.a = this.mNewVoteAnimHelper.a.subList(0, j);
        }
        this.mNewVoteAnimHelper.a = PraiseConfigHelper.a(this.mNewVoteAnimHelper.a);
        if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
        for (bool1 = true;; bool1 = false)
        {
          localObject = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          if (!bool2) {
            break label358;
          }
          paramProfileCardInfo = String.format(this.mActivity.getString(2131691321), new Object[] { String.valueOf(i) });
          break;
        }
        label358:
        String str = String.format(this.mActivity.getString(2131691234), new Object[] { String.valueOf(i) });
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0) {
          localVoteView.a();
        }
        paramProfileCardInfo = str;
      }
    }
    localVoteView.setVisibility(4);
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
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bAvailVoteCnt == 0)) {
        ((VoteView)localObject).a();
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null, paramBoolean);
      ((VoteView)localObject).setOnClickListener(this.mOnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.mActivity.getString(2131691246), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void updateNickInfo(String paramString)
  {
    Object localObject = (View)this.mHeaderChildMap.get("map_key_profile_remark_name");
    if (localObject == null) {}
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(paramString))
        {
          ((View)localObject).setVisibility(8);
          return;
        }
        ((View)localObject).setVisibility(0);
      } while (!(localObject instanceof TextView));
      localObject = (TextView)localObject;
      ((TextView)localObject).setText(this.mActivity.getString(2131693383) + paramString);
      paramString = (View)this.mHeaderChildMap.get("map_key_profile_nick_name");
    } while (!(paramString instanceof ProfileNameView));
    ((TextView)localObject).setTextColor(((ProfileNameView)paramString).a());
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
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = ProfileCardUtil.c(this.mActivity, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + Utils.a(str));
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label126;
      }
      paramProfileCardInfo = this.mActivity.getString(2131699051);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramProfileCardInfo);
      ((TextView)localObject).setContentDescription(paramProfileCardInfo);
    }
    label126:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.mActivity.getString(2131691231) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void updateSign(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (TroopManager)this.mApp.getManager(QQManagerFactory.TROOP_MANAGER);
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.b) && (((TroopManager)localObject1).n(paramProfileCardInfo.jdField_a_of_type_JavaLangString))) {}
    View localView;
    TextView localTextView;
    RichStatus localRichStatus;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = (View)this.mHeaderChildMap.get("map_key_sign");
          localView = (View)this.mHeaderChildMap.get("map_key_sign_common_topic");
        } while ((!(localObject1 instanceof TextView)) || (paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null));
        localTextView = (TextView)localObject1;
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
          break;
        }
        localTextView.setVisibility(8);
      } while (localView == null);
      localView.setVisibility(8);
      return;
      localRichStatus = RichStatusUtils.Companion.getRichStatus(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
      if ((ProfileActivity.AllInOne.g(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localRichStatus != null)) {
        break;
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130846169, 0, 0, 0);
        localTextView.setText(HardCodeUtil.a(2131708479));
        localTextView.setVisibility(0);
        localTextView.setTag(new DataTag(3, ""));
        localTextView.setOnClickListener(this.mOnClickListener);
        localTextView.setContentDescription(this.mActivity.getString(2131691312));
        recommendTopicViewControl(localView, true);
        return;
      }
      localTextView.setVisibility(8);
    } while (localView == null);
    localView.setVisibility(8);
    return;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
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
        localObject1 = new StatableBitmapDrawable(getResources(), (Bitmap)localObject1, false, false);
        i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
        ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
        localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
        ((OffsetableImageSpan)localObject1).setOffset(-0.1F);
        localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
        if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(2130846169, 0, 0, 0);
        }
        localTextView.setText(new QQText(localSpannableStringBuilder, 1, 14));
        label478:
        localTextView.setMovementMethod(StateColorMovementMethod.a());
        localTextView.setVisibility(0);
        updateSignTopic(paramProfileCardInfo, localView, localTextView, localRichStatus, i, localSpannableString);
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))) {
          localTextView.setOnClickListener(this.mOnClickListener);
        }
        if ((ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0)) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130846170, 0);
        }
        localObject1 = new StringBuilder().append(this.mActivity.getString(2131691312)).append(":");
        if (TextUtils.isEmpty(localSpannableString)) {
          break label684;
        }
      }
    }
    label684:
    for (paramProfileCardInfo = localSpannableString.toString();; paramProfileCardInfo = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramProfileCardInfo);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130849983);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          Object localObject3 = null;
        }
      }
      break;
      localTextView.setText(new QQText(constructSignSpan(paramProfileCardInfo, localSpannableString, localTextView), 1, 14));
      i = 0;
      break label478;
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
          if (paramProfileCardInfo.b) {
            VasWebviewUtil.reportCommercialDrainage(this.mApp.getCurrentAccountUin(), "group_card", "guide_show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */