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
  public long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AIOPictureView.9(this);
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public IProvider a;
  private AIOPicturePresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
  public AIOPictureView.OnTroopThumbListener a;
  public PictureView a;
  public Runnable a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public ImageView b;
  public RelativeLayout b;
  public TextView b;
  public String b;
  public boolean b;
  public int c;
  public TextView c;
  public boolean c;
  private int d;
  public ImageButton d;
  public TextView d;
  
  public AIOPictureView(Context paramContext, AIOPicturePresenter paramAIOPicturePresenter)
  {
    super(paramContext, paramAIOPicturePresenter);
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter = paramAIOPicturePresenter;
  }
  
  private URLDrawable a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, File paramFile, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
    Object localObject = paramAIOPictureModel.a(paramAIOPictureData, 1);
    URLDrawable localURLDrawable = null;
    if (localObject != null)
    {
      localObject = URLDrawable.getFileDrawable(paramAIOPictureData.jdField_a_of_type_JavaLangString, null);
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
    localObject = paramAIOPictureModel.a(paramAIOPictureData, 4);
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
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setGalleryImageListener(new AIOPictureView.10(this, paramRichMediaBrowserInfo, paramFile, paramAIOPictureModel, paramAIOPictureData));
    this.jdField_a_of_type_JavaLangRunnable = RichMediaBrowserUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, paramAIOPictureModel);
    if ((this.jdField_a_of_type_JavaLangRunnable == null) && (paramAIOPictureModel.getStatus() == 1)) {
      a(paramRichMediaBrowserInfo, paramFile, paramAIOPictureModel, paramInt);
    } else {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOPictureModel, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(paramAIOPictureModel.getExifOrientation()));
    }
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageDrawable(paramAIOPictureModel);
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
    localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
    localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_Int;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mUseExifOrientation = false;
    localURLDrawableOptions.mDecodeFileStrategy = 2;
    paramFile1 = null;
    if (i != 0)
    {
      paramRichMediaBrowserInfo = paramAIOPictureModel.a(paramAIOPictureData, 4);
    }
    else
    {
      paramAIOPictureModel = paramAIOPictureModel.a(paramAIOPictureData, 2);
      paramRichMediaBrowserInfo = paramAIOPictureModel;
      if (paramAIOPictureData.g)
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
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramAIOPictureModel);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageDrawable(paramAIOPictureModel);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOPictureModel, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(i));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, true);
      return paramAIOPictureModel;
    }
    if ((!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView))) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
    }
    a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
    return paramAIOPictureModel;
  }
  
  private void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if (localObject != null) {
      ((IProvider)localObject).a("Pic_Forward_Contacts", 0);
    }
    localObject = new AIOPicturePresenter.ActionSheetForwardActionInfo();
    ((AIOPicturePresenter.ActionSheetForwardActionInfo)localObject).jdField_a_of_type_Int = paramInt;
    if (paramInt == 72)
    {
      ((AIOPicturePresenter.ActionSheetForwardActionInfo)localObject).jdField_a_of_type_JavaLangString = paramActionSheetItem.uin;
      ((AIOPicturePresenter.ActionSheetForwardActionInfo)localObject).jdField_b_of_type_Int = paramActionSheetItem.uinType;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      AIOPicturePresenter localAIOPicturePresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      paramInt = ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType();
      if (this.jdField_b_of_type_Boolean) {
        paramActionSheetItem = "biz_src_jc_groupgif";
      } else {
        paramActionSheetItem = "biz_src_jc_photo";
      }
      localAIOPicturePresenter.a(paramRichMediaBrowserInfo, localActivity, (AIOPicturePresenter.ActionSheetForwardActionInfo)localObject, paramInt, paramActionSheetItem);
      if (this.jdField_b_of_type_Boolean) {
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
      }
    }
    if ((ParamsManager.a().d()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null))
    {
      paramActionSheetItem = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
      AIOBrowserPresenter.a("0X8009ABA");
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if (localIProvider != null) {
      localIProvider.a(paramLong, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramLong, paramInt1, 1);
  }
  
  private void a(Uri paramUri, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if ((((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) || (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView == null)) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      this.jdField_a_of_type_JavaLangString = ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).checkQQCode(paramUri, paramArrayList, (Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet);
    }
  }
  
  private void a(AIOPictureData paramAIOPictureData)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet add to favorite.");
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealAddToEmotion(paramAIOPictureData, (Activity)this.jdField_a_of_type_AndroidContentContext);
    }
    if (this.jdField_b_of_type_Boolean) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
    }
  }
  
  private void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    Object localObject3 = new AIOPictureModel();
    Object localObject2 = ((AIOPictureModel)localObject3).a(paramAIOPictureData, 4);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ((AIOPictureModel)localObject3).a(paramAIOPictureData, 2);
    }
    if ((localObject1 == null) && (ParamsManager.a().b())) {
      return;
    }
    if (localObject1 != null) {
      this.jdField_b_of_type_JavaLangString = ((File)localObject1).getPath();
    }
    localObject2 = ActionSheet.createMenuSheet(this.jdField_a_of_type_AndroidContentContext);
    if (UinTypeUtil.a(ParamsManager.a().a()) != 1032)
    {
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      if (localObject1 != null) {
        a((ArrayList)localObject2, paramAIOPictureData, (File)localObject1, (ArrayList)localObject3, (File)localObject1);
      } else if ((!ParamsManager.a().d()) && (ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c())) && (UinTypeUtil.a(ParamsManager.a().a()) != 1044)) {
        RichMediaBrowserUtils.a(54, (ArrayList)localObject3);
      }
      if ((paramAIOPictureData.jdField_d_of_type_Int == 4) && (!this.jdField_b_of_type_Boolean) && (!paramAIOPictureData.jdField_j_of_type_Boolean)) {
        RichMediaBrowserUtils.a(66, (ArrayList)localObject3);
      }
      a(paramAIOPictureData, paramRichMediaBrowserInfo, (File)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidContentIntent;
      if (localObject1 != null)
      {
        if (this.jdField_b_of_type_Boolean) {
          paramAIOPictureData = "biz_src_jc_groupgif";
        } else {
          paramAIOPictureData = "biz_src_jc_photo";
        }
        ((Intent)localObject1).putExtra("big_brother_source_key", paramAIOPictureData);
      }
      if ((UinTypeUtil.a(ParamsManager.a().a()) != 1044) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        paramAIOPictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
        if (paramAIOPictureData == null) {
          paramAIOPictureData = null;
        } else {
          paramAIOPictureData = paramAIOPictureData.a(paramRichMediaBrowserInfo, (Activity)this.jdField_a_of_type_AndroidContentContext);
        }
        if (paramAIOPictureData != null)
        {
          paramAIOPictureData.putExtra("key_new_img_shareactionsheet", 1);
          paramAIOPictureData.putExtra(((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getShowDataLine(), true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOPictureData);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(null);
          QLog.e("AIOPictureView", 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, (List)localObject3);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
    }
    a((ActionSheet)localObject2, (File)localObject1);
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData)
  {
    if ((paramRichMediaBrowserInfo != null) && ((paramRichMediaBrowserInfo.baseData instanceof AIOPictureData)))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)paramRichMediaBrowserInfo.baseData;
      if ((localAIOPictureData.getType() == 100) && (localAIOPictureData.jdField_a_of_type_Long == paramAIOPictureData.jdField_a_of_type_Long) && (localAIOPictureData.jdField_a_of_type_Int == paramAIOPictureData.jdField_a_of_type_Int) && (!paramRichMediaBrowserInfo.isReport))
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
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageDrawable(paramURLDrawable);
    paramRichMediaBrowserInfo = paramAIOPictureModel.a(paramAIOPictureData, 4);
    String str = paramURLDrawable.getURL().toString();
    if (str.equals(paramRichMediaBrowserInfo)) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setOriginalImage(true);
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
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramURLDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(i));
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.isOriginalImage()) {
      paramRichMediaBrowserInfo = paramAIOPictureData.jdField_c_of_type_JavaLangString;
    } else {
      paramRichMediaBrowserInfo = paramAIOPictureData.jdField_b_of_type_JavaLangString;
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
    if (paramAIOPictureData.g)
    {
      paramRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if (paramRichMediaBrowserInfo != null) {
        paramRichMediaBrowserInfo.a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
      }
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    try
    {
      paramRichMediaBrowserInfo = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        paramRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(paramRichMediaBrowserInfo.jdField_a_of_type_Long, paramRichMediaBrowserInfo.jdField_a_of_type_Int);
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealAddFavorite((Activity)this.jdField_a_of_type_AndroidContentContext, paramRichMediaBrowserInfo, paramFile.getAbsolutePath(), ParamsManager.a().d());
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_AndroidContentContext.getString(2131718245), 0).a();
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
    paramRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramURLDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, BrowserUtils.a(i));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, true);
    }
  }
  
  private void a(ActionSheet paramActionSheet, File paramFile)
  {
    if ((UinTypeUtil.a(ParamsManager.a().a()) == 1032) && (paramFile != null)) {
      paramActionSheet.addButton(2131718244);
    }
    paramActionSheet.addCancelButton(2131718236);
    paramActionSheet.setOnButtonClickListener(new AIOPictureView.4(this, paramActionSheet));
    paramActionSheet.show();
    paramActionSheet.registerWatchDisMissActionListener(this);
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, AIOPictureData paramAIOPictureData, File paramFile1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if (UinTypeUtil.a(ParamsManager.a().a()) != 1044) {
      RichMediaBrowserUtils.a(2, paramArrayList1);
    }
    if (UinTypeUtil.a(ParamsManager.a().a()) != 1044)
    {
      if (paramAIOPictureData.jdField_e_of_type_JavaLangString != null) {
        RichMediaBrowserUtils.a(50, paramArrayList1);
      }
      if ((this.jdField_a_of_type_Boolean) && (paramAIOPictureData.jdField_e_of_type_JavaLangString != null)) {
        RichMediaBrowserUtils.a(51, paramArrayList1);
      }
    }
    RichMediaBrowserUtils.a(27, paramArrayList1);
    if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isPicShareToWXEnable()) && (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isFileSizeEnable(paramFile1))) {
      RichMediaBrowserUtils.a(9, paramArrayList1);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      RichMediaBrowserUtils.a(48, paramArrayList2);
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if (!((IBrowserDepend)QRoute.api(IBrowserDepend.class)).saveImageNeedBlock()) {
      RichMediaBrowserUtils.a(39, paramArrayList2);
    }
    if (!this.jdField_b_of_type_Boolean) {
      RichMediaBrowserUtils.a(6, paramArrayList2);
    }
    if (UinTypeUtil.a(ParamsManager.a().a()) != 1044)
    {
      if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c())) && (!ParamsManager.a().d())) {
        RichMediaBrowserUtils.a(54, paramArrayList2);
      }
      if (this.jdField_c_of_type_Boolean) {
        RichMediaBrowserUtils.a(52, paramArrayList2);
      }
      ThreadManager.getFileThreadHandler().post(new AIOPictureView.3(this, paramFile2, paramArrayList2));
    }
  }
  
  private boolean a(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealThumbImage()");
    Object localObject2 = new AIOPictureModel();
    if (((AIOPictureModel)localObject2).a(paramAIOPictureData, 1) != null)
    {
      Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelperConstants.a;
      localObject2 = ((AIOPictureModel)localObject2).a(paramAIOPictureData, 1);
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
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOPictureData, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
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
    if (localAIOPictureModel.a(paramAIOPictureData, 8) != null)
    {
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelperConstants.a;
      ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
      Object localObject1 = null;
      try
      {
        localObject2 = URLDrawable.getDrawable(localAIOPictureModel.a(paramAIOPictureData, 8), (URLDrawable.URLDrawableOptions)localObject2);
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
        paramBrowserScaleView.initDrawable((Drawable)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set temp image");
        return true;
      }
      paramBrowserScaleView = BrowserLogHelper.getInstance().getGalleryLog();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getView(): url is ");
      ((StringBuilder)localObject1).append(localAIOPictureModel.a(paramAIOPictureData, 8));
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
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealPicForwardToGroupAlbum(paramAIOPictureData, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider);
    }
  }
  
  private void b(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    if ((!PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext)) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, null);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if (localObject != null) {
      ((IProvider)localObject).a("Pic_save", 0);
    }
    localObject = new AIOPictureModel();
    if ((((AIOPictureModel)localObject).a(paramAIOPictureData, 4) == null) && (((AIOPictureModel)localObject).a(paramAIOPictureData, 4)) && (AppNetConnInfo.isNetSupport()))
    {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOPictureData.jdField_c_of_type_Long > 29360128L))
      {
        a(100, paramAIOPictureData, paramRichMediaBrowserInfo);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramAIOPictureData);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 4);
        a();
        f();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().b();
      }
    }
    else if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramAIOPictureData = (IBrowserDepend)QRoute.api(IBrowserDepend.class);
      paramRichMediaBrowserInfo = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
      ((StringBuilder)localObject).append(NetConnInfoCenter.getServerTime());
      paramAIOPictureData.savePic(paramRichMediaBrowserInfo, paramFile, Utils.Crc64String(((StringBuilder)localObject).toString()));
    }
    if (this.jdField_b_of_type_Boolean) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
    }
    if ((ParamsManager.a().d()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null))
    {
      paramAIOPictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
      AIOBrowserPresenter.a("0X8009ABB");
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "ACTION_GALLERY_PIC_SAVE");
  }
  
  private boolean b(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
    if ((!paramAIOPictureData.f) && (!paramAIOPictureData.jdField_e_of_type_Boolean) && (!paramAIOPictureData.jdField_d_of_type_Boolean)) {
      return false;
    }
    paramAIOPictureData = BaseApplication.getContext().getResources().getDrawable(2130849901);
    paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
    this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.initDrawable(paramAIOPictureData, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), false);
    return true;
  }
  
  private void c(AIOPictureData paramAIOPictureData)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet share weiyun.");
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).dealSendToWeiYun(paramAIOPictureData);
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
      return;
    }
    if (paramAIOPictureData.jdField_a_of_type_Long > 0L)
    {
      IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if ((localIProvider != null) && (localIProvider.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(paramAIOPictureData.jdField_a_of_type_Long);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131718234), 0).a();
      }
    }
  }
  
  private void d(AIOPictureData paramAIOPictureData)
  {
    String str2 = ParamsManager.a().a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ParamsManager.a().c();
    }
    ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", ParamsManager.a().c(), 0, "", "", "", "");
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).jumpToTargetAIOPosition((Activity)this.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().c(), str1, paramAIOPictureData.jdField_b_of_type_Long, paramAIOPictureData.jdField_d_of_type_Long, paramAIOPictureData.jdField_b_of_type_Int, false);
    }
  }
  
  private void e(AIOPictureData paramAIOPictureData)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider != null))
    {
      if (paramAIOPictureData.jdField_k_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(ParamsManager.a().a(), true, paramAIOPictureData.jdField_k_of_type_JavaLangString, paramAIOPictureData.jdField_j_of_type_JavaLangString, localAppRuntime.getAccount(), paramAIOPictureData.l);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(ParamsManager.a().a(), false, paramAIOPictureData.i, paramAIOPictureData.jdField_j_of_type_JavaLangString, localAppRuntime.getAccount(), paramAIOPictureData.l);
    }
  }
  
  private void f(AIOPictureData paramAIOPictureData)
  {
    if ((!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView))) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
    }
    a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
  }
  
  private void g(AIOPictureData paramAIOPictureData)
  {
    if ((!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) && (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView))) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
    }
    a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
  }
  
  private void h(AIOPictureData paramAIOPictureData)
  {
    if (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView)) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
    }
  }
  
  private void n()
  {
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && (new AIOPictureModel().a(localAIOPictureData, 4)))
    {
      if (localAIOPictureData.jdField_c_of_type_Long > 0L)
      {
        a(String.format(Locale.CHINA, this.jdField_a_of_type_AndroidContentContext.getString(2131718255), new Object[] { FileSizeFormat.a(localAIOPictureData.jdField_c_of_type_Long) }));
        return;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131718252));
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPictureView", 2, "onClick qq_gallery_danmaku_view ");
    }
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().a(), false, localAIOPictureData.jdField_d_of_type_Long, 0L);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.i();
  }
  
  private void p()
  {
    AIOPictureData localAIOPictureData = a();
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
            localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
            if (localIProvider != null) {
              localIProvider.b(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 24);
            }
          }
        }
        else
        {
          localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
          if (localIProvider != null) {
            localIProvider.b(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 4);
          }
        }
      }
      else
      {
        localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
        if (localIProvider != null) {
          localIProvider.b(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 0);
      a();
    }
  }
  
  private void q()
  {
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && (!TextUtils.isEmpty(localAIOPictureData.m)) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      ((IJumpUtil)QRoute.api(IJumpUtil.class)).jumpToCameraActivityForAio((Activity)this.jdField_a_of_type_AndroidContentContext, localAIOPictureData.m);
      ReportController.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", localAIOPictureData.m, "");
    }
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562763, null));
    l();
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.controlViewContainer != null) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.controlViewContainer.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    return this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView;
  }
  
  public AIOPictureData a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a != null))
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100)) {
        return (AIOPictureData)localRichMediaBrowserInfo.baseData;
      }
    }
    return null;
  }
  
  public void a()
  {
    AIOPictureData localAIOPictureData = a();
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
              localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView;
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
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
            g(false);
            c(false);
            d(false);
            h(false);
            this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPictureData.progress / 100);
            localObject = this.jdField_a_of_type_AndroidWidgetTextView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131718262));
            localStringBuilder.append(localAIOPictureData.progress / 100);
            localStringBuilder.append("%");
            ((TextView)localObject).setText(localStringBuilder.toString());
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
          g(false);
          c(false);
          d(false);
          h(false);
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPictureData.progress / 100);
          localObject = this.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131718238));
          localStringBuilder.append(localAIOPictureData.progress / 100);
          localStringBuilder.append("%");
          ((TextView)localObject).setText(localStringBuilder.toString());
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          return;
        }
        g(false);
        c(false);
        h(false);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), localAIOPictureData.progress);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      c(b());
      d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem()));
      h(c());
      j(true);
      Object localObject = new AIOPictureModel();
      if ((((AIOPictureModel)localObject).a(localAIOPictureData, 2) == null) && (((AIOPictureModel)localObject).a(localAIOPictureData, 4) == null)) {
        i(false);
      } else {
        i(true);
      }
      if ((((AIOPictureModel)localObject).a(localAIOPictureData, 4)) && (((AIOPictureModel)localObject).a(localAIOPictureData, 4) == null))
      {
        g(true);
        return;
      }
      g(false);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if (localObject2 != null)
    {
      if ((((RichMediaBrowserInfo)localObject2).baseData == null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView == null)) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 100)
      {
        localObject1 = (AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData;
        Object localObject3 = new AIOPictureModel();
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(), (AIOPictureData)localObject1);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setOnItemEventListener(this);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setPosition(paramInt);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setImageInfo((RichMediaBrowserInfo)localObject2);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setIgnoreLayout(false);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131718251));
        Object localObject4 = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
        if ((localObject4 != null) && (((URLDrawable)localObject4).getStatus() == 1))
        {
          a((RichMediaBrowserInfo)localObject2, (AIOPictureData)localObject1, (AIOPictureModel)localObject3, (URLDrawable)localObject4);
        }
        else
        {
          localObject4 = ((AIOPictureModel)localObject3).a((AIOPictureData)localObject1, 4);
          if (localObject4 != null)
          {
            a((RichMediaBrowserInfo)localObject2, (AIOPictureData)localObject1, (AIOPictureModel)localObject3, (File)localObject4, paramInt);
          }
          else
          {
            File localFile = ((AIOPictureModel)localObject3).a((AIOPictureData)localObject1, 2);
            if (localFile != null)
            {
              a((RichMediaBrowserInfo)localObject2, (AIOPictureData)localObject1, (AIOPictureModel)localObject3, (File)localObject4, localFile, paramInt);
            }
            else if (((AIOPictureModel)localObject3).a((AIOPictureData)localObject1, 8) != null)
            {
              f((AIOPictureData)localObject1);
            }
            else if (((AIOPictureModel)localObject3).a((AIOPictureData)localObject1, 1) != null)
            {
              g((AIOPictureData)localObject1);
            }
            else if ((!((AIOPictureData)localObject1).f) && (!((AIOPictureData)localObject1).jdField_e_of_type_Boolean) && (!((AIOPictureData)localObject1).jdField_d_of_type_Boolean))
            {
              BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): No pic");
              a(this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView);
              a(((AIOPictureData)localObject1).jdField_a_of_type_Long, ((AIOPictureData)localObject1).jdField_a_of_type_Int, 2);
            }
            else
            {
              h((AIOPictureData)localObject1);
            }
          }
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((AIOPictureData)localObject1).jdField_a_of_type_Long);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(((AIOPictureData)localObject1).jdField_a_of_type_Int);
        localObject2 = ((StringBuilder)localObject2).toString();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject2))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
          if (localObject3 != null)
          {
            ((IProvider)localObject3).a(((AIOPictureData)localObject1).jdField_a_of_type_Long, ((AIOPictureData)localObject1).jdField_a_of_type_Int);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setMainBrowserPresenter(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter);
      Object localObject1 = new AIOPictureView.GalleryPictureViewHolder(this);
      ((AIOPictureView.GalleryPictureViewHolder)localObject1).a = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView.setTag(localObject1);
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable != null))
    {
      paramView = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (paramView != null)
      {
        if (paramView.getStatus() == 0) {
          paramView.cancelDownload(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.remove(Integer.valueOf(paramInt));
      }
    }
    if (paramInt == this.jdField_d_of_type_Int)
    {
      paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((paramView != null) && (paramView.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_d_of_type_Int = -1;
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131718260), this.jdField_a_of_type_AndroidContentContext.getString(2131718259), new AIOPictureView.7(this, paramInt, paramObject), new AIOPictureView.8(this)));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
      if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView != null) && ((this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView.getTag() instanceof AIOPictureView.GalleryPictureViewHolder)))
      {
        Object localObject3 = ((AIOPictureView.GalleryPictureViewHolder)this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.mBrowserItemView.getTag()).a;
        AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
        localObject1 = new AIOPictureModel();
        Object localObject2;
        if (localAIOPictureData.jdField_e_of_type_Boolean)
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
            localObject1 = BaseApplication.getContext().getResources().getDrawable(2130849901);
            ((BrowserScaleView)localObject3).setImageDrawable((Drawable)localObject1);
            ((BrowserScaleView)localObject3).initDrawable((Drawable)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, false);
          }
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
          return;
        }
        if (((AIOPictureModel)localObject1).a(localAIOPictureData, 2) != null)
        {
          localObject2 = ((AIOPictureModel)localObject1).a(localAIOPictureData, 2);
          localObject1 = localObject2;
          if (paramBoolean)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("#PART");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          a(paramInt);
          localObject2 = FileUtils.estimateFileType(localAIOPictureData.jdField_b_of_type_JavaLangString);
          localObject3 = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("AIOGalleryAdapter.updateView(): Update large image, position=");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("url = ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(",extName = ");
          localStringBuilder.append((String)localObject2);
          ((IBrowserLog)localObject3).d("AIOPictureView", 4, localStringBuilder.toString());
          localAIOPictureData.g = paramBoolean;
          return;
        }
        if (((AIOPictureModel)localObject1).a(localAIOPictureData, 1) != null)
        {
          localObject1 = URLDrawable.getDrawable(((AIOPictureModel)localObject1).a(localAIOPictureData, 1), URLDrawable.URLDrawableOptions.obtain());
          ((BrowserScaleView)localObject3).setImageDrawable((Drawable)localObject1);
          ((BrowserScaleView)localObject3).initDrawable((Drawable)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOPictureData localAIOPictureData = a();
    if (localAIOPictureData != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if (localObject != null)
      {
        int i = ((IProvider)localObject).a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int);
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
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.b(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 24);
        }
      }
    }
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
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
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      this.jdField_a_of_type_Boolean = paramIntent.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
      this.jdField_c_of_type_Int = paramIntent.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
      this.jdField_b_of_type_Boolean = paramIntent.getBoolean("group.emo.big.preview", false);
      this.jdField_c_of_type_Boolean = paramIntent.getBoolean("extra.OCR", false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider))) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a());
    }
    a(new AIOPictureView.1(this));
  }
  
  public void a(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOPictureView.5(this, paramAIOPictureData, paramRichMediaBrowserInfo, paramFile));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new AIOPictureView.6(this));
  }
  
  public void a(AIOPictureView.OnTroopThumbListener paramOnTroopThumbListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserViewAIOPictureView$OnTroopThumbListener = paramOnTroopThumbListener;
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
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void b()
  {
    super.b();
    m();
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
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.getDrawable();
      AIOPictureData localAIOPictureData = a();
      if ((!this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.isOriginalImage()) && (localAIOPictureData != null) && ((localDrawable instanceof SkinnableBitmapDrawable)) && (localAIOPictureData.jdField_b_of_type_Int == 1) && (localAIOPictureData.jdField_c_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()))
      {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setDoubleTapEnable(false);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView.imageView.setScaleEnable(false);
      }
    }
    a();
  }
  
  public boolean b()
  {
    if (super.b())
    {
      AIOPictureData localAIOPictureData = a();
      if (localAIOPictureData != null)
      {
        AIOPictureModel localAIOPictureModel = new AIOPictureModel();
        File localFile2 = localAIOPictureModel.a(localAIOPictureData, 4);
        File localFile1 = localFile2;
        if (localFile2 == null) {
          localFile1 = localAIOPictureModel.a(localAIOPictureData, 2);
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
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
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
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentIntent;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      int i;
      if ((!((Intent)localObject).getBooleanExtra("extra.FROM_AIO", false)) && (ParamsManager.a().c() != 3) && (ParamsManager.a().c() != 2) && (ParamsManager.a().c() != 6)) {
        i = 0;
      } else {
        i = 1;
      }
      localObject = this.jdField_a_of_type_AndroidContentIntent.getExtras();
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
    }
    return bool1;
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().jdField_a_of_type_Boolean = false;
      return;
    }
    f(false);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().g();
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        n();
      }
      TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
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
    AIOPictureData localAIOPictureData = a();
    IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if ((localIProvider != null) && (localAIOPictureData != null) && (localIProvider.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 3);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 4);
      a();
      f();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().b();
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      AIOPictureData localAIOPictureData = a();
      int j = 0;
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localAIOPictureData != null)
        {
          i = j;
          if (!ParamsManager.a().f())
          {
            i = j;
            if (!ParamsManager.a().d())
            {
              i = j;
              if (((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
              {
                i = j;
                if (((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).isAEPituTakeSameOpen())
                {
                  long l = localAIOPictureData.jdField_a_of_type_Long;
                  i = j;
                  if (!TextUtils.isEmpty(localAIOPictureData.m))
                  {
                    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131718235);
                    if (!TextUtils.isEmpty(localAIOPictureData.n)) {
                      str = localAIOPictureData.n;
                    }
                    this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
                    j = 1;
                    i = j;
                    if (this.jdField_a_of_type_Long != l)
                    {
                      ReportController.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", localAIOPictureData.m, "");
                      this.jdField_a_of_type_Long = l;
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
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  void k()
  {
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      Object localObject2 = localAIOPictureModel.a(localAIOPictureData, 4);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOPictureModel.a(localAIOPictureData, 2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOPictureModel.a(localAIOPictureData, 1);
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
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).startEditPicActivity((Activity)this.jdField_a_of_type_AndroidContentContext, i, bool1, bool2, j, ((File)localObject2).getAbsolutePath(), ParamsManager.a().a());
      ReportController.b(null, "dc00898", "", "", "0X8007ACE", "0X8007ACE", 0, 0, "", "", "", "");
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376889));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373153));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364715));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377129));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131366457));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370386));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364256));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364257));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374212));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374216));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374214));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374219));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374215));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
        d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem()));
      }
      h(c());
      c(b());
    }
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewPicPictureView;
    if ((localObject != null) && (!((PictureView)localObject).isInExitAnim)) {
      f(true);
    }
  }
  
  public void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
    if ((localObject != null) && (((AIOPicturePresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_d_of_type_Int = -1;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370699)
    {
      if (a().jdField_c_of_type_Int == 3) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.d();
      }
    }
    else if (i == 2131364715)
    {
      p();
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
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.f();
      }
    }
    else if (i == 2131374214)
    {
      d();
    }
    else if (i == 2131374212)
    {
      o();
    }
    else if (i == 2131364256)
    {
      Object localObject;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        localObject = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (!PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
            ((BaseActivity)localObject).requestPermissions(new AIOPictureView.2(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          } else {
            q();
          }
        }
        else {
          q();
        }
      }
      else
      {
        localObject = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick, activity:");
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
        ((IBrowserLog)localObject).d("AIOPictureView", 2, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDismissOperations()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.updateSystemUIVisablity();
    }
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
    super.onEnterAnimationStart();
    f(false);
    j(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView
 * JD-Core Version:    0.7.0.1
 */