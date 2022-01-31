package com.tencent.mobileqq.troop.activity;

import actj;
import agle;
import agqf;
import agqi;
import agqn;
import agqp;
import agqq;
import ajsd;
import ajya;
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
import anej;
import aqbe;
import axqy;
import ayoi;
import ayst;
import azer;
import azes;
import azet;
import azeu;
import azev;
import azew;
import azex;
import azey;
import azez;
import azfa;
import bahv;
import bana;
import banq;
import bapg;
import bbdj;
import bbfj;
import bbgu;
import bbvj;
import bcql;
import bfnz;
import bfpc;
import bfpp;
import bfpt;
import bfqu;
import bkvi;
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
import lze;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;
import vzl;
import whj;

public class TroopAvatarWallEditActivity
  extends BaseActivity
  implements agqn, agqp, View.OnClickListener, bfpt, bfqu
{
  public int a;
  private long jdField_a_of_type_Long;
  public agqi a;
  protected Rect a;
  protected View a;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  anej jdField_a_of_type_Anej;
  private azfa jdField_a_of_type_Azfa;
  public banq a;
  public bapg a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected DragView a;
  protected Gallery a;
  public GridView a;
  public String a;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected boolean a;
  protected int b;
  agqi b;
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
    if (this.jdField_a_of_type_Agqi == null) {}
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
    this.jdField_a_of_type_Agqi.a(str, paramIntent);
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)findViewById(2131362971));
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
      this.jdField_a_of_type_Banq = new banq(paramBundle, localGridView, localQQAppInterface, str, bool, this.jdField_a_of_type_Boolean, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i = this.jdField_a_of_type_Banq.a(this);
      ((RelativeLayout)findViewById(2131375381)).setMinimumHeight(i * 2 + vzl.a(this, 10.0F));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      axqy.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((bfnz.l()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
        localObject = new TroopAvatarWallEditActivity.9(this);
        this.jdField_a_of_type_Anej = new anej();
        this.jdField_a_of_type_Anej.b = ((Runnable)localObject);
        this.jdField_a_of_type_Anej.a = paramURLDrawable;
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
    if (this.jdField_a_of_type_Agqi == null) {}
    do
    {
      do
      {
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        localObject = this.jdField_a_of_type_Agqi.a();
        if (QLog.isColorLevel()) {
          QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Arrays.deepToString(((List)localObject).toArray()) }));
        }
        if ((this.jdField_a_of_type_Banq != null) && (paramBoolean2)) {
          this.jdField_a_of_type_Banq.a((List)localObject);
        }
      } while ((this.jdField_a_of_type_Bapg == null) || (!paramBoolean1));
      this.jdField_a_of_type_Bapg.a((List)localObject);
    } while (this.jdField_a_of_type_Azfa == null);
    this.jdField_a_of_type_Azfa.b(this.jdField_a_of_type_Bapg.getCount());
    this.jdField_a_of_type_Azfa.a(this.jdField_a_of_type_Int);
    return;
    Object localObject = this.jdField_a_of_type_Agqi.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject }));
    }
    ArrayList localArrayList = new ArrayList(1);
    Button localButton;
    if (localObject != null)
    {
      localArrayList.add(localObject);
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (((agle)localObject).jdField_a_of_type_Boolean) {
        break label248;
      }
    }
    label248:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localButton.setEnabled(paramBoolean1);
      if (this.jdField_a_of_type_Bapg == null) {
        break;
      }
      this.jdField_a_of_type_Bapg.a(localArrayList);
      return;
    }
  }
  
  private void b(Bundle paramBundle)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131366897));
    View localView = findViewById(2131375377);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    Object localObject = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localObject = agqq.a(this, 103);
      localLayoutParams.bottomMargin = actj.a(45.0F, getResources());
      localLayoutParams.width = ((Point)localObject).x;
      localLayoutParams.height = ((Point)localObject).y;
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Bapg = new bapg(this, this.app, this.jdField_a_of_type_JavaLangString, ((Point)localObject).x, ((Point)localObject).y, this.jdField_a_of_type_ComTencentWidgetGallery);
      this.jdField_a_of_type_Bapg.a(this.jdField_b_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Bapg;
      if (paramBundle.getBoolean("from_photo_wall", false)) {
        break label571;
      }
      bool1 = true;
      label196:
      ((bapg)localObject).c(bool1);
      this.jdField_a_of_type_Bapg.d(paramBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Bapg.a(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Bapg.b(this.jdField_a_of_type_Boolean);
      paramBundle = agqq.a(this, 103);
      this.jdField_a_of_type_Bapg.a(paramBundle.x, paramBundle.y);
      this.jdField_a_of_type_ComTencentWidgetGallery.setContentDescription(ajya.a(2131715219));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297009));
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
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Bapg);
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new azer(this));
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new azew(this));
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new azex(this));
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131365403));
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
        ((Point)localObject).set(i, agqq.a(i));
        break;
      }
      int k = actj.a(60.0F, getResources());
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
    String str = ajsd.bc;
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
        bcql.a(this, getString(2131695190), 0).a();
        return;
      }
    }
    bbdj.a(this, 230).setTitle(getString(2131718848)).setMessage(getString(2131695183)).setPositiveButton(getString(2131718724), new azet(this, paramURLDrawable, str)).setNegativeButton(getString(2131694648), new azes(this)).show();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new azeu(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131691501));
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368081));
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Azfa = new azfa(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Azfa.b(this.jdField_a_of_type_Bapg.getCount());
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131367776)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      bcql.a(this, getString(2131693235), 0).a();
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(2131693384, 1);
    localbfpc.a(2131693394, 1);
    if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
      ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localbfpc));
    }
    localbfpc.c(2131690596);
    localbfpc.a(new azez(this, localbfpc, (URLDrawable)localObject));
    localbfpc.show();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject2 = agqq.a(bahv.b(bahv.a(agle.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0)));
    if (localObject2 == null)
    {
      b(1);
      return;
    }
    File localFile2 = ayoi.a(((URL)localObject2).toString());
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
        localObject2 = new ayst();
      }
      try
      {
        localObject1 = ((ayst)localObject2).loadImageFile((DownloadParams)localObject1, new azev(this));
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", new Object[] { Boolean.valueOf(bool) }));
          }
          if (!bool) {
            break label284;
          }
          if (this.jdField_b_of_type_Agqi == null)
          {
            this.jdField_b_of_type_Agqi = new agqf(this, this, this.app, this.jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_Agqi.a(this);
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
  
  public void a(agle paramagle)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(true, true);
    }
  }
  
  public void a(agle paramagle, bana parambana)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramagle.d == 1) && (this.d)) {
        if (parambana.jdField_a_of_type_Int == 1)
        {
          this.d = false;
          b();
        }
      }
      while (this.jdField_a_of_type_Banq == null)
      {
        do
        {
          return;
        } while (parambana.jdField_a_of_type_Int != 2);
        b(5);
        return;
      }
      this.jdField_a_of_type_Banq.a(paramagle, parambana);
      return;
    }
    Button localButton;
    if (this.jdField_a_of_type_Bapg.a(0) == paramagle)
    {
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (paramagle.jdField_a_of_type_Boolean) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      this.jdField_a_of_type_Bapg.a(paramagle, parambana);
      if ((paramagle.d != 1) || (parambana.jdField_a_of_type_Int != 1)) {
        break;
      }
      agqi.a(agqq.a(this, 0), 2);
      return;
    }
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      axqy.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramString = bbvj.a(ajsd.bX);
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
      aqbe.a(this, paramURLDrawable, 21);
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
    localIntent.putExtra("report_params", whj.a(null, paramString2, null, null, null, 7));
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
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.a();
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_Agqi != null) {
        this.jdField_a_of_type_Agqi.d(paramInt);
      }
      return;
    }
    runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
  }
  
  public void b(agle paramagle)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramagle.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(paramagle.c)) && (bahv.b(paramagle.c))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramagle.c);
      }
      if (this.jdField_a_of_type_Agqi.a().size() == 0) {
        finish();
      }
      a(true, true);
      if (this.jdField_a_of_type_Int >= 0) {
        this.jdField_a_of_type_Agqi.b(this.jdField_a_of_type_Int);
      }
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    if ((this.jdField_a_of_type_Anej != null) && (this.jdField_a_of_type_Anej.b != null)) {
      this.jdField_a_of_type_Anej.b.run();
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
      } while (this.jdField_a_of_type_Agqi == null);
      this.jdField_a_of_type_Agqi.d();
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
    setContentView(2131560304);
    Object localObject1 = getIntent().getExtras();
    findViewById(2131375496).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362998);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364978));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363484));
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
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (bkvi.c) && (bkvi.jdField_a_of_type_Boolean))
    {
      int i = bkvi.b(this);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).top -= i;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).bottom -= i;
    }
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755879);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362984));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131715217));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (ThemeUtil.isInNightMode(this.app))
    {
      localObject2 = getResources().getDrawable(2130839569);
      ((Drawable)localObject2).setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
    a((Bundle)localObject1);
    b((Bundle)localObject1);
    c();
    if (!this.c) {
      if (this.jdField_b_of_type_Boolean)
      {
        paramBundle = new agqi(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Agqi = paramBundle;
        this.jdField_a_of_type_Agqi.a(this);
        this.jdField_a_of_type_Agqi.e(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Agqi.a(false);
        this.jdField_a_of_type_Agqi.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Agqi.a(this);
      }
    }
    for (;;)
    {
      a(getIntent());
      return true;
      paramBundle = new agqf(this, this, this.app, this.jdField_a_of_type_JavaLangString);
      break;
      localObject1 = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (TroopClipPic)paramBundle.next();
        if (localObject2 != null) {
          ((List)localObject1).add(agle.a((TroopClipPic)localObject2, null));
        }
      }
      if (this.jdField_a_of_type_Bapg != null)
      {
        this.jdField_a_of_type_Bapg.a((List)localObject1);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Azfa != null)
        {
          this.jdField_a_of_type_Azfa.b(this.jdField_a_of_type_Bapg.getCount());
          this.jdField_a_of_type_Azfa.a(this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Bapg != null) {
      this.jdField_a_of_type_Bapg.a();
    }
    if (this.jdField_a_of_type_Agqi != null) {
      this.jdField_a_of_type_Agqi.f();
    }
    if (this.jdField_b_of_type_Agqi != null) {
      this.jdField_b_of_type_Agqi.f();
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
    if (bfnz.l())
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((localContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_Anej != null) && (this.jdField_a_of_type_Anej.a != null)) {
        this.jdField_a_of_type_Anej.a.run();
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
    case 2131364978: 
    case 2131362258: 
      do
      {
        return;
        if (!bbfj.d(this))
        {
          bcql.a(this, getString(2131694673), 0).b(getResources().getDimensionPixelOffset(2131298865));
          return;
        }
        paramView = (bfpc)bfpp.a(this, null);
        paramView.a(2131693381, 3);
        paramView.c(2131690596);
        paramView.a(new azey(this, paramView));
        paramView.show();
        return;
      } while ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
      d();
      return;
    case 2131362984: 
      finish();
      return;
    }
    this.jdField_a_of_type_Agqi.c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Agqi == null) {}
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_Banq.a(paramInt);
      if (paramAdapterView != null)
      {
        if (4 != paramAdapterView.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Agqi.b(paramInt);
          return;
        }
        if (!bbfj.d(this))
        {
          bcql.a(this, getString(2131694673), 0).b(getResources().getDimensionPixelOffset(2131298865));
          return;
        }
        this.jdField_a_of_type_Agqi.c();
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
    lze.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    lze.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */