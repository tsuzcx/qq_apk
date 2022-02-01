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
  private SeekBar.OnSeekBarChangeListener A = new VideoFilePresenter.5(this);
  private long B = FileManagerUtil.a().longValue();
  private AudioManager.OnAudioFocusChangeListener C = new VideoFilePresenter.9(this);
  protected VideoFileViewer a;
  protected AudioManager b;
  boolean j = false;
  final Runnable k = new VideoFilePresenter.10(this);
  Runnable l = new VideoFilePresenter.11(this);
  private PowerManager.WakeLock m;
  private Handler n;
  private boolean o = false;
  private long p = 0L;
  private int q = 0;
  private boolean r = false;
  private long s = 0L;
  private ShareActionSheet t;
  private boolean u;
  private BaseVideoView v = null;
  private IFileVideoDownloader w;
  private BaseVideoBiz x;
  private View.OnLongClickListener y = new VideoFilePresenter.1(this);
  private View.OnClickListener z = new VideoFilePresenter.2(this);
  
  public VideoFilePresenter(FileBrowserModelBase paramFileBrowserModelBase, Activity paramActivity)
  {
    super(paramFileBrowserModelBase, paramActivity);
    this.a = new VideoFileViewer(paramActivity);
    this.n = new Handler();
    a(this.a);
    y();
  }
  
  private void A()
  {
    this.d.runOnUiThread(new VideoFilePresenter.7(this));
  }
  
  private void B()
  {
    BaseVideoView localBaseVideoView = this.v;
    if ((localBaseVideoView != null) && (!localBaseVideoView.isPlaying())) {
      return;
    }
    this.n.postDelayed(this.l, 2500L);
  }
  
  private int a(int paramInt)
  {
    long l2 = this.p;
    long l1 = l2;
    if (l2 == 0L)
    {
      BaseVideoView localBaseVideoView = this.v;
      l1 = l2;
      if (localBaseVideoView != null) {
        l1 = localBaseVideoView.getVideoDurationMs();
      }
    }
    float f = paramInt / 10000.0F;
    return (int)((float)l1 * f);
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
  
  private void u()
  {
    this.n.removeCallbacks(this.l);
    this.a.i();
  }
  
  private String v()
  {
    if (FileManagerUtil.s(this.c.y())) {
      return this.c.y();
    }
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((BaseVideoBiz)localObject).c();
      if (FileManagerUtil.s((String)localObject)) {
        return localObject;
      }
    }
    return null;
  }
  
  private void w()
  {
    Object localObject = v();
    if ((localObject == null) && (this.c.w() == 1))
    {
      this.a.h(true);
      if (this.c.b() == 16)
      {
        this.a.a(this.c.y(), this.d.getResources().getString(2131889822));
        this.c.a(true);
        localObject = this.t;
        if ((localObject != null) && (((ShareActionSheet)localObject).isShowing())) {
          this.t.dismiss();
        }
        return;
      }
      x();
      this.a.b(true);
      b(this.c.J());
      return;
    }
    if (this.v != null)
    {
      VideoPlayParam localVideoPlayParam = new VideoPlayParam();
      localVideoPlayParam.mIsLocal = true;
      localVideoPlayParam.mVideoPath = ((String)localObject);
      localVideoPlayParam.mSceneId = 109;
      localVideoPlayParam.mSceneName = SceneID.getSceneStr(109);
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      localVideoPlayParam.mCallback = this;
      this.v.setVideoParam(localVideoPlayParam);
    }
  }
  
  private void x()
  {
    this.x = this.c.Q_();
    BaseVideoBiz localBaseVideoBiz = this.x;
    if (localBaseVideoBiz == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "get video biz, data is null!");
      return;
    }
    this.w = FileVideoDownloadManager.b(localBaseVideoBiz);
    this.w.a(this);
    this.w.a(this);
    this.w.a(true);
    this.w.c();
    this.a.f(false);
    this.a.b(true);
  }
  
  @SuppressLint({"InvalidWakeLockTag"})
  private void y()
  {
    this.d.setRequestedOrientation(-1);
    if ((this.b == null) || (this.v == null))
    {
      this.b = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
      this.m = ((PowerManager)this.d.getSystemService("power")).newWakeLock(536870922, "FileBrowserPresenter<FileAssistant>");
      this.m.setReferenceCounted(false);
      this.n = new Handler();
    }
  }
  
  private void z()
  {
    if (this.v != null)
    {
      this.m.release();
      this.v.pause();
      this.d.runOnUiThread(new VideoFilePresenter.6(this));
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = video");
    }
    this.a.b(this.z);
    this.a.d(10000);
    this.a.a(this.A);
    this.a.g();
    this.c.a(this);
    this.a.f(false);
    i();
    this.v = this.a.e();
    w();
    if (this.f != null) {
      this.f.a(true);
    }
    if ((FileManagerUtil.s(this.c.y())) && (this.c.R() == 2)) {
      this.a.f(true);
    }
    int i = this.c.R();
    int i1 = this.c.O();
    if ((i == 6) && (i1 == 1))
    {
      this.a.b(false);
      this.a.f(false);
      this.a.c(false);
    }
    this.a.e(this.c.aq());
    A();
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(this.d, 53);
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
    if (this.v == null)
    {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "!!!! onDownloadInfoSucc mVideoViwe null !!!!");
      return;
    }
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = false;
    localVideoPlayParam.mSavePath = paramSuperPlayerVideoInfo.getLocalSavePath();
    localVideoPlayParam.mFileID = paramSuperPlayerVideoInfo.getFileId();
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = SceneID.getSceneStr(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    localVideoPlayParam.mCallback = this;
    localVideoPlayParam.mUrls = paramSuperPlayerVideoInfo.getPlayUrls();
    localVideoPlayParam.mCookies = paramSuperPlayerVideoInfo.getCookie();
    localVideoPlayParam.mVideoFormat = 104;
    this.v.setVideoParam(localVideoPlayParam);
    A();
  }
  
  public void a(String paramString)
  {
    this.a.f(true);
    this.a.b(false);
    this.n.post(this.k);
  }
  
  public void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] paramArrayOfArrayList, String paramString)
  {
    if (this.t == null)
    {
      localObject1 = new ShareActionSheetV2.Param();
      ((ShareActionSheetV2.Param)localObject1).context = this.d;
      this.t = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject1);
    }
    this.t.setRowVisibility(0, 0, 0);
    this.t.setOnDismissListener(new VideoFilePresenter.3(this));
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
      this.t.setActionSheetTitle(paramString);
      paramString = this.c.k();
      localObject2 = this.c.l();
      if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        this.t.setIntentForStartForwardRecentActivity(paramString);
        this.d.getIntent().putExtra("big_brother_source_key", (String)localObject2);
      }
      else
      {
        this.t.setRowVisibility(8, 0, 0);
      }
      this.t.setActionSheetItems(paramArrayOfArrayList, (List)localObject1);
      this.t.setItemClickListenerV2(new VideoFilePresenter.4(this));
      this.t.show();
      this.u = true;
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    this.a.f(true);
    this.a.b(false);
    if ((this.c != null) && ((this.c instanceof DeviceFileModel))) {
      w();
    }
  }
  
  public void g()
  {
    if (!FileUtil.b(this.c.y())) {
      return;
    }
    this.a.b(false);
    this.a.f(true);
    this.a.c(false);
  }
  
  protected void i()
  {
    try
    {
      FileManagerReporter.a("0X8007426");
      FileManagerReporter.a("0X8007427");
      this.a.a(this.B, this.y);
      this.a.h(true);
      if (this.v != null)
      {
        this.a.d(this.v.isPlaying());
        return;
      }
      this.a.d(false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected boolean j()
  {
    return this.b.requestAudioFocus(this.C, 3, 1) == 1;
  }
  
  public void k()
  {
    this.a.f();
    Object localObject1 = this.v;
    if (localObject1 != null)
    {
      ((BaseVideoView)localObject1).releasePlayer(true);
      this.v = null;
    }
    localObject1 = this.w;
    if (localObject1 != null) {
      ((IFileVideoDownloader)localObject1).a(null);
    }
    localObject1 = this.n;
    if (localObject1 != null)
    {
      ((Handler)localObject1).removeCallbacks(this.k);
      this.n.removeCallbacks(this.l);
      this.n = null;
    }
    localObject1 = this.b;
    if (localObject1 != null) {
      ((AudioManager)localObject1).abandonAudioFocus(this.C);
    }
    localObject1 = this.w;
    if (localObject1 != null) {
      ((IFileVideoDownloader)localObject1).a(false);
    }
    int i = this.c.ao();
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
        localObject1 = this.c.u();
        localObject2 = "";
        str1 = "3";
        i = 1;
        break label240;
      }
      localObject2 = "";
    }
    else
    {
      localObject2 = this.c.u();
    }
    localObject1 = "";
    String str1 = "3";
    i = 2;
    label240:
    Object localObject3 = new DecimalFormat("0.00");
    double d = this.p;
    Double.isNaN(d);
    String str2 = ((DecimalFormat)localObject3).format(d / 1000.0D);
    d = this.s;
    Double.isNaN(d);
    localObject3 = ((DecimalFormat)localObject3).format(d / 1000.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str2);
    localStringBuilder.append(";");
    localStringBuilder.append((String)localObject3);
    ReportController.b(null, "dc00898", "", (String)localObject1, "0X8009AA6", "0X8009AA6", i, 0, str1, "3", localStringBuilder.toString(), (String)localObject2);
    super.k();
  }
  
  public void l()
  {
    super.l();
    if (this.u)
    {
      this.u = false;
      return;
    }
    PowerManager.WakeLock localWakeLock = this.m;
    if ((localWakeLock != null) && (localWakeLock.isHeld())) {
      this.m.release();
    }
    z();
  }
  
  public void m()
  {
    super.m();
    VideoFileViewer localVideoFileViewer = this.a;
    if (localVideoFileViewer != null)
    {
      BaseVideoView localBaseVideoView = this.v;
      if (localBaseVideoView != null)
      {
        localVideoFileViewer.d(localBaseVideoView.isPlaying() ^ true);
        this.n.postDelayed(this.k, 100L);
        this.v.play();
      }
    }
  }
  
  public void n()
  {
    this.d.overridePendingTransition(17432576, 17432577);
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@@@@@@@@@@@ videoView Download Success:");
    localStringBuilder.append(paramLong);
    QLog.i("FileBrowserPresenter<FileAssistant>", 1, localStringBuilder.toString());
    this.w.f();
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
            BaseVideoView localBaseVideoView = this.v;
            if (localBaseVideoView != null) {
              this.p = localBaseVideoView.getVideoDurationMs();
            }
            this.a.a(this.p);
            if (v() != null) {
              paramInt = 1;
            } else {
              paramInt = 0;
            }
            if (paramInt != 0)
            {
              this.a.b(false);
              this.a.f(true);
            }
            else
            {
              this.a.b(true);
              this.a.f(false);
            }
            this.a.h(false);
          }
        }
      }
      else
      {
        this.o = true;
        this.q = 0;
        this.m.release();
        this.a.c(0);
        this.a.b(0L);
        this.a.d(false);
        return;
      }
    }
    this.a.h(true);
  }
  
  protected void p()
  {
    int i = this.c.O();
    if (i == 2)
    {
      if (this.c.f() != null) {
        this.c.f().b();
      }
    }
    else if (i == 1)
    {
      if (this.c.e() != null) {
        this.c.e().b();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "Video stop transform, but status unknown!");
    }
    r();
  }
  
  protected void r()
  {
    this.c.a("0X8009D60", null);
    super.r();
    this.d.overridePendingTransition(17432576, 17432577);
  }
  
  public void t()
  {
    if (this.t != null)
    {
      Object localObject = this.c.n();
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
        this.t.setActionSheetItems(localList, (List)localObject);
      }
      if (this.t.isShowing()) {
        this.t.refresh();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.VideoFilePresenter
 * JD-Core Version:    0.7.0.1
 */