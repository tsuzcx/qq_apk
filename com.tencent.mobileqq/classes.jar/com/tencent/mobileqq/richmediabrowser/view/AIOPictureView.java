package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
import android.support.v4.util.MQLruCache;
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
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOPicturePresenter.ActionSheetForwardActionInfo;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.richmediabrowser.utils.GalleryJumpUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
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
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.WatchDismissActions;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AIOPictureView
  extends AIOBrowserBaseView
  implements View.OnClickListener, IBrowserItemEventListener, ActionSheet.WatchDismissActions
{
  public int a;
  public long a;
  MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new AIOPictureView.12(this);
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private AIOPicturePresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
  public AIOPictureView.OnTroopThumbListener a;
  public BrowserScaleView a;
  public Runnable a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  private int b;
  public ImageView b;
  public RelativeLayout b;
  public TextView b;
  public String b;
  public boolean b;
  public TextView c;
  public boolean c;
  public ImageButton d;
  public TextView d;
  
  public AIOPictureView(Activity paramActivity, AIOPicturePresenter paramAIOPicturePresenter)
  {
    super(paramActivity, paramAIOPicturePresenter);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter = paramAIOPicturePresenter;
  }
  
  private URLDrawable a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, File paramFile, int paramInt)
  {
    URLDrawable localURLDrawable = null;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.mScreenWidthPx;
    localURLDrawableOptions.mRequestHeight = this.mScreenHeightPx;
    Object localObject;
    if (paramAIOPictureModel.a(paramAIOPictureData, 1) != null)
    {
      localObject = URLDrawable.getFileDrawable(paramAIOPictureData.jdField_a_of_type_JavaLangString, null);
      ((URLDrawable)localObject).downloadImediatly();
    }
    for (localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);; localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "TYPE_ORIGINAL_IMAGE");
      localURLDrawableOptions.mPlayGifImage = true;
      localURLDrawableOptions.mUseExifOrientation = false;
      localURLDrawableOptions.mDecodeFileStrategy = 2;
      if ((paramAIOPictureData.jdField_d_of_type_Int == 1) && ((paramAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
        localURLDrawableOptions.mUseAutoScaleParams = false;
      }
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
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "[getView] URLDrawable.getDrawable failed.");
          continue;
          this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramAIOPictureModel, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getRotation(paramRichMediaBrowserInfo.orientation));
        }
      }
      paramFile = paramFile.getAbsolutePath();
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setGalleryImageListener(new AIOPictureView.13(this, paramRichMediaBrowserInfo, paramFile, paramAIOPictureModel, paramAIOPictureData));
      this.jdField_a_of_type_JavaLangRunnable = AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, paramAIOPictureModel);
      if ((this.jdField_a_of_type_JavaLangRunnable != null) || (paramAIOPictureModel.getStatus() != 1)) {
        break;
      }
      a(paramRichMediaBrowserInfo, paramFile, paramAIOPictureModel, paramInt);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable(paramAIOPictureModel);
      return paramAIOPictureModel;
    }
  }
  
  /* Error */
  private URLDrawable a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, File paramFile1, File paramFile2, int paramInt)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +207 -> 209
    //   5: iconst_1
    //   6: istore 7
    //   8: invokestatic 73	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   11: astore 8
    //   13: aload 8
    //   15: aload_0
    //   16: getfield 76	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:mScreenWidthPx	I
    //   19: putfield 79	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   22: aload 8
    //   24: aload_0
    //   25: getfield 82	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:mScreenHeightPx	I
    //   28: putfield 85	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   31: aload 8
    //   33: getstatic 203	com/tencent/mobileqq/transfile/URLDrawableHelper:TRANSPARENT	Landroid/graphics/drawable/Drawable;
    //   36: putfield 107	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   39: aload 8
    //   41: iconst_1
    //   42: putfield 129	com/tencent/image/URLDrawable$URLDrawableOptions:mPlayGifImage	Z
    //   45: aload 8
    //   47: iconst_0
    //   48: putfield 132	com/tencent/image/URLDrawable$URLDrawableOptions:mUseExifOrientation	Z
    //   51: aload 8
    //   53: iconst_2
    //   54: putfield 135	com/tencent/image/URLDrawable$URLDrawableOptions:mDecodeFileStrategy	I
    //   57: aload_2
    //   58: getfield 137	com/tencent/mobileqq/richmediabrowser/model/AIOPictureData:jdField_d_of_type_Int	I
    //   61: iconst_1
    //   62: if_icmpne +19 -> 81
    //   65: aload_2
    //   66: getfield 140	com/tencent/mobileqq/richmediabrowser/model/AIOPictureData:jdField_f_of_type_Int	I
    //   69: iconst_2
    //   70: iand
    //   71: iconst_2
    //   72: if_icmpne +9 -> 81
    //   75: aload 8
    //   77: iconst_0
    //   78: putfield 143	com/tencent/image/URLDrawable$URLDrawableOptions:mUseAutoScaleParams	Z
    //   81: iload 7
    //   83: ifeq +132 -> 215
    //   86: aload_3
    //   87: aload_2
    //   88: iconst_4
    //   89: invokevirtual 146	com/tencent/mobileqq/richmediabrowser/model/AIOPictureModel:a	(Lcom/tencent/mobileqq/richmediabrowser/model/AIOPictureData;I)Ljava/lang/String;
    //   92: astore_3
    //   93: aload_3
    //   94: aload 8
    //   96: invokestatic 149	com/tencent/image/URLDrawable:getDrawable	(Ljava/lang/String;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   99: astore_3
    //   100: aload_3
    //   101: iconst_1
    //   102: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: invokevirtual 159	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   108: aload_3
    //   109: invokevirtual 103	com/tencent/image/URLDrawable:downloadImediatly	()V
    //   112: aload_3
    //   113: ifnull +212 -> 325
    //   116: aload_3
    //   117: invokevirtual 191	com/tencent/image/URLDrawable:getStatus	()I
    //   120: iconst_1
    //   121: if_icmpne +204 -> 325
    //   124: aload_1
    //   125: getfield 210	com/tencent/richmediabrowser/model/RichMediaBrowserInfo:orientation	I
    //   128: bipush 254
    //   130: if_icmpne +15 -> 145
    //   133: aload_1
    //   134: aload 5
    //   136: invokevirtual 165	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   139: invokestatic 229	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   142: putfield 210	com/tencent/richmediabrowser/model/RichMediaBrowserInfo:orientation	I
    //   145: aload_0
    //   146: getfield 63	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter	Lcom/tencent/mobileqq/richmediabrowser/presenter/AIOPicturePresenter;
    //   149: getfield 233	com/tencent/mobileqq/richmediabrowser/presenter/AIOPicturePresenter:mActiveDrawable	Ljava/util/concurrent/ConcurrentHashMap;
    //   152: iload 6
    //   154: invokestatic 155	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aload_3
    //   158: invokevirtual 239	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: aload_0
    //   163: getfield 167	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView	Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;
    //   166: aload_3
    //   167: invokevirtual 198	com/tencent/richmediabrowser/view/recyclerview/BrowserScaleView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   170: aload_0
    //   171: getfield 167	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView	Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;
    //   174: aload_3
    //   175: aload_0
    //   176: getfield 76	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:mScreenWidthPx	I
    //   179: aload_0
    //   180: getfield 82	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:mScreenHeightPx	I
    //   183: aload_0
    //   184: getfield 63	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter	Lcom/tencent/mobileqq/richmediabrowser/presenter/AIOPicturePresenter;
    //   187: aload_1
    //   188: getfield 210	com/tencent/richmediabrowser/model/RichMediaBrowserInfo:orientation	I
    //   191: invokevirtual 216	com/tencent/mobileqq/richmediabrowser/presenter/AIOPicturePresenter:getRotation	(I)I
    //   194: invokevirtual 220	com/tencent/richmediabrowser/view/recyclerview/BrowserScaleView:initDrawable	(Landroid/graphics/drawable/Drawable;III)V
    //   197: aload_0
    //   198: getfield 63	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter	Lcom/tencent/mobileqq/richmediabrowser/presenter/AIOPicturePresenter;
    //   201: iload 6
    //   203: iconst_1
    //   204: invokevirtual 243	com/tencent/mobileqq/richmediabrowser/presenter/AIOPicturePresenter:onLoadFinish	(IZ)V
    //   207: aload_3
    //   208: areturn
    //   209: iconst_0
    //   210: istore 7
    //   212: goto -204 -> 8
    //   215: aload_3
    //   216: aload_2
    //   217: iconst_2
    //   218: invokevirtual 146	com/tencent/mobileqq/richmediabrowser/model/AIOPictureModel:a	(Lcom/tencent/mobileqq/richmediabrowser/model/AIOPictureData;I)Ljava/lang/String;
    //   221: astore 4
    //   223: aload 4
    //   225: astore_3
    //   226: aload_2
    //   227: getfield 246	com/tencent/mobileqq/richmediabrowser/model/AIOPictureData:jdField_g_of_type_Boolean	Z
    //   230: ifeq -137 -> 93
    //   233: new 248	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   240: aload 4
    //   242: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc 255
    //   247: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore_3
    //   254: goto -161 -> 93
    //   257: astore_3
    //   258: aconst_null
    //   259: astore_3
    //   260: invokestatic 113	com/tencent/richmediabrowser/log/BrowserLogHelper:getInstance	()Lcom/tencent/richmediabrowser/log/BrowserLogHelper;
    //   263: invokevirtual 117	com/tencent/richmediabrowser/log/BrowserLogHelper:getGalleryLog	()Lcom/tencent/richmediabrowser/log/IBrowserLog;
    //   266: ldc 119
    //   268: iconst_4
    //   269: ldc 205
    //   271: invokeinterface 126 4 0
    //   276: goto -164 -> 112
    //   279: astore_2
    //   280: invokestatic 113	com/tencent/richmediabrowser/log/BrowserLogHelper:getInstance	()Lcom/tencent/richmediabrowser/log/BrowserLogHelper;
    //   283: invokevirtual 117	com/tencent/richmediabrowser/log/BrowserLogHelper:getGalleryLog	()Lcom/tencent/richmediabrowser/log/IBrowserLog;
    //   286: ldc 119
    //   288: iconst_4
    //   289: new 248	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   296: ldc_w 260
    //   299: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload_2
    //   303: invokevirtual 263	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokeinterface 126 4 0
    //   317: aload_1
    //   318: iconst_1
    //   319: putfield 210	com/tencent/richmediabrowser/model/RichMediaBrowserInfo:orientation	I
    //   322: goto -177 -> 145
    //   325: aload_0
    //   326: aload_2
    //   327: aload_0
    //   328: getfield 167	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView	Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;
    //   331: invokespecial 266	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:a	(Lcom/tencent/mobileqq/richmediabrowser/model/AIOPictureData;Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;)Z
    //   334: ifne +36 -> 370
    //   337: aload_0
    //   338: aload_2
    //   339: aload_0
    //   340: getfield 167	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView	Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;
    //   343: invokespecial 269	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:a	(Lcom/tencent/mobileqq/richmediabrowser/model/AIOPictureData;Lcom/tencent/richmediabrowser/view/GalleryUrlImageView;)Z
    //   346: ifne +24 -> 370
    //   349: aload_0
    //   350: aload_2
    //   351: aload_0
    //   352: getfield 167	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView	Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;
    //   355: invokespecial 271	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:b	(Lcom/tencent/mobileqq/richmediabrowser/model/AIOPictureData;Lcom/tencent/richmediabrowser/view/GalleryUrlImageView;)Z
    //   358: ifne +12 -> 370
    //   361: aload_0
    //   362: aload_0
    //   363: getfield 167	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView	Lcom/tencent/richmediabrowser/view/recyclerview/BrowserScaleView;
    //   366: invokespecial 274	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:a	(Lcom/tencent/richmediabrowser/view/GalleryUrlImageView;)Z
    //   369: pop
    //   370: aload_0
    //   371: aload_2
    //   372: getfield 275	com/tencent/mobileqq/richmediabrowser/model/AIOPictureData:jdField_a_of_type_Long	J
    //   375: aload_2
    //   376: getfield 276	com/tencent/mobileqq/richmediabrowser/model/AIOPictureData:jdField_a_of_type_Int	I
    //   379: iconst_2
    //   380: invokespecial 279	com/tencent/mobileqq/richmediabrowser/view/AIOPictureView:a	(JII)V
    //   383: aload_3
    //   384: areturn
    //   385: astore 4
    //   387: goto -127 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	390	0	this	AIOPictureView
    //   0	390	1	paramRichMediaBrowserInfo	RichMediaBrowserInfo
    //   0	390	2	paramAIOPictureData	AIOPictureData
    //   0	390	3	paramAIOPictureModel	AIOPictureModel
    //   0	390	4	paramFile1	File
    //   0	390	5	paramFile2	File
    //   0	390	6	paramInt	int
    //   6	205	7	i	int
    //   11	84	8	localURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   93	100	257	java/lang/Throwable
    //   133	145	279	java/lang/Exception
    //   100	112	385	java/lang/Throwable
  }
  
  private void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Contacts", 0);
    }
    AIOPicturePresenter.ActionSheetForwardActionInfo localActionSheetForwardActionInfo = new AIOPicturePresenter.ActionSheetForwardActionInfo();
    localActionSheetForwardActionInfo.jdField_a_of_type_Int = paramInt;
    if (paramInt == 72)
    {
      localActionSheetForwardActionInfo.jdField_a_of_type_JavaLangString = paramActionSheetItem.uin;
      localActionSheetForwardActionInfo.jdField_b_of_type_Int = paramActionSheetItem.uinType;
    }
    AIOPicturePresenter localAIOPicturePresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter;
    Activity localActivity = this.mContext;
    if (this.jdField_b_of_type_Boolean) {}
    for (paramActionSheetItem = "biz_src_jc_groupgif";; paramActionSheetItem = "biz_src_jc_photo")
    {
      localAIOPicturePresenter.a(paramRichMediaBrowserInfo, localActivity, localActionSheetForwardActionInfo, 100500, paramActionSheetItem);
      if (this.jdField_b_of_type_Boolean) {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "2", "", "", "", "", 0, 0, 0, 0);
      }
      if (ParamsManager.a().c()) {
        MultiMsgUtil.a("0X8009ABA");
      }
      return;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramLong, paramInt1, paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramLong, paramInt1, 1);
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
      ThreadManager.getUIHandler().post(new AIOPictureView.9(this, localScannerResult, paramArrayList));
      if (localScannerResult.jdField_a_of_type_JavaUtilArrayList != null)
      {
        i = localScannerResult.jdField_a_of_type_JavaUtilArrayList.size();
        if (localScannerResult.b == null) {
          break label178;
        }
        j = localScannerResult.b.size();
        label97:
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "qrSize = " + i + ", miniSize = " + j);
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
      label178:
      j = 0;
      break label97;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "checkQQCode scannerResult is null");
    }
  }
  
  private void a(AIOPictureData paramAIOPictureData)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet add to favorite.");
    Bundle localBundle = new Bundle();
    localBundle.putString("pic_md5", paramAIOPictureData.jdField_f_of_type_JavaLangString);
    paramAIOPictureData = new AIOPictureView.7(this);
    QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_add_fav", localBundle, paramAIOPictureData);
    if (this.jdField_b_of_type_Boolean) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "1", "", "", "", "", 0, 0, 0, 0);
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
    if ((localObject1 == null) && (ParamsManager.a().a())) {
      return;
    }
    if (localObject1 != null) {
      this.jdField_b_of_type_JavaLangString = ((File)localObject1).getPath();
    }
    localObject2 = ActionSheet.createMenuSheet(this.mContext);
    if (UinTypeUtil.a(ParamsManager.a().a()) != 1032)
    {
      localObject2 = new ArrayList();
      localObject3 = new ArrayList();
      if (localObject1 != null)
      {
        a((ArrayList)localObject2, paramAIOPictureData, (File)localObject1, (ArrayList)localObject3, (File)localObject1);
        if ((paramAIOPictureData.jdField_g_of_type_Int == 4) && (!this.jdField_b_of_type_Boolean) && (!paramAIOPictureData.jdField_l_of_type_Boolean)) {
          RichMediaShareActionSheetUtil.a(66, (ArrayList)localObject3);
        }
        a(paramAIOPictureData, paramRichMediaBrowserInfo, (File)localObject1);
        if (this.mContext != null)
        {
          localObject1 = this.mContext.getIntent();
          if (!this.jdField_b_of_type_Boolean) {
            break label348;
          }
          paramAIOPictureData = "biz_src_jc_groupgif";
          label180:
          ((Intent)localObject1).putExtra("big_brother_source_key", paramAIOPictureData);
        }
        if ((ParamsManager.a().a() != 1037) && (UinTypeUtil.a(ParamsManager.a().a()) != 1044))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter != null) {
            break label355;
          }
          paramAIOPictureData = null;
          label225:
          if (paramAIOPictureData == null) {
            break label371;
          }
          paramAIOPictureData.putExtra("key_new_img_shareactionsheet", 1);
          paramAIOPictureData.putExtra("k_dataline", true);
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOPictureData);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, (List)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        return;
        if ((ParamsManager.a().c()) || (ParamsManager.a().a() == 1037) || (!ParamsManager.a().g()) || (TextUtils.isEmpty(ParamsManager.a().c())) || (UinTypeUtil.a(ParamsManager.a().a()) == 1044)) {
          break;
        }
        RichMediaShareActionSheetUtil.a(54, (ArrayList)localObject3);
        break;
        label348:
        paramAIOPictureData = "biz_src_jc_photo";
        break label180;
        label355:
        paramAIOPictureData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramRichMediaBrowserInfo, this.mContext);
        break label225;
        label371:
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(null);
        QLog.e("AIOPictureView", 2, "showActionSheetForPic setIntentForStartForwardRecentActivity get null intent");
      }
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
      }
    }
    else
    {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009EEF", "0X8009EEF", 2, 0, "", "", "", "");
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, AIOPictureData paramAIOPictureData, AIOPictureModel paramAIOPictureModel, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageDrawable(paramURLDrawable);
    String str2 = paramAIOPictureModel.a(paramAIOPictureData, 4);
    String str1 = paramURLDrawable.getURL().toString();
    if (str1.equals(str2)) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setOriginalImage(true);
    }
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramURLDrawable.getURL().getFile());
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getRotation(paramRichMediaBrowserInfo.orientation));
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.isOriginalImage())
      {
        paramRichMediaBrowserInfo = paramAIOPictureData.jdField_c_of_type_JavaLangString;
        paramRichMediaBrowserInfo = FileUtils.b(paramRichMediaBrowserInfo);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): cache url is " + str1 + ", cache type is " + paramAIOPictureModel.a(paramAIOPictureData, paramURLDrawable.getURL().getFile()) + ",extName = + " + paramRichMediaBrowserInfo);
        if ((paramAIOPictureData.jdField_g_of_type_Boolean) && (RichMediaBrowserManager.getInstance().getProvider() != null)) {
          RichMediaBrowserManager.getInstance().getProvider().downloadMedia(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + localException.getMessage());
        paramRichMediaBrowserInfo.orientation = 0;
        continue;
        paramRichMediaBrowserInfo = paramAIOPictureData.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    try
    {
      paramRichMediaBrowserInfo = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      if (RichMediaBrowserManager.getInstance().getProvider() != null)
      {
        paramRichMediaBrowserInfo = RichMediaBrowserManager.getInstance().getProvider().getFavorateParams(paramRichMediaBrowserInfo.jdField_a_of_type_Long, paramRichMediaBrowserInfo.jdField_a_of_type_Int);
        if (paramRichMediaBrowserInfo == null) {
          QfavBuilder.b(paramFile.getAbsolutePath()).a(this.mContext, ParamsManager.a().d());
        }
        for (;;)
        {
          QfavReport.a(null, 40, 3);
          return;
          new QfavBuilder(paramRichMediaBrowserInfo).a(this.mContext, ParamsManager.a().d());
        }
      }
      return;
    }
    catch (RemoteException paramRichMediaBrowserInfo)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "ACTION_GALLERY_PIC_FAVORITE exception = " + paramRichMediaBrowserInfo.getMessage());
      QQToast.a(this.mContext.getApplicationContext(), this.mContext.getString(2131692807), 0).a();
    }
  }
  
  private void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, String paramString, URLDrawable paramURLDrawable, int paramInt)
  {
    if (paramRichMediaBrowserInfo.orientation == -2) {}
    try
    {
      paramRichMediaBrowserInfo.orientation = JpegExifReader.readOrientation(paramString);
      paramURLDrawable.setTag(Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramURLDrawable, this.mScreenWidthPx, this.mScreenHeightPx, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getRotation(paramRichMediaBrowserInfo.orientation));
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadFinish(paramInt, true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "read exif error" + paramString.getMessage());
        paramRichMediaBrowserInfo.orientation = 1;
      }
    }
  }
  
  private void a(ActionSheet paramActionSheet, File paramFile)
  {
    if ((UinTypeUtil.a(ParamsManager.a().a()) == 1032) && (paramFile != null)) {
      paramActionSheet.addButton(2131693308);
    }
    paramActionSheet.addCancelButton(2131692810);
    paramActionSheet.setOnButtonClickListener(new AIOPictureView.4(this, paramActionSheet));
    paramActionSheet.show();
    paramActionSheet.registerWatchDisMissActionListener(this);
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList1, AIOPictureData paramAIOPictureData, File paramFile1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList2, File paramFile2)
  {
    if ((ParamsManager.a().a() != 1037) && (UinTypeUtil.a(ParamsManager.a().a()) != 1044)) {
      RichMediaShareActionSheetUtil.a(2, paramArrayList1);
    }
    if ((ParamsManager.a().a() != 1037) && (UinTypeUtil.a(ParamsManager.a().a()) != 1044))
    {
      if (paramAIOPictureData.jdField_e_of_type_JavaLangString != null) {
        RichMediaShareActionSheetUtil.a(50, paramArrayList1);
      }
      if ((this.jdField_a_of_type_Boolean) && (paramAIOPictureData.jdField_e_of_type_JavaLangString != null)) {
        RichMediaShareActionSheetUtil.a(51, paramArrayList1);
      }
    }
    RichMediaShareActionSheetUtil.a(27, paramArrayList1);
    if ((PicShareToWX.a() != null) && (PicShareToWX.a().a()) && (PicShareToWX.a().a(paramFile1))) {
      RichMediaShareActionSheetUtil.a(9, paramArrayList1);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      RichMediaShareActionSheetUtil.a(48, paramArrayList2);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickMore", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if (!ZhuoXusManager.a().a()) {
      RichMediaShareActionSheetUtil.a(39, paramArrayList2);
    }
    if (!this.jdField_b_of_type_Boolean) {
      RichMediaShareActionSheetUtil.a(6, paramArrayList2);
    }
    if ((ParamsManager.a().a() != 1037) && (UinTypeUtil.a(ParamsManager.a().a()) != 1044))
    {
      if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c())) && (!ParamsManager.a().c())) {
        RichMediaShareActionSheetUtil.a(54, paramArrayList2);
      }
      if (this.jdField_c_of_type_Boolean) {
        RichMediaShareActionSheetUtil.a(52, paramArrayList2);
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
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      if ((paramAIOPictureData.jdField_d_of_type_Int == 1) && ((paramAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = false;
      }
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
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
      }
      if ((paramAIOPictureData != null) && (paramAIOPictureData.getStatus() == 1))
      {
        paramAIOPictureData.setTag(Integer.valueOf(1));
        paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramAIOPictureData, this.mScreenWidthPx, this.mScreenHeightPx, 0);
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
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mUseExifOrientation = false;
      if ((paramAIOPictureData.jdField_d_of_type_Int == 1) && ((paramAIOPictureData.jdField_f_of_type_Int & 0x2) == 2)) {
        ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = false;
      }
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
        for (;;)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealTempImage() exception = " + localException.getMessage());
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): url is " + localAIOPictureModel.a(paramAIOPictureData, 8) + ", file type is " + 8);
      }
      if ((localObject1 != null) && (localObject1.getStatus() == 1))
      {
        localObject1.setTag(Integer.valueOf(1));
        paramBrowserScaleView.setImageDrawable(localObject1);
        paramBrowserScaleView.initDrawable(localObject1, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "set temp image");
        return true;
      }
    }
    return false;
  }
  
  private boolean a(GalleryUrlImageView paramGalleryUrlImageView)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealDefaultImage()");
    paramGalleryUrlImageView.setImageDrawable(URLDrawableHelper.TRANSPARENT);
    return true;
  }
  
  private void b(AIOPictureData paramAIOPictureData)
  {
    if (LocalMultiProcConfig.getInt4Uin(ParamsManager.a().d() + "__qzone_pic_permission__" + ParamsManager.a().a(), -1, Long.valueOf(ParamsManager.a().d()).longValue()) == 0)
    {
      paramAIOPictureData = new QQCustomDialog(this.mContext, 2131755842);
      paramAIOPictureData.setContentView(2131559084);
      paramAIOPictureData.setTitle(this.mContext.getString(2131697668));
      paramAIOPictureData.setMessage(this.mContext.getString(2131697666));
      paramAIOPictureData.setNegativeButton(this.mContext.getString(2131697667), new AIOPictureView.8(this));
      paramAIOPictureData.setCanceledOnTouchOutside(false);
      paramAIOPictureData.setCancelable(false);
      paramAIOPictureData.show();
      QZoneClickReport.startReportImediately(ParamsManager.a().d(), "40", "1");
      return;
    }
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_Forward_Grpalbum", 0);
    }
    AIOGalleryUtils.a(this.mContext, ParamsManager.a().d(), ParamsManager.a().a(), ParamsManager.a().b(), paramAIOPictureData.jdField_a_of_type_JavaLangString, paramAIOPictureData.jdField_e_of_type_JavaLangString, paramAIOPictureData.jdField_g_of_type_Long, -1);
  }
  
  private void b(AIOPictureData paramAIOPictureData, RichMediaBrowserInfo paramRichMediaBrowserInfo, File paramFile)
  {
    if (!CheckPermission.isHasStoragePermission(this.mContext))
    {
      CheckPermission.requestStorePermission(this.mContext, null);
      return;
    }
    if (RichMediaBrowserManager.getInstance().getProvider() != null) {
      RichMediaBrowserManager.getInstance().getProvider().reportData("Pic_save", 0);
    }
    AIOPictureModel localAIOPictureModel = new AIOPictureModel();
    if ((localAIOPictureModel.a(paramAIOPictureData, 4) == null) && (localAIOPictureModel.a(paramAIOPictureData, 4)) && (AppNetConnInfo.isNetSupport())) {
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOPictureData.jdField_c_of_type_Long > 29360128L)) {
        a(1, paramAIOPictureData, paramRichMediaBrowserInfo);
      }
    }
    for (;;)
    {
      if (RichMediaBrowserManager.getInstance().getProvider() != null) {
        RichMediaBrowserManager.getInstance().getProvider().reportData(paramFile.getAbsolutePath(), 55);
      }
      if (this.jdField_b_of_type_Boolean) {
        VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "3", "", "", "", "", 0, 0, 0, 0);
      }
      if (ParamsManager.a().c()) {
        MultiMsgUtil.a("0X8009ABB");
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "ACTION_GALLERY_PIC_SAVE");
      return;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramAIOPictureData);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 3);
      updateUI();
      d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().b();
      continue;
      AIOGalleryUtils.a(this.mContext, paramFile, Utils.Crc64String(paramFile.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
    }
  }
  
  private boolean b(AIOPictureData paramAIOPictureData, GalleryUrlImageView paramGalleryUrlImageView)
  {
    boolean bool = false;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "dealErrorImage()");
    if ((paramAIOPictureData.jdField_f_of_type_Boolean) || (paramAIOPictureData.jdField_e_of_type_Boolean) || (paramAIOPictureData.jdField_d_of_type_Boolean))
    {
      paramAIOPictureData = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183);
      paramGalleryUrlImageView.setImageDrawable(paramAIOPictureData);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.initDrawable(paramAIOPictureData, this.mScreenWidthPx, this.mScreenHeightPx, 0);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedIndex(), false);
      bool = true;
    }
    return bool;
  }
  
  private void c(AIOPictureData paramAIOPictureData)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "action sheet share weiyun.");
      localBundle = new Bundle();
      localBundle.putString("pic_md5", paramAIOPictureData.jdField_f_of_type_JavaLangString);
      QIPCClientHelper.getInstance().callServer("EmoticonIPCModule", "action_group_emo_big_pic_upload_wy", localBundle, null);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "5", "", "", "", "", 0, 0, 0, 0);
    }
    while ((paramAIOPictureData.jdField_a_of_type_Long <= 0L) || (RichMediaBrowserManager.getInstance().getProvider() == null) || (!RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Bundle localBundle;
      return;
    }
    RichMediaBrowserManager.getInstance().getProvider().saveToWeiyun(paramAIOPictureData.jdField_a_of_type_Long);
    QQToast.a(this.mContext, this.mContext.getString(2131692733), 0).a();
  }
  
  private void d(AIOPictureData paramAIOPictureData)
  {
    String str = ParamsManager.a().a();
    if (TextUtils.isEmpty(str)) {
      str = ParamsManager.a().c();
    }
    for (;;)
    {
      ReportController.b(null, "P_CliOper", "dwop_via", "", "0X8009BE3", "0X8009BE3", ParamsManager.a().c(), 0, "", "", "", "");
      GalleryJumpUtils.a(this.mContext, ParamsManager.a().a(), ParamsManager.a().c(), str, paramAIOPictureData.jdField_b_of_type_Long, paramAIOPictureData.jdField_d_of_type_Long, paramAIOPictureData.jdField_b_of_type_Int, false);
      return;
    }
  }
  
  private void e(AIOPictureData paramAIOPictureData)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      if (paramAIOPictureData.jdField_m_of_type_Boolean) {
        RichMediaBrowserManager.getInstance().getProvider().safetyReport(ParamsManager.a().a(), true, paramAIOPictureData.jdField_m_of_type_JavaLangString, paramAIOPictureData.jdField_l_of_type_JavaLangString, localAppRuntime.getAccount(), paramAIOPictureData.n);
      }
    }
    else {
      return;
    }
    RichMediaBrowserManager.getInstance().getProvider().safetyReport(ParamsManager.a().a(), false, paramAIOPictureData.k, paramAIOPictureData.jdField_l_of_type_JavaLangString, localAppRuntime.getAccount(), paramAIOPictureData.n);
  }
  
  private void f(AIOPictureData paramAIOPictureData)
  {
    if ((!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView)) && (!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView)) && (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView))) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
    }
    a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
  }
  
  private void g(AIOPictureData paramAIOPictureData)
  {
    if ((!a(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView)) && (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView))) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
    }
    a(paramAIOPictureData.jdField_a_of_type_Long, paramAIOPictureData.jdField_a_of_type_Int, 2);
  }
  
  private void h(AIOPictureData paramAIOPictureData)
  {
    if (!b(paramAIOPictureData, this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView)) {
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
    }
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (new AIOPictureModel().a((AIOPictureData)localObject, 4))
      {
        if (((AIOPictureData)localObject).jdField_c_of_type_Long <= 0L) {
          break label98;
        }
        a(String.format(Locale.CHINA, this.mContext.getString(2131695009), new Object[] { FileUtil.a(((AIOPictureData)localObject).jdField_c_of_type_Long) }));
      }
    }
    return;
    label98:
    a(this.mContext.getString(2131695006));
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOPictureView", 2, "onClick qq_gallery_danmaku_view ");
    }
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
      MiniChatActivity.a(this.mContext, ParamsManager.a().a(), ParamsManager.a().a(), false, 26, ((AIOPictureData)localRichMediaBrowserInfo.baseData).jdField_d_of_type_Long, 0L);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.l();
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      switch (((AIOPictureData)localObject).status)
      {
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 0);
      updateUI();
      return;
      if (RichMediaBrowserManager.getInstance().getProvider() != null)
      {
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 4);
        continue;
        if (RichMediaBrowserManager.getInstance().getProvider() != null)
        {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 2);
          continue;
          if (RichMediaBrowserManager.getInstance().getProvider() != null) {
            RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 24);
          }
        }
      }
    }
  }
  
  private void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (!TextUtils.isEmpty(((AIOPictureData)localObject).o))
      {
        JumpUtil.a(this.mContext, ((AIOPictureData)localObject).o);
        ReportController.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 1, 0, "", "", ((AIOPictureData)localObject).o, "");
      }
    }
  }
  
  public AIOPictureData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100)) {
      return (AIOPictureData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 100))
    {
      a((AIOPictureData)localRichMediaBrowserInfo.baseData, localRichMediaBrowserInfo);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "showActionSheet, from:" + paramInt);
    }
  }
  
  public void a(int paramInt, Drawable paramDrawable, URLDrawable paramURLDrawable, BrowserScaleView paramBrowserScaleView)
  {
    if (((paramDrawable instanceof URLDrawable)) && (((URLDrawable)paramDrawable).isFakeSize()) && (paramURLDrawable == null))
    {
      paramDrawable = ((URLDrawable)paramDrawable).getURL();
      if (("file".equals(paramDrawable.getProtocol())) && (paramDrawable.getRef() == null))
      {
        if ((paramInt != this.jdField_b_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label113;
        }
        paramDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "use exist raw drawable");
      }
    }
    for (;;)
    {
      if (paramDrawable.getStatus() == 1)
      {
        paramBrowserScaleView.setIgnoreLayout(true);
        paramBrowserScaleView.setImageDrawable(paramDrawable);
        paramBrowserScaleView.setIgnoreLayout(false);
      }
      return;
      label113:
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "rawDrawable is exist");
      paramDrawable = paramDrawable.toString() + "#" + "NOSAMPLE";
      paramURLDrawable = URLDrawable.URLDrawableOptions.obtain();
      paramURLDrawable.mUseExifOrientation = false;
      paramURLDrawable.mUseMemoryCache = false;
      paramDrawable = URLDrawable.getDrawable(paramDrawable, paramURLDrawable);
      paramDrawable.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = paramDrawable;
      this.jdField_b_of_type_Int = paramInt;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "create rawDrawable, position:" + paramInt);
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(DialogUtil.a(this.mContext, 230, this.mContext.getString(2131718664), this.mContext.getString(2131718663), new AIOPictureView.10(this, paramInt, paramObject), new AIOPictureView.11(this)));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getItem(paramInt);
    BrowserScaleView localBrowserScaleView;
    AIOPictureData localAIOPictureData;
    if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((RichMediaBrowserInfo)localObject2).baseData.getType() == 100) && (this.mBrowserItemView != null) && ((this.mBrowserItemView.getTag() instanceof AIOPictureView.GalleryPictureViewHolder)))
    {
      localBrowserScaleView = ((AIOPictureView.GalleryPictureViewHolder)this.mBrowserItemView.getTag()).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject2).baseData;
      localObject2 = new AIOPictureModel();
      if (!localAIOPictureData.jdField_e_of_type_Boolean) {
        break label234;
      }
      localObject2 = localBrowserScaleView.getDrawable();
      if (!URLDrawable.class.isInstance(localObject2)) {
        break label418;
      }
      localObject1 = (URLDrawable)localObject2;
    }
    label418:
    for (localObject2 = ((URLDrawable)localObject1).getURL().getRef();; localObject2 = null)
    {
      if ((localObject1 == null) || (localObject2 == null) || ((!"PART".equals(localObject2)) && (!"DISPLAY".equals(localObject2))))
      {
        localObject1 = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838183);
        localBrowserScaleView.setImageDrawable((Drawable)localObject1);
        localBrowserScaleView.initDrawable((Drawable)localObject1, this.mScreenWidthPx, this.mScreenHeightPx, 0);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadFinish(paramInt, false);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().d();
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): IMAGE_FILE_ERROR");
      label234:
      do
      {
        return;
        if (((AIOPictureModel)localObject2).a(localAIOPictureData, 2) != null)
        {
          localObject2 = ((AIOPictureModel)localObject2).a(localAIOPictureData, 2);
          localObject1 = localObject2;
          if (paramBoolean) {
            localObject1 = (String)localObject2 + "#PART";
          }
          bindView(paramInt);
          localObject2 = FileUtils.b(localAIOPictureData.jdField_b_of_type_JavaLangString);
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "AIOGalleryAdapter.updateView(): Update large image, position=" + paramInt + "url = " + (String)localObject1 + ",extName = " + (String)localObject2);
          localAIOPictureData.jdField_g_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().c();
          return;
        }
      } while (((AIOPictureModel)localObject2).a(localAIOPictureData, 1) == null);
      localObject1 = URLDrawable.getDrawable(((AIOPictureModel)localObject2).a(localAIOPictureData, 1), URLDrawable.URLDrawableOptions.obtain());
      localBrowserScaleView.setImageDrawable((Drawable)localObject1);
      localBrowserScaleView.initDrawable((Drawable)localObject1, this.mScreenWidthPx, this.mScreenHeightPx, 0);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOPictureData localAIOPictureData = a();
    if ((localAIOPictureData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int);
      if ((i < 0) || (i >= 100)) {
        break label124;
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "onRevokeMsg isSaving:" + bool);
      if (bool) {
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 24);
      }
      return;
    }
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
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
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public boolean b()
  {
    Object localObject;
    if (super.b())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
      {
        AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
        AIOPictureModel localAIOPictureModel = new AIOPictureModel();
        localObject = localAIOPictureModel.a(localAIOPictureData, 4);
        if (localObject != null) {
          break label109;
        }
        localObject = localAIOPictureModel.a(localAIOPictureData, 2);
      }
    }
    label109:
    for (;;)
    {
      if ((localObject == null) && (ParamsManager.a().a())) {
        return false;
      }
      return (!ParamsManager.a().a()) && (!ParamsManager.a().c());
    }
  }
  
  public boolean back()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (((AIOPictureData)localObject).status == 2)
      {
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 4);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 0);
      }
    }
    return super.back();
  }
  
  public void bindView(int paramInt)
  {
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    int j = 1;
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getItem(paramInt);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {
      return;
    }
    AIOPictureData localAIOPictureData;
    DCAIOPreview localDCAIOPreview;
    if (localRichMediaBrowserInfo.baseData.getType() == 100)
    {
      localAIOPictureData = (AIOPictureData)localRichMediaBrowserInfo.baseData;
      localObject1 = new AIOPictureModel();
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(), localAIOPictureData);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setOnItemEventListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setPosition(paramInt);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setImageInfo(localRichMediaBrowserInfo);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setIgnoreLayout(false);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setContentDescription(this.mContext.getString(2131691649));
      localDCAIOPreview = null;
      localObject2 = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
      if ((localObject2 == null) || (((URLDrawable)localObject2).getStatus() != 1)) {
        break label450;
      }
      a(localRichMediaBrowserInfo, localAIOPictureData, (AIOPictureModel)localObject1, (URLDrawable)localObject2);
      if (!this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.isOriginalImage()) {
        break label442;
      }
    }
    label442:
    for (Object localObject1 = "original";; localObject1 = "large")
    {
      bool1 = true;
      paramInt = j;
      if (paramInt != 0)
      {
        paramInt = localRichMediaBrowserInfo.hashCode();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(paramInt);
        localDCAIOPreview = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a();
        if (localDCAIOPreview != null)
        {
          localDCAIOPreview.a(paramInt);
          localDCAIOPreview.a(paramInt, localAIOPictureData.jdField_e_of_type_Long, localAIOPictureData.jdField_f_of_type_Long);
          localDCAIOPreview.b(paramInt, PeakUtils.a(localAIOPictureData.jdField_c_of_type_Int));
          if (localAIOPictureData.h) {
            localDCAIOPreview.d(paramInt);
          }
          if (localObject1 != null)
          {
            localDCAIOPreview.a(paramInt, (String)localObject1);
            localDCAIOPreview.a(paramInt, bool1);
          }
        }
      }
      localObject1 = localAIOPictureData.jdField_a_of_type_Long + "_" + localAIOPictureData.jdField_a_of_type_Int;
      if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject1)) && (RichMediaBrowserManager.getInstance().getProvider() != null))
      {
        RichMediaBrowserManager.getInstance().getProvider().payFlow(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setMainBrowserPresenter(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.mainBrowserPresenter);
      localObject1 = new AIOPictureView.GalleryPictureViewHolder(this);
      ((AIOPictureView.GalleryPictureViewHolder)localObject1).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      this.mBrowserItemView.setTag(localObject1);
      return;
    }
    label450:
    Object localObject2 = ((AIOPictureModel)localObject1).a(localAIOPictureData, 4);
    int i;
    if (localObject2 != null) {
      if (localObject2 != null)
      {
        i = 1;
        label472:
        localObject1 = a(localRichMediaBrowserInfo, localAIOPictureData, (AIOPictureModel)localObject1, (File)localObject2, paramInt);
        if (!((URLDrawable)localObject1).isDownloadStarted()) {
          break label811;
        }
        if (GlobalImageCache.a.get(((URLDrawable)localObject1).getURL().toString()) != null) {
          bool1 = true;
        }
        if (i == 0) {
          break label534;
        }
        localObject1 = "original";
      }
    }
    for (;;)
    {
      paramInt = j;
      break;
      i = 0;
      break label472;
      label534:
      localObject1 = "large";
      continue;
      File localFile = ((AIOPictureModel)localObject1).a(localAIOPictureData, 2);
      if (localFile != null)
      {
        if (localObject2 != null)
        {
          i = 1;
          label564:
          localObject2 = a(localRichMediaBrowserInfo, localAIOPictureData, (AIOPictureModel)localObject1, (File)localObject2, localFile, paramInt);
          bool1 = bool3;
          localObject1 = localDCAIOPreview;
          if (localObject2 != null)
          {
            bool1 = bool3;
            localObject1 = localDCAIOPreview;
            if (((URLDrawable)localObject2).isDownloadStarted())
            {
              bool1 = bool2;
              if (GlobalImageCache.a.get(((URLDrawable)localObject2).getURL().toString()) != null) {
                bool1 = true;
              }
              if (i == 0) {
                break label653;
              }
            }
          }
        }
        label653:
        for (localObject1 = "original";; localObject1 = "large")
        {
          paramInt = j;
          break;
          i = 0;
          break label564;
        }
      }
      if (((AIOPictureModel)localObject1).a(localAIOPictureData, 8) != null)
      {
        f(localAIOPictureData);
        localObject1 = null;
        bool1 = false;
        paramInt = j;
        break;
      }
      if (((AIOPictureModel)localObject1).a(localAIOPictureData, 1) != null)
      {
        g(localAIOPictureData);
        localObject1 = null;
        bool1 = false;
        paramInt = j;
        break;
      }
      if ((localAIOPictureData.jdField_f_of_type_Boolean) || (localAIOPictureData.jdField_e_of_type_Boolean) || (localAIOPictureData.jdField_d_of_type_Boolean))
      {
        h(localAIOPictureData);
        localObject1 = null;
        bool1 = false;
        paramInt = 0;
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "getView(): No pic");
      a(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
      a(localAIOPictureData.jdField_a_of_type_Long, localAIOPictureData.jdField_a_of_type_Int, 2);
      localObject1 = null;
      bool1 = false;
      paramInt = 0;
      break;
      label811:
      localObject1 = null;
      bool1 = bool4;
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
    a(new AIOPictureView.1(this));
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    paramIntent = paramIntent.getExtras();
    this.jdField_a_of_type_Boolean = paramIntent.getBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", false);
    this.jdField_a_of_type_Int = paramIntent.getInt("extra.EXTRA_FORWARD_TO_QZONE_SRC");
    this.jdField_b_of_type_Boolean = paramIntent.getBoolean("group.emo.big.preview", false);
    this.jdField_c_of_type_Boolean = paramIntent.getBoolean("extra.OCR", false);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public boolean c()
  {
    if ((this.mContext.getIntent().getBooleanExtra("extra.FROM_AIO", false)) || (ParamsManager.a().c() == 3) || (ParamsManager.a().c() == 2) || (ParamsManager.a().c() == 6)) {}
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
  
  public void clearTheOuchCache()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.mActiveDrawable.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void e(boolean paramBoolean)
  {
    super.e(paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().jdField_a_of_type_Boolean = false;
      return;
    }
    showContentView(false);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().g();
  }
  
  public void f(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      if (paramBoolean) {
        k();
      }
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
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
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof AIOPictureView.GalleryPictureViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView = ((AIOPictureView.GalleryPictureViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559261, paramViewGroup, false));
      j();
    }
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 2);
      RichMediaBrowserManager.getInstance().getProvider().downloadMedia(((AIOPictureData)localObject).jdField_a_of_type_Long, ((AIOPictureData)localObject).jdField_a_of_type_Int, 4);
      updateUI();
      d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.a().b();
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageButton != null) {
      this.jdField_d_of_type_AndroidWidgetImageButton.setEnabled(paramBoolean);
    }
  }
  
  void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 100))
    {
      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject1).baseData;
      AIOPictureModel localAIOPictureModel = new AIOPictureModel();
      localObject2 = localAIOPictureModel.a(localAIOPictureData, 4);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localAIOPictureModel.a(localAIOPictureData, 2);
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localAIOPictureModel.a(localAIOPictureData, 1);
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
  
  public void i(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((RichMediaBrowserInfo)localObject).baseData != null)
          {
            i = j;
            if (((RichMediaBrowserInfo)localObject).baseData.getType() == 100)
            {
              i = j;
              if (!ParamsManager.a().f())
              {
                i = j;
                if (!ParamsManager.a().c())
                {
                  i = j;
                  if (CaptureUtil.a())
                  {
                    i = j;
                    if (ShortVideoUtils.isAEPituTakeSameOpen())
                    {
                      AIOPictureData localAIOPictureData = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
                      long l = localAIOPictureData.jdField_a_of_type_Long;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOPictureData.o))
                      {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                        localObject = this.mContext.getString(2131692803);
                        if (!TextUtils.isEmpty(localAIOPictureData.p)) {
                          localObject = localAIOPictureData.p;
                        }
                        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                        if (this.jdField_a_of_type_Long != l)
                        {
                          ReportController.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 1, 0, "", "", localAIOPictureData.o, "");
                          this.jdField_a_of_type_Long = l;
                        }
                        i = 1;
                      }
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
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131364353));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131364354));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374674));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374678));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374676));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131374681));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374677));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        localLayoutParams.addRule(10, -1);
        localLayoutParams.topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
      d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem()));
      g(c());
      c(b());
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void notifyImageModelDataChanged()
  {
    super.notifyImageModelDataChanged();
    clearTheOuchCache();
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100) && (((AIOPictureData)((RichMediaBrowserInfo)localObject).baseData).jdField_d_of_type_Int == 3))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.back();
        continue;
        m();
        continue;
        c();
        continue;
        h();
        continue;
        i();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.h();
        continue;
        b();
        continue;
        l();
        continue;
        if ((this.mContext instanceof AIOGalleryActivity))
        {
          localObject = (AIOGalleryActivity)this.mContext;
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (!PermissionUtils.isStorePermissionEnable(this.mContext)) {
              ((AIOGalleryActivity)localObject).requestPermissions(new AIOPictureView.2(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
            } else {
              n();
            }
          }
          else {
            n();
          }
        }
        else
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 2, "onClick, activity:" + this.mContext);
        }
      }
    }
  }
  
  public void onClickEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.back();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    clearTheOuchCache();
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    clearTheOuchCache();
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
    if (paramInt == this.jdField_b_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_b_of_type_Int = -1;
    }
  }
  
  public void onDismissOperations()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.updateSystemUIVisablity();
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
    i(false);
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.getDrawable();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem();
    if ((!this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.isOriginalImage()) && (localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 100))
    {
      localObject = (AIOPictureData)((RichMediaBrowserInfo)localObject).baseData;
      if (((localDrawable instanceof SkinnableBitmapDrawable)) && (((AIOPictureData)localObject).jdField_b_of_type_Int == 1) && (((AIOPictureData)localObject).jdField_c_of_type_Long > ((IFMConfig)QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()))
      {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setDoubleTapEnable(false);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.setScaleEnable(false);
      }
    }
    updateUI();
  }
  
  public void onLongClickEvent()
  {
    onLongClick(this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView);
  }
  
  public void onScaleBegin()
  {
    if ((this.mBrowserItemView != null) && ((this.mBrowserItemView.getTag() instanceof AIOPictureView.GalleryPictureViewHolder)))
    {
      BrowserScaleView localBrowserScaleView = ((AIOPictureView.GalleryPictureViewHolder)this.mBrowserItemView.getTag()).jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView;
      Drawable localDrawable = localBrowserScaleView.getDrawable();
      URLDrawable localURLDrawable = localBrowserScaleView.mDecoding;
      if (((localDrawable instanceof URLDrawable)) && (((URLDrawable)localDrawable).isFakeSize()) && (localURLDrawable == null)) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getCurrentPosition(), localDrawable, localURLDrawable, localBrowserScaleView);
      }
    }
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
    AIOPictureData localAIOPictureData = a();
    if (localAIOPictureData != null) {}
    switch (localAIOPictureData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOPictureView", 4, "updateUI status is error, status = " + localAIOPictureData.status);
      return;
    case 1: 
      f(false);
      c(false);
      g(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedIndex(), localAIOPictureData.progress);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedIndex(), true);
      f(false);
      c(false);
      d(false);
      g(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPictureData.progress / 100);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700131) + localAIOPictureData.progress / 100 + "%");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedIndex(), true);
      f(false);
      c(false);
      d(false);
      g(false);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localAIOPictureData.progress / 100);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700115) + localAIOPictureData.progress / 100 + "%");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedIndex(), true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    c(b());
    d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOPicturePresenter.getSelectedItem()));
    g(c());
    i(true);
    AIOPictureModel localAIOPictureModel = new AIOPictureModel();
    if ((localAIOPictureModel.a(localAIOPictureData, 2) != null) || (localAIOPictureModel.a(localAIOPictureData, 4) != null)) {
      h(true);
    }
    while ((localAIOPictureModel.a(localAIOPictureData, 4)) && (localAIOPictureModel.a(localAIOPictureData, 4) == null))
    {
      f(true);
      return;
      h(false);
    }
    f(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView
 * JD-Core Version:    0.7.0.1
 */