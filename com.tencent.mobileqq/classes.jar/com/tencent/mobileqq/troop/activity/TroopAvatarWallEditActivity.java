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
  private long A;
  protected View a;
  protected DragView b;
  protected Gallery c;
  protected TroopAvatarWallGalleryAdapter d;
  public GridView e;
  public AvatarGridAdapter f;
  protected ImageButton g;
  protected ImageView h;
  protected Button i;
  protected int j = -1;
  protected String k;
  protected int l;
  protected String m;
  protected boolean n = false;
  protected boolean o = true;
  protected boolean p = false;
  protected boolean q = false;
  CookieManager r;
  protected Rect s;
  Set<String> t = new HashSet();
  TroopPhotoController u;
  TroopPhotoController v;
  PermissionParam w;
  String x;
  private TroopAvatarWallEditActivity.Indicator y;
  private LinearLayout z;
  
  private void a(Intent paramIntent)
  {
    if (this.u == null) {
      return;
    }
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.u.b(str, paramIntent);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    this.e = ((GridView)findViewById(2131429041));
    if ((this.o) && (this.n))
    {
      this.e.setVisibility(0);
      this.e.setOnItemClickListener(this);
      this.e.setEdgeEffectEnabled(false);
      this.f = new AvatarGridAdapter(new WeakReference(this), this.e, this.app, this.k, this.p ^ true, this.n, "Grp_Admin_data");
      paramBundle = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramBundle);
      int i1 = this.f.a(this);
      ((RelativeLayout)findViewById(2131444960)).setMinimumHeight(i1 * 2 + UIUtils.a(this, 10.0F));
      return;
    }
    this.e.setVisibility(8);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (this.m != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.m, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    int i1;
    if ((VersionUtils.k()) && ((((Context)localObject).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) || (((Context)localObject).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 == 0)
    {
      paramURLDrawable = new TroopAvatarWallEditActivity.8(this, paramURLDrawable);
      localObject = new TroopAvatarWallEditActivity.9(this);
      this.w = new PermissionParam();
      PermissionParam localPermissionParam = this.w;
      localPermissionParam.c = ((Runnable)localObject);
      localPermissionParam.b = paramURLDrawable;
      requestPermissions(this, 1, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b(paramURLDrawable);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.u;
    if (localObject1 == null) {
      return;
    }
    Object localObject2;
    if (this.o)
    {
      localObject2 = ((TroopPhotoController)localObject1).g();
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
        localObject1 = this.f;
        if ((localObject1 != null) && (paramBoolean2)) {
          ((AvatarGridAdapter)localObject1).a((List)localObject2);
        }
      }
      if (localObject2 != null)
      {
        localObject1 = this.d;
        if ((localObject1 != null) && (paramBoolean1))
        {
          ((TroopAvatarWallGalleryAdapter)localObject1).a((List)localObject2);
          localObject1 = this.y;
          if (localObject1 != null)
          {
            ((TroopAvatarWallEditActivity.Indicator)localObject1).b(this.d.getCount());
            this.y.a(this.j);
          }
        }
      }
    }
    else
    {
      localObject2 = ((TroopPhotoController)localObject1).h();
      if (QLog.isColorLevel()) {
        QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("updateDataSet %s", new Object[] { localObject2 }));
      }
      localObject1 = new ArrayList(1);
      if (localObject2 != null)
      {
        ((List)localObject1).add(localObject2);
        this.i.setEnabled(((AvatarInfo)localObject2).g ^ true);
      }
      localObject2 = this.d;
      if (localObject2 != null) {
        ((TroopAvatarWallGalleryAdapter)localObject2).a((List)localObject1);
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    this.c = ((Gallery)findViewById(2131433934));
    View localView = findViewById(2131444956);
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = getResources().getDisplayMetrics().heightPixels;
    Point localPoint = new Point();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    if ((!this.o) && (this.n))
    {
      localPoint = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(this, 103);
      localLayoutParams.bottomMargin = AIOUtils.b(45.0F, getResources());
    }
    else if ((this.o) && (this.n))
    {
      localPoint.set(i1, ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(i1));
    }
    else
    {
      int i3 = AIOUtils.b(60.0F, getResources());
      localPoint.set(i1, i2 - i3);
      localLayoutParams.removeRule(13);
      localLayoutParams.addRule(12);
      localLayoutParams.bottomMargin = i3;
    }
    localLayoutParams.width = localPoint.x;
    localLayoutParams.height = localPoint.y;
    localView.setLayoutParams(localLayoutParams);
    this.d = new TroopAvatarWallGalleryAdapter(this, this.app, this.k, localPoint.x, localPoint.y, this.c);
    this.d.a(this.m);
    this.d.c(paramBundle.getBoolean("from_photo_wall", false) ^ true);
    this.d.d(paramBundle.getBoolean("is_use_path", false));
    this.d.a(this.o);
    this.d.b(this.n);
    paramBundle = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getClipRectSize(this, 103);
    this.d.a(paramBundle.x, paramBundle.y);
    this.c.setContentDescription(HardCodeUtil.a(2131912484));
    this.c.setSpacing(getResources().getDimensionPixelSize(2131297535));
    this.c.enableDoubleTap(this.n ^ true);
    this.c.enableScaleGesture(this.n ^ true);
    this.c.setAdapter(this.d);
    if ((this.o) && (!this.n)) {
      this.c.setOnItemLongClickListener(new TroopAvatarWallEditActivity.1(this));
    }
    if (!this.n) {
      this.c.setOnItemClickListener(new TroopAvatarWallEditActivity.2(this));
    }
    this.c.setOnItemSelectedListener(new TroopAvatarWallEditActivity.3(this));
    ThreadManager.postImmediately(new TroopAvatarWallEditActivity.4(this), null, true);
    this.b = ((DragView)findViewById(2131432158));
    this.b.setGestureChangeListener(this);
    this.b.setEnableDrag(this.n ^ true);
    this.b.setRatioModify(true);
    paramBundle = this.s;
    if (paramBundle != null) {
      this.b.setOriginRect(paramBundle);
    }
  }
  
  private void b(URLDrawable paramURLDrawable)
  {
    String str = AppConstants.SDCARD_IMG_SAVE;
    new File(str).mkdirs();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(this.k);
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
    QQToast.makeText(this, getString(2131892637), 0).show();
    return;
    DialogUtil.a(this, 230).setTitle(getString(2131915885)).setMessage(getString(2131892633)).setPositiveButton(getString(2131915687), new TroopAvatarWallEditActivity.11(this, paramURLDrawable, str)).setNegativeButton(getString(2131892140), new TroopAvatarWallEditActivity.10(this)).show();
    label177:
  }
  
  private void b(URLDrawable paramURLDrawable, String paramString)
  {
    new TroopAvatarWallEditActivity.12(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void c()
  {
    if ((this.n) && (this.o))
    {
      this.g.setVisibility(0);
      this.g.setOnClickListener(this);
      this.g.setContentDescription(getResources().getString(2131888434));
    }
    else
    {
      this.g.setVisibility(8);
    }
    if ((!this.o) && (this.n))
    {
      this.i.setVisibility(0);
      this.i.setOnClickListener(this);
    }
    this.z = ((LinearLayout)findViewById(2131435686));
    if ((this.o) && (!this.n))
    {
      this.z.setVisibility(0);
      this.y = new TroopAvatarWallEditActivity.Indicator(this.z);
      this.y.b(this.d.getCount());
      return;
    }
    this.z.setVisibility(8);
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
    Object localObject = this.c;
    if (localObject == null)
    {
      QQToast.makeText(this, getString(2131890214), 0).show();
      return;
    }
    localObject = ((Gallery)localObject).getSelectedView();
    if (localObject == null)
    {
      QQToast.makeText(this, getString(2131890214), 0).show();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131435357)).getDrawable();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getStatus() != 1)
      {
        QQToast.makeText(this, getString(2131890214), 0).show();
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
      localActionSheet.addButton(2131890804, 1);
      localActionSheet.addButton(2131890810, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManager.executeOnFileThread(new TroopAvatarWallEditActivity.6(this, (URLDrawable)localObject, localActionSheet));
      }
      localActionSheet.addCancelButton(2131887648);
      localActionSheet.setOnButtonClickListener(new TroopAvatarWallEditActivity.7(this, localActionSheet, (URLDrawable)localObject));
      localActionSheet.show();
      return;
    }
    QQToast.makeText(this, getString(2131890214), 0).show();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload isUseClassAvatar and isCover", new Object[0]));
    }
    Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    localObject1 = ((ITroopAvatarUtilApi)localObject1).getArtWork(((ITroopAvatarUtilApi)localObject1).getAvatarAddress(AvatarInfo.a, this.k, 0));
    Object localObject4 = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto((String)localObject1);
    if (localObject4 == null)
    {
      c(1);
      return;
    }
    Object localObject3 = AbsDownloader.getFile(((URL)localObject4).toString());
    boolean bool;
    if (QLog.isColorLevel())
    {
      if ((localObject3 != null) && (((File)localObject3).exists())) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onBeforeUpload %s %b", new Object[] { localObject4, Boolean.valueOf(bool) }));
    }
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject3;
      if (((File)localObject3).exists()) {}
    }
    else
    {
      localObject1 = new DownloadParams();
      ((DownloadParams)localObject1).url = ((URL)localObject4);
      ((DownloadParams)localObject1).urlStr = ((URL)localObject4).toString();
      localObject4 = new NearbyImgDownloader();
      try
      {
        localObject1 = ((NearbyImgDownloader)localObject4).loadImageFile((DownloadParams)localObject1, new TroopAvatarWallEditActivity.14(this));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localObject3;
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
      if (this.v == null)
      {
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("troopUin", this.k);
        ((Bundle)localObject3).putInt("type", 1);
        this.v = new TroopAvatarController(this, this, this.app, (Bundle)localObject3);
        this.v.a(this);
      }
      runOnUiThread(new TroopAvatarWallEditActivity.15(this, localObject2));
      return;
    }
    c(3);
  }
  
  protected void a()
  {
    TroopPhotoController localTroopPhotoController = this.u;
    if (localTroopPhotoController != null) {
      localTroopPhotoController.c();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.o)
    {
      if (this.c.getSelectedItemPosition() != paramInt) {
        this.c.setSelection(paramInt);
      }
      a(false, true);
    }
  }
  
  void a(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.m != null) {
      ReportController.b(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.m, "", "", "");
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
    ((StringBuilder)localObject).append(this.k);
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
    if (this.o) {
      a(true, true);
    }
  }
  
  public void a(AvatarInfo paramAvatarInfo, TroopUploadingThread.UploadState paramUploadState)
  {
    if (this.o)
    {
      if ((paramAvatarInfo.m == 1) && (this.q))
      {
        if (paramUploadState.a == 1)
        {
          this.q = false;
          a();
          return;
        }
        if (paramUploadState.a == 2) {
          c(5);
        }
        return;
      }
      AvatarGridAdapter localAvatarGridAdapter = this.f;
      if (localAvatarGridAdapter != null) {
        localAvatarGridAdapter.a(paramAvatarInfo, paramUploadState);
      }
    }
    else
    {
      if (this.d.a(0) == paramAvatarInfo)
      {
        this.i.setEnabled(paramAvatarInfo.g ^ true);
        this.d.a(paramAvatarInfo, paramUploadState);
      }
      if ((paramAvatarInfo.m == 1) && (paramUploadState.a == 1)) {
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
  
  public void b()
  {
    a(true, true);
  }
  
  public void b(AvatarInfo paramAvatarInfo)
  {
    if (this.o)
    {
      ITroopAvatarUtilApi localITroopAvatarUtilApi = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
      if ((paramAvatarInfo.e == 1) && (!TextUtils.isEmpty(paramAvatarInfo.d)) && (localITroopAvatarUtilApi.isNumeric(paramAvatarInfo.d))) {
        this.t.add(paramAvatarInfo.d);
      }
      paramAvatarInfo = this.u.g();
      if ((paramAvatarInfo == null) || (paramAvatarInfo.size() == 0)) {
        finish();
      }
      a(true, true);
      int i1 = this.j;
      if (i1 >= 0) {
        this.u.b(i1);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    if ((this.q) && (paramInt == 0))
    {
      ThreadManager.postImmediately(new TroopAvatarWallEditActivity.13(this), null, true);
      return true;
    }
    return false;
  }
  
  protected void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("onInsertAvatarFailed %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      TroopPhotoController localTroopPhotoController = this.u;
      if (localTroopPhotoController != null) {
        localTroopPhotoController.d(paramInt);
      }
    }
    else
    {
      runOnUiThread(new TroopAvatarWallEditActivity.16(this, paramInt));
    }
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 1, "CheckPermission user denied = ");
    PermissionParam localPermissionParam = this.w;
    if ((localPermissionParam != null) && (localPermissionParam.c != null)) {
      this.w.c.run();
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
        paramIntent = this.u;
        if (paramIntent != null) {
          paramIntent.i();
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
      setContentView(2131626666);
      Object localObject1 = getIntent().getExtras();
      findViewById(2131445141).setVisibility(0);
      this.a = findViewById(2131429234);
      this.a.setBackgroundColor(-16777216);
      this.g = ((ImageButton)findViewById(2131431689));
      this.i = ((Button)findViewById(2131429821));
      this.n = ((Bundle)localObject1).getBoolean("IS_EDIT");
      this.o = ((Bundle)localObject1).getBoolean("IS_COVER", true);
      this.q = ((Bundle)localObject1).getBoolean("isUseClassAvatar", false);
      boolean bool;
      if (((Bundle)localObject1).getInt("vistor_type", 1) != 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.p = bool;
      paramBundle = ((Bundle)localObject1).getParcelableArrayList("PHOTO_LIST");
      this.k = ((Bundle)localObject1).getString("troop_uin");
      if ((this.p) && ((paramBundle == null) || (paramBundle.size() == 0)))
      {
        finish();
        return true;
      }
      if ((!this.p) && (TextUtils.isEmpty(this.k)))
      {
        finish();
        return true;
      }
      this.j = ((Bundle)localObject1).getInt("index", -1);
      this.l = ((Bundle)localObject1).getInt("troop_auth_submit_time", 0);
      this.s = ((Rect)((Bundle)localObject1).getParcelable("KEY_THUMBNAL_BOUND"));
      Object localObject2;
      if ((this.s != null) && (LiuHaiUtils.e) && (LiuHaiUtils.b))
      {
        int i1 = LiuHaiUtils.e(this);
        localObject2 = this.s;
        ((Rect)localObject2).top -= i1;
        localObject2 = this.s;
        ((Rect)localObject2).bottom -= i1;
      }
      if (!this.n) {
        setTheme(2131953444);
      }
      this.h = ((ImageView)findViewById(2131429208));
      this.h.setVisibility(0);
      this.h.setContentDescription(HardCodeUtil.a(2131901576));
      this.h.setOnClickListener(this);
      if (ThemeUtil.isInNightMode(this.app))
      {
        localObject2 = getResources().getDrawable(2130840315);
        ((Drawable)localObject2).setColorFilter(Color.parseColor("#7e000000"), PorterDuff.Mode.SRC_ATOP);
        this.h.setImageDrawable((Drawable)localObject2);
      }
      a((Bundle)localObject1);
      b((Bundle)localObject1);
      c();
      if (!this.p)
      {
        paramBundle = new Bundle();
        paramBundle.putString("troopUin", this.k);
        paramBundle.putInt("type", 1);
        if (this.o) {
          paramBundle = new TroopPhotoController(this, this, this.app, paramBundle);
        } else {
          paramBundle = new TroopAvatarController(this, this, this.app, paramBundle);
        }
        this.u = paramBundle;
        this.u.a(this);
        this.u.e(this.l);
        this.u.a(false);
        this.u.b(this.j);
        this.u.a(this);
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
        paramBundle = this.d;
        if (paramBundle != null)
        {
          paramBundle.a((List)localObject1);
          this.c.setSelection(this.j);
          paramBundle = this.y;
          if (paramBundle != null)
          {
            paramBundle.b(this.d.getCount());
            this.y.a(this.j);
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
    Object localObject = this.d;
    if (localObject != null) {
      ((TroopAvatarWallGalleryAdapter)localObject).a();
    }
    localObject = this.u;
    if (localObject != null) {
      ((TroopPhotoController)localObject).e();
    }
    localObject = this.v;
    if (localObject != null) {
      ((TroopPhotoController)localObject).e();
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
    if (this.t.size() > 0) {
      localIntent.putStringArrayListExtra("key_del_pics", new ArrayList(this.t));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troop_avatar_wall.TroopAvatarWallEditActivity", 2, String.format("finish delPics=%s", new Object[] { Arrays.toString(this.t.toArray()) }));
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
        localObject = this.w;
        if ((localObject != null) && (((PermissionParam)localObject).b != null)) {
          this.w.b.run();
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
    case 2131431689: 
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131892157), 0).show(getResources().getDimensionPixelOffset(2131299920));
      }
      else
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
        localActionSheet.addButton(2131890801, 3);
        localActionSheet.addCancelButton(2131887648);
        localActionSheet.setOnButtonClickListener(new TroopAvatarWallEditActivity.5(this, localActionSheet));
        localActionSheet.show();
      }
      break;
    case 2131429821: 
      this.u.b();
      break;
    case 2131429208: 
      finish();
      break;
    case 2131427966: 
      if ((this.o) && (!this.n)) {
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
    this.a.setAlpha(paramFloat);
    this.h.setVisibility(8);
    if (this.o) {
      this.z.setVisibility(8);
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
    if (this.u == null) {
      return;
    }
    paramAdapterView = this.f.a(paramInt);
    if (paramAdapterView != null)
    {
      if (4 != paramAdapterView.e)
      {
        this.u.b(paramInt);
        return;
      }
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131892157), 0).show(getResources().getDimensionPixelOffset(2131299920));
        return;
      }
      this.u.b();
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
      if ((this.o) && (!this.n)) {
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
    if (this.n) {
      return;
    }
    this.a.setAlpha(1.0F);
    this.h.setVisibility(0);
    if (this.o) {
      this.z.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity
 * JD-Core Version:    0.7.0.1
 */