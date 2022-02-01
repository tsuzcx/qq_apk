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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.vas.misc.DiyMoreInfoViewHelper;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  extends AbsProfileContentComponent
  implements Handler.Callback, View.OnClickListener
{
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
    String str3 = paramPhotoInfo.strPicUrl;
    View localView2 = LayoutInflater.from(this.mActivity).inflate(2131561525, null);
    ImageView localImageView = (ImageView)localView2.findViewById(2131369099);
    View localView3 = localView2.findViewById(2131369101);
    View localView1 = localView2.findViewById(2131369098);
    View localView4 = localView2.findViewById(2131369100);
    TextView localTextView = (TextView)localView2.findViewById(2131369095);
    UnderlineTextView localUnderlineTextView = (UnderlineTextView)localView2.findViewById(2131369094);
    localUnderlineTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    String str2 = "";
    String str1 = "";
    boolean bool = false;
    if (paramPhotoInfo.mapEx != null)
    {
      str2 = (String)paramPhotoInfo.mapEx.get("info_type");
      str1 = (String)paramPhotoInfo.mapEx.get("feeds_content");
      bool = "1".equals(paramPhotoInfo.mapEx.get("isVideo"));
    }
    int i;
    if ((TextUtils.equals(str2, "1")) && (!TextUtils.isEmpty(str1)))
    {
      localUnderlineTextView.setText(str1);
      localUnderlineTextView.setVisibility(0);
      localImageView.setVisibility(8);
      paramQQAppInterface = localUnderlineTextView.getLayoutParams();
      paramQQAppInterface.width = paramInt1;
      paramQQAppInterface.height = paramInt1;
      i = localUnderlineTextView.getLineHeight();
      if (i > 0) {
        localUnderlineTextView.setMaxLines(getTextCount(paramCard));
      }
      for (;;)
      {
        i = 1;
        if (i != 0) {
          break;
        }
        QLog.w("ProfileQZoneComponent", 1, "makeOrRefreshQZone: needUpdateUI=false,skip this one");
        return false;
        QLog.w("ProfileQZoneComponent", 1, "makeOrRefreshQZone: invalid lineHeight:" + i);
      }
    }
    if (!TextUtils.isEmpty(str3))
    {
      if (ThemeUtil.isInNightMode(paramQQAppInterface)) {
        localImageView.setColorFilter(1996488704);
      }
      if (this.mQzoneDefaultPic == null) {
        this.mQzoneDefaultPic = new ColorDrawable(this.mActivity.getResources().getColor(2131165731));
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = URLDrawable.URLDrawableOptions.obtain();
        paramQQAppInterface.mLoadingDrawable = this.mQzoneDefaultPic;
        paramQQAppInterface.mFailedDrawable = this.mQzoneDefaultPic;
        paramQQAppInterface.mRequestHeight = paramInt1;
        paramQQAppInterface.mRequestWidth = paramInt1;
        if ((str3.startsWith("http://")) || (str3.startsWith("https://")))
        {
          localImageView.setImageDrawable(URLDrawable.getDrawable(str3, paramQQAppInterface));
          if (str3.contains("video=1")) {
            break label787;
          }
          if (!bool) {
            break label533;
          }
          break label787;
          setVisible(localView3, bool);
          if (paramPhotoInfo.IsOnlySelf != 1) {
            break label539;
          }
          bool = true;
          setVisible(localView4, bool);
          i = 1;
          break;
        }
        if (!bool) {
          break label519;
        }
        paramQQAppInterface = ShortVideoUtils.getVideoThumbnail(this.mActivity, str3, paramInt1, 0L);
        if (paramQQAppInterface != null)
        {
          localImageView.setImageBitmap(paramQQAppInterface);
          continue;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("Q.profilecard.FrdProfileCard", 1, "makeOrRefreshQZone fail!", paramQQAppInterface);
        i = 1;
      }
      localImageView.setImageDrawable(this.mQzoneDefaultPic);
      continue;
      label519:
      localImageView.setImageDrawable(URLDrawable.getFileDrawable(str3, paramQQAppInterface));
      continue;
      label533:
      bool = false;
      continue;
      label539:
      bool = false;
      continue;
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
        localImageView.setLayoutParams(paramQQAppInterface);
        paramQQAppInterface = localView1.getLayoutParams();
        if (!isDIYTemplateProfile()) {
          break label750;
        }
        paramQQAppInterface.width = -1;
      }
      for (paramQQAppInterface.height = -1;; paramQQAppInterface.height = paramInt1)
      {
        localView1.setLayoutParams(paramQQAppInterface);
        if (paramArrayOfInt[0] > 0) {
          paramArrayOfInt[0] += paramInt2;
        }
        paramArrayOfInt[0] += paramInt1;
        if (paramArrayOfInt[0] + paramInt1 + paramInt2 <= paramInt3) {
          break label765;
        }
        log(String.format(Locale.getDefault(), "makeOrRefreshQZone cur:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(paramArrayOfInt[0]), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
        return true;
        paramQQAppInterface.width = paramInt1;
        paramQQAppInterface.height = paramInt1;
        break;
        label750:
        paramQQAppInterface.width = paramInt1;
      }
      label765:
      localView1.setVisibility(8);
      localTextView.setVisibility(8);
      return false;
      i = 0;
      break;
      label787:
      bool = true;
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
    Object localObject;
    if ((!paramBoolean) && (paramCard.isShowFeeds()) && (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc))) {
      localObject = QzoneContactsFeedUtils.a(paramCard.strQzoneFeedsDesc, paramQQAppInterface);
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject;
            if (!TextUtils.isEmpty(paramCard.strSpaceName)) {
              return paramCard.strSpaceName;
            }
            localObject = getGenderName(paramProfileCardInfo);
            if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              localObject = HardCodeUtil.a(2131708464);
            }
            str = String.format("%s%s", new Object[] { localObject, this.mActivity.getString(2131693418) });
            localObject = str;
          } while (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0);
          localObject = str;
        } while (!paramCard.showPublishButton);
        localObject = str;
      } while (paramViewGroup == null);
      localObject = str;
    } while ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) == 0);
    paramViewGroup.removeAllViews();
    paramViewGroup.setVisibility(0);
    log("no photo, show writeMoodContainer view.");
    paramQQAppInterface = LayoutInflater.from(this.mActivity).inflate(2131561527, null);
    paramViewGroup.addView(paramQQAppInterface);
    paramQQAppInterface.setOnClickListener(new ProfileQZoneComponent.4(this));
    LpReportInfo_pf00064.allReport(699, 7);
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
      return ProfileCardTemplate.a(localProfileCardInfo.jdField_a_of_type_Long);
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
    QQAppInterface localQQAppInterface = this.mApp;
    Object localObject3 = LayoutInflater.from(this.mActivity);
    if ((!ProfileActivity.AllInOne.g(localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (this.mIsFromArkBabyQ))
    {
      if (this.mViewContainer != null) {}
      for (bool1 = true;; bool1 = false)
      {
        this.mViewContainer = null;
        return bool1;
      }
    }
    ThreadManager.post(new ProfileQZoneComponent.2(this, localProfileCardInfo), 8, null, true);
    Object localObject1 = (View)this.mViewContainer;
    if (isDIYTemplateProfile()) {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = this.mDiyHelper.getDiyView("map_key_qzone");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((LayoutInflater)localObject3).inflate(2131561524, null);
      }
      this.mViewContainer = localObject1;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ViewGroup localViewGroup1 = (ViewGroup)((View)localObject1).findViewById(2131369096);
      ViewGroup localViewGroup2 = (ViewGroup)((View)localObject1).findViewById(2131369097);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131379248);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131368771);
      localTextView.setSingleLine(true);
      localTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      boolean bool2;
      if ((paramCard.ulShowControl & 0x80) != 0)
      {
        bool2 = true;
        log(String.format("makeOrRefreshQZone card.ulShowControl=%x hasLocked=%s", new Object[] { Integer.valueOf(paramCard.ulShowControl), Boolean.valueOf(bool2) }));
        if ((bool2) || ((!paramCard.isShowPhoto()) && (!paramCard.hasFakeData)) || (!paramCard.hasGotPhotoUrl())) {
          break label589;
        }
        localObject3 = paramCard.getQZonePhotoList();
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = Collections.emptyList();
        }
        if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          if (((List)localObject2).size() < this.qzonePicNums) {
            break label582;
          }
          this.qzonePicNums = ((List)localObject2).size();
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
          localTextView.setText(String.format("%s%s", new Object[] { getGenderName(localProfileCardInfo), this.mActivity.getString(2131693418) }));
        }
        if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          localTextView.setText(HardCodeUtil.a(2131708425));
        }
        label471:
        if (localTextView.getText() != null) {
          break label622;
        }
      }
      label582:
      label589:
      label622:
      for (localObject2 = "";; localObject2 = localTextView.getText().toString())
      {
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setContentDescription(this.mActivity.getString(2131691294));
        updateItemTheme((View)localObject1, localTextView, null, localImageView);
        log(String.format("makeOrRefreshQZone, [h:%s, des: %s, space: %s, remark: %s, nick: %s, info: %s]", new Object[] { paramCard.strQzoneHeader, paramCard.strQzoneFeedsDesc, paramCard.strSpaceName, localProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4], localProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0], localObject2 }));
        return bool1;
        bool2 = false;
        break;
        paramCard.hasFakeData = false;
        return true;
        localViewGroup1.setVisibility(8);
        localTextView.setVisibility(0);
        localTextView.setText(getNoPhotoInfoStr(localQQAppInterface, localProfileCardInfo, paramCard, bool2, localViewGroup2));
        break label471;
      }
    }
  }
  
  private void qzGoQzoneUserHomeActivity(int paramInt)
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    QQAppInterface localQQAppInterface = this.mApp;
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
    localObject1 = localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.vQzoneCoverInfo;
    if (localObject1 == null) {}
    for (paramInt = 0;; paramInt = localObject1.length)
    {
      log(String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", new Object[] { localObject1, Integer.valueOf(paramInt) }));
      QZoneHelper.forwardToUserHome(this.mActivity, (QZoneHelper.UserInfo)localObject2, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g, -1, 5, this.mPreloadHitSession, (byte[])localObject1, false);
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
      return;
    }
  }
  
  private void resetPhotoContainer(QQAppInterface paramQQAppInterface, ProfileCardInfo paramProfileCardInfo, Card paramCard, ViewGroup paramViewGroup, List<PhotoInfo> paramList)
  {
    label10:
    int j;
    int i;
    int k;
    int m;
    if (paramList.isEmpty())
    {
      return;
    }
    else
    {
      Object localObject = LayoutInflater.from(this.mActivity);
      Resources localResources = this.mActivity.getResources();
      j = localResources.getDimensionPixelSize(2131298426);
      i = localResources.getDimensionPixelSize(2131297605);
      k = ViewUtils.b(30.0F);
      k = (int)(this.mScreenWidth - i - k);
      i = getColumnCount(paramCard);
      m = (int)((k - (i - 1) * j) * 1.0F) / i;
      log(String.format(Locale.getDefault(), "makeOrRefreshQZone count:%s, photo:%s, margin:%s, max: %s", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k) }));
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || ((LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, paramQQAppInterface.getLongAccountUin()) & 0x4000) == 0)) {
        break label338;
      }
      paramProfileCardInfo = ((LayoutInflater)localObject).inflate(2131561526, null);
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
    for (;;)
    {
      paramProfileCardInfo = paramList.iterator();
      if (!paramProfileCardInfo.hasNext()) {
        break label10;
      }
      if (!createPhotoView(paramQQAppInterface, paramCard, paramViewGroup, (PhotoInfo)paramProfileCardInfo.next(), m, j, new int[] { i }, k)) {
        break;
      }
      return;
      label338:
      i = 0;
    }
  }
  
  private static void setVisible(View paramView, boolean paramBoolean)
  {
    if (paramView != null) {
      if (!paramBoolean) {
        break label16;
      }
    }
    label16:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
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
    Object localObject;
    if (this.mActivity == null) {
      localObject = "他";
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = this.mActivity.getString(2131699475);
        localObject = str;
      } while (paramProfileCardInfo == null);
      localObject = str;
    } while (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.shGender == 1) {
      return this.mActivity.getString(2131699474);
    }
    return this.mActivity.getString(2131699475);
  }
  
  public String getProfileContentKey()
  {
    return "map_key_qzone";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.mApp;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      ((EntityManager)localObject).update((Card)paramMessage.obj);
      ((EntityManager)localObject).close();
      continue;
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      ((EntityManager)localObject).persist((Card)paramMessage.obj);
      ((EntityManager)localObject).close();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1037) && (paramInt2 == -1) && (paramIntent != null) && (this.mData != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("imageUrl");
      if ((localArrayList1 != null) && (localArrayList1.size() > 0))
      {
        Object localObject = (FriendsManager)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localObject == null) {
          localObject = null;
        }
        while (localObject != null)
        {
          ArrayList localArrayList2 = new ArrayList();
          paramInt1 = 0;
          for (;;)
          {
            if ((paramInt1 < localArrayList1.size()) && (paramInt1 < 3))
            {
              localArrayList2.add(Boolean.valueOf(paramIntent.getBooleanExtra("isVideo" + paramInt1, false)));
              paramInt1 += 1;
              continue;
              localObject = ((FriendsManager)localObject).a(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              break;
            }
          }
          ((Card)localObject).addQZonePhotoList(localArrayList1, localArrayList2);
          ((Card)localObject).hasFakeData = true;
          ((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard = ((Card)localObject);
          makeOrRefreshQZone(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)this.mData;
    QQAppInterface localQQAppInterface = this.mApp;
    startQzoneShowFeed();
    ThreadManager.post(new ProfileQZoneComponent.5(this, localProfileCardInfo), 8, null, true);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
    if (localProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006A7C", "0X8006A7C", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (localProfileCardInfo.b) {
        new ReportTask(localQQAppInterface).a("dc00899").b("Grp_mem_card").c("page").d("zone_clk").a(new String[] { localProfileCardInfo.jdField_a_of_type_JavaLangString }).a();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006A90", "0X8006A90", 0, 0, "", "", "", "");
    }
  }
  
  public void onCreate(@NonNull BaseActivity paramBaseActivity, @Nullable Bundle paramBundle)
  {
    Intent localIntent = paramBaseActivity.getIntent();
    if (localIntent != null) {
      this.mIsFromArkBabyQ = localIntent.getBooleanExtra("key_from_ark_babyq", false);
    }
    super.onCreate(paramBaseActivity, paramBundle);
    paramBaseActivity = paramBaseActivity.getResources().getDisplayMetrics();
    this.mScreenWidth = Math.min(paramBaseActivity.widthPixels, paramBaseActivity.heightPixels);
    this.mAsyncThreadHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    this.mUiHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
    ThreadManager.post(new ProfileQZoneComponent.1(this, (ProfileCardInfo)this.mData), 8, null, true);
  }
  
  public boolean onDataUpdate(ProfileCardInfo paramProfileCardInfo)
  {
    boolean bool = super.onDataUpdate(paramProfileCardInfo);
    return makeOrRefreshQZone(((ProfileCardInfo)this.mData).jdField_a_of_type_ComTencentMobileqqDataCard) | bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mAsyncThreadHandler != null)
    {
      this.mAsyncThreadHandler.removeCallbacksAndMessages(null);
      this.mAsyncThreadHandler.removeMessages(0);
      this.mAsyncThreadHandler = null;
    }
    this.mPreloadHitSession.d();
  }
  
  public void onResume()
  {
    super.onResume();
    QQAppInterface localQQAppInterface = this.mApp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent
 * JD-Core Version:    0.7.0.1
 */