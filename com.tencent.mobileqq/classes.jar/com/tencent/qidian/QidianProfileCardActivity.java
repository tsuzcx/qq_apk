package com.tencent.qidian;

import ally;
import allz;
import alma;
import almb;
import almc;
import almf;
import almg;
import almh;
import almi;
import almj;
import almk;
import alml;
import almm;
import almn;
import almo;
import almp;
import almq;
import almr;
import alms;
import almt;
import almu;
import almv;
import almw;
import almx;
import alna;
import alnb;
import alnc;
import alng;
import alni;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
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
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import com.tencent.theme.SkinnableBitmapDrawable;
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
  private alni jdField_a_of_type_Alni;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new almf(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new almc(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BmqqBusinessObserver jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver = new almk(this);
  public CardHandler a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new almi(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new almb(this);
  public FriendsManager a;
  public BmqqUserSimpleInfo a;
  public PreloadProcHitPluginSession a;
  public ProfileCardInfo a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public PhotoWallViewForQiDianProfile.PhotoWallCallback a;
  public QidianManager a;
  private QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new almj(this);
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString = "";
  public ConcurrentHashMap a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private String jdField_b_of_type_JavaLangString = "";
  public ConcurrentHashMap b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public int d;
  public int e;
  int f;
  
  public QidianProfileCardActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = new ProfileCardInfo();
    this.jdField_c_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentQidianPhotoWallViewForQiDianProfile$PhotoWallCallback = new alna(this);
    this.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitPluginSession = new PreloadProcHitPluginSession("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  }
  
  public static Bitmap a(QQAppInterface paramQQAppInterface, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if (paramURLDrawable != null)
    {
      Bitmap localBitmap;
      if ((paramURLDrawable instanceof BitmapDrawable))
      {
        localBitmap = ((BitmapDrawable)paramURLDrawable).getBitmap();
        paramURLDrawable = localBitmap;
        if (paramBoolean) {
          paramURLDrawable = paramQQAppInterface.a(localBitmap, 50, 50);
        }
      }
      do
      {
        do
        {
          return paramURLDrawable;
          if (!(paramURLDrawable instanceof SkinnableBitmapDrawable)) {
            break;
          }
          localBitmap = ((SkinnableBitmapDrawable)paramURLDrawable).getBitmap();
          paramURLDrawable = localBitmap;
        } while (!paramBoolean);
        return paramQQAppInterface.a(localBitmap, 50, 50);
        localBitmap = ImageUtil.a(paramURLDrawable);
        paramURLDrawable = localBitmap;
      } while (!paramBoolean);
      return paramQQAppInterface.a(localBitmap, 50, 50);
    }
    return null;
  }
  
  public static Message a(Parcelable paramParcelable)
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("data", paramParcelable);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message a(ArrayList paramArrayList)
  {
    Message localMessage = new Message();
    localMessage.what = 2;
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("data", paramArrayList);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  private View a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
    View localView = View.inflate(this, paramInt2, null);
    paramInt2 = getResources().getDimensionPixelSize(2131558550);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131365251);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = paramInt2;
    this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
    return localButton;
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
  
  private void a(URLDrawable paramURLDrawable)
  {
    ThreadManager.executeOnFileThread(new alnc(this, paramURLDrawable));
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.c(this);
    localActionSheet.b(2131435871);
    localActionSheet.b(2131435877);
    localActionSheet.b(2131438731);
    localActionSheet.c(2131433015);
    localActionSheet.a(new almo(this, localActionSheet, paramURLDrawable, paramString));
    localActionSheet.show();
  }
  
  private void a(QidianProfileUiInfo.ConfigGroupInfo paramConfigGroupInfo)
  {
    paramConfigGroupInfo = paramConfigGroupInfo.a;
    if (paramConfigGroupInfo != null)
    {
      int j = paramConfigGroupInfo.size();
      int i = 0;
      if (i < j)
      {
        QidianProfileUiInfo.ConfigInfo localConfigInfo = (QidianProfileUiInfo.ConfigInfo)paramConfigGroupInfo.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localConfigInfo, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if (paramConfigInfo != null) {
      switch (paramConfigInfo.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        j();
      }
      return;
      b(paramConfigInfo, paramBoolean);
      continue;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
      {
        c(paramConfigInfo, paramBoolean);
        continue;
        if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
        {
          d(paramConfigInfo, paramBoolean);
          continue;
          b(paramConfigInfo, paramBoolean);
        }
      }
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.aP).mkdirs();
      str = AppConstants.aP + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString + com.tencent.image.Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131434583), 0).a();
          return;
        }
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131434586)).setMessage(getString(2131434588)).setPositiveButton(getString(2131434587), new almq(this, paramURLDrawable, str)).setNegativeButton(getString(2131433012), new almp(this)).show();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    ThreadManager.executeOnFileThread(new alng(this, paramURLDrawable, paramString));
  }
  
  private void b(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if ((paramConfigInfo.jdField_b_of_type_JavaLangString == null) || ((TextUtils.isEmpty(paramConfigInfo.jdField_b_of_type_JavaLangString.trim())) && (!paramConfigInfo.jdField_a_of_type_JavaLangString.equals("企业全称")))) {
      return;
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
        break label158;
      }
    }
    label158:
    for (boolean bool = true;; bool = false)
    {
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool;
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = paramConfigInfo.jdField_a_of_type_Boolean;
      paramConfigInfo = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_Alni.sendMessage(paramConfigInfo);
      return;
      str = paramConfigInfo.jdField_c_of_type_JavaLangString;
      break;
    }
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
    Object localObject = getPackageManager().getInstalledPackages(0);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((PackageInfo)((Iterator)localObject).next()).packageName.equals("com.tencent.mm")) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void c(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getPublicAccountItems();
    } while ((localObject == null) || (((List)localObject).size() <= 0) || (localObject == null) || (((List)localObject).size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      PublicAccountItem localPublicAccountItem = (PublicAccountItem)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = localPublicAccountItem.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = localPublicAccountItem.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localPublicAccountItem.jdField_b_of_type_JavaLangString.trim();
      if (localPublicAccountItem.jdField_b_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool;
        localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
        localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
        localQidianCompoundProfileItem.d = localPublicAccountItem.jdField_c_of_type_JavaLangString;
        localQidianCompoundProfileItem.e = localPublicAccountItem.d;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    paramConfigInfo = a(localArrayList);
    this.jdField_a_of_type_Alni.sendMessage(paramConfigInfo);
  }
  
  private void d(QidianProfileUiInfo.ConfigInfo paramConfigInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {}
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.getGroupItems();
    } while ((localObject == null) || (((List)localObject).size() <= 0) || (localObject == null) || (((List)localObject).size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      GroupItem localGroupItem = (GroupItem)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = paramConfigInfo.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = String.valueOf(localGroupItem.jdField_a_of_type_Long);
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localGroupItem.jdField_a_of_type_JavaLangString.trim();
      localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = paramConfigInfo.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    paramConfigInfo = a(localArrayList);
    this.jdField_a_of_type_Alni.sendMessage(paramConfigInfo);
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131430029);
    }
    if (this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true)) {
      this.jdField_a_of_type_ComTencentQidianQidianManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((QidianHandler)this.app.a(85)).c(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
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
    this.jdField_a_of_type_Alni.postDelayed(new alms(this, paramInt), 0L);
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
        break label199;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job))
      {
        localObject2 = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.job;
        if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 1) {}
      }
      localObject3 = localObject2;
      localObject1 = str1;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.sign)) {
        break label199;
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
      return;
      if (paramInt != 0)
      {
        localObject3 = localObject2;
        if (paramInt != 2) {}
      }
      else
      {
        str1 = a();
        localObject3 = localObject2;
        localObject1 = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
        {
          localObject3 = localObject2;
          localObject1 = str1;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle))
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqJobTitle;
            localObject2 = "";
            localObject1 = str1;
            continue;
          }
        }
      }
      label199:
      localObject2 = "";
    }
  }
  
  private void h()
  {
    Resources localResources = getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131558448) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364148));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364975));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365235));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new almt(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362841));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368908));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131363733));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new almu(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362754));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365209));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368907));
    findViewById(2131368906).setOnClickListener(new almv(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368912));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new almw(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368913));
    this.jdField_c_of_type_AndroidWidgetImageView.setTag(new DataTag(53, null));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
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
      localConfigInfo.jdField_a_of_type_JavaLangString = "帐号";
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 2;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131438797);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131433298);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_b_of_type_Int = 3;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131434667);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigInfo.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localConfigGroupInfo.a.add(localConfigInfo);
      localConfigInfo = new QidianProfileUiInfo.ConfigInfo();
      localConfigInfo.jdField_a_of_type_Int = 1;
      localConfigInfo.jdField_a_of_type_JavaLangString = getResources().getString(2131437509);
      localConfigInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!BmqqSegmentUtil.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!BmqqSegmentUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label425;
      }
      localConfigInfo.jdField_b_of_type_Int = 7;
      localConfigInfo.d = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localConfigInfo.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localConfigGroupInfo.a.add(localConfigInfo);
      a(localConfigGroupInfo);
      return;
      label425:
      localConfigInfo.jdField_b_of_type_Int = 0;
    }
  }
  
  private void i(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null)) {
      return;
    }
    ThreadManager.post(new alml(this, paramString), 8, null, true);
  }
  
  private void j()
  {
    this.jdField_a_of_type_Alni.post(new almx(this));
  }
  
  private void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = "http://" + paramString;
    }
    paramString = new Intent(this, QQBrowserActivity.class);
    paramString.putExtra("url", str);
    paramString.putExtra("isShowAd", false);
    startActivity(paramString);
  }
  
  private void k()
  {
    ThreadManager.executeOnSubThread(new alma(this));
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
    j("http://weixin.qq.com/d");
  }
  
  public Drawable a(URLImageView paramURLImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      URLDrawable localURLDrawable1 = URLDrawable.getDrawable(paramString);
      if ((localURLDrawable1 == null) || (localURLDrawable1.getStatus() == 2)) {
        return ImageUtil.b();
      }
    }
    catch (Exception localException)
    {
      URLDrawable localURLDrawable2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 4, "getWeixinPAFaceDrawable load net error, " + localException.getMessage());
        }
        localURLDrawable2 = null;
      }
      if (localURLDrawable2.getStatus() == 1) {
        return new BitmapDrawable(a(this.app, localURLDrawable2, true));
      }
      paramURLImageView.setURLDrawableDownListener(new alnb(this, this.app, paramURLImageView, paramString, ImageUtil.b(), true));
      return localURLDrawable2;
    }
  }
  
  public View a(QidianProfileCardActivity.QidianSimpleProfileItem paramQidianSimpleProfileItem)
  {
    int i = 2130841702;
    Object localObject1;
    Object localObject5;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("企业全称"))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2130970063, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131368719);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131368917);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131368918);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131368916);
      ((ImageView)localObject5).setImageResource(2130841702);
      localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
      while (((Iterator)localObject5).hasNext())
      {
        Iterator localIterator = ((QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject5).next()).a.iterator();
        while (localIterator.hasNext())
        {
          QidianProfileUiInfo.ConfigInfo localConfigInfo = (QidianProfileUiInfo.ConfigInfo)localIterator.next();
          if ((localConfigInfo.jdField_a_of_type_JavaLangString.equals("企业全称")) && (localConfigInfo.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo != null))
          {
            ((TextView)localObject2).setText(localConfigInfo.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.jdField_a_of_type_JavaLangString);
            ((TextView)localObject3).setText(localConfigInfo.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.jdField_c_of_type_JavaLangString);
            ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, localConfigInfo.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
            this.jdField_b_of_type_JavaLangString = localConfigInfo.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo$ConfigCorpSimpleInfo.d;
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
      }
      ((RelativeLayout)localObject1).setClickable(true);
      ((RelativeLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      return localObject1;
    }
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("电话"))
    {
      i = 2130841708;
      label323:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2130970067, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131368719);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131368917);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131368916);
      localObject5 = (ImageView)((RelativeLayout)localObject2).findViewById(2131368920);
      ((TextView)localObject3).setText(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      if (paramQidianSimpleProfileItem.jdField_a_of_type_Boolean) {
        break label785;
      }
      ((ImageView)localObject4).setVisibility(4);
      ((RelativeLayout)localObject2).setLongClickable(true);
      ((RelativeLayout)localObject2).setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      ((RelativeLayout)localObject2).setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      label440:
      if (!paramQidianSimpleProfileItem.jdField_c_of_type_Boolean) {
        break label834;
      }
      ((ImageView)localObject5).setVisibility(0);
    }
    for (;;)
    {
      ((ImageView)localObject1).setImageResource(i);
      localObject1 = localObject2;
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("地址")) {
        break;
      }
      localObject3 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((QidianProfileUiInfo.ConfigGroupInfo)((Iterator)localObject3).next()).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (QidianProfileUiInfo.ConfigInfo)((Iterator)localObject1).next();
          if (((QidianProfileUiInfo.ConfigInfo)localObject4).jdField_a_of_type_JavaLangString.equals("地址")) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, ((QidianProfileUiInfo.ConfigInfo)localObject4).f + "|" + ((QidianProfileUiInfo.ConfigInfo)localObject4).g));
          }
        }
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("手机"))
      {
        i = 2130841706;
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("邮箱"))
      {
        i = 2130841704;
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("帐号"))
      {
        i = 2130843040;
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("地址"))
      {
        i = 2130841701;
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("主页"))
      {
        i = 2130841705;
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("公司")) {
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("地区"))
      {
        i = 2130841707;
        break label323;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("签名")) {
        return null;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))
      {
        i = 2130841709;
        break label323;
      }
      i = 2130841703;
      break label323;
      label785:
      ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
      ((RelativeLayout)localObject2).setClickable(true);
      ((RelativeLayout)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      break label440;
      label834:
      ((ImageView)localObject5).setVisibility(8);
    }
  }
  
  public View a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      localObject1 = null;
    }
    LinearLayout localLinearLayout;
    int i;
    do
    {
      RelativeLayout localRelativeLayout;
      do
      {
        return localObject1;
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2130970062, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131363632);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131366347);
        ((TextView)localObject1).setText(((QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(0)).jdField_c_of_type_JavaLangString);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2130970061, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131362719);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131362754);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131362720);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131363579);
    localURLImageView.post(new allz(this, (QidianProfileCardActivity.QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_b_of_type_JavaLangString);
    ((LinearLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 0)
    {
      localTextView2.setText(2131427333);
      ((LinearLayout)localObject1).setTag(new DataTag(49, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      label243:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int != 0) || (!((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean)) {
        break label385;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130840670);
    }
    for (;;)
    {
      localObject2 = new LinearLayout.LayoutParams(0, -2, 1.0F);
      if (i == 0) {
        ((LinearLayout)localObject1).setPadding(0, 0, this.f, 0);
      }
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      i += 1;
      break;
      if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 1)
      {
        localTextView2.setText(2131427334);
        ((LinearLayout)localObject1).setTag(new DataTag(50, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).e));
        break label243;
      }
      localTextView2.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString);
      ((LinearLayout)localObject1).setTag(new DataTag(51, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      break label243;
      label385:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 1) && (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130841726);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131558448));
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
        localObject = FaceDrawable.a(this.app, 1, paramString);
      }
      while (localObject != null)
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        paramURLImageView.setImageDrawable((Drawable)localObject);
        return;
        if (paramInt == 1) {
          localObject = a(paramURLImageView, paramString);
        } else {
          localObject = this.app.a(paramString);
        }
      }
    }
  }
  
  public void a(PublicAccountItem paramPublicAccountItem)
  {
    Object localObject = paramPublicAccountItem.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 0, 2130970071, null, null, getString(2131434937), getString(2131434937), new almm(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(super.getString(2131427336));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(true);
    }
    localObject = b((URLImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.framePreviewImage, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage((Drawable)localObject, true, 1);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow() != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().findViewById(2131364050).setOnLongClickListener(new almn(this, (Drawable)localObject, paramPublicAccountItem));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131296327)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_ComTencentWidgetActionSheet.c(super.getResources().getStringArray(2131296327)[1]);
      }
      this.jdField_b_of_type_ComTencentWidgetActionSheet.d(super.getResources().getStringArray(2131296327)[2]);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new almg(this, paramString));
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
    ThreadManager.post(new almr(this, paramArrayOfByte), 8, null, true);
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
      a(2131430029);
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
        return ImageUtil.b();
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
      paramURLImageView.setURLDrawableDownListener(new alnb(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130846329), false));
      return localDrawable;
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 6)) {}
    label319:
    for (;;)
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 6))
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131435762, 2130970069, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(7, null));
        }
        if ((this.jdField_c_of_type_Int != 1) || (!this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label219;
        }
        a(2131427337, 2130970069, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label319;
        }
        a(2131437024, 2130970068, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(8, Integer.valueOf(this.jdField_c_of_type_Int)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        label219:
        if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_ComTencentQidianQidianManager.c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          a(2131435796, 2130970069, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
        } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
          a(2131435796, 2130970069, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new DataTag(20, null));
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
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.a(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.a(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(50);
        this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard = localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localEntityManager.a(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.a();
        }
      }
      if ((paramInt == 0) || (paramInt == 2))
      {
        localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          return;
        }
        finally
        {
          if (localEntityManager != null) {
            localEntityManager.a();
          }
        }
      }
      if (paramInt != 6) {
        continue;
      }
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.a(QidianExternalInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.a(QidianProfileUiInfo.class, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.a();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131296326)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentQidianQidianManager.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131296326)[1], 1);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(super.getResources().getStringArray(2131296326)[2], 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(super.getResources().getStringArray(2131296326)[3]);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new almh(this, paramString));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_Alni != null) {
      this.jdField_a_of_type_Alni.sendMessage(localMessage);
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
    PublicAccountUtil.a(localIntent, this.app, this, paramString, -1);
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
      localObject = ((FriendsManager)this.app.getManager(50)).c(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((Friends)localObject).name))) {
        break label167;
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
      label167:
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
        localObject = ContactUtils.k(this.app, str);
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
    ChatSettingForTroop.a(this, TroopInfoActivity.a(paramString, 31), 2);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = true;
    super.doOnCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card start " + System.currentTimeMillis());
    }
    this.jdField_a_of_type_ComTencentQidianQidianManager = ((QidianManager)this.app.getManager(164));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.a(2));
    setContentView(2130970060);
    this.d = AIOUtils.a(16.0F, getResources());
    this.e = AIOUtils.a(10.0F, getResources());
    this.f = AIOUtils.a(8.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
    {
      paramBundle = super.getIntent().getStringExtra("uin");
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramBundle, 78);
    }
    this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
    {
      super.finish();
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
    g();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Alni = new alni(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.post(new ally(this), 8, null, true);
    e(this.jdField_c_of_type_Int);
    h();
    k();
    f(this.jdField_c_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("performance", 2, "open profile card end " + System.currentTimeMillis());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentBizBmqqAppBmqqBusinessObserver);
    g();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
  
  protected void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131435795, 1);
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */