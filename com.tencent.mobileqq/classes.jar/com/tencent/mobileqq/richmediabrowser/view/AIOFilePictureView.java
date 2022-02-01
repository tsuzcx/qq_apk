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
  private ImageView A;
  private Intent B;
  private IProvider C;
  public AIOFilePicturePresenter k;
  public PictureView l;
  public boolean m = false;
  public String n;
  public RelativeLayout o;
  public TextView p;
  public ImageView q;
  public SeekBar r;
  public TextView s;
  public ImageView t;
  public Runnable u;
  public TextView v;
  public TextView w;
  public ImageButton x;
  public String y;
  MessageQueue.IdleHandler z = new AIOFilePictureView.4(this);
  
  public AIOFilePictureView(Context paramContext, AIOFilePicturePresenter paramAIOFilePicturePresenter)
  {
    super(paramContext, paramAIOFilePicturePresenter);
    this.k = paramAIOFilePicturePresenter;
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    IProvider localIProvider = this.C;
    if (localIProvider != null) {
      localIProvider.a(paramLong, paramInt1, paramInt2);
    }
    this.k.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2)
  {
    if (((this.c instanceof Activity)) && (!((Activity)this.c).isFinishing()))
    {
      if (this.l.mBrowserItemView == null) {
        return;
      }
      this.n = ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).checkQQCode(paramUri, paramArrayList1, paramArrayList2, (Activity)this.c, this.y, this.b);
    }
  }
  
  private void a(AIOFilePictureData paramAIOFilePictureData, int paramInt)
  {
    Intent localIntent = new Intent();
    String str;
    if (MessageRecordInfo.b(paramAIOFilePictureData.u)) {
      str = ParamsManager.a().k();
    } else {
      str = ParamsManager.a().j();
    }
    ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).onQRDecodeSucceed(this.c, this.n, paramAIOFilePictureData.j, true, str, null, null, paramAIOFilePictureData.v, paramInt, ParamsManager.a().k(), ParamsManager.a().j(), localIntent);
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOFilePictureData paramAIOFilePictureData, AIOFilePictureModel paramAIOFilePictureModel, File paramFile, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.i;
    localURLDrawableOptions.mRequestHeight = this.j;
    if (paramAIOFilePictureModel.c(paramAIOFilePictureData, 16) != null)
    {
      paramAIOFilePictureModel = URLDrawable.getFileDrawable(paramAIOFilePictureData.k, null);
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
      this.k.c.mActiveDrawable.put(Integer.valueOf(paramInt), paramAIOFilePictureModel);
      paramFile = paramFile.getAbsolutePath();
      this.l.imageView.setGalleryImageListener(new AIOFilePictureView.5(this, paramRichMediaBrowserInfo, paramFile, paramAIOFilePictureModel, paramAIOFilePictureData));
      this.u = RichMediaBrowserUtils.a(this.t, paramAIOFilePictureModel);
      if ((this.u == null) && (paramAIOFilePictureModel.getStatus() == 1)) {
        a(paramRichMediaBrowserInfo, paramFile, paramAIOFilePictureModel, paramInt);
      } else {
        this.l.imageView.initDrawable(paramAIOFilePictureModel, this.i, this.j, BrowserUtils.a(paramAIOFilePictureModel.getExifOrientation()));
      }
      this.l.imageView.setImageDrawable(paramAIOFilePictureModel);
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    paramRichMediaBrowserInfo = URLDrawable.URLDrawableOptions.obtain();
    paramRichMediaBrowserInfo.mRequestWidth = this.i;
    paramRichMediaBrowserInfo.mRequestHeight = this.j;
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
      this.k.c.mActiveDrawable.put(Integer.valueOf(paramInt), paramRichMediaBrowserInfo);
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
      this.l.imageView.setImageDrawable(paramRichMediaBrowserInfo);
      this.l.imageView.initDrawable(paramRichMediaBrowserInfo, this.i, this.j, BrowserUtils.a(i));
      this.k.c.onLoadFinish(paramInt, true);
      return;
    }
    if ((!a(paramAIOFilePictureData, this.l.imageView)) && (!b(paramAIOFilePictureData, this.l.imageView))) {
      a(this.l.imageView);
    }
    a(paramAIOFilePictureData.a, paramAIOFilePictureData.b, 18);
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo1, RichMediaBrowserInfo paramRichMediaBrowserInfo2)
  {
    if ((paramRichMediaBrowserInfo1 != null) && (paramRichMediaBrowserInfo1.baseData != null) && (paramRichMediaBrowserInfo1.baseData.getType() == 102) && (((AIOBrowserBaseData)paramRichMediaBrowserInfo1.baseData).a == ((AIOBrowserBaseData)paramRichMediaBrowserInfo2.baseData).a) && (!paramRichMediaBrowserInfo1.isReport))
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
    if ((this.k.c != null) && (this.k.c.mActiveDrawable != null)) {
      this.k.c.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
    this.l.imageView.initDrawable(paramURLDrawable, this.i, this.j, BrowserUtils.a(i));
    this.k.c.onLoadFinish(paramInt, true);
  }
  
  private void a(File paramFile, AIOFilePictureData paramAIOFilePictureData)
  {
    File localFile = paramFile;
    if (paramFile == null) {
      localFile = new AIOFilePictureModel().c(paramAIOFilePictureData, 20);
    }
    if (localFile == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 1, "setItemClickListenerForFile: error, file is null.");
      return;
    }
    if ((!PermissionUtil.a(this.c)) && ((this.c instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.c, null);
      return;
    }
    ((IFileDepend)QRoute.api(IFileDepend.class)).saveToAlbum(this.c, localFile.getAbsolutePath());
  }
  
  private boolean a(AIOFilePictureData paramAIOFilePictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "dealThumbImage()");
    Object localObject2 = new AIOFilePictureModel();
    if (((AIOFilePictureModel)localObject2).c(paramAIOFilePictureData, 16) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
      localObject2 = ((AIOFilePictureModel)localObject2).c(paramAIOFilePictureData, 16);
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
        this.l.imageView.initDrawable(paramAIOFilePictureData, this.i, this.j, 0);
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
    if (paramAIOFilePictureData.o)
    {
      paramAIOFilePictureData = MobileQQ.getContext().getResources().getDrawable(2130851629);
      paramGalleryUrlImageView.setImageDrawable(paramAIOFilePictureData);
      this.l.imageView.initDrawable(paramAIOFilePictureData, this.i, this.j, 0);
      return true;
    }
    return false;
  }
  
  private int d(int paramInt)
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
  
  private void p()
  {
    AIOFilePictureData localAIOFilePictureData = this.k.r();
    if ((localAIOFilePictureData != null) && (new AIOFilePictureModel().a(localAIOFilePictureData, 20)))
    {
      if (localAIOFilePictureData.s > 0L)
      {
        a(String.format(Locale.CHINA, this.c.getString(2131915747), new Object[] { FileSizeFormat.a(localAIOFilePictureData.s) }));
        return;
      }
      a(this.c.getString(2131915744));
    }
  }
  
  private boolean q()
  {
    IProvider localIProvider = this.C;
    return (localIProvider != null) && (localIProvider.c());
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.g = ((RelativeLayout)LayoutInflater.from(this.c).inflate(2131629205, null));
    o();
    this.v = new TextView(this.c);
    this.v.setTextSize(2, 8.0F);
    this.v.setTextColor(-1);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(3, 2131432774);
    paramView.addRule(14);
    paramView.topMargin = Utils.a(4.0F, this.c.getResources());
    this.l.mBrowserItemView.addView(this.v, paramView);
    this.A = new ImageView(this.c);
    this.A.setId(2131432774);
    paramView = new RelativeLayout.LayoutParams(120, 120);
    paramView.addRule(13);
    this.l.mBrowserItemView.addView(this.A, paramView);
    this.v.setVisibility(8);
    this.A.setVisibility(8);
    if (this.l.controlViewContainer != null)
    {
      this.l.controlViewContainer.addView(this.g);
      return this.l.mBrowserItemView;
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    AIOFilePictureData localAIOFilePictureData = this.k.r();
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
          this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
          g(false);
          c(false);
          h(false);
          d(false);
          localObject = this.p;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.c.getString(2131915730));
          localStringBuilder.append(localAIOFilePictureData.progress / 100);
          localStringBuilder.append("%");
          ((TextView)localObject).setText(localStringBuilder.toString());
          this.r.setProgress(localAIOFilePictureData.progress / 100);
          this.o.setVisibility(0);
          return;
        }
        g(false);
        c(false);
        h(false);
        d(false);
        this.k.c.onLoadStart(this.k.c.getSelectedIndex(), localAIOFilePictureData.progress);
        return;
      }
      this.o.setVisibility(8);
      c(g());
      d(a(this.k.c.getSelectedItem()));
      g(FileUtils.fileExistsAndNotEmpty(localAIOFilePictureData.m) ^ true);
      h(true);
      Object localObject = new AIOFilePictureModel();
      if (localAIOFilePictureData.s > 10485760L) {
        i(false);
      } else if ((((AIOFilePictureModel)localObject).c(localAIOFilePictureData, 18) == null) && (((AIOFilePictureModel)localObject).c(localAIOFilePictureData, 20) == null)) {
        i(false);
      } else {
        i(true);
      }
      this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.t.setVisibility(8);
    Object localObject3 = this.k.c.getItem(paramInt);
    if ((localObject3 != null) && (((RichMediaBrowserInfo)localObject3).baseData != null))
    {
      if (this.l.imageView == null) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject3).baseData.getType() == 102)
      {
        a(this.k.p(), (RichMediaBrowserInfo)localObject3);
        Object localObject2 = (AIOFilePictureData)((RichMediaBrowserInfo)localObject3).baseData;
        AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
        this.l.imageView.setOnItemEventListener(this);
        this.l.imageView.setPosition(paramInt);
        this.l.imageView.setImageInfo((RichMediaBrowserInfo)localObject3);
        this.l.imageView.setIgnoreLayout(false);
        this.l.imageView.setContentDescription(this.c.getString(2131915743));
        URLDrawable localURLDrawable = (URLDrawable)this.k.c.mActiveDrawable.get(Integer.valueOf(paramInt));
        String str1 = localAIOFilePictureModel.b((AIOFilePictureData)localObject2, 20);
        String str2 = localAIOFilePictureModel.b((AIOFilePictureData)localObject2, 18);
        String str3 = localAIOFilePictureModel.b((AIOFilePictureData)localObject2, 16);
        if ((localURLDrawable != null) && (localURLDrawable.getURL() != null)) {
          localObject1 = localURLDrawable.getURL().toString();
        } else {
          localObject1 = "";
        }
        if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).equals(str1)) || (((String)localObject1).equals(str2)) || (((String)localObject1).equals(str3))))
        {
          this.l.imageView.setImageDrawable(localURLDrawable);
          localObject1 = localAIOFilePictureModel.b((AIOFilePictureData)localObject2, 20);
          localObject2 = localURLDrawable.getURL().toString();
          this.k.c.onLoadFinish(paramInt, true);
          if (((String)localObject2).equals(localObject1)) {
            this.l.imageView.setOriginalImage(true);
          }
          this.l.imageView.initDrawable(localURLDrawable, this.i, this.j, BrowserUtils.a(JpegExifReader.readOrientation(localURLDrawable.getURL().getFile())));
        }
        else
        {
          localObject1 = localAIOFilePictureModel.c((AIOFilePictureData)localObject2, 20);
          if (localObject1 != null)
          {
            a((RichMediaBrowserInfo)localObject3, (AIOFilePictureData)localObject2, localAIOFilePictureModel, (File)localObject1, paramInt);
          }
          else
          {
            localObject1 = localAIOFilePictureModel.c((AIOFilePictureData)localObject2, 18);
            if (localObject1 != null)
            {
              a((RichMediaBrowserInfo)localObject3, (AIOFilePictureData)localObject2, (File)localObject1, paramInt);
            }
            else if (localAIOFilePictureModel.c((AIOFilePictureData)localObject2, 16) != null)
            {
              if ((!a((AIOFilePictureData)localObject2, this.l.imageView)) && (!b((AIOFilePictureData)localObject2, this.l.imageView))) {
                a(this.l.imageView);
              }
              a(((AIOFilePictureData)localObject2).a, ((AIOFilePictureData)localObject2).b, 18);
              localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("getView(): url is ");
              ((StringBuilder)localObject3).append(localAIOFilePictureModel.b((AIOFilePictureData)localObject2, 16));
              ((StringBuilder)localObject3).append(", file type is ");
              ((StringBuilder)localObject3).append(16);
              ((IBrowserLog)localObject1).d("AIOGalleryFilePicView", 4, ((StringBuilder)localObject3).toString());
            }
            else if ((!((IFileDepend)QRoute.api(IFileDepend.class)).checkFileThumbOverSize(((AIOFilePictureData)localObject2).x, ((AIOFilePictureData)localObject2).y, ((AIOFilePictureData)localObject2).s)) && (((AIOFilePictureData)localObject2).z != 1))
            {
              if (((AIOFilePictureData)localObject2).o)
              {
                a(this.l.imageView);
              }
              else
              {
                a(this.l.imageView);
                a(((AIOFilePictureData)localObject2).a, ((AIOFilePictureData)localObject2).b, 18);
              }
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOGalleryFilePicView", 4, "getView(): No pic");
            }
            else
            {
              localObject1 = MobileQQ.getContext().getResources().getDrawable(2130851626);
              this.A.setVisibility(0);
              this.A.setImageDrawable((Drawable)localObject1);
              this.v.setVisibility(0);
              this.v.setText(2131915760);
              this.k.g().b();
            }
          }
        }
      }
      this.l.imageView.setMainBrowserPresenter(this.k.c.mainBrowserPresenter);
      Object localObject1 = new AIOFilePictureView.GalleryFilePicViewHolder(this);
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject1).a = this.l.imageView;
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject1).b = this.v;
      ((AIOFilePictureView.GalleryFilePicViewHolder)localObject1).c = this.A;
      this.l.mBrowserItemView.setTag(localObject1);
    }
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.k.c.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 102) && (this.l.mBrowserItemView != null) && ((paramView.getTag() instanceof AIOFilePictureView.GalleryFilePicViewHolder)))
    {
      paramView = (AIOFilePictureView.GalleryFilePicViewHolder)paramView.getTag();
      Object localObject2 = paramView.a;
      Object localObject3 = paramView.c;
      TextView localTextView = paramView.b;
      AIOFilePictureData localAIOFilePictureData = (AIOFilePictureData)((RichMediaBrowserInfo)localObject1).baseData;
      paramView = new AIOFilePictureModel();
      ((ImageView)localObject3).setVisibility(8);
      localTextView.setVisibility(8);
      if (localAIOFilePictureData.o)
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
        if ((paramView == null) && (FileUtils.fileExistsAndNotEmpty(localAIOFilePictureData.k)))
        {
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = URLDrawableHelperConstants.a;
          paramView.mFailedDrawable = URLDrawableHelperConstants.a;
          paramView = URLDrawable.getDrawable(new File(localAIOFilePictureData.k), paramView);
          if (paramView != null)
          {
            ((BrowserScaleView)localObject2).setImageDrawable(paramView);
            paramView.downloadImediatly();
          }
        }
        else if ((localObject1 == null) || (paramView == null) || ((!"PART".equals(paramView)) && (!"DISPLAY".equals(paramView))))
        {
          if ((!((IFileDepend)QRoute.api(IFileDepend.class)).checkFileThumbOverSize(localAIOFilePictureData.x, localAIOFilePictureData.y, localAIOFilePictureData.s)) && (localAIOFilePictureData.z != 1))
          {
            paramView = MobileQQ.getContext().getResources().getDrawable(2130851629);
            ((BrowserScaleView)localObject2).setImageDrawable(paramView);
            ((BrowserScaleView)localObject2).initDrawable(paramView, this.i, this.j, 0);
          }
          else
          {
            paramView = MobileQQ.getContext().getResources().getDrawable(2130851626);
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageDrawable(paramView);
            localTextView.setVisibility(0);
            localTextView.setText(2131915760);
            this.k.g().b();
          }
          this.k.c.onLoadFinish(paramInt, false);
        }
      }
      else if (paramView.c(localAIOFilePictureData, 18) != null)
      {
        paramView = paramView.b(localAIOFilePictureData, 18);
        a(paramInt);
        localObject1 = FileUtils.estimateFileType(localAIOFilePictureData.l);
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
    this.B = paramIntent;
    this.m = paramIntent.getExtras().getBoolean("extra.OCR", false);
    if ((this.k.a != null) && ((this.k.a.getParamsBuilder().a() instanceof IProvider))) {
      this.C = ((IProvider)this.k.a.getParamsBuilder().a());
    }
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile)
  {
    this.b.setItemClickListenerV2(new AIOFilePictureView.3(this, paramAIOFilePictureData, paramFile));
  }
  
  public void a(AIOFilePictureData paramAIOFilePictureData, File paramFile, int paramInt)
  {
    if (this.c != null)
    {
      localObject = this.B;
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
      if ((ParamsManager.a().r()) && (!TextUtils.isEmpty(ParamsManager.a().j()))) {
        RichMediaBrowserUtils.a(54, localArrayList);
      }
      if (this.m) {
        RichMediaBrowserUtils.a(52, localArrayList);
      }
      ThreadManager.getFileThreadHandler().post(new AIOFilePictureView.2(this, paramFile, (ArrayList)localObject, localArrayList));
      RichMediaBrowserUtils.a(121, localArrayList);
      if (QbSdk.isInDefaultBrowser(this.c, paramFile.getPath())) {
        RichMediaBrowserUtils.a(132, localArrayList);
      }
    }
    else if ((ParamsManager.a().r()) && (!TextUtils.isEmpty(ParamsManager.a().j())))
    {
      RichMediaBrowserUtils.a(54, localArrayList);
    }
    a(paramAIOFilePictureData, paramFile);
    if ((this.c instanceof Activity))
    {
      paramAIOFilePictureData = this.k.a(paramAIOFilePictureData, (Activity)this.c);
      if (paramAIOFilePictureData != null) {
        this.b.setIntentForStartForwardRecentActivity(paramAIOFilePictureData);
      }
    }
    this.b.setActionSheetItems((List)localObject, localArrayList);
    this.b.show();
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.a(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof PictureView)) {
      this.l = ((PictureView)paramIBaseViewBuilder);
    }
    this.h.setPictureScaleEventListener(this);
  }
  
  public void a(String paramString)
  {
    TextView localTextView = this.w;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    a(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.k.r();
    Object localObject;
    if (this.l.imageView != null)
    {
      localObject = this.l.imageView.getDrawable();
      if ((localAIOFilePictureData != null) && (!this.l.imageView.isOriginalImage()) && ((localObject instanceof SkinnableBitmapDrawable)) && (localAIOFilePictureData.f == 1) && (localAIOFilePictureData.d > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()))
      {
        this.l.imageView.setDoubleTapEnable(false);
        this.l.imageView.setScaleEnable(false);
      }
    }
    if (localAIOFilePictureData != null)
    {
      localObject = new AIOFilePictureModel();
      if ((((AIOFilePictureModel)localObject).c(localAIOFilePictureData, 20) == null) && (((AIOFilePictureModel)localObject).c(localAIOFilePictureData, 18) == null) && (((AIOFilePictureModel)localObject).c(localAIOFilePictureData, 16) == null) && ((((IFileDepend)QRoute.api(IFileDepend.class)).checkFileThumbOverSize(localAIOFilePictureData.x, localAIOFilePictureData.y, localAIOFilePictureData.s)) || (localAIOFilePictureData.z == 1))) {
        this.k.g().b();
      }
    }
    a();
  }
  
  public void c()
  {
    super.c();
    this.C = null;
    PictureView localPictureView = this.l;
    if (localPictureView != null) {
      localPictureView.onDestroy();
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    AIOFilePictureData localAIOFilePictureData = this.k.r();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      Object localObject2 = localAIOFilePictureModel.c(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOFilePictureModel.c(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOFilePictureModel.c(localAIOFilePictureData, 16);
      }
      if ((localObject2 == null) && (ParamsManager.a().c())) {
        return;
      }
      a(localAIOFilePictureData, (File)localObject2, paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if ((this.k.b() != null) && (this.k.b().h()))
    {
      this.k.g().a = false;
      return;
    }
    f(false);
    b(false);
    this.k.g().g();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.w != null)
    {
      if (paramBoolean) {
        p();
      }
      TextView localTextView = this.w;
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
      AIOFilePictureData localAIOFilePictureData = this.k.r();
      if (localAIOFilePictureData != null)
      {
        AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
        File localFile2 = localAIOFilePictureModel.c(localAIOFilePictureData, 20);
        File localFile1 = localFile2;
        if (localFile2 == null) {
          localFile1 = localAIOFilePictureModel.c(localAIOFilePictureData, 18);
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
    if (this.l.imageView != null)
    {
      Object localObject = this.l.imageView.getCurrentMatrixRectF();
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
    ImageButton localImageButton = this.x;
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
    ImageButton localImageButton = this.x;
    if (localImageButton != null) {
      localImageButton.setEnabled(paramBoolean);
    }
  }
  
  public boolean l()
  {
    Object localObject = this.B;
    boolean bool2 = false;
    int i;
    if ((!((Intent)localObject).getBooleanExtra("extra.FROM_AIO", false)) && (ParamsManager.a().o() != 3) && (ParamsManager.a().o() != 2)) {
      i = 0;
    } else {
      i = 1;
    }
    localObject = this.B.getExtras();
    boolean bool1;
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
    return bool1;
  }
  
  public void m()
  {
    AIOFilePictureData localAIOFilePictureData = this.k.r();
    if (localAIOFilePictureData != null)
    {
      Object localObject = this.C;
      if ((localObject != null) && (((IProvider)localObject).c()))
      {
        if (!NetworkUtil.isNetSupport(this.c))
        {
          QQToast.makeText(this.c, this.c.getString(2131915742), 0).show();
          a();
          return;
        }
        if (localAIOFilePictureData.r)
        {
          QQToast.makeText(this.c, this.c.getString(2131915734), 0).show();
          a();
          return;
        }
        if (localAIOFilePictureData.t) {
          a();
        }
        long l1 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
        if ((localAIOFilePictureData.s > l1) && (AppNetConnInfo.isMobileConn())) {
          try
          {
            ((IFileDepend)QRoute.api(IFileDepend.class)).showFlowDialog(false, this.c, new AIOFilePictureView.1(this, localAIOFilePictureData));
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
        this.k.a(localThrowable.a, localThrowable.b, 3);
        this.C.a(localThrowable.a, localThrowable.b, 20);
        if (this.l.imageView != null)
        {
          this.l.imageView.setDoubleTapEnable(true);
          this.l.imageView.setScaleEnable(true);
        }
        h();
        this.k.g().b();
        a();
      }
    }
  }
  
  void n()
  {
    AIOFilePictureData localAIOFilePictureData = this.k.r();
    if (localAIOFilePictureData != null)
    {
      AIOFilePictureModel localAIOFilePictureModel = new AIOFilePictureModel();
      Object localObject2 = localAIOFilePictureModel.c(localAIOFilePictureData, 20);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOFilePictureModel.c(localAIOFilePictureData, 18);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOFilePictureModel.c(localAIOFilePictureData, 16);
      }
      if (localObject2 == null) {
        return;
      }
      this.y = ((File)localObject2).getAbsolutePath();
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
      if (q())
      {
        localObject1 = this.C;
        if (localObject1 != null)
        {
          localObject1 = ((IProvider)localObject1).c(localAIOFilePictureData.a, localAIOFilePictureData.b, ParamsManager.a().i());
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
      if ((this.c instanceof Activity)) {
        ((IFileDepend)QRoute.api(IFileDepend.class)).startEditPicActivity((Activity)this.c, i, bool1, bool2, j, ((File)localObject2).getAbsolutePath(), ParamsManager.a().i(), (ForwardFileInfo)localObject1);
      }
      ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
    }
  }
  
  public void o()
  {
    if (this.g != null)
    {
      this.g = ((RelativeLayout)this.g.findViewById(2131440296));
      this.o = ((RelativeLayout)this.g.findViewById(2131445235));
      this.p = ((TextView)this.g.findViewById(2131440762));
      this.q = ((ImageView)this.g.findViewById(2131430821));
      this.r = ((SeekBar)this.g.findViewById(2131445502));
      this.s = ((TextView)this.g.findViewById(2131432775));
      this.t = ((ImageView)this.g.findViewById(2131437653));
      this.q.setOnClickListener(this);
      this.x = ((ImageButton)this.g.findViewById(2131442311));
      this.x.setOnClickListener(this);
      this.w = ((TextView)this.g.findViewById(2131442314));
      this.w.setOnClickListener(this);
      h(l());
      this.f = ((ImageButton)this.g.findViewById(2131442307));
      if (this.f != null) {
        this.f.setOnClickListener(this);
      }
      this.e = ((ImageButton)this.g.findViewById(2131442309));
      if (this.e != null) {
        this.e.setOnClickListener(this);
      }
      this.d = ((ImageButton)this.g.findViewById(2131442310));
      this.d.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.d;
      }
    }
    Object localObject = this.l;
    if ((localObject != null) && (!((PictureView)localObject).isInExitAnim)) {
      f(true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131437976)
    {
      localObject = this.k.c.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 102)) {
        this.k.j();
      }
    }
    else if (i == 2131430821)
    {
      localObject = this.k.r();
      if (localObject != null)
      {
        IProvider localIProvider = this.C;
        if (localIProvider != null) {
          localIProvider.b(((AIOFilePictureData)localObject).a, ((AIOFilePictureData)localObject).b, 20);
        }
        this.k.a(((AIOFilePictureData)localObject).a, ((AIOFilePictureData)localObject).b, 0);
        a();
      }
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
      if (this.k.a != null) {
        this.k.a.h();
      }
    }
    else if (i == 2131442309)
    {
      e();
    }
    else if (i == 2131442307)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryFilePicView", 2, "onClick qq_gallery_danmaku_view ");
      }
      localObject = this.k.r();
      if ((localObject != null) && ((this.c instanceof Activity))) {
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.c, ParamsManager.a().i(), ParamsManager.a().e(), false, ((AIOFilePictureData)localObject).e, 0L);
      }
      this.k.q();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismissOperations()
  {
    this.k.c.updateSystemUIVisablity();
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    Looper.myQueue().addIdleHandler(this.z);
    f(true);
    a();
  }
  
  public void onEnterAnimationStart()
  {
    f(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFilePictureView
 * JD-Core Version:    0.7.0.1
 */