package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.listener.IBrowserItemEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class AIOFilePictureView
  extends AIOBrowserBaseView
  implements View.OnClickListener, IBrowserItemEventListener, ActionSheet.WatchDismissActions
{
  MessageQueue.IdleHandler a;
  public ImageView a;
  public SeekBar a;
  public TextView a;
  public AIOFilePicturePresenter a;
  public BrowserScaleView a;
  public Runnable a;
  public String a;
  public boolean a;
  public ImageView b;
  public RelativeLayout b;
  public TextView b;
  public String b;
  private ImageView c;
  public TextView c;
  public ImageButton d;
  public TextView d;
  
  public AIOFilePictureView(Activity paramActivity, AIOFilePicturePresenter paramAIOFilePicturePresenter)
  {
    super(paramActivity, paramAIOFilePicturePresenter);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AIOFilePictureView.5(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter = paramAIOFilePicturePresenter;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramLong, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    int k = 0;
    if ((this.mContext == null) || (this.mContext.isFinishing()) || (this.mBrowserItemView == null)) {
      return;
    }
    ScannerResult localScannerResult = ScannerUtils.a(paramUri, this.mContext, 3);
    int i;
    int j;
    if (localScannerResult != null)
    {
      ThreadManager.getUIHandler().post(new AIOFilePictureView.2(this, localScannerResult, paramArrayList));
      if (localScannerResult.a != null)
      {
        i = localScannerResult.a.size();
        if (localScannerResult.b == null) {
          break label176;
        }
        j = localScannerResult.b.size();
        label97:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "qrSize = " + i + ", miniSize = " + j);
      }
    }
    for (;;)
    {
      i = k;
      if (localScannerResult != null) {
        i = localScannerResult.a();
      }
      if (i > 0) {
        this.jdField_a_of_type_JavaLangString = paramUri.getPath();
      }
      MiniScanReport.b(i);
      return;
      i = 0;
      break;
      label176:
      j = 0;
      break label97;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "checkQQCode scannerResult is null");
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOFilePictureData paramAIOFilePictureData, AIOFilePictureModel paramAIOFilePictureModel, File paramFile, int paramInt)
  {
    Object localObject = null;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.mScreenWidthPx;
    localURLDrawableOptions.mRequestHeight = this.mScreenHeightPx;
    if (paramAIOFilePictureModel.a(paramAIOFilePictureData, 16) != null)
    {
      paramAIOFilePictureModel = URLDrawable.getFileDrawable(paramAIOFilePictureData.jdField_b_of_type_JavaLangString, null);
      paramAIOFilePictureModel.downloadImediatly();
      localURLDrawableOptions.mLoadingDrawable = paramAIOFilePictureModel;
    }
    for (;;)
    {
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      try
      {
        paramAIOFilePictureModel = URLDrawable.getFileDrawable(paramFile.getAbsolutePath(), localURLDrawableOptions);
        if (paramAIOFilePictureModel != null)
        {
          paramAIOFilePictureModel.setTag(Integer.valueOf(1));
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramAIOFilePictureModel);
          paramFile = paramFile.getAbsolutePath();
          this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setGalleryImageListener(new AIOFilePictureView.6(this, paramRichMediaBrowserInfo, paramFile, paramAIOFilePictureModel, paramAIOFilePictureData));
          this.jdField_a_of_type_JavaLangRunnable = AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, paramAIOFilePictureModel);
          if ((this.jdField_a_of_type_JavaLangRunnable == null) && (paramAIOFilePictureModel.getStatus() == 1))
          {
            a(paramRichMediaBrowserInfo, paramFile, paramAIOFilePictureModel, paramInt);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable(paramAIOFilePictureModel);
          }
        }
        else
        {
          return;
          localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        }
      }
      catch (Throwable paramAIOFilePictureModel)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
          paramAIOFilePictureModel = localObject;
          continue;
          this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramAIOFilePictureModel, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getRotation(paramRichMediaBrowserInfo.orientation));
        }
      }
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.mScreenWidthPx;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.mScreenHeightPx;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
    try
    {
      localObject2 = URLDrawable.getDrawable(paramFile, (URLDrawable.URLDrawableOptions)localObject2);
      localObject1 = localObject2;
      ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
      localObject1 = localObject2;
      ((URLDrawable)localObject2).downloadImediatly();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable(localObject1);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(localObject1, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getRotation(paramRichMediaBrowserInfo.orientation));
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadFinish(paramInt, true);
        return;
        localThrowable = localThrowable;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
      }
      catch (Exception paramAIOFilePictureData)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + paramAIOFilePictureData.getMessage());
          paramRichMediaBrowserInfo.orientation = 1;
        }
      }
      if ((a(paramAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView)) || (b(paramAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView))) {
        break label286;
      }
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
      a(paramAIOFilePictureData.jdField_a_of_type_Long, paramAIOFilePictureData.jdField_a_of_type_Int, 18);
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), localObject1);
    }
    if ((localObject1 == null) || (localObject1.getStatus() != 1) || (paramRichMediaBrowserInfo.orientation == -2)) {}
    label286:
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo1, RichMediaBrowserInfo paramRichMediaBrowserInfo2)
  {
    if ((paramRichMediaBrowserInfo1 != null) && (paramRichMediaBrowserInfo1.baseData != null) && (paramRichMediaBrowserInfo1.baseData.getType() == 102) && (((AIOBrowserBaseData)paramRichMediaBrowserInfo1.baseData).jdField_a_of_type_Long == ((AIOBrowserBaseData)paramRichMediaBrowserInfo2.baseData).jdField_a_of_type_Long) && (!paramRichMediaBrowserInfo1.isReport))
    {
      ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 1, 0, "", "", "", "");
      paramRichMediaBrowserInfo1.isReport = true;
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EF0", "0X8009EF0", 2, 0, "", "", "", "");
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getRotation(paramRichMediaBrowserInfo.orientation));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  private void a(File paramFile, AIOFilePictureData paramAIOFilePictureData)
  {
    File localFile = paramFile;
    if (paramFile == null) {
      localFile = new AIOFilePictureModel().a(paramAIOFilePictureData, 20);
    }
    if (localFile == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 1, "setItemClickListenerForFile: error, file is null.");
      return;
    }
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    FileManagerUtil.a(this.mContext, localFile.getAbsolutePath());
  }
  
  private boolean a(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new AIOFilePictureModel();
    if (((AIOFilePictureModel)localObject2).a(paramAIOFilePictureData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      localObject2 = ((AIOFilePictureModel)localObject2).a(paramAIOFilePictureData, 16);
      paramAIOFilePictureData = null;
      try
      {
        localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
        paramAIOFilePictureData = (AIOFilePictureData)localObject1;
        ((URLDrawable)localObject1).downloadImediatly();
        paramAIOFilePictureData = (AIOFilePictureData)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOFilePictureData != null) && (paramAIOFilePictureData.getStatus() == 1))
      {
        paramAIOFilePictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramAIOFilePictureData, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(URLDrawableHelper.TRANSPARENT);
    return true;
  }
  
  private boolean b(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    boolean bool = false;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealErrorImage()");
    if (paramAIOFilePictureData.jdField_d_of_type_Boolean)
    {
      paramAIOFilePictureData = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183);
      paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramAIOFilePictureData, this.mScreenWidthPx, this.mScreenHeightPx, 0);
      bool = true;
    }
    return bool;
  }
  
  private boolean d()
  {
    return (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder());
  }
  
  private void k()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if ((localAIOFilePictureData != null) && (new AIOFilePictureModel().a(localAIOFilePictureData, 20)))
    {
      if (localAIOFilePictureData.jdField_c_of_type_Long > 0L) {
        a(String.format(Locale.CHINA, this.mContext.getString(2131695009), new Object[] { FileUtil.a(localAIOFilePictureData.jdField_c_of_type_Long) }));
      }
    }
    else {
      return;
    }
    a(this.mContext.getString(2131695006));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    Object localObject2;
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 16);
      }
      if ((localObject2 != null) || (!ParamsManager.a().a())) {}
    }
    else
    {
      return;
    }
    a(localAIOFilePictureData, (File)localObject2, paramInt);
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOFilePictureView.4(this, paramAIOFilePictureData, paramFile));
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    if ((this.mContext != null) && (this.mContext.getIntent() != null)) {
      this.mContext.getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramFile != null)
    {
      RichMediaShareActionSheetUtil.a(2, localArrayList1);
      if ((PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile))) {
        RichMediaShareActionSheetUtil.a(9, localArrayList1);
      }
      RichMediaShareActionSheetUtil.a(27, localArrayList1);
      RichMediaShareActionSheetUtil.a(39, localArrayList2);
      RichMediaShareActionSheetUtil.a(6, localArrayList2);
      if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c()))) {
        RichMediaShareActionSheetUtil.a(54, localArrayList2);
      }
      if (this.jdField_a_of_type_Boolean) {
        RichMediaShareActionSheetUtil.a(52, localArrayList2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOFilePictureView.3(this, paramFile, localArrayList2));
    }
    for (;;)
    {
      a(paramAIOFilePictureData, paramFile);
      paramAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(paramAIOFilePictureData, this.mContext);
      if (paramAIOFilePictureData != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOFilePictureData);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localArrayList1, localArrayList2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c()))) {
        RichMediaShareActionSheetUtil.a(54, localArrayList2);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public boolean b()
  {
    if (super.b())
    {
      AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
      if (localAIOFilePictureData != null)
      {
        AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
        File localFile2 = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
        File localFile1 = localFile2;
        if (localFile2 == null) {
          localFile1 = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
        }
        if ((localFile1 != null) || (!ParamsManager.a().a())) {
          break label67;
        }
      }
    }
    label67:
    while ((ParamsManager.a().a()) || (ParamsManager.a().c())) {
      return false;
    }
    return true;
  }
  
  public boolean back()
  {
    return super.back();
  }
  
  public void bindView(int paramInt)
  {
    super.bindView(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getItem(paramInt);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {
      return;
    }
    AIOFilePictureData localAIOFilePictureData;
    AIOFilePictureModel localAIOFilePictureModel;
    Object localObject;
    if (localRichMediaBrowserInfo.baseData.getType() == 102)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(), localRichMediaBrowserInfo);
      localAIOFilePictureData = (AIOFilePictureData)localRichMediaBrowserInfo.baseData;
      localAIOFilePictureModel = new AIOFilePictureModel();
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setOnItemEventListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setPosition(paramInt);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageInfo(localRichMediaBrowserInfo);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setIgnoreLayout(false);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setContentDescription(this.mContext.getString(2131691649));
      URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
      String str2 = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      String str3 = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
      String str4 = localAIOFilePictureModel.a(localAIOFilePictureData, 16);
      String str1 = "";
      localObject = str1;
      if (localURLDrawable != null)
      {
        localObject = str1;
        if (localURLDrawable.getURL() != null) {
          localObject = localURLDrawable.getURL().toString();
        }
      }
      if ((localURLDrawable == null) || (localURLDrawable.getStatus() != 1) || (TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).equals(str2)) && (!((String)localObject).equals(str3)) && (!((String)localObject).equals(str4)))) {
        break label427;
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable(localURLDrawable);
      localObject = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      str1 = localURLDrawable.getURL().toString();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadFinish(paramInt, true);
      if (str1.equals(localObject)) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setOriginalImage(true);
      }
      if (localRichMediaBrowserInfo.orientation == -2) {
        localRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(localURLDrawable.getURL().getFile());
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(localURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getRotation(localRichMediaBrowserInfo.orientation));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setMainBrowserPresenter(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.mainBrowserPresenter);
      localObject = new AIOFilePictureView.GalleryFilePicViewHolder(this);
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      this.mBrowserItemView.setTag(localObject);
      return;
      label427:
      localObject = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      if (localObject != null)
      {
        a(localRichMediaBrowserInfo, localAIOFilePictureData, localAIOFilePictureModel, (File)localObject, paramInt);
      }
      else
      {
        localObject = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
        if (localObject != null)
        {
          a(localRichMediaBrowserInfo, localAIOFilePictureData, (File)localObject, paramInt);
        }
        else if (localAIOFilePictureModel.a(localAIOFilePictureData, 16) != null)
        {
          if ((!a(localAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView)) && (!b(localAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView))) {
            a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
          }
          a(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): url is " + localAIOFilePictureModel.a(localAIOFilePictureData, 16) + ", file type is " + 16);
        }
        else
        {
          if ((!QFileUtils.a(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) && (localAIOFilePictureData.jdField_g_of_type_Int != 1))
          {
            if (localAIOFilePictureData.jdField_d_of_type_Boolean) {
              a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
            }
            for (;;)
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): No pic");
              break;
              a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
              a(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, 18);
            }
          }
          localObject = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844424);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setText(2131692465);
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
        }
      }
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("extra.OCR", false);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public boolean c()
  {
    if ((this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (ParamsManager.a().c() == 3) || (ParamsManager.a().c() == 2)) {}
    for (int i = 1;; i = 0)
    {
      Bundle localBundle = this.mContext.getIntent().getExtras();
      if (((i == 0) && ((ParamsManager.a().c() != 4) || (!localBundle.getBoolean("key_allow_forward_photo_preview_edit", false)))) || (UinTypeUtil.a(ParamsManager.a().a()) == 1032) || (UinTypeUtil.a(ParamsManager.a().a()) == 1044) || (ParamsManager.a().a() == 1037)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().jdField_a_of_type_Boolean = false;
      return;
    }
    showContentView(false);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().g();
  }
  
  public void f(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        k();
      }
      localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    ImageButton localImageButton;
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null)
    {
      localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  public Rect getAnimationEndDstRect()
  {
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getCurrentMatrixRectF();
      if (((RectF)localObject).bottom > this.mScreenHeightPx) {}
      for (int i = this.mScreenHeightPx;; i = (int)((RectF)localObject).bottom)
      {
        localObject = new Rect((int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).right, i);
        ((Rect)localObject).offset((int)this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getContext().getResources().getDimension(2131296673), 0);
        return localObject;
      }
    }
    return super.getAnimationEndDstRect();
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof AIOFilePictureView.GalleryFilePicViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      paramView = (AIOFilePictureView.GalleryFilePicViewHolder)paramView.getTag();
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = paramView.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      this.jdField_c_of_type_AndroidWidgetTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
      this.jdField_c_of_type_AndroidWidgetImageView = paramView.jdField_a_of_type_AndroidWidgetImageView;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getLayoutParams();
      paramView.width = -1;
      paramView.height = -1;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setLayoutParams(paramView);
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559261, paramViewGroup, false));
      j();
      this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.mContext);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 8.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(3, 2131366584);
      paramView.addRule(14);
      paramView.topMargin = AIOUtils.a(4.0F, this.mContext.getResources());
      this.mBrowserItemView.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramView);
      this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.mContext);
      this.jdField_c_of_type_AndroidWidgetImageView.setId(2131366584);
      paramView = new RelativeLayout.LayoutParams(120, 120);
      paramView.addRule(13);
      this.mBrowserItemView.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramView);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void h()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if ((localAIOFilePictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      if (!NetworkUtil.d(this.mContext))
      {
        QQToast.a(this.mContext, this.mContext.getString(2131693806), 0).a();
        updateUI();
      }
    }
    else {
      return;
    }
    if (localAIOFilePictureData.jdField_g_of_type_Boolean)
    {
      QQToast.a(this.mContext, this.mContext.getString(2131692760), 0).a();
      updateUI();
      return;
    }
    if (localAIOFilePictureData.h) {
      updateUI();
    }
    long l = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
    if ((localAIOFilePictureData.jdField_e_of_type_Long > l) && (FileManagerUtil.a())) {
      try
      {
        FileManagerUtil.a(false, this.mContext, new AIOFilePictureView.1(this, localAIOFilePictureData));
        return;
      }
      catch (Throwable localThrowable)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "showFlowDialog throwable = " + localThrowable.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 2);
    RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 20);
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView != null)
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setDoubleTapEnable(true);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setScaleEnable(true);
    }
    d();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
    updateUI();
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
  }
  
  void i()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    Object localObject2;
    Object localObject1;
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 16);
      }
      if (localObject2 != null) {}
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
    int i = 99;
    int j;
    boolean bool;
    int k;
    switch (ParamsManager.a().c())
    {
    default: 
      j = 0;
      bool = false;
      k = 0;
      localObject1 = EditPicActivity.a(this.mContext, ((File)localObject2).getAbsolutePath(), true, true, true, true, true, 2, i, 7);
      ((Intent)localObject1).putExtra("uintype", ParamsManager.a().a());
      ((Intent)localObject1).putExtra("open_chatfragment", true);
      ((Intent)localObject1).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
      ((Intent)localObject1).putExtra("key_enable_edit_title_bar", true);
      if (bool) {
        ((Intent)localObject1).putExtra("key_help_forward_pic", bool);
      }
      if (j != 0) {
        ((Intent)localObject1).putExtra("key_allow_multiple_forward_from_limit", false);
      }
      if (d())
      {
        localObject2 = RichMediaBrowserManager.getInstance().getProvider().getForwardData(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, ParamsManager.a().a());
        if (localObject2 != null)
        {
          ((Intent)localObject2).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
          localObject2 = (ForwardFileInfo)((Intent)localObject2).getParcelableExtra("fileinfo");
          if (localObject2 != null) {
            ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
          }
        }
      }
      ((Intent)localObject1).putExtra("not_forward", true);
      if (k != 0) {
        this.mContext.startActivityForResult((Intent)localObject1, k);
      }
      break;
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
      return;
      i = 125;
      j = 0;
      bool = true;
      k = 19002;
      break;
      i = 126;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 127;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 128;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 129;
      j = 1;
      bool = true;
      k = 19000;
      break;
      i = 130;
      j = 0;
      bool = true;
      k = 19000;
      break;
      this.mContext.startActivity((Intent)localObject1);
    }
  }
  
  public void j()
  {
    if (this.mBrowserItemView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131373170));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = ((BrowserScaleView)this.mBrowserItemView.findViewById(2131368729));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131377442));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131373573));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131364828));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.mBrowserItemView.findViewById(2131377693));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131366585));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131370751));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374678));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131374681));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      g(c());
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374674));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374676));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374677));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.addRule(10, -1);
        localLayoutParams.topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 102))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.back();
        continue;
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
        if (localObject != null)
        {
          if (RichMediaBrowserManager.getInstance().getProvider() != null) {
            RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOFilePictureData)localObject).jdField_a_of_type_Long, ((AIOFilePictureData)localObject).jdField_a_of_type_Int, 20);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(((AIOFilePictureData)localObject).jdField_a_of_type_Long, ((AIOFilePictureData)localObject).jdField_a_of_type_Int, 0);
          updateUI();
          continue;
          c();
          continue;
          h();
          continue;
          i();
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.h();
          continue;
          b();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryFilePicView", 0, "onClick qq_gallery_danmaku_view ");
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
          if (localObject != null) {
            MiniChatActivity.a(this.mContext, ParamsManager.a().a(), ParamsManager.a().a(), false, 26, ((AIOFilePictureData)localObject).jdField_d_of_type_Long, 0L);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.l();
        }
      }
    }
  }
  
  public void onClickEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.back();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public void onDismissOperations()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.updateSystemUIVisablity();
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    showContentView(false);
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getDrawable();
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if ((localAIOFilePictureData != null) && (!this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.isOriginalImage()) && ((localObject instanceof SkinnableBitmapDrawable)) && (localAIOFilePictureData.jdField_b_of_type_Int == 1) && (localAIOFilePictureData.jdField_c_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()))
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setDoubleTapEnable(false);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setScaleEnable(false);
    }
    if (localAIOFilePictureData != null)
    {
      localObject = new AIOFilePictureModel();
      if ((((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 20) == null) && (((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 18) == null) && (((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 16) == null) && ((QFileUtils.a(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) || (localAIOFilePictureData.jdField_g_of_type_Int == 1))) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
      }
    }
    updateUI();
  }
  
  public void onLongClickEvent()
  {
    onLongClick(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    paramView = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getDrawable();
    if (!URLDrawable.class.isInstance(paramView)) {
      return;
    }
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void updateUI()
  {
    super.updateUI();
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if (localAIOFilePictureData != null) {}
    switch (localAIOFilePictureData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "updateUI status is error, status = " + localAIOFilePictureData.status);
      return;
    case 1: 
      f(false);
      c(false);
      g(false);
      d(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getSelectedIndex(), localAIOFilePictureData.progress);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getSelectedIndex(), true);
      f(false);
      c(false);
      g(false);
      d(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700139) + localAIOFilePictureData.progress / 100 + "%");
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOFilePictureData.progress / 100);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    c(b());
    d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getSelectedItem()));
    boolean bool;
    AIOFilePictureModel localAIOFilePictureModel;
    if (!FileUtil.b(localAIOFilePictureData.jdField_d_of_type_JavaLangString))
    {
      bool = true;
      f(bool);
      g(true);
      localAIOFilePictureModel = new AIOFilePictureModel();
      if (localAIOFilePictureData.jdField_e_of_type_Long <= 10485760L) {
        break label324;
      }
      h(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getSelectedIndex(), true);
      return;
      bool = false;
      break;
      label324:
      if ((localAIOFilePictureModel.a(localAIOFilePictureData, 18) != null) || (localAIOFilePictureModel.a(localAIOFilePictureData, 20) != null)) {
        h(true);
      } else {
        h(false);
      }
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    paramString1 = null;
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.getItem(paramInt);
    Object localObject;
    ImageView localImageView;
    AIOFilePictureData localAIOFilePictureData;
    if ((paramString2 != null) && (paramString2.baseData != null) && (paramString2.baseData.getType() == 102) && (this.mBrowserItemView != null) && ((paramView.getTag() instanceof AIOFilePictureView.GalleryFilePicViewHolder)))
    {
      localObject = (AIOFilePictureView.GalleryFilePicViewHolder)paramView.getTag();
      paramView = ((AIOFilePictureView.GalleryFilePicViewHolder)localObject).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      localImageView = ((AIOFilePictureView.GalleryFilePicViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView;
      localObject = ((AIOFilePictureView.GalleryFilePicViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView;
      localAIOFilePictureData = (AIOFilePictureData)paramString2.baseData;
      paramString2 = new AIOFilePictureModel();
      localImageView.setVisibility(8);
      ((TextView)localObject).setVisibility(8);
      if (!localAIOFilePictureData.jdField_d_of_type_Boolean) {
        break label379;
      }
      paramString2 = paramView.getDrawable();
      if (!URLDrawable.class.isInstance(paramString2)) {
        break label478;
      }
      paramString1 = (URLDrawable)paramString2;
    }
    label478:
    for (paramString2 = paramString1.getURL().getRef();; paramString2 = null)
    {
      if ((paramString2 == null) && (FileUtil.b(localAIOFilePictureData.jdField_b_of_type_JavaLangString)))
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        paramString1.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
        paramString1 = URLDrawable.getDrawable(new File(localAIOFilePictureData.jdField_b_of_type_JavaLangString), paramString1);
        if (paramString1 != null)
        {
          paramView.setImageDrawable(paramString1);
          paramString1.downloadImediatly();
        }
      }
      label379:
      do
      {
        do
        {
          return;
        } while ((paramString1 != null) && (paramString2 != null) && (("PART".equals(paramString2)) || ("DISPLAY".equals(paramString2))));
        if ((QFileUtils.a(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) || (localAIOFilePictureData.jdField_g_of_type_Int == 1))
        {
          paramString1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844424);
          localImageView.setVisibility(0);
          localImageView.setImageDrawable(paramString1);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setText(2131692465);
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.onLoadFinish(paramInt, false);
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().d();
          return;
          paramString1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183);
          paramView.setImageDrawable(paramString1);
          paramView.initDrawable(paramString1, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        }
      } while (paramString2.a(localAIOFilePictureData, 18) == null);
      paramString1 = paramString2.a(localAIOFilePictureData, 18);
      bindView(paramInt);
      paramString2 = FileUtils.b(localAIOFilePictureData.jdField_c_of_type_JavaLangString);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + paramString1 + ",extName = " + paramString2);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView
 * JD-Core Version:    0.7.0.1
 */