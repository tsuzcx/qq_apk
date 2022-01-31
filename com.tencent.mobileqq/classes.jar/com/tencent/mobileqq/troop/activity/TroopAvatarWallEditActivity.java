package com.tencent.mobileqq.troop.activity;

import aekt;
import aiiy;
import aile;
import ailh;
import ailm;
import ailo;
import ailp;
import aljq;
import alpo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aovq;
import arum;
import azmj;
import bame;
import baqq;
import bbda;
import bbdb;
import bbdc;
import bbdd;
import bbde;
import bbdf;
import bbdg;
import bbdh;
import bbdi;
import bbdj;
import bcgh;
import bcln;
import bcmd;
import bcnt;
import bdcd;
import bdee;
import bdfq;
import bduw;
import bhou;
import bhpy;
import bhql;
import bhqp;
import bhrq;
import bngs;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.DragView;
import com.tencent.widget.Gallery;
import com.tencent.widget.GridView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mbt;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;
import xod;
import xwb;

public class TroopAvatarWallEditActivity
  extends BaseActivity
  implements ailm, ailo, View.OnClickListener, bhqp, bhrq
{
  public int a;
  private long jdField_a_of_type_Long;
  public ailh a;
  protected Rect a;
  protected View a;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  aovq jdField_a_of_type_Aovq;
  private bbdj jdField_a_of_type_Bbdj;
  public bcmd a;
  public bcnt a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected DragView a;
  protected Gallery a;
  public GridView a;
  public String a;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected boolean a;
  protected int b;
  ailh b;
  protected String b;
  protected boolean b;
  public String c;
  public boolean c;
  protected boolean d;
  
  public TroopAvatarWallEditActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_Ailh == null) {}
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      paramIntent = paramIntent.getStringExtra("key_clip_info");
    } while (TextUtils.isEmpty(str));
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
    }
    this.jdField_a_of_type_Ailh.a(str, paramIntent);
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)findViewById(2131363007));
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGridView.setEdgeEffectEnabled(false);
      paramBundle = new WeakReference(this);
      GridView localGridView = this.jdField_a_of_type_ComTencentWidgetGridView;
      QQAppInterface localQQAppInterface = this.app;
      String str = this.jdField_a_of_type_JavaLangString;
      if (!this.c) {
        bool = true;
      }
      this.jdField_a_of_type_Bcmd = new bcmd(paramBundle, localGridView, localQQAppInterface, str, bool, this.jdField_a_of_type_Boolean, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i = this.jdField_a_of_type_Bcmd.a(this);
      ((RelativeLayout)findViewById(2131375866)).setMinimumHeight(i * 2 + xod.a(this, 10.0F));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      azmj.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((bhou.k()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
        localObject = new TroopAvatarWallEditActivity.9(this);
        this.jdField_a_of_type_Aovq = new aovq();
        this.jdField_a_of_type_Aovq.b = ((Runnable)localObject);
        this.jdField_a_of_type_Aovq.a = paramURLDrawable;
        requestPermissions(this, 1, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramURLDrawable);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Ailh == null) {}
    do
    {
      do
      {
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        localObject = this.jdField_a_of_type_Ailh.a();
        if (QLog.isColorLevel()) {
          QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Arrays.deepToString(((List)localObject).toArray()) }));
        }
        if ((this.jdField_a_of_type_Bcmd != null) && (paramBoolean2)) {
          this.jdField_a_of_type_Bcmd.a((List)localObject);
        }
      } while ((this.jdField_a_of_type_Bcnt == null) || (!paramBoolean1));
      this.jdField_a_of_type_Bcnt.a((List)localObject);
    } while (this.jdField_a_of_type_Bbdj == null);
    this.jdField_a_of_type_Bbdj.b(this.jdField_a_of_type_Bcnt.getCount());
    this.jdField_a_of_type_Bbdj.a(this.jdField_a_of_type_Int);
    return;
    Object localObject = this.jdField_a_of_type_Ailh.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject }));
    }
    ArrayList localArrayList = new ArrayList(1);
    Button localButton;
    if (localObject != null)
    {
      localArrayList.add(localObject);
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (((aiiy)localObject).jdField_a_of_type_Boolean) {
        break label248;
      }
    }
    label248:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localButton.setEnabled(paramBoolean1);
      if (this.jdField_a_of_type_Bcnt == null) {
        break;
      }
      this.jdField_a_of_type_Bcnt.a(localArrayList);
      return;
    }
  }
  
  private void b(Bundle paramBundle)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367010));
    View localView = findViewById(2131375862);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    Object localObject = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localObject = ailp.a(this, 103);
      localLayoutParams.bottomMargin = aekt.a(45.0F, getResources());
      localLayoutParams.width = ((Point)localObject).x;
      localLayoutParams.height = ((Point)localObject).y;
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Bcnt = new bcnt(this, this.app, this.jdField_a_of_type_JavaLangString, ((Point)localObject).x, ((Point)localObject).y, this.jdField_a_of_type_ComTencentWidgetGallery);
      this.jdField_a_of_type_Bcnt.a(this.jdField_b_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Bcnt;
      if (paramBundle.getBoolean("from_photo_wall", false)) {
        break label571;
      }
      bool1 = true;
      label196:
      ((bcnt)localObject).c(bool1);
      this.jdField_a_of_type_Bcnt.d(paramBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Bcnt.a(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bcnt.b(this.jdField_a_of_type_Boolean);
      paramBundle = ailp.a(this, 103);
      this.jdField_a_of_type_Bcnt.a(paramBundle.x, paramBundle.y);
      this.jdField_a_of_type_ComTencentWidgetGallery.setContentDescription(alpo.a(2131715591));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297026));
      paramBundle = this.jdField_a_of_type_ComTencentWidgetGallery;
      if (this.jdField_a_of_type_Boolean) {
        break label577;
      }
      bool1 = true;
      label307:
      paramBundle.b(bool1);
      paramBundle = this.jdField_a_of_type_ComTencentWidgetGallery;
      if (this.jdField_a_of_type_Boolean) {
        break label583;
      }
    }
    label571:
    label577:
    label583:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBundle.a(bool1);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Bcnt);
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new bbda(this));
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new bbdf(this));
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new bbdg(this));
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131365487));
      this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
      paramBundle = this.jdField_a_of_type_ComTencentWidgetDragView;
      bool1 = bool2;
      if (!this.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
      paramBundle.setEnableDrag(bool1);
      this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.jdField_a_of_type_AndroidGraphicsRect);
      }
      return;
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        ((Point)localObject).set(i, ailp.a(i));
        break;
      }
      int k = aekt.a(60.0F, getResources());
      ((Point)localObject).set(i, j - k);
      localLayoutParams.removeRule(13);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = k;
      break;
      bool1 = false;
      break label196;
      bool1 = false;
      break label307;
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    String str = aljq.bd;
    new File(str).mkdirs();
    str = str + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(paramURLDrawable.getURL().toString());
    File localFile = new File(str);
    if (!localFile.exists()) {
      try
      {
        if (localFile.createNewFile()) {
          b(paramURLDrawable, localFile.getPath());
        }
        return;
      }
      catch (IOException paramURLDrawable)
      {
        QQToast.a(this, getString(2131695348), 0).a();
        return;
      }
    }
    bdcd.a(this, 230).setTitle(getString(2131719323)).setMessage(getString(2131695341)).setPositiveButton(getString(2131719197), new bbdc(this, paramURLDrawable, str)).setNegativeButton(getString(2131694804), new bbdb(this)).show();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new bbdd(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131691555));
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368219));
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Bbdj = new bbdj(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Bbdj.b(this.jdField_a_of_type_Bcnt.getCount());
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = aekt.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131693336), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693336), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131367910)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131693336), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131693336), 0).a();
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.a(2131693485, 1);
    localbhpy.a(2131693495, 1);
    if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
      ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localbhpy));
    }
    localbhpy.c(2131690648);
    localbhpy.a(new bbdi(this, localbhpy, (URLDrawable)localObject));
    localbhpy.show();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject2 = ailp.a(bcgh.b(bcgh.a(aiiy.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0)));
    if (localObject2 == null)
    {
      b(1);
      return;
    }
    File localFile2 = bame.a(((URL)localObject2).toString());
    boolean bool;
    if (QLog.isColorLevel())
    {
      if ((localFile2 == null) || (!localFile2.exists())) {
        break label264;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload %s %b", new Object[] { localObject2, Boolean.valueOf(bool) }));
      Object localObject1;
      if (localFile2 != null)
      {
        localObject1 = localFile2;
        if (localFile2.exists()) {}
      }
      else
      {
        localObject1 = new DownloadParams();
        ((DownloadParams)localObject1).url = ((URL)localObject2);
        ((DownloadParams)localObject1).urlStr = ((URL)localObject2).toString();
        localObject2 = new baqq();
      }
      try
      {
        localObject1 = ((baqq)localObject2).loadImageFile((DownloadParams)localObject1, new bbde(this));
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", new Object[] { Boolean.valueOf(bool) }));
          }
          if (!bool) {
            break label284;
          }
          if (this.jdField_b_of_type_Ailh == null)
          {
            this.jdField_b_of_type_Ailh = new aile(this, this, this.app, this.jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_Ailh.a(this);
          }
          runOnUiThread(new TroopAvatarWallEditActivity.15(this, (File)localObject1));
          return;
          label264:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          File localFile1 = localFile2;
          continue;
          bool = false;
        }
        label284:
        b(3);
      }
    }
  }
  
  public void F()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "onGestureFinish");
    }
    finish();
  }
  
  public void G()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onResetPosition", new Object[0]));
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void H()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onClickDragView", new Object[0]));
    }
    finish();
  }
  
  public void a()
  {
    a(true, true);
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onContentMove %.1f", new Object[] { Float.valueOf(paramFloat) }));
    }
    this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition() != paramInt) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
      }
      a(false, true);
    }
  }
  
  public void a(aiiy paramaiiy)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(true, true);
    }
  }
  
  public void a(aiiy paramaiiy, bcln parambcln)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramaiiy.d == 1) && (this.d)) {
        if (parambcln.jdField_a_of_type_Int == 1)
        {
          this.d = false;
          b();
        }
      }
      while (this.jdField_a_of_type_Bcmd == null)
      {
        do
        {
          return;
        } while (parambcln.jdField_a_of_type_Int != 2);
        b(5);
        return;
      }
      this.jdField_a_of_type_Bcmd.a(paramaiiy, parambcln);
      return;
    }
    Button localButton;
    if (this.jdField_a_of_type_Bcnt.a(0) == paramaiiy)
    {
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (paramaiiy.jdField_a_of_type_Boolean) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      this.jdField_a_of_type_Bcnt.a(paramaiiy, parambcln);
      if ((paramaiiy.d != 1) || (parambcln.jdField_a_of_type_Int != 1)) {
        break;
      }
      ailh.a(ailp.a(this, 0), 2);
      return;
    }
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      azmj.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramString = bduw.a(aljq.bY);
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = paramString + this.jdField_a_of_type_JavaLangString + Utils.Crc64String(paramURLDrawable.getURL().toString());
    paramString = (String)localObject;
    if (!new File((String)localObject).exists()) {}
    try
    {
      paramString = paramURLDrawable.saveTo((String)localObject);
      localBundle.putString("forward_filepath", paramString);
      localBundle.putString("forward_thumb", paramString);
      paramURLDrawable = new Intent();
      paramURLDrawable.putExtras(localBundle);
      arum.a(this, paramURLDrawable, 21);
      return;
    }
    catch (IOException paramURLDrawable)
    {
      for (;;)
      {
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", paramURLDrawable);
          paramString = (String)localObject;
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    localIntent.putExtra("report_params", xwb.a(null, paramString2, null, null, null, 7));
    startActivity(localIntent);
  }
  
  public boolean a(int paramInt)
  {
    if ((this.d) && (paramInt == 0))
    {
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.13(this), null, true);
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ailh != null) {
      this.jdField_a_of_type_Ailh.a();
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_Ailh != null) {
        this.jdField_a_of_type_Ailh.d(paramInt);
      }
      return;
    }
    runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
  }
  
  public void b(aiiy paramaiiy)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramaiiy.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(paramaiiy.c)) && (bcgh.b(paramaiiy.c))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramaiiy.c);
      }
      if (this.jdField_a_of_type_Ailh.a().size() == 0) {
        finish();
      }
      a(true, true);
      if (this.jdField_a_of_type_Int >= 0) {
        this.jdField_a_of_type_Ailh.b(this.jdField_a_of_type_Int);
      }
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    if ((this.jdField_a_of_type_Aovq != null) && (this.jdField_a_of_type_Aovq.b != null)) {
      this.jdField_a_of_type_Aovq.b.run();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
    case 257: 
      do
      {
        return;
      } while (this.jdField_a_of_type_Ailh == null);
      this.jdField_a_of_type_Ailh.d();
      return;
    }
    c(paramIntent.getExtras());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
    {
      finish();
      return false;
    }
    setContentView(2131560412);
    Object localObject1 = getIntent().getExtras();
    findViewById(2131375984).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363034);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365063));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363525));
    this.jdField_a_of_type_Boolean = ((Bundle)localObject1).getBoolean("IS_EDIT");
    this.jdField_b_of_type_Boolean = ((Bundle)localObject1).getBoolean("IS_COVER", true);
    this.d = ((Bundle)localObject1).getBoolean("isUseClassAvatar", false);
    if (((Bundle)localObject1).getInt("vistor_type", 1) != 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.c = bool;
      paramBundle = ((Bundle)localObject1).getParcelableArrayList("PHOTO_LIST");
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject1).getString("troop_uin");
      if ((!this.c) || ((paramBundle != null) && (paramBundle.size() != 0))) {
        break;
      }
      finish();
      return true;
    }
    if ((!this.c) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      finish();
      return true;
    }
    this.jdField_a_of_type_Int = ((Bundle)localObject1).getInt("index", -1);
    this.jdField_b_of_type_Int = ((Bundle)localObject1).getInt("troop_auth_submit_time", 0);
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)((Bundle)localObject1).getParcelable("KEY_THUMBNAL_BOUND"));
    Object localObject2;
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (bngs.c) && (bngs.jdField_a_of_type_Boolean))
    {
      int i = bngs.b(this);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).top -= i;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).bottom -= i;
    }
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755896);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363020));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(alpo.a(2131715589));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (ThemeUtil.isInNightMode(this.app))
    {
      localObject2 = getResources().getDrawable(2130839666);
      ((Drawable)localObject2).setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
    a((Bundle)localObject1);
    b((Bundle)localObject1);
    c();
    if (!this.c) {
      if (this.jdField_b_of_type_Boolean)
      {
        paramBundle = new ailh(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Ailh = paramBundle;
        this.jdField_a_of_type_Ailh.a(this);
        this.jdField_a_of_type_Ailh.e(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Ailh.a(false);
        this.jdField_a_of_type_Ailh.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Ailh.a(this);
      }
    }
    for (;;)
    {
      a(getIntent());
      return true;
      paramBundle = new aile(this, this, this.app, this.jdField_a_of_type_JavaLangString);
      break;
      localObject1 = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (TroopClipPic)paramBundle.next();
        if (localObject2 != null) {
          ((List)localObject1).add(aiiy.a((TroopClipPic)localObject2, null));
        }
      }
      if (this.jdField_a_of_type_Bcnt != null)
      {
        this.jdField_a_of_type_Bcnt.a((List)localObject1);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Bbdj != null)
        {
          this.jdField_a_of_type_Bbdj.b(this.jdField_a_of_type_Bcnt.getCount());
          this.jdField_a_of_type_Bbdj.a(this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Bcnt != null) {
      this.jdField_a_of_type_Bcnt.a();
    }
    if (this.jdField_a_of_type_Ailh != null) {
      this.jdField_a_of_type_Ailh.f();
    }
    if (this.jdField_b_of_type_Ailh != null) {
      this.jdField_b_of_type_Ailh.f();
    }
    super.doOnDestroy();
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    a(paramIntent);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_JavaUtilSet.size() > 0) {
      localIntent.putStringArrayListExtra("key_del_pics", new ArrayList(this.jdField_a_of_type_JavaUtilSet));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("finish delPics=%s", new Object[] { Arrays.toString(this.jdField_a_of_type_JavaUtilSet.toArray()) }));
    }
    setResult(-1, localIntent);
    super.finish();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user grant = ");
    if (bhou.k())
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((localContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_Aovq != null) && (this.jdField_a_of_type_Aovq.a != null)) {
        this.jdField_a_of_type_Aovq.a.run();
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131365063: 
    case 2131362279: 
      do
      {
        return;
        if (!bdee.d(this))
        {
          QQToast.a(this, getString(2131694829), 0).b(getResources().getDimensionPixelOffset(2131298914));
          return;
        }
        paramView = (bhpy)bhql.a(this, null);
        paramView.a(2131693482, 3);
        paramView.c(2131690648);
        paramView.a(new bbdh(this, paramView));
        paramView.show();
        return;
      } while ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
      d();
      return;
    case 2131363020: 
      finish();
      return;
    }
    this.jdField_a_of_type_Ailh.c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Ailh == null) {}
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_Bcmd.a(paramInt);
      if (paramAdapterView != null)
      {
        if (4 != paramAdapterView.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Ailh.b(paramInt);
          return;
        }
        if (!bdee.d(this))
        {
          QQToast.a(this, getString(2131694829), 0).b(getResources().getDimensionPixelOffset(2131298914));
          return;
        }
        this.jdField_a_of_type_Ailh.c();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troop_avatar_wall", 2, "avatarInfo = null, position=" + paramInt);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        d();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    mbt.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    mbt.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */