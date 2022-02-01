package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IJumpUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter.ActionSheetForwardActionInfo;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.BrowserUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.pic.PictureView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AIOPictureView
  extends AIOBrowserBaseView
  implements View.OnClickListener, ActionSheet.WatchDismissActions
{
  public TextView A;
  public ImageButton B;
  public LinearLayout C;
  public TextView D;
  public long E = 0L;
  public IProvider F;
  MessageQueue.IdleHandler G = new AIOPictureView.9(this);
  private AIOPicturePresenter H;
  private URLDrawable I;
  private int J = -1;
  private Intent K;
  public PictureView k;
  public boolean l = false;
  public int m = 1;
  public boolean n;
  public boolean o = false;
  public String p;
  public String q;
  public AIOPictureView.OnTroopThumbListener r;
  public ArrayList<String> s = new ArrayList();
  public RelativeLayout t;
  public TextView u;
  public ImageView v;
  public SeekBar w;
  public TextView x;
  public ImageView y;
  public Runnable z;
  
  public AIOPictureView(Context paramContext, AIOPicturePresenter paramAIOPicturePresenter)
  {
    super(paramContext, paramAIOPicturePresenter);
    this.H = paramAIOPicturePresenter;
  }
  
  private URLDrawable a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, File paramFile, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.i;
    localURLDrawableOptions.mRequestHeight = this.j;
    Object localObject = paramAIOPictureModel.c(paramAIOPictureData, 1);
    URLDrawable localURLDrawable = null;
    if (localObject != null)
    {
      localObject = URLDrawable.getFileDrawable(paramAIOPictureData.j, null);
      ((URLDrawable)localObject).downloadImediatly();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    }
    else
    {
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "TYPE_ORIGINAL_IMAGE");
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mDecodeFileStrategy = 2;
    localObject = paramAIOPictureModel.b(paramAIOPictureData, 4);
    paramAIOPictureModel = localURLDrawable;
    try
    {
      localURLDrawable = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
      paramAIOPictureModel = localURLDrawable;
      localURLDrawable.setTag(Integer.valueOf(1));
      paramAIOPictureModel = localURLDrawable;
    }
    catch (Throwable localThrowable)
    {
      label144:
      break label144;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
    paramFile = paramFile.getAbsolutePath();
    this.k.imageView.setGalleryImageListener(new AIOPictureView.10(this, paramRichMediaBrowserInfo, paramFile, paramAIOPictureModel, paramAIOPictureData));
    this.z = RichMediaBrowserUtils.a(this.y, paramAIOPictureModel);
    if ((this.z == null) && (paramAIOPictureModel.getStatus() == 1)) {
      a(paramRichMediaBrowserInfo, paramFile, paramAIOPictureModel, paramInt);
    } else {
      this.k.imageView.initDrawable(paramAIOPictureModel, this.i, this.j, BrowserUtils.a(paramAIOPictureModel.getExifOrientation()));
    }
    this.k.imageView.setImageDrawable(paramAIOPictureModel);
    return paramAIOPictureModel;
  }
  
  private URLDrawable a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, File paramFile1, File paramFile2, int paramInt)
  {
    int j = 0;
    int i;
    if (paramFile1 != null) {
      i = 1;
    } else {
      i = 0;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.i;
    localURLDrawableOptions.mRequestHeight = this.j;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mDecodeFileStrategy = 2;
    paramFile1 = null;
    if (i != 0)
    {
      paramRichMediaBrowserInfo = paramAIOPictureModel.b(paramAIOPictureData, 4);
    }
    else
    {
      paramAIOPictureModel = paramAIOPictureModel.b(paramAIOPictureData, 2);
      paramRichMediaBrowserInfo = paramAIOPictureModel;
      if (paramAIOPictureData.q)
      {
        paramRichMediaBrowserInfo = new StringBuilder();
        paramRichMediaBrowserInfo.append(paramAIOPictureModel);
        paramRichMediaBrowserInfo.append("#PART");
        paramRichMediaBrowserInfo = paramRichMediaBrowserInfo.toString();
      }
    }
    paramAIOPictureModel = paramFile1;
    try
    {
      paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramRichMediaBrowserInfo, localURLDrawableOptions);
      paramAIOPictureModel = paramRichMediaBrowserInfo;
      paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
      paramAIOPictureModel = paramRichMediaBrowserInfo;
      paramRichMediaBrowserInfo.downloadImediatly();
      paramAIOPictureModel = paramRichMediaBrowserInfo;
    }
    catch (Throwable paramRichMediaBrowserInfo)
    {
      label157:
      break label157;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
    if ((paramAIOPictureModel != null) && (paramAIOPictureModel.getStatus() == 1))
    {
      try
      {
        i = JpegExifReader.readOrientation(paramFile2.getAbsolutePath());
      }
      catch (Exception paramRichMediaBrowserInfo)
      {
        paramAIOPictureData = BrowserLogHelper.getInstance().getGalleryLog();
        paramFile1 = new StringBuilder();
        paramFile1.append("read exif error");
        paramFile1.append(paramRichMediaBrowserInfo.getMessage());
        paramAIOPictureData.d("AIOPictureView", 4, paramFile1.toString());
        i = j;
      }
      this.H.c.mActiveDrawable.put(Integer.valueOf(paramInt), paramAIOPictureModel);
      this.k.imageView.setImageDrawable(paramAIOPictureModel);
      this.k.imageView.initDrawable(paramAIOPictureModel, this.i, this.j, BrowserUtils.a(i));
      this.H.c.onLoadFinish(paramInt, true);
      return paramAIOPictureModel;
    }
    if ((!a(paramAIOPictureData, this.k.imageView)) && (!a(paramAIOPictureData, this.k.imageView)) && (!b(paramAIOPictureData, this.k.imageView))) {
      a(this.k.imageView);
    }
    a(paramAIOPictureData.a, paramAIOPictureData.b, 2);
    return paramAIOPictureModel;
  }
  
  private void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject = this.F;
    if (localObject != null) {
      ((IProvider)localObject).a("Pic_Forward_Contacts", 0);
    }
    localObject = new AIOPicturePresenter.ActionSheetForwardActionInfo();
    ((AIOPicturePresenter.ActionSheetForwardActionInfo)localObject).a = paramInt;
    if (paramInt == 72)
    {
      ((AIOPicturePresenter.ActionSheetForwardActionInfo)localObject).b = paramActionSheetItem.uin;
      ((AIOPicturePresenter.ActionSheetForwardActionInfo)localObject).c = paramActionSheetItem.uinType;
    }
    if ((this.c instanceof Activity))
    {
      AIOPicturePresenter localAIOPicturePresenter = this.H;
      Activity localActivity = (Activity)this.c;
      paramInt = ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType();
      if (this.n) {
        paramActionSheetItem = "biz_src_jc_groupgif";
      } else {
        paramActionSheetItem = "biz_src_jc_photo";
      }
      localAIOPicturePresenter.a(paramRichMediaBrowserInfo, localActivity, (AIOPicturePresenter.ActionSheetForwardActionInfo)localObject, paramInt, paramActionSheetItem);
      if (this.n) {
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
      }
    }
    if ((ParamsManager.a().g()) && (this.H.a != null))
    {
      paramActionSheetItem = this.H.a;
      AIOBrowserPresenter.a("0X8009ABA");
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    IProvider localIProvider = this.F;
    if (localIProvider != null) {
      localIProvider.a(paramLong, paramInt1, paramInt2);
    }
    this.H.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2)
  {
    if ((((this.c instanceof Activity)) && (((Activity)this.c).isFinishing())) || (this.k == null)) {
      return;
    }
    if ((this.c instanceof Activity)) {
      this.p = ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).checkQQCode(paramUri, paramArrayList1, paramArrayList2, (Activity)this.c, this.q, this.b);
    }
  }
  
  private void a(AIOPictureData paramAIOPictureData)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet add to favorite.");
    if ((this.c instanceof Activity)) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealAddToEmotion(paramAIOPictureData, (Activity)this.c);
    }
    if (this.n) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject3 = new AIOPictureModel();
    Object localObject2 = ((AIOPictureModel)localObject3).c(paramAIOPictureData, 4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ((AIOPictureModel)localObject3).c(paramAIOPictureData, 2);
    }
    if ((localObject1 == null) && (ParamsManager.a().c())) {
      return;
    }
    if (localObject1 != null) {
      this.q = ((File)localObject1).getPath();
    }
    localObject2 = ActionSheet.createMenuSheet(this.c);
    if (UinTypeUtil.e(ParamsManager.a().i()) != 1032)
    {
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      if (localObject1 != null) {
        a((ArrayList)localObject2, paramAIOPictureData, (File)localObject1, (ArrayList)localObject3, (File)localObject1);
      } else if ((!ParamsManager.a().g()) && (ParamsManager.a().r()) && (!TextUtils.isEmpty(ParamsManager.a().j())) && (UinTypeUtil.e(ParamsManager.a().i()) != 1044)) {
        RichMediaBrowserUtils.a(54, (ArrayList)localObject3);
      }
      if ((paramAIOPictureData.B == 4) && (!this.n) && (!paramAIOPictureData.C)) {
        RichMediaBrowserUtils.a(66, (ArrayList)localObject3);
      }
      a(paramAIOPictureData, paramRichMediaBrowserInfo, (File)localObject1);
      localObject1 = this.K;
      if (localObject1 != null)
      {
        if (this.n) {
          paramAIOPictureData = "biz_src_jc_groupgif";
        } else {
          paramAIOPictureData = "biz_src_jc_photo";
        }
        ((Intent)localObject1).putExtra("big_brother_source_key", paramAIOPictureData);
      }
      if ((UinTypeUtil.e(ParamsManager.a().i()) != 1044) && ((this.c instanceof Activity)))
      {
        paramAIOPictureData = this.H;
        if (paramAIOPictureData == null) {
          paramAIOPictureData = null;
        } else {
          paramAIOPictureData = paramAIOPictureData.a(paramRichMediaBrowserInfo, (Activity)this.c);
        }
        if (paramAIOPictureData != null)
        {
          paramAIOPictureData.putExtra("key_new_img_shareactionsheet", 1);
          paramAIOPictureData.putExtra(((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getShowDataLine(), true);
          this.b.setIntentForStartForwardRecentActivity(paramAIOPictureData);
        }
        else
        {
          this.b.setIntentForStartForwardRecentActivity(null);
          QLog.e("AIOPictureView", 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
        }
      }
      this.b.setActionSheetItems((List)localObject2, (List)localObject3);
      this.b.show();
      return;
    }
    a((ActionSheet)localObject2, (File)localObject1);
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData)
  {
    if ((paramRichMediaBrowserInfo != null) && ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.getType() == 100) && (localAIOPictureData.a == paramAIOPictureData.a) && (localAIOPictureData.b == paramAIOPictureData.b) && (!paramRichMediaBrowserInfo.isReport))
      {
        ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 1, 0, "", "", "", "");
        paramRichMediaBrowserInfo.isReport = true;
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, URLDrawable paramURLDrawable)
  {
    this.k.imageView.setImageDrawable(paramURLDrawable);
    paramRichMediaBrowserInfo = paramAIOPictureModel.b(paramAIOPictureData, 4);
    String str = paramURLDrawable.getURL().toString();
    if (str.equals(paramRichMediaBrowserInfo)) {
      this.k.imageView.setOriginalImage(true);
    }
    int i = 0;
    try
    {
      int j = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      i = j;
    }
    catch (Exception paramRichMediaBrowserInfo)
    {
      localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("read exif error");
      localStringBuilder.append(paramRichMediaBrowserInfo.getMessage());
      localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
    }
    this.k.imageView.initDrawable(paramURLDrawable, this.i, this.j, BrowserUtils.a(i));
    if (this.k.imageView.isOriginalImage()) {
      paramRichMediaBrowserInfo = paramAIOPictureData.l;
    } else {
      paramRichMediaBrowserInfo = paramAIOPictureData.k;
    }
    paramRichMediaBrowserInfo = FileUtils.estimateFileType(paramRichMediaBrowserInfo);
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getView(): cache url is ");
    localStringBuilder.append(str);
    localStringBuilder.append(", cache type is ");
    localStringBuilder.append(paramAIOPictureModel.a(paramAIOPictureData, paramURLDrawable.getURL().getFile()));
    localStringBuilder.append(",extName = + ");
    localStringBuilder.append(paramRichMediaBrowserInfo);
    localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
    if (paramAIOPictureData.q)
    {
      paramRichMediaBrowserInfo = this.F;
      if (paramRichMediaBrowserInfo != null) {
        paramRichMediaBrowserInfo.a(paramAIOPictureData.a, paramAIOPictureData.b, 2);
      }
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    try
    {
      paramRichMediaBrowserInfo = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      if ((this.F != null) && ((this.c instanceof Activity)))
      {
        paramRichMediaBrowserInfo = this.F.a(paramRichMediaBrowserInfo.a, paramRichMediaBrowserInfo.b);
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealAddFavorite((Activity)this.c, paramRichMediaBrowserInfo, paramFile.getAbsolutePath(), ParamsManager.a().k());
        return;
      }
    }
    catch (RemoteException paramRichMediaBrowserInfo)
    {
      paramFile = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTION_GALLERY_PIC_FAVORITE exception = ");
      localStringBuilder.append(paramRichMediaBrowserInfo.getMessage());
      paramFile.d("AIOPictureView", 4, localStringBuilder.toString());
      QQToast.makeText(this.c.getApplicationContext(), this.c.getString(2131915737), 0).show();
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    int i;
    try
    {
      i = JpegExifReader.readOrientation(paramString);
    }
    catch (Exception paramRichMediaBrowserInfo)
    {
      paramString = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read exif error");
      localStringBuilder.append(paramRichMediaBrowserInfo.getMessage());
      paramString.d("AIOPictureView", 4, localStringBuilder.toString());
      i = 0;
    }
    paramURLDrawable.setTag(Integer.valueOf(1));
    paramRichMediaBrowserInfo = this.H;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.c != null))
    {
      if (this.H.c.mActiveDrawable != null) {
        this.H.c.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      }
      this.k.imageView.initDrawable(paramURLDrawable, this.i, this.j, BrowserUtils.a(i));
      this.H.c.onLoadFinish(paramInt, true);
    }
  }
  
  private void a(ActionSheet paramActionSheet, File paramFile)
  {
    if ((UinTypeUtil.e(ParamsManager.a().i()) == 1032) && (paramFile != null)) {
      paramActionSheet.addButton(2131915736);
    }
    paramActionSheet.addCancelButton(2131915728);
    paramActionSheet.setOnButtonClickListener(new AIOPictureView.4(this, paramActionSheet));
    paramActionSheet.show();
    paramActionSheet.registerWatchDisMissActionListener(this);
  }
  
  private void a(File paramFile)
  {
    if ((this.c instanceof Activity)) {
      ((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).showSupportedAppList((Activity)this.c, paramFile.getAbsolutePath(), "image/*");
    }
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, AIOPictureData paramAIOPictureData, File paramFile1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if (UinTypeUtil.e(ParamsManager.a().i()) != 1044) {
      RichMediaBrowserUtils.a(2, paramArrayList1);
    }
    if (UinTypeUtil.e(ParamsManager.a().i()) != 1044)
    {
      if ((paramAIOPictureData.r != null) && (paramAIOPictureData.f != 10014)) {
        RichMediaBrowserUtils.a(50, paramArrayList1);
      }
      if ((this.l) && (paramAIOPictureData.r != null)) {
        RichMediaBrowserUtils.a(51, paramArrayList1);
      }
    }
    RichMediaBrowserUtils.a(27, paramArrayList1);
    if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isPicShareToWXEnable()) && (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isFileSizeEnable(paramFile1))) {
      RichMediaBrowserUtils.a(9, paramArrayList1);
    }
    if (this.n)
    {
      RichMediaBrowserUtils.a(48, paramArrayList2);
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if (!((IBrowserDepend)QRoute.api(IBrowserDepend.class)).saveImageNeedBlock()) {
      RichMediaBrowserUtils.a(39, paramArrayList2);
    }
    if (!this.n) {
      RichMediaBrowserUtils.a(6, paramArrayList2);
    }
    if (UinTypeUtil.e(ParamsManager.a().i()) != 1044)
    {
      if ((ParamsManager.a().r()) && (!TextUtils.isEmpty(ParamsManager.a().j())) && (!ParamsManager.a().g())) {
        RichMediaBrowserUtils.a(54, paramArrayList2);
      }
      if (this.o) {
        RichMediaBrowserUtils.a(52, paramArrayList2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOPictureView.3(this, paramFile2, paramArrayList1, paramArrayList2));
    }
  }
  
  private boolean a(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealThumbImage()");
    Object localObject2 = new AIOPictureModel();
    if (((AIOPictureModel)localObject2).c(paramAIOPictureData, 1) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
      localObject2 = ((AIOPictureModel)localObject2).c(paramAIOPictureData, 1);
      paramAIOPictureData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOPictureData = (AIOPictureData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOPictureData = (AIOPictureData)localObject1;
      }
      catch (Exception localException)
      {
        localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealTempImage() exception = ");
        localStringBuilder.append(localException.getMessage());
        ((IBrowserLog)localObject2).d("AIOPictureView", 4, localStringBuilder.toString());
      }
      if ((paramAIOPictureData != null) && (paramAIOPictureData.getStatus() == 1))
      {
        paramAIOPictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
        this.k.imageView.initDrawable(paramAIOPictureData, this.i, this.j, 0);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(AIOPictureData paramAIOPictureData, BrowserScaleView paramBrowserScaleView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage()");
    AIOPictureModel localAIOPictureModel = new AIOPictureModel();
    if (localAIOPictureModel.c(paramAIOPictureData, 8) != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
      Object localObject1 = null;
      try
      {
        localObject2 = URLDrawable.getDrawable(localAIOPictureModel.b(paramAIOPictureData, 8), (URLDrawable.URLDrawableOptions)localObject2);
        localObject1 = localObject2;
        ((URLDrawable)localObject2).downloadImediatly();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealTempImage() exception = ");
        localStringBuilder.append(localException.getMessage());
        localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
      }
      if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
      {
        ((URLDrawable)localObject1).setTag(Integer.valueOf(1));
        paramBrowserScaleView.setImageDrawable((Drawable)localObject1);
        paramBrowserScaleView.initDrawable((Drawable)localObject1, this.i, this.j, 0);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set temp image");
        return true;
      }
      paramBrowserScaleView = BrowserLogHelper.getInstance().getGalleryLog();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView(): url is ");
      ((StringBuilder)localObject1).append(localAIOPictureModel.b(paramAIOPictureData, 8));
      ((StringBuilder)localObject1).append(", file type is ");
      ((StringBuilder)localObject1).append(8);
      paramBrowserScaleView.d("AIOPictureView", 4, ((StringBuilder)localObject1).toString());
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(URLDrawableHelperConstants.a);
    return true;
  }
  
  private void b(AIOPictureData paramAIOPictureData)
  {
    if ((this.c instanceof Activity)) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealPicForwardToGroupAlbum(paramAIOPictureData, this.c, this.F);
    }
  }
  
  private void b(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    if ((!PermissionUtil.a(this.c)) && ((this.c instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.c, null);
      return;
    }
    Object localObject = this.F;
    if (localObject != null) {
      ((IProvider)localObject).a("Pic_save", 0);
    }
    localObject = new AIOPictureModel();
    if ((((AIOPictureModel)localObject).c(paramAIOPictureData, 4) == null) && (((AIOPictureModel)localObject).a(paramAIOPictureData, 4)) && (AppNetConnInfo.isNetSupport()))
    {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOPictureData.d > 29360128L))
      {
        a(100, paramAIOPictureData, paramRichMediaBrowserInfo);
      }
      else
      {
        this.H.a(paramAIOPictureData);
        this.H.a(paramAIOPictureData.a, paramAIOPictureData.b, 4);
        a();
        h();
        this.H.g().b();
      }
    }
    else if ((this.c instanceof Activity))
    {
      paramAIOPictureData = (IBrowserDepend)QRoute.api(IBrowserDepend.class);
      paramRichMediaBrowserInfo = (Activity)this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTime());
      paramAIOPictureData.savePic(paramRichMediaBrowserInfo, paramFile, Utils.Crc64String(((StringBuilder)localObject).toString()));
    }
    if (this.n) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
    }
    if ((ParamsManager.a().g()) && (this.H.a != null))
    {
      paramAIOPictureData = this.H.a;
      AIOBrowserPresenter.a("0X8009ABB");
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "ACTION_GALLERY_PIC_SAVE");
  }
  
  private void b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    IProvider localIProvider = this.F;
    if (localIProvider != null) {
      localIProvider.a("Pic_Forward_Qzone", 0);
    }
    if ((paramRichMediaBrowserInfo != null) && ((this.c instanceof Activity))) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).fowardToQzoneAlbum((Activity)this.c, ParamsManager.a().k(), ParamsManager.a().f(), this.m, paramRichMediaBrowserInfo.baseData, this.l, ParamsManager.a().e());
    }
    if (this.n) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "4", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private boolean b(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
    if ((!paramAIOPictureData.p) && (!paramAIOPictureData.o) && (!paramAIOPictureData.n)) {
      return false;
    }
    paramAIOPictureData = BaseApplication.getContext().getResources().getDrawable(2130851629);
    paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
    this.k.imageView.initDrawable(paramAIOPictureData, this.i, this.j, 0);
    this.H.c.onLoadFinish(this.H.c.getSelectedIndex(), false);
    return true;
  }
  
  private void c(AIOPictureData paramAIOPictureData)
  {
    if (this.n)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet share weiyun.");
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealSendToWeiYun(paramAIOPictureData);
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    if (paramAIOPictureData.a > 0L)
    {
      IProvider localIProvider = this.F;
      if ((localIProvider != null) && (localIProvider.c()))
      {
        this.F.a(paramAIOPictureData.a);
        QQToast.makeText(this.c, this.c.getString(2131915726), 0).show();
      }
    }
  }
  
  private void d(AIOPictureData paramAIOPictureData)
  {
    String str2 = ParamsManager.a().e();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ParamsManager.a().j();
    }
    ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", ParamsManager.a().o(), 0, "", "", "", "");
    if ((this.c instanceof Activity)) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.c, ParamsManager.a().i(), ParamsManager.a().j(), str1, paramAIOPictureData.c, paramAIOPictureData.e, paramAIOPictureData.f, false);
    }
  }
  
  private void e(AIOPictureData paramAIOPictureData)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (this.F != null))
    {
      if (paramAIOPictureData.E)
      {
        this.F.a(ParamsManager.a().i(), true, paramAIOPictureData.F, paramAIOPictureData.D, localAppRuntime.getAccount(), paramAIOPictureData.G);
        return;
      }
      this.F.a(ParamsManager.a().i(), false, paramAIOPictureData.z, paramAIOPictureData.D, localAppRuntime.getAccount(), paramAIOPictureData.G);
    }
  }
  
  private void f(AIOPictureData paramAIOPictureData)
  {
    if ((!a(paramAIOPictureData, this.k.imageView)) && (!a(paramAIOPictureData, this.k.imageView)) && (!b(paramAIOPictureData, this.k.imageView))) {
      a(this.k.imageView);
    }
    a(paramAIOPictureData.a, paramAIOPictureData.b, 2);
  }
  
  private void g(AIOPictureData paramAIOPictureData)
  {
    if ((!a(paramAIOPictureData, this.k.imageView)) && (!b(paramAIOPictureData, this.k.imageView))) {
      a(this.k.imageView);
    }
    a(paramAIOPictureData.a, paramAIOPictureData.b, 2);
  }
  
  private void h(AIOPictureData paramAIOPictureData)
  {
    if (!b(paramAIOPictureData, this.k.imageView)) {
      a(this.k.imageView);
    }
  }
  
  private void r()
  {
    AIOPictureData localAIOPictureData = o();
    if ((localAIOPictureData != null) && (new AIOPictureModel().a(localAIOPictureData, 4)))
    {
      if (localAIOPictureData.d > 0L)
      {
        a(String.format(Locale.CHINA, this.c.getString(2131915747), new Object[] { FileSizeFormat.a(localAIOPictureData.d) }));
        return;
      }
      a(this.c.getString(2131915744));
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPictureView", 2, "onClick qq_gallery_danmaku_view ");
    }
    AIOPictureData localAIOPictureData = o();
    if ((localAIOPictureData != null) && ((this.c instanceof Activity))) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.c, ParamsManager.a().i(), ParamsManager.a().e(), false, localAIOPictureData.e, 0L);
    }
    this.H.q();
  }
  
  private void t()
  {
    AIOPictureData localAIOPictureData = o();
    if (localAIOPictureData != null)
    {
      int i = localAIOPictureData.status;
      IProvider localIProvider;
      if (i != 1)
      {
        if (i != 3)
        {
          if (i == 4)
          {
            localIProvider = this.F;
            if (localIProvider != null) {
              localIProvider.b(localAIOPictureData.a, localAIOPictureData.b, 24);
            }
          }
        }
        else
        {
          localIProvider = this.F;
          if (localIProvider != null) {
            localIProvider.b(localAIOPictureData.a, localAIOPictureData.b, 4);
          }
        }
      }
      else
      {
        localIProvider = this.F;
        if (localIProvider != null) {
          localIProvider.b(localAIOPictureData.a, localAIOPictureData.b, 2);
        }
      }
      this.H.a(localAIOPictureData.a, localAIOPictureData.b, 0);
      a();
    }
  }
  
  private void u()
  {
    AIOPictureData localAIOPictureData = o();
    if ((localAIOPictureData != null) && (!TextUtils.isEmpty(localAIOPictureData.H)) && ((this.c instanceof Activity)))
    {
      ((IJumpUtil)QRoute.api(IJumpUtil.class)).jumpToCameraActivityForAio((Activity)this.c, localAIOPictureData.H);
      ReportController.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", localAIOPictureData.H, "");
    }
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.g = ((RelativeLayout)LayoutInflater.from(this.c).inflate(2131629205, null));
    p();
    if (this.k.controlViewContainer != null) {
      this.k.controlViewContainer.addView(this.g);
    }
    return this.k.mBrowserItemView;
  }
  
  public void a()
  {
    AIOPictureData localAIOPictureData = o();
    if (localAIOPictureData != null)
    {
      int i = localAIOPictureData.status;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              localObject = this.k;
              if (localObject != null) {
                ((PictureView)localObject).updateUI();
              }
              localObject = BrowserLogHelper.getInstance().getGalleryLog();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("updateUI status is error, status = ");
              localStringBuilder.append(localAIOPictureData.status);
              ((IBrowserLog)localObject).d("AIOPictureView", 4, localStringBuilder.toString());
              return;
            }
            this.H.c.onLoadFinish(this.H.c.getSelectedIndex(), true);
            g(false);
            c(false);
            d(false);
            h(false);
            this.w.setProgress(localAIOPictureData.progress / 100);
            localObject = this.u;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.c.getString(2131915754));
            localStringBuilder.append(localAIOPictureData.progress / 100);
            localStringBuilder.append("%");
            ((TextView)localObject).setText(localStringBuilder.toString());
            this.t.setVisibility(0);
            return;
          }
          this.H.c.onLoadFinish(this.H.c.getSelectedIndex(), true);
          g(false);
          c(false);
          d(false);
          h(false);
          this.w.setProgress(localAIOPictureData.progress / 100);
          localObject = this.u;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c.getString(2131915730));
          localStringBuilder.append(localAIOPictureData.progress / 100);
          localStringBuilder.append("%");
          ((TextView)localObject).setText(localStringBuilder.toString());
          this.t.setVisibility(0);
          return;
        }
        g(false);
        c(false);
        h(false);
        this.H.c.onLoadStart(this.H.c.getSelectedIndex(), localAIOPictureData.progress);
        return;
      }
      this.H.c.onLoadFinish(this.H.c.getSelectedIndex(), true);
      this.t.setVisibility(8);
      c(g());
      d(a(this.H.c.getSelectedItem()));
      h(l());
      j(true);
      Object localObject = new AIOPictureModel();
      if ((((AIOPictureModel)localObject).c(localAIOPictureData, 2) == null) && (((AIOPictureModel)localObject).c(localAIOPictureData, 4) == null)) {
        i(false);
      } else {
        i(true);
      }
      if ((((AIOPictureModel)localObject).a(localAIOPictureData, 4)) && (((AIOPictureModel)localObject).c(localAIOPictureData, 4) == null))
      {
        g(true);
        return;
      }
      g(false);
    }
  }
  
  public void a(int paramInt)
  {
    this.y.setVisibility(8);
    Object localObject2 = this.H.c.getItem(paramInt);
    if (localObject2 != null)
    {
      if ((((RichMediaBrowserInfo)localObject2).baseData == null) && (this.k.imageView == null)) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 100)
      {
        localObject1 = (AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData;
        Object localObject3 = new AIOPictureModel();
        a(this.H.p(), (AIOPictureData)localObject1);
        this.k.imageView.setOnItemEventListener(this);
        this.k.imageView.setPosition(paramInt);
        this.k.imageView.setImageInfo((RichMediaBrowserInfo)localObject2);
        this.k.imageView.setIgnoreLayout(false);
        this.k.imageView.setContentDescription(this.c.getString(2131915743));
        Object localObject4 = (URLDrawable)this.H.c.mActiveDrawable.get(Integer.valueOf(paramInt));
        if ((localObject4 != null) && (((URLDrawable)localObject4).getStatus() == 1))
        {
          a((RichMediaBrowserInfo)localObject2, (AIOPictureData)localObject1, (AIOPictureModel)localObject3, (URLDrawable)localObject4);
        }
        else
        {
          localObject4 = ((AIOPictureModel)localObject3).c((AIOPictureData)localObject1, 4);
          if (localObject4 != null)
          {
            a((RichMediaBrowserInfo)localObject2, (AIOPictureData)localObject1, (AIOPictureModel)localObject3, (File)localObject4, paramInt);
          }
          else
          {
            File localFile = ((AIOPictureModel)localObject3).c((AIOPictureData)localObject1, 2);
            if (localFile != null)
            {
              a((RichMediaBrowserInfo)localObject2, (AIOPictureData)localObject1, (AIOPictureModel)localObject3, (File)localObject4, localFile, paramInt);
            }
            else if (((AIOPictureModel)localObject3).c((AIOPictureData)localObject1, 8) != null)
            {
              f((AIOPictureData)localObject1);
            }
            else if (((AIOPictureModel)localObject3).c((AIOPictureData)localObject1, 1) != null)
            {
              g((AIOPictureData)localObject1);
            }
            else if ((!((AIOPictureData)localObject1).p) && (!((AIOPictureData)localObject1).o) && (!((AIOPictureData)localObject1).n))
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): No pic");
              a(this.k.imageView);
              a(((AIOPictureData)localObject1).a, ((AIOPictureData)localObject1).b, 2);
            }
            else
            {
              h((AIOPictureData)localObject1);
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((AIOPictureData)localObject1).a);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(((AIOPictureData)localObject1).b);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (!this.s.contains(localObject2))
        {
          localObject3 = this.F;
          if (localObject3 != null)
          {
            ((IProvider)localObject3).c(((AIOPictureData)localObject1).a, ((AIOPictureData)localObject1).b);
            this.s.add(localObject2);
          }
        }
      }
      this.k.imageView.setMainBrowserPresenter(this.H.a);
      Object localObject1 = new AIOPictureView.GalleryPictureViewHolder(this);
      ((AIOPictureView.GalleryPictureViewHolder)localObject1).a = this.k.imageView;
      this.k.mBrowserItemView.setTag(localObject1);
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = this.H;
    if ((paramView != null) && (paramView.c != null) && (this.H.c.mActiveDrawable != null))
    {
      paramView = (URLDrawable)this.H.c.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (paramView != null)
      {
        if (paramView.getStatus() == 0) {
          paramView.cancelDownload(true);
        }
        this.H.c.mActiveDrawable.remove(Integer.valueOf(paramInt));
      }
    }
    if (paramInt == this.J)
    {
      paramView = this.I;
      if ((paramView != null) && (paramView.getStatus() == 0)) {
        this.I.cancelDownload(true);
      }
      this.I = null;
      this.J = -1;
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(DialogUtil.a(this.c, 230, this.c.getString(2131915752), this.c.getString(2131915751), new AIOPictureView.7(this, paramInt, paramObject), new AIOPictureView.8(this)));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.H.c != null)
    {
      Object localObject1 = this.H.c.getItem(paramInt);
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && (this.k.mBrowserItemView != null) && ((this.k.mBrowserItemView.getTag() instanceof AIOPictureView.GalleryPictureViewHolder)))
      {
        Object localObject3 = ((AIOPictureView.GalleryPictureViewHolder)this.k.mBrowserItemView.getTag()).a;
        AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
        localObject1 = new AIOPictureModel();
        Object localObject2;
        if (localAIOPictureData.o)
        {
          localObject2 = ((BrowserScaleView)localObject3).getDrawable();
          paramBoolean = URLDrawable.class.isInstance(localObject2);
          localObject1 = null;
          if (paramBoolean)
          {
            localObject1 = (URLDrawable)localObject2;
            localObject2 = ((URLDrawable)localObject1).getURL().getRef();
          }
          else
          {
            localObject2 = null;
          }
          if ((localObject1 == null) || (localObject2 == null) || ((!"PART".equals(localObject2)) && (!"DISPLAY".equals(localObject2))))
          {
            localObject1 = BaseApplication.getContext().getResources().getDrawable(2130851629);
            ((BrowserScaleView)localObject3).setImageDrawable((Drawable)localObject1);
            ((BrowserScaleView)localObject3).initDrawable((Drawable)localObject1, this.i, this.j, 0);
            this.H.c.onLoadFinish(paramInt, false);
          }
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
          return;
        }
        if (((AIOPictureModel)localObject1).c(localAIOPictureData, 2) != null)
        {
          localObject2 = ((AIOPictureModel)localObject1).b(localAIOPictureData, 2);
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("#PART");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          a(paramInt);
          localObject2 = FileUtils.estimateFileType(localAIOPictureData.k);
          localObject3 = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AIOGalleryAdapter.updateView(): Update large image, position=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("url = ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(",extName = ");
          localStringBuilder.append((String)localObject2);
          ((IBrowserLog)localObject3).d("AIOPictureView", 4, localStringBuilder.toString());
          localAIOPictureData.q = paramBoolean;
          return;
        }
        if (((AIOPictureModel)localObject1).c(localAIOPictureData, 1) != null)
        {
          localObject1 = URLDrawable.getDrawable(((AIOPictureModel)localObject1).b(localAIOPictureData, 1), URLDrawable.URLDrawableOptions.obtain());
          ((BrowserScaleView)localObject3).setImageDrawable((Drawable)localObject1);
          ((BrowserScaleView)localObject3).initDrawable((Drawable)localObject1, this.i, this.j, 0);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOPictureData localAIOPictureData = o();
    if (localAIOPictureData != null)
    {
      Object localObject = this.F;
      if (localObject != null)
      {
        int i = ((IProvider)localObject).b(localAIOPictureData.a, localAIOPictureData.b);
        boolean bool;
        if ((i >= 0) && (i < 100)) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRevokeMsg isSaving:");
        localStringBuilder.append(bool);
        ((IBrowserLog)localObject).d("AIOPictureView", 4, localStringBuilder.toString());
        if (bool) {
          this.F.b(localAIOPictureData.a, localAIOPictureData.b, 24);
        }
      }
    }
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && ((this.c instanceof Activity)) && (!((Activity)this.c).isFinishing())) {
      try
      {
        paramDialog.show();
        return;
      }
      catch (Throwable paramDialog)
      {
        IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showDialogSafe exception: ");
        localStringBuilder.append(paramDialog.getMessage());
        localIBrowserLog.d("AIOPictureView", 4, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.K = paramIntent;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      this.l = paramIntent.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
      this.m = paramIntent.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
      this.n = paramIntent.getBoolean("group.emo.big.preview", false);
      this.o = paramIntent.getBoolean("extra.OCR", false);
    }
    if ((this.H.a != null) && ((this.H.a.getParamsBuilder().a() instanceof IProvider))) {
      this.F = ((IProvider)this.H.a.getParamsBuilder().a());
    }
    a(new AIOPictureView.1(this));
  }
  
  public void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    this.b.setItemClickListenerV2(new AIOPictureView.5(this, paramAIOPictureData, paramRichMediaBrowserInfo, paramFile));
    this.b.setCancelListener(new AIOPictureView.6(this));
  }
  
  public void a(AIOPictureView.OnTroopThumbListener paramOnTroopThumbListener)
  {
    this.r = paramOnTroopThumbListener;
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.a(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof PictureView)) {
      this.k = ((PictureView)paramIBaseViewBuilder);
    }
    this.h.setPictureScaleEventListener(this);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.A;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    a(paramInt);
    if (this.k.imageView != null)
    {
      Drawable localDrawable = this.k.imageView.getDrawable();
      AIOPictureData localAIOPictureData = o();
      if ((!this.k.imageView.isOriginalImage()) && (localAIOPictureData != null) && ((localDrawable instanceof SkinnableBitmapDrawable)) && (localAIOPictureData.f == 1) && (localAIOPictureData.d > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()))
      {
        this.k.imageView.setDoubleTapEnable(false);
        this.k.imageView.setScaleEnable(false);
      }
    }
    a();
  }
  
  public void c()
  {
    super.c();
    q();
    this.F = null;
    PictureView localPictureView = this.k;
    if (localPictureView != null) {
      localPictureView.onDestroy();
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    if (this.H.c != null)
    {
      Object localObject = this.H.c.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
      {
        a((AIOPictureData)((RichMediaBrowserInfo)localObject).baseData, (RichMediaBrowserInfo)localObject);
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheet, from:");
        localStringBuilder.append(paramInt);
        ((IBrowserLog)localObject).d("AIOPictureView", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if ((this.H.b() != null) && (this.H.b().h()))
    {
      this.H.g().a = false;
      return;
    }
    f(false);
    b(false);
    this.H.g().g();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.A != null)
    {
      if (paramBoolean) {
        r();
      }
      TextView localTextView = this.A;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public boolean g()
  {
    if (super.g())
    {
      AIOPictureData localAIOPictureData = o();
      if (localAIOPictureData != null)
      {
        AIOPictureModel localAIOPictureModel = new AIOPictureModel();
        File localFile2 = localAIOPictureModel.c(localAIOPictureData, 4);
        File localFile1 = localFile2;
        if (localFile2 == null) {
          localFile1 = localAIOPictureModel.c(localAIOPictureData, 2);
        }
        if ((localFile1 == null) && (ParamsManager.a().c())) {
          return false;
        }
        if ((!ParamsManager.a().c()) && (!ParamsManager.a().g())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public Rect getAnimationEndDstRect()
  {
    if (this.k.imageView != null)
    {
      Object localObject = this.k.imageView.getCurrentMatrixRectF();
      int i;
      if (((RectF)localObject).bottom > this.j) {
        i = this.j;
      } else {
        i = (int)((RectF)localObject).bottom;
      }
      localObject = new Rect((int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).right, i);
      ((Rect)localObject).offset((int)this.c.getResources().getDimension(2131299646), 0);
      return localObject;
    }
    return super.getAnimationEndDstRect();
  }
  
  public void h(boolean paramBoolean)
  {
    ImageButton localImageButton = this.B;
    if (localImageButton != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localImageButton.setVisibility(i);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    ImageButton localImageButton = this.B;
    if (localImageButton != null) {
      localImageButton.setEnabled(paramBoolean);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.C != null)
    {
      AIOPictureData localAIOPictureData = o();
      int j = 0;
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localAIOPictureData != null)
        {
          i = j;
          if (!ParamsManager.a().n())
          {
            i = j;
            if (!ParamsManager.a().g())
            {
              i = j;
              if (((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
              {
                i = j;
                if (((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).isAEPituTakeSameOpen())
                {
                  long l1 = localAIOPictureData.a;
                  i = j;
                  if (!TextUtils.isEmpty(localAIOPictureData.H))
                  {
                    this.C.setVisibility(0);
                    String str = this.c.getString(2131915727);
                    if (!TextUtils.isEmpty(localAIOPictureData.I)) {
                      str = localAIOPictureData.I;
                    }
                    this.D.setText(str);
                    j = 1;
                    i = j;
                    if (this.E != l1)
                    {
                      ReportController.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", localAIOPictureData.H, "");
                      this.E = l1;
                      i = j;
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (i == 0) {
        this.C.setVisibility(8);
      }
    }
  }
  
  public boolean l()
  {
    Object localObject = this.K;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i;
      if ((!((Intent)localObject).getBooleanExtra("extra.FROM_AIO", false)) && (ParamsManager.a().o() != 3) && (ParamsManager.a().o() != 2) && (ParamsManager.a().o() != 6)) {
        i = 0;
      } else {
        i = 1;
      }
      localObject = this.K.getExtras();
      if (i == 0)
      {
        bool1 = bool2;
        if (ParamsManager.a().o() == 4)
        {
          bool1 = bool2;
          if (!((Bundle)localObject).getBoolean("key_allow_forward_photo_preview_edit", false)) {}
        }
      }
      else
      {
        bool1 = bool2;
        if (UinTypeUtil.e(ParamsManager.a().i()) != 1032)
        {
          bool1 = bool2;
          if (UinTypeUtil.e(ParamsManager.a().i()) != 1044) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void m()
  {
    AIOPictureData localAIOPictureData = o();
    IProvider localIProvider = this.F;
    if ((localIProvider != null) && (localAIOPictureData != null) && (localIProvider.c()))
    {
      this.H.a(localAIOPictureData.a, localAIOPictureData.b, 3);
      this.F.a(localAIOPictureData.a, localAIOPictureData.b, 4);
      a();
      h();
      this.H.g().b();
    }
  }
  
  void n()
  {
    AIOPictureData localAIOPictureData = o();
    if ((localAIOPictureData != null) && ((this.c instanceof Activity)))
    {
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      Object localObject2 = localAIOPictureModel.c(localAIOPictureData, 4);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOPictureModel.c(localAIOPictureData, 2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOPictureModel.c(localAIOPictureData, 1);
      }
      if (localObject2 == null) {
        return;
      }
      this.q = ((File)localObject2).getAbsolutePath();
      int i;
      switch (ParamsManager.a().o())
      {
      default: 
        i = 99;
        bool1 = false;
        bool2 = false;
        j = 0;
        break;
      case 6: 
        i = 130;
        bool2 = false;
        break;
      case 5: 
        i = 129;
        break;
      case 4: 
        i = 125;
        bool1 = true;
        bool2 = false;
        j = 19002;
        break;
      case 3: 
        i = 128;
        break;
      case 2: 
        i = 127;
        break;
      case 1: 
        i = 126;
      }
      boolean bool2 = true;
      boolean bool1 = true;
      int j = 19000;
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).startEditPicActivity((Activity)this.c, i, bool1, bool2, j, ((File)localObject2).getAbsolutePath(), ParamsManager.a().i());
      ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
    }
  }
  
  public AIOPictureData o()
  {
    if ((this.H.a != null) && (this.H.a.b != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.H.a.b.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100)) {
        return (AIOPictureData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131437976)
    {
      if (o().v == 3) {
        this.H.j();
      }
    }
    else if (i == 2131430821)
    {
      t();
    }
    else if (i == 2131442310)
    {
      f();
    }
    else if (i == 2131442314)
    {
      m();
    }
    else if (i == 2131442311)
    {
      n();
      if (this.H.a != null) {
        this.H.a.h();
      }
    }
    else if (i == 2131442309)
    {
      e();
    }
    else if (i == 2131442307)
    {
      s();
    }
    else if (i == 2131430269)
    {
      Object localObject;
      if ((this.c instanceof BaseActivity))
      {
        localObject = (BaseActivity)this.c;
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (!PermissionUtil.a(this.c)) {
            ((BaseActivity)localObject).requestPermissions(new AIOPictureView.2(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          } else {
            u();
          }
        }
        else {
          u();
        }
      }
      else
      {
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick, activity:");
        localStringBuilder.append(this.c);
        ((IBrowserLog)localObject).d("AIOPictureView", 2, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismissOperations()
  {
    if (this.H.c != null) {
      this.H.c.updateSystemUIVisablity();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    Looper.myQueue().addIdleHandler(this.G);
    f(true);
    a();
  }
  
  public void onEnterAnimationStart()
  {
    super.onEnterAnimationStart();
    f(false);
    j(false);
  }
  
  public void p()
  {
    if (this.g != null)
    {
      this.t = ((RelativeLayout)this.g.findViewById(2131445235));
      this.u = ((TextView)this.g.findViewById(2131440762));
      this.v = ((ImageView)this.g.findViewById(2131430821));
      this.w = ((SeekBar)this.g.findViewById(2131445502));
      this.x = ((TextView)this.g.findViewById(2131432775));
      this.y = ((ImageView)this.g.findViewById(2131437653));
      this.C = ((LinearLayout)this.g.findViewById(2131430269));
      this.D = ((TextView)this.g.findViewById(2131430270));
      this.C.setOnClickListener(this);
      this.C.setVisibility(8);
      this.v.setOnClickListener(this);
      this.f = ((ImageButton)this.g.findViewById(2131442307));
      this.f.setOnClickListener(this);
      this.B = ((ImageButton)this.g.findViewById(2131442311));
      this.B.setOnClickListener(this);
      this.e = ((ImageButton)this.g.findViewById(2131442309));
      this.e.setOnClickListener(this);
      this.A = ((TextView)this.g.findViewById(2131442314));
      this.A.setOnClickListener(this);
      this.d = ((ImageButton)this.g.findViewById(2131442310));
      this.d.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.d;
      }
      if (this.H.c != null) {
        d(a(this.H.c.getSelectedItem()));
      }
      h(l());
      c(g());
    }
    Object localObject = this.k;
    if ((localObject != null) && (!((PictureView)localObject).isInExitAnim)) {
      f(true);
    }
  }
  
  public void q()
  {
    Object localObject = this.H;
    if ((localObject != null) && (((AIOPicturePresenter)localObject).c != null) && (this.H.c.mActiveDrawable != null)) {
      this.H.c.mActiveDrawable.clear();
    }
    localObject = this.I;
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 0)) {
      this.I.cancelDownload(true);
    }
    this.I = null;
    this.J = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView
 * JD-Core Version:    0.7.0.1
 */