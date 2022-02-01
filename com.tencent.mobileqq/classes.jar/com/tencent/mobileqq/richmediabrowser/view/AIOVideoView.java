package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqvideoplatform.VideoPlatformUtils;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IShortVideoDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoModel;
import com.tencent.mobileqq.richmediabrowser.model.VideoPlayMedioInfo;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController;
import com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.event.IVideoViewClickEvent;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.BrowserUtils;
import com.tencent.richmediabrowser.view.video.VideoView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.Pair;
import com.tencent.util.PermissionUtil;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BaseActivity;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AIOVideoView
  extends AIOBrowserBaseView
  implements View.OnClickListener, VideoPlayerCallback, IVideoViewClickEvent
{
  public long a;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  private IProvider jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
  public AIOVideoPresenter a;
  private TVKVideoController jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
  public VideoView a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private long jdField_b_of_type_Long = -1L;
  public RelativeLayout b;
  public TextView b;
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public ImageButton d;
  public ImageButton e;
  
  public AIOVideoView(Context paramContext, AIOVideoPresenter paramAIOVideoPresenter)
  {
    super(paramContext, paramAIOVideoPresenter);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter = paramAIOVideoPresenter;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "drawable2Bitmap, drawable is null");
      }
      return null;
    }
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0)) {
      localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  private VideoPlayParam a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    Object localObject1 = new VideoPlayParam();
    Object localObject2 = paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    ((VideoPlayParam)localObject1).mSceneId = 101;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(SceneID.a(101));
    ((StringBuilder)localObject3).append("_FulScr");
    ((VideoPlayParam)localObject1).mSceneName = ((StringBuilder)localObject3).toString();
    localObject3 = a();
    if ((localObject3 != null) && (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(((AIOVideoData)localObject3).jdField_d_of_type_Int)))
    {
      ((VideoPlayParam)localObject1).mSceneId = 100;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(SceneID.a(100));
      ((StringBuilder)localObject3).append("_FulScr");
      ((VideoPlayParam)localObject1).mSceneName = ((StringBuilder)localObject3).toString();
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if (localObject3 != null) {
      ((VideoPlayParam)localObject1).mIsMute = ((AIOVideoPresenter)localObject3).b(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
    }
    if (!((VideoPlayParam)localObject1).mIsMute)
    {
      localObject3 = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
      if (localObject3 != null) {
        ((VideoView)localObject3).requestAudioFocus();
      }
    }
    if (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean)
    {
      ((VideoPlayParam)localObject1).mUrls = paramVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
      ((VideoPlayParam)localObject1).mSavePath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
    }
    else
    {
      ((VideoPlayParam)localObject1).mVideoPath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
    }
    ((VideoPlayParam)localObject1).mIsLocal = (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean ^ true);
    paramVideoPlayMedioInfo = (VideoPlayMedioInfo)localObject1;
    if (localObject2 != null)
    {
      paramVideoPlayMedioInfo = (VideoPlayMedioInfo)localObject1;
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView != null)
      {
        paramVideoPlayMedioInfo = ((IVideoDepend)QRoute.api(IVideoDepend.class)).buildVideoPlayParam((MessageRecord)localObject2, (VideoPlayParam)localObject1);
        localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("realPlayVideo, videoDuration = ");
        ((StringBuilder)localObject2).append(paramVideoPlayMedioInfo.mVideoFileTimeMs);
        ((IBrowserLog)localObject1).d("AIOVideoView", 4, ((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.totalTime.setText(BrowserUtils.a(paramVideoPlayMedioInfo.mVideoFileTimeMs));
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.progressTime.setText(BrowserUtils.a(0L));
      }
    }
    if (paramVideoPlayMedioInfo != null)
    {
      paramVideoPlayMedioInfo.mIsLoop = false;
      paramVideoPlayMedioInfo.mNeedPlayProgress = true;
    }
    return paramVideoPlayMedioInfo;
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    Object localObject1;
    Object localObject3;
    if (paramInt1 == 2)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(a());
      if ((localObject1 != null) && (((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(((VideoPlayMedioInfo)localObject1).jdField_b_of_type_JavaLangString)))
      {
        localObject2 = ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ArrayOfJavaLangString;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          if (!StringUtil.a((String)localObject3)) {
            BaseInnerDns.getInstance().reportBadIp(((VideoPlayMedioInfo)localObject1).jdField_b_of_type_JavaLangString, BaseInnerDns.getHostFromUrl((String)localObject3), ((IVideoDepend)QRoute.api(IVideoDepend.class)).getVideoIpType());
          }
          i += 1;
        }
        LongVideoUrlCacheManager.a().a();
      }
    }
    if (paramInt1 == 1) {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718273);
    } else {
      localObject1 = null;
    }
    if (paramInt2 == 14011001)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718271);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(5002, 0L);
    }
    Object localObject2 = a();
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718267);
      }
      ((AIOVideoData)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject1);
      ((AIOVideoData)localObject2).h += 1;
      localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handlePlayError, videoData.mPlayErrTimes = ");
      ((StringBuilder)localObject3).append(((AIOVideoData)localObject2).h);
      ((IBrowserLog)localObject1).d("AIOVideoView", 2, ((StringBuilder)localObject3).toString());
    }
    if ((VideoPlatformUtils.a(paramInt2, paramVideoPlayParam)) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (localObject2 != null) && (((AIOVideoData)localObject2).h < 2))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOVideoView.1(this, (AIOVideoData)localObject2));
      return;
    }
    ThreadManager.getUIHandler().post(new AIOVideoView.2(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryPlayVideo, position = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("AIOVideoView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localObject1 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("tryPlayVideo, position = ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" , msgId = ");
        ((StringBuilder)localObject2).append(((AIOVideoData)localObject1).jdField_a_of_type_Long);
        QLog.d("AIOVideoView", 2, ((StringBuilder)localObject2).toString());
      }
      ((AIOVideoData)localObject1).i = paramInt;
      ((AIOVideoData)localObject1).jdField_f_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(((AIOVideoData)localObject1).jdField_a_of_type_Long, paramBoolean ^ true);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a((AIOVideoData)localObject1);
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b((AIOVideoData)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject1).jdField_a_of_type_Long, ((AIOVideoData)localObject1).jdField_a_of_type_Int, 1);
        a();
        localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = ");
        localStringBuilder.append(((AIOVideoData)localObject1).jdField_a_of_type_Long);
        localStringBuilder.append(", shortVideoData.subId = ");
        localStringBuilder.append(((AIOVideoData)localObject1).jdField_a_of_type_Int);
        ((IBrowserLog)localObject2).d("AIOVideoView", 4, localStringBuilder.toString());
        return;
      }
      a((VideoPlayMedioInfo)localObject2);
    }
  }
  
  private void a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramLong))
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramLong);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportForVideoStartPlayCost, id:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", clickBubbleTime = ");
        ((StringBuilder)localObject).append(l);
        QLog.d("AIOVideoView", 2, ((StringBuilder)localObject).toString());
      }
      if (l > 0L)
      {
        paramLong = System.currentTimeMillis() - l;
        HashMap localHashMap = new HashMap();
        localHashMap.put("timeCost", String.valueOf(paramLong));
        localHashMap.put("busiType", paramVideoPlayParam.mSceneName);
        if (paramVideoPlayParam.mIsLocal) {
          localObject = "actVideoFSPlayCost";
        } else {
          localObject = "acVideoFSPlayCost_Online";
        }
        IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("report video start play cost , reportName = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" , timeCost = ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" , busiType = ");
        localStringBuilder.append(paramVideoPlayParam.mSceneName);
        localIBrowserLog.d("AIOVideoView", 2, localStringBuilder.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, (String)localObject, true, paramLong, 0L, localHashMap, "");
      }
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, videoFrame null");
      }
      return;
    }
    try
    {
      Object localObject = MobileQQ.getContext().getFilesDir().getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("tmpaiovideoframe.jpg");
      localObject = new File(localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      this.jdField_a_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onVideoFrameCallBack, write tmp file:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("AIOVideoView", 2, ((StringBuilder)localObject).toString());
      }
      RichMediaBrowserUtils.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    ArrayList localArrayList = new ArrayList();
    paramBitmap = ((IVideoDepend)QRoute.api(IVideoDepend.class)).hasCode(paramBitmap);
    if (((Boolean)paramBitmap.first).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected QRCode, build item");
      }
      RichMediaBrowserUtils.a(126, localArrayList, this.jdField_a_of_type_JavaLangString, 0);
    }
    if (((Boolean)paramBitmap.second).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected MiniCode, build item");
      }
      RichMediaBrowserUtils.a(127, localArrayList, this.jdField_a_of_type_JavaLangString, 0);
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected nothing");
      }
    }
    else {
      ThreadManager.getUIHandler().post(new AIOVideoView.11(this, localArrayList));
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if ((localObject != null) && (((IProvider)localObject).a()))
    {
      paramAIOVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, ParamsManager.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem() != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).jdField_e_of_type_JavaLangString))
            {
              paramAIOVideoData.putExtra(((IVideoDepend)QRoute.api(IVideoDepend.class)).getCameraVideoParam(), ((AIOVideoData)localObject).jdField_e_of_type_JavaLangString);
              paramAIOVideoData.putExtra(((IVideoDepend)QRoute.api(IVideoDepend.class)).getCameraMaterialName(), ((AIOVideoData)localObject).jdField_f_of_type_JavaLangString);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOVideoData);
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    File localFile = new AIOVideoModel().a(paramAIOVideoData, 1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    int j = 0;
    if ((localFile != null) && (localFile.exists()))
    {
      long l = localFile.length();
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showActionSheetForShortVideo, file.getPath()=");
      localStringBuilder.append(localFile.getPath());
      localStringBuilder.append(", mTransferredSize = ");
      localStringBuilder.append(l);
      localStringBuilder.append(", data.size = ");
      localStringBuilder.append(paramAIOVideoData.c);
      localIBrowserLog.d("AIOVideoView", 4, localStringBuilder.toString());
      if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(paramAIOVideoData.jdField_d_of_type_Int)) || (l >= paramAIOVideoData.c))
      {
        i = 0;
        break label211;
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
    }
    int i = 1;
    label211:
    if ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0)) {
      j = 1;
    }
    if (j != 0) {
      RichMediaBrowserUtils.a(2, this.jdField_a_of_type_JavaUtilArrayList);
    }
    if ((VersionUtils.d()) && ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
      RichMediaBrowserUtils.a(39, this.jdField_b_of_type_JavaUtilArrayList);
    }
    if (i == 0)
    {
      RichMediaBrowserUtils.a(6, this.jdField_b_of_type_JavaUtilArrayList);
      RichMediaBrowserUtils.a(3, this.jdField_a_of_type_JavaUtilArrayList);
      RichMediaBrowserUtils.a(27, this.jdField_a_of_type_JavaUtilArrayList);
    }
    if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c())) && (ParamsManager.a().a() != -1)) {
      RichMediaBrowserUtils.a(54, this.jdField_b_of_type_JavaUtilArrayList);
    }
    if (i == 0) {
      RichMediaBrowserUtils.a(64, this.jdField_a_of_type_JavaUtilArrayList);
    }
    a(paramAIOVideoData, localFile, paramInt, localRichMediaBrowserInfo);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
    if (j != 0) {
      a(paramAIOVideoData);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramAIOVideoData != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if ((localObject != null) && (((IProvider)localObject).a()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, ParamsManager.a().a());
        if ((localObject != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
        {
          ((Intent)localObject).putExtra("NeedReportForwardShortVideo", true);
          ((IVideoDepend)QRoute.api(IVideoDepend.class)).dealSendToFriend((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, paramAIOVideoData.jdField_e_of_type_JavaLangString, paramAIOVideoData.jdField_f_of_type_JavaLangString, paramInt, paramActionSheetItem);
        }
      }
    }
    if ((ParamsManager.a().d()) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null))
    {
      paramAIOVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
      AIOBrowserPresenter.a("0X8009ABC");
    }
  }
  
  private void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realPlayVideo id = ");
    localStringBuilder.append(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
    localIBrowserLog.d("AIOVideoView", 4, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int, 3);
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.a(0L, 0L, ParamsManager.a().c());
    }
    this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.setVideoPlayCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = a(paramVideoPlayMedioInfo);
    paramVideoPlayMedioInfo = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if ((paramVideoPlayMedioInfo != null) && (paramVideoPlayMedioInfo.mVideoView != null))
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.setVideoPlayCallback(this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.setVideoParam(this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.play();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else if (paramInt == 1) {
      paramInt = 2;
    } else if (paramInt == 3000) {
      paramInt = 3;
    } else if (paramInt == 6000) {
      paramInt = 4;
    } else {
      paramInt = -1;
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
      {
        this.d.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.d.setVisibility(4);
    }
    return false;
  }
  
  private void b(AIOVideoData paramAIOVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramAIOVideoData.jdField_b_of_type_JavaLangString);
    localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i = paramAIOVideoData.jdField_b_of_type_Int;
    if (i == 0)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      return;
    }
    if (i == 3000)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      return;
    }
    if (i == 1)
    {
      ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
  }
  
  private void b(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (paramAIOVideoData.g == 5002)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718256, 0).a();
      return;
    }
    if ((!PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext)) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, null);
      return;
    }
    if (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(paramAIOVideoData.jdField_d_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOVideoData.c))
    {
      paramAIOVideoData = new StringBuilder();
      paramRichMediaBrowserInfo = new StringBuilder();
      paramRichMediaBrowserInfo.append(paramFile.getParentFile().getName());
      paramRichMediaBrowserInfo.append(NetConnInfoCenter.getServerTime());
      paramAIOVideoData.append(paramRichMediaBrowserInfo.toString().toLowerCase(Locale.US));
      paramAIOVideoData.append(".mp4");
      paramAIOVideoData = paramAIOVideoData.toString();
      ThreadManager.getFileThreadHandler().post(((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_MqqOsMqqHandler, paramAIOVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode());
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOVideoData.c > 29360128L))
    {
      a(101, paramAIOVideoData, paramRichMediaBrowserInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramAIOVideoData);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 7);
    a();
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.pause();
    }
  }
  
  private void c(AIOVideoData paramAIOVideoData)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if ((localObject != null) && (((IProvider)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, ParamsManager.a().a());
      if ((localObject != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
        ((IVideoDepend)QRoute.api(IVideoDepend.class)).dealAddFavorite((Intent)localObject, (Activity)this.jdField_a_of_type_AndroidContentContext, null, 3, 0, paramAIOVideoData.jdField_b_of_type_Int);
      }
    }
  }
  
  private void d(int paramInt)
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, paramInt);
    }
  }
  
  private void i(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372191);
      this.d = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374213));
      this.d.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131718239));
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.initContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131380237));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380239));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380238));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364704));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.c = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374212));
      this.c.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374214));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.e = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374220));
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364256));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364257));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380764);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374215));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if ((localObject != null) && (!((VideoView)localObject).isInExitAnim)) {
      f(true);
    }
  }
  
  private void r()
  {
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if (localObject != null) {
      ((VideoView)localObject).pauseVideo();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if (((AIOVideoPresenter)localObject).a(((AIOVideoPresenter)localObject).jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getCurrentPosition())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(true);
    }
  }
  
  private void s()
  {
    AIOVideoData localAIOVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
    if ((localAIOVideoData != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      long l;
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) {
        l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
      } else {
        l = 0L;
      }
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().a(), false, localAIOVideoData.jdField_d_of_type_Long, l);
    }
    if ((localAIOVideoData != null) && (localAIOVideoData.status == 3))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData.jdField_a_of_type_Long, true);
      r();
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.i();
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
    {
      localObject = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext))
        {
          ((BaseActivity)localObject).requestPermissions(new AIOVideoView.3(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        u();
        return;
      }
      u();
      return;
    }
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick, activity:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
    ((IBrowserLog)localObject).d("AIOVideoView", 4, localStringBuilder.toString());
  }
  
  private void u()
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (!TextUtils.isEmpty(localAIOVideoData.jdField_e_of_type_JavaLangString)) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      ((IJumpUtil)QRoute.api(IJumpUtil.class)).jumpToCameraActivityForAio((Activity)this.jdField_a_of_type_AndroidContentContext, localAIOVideoData.jdField_e_of_type_JavaLangString);
      ReportController.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.jdField_e_of_type_JavaLangString, "");
    }
  }
  
  private void v()
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController;
      if (localObject != null) {
        ((TVKVideoController)localObject).b();
      }
      long l;
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) {
        l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
      } else {
        l = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController = new TVKVideoController(this.jdField_a_of_type_AndroidContentContext);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController.a((VideoPlayMedioInfo)localObject, localAIOVideoData.jdField_e_of_type_Long, l);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController.a(localAIOVideoData.jdField_b_of_type_Int, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.d();
        }
      }
      else
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
      }
    }
  }
  
  public long a()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if ((localVideoView != null) && (localVideoView.mVideoView != null)) {
      return this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
    }
    return 0L;
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562764, null));
    q();
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.videoControlContainer != null) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.videoControlContainer.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    return this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mBrowserItemView;
  }
  
  public AIOVideoData a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if ((localObject != null) && (((AIOVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 101)) {
        return (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      }
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = a();
    c(b());
    d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem()));
    h(true);
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView != null))
    {
      Object localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI id = ");
      localStringBuilder.append(((AIOVideoData)localObject1).id);
      localStringBuilder.append(", status = ");
      localStringBuilder.append(((AIOVideoData)localObject1).status);
      ((IBrowserLog)localObject2).d("AIOVideoView", 4, localStringBuilder.toString());
      int j = ((AIOVideoData)localObject1).status;
      int i = 8;
      long l;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j != 6)
                {
                  if (j != 7)
                  {
                    localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("updateUI status is error, status = ");
                    localStringBuilder.append(((AIOVideoData)localObject1).status);
                    ((IBrowserLog)localObject2).d("AIOVideoView", 4, localStringBuilder.toString());
                    return;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
                  localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131718262));
                  localStringBuilder.append(((AIOVideoData)localObject1).progress);
                  localStringBuilder.append("%");
                  ((TextView)localObject2).setText(localStringBuilder.toString());
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(((AIOVideoData)localObject1).progress * 100);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
                  g(true);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
                  a(true);
                  return;
                }
                this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(0);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846308);
                localObject2 = (TextView)this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.findViewById(2131366307);
                if (localObject2 != null)
                {
                  if (!TextUtils.isEmpty(((AIOVideoData)localObject1).jdField_d_of_type_JavaLangString)) {
                    localObject1 = ((AIOVideoData)localObject1).jdField_d_of_type_JavaLangString;
                  } else {
                    localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131720253);
                  }
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
                g(false);
                a(false);
                return;
              }
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(true);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(0);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846308);
              g(false);
              a(true);
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(true);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846309);
            if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)
            {
              l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getVideoDurationMs();
              localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("videoDuration = ");
              ((StringBuilder)localObject2).append(l);
              ((IBrowserLog)localObject1).d("AIOVideoView", 4, ((StringBuilder)localObject2).toString());
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.totalTime.setText(BrowserUtils.a(l));
            }
            g(false);
            a(true);
            return;
          }
          if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) {
            if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying()) {
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(0);
            } else {
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(true);
          g(false);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
          a(true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
        g(false);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
        a(false);
        return;
      }
      g(false);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
      localObject2 = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn;
      if (!((AIOVideoData)localObject1).jdField_f_of_type_Boolean) {
        i = 0;
      }
      ((ImageView)localObject2).setVisibility(i);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846308);
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)
      {
        l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getVideoDurationMs();
        localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoDuration = ");
        ((StringBuilder)localObject2).append(l);
        ((IBrowserLog)localObject1).d("AIOVideoView", 4, ((StringBuilder)localObject2).toString());
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.totalTime.setText(BrowserUtils.a(l));
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.progressTime.setText(BrowserUtils.a(0L));
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playBar.setProgress(0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      localObject1 = new AIOVideoModel();
      Object localObject2 = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b.get(Integer.valueOf(paramInt));
      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.showCover((Drawable)localObject2);
      } else if (((AIOVideoModel)localObject1).a(localAIOVideoData, 0) != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCoverImage(), paramInt);
      }
      if (localAIOVideoData.jdField_d_of_type_Int == 1) {
        localObject1 = "0X8009EF1";
      } else {
        localObject1 = "0X8009EF2";
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
      if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101) && (((AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long == localAIOVideoData.jdField_a_of_type_Long) && (!((RichMediaBrowserInfo)localObject2).isReport))
      {
        ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
        ((RichMediaBrowserInfo)localObject2).isReport = true;
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
      }
      localObject1 = new AIOVideoView.GalleryVideoViewHolder(this);
      ((AIOVideoView.GalleryVideoViewHolder)localObject1).a = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mBrowserItemView.setTag(localObject1);
    }
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
    {
      if (paramView == null) {
        return;
      }
      if ((paramView.getTag() instanceof AIOVideoView.GalleryVideoViewHolder))
      {
        paramView = ((AIOVideoView.GalleryVideoViewHolder)paramView.getTag()).a;
        if (((RichMediaBrowserInfo)localObject).baseData.getType() == 101)
        {
          localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_JavaLangString, ((AIOVideoData)localObject).jdField_e_of_type_Int, ((AIOVideoData)localObject).jdField_f_of_type_Int, paramView.getCoverImage(), paramInt);
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(paramInt))
          {
            paramView = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a((AIOVideoData)localObject);
            if (paramView != null) {
              a(paramView);
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131718260), this.jdField_a_of_type_AndroidContentContext.getString(2131718259), new AIOVideoView.9(this, paramInt, paramObject), new AIOVideoView.10(this)));
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if (localObject != null)
      {
        int i = ((IProvider)localObject).a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int);
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
        ((IBrowserLog)localObject).d("AIOVideoView", 4, localStringBuilder.toString());
        if (bool)
        {
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg cancelDownloadMedia");
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.b(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 256);
        }
        if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) {
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.pause();
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "notifyVideoUrl ");
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData == null) {
      return;
    }
    LongVideoUrlCacheManager.a().a(localAIOVideoData.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageRecord, paramInt3, paramString2);
    paramString2 = new VideoPlayMedioInfo();
    paramString2.jdField_a_of_type_Boolean = true;
    paramString2.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString2.jdField_a_of_type_JavaLangString = paramString1;
    paramString2.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    paramString2.jdField_a_of_type_Int = paramInt3;
    paramString2.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
    paramString2.jdField_b_of_type_Int = localAIOVideoData.jdField_a_of_type_Int;
    paramString1 = new File(localAIOVideoData.jdField_b_of_type_JavaLangString);
    if (paramString1.exists()) {
      paramString2.jdField_d_of_type_Long = paramString1.length();
    } else {
      paramString2.jdField_d_of_type_Long = 0L;
    }
    paramString1 = BrowserLogHelper.getInstance().getGalleryLog();
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  ");
    paramArrayOfString.append(paramString2.e);
    paramString1.d("AIOVideoView", 4, paramArrayOfString.toString());
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if (paramString1.b(paramString1.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition()))
    {
      a(paramString2);
    }
    else
    {
      d(0);
      a();
    }
    if (new AIOVideoModel().a(localAIOVideoData, 0) == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
      if (paramString1 != null) {
        paramString1.a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 0);
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
        localIBrowserLog.d("AIOVideoView", 4, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider))) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a());
    }
  }
  
  public void a(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
      if ((((AIOVideoPresenter)localObject).a(((AIOVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) && (paramSeekBar != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a(paramSeekBar.getProgress());
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a(BrowserDanmakuUtils.a(((AIOVideoData)localObject).jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
        }
      }
    }
  }
  
  public void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.l();
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOVideoView.4(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new AIOVideoView.5(this));
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.a(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof VideoView))
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView = ((VideoView)paramIBaseViewBuilder);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.setPlayPanelDecorator(true);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.setVideoViewClickEvent(this);
    }
  }
  
  public void b()
  {
    super.b();
    l();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = null;
    VideoView localVideoView = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if (localVideoView != null) {
      localVideoView.onDestroy();
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    a(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(paramInt))
      {
        a(paramInt, true);
        return;
      }
      a();
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying())
      {
        long l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showActionSheet, captureCurFrame, from:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", pos:");
          localStringBuilder.append(l);
          QLog.i("AIOVideoView", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.captureCurFrame(l, 0, 0);
      }
      else if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playBar.getProgress() > 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showActionSheet, captureCurFrame, from:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", pos:");
          localStringBuilder.append(this.jdField_b_of_type_Long);
          QLog.i("AIOVideoView", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.captureCurFrame(this.jdField_b_of_type_Long, 0, 0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 2, "showActionSheet, video is not playing, recognize thumbnail");
        }
        ThreadManager.getSubThreadHandler().post(new AIOVideoView.8(this));
      }
      a(localAIOVideoData, paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doEnterImmersion, isClick:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", hasDanmaku:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.c());
    localIBrowserLog.d("AIOVideoView", 2, localStringBuilder.toString());
    super.e(paramBoolean);
    if (paramBoolean)
    {
      f(false);
      b(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.e();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.f();
      i(false);
      return;
    }
    f(false);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().e();
  }
  
  public void g()
  {
    i(true);
  }
  
  public void g(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localRelativeLayout.setVisibility(i);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      int j = 0;
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
                    i = j;
                    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
                    {
                      AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOVideoData.jdField_e_of_type_JavaLangString))
                      {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131718235);
                        if (!TextUtils.isEmpty(localAIOVideoData.jdField_f_of_type_JavaLangString)) {
                          localObject = localAIOVideoData.jdField_f_of_type_JavaLangString;
                        }
                        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                        j = 1;
                        i = j;
                        if (this.jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long)
                        {
                          ReportController.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.jdField_e_of_type_JavaLangString, "");
                          this.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
                          i = j;
                        }
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
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if ((localObject != null) && (((VideoView)localObject).mVideoView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
      if (!((AIOVideoPresenter)localObject).b(((AIOVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.setCoverVisible();
      }
    }
  }
  
  public void k()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if ((((AIOVideoPresenter)localObject).b(((AIOVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView != null))
    {
      localObject = a();
      if ((this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (localObject != null) && (((AIOVideoData)localObject).status == 4)) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.resume();
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b.clear();
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (!this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isLocalPlay()) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying()))
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131718265);
      localObject = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, (String)localObject, 2131718249, 2131718276, new AIOVideoView.6(this), new AIOVideoView.7(this));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.pause();
      a((Dialog)localObject);
    }
  }
  
  public void n()
  {
    VideoView localVideoView = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if ((localVideoView != null) && (localVideoView.mVideoView != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying())) {
      r();
    } else if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition(), false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.k();
    }
    h();
  }
  
  public void o()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a();
        f();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().b();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean = true;
        e(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().f();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.d();
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCapFrame, id:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", w:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", h:");
      localStringBuilder.append(paramInt2);
      QLog.i("AIOVideoView", 2, localStringBuilder.toString());
    }
    a(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131364704)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
      {
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
        if (localIProvider != null) {
          localIProvider.b(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 256);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
        a();
      }
    }
    else if (i == 2131374213)
    {
      v();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.m();
      }
    }
    else if (i == 2131374215)
    {
      e();
    }
    else if (i == 2131374214)
    {
      d();
    }
    else if (i == 2131374212)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 2, "onClick qq_gallery_danmaku_view ");
      }
      s();
    }
    else if (i == 2131374220)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
      if (localObject != null) {
        ((AIOVideoPresenter)localObject).d();
      }
    }
    else if (i == 2131364256)
    {
      t();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if (localObject != null)
    {
      localObject = ((AIOVideoPresenter)localObject).a(a());
      if (localObject != null) {
        ((VideoPlayMedioInfo)localObject).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(2003, 0L);
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onEnterAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 2, "onEnterAnimationEnd");
    }
    super.onEnterAnimationEnd();
    f(true);
    a();
  }
  
  public void onEnterAnimationStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 2, "onEnterAnimationStart");
    }
    f(false);
  }
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstFrameRendered, id:");
      localStringBuilder.append(paramLong);
      QLog.d("AIOVideoView", 2, localStringBuilder.toString());
    }
    a(paramLong, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayError, id = ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ,module = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" , errorType = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errCode = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" , exInfo = ");
    localStringBuilder.append(paramString);
    localIBrowserLog.e("AIOVideoView", 1, localStringBuilder.toString());
    a(paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public void onScrollEnd()
  {
    AIOVideoPresenter localAIOVideoPresenter = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
    if (localAIOVideoPresenter.a(localAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition()))
    {
      if ((this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying()))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(false);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateChange , state = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msgUniseq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("AIOVideoView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 4)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (paramInt != 8)
          {
            if (paramInt != 9) {
              return;
            }
            localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
            if (localObject != null) {
              ((VideoView)localObject).abandonAudioFocus();
            }
          }
          else
          {
            localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
            if (localObject != null)
            {
              ((VideoView)localObject).progressTime.setText(BrowserUtils.a(this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getVideoDurationMs()));
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playBar.setProgress(100);
            }
            d(0);
            a();
          }
        }
        else
        {
          d(4);
          a();
        }
      }
      else
      {
        d(2);
        a();
      }
    }
    else
    {
      d(3);
      a();
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam.mIsMute) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.requestAudioFocus();
      }
      localObject = a();
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_Long, false);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
      if (((AIOVideoPresenter)localObject).a(((AIOVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition()))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
        if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a() != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a(BrowserDanmakuUtils.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
        }
      }
    }
  }
  
  public void p()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
    AIOVideoData localAIOVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
    if ((localAIOVideoData != null) && (localAIOVideoData.status != 7)) {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition(), false);
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView
 * JD-Core Version:    0.7.0.1
 */