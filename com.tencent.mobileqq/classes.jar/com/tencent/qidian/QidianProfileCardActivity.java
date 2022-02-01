package com.tencent.qidian;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
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
import com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo = new ProfileCardInfo();
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
          return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
      else if ((paramQQAppInterface instanceof SkinnableBitmapDrawable))
      {
        paramURLDrawable = ((SkinnableBitmapDrawable)paramQQAppInterface).getBitmap();
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
      else
      {
        paramURLDrawable = ImageUtil.a(paramQQAppInterface);
        paramQQAppInterface = paramURLDrawable;
        if (paramBoolean) {
          return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
        }
      }
    }
    else {
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  private View a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    View localView = View.inflate(this, paramInt2, null);
    int i = getResources().getDimensionPixelSize(2131298142);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131379994);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.jdField_a_of_type_Boolean) {
      if (paramInt2 == 2131560862)
      {
        localButton.setBackgroundResource(2130844470);
        localButton.setTextColor(getResources().getColor(2131166312));
      }
      else if (paramInt2 == 2131560861)
      {
        localButton.setBackgroundResource(2130844469);
        localButton.setTextColor(getResources().getColor(2131166311));
      }
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localButton;
  }
  
  private View a(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if ((paramConfigInfo.jdField_b_of_type_JavaLangString != null) && ((!TextUtils.isEmpty(paramConfigInfo.jdField_b_of_type_JavaLangString.trim())) || (paramConfigInfo.jdField_c_of_type_Int == 11) || (paramConfigInfo.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709704)))))
    {
      QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
      localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
      localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = paramConfigInfo.jdField_b_of_type_JavaLangString;
      localQidianSimpleProfileItem.jdField_a_of_type_Int = paramConfigInfo.jdField_a_of_type_Int;
      localQidianSimpleProfileItem.jdField_b_of_type_Int = paramConfigInfo.jdField_b_of_type_Int;
      String str;
      if (!TextUtils.isEmpty(paramConfigInfo.d)) {
        str = paramConfigInfo.d;
      } else {
        str = paramConfigInfo.jdField_c_of_type_JavaLangString;
      }
      localQidianSimpleProfileItem.jdField_c_of_type_JavaLangString = str;
      boolean bool;
      if (localQidianSimpleProfileItem.jdField_b_of_type_Int != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool;
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = paramConfigInfo.jdField_a_of_type_Boolean;
      localQidianSimpleProfileItem.jdField_c_of_type_Int = paramConfigInfo.jdField_c_of_type_Int;
      return a(localQidianSimpleProfileItem);
    }
    return null;
  }
  
  private DataTag a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 9: 
      return new DataTag(82, paramString3);
    case 7: 
      return new DataTag(54, paramString3);
    case 6: 
      return new DataTag(75, paramString2);
    case 5: 
      return new DataTag(76, paramString3);
    case 4: 
      return new DataTag(48, new String[] { paramString1, paramString2 });
    case 3: 
      return new DataTag(47, paramString2);
    case 2: 
      return new DataTag(4, paramString2);
    }
    return new DataTag(52, paramString2);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.remark)) {
      return this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.remark;
    }
    int i = this.jdField_c_of_type_Int;
    Object localObject;
    if (i == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((BmqqUserSimpleInfo)localObject).mBmqqNickName))) {
        return this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqNickName;
      }
    }
    else if ((i == 1) || (i == 6))
    {
      localObject = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((QidianExternalInfo)localObject).nickname)) {
          return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.uin;
        }
        return this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin;
  }
  
  private ArrayList<View> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
    if ((localObject1 != null) && (((QidianExternalInfo)localObject1).getCompanyShowCaseInfos() != null) && (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos().size() > 0))
    {
      localObject1 = (LinearLayout)getLayoutInflater().inflate(2131560857, null);
      Object localObject2 = (TextView)((LinearLayout)localObject1).findViewById(2131378784);
      localObject2 = (LinearLayout)((LinearLayout)localObject1).findViewById(2131365132);
      PhotoWallViewForQiDianProfile localPhotoWallViewForQiDianProfile = new PhotoWallViewForQiDianProfile(getApplicationContext());
      localPhotoWallViewForQiDianProfile.setPhotoWallCallback(this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback);
      List localList = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getCompanyShowCaseInfos();
      localPhotoWallViewForQiDianProfile.a(getApplicationContext(), localList);
      localPhotoWallViewForQiDianProfile.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((LinearLayout)localObject2).addView(localPhotoWallViewForQiDianProfile);
      localArrayList.add(localObject1);
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
    localActionSheet.addButton(2131693256);
    localActionSheet.addButton(2131693262);
    localActionSheet.addButton(2131698325);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new QidianProfileCardActivity.25(this, localActionSheet, paramURLDrawable, paramString));
    localActionSheet.show();
  }
  
  private void a(QidianProfileUiInfo.ConfigGroupInfo paramConfigGroupInfo)
  {
    Object localObject5 = new ArrayList();
    Object localObject4 = a();
    List localList = paramConfigGroupInfo.a;
    if (localList != null)
    {
      int j = localList.size();
      Object localObject1 = null;
      paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject1;
      int i = 0;
      while (i < j)
      {
        QidianProfileUiInfo.ConfigInfo localConfigInfo = (QidianProfileUiInfo.ConfigInfo)localList.get(i);
        localObject2 = localObject1;
        localObject3 = paramConfigGroupInfo;
        if (localConfigInfo != null)
        {
          int k = localConfigInfo.jdField_a_of_type_Int;
          boolean bool = true;
          if (k != 1) {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k != 6)
                {
                  localObject2 = localObject1;
                  localObject3 = paramConfigGroupInfo;
                  break label176;
                }
              }
              else
              {
                localObject2 = c();
                localObject3 = paramConfigGroupInfo;
                break label176;
              }
            }
            else
            {
              localObject3 = b();
              localObject2 = localObject1;
              break label176;
            }
          }
          if (i != j - 1) {
            bool = false;
          }
          ((ArrayList)localObject5).add(a(localConfigInfo, bool));
          localObject3 = paramConfigGroupInfo;
          localObject2 = localObject1;
        }
        label176:
        i += 1;
        localObject1 = localObject2;
        paramConfigGroupInfo = (QidianProfileUiInfo.ConfigGroupInfo)localObject3;
      }
      Object localObject2 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        if (localObject3 != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        }
      }
      localObject2 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (View)((Iterator)localObject2).next();
        if (localObject3 != null) {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.addView((View)localObject3);
        }
      }
      localObject2 = (LinearLayout)getLayoutInflater().inflate(2131560858, null);
      Object localObject3 = (LinearLayout)((LinearLayout)localObject2).findViewById(2131365132);
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
      while (localIterator.hasNext())
      {
        PublicAccountItem localPublicAccountItem = (PublicAccountItem)localIterator.next();
        RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131560859, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131368343);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131371697);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364429);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365517);
        localURLImageView.post(new QidianProfileCardActivity.9(this, localPublicAccountItem, localURLImageView));
        localTextView1.setText(localPublicAccountItem.jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (localPublicAccountItem.jdField_a_of_type_Int == 0)
        {
          localTextView2.setText(2131698332);
          localRelativeLayout.setTag(new DataTag(49, localPublicAccountItem.jdField_a_of_type_JavaLangString));
        }
        else if (localPublicAccountItem.jdField_a_of_type_Int == 1)
        {
          localTextView2.setText(2131698333);
          localRelativeLayout.setTag(new DataTag(50, localPublicAccountItem));
        }
        else if (localPublicAccountItem.jdField_a_of_type_Int == 2)
        {
          localTextView2.setText(2131698336);
          localRelativeLayout.setTag(new DataTag(106, localPublicAccountItem));
        }
        if ((localPublicAccountItem.jdField_a_of_type_Int == 0) && (localPublicAccountItem.jdField_b_of_type_Int == 1))
        {
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130842734);
        }
        else if ((localPublicAccountItem.jdField_a_of_type_Int == 1) && (localPublicAccountItem.jdField_b_of_type_Int == 1))
        {
          localImageView.setVisibility(0);
          localImageView.setBackgroundResource(2130844494);
        }
        else
        {
          localImageView.setVisibility(8);
        }
        localArrayList.add(localRelativeLayout);
      }
    }
    return localArrayList;
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_SAVE);
    ((StringBuilder)localObject).append(com.tencent.image.Utils.Crc64String(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
    ((StringBuilder)localObject).append(com.tencent.image.Utils.Crc64String(paramURLDrawable.getURL().toString()));
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if (!localFile.exists()) {}
    try
    {
      if (!localFile.createNewFile()) {
        break label195;
      }
      b(paramURLDrawable, localFile.getPath());
      return;
    }
    catch (IOException paramURLDrawable)
    {
      label110:
      break label110;
    }
    QQToast.a(this, getString(2131694911), 0).a();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131718393)).setMessage(getString(2131694907)).setPositiveButton(getString(2131718205), new QidianProfileCardActivity.27(this, paramURLDrawable, (String)localObject)).setNegativeButton(getString(2131694460), new QidianProfileCardActivity.26(this)).show();
    label195:
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
        RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131560859, null);
        URLImageView localURLImageView = (URLImageView)localRelativeLayout.findViewById(2131368343);
        TextView localTextView1 = (TextView)localRelativeLayout.findViewById(2131371697);
        ImageView localImageView = (ImageView)localRelativeLayout.findViewById(2131364429);
        TextView localTextView2 = (TextView)localRelativeLayout.findViewById(2131365517);
        localURLImageView.post(new QidianProfileCardActivity.10(this, localGroupItem, localURLImageView));
        localTextView1.setText(String.valueOf(localGroupItem.jdField_a_of_type_JavaLangString));
        localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTextView2.setText(HardCodeUtil.a(2131709703));
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
      a(2131695275);
    }
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, true))
    {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, false);
    }
    else if (this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, false))
    {
      BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, 1);
      this.jdField_a_of_type_ComTencentQidianQidianManager.b(this, localBmqqAccountType);
    }
    else
    {
      this.jdField_a_of_type_ComTencentQidianQidianManager.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
    }
    if (paramInt == 6) {
      ((QidianHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).c(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
    }
  }
  
  private void f(int paramInt)
  {
    int j = 0;
    int i;
    if (paramInt == 6)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {}
    }
    else
    {
      do
      {
        for (;;)
        {
          i = 1;
          break label72;
          if (paramInt != 1) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null)
          {
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card != null) {
              break label72;
            }
          }
        }
        if (paramInt != 2)
        {
          i = j;
          if (paramInt != 0) {
            break;
          }
        }
        i = j;
      } while (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo == null);
    }
    label72:
    if (i != 0) {
      ThreadManager.post(new QidianProfileCardActivity.3(this, paramInt), 8, null, true);
    }
  }
  
  private void g()
  {
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    localConcurrentHashMap = this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
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
    int i = 1;
    Object localObject4 = "";
    if ((paramInt != 1) && (paramInt != 6))
    {
      if ((paramInt != 0) && (paramInt != 2))
      {
        localObject1 = "";
        localObject2 = localObject1;
        break label200;
      }
      localObject3 = a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo;
      localObject1 = localObject3;
      if (localObject2 == null) {
        break label196;
      }
      localObject1 = localObject3;
      if (TextUtils.isEmpty(((BmqqUserSimpleInfo)localObject2).mBmqqJobTitle)) {
        break label196;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle;
      localObject1 = localObject3;
    }
    else
    {
      String str = a();
      localObject2 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
      localObject1 = str;
      if (localObject2 == null) {
        break label196;
      }
      if (!TextUtils.isEmpty(((QidianExternalInfo)localObject2).job))
      {
        localObject3 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job;
        paramInt = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity;
      }
      else
      {
        localObject3 = "";
      }
      localObject2 = localObject3;
      localObject1 = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.sign))
      {
        localObject4 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.sign;
        localObject1 = str;
        localObject2 = localObject3;
      }
    }
    Object localObject3 = localObject4;
    localObject4 = localObject2;
    Object localObject2 = localObject3;
    break label200;
    label196:
    localObject2 = "";
    label200:
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    Object localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
    if (localObject1 == null) {
      return;
    }
    if (((QidianExternalInfo)localObject1).verity == 2) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
    }
  }
  
  private void h()
  {
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    this.jdField_a_of_type_Int = (((Resources)localObject).getDimensionPixelSize(2131299168) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364110));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368087));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368057));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new QidianProfileCardActivity.4(this));
    if (!SimpleUIUtil.a()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844466));
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380408));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365132));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369177));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131365037));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
    ((BounceScrollView)localObject).mScrollFlag = 1;
    ((BounceScrollView)localObject).setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new QidianProfileCardActivity.5(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369573));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377597));
    findViewById(2131377613).setOnClickListener(new QidianProfileCardActivity.6(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369986));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new QidianProfileCardActivity.7(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376602));
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(new DataTag(53, null));
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    b();
  }
  
  private void h(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if ((paramInt != 1) && (paramInt != 6))
    {
      if ((paramInt == 0) || (paramInt == 2)) {
        i();
      }
    }
    else
    {
      Object localObject = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
      if (localObject != null)
      {
        localObject = ((QidianProfileUiInfo)localObject).getConfigGroupInfos().iterator();
        while (((Iterator)localObject).hasNext()) {
          a((QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject).next());
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.remark = paramString;
    ProfileNameUtils.updateNameArray(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo, 4, paramString);
    ProfileNameUtils.updateProfileName(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      QidianProfileUiInfo.ConfigGroupInfo localConfigGroupInfo = new QidianProfileUiInfo.ConfigGroupInfo();
      localConfigGroupInfo.a = new ArrayList(5);
      new QidianProfileUiInfo.ConfigInfo();
      QidianProfileUiInfo.ConfigInfo localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 0;
      localConfigInfo.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131709711);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 2;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131698045);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131719441);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 3;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131693871);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131695020);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((BmqqSegmentUtil.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) && (BmqqSegmentUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)))
      {
        localConfigInfo.jdField_b_of_type_Int = 7;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mqqwpa://card/show_pslcard?card_type=crm&uin=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
        localConfigInfo.d = localStringBuilder.toString();
        localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();
      }
      else
      {
        localConfigInfo.jdField_b_of_type_Int = 0;
        localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();
      }
      localConfigGroupInfo.a.add(localConfigInfo);
      a(localConfigGroupInfo);
    }
  }
  
  private void i(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
        return;
      }
      ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
    }
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
    Object localObject = paramString;
    if (!paramString.startsWith("http"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", (String)localObject);
    paramString.putExtra("isShowAd", false);
    paramString.putExtra("big_brother_source_key", "biz_src_qycp");
    startActivity(paramString);
  }
  
  private void k(String paramString)
  {
    Object localObject = (ClipboardManager)getSystemService("clipboard");
    ClipboardMonitor.setText((ClipboardManager)localObject, paramString);
    ((ClipboardManager)localObject).setText(paramString);
    if (b())
    {
      paramString = new Intent();
      localObject = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
      paramString.setAction("android.intent.action.MAIN");
      paramString.addCategory("android.intent.category.LAUNCHER");
      paramString.addFlags(268435456);
      paramString.setComponent((ComponentName)localObject);
      startActivity(paramString);
      return;
    }
    j("https://weixin.qq.com/d");
  }
  
  public Drawable a(URLImageView paramURLImageView, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.getDrawable(paramString);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getWeixinPAFaceDrawable load net error, ");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.d("QidianProfileCardActivity", 4, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() != 2))
    {
      if (((URLDrawable)localObject1).getStatus() == 1) {
        return new BitmapDrawable(a(this.app, (URLDrawable)localObject1, SimpleUIUtil.a() ^ true));
      }
      paramURLImageView.setURLDrawableDownListener(new QidianProfileCardActivity.DrawableListener(this, this.app, paramURLImageView, paramString, ImageUtil.e(), SimpleUIUtil.a() ^ true));
      return localObject1;
    }
    return ImageUtil.e();
  }
  
  public View a(QidianProfileCardActivity.QidianSimpleProfileItem paramQidianSimpleProfileItem)
  {
    int k = paramQidianSimpleProfileItem.jdField_c_of_type_Int;
    int j = 2130844472;
    int i = 11;
    Object localObject6;
    if ((k != 11) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709700))))
    {
      if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 1) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709694))))
      {
        if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 2) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709696))))
        {
          if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 3) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709698))))
          {
            if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 4) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709706))))
            {
              if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 5) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709695))))
              {
                if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 6) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709702))))
                {
                  i = j;
                  if (paramQidianSimpleProfileItem.jdField_c_of_type_Int != 7) {
                    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709709))) {
                      i = j;
                    } else if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 8) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709699))))
                    {
                      if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 9) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709708))))
                      {
                        if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int != 10) && (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))) {
                          i = 2130844473;
                        } else {
                          i = 2130844479;
                        }
                      }
                      else {
                        return null;
                      }
                    }
                    else {
                      i = 2130844477;
                    }
                  }
                }
                else
                {
                  i = 2130844475;
                }
              }
              else {
                i = 2130844471;
              }
            }
            else {
              i = 2130845955;
            }
          }
          else {
            i = 2130844474;
          }
        }
        else {
          i = 2130844476;
        }
      }
      else {
        i = 2130844478;
      }
      localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131560860, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)localRelativeLayout.findViewById(2131369951);
      localObject2 = (TextView)localRelativeLayout.findViewById(2131371023);
      localObject3 = (ImageView)localRelativeLayout.findViewById(2131376570);
      localObject4 = (ImageView)localRelativeLayout.findViewById(2131371021);
      ((TextView)localObject2).setText(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject3).setVisibility(4);
        localRelativeLayout.setLongClickable(true);
        localRelativeLayout.setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
        localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      }
      else
      {
        localRelativeLayout.setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
        localRelativeLayout.setClickable(true);
        localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localObject3).setVisibility(0);
      }
      if (paramQidianSimpleProfileItem.jdField_c_of_type_Boolean) {
        ((ImageView)localObject4).setVisibility(0);
      } else {
        ((ImageView)localObject4).setVisibility(8);
      }
      ((ImageView)localObject1).setImageResource(i);
      if ((paramQidianSimpleProfileItem.jdField_c_of_type_Int == 5) || (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709705))))
      {
        localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
        if ((localObject1 != null) && (((QidianProfileUiInfo)localObject1).mConfigGroupInfos != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject1).next();
            if ((localObject2 == null) || (((QidianProfileUiInfo.ConfigGroupInfo)localObject2).a == null)) {
              break;
            }
            localObject2 = ((QidianProfileUiInfo.ConfigGroupInfo)localObject2).a.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject2).next();
              if ((localObject3 != null) && ((((QidianProfileUiInfo.ConfigInfo)localObject3).jdField_c_of_type_Int == 5) || (((QidianProfileUiInfo.ConfigInfo)localObject3).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709701)))))
              {
                i = paramQidianSimpleProfileItem.jdField_b_of_type_Int;
                localObject4 = paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString;
                localObject5 = paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString;
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append(((QidianProfileUiInfo.ConfigInfo)localObject3).f);
                ((StringBuilder)localObject6).append("|");
                ((StringBuilder)localObject6).append(((QidianProfileUiInfo.ConfigInfo)localObject3).g);
                localRelativeLayout.setTag(a(i, (String)localObject4, (String)localObject5, ((StringBuilder)localObject6).toString()));
              }
            }
          }
        }
      }
      localObject1 = (TextView)localRelativeLayout.findViewById(2131366393);
      ((TextView)localObject1).setVisibility(8);
      if (paramQidianSimpleProfileItem.jdField_b_of_type_Int == 2)
      {
        paramQidianSimpleProfileItem = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
        if ((paramQidianSimpleProfileItem != null) && (!TextUtils.isEmpty(paramQidianSimpleProfileItem.mobile)))
        {
          ((TextView)localObject1).setVisibility(0);
          if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.isExternalMobileVerified())
          {
            ((TextView)localObject1).setText(2131709577);
            ((TextView)localObject1).setTextColor(Color.parseColor("#7CE7C2"));
            ((TextView)localObject1).setBackgroundResource(2130844158);
            return localRelativeLayout;
          }
          ((TextView)localObject1).setText(2131709576);
          ((TextView)localObject1).setTextColor(Color.parseColor("#FFCD9C"));
          ((TextView)localObject1).setBackgroundResource(2130844157);
        }
      }
      return localRelativeLayout;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)getLayoutInflater().inflate(2131560856, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
    Object localObject5 = (ImageView)localRelativeLayout.findViewById(2131369951);
    Object localObject1 = (TextView)localRelativeLayout.findViewById(2131371023);
    Object localObject2 = (TextView)localRelativeLayout.findViewById(2131363771);
    Object localObject3 = (ImageView)localRelativeLayout.findViewById(2131376570);
    Object localObject4 = (ImageView)localRelativeLayout.findViewById(2131371021);
    ((ImageView)localObject5).setImageResource(2130844472);
    localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
    if ((localObject5 != null) && (((QidianProfileUiInfo)localObject5).mConfigGroupInfos != null))
    {
      localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
      if (((Iterator)localObject5).hasNext())
      {
        localObject6 = (QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject5).next();
        if ((localObject6 != null) && (((QidianProfileUiInfo.ConfigGroupInfo)localObject6).a != null))
        {
          localObject6 = ((QidianProfileUiInfo.ConfigGroupInfo)localObject6).a.iterator();
          for (j = i;; j = 11)
          {
            i = j;
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            Object localObject7 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject6).next();
            if ((localObject7 != null) && ((((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_c_of_type_Int == j) || (((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_JavaLangString.equals(HardCodeUtil.a(2131709697)))) && (((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo != null))
            {
              ((TextView)localObject1).setText(((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.jdField_a_of_type_JavaLangString);
              ((TextView)localObject2).setText(((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.jdField_c_of_type_JavaLangString);
              localRelativeLayout.setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, ((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
              this.jdField_b_of_type_JavaLangString = ((QidianProfileUiInfo.ConfigInfo)localObject7).jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.d;
              localObject7 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
              if (localObject7 != null)
              {
                if (((QidianExternalInfo)localObject7).verity == 2) {
                  i = 1;
                } else {
                  i = 0;
                }
                if ((i != 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) && (HttpUtil.isValidUrl(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)))
                {
                  localObject7 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = getResources().getDrawable(2130844467);
                  ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = getResources().getDrawable(2130844467);
                  ((URLDrawable.URLDrawableOptions)localObject7).mPlayGifImage = false;
                  ((URLDrawable.URLDrawableOptions)localObject7).mGifRoundCorner = 0.0F;
                  ((URLDrawable.URLDrawableOptions)localObject7).mRequestWidth = 20;
                  ((URLDrawable.URLDrawableOptions)localObject7).mRequestHeight = 20;
                  localObject7 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url, (URLDrawable.URLDrawableOptions)localObject7);
                  if (localObject4 != null)
                  {
                    ((ImageView)localObject4).setMaxWidth(20);
                    ((ImageView)localObject4).setMaxHeight(20);
                    ((ImageView)localObject4).setVisibility(0);
                    ((ImageView)localObject4).setImageDrawable((Drawable)localObject7);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (!paramQidianSimpleProfileItem.jdField_a_of_type_Boolean)
    {
      ((ImageView)localObject3).setVisibility(4);
      localRelativeLayout.setLongClickable(true);
      localRelativeLayout.setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      localRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      return localRelativeLayout;
    }
    localRelativeLayout.setClickable(true);
    localRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((ImageView)localObject3).setVisibility(0);
    return localRelativeLayout;
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
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299168));
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramURLImageView == null) {
        return;
      }
      if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) && (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) != null))
      {
        paramURLImageView.setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
        return;
      }
      Object localObject;
      if (paramInt == 0) {
        localObject = FaceDrawable.getFaceDrawable(this.app, 1, paramString);
      } else if ((paramInt != 1) && (paramInt != 2)) {
        localObject = this.app.getTroopFaceDrawable(paramString);
      } else {
        localObject = a(paramURLImageView, paramString);
      }
      if (localObject != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        paramURLImageView.setImageDrawable((Drawable)localObject);
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, 2131560864, null, null, getString(2131690874), getString(2131690874), new QidianProfileCardActivity.23(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(true);
    }
    if (paramInt == 50) {
      paramInt = 2131698330;
    } else {
      paramInt = 2131698331;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(super.getString(paramInt));
    localObject = b((URLImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.framePreviewImage, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage((Drawable)localObject, true, 1);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow() != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().findViewById(2131367217).setOnLongClickListener(new QidianProfileCardActivity.24(this, (Drawable)localObject, paramPublicAccountItem));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968585)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin))) {
        this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968585)[1]);
      }
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(super.getResources().getStringArray(2130968585)[2]);
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
    boolean bool1 = QidianManager.a(this.jdField_b_of_type_Int);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, this.app);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAccountType accountType: ");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      QLog.d("QidianProfileCardActivity", 2, localStringBuilder.toString());
    }
    int i = this.jdField_c_of_type_Int;
    bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (i != 1)
      {
        bool1 = bool2;
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              bool1 = bool2;
              if (i == 6) {
                return bool1;
              }
            }
            else
            {
              a(2131695275);
              return true;
            }
          }
          else {
            CrmUtils.a(this, null, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, true, -1, true, -1);
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public Drawable b(URLImageView paramURLImageView, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Object localObject1;
    try
    {
      localObject1 = URLDrawable.getDrawable(paramString);
    }
    catch (Exception localException)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getWeixinPAQrDrawable load net error, ");
        ((StringBuilder)localObject1).append(localException.getMessage());
        QLog.d("QidianProfileCardActivity", 4, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() != 2))
    {
      if (((URLDrawable)localObject1).getStatus() == 1) {
        return localObject1;
      }
      paramURLImageView.setURLDrawableDownListener(new QidianProfileCardActivity.DrawableListener(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130851160), false));
      return localObject1;
    }
    return ImageUtil.e();
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
    int i = this.jdField_c_of_type_Int;
    if ((i != 1) && (i != 2) && (i != 0) && (i != 6)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
    boolean bool2 = ProfilePAUtils.isPaTypeCanAddAsFriend(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne);
    boolean bool1;
    if (this.jdField_c_of_type_Int == 6) {
      bool1 = true;
    } else {
      bool1 = ProfilePAUtils.isPaTypeCanTalk(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne);
    }
    boolean bool3 = ProfilePAUtils.isPaTypeCanFreeCall(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne);
    if (bool2) {
      a(2131693278, 2131560862, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(7, null));
    }
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin))) {
      a(2131698327, 2131560862, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(55, null));
    } else if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin))) {
      a(2131693303, 2131560862, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
    } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
      a(2131693303, 2131560862, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
    }
    if (bool1) {
      a(2131698724, 2131560861, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(8, Integer.valueOf(this.jdField_c_of_type_Int)));
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
    }
    try
    {
      this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)((EntityManager)localObject1).find(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
      this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)((EntityManager)localObject1).find(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.card = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
        this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)((EntityManager)localObject1).find(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
      }
      if (localObject1 == null) {
        break label304;
      }
      ((EntityManager)localObject1).close();
    }
    finally
    {
      if (localObject1 != null) {
        ((EntityManager)localObject1).close();
      }
    }
    if (paramInt == 6)
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)((EntityManager)localObject1).find(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)((EntityManager)localObject1).find(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
        if (localObject1 != null) {
          ((EntityManager)localObject1).close();
        }
      }
      finally
      {
        if (localObject1 != null) {
          ((EntityManager)localObject1).close();
        }
      }
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)((EntityManager)localObject1).find(BmqqUserSimpleInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin));
      if (localObject1 != null) {
        ((EntityManager)localObject1).close();
      }
      label304:
      localObject1 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
      if (localObject1 != null) {
        ((QidianExternalInfo)localObject1).initList();
      }
      runOnUiThread(new QidianProfileCardActivity.8(this, paramInt));
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((EntityManager)localObject1).close();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    boolean bool;
    if (!this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.isExternalMobileVerified())
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968584)[4], 1);
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968584)[0], 1);
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin))) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968584)[1], 1);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(super.getResources().getStringArray(2130968584)[2], 1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(super.getResources().getStringArray(2130968584)[3]);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new QidianProfileCardActivity.18(this, bool, paramString));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    QidianProfileCardActivity.UiHandler localUiHandler = this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity$UiHandler;
    if (localUiHandler != null) {
      localUiHandler.sendMessage(localMessage);
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
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name)))
      {
        this.jdField_a_of_type_JavaLangString = ((Friends)localObject).name;
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
        if (localObject != null) {
          this.jdField_a_of_type_JavaLangString = ((QidianExternalInfo)localObject).nickname;
        }
      }
    }
    localIntent.putExtra("key_nick_name", this.jdField_a_of_type_JavaLangString);
    if (this.jdField_c_of_type_Int == 6) {
      localIntent.putExtra("key_qidian_detail_url", this.jdField_b_of_type_JavaLangString);
    }
    Object localObject = BusinessCardUtils.a(this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo);
    localIntent = ProfileCardUtil.a(localIntent, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin, this.app, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne, (BusinessCard)localObject);
    localIntent.addFlags(536870912);
    super.startActivityForResult(localIntent, 1012);
  }
  
  public void d(int paramInt)
  {
    Object localObject;
    if (paramInt == 1)
    {
      Intent localIntent = new Intent(getActivity(), ChatActivity.class);
      localIntent.addFlags(67108864);
      String str = this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(str))
      {
        paramInt = 0;
        localObject = ContactUtils.c(this.app, str);
      }
      else
      {
        localObject = null;
        paramInt = 1025;
      }
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", paramInt);
      if (localObject != null) {
        localIntent.putExtra("uinname", (String)localObject);
      }
      startActivity(localIntent);
      return;
    }
    if (paramInt == 6)
    {
      localObject = new Intent(getActivity(), ChatActivity.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    ProfileBottomContainer.enterChat(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo);
  }
  
  public void d(String paramString)
  {
    TroopUtils.a(this, TroopInfoUIUtil.a(paramString, 31), 2);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1000)
      {
        if (paramInt1 != 1012) {
          return;
        }
        if (paramIntent != null)
        {
          if (paramIntent.getBooleanExtra("finchat", false))
          {
            super.finish();
            return;
          }
          paramIntent = paramIntent.getStringExtra("remark");
          if (!com.tencent.mobileqq.util.Utils.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.remark, paramIntent)) {
            h(paramIntent);
          }
        }
      }
      else
      {
        super.setResult(-1);
        super.finish();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.app);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("open profile card start ");
      paramBundle.append(System.currentTimeMillis());
      QLog.d("performance", 2, paramBundle.toString());
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    try
    {
      setContentView(2131560853);
      this.jdField_d_of_type_Int = AIOUtils.b(16.0F, getResources());
      this.e = AIOUtils.b(10.0F, getResources());
      this.f = AIOUtils.b(8.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne = ((AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne = new AllInOne(paramBundle, 104);
      }
      this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin != null))
      {
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
        if ((paramBundle != null) && (paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin)) && (!this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin.equals(this.app.getCurrentAccountUin()))) {
          this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.pa = 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.nameArray = new String[8];
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
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("open profile card end ");
          paramBundle.append(System.currentTimeMillis());
          QLog.d("performance", 2, paramBundle.toString());
        }
        return true;
      }
      super.finish();
      return false;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      finish();
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()))
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
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    AllInOne localAllInOne = (AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.uin.equals(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin))) {
      e(this.jdField_c_of_type_Int);
    }
    if ((localAllInOne != null) && (!localAllInOne.uin.equals(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
  }
  
  public void e()
  {
    QidianExternalInfo localQidianExternalInfo = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo;
    if ((localQidianExternalInfo != null) && (!TextUtils.isEmpty(localQidianExternalInfo.masterUin)) && (this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin)))
    {
      CrmUtils.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
      return;
    }
    a(2131693334, 1);
  }
  
  public void e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mailto:");
    localStringBuilder.append(paramString);
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString())));
  }
  
  public void f()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.profileName.a.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
    }
    ProfileBottomContainer.addFriend(this.app, this, this.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo, this.jdField_a_of_type_AndroidAppDialog);
  }
  
  public void f(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tel:");
      localStringBuilder.append(paramString);
      super.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(localStringBuilder.toString())));
    }
  }
  
  public void g(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramString);
      super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString())));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */