package com.tencent.qidian;

import actj;
import ajsd;
import ajti;
import ajto;
import ajxj;
import ajxl;
import ajya;
import amev;
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
import aqyd;
import aukp;
import aukq;
import ausw;
import auuy;
import axmv;
import banb;
import bayh;
import bbac;
import bbbr;
import bbcz;
import bbdj;
import bbef;
import bbgu;
import bcqf;
import bcql;
import bcqr;
import bdue;
import bduf;
import bdui;
import bduj;
import bdum;
import bdun;
import bduo;
import bdup;
import bduq;
import bdur;
import bdus;
import bdut;
import bduu;
import bduv;
import bduw;
import bdux;
import bduy;
import bduz;
import bdva;
import bdvb;
import bdvc;
import bdvd;
import bdvg;
import bdvm;
import bdvn;
import bdvr;
import bdvs;
import bdvt;
import bdvu;
import bdvv;
import bfpc;
import bfpp;
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
import myt;
import myv;
import naj;
import naz;
import sgg;

public class QidianProfileCardActivity
  extends ProfileActivity
{
  public int a;
  public ajti a;
  private ajto jdField_a_of_type_Ajto = new bdup(this);
  private ajxj jdField_a_of_type_Ajxj = new bdui(this);
  public ajxl a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Bitmap a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bdum(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new bduj(this);
  public ImageView a;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  aqyd jdField_a_of_type_Aqyd = new aqyd("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.a());
  public auuy a;
  bbgu jdField_a_of_type_Bbgu;
  public bcqf a;
  private bcqr jdField_a_of_type_Bcqr;
  bdue jdField_a_of_type_Bdue = new bdvb(this);
  public bduf a;
  private bdvg jdField_a_of_type_Bdvg;
  private bdvm jdField_a_of_type_Bdvm = new bduq(this);
  private bfpc jdField_a_of_type_Bfpc;
  public BmqqUserSimpleInfo a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private QidianCorpInfo jdField_a_of_type_ComTencentQidianDataQidianCorpInfo;
  public QidianExternalInfo a;
  private QidianProfileUiInfo jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo;
  private String jdField_a_of_type_JavaLangString = "";
  public ConcurrentHashMap<String, bdvd> a;
  private myt jdField_a_of_type_Myt = new bdur(this);
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public ImageView b;
  public LinearLayout b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bfpc jdField_b_of_type_Bfpc;
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
    this.jdField_a_of_type_Auuy = new auuy();
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
        paramURLDrawable = bbef.a(paramQQAppInterface);
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
    int i = getResources().getDimensionPixelSize(2131297896);
    localView.setVisibility(0);
    Button localButton = (Button)localView.findViewById(2131378436);
    localButton.setText(paramInt1);
    localButton.setOnClickListener(paramOnClickListener);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.rightMargin = i;
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt2 != 2131560526) {
        break label122;
      }
      localButton.setBackgroundResource(2130843580);
      localButton.setTextColor(getResources().getColor(2131166141));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams);
      return localButton;
      label122:
      if (paramInt2 == 2131560525)
      {
        localButton.setBackgroundResource(2130843579);
        localButton.setTextColor(getResources().getColor(2131166140));
      }
    }
  }
  
  private ausw a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new ausw(52, paramString2);
    case 2: 
      return new ausw(4, paramString2);
    case 3: 
      return new ausw(47, paramString2);
    case 4: 
      return new ausw(48, new String[] { paramString1, paramString2 });
    case 7: 
      return new ausw(54, paramString3);
    case 6: 
      return new ausw(75, paramString2);
    case 5: 
      return new ausw(76, paramString3);
    }
    return new ausw(82, paramString3);
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i)) {
      return this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
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
    return this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
  }
  
  private void a(bdvu parambdvu)
  {
    parambdvu = parambdvu.a;
    if (parambdvu != null)
    {
      int j = parambdvu.size();
      int i = 0;
      if (i < j)
      {
        bdvv localbdvv = (bdvv)parambdvu.get(i);
        if (i == j - 1) {}
        for (boolean bool = true;; bool = false)
        {
          a(localbdvv, bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  private void a(bdvv parambdvv, boolean paramBoolean)
  {
    if (parambdvv != null) {
      switch (parambdvv.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (paramBoolean) {
        j();
      }
      return;
      b(parambdvv, paramBoolean);
      continue;
      if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
      {
        c(parambdvv, paramBoolean);
        continue;
        if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 4))
        {
          d(parambdvv, paramBoolean);
          continue;
          b(parambdvv, paramBoolean);
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
    bfpc localbfpc = bfpc.c(this);
    localbfpc.b(2131693384);
    localbfpc.b(2131693394);
    localbfpc.b(2131698251);
    localbfpc.c(2131690596);
    localbfpc.a(new bduu(this, localbfpc, paramURLDrawable, paramString));
    localbfpc.show();
  }
  
  private void b(bdvv parambdvv, boolean paramBoolean)
  {
    if ((parambdvv.jdField_b_of_type_JavaLangString == null) || ((TextUtils.isEmpty(parambdvv.jdField_b_of_type_JavaLangString.trim())) && (!parambdvv.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709753))))) {
      return;
    }
    QidianProfileCardActivity.QidianSimpleProfileItem localQidianSimpleProfileItem = new QidianProfileCardActivity.QidianSimpleProfileItem();
    localQidianSimpleProfileItem.jdField_a_of_type_JavaLangString = parambdvv.jdField_a_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_b_of_type_JavaLangString = parambdvv.jdField_b_of_type_JavaLangString;
    localQidianSimpleProfileItem.jdField_a_of_type_Int = parambdvv.jdField_a_of_type_Int;
    localQidianSimpleProfileItem.jdField_b_of_type_Int = parambdvv.jdField_b_of_type_Int;
    String str;
    if (!TextUtils.isEmpty(parambdvv.d))
    {
      str = parambdvv.d;
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
      localQidianSimpleProfileItem.jdField_c_of_type_Boolean = parambdvv.jdField_a_of_type_Boolean;
      parambdvv = a(localQidianSimpleProfileItem);
      this.jdField_a_of_type_Bdvg.sendMessage(parambdvv);
      return;
      str = parambdvv.jdField_c_of_type_JavaLangString;
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
      new File(ajsd.bc).mkdirs();
      str = ajsd.bc + Utils.Crc64String(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString) + Utils.Crc64String(paramURLDrawable.getURL().toString());
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
          bcql.a(this, getString(2131695190), 0).a();
          return;
        }
      }
    }
    bbdj.a(this, 230).setTitle(getString(2131718848)).setMessage(getString(2131695183)).setPositiveButton(getString(2131718724), new bduw(this, paramURLDrawable, str)).setNegativeButton(getString(2131694648), new bduv(this)).show();
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
  
  private void c(bdvv parambdvv, boolean paramBoolean)
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
      bdvs localbdvs = (bdvs)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = localbdvs.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = localbdvs.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbdvs.jdField_b_of_type_JavaLangString.trim();
      if (localbdvs.jdField_b_of_type_Int == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQidianCompoundProfileItem.jdField_a_of_type_Boolean = bool;
        localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambdvv.jdField_a_of_type_JavaLangString;
        localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
        localQidianCompoundProfileItem.d = localbdvs.jdField_c_of_type_JavaLangString;
        localQidianCompoundProfileItem.e = localbdvs.d;
        localArrayList.add(localQidianCompoundProfileItem);
        break;
      }
    }
    parambdvv = a(localArrayList);
    this.jdField_a_of_type_Bdvg.sendMessage(parambdvv);
  }
  
  private void d(bdvv parambdvv, boolean paramBoolean)
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
      bdvr localbdvr = (bdvr)((Iterator)localObject).next();
      QidianProfileCardActivity.QidianCompoundProfileItem localQidianCompoundProfileItem = new QidianProfileCardActivity.QidianCompoundProfileItem();
      localQidianCompoundProfileItem.jdField_a_of_type_Int = parambdvv.jdField_a_of_type_Int;
      localQidianCompoundProfileItem.jdField_a_of_type_JavaLangString = String.valueOf(localbdvr.jdField_a_of_type_Long);
      localQidianCompoundProfileItem.jdField_b_of_type_JavaLangString = localbdvr.jdField_a_of_type_JavaLangString.trim();
      localQidianCompoundProfileItem.jdField_c_of_type_JavaLangString = parambdvv.jdField_a_of_type_JavaLangString;
      localQidianCompoundProfileItem.jdField_b_of_type_Boolean = paramBoolean;
      localArrayList.add(localQidianCompoundProfileItem);
    }
    parambdvv = a(localArrayList);
    this.jdField_a_of_type_Bdvg.sendMessage(parambdvv);
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 4) {
      a(2131695620);
    }
    if (this.jdField_a_of_type_Bduf.a(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true)) {
      this.jdField_a_of_type_Bduf.a(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (paramInt == 6) {
        ((bdvn)this.app.a(85)).c(Long.parseLong(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
      }
      return;
      if (this.jdField_a_of_type_Bduf.b(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, false))
      {
        BmqqAccountType localBmqqAccountType = new BmqqAccountType(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 1);
        this.jdField_a_of_type_Bduf.b(this, localBmqqAccountType);
      }
      else
      {
        this.jdField_a_of_type_Bduf.b(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private void f(int paramInt)
  {
    this.jdField_a_of_type_Bdvg.postDelayed(new QidianProfileCardActivity.3(this, paramInt), 0L);
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
    this.jdField_a_of_type_Bfpc = null;
    this.jdField_b_of_type_Bfpc = null;
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
    this.jdField_a_of_type_Int = (localResources.getDimensionPixelSize(2131298865) - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363701));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367427));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367397));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bdux(this));
    if (!axmv.b()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130843576));
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378843));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364656));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368401));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131364565));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.mScrollFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new bduy(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370647));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368752));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376208));
    findViewById(2131376224).setOnClickListener(new bduz(this));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369140));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new bdva(this));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375308));
    this.jdField_d_of_type_AndroidWidgetImageView.setTag(new ausw(53, null));
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
        a((bdvu)localIterator.next());
        continue;
        if ((paramInt == 0) || (paramInt == 2)) {
          i();
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i = paramString;
    FriendProfileCardActivity.a(this.jdField_a_of_type_Auuy, 4, paramString);
    FriendProfileCardActivity.b(this.jdField_a_of_type_Auuy);
    paramString = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void i()
  {
    bdvu localbdvu;
    bdvv localbdvv;
    if (this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo != null)
    {
      localbdvu = new bdvu();
      localbdvu.a = new ArrayList(5);
      new bdvv();
      localbdvv = new bdvv();
      localbdvv.jdField_a_of_type_Int = 1;
      localbdvv.jdField_b_of_type_Int = 0;
      localbdvv.jdField_a_of_type_JavaLangString = ajya.a(2131709760);
      localbdvv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      localbdvu.a.add(localbdvv);
      localbdvv = new bdvv();
      localbdvv.jdField_a_of_type_Int = 1;
      localbdvv.jdField_b_of_type_Int = 2;
      localbdvv.jdField_a_of_type_JavaLangString = getResources().getString(2131698093);
      localbdvv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbdvv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMobileNum;
      localbdvu.a.add(localbdvv);
      localbdvv = new bdvv();
      localbdvv.jdField_a_of_type_Int = 1;
      localbdvv.jdField_b_of_type_Int = 1;
      localbdvv.jdField_a_of_type_JavaLangString = getResources().getString(2131720033);
      localbdvv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbdvv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqTelphone;
      localbdvu.a.add(localbdvv);
      localbdvv = new bdvv();
      localbdvv.jdField_a_of_type_Int = 1;
      localbdvv.jdField_b_of_type_Int = 3;
      localbdvv.jdField_a_of_type_JavaLangString = getResources().getString(2131694066);
      localbdvv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbdvv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqEmail;
      localbdvu.a.add(localbdvv);
      localbdvv = new bdvv();
      localbdvv.jdField_a_of_type_Int = 1;
      localbdvv.jdField_a_of_type_JavaLangString = getResources().getString(2131695367);
      localbdvv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqCompany;
      if ((!myv.b(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqUin)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin)) || (!myv.a(this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin))) {
        break label428;
      }
      localbdvv.jdField_b_of_type_Int = 7;
      localbdvv.d = ("mqqwpa://card/show_pslcard?card_type=crm&uin=" + this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.mBmqqMasterUin);
    }
    for (localbdvv.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified();; localbdvv.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo.isCertified())
    {
      localbdvu.a.add(localbdvv);
      a(localbdvu);
      return;
      label428:
      localbdvv.jdField_b_of_type_Int = 0;
    }
  }
  
  private void i(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_Ajxl == null)) {
      return;
    }
    ThreadManager.post(new QidianProfileCardActivity.2(this, paramString), 8, null, true);
  }
  
  private void j()
  {
    this.jdField_a_of_type_Bdvg.post(new QidianProfileCardActivity.8(this));
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
        return bbef.b();
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
        if (!axmv.b()) {}
        for (bool = true;; bool = false) {
          return new BitmapDrawable(a(paramURLImageView, localURLDrawable2, bool));
        }
      }
      localQQAppInterface = this.app;
      localDrawable = bbef.b();
      if (axmv.b()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramURLImageView.setURLDrawableDownListener(new bdvc(this, localQQAppInterface, paramURLImageView, paramString, localDrawable, bool));
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709749)))
    {
      localObject1 = (RelativeLayout)getLayoutInflater().inflate(2131560520, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      Object localObject5 = (ImageView)((RelativeLayout)localObject1).findViewById(2131369113);
      localObject2 = (TextView)((RelativeLayout)localObject1).findViewById(2131370137);
      localObject3 = (TextView)((RelativeLayout)localObject1).findViewById(2131363387);
      localObject4 = (ImageView)((RelativeLayout)localObject1).findViewById(2131375281);
      localImageView = (ImageView)((RelativeLayout)localObject1).findViewById(2131370135);
      ((ImageView)localObject5).setImageResource(2130843582);
      if (this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo != null)
      {
        localObject5 = this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo.mConfigGroupInfos.iterator();
        if (((Iterator)localObject5).hasNext())
        {
          Iterator localIterator = ((bdvu)((Iterator)localObject5).next()).a.iterator();
          label427:
          label430:
          for (;;)
          {
            Object localObject6;
            if (localIterator.hasNext())
            {
              localObject6 = (bdvv)localIterator.next();
              if ((!((bdvv)localObject6).jdField_a_of_type_JavaLangString.equals(ajya.a(2131709746))) || (((bdvv)localObject6).jdField_a_of_type_Bdvt == null)) {
                continue;
              }
              ((TextView)localObject2).setText(((bdvv)localObject6).jdField_a_of_type_Bdvt.jdField_a_of_type_JavaLangString);
              ((TextView)localObject3).setText(((bdvv)localObject6).jdField_a_of_type_Bdvt.jdField_c_of_type_JavaLangString);
              ((RelativeLayout)localObject1).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, ((bdvv)localObject6).jdField_a_of_type_Bdvt.d, paramQidianSimpleProfileItem.jdField_c_of_type_JavaLangString));
              this.jdField_b_of_type_JavaLangString = ((bdvv)localObject6).jdField_a_of_type_Bdvt.d;
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) {
                continue;
              }
              if (this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verity != 2) {
                break label427;
              }
            }
            for (i = 1;; i = 0)
            {
              if ((i == 0) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url)) || (!naj.a(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.verify_url))) {
                break label430;
              }
              localObject6 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = getResources().getDrawable(2130843577);
              ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = getResources().getDrawable(2130843577);
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
    if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709743)))
    {
      i = 2130843588;
      label509:
      localObject2 = (RelativeLayout)super.getLayoutInflater().inflate(2131560524, this.jdField_b_of_type_AndroidWidgetLinearLayout, false);
      localObject1 = (ImageView)((RelativeLayout)localObject2).findViewById(2131369113);
      localObject3 = (TextView)((RelativeLayout)localObject2).findViewById(2131370137);
      localObject4 = (ImageView)((RelativeLayout)localObject2).findViewById(2131375281);
      localImageView = (ImageView)((RelativeLayout)localObject2).findViewById(2131370135);
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
      if (!paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709754))) {
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
        localObject1 = ((bdvu)((Iterator)localObject3).next()).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (bdvv)((Iterator)localObject1).next();
          if (((bdvv)localObject4).jdField_a_of_type_JavaLangString.equals(ajya.a(2131709750))) {
            ((RelativeLayout)localObject2).setTag(a(paramQidianSimpleProfileItem.jdField_b_of_type_Int, paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString, paramQidianSimpleProfileItem.jdField_b_of_type_JavaLangString, ((bdvv)localObject4).f + "|" + ((bdvv)localObject4).g));
          }
        }
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709745)))
      {
        i = 2130843586;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709747)))
      {
        i = 2130843584;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709755)))
      {
        i = 2130844923;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709744)))
      {
        i = 2130843581;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709751)))
      {
        i = 2130843585;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709758)))
      {
        i = 2130843582;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709748)))
      {
        i = 2130843587;
        break label509;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals(ajya.a(2131709757))) {
        return null;
      }
      if (paramQidianSimpleProfileItem.jdField_a_of_type_JavaLangString.equals("QQ空间"))
      {
        i = 2130843589;
        break label509;
      }
      i = 2130843583;
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
        localRelativeLayout = (RelativeLayout)super.getLayoutInflater().inflate(2131560519, null);
        localObject1 = (TextView)localRelativeLayout.findViewById(2131377032);
        localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131368324);
        ((TextView)localObject1).setText(((QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(0)).jdField_c_of_type_JavaLangString);
        i = 0;
        localObject1 = localRelativeLayout;
      } while (i >= paramList.size());
      localObject1 = localRelativeLayout;
    } while (i >= 2);
    Object localObject2 = (QidianProfileCardActivity.QidianCompoundProfileItem)paramList.get(i);
    Object localObject1 = (LinearLayout)super.getLayoutInflater().inflate(2131560518, null);
    URLImageView localURLImageView = (URLImageView)((LinearLayout)localObject1).findViewById(2131367679);
    TextView localTextView1 = (TextView)((LinearLayout)localObject1).findViewById(2131370647);
    ImageView localImageView = (ImageView)((LinearLayout)localObject1).findViewById(2131364022);
    TextView localTextView2 = (TextView)((LinearLayout)localObject1).findViewById(2131365017);
    localURLImageView.post(new QidianProfileCardActivity.10(this, (QidianProfileCardActivity.QidianCompoundProfileItem)localObject2, localURLImageView));
    localTextView1.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_b_of_type_JavaLangString);
    ((LinearLayout)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 0)
    {
      localTextView2.setText(2131698257);
      ((LinearLayout)localObject1).setTag(new ausw(49, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      label243:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int != 0) || (!((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean)) {
        break label385;
      }
      localImageView.setVisibility(0);
      localImageView.setBackgroundResource(2130842124);
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
        localTextView2.setText(2131698258);
        ((LinearLayout)localObject1).setTag(new ausw(50, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).e));
        break label243;
      }
      localTextView2.setText(((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString);
      ((LinearLayout)localObject1).setTag(new ausw(51, ((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_JavaLangString));
      break label243;
      label385:
      if ((((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Int == 1) && (((QidianProfileCardActivity.QidianCompoundProfileItem)localObject2).jdField_a_of_type_Boolean))
      {
        localImageView.setVisibility(0);
        localImageView.setBackgroundResource(2130843606);
      }
      else
      {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      this.jdField_a_of_type_Bcqf.dismiss();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcqf == null) {
      this.jdField_a_of_type_Bcqf = new bcqf(this, getResources().getDimensionPixelSize(2131298865));
    }
    this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bcqf.c(paramInt);
    this.jdField_a_of_type_Bcqf.show();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bcqr == null) {
      this.jdField_a_of_type_Bcqr = new bcqr(this);
    }
    this.jdField_a_of_type_Bcqr.a(paramInt1, getTitleBarHeight(), 0, paramInt2);
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
        localObject = bayh.a(this.app, 1, paramString);
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
  
  public void a(bdvs parambdvs)
  {
    Object localObject = parambdvs.d;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_Bbgu == null)
    {
      this.jdField_a_of_type_Bbgu = bbdj.a(this, 0, 2131560528, null, null, getString(2131690832), getString(2131690832), new bdus(this), null);
      this.jdField_a_of_type_Bbgu.setMessageCount(super.getString(2131698256));
      this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(true);
    }
    localObject = b((URLImageView)this.jdField_a_of_type_Bbgu.framePreviewImage, (String)localObject);
    this.jdField_a_of_type_Bbgu.setPreviewImage((Drawable)localObject, true, 1);
    if (this.jdField_a_of_type_Bbgu.getWindow() != null) {
      this.jdField_a_of_type_Bbgu.getWindow().findViewById(2131366690).setOnLongClickListener(new bdut(this, (Drawable)localObject, parambdvs));
    }
    this.jdField_a_of_type_Bbgu.show();
  }
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_Bfpc == null)
    {
      this.jdField_b_of_type_Bfpc = ((bfpc)bfpp.a(this, null));
      this.jdField_b_of_type_Bfpc.a(super.getResources().getStringArray(2130968583)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bduf.d(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_Bfpc.c(super.getResources().getStringArray(2130968583)[1]);
      }
      this.jdField_b_of_type_Bfpc.d(super.getResources().getStringArray(2130968583)[2]);
      this.jdField_b_of_type_Bfpc.a(new bdun(this, paramString));
    }
    this.jdField_b_of_type_Bfpc.show();
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
    if (bduf.a(this.jdField_b_of_type_Int)) {
      return true;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Bduf.a(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app);
    if (QLog.isColorLevel()) {
      QLog.d("QidianProfileCardActivity", 2, "initAccountType accountType: " + this.jdField_c_of_type_Int);
    }
    switch (this.jdField_c_of_type_Int)
    {
    }
    for (;;)
    {
      return false;
      a(2131695620);
      return true;
      naz.a(this, null, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, true, -1, true, -1);
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
        return bbef.b();
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
      paramURLImageView.setURLDrawableDownListener(new bdvc(this, this.app, paramURLImageView, paramString, getResources().getDrawable(2130849629), false));
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
      boolean bool2 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      boolean bool1;
      boolean bool3;
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 6))
      {
        bool1 = true;
        bool3 = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        if (bool2) {
          a(2131693424, 2131560526, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new ausw(7, null));
        }
        if ((this.jdField_c_of_type_Int != 1) || (!this.jdField_a_of_type_Bduf.d(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label216;
        }
        a(2131698253, 2131560526, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new ausw(55, null));
      }
      for (;;)
      {
        if (!bool1) {
          break label314;
        }
        a(2131698725, 2131560525, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new ausw(8, Integer.valueOf(this.jdField_c_of_type_Int)));
        return;
        bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        break;
        label216:
        if ((this.jdField_c_of_type_Int == 6) && (this.jdField_a_of_type_Bduf.c(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          a(2131693457, 2131560526, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new ausw(20, null));
        } else if ((bool3) && (this.jdField_c_of_type_Int != 6)) {
          a(2131693457, 2131560526, this.jdField_a_of_type_AndroidViewView$OnClickListener).setTag(new ausw(20, null));
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    aukp localaukp;
    if (paramInt == 1) {
      localaukp = this.app.getEntityManagerFactory().createEntityManager();
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localaukp.a(QidianExternalInfo.class, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localaukp.a(QidianProfileUiInfo.class, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        ajxl localajxl = (ajxl)this.app.getManager(51);
        this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqDataCard = localajxl.b(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin))) {
          this.jdField_a_of_type_ComTencentQidianDataQidianCorpInfo = ((QidianCorpInfo)localaukp.a(QidianCorpInfo.class, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin));
        }
        return;
      }
      finally
      {
        if (localaukp != null) {
          localaukp.a();
        }
      }
      if ((paramInt == 0) || (paramInt == 2))
      {
        localaukp = this.app.getEntityManagerFactory().createEntityManager();
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqDataBmqqUserSimpleInfo = ((BmqqUserSimpleInfo)localaukp.a(BmqqUserSimpleInfo.class, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
          return;
        }
        finally
        {
          if (localaukp != null) {
            localaukp.a();
          }
        }
      }
      if (paramInt != 6) {
        continue;
      }
      localaukp = this.app.getEntityManagerFactory().createEntityManager();
      try
      {
        this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = ((QidianExternalInfo)localaukp.a(QidianExternalInfo.class, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentQidianDataQidianProfileUiInfo = ((QidianProfileUiInfo)localaukp.a(QidianProfileUiInfo.class, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString));
        return;
      }
      finally
      {
        if (localaukp != null) {
          localaukp.a();
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Bfpc == null)
    {
      this.jdField_a_of_type_Bfpc = ((bfpc)bfpp.a(this, null));
      this.jdField_a_of_type_Bfpc.a(super.getResources().getStringArray(2130968582)[0], 1);
      if ((this.jdField_c_of_type_Int == 1) && (this.jdField_a_of_type_Bduf.d(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Bfpc.a(super.getResources().getStringArray(2130968582)[1], 1);
      }
      this.jdField_a_of_type_Bfpc.a(super.getResources().getStringArray(2130968582)[2], 1);
      this.jdField_a_of_type_Bfpc.d(super.getResources().getStringArray(2130968582)[3]);
      this.jdField_a_of_type_Bfpc.a(new bduo(this, paramString));
    }
    this.jdField_a_of_type_Bfpc.show();
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    if (this.jdField_a_of_type_Bdvg != null) {
      this.jdField_a_of_type_Bdvg.sendMessage(localMessage);
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
    sgg.a(localIntent, this.app, this, paramString, -1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Auuy == null) {
      return;
    }
    Intent localIntent = new Intent(this, ProfileCardMoreActivity.class);
    Object localObject;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = ((ajxl)this.app.getManager(51)).e(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      localObject = amev.a(this.app, this.jdField_a_of_type_Auuy);
      localIntent = bbac.a(localIntent, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.app, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, (BusinessCard)localObject);
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
      String str = this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ajxl.b(str))
      {
        paramInt = 0;
        localObject = bbcz.i(this.app, str);
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
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("uintype", 1024);
      startActivity((Intent)localObject);
      return;
    }
    FriendProfileCardActivity.b(this.app, this, this.jdField_a_of_type_Auuy);
  }
  
  public void d(String paramString)
  {
    banb.a(this, TroopInfoActivity.a(paramString, 31), 2);
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
      } while (bbbr.a(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i, paramIntent));
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
    this.jdField_a_of_type_Bduf = ((bduf)this.app.getManager(165));
    this.jdField_a_of_type_Ajxl = ((ajxl)this.app.getManager(51));
    this.jdField_a_of_type_Ajti = ((ajti)this.app.a(2));
    try
    {
      setContentView(2131560517);
      this.jdField_d_of_type_Int = actj.a(16.0F, getResources());
      this.e = actj.a(10.0F, getResources());
      this.f = actj.a(8.0F, getResources());
      this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)super.getIntent().getParcelableExtra("AllInOne"));
      if (this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)
      {
        paramBundle = super.getIntent().getStringExtra("uin");
        this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = new ProfileActivity.AllInOne(paramBundle, 104);
      }
      this.jdField_b_of_type_Int = super.getIntent().getIntExtra("cspecialflag", 0);
      if ((this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString == null))
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
    if ((this.jdField_a_of_type_Ajxl != null) && (this.jdField_a_of_type_Ajxl.b(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(this.app.getCurrentAccountUin()))) {
      this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Auuy.jdField_a_of_type_ArrayOfJavaLangString = new String[7];
    g();
    this.app.addObserver(this.jdField_a_of_type_Ajxj);
    this.app.addObserver(this.jdField_a_of_type_Myt);
    this.app.addObserver(this.jdField_a_of_type_Bdvm);
    this.app.addObserver(this.jdField_a_of_type_Ajto);
    if (!a())
    {
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Bdvg = new bdvg(this);
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
    this.app.removeObserver(this.jdField_a_of_type_Ajxj);
    this.app.removeObserver(this.jdField_a_of_type_Bdvm);
    this.app.removeObserver(this.jdField_a_of_type_Ajto);
    this.app.removeObserver(this.jdField_a_of_type_Myt);
    g();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    ProfileActivity.AllInOne localAllInOne = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
    if ((localAllInOne != null) && (localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      e(this.jdField_c_of_type_Int);
    }
    if ((localAllInOne != null) && (!localAllInOne.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      startActivity(paramIntent);
      super.finish();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin)) || (this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      a(2131693459, 1);
      return;
    }
    naz.b(this.app, this, this.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo.masterUin, this.jdField_a_of_type_Auuy.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    super.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + paramString)));
  }
  
  public void f()
  {
    getIntent().putExtra("param_return_addr", QidianProfileCardActivity.class.getName());
    FriendProfileCardActivity.a(this.app, this, this.jdField_a_of_type_Auuy, this.jdField_a_of_type_AndroidAppDialog);
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
      Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
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