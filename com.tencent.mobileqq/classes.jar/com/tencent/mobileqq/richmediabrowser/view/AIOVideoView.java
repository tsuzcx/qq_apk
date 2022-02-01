package com.tencent.mobileqq.richmediabrowser.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.VideoPlayMedioInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qqvideoplatform.api.VideoPlatformUtils;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOVideoPresenter;
import com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.videoview.TVKVideoController;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.core.RichMediaBrowserManager;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.IProvider;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class AIOVideoView
  extends AIOBrowserBaseView
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public long a;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public SeekBar a;
  public TextView a;
  public AIOVideoPresenter a;
  public BaseVideoView a;
  private TVKVideoController jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController;
  public GalleryUrlImageView a;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout b;
  public SeekBar b;
  public TextView b;
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ImageView c;
  public RelativeLayout c;
  public TextView c;
  public ImageButton d;
  public TextView d;
  public ImageButton e;
  public TextView e;
  
  public AIOVideoView(Activity paramActivity, AIOVideoPresenter paramAIOVideoPresenter)
  {
    super(paramActivity, paramAIOVideoPresenter);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter = paramAIOVideoPresenter;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "drawable2Bitmap, drawable is null");
      }
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicHeight() <= 0)) {}
    for (Object localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);; localObject = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  private VideoPlayParam a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    MessageForShortVideo localMessageForShortVideo = paramVideoPlayMedioInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    localVideoPlayParam.mSceneId = 101;
    localVideoPlayParam.mSceneName = (SceneID.a(101) + "_FulScr");
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (localAIOVideoData.jdField_d_of_type_Int == 1))
    {
      localVideoPlayParam.mSceneId = 100;
      localVideoPlayParam.mSceneName = (SceneID.a(100) + "_FulScr");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter != null) {
      localVideoPlayParam.mIsMute = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(paramVideoPlayMedioInfo.jdField_a_of_type_Long);
    }
    if (!localVideoPlayParam.mIsMute) {
      k();
    }
    if (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean)
    {
      localVideoPlayParam.mUrls = paramVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
      localVideoPlayParam.mSavePath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
      if (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean) {
        break label332;
      }
    }
    label332:
    for (boolean bool = true;; bool = false)
    {
      localVideoPlayParam.mIsLocal = bool;
      if (localMessageForShortVideo != null)
      {
        long l = localMessageForShortVideo.videoFileTime * 1000;
        localVideoPlayParam.mVideoFileTimeMs = l;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo, videoDuration = " + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
        localVideoPlayParam.mFileID = (localMessageForShortVideo.md5 + localMessageForShortVideo.uniseq);
        localVideoPlayParam.mFileSize = localMessageForShortVideo.videoFileSize;
      }
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      a(localVideoPlayParam);
      return localVideoPlayParam;
      localVideoPlayParam.mVideoPath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    String str1 = null;
    if (paramInt1 == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(a());
      if ((localObject != null) && (((VideoPlayMedioInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(((VideoPlayMedioInfo)localObject).jdField_b_of_type_JavaLangString)))
      {
        String[] arrayOfString = ((VideoPlayMedioInfo)localObject).jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          if (!StringUtil.a(str2)) {
            InnerDns.getInstance().reportBadIp(((VideoPlayMedioInfo)localObject).jdField_b_of_type_JavaLangString, InnerDns.getHostFromUrl(str2), 1005);
          }
          i += 1;
        }
        LongVideoUrlCacheManager.a().a();
      }
    }
    if (paramInt1 == 1) {
      str1 = this.mContext.getString(2131719374);
    }
    if (paramInt2 == 14011001)
    {
      str1 = this.mContext.getString(2131718625);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(5002, 0L);
    }
    Object localObject = a();
    if (localObject != null) {
      if (str1 == null) {
        break label300;
      }
    }
    for (;;)
    {
      ((AIOVideoData)localObject).jdField_f_of_type_JavaLangString = str1;
      ((AIOVideoData)localObject).l += 1;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, videoData.mPlayErrTimes = " + ((AIOVideoData)localObject).l);
      if ((!VideoPlatformUtils.a(paramInt2, paramVideoPlayParam)) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) || (localObject == null) || (((AIOVideoData)localObject).l >= 2)) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOVideoView.3(this, (AIOVideoData)localObject));
      return;
      label300:
      str1 = this.mContext.getString(2131719377);
    }
    ThreadManager.getUIHandler().post(new AIOVideoView.4(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getItem(paramInt);
    Object localObject2;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localObject1 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "tryPlayVideo, position = " + paramInt + " , msgId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Long);
      }
      ((AIOVideoData)localObject1).m = paramInt;
      ((AIOVideoData)localObject1).i = paramBoolean;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter;
      long l = ((AIOVideoData)localObject1).jdField_a_of_type_Long;
      if (!paramBoolean) {
        bool = true;
      }
      ((AIOVideoPresenter)localObject2).b(l, bool);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a((AIOVideoData)localObject1);
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b((AIOVideoData)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject1).jdField_a_of_type_Long, ((AIOVideoData)localObject1).jdField_a_of_type_Int, 4);
        updateUI();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Long + ", shortVideoData.subId = " + ((AIOVideoData)localObject1).jdField_a_of_type_Int);
      }
    }
    else
    {
      return;
    }
    a((VideoPlayMedioInfo)localObject2);
  }
  
  private void a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    HashMap localHashMap;
    if (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramLong))
    {
      long l = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 0, "reportForVideoStartPlayCost, id:" + paramLong + ", clickBubbleTime = " + l);
      }
      if (l > 0L)
      {
        paramLong = System.currentTimeMillis() - l;
        localHashMap = new HashMap();
        localHashMap.put("timeCost", String.valueOf(paramLong));
        localHashMap.put("busiType", paramVideoPlayParam.mSceneName);
        if (!paramVideoPlayParam.mIsLocal) {
          break label203;
        }
      }
    }
    label203:
    for (String str = "actVideoFSPlayCost";; str = "acVideoFSPlayCost_Online")
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "report video start play cost , reportName = " + str + " , timeCost = " + paramLong + " , busiType = " + paramVideoPlayParam.mSceneName);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, videoFrame null");
      }
    }
    do
    {
      return;
      try
      {
        localObject = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
        localObject = new File((String)localObject + File.separator + "tmpaiovideoframe.jpg");
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        this.jdField_a_of_type_JavaLangString = ((File)localObject).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, write tmp file:" + this.jdField_a_of_type_JavaLangString);
        }
        FileUtil.a(paramBitmap, this.jdField_a_of_type_JavaLangString);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Object localObject;
          localIOException.printStackTrace();
          continue;
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "detectQQCodeFromBmp scannerResult is null");
        }
        ThreadManager.getUIHandler().post(new AIOVideoView.13(this, localIOException));
      }
      localObject = new ArrayList();
      paramBitmap = ScannerUtils.a(paramBitmap, 3);
      if (paramBitmap == null) {
        break;
      }
      if (paramBitmap.d())
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, detected QRCode, build item");
        }
        RichMediaShareActionSheetUtil.a(126, (ArrayList)localObject, this.jdField_a_of_type_JavaLangString, 0);
      }
      if (paramBitmap.c())
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, detected MiniCode, build item");
        }
        RichMediaShareActionSheetUtil.a(127, (ArrayList)localObject, this.jdField_a_of_type_JavaLangString, 0);
      }
      if (!((ArrayList)localObject).isEmpty()) {
        break label265;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, detected nothing");
    return;
    label265:
  }
  
  private void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (paramVideoPlayMedioInfo == null) {}
    do
    {
      return;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "realPlayVideo id = " + paramVideoPlayMedioInfo.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramVideoPlayMedioInfo.jdField_a_of_type_Long, paramVideoPlayMedioInfo.jdField_b_of_type_Int, 5);
      updateUI();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(0L, 0L, ParamsManager.a().c());
      paramVideoPlayMedioInfo = a(paramVideoPlayMedioInfo);
    } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(paramVideoPlayMedioInfo);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
  }
  
  private void a(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, ParamsManager.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem() != null)
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            int i = ((AIOVideoData)localObject).jdField_g_of_type_Int;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).jdField_d_of_type_JavaLangString)))
            {
              paramAIOVideoData.putExtra("param_key_redbag_type", i);
              paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).jdField_c_of_type_JavaLangString);
              paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject).jdField_e_of_type_JavaLangString);
            }
            if (((AIOVideoData)localObject).k == 2) {
              paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject).k);
            }
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).jdField_g_of_type_JavaLangString))
            {
              paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject).jdField_g_of_type_JavaLangString);
              paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject).h);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOVideoData);
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    int j = 0;
    File localFile = new AIOVideoModel().a(paramAIOVideoData, 1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    long l;
    int i;
    if ((localFile != null) && (localFile.exists()))
    {
      l = localFile.length();
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showActionSheetForShortVideo, file.getPath()=" + localFile.getPath() + ", mTransferredSize = " + l + ", data.size = " + paramAIOVideoData.jdField_c_of_type_Long);
      if (paramAIOVideoData.jdField_d_of_type_Int == 1) {
        i = 0;
      }
    }
    for (;;)
    {
      if ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0)) {
        j = 1;
      }
      if (j != 0) {
        RichMediaShareActionSheetUtil.a(2, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((VersionUtils.d()) && ((paramAIOVideoData.jdField_d_of_type_Int != 1) || (i == 0))) {
        RichMediaShareActionSheetUtil.a(39, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0)
      {
        RichMediaShareActionSheetUtil.a(6, this.jdField_b_of_type_JavaUtilArrayList);
        RichMediaShareActionSheetUtil.a(3, this.jdField_a_of_type_JavaUtilArrayList);
        RichMediaShareActionSheetUtil.a(27, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c())) && (ParamsManager.a().a() != -1)) {
        RichMediaShareActionSheetUtil.a(54, this.jdField_b_of_type_JavaUtilArrayList);
      }
      if (i == 0) {
        RichMediaShareActionSheetUtil.a(64, this.jdField_a_of_type_JavaUtilArrayList);
      }
      a(paramAIOVideoData, localFile, paramInt, localRichMediaBrowserInfo);
      if (this.mContext != null) {
        this.mContext.getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_JavaUtilArrayList);
      if (j != 0) {
        a(paramAIOVideoData);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      return;
      if (l < paramAIOVideoData.jdField_c_of_type_Long)
      {
        i = 1;
        continue;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      paramAIOVideoData = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, ParamsManager.a().a());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem() != null)
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            int i = ((AIOVideoData)localObject).jdField_g_of_type_Int;
            AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
            if ((i == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOVideoData)localObject).jdField_d_of_type_JavaLangString)))
            {
              paramAIOVideoData.putExtra("param_key_redbag_type", i);
              paramAIOVideoData.putExtra("param_key_redbag_video_id", ((AIOVideoData)localObject).jdField_c_of_type_JavaLangString);
              paramAIOVideoData.putExtra("from_session_uin", ((AIOVideoData)localObject).jdField_e_of_type_JavaLangString);
            }
            if (((AIOVideoData)localObject).k == 2) {
              paramAIOVideoData.putExtra("special_video_type", ((AIOVideoData)localObject).k);
            }
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).jdField_g_of_type_JavaLangString))
            {
              paramAIOVideoData.putExtra("widgetinfo", ((AIOVideoData)localObject).jdField_g_of_type_JavaLangString);
              paramAIOVideoData.putExtra("key_camera_material_name", ((AIOVideoData)localObject).h);
            }
          }
        }
        if (paramInt != 72) {
          break label310;
        }
        paramAIOVideoData.putExtra("key_req", ForwardRecentActivity.jdField_f_of_type_Int);
        paramAIOVideoData.putExtra("key_direct_show_uin_type", paramActionSheetItem.uinType);
        paramAIOVideoData.putExtra("key_direct_show_uin", paramActionSheetItem.uin);
        ForwardBaseOption.a(this.mContext, paramAIOVideoData, ForwardRecentTranslucentActivity.class, 19005, 100500, " biz_src_jc_video");
      }
    }
    for (;;)
    {
      if (ParamsManager.a().c()) {
        MultiMsgUtil.a("0X8009ABC");
      }
      return;
      label310:
      ForwardBaseOption.a(this.mContext, paramAIOVideoData, 100500, " biz_src_jc_video");
    }
  }
  
  private void a(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new AIOVideoView.2(this, paramVideoPlayParam);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i = 1;
    if (paramInt == 0) {
      paramInt = i;
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "0", "0", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (paramInt == 3000) {
        paramInt = 3;
      } else if (paramInt == 6000) {
        paramInt = 4;
      } else {
        paramInt = -1;
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
      {
        this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.jdField_d_of_type_AndroidWidgetImageButton.setVisibility(4);
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, paramInt);
    }
  }
  
  private void b(AIOVideoData paramAIOVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.parse("file://" + paramAIOVideoData.jdField_b_of_type_JavaLangString), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.mContext.startActivity(localIntent);
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
    if (paramAIOVideoData.j == 5002)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
      QQToast.a(this.mContext, 1, HardCodeUtil.a(2131700112), 0).a();
    }
    do
    {
      return;
      if (!CheckPermission.isHasStoragePermission(this.mContext))
      {
        CheckPermission.requestStorePermission(this.mContext, null);
        return;
      }
      if (paramAIOVideoData.jdField_d_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramInt, paramFile);
        return;
      }
      if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOVideoData.jdField_c_of_type_Long))
      {
        paramAIOVideoData = new StringBuilder().append(paramFile.getParentFile().getName()).append(NetConnInfoCenter.getServerTime()).toString().toLowerCase(Locale.US) + ".mp4";
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(paramFile.getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_MqqOsMqqHandler, paramAIOVideoData, false));
        return;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(10001);
        return;
      }
      if ((!AppNetConnInfo.isWifiConn()) && (paramAIOVideoData.jdField_c_of_type_Long > 29360128L))
      {
        a(3, paramAIOVideoData, paramRichMediaBrowserInfo);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramAIOVideoData);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, 2);
      updateUI();
    } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
  }
  
  private void c(AIOVideoData paramAIOVideoData)
  {
    if ((RichMediaBrowserManager.getInstance().getProvider() != null) && (RichMediaBrowserManager.getInstance().getProvider().isPingBinder()))
    {
      Intent localIntent = RichMediaBrowserManager.getInstance().getProvider().getForwardData(paramAIOVideoData.jdField_a_of_type_Long, paramAIOVideoData.jdField_a_of_type_Int, ParamsManager.a().a());
      if (localIntent != null)
      {
        QfavBuilder.a(localIntent).a(this.mContext, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        QfavReport.a(null, 3, 0, paramAIOVideoData.jdField_b_of_type_Int);
        QfavReport.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
      }
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void i()
  {
    if (this.mBrowserItemView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131381302));
      Object localObject = (RelativeLayout)this.mBrowserItemView.findViewById(2131372607);
      this.jdField_a_of_type_AndroidViewView = ((RelativeLayout)localObject).findViewById(2131372351);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377688));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372608));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373552));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379724));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new AIOVideoView.1(this));
      this.jdField_d_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374675));
      this.jdField_d_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131700126));
      this.jdField_d_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131380972));
      this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380974));
      this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380973));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364816));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mBrowserItemView.findViewById(2131364213));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131376473));
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374674));
      this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374676));
      this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_e_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374682));
      this.jdField_e_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131364353));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.mBrowserItemView.findViewById(2131364354));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = this.mBrowserItemView.findViewById(2131381529);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.mBrowserItemView.findViewById(2131374677));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.mBrowserItemView.findViewById(2131373467));
      this.jdField_c_of_type_AndroidWidgetImageView.bringToFront();
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131373469));
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
      }
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  private void i(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(true);
    }
  }
  
  private void k()
  {
    if ((VersionUtils.b()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  private void l()
  {
    if ((VersionUtils.b()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private void m()
  {
    AIOVideoData localAIOVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
    if (localAIOVideoData != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label90;
      }
    }
    label90:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();; l = 0L)
    {
      MiniChatActivity.a(this.mContext, ParamsManager.a().a(), ParamsManager.a().a(), false, 26, localAIOVideoData.jdField_d_of_type_Long, l);
      if ((localAIOVideoData != null) && (localAIOVideoData.status == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData.jdField_a_of_type_Long, true);
        j();
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.l();
      return;
    }
  }
  
  private void n()
  {
    if ((this.mContext instanceof AIOGalleryActivity))
    {
      AIOGalleryActivity localAIOGalleryActivity = (AIOGalleryActivity)this.mContext;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!PermissionUtils.isStorePermissionEnable(this.mContext))
        {
          localAIOGalleryActivity.requestPermissions(new AIOVideoView.5(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        o();
        return;
      }
      o();
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onClick, activity:" + this.mContext);
  }
  
  private void o()
  {
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (!TextUtils.isEmpty(localAIOVideoData.jdField_g_of_type_JavaLangString)))
    {
      JumpUtil.a(this.mContext, localAIOVideoData.jdField_g_of_type_JavaLangString);
      ReportController.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.jdField_g_of_type_JavaLangString, "");
    }
  }
  
  private void p()
  {
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null) {
        break label131;
      }
    }
    label131:
    for (long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();; l = 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController = new TVKVideoController(this.mContext);
      VideoPlayMedioInfo localVideoPlayMedioInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData);
      if (localVideoPlayMedioInfo == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(localVideoPlayMedioInfo, localAIOVideoData.jdField_e_of_type_Long, l);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewTVKVideoController.a(localAIOVideoData.jdField_b_of_type_Int, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.back();
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
  }
  
  public AIOVideoData a()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 101)) {
      return (AIOVideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
        break label94;
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCurPlayingPos();
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.captureCurFrame(l, 0, 0);
    }
    for (;;)
    {
      a(localAIOVideoData, paramInt);
      return;
      label94:
      if (this.jdField_a_of_type_AndroidWidgetSeekBar.getProgress() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "showActionSheet, captureCurFrame, from:" + paramInt + ", pos:" + this.jdField_b_of_type_Long);
        }
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.captureCurFrame(this.jdField_b_of_type_Long, 0, 0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOVideoView", 0, "showActionSheet, video is not playing, recognize thumbnail");
        }
        ThreadManager.getSubThreadHandler().post(new AIOVideoView.10(this));
      }
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(DialogUtil.a(this.mContext, 230, this.mContext.getString(2131718664), this.mContext.getString(2131718663), new AIOVideoView.11(this, paramInt, paramObject), new AIOVideoView.12(this)));
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOVideoData localAIOVideoData = a();
    if ((localAIOVideoData != null) && (RichMediaBrowserManager.getInstance().getProvider() != null))
    {
      int i = RichMediaBrowserManager.getInstance().getProvider().getSaveFileProgress(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int);
      if ((i < 0) || (i >= 100)) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg isSaving:" + bool);
      if (bool)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onRevokeMsg cancelDownloadMedia");
        RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 256);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt3)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "notifyVideoUrl ");
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = a();
    if (localAIOVideoData == null) {}
    label160:
    label295:
    label305:
    for (;;)
    {
      return;
      LongVideoUrlCacheManager.a().a(localAIOVideoData.jdField_a_of_type_Long, paramArrayOfString, System.currentTimeMillis(), paramMessageForShortVideo, paramInt3, paramString2);
      paramString2 = new VideoPlayMedioInfo();
      paramString2.jdField_a_of_type_Boolean = true;
      paramString2.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      paramString2.jdField_a_of_type_Int = paramInt3;
      paramString2.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
      paramString2.jdField_b_of_type_Int = localAIOVideoData.jdField_a_of_type_Int;
      paramString1 = new File(localAIOVideoData.jdField_b_of_type_JavaLangString);
      if (paramString1.exists())
      {
        paramString2.jdField_d_of_type_Long = paramString1.length();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  " + paramString2.e);
        if (!this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition())) {
          break label295;
        }
        a(paramString2);
      }
      for (;;)
      {
        if (new AIOVideoModel().a(localAIOVideoData, 0) != null) {
          break label305;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
        if (RichMediaBrowserManager.getInstance().getProvider() == null) {
          break;
        }
        RichMediaBrowserManager.getInstance().getProvider().downloadMedia(localAIOVideoData.jdField_a_of_type_Long, localAIOVideoData.jdField_a_of_type_Int, 0);
        return;
        paramString2.jdField_d_of_type_Long = 0L;
        break label160;
        b(0);
        updateUI();
      }
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
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOVideoView.6(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setCancelListener(new AIOVideoView.7(this));
  }
  
  public void bindView(int paramInt)
  {
    super.bindView(paramInt);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getItem(paramInt);
    AIOVideoData localAIOVideoData;
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView.setOnLongClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setID(localAIOVideoData.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setId(2131374644);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setOnLongClickListener(this);
      localObject1 = new AIOVideoModel();
      this.mBrowserItemView.setTag(2131296433, Boolean.valueOf(true));
      Object localObject2 = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b.get(Integer.valueOf(paramInt));
      if ((localObject2 == null) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)) {
        break label316;
      }
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.showCover((Drawable)localObject2);
      localObject1 = "0X8009EF2";
      if (localAIOVideoData.jdField_d_of_type_Int == 1) {
        localObject1 = "0X8009EF1";
      }
      this.mBrowserItemView.setContentDescription(this.mContext.getString(2131691674));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
      if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (((RichMediaBrowserInfo)localObject2).baseData.getType() != 101) || (((AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData).jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long) || (((RichMediaBrowserInfo)localObject2).isReport)) {
        break label355;
      }
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
      ((RichMediaBrowserInfo)localObject2).isReport = true;
    }
    for (;;)
    {
      localObject1 = new AIOVideoView.GalleryVideoViewHolder(this);
      ((AIOVideoView.GalleryVideoViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      this.mBrowserItemView.setTag(localObject1);
      return;
      label316:
      if (((AIOVideoModel)localObject1).a(localAIOVideoData, 0) == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(localAIOVideoData.jdField_a_of_type_JavaLangString, localAIOVideoData.jdField_e_of_type_Int, localAIOVideoData.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getCoverImage(), paramInt);
      break;
      label355:
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void clearTheOuchCache()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b.clear();
  }
  
  public void e()
  {
    i(true);
  }
  
  public void e(boolean paramBoolean)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "doEnterImmersion, isClick:" + paramBoolean + ", hasDanmaku:" + this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.c());
    super.e(paramBoolean);
    if (paramBoolean)
    {
      showContentView(false);
      b(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(false);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.e();
      i(false);
      return;
    }
    showContentView(false);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().e();
  }
  
  public void f(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof AIOVideoView.GalleryVideoViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((AIOVideoView.GalleryVideoViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131558644, paramViewGroup, false));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView = ((GalleryUrlImageView)this.mBrowserItemView.findViewById(2131373468));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = ((BaseVideoView)QQVideoViewFactory.b(this.mContext, 0L, null, this.jdField_a_of_type_ComTencentRichmediabrowserViewGalleryUrlImageView));
      paramView = new RelativeLayout.LayoutParams(-1, -1);
      paramView.addRule(13);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
        ((RelativeLayout)this.mBrowserItemView.findViewById(2131381298)).addView(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView, paramView);
      }
      i();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isLocalPlay()) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()))
    {
      Object localObject = this.mContext.getString(2131719369);
      localObject = DialogUtil.a(this.mContext, 230, null, (String)localObject, 2131694495, 2131720765, new AIOVideoView.8(this), new AIOVideoView.9(this));
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      a((Dialog)localObject);
    }
  }
  
  public void h(boolean paramBoolean)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem();
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
              if (!ParamsManager.a().c())
              {
                i = j;
                if (CaptureUtil.a())
                {
                  i = j;
                  if (ShortVideoUtils.isAEPituTakeSameOpen())
                  {
                    i = j;
                    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
                    {
                      AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
                      i = j;
                      if (!TextUtils.isEmpty(localAIOVideoData.jdField_g_of_type_JavaLangString))
                      {
                        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
                        localObject = this.mContext.getString(2131692803);
                        if (!TextUtils.isEmpty(localAIOVideoData.h)) {
                          localObject = localAIOVideoData.h;
                        }
                        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
                        if (this.jdField_a_of_type_Long != localAIOVideoData.jdField_a_of_type_Long)
                        {
                          ReportController.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.jdField_g_of_type_JavaLangString, "");
                          this.jdField_a_of_type_Long = localAIOVideoData.jdField_a_of_type_Long;
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
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "playBar is visible");
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_AndroidWidgetSeekBar.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (new Rect(i, j, this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth() + i, this.jdField_a_of_type_AndroidWidgetSeekBar.getHeight() + j).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "playBar deal event");
        g();
        return true;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "recyclerView deal event");
    }
    return super.isNeedDisallowInterceptEvent(paramMotionEvent);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
        j();
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.i();
        f();
        break;
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition(), false);
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a();
          d();
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().f();
          break;
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().b();
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().jdField_a_of_type_Boolean = true;
          e(true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.back();
      continue;
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
      if ((localObject != null) && (((AIOVideoData)localObject).status != 2)) {
        a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition(), false);
      }
      g();
      continue;
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
      {
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        if (RichMediaBrowserManager.getInstance().getProvider() != null) {
          RichMediaBrowserManager.getInstance().getProvider().cancelDownloadMedia(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 256);
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
        updateUI();
        continue;
        p();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.k();
        continue;
        c();
        continue;
        b();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("AIOVideoView", 0, "onClick qq_gallery_danmaku_view ");
        }
        m();
        continue;
        if (this.basePresenter != null)
        {
          this.basePresenter.back();
          continue;
          n();
        }
      }
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b.remove(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onEnterAnimationEnd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onEnterAnimationEnd");
    }
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onEnterAnimationStart");
    }
    showContentView(false);
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    bindView(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getItem(paramInt);
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject).jdField_a_of_type_Long, ((AIOVideoData)localObject).jdField_a_of_type_Int, 0);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(paramInt)) {
        a(paramInt, true);
      }
    }
    else
    {
      return;
    }
    updateUI();
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPause");
    j();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
      {
        paramInt = (int)(paramInt / 10000.0F * (float)this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs());
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.seekTo(paramInt);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(paramInt));
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.j();
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition())) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null))
    {
      AIOVideoData localAIOVideoData = a();
      if ((localAIOVideoData != null) && (localAIOVideoData.status == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.resume();
      }
    }
  }
  
  public void onScrollEnd()
  {
    super.onScrollEnd();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(false);
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onScrollHalfScreenWidth");
    }
    super.onScrollHalfScreenWidth();
    if ((this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.mIsPlayVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStop");
    clearTheOuchCache();
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.releasePlayer(true);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getCurrentPosition())) && (paramSeekBar != null))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a(paramSeekBar.getProgress());
      AIOVideoData localAIOVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a();
      if (localAIOVideoData != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a().a(BrowserDanmakuUtils.a(localAIOVideoData.jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
      }
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    Object localObject1 = a();
    c(b());
    d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedItem()));
    h(true);
    if (localObject1 != null) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI id = " + ((AIOVideoData)localObject1).id + ", status = " + ((AIOVideoData)localObject1).status);
    }
    switch (((AIOVideoData)localObject1).status)
    {
    case 7: 
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI status is error, status = " + ((AIOVideoData)localObject1).status);
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 5: 
    case 6: 
    case 8: 
      label506:
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
          g(false);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(false);
          return;
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), true);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131700153) + ((AIOVideoData)localObject1).progress + "%");
          this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(((AIOVideoData)localObject1).progress * 100);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          g(false);
          f(true);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(true);
          return;
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadStart(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          g(false);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          a(false);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying()) {
              break label506;
            }
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), true);
            g(true);
            f(false);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            a(true);
            return;
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), true);
          g(true);
          f(false);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846433);
          a(true);
        } while (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null);
        long l = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.getVideoDurationMs();
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(l));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
        return;
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), true);
        g(true);
        f(false);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846432);
        a(true);
        return;
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), true);
        g(false);
        f(false);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846432);
        a(false);
        localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131366426);
      } while (localObject2 == null);
      if (!TextUtils.isEmpty(((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString)) {}
      for (localObject1 = ((AIOVideoData)localObject1).jdField_f_of_type_JavaLangString;; localObject1 = this.mContext.getString(2131719377))
      {
        ((TextView)localObject2).setText((CharSequence)localObject1);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getSelectedIndex(), true);
    g(false);
    f(false);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
    if (((AIOVideoData)localObject1).jdField_f_of_type_Boolean) {}
    for (;;)
    {
      ((ImageView)localObject2).setVisibility(i);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846432);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(0L));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
      a(true);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.getItem(paramInt);
    if ((localObject2 == null) || (((RichMediaBrowserInfo)localObject2).baseData == null) || (paramView == null)) {
      return;
    }
    if ((paramView.getTag() instanceof AIOVideoView.GalleryVideoViewHolder))
    {
      Object localObject1 = ((AIOVideoView.GalleryVideoViewHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101)
      {
        localObject2 = (AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData;
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateView loadShortVideoCover");
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a(((AIOVideoData)localObject2).jdField_a_of_type_JavaLangString, ((AIOVideoData)localObject2).jdField_e_of_type_Int, ((AIOVideoData)localObject2).jdField_f_of_type_Int, ((BaseVideoView)localObject1).getCoverImage(), paramInt);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.b(paramInt))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOVideoPresenter.a((AIOVideoData)localObject2);
          if (localObject1 != null) {
            a((VideoPlayMedioInfo)localObject1);
          }
        }
      }
    }
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView
 * JD-Core Version:    0.7.0.1
 */