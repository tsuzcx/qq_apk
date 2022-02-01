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
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFilePicturePresenter;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.PermissionUtil;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AIOFilePictureView
  extends AIOBrowserBaseView
  implements View.OnClickListener, ActionSheet.WatchDismissActions
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AIOFilePictureView.4(this);
  public ImageView a;
  public SeekBar a;
  public TextView a;
  private IProvider jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
  public AIOFilePicturePresenter a;
  public PictureView a;
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
  
  public AIOFilePictureView(Context paramContext, AIOFilePicturePresenter paramAIOFilePicturePresenter)
  {
    super(paramContext, paramAIOFilePicturePresenter);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter = paramAIOFilePicturePresenter;
  }
  
  private int a(int paramInt)
  {
    int i = 6;
    if (paramInt != 2)
    {
      if (paramInt != 6)
      {
        if (paramInt != 39)
        {
          if (paramInt != 52)
          {
            if (paramInt != 64)
            {
              if ((paramInt != 121) && (paramInt != 132))
              {
                if (paramInt != 26)
                {
                  if (paramInt == 27) {
                    return i;
                  }
                  if ((paramInt != 72) && (paramInt != 73)) {
                    switch (paramInt)
                    {
                    default: 
                      break;
                    case 56: 
                      return 10;
                    case 55: 
                      return 9;
                    case 54: 
                      return 7;
                    }
                  }
                }
                return -1;
              }
              else
              {
                return 13;
              }
            }
            else {
              return 11;
            }
          }
          else {
            return 8;
          }
        }
        else {
          return 2;
        }
      }
      else {
        return 3;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if (localIProvider != null) {
      localIProvider.a(paramLong, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView == null) {
        return;
      }
      this.jdField_a_of_type_JavaLangString = ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).checkQQCode(paramUri, paramArrayList, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet);
    }
  }
  
  private void a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    Intent localIntent = new Intent();
    String str;
    if (MessageRecordInfo.a(paramAIOFilePictureData.jdField_d_of_type_Int)) {
      str = ParamsManager.a().d();
    } else {
      str = ParamsManager.a().c();
    }
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramAIOFilePictureData.jdField_c_of_type_Int, true, str, null, null, paramAIOFilePictureData.jdField_e_of_type_JavaLangString, paramInt, ParamsManager.a().d(), ParamsManager.a().c(), localIntent);
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOFilePictureData paramAIOFilePictureData, AIOFilePictureModel paramAIOFilePictureModel, File paramFile, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
    if (paramAIOFilePictureModel.a(paramAIOFilePictureData, 16) != null)
    {
      paramAIOFilePictureModel = URLDrawable.getFileDrawable(paramAIOFilePictureData.jdField_a_of_type_JavaLangString, null);
      paramAIOFilePictureModel.downloadImediatly();
      localURLDrawableOptions.mLoadingDrawable = paramAIOFilePictureModel;
    }
    else
    {
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    }
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mUseExifOrientation = false;
    try
    {
      paramAIOFilePictureModel = URLDrawable.getFileDrawable(paramFile.getAbsolutePath(), localURLDrawableOptions);
    }
    catch (Throwable paramAIOFilePictureModel)
    {
      label89:
      break label89;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
    paramAIOFilePictureModel = null;
    if (paramAIOFilePictureModel != null)
    {
      paramAIOFilePictureModel.setTag(Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramAIOFilePictureModel);
      paramFile = paramFile.getAbsolutePath();
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setGalleryImageListener(new AIOFilePictureView.5(this, paramRichMediaBrowserInfo, paramFile, paramAIOFilePictureModel, paramAIOFilePictureData));
      this.jdField_a_of_type_JavaLangRunnable = RichMediaBrowserUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, paramAIOFilePictureModel);
      if ((this.jdField_a_of_type_JavaLangRunnable == null) && (paramAIOFilePictureModel.getStatus() == 1)) {
        a(paramRichMediaBrowserInfo, paramFile, paramAIOFilePictureModel, paramInt);
      } else {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOFilePictureModel, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(paramAIOFilePictureModel.getExifOrientation()));
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageDrawable(paramAIOFilePictureModel);
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    paramRichMediaBrowserInfo = URLDrawable.URLDrawableOptions.obtain();
    paramRichMediaBrowserInfo.mRequestWidth = this.jdField_a_of_type_Int;
    paramRichMediaBrowserInfo.mRequestHeight = this.jdField_b_of_type_Int;
    paramRichMediaBrowserInfo.mLoadingDrawable = URLDrawableHelperConstants.a;
    paramRichMediaBrowserInfo.mPlayGifImage = true;
    int i = 0;
    paramRichMediaBrowserInfo.mUseExifOrientation = false;
    try
    {
      paramRichMediaBrowserInfo = URLDrawable.getDrawable(paramFile, paramRichMediaBrowserInfo);
    }
    catch (Throwable paramRichMediaBrowserInfo)
    {
      label61:
      label63:
      break label61;
    }
    try
    {
      paramRichMediaBrowserInfo.setTag(Integer.valueOf(1));
      paramRichMediaBrowserInfo.downloadImediatly();
    }
    catch (Throwable localThrowable)
    {
      break label63;
    }
    paramRichMediaBrowserInfo = null;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "[getView] URLDrawable.getDrawable failed.");
    if (paramRichMediaBrowserInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
    }
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.getStatus() == 1))
    {
      try
      {
        int j = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
        i = j;
      }
      catch (Exception paramAIOFilePictureData)
      {
        paramFile = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("read exif error");
        localStringBuilder.append(paramAIOFilePictureData.getMessage());
        paramFile.d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageDrawable(paramRichMediaBrowserInfo);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramRichMediaBrowserInfo, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(i));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, true);
      return;
    }
    if ((!a(paramAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!b(paramAIOFilePictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView))) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
    }
    a(paramAIOFilePictureData.jdField_a_of_type_Long, paramAIOFilePictureData.jdField_a_of_type_Int, 18);
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
      paramString.d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
      i = 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramURLDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(i));
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, true);
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
    if ((!PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext)) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, null);
      return;
    }
    ((IFileDepend)QRoute.api(IFileDepend.class)).saveToAlbum(this.jdField_a_of_type_AndroidContentContext, localFile.getAbsolutePath());
  }
  
  private boolean a(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new AIOFilePictureModel();
    if (((AIOFilePictureModel)localObject2).a(paramAIOFilePictureData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
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
        localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dealTempImage() exception = ");
        localStringBuilder.append(localException.getMessage());
        ((IBrowserLog)localObject2).d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
      }
      if ((paramAIOFilePictureData != null) && (paramAIOFilePictureData.getStatus() == 1))
      {
        paramAIOFilePictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOFilePictureData, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "set thumb image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(URLDrawableHelperConstants.a);
    return true;
  }
  
  private boolean b(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealErrorImage()");
    if (paramAIOFilePictureData.jdField_d_of_type_Boolean)
    {
      paramAIOFilePictureData = MobileQQ.getContext().getResources().getDrawable(2130849901);
      paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOFilePictureData, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    return (localIProvider != null) && (localIProvider.a());
  }
  
  private void m()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if ((localAIOFilePictureData != null) && (new AIOFilePictureModel().a(localAIOFilePictureData, 20)))
    {
      if (localAIOFilePictureData.jdField_e_of_type_Long > 0L)
      {
        a(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidContentContext.getString(2131718255), new Object[] { FileSizeFormat.a(localAIOFilePictureData.jdField_e_of_type_Long) }));
        return;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131718252));
    }
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562763, null));
    l();
    this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(2, 8.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(3, 2131366456);
    paramView.addRule(14);
    paramView.topMargin = Utils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView.addView(this.jdField_c_of_type_AndroidWidgetTextView, paramView);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_AndroidWidgetImageView.setId(2131366456);
    paramView = new RelativeLayout.LayoutParams(120, 120);
    paramView.addRule(13);
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramView);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.controlViewContainer != null)
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.controlViewContainer.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if (localAIOFilePictureData != null)
    {
      int i = localAIOFilePictureData.status;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 3)
          {
            localObject = BrowserLogHelper.getInstance().getGalleryLog();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateUI status is error, status = ");
            localStringBuilder.append(localAIOFilePictureData.status);
            ((IBrowserLog)localObject).d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
          g(false);
          c(false);
          h(false);
          d(false);
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131718238));
          localStringBuilder.append(localAIOFilePictureData.progress / 100);
          localStringBuilder.append("%");
          ((TextView)localObject).setText(localStringBuilder.toString());
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOFilePictureData.progress / 100);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return;
        }
        g(false);
        c(false);
        h(false);
        d(false);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), localAIOFilePictureData.progress);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      c(b());
      d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem()));
      g(FileUtils.fileExistsAndNotEmpty(localAIOFilePictureData.jdField_c_of_type_JavaLangString) ^ true);
      h(true);
      Object localObject = new AIOFilePictureModel();
      if (localAIOFilePictureData.jdField_e_of_type_Long > 10485760L) {
        i(false);
      } else if ((((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 18) == null) && (((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 20) == null)) {
        i(false);
      } else {
        i(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject3 != null) && (((RichMediaBrowserInfo)localObject3).baseData != null))
    {
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView == null) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject3).baseData.getType() == 102)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(), (RichMediaBrowserInfo)localObject3);
        Object localObject2 = (AIOFilePictureData)((RichMediaBrowserInfo)localObject3).baseData;
        AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setOnItemEventListener(this);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setPosition(paramInt);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageInfo((RichMediaBrowserInfo)localObject3);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setIgnoreLayout(false);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131718251));
        URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
        String str1 = localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 20);
        String str2 = localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 18);
        String str3 = localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 16);
        if ((localURLDrawable != null) && (localURLDrawable.getURL() != null)) {
          localObject1 = localURLDrawable.getURL().toString();
        } else {
          localObject1 = "";
        }
        if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equals(str1)) || (((String)localObject1).equals(str2)) || (((String)localObject1).equals(str3))))
        {
          this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageDrawable(localURLDrawable);
          localObject1 = localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 20);
          localObject2 = localURLDrawable.getURL().toString();
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, true);
          if (((String)localObject2).equals(localObject1)) {
            this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setOriginalImage(true);
          }
          this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(localURLDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(JpegExifReader.readOrientation(localURLDrawable.getURL().getFile())));
        }
        else
        {
          localObject1 = localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 20);
          if (localObject1 != null)
          {
            a((RichMediaBrowserInfo)localObject3, (AIOFilePictureData)localObject2, localAIOFilePictureModel, (File)localObject1, paramInt);
          }
          else
          {
            localObject1 = localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 18);
            if (localObject1 != null)
            {
              a((RichMediaBrowserInfo)localObject3, (AIOFilePictureData)localObject2, (File)localObject1, paramInt);
            }
            else if (localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 16) != null)
            {
              if ((!a((AIOFilePictureData)localObject2, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!b((AIOFilePictureData)localObject2, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView))) {
                a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
              }
              a(((AIOFilePictureData)localObject2).jdField_a_of_type_Long, ((AIOFilePictureData)localObject2).jdField_a_of_type_Int, 18);
              localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("getView(): url is ");
              ((StringBuilder)localObject3).append(localAIOFilePictureModel.a((AIOFilePictureData)localObject2, 16));
              ((StringBuilder)localObject3).append(", file type is ");
              ((StringBuilder)localObject3).append(16);
              ((IBrowserLog)localObject1).d("AIOGalleryFilePicView", 4, ((StringBuilder)localObject3).toString());
            }
            else if ((!((IFileDepend)QRoute.api(IFileDepend.class)).checkFileThumbOverSize(((AIOFilePictureData)localObject2).jdField_e_of_type_Int, ((AIOFilePictureData)localObject2).f, ((AIOFilePictureData)localObject2).jdField_e_of_type_Long)) && (((AIOFilePictureData)localObject2).jdField_g_of_type_Int != 1))
            {
              if (((AIOFilePictureData)localObject2).jdField_d_of_type_Boolean)
              {
                a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
              }
              else
              {
                a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
                a(((AIOFilePictureData)localObject2).jdField_a_of_type_Long, ((AIOFilePictureData)localObject2).jdField_a_of_type_Int, 18);
              }
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): No pic");
            }
            else
            {
              localObject1 = MobileQQ.getContext().getResources().getDrawable(2130849898);
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
              this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetTextView.setText(2131718268);
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setMainBrowserPresenter(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mainBrowserPresenter);
      Object localObject1 = new AIOFilePictureView.GalleryFilePicViewHolder(this);
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject1).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView;
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView.setTag(localObject1);
    }
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 102) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView != null) && ((paramView.getTag() instanceof AIOFilePictureView.GalleryFilePicViewHolder)))
    {
      paramView = (AIOFilePictureView.GalleryFilePicViewHolder)paramView.getTag();
      Object localObject2 = paramView.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      Object localObject3 = paramView.jdField_a_of_type_AndroidWidgetImageView;
      TextView localTextView = paramView.jdField_a_of_type_AndroidWidgetTextView;
      AIOFilePictureData localAIOFilePictureData = (AIOFilePictureData)((RichMediaBrowserInfo)localObject1).baseData;
      paramView = new AIOFilePictureModel();
      ((ImageView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      if (localAIOFilePictureData.jdField_d_of_type_Boolean)
      {
        paramView = ((BrowserScaleView)localObject2).getDrawable();
        paramBoolean = URLDrawable.class.isInstance(paramView);
        localObject1 = null;
        if (paramBoolean)
        {
          localObject1 = (URLDrawable)paramView;
          paramView = ((URLDrawable)localObject1).getURL().getRef();
        }
        else
        {
          paramView = null;
        }
        if ((paramView == null) && (FileUtils.fileExistsAndNotEmpty(localAIOFilePictureData.jdField_a_of_type_JavaLangString)))
        {
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = URLDrawableHelperConstants.a;
          paramView.mFailedDrawable = URLDrawableHelperConstants.a;
          paramView = URLDrawable.getDrawable(new File(localAIOFilePictureData.jdField_a_of_type_JavaLangString), paramView);
          if (paramView != null)
          {
            ((BrowserScaleView)localObject2).setImageDrawable(paramView);
            paramView.downloadImediatly();
          }
        }
        else if ((localObject1 == null) || (paramView == null) || ((!"PART".equals(paramView)) && (!"DISPLAY".equals(paramView))))
        {
          if ((!((IFileDepend)QRoute.api(IFileDepend.class)).checkFileThumbOverSize(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) && (localAIOFilePictureData.jdField_g_of_type_Int != 1))
          {
            paramView = MobileQQ.getContext().getResources().getDrawable(2130849901);
            ((BrowserScaleView)localObject2).setImageDrawable(paramView);
            ((BrowserScaleView)localObject2).initDrawable(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
          }
          else
          {
            paramView = MobileQQ.getContext().getResources().getDrawable(2130849898);
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageDrawable(paramView);
            localTextView.setVisibility(0);
            localTextView.setText(2131718268);
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, false);
        }
      }
      else if (paramView.a(localAIOFilePictureData, 18) != null)
      {
        paramView = paramView.a(localAIOFilePictureData, 18);
        a(paramInt);
        localObject1 = FileUtils.estimateFileType(localAIOFilePictureData.jdField_b_of_type_JavaLangString);
        localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("AIOGalleryAdapter.updateView(): Update large image, position=");
        ((StringBuilder)localObject3).append(paramInt);
        ((StringBuilder)localObject3).append("url = ");
        ((StringBuilder)localObject3).append(paramView);
        ((StringBuilder)localObject3).append(",extName = ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((IBrowserLog)localObject2).d("AIOGalleryFilePicView", 4, ((StringBuilder)localObject3).toString());
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Boolean = paramIntent.getExtras().getBoolean("extra.OCR", false);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider))) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a());
    }
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOFilePictureView.3(this, paramAIOFilePictureData, paramFile));
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent;
      if (localObject != null) {
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_jc_file");
      }
    }
    Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (paramFile != null)
    {
      RichMediaBrowserUtils.a(2, (ArrayList)localObject);
      if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isPicShareToWXEnable()) && (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isFileSizeEnable(paramFile))) {
        RichMediaBrowserUtils.a(9, (ArrayList)localObject);
      }
      RichMediaBrowserUtils.a(27, (ArrayList)localObject);
      RichMediaBrowserUtils.a(64, (ArrayList)localObject);
      RichMediaBrowserUtils.a(39, localArrayList);
      RichMediaBrowserUtils.a(6, localArrayList);
      if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c()))) {
        RichMediaBrowserUtils.a(54, localArrayList);
      }
      if (this.jdField_a_of_type_Boolean) {
        RichMediaBrowserUtils.a(52, localArrayList);
      }
      ThreadManager.getFileThreadHandler().post(new AIOFilePictureView.2(this, paramFile, localArrayList));
      RichMediaBrowserUtils.a(121, localArrayList);
      if (QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidContentContext, paramFile.getPath())) {
        RichMediaBrowserUtils.a(132, localArrayList);
      }
    }
    else if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c())))
    {
      RichMediaBrowserUtils.a(54, localArrayList);
    }
    a(paramAIOFilePictureData, paramFile);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(paramAIOFilePictureData, (Activity)this.jdField_a_of_type_AndroidContentContext);
      if (paramAIOFilePictureData != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOFilePictureData);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject, localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.a(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof PictureView)) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView = ((PictureView)paramIBaseViewBuilder);
    }
    this.jdField_a_of_type_ComTencentRichmediabrowserViewBrowserBaseView.setPictureScaleEventListener(this);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = null;
    PictureView localPictureView = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView;
    if (localPictureView != null) {
      localPictureView.onDestroy();
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    a(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.getDrawable();
      if ((localAIOFilePictureData != null) && (!this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.isOriginalImage()) && ((localObject instanceof SkinnableBitmapDrawable)) && (localAIOFilePictureData.jdField_b_of_type_Int == 1) && (localAIOFilePictureData.jdField_c_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()))
      {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setDoubleTapEnable(false);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setScaleEnable(false);
      }
    }
    if (localAIOFilePictureData != null)
    {
      localObject = new AIOFilePictureModel();
      if ((((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 20) == null) && (((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 18) == null) && (((AIOFilePictureModel)localObject).a(localAIOFilePictureData, 16) == null) && ((((IFileDepend)QRoute.api(IFileDepend.class)).checkFileThumbOverSize(localAIOFilePictureData.jdField_e_of_type_Int, localAIOFilePictureData.f, localAIOFilePictureData.jdField_e_of_type_Long)) || (localAIOFilePictureData.jdField_g_of_type_Int == 1))) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
      }
    }
    a();
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
        if ((localFile1 == null) && (ParamsManager.a().b())) {
          return false;
        }
        if ((!ParamsManager.a().b()) && (!ParamsManager.a().d())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      Object localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 16);
      }
      if ((localObject2 == null) && (ParamsManager.a().b())) {
        return;
      }
      a(localAIOFilePictureData, (File)localObject2, paramInt);
    }
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    int i;
    if ((!((Intent)localObject).getBooleanExtra("extra.FROM_AIO", false)) && (ParamsManager.a().c() != 3) && (ParamsManager.a().c() != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    localObject = this.jdField_a_of_type_AndroidContentIntent.getExtras();
    boolean bool1;
    if (i == 0)
    {
      bool1 = bool2;
      if (ParamsManager.a().c() == 4)
      {
        bool1 = bool2;
        if (!((Bundle)localObject).getBoolean("key_allow_forward_photo_preview_edit", false)) {}
      }
    }
    else
    {
      bool1 = bool2;
      if (UinTypeUtil.a(ParamsManager.a().a()) != 1032)
      {
        bool1 = bool2;
        if (UinTypeUtil.a(ParamsManager.a().a()) != 1044) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().jdField_a_of_type_Boolean = false;
      return;
    }
    f(false);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().g();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        m();
      }
      TextView localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public Rect getAnimationEndDstRect()
  {
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.getCurrentMatrixRectF();
      int i;
      if (((RectF)localObject).bottom > this.jdField_b_of_type_Int) {
        i = this.jdField_b_of_type_Int;
      } else {
        i = (int)((RectF)localObject).bottom;
      }
      localObject = new Rect((int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).right, i);
      ((Rect)localObject).offset((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298924), 0);
      return localObject;
    }
    return super.getAnimationEndDstRect();
  }
  
  public void h(boolean paramBoolean)
  {
    ImageButton localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
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
    ImageButton localImageButton = this.jdField_d_of_type_AndroidWidgetImageButton;
    if (localImageButton != null) {
      localImageButton.setEnabled(paramBoolean);
    }
  }
  
  public void j()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if (localAIOFilePictureData != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if ((localObject != null) && (((IProvider)localObject).a()))
      {
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718250), 0).a();
          a();
          return;
        }
        if (localAIOFilePictureData.jdField_g_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718242), 0).a();
          a();
          return;
        }
        if (localAIOFilePictureData.h) {
          a();
        }
        long l = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
        if ((localAIOFilePictureData.jdField_e_of_type_Long > l) && (AppNetConnInfo.isMobileConn())) {
          try
          {
            ((IFileDepend)QRoute.api(IFileDepend.class)).showFlowDialog(false, this.jdField_a_of_type_AndroidContentContext, new AIOFilePictureView.1(this, localAIOFilePictureData));
            return;
          }
          catch (Throwable localThrowable)
          {
            localObject = BrowserLogHelper.getInstance().getGalleryLog();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("showFlowDialog throwable = ");
            localStringBuilder.append(localThrowable.getMessage());
            ((IBrowserLog)localObject).d("AIOGalleryFilePicView", 4, localStringBuilder.toString());
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 3);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(localThrowable.jdField_a_of_type_Long, localThrowable.jdField_a_of_type_Int, 20);
        if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView != null)
        {
          this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setDoubleTapEnable(true);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setScaleEnable(true);
        }
        f();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a().b();
        a();
      }
    }
  }
  
  void k()
  {
    AIOFilePictureData localAIOFilePictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      Object localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOFilePictureModel.a(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOFilePictureModel.a(localAIOFilePictureData, 16);
      }
      if (localObject2 == null) {
        return;
      }
      this.jdField_b_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
      int i;
      switch (ParamsManager.a().c())
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
      if (d())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
        if (localObject1 != null)
        {
          localObject1 = ((IProvider)localObject1).a(localAIOFilePictureData.jdField_a_of_type_Long, localAIOFilePictureData.jdField_a_of_type_Int, ParamsManager.a().a());
          if (localObject1 != null)
          {
            ((Intent)localObject1).setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
            localObject1 = (ForwardFileInfo)((Intent)localObject1).getParcelableExtra("fileinfo");
            break label280;
          }
        }
      }
      localObject1 = null;
      label280:
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((IFileDepend)QRoute.api(IFileDepend.class)).startEditPicActivity((Activity)this.jdField_a_of_type_AndroidContentContext, i, bool1, bool2, j, ((File)localObject2).getAbsolutePath(), ParamsManager.a().a(), (ForwardFileInfo)localObject1);
      }
      ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372747));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376889));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373153));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364715));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377129));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366457));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370386));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374216));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374219));
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      h(c());
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374212));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374214));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374215));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView;
    if ((localObject != null) && (!((PictureView)localObject).isInExitAnim)) {
      f(true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131370699)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 102)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.d();
      }
    }
    else if (i == 2131364715)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
      if (localObject != null)
      {
        IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
        if (localIProvider != null) {
          localIProvider.b(((AIOFilePictureData)localObject).jdField_a_of_type_Long, ((AIOFilePictureData)localObject).jdField_a_of_type_Int, 20);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a(((AIOFilePictureData)localObject).jdField_a_of_type_Long, ((AIOFilePictureData)localObject).jdField_a_of_type_Int, 0);
        a();
      }
    }
    else if (i == 2131374215)
    {
      e();
    }
    else if (i == 2131374219)
    {
      j();
    }
    else if (i == 2131374216)
    {
      k();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.f();
      }
    }
    else if (i == 2131374214)
    {
      d();
    }
    else if (i == 2131374212)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryFilePicView", 2, "onClick qq_gallery_danmaku_view ");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.a();
      if ((localObject != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().a(), false, ((AIOFilePictureData)localObject).jdField_d_of_type_Long, 0L);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.i();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismissOperations()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFilePicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateSystemUIVisablity();
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    f(true);
    a();
  }
  
  public void onEnterAnimationStart()
  {
    f(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView
 * JD-Core Version:    0.7.0.1
 */