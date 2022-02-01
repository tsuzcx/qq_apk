package com.tencent.qidian;

import Override;
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
import android.os.Parcelable;
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
import anri;
import anvi;
import anvk;
import anvx;
import aqkw;
import avlg;
import azpb;
import azrb;
import bdfk;
import bgvk;
import bhaa;
import bhbx;
import bhdj;
import bheg;
import bisl;
import bisy;
import bjwz;
import bjxa;
import bjxd;
import bjxe;
import bjxh;
import bjxi;
import bjxj;
import bjxk;
import bjxl;
import bjxm;
import bjxn;
import bjxo;
import bjxp;
import bjxq;
import bjxr;
import bjxs;
import bjxt;
import bjxu;
import bjxv;
import bjxw;
import bjxx;
import bjxy;
import bjyb;
import bjyh;
import bjyi;
import bjym;
import bjyn;
import bjyo;
import bjyp;
import bjyq;
import bkyz;
import bkzi;
import bkzz;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
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
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import nur;
import nut;
import nwu;
import uuc;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bjxh(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bjxe(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public anri a;
  private anvi jdField_a_of_type_Anvi = new bjxd(this);
  public anvk a;
  avlg jdField_a_of_type_Avlg = new avlg("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
  public azrb a;
  public bisl a;
  private bisy jdField_a_of_type_Bisy;
  bjwz jdField_a_of_type_Bjwz = new bjxw(this);
  public bjxa a;
  private bjyb jdField_a_of_type_Bjyb;
  private bjyh jdField_a_of_type_Bjyh = new bjxl(this);
  private bkzi jdField_a_of_type_Bkzi;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new bjxk(this);
  public BmqqUserSimpleInfo a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private String jdField_a_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, bjxy> a;
  private nur jdField_a_of_type_Nur = new bjxm(this);
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public ImageView b;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bkzi jdField_b_of_type_Bkzi;
  private String jdField_b_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, Drawable> b;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  public int d;
  private ImageView d;
  public int e;
  int f;
  
  public QidianProfileCardActivity()
  {
    this.jdField_a_of_type_Azrb = new azrb();
    this.jdField_c_of_type_Int = 4;
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
        paramURLDrawable = bheg.a(paramQQAppInterface);
        paramQQAppInterface = paramURLDrawable;
      } while (!paramBoolean);
      return QQAppInterface.getCircleFaceBitmap(paramURLDrawable, 50, 50);
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
  
  public static Message a(ArrayList<Parcelable> paramArrayList)
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
    int i = getResources().getDimensionPixelSize(2131298068);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131380283);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt2 != 2131560896) {
        break label122;
      }
      localButton.setBackgroundResource(2130844374);
      localButton.setTextColor(getResources().getColor(2131166293));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
      return localButton;
      label122:
      if (paramInt2 == 2131560895)
      {
        localButton.setBackgroundResource(2130844373);
        localButton.setTextColor(getResources().getColor(2131166292));
      }
    }
  }
  
  private azpb a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new azpb(52, paramString2);
    case 2: 
      return new azpb(4, paramString2);
    case 3: 
      return new azpb(47, paramString2);
    case 4: 
      return new azpb(48, new String[] { paramString1, paramString2 });
    case 7: 
      return new azpb(54, paramString3);
    case 6: 
      return new azpb(75, paramString2);
    case 5: 
      return new azpb(76, paramString3);
    }
    return new azpb(82, paramString3);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i)) {
      return this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
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
    return this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
  }
  
  private void a(bjyp parambjyp)
  {
    parambjyp = parambjyp.a;
    if (parambjyp != null)
    {
      int j = parambjyp.size();
      int i = 0;
      if (i < j)
      {
        bjyq localbjyq = (bjyq)parambjyp.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localbjyq, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(bjyq parambjyq, boolean paramBoolean)
  {
    if (parambjyq != null) {
      switch (parambjyq.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        j();
      }
      return;
      b(parambjyq, paramBoolean);
      continue;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
      {
        c(parambjyq, paramBoolean);
        continue;
        if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
        {
          d(parambjyq, paramBoolean);
          continue;
          b(parambjyq, paramBoolean);
        }
      }
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    ThreadManager.executeOnFileThread(new QidianProfileCardActivity.ForwardRunnable(this, paramURLDrawable));
  }
  
  private void a(URLDrawable paramURLDrawable, String paramString)
  {
    bkzi localbkzi = bkzi.c(this);
    localbkzi.b(2131693153);
    localbkzi.b(2131693159);
    localbkzi.b(2131697986);
    localbkzi.c(2131690697);
    localbkzi.a(new bjxp(this, localbkzi, paramURLDrawable, paramString));
    localbkzi.show();
  }
  
  private void b(bjyq parambjyq, boolean paramBoolean)
  {
    if ((parambjyq.jdField_b_of_type_JavaLangString == null) || ((TextUtils.isEmpty(parambjyq.jdField_b_of_type_JavaLangString.trim())) && (!parambjyq.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709201))))) {
      return;
    }
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = parambjyq.jdField_a_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = parambjyq.jdField_b_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_a_of_type_Int = parambjyq.jdField_a_of_type_Int;
    localQidianSimpleProfileItem.jdField_b_of_type_Int = parambjyq.jdField_b_of_type_Int;
    String str;
    if (!TextUtils.isEmpty(parambjyq.d))
    {
      str = parambjyq.d;
      localQidianSimpleProfileItem.jdField_c_of_type_JavaLangString = str;
      if (localQidianSimpleProfileItem.jdField_b_of_type_Int == 0) {
        break label161;
      }
    }
    label161:
    for (boolean bool = true;; bool = false)
    {
      localQidianSimpleProfileItem.jdField_a_of_type_Boolean = bool;
      localQidianSimpleProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = parambjyq.jdField_a_of_type_Boolean;
      parambjyq = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_Bjyb.sendMessage(parambjyq);
      return;
      str = parambjyq.jdField_c_of_type_JavaLangString;
      break;
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(AppConstants.SDCARD_IMG_SAVE).mkdirs();
      str = AppConstants.SDCARD_IMG_SAVE + Utils.Crc64String(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131694684), 0).a();
          return;
        }
      }
    }
    bhdj.a(this, 230).setTitle(getString(2131718171)).setMessage(getString(2131694680)).setPositiveButton(getString(2131718048), new bjxr(this, paramURLDrawable, str)).setNegativeButton(getString(2131694291), new bjxq(this)).show();
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
    return bkyz.a(getApplicationContext(), "com.tencent.mm");
  }
  
  private void c(bjyq parambjyq, boolean paramBoolean)
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
      bjyn localbjyn = (bjyn)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = localbjyn.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = localbjyn.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbjyn.jdField_b_of_type_JavaLangString.trim();
      if (localbjyn.jdField_b_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool;
        localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambjyq.jdField_a_of_type_JavaLangString;
        localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
        localQidianCompoundProfileItem.d = localbjyn.jdField_c_of_type_JavaLangString;
        localQidianCompoundProfileItem.e = localbjyn.d;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    parambjyq = a(localArrayList);
    this.jdField_a_of_type_Bjyb.sendMessage(parambjyq);
  }
  
  private void d(bjyq parambjyq, boolean paramBoolean)
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
      bjym localbjym = (bjym)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = parambjyq.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = String.valueOf(localbjym.jdField_a_of_type_Long);
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbjym.jdField_a_of_type_JavaLangString.trim();
      localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambjyq.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    parambjyq = a(localArrayList);
    this.jdField_a_of_type_Bjyb.sendMessage(parambjyq);
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131695032);
    }
    if (this.jdField_a_of_type_Bjxa.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true)) {
      this.jdField_a_of_type_Bjxa.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((bjyi)this.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).c(Long.parseLong(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      }
      return;
      if (this.jdField_a_of_type_Bjxa.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false))
      {
        BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1);
        this.jdField_a_of_type_Bjxa.b(this, localBmqqAccountType);
      }
      else
      {
        this.jdField_a_of_type_Bjxa.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void f(int paramInt)
  {
    this.jdField_a_of_type_Bjyb.postDelayed(new QidianProfileCardActivity.3(this, paramInt), 0L);
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
    this.jdField_a_of_type_Bkzi = null;
    this.jdField_b_of_type_Bkzi = null;
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
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131299080) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364089));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368115));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368085));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bjxs(this));
    if (!bdfk.b()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130844370));
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380703));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365119));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369200));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131365022));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new bjxt(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371803));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369615));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377770));
    findViewById(2131377786).setOnClickListener(new bjxu(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370045));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bjxv(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376730));
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(new azpb(53, null));
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
        a((bjyp)localIterator.next());
        continue;
        if ((paramInt == 0) || (paramInt == 2)) {
          i();
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_Azrb, 4, paramString);
    FriendProfileCardActivity.a(this.jdField_a_of_type_Azrb);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void i()
  {
    bjyp localbjyp;
    bjyq localbjyq;
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localbjyp = new bjyp();
      localbjyp.a = new ArrayList(5);
      new bjyq();
      localbjyq = new bjyq();
      localbjyq.jdField_a_of_type_Int = 1;
      localbjyq.jdField_b_of_type_Int = 0;
      localbjyq.jdField_a_of_type_JavaLangString = anvx.a(2131709208);
      localbjyq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localbjyp.a.add(localbjyq);
      localbjyq = new bjyq();
      localbjyq.jdField_a_of_type_Int = 1;
      localbjyq.jdField_b_of_type_Int = 2;
      localbjyq.jdField_a_of_type_JavaLangString = getResources().getString(2131697781);
      localbjyq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbjyq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbjyp.a.add(localbjyq);
      localbjyq = new bjyq();
      localbjyq.jdField_a_of_type_Int = 1;
      localbjyq.jdField_b_of_type_Int = 1;
      localbjyq.jdField_a_of_type_JavaLangString = getResources().getString(2131719160);
      localbjyq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbjyq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbjyp.a.add(localbjyq);
      localbjyq = new bjyq();
      localbjyq.jdField_a_of_type_Int = 1;
      localbjyq.jdField_b_of_type_Int = 3;
      localbjyq.jdField_a_of_type_JavaLangString = getResources().getString(2131693744);
      localbjyq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbjyq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbjyp.a.add(localbjyq);
      localbjyq = new bjyq();
      localbjyq.jdField_a_of_type_Int = 1;
      localbjyq.jdField_a_of_type_JavaLangString = getResources().getString(2131694792);
      localbjyq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!nut.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!nut.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label428;
      }
      localbjyq.jdField_b_of_type_Int = 7;
      localbjyq.d = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localbjyq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localbjyq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localbjyp.a.add(localbjyq);
      a(localbjyp);
      return;
      label428:
      localbjyq.jdField_b_of_type_Int = 0;
    }
  }
  
  private void i(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Anvk == null)) {
      return;
    }
    ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
  }
  
  private void j()
  {
    this.jdField_a_of_type_Bjyb.post(new QidianProfileCardActivity.8(this));
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
  
  private void k()
  {
    ThreadManager.executeOnSubThread(new QidianProfileCardActivity.11(this));
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
        return bheg.b();
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
        if (!bdfk.b()) {}
        for (bool = true;; bool = false) {
          return new BitmapDrawable(a(paramURLImageView, localURLDrawable2, bool));
        }
      }
      localQQAppInterface = this.app;
      localDrawable = bheg.b();
      if (bdfk.b()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramURLImageView.setURLDrawableDownListener(new bjxx(this, localQQAppInterface, paramURLImageView, paramString, localDrawable, bool));
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
    label154:
    int i;
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709197)))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2131560890, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      Object localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131370012);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131371123);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131363747);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131376698);
      localImageView = (ImageView)((RelativeLayout)localObject1).findViewById(2131371121);
      ((ImageView)localObject5).setImageResource(2130844376);
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null)
      {
        localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          Iterator localIterator = ((bjyp)((Iterator)localObject5).next()).a.iterator();
          label427:
          label430:
          for (;;)
          {
            Object localObject6;
            if (localIterator.hasNext())
            {
              localObject6 = (bjyq)localIterator.next();
              if ((!((bjyq)localObject6).jdField_a_of_type_JavaLangString.equals(anvx.a(2131709194))) || (((bjyq)localObject6).jdField_a_of_type_Bjyo == null)) {
                continue;
              }
              ((TextView)localObject2).setText(((bjyq)localObject6).jdField_a_of_type_Bjyo.jdField_a_of_type_JavaLangString);
              ((TextView)localObject3).setText(((bjyq)localObject6).jdField_a_of_type_Bjyo.jdField_c_of_type_JavaLangString);
              ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, ((bjyq)localObject6).jdField_a_of_type_Bjyo.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
              this.jdField_b_of_type_JavaLangString = ((bjyq)localObject6).jdField_a_of_type_Bjyo.d;
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
                continue;
              }
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 2) {
                break label427;
              }
            }
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) || (!HttpUtil.isValidUrl(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url))) {
                break label430;
              }
              localObject6 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = getResources().getDrawable(2130844371);
              ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = getResources().getDrawable(2130844371);
              ((URLDrawable.URLDrawableOptions)localObject6).mPlayGifImage = false;
              ((URLDrawable.URLDrawableOptions)localObject6).mGifRoundCorner = 0.0F;
              ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = 20;
              ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = 20;
              localObject6 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url, (URLDrawable.URLDrawableOptions)localObject6);
              if (localImageView == null) {
                break label154;
              }
              localImageView.setMaxWidth(20);
              localImageView.setMaxHeight(20);
              localImageView.setVisibility(0);
              localImageView.setImageDrawable((Drawable)localObject6);
              break label154;
              break;
            }
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709191)))
    {
      i = 2130844382;
      label509:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2131560894, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131370012);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131371123);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131376698);
      localImageView = (ImageView)((RelativeLayout)localObject2).findViewById(2131371121);
      ((TextView)localObject3).setText(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      if (paramQidianSimpleProfileItem.jdField_a_of_type_Boolean) {
        break label1018;
      }
      ((ImageView)localObject4).setVisibility(4);
      ((RelativeLayout)localObject2).setLongClickable(true);
      ((RelativeLayout)localObject2).setTag(paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString);
      ((RelativeLayout)localObject2).setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      label626:
      if (!paramQidianSimpleProfileItem.jdField_c_of_type_Boolean) {
        break label1067;
      }
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      ((ImageView)localObject1).setImageResource(i);
      localObject1 = localObject2;
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709202))) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo == null) {
        break;
      }
      localObject3 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((bjyp)((Iterator)localObject3).next()).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (bjyq)((Iterator)localObject1).next();
          if (((bjyq)localObject4).jdField_a_of_type_JavaLangString.equals(anvx.a(2131709198))) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, ((bjyq)localObject4).f + "|" + ((bjyq)localObject4).g));
          }
        }
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709193)))
      {
        i = 2130844380;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709195)))
      {
        i = 2130844378;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709203)))
      {
        i = 2130845756;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709192)))
      {
        i = 2130844375;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709199)))
      {
        i = 2130844379;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709206)))
      {
        i = 2130844376;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709196)))
      {
        i = 2130844381;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(anvx.a(2131709205))) {
        return null;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))
      {
        i = 2130844383;
        break label509;
      }
      i = 2130844377;
      break label509;
      label1018:
      ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
      ((RelativeLayout)localObject2).setClickable(true);
      ((RelativeLayout)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((ImageView)localObject4).setVisibility(0);
      break label626;
      label1067:
      localImageView.setVisibility(8);
    }
  }
  
  public View a(List<QidianProfileCardActivity.QidianCompoundProfileItem> paramList)
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
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131560889, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131378658);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131369048);
        ((TextView)localObject1).setText(((QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(0)).jdField_c_of_type_JavaLangString);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2131560888, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131368381);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131371803);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131364434);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131365513);
    localURLImageView.post(new QidianProfileCardActivity.10(this, (QidianProfileCardActivity.QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_b_of_type_JavaLangString);
    ((LinearLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 0)
    {
      localTextView2.setText(2131697992);
      ((LinearLayout)localObject1).setTag(new azpb(49, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      label243:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int != 0) || (!((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean)) {
        break label385;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130842688);
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
        localTextView2.setText(2131697993);
        ((LinearLayout)localObject1).setTag(new azpb(50, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).e));
        break label243;
      }
      localTextView2.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString);
      ((LinearLayout)localObject1).setTag(new azpb(51, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      break label243;
      label385:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 1) && (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130844400);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this, getResources().getDimensionPixelSize(2131299080));
    }
    this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bisl.c(paramInt);
    this.jdField_a_of_type_Bisl.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bisy == null) {
      this.jdField_a_of_type_Bisy = new bisy(this);
    }
    this.jdField_a_of_type_Bisy.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
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
        if (paramInt == 1) {
          localObject = a(paramURLImageView, paramString);
        } else {
          localObject = this.app.getTroopFaceDrawable(paramString);
        }
      }
    }
  }
  
  public void a(bjyn parambjyn)
  {
    Object localObject = parambjyn.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, 0, 2131560898, null, null, getString(2131690845), getString(2131690845), new bjxn(this), null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageCount(super.getString(2131697991));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(true);
    }
    localObject = b((URLImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.framePreviewImage, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPreviewImage((Drawable)localObject, true, 1);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow() != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow().findViewById(2131367272).setOnLongClickListener(new bjxo(this, (Drawable)localObject, parambjyn));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Bkzi == null)
    {
      this.jdField_b_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      this.jdField_b_of_type_Bkzi.a(super.getResources().getStringArray(2130968586)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bjxa.d(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Bkzi.c(super.getResources().getStringArray(2130968586)[1]);
      }
      this.jdField_b_of_type_Bkzi.d(super.getResources().getStringArray(2130968586)[2]);
      this.jdField_b_of_type_Bkzi.a(new bjxi(this, paramString));
    }
    this.jdField_b_of_type_Bkzi.show();
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
    ThreadManager.post(new QidianProfileCardActivity.25(this, paramArrayOfByte), 8, null, true);
  }
  
  public boolean a()
  {
    if (bjxa.a(this.jdField_b_of_type_Int)) {
      return true;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Bjxa.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.jdField_c_of_type_Int);
    }
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      a(2131695032);
      return true;
      nwu.a(this, null, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true, -1, true, -1);
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
        return bheg.b();
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
      paramURLImageView.setURLDrawableDownListener(new bjxx(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130850820), false));
      return localDrawable;
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 6)) {}
    label306:
    for (;;)
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if (this.jdField_c_of_type_Int == 6)
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131693173, 2131560896, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new azpb(7, null));
        }
        if ((this.jdField_c_of_type_Int != 1) || (!this.jdField_a_of_type_Bjxa.d(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label208;
        }
        a(2131697988, 2131560896, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new azpb(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label306;
        }
        a(2131698376, 2131560895, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new azpb(8, Integer.valueOf(this.jdField_c_of_type_Int)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        label208:
        if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_Bjxa.c(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          a(2131693198, 2131560896, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new azpb(20, null));
        } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
          a(2131693198, 2131560896, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new azpb(20, null));
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
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.find(QidianExternalInfo.class, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.find(QidianProfileUiInfo.class, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqDataCard = localanvk.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localEntityManager.find(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
      if ((paramInt == 0) || (paramInt == 2))
      {
        localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localEntityManager.find(BmqqUserSimpleInfo.class, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          return;
        }
        finally
        {
          if (localEntityManager != null) {
            localEntityManager.close();
          }
        }
      }
      if (paramInt != 6) {
        continue;
      }
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localEntityManager.find(QidianExternalInfo.class, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localEntityManager.find(QidianProfileUiInfo.class, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
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
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this, null));
      this.jdField_a_of_type_Bkzi.a(super.getResources().getStringArray(2130968585)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bjxa.d(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bkzi.a(super.getResources().getStringArray(2130968585)[1], 1);
      }
      this.jdField_a_of_type_Bkzi.a(super.getResources().getStringArray(2130968585)[2], 1);
      this.jdField_a_of_type_Bkzi.d(super.getResources().getStringArray(2130968585)[3]);
      this.jdField_a_of_type_Bkzi.a(new bjxj(this, paramString));
    }
    this.jdField_a_of_type_Bkzi.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_Bjyb != null) {
      this.jdField_a_of_type_Bjyb.sendMessage(localMessage);
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
    uuc.a(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Azrb == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      localObject = aqkw.a(this.app, this.jdField_a_of_type_Azrb);
      localIntent = bhaa.a(localIntent, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
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
      String str = this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Anvk.b(str))
      {
        paramInt = 0;
        localObject = ContactUtils.getFriendNickName(this.app, str);
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
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_Azrb);
  }
  
  public void d(String paramString)
  {
    TroopUtils.openTroopInfoActivity(this, TroopInfoActivity.a(paramString, 31), 2);
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
      } while (bhbx.a(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i, paramIntent));
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
    this.jdField_a_of_type_Bjxa = ((bjxa)this.app.getManager(QQManagerFactory.QIDIAN_MANAGER));
    this.jdField_a_of_type_Anvk = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_Anri = ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    try
    {
      setContentView(2131560887);
      this.jdField_d_of_type_Int = AIOUtils.dp2px(16.0F, getResources());
      this.e = AIOUtils.dp2px(10.0F, getResources());
      this.f = AIOUtils.dp2px(8.0F, getResources());
      this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramBundle, 104);
      }
      this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
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
    if ((this.jdField_a_of_type_Anvk != null) && (this.jdField_a_of_type_Anvk.b(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Azrb.jdField_a_of_type_ArrayOfJavaLangString = new String[8];
    g();
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.app.addObserver(this.jdField_a_of_type_Nur);
    this.app.addObserver(this.jdField_a_of_type_Bjyh);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Bjyb = new bjyb(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    ThreadManager.post(new QidianProfileCardActivity.1(this), 8, null, true);
    e(this.jdField_c_of_type_Int);
    h();
    k();
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
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Bjyh);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_Nur);
    g();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      e(this.jdField_c_of_type_Int);
    }
    if ((localAllInOne != null) && (!localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131693229, 1);
      return;
    }
    nwu.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_Azrb.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void f()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) {
      this.jdField_a_of_type_Azrb.jdField_a_of_type_Bgvk.a.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.nickname;
    }
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_Azrb, this.jdField_a_of_type_AndroidAppDialog);
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
      Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */