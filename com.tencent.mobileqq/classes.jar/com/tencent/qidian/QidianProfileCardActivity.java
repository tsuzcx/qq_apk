package com.tencent.qidian;

import aekt;
import aljq;
import alkv;
import allb;
import alox;
import aloz;
import alpo;
import android.app.Activity;
import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
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
import anvv;
import asor;
import awbw;
import awbx;
import awki;
import awmk;
import azib;
import bclo;
import bcxb;
import bcyw;
import bdal;
import bdbt;
import bdcd;
import bdda;
import bdfq;
import bepp;
import beqa;
import bftz;
import bfua;
import bfud;
import bfue;
import bfuh;
import bfui;
import bfuj;
import bfuk;
import bful;
import bfum;
import bfun;
import bfuo;
import bfup;
import bfuq;
import bfur;
import bfus;
import bfut;
import bfuu;
import bfuv;
import bfuw;
import bfux;
import bfuy;
import bfvb;
import bfvh;
import bfvi;
import bfvm;
import bfvn;
import bfvo;
import bfvp;
import bfvq;
import bhpe;
import bhpy;
import bhql;
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
import com.tencent.mobileqq.widget.QQToast;
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
import nbn;
import nbp;
import ndd;
import ndv;
import syb;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  public int a;
  public alkv a;
  private allb jdField_a_of_type_Allb = new bfuk(this);
  private alox jdField_a_of_type_Alox = new bfud(this);
  public aloz a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bfuh(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bfue(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  asor jdField_a_of_type_Asor = new asor("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  public awmk a;
  bdfq jdField_a_of_type_Bdfq;
  public bepp a;
  private beqa jdField_a_of_type_Beqa;
  bftz jdField_a_of_type_Bftz = new bfuw(this);
  public bfua a;
  private bfvb jdField_a_of_type_Bfvb;
  private bfvh jdField_a_of_type_Bfvh = new bful(this);
  private bhpy jdField_a_of_type_Bhpy;
  public BmqqUserSimpleInfo a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private String jdField_a_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, bfuy> a;
  private nbn jdField_a_of_type_Nbn = new bfum(this);
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public ImageView b;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bhpy jdField_b_of_type_Bhpy;
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
    this.jdField_a_of_type_Awmk = new awmk();
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
        paramURLDrawable = bdda.a(paramQQAppInterface);
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
    int i = getResources().getDimensionPixelSize(2131297917);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131379049);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt2 != 2131560702) {
        break label122;
      }
      localButton.setBackgroundResource(2130843939);
      localButton.setTextColor(getResources().getColor(2131166188));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
      return localButton;
      label122:
      if (paramInt2 == 2131560701)
      {
        localButton.setBackgroundResource(2130843938);
        localButton.setTextColor(getResources().getColor(2131166187));
      }
    }
  }
  
  private awki a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new awki(52, paramString2);
    case 2: 
      return new awki(4, paramString2);
    case 3: 
      return new awki(47, paramString2);
    case 4: 
      return new awki(48, new String[] { paramString1, paramString2 });
    case 7: 
      return new awki(54, paramString3);
    case 6: 
      return new awki(75, paramString2);
    case 5: 
      return new awki(76, paramString3);
    }
    return new awki(82, paramString3);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i)) {
      return this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
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
    return this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
  }
  
  private void a(bfvp parambfvp)
  {
    parambfvp = parambfvp.a;
    if (parambfvp != null)
    {
      int j = parambfvp.size();
      int i = 0;
      if (i < j)
      {
        bfvq localbfvq = (bfvq)parambfvp.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localbfvq, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(bfvq parambfvq, boolean paramBoolean)
  {
    if (parambfvq != null) {
      switch (parambfvq.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        j();
      }
      return;
      b(parambfvq, paramBoolean);
      continue;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
      {
        c(parambfvq, paramBoolean);
        continue;
        if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
        {
          d(parambfvq, paramBoolean);
          continue;
          b(parambfvq, paramBoolean);
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
    bhpy localbhpy = bhpy.c(this);
    localbhpy.b(2131693485);
    localbhpy.b(2131693495);
    localbhpy.b(2131698541);
    localbhpy.c(2131690648);
    localbhpy.a(new bfup(this, localbhpy, paramURLDrawable, paramString));
    localbhpy.show();
  }
  
  private void b(bfvq parambfvq, boolean paramBoolean)
  {
    if ((parambfvq.jdField_b_of_type_JavaLangString == null) || ((TextUtils.isEmpty(parambfvq.jdField_b_of_type_JavaLangString.trim())) && (!parambfvq.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710125))))) {
      return;
    }
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = parambfvq.jdField_a_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = parambfvq.jdField_b_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_a_of_type_Int = parambfvq.jdField_a_of_type_Int;
    localQidianSimpleProfileItem.jdField_b_of_type_Int = parambfvq.jdField_b_of_type_Int;
    String str;
    if (!TextUtils.isEmpty(parambfvq.d))
    {
      str = parambfvq.d;
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
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = parambfvq.jdField_a_of_type_Boolean;
      parambfvq = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_Bfvb.sendMessage(parambfvq);
      return;
      str = parambfvq.jdField_c_of_type_JavaLangString;
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
      new File(aljq.bd).mkdirs();
      str = aljq.bd + Utils.Crc64String(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          QQToast.a(this, getString(2131695348), 0).a();
          return;
        }
      }
    }
    bdcd.a(this, 230).setTitle(getString(2131719323)).setMessage(getString(2131695341)).setPositiveButton(getString(2131719197), new bfur(this, paramURLDrawable, str)).setNegativeButton(getString(2131694804), new bfuq(this)).show();
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
    return bhpe.a(getApplicationContext(), "com.tencent.mm");
  }
  
  private void c(bfvq parambfvq, boolean paramBoolean)
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
      bfvn localbfvn = (bfvn)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = localbfvn.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = localbfvn.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbfvn.jdField_b_of_type_JavaLangString.trim();
      if (localbfvn.jdField_b_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool;
        localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambfvq.jdField_a_of_type_JavaLangString;
        localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
        localQidianCompoundProfileItem.d = localbfvn.jdField_c_of_type_JavaLangString;
        localQidianCompoundProfileItem.e = localbfvn.d;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    parambfvq = a(localArrayList);
    this.jdField_a_of_type_Bfvb.sendMessage(parambfvq);
  }
  
  private void d(bfvq parambfvq, boolean paramBoolean)
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
      bfvm localbfvm = (bfvm)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = parambfvq.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = String.valueOf(localbfvm.jdField_a_of_type_Long);
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbfvm.jdField_a_of_type_JavaLangString.trim();
      localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambfvq.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    parambfvq = a(localArrayList);
    this.jdField_a_of_type_Bfvb.sendMessage(parambfvq);
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131695778);
    }
    if (this.jdField_a_of_type_Bfua.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true)) {
      this.jdField_a_of_type_Bfua.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((bfvi)this.app.a(85)).c(Long.parseLong(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      }
      return;
      if (this.jdField_a_of_type_Bfua.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false))
      {
        BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1);
        this.jdField_a_of_type_Bfua.b(this, localBmqqAccountType);
      }
      else
      {
        this.jdField_a_of_type_Bfua.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void f(int paramInt)
  {
    this.jdField_a_of_type_Bfvb.postDelayed(new QidianProfileCardActivity.3(this, paramInt), 0L);
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
    this.jdField_a_of_type_Bhpy = null;
    this.jdField_b_of_type_Bhpy = null;
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
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131298914) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363757));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367555));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367527));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bfus(this));
    if (!azib.b()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843935));
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379464));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364735));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368584));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131364643));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new bfut(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370958));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368971));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376710));
    findViewById(2131376726).setOnClickListener(new bfuu(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369372));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bfuv(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375790));
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(new awki(53, null));
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
        a((bfvp)localIterator.next());
        continue;
        if ((paramInt == 0) || (paramInt == 2)) {
          i();
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_Awmk, 4, paramString);
    FriendProfileCardActivity.b(this.jdField_a_of_type_Awmk);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void i()
  {
    bfvp localbfvp;
    bfvq localbfvq;
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localbfvp = new bfvp();
      localbfvp.a = new ArrayList(5);
      new bfvq();
      localbfvq = new bfvq();
      localbfvq.jdField_a_of_type_Int = 1;
      localbfvq.jdField_b_of_type_Int = 0;
      localbfvq.jdField_a_of_type_JavaLangString = alpo.a(2131710132);
      localbfvq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localbfvp.a.add(localbfvq);
      localbfvq = new bfvq();
      localbfvq.jdField_a_of_type_Int = 1;
      localbfvq.jdField_b_of_type_Int = 2;
      localbfvq.jdField_a_of_type_JavaLangString = getResources().getString(2131698383);
      localbfvq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbfvq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbfvp.a.add(localbfvq);
      localbfvq = new bfvq();
      localbfvq.jdField_a_of_type_Int = 1;
      localbfvq.jdField_b_of_type_Int = 1;
      localbfvq.jdField_a_of_type_JavaLangString = getResources().getString(2131720569);
      localbfvq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbfvq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbfvp.a.add(localbfvq);
      localbfvq = new bfvq();
      localbfvq.jdField_a_of_type_Int = 1;
      localbfvq.jdField_b_of_type_Int = 3;
      localbfvq.jdField_a_of_type_JavaLangString = getResources().getString(2131694182);
      localbfvq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbfvq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbfvp.a.add(localbfvq);
      localbfvq = new bfvq();
      localbfvq.jdField_a_of_type_Int = 1;
      localbfvq.jdField_a_of_type_JavaLangString = getResources().getString(2131695525);
      localbfvq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!nbp.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!nbp.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label428;
      }
      localbfvq.jdField_b_of_type_Int = 7;
      localbfvq.d = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localbfvq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localbfvq.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localbfvp.a.add(localbfvq);
      a(localbfvp);
      return;
      label428:
      localbfvq.jdField_b_of_type_Int = 0;
    }
  }
  
  private void i(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Aloz == null)) {
      return;
    }
    ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
  }
  
  private void j()
  {
    this.jdField_a_of_type_Bfvb.post(new QidianProfileCardActivity.8(this));
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
        return bdda.b();
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
        if (!azib.b()) {}
        for (bool = true;; bool = false) {
          return new BitmapDrawable(a(paramURLImageView, localURLDrawable2, bool));
        }
      }
      localQQAppInterface = this.app;
      localDrawable = bdda.b();
      if (azib.b()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramURLImageView.setURLDrawableDownListener(new bfux(this, localQQAppInterface, paramURLImageView, paramString, localDrawable, bool));
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710121)))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2131560696, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      Object localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131369345);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131370403);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131363426);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131375763);
      localImageView = (ImageView)((RelativeLayout)localObject1).findViewById(2131370401);
      ((ImageView)localObject5).setImageResource(2130843941);
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null)
      {
        localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          Iterator localIterator = ((bfvp)((Iterator)localObject5).next()).a.iterator();
          label427:
          label430:
          for (;;)
          {
            Object localObject6;
            if (localIterator.hasNext())
            {
              localObject6 = (bfvq)localIterator.next();
              if ((!((bfvq)localObject6).jdField_a_of_type_JavaLangString.equals(alpo.a(2131710118))) || (((bfvq)localObject6).jdField_a_of_type_Bfvo == null)) {
                continue;
              }
              ((TextView)localObject2).setText(((bfvq)localObject6).jdField_a_of_type_Bfvo.jdField_a_of_type_JavaLangString);
              ((TextView)localObject3).setText(((bfvq)localObject6).jdField_a_of_type_Bfvo.jdField_c_of_type_JavaLangString);
              ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, ((bfvq)localObject6).jdField_a_of_type_Bfvo.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
              this.jdField_b_of_type_JavaLangString = ((bfvq)localObject6).jdField_a_of_type_Bfvo.d;
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
                continue;
              }
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 2) {
                break label427;
              }
            }
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) || (!ndd.a(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url))) {
                break label430;
              }
              localObject6 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = getResources().getDrawable(2130843936);
              ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = getResources().getDrawable(2130843936);
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710115)))
    {
      i = 2130843947;
      label509:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2131560700, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131369345);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131370403);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131375763);
      localImageView = (ImageView)((RelativeLayout)localObject2).findViewById(2131370401);
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
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710126))) {
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
        localObject1 = ((bfvp)((Iterator)localObject3).next()).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (bfvq)((Iterator)localObject1).next();
          if (((bfvq)localObject4).jdField_a_of_type_JavaLangString.equals(alpo.a(2131710122))) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, ((bfvq)localObject4).f + "|" + ((bfvq)localObject4).g));
          }
        }
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710117)))
      {
        i = 2130843945;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710119)))
      {
        i = 2130843943;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710127)))
      {
        i = 2130845287;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710116)))
      {
        i = 2130843940;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710123)))
      {
        i = 2130843944;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710130)))
      {
        i = 2130843941;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710120)))
      {
        i = 2130843946;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(alpo.a(2131710129))) {
        return null;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))
      {
        i = 2130843948;
        break label509;
      }
      i = 2130843942;
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
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131560695, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131377552);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131368471);
        ((TextView)localObject1).setText(((QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(0)).jdField_c_of_type_JavaLangString);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2131560694, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131367808);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131370958);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131364083);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131365102);
    localURLImageView.post(new QidianProfileCardActivity.10(this, (QidianProfileCardActivity.QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_b_of_type_JavaLangString);
    ((LinearLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 0)
    {
      localTextView2.setText(2131698547);
      ((LinearLayout)localObject1).setTag(new awki(49, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      label243:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int != 0) || (!((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean)) {
        break label385;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130842277);
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
        localTextView2.setText(2131698548);
        ((LinearLayout)localObject1).setTag(new awki(50, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).e));
        break label243;
      }
      localTextView2.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString);
      ((LinearLayout)localObject1).setTag(new awki(51, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      break label243;
      label385:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 1) && (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130843965);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      this.jdField_a_of_type_Bepp.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepp == null) {
      this.jdField_a_of_type_Bepp = new bepp(this, getResources().getDimensionPixelSize(2131298914));
    }
    this.jdField_a_of_type_Bepp.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bepp.c(paramInt);
    this.jdField_a_of_type_Bepp.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Beqa == null) {
      this.jdField_a_of_type_Beqa = new beqa(this);
    }
    this.jdField_a_of_type_Beqa.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
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
        localObject = bcxb.a(this.app, 1, paramString);
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
  
  public void a(bfvn parambfvn)
  {
    Object localObject = parambfvn.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(this, 0, 2131560704, null, null, getString(2131690884), getString(2131690884), new bfun(this), null);
      this.jdField_a_of_type_Bdfq.setMessageCount(super.getString(2131698546));
      this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(true);
    }
    localObject = b((URLImageView)this.jdField_a_of_type_Bdfq.framePreviewImage, (String)localObject);
    this.jdField_a_of_type_Bdfq.setPreviewImage((Drawable)localObject, true, 1);
    if (this.jdField_a_of_type_Bdfq.getWindow() != null) {
      this.jdField_a_of_type_Bdfq.getWindow().findViewById(2131366809).setOnLongClickListener(new bfuo(this, (Drawable)localObject, parambfvn));
    }
    this.jdField_a_of_type_Bdfq.show();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Bhpy == null)
    {
      this.jdField_b_of_type_Bhpy = ((bhpy)bhql.a(this, null));
      this.jdField_b_of_type_Bhpy.a(super.getResources().getStringArray(2130968583)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bfua.d(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Bhpy.c(super.getResources().getStringArray(2130968583)[1]);
      }
      this.jdField_b_of_type_Bhpy.d(super.getResources().getStringArray(2130968583)[2]);
      this.jdField_b_of_type_Bhpy.a(new bfui(this, paramString));
    }
    this.jdField_b_of_type_Bhpy.show();
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
    if (bfua.a(this.jdField_b_of_type_Int)) {
      return true;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Bfua.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.jdField_c_of_type_Int);
    }
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      a(2131695778);
      return true;
      ndv.a(this, null, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true, -1, true, -1);
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
        return bdda.b();
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
      paramURLImageView.setURLDrawableDownListener(new bfux(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130850063), false));
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
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 6))
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131693525, 2131560702, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new awki(7, null));
        }
        if ((this.jdField_c_of_type_Int != 1) || (!this.jdField_a_of_type_Bfua.d(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label216;
        }
        a(2131698543, 2131560702, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new awki(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label314;
        }
        a(2131699023, 2131560701, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new awki(8, Integer.valueOf(this.jdField_c_of_type_Int)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        label216:
        if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_Bfua.c(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          a(2131693558, 2131560702, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new awki(20, null));
        } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
          a(2131693558, 2131560702, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new awki(20, null));
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    awbw localawbw;
    if (paramInt == 1) {
      localawbw = this.app.getEntityManagerFactory().createEntityManager();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localawbw.a(QidianExternalInfo.class, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localawbw.a(QidianProfileUiInfo.class, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        aloz localaloz = (aloz)this.app.getManager(51);
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqDataCard = localaloz.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localawbw.a(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localawbw != null) {
          localawbw.a();
        }
      }
      if ((paramInt == 0) || (paramInt == 2))
      {
        localawbw = this.app.getEntityManagerFactory().createEntityManager();
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localawbw.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          return;
        }
        finally
        {
          if (localawbw != null) {
            localawbw.a();
          }
        }
      }
      if (paramInt != 6) {
        continue;
      }
      localawbw = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localawbw.a(QidianExternalInfo.class, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localawbw.a(QidianProfileUiInfo.class, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
      finally
      {
        if (localawbw != null) {
          localawbw.a();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bhpy == null)
    {
      this.jdField_a_of_type_Bhpy = ((bhpy)bhql.a(this, null));
      this.jdField_a_of_type_Bhpy.a(super.getResources().getStringArray(2130968582)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bfua.d(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bhpy.a(super.getResources().getStringArray(2130968582)[1], 1);
      }
      this.jdField_a_of_type_Bhpy.a(super.getResources().getStringArray(2130968582)[2], 1);
      this.jdField_a_of_type_Bhpy.d(super.getResources().getStringArray(2130968582)[3]);
      this.jdField_a_of_type_Bhpy.a(new bfuj(this, paramString));
    }
    this.jdField_a_of_type_Bhpy.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_Bfvb != null) {
      this.jdField_a_of_type_Bfvb.sendMessage(localMessage);
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
    syb.a(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Awmk == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ((aloz)this.app.getManager(51)).e(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      localObject = anvv.a(this.app, this.jdField_a_of_type_Awmk);
      localIntent = bcyw.a(localIntent, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
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
      String str = this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Aloz.b(str))
      {
        paramInt = 0;
        localObject = bdbt.i(this.app, str);
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
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_Awmk);
  }
  
  public void d(String paramString)
  {
    bclo.a(this, TroopInfoActivity.a(paramString, 31), 2);
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
      } while (bdal.a(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i, paramIntent));
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
    this.jdField_a_of_type_Bfua = ((bfua)this.app.getManager(165));
    this.jdField_a_of_type_Aloz = ((aloz)this.app.getManager(51));
    this.jdField_a_of_type_Alkv = ((alkv)this.app.a(2));
    try
    {
      setContentView(2131560693);
      this.jdField_d_of_type_Int = aekt.a(16.0F, getResources());
      this.e = aekt.a(10.0F, getResources());
      this.f = aekt.a(8.0F, getResources());
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramBundle, 104);
      }
      this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
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
    if ((this.jdField_a_of_type_Aloz != null) && (this.jdField_a_of_type_Aloz.b(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Awmk.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
    g();
    this.app.addObserver(this.jdField_a_of_type_Alox);
    this.app.addObserver(this.jdField_a_of_type_Nbn);
    this.app.addObserver(this.jdField_a_of_type_Bfvh);
    this.app.addObserver(this.jdField_a_of_type_Allb);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Bfvb = new bfvb(this);
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
    this.app.removeObserver(this.jdField_a_of_type_Alox);
    this.app.removeObserver(this.jdField_a_of_type_Bfvh);
    this.app.removeObserver(this.jdField_a_of_type_Allb);
    this.app.removeObserver(this.jdField_a_of_type_Nbn);
    g();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      e(this.jdField_c_of_type_Int);
    }
    if ((localAllInOne != null) && (!localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131693560, 1);
      return;
    }
    ndv.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_Awmk.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void f()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_Awmk, this.jdField_a_of_type_AndroidAppDialog);
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
      Intent localIntent = aekt.a(new Intent(this, SplashActivity.class), null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */