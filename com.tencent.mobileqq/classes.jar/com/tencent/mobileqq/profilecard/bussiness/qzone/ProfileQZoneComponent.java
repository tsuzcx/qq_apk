package com.tencent.mobileqq.profilecard.bussiness.qzone;

import SummaryCard.PhotoInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.IDiyMoreInfoManager;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.UnderlineTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ProfileQZoneComponent
  extends AbsQQProfileContentComponent
  implements Handler.Callback, View.OnClickListener
{
  public static final String KEY_IMAGE_URL = "imageUrl";
  public static final String KEY_IS_VIDEO = "isVideo";
  private static final int SUBTHREAD_MSG_PERSIST_CARD = 6;
  private static final int SUBTHREAD_MSG_UPDATE_CARD = 5;
  private static final String TAG = "ProfileQZoneComponent";
  private WeakReferenceHandler mAsyncThreadHandler;
  private boolean mIsFromArkBabyQ;
  private final PreloadProcHitPluginSession mPreloadHitSession = new PreloadProcHitPluginSession("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
  private ColorDrawable mQzoneDefaultPic;
  private float mScreenWidth;
  private WeakReferenceHandler mUiHandler;
  private int qzonePicNums = 0;
  
  public ProfileQZoneComponent(IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramIComponentCenter, paramProfileCardInfo);
  }
  
  private boolean createPhotoView(QQAppInterface paramQQAppInterface, Card paramCard, ViewGroup paramViewGroup, PhotoInfo paramPhotoInfo, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    String str2 = paramPhotoInfo.strPicUrl;
    View localView2 = LayoutInflater.from(this.mActivity).inflate(2131627722, null);
    ImageView localImageView = (ImageView)localView2.findViewById(2131435741);
    View localView3 = localView2.findViewById(2131435743);
    View localView1 = localView2.findViewById(2131435740);
    View localView4 = localView2.findViewById(2131435742);
    TextView localTextView = (TextView)localView2.findViewById(2131435737);
    UnderlineTextView localUnderlineTextView = (UnderlineTextView)localView2.findViewById(2131435736);
    localUnderlineTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    Object localObject = paramPhotoInfo.mapEx;
    String str1 = "";
    boolean bool;
    if (localObject != null)
    {
      str1 = (String)paramPhotoInfo.mapEx.get("info_type");
      localObject = (String)paramPhotoInfo.mapEx.get("feeds_content");
      bool = "1".equals(paramPhotoInfo.mapEx.get("isVideo"));
    }
    else
    {
      localObject = "";
      bool = false;
    }
    int i;
    if ((TextUtils.equals(str1, "1")) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      localUnderlineTextView.setText((CharSequence)localObject);
      localUnderlineTextView.setVisibility(0);
      localImageView.setVisibility(8);
      paramQQAppInterface = localUnderlineTextView.getLayoutParams();
      paramQQAppInterface.width = paramInt1;
      paramQQAppInterface.height = paramInt1;
      i = localUnderlineTextView.getLineHeight();
      if (i > 0)
      {
        localUnderlineTextView.setMaxLines(getTextCount(paramCard));
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("makeOrRefreshQZone: invalid lineHeight:");
        paramQQAppInterface.append(i);
        QLog.w("ProfileQZoneComponent", 1, paramQQAppInterface.toString());
      }
      i = 1;
    }
    else if (!TextUtils.isEmpty(str2))
    {
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        localImageView.setColorFilter(1996488704);
      }
      if (this.mQzoneDefaultPic == null) {
        this.mQzoneDefaultPic = new ColorDrawable(this.mActivity.getResources().getColor(2131166314));
      }
      try
      {
        paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramQQAppInterface.mLoadingDrawable = this.mQzoneDefaultPic;
        paramQQAppInterface.mFailedDrawable = this.mQzoneDefaultPic;
        paramQQAppInterface.mRequestHeight = paramInt1;
        paramQQAppInterface.mRequestWidth = paramInt1;
        if ((!str2.startsWith("http://")) && (!str2.startsWith("https://")))
        {
          if (bool)
          {
            paramQQAppInterface = ShortVideoUtils.getVideoThumbnail(this.mActivity, str2, paramInt1, 0L);
            if (paramQQAppInterface != null) {
              localImageView.setImageBitmap(paramQQAppInterface);
            } else {
              localImageView.setImageDrawable(this.mQzoneDefaultPic);
            }
          }
          else
          {
            localImageView.setImageDrawable(URLDrawable.getFileDrawable(str2, paramQQAppInterface));
          }
        }
        else {
          localImageView.setImageDrawable(URLDrawable.getDrawable(str2, paramQQAppInterface));
        }
        if (str2.contains("video=1")) {
          break label796;
        }
        if (!bool) {
          break label790;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        label487:
        QLog.e("Q.profilecard.FrdProfileCard", 1, "makeOrRefreshQZone fail!", paramQQAppInterface);
      }
      setVisible(localView3, bool);
      if (paramPhotoInfo.IsOnlySelf != 1) {
        break label802;
      }
      bool = true;
    }
    for (;;)
    {
      setVisible(localView4, bool);
      break;
      break;
      i = 0;
      if (i == 0) {
        QLog.w("ProfileQZoneComponent", 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
      }
      for (;;)
      {
        return false;
        paramViewGroup.addView(localView2);
        paramQQAppInterface = localView2.getLayoutParams();
        if ((paramQQAppInterface instanceof LinearLayout.LayoutParams))
        {
          paramQQAppInterface = (LinearLayout.LayoutParams)paramQQAppInterface;
          paramQQAppInterface.rightMargin = paramInt2;
          localView2.setLayoutParams(paramQQAppInterface);
        }
        paramQQAppInterface = localImageView.getLayoutParams();
        if (isDIYTemplateProfile())
        {
          paramQQAppInterface.width = -1;
          paramQQAppInterface.height = -1;
        }
        else
        {
          paramQQAppInterface.width = paramInt1;
          paramQQAppInterface.height = paramInt1;
        }
        localImageView.setLayoutParams(paramQQAppInterface);
        paramQQAppInterface = localView1.getLayoutParams();
        if (isDIYTemplateProfile())
        {
          paramQQAppInterface.width = -1;
          paramQQAppInterface.height = -1;
        }
        else
        {
          paramQQAppInterface.width = paramInt1;
          paramQQAppInterface.height = paramInt1;
        }
        localView1.setLayoutParams(paramQQAppInterface);
        if (paramArrayOfInt[0] > 0) {
          paramArrayOfInt[0] += paramInt2;
        }
        paramArrayOfInt[0] += paramInt1;
        if (paramArrayOfInt[0] + paramInt1 + paramInt2 > paramInt3)
        {
          log(String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
          return true;
        }
        localView1.setVisibility(8);
        localTextView.setVisibility(8);
      }
      label790:
      bool = false;
      break label487;
      label796:
      bool = true;
      break label487;
      label802:
      bool = false;
    }
  }
  
  private void forwardToWriteMood()
  {
    this.mActivity.getIntent().putExtra("writeMoodFromProfileCard", true);
    QZoneHelper.forwardToWriteMood(this.mActivity, this.mApp.getCurrentAccountUin(), 1037);
    LpReportInfo_pf00064.allReport(699, 8);
    LpReportInfo_pf00064.allReport(586, 1, 6);
  }
  
  private int getColumnCount(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 3;
    }
    return 4;
  }
  
  private String getNoPhotoInfoStr(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, Card paramCard, boolean paramBoolean, ViewGroup paramViewGroup)
  {
    if ((!paramBoolean) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc))) {
      return QzoneContactsFeedUtils.a(paramCard.strQzoneFeedsDesc, paramQQAppInterface);
    }
    if (!TextUtils.isEmpty(paramCard.strSpaceName)) {
      return paramCard.strSpaceName;
    }
    String str = getGenderName(paramProfileCardInfo);
    if (paramProfileCardInfo.allInOne.pa == 0) {
      str = HardCodeUtil.a(2131906256);
    }
    str = String.format("%s%s", new Object[] { str, this.mActivity.getString(2131890922) });
    if ((paramProfileCardInfo.allInOne.pa == 0) && (paramCard.showPublishButton) && (paramViewGroup != null) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      paramViewGroup.removeAllViews();
      paramViewGroup.setVisibility(0);
      log("no photo, show writeMoodContainer view.");
      paramQQAppInterface = LayoutInflater.from(this.mActivity).inflate(2131627724, null);
      paramViewGroup.addView(paramQQAppInterface);
      paramQQAppInterface.setOnClickListener(new ProfileQZoneComponent.4(this));
      LpReportInfo_pf00064.allReport(699, 7);
    }
    return str;
  }
  
  private int getTextCount(Card paramCard)
  {
    if ((paramCard != null) && (paramCard.enlargeQzonePic == 1)) {
      return 4;
    }
    return 3;
  }
  
  private boolean isDIYTemplateProfile()
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    if (localProfileCardInfo != null) {
      return ProfileTemplateApi.isDiyTemplateStyleID(localProfileCardInfo.curUseStyleId);
    }
    return false;
  }
  
  private static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileQZoneComponent", 2, paramString);
    }
  }
  
  private boolean makeOrRefreshQZone(Card paramCard)
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    QQAppInterface localQQAppInterface = this.mQQAppInterface;
    Object localObject3 = LayoutInflater.from(this.mActivity);
    boolean bool2 = ProfilePAUtils.isPaTypeHasUin(localProfileCardInfo.allInOne);
    boolean bool1 = true;
    if ((bool2) && (paramCard != null) && (!this.mIsFromArkBabyQ) && (!ProfilePAUtils.isFromGuild(localProfileCardInfo.allInOne.pa)))
    {
      ThreadManager.post(new ProfileQZoneComponent.2(this, localProfileCardInfo), 8, null, true);
      Object localObject1 = (View)this.mViewContainer;
      if (isDIYTemplateProfile()) {
        localObject1 = null;
      }
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).getQZoneDiyView("map_key_qzone");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((LayoutInflater)localObject3).inflate(2131627721, null);
        }
        this.mViewContainer = localObject1;
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131435738);
      ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131435739);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131447238);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131435403);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      if ((paramCard.ulShowControl & 0x80) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      log(String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
      if ((!bool2) && ((paramCard.isShowPhoto()) || (paramCard.hasFakeData)) && (paramCard.hasGotPhotoUrl()))
      {
        localObject3 = paramCard.getQZonePhotoList();
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = Collections.emptyList();
        }
        if (localProfileCardInfo.allInOne.pa == 0) {
          if (((List)localObject2).size() >= this.qzonePicNums)
          {
            this.qzonePicNums = ((List)localObject2).size();
          }
          else
          {
            paramCard.hasFakeData = false;
            return true;
          }
        }
        localViewGroup1.removeAllViews();
        localViewGroup1.setVisibility(0);
        if ((localViewGroup2 != null) && (localViewGroup2.getVisibility() != 8))
        {
          localViewGroup2.removeAllViews();
          localViewGroup2.setVisibility(8);
        }
        localTextView.setVisibility(8);
        resetPhotoContainer(localQQAppInterface, localProfileCardInfo, paramCard, localViewGroup1, (List)localObject2);
        if (!TextUtils.isEmpty(paramCard.strQzoneHeader))
        {
          localTextView.setVisibility(0);
          localObject2 = getGenderName(localProfileCardInfo);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(paramCard.strQzoneHeader);
          localTextView.setText(((StringBuilder)localObject3).toString());
        }
        if (localProfileCardInfo.allInOne.pa == 0) {
          localTextView.setText(HardCodeUtil.a(2131906217));
        }
      }
      else
      {
        localViewGroup1.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText(getNoPhotoInfoStr(localQQAppInterface, localProfileCardInfo, paramCard, bool2, localViewGroup2));
      }
      if (localTextView.getText() == null) {
        localObject2 = "";
      } else {
        localObject2 = localTextView.getText().toString();
      }
      ((View)localObject1).setOnClickListener(this);
      ((View)localObject1).setContentDescription(this.mActivity.getString(2131888161));
      updateItemTheme((View)localObject1, localTextView, null, localImageView);
      if (bool1)
      {
        localObject3 = ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter);
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
          ((IDiyMoreInfoManager)localObject3).updateQzoneForDeepDiy((View)localObject1);
        }
      }
      log(String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", new Object[] { paramCard.strQzoneHeader, paramCard.strQzoneFeedsDesc, paramCard.strSpaceName, localProfileCardInfo.nameArray[4], localProfileCardInfo.nameArray[0], localObject2 }));
      return bool1;
    }
    if (this.mViewContainer == null) {
      bool1 = false;
    }
    this.mViewContainer = null;
    return bool1;
  }
  
  private void qzGoQzoneUserHomeActivity(int paramInt)
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    QQAppInterface localQQAppInterface = this.mQQAppInterface;
    if (paramInt == 7)
    {
      this.mUiHandler.post(new ProfileQZoneComponent.7(this));
      return;
    }
    Object localObject2 = localQQAppInterface.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localQQAppInterface.getCurrentNickname();
    }
    localObject2 = QZoneHelper.UserInfo.getInstance();
    ((QZoneHelper.UserInfo)localObject2).qzone_uin = localQQAppInterface.getCurrentAccountUin();
    ((QZoneHelper.UserInfo)localObject2).nickname = ((String)localObject1);
    localObject1 = localProfileCardInfo.card.vQzoneCoverInfo;
    paramInt = 0;
    if (localObject1 != null) {
      paramInt = localObject1.length;
    }
    log(String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", new Object[] { localObject1, Integer.valueOf(paramInt) }));
    QZoneHelper.forwardToUserHome(this.mActivity, (QZoneHelper.UserInfo)localObject2, localProfileCardInfo.allInOne.uin, localProfileCardInfo.allInOne.lastActivity, -1, 5, this.mPreloadHitSession, (byte[])localObject1, false);
    localObject1 = new QZoneClickReport.ReportInfo();
    ((QZoneClickReport.ReportInfo)localObject1).actionType = "1";
    ((QZoneClickReport.ReportInfo)localObject1).subactionType = "0";
    ((QZoneClickReport.ReportInfo)localObject1).tabletype = 4;
    ((QZoneClickReport.ReportInfo)localObject1).sourceType = "3";
    ((QZoneClickReport.ReportInfo)localObject1).sourceFrom = "userSummary";
    ((QZoneClickReport.ReportInfo)localObject1).sourceTo = "homePage";
    QZoneClickReport.startReportImediately(localQQAppInterface.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("source_type", "3");
    ((HashMap)localObject1).put("source_from", "userSummary");
    ((HashMap)localObject1).put("source_to", "homePage");
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(localQQAppInterface.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
  }
  
  private void resetPhotoContainer(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, Card paramCard, ViewGroup paramViewGroup, List<PhotoInfo> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject = LayoutInflater.from(this.mActivity);
    Resources localResources = this.mActivity.getResources();
    int j = localResources.getDimensionPixelSize(2131299135);
    int i = localResources.getDimensionPixelSize(2131298260);
    int k = ViewUtils.dpToPx(30.0F);
    k = (int)(this.mScreenWidth - i - k);
    i = getColumnCount(paramCard);
    int m = (int)((k - (i - 1) * j) * 1.0F) / i;
    log(String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
    if ((paramProfileCardInfo.allInOne.pa == 0) && ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) != 0))
    {
      paramProfileCardInfo = ((LayoutInflater)localObject).inflate(2131627723, null);
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        paramProfileCardInfo.setBackgroundColor(Color.parseColor("#77F5F6FA"));
      }
      paramViewGroup.addView(paramProfileCardInfo);
      localObject = paramProfileCardInfo.getLayoutParams();
      if ((localObject instanceof LinearLayout.LayoutParams))
      {
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).width = m;
        ((LinearLayout.LayoutParams)localObject).height = m;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        paramProfileCardInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      i = 0 + m;
      paramProfileCardInfo.setOnClickListener(new ProfileQZoneComponent.3(this));
      LpReportInfo_pf00064.allReport(699, 7);
    }
    else
    {
      i = 0;
    }
    paramProfileCardInfo = paramList.iterator();
    do
    {
      if (!paramProfileCardInfo.hasNext()) {
        break;
      }
    } while (!createPhotoView(paramQQAppInterface, paramCard, paramViewGroup, (PhotoInfo)paramProfileCardInfo.next(), m, j, new int[] { i }, k));
  }
  
  private static void setVisible(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      paramView.setVisibility(i);
    }
  }
  
  public String getComponentName()
  {
    return "ProfileQZoneComponent";
  }
  
  public int getComponentType()
  {
    return 1012;
  }
  
  public String getGenderName(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.mActivity == null) {
      return "他";
    }
    String str = this.mActivity.getString(2131897611);
    Object localObject = str;
    if (paramProfileCardInfo != null)
    {
      localObject = str;
      if (paramProfileCardInfo.card != null)
      {
        if (paramProfileCardInfo.card.shGender == 1) {
          paramProfileCardInfo = this.mActivity.getString(2131897610);
        } else {
          paramProfileCardInfo = this.mActivity.getString(2131897611);
        }
        localObject = paramProfileCardInfo;
      }
    }
    return localObject;
  }
  
  public String getProfileContentKey()
  {
    return "map_key_qzone";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.mQQAppInterface;
    int i = paramMessage.what;
    if (i != 5)
    {
      if (i == 6)
      {
        localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject).persist((Card)paramMessage.obj);
        ((EntityManager)localObject).close();
      }
    }
    else
    {
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      ((EntityManager)localObject).update((Card)paramMessage.obj);
      ((EntityManager)localObject).close();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1037) && (paramInt2 == -1) && (paramIntent != null) && (this.mData != null) && (((ProfileCardInfo)this.mData).allInOne != null) && (((ProfileCardInfo)this.mData).allInOne.pa == 0))
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("imageUrl");
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      {
        Object localObject = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = ((FriendsManager)localObject).f(((ProfileCardInfo)this.mData).allInOne.uin);
        }
        if (localObject != null)
        {
          ArrayList localArrayList2 = new ArrayList();
          paramInt1 = 0;
          while ((paramInt1 < localArrayList1.size()) && (paramInt1 < 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isVideo");
            localStringBuilder.append(paramInt1);
            localArrayList2.add(Boolean.valueOf(paramIntent.getBooleanExtra(localStringBuilder.toString(), false)));
            paramInt1 += 1;
          }
          ((Card)localObject).addQZonePhotoList(localArrayList1, localArrayList2);
          ((Card)localObject).hasFakeData = true;
          ((ProfileCardInfo)this.mData).card = ((Card)localObject);
          makeOrRefreshQZone(((ProfileCardInfo)this.mData).card);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    QQAppInterface localQQAppInterface = this.mQQAppInterface;
    startQzoneShowFeed();
    ThreadManager.post(new ProfileQZoneComponent.5(this, localProfileCardInfo), 8, null, true);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileEntryUtils.getProfileEntryType(localProfileCardInfo.allInOne.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(localProfileCardInfo.allInOne)), "", "", "");
    if (localProfileCardInfo.allInOne.pa == 0) {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
    } else {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
    }
    if (localProfileCardInfo.isTroopMemberCard) {
      new ReportTask(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("zone_clk").a(new String[] { localProfileCardInfo.troopUin }).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(QBaseActivity paramQBaseActivity, @Nullable Bundle paramBundle)
  {
    Intent localIntent = paramQBaseActivity.getIntent();
    if (localIntent != null) {
      this.mIsFromArkBabyQ = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.onCreate(paramQBaseActivity, paramBundle);
    paramQBaseActivity = paramQBaseActivity.getResources().getDisplayMetrics();
    this.mScreenWidth = Math.min(paramQBaseActivity.widthPixels, paramQBaseActivity.heightPixels);
    this.mAsyncThreadHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.mUiHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    ThreadManager.post(new ProfileQZoneComponent.1(this, (ProfileCardInfo)this.mData), 8, null, true);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    return super.onDataUpdate(paramProfileCardInfo) | makeOrRefreshQZone(((ProfileCardInfo)this.mData).card);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    WeakReferenceHandler localWeakReferenceHandler = this.mAsyncThreadHandler;
    if (localWeakReferenceHandler != null)
    {
      localWeakReferenceHandler.removeCallbacksAndMessages(null);
      this.mAsyncThreadHandler.removeMessages(0);
      this.mAsyncThreadHandler = null;
    }
    this.mPreloadHitSession.e();
  }
  
  public void onResume()
  {
    super.onResume();
    QQAppInterface localQQAppInterface = this.mQQAppInterface;
    if (localQQAppInterface != null)
    {
      IWebProcessManagerService localIWebProcessManagerService = (IWebProcessManagerService)localQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (localIWebProcessManagerService != null) {
        localIWebProcessManagerService.startWebProcess(-1, new ProfileQZoneComponent.WebProcessStartedListener(this.mPreloadHitSession));
      }
      QZoneHelper.preloadInFriendProfileCard(localQQAppInterface, this.mPreloadHitSession);
    }
  }
  
  public void startQzoneShowFeed()
  {
    ThreadManager.post(new ProfileQZoneComponent.6(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent
 * JD-Core Version:    0.7.0.1
 */