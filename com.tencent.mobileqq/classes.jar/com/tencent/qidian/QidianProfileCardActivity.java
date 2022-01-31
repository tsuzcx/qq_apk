package com.tencent.qidian;

import aciy;
import ajed;
import ajfi;
import ajfo;
import ajjh;
import ajjj;
import ajjy;
import alqg;
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
import aqdz;
import atmp;
import atmq;
import atuw;
import atwx;
import awnu;
import azlj;
import azwp;
import azyk;
import azzz;
import babh;
import babr;
import bacm;
import bafb;
import bbms;
import bbmy;
import bbne;
import bcpm;
import bcpn;
import bcpq;
import bcpr;
import bcpu;
import bcpv;
import bcpw;
import bcpx;
import bcpy;
import bcpz;
import bcqa;
import bcqb;
import bcqc;
import bcqd;
import bcqe;
import bcqf;
import bcqg;
import bcqh;
import bcqi;
import bcqj;
import bcqk;
import bcql;
import bcqo;
import bcqu;
import bcqv;
import bcqz;
import bcra;
import bcrb;
import bcrc;
import bcrd;
import begr;
import behe;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qzone.QzonePluginProxyActivity;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mnx;
import mnz;
import mpl;
import mqb;
import rtr;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  public int a;
  public ajfi a;
  private ajfo jdField_a_of_type_Ajfo = new bcpx(this);
  private ajjh jdField_a_of_type_Ajjh = new bcpq(this);
  public ajjj a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bcpu(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bcpr(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  aqdz jdField_a_of_type_Aqdz = new aqdz("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  public atwx a;
  bafb jdField_a_of_type_Bafb;
  public bbms a;
  private bbne jdField_a_of_type_Bbne;
  bcpm jdField_a_of_type_Bcpm = new bcqj(this);
  public bcpn a;
  private bcqo jdField_a_of_type_Bcqo;
  private bcqu jdField_a_of_type_Bcqu = new bcpy(this);
  private begr jdField_a_of_type_Begr;
  public BmqqUserSimpleInfo a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private String jdField_a_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, bcql> a;
  private mnx jdField_a_of_type_Mnx = new bcpz(this);
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public ImageView b;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private begr jdField_b_of_type_Begr;
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
    this.jdField_a_of_type_Atwx = new atwx();
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
          paramQQAppInterface = QQAppInterface.a(paramURLDrawable, 50, 50);
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
        return QQAppInterface.a(paramURLDrawable, 50, 50);
        paramURLDrawable = bacm.a(paramQQAppInterface);
        paramQQAppInterface = paramURLDrawable;
      } while (!paramBoolean);
      return QQAppInterface.a(paramURLDrawable, 50, 50);
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
    int i = getResources().getDimensionPixelSize(2131166806);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131312607);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt2 != 2131494953) {
        break label122;
      }
      localButton.setBackgroundResource(2130843495);
      localButton.setTextColor(getResources().getColor(2131100551));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
      return localButton;
      label122:
      if (paramInt2 == 2131494952)
      {
        localButton.setBackgroundResource(2130843494);
        localButton.setTextColor(getResources().getColor(2131100550));
      }
    }
  }
  
  private atuw a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new atuw(52, paramString2);
    case 2: 
      return new atuw(4, paramString2);
    case 3: 
      return new atuw(47, paramString2);
    case 4: 
      return new atuw(48, new String[] { paramString1, paramString2 });
    case 7: 
      return new atuw(54, paramString3);
    case 6: 
      return new atuw(75, paramString2);
    case 5: 
      return new atuw(76, paramString3);
    }
    return new atuw(82, paramString3);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i)) {
      return this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
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
    return this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
  }
  
  private void a(bcrc parambcrc)
  {
    parambcrc = parambcrc.a;
    if (parambcrc != null)
    {
      int j = parambcrc.size();
      int i = 0;
      if (i < j)
      {
        bcrd localbcrd = (bcrd)parambcrc.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localbcrd, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(bcrd parambcrd, boolean paramBoolean)
  {
    if (parambcrd != null) {
      switch (parambcrd.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        j();
      }
      return;
      b(parambcrd, paramBoolean);
      continue;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
      {
        c(parambcrd, paramBoolean);
        continue;
        if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
        {
          d(parambcrd, paramBoolean);
          continue;
          b(parambcrd, paramBoolean);
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
    begr localbegr = begr.c(this);
    localbegr.b(2131627742);
    localbegr.b(2131627752);
    localbegr.b(2131632505);
    localbegr.c(2131625035);
    localbegr.a(new bcqc(this, localbegr, paramURLDrawable, paramString));
    localbegr.show();
  }
  
  private void b(bcrd parambcrd, boolean paramBoolean)
  {
    if ((parambcrd.jdField_b_of_type_JavaLangString == null) || ((TextUtils.isEmpty(parambcrd.jdField_b_of_type_JavaLangString.trim())) && (!parambcrd.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643957))))) {
      return;
    }
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = parambcrd.jdField_a_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = parambcrd.jdField_b_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_a_of_type_Int = parambcrd.jdField_a_of_type_Int;
    localQidianSimpleProfileItem.jdField_b_of_type_Int = parambcrd.jdField_b_of_type_Int;
    String str;
    if (!TextUtils.isEmpty(parambcrd.d))
    {
      str = parambcrd.d;
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
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = parambcrd.jdField_a_of_type_Boolean;
      parambcrd = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_Bcqo.sendMessage(parambcrd);
      return;
      str = parambcrd.jdField_c_of_type_JavaLangString;
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
      new File(ajed.ba).mkdirs();
      str = ajed.ba + Utils.Crc64String(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          bbmy.a(this, getString(2131629508), 0).a();
          return;
        }
      }
    }
    babr.a(this, 230).setTitle(getString(2131653010)).setMessage(getString(2131629501)).setPositiveButton(getString(2131652888), new bcqe(this, paramURLDrawable, str)).setNegativeButton(getString(2131628983), new bcqd(this)).show();
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
  
  private void c(bcrd parambcrd, boolean paramBoolean)
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
      bcra localbcra = (bcra)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = localbcra.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = localbcra.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbcra.jdField_b_of_type_JavaLangString.trim();
      if (localbcra.jdField_b_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool;
        localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambcrd.jdField_a_of_type_JavaLangString;
        localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
        localQidianCompoundProfileItem.d = localbcra.jdField_c_of_type_JavaLangString;
        localQidianCompoundProfileItem.e = localbcra.d;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    parambcrd = a(localArrayList);
    this.jdField_a_of_type_Bcqo.sendMessage(parambcrd);
  }
  
  private void d(bcrd parambcrd, boolean paramBoolean)
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
      bcqz localbcqz = (bcqz)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = parambcrd.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = String.valueOf(localbcqz.jdField_a_of_type_Long);
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbcqz.jdField_a_of_type_JavaLangString.trim();
      localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambcrd.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    parambcrd = a(localArrayList);
    this.jdField_a_of_type_Bcqo.sendMessage(parambcrd);
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131629938);
    }
    if (this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true)) {
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((bcqv)this.app.a(85)).c(Long.parseLong(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      }
      return;
      if (this.jdField_a_of_type_Bcpn.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false))
      {
        BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1);
        this.jdField_a_of_type_Bcpn.b(this, localBmqqAccountType);
      }
      else
      {
        this.jdField_a_of_type_Bcpn.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void f(int paramInt)
  {
    this.jdField_a_of_type_Bcqo.postDelayed(new QidianProfileCardActivity.3(this, paramInt), 0L);
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
    this.jdField_a_of_type_Begr = null;
    this.jdField_b_of_type_Begr = null;
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
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131167766) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298149));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301817));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301787));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bcqf(this));
    if (!awnu.b()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843491));
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131313013));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299097));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302777));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131299006));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new bcqg(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304981));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303112));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310414));
    findViewById(2131310430).setOnClickListener(new bcqh(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303472));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bcqi(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309558));
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(new atuw(53, null));
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
        a((bcrc)localIterator.next());
        continue;
        if ((paramInt == 0) || (paramInt == 2)) {
          i();
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_Atwx, 4, paramString);
    FriendProfileCardActivity.b(this.jdField_a_of_type_Atwx);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void i()
  {
    bcrc localbcrc;
    bcrd localbcrd;
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localbcrc = new bcrc();
      localbcrc.a = new ArrayList(5);
      new bcrd();
      localbcrd = new bcrd();
      localbcrd.jdField_a_of_type_Int = 1;
      localbcrd.jdField_b_of_type_Int = 0;
      localbcrd.jdField_a_of_type_JavaLangString = ajjy.a(2131643964);
      localbcrd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localbcrc.a.add(localbcrd);
      localbcrd = new bcrd();
      localbcrd.jdField_a_of_type_Int = 1;
      localbcrd.jdField_b_of_type_Int = 2;
      localbcrd.jdField_a_of_type_JavaLangString = getResources().getString(2131632356);
      localbcrd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbcrd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbcrc.a.add(localbcrd);
      localbcrd = new bcrd();
      localbcrd.jdField_a_of_type_Int = 1;
      localbcrd.jdField_b_of_type_Int = 1;
      localbcrd.jdField_a_of_type_JavaLangString = getResources().getString(2131654132);
      localbcrd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbcrd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbcrc.a.add(localbcrd);
      localbcrd = new bcrd();
      localbcrd.jdField_a_of_type_Int = 1;
      localbcrd.jdField_b_of_type_Int = 3;
      localbcrd.jdField_a_of_type_JavaLangString = getResources().getString(2131628423);
      localbcrd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbcrd.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbcrc.a.add(localbcrd);
      localbcrd = new bcrd();
      localbcrd.jdField_a_of_type_Int = 1;
      localbcrd.jdField_a_of_type_JavaLangString = getResources().getString(2131629685);
      localbcrd.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!mnz.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!mnz.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label428;
      }
      localbcrd.jdField_b_of_type_Int = 7;
      localbcrd.d = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localbcrd.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localbcrd.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localbcrc.a.add(localbcrd);
      a(localbcrc);
      return;
      label428:
      localbcrd.jdField_b_of_type_Int = 0;
    }
  }
  
  private void i(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Ajjj == null)) {
      return;
    }
    ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
  }
  
  private void j()
  {
    this.jdField_a_of_type_Bcqo.post(new QidianProfileCardActivity.8(this));
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
    j("http://weixin.qq.com/d");
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
        return bacm.b();
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
        if (!awnu.b()) {}
        for (bool = true;; bool = false) {
          return new BitmapDrawable(a(paramURLImageView, localURLDrawable2, bool));
        }
      }
      localQQAppInterface = this.app;
      localDrawable = bacm.b();
      if (awnu.b()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramURLImageView.setURLDrawableDownListener(new bcqk(this, localQQAppInterface, paramURLImageView, paramString, localDrawable, bool));
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643953)))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2131494947, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      Object localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131303445);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131304458);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131297842);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131309531);
      localImageView = (ImageView)((RelativeLayout)localObject1).findViewById(2131304456);
      ((ImageView)localObject5).setImageResource(2130843497);
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null)
      {
        localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          Iterator localIterator = ((bcrc)((Iterator)localObject5).next()).a.iterator();
          label427:
          label430:
          for (;;)
          {
            Object localObject6;
            if (localIterator.hasNext())
            {
              localObject6 = (bcrd)localIterator.next();
              if ((!((bcrd)localObject6).jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643950))) || (((bcrd)localObject6).jdField_a_of_type_Bcrb == null)) {
                continue;
              }
              ((TextView)localObject2).setText(((bcrd)localObject6).jdField_a_of_type_Bcrb.jdField_a_of_type_JavaLangString);
              ((TextView)localObject3).setText(((bcrd)localObject6).jdField_a_of_type_Bcrb.jdField_c_of_type_JavaLangString);
              ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, ((bcrd)localObject6).jdField_a_of_type_Bcrb.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
              this.jdField_b_of_type_JavaLangString = ((bcrd)localObject6).jdField_a_of_type_Bcrb.d;
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
                continue;
              }
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 2) {
                break label427;
              }
            }
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) || (!mpl.a(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url))) {
                break label430;
              }
              localObject6 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = getResources().getDrawable(2130843492);
              ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = getResources().getDrawable(2130843492);
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643947)))
    {
      i = 2130843503;
      label509:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2131494951, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131303445);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131304458);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131309531);
      localImageView = (ImageView)((RelativeLayout)localObject2).findViewById(2131304456);
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
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643958))) {
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
        localObject1 = ((bcrc)((Iterator)localObject3).next()).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (bcrd)((Iterator)localObject1).next();
          if (((bcrd)localObject4).jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643954))) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, ((bcrd)localObject4).f + "|" + ((bcrd)localObject4).g));
          }
        }
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643949)))
      {
        i = 2130843501;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643951)))
      {
        i = 2130843499;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643959)))
      {
        i = 2130844841;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643948)))
      {
        i = 2130843496;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643955)))
      {
        i = 2130843500;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643962)))
      {
        i = 2130843497;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643952)))
      {
        i = 2130843502;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajjy.a(2131643961))) {
        return null;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))
      {
        i = 2130843504;
        break label509;
      }
      i = 2130843498;
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
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131494946, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131311220);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131302702);
        ((TextView)localObject1).setText(((QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(0)).jdField_c_of_type_JavaLangString);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2131494945, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131302061);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131304981);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131298465);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131299450);
    localURLImageView.post(new QidianProfileCardActivity.10(this, (QidianProfileCardActivity.QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_b_of_type_JavaLangString);
    ((LinearLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 0)
    {
      localTextView2.setText(2131632511);
      ((LinearLayout)localObject1).setTag(new atuw(49, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      label243:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int != 0) || (!((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean)) {
        break label385;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130842031);
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
        localTextView2.setText(2131632512);
        ((LinearLayout)localObject1).setTag(new atuw(50, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).e));
        break label243;
      }
      localTextView2.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString);
      ((LinearLayout)localObject1).setTag(new atuw(51, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      break label243;
      label385:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 1) && (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130843522);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this, getResources().getDimensionPixelSize(2131167766));
    }
    this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bbms.c(paramInt);
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bbne == null) {
      this.jdField_a_of_type_Bbne = new bbne(this);
    }
    this.jdField_a_of_type_Bbne.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
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
        localObject = azwp.a(this.app, 1, paramString);
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
  
  public void a(bcra parambcra)
  {
    Object localObject = parambcra.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = babr.a(this, 0, 2131494955, null, null, getString(2131625271), getString(2131625271), new bcqa(this), null);
      this.jdField_a_of_type_Bafb.setMessageCount(super.getString(2131632510));
      this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(true);
    }
    localObject = b((URLImageView)this.jdField_a_of_type_Bafb.framePreviewImage, (String)localObject);
    this.jdField_a_of_type_Bafb.setPreviewImage((Drawable)localObject, true, 1);
    if (this.jdField_a_of_type_Bafb.getWindow() != null) {
      this.jdField_a_of_type_Bafb.getWindow().findViewById(2131301079).setOnLongClickListener(new bcqb(this, (Drawable)localObject, parambcra));
    }
    this.jdField_a_of_type_Bafb.show();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Begr == null)
    {
      this.jdField_b_of_type_Begr = ((begr)behe.a(this, null));
      this.jdField_b_of_type_Begr.a(super.getResources().getStringArray(2130903047)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bcpn.d(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Begr.c(super.getResources().getStringArray(2130903047)[1]);
      }
      this.jdField_b_of_type_Begr.d(super.getResources().getStringArray(2130903047)[2]);
      this.jdField_b_of_type_Begr.a(new bcpv(this, paramString));
    }
    this.jdField_b_of_type_Begr.show();
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
    if (bcpn.a(this.jdField_b_of_type_Int)) {
      return true;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.jdField_c_of_type_Int);
    }
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      a(2131629938);
      return true;
      mqb.a(this, null, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true, -1, true, -1);
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
        return bacm.b();
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
      paramURLImageView.setURLDrawableDownListener(new bcqk(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130849384), false));
      return localDrawable;
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 2) && (this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 6)) {}
    label314:
    for (;;)
    {
      return;
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 6))
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131627782, 2131494953, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new atuw(7, null));
        }
        if ((this.jdField_c_of_type_Int != 1) || (!this.jdField_a_of_type_Bcpn.d(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label216;
        }
        a(2131632507, 2131494953, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new atuw(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label314;
        }
        a(2131632979, 2131494952, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new atuw(8, Integer.valueOf(this.jdField_c_of_type_Int)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        label216:
        if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_Bcpn.c(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          a(2131627815, 2131494953, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new atuw(20, null));
        } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
          a(2131627815, 2131494953, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new atuw(20, null));
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    atmp localatmp;
    if (paramInt == 1) {
      localatmp = this.app.getEntityManagerFactory().createEntityManager();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localatmp.a(QidianExternalInfo.class, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localatmp.a(QidianProfileUiInfo.class, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        ajjj localajjj = (ajjj)this.app.getManager(51);
        this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqDataCard = localajjj.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localatmp.a(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localatmp != null) {
          localatmp.a();
        }
      }
      if ((paramInt == 0) || (paramInt == 2))
      {
        localatmp = this.app.getEntityManagerFactory().createEntityManager();
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localatmp.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          return;
        }
        finally
        {
          if (localatmp != null) {
            localatmp.a();
          }
        }
      }
      if (paramInt != 6) {
        continue;
      }
      localatmp = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localatmp.a(QidianExternalInfo.class, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localatmp.a(QidianProfileUiInfo.class, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
      finally
      {
        if (localatmp != null) {
          localatmp.a();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = ((begr)behe.a(this, null));
      this.jdField_a_of_type_Begr.a(super.getResources().getStringArray(2130903046)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bcpn.d(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Begr.a(super.getResources().getStringArray(2130903046)[1], 1);
      }
      this.jdField_a_of_type_Begr.a(super.getResources().getStringArray(2130903046)[2], 1);
      this.jdField_a_of_type_Begr.d(super.getResources().getStringArray(2130903046)[3]);
      this.jdField_a_of_type_Begr.a(new bcpw(this, paramString));
    }
    this.jdField_a_of_type_Begr.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_Bcqo != null) {
      this.jdField_a_of_type_Bcqo.sendMessage(localMessage);
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
    rtr.a(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Atwx == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ((ajjj)this.app.getManager(51)).e(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      localObject = alqg.a(this.app, this.jdField_a_of_type_Atwx);
      localIntent = azyk.a(localIntent, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
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
      String str = this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ajjj.b(str))
      {
        paramInt = 0;
        localObject = babh.i(this.app, str);
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
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_Atwx);
  }
  
  public void d(String paramString)
  {
    azlj.a(this, TroopInfoActivity.a(paramString, 31), 2);
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
      } while (azzz.a(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i, paramIntent));
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
    this.jdField_a_of_type_Bcpn = ((bcpn)this.app.getManager(165));
    this.jdField_a_of_type_Ajjj = ((ajjj)this.app.getManager(51));
    this.jdField_a_of_type_Ajfi = ((ajfi)this.app.a(2));
    try
    {
      setContentView(2131494944);
      this.jdField_d_of_type_Int = aciy.a(16.0F, getResources());
      this.e = aciy.a(10.0F, getResources());
      this.f = aciy.a(8.0F, getResources());
      this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramBundle, 104);
      }
      this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
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
    if ((this.jdField_a_of_type_Ajjj != null) && (this.jdField_a_of_type_Ajjj.b(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Atwx.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
    g();
    this.app.addObserver(this.jdField_a_of_type_Ajjh);
    this.app.addObserver(this.jdField_a_of_type_Mnx);
    this.app.addObserver(this.jdField_a_of_type_Bcqu);
    this.app.addObserver(this.jdField_a_of_type_Ajfo);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Bcqo = new bcqo(this);
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
    this.app.removeObserver(this.jdField_a_of_type_Ajjh);
    this.app.removeObserver(this.jdField_a_of_type_Bcqu);
    this.app.removeObserver(this.jdField_a_of_type_Ajfo);
    this.app.removeObserver(this.jdField_a_of_type_Mnx);
    g();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      e(this.jdField_c_of_type_Int);
    }
    if ((localAllInOne != null) && (!localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131627817, 1);
      return;
    }
    mqb.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_Atwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void f()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_Atwx, this.jdField_a_of_type_AndroidAppDialog);
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
      Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), null);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */