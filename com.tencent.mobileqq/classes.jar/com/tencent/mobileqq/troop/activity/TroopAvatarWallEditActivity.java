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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.phonecontact.permission.PermissionParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.TroopAvatarController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnDataChangeListener;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController.OnUploadListener;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread.UploadState;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  PermissionParam jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam;
  private TroopAvatarWallEditActivity.Indicator jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator;
  TroopPhotoController jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController == null) {
      return;
    }
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(str, paramIntent);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentWidgetGridView = ((GridView)findViewById(2131363167));
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentWidgetGridView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetGridView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter = new AvatarGridAdapter(new WeakReference(this), this.jdField_a_of_type_ComTencentWidgetGridView, this.app, this.jdField_a_of_type_JavaLangString, this.c ^ true, this.jdField_a_of_type_Boolean, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter.a(this);
      ((RelativeLayout)findViewById(2131376687)).setMinimumHeight(i * 2 + UIUtils.a(this, 10.0F));
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
    int i;
    if ((VersionUtils.k()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
      localObject = new TroopAvatarWallEditActivity.9(this);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam = new PermissionParam();
      PermissionParam localPermissionParam = this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam;
      localPermissionParam.b = ((Runnable)localObject);
      localPermissionParam.a = paramURLDrawable;
      requestPermissions(this, 1, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b(paramURLDrawable);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject2 = ((TroopPhotoController)localObject1).a();
      if (QLog.isColorLevel())
      {
        if (localObject2 == null) {
          localObject1 = "";
        } else {
          localObject1 = Arrays.deepToString(((List)localObject2).toArray());
        }
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet [%b,%b] %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), localObject1 }));
      }
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter;
        if ((localObject1 != null) && (paramBoolean2)) {
          ((AvatarGridAdapter)localObject1).a((List)localObject2);
        }
      }
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter;
        if ((localObject1 != null) && (paramBoolean1))
        {
          ((TroopAvatarWallGalleryAdapter)localObject1).a((List)localObject2);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator;
          if (localObject1 != null)
          {
            ((TroopAvatarWallEditActivity.Indicator)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount());
            this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.a(this.jdField_a_of_type_Int);
          }
        }
      }
    }
    else
    {
      localObject2 = ((TroopPhotoController)localObject1).a();
      if (QLog.isColorLevel()) {
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject2 }));
      }
      localObject1 = new ArrayList(1);
      if (localObject2 != null)
      {
        ((List)localObject1).add(localObject2);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(((AvatarInfo)localObject2).jdField_a_of_type_Boolean ^ true);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter;
      if (localObject2 != null) {
        ((TroopAvatarWallGalleryAdapter)localObject2).a((List)localObject1);
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367431));
    View localView = findViewById(2131376683);
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = getResources().getDisplayMetrics().heightPixels;
    Point localPoint = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localPoint = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(this, 103);
      localLayoutParams.bottomMargin = AIOUtils.b(45.0F, getResources());
    }
    else if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      localPoint.set(i, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(i));
    }
    else
    {
      int k = AIOUtils.b(60.0F, getResources());
      localPoint.set(i, j - k);
      localLayoutParams.removeRule(13);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = k;
    }
    localLayoutParams.width = localPoint.x;
    localLayoutParams.height = localPoint.y;
    localView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter = new TroopAvatarWallGalleryAdapter(this, this.app, this.jdField_a_of_type_JavaLangString, localPoint.x, localPoint.y, this.jdField_a_of_type_ComTencentWidgetGallery);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.c(paramBundle.getBoolean("from_photo_wall", false) ^ true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.d(paramBundle.getBoolean("is_use_path", false));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.b(this.jdField_a_of_type_Boolean);
    paramBundle = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(this, 103);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(paramBundle.x, paramBundle.y);
    this.jdField_a_of_type_ComTencentWidgetGallery.setContentDescription(HardCodeUtil.a(2131714990));
    this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297150));
    this.jdField_a_of_type_ComTencentWidgetGallery.enableDoubleTap(this.jdField_a_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentWidgetGallery.enableScaleGesture(this.jdField_a_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter);
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new TroopAvatarWallEditActivity.1(this));
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new TroopAvatarWallEditActivity.2(this));
    }
    this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new TroopAvatarWallEditActivity.3(this));
    ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)findViewById(2131365892));
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setEnableDrag(this.jdField_a_of_type_Boolean ^ true);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(true);
    paramBundle = this.jdField_a_of_type_AndroidGraphicsRect;
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(paramBundle);
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    String str = AppConstants.SDCARD_IMG_SAVE;
    new File(str).mkdirs();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(Utils.Crc64String(paramURLDrawable.getURL().toString()));
    str = ((StringBuilder)localObject).toString();
    localObject = new File(str);
    if (!((File)localObject).exists()) {}
    try
    {
      if (!((File)localObject).createNewFile()) {
        break label177;
      }
      b(paramURLDrawable, ((File)localObject).getPath());
      return;
    }
    catch (IOException paramURLDrawable)
    {
      label92:
      break label92;
    }
    QQToast.a(this, getString(2131694911), 0).a();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131718393)).setMessage(getString(2131694907)).setPositiveButton(getString(2131718205), new TroopAvatarWallEditActivity.11(this, paramURLDrawable, str)).setNegativeButton(getString(2131694460), new TroopAvatarWallEditActivity.10(this)).show();
    label177:
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new TroopAvatarWallEditActivity.12(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(getResources().getString(2131691476));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368768));
    if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator = new TroopAvatarWallEditActivity.Indicator(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
    Object localObject = this.jdField_a_of_type_ComTencentWidgetGallery;
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693100), 0).a();
      return;
    }
    localObject = ((Gallery)localObject).getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131693100), 0).a();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131368461)).getDrawable();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        QQToast.a(this, getString(2131693100), 0).a();
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      localActionSheet.addButton(2131693256, 1);
      localActionSheet.addButton(2131693262, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localActionSheet));
      }
      localActionSheet.addCancelButton(2131690728);
      localActionSheet.setOnButtonClickListener(new TroopAvatarWallEditActivity.7(this, localActionSheet, (URLDrawable)localObject));
      localActionSheet.show();
      return;
    }
    QQToast.a(this, getString(2131693100), 0).a();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    localObject1 = ((ITroopAvatarUtilApi)localObject1).getArtWork(((ITroopAvatarUtilApi)localObject1).getAvatarAddress(AvatarInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0));
    Object localObject3 = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto((String)localObject1);
    if (localObject3 == null)
    {
      b(1);
      return;
    }
    File localFile = AbsDownloader.getFile(((URL)localObject3).toString());
    boolean bool;
    if (QLog.isColorLevel())
    {
      if ((localFile != null) && (localFile.exists())) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload %s %b", new Object[] { localObject3, Boolean.valueOf(bool) }));
    }
    Object localObject2;
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
      try
      {
        localObject1 = ((NearbyImgDownloader)localObject3).loadImageFile((DownloadParams)localObject1, new TroopAvatarWallEditActivity.14(this));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localFile;
      }
    }
    if ((localObject2 != null) && (localObject2.exists())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("insertAvatar f exists=%b", new Object[] { Boolean.valueOf(bool) }));
    }
    if (bool)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController = new TroopAvatarController(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(this);
      }
      runOnUiThread(new TroopAvatarWallEditActivity.15(this, localObject2));
      return;
    }
    b(3);
  }
  
  public void a()
  {
    a(true, true);
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(Utils.Crc64String(paramURLDrawable.getURL().toString()));
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (!new File((String)localObject).exists()) {
      try
      {
        paramString = paramURLDrawable.saveTo((String)localObject);
      }
      catch (IOException paramURLDrawable)
      {
        paramString = (String)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e("foward", 2, "IOException", paramURLDrawable);
          paramString = (String)localObject;
        }
      }
    }
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_thumb", paramString);
    paramURLDrawable = new Intent();
    paramURLDrawable.putExtras(localBundle);
    ForwardBaseOption.a(this, paramURLDrawable, 21);
  }
  
  public void a(AvatarInfo paramAvatarInfo)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(true, true);
    }
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if ((paramAvatarInfo.d == 1) && (this.d))
      {
        if (paramUploadState.jdField_a_of_type_Int == 1)
        {
          this.d = false;
          b();
          return;
        }
        if (paramUploadState.jdField_a_of_type_Int == 2) {
          b(5);
        }
        return;
      }
      AvatarGridAdapter localAvatarGridAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter;
      if (localAvatarGridAdapter != null) {
        localAvatarGridAdapter.a(paramAvatarInfo, paramUploadState);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(0) == paramAvatarInfo)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramAvatarInfo.jdField_a_of_type_Boolean ^ true);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(paramAvatarInfo, paramUploadState);
      }
      if ((paramAvatarInfo.d == 1) && (paramUploadState.jdField_a_of_type_Int == 1)) {
        TroopPhotoController.a(((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this, 0), 2);
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("fromPicQRDecode", true);
    localIntent.putExtra("report_params", ((IScanUtilApi)QRoute.api(IScanUtilApi.class)).buildQRScanReportParams(null, paramString2, null, null, null, 7));
    RouteUtils.a(this, localIntent, "/qrscan/scanner");
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
    TroopPhotoController localTroopPhotoController = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localTroopPhotoController != null) {
      localTroopPhotoController.a();
    }
  }
  
  protected void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      TroopPhotoController localTroopPhotoController = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
      if (localTroopPhotoController != null) {
        localTroopPhotoController.d(paramInt);
      }
    }
    else
    {
      runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
    }
  }
  
  public void b(AvatarInfo paramAvatarInfo)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      if ((paramAvatarInfo.jdField_b_of_type_Int == 1) && (!TextUtils.isEmpty(paramAvatarInfo.c)) && (localITroopAvatarUtilApi.isNumeric(paramAvatarInfo.c))) {
        this.jdField_a_of_type_JavaUtilSet.add(paramAvatarInfo.c);
      }
      paramAvatarInfo = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a();
      if ((paramAvatarInfo == null) || (paramAvatarInfo.size() == 0)) {
        finish();
      }
      a(true, true);
      int i = this.jdField_a_of_type_Int;
      if (i >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.b(i);
      }
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    PermissionParam localPermissionParam = this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam;
    if ((localPermissionParam != null) && (localPermissionParam.b != null)) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam.b.run();
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 21)
      {
        if (paramInt1 != 257) {
          return;
        }
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
        if (paramIntent != null) {
          paramIntent.d();
        }
      }
      else
      {
        c(paramIntent.getExtras());
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if ((this.app != null) && (!TextUtils.isEmpty(this.app.getAccount())))
    {
      setContentView(2131560621);
      Object localObject1 = getIntent().getExtras();
      findViewById(2131376811).setVisibility(0);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131363349);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131365474));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363873));
      this.jdField_a_of_type_Boolean = ((Bundle)localObject1).getBoolean("IS_EDIT");
      this.jdField_b_of_type_Boolean = ((Bundle)localObject1).getBoolean("IS_COVER", true);
      this.d = ((Bundle)localObject1).getBoolean("isUseClassAvatar", false);
      boolean bool;
      if (((Bundle)localObject1).getInt("vistor_type", 1) != 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.c = bool;
      paramBundle = ((Bundle)localObject1).getParcelableArrayList("PHOTO_LIST");
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject1).getString("troop_uin");
      if ((this.c) && ((paramBundle == null) || (paramBundle.size() == 0)))
      {
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
        setTheme(2131756286);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363334));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131714988));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (ThemeUtil.isInNightMode(this.app))
      {
        localObject2 = getResources().getDrawable(2130840090);
        ((Drawable)localObject2).setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      }
      a((Bundle)localObject1);
      b((Bundle)localObject1);
      c();
      if (!this.c)
      {
        if (this.jdField_b_of_type_Boolean) {
          paramBundle = new TroopPhotoController(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        } else {
          paramBundle = new TroopAvatarController(this, this, this.app, this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController = paramBundle;
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(this);
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.e(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(false);
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.b(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.a(this);
      }
      else
      {
        localObject1 = new ArrayList();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          localObject2 = (TroopClipPic)paramBundle.next();
          if (localObject2 != null) {
            ((List)localObject1).add(AvatarInfo.a((TroopClipPic)localObject2, null));
          }
        }
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter;
        if (paramBundle != null)
        {
          paramBundle.a((List)localObject1);
          this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Int);
          paramBundle = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator;
          if (paramBundle != null)
          {
            paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.getCount());
            this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity$Indicator.a(this.jdField_a_of_type_Int);
          }
        }
      }
      a(getIntent());
      return true;
    }
    finish();
    return false;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter;
    if (localObject != null) {
      ((TroopAvatarWallGalleryAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject != null) {
      ((TroopPhotoController)localObject).f();
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController;
    if (localObject != null) {
      ((TroopPhotoController)localObject).f();
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
      Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
      if ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam;
        if ((localObject != null) && (((PermissionParam)localObject).a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactPermissionPermissionParam.a.run();
        }
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131365474: 
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this, getString(2131694475), 0).b(getResources().getDimensionPixelOffset(2131299168));
      }
      else
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
        localActionSheet.addButton(2131693253, 3);
        localActionSheet.addCancelButton(2131690728);
        localActionSheet.setOnButtonClickListener(new TroopAvatarWallEditActivity.5(this, localActionSheet));
        localActionSheet.show();
      }
      break;
    case 2131363873: 
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.c();
      break;
    case 2131363334: 
      finish();
      break;
    case 2131362366: 
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        d();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
  
  public void onGestureFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, "onGestureFinish");
    }
    finish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController == null) {
      return;
    }
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarGridAdapter.a(paramInt);
    if (paramAdapterView != null)
    {
      if (4 != paramAdapterView.jdField_b_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.b(paramInt);
        return;
      }
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this, getString(2131694475), 0).b(getResources().getDimensionPixelOffset(2131299168));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopAvatarTroopPhotoController.c();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("avatarInfo = null, position=");
      paramAdapterView.append(paramInt);
      QLog.i("Q.troop_avatar_wall", 2, paramAdapterView.toString());
    }
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
  
  protected void onPause()
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */