package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloadInfoListener;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloadListener;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloader;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewListener;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DeviceFileModel;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqvideoplatform.api.SceneID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;>;
import java.util.Iterator;
import java.util.List;

public class VideoFilePresenter
  extends FileBrowserPresenterBase
  implements IFileVideoDownloadInfoListener, IFileVideoDownloadListener, FileBrowserModelBase.OnTransEventListener, VideoPlayerCallback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new VideoFilePresenter.9(this);
  protected AudioManager a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new VideoFilePresenter.2(this);
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener = new VideoFilePresenter.1(this);
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new VideoFilePresenter.5(this);
  private IFileVideoDownloader jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader;
  private BaseVideoBiz jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz;
  protected VideoFileViewer a;
  private BaseVideoView jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  final Runnable jdField_a_of_type_JavaLangRunnable = new VideoFilePresenter.10(this);
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 0L;
  Runnable jdField_b_of_type_JavaLangRunnable = new VideoFilePresenter.11(this);
  private long c = FileManagerUtil.a().longValue();
  private boolean d = false;
  private boolean e = false;
  private boolean f;
  
  public VideoFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer = new VideoFileViewer(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer);
    s();
  }
  
  private int a(int paramInt)
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (l2 == 0L)
    {
      BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      l1 = l2;
      if (localBaseVideoView != null) {
        l1 = localBaseVideoView.getVideoDurationMs();
      }
    }
    float f1 = paramInt / 10000.0F;
    return (int)((float)l1 * f1);
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList)
  {
    if ((paramArrayOfArrayList != null) && (paramArrayOfArrayList.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfArrayList.length)
      {
        Object localObject = paramArrayOfArrayList[i];
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject).next()).action == 26) {
              ReportController.b(null, "dc00898", "", "", "0X800A60D", "0X800A60D", 0, 0, "", "", "", "");
            }
          }
        }
        i += 1;
      }
    }
  }
  
  private String b()
  {
    if (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz;
    if (localObject != null)
    {
      localObject = ((BaseVideoBiz)localObject).b();
      if (FileManagerUtil.b((String)localObject)) {
        return localObject;
      }
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f();
  }
  
  private void q()
  {
    Object localObject = b();
    if ((localObject == null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d() == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.h(true);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b() == 16)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d(), this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131692751));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
        if ((localObject != null) && (((ShareActionSheet)localObject).isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.dismiss();
        }
        return;
      }
      r();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(true);
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      VideoPlayParam localVideoPlayParam = new VideoPlayParam();
      localVideoPlayParam.mIsLocal = true;
      localVideoPlayParam.mVideoPath = ((String)localObject);
      localVideoPlayParam.mSceneId = 109;
      localVideoPlayParam.mSceneName = SceneID.a(109);
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      localVideoPlayParam.mCallback = this;
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
    BaseVideoBiz localBaseVideoBiz = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerDataBaseVideoBiz;
    if (localBaseVideoBiz == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader = FileVideoDownloadManager.a(localBaseVideoBiz);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(true);
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void s()
  {
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(-1);
    if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenter<FileAssistant>");
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.setReferenceCounted(false);
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.pause();
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.6(this));
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFilePresenter.7(this));
  }
  
  private void v()
  {
    BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if ((localBaseVideoView != null) && (!localBaseVideoView.isPlaying())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 2500L);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = video");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(10000);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(false);
    b();
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a();
    q();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener.a(true);
    }
    if ((FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i() == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(true);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.i();
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if ((i == 6) && (j == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.c(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.l());
    u();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(this.jdField_a_of_type_AndroidAppActivity, 53);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt1, int paramInt2, String paramString) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "!!!! onDownloadInfoSucc mVideoViwe null !!!!");
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = false;
    localVideoPlayParam.mSavePath = paramSuperPlayerVideoInfo.getLocalSavePath();
    localVideoPlayParam.mFileID = paramSuperPlayerVideoInfo.getFileId();
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = SceneID.a(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = this;
    localVideoPlayParam.mUrls = paramSuperPlayerVideoInfo.getPlayUrls();
    localVideoPlayParam.mCookies = paramSuperPlayerVideoInfo.getCookie();
    localVideoPlayParam.mVideoFormat = 104;
    this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.setVideoParam(localVideoPlayParam);
    u();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(false);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localObject1 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject1).context = this.jdField_a_of_type_AndroidAppActivity;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setOnDismissListener(new VideoFilePresenter.3(this));
    Object localObject2 = null;
    if (paramArrayOfArrayList != null)
    {
      if (paramArrayOfArrayList.length == 1)
      {
        paramArrayOfArrayList = paramArrayOfArrayList[0];
        localObject1 = null;
        break label110;
      }
      if (paramArrayOfArrayList.length == 2)
      {
        localObject1 = paramArrayOfArrayList[0];
        localObject2 = paramArrayOfArrayList[1];
        paramArrayOfArrayList = (ArrayList<ShareActionSheetBuilder.ActionSheetItem>[])localObject1;
        localObject1 = localObject2;
        break label110;
      }
    }
    Object localObject1 = null;
    paramArrayOfArrayList = (ArrayList<ShareActionSheetBuilder.ActionSheetItem>[])localObject2;
    label110:
    if (((paramArrayOfArrayList != null) && (!paramArrayOfArrayList.isEmpty())) || ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a();
      if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(paramString);
        this.jdField_a_of_type_AndroidAppActivity.getIntent().putExtra("big_brother_source_key", (String)localObject2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(paramArrayOfArrayList, (List)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new VideoFilePresenter.4(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
      this.f = true;
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    try
    {
      FileManagerReporter.a("0X8007426");
      FileManagerReporter.a("0X8007427");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.c, this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.h(true);
      if (this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.isPlaying());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  protected boolean c()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1) == 1;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(false);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase instanceof DeviceFileModel))) {
      q();
    }
  }
  
  public void g()
  {
    if (!FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.d())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.c(false);
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.c();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
    if (localObject1 != null)
    {
      ((BaseVideoView)localObject1).releasePlayer(true);
      this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader;
    if (localObject1 != null) {
      ((IFileVideoDownloader)localObject1).a(null);
    }
    localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject1 != null)
    {
      ((Handler)localObject1).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject1 = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject1 != null) {
      ((AudioManager)localObject1).abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader;
    if (localObject1 != null) {
      ((IFileVideoDownloader)localObject1).a(false);
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.l();
    Object localObject2;
    if ((i != 3) && (i != 4))
    {
      if ((i != 5) && (i != 6))
      {
        if ((i != 1) && (i != 2))
        {
          localObject1 = "";
          localObject2 = localObject1;
          str1 = "4";
          i = 5;
          break label240;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
        localObject2 = "";
        str1 = "3";
        i = 1;
        break label240;
      }
      localObject2 = "";
    }
    else
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
    }
    localObject1 = "";
    String str1 = "3";
    i = 2;
    label240:
    Object localObject3 = new DecimalFormat("0.00");
    double d1 = this.jdField_a_of_type_Long;
    Double.isNaN(d1);
    String str2 = ((DecimalFormat)localObject3).format(d1 / 1000.0D);
    d1 = this.jdField_b_of_type_Long;
    Double.isNaN(d1);
    localObject3 = ((DecimalFormat)localObject3).format(d1 / 1000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(";");
    localStringBuilder.append((String)localObject3);
    ReportController.b(null, "dc00898", "", (String)localObject1, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", localStringBuilder.toString(), (String)localObject2);
    super.i();
  }
  
  public void j()
  {
    super.j();
    if (this.f)
    {
      this.f = false;
      return;
    }
    PowerManager.WakeLock localWakeLock = this.jdField_a_of_type_AndroidOsPowerManager$WakeLock;
    if ((localWakeLock != null) && (localWakeLock.isHeld())) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
    }
    t();
  }
  
  public void k()
  {
    super.k();
    VideoFileViewer localVideoFileViewer = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer;
    if (localVideoFileViewer != null)
    {
      BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
      if (localBaseVideoView != null)
      {
        localVideoFileViewer.d(localBaseVideoView.isPlaying() ^ true);
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 100L);
        this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView.play();
      }
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.h();
    if (i == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
      }
    }
    else if (i == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a() != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a().b();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
    }
    n();
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a("0X8009D60", null);
    super.n();
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(17432576, 17432577);
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@@@@@@@@@@@ videoView Download Success:");
    localStringBuilder.append(paramLong);
    QLog.i("FileBrowserPresenter<FileAssistant>", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileVideoDownloader.c();
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 8)
      {
        if (paramInt != 3) {
          if (paramInt != 4)
          {
            if (paramInt == 5) {}
          }
          else
          {
            BaseVideoView localBaseVideoView = this.jdField_a_of_type_ComTencentMobileqqVideoplatformViewBaseVideoView;
            if (localBaseVideoView != null) {
              this.jdField_a_of_type_Long = localBaseVideoView.getVideoDurationMs();
            }
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.a(this.jdField_a_of_type_Long);
            if (b() != null) {
              paramInt = 1;
            } else {
              paramInt = 0;
            }
            if (paramInt != 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(false);
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(true);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(true);
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.f(false);
            }
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.h(false);
          }
        }
      }
      else
      {
        this.d = true;
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.c(0);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.b(0L);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.d(false);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerVideoFileViewer.h(true);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.b();
      List localList = null;
      if (localObject != null)
      {
        if (localObject.length == 1)
        {
          localList = localObject[0];
          localObject = null;
          break label55;
        }
        if (localObject.length == 2)
        {
          localList = localObject[0];
          localObject = localObject[1];
          break label55;
        }
      }
      localObject = null;
      label55:
      if (((localList != null) && (!localList.isEmpty())) || ((localObject != null) && (!((ArrayList)localObject).isEmpty()))) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localList, (List)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.refresh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter
 * JD-Core Version:    0.7.0.1
 */