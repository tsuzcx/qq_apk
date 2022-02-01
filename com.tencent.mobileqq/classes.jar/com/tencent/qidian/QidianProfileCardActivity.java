package com.tencent.qidian;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.bmqq.app.BmqqBusinessObserver;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.GroupItem;
import com.tencent.qidian.data.PublicAccountItem;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigCorpSimpleInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigGroupInfo;
import com.tencent.qidian.data.QidianProfileUiInfo.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new QidianProfileCardActivity.16(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new QidianProfileCardActivity.15(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BmqqBusinessObserver jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver = new QidianProfileCardActivity.22(this);
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new QidianProfileCardActivity.19(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QidianProfileCardActivity.14(this);
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new QidianProfileCardActivity.13(this);
  public BmqqUserSimpleInfo a;
  PreloadProcHitPluginSession jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
  private ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new QidianProfileCardActivity.20(this);
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  PhotoWallViewForQiDianProfile.PhotoWallCallback jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback = new QidianProfileCardActivity.11(this);
  QidianManager jdField_a_of_type_ComTencentQidianQidianManager;
  private QidianProfileCardActivity.UiHandler jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$UiHandler;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new QidianProfileCardActivity.21(this);
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, QidianProfileCardActivity.PaGroupStruct> a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public ImageView b;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private String jdField_b_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, Drawable> b;
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 4;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  int e;
  int f;
  
  public QidianProfileCardActivity()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public static Bitmap a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    paramQQAppInterface = paramURLDrawable.getCurrDrawable();
    if (paramQQAppInterface != null)
    {
      if ((paramQQAppInterface instanceof BitmapDrawable))
      {
        paramURLDrawable = ((BitmapDrawable)paramQQAppInterface).getBitmap();
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          paramQQAppInterface = QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
      do
      {
        do
        {
          return paramQQAppInterface;
          if (!(paramQQAppInterface instanceof SkinnableBitmapDrawable)) {
            break;
          }
          paramURLDrawable = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
          paramQQAppInterface = paramURLDrawable;
        } while (!paramBoolean);
        return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        paramURLDrawable = ImageUtil.a(paramQQAppInterface);
        paramQQAppInterface = paramURLDrawable;
      } while (!paramBoolean);
      return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
    }
    return null;
  }
  
  private View a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    View localView = View.inflate(this, paramInt2, null);
    int i = getResources().getDimensionPixelSize(2131298148);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131380726);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt2 != 2131560987) {
        break label122;
      }
      localButton.setBackgroundResource(2130844564);
      localButton.setTextColor(getResources().getColor(2131166301));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
      return localButton;
      label122:
      if (paramInt2 == 2131560986)
      {
        localButton.setBackgroundResource(2130844563);
        localButton.setTextColor(getResources().getColor(2131166300));
      }
    }
  }
  
  private View a(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if ((paramConfigInfo.jdField_b_of_type_JavaLangString == null) || ((TextUtils.isEmpty(paramConfigInfo.jdField_b_of_type_JavaLangString.trim())) && (!paramConfigInfo.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709717))))) {
      return null;
    }
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = paramConfigInfo.jdField_b_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_a_of_type_Int = paramConfigInfo.jdField_a_of_type_Int;
    localQidianSimpleProfileItem.jdField_b_of_type_Int = paramConfigInfo.jdField_b_of_type_Int;
    String str;
    if (!TextUtils.isEmpty(paramConfigInfo.d))
    {
      str = paramConfigInfo.d;
      localQidianSimpleProfileItem.jdField_c_of_type_JavaLangString = str;
      if (localQidianSimpleProfileItem.jdField_b_of_type_Int == 0) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool;
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = paramConfigInfo.jdField_a_of_type_Boolean;
      return a(localQidianSimpleProfileItem);
      str = paramConfigInfo.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  private DataTag a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new DataTag(52, paramString2);
    case 2: 
      return new DataTag(4, paramString2);
    case 3: 
      return new DataTag(47, paramString2);
    case 4: 
      return new DataTag(48, new String[] { paramString1, paramString2 });
    case 7: 
      return new DataTag(54, paramString3);
    case 6: 
      return new DataTag(75, paramString2);
    case 5: 
      return new DataTag(76, paramString3);
    }
    return new DataTag(82, paramString3);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i)) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
    }
    if (this.jdField_c_of_type_Int == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName))) {
        return this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName;
      }
    }
    else if (((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 6)) && (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname)) {
        return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.uin;
      }
      return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
    }
    return this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
  }
  
  private ArrayList<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos() != null) && (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos().size() > 0))
    {
      LinearLayout localLinearLayout = (LinearLayout)getLayoutInflater().inflate(2131560982, null);
      Object localObject = (TextView)localLinearLayout.findViewById(2131379432);
      localObject = (LinearLayout)localLinearLayout.findViewById(2131365255);
      PhotoWallViewForQiDianProfile localPhotoWallViewForQiDianProfile = new PhotoWallViewForQiDianProfile(getApplicationContext());
      localPhotoWallViewForQiDianProfile.setPhotoWallCallback(this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback);
      List localList = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
      localPhotoWallViewForQiDianProfile.a(getApplicationContext(), localList);
      localPhotoWallViewForQiDianProfile.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((LinearLayout)localObject).addView(localPhotoWallViewForQiDianProfile);
      localArrayList.add(localLinearLayout);
    }
    return localArrayList;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    ThreadManager.executeOnFileThread(new QidianProfileCardActivity.ForwardRunnable(this, paramURLDrawable));
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.createMenuSheet(this);
    localActionSheet.addButton(2131693302);
    localActionSheet.addButton(2131693308);
    localActionSheet.addButton(2131698260);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new QidianProfileCardActivity.25(this, localActionSheet, paramURLDrawable, paramString));
    localActionSheet.show();
  }
  
  private void a(QidianProfileUiInfo.ConfigGroupInfo paramConfigGroupInfo)
  {
    Object localObject4 = new ArrayList();
    Object localObject3 = a();
    Object localObject5 = paramConfigGroupInfo.a;
    if (localObject5 != null)
    {
      int j = ((List)localObject5).size();
      int i = 0;
      Object localObject1 = null;
      paramConfigGroupInfo = null;
      if (i < j)
      {
        localObject2 = (QidianProfileUiInfo.ConfigInfo)((List)localObject5).get(i);
        if (localObject2 != null) {}
        switch (((QidianProfileUiInfo.ConfigInfo)localObject2).jdField_a_of_type_Int)
        {
        case 4: 
        case 5: 
        default: 
          localObject2 = localObject1;
          localObject1 = paramConfigGroupInfo;
          paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject2;
        }
        for (;;)
        {
          i += 1;
          localObject2 = localObject1;
          localObject1 = paramConfigGroupInfo;
          paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject2;
          break;
          if (i == j - 1) {}
          for (boolean bool = true;; bool = false)
          {
            ((ArrayList)localObject4).add(a((QidianProfileUiInfo.ConfigInfo)localObject2, bool));
            localObject2 = paramConfigGroupInfo;
            paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject1;
            localObject1 = localObject2;
            break;
          }
          localObject2 = b();
          paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject1;
          localObject1 = localObject2;
          continue;
          localObject2 = c();
          localObject1 = paramConfigGroupInfo;
          paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject2;
        }
      }
      Object localObject2 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (View)((Iterator)localObject2).next();
        if (localObject4 != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject4);
        }
      }
      localObject2 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        if (localObject3 != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        }
      }
      localObject2 = (LinearLayout)getLayoutInflater().inflate(2131560983, null);
      localObject3 = (LinearLayout)((LinearLayout)localObject2).findViewById(2131365255);
      localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).setMargins(ViewUtils.a(15.0F), 0, 0, 0);
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (View)((Iterator)localObject1).next();
          if (((LinearLayout)localObject3).getChildCount() > 6) {
            break;
          }
          if (localObject5 != null) {
            ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject4);
          }
        }
      }
      if (paramConfigGroupInfo != null)
      {
        paramConfigGroupInfo = paramConfigGroupInfo.iterator();
        while (paramConfigGroupInfo.hasNext())
        {
          localObject1 = (View)paramConfigGroupInfo.next();
          if (((LinearLayout)localObject3).getChildCount() > 6) {
            break;
          }
          if (localObject1 != null) {
            ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject4);
          }
        }
      }
      if (((LinearLayout)localObject3).getChildCount() > 0) {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      }
    }
  }
  
  private ArrayList<View> b()
  {
    ArrayList localArrayList = new ArrayList(6);
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (a() != null) && (a().size() > 0))
    {
      Iterator localIterator = a().iterator();
      if (localIterator.hasNext())
      {
        PublicAccountItem localPublicAccountItem = (PublicAccountItem)localIterator.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131560984, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131368603);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131372115);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364541);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365674);
        localURLImageView.post(new QidianProfileCardActivity.9(this, localPublicAccountItem, localURLImageView));
        localTextView1.setText(localPublicAccountItem.jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (localPublicAccountItem.jdField_a_of_type_Int == 0)
        {
          localTextView2.setText(2131698267);
          localRelativeLayout.setTag(new DataTag(49, localPublicAccountItem.jdField_a_of_type_JavaLangString));
          label201:
          if ((localPublicAccountItem.jdField_a_of_type_Int != 0) || (localPublicAccountItem.jdField_b_of_type_Int != 1)) {
            break label308;
          }
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130842834);
        }
        for (;;)
        {
          localArrayList.add(localRelativeLayout);
          break;
          if (localPublicAccountItem.jdField_a_of_type_Int == 1)
          {
            localTextView2.setText(2131698268);
            localRelativeLayout.setTag(new DataTag(50, localPublicAccountItem));
            break label201;
          }
          if (localPublicAccountItem.jdField_a_of_type_Int != 2) {
            break label201;
          }
          localTextView2.setText(2131698271);
          localRelativeLayout.setTag(new DataTag(106, localPublicAccountItem));
          break label201;
          label308:
          if ((localPublicAccountItem.jdField_a_of_type_Int == 1) && (localPublicAccountItem.jdField_b_of_type_Int == 1))
          {
            localImageView.setVisibility(0);
            localImageView.setBackgroundResource(2130844590);
          }
          else
          {
            localImageView.setVisibility(8);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
      str = AppConstants.SDCARD_IMG_SAVE + com.tencent.image.Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + com.tencent.image.Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            b(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131694921), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131718675)).setMessage(getString(2131694917)).setPositiveButton(getString(2131718540), new QidianProfileCardActivity.27(this, paramURLDrawable, str)).setNegativeButton(getString(2131694495), new QidianProfileCardActivity.26(this)).show();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    ThreadManager.executeOnFileThread(new QidianProfileCardActivity.SavePhotoRunnable(this, paramURLDrawable, paramString));
  }
  
  private void b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, QQMapActivity.class);
    localIntent.putExtra("lat", paramString1);
    localIntent.putExtra("lon", paramString2);
    startActivity(localIntent);
  }
  
  private boolean b()
  {
    return PackageUtil.a(getApplicationContext(), "com.tencent.mm");
  }
  
  private ArrayList<View> c()
  {
    ArrayList localArrayList = new ArrayList(6);
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (b() != null) && (b().size() > 0))
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext())
      {
        GroupItem localGroupItem = (GroupItem)localIterator.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131560984, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131368603);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131372115);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364541);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365674);
        localURLImageView.post(new QidianProfileCardActivity.10(this, localGroupItem, localURLImageView));
        localTextView1.setText(String.valueOf(localGroupItem.jdField_a_of_type_JavaLangString));
        localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView2.setText(HardCodeUtil.a(2131709716));
        localRelativeLayout.setTag(new DataTag(51, String.valueOf(localGroupItem.jdField_a_of_type_Long)));
        localImageView.setVisibility(8);
        localArrayList.add(localRelativeLayout);
      }
    }
    return localArrayList;
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131695271);
    }
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((QidianHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).c(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      }
      return;
      if (this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false))
      {
        BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1);
        this.jdField_a_of_type_ComTencentQidianQidianManager.b(this, localBmqqAccountType);
      }
      else
      {
        this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void f(int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt == 6)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        ThreadManager.post(new QidianProfileCardActivity.3(this, paramInt), 8, null, true);
      }
      return;
      if (paramInt == 1)
      {
        if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
        }
        else
        {
          i = 1;
        }
      }
      else if (paramInt != 2)
      {
        i = j;
        if (paramInt != 0) {}
      }
      else
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null) {
          i = 1;
        }
      }
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = null;
    this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = null;
    this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = null;
  }
  
  private void g(int paramInt)
  {
    Object localObject1 = "";
    Object localObject2 = "";
    String str1;
    Object localObject3;
    if ((paramInt == 1) || (paramInt == 6))
    {
      str1 = a();
      localObject3 = localObject2;
      localObject1 = str1;
      if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
        break label244;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job))
      {
        localObject2 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job;
        if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 1) {}
      }
      localObject3 = localObject2;
      localObject1 = str1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.sign)) {
        break label244;
      }
      String str2 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.sign;
      localObject1 = str1;
      localObject3 = localObject2;
      localObject2 = str2;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
      for (;;)
      {
        return;
        if (paramInt != 0)
        {
          localObject3 = localObject2;
          if (paramInt != 2) {
            break label244;
          }
        }
        str1 = a();
        localObject3 = localObject2;
        localObject1 = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null) {
          break label244;
        }
        localObject3 = localObject2;
        localObject1 = str1;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle)) {
          break label244;
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle;
        localObject2 = "";
        localObject1 = str1;
        break;
        if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity == 2) {}
        for (paramInt = 1; (paramInt != 0) && (this.jdField_b_of_type_AndroidWidgetImageView != null); paramInt = 0)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          return;
        }
      }
      label244:
      localObject2 = "";
    }
  }
  
  private void h()
  {
    Resources localResources = getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131299166) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364192));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368336));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368305));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new QidianProfileCardActivity.4(this));
    if (!SimpleUIUtil.a()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844560));
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381151));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365255));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369449));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131365157));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new QidianProfileCardActivity.5(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372115));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369888));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378181));
    findViewById(2131378197).setOnClickListener(new QidianProfileCardActivity.6(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370318));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new QidianProfileCardActivity.7(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377126));
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(new DataTag(53, null));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b();
  }
  
  private void h(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    Iterator localIterator;
    if ((paramInt == 1) || (paramInt == 6))
    {
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null) {
        localIterator = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.getConfigGroupInfos().iterator();
      }
    }
    else {
      while (localIterator.hasNext())
      {
        a((QidianProfileUiInfo.ConfigGroupInfo)localIterator.next());
        continue;
        if ((paramInt == 0) || (paramInt == 2)) {
          i();
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, 4, paramString);
    FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void i()
  {
    QidianProfileUiInfo.ConfigGroupInfo localConfigGroupInfo;
    QidianProfileUiInfo.ConfigInfo localConfigInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localConfigGroupInfo = new QidianProfileUiInfo.ConfigGroupInfo();
      localConfigGroupInfo.a = new ArrayList(5);
      new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 0;
      localConfigInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131709724);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 2;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131698038);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131719717);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 3;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131693915);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131695030);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!BmqqSegmentUtil.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!BmqqSegmentUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label428;
      }
      localConfigInfo.jdField_b_of_type_Int = 7;
      localConfigInfo.d = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localConfigGroupInfo.a.add(localConfigInfo);
      a(localConfigGroupInfo);
      return;
      label428:
      localConfigInfo.jdField_b_of_type_Int = 0;
    }
  }
  
  private void i(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
      return;
    }
    ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
  }
  
  private void j()
  {
    ThreadManager.executeOnSubThread(new QidianProfileCardActivity.12(this));
  }
  
  private void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = "https://" + paramString;
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", str);
    paramString.putExtra("isShowAd", false);
    paramString.putExtra("big_brother_source_key", "biz_src_qycp");
    startActivity(paramString);
  }
  
  private void k(String paramString)
  {
    ((ClipboardManager)getSystemService("clipboard")).setText(paramString);
    if (b())
    {
      paramString = new Intent();
      ComponentName localComponentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
      paramString.setAction("android.intent.action.MAIN");
      paramString.addCategory("android.intent.category.LAUNCHER");
      paramString.addFlags(268435456);
      paramString.setComponent(localComponentName);
      startActivity(paramString);
      return;
    }
    j("https://weixin.qq.com/d");
  }
  
  public Drawable a(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    URLDrawable localURLDrawable2;
    QQAppInterface localQQAppInterface;
    Drawable localDrawable;
    try
    {
      URLDrawable localURLDrawable1 = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable1 == null) || (localURLDrawable1.getStatus() == 2)) {
        return ImageUtil.c();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAFaceDrawable load net error, " + localException.getMessage());
        }
        localURLDrawable2 = null;
      }
      if (localURLDrawable2.getStatus() == 1)
      {
        paramURLImageView = this.app;
        if (!SimpleUIUtil.a()) {}
        for (bool = true;; bool = false) {
          return new BitmapDrawable(a(paramURLImageView, localURLDrawable2, bool));
        }
      }
      localQQAppInterface = this.app;
      localDrawable = ImageUtil.c();
      if (SimpleUIUtil.a()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramURLImageView.setURLDrawableDownListener(new QidianProfileCardActivity.DrawableListener(this, localQQAppInterface, paramURLImageView, paramString, localDrawable, bool));
      return localURLDrawable2;
    }
  }
  
  public View a(QidianProfileCardActivity.QidianSimpleProfileItem paramQidianSimpleProfileItem)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    ImageView localImageView;
    label205:
    label217:
    int i;
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709713)))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2131560981, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      Object localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131370283);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131371401);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131363843);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131377093);
      localImageView = (ImageView)((RelativeLayout)localObject1).findViewById(2131371399);
      ((ImageView)localObject5).setImageResource(2130844566);
      Object localObject6;
      if ((this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null) && (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos != null))
      {
        localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          localObject6 = (QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject5).next();
          if ((localObject6 != null) && (((QidianProfileUiInfo.ConfigGroupInfo)localObject6).a != null)) {
            break label205;
          }
        }
      }
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject4).setVisibility(4);
        ((RelativeLayout)localObject1).setLongClickable(true);
        ((RelativeLayout)localObject1).setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
        ((RelativeLayout)localObject1).setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        return localObject1;
        localObject6 = ((QidianProfileUiInfo.ConfigGroupInfo)localObject6).a.iterator();
        label495:
        label498:
        for (;;)
        {
          Object localObject7;
          if (((Iterator)localObject6).hasNext())
          {
            localObject7 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject6).next();
            if ((localObject7 == null) || (!((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709710))) || (((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo == null)) {
              continue;
            }
            ((TextView)localObject2).setText(((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.jdField_a_of_type_JavaLangString);
            ((TextView)localObject3).setText(((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.jdField_c_of_type_JavaLangString);
            ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, ((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
            this.jdField_b_of_type_JavaLangString = ((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.d;
            if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 2) {
              break label495;
            }
          }
          for (i = 1;; i = 0)
          {
            if ((i == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) || (!HttpUtil.isValidUrl(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url))) {
              break label498;
            }
            localObject7 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = getResources().getDrawable(2130844561);
            ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = getResources().getDrawable(2130844561);
            ((URLDrawable.URLDrawableOptions)localObject7).mPlayGifImage = false;
            ((URLDrawable.URLDrawableOptions)localObject7).mGifRoundCorner = 0.0F;
            ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = 20;
            ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = 20;
            localObject7 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url, (URLDrawable.URLDrawableOptions)localObject7);
            if (localImageView == null) {
              break label217;
            }
            localImageView.setMaxWidth(20);
            localImageView.setMaxHeight(20);
            localImageView.setVisibility(0);
            localImageView.setImageDrawable((Drawable)localObject7);
            break label217;
            break;
          }
        }
      }
      ((RelativeLayout)localObject1).setClickable(true);
      ((RelativeLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      return localObject1;
    }
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709707)))
    {
      i = 2130844572;
      label541:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2131560985, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131370283);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131371401);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131377093);
      localImageView = (ImageView)((RelativeLayout)localObject2).findViewById(2131371399);
      ((TextView)localObject3).setText(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      if (paramQidianSimpleProfileItem.jdField_a_of_type_Boolean) {
        break label1091;
      }
      ((ImageView)localObject4).setVisibility(4);
      ((RelativeLayout)localObject2).setLongClickable(true);
      ((RelativeLayout)localObject2).setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      ((RelativeLayout)localObject2).setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      label658:
      if (!paramQidianSimpleProfileItem.jdField_c_of_type_Boolean) {
        break label1140;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      ((ImageView)localObject1).setImageResource(i);
      localObject1 = localObject2;
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709718))) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo == null) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos == null) {
        break;
      }
      localObject3 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject3).next();
        localObject1 = localObject2;
        if (localObject4 == null) {
          break;
        }
        localObject1 = localObject2;
        if (((QidianProfileUiInfo.ConfigGroupInfo)localObject4).a == null) {
          break;
        }
        localObject1 = ((QidianProfileUiInfo.ConfigGroupInfo)localObject4).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject1).next();
          if ((localObject4 != null) && (((QidianProfileUiInfo.ConfigInfo)localObject4).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709714)))) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, ((QidianProfileUiInfo.ConfigInfo)localObject4).f + "|" + ((QidianProfileUiInfo.ConfigInfo)localObject4).g));
          }
        }
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709709)))
      {
        i = 2130844570;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709711)))
      {
        i = 2130844568;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709719)))
      {
        i = 2130846078;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709708)))
      {
        i = 2130844565;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709715)))
      {
        i = 2130844569;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709722)))
      {
        i = 2130844566;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709712)))
      {
        i = 2130844571;
        break label541;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709721))) {
        return null;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))
      {
        i = 2130844573;
        break label541;
      }
      i = 2130844567;
      break label541;
      label1091:
      ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
      ((RelativeLayout)localObject2).setClickable(true);
      ((RelativeLayout)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      break label658;
      label1140:
      localImageView.setVisibility(8);
    }
  }
  
  public List<PublicAccountItem> a()
  {
    if (this.jdField_c_of_type_Int == 6) {
      return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItemsCorp();
    }
    return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItemsUser();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299166));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void a(int paramInt, URLImageView paramURLImageView, String paramString, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramURLImageView == null)) {}
    for (;;)
    {
      return;
      if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
      {
        paramURLImageView.setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
        return;
      }
      Object localObject;
      if (paramInt == 0) {
        localObject = FaceDrawable.getFaceDrawable(this.app, 1, paramString);
      }
      while (localObject != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        paramURLImageView.setImageDrawable((Drawable)localObject);
        return;
        if ((paramInt == 1) || (paramInt == 2)) {
          localObject = a(paramURLImageView, paramString);
        } else {
          localObject = this.app.getTroopFaceDrawable(paramString);
        }
      }
    }
  }
  
  public void a(PublicAccountItem paramPublicAccountItem, int paramInt)
  {
    Object localObject = paramPublicAccountItem.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, 2131560989, null, null, getString(2131690946), getString(2131690946), new QidianProfileCardActivity.23(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(true);
    }
    if (paramInt == 50) {}
    for (paramInt = 2131698265;; paramInt = 2131698266)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(super.getString(paramInt));
      localObject = b((URLImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.framePreviewImage, (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage((Drawable)localObject, true, 1);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow() != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().findViewById(2131367459).setOnLongClickListener(new QidianProfileCardActivity.24(this, (Drawable)localObject, paramPublicAccountItem));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968586)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968586)[1]);
      }
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(super.getResources().getStringArray(2130968586)[2]);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new QidianProfileCardActivity.17(this, paramString));
    }
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianProfileCardActivity", 2, "enterNewPage content is null");
      }
      return;
    }
    Intent localIntent = new Intent(this, QidianProfileAllTextActivity.class);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("content", paramString2);
    super.startActivity(localIntent);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ThreadManager.post(new QidianProfileCardActivity.28(this, paramArrayOfByte), 8, null, true);
  }
  
  public boolean a()
  {
    if (QidianManager.a(this.jdField_b_of_type_Int)) {
      return true;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.jdField_c_of_type_Int);
    }
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      a(2131695271);
      return true;
      CrmUtils.a(this, null, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true, -1, true, -1);
    }
  }
  
  public Drawable b(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable == null) || (localURLDrawable.getStatus() == 2)) {
        return ImageUtil.c();
      }
    }
    catch (Exception localException)
    {
      Drawable localDrawable;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAQrDrawable load net error, " + localException.getMessage());
        }
        localDrawable = null;
      }
      if (localDrawable.getStatus() == 1) {
        return localDrawable;
      }
      paramURLImageView.setURLDrawableDownListener(new QidianProfileCardActivity.DrawableListener(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130851249), false));
      return localDrawable;
    }
  }
  
  public List<GroupItem> b()
  {
    if (this.jdField_c_of_type_Int == 6) {
      return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItemsCorp();
    }
    return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItemsUser();
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 6)) {}
    label306:
    for (;;)
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if (this.jdField_c_of_type_Int == 6)
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131693323, 2131560987, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(7, null));
        }
        if ((this.jdField_c_of_type_Int != 1) || (!this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label208;
        }
        a(2131698262, 2131560987, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label306;
        }
        a(2131698656, 2131560986, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(8, Integer.valueOf(this.jdField_c_of_type_Int)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        label208:
        if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          a(2131693348, 2131560987, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
        } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
          a(2131693348, 2131560987, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    EntityManager localEntityManager;
    if (paramInt == 1) {
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.find(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.find(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localEntityManager.find(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        if (localEntityManager != null) {
          localEntityManager.close();
        }
        if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {
          this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.initList();
        }
        runOnUiThread(new QidianProfileCardActivity.8(this, paramInt));
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
      if ((paramInt == 0) || (paramInt == 2)) {
        localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.find(BmqqUserSimpleInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        if (localEntityManager == null) {
          continue;
        }
        localEntityManager.close();
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.find(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.find(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        if (localEntityManager == null) {
          continue;
        }
        localEntityManager.close();
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968585)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968585)[1], 1);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968585)[2], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(super.getResources().getStringArray(2130968585)[3]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new QidianProfileCardActivity.18(this, paramString));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$UiHandler != null) {
      this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$UiHandler.sendMessage(localMessage);
    }
  }
  
  public void c(int paramInt)
  {
    g(paramInt);
    h(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "Show finish");
    }
  }
  
  public void c(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("need_finish", true);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((Friends)localObject).name))) {
        break label168;
      }
      this.jdField_a_of_type_JavaLangString = ((Friends)localObject).name;
    }
    for (;;)
    {
      localIntent.putExtra("key_nick_name", this.jdField_a_of_type_JavaLangString);
      if (this.jdField_c_of_type_Int == 6) {
        localIntent.putExtra("key_qidian_detail_url", this.jdField_b_of_type_JavaLangString);
      }
      localObject = BusinessCardUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
      localIntent = ProfileCardUtil.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
      localIntent.addFlags(536870912);
      super.startActivityForResult(localIntent, 1012);
      return;
      label168:
      if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
      }
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      Intent localIntent = new Intent(getActivity(), ChatActivity.class);
      localIntent.addFlags(67108864);
      localObject = null;
      String str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(str))
      {
        paramInt = 0;
        localObject = ContactUtils.i(this.app, str);
      }
      for (;;)
      {
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", paramInt);
        if (localObject != null) {
          localIntent.putExtra("uinname", (String)localObject);
        }
        startActivity(localIntent);
        return;
        paramInt = 1025;
      }
    }
    if (paramInt == 6)
    {
      localObject = new Intent(getActivity(), ChatActivity.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void d(String paramString)
  {
    TroopUtils.a(this, TroopInfoActivity.a(paramString, 31), 2);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 1012: 
      do
      {
        do
        {
          return;
        } while (paramIntent == null);
        if (paramIntent.getBooleanExtra("finchat", false))
        {
          super.finish();
          return;
        }
        paramIntent = paramIntent.getStringExtra("remark");
      } while (com.tencent.mobileqq.util.Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i, paramIntent));
      h(paramIntent);
      return;
    }
    super.setResult(-1);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.app);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card start " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    try
    {
      setContentView(2131560978);
      this.jdField_d_of_type_Int = AIOUtils.a(16.0F, getResources());
      this.e = AIOUtils.a(10.0F, getResources());
      this.f = AIOUtils.a(8.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramBundle, 104);
      }
      this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
    g();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$UiHandler = new QidianProfileCardActivity.UiHandler(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.post(new QidianProfileCardActivity.1(this), 8, null, true);
    e(this.jdField_c_of_type_Int);
    h();
    j();
    f(this.jdField_c_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card end " + System.currentTimeMillis());
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    g();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      e(this.jdField_c_of_type_Int);
    }
    if ((localAllInOne != null) && (!localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131693379, 1);
      return;
    }
    CrmUtils.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void f()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.a.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
    }
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_AndroidAppDialog);
  }
  
  public void f(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      super.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    }
  }
  
  public void g(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString)));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */