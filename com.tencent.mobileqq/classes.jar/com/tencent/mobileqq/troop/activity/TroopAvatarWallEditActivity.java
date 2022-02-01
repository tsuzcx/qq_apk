package com.tencent.mobileqq.troop.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.activity.photo.TroopAvatarController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnDataChangeListener;
import com.tencent.mobileqq.activity.photo.TroopPhotoController.OnUploadListener;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.OnGestureChangeListener;
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
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.util.WeakReference;

public class TroopAvatarWallEditActivity
  extends BaseActivity
  implements View.OnClickListener, TroopPhotoController.OnDataChangeListener, TroopPhotoController.OnUploadListener, AdapterView.OnItemClickListener, DragView.OnGestureChangeListener
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected Rect a;
  protected View a;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  PermissionParam jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam;
  TroopPhotoController jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController;
  private TroopAvatarWallEditActivity.Indicator jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator;
  public AvatarGridAdapter a;
  protected TroopAvatarWallGalleryAdapter a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected DragView a;
  protected Gallery a;
  public GridView a;
  protected String a;
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected boolean a;
  protected int b;
  TroopPhotoController b;
  protected String b;
  protected boolean b;
  String c;
  protected boolean c = false;
  protected boolean d = false;
  
  public TroopAvatarWallEditActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null) {}
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
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPicPicked(str, paramIntent);
  }
  
  private void a(Bundle paramBundle)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)findViewById(2131363233));
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
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter = new AvatarGridAdapter(paramBundle, localGridView, localQQAppInterface, str, bool, this.jdField_a_of_type_Boolean, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter.a(this);
      ((RelativeLayout)findViewById(2131377227)).setMinimumHeight(i * 2 + UIUtils.a(this, 10.0F));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(8);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if ((VersionUtils.k()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
        localObject = new TroopAvatarWallEditActivity.9(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam = new PermissionParam();
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.b = ((Runnable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.a = paramURLDrawable;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null) {
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.getCoverList();
      if (QLog.isColorLevel()) {
        if (localObject2 != null) {
          break label159;
        }
      }
      label159:
      for (localObject1 = "";; localObject1 = Arrays.deepToString(((List)localObject2).toArray()))
      {
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), localObject1 }));
        if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter != null) && (paramBoolean2)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter.a((List)localObject2);
        }
        if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter == null) || (!paramBoolean1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a((List)localObject2);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount());
        this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.a(this.jdField_a_of_type_Int);
        return;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.getAvatar();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject1 }));
    }
    Object localObject2 = new ArrayList(1);
    Button localButton;
    if (localObject1 != null)
    {
      ((List)localObject2).add(localObject1);
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (((AvatarInfo)localObject1).jdField_a_of_type_Boolean) {
        break label274;
      }
    }
    label274:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      localButton.setEnabled(paramBoolean1);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a((List)localObject2);
      return;
    }
  }
  
  private void b()
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369046));
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator = new TroopAvatarWallEditActivity.Indicator(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount());
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private void b(Bundle paramBundle)
  {
    boolean bool2 = false;
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367677));
    View localView = findViewById(2131377223);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    Object localObject = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localObject = TroopPhotoUtil.a(this, 103);
      localLayoutParams.bottomMargin = AIOUtils.a(45.0F, getResources());
      localLayoutParams.width = ((Point)localObject).x;
      localLayoutParams.height = ((Point)localObject).y;
      localView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter = new TroopAvatarWallGalleryAdapter(this, this.app, this.jdField_a_of_type_JavaLangString, ((Point)localObject).x, ((Point)localObject).y, this.jdField_a_of_type_ComTencentWidgetGallery);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_b_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter;
      if (paramBundle.getBoolean("from_photo_wall", false)) {
        break label571;
      }
      bool1 = true;
      label196:
      ((TroopAvatarWallGalleryAdapter)localObject).c(bool1);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.d(paramBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.b(this.jdField_a_of_type_Boolean);
      paramBundle = TroopPhotoUtil.a(this, 103);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(paramBundle.x, paramBundle.y);
      this.jdField_a_of_type_ComTencentWidgetGallery.setContentDescription(HardCodeUtil.a(2131715067));
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297168));
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
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter);
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new TroopAvatarWallEditActivity.1(this));
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new TroopAvatarWallEditActivity.2(this));
      }
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new TroopAvatarWallEditActivity.3(this));
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
      this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131366062));
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
        ((Point)localObject).set(i, TroopPhotoUtil.a(i));
        break;
      }
      int k = AIOUtils.a(60.0F, getResources());
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
    String str = AppConstants.SDCARD_IMG_SAVE;
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
        QQToast.a(this, getString(2131694921), 0).a();
        return;
      }
    }
    DialogUtil.a(this, 230).setTitle(getString(2131718675)).setMessage(getString(2131694917)).setPositiveButton(getString(2131718540), new TroopAvatarWallEditActivity.11(this, paramURLDrawable, str)).setNegativeButton(getString(2131694495), new TroopAvatarWallEditActivity.10(this)).show();
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new TroopAvatarWallEditActivity.12(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetGallery == null)
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131368729)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131693140), 0).a();
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(2131693302, 1);
    localActionSheet.addButton(2131693308, 1);
    if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
      ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localActionSheet));
    }
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new TroopAvatarWallEditActivity.7(this, localActionSheet, (URLDrawable)localObject));
    localActionSheet.show();
  }
  
  private void c(Bundle paramBundle)
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    Object localObject3 = TroopPhotoUtil.a(((ITroopAvatarUtilApi)localObject1).getArtWork(((ITroopAvatarUtilApi)localObject1).getAvatarAddress(AvatarInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0)));
    if (localObject3 == null)
    {
      a(1);
      return;
    }
    File localFile = AbsDownloader.getFile(((URL)localObject3).toString());
    boolean bool;
    if (QLog.isColorLevel())
    {
      if ((localFile == null) || (!localFile.exists())) {
        break label280;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload %s %b", new Object[] { localObject3, Boolean.valueOf(bool) }));
      if (localFile != null)
      {
        localObject1 = localFile;
        if (localFile.exists()) {}
      }
      else
      {
        localObject1 = new DownloadParams();
        ((DownloadParams)localObject1).url = ((URL)localObject3);
        ((DownloadParams)localObject1).urlStr = ((URL)localObject3).toString();
        localObject3 = new NearbyImgDownloader();
      }
      try
      {
        localObject1 = ((NearbyImgDownloader)localObject3).loadImageFile((DownloadParams)localObject1, new TroopAvatarWallEditActivity.14(this));
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", new Object[] { Boolean.valueOf(bool) }));
          }
          if (!bool) {
            break label300;
          }
          if (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null)
          {
            this.jdField_b_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = new TroopAvatarController(this, this, this.app, this.jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.addDataChangeListener(this);
          }
          runOnUiThread(new TroopAvatarWallEditActivity.15(this, (File)localObject1));
          return;
          label280:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = localFile;
          continue;
          bool = false;
        }
        label300:
        a(3);
      }
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.startUpload();
    }
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onInsertAvatarFailed(paramInt);
      }
      return;
    }
    runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
  }
  
  void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    paramString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_FORWARD_URLDRAWABLE);
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
      ForwardBaseOption.a(this, paramURLDrawable, 21);
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
  
  void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    localIntent.putExtra("report_params", ScannerUtils.a(null, paramString2, null, null, null, 7));
    startActivity(localIntent);
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.b != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.b.run();
    }
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
    case 257: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onSnapShotBack();
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
    setContentView(2131560733);
    Object localObject1 = getIntent().getExtras();
    findViewById(2131377359).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131363419);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365630));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363948));
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
    if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (LiuHaiUtils.c) && (LiuHaiUtils.jdField_a_of_type_Boolean))
    {
      int i = LiuHaiUtils.b(this);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).top -= i;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).bottom -= i;
    }
    if (!this.jdField_a_of_type_Boolean) {
      setTheme(2131755937);
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363402));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131715065));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (ThemeUtil.isInNightMode(this.app))
    {
      localObject2 = getResources().getDrawable(2130840231);
      ((Drawable)localObject2).setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    }
    a((Bundle)localObject1);
    b((Bundle)localObject1);
    b();
    if (!this.c) {
      if (this.jdField_b_of_type_Boolean)
      {
        paramBundle = new TroopPhotoController(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.addDataChangeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onGetTroopAuthSubmitTime(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onUpdateTroopAvatarWallList(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onItemSelect(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.setUploadListener(this);
      }
    }
    for (;;)
    {
      a(getIntent());
      return true;
      paramBundle = new TroopAvatarController(this, this, this.app, this.jdField_a_of_type_JavaLangString);
      break;
      localObject1 = new ArrayList();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        localObject2 = (TroopClipPic)paramBundle.next();
        if (localObject2 != null) {
          ((List)localObject1).add(AvatarInfo.a((TroopClipPic)localObject2, null));
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a((List)localObject1);
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount());
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.a(this.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onDestroy();
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
    if (VersionUtils.k())
    {
      Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((localContext.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (localContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPermissionPermissionParam.a.run();
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAddItem(AvatarInfo paramAvatarInfo)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(true, true);
    }
  }
  
  public boolean onBeforeUpload(int paramInt)
  {
    if ((this.d) && (paramInt == 0))
    {
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.13(this), null, true);
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!NetworkUtil.d(this))
      {
        QQToast.a(this, getString(2131694510), 0).b(getResources().getDimensionPixelOffset(2131299166));
      }
      else
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
        localActionSheet.addButton(2131693299, 3);
        localActionSheet.addCancelButton(2131690800);
        localActionSheet.setOnButtonClickListener(new TroopAvatarWallEditActivity.5(this, localActionSheet));
        localActionSheet.show();
        continue;
        if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
        {
          c();
          continue;
          finish();
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPickPic();
        }
      }
    }
  }
  
  public void onClickDragView()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onClickDragView", new Object[0]));
    }
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onContentMove(float paramFloat)
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
  
  public void onDataSetChanged()
  {
    a(true, true);
  }
  
  public void onDelItem(AvatarInfo paramAvatarInfo)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      if ((paramAvatarInfo.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(paramAvatarInfo.c)) && (localITroopAvatarUtilApi.isNumeric(paramAvatarInfo.c))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramAvatarInfo.c);
      }
      paramAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.getCoverList();
      if ((paramAvatarInfo == null) || (paramAvatarInfo.size() == 0)) {
        finish();
      }
      a(true, true);
      if (this.jdField_a_of_type_Int >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onItemSelect(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onGestureFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "onGestureFinish");
    }
    finish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController == null) {}
    do
    {
      return;
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter.a(paramInt);
      if (paramAdapterView != null)
      {
        if (4 != paramAdapterView.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onItemSelect(paramInt);
          return;
        }
        if (!NetworkUtil.d(this))
        {
          QQToast.a(this, getString(2131694510), 0).b(getResources().getDimensionPixelOffset(2131299166));
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoTroopPhotoController.onPickPic();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troop_avatar_wall", 2, "avatarInfo = null, position=" + paramInt);
  }
  
  public void onItemSelect(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentWidgetGallery.getSelectedItemPosition() != paramInt) {
        this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(paramInt);
      }
      a(false, true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        c();
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResetPosition()
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
  
  public void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
  
  public void onUpdateItem(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramAvatarInfo.d == 1) && (this.d)) {
        if (paramUploadState.jdField_a_of_type_Int == 1)
        {
          this.d = false;
          a();
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter == null)
      {
        do
        {
          return;
        } while (paramUploadState.jdField_a_of_type_Int != 2);
        a(5);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter.a(paramAvatarInfo, paramUploadState);
      return;
    }
    Button localButton;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(0) == paramAvatarInfo)
    {
      localButton = this.jdField_a_of_type_AndroidWidgetButton;
      if (paramAvatarInfo.jdField_a_of_type_Boolean) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(paramAvatarInfo, paramUploadState);
      if ((paramAvatarInfo.d != 1) || (paramUploadState.jdField_a_of_type_Int != 1)) {
        break;
      }
      TroopPhotoController.showToast(TroopPhotoUtil.a(this, 0), 2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */