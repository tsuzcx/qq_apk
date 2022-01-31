package com.tencent.mobileqq.troop.activity;

import actn;
import aglg;
import agqh;
import agqk;
import agqp;
import agqr;
import agqs;
import ajsf;
import ajyc;
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
import anee;
import aqbc;
import axqw;
import ayog;
import aysr;
import azep;
import azeq;
import azer;
import azes;
import azet;
import azeu;
import azev;
import azew;
import azex;
import azey;
import bahh;
import bamm;
import banc;
import baos;
import bbcv;
import bbev;
import bbgg;
import bbuv;
import bcpw;
import bfni;
import bfol;
import bfoy;
import bfpc;
import bfqd;
import bkur;
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
import lzj;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;
import vzo;
import whm;

public class TroopAvatarWallEditActivity
  extends BaseActivity
  implements agqp, agqr, View.OnClickListener, bfpc, bfqd
{
  public int a;
  private long jdField_a_of_type_Long;
  public agqk a;
  protected Rect a;
  protected View a;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  anee jdField_a_of_type_Anee;
  private azey jdField_a_of_type_Azey;
  public banc a;
  public baos a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected DragView a;
  protected Gallery a;
  public GridView a;
  public String a;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected boolean a;
  protected int b;
  agqk b;
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
    if (this.jdField_a_of_type_Agqk == null) {}
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
    this.jdField_a_of_type_Agqk.a(str, paramIntent);
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)findViewById(2131362972));
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
      this.jdField_a_of_type_Banc = new banc(paramBundle, localGridView, localQQAppInterface, str, bool, this.jdField_a_of_type_Boolean, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i = this.jdField_a_of_type_Banc.a(this);
      ((RelativeLayout)findViewById(2131375379)).setMinimumHeight(i * 2 + vzo.a(this, 10.0F));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      axqw.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((bfni.l()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
        localObject = new TroopAvatarWallEditActivity.9(this);
        this.jdField_a_of_type_Anee = new anee();
        this.jdField_a_of_type_Anee.b = ((Runnable)localObject);
        this.jdField_a_of_type_Anee.a = paramURLDrawable;
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
    if (this.jdField_a_of_type_Agqk == null) {}
    do
    {
      do
      {
        return;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        localObject = this.jdField_a_of_type_Agqk.a();
        if (QLog.isColorLevel()) {
          QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Arrays.deepToString(((List)localObject).toArray()) }));
        }
        if ((this.jdField_a_of_type_Banc != null) && (paramBoolean2)) {
          this.jdField_a_of_type_Banc.a((List)localObject);
        }
      } while ((this.jdField_a_of_type_Baos == null) || (!paramBoolean1));
      this.jdField_a_of_type_Baos.a((List)localObject);
    } while (this.jdField_a_of_type_Azey == null);
    this.jdField_a_of_type_Azey.b(this.jdField_a_of_type_Baos.getCount());
    this.jdField_a_of_type_Azey.a(this.jdField_a_of_type_Int);
    return;
    Object localObject = this.jdField_a_of_type_Agqk.a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject }));
    }
    ArrayList localArrayList = new ArrayList(1);
    Button localButton;
    if (localObject != null)
    {
      localArrayList.add(localObject);
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (((aglg)localObject).jdField_a_of_type_Boolean) {
        break label248;
      }
    }
    label248:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localButton.setEnabled(paramBoolean1);
      if (this.jdField_a_of_type_Baos == null) {
        break;
      }
      this.jdField_a_of_type_Baos.a(localArrayList);
      return;
    }
  }
  
  private void b(Bundle paramBundle)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131366897));
    View localView = findViewById(2131375375);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    Object localObject = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localObject = agqs.a(this, 103);
      localLayoutParams.bottomMargin = actn.a(45.0F, getResources());
      localLayoutParams.width = ((Point)localObject).x;
      localLayoutParams.height = ((Point)localObject).y;
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Baos = new baos(this, this.app, this.jdField_a_of_type_JavaLangString, ((Point)localObject).x, ((Point)localObject).y, this.jdField_a_of_type_ComTencentWidgetGallery);
      this.jdField_a_of_type_Baos.a(this.jdField_b_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_Baos;
      if (paramBundle.getBoolean("from_photo_wall", false)) {
        break label571;
      }
      bool1 = true;
      label196:
      ((baos)localObject).c(bool1);
      this.jdField_a_of_type_Baos.d(paramBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Baos.a(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Baos.b(this.jdField_a_of_type_Boolean);
      paramBundle = agqs.a(this, 103);
      this.jdField_a_of_type_Baos.a(paramBundle.x, paramBundle.y);
      this.jdField_a_of_type_ComTencentWidgetGallery.setContentDescription(ajyc.a(2131715208));
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
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Baos);
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new azep(this));
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new azeu(this));
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new azev(this));
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131365404));
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
        ((Point)localObject).set(i, agqs.a(i));
        break;
      }
      int k = actn.a(60.0F, getResources());
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
    String str = ajsf.bc;
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
        bcpw.a(this, getString(2131695189), 0).a();
        return;
      }
    }
    bbcv.a(this, 230).setTitle(getString(2131718837)).setMessage(getString(2131695182)).setPositiveButton(getString(2131718713), new azer(this, paramURLDrawable, str)).setNegativeButton(getString(2131694647), new azeq(this)).show();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new azes(this, paramURLDrawable, paramString).execute(new Void[0]);
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
      this.jdField_a_of_type_Azey = new azey(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_Azey.b(this.jdField_a_of_type_Baos.getCount());
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = actn.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      bcpw.a(this, getString(2131693234), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      bcpw.a(this, getString(2131693234), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131367776)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      bcpw.a(this, getString(2131693234), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      bcpw.a(this, getString(2131693234), 0).a();
      return;
    }
    bfol localbfol = (bfol)bfoy.a(this, null);
    localbfol.a(2131693383, 1);
    localbfol.a(2131693393, 1);
    if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
      ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localbfol));
    }
    localbfol.c(2131690596);
    localbfol.a(new azex(this, localbfol, (URLDrawable)localObject));
    localbfol.show();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject2 = agqs.a(bahh.b(bahh.a(aglg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0)));
    if (localObject2 == null)
    {
      b(1);
      return;
    }
    File localFile2 = ayog.a(((URL)localObject2).toString());
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
        localObject2 = new aysr();
      }
      try
      {
        localObject1 = ((aysr)localObject2).loadImageFile((DownloadParams)localObject1, new azet(this));
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", new Object[] { Boolean.valueOf(bool) }));
          }
          if (!bool) {
            break label284;
          }
          if (this.jdField_b_of_type_Agqk == null)
          {
            this.jdField_b_of_type_Agqk = new agqh(this, this, this.app, this.jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_Agqk.a(this);
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
  
  public void a(aglg paramaglg)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(true, true);
    }
  }
  
  public void a(aglg paramaglg, bamm parambamm)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramaglg.d == 1) && (this.d)) {
        if (parambamm.jdField_a_of_type_Int == 1)
        {
          this.d = false;
          b();
        }
      }
      while (this.jdField_a_of_type_Banc == null)
      {
        do
        {
          return;
        } while (parambamm.jdField_a_of_type_Int != 2);
        b(5);
        return;
      }
      this.jdField_a_of_type_Banc.a(paramaglg, parambamm);
      return;
    }
    Button localButton;
    if (this.jdField_a_of_type_Baos.a(0) == paramaglg)
    {
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (paramaglg.jdField_a_of_type_Boolean) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      this.jdField_a_of_type_Baos.a(paramaglg, parambamm);
      if ((paramaglg.d != 1) || (parambamm.jdField_a_of_type_Int != 1)) {
        break;
      }
      agqk.a(agqs.a(this, 0), 2);
      return;
    }
  }
  
  public void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      axqw.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramString = bbuv.a(ajsf.bX);
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
      aqbc.a(this, paramURLDrawable, 21);
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
    localIntent.putExtra("report_params", whm.a(null, paramString2, null, null, null, 7));
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
    if (this.jdField_a_of_type_Agqk != null) {
      this.jdField_a_of_type_Agqk.a();
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_Agqk != null) {
        this.jdField_a_of_type_Agqk.d(paramInt);
      }
      return;
    }
    runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
  }
  
  public void b(aglg paramaglg)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramaglg.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(paramaglg.c)) && (bahh.b(paramaglg.c))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramaglg.c);
      }
      if (this.jdField_a_of_type_Agqk.a().size() == 0) {
        finish();
      }
      a(true, true);
      if (this.jdField_a_of_type_Int >= 0) {
        this.jdField_a_of_type_Agqk.b(this.jdField_a_of_type_Int);
      }
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    if ((this.jdField_a_of_type_Anee != null) && (this.jdField_a_of_type_Anee.b != null)) {
      this.jdField_a_of_type_Anee.b.run();
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
      } while (this.jdField_a_of_type_Agqk == null);
      this.jdField_a_of_type_Agqk.d();
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
    findViewById(2131375494).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362999);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131364979));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363485));
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
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (bkur.c) && (bkur.jdField_a_of_type_Boolean))
    {
      int i = bkur.b(this);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).top -= i;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).bottom -= i;
    }
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755879);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362985));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajyc.a(2131715206));
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
        paramBundle = new agqk(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Agqk = paramBundle;
        this.jdField_a_of_type_Agqk.a(this);
        this.jdField_a_of_type_Agqk.e(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Agqk.a(false);
        this.jdField_a_of_type_Agqk.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Agqk.a(this);
      }
    }
    for (;;)
    {
      a(getIntent());
      return true;
      paramBundle = new agqh(this, this, this.app, this.jdField_a_of_type_JavaLangString);
      break;
      localObject1 = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (TroopClipPic)paramBundle.next();
        if (localObject2 != null) {
          ((List)localObject1).add(aglg.a((TroopClipPic)localObject2, null));
        }
      }
      if (this.jdField_a_of_type_Baos != null)
      {
        this.jdField_a_of_type_Baos.a((List)localObject1);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Azey != null)
        {
          this.jdField_a_of_type_Azey.b(this.jdField_a_of_type_Baos.getCount());
          this.jdField_a_of_type_Azey.a(this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Baos != null) {
      this.jdField_a_of_type_Baos.a();
    }
    if (this.jdField_a_of_type_Agqk != null) {
      this.jdField_a_of_type_Agqk.f();
    }
    if (this.jdField_b_of_type_Agqk != null) {
      this.jdField_b_of_type_Agqk.f();
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
    if (bfni.l())
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((localContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_Anee != null) && (this.jdField_a_of_type_Anee.a != null)) {
        this.jdField_a_of_type_Anee.a.run();
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
    case 2131364979: 
    case 2131362259: 
      do
      {
        return;
        if (!bbev.d(this))
        {
          bcpw.a(this, getString(2131694672), 0).b(getResources().getDimensionPixelOffset(2131298865));
          return;
        }
        paramView = (bfol)bfoy.a(this, null);
        paramView.a(2131693380, 3);
        paramView.c(2131690596);
        paramView.a(new azew(this, paramView));
        paramView.show();
        return;
      } while ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean));
      d();
      return;
    case 2131362985: 
      finish();
      return;
    }
    this.jdField_a_of_type_Agqk.c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Agqk == null) {}
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_Banc.a(paramInt);
      if (paramAdapterView != null)
      {
        if (4 != paramAdapterView.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Agqk.b(paramInt);
          return;
        }
        if (!bbev.d(this))
        {
          bcpw.a(this, getString(2131694672), 0).b(getResources().getDimensionPixelOffset(2131298865));
          return;
        }
        this.jdField_a_of_type_Agqk.c();
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
    lzj.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    lzj.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */