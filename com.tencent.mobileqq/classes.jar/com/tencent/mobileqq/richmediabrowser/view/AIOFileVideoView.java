package com.tencent.mobileqq.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqvideoplatform.VideoPlatformUtils;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils;
import com.tencent.mobileqq.richmediabrowser.IProvider;
import com.tencent.mobileqq.richmediabrowser.ImmersionHelper;
import com.tencent.mobileqq.richmediabrowser.ParamsManager;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.richmediabrowser.api.IVideoDepend;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel;
import com.tencent.mobileqq.richmediabrowser.model.VideoPlayMedioInfo;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOFileVideoPresenter;
import com.tencent.mobileqq.richmediabrowser.qqfloatingscreen.TVKVideoController;
import com.tencent.mobileqq.richmediabrowser.utils.LongVideoUrlCacheManager;
import com.tencent.mobileqq.richmediabrowser.utils.RichMediaBrowserUtils;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
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
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import com.tencent.richmediabrowser.view.video.VideoView;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.PermissionUtil;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class AIOFileVideoView
  extends AIOBrowserBaseView
  implements View.OnClickListener, VideoPlayerCallback, IVideoViewClickEvent
{
  private long jdField_a_of_type_Long = -1L;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public SeekBar a;
  public TextView a;
  private IProvider jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
  public AIOFileVideoPresenter a;
  private TVKVideoController jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam;
  public VideoView a;
  public String a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  public RelativeLayout b;
  private String jdField_b_of_type_JavaLangString = "";
  ArrayList<ShareActionSheetBuilder.ActionSheetItem> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  public int c;
  ArrayList<ShareActionSheetBuilder.ActionSheetItem> c;
  public ImageButton d;
  public ImageButton e;
  
  public AIOFileVideoView(Context paramContext, AIOFileVideoPresenter paramAIOFileVideoPresenter)
  {
    super(paramContext, paramAIOFileVideoPresenter);
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter = paramAIOFileVideoPresenter;
  }
  
  private int a(int paramInt)
  {
    int i = 6;
    if (paramInt != 2) {
      if (paramInt != 6) {
        if (paramInt != 27) {
          if (paramInt != 39) {
            if (paramInt != 64) {
              if (paramInt != 132) {
                if ((paramInt == 72) || (paramInt == 73)) {}
              }
            }
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      break;
    case 56: 
      return 9;
    case 55: 
      return 8;
      return -1;
      return 13;
      return 11;
      return 2;
      return 5;
      return 3;
      i = 1;
    }
    return i;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "drawable2Bitmap, drawable is null");
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
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = (paramVideoPlayMedioInfo.jdField_a_of_type_Boolean ^ true);
    if (!localVideoPlayParam.mIsLocal)
    {
      if (paramVideoPlayMedioInfo.jdField_a_of_type_AndroidOsBundle != null)
      {
        localVideoPlayParam.mSavePath = paramVideoPlayMedioInfo.jdField_a_of_type_AndroidOsBundle.getString("savepath");
        localVideoPlayParam.mFileID = paramVideoPlayMedioInfo.jdField_a_of_type_AndroidOsBundle.getString("fileid");
      }
      else
      {
        QLog.e("AIOFileVideoView<FileAssistant>XOXO", 1, "bundle is null!!!");
      }
      localVideoPlayParam.mUrls = paramVideoPlayMedioInfo.jdField_a_of_type_ArrayOfJavaLangString;
      localVideoPlayParam.mCookies = paramVideoPlayMedioInfo.jdField_a_of_type_JavaUtilArrayList;
      localVideoPlayParam.mVideoFormat = 104;
      d(1);
    }
    else
    {
      localVideoPlayParam.mVideoPath = paramVideoPlayMedioInfo.jdField_a_of_type_JavaLangString;
      d(3);
    }
    localVideoPlayParam.mIsMute = paramVideoPlayMedioInfo.jdField_e_of_type_Boolean;
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = SceneID.a(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    return localVideoPlayParam;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 6)
              {
                if (paramInt != 7) {
                  return "undefine";
                }
                return "Saving";
              }
              return "Error";
            }
            return "Pause";
          }
          return "Playing";
        }
        return "Buffering";
      }
      return "Downloading";
    }
    return "Nomal";
  }
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    AIOFileVideoData localAIOFileVideoData = a();
    boolean bool2 = false;
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 2)
    {
      localObject1 = new AIOFileVideoModel().a(localAIOFileVideoData, localAIOFileVideoData.i);
      if ((localObject1 != null) && (((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ArrayOfJavaLangString != null) && (!StringUtil.a(((VideoPlayMedioInfo)localObject1).jdField_b_of_type_JavaLangString)))
      {
        localObject2 = ((VideoPlayMedioInfo)localObject1).jdField_a_of_type_ArrayOfJavaLangString;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject2[i];
          if (!StringUtil.a(str)) {
            BaseInnerDns.getInstance().reportBadIp(((VideoPlayMedioInfo)localObject1).jdField_b_of_type_JavaLangString, BaseInnerDns.getHostFromUrl(str), ((IVideoDepend)QRoute.api(IVideoDepend.class)).getVideoIpType());
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
    if (localAIOFileVideoData != null)
    {
      if (localObject1 == null) {
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718267);
      }
      localAIOFileVideoData.jdField_f_of_type_JavaLangString = ((String)localObject1);
      localAIOFileVideoData.jdField_g_of_type_Int += 1;
      localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handlePlayError, videoData.mPlayErrTimes = ");
      ((StringBuilder)localObject2).append(localAIOFileVideoData.jdField_g_of_type_Int);
      ((IBrowserLog)localObject1).d("AIOFileVideoView<FileAssistant>XOXO", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool1 = bool2;
    if (paramVideoPlayParam != null)
    {
      bool1 = bool2;
      if (paramVideoPlayParam.mVideoPath != null)
      {
        bool1 = bool2;
        if (paramVideoPlayParam.mVideoPath.startsWith(AppConstants.SDCARD_FILE_SAVE_PATH)) {
          bool1 = VideoPlatformUtils.a(paramInt2, paramVideoPlayParam);
        }
      }
    }
    if ((bool1) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (localAIOFileVideoData != null) && (localAIOFileVideoData.jdField_g_of_type_Int < 2))
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 2, "handlePlayError, auto replay video.");
      ThreadManager.getUIHandler().post(new AIOFileVideoView.2(this, localAIOFileVideoData));
      return;
    }
    ThreadManager.getUIHandler().post(new AIOFileVideoView.3(this));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryPlayVideo, position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 103))
    {
      localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, String.format("tryPlayVideo, position:%d , msgId:%s request:%b ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(((AIOFileVideoData)localObject).jdField_a_of_type_Long), Boolean.valueOf(((AIOFileVideoData)localObject).jdField_d_of_type_Boolean) }));
      }
      ((AIOFileVideoData)localObject).jdField_h_of_type_Boolean = paramBoolean;
      AIOFileVideoModel localAIOFileVideoModel = new AIOFileVideoModel();
      if ((!localAIOFileVideoModel.a((AIOFileVideoData)localObject)) && (!((AIOFileVideoData)localObject).jdField_d_of_type_Boolean))
      {
        localAIOFileVideoModel.a((AIOFileVideoData)localObject, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a((AIOFileVideoData)localObject);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(((AIOFileVideoData)localObject).jdField_a_of_type_Long, ((AIOFileVideoData)localObject).jdField_a_of_type_Int, 1);
        a();
        return;
      }
      a(localAIOFileVideoModel.a((AIOFileVideoData)localObject, ((AIOFileVideoData)localObject).i));
      if ((((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) && (((AIOFileVideoData)localObject).jdField_d_of_type_JavaLangString != null)) {
        d(3);
      }
      a();
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, videoFrame null");
      }
      return;
    }
    try
    {
      Object localObject1 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("tmpaiovideoframe.jpg");
      localObject1 = new File(((StringBuilder)localObject2).toString());
      if (!((File)localObject1).exists()) {
        ((File)localObject1).createNewFile();
      }
      this.jdField_b_of_type_JavaLangString = ((File)localObject1).getAbsolutePath();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onVideoFrameCallBack, write tmp file:");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, ((StringBuilder)localObject1).toString());
      }
      RichMediaBrowserUtils.a(paramBitmap, this.jdField_b_of_type_JavaLangString);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    ArrayList localArrayList = new ArrayList();
    Pair localPair2 = ((IFileDepend)QRoute.api(IFileDepend.class)).getDetectCode(paramBitmap);
    paramBitmap = localPair2.first;
    Object localObject2 = "";
    Object localObject4 = null;
    Object localObject3 = null;
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected QRCode, build item");
      }
      if ((localPair2.first instanceof Pair))
      {
        Pair localPair1 = (Pair)localPair2.first;
        try
        {
          paramBitmap = new JSONObject();
          try
          {
            paramBitmap.put("scannerType", String.valueOf(localPair1.second).trim());
            paramBitmap.put("scannerResult", String.valueOf(localPair1.first).trim());
          }
          catch (JSONException localJSONException1) {}
          localJSONException2.printStackTrace();
        }
        catch (JSONException localJSONException2)
        {
          paramBitmap = null;
        }
      }
      else
      {
        paramBitmap = null;
      }
      if (paramBitmap == null) {
        paramBitmap = "";
      } else {
        paramBitmap = paramBitmap.toString();
      }
      RichMediaBrowserUtils.a(126, localArrayList, paramBitmap, 0);
    }
    if (localPair2.second != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected MiniCode, build item");
      }
      paramBitmap = localObject4;
      if ((localPair2.second instanceof String)) {
        try
        {
          String str = (String)localPair2.second;
          paramBitmap = new JSONObject();
          try
          {
            paramBitmap.put("strMini", str);
          }
          catch (JSONException localJSONException3) {}
          localJSONException4.printStackTrace();
        }
        catch (JSONException localJSONException4)
        {
          paramBitmap = localObject3;
        }
      }
      if (paramBitmap == null) {
        paramBitmap = (Bitmap)localObject2;
      } else {
        paramBitmap = paramBitmap.toString();
      }
      RichMediaBrowserUtils.a(127, localArrayList, paramBitmap, 0);
    }
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected nothing");
      }
    }
    else {
      ThreadManager.getUIHandler().post(new AIOFileVideoView.4(this, localArrayList));
    }
  }
  
  private void a(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam = a(paramVideoPlayMedioInfo);
    this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.setVideoPlayCallback(this);
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)
    {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.setVideoPlayCallback(this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.setVideoParam(this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.play();
    }
  }
  
  private boolean a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    if ((paramAIOFileVideoData.jdField_f_of_type_Long == -7003L) || (paramAIOFileVideoData.jdField_f_of_type_Long == -6101L) || (paramAIOFileVideoData.jdField_f_of_type_Long == -103L) || (paramAIOFileVideoData.jdField_f_of_type_Long == -301L)) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)))
      {
        if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_c_of_type_JavaLangString)) {
          return false;
        }
        this.e.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.e.setVisibility(4);
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 3000) {
      return 3;
    }
    return 9;
  }
  
  private void b(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((!PermissionUtil.a(this.jdField_a_of_type_AndroidContentContext)) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, null);
      return;
    }
    if (new AIOFileVideoModel().a(paramAIOFileVideoData))
    {
      ((IFileDepend)QRoute.api(IFileDepend.class)).saveToAlbum(this.jdField_a_of_type_AndroidContentContext, paramAIOFileVideoData.jdField_c_of_type_JavaLangString);
      return;
    }
    Bundle localBundle = new Bundle();
    IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    if (localIProvider != null) {
      localIProvider.a(paramAIOFileVideoData.jdField_a_of_type_Long, 13, localBundle);
    }
    paramAIOFileVideoData.j = true;
    a(paramAIOFileVideoData.jdField_a_of_type_Long, paramAIOFileVideoData.jdField_a_of_type_Int);
    a();
  }
  
  private void b(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    String str;
    if (MessageRecordInfo.a(paramAIOFileVideoData.jdField_f_of_type_Int)) {
      str = ParamsManager.a().d();
    } else {
      str = ParamsManager.a().c();
    }
    ((IVideoDepend)QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramAIOFileVideoData.jdField_e_of_type_Int, true, str, null, null, paramAIOFileVideoData.jdField_h_of_type_JavaLangString, paramInt, ParamsManager.a().d(), ParamsManager.a().c());
  }
  
  private boolean c()
  {
    IProvider localIProvider = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider;
    return (localIProvider != null) && (localIProvider.a());
  }
  
  private void d(int paramInt)
  {
    AIOFileVideoData localAIOFileVideoData = a();
    if (localAIOFileVideoData != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, paramInt);
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
    Object localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if (localObject != null) {
      ((VideoView)localObject).pauseVideo();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
    if (((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(true);
    }
  }
  
  private void r()
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
    if (localAIOFileVideoData != null)
    {
      if (!FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString)) {
        return;
      }
      TVKVideoController localTVKVideoController = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController;
      if (localTVKVideoController != null) {
        localTVKVideoController.b();
      }
      long l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController = new TVKVideoController(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController.a(localAIOFileVideoData.jdField_c_of_type_JavaLangString, localAIOFileVideoData.jdField_a_of_type_Long, l);
      if (FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController.a(localAIOFileVideoData.jdField_b_of_type_JavaLangString, localAIOFileVideoData.jdField_c_of_type_Int, localAIOFileVideoData.jdField_d_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserQqfloatingscreenTVKVideoController.a(localAIOFileVideoData.jdField_b_of_type_Int, localAIOFileVideoData.jdField_c_of_type_Int, localAIOFileVideoData.jdField_d_of_type_Int)) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.d();
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
    j();
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.videoControlContainer != null) {
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.videoControlContainer.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    return this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mBrowserItemView;
  }
  
  public AIOFileVideoData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView != null))
    {
      c(b());
      d(a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem()));
      Object localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI id = ");
      localStringBuilder.append(((AIOFileVideoData)localObject1).id);
      localStringBuilder.append(", status = ");
      localStringBuilder.append(((AIOFileVideoData)localObject1).a());
      ((IBrowserLog)localObject2).d("AIOFileVideoView<FileAssistant>XOXO", 4, localStringBuilder.toString());
      int j = ((AIOFileVideoData)localObject1).status;
      int i = 8;
      if (j != 0)
      {
        float f;
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
                    localStringBuilder.append(((AIOFileVideoData)localObject1).status);
                    ((IBrowserLog)localObject2).d("AIOFileVideoView<FileAssistant>XOXO", 4, localStringBuilder.toString());
                    return;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
                  f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long * 100.0F;
                  localObject1 = new DecimalFormat("0.00").format(f);
                  localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131718262));
                  localStringBuilder.append((String)localObject1);
                  localStringBuilder.append("%");
                  ((TextView)localObject2).setText(localStringBuilder.toString());
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)f * 100);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
                  g(true);
                  d(false);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
                  this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
                  a(false);
                  return;
                }
                this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
                if (((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean)
                {
                  g(false);
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131718238));
                  ((StringBuilder)localObject2).append("(");
                  ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).jdField_g_of_type_Long));
                  ((StringBuilder)localObject2).append("/");
                  ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).jdField_c_of_type_Long));
                  ((StringBuilder)localObject2).append(")");
                  localObject2 = ((StringBuilder)localObject2).toString();
                  this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                  this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                  f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long;
                  this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(f * 100.0F) * 100);
                  g(true);
                }
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(0);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
                this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846308);
                a(false);
                return;
              }
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
              g(false);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(0);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846308);
              a(true);
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(true);
            g(false);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846309);
            a(true);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.coverView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)
            {
              long l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getVideoDurationMs();
              localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("videoDuration = ");
              ((StringBuilder)localObject2).append(l);
              ((IBrowserLog)localObject1).d("AIOFileVideoView<FileAssistant>XOXO", 4, ((StringBuilder)localObject2).toString());
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.totalTime.setText(BrowserUtils.a(l));
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.progressTime.setText(BrowserUtils.a(0L));
            }
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying()) {
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(0);
            } else {
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
            if (((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean)
            {
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(true);
              g(false);
            }
            else
            {
              g(true);
              this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
              d(false);
            }
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
            this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
            a(true);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131718238));
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).jdField_g_of_type_Long));
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).jdField_c_of_type_Long));
          ((StringBuilder)localObject2).append(")");
          localObject2 = ((StringBuilder)localObject2).toString();
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          f = (float)((AIOFileVideoData)localObject1).jdField_g_of_type_Long / (float)((AIOFileVideoData)localObject1).jdField_c_of_type_Long;
          this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(f * 100.0F) * 100);
          g(true);
          d(false);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn.setVisibility(8);
          a(false);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), true);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.showPlayPanel(false);
        g(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.bufferPanel.setVisibility(8);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mErrLayout.setVisibility(8);
        localObject2 = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mCenterPlayBtn;
        if (!((AIOFileVideoData)localObject1).jdField_h_of_type_Boolean) {
          i = 0;
        }
        ((ImageView)localObject2).setVisibility(i);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playButton.setImageResource(2130846308);
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.progressTime.setText(BrowserUtils.a(0L));
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playBar.setProgress(0);
        if (((AIOFileVideoData)localObject1).jdField_f_of_type_Boolean) {
          a(true);
        } else {
          a(false);
        }
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.coverView.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if (localRichMediaBrowserInfo != null)
    {
      if (localRichMediaBrowserInfo.baseData == null) {
        return;
      }
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
        if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103) && (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject1).baseData).jdField_a_of_type_Long == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long) && (!((RichMediaBrowserInfo)localObject1).isReport))
        {
          ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 1, 0, "", "", "", "");
          ((RichMediaBrowserInfo)localObject1).isReport = true;
        }
        else
        {
          ReportController.b(null, "dc00898", "", "", "0X8009EF3", "0X8009EF3", 2, 0, "", "", "", "");
        }
        AIOFileVideoData localAIOFileVideoData = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
        AIOFileVideoModel localAIOFileVideoModel = new AIOFileVideoModel();
        localObject1 = (Drawable)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
        if (!localAIOFileVideoModel.b(localAIOFileVideoData)) {
          if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.onLoadFinish(paramInt, true);
          }
          else if (!TextUtils.isEmpty(localAIOFileVideoData.jdField_b_of_type_JavaLangString))
          {
            Object localObject2 = new File(localAIOFileVideoData.jdField_b_of_type_JavaLangString);
            if (((File)localObject2).exists())
            {
              localObject1 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.jdField_a_of_type_Int;
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.jdField_b_of_type_Int;
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
              ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
              ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
              localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
              localObject2 = (URLDrawable)localObject1;
              ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.put(Integer.valueOf(paramInt), localObject2);
            }
          }
          else
          {
            localObject1 = BaseApplication.getContext().getResources().getDrawable(2130849901);
          }
        }
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.coverView.setImageDrawable((Drawable)localObject1);
        if (localAIOFileVideoModel.b(localAIOFileVideoData)) {
          this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.coverView.setImageDrawable(null);
        }
        if (localRichMediaBrowserInfo.isEnterImage) {
          localAIOFileVideoData.jdField_g_of_type_Boolean = true;
        }
        localObject1 = new AIOFileVideoView.GalleryFileVideoViewHolder(this);
        ((AIOFileVideoView.GalleryFileVideoViewHolder)localObject1).a = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView;
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mBrowserItemView.setTag(localObject1);
      }
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt2, Bundle paramBundle)
  {
    paramString2 = BrowserLogHelper.getInstance().getGalleryLog();
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("setVideoDrawableWithUrls position = ");
    paramMessageRecord.append(paramInt1);
    paramString2.d("AIOFileVideoView<FileAssistant>XOXO", 4, paramMessageRecord.toString());
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt1);
    if (localRichMediaBrowserInfo != null)
    {
      if (localRichMediaBrowserInfo.baseData == null) {
        return;
      }
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        paramString2 = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
        paramString2.jdField_a_of_type_AndroidOsBundle = paramBundle;
        paramMessageRecord = new AIOFileVideoModel();
        if (paramString2.jdField_d_of_type_Boolean)
        {
          paramString1 = BrowserLogHelper.getInstance().getGalleryLog();
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("fileVideo is playing:");
          paramArrayOfString.append(paramString2.id);
          paramString1.d("AIOFileVideoView<FileAssistant>XOXO", 4, paramArrayOfString.toString());
          return;
        }
        paramString2.jdField_c_of_type_JavaLangString = paramString1;
        paramString2.jdField_d_of_type_Boolean = true;
        if (!"I:E".equals(paramString1)) {}
      }
    }
    try
    {
      paramString2.jdField_f_of_type_Long = Long.parseLong(paramArrayOfString[0]);
      paramString1 = paramArrayOfString[1];
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).jdField_f_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int, 6);
      boolean bool;
      if (((IFileDepend)QRoute.api(IFileDepend.class)).isVideoFileError(paramString2.jdField_f_of_type_Long))
      {
        paramString1 = this.jdField_a_of_type_AndroidContentContext.getString(2131718274);
        bool = true;
      }
      else
      {
        bool = a(paramString2, false);
      }
      if (!bool) {
        break label344;
      }
      paramString1 = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "", paramString1, null, this.jdField_a_of_type_AndroidContentContext.getString(2131718246), new AIOFileVideoView.1(this), null);
      if (!paramString1.isShowing()) {
        paramString1.show();
      }
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label336:
      break label336;
    }
    paramString2.jdField_f_of_type_Long = -1L;
    label344:
    paramString2.jdField_e_of_type_JavaLangString = paramArrayOfString[1];
    break label376;
    paramString2.jdField_d_of_type_JavaLangString = paramArrayOfString[0];
    paramString2.jdField_a_of_type_JavaUtilArrayList = paramBundle.getStringArrayList("cookies");
    label376:
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int, 0);
    paramString1 = paramMessageRecord.a(paramString2, paramString2.i);
    paramArrayOfString = BrowserLogHelper.getInstance().getGalleryLog();
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("setVideoDrawableWithUrls autoPlay id = ");
    paramMessageRecord.append(paramString2.id);
    paramArrayOfString.d("AIOFileVideoView<FileAssistant>XOXO", 4, paramMessageRecord.toString());
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(paramString2.jdField_a_of_type_Long, paramString2.jdField_a_of_type_Int, 3);
    a(paramString1);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      if ((this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying())) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.pause();
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onRevokeMsg exp!");
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(paramLong, paramInt, 7);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedIndex(), paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3, paramBundle);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_c_of_type_Int = (ViewUtils.a() / 2);
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) && ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a() instanceof IProvider))) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = ((IProvider)this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.getParamsBuilder().a());
    }
  }
  
  public void a(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onStopTrackingTouch");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a() != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
      if ((((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) && (paramSeekBar != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "seek danmaku");
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().a(paramSeekBar.getProgress());
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().a(BrowserDanmakuUtils.a(((AIOFileVideoData)localObject).jdField_d_of_type_Long, paramSeekBar.getProgress(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
        }
      }
    }
  }
  
  public void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.l();
    }
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new AIOFileVideoView.6(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent() != null)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    RichMediaBrowserUtils.a(2, this.jdField_b_of_type_JavaUtilArrayList);
    RichMediaBrowserUtils.a(27, this.jdField_b_of_type_JavaUtilArrayList);
    if ((paramAIOFileVideoData.isLocal) || (paramAIOFileVideoData.jdField_f_of_type_Boolean)) {
      RichMediaBrowserUtils.a(64, this.jdField_b_of_type_JavaUtilArrayList);
    }
    RichMediaBrowserUtils.a(39, this.jdField_c_of_type_JavaUtilArrayList);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider.a(paramAIOFileVideoData.jdField_a_of_type_Long)) {
      RichMediaBrowserUtils.a(6, this.jdField_c_of_type_JavaUtilArrayList);
    }
    if ((ParamsManager.a().g()) && (!TextUtils.isEmpty(ParamsManager.a().c()))) {
      RichMediaBrowserUtils.a(54, this.jdField_c_of_type_JavaUtilArrayList);
    }
    if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying())
    {
      long l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.captureCurFrame(l, 0, 0);
    }
    else if (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playBar.getProgress() > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheet, captureCurFrame, from:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", pos:");
        localStringBuilder.append(this.jdField_a_of_type_Long);
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.captureCurFrame(this.jdField_a_of_type_Long, 0, 0);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "showActionSheet, video is not playing, recognize thumbnail");
      }
      ThreadManager.getSubThreadHandler().post(new AIOFileVideoView.5(this));
    }
    if (((paramAIOFileVideoData.isLocal) || (paramAIOFileVideoData.jdField_f_of_type_Boolean)) && (QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidContentContext, paramAIOFileVideoData.jdField_c_of_type_JavaLangString))) {
      RichMediaBrowserUtils.a(132, this.jdField_c_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    this.jdField_a_of_type_JavaLangString = null;
    a(paramAIOFileVideoData);
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(paramAIOFileVideoData, (Activity)this.jdField_a_of_type_AndroidContentContext);
      if (paramAIOFileVideoData != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramAIOFileVideoData);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_c_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
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
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
    if (localObject != null) {
      ((AIOFileVideoPresenter)localObject).c(a());
    }
    super.b();
    localObject = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if (localObject != null) {
      ((VideoView)localObject).onDestroy();
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    a(paramInt);
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onItemSelected position = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((IBrowserLog)localObject1).d("AIOFileVideoView<FileAssistant>XOXO", 4, ((StringBuilder)localObject2).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getItem(paramInt);
    if (localObject1 != null)
    {
      if (((RichMediaBrowserInfo)localObject1).baseData == null) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103)
      {
        localObject2 = (AIOFileVideoData)((RichMediaBrowserInfo)localObject1).baseData;
        AIOFileVideoModel localAIOFileVideoModel = new AIOFileVideoModel();
        if ((((AIOFileVideoData)localObject2).jdField_h_of_type_Boolean) && (localAIOFileVideoModel.a((AIOFileVideoData)localObject2)))
        {
          a(paramInt, true);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(((AIOFileVideoData)localObject2).jdField_a_of_type_Long, ((AIOFileVideoData)localObject2).jdField_a_of_type_Int, 0);
        if (((RichMediaBrowserInfo)localObject1).isEnterImage) {
          ((AIOFileVideoData)localObject2).jdField_g_of_type_Boolean = true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider != null)
        {
          if (((AIOFileVideoData)localObject2).jdField_h_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(((AIOFileVideoData)localObject2).jdField_a_of_type_Long, ((AIOFileVideoData)localObject2).jdField_a_of_type_Int, 1);
            localAIOFileVideoModel.a((AIOFileVideoData)localObject2, this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserIProvider);
          }
          if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject2).jdField_c_of_type_JavaLangString))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
            if (((AIOFileVideoPresenter)localObject1).a(((AIOFileVideoPresenter)localObject1).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
              this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(false);
            }
          }
          a();
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "FileVideo_AP onItemSelected needUrl return");
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.b(paramInt)) && (((RichMediaBrowserInfo)localObject1).isEnterImage)) {
          a(localAIOFileVideoModel.a((AIOFileVideoData)localObject2, ((AIOFileVideoData)localObject2).i));
        }
        if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject2).jdField_c_of_type_JavaLangString))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
          if (((AIOFileVideoPresenter)localObject1).a(((AIOFileVideoPresenter)localObject1).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) {
            this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(false);
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList = null;
        this.jdField_a_of_type_JavaLangString = null;
        a();
      }
    }
  }
  
  public boolean b()
  {
    if (super.b())
    {
      AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
      if ((localAIOFileVideoData != null) && (!ParamsManager.a().d()) && (FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.jdField_c_of_type_JavaLangString))) {
        return true;
      }
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
    if (localAIOFileVideoData != null) {
      a(localAIOFileVideoData, paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doEnterImmersion, isClick = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ,  isShowingDanmaku =");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a() != null) {
        bool = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().b();
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, localStringBuilder.toString());
    }
    super.e(paramBoolean);
    if (paramBoolean)
    {
      f(false);
      b(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.b(false);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.e();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.f();
      i(false);
      return;
    }
    f(false);
    b(false);
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
    h(b());
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      if (paramBoolean)
      {
        localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 49.0F, localDisplayMetrics));
        return;
      }
      localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 10.0F, localDisplayMetrics));
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372191);
      this.e = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374213));
      this.e.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131718239));
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.initContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131380237));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380239));
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(10000);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380238));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131364704));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374212));
      if (this.jdField_c_of_type_AndroidWidgetImageButton != null) {
        this.jdField_c_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374214));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      }
      this.d = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374220));
      this.d.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380764);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374215));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.jdField_a_of_type_Int;
        localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
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
  
  public void k()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onResume");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
    if ((((AIOFileVideoPresenter)localObject).b(((AIOFileVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition())) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
      if ((localObject != null) && (((AIOFileVideoData)localObject).status == 4)) {
        this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.resume();
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.c(a());
  }
  
  public void m()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition(), true);
  }
  
  public void n()
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
    if ((this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.isPlaying()))
    {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video playing, try PAUSE!");
      q();
    }
    else
    {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video pause, try PLAY!");
      new AIOFileVideoModel().a(localAIOFileVideoData, this.jdField_a_of_type_AndroidContentContext, this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.k();
    }
    h();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.b())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().f();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().jdField_a_of_type_Boolean = false;
        f();
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().a();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().f();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().b();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().jdField_a_of_type_Boolean = true;
      e(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.d();
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
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, localStringBuilder.toString());
    }
    a(paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131364704)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
      if (localObject != null)
      {
        ((AIOFileVideoData)localObject).jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(((AIOFileVideoData)localObject).jdField_a_of_type_Long, ((AIOFileVideoData)localObject).jdField_a_of_type_Int, 0);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.b((AIOFileVideoData)localObject);
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.d();
      }
    }
    else if (i == 2131374213)
    {
      r();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter.m();
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
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onClick qq_gallery_danmaku_view ");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
      if ((localObject != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        long l = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos();
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.jdField_a_of_type_AndroidContentContext, ParamsManager.a().a(), ParamsManager.a().a(), false, ((AIOFileVideoData)localObject).jdField_d_of_type_Long, l);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.i();
    }
    else if (i == 2131374220)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
      if (localObject != null) {
        ((AIOFileVideoPresenter)localObject).d();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("@@@@@@@@@@@ videoView Download Success:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
    localObject = a();
    if (!((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.d((AIOFileVideoData)localObject);
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    f(true);
    a();
  }
  
  public void onEnterAnimationStart()
  {
    f(false);
  }
  
  public void onExitAnimationStart() {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstFrameRendered, id:");
      localStringBuilder.append(paramLong);
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, localStringBuilder.toString());
    }
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
    localIBrowserLog.e("AIOFileVideoView<FileAssistant>XOXO", 1, localStringBuilder.toString());
    a(paramInt1, paramInt3, this.jdField_a_of_type_ComTencentMobileqqVideoplatformApiVideoPlayParam);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong2;
    VideoView localVideoView = this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView;
    if (localVideoView != null)
    {
      double d1 = paramLong2;
      double d2 = localVideoView.mVideoView.getVideoDurationMs();
      Double.isNaN(d1);
      Double.isNaN(d2);
      int i = (int)(d1 / d2 * 10000.0D);
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.progressTime.setText(BrowserUtils.a(paramLong2));
      this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.playBar.setProgress(i);
    }
  }
  
  public void onScrollEnd()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
    if (((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
      if (localObject != null) {
        FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject).jdField_c_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(false);
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onScrollHalfScreenWidth");
    }
    if ((this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.mIsPlayVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.c(a());
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateChange , state = ");
      ((StringBuilder)localObject).append(a(paramInt));
      ((StringBuilder)localObject).append(", msgUniseq=");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, ((StringBuilder)localObject).toString());
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
            localObject = a();
            if (localObject != null) {
              ((AIOFileVideoData)localObject).jdField_f_of_type_Boolean = true;
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
      localObject = a();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStateChange , state = ");
        ((StringBuilder)localObject).append(a(paramInt));
        ((StringBuilder)localObject).append(", msgUniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" get videoData is null!");
        QLog.w("AIOFileVideoView<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (((AIOFileVideoData)localObject).jdField_f_of_type_Boolean) {
        d(3);
      } else {
        d(1);
      }
      a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.b(((AIOFileVideoData)localObject).jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(((AIOFileVideoData)localObject).jdField_a_of_type_Long);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter;
      if (((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition()))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getSelectedItem();
        if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) && (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a() != null) && (this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView != null)) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a().a(BrowserDanmakuUtils.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentRichmediabrowserViewVideoVideoView.mVideoView.getCurPlayingPos(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap));
        }
      }
    }
  }
  
  public void p()
  {
    AIOFileVideoData localAIOFileVideoData = this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a();
    if (localAIOFileVideoData == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().e("AIOFileVideoView<FileAssistant>XOXO", 1, "presenter get data is null");
      return;
    }
    AIOFileVideoModel localAIOFileVideoModel = new AIOFileVideoModel();
    IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemClick id = ");
    localStringBuilder.append(localAIOFileVideoData.id);
    localIBrowserLog.d("AIOFileVideoView<FileAssistant>XOXO", 4, localStringBuilder.toString());
    if (localAIOFileVideoModel.a(localAIOFileVideoData)) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 3);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.a(localAIOFileVideoData.jdField_a_of_type_Long, localAIOFileVideoData.jdField_a_of_type_Int, 1);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOFileVideoPresenter.jdField_a_of_type_ComTencentRichmediabrowserPresenterBrowserBasePresenter.getCurrentPosition(), false);
    i();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView
 * JD-Core Version:    0.7.0.1
 */