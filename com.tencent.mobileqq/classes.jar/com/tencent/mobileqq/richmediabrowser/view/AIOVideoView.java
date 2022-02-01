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
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
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
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> A = new ArrayList();
  private String B = "";
  private long C = -1L;
  public AIOVideoPresenter k;
  public VideoView l;
  public RelativeLayout m;
  public TextView n;
  public ImageView o;
  public SeekBar p;
  public ImageButton q;
  public LinearLayout r;
  public TextView s;
  public long t = 0L;
  public ImageButton u;
  private TVKVideoController v;
  private View w;
  private IProvider x;
  private VideoPlayParam y;
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> z = new ArrayList();
  
  public AIOVideoView(Context paramContext, AIOVideoPresenter paramAIOVideoPresenter)
  {
    super(paramContext, paramAIOVideoPresenter);
    this.k = paramAIOVideoPresenter;
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
    Object localObject2 = paramVideoPlayMedioInfo.f;
    ((VideoPlayParam)localObject1).mSceneId = 101;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(SceneID.getSceneStr(101));
    ((StringBuilder)localObject3).append("_FulScr");
    ((VideoPlayParam)localObject1).mSceneName = ((StringBuilder)localObject3).toString();
    localObject3 = l();
    if ((localObject3 != null) && (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(((AIOVideoData)localObject3).m)))
    {
      ((VideoPlayParam)localObject1).mSceneId = 100;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(SceneID.getSceneStr(100));
      ((StringBuilder)localObject3).append("_FulScr");
      ((VideoPlayParam)localObject1).mSceneName = ((StringBuilder)localObject3).toString();
    }
    localObject3 = this.k;
    if (localObject3 != null) {
      ((VideoPlayParam)localObject1).mIsMute = ((AIOVideoPresenter)localObject3).e(paramVideoPlayMedioInfo.k);
    }
    if (!((VideoPlayParam)localObject1).mIsMute)
    {
      localObject3 = this.l;
      if (localObject3 != null) {
        ((VideoView)localObject3).requestAudioFocus();
      }
    }
    if (paramVideoPlayMedioInfo.a)
    {
      ((VideoPlayParam)localObject1).mUrls = paramVideoPlayMedioInfo.c;
      ((VideoPlayParam)localObject1).mSavePath = paramVideoPlayMedioInfo.b;
    }
    else
    {
      ((VideoPlayParam)localObject1).mVideoPath = paramVideoPlayMedioInfo.b;
    }
    ((VideoPlayParam)localObject1).mIsLocal = (paramVideoPlayMedioInfo.a ^ true);
    paramVideoPlayMedioInfo = (VideoPlayMedioInfo)localObject1;
    if (localObject2 != null)
    {
      paramVideoPlayMedioInfo = (VideoPlayMedioInfo)localObject1;
      if (this.l != null)
      {
        paramVideoPlayMedioInfo = ((IVideoDepend)QRoute.api(IVideoDepend.class)).buildVideoPlayParam((MessageRecord)localObject2, (VideoPlayParam)localObject1);
        localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("realPlayVideo, videoDuration = ");
        ((StringBuilder)localObject2).append(paramVideoPlayMedioInfo.mVideoFileTimeMs);
        ((IBrowserLog)localObject1).d("AIOVideoView", 4, ((StringBuilder)localObject2).toString());
        this.l.totalTime.setText(BrowserUtils.a(paramVideoPlayMedioInfo.mVideoFileTimeMs));
        this.l.progressTime.setText(BrowserUtils.a(0L));
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
      localObject1 = this.k.b(l());
      if ((localObject1 != null) && (((VideoPlayMedioInfo)localObject1).c != null) && (!StringUtil.isEmpty(((VideoPlayMedioInfo)localObject1).e)))
      {
        localObject2 = ((VideoPlayMedioInfo)localObject1).c;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject2[i];
          if (!StringUtil.isEmpty((String)localObject3)) {
            BaseInnerDns.getInstance().reportBadIp(((VideoPlayMedioInfo)localObject1).e, BaseInnerDns.getHostFromUrl((String)localObject3), ((IVideoDepend)QRoute.api(IVideoDepend.class)).getVideoIpType());
          }
          i += 1;
        }
        LongVideoUrlCacheManager.a().b();
      }
    }
    if (paramInt1 == 1) {
      localObject1 = this.c.getString(2131915765);
    } else {
      localObject1 = null;
    }
    if (paramInt2 == 14011001)
    {
      localObject1 = this.c.getString(2131915763);
      this.k.a(5002, 0L);
    }
    Object localObject2 = l();
    if (localObject2 != null)
    {
      if (localObject1 == null) {
        localObject1 = this.c.getString(2131915759);
      }
      ((AIOVideoData)localObject2).u = ((String)localObject1);
      ((AIOVideoData)localObject2).B += 1;
      localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handlePlayError, videoData.mPlayErrTimes = ");
      ((StringBuilder)localObject3).append(((AIOVideoData)localObject2).B);
      ((IBrowserLog)localObject1).d("AIOVideoView", 2, ((StringBuilder)localObject3).toString());
    }
    if ((VideoPlatformUtils.a(paramInt2, paramVideoPlayParam)) && (this.l.mVideoView != null) && (localObject2 != null) && (((AIOVideoData)localObject2).B < 2))
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
    Object localObject1 = this.k.c.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      localObject1 = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("tryPlayVideo, position = ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" , msgId = ");
        ((StringBuilder)localObject2).append(((AIOVideoData)localObject1).a);
        QLog.d("AIOVideoView", 2, ((StringBuilder)localObject2).toString());
      }
      ((AIOVideoData)localObject1).C = paramInt;
      ((AIOVideoData)localObject1).v = paramBoolean;
      this.k.b(((AIOVideoData)localObject1).a, paramBoolean ^ true);
      Object localObject2 = this.k.b((AIOVideoData)localObject1);
      if (localObject2 == null)
      {
        this.k.c((AIOVideoData)localObject1);
        this.k.a(((AIOVideoData)localObject1).a, ((AIOVideoData)localObject1).b, 1);
        a();
        localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateItemStatus VIDEO_GETTING_URL , shortVideoData.msgId = ");
        localStringBuilder.append(((AIOVideoData)localObject1).a);
        localStringBuilder.append(", shortVideoData.subId = ");
        localStringBuilder.append(((AIOVideoData)localObject1).b);
        ((IBrowserLog)localObject2).d("AIOVideoView", 4, localStringBuilder.toString());
        return;
      }
      b((VideoPlayMedioInfo)localObject2);
    }
  }
  
  private void a(long paramLong, VideoPlayParam paramVideoPlayParam)
  {
    if (!this.k.b(paramLong))
    {
      long l1 = this.k.d(paramLong);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportForVideoStartPlayCost, id:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(", clickBubbleTime = ");
        ((StringBuilder)localObject).append(l1);
        QLog.d("AIOVideoView", 2, ((StringBuilder)localObject).toString());
      }
      if (l1 > 0L)
      {
        paramLong = System.currentTimeMillis() - l1;
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
      this.B = ((File)localObject).getAbsolutePath();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onVideoFrameCallBack, write tmp file:");
        ((StringBuilder)localObject).append(this.B);
        QLog.i("AIOVideoView", 2, ((StringBuilder)localObject).toString());
      }
      RichMediaBrowserUtils.a(paramBitmap, this.B);
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
      RichMediaBrowserUtils.a(126, localArrayList, this.B, 0);
    }
    if (((Boolean)paramBitmap.second).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, detected MiniCode, build item");
      }
      RichMediaBrowserUtils.a(127, localArrayList, this.B, 0);
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
    Object localObject = this.x;
    if ((localObject != null) && (((IProvider)localObject).c()))
    {
      paramAIOVideoData = this.x.c(paramAIOVideoData.a, paramAIOVideoData.b, ParamsManager.a().i());
      if (paramAIOVideoData != null)
      {
        paramAIOVideoData.putExtra("NeedReportForwardShortVideo", true);
        if (this.k.c.getSelectedItem() != null)
        {
          localObject = this.k.c.getSelectedItem().baseData;
          if ((localObject instanceof AIOVideoData))
          {
            localObject = (AIOVideoData)localObject;
            if (!TextUtils.isEmpty(((AIOVideoData)localObject).z))
            {
              paramAIOVideoData.putExtra(((IVideoDepend)QRoute.api(IVideoDepend.class)).getCameraVideoParam(), ((AIOVideoData)localObject).z);
              paramAIOVideoData.putExtra(((IVideoDepend)QRoute.api(IVideoDepend.class)).getCameraMaterialName(), ((AIOVideoData)localObject).A);
            }
          }
        }
        this.b.setIntentForStartForwardRecentActivity(paramAIOVideoData);
      }
    }
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    File localFile = new AIOVideoModel().b(paramAIOVideoData, 1);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.k.c.getSelectedItem();
    this.z.clear();
    this.A.clear();
    int j = 0;
    if ((localFile != null) && (localFile.exists()))
    {
      long l1 = localFile.length();
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showActionSheetForShortVideo, file.getPath()=");
      localStringBuilder.append(localFile.getPath());
      localStringBuilder.append(", mTransferredSize = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", data.size = ");
      localStringBuilder.append(paramAIOVideoData.d);
      localIBrowserLog.d("AIOVideoView", 4, localStringBuilder.toString());
      if ((((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(paramAIOVideoData.m)) || (l1 >= paramAIOVideoData.d))
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
    if ((paramAIOVideoData.m != 1) || (i == 0)) {
      j = 1;
    }
    if (j != 0) {
      RichMediaBrowserUtils.a(2, this.z);
    }
    if ((VersionUtils.d()) && ((paramAIOVideoData.m != 1) || (i == 0))) {
      RichMediaBrowserUtils.a(39, this.A);
    }
    if (i == 0)
    {
      RichMediaBrowserUtils.a(6, this.A);
      RichMediaBrowserUtils.a(3, this.z);
      RichMediaBrowserUtils.a(27, this.z);
    }
    if ((ParamsManager.a().r()) && (!TextUtils.isEmpty(ParamsManager.a().j())) && (ParamsManager.a().i() != -1)) {
      RichMediaBrowserUtils.a(54, this.A);
    }
    if ((i == 0) && (localFile != null) && (((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).isFileSupported(localFile.getAbsolutePath()))) {
      RichMediaBrowserUtils.a(166, this.z);
    }
    if (i == 0) {
      RichMediaBrowserUtils.a(64, this.z);
    }
    a(paramAIOVideoData, localFile, paramInt, localRichMediaBrowserInfo);
    if ((this.c instanceof Activity)) {
      ((Activity)this.c).getIntent().putExtra("big_brother_source_key", " biz_src_jc_video");
    }
    this.b.setActionSheetItems(this.z, this.A);
    if (j != 0) {
      a(paramAIOVideoData);
    }
    this.b.show();
  }
  
  private void a(AIOVideoData paramAIOVideoData, int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramAIOVideoData != null)
    {
      Object localObject = this.x;
      if ((localObject != null) && (((IProvider)localObject).c()))
      {
        localObject = this.x.c(paramAIOVideoData.a, paramAIOVideoData.b, ParamsManager.a().i());
        if ((localObject != null) && ((this.c instanceof Activity)))
        {
          ((Intent)localObject).putExtra("NeedReportForwardShortVideo", true);
          ((IVideoDepend)QRoute.api(IVideoDepend.class)).dealSendToFriend((Activity)this.c, (Intent)localObject, paramAIOVideoData.z, paramAIOVideoData.A, paramInt, paramActionSheetItem);
        }
      }
    }
    if ((ParamsManager.a().g()) && (this.k.a != null))
    {
      paramAIOVideoData = this.k.a;
      AIOBrowserPresenter.a("0X8009ABC");
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
  
  private void b(AIOVideoData paramAIOVideoData)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file://");
    localStringBuilder.append(paramAIOVideoData.k);
    localIntent.setDataAndType(Uri.parse(localStringBuilder.toString()), "video/*");
    localIntent.putExtra("big_brother_source_key", " biz_src_jc_video");
    this.c.startActivity(localIntent);
    int i = paramAIOVideoData.f;
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
    if (paramAIOVideoData.t == 5002)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "video file is expired");
      QQToast.makeText(this.c, 1, 2131915748, 0).show();
      return;
    }
    if ((!PermissionUtil.a(this.c)) && ((this.c instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.c, null);
      return;
    }
    if (((IBrowserDepend)QRoute.api(IBrowserDepend.class)).isShortVideoType(paramAIOVideoData.m))
    {
      this.k.a(paramInt, paramFile);
      return;
    }
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() == paramAIOVideoData.d))
    {
      paramAIOVideoData = new StringBuilder();
      paramRichMediaBrowserInfo = new StringBuilder();
      paramRichMediaBrowserInfo.append(paramFile.getParentFile().getName());
      paramRichMediaBrowserInfo.append(NetConnInfoCenter.getServerTime());
      paramAIOVideoData.append(paramRichMediaBrowserInfo.toString().toLowerCase(Locale.US));
      paramAIOVideoData.append(".mp4");
      paramAIOVideoData = paramAIOVideoData.toString();
      ThreadManager.getFileThreadHandler().post(((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoFileSaveRunnable(paramFile.getAbsolutePath(), this.k.g, paramAIOVideoData, false));
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      this.k.g.sendEmptyMessage(((IShortVideoDepend)QRoute.api(IShortVideoDepend.class)).getVideoSaveFailCode());
      return;
    }
    if ((!AppNetConnInfo.isWifiConn()) && (paramAIOVideoData.d > 29360128L))
    {
      a(101, paramAIOVideoData, paramRichMediaBrowserInfo);
      return;
    }
    this.k.a(paramAIOVideoData);
    this.k.a(paramAIOVideoData.a, paramAIOVideoData.b, 7);
    a();
    if (this.l.mVideoView != null) {
      this.l.mVideoView.pause();
    }
  }
  
  private void b(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    if (paramVideoPlayMedioInfo == null) {
      return;
    }
    Object localObject = l();
    int i = -1;
    if (localObject != null) {
      i = ((AIOVideoData)localObject).status;
    }
    localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("realPlayVideo id = ");
    localStringBuilder.append(paramVideoPlayMedioInfo.k);
    ((IBrowserLog)localObject).d("AIOVideoView", 4, localStringBuilder.toString());
    this.k.a(paramVideoPlayMedioInfo.k, paramVideoPlayMedioInfo.l, 3);
    a();
    if (this.k.a != null) {
      this.k.a.a(0L, 0L, ParamsManager.a().j());
    }
    this.l.setVideoPlayCallback(this);
    localObject = this.l;
    if ((localObject != null) && (((VideoView)localObject).mVideoView != null))
    {
      if (i != 4) {
        c(paramVideoPlayMedioInfo);
      }
      this.l.mVideoView.play();
    }
  }
  
  private void c(AIOVideoData paramAIOVideoData)
  {
    Object localObject = this.x;
    if ((localObject != null) && (((IProvider)localObject).c()))
    {
      localObject = this.x.c(paramAIOVideoData.a, paramAIOVideoData.b, ParamsManager.a().i());
      if ((localObject != null) && ((this.c instanceof Activity))) {
        ((IVideoDepend)QRoute.api(IVideoDepend.class)).dealAddFavorite((Intent)localObject, (Activity)this.c, null, 3, 0, paramAIOVideoData.f);
      }
    }
  }
  
  private void c(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    this.y = a(paramVideoPlayMedioInfo);
    this.l.setVideoPlayCallback(this.y);
    this.l.mVideoView.setVideoParam(this.y);
  }
  
  private void d(int paramInt)
  {
    AIOVideoData localAIOVideoData = l();
    if (localAIOVideoData != null) {
      this.k.a(localAIOVideoData.a, localAIOVideoData.b, paramInt);
    }
  }
  
  private boolean i(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.k.c.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOVideoData)) && (this.k.b((AIOVideoData)localRichMediaBrowserInfo.baseData) != null))
      {
        this.q.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.q.setVisibility(4);
    }
    return false;
  }
  
  private void j(boolean paramBoolean)
  {
    View localView = this.w;
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
  
  private void u()
  {
    if (this.g != null)
    {
      localObject = (RelativeLayout)this.g.findViewById(2131439678);
      this.q = ((ImageButton)this.g.findViewById(2131442308));
      this.q.setContentDescription(this.c.getString(2131915731));
      this.q.setOnClickListener(this);
      this.l.initContentView(this.g);
      this.m = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131449155));
      this.p = ((SeekBar)this.m.findViewById(2131449157));
      this.p.setMax(10000);
      this.n = ((TextView)this.m.findViewById(2131449156));
      this.o = ((ImageView)this.m.findViewById(2131430807));
      this.o.setOnClickListener(this);
      this.f = ((ImageButton)this.g.findViewById(2131442307));
      this.f.setOnClickListener(this);
      this.e = ((ImageButton)this.g.findViewById(2131442309));
      this.e.setOnClickListener(this);
      this.u = ((ImageButton)this.g.findViewById(2131442315));
      this.u.setOnClickListener(this);
      this.r = ((LinearLayout)this.g.findViewById(2131430269));
      this.s = ((TextView)this.g.findViewById(2131430270));
      this.r.setOnClickListener(this);
      this.r.setVisibility(8);
      this.w = this.g.findViewById(2131449733);
      this.d = ((ImageButton)this.g.findViewById(2131442310));
      this.d.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.d;
        localObject = (RelativeLayout.LayoutParams)this.u.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.d;
        localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.d;
      }
    }
    Object localObject = this.l;
    if ((localObject != null) && (!((VideoView)localObject).isInExitAnim)) {
      f(true);
    }
  }
  
  private void v()
  {
    Object localObject = this.l;
    if (localObject != null) {
      ((VideoView)localObject).pauseVideo();
    }
    localObject = this.k;
    if (((AIOVideoPresenter)localObject).a(((AIOVideoPresenter)localObject).a.getCurrentPosition())) {
      this.k.a(true);
    }
  }
  
  private void w()
  {
    AIOVideoData localAIOVideoData = this.k.r();
    if ((localAIOVideoData != null) && ((this.c instanceof Activity)))
    {
      long l1;
      if (this.l.mVideoView != null) {
        l1 = this.l.mVideoView.getCurPlayingPos();
      } else {
        l1 = 0L;
      }
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.c, ParamsManager.a().i(), ParamsManager.a().e(), false, localAIOVideoData.e, l1);
    }
    if ((localAIOVideoData != null) && (localAIOVideoData.status == 3))
    {
      this.k.a(localAIOVideoData.a, true);
      v();
    }
    this.k.q();
  }
  
  private void x()
  {
    if ((this.c instanceof BaseActivity))
    {
      localObject = (BaseActivity)this.c;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (!PermissionUtil.a(this.c))
        {
          ((BaseActivity)localObject).requestPermissions(new AIOVideoView.3(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
          return;
        }
        y();
        return;
      }
      y();
      return;
    }
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick, activity:");
    localStringBuilder.append(this.c);
    ((IBrowserLog)localObject).d("AIOVideoView", 4, localStringBuilder.toString());
  }
  
  private void y()
  {
    AIOVideoData localAIOVideoData = l();
    if ((localAIOVideoData != null) && (!TextUtils.isEmpty(localAIOVideoData.z)) && ((this.c instanceof Activity)))
    {
      ((IJumpUtil)QRoute.api(IJumpUtil.class)).jumpToCameraActivityForAio((Activity)this.c, localAIOVideoData.z);
      ReportController.b(null, "dc00898", "", "", "0X800A91F", "0X800A91F", 2, 0, "", "", localAIOVideoData.z, "");
    }
  }
  
  private void z()
  {
    AIOVideoData localAIOVideoData = l();
    if (localAIOVideoData != null)
    {
      Object localObject = this.v;
      if (localObject != null) {
        ((TVKVideoController)localObject).b();
      }
      long l1;
      if (this.l.mVideoView != null) {
        l1 = this.l.mVideoView.getCurPlayingPos();
      } else {
        l1 = 0L;
      }
      this.v = new TVKVideoController(this.c);
      localObject = this.k.b(localAIOVideoData);
      if (localObject != null)
      {
        this.v.a((VideoPlayMedioInfo)localObject, localAIOVideoData.r, l1);
        this.v.a(localAIOVideoData.j, localAIOVideoData.p, localAIOVideoData.q);
        if (this.v.a(localAIOVideoData.f, localAIOVideoData.p, localAIOVideoData.q)) {
          this.k.j();
        }
      }
      else
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "Failed to floating, videoPlayMedioInfo is null");
      }
    }
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.g = ((RelativeLayout)LayoutInflater.from(this.c).inflate(2131629206, null));
    u();
    if (this.l.videoControlContainer != null) {
      this.l.videoControlContainer.addView(this.g);
    }
    return this.l.mBrowserItemView;
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = l();
    c(g());
    d(a(this.k.c.getSelectedItem()));
    h(true);
    if ((localObject1 != null) && (this.l != null))
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
      long l1;
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
                  this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
                  localObject2 = this.n;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(this.c.getString(2131915754));
                  localStringBuilder.append(((AIOVideoData)localObject1).progress);
                  localStringBuilder.append("%");
                  ((TextView)localObject2).setText(localStringBuilder.toString());
                  this.p.setProgress(((AIOVideoData)localObject1).progress * 100);
                  this.l.bufferPanel.setVisibility(8);
                  this.l.showPlayPanel(false);
                  g(true);
                  this.l.mErrLayout.setVisibility(8);
                  this.l.mCenterPlayBtn.setVisibility(8);
                  i(true);
                  return;
                }
                this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
                this.l.showPlayPanel(false);
                this.l.bufferPanel.setVisibility(8);
                this.l.mErrLayout.setVisibility(0);
                this.l.mCenterPlayBtn.setVisibility(8);
                this.l.playButton.setImageResource(2130847779);
                localObject2 = (TextView)this.l.mErrLayout.findViewById(2131432606);
                if (localObject2 != null)
                {
                  if (!TextUtils.isEmpty(((AIOVideoData)localObject1).u)) {
                    localObject1 = ((AIOVideoData)localObject1).u;
                  } else {
                    localObject1 = this.c.getString(2131917888);
                  }
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
                g(false);
                i(false);
                return;
              }
              this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
              this.l.showPlayPanel(true);
              this.l.bufferPanel.setVisibility(8);
              this.l.mErrLayout.setVisibility(8);
              this.l.mCenterPlayBtn.setVisibility(0);
              this.l.playButton.setImageResource(2130847779);
              g(false);
              i(true);
              return;
            }
            this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
            this.l.showPlayPanel(true);
            this.l.bufferPanel.setVisibility(8);
            this.l.mErrLayout.setVisibility(8);
            this.l.mCenterPlayBtn.setVisibility(8);
            this.l.playButton.setImageResource(2130847780);
            if (this.l.mVideoView != null)
            {
              l1 = this.l.mVideoView.getVideoDurationMs();
              localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("videoDuration = ");
              ((StringBuilder)localObject2).append(l1);
              ((IBrowserLog)localObject1).d("AIOVideoView", 4, ((StringBuilder)localObject2).toString());
              this.l.totalTime.setText(BrowserUtils.a(l1));
            }
            g(false);
            i(true);
            return;
          }
          if (this.l.mVideoView != null) {
            if (this.l.mVideoView.isPlaying()) {
              this.l.bufferPanel.setVisibility(0);
            } else {
              this.l.bufferPanel.setVisibility(8);
            }
          }
          this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
          this.l.showPlayPanel(true);
          g(false);
          this.l.mCenterPlayBtn.setVisibility(8);
          this.l.mErrLayout.setVisibility(8);
          i(true);
          return;
        }
        this.k.c.onLoadStart(this.k.c.getSelectedIndex(), ((AIOVideoData)localObject1).progress);
        this.l.showPlayPanel(false);
        g(false);
        this.l.bufferPanel.setVisibility(8);
        this.l.mErrLayout.setVisibility(8);
        this.l.mCenterPlayBtn.setVisibility(8);
        i(false);
        return;
      }
      g(false);
      i(true);
      this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
      this.l.showPlayPanel(false);
      this.l.bufferPanel.setVisibility(8);
      this.l.mErrLayout.setVisibility(8);
      localObject2 = this.l.mCenterPlayBtn;
      if (!((AIOVideoData)localObject1).v) {
        i = 0;
      }
      ((ImageView)localObject2).setVisibility(i);
      this.l.playButton.setImageResource(2130847779);
      if (this.l.mVideoView != null)
      {
        l1 = this.l.mVideoView.getVideoDurationMs();
        localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("videoDuration = ");
        ((StringBuilder)localObject2).append(l1);
        ((IBrowserLog)localObject1).d("AIOVideoView", 4, ((StringBuilder)localObject2).toString());
        this.l.totalTime.setText(BrowserUtils.a(l1));
        this.l.progressTime.setText(BrowserUtils.a(0L));
      }
      this.l.playBar.setProgress(0);
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    Object localObject1 = this.k.c.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 101))
    {
      AIOVideoData localAIOVideoData = (AIOVideoData)((RichMediaBrowserInfo)localObject1).baseData;
      localObject1 = new AIOVideoModel();
      Object localObject2 = (URLDrawable)this.k.f.get(Integer.valueOf(paramInt));
      if ((localObject2 != null) && (this.l.mVideoView != null)) {
        this.l.mVideoView.showCover((Drawable)localObject2);
      } else if (((AIOVideoModel)localObject1).b(localAIOVideoData, 0) != null) {
        this.k.a(localAIOVideoData.j, localAIOVideoData.p, localAIOVideoData.q, this.l.mVideoView.getCoverImage(), paramInt);
      }
      if (localAIOVideoData.m == 1) {
        localObject1 = "0X8009EF1";
      } else {
        localObject1 = "0X8009EF2";
      }
      localObject2 = this.k.p();
      if ((localObject2 != null) && (((RichMediaBrowserInfo)localObject2).baseData != null) && (((RichMediaBrowserInfo)localObject2).baseData.getType() == 101) && (((AIOVideoData)((RichMediaBrowserInfo)localObject2).baseData).a == localAIOVideoData.a) && (!((RichMediaBrowserInfo)localObject2).isReport))
      {
        ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 1, 0, "", "", "", "");
        ((RichMediaBrowserInfo)localObject2).isReport = true;
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, 2, 0, "", "", "", "");
      }
      localObject1 = new AIOVideoView.GalleryVideoViewHolder(this);
      ((AIOVideoView.GalleryVideoViewHolder)localObject1).a = this.l.mVideoView;
      this.l.mBrowserItemView.setTag(localObject1);
    }
  }
  
  public void a(int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject = this.k.c.getItem(paramInt);
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
          this.k.a(((AIOVideoData)localObject).j, ((AIOVideoData)localObject).p, ((AIOVideoData)localObject).q, paramView.getCoverImage(), paramInt);
          if (this.k.c(paramInt))
          {
            paramView = this.k.b((AIOVideoData)localObject);
            if (paramView != null) {
              b(paramView);
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    a(DialogUtil.a(this.c, 230, this.c.getString(2131915752), this.c.getString(2131915751), new AIOVideoView.9(this, paramInt, paramObject), new AIOVideoView.10(this)));
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    AIOVideoData localAIOVideoData = l();
    if (localAIOVideoData != null)
    {
      Object localObject = this.x;
      if (localObject != null)
      {
        int i = ((IProvider)localObject).b(localAIOVideoData.a, localAIOVideoData.b);
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
          this.x.b(localAIOVideoData.a, localAIOVideoData.b, 256);
        }
        if (this.l.mVideoView != null) {
          this.l.mVideoView.pause();
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "notifyVideoUrl ");
    this.k.a(paramLong, paramInt1, paramInt2, paramString1);
    AIOVideoData localAIOVideoData = l();
    if (localAIOVideoData == null) {
      return;
    }
    LongVideoUrlCacheManager.a().a(localAIOVideoData.a, paramArrayOfString, System.currentTimeMillis(), paramMessageRecord, paramInt3, paramString2);
    paramString2 = new VideoPlayMedioInfo();
    paramString2.a = true;
    paramString2.c = paramArrayOfString;
    paramString2.b = paramString1;
    paramString2.f = paramMessageRecord;
    paramString2.g = paramInt3;
    paramString2.k = localAIOVideoData.a;
    paramString2.l = localAIOVideoData.b;
    paramString1 = new File(localAIOVideoData.k);
    if (paramString1.exists()) {
      paramString2.p = paramString1.length();
    } else {
      paramString2.p = 0L;
    }
    paramString1 = BrowserLogHelper.getInstance().getGalleryLog();
    paramArrayOfString = new StringBuilder();
    paramArrayOfString.append("setShortVideoDrawableWithUrls, set playMediaInfo.isMute =  ");
    paramArrayOfString.append(paramString2.m);
    paramString1.d("AIOVideoView", 4, paramArrayOfString.toString());
    paramString1 = this.k;
    if (paramString1.c(paramString1.c.getCurrentPosition()))
    {
      b(paramString2);
    }
    else
    {
      d(0);
      a();
    }
    if (new AIOVideoModel().b(localAIOVideoData, 0) == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "setShortVideoDrawableWithUrls, get thumb");
      paramString1 = this.x;
      if (paramString1 != null) {
        paramString1.a(localAIOVideoData.a, localAIOVideoData.b, 0);
      }
    }
  }
  
  public void a(Dialog paramDialog)
  {
    if ((paramDialog != null) && ((this.c instanceof Activity)) && (!((Activity)this.c).isFinishing())) {
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
    if ((this.k.a != null) && ((this.k.a.getParamsBuilder().a() instanceof IProvider))) {
      this.x = ((IProvider)this.k.a.getParamsBuilder().a());
    }
  }
  
  public void a(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    if (this.k.b() != null)
    {
      Object localObject = this.k;
      if ((((AIOVideoPresenter)localObject).a(((AIOVideoPresenter)localObject).c.getCurrentPosition())) && (paramSeekBar != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "seek danmaku");
        this.k.b().a(paramSeekBar.getProgress());
        localObject = this.k.r();
        if (localObject != null) {
          this.k.b().b(BrowserDanmakuUtils.a(((AIOVideoData)localObject).e, paramSeekBar.getProgress(), this.k.b(), this.k.d));
        }
      }
    }
  }
  
  public void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.k.a != null)) {
      this.k.a.n();
    }
  }
  
  public void a(AIOVideoData paramAIOVideoData, File paramFile, int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.b.setItemClickListenerV2(new AIOVideoView.4(this, paramAIOVideoData, paramFile, paramInt, paramRichMediaBrowserInfo));
    this.b.setCancelListener(new AIOVideoView.5(this));
  }
  
  public void a(IBaseViewBuilder paramIBaseViewBuilder)
  {
    super.a(paramIBaseViewBuilder);
    if ((paramIBaseViewBuilder instanceof VideoView))
    {
      this.l = ((VideoView)paramIBaseViewBuilder);
      this.l.setPlayPanelDecorator(true);
      this.l.setVideoViewClickEvent(this);
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    a(paramInt);
    Object localObject = this.k.c.getItem(paramInt);
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.k.a(((AIOVideoData)localObject).a, ((AIOVideoData)localObject).b, 0);
      if (this.k.c(paramInt))
      {
        a(paramInt, true);
        return;
      }
      a();
    }
  }
  
  public void c()
  {
    super.c();
    o();
    this.x = null;
    VideoView localVideoView = this.l;
    if (localVideoView != null) {
      localVideoView.onDestroy();
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    AIOVideoData localAIOVideoData = l();
    if (localAIOVideoData != null)
    {
      StringBuilder localStringBuilder;
      if (this.l.mVideoView.isPlaying())
      {
        long l1 = this.l.mVideoView.getCurPlayingPos();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showActionSheet, captureCurFrame, from:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", pos:");
          localStringBuilder.append(l1);
          QLog.i("AIOVideoView", 2, localStringBuilder.toString());
        }
        this.l.mVideoView.captureCurFrame(l1, 0, 0);
      }
      else if (this.l.playBar.getProgress() > 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showActionSheet, captureCurFrame, from:");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(", pos:");
          localStringBuilder.append(this.C);
          QLog.i("AIOVideoView", 2, localStringBuilder.toString());
        }
        this.l.mVideoView.captureCurFrame(this.C, 0, 0);
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
    localStringBuilder.append(this.k.i());
    localIBrowserLog.d("AIOVideoView", 2, localStringBuilder.toString());
    super.e(paramBoolean);
    if (paramBoolean)
    {
      f(false);
      b(false);
      this.k.b(false);
      return;
    }
    if (this.k.i())
    {
      this.k.g().a = false;
      this.k.k();
      this.k.l();
      j(false);
      return;
    }
    f(false);
    b(false);
    this.k.g().e();
  }
  
  public void g(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.m;
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
    if (this.r != null)
    {
      Object localObject = this.k.c.getSelectedItem();
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
            if (!ParamsManager.a().n())
            {
              i = j;
              if (!ParamsManager.a().g())
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
                      if (!TextUtils.isEmpty(localAIOVideoData.z))
                      {
                        this.r.setVisibility(0);
                        localObject = this.c.getString(2131915727);
                        if (!TextUtils.isEmpty(localAIOVideoData.A)) {
                          localObject = localAIOVideoData.A;
                        }
                        this.s.setText((CharSequence)localObject);
                        j = 1;
                        i = j;
                        if (this.t != localAIOVideoData.a)
                        {
                          ReportController.b(null, "dc00898", "", "", "0X800A91E", "0X800A91E", 2, 0, "", "", localAIOVideoData.z, "");
                          this.t = localAIOVideoData.a;
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
        this.r.setVisibility(8);
      }
    }
  }
  
  public void i()
  {
    j(true);
  }
  
  public AIOVideoData l()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((AIOVideoPresenter)localObject).c != null))
    {
      localObject = this.k.c.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 101)) {
        return (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      }
    }
    return null;
  }
  
  public void m()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((VideoView)localObject).mVideoView != null))
    {
      localObject = this.k;
      if (!((AIOVideoPresenter)localObject).c(((AIOVideoPresenter)localObject).c.getCurrentPosition())) {
        this.l.mVideoView.setCoverVisible();
      }
    }
  }
  
  public void n()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    Object localObject = this.k;
    if ((((AIOVideoPresenter)localObject).c(((AIOVideoPresenter)localObject).c.getCurrentPosition())) && (this.l != null))
    {
      localObject = l();
      if ((this.l.mVideoView != null) && (localObject != null) && (((AIOVideoData)localObject).status == 4)) {
        this.l.mVideoView.resume();
      }
    }
  }
  
  public void o()
  {
    this.k.f.clear();
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
    if (i == 2131430807)
    {
      localObject = this.k.c.getSelectedItem();
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData)))
      {
        localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
        IProvider localIProvider = this.x;
        if (localIProvider != null) {
          localIProvider.b(((AIOVideoData)localObject).a, ((AIOVideoData)localObject).b, 256);
        }
        this.k.a(((AIOVideoData)localObject).a, ((AIOVideoData)localObject).b, 0);
        a();
      }
    }
    else if (i == 2131442308)
    {
      z();
      if (this.k.a != null) {
        this.k.a.o();
      }
    }
    else if (i == 2131442310)
    {
      f();
    }
    else if (i == 2131442309)
    {
      e();
    }
    else if (i == 2131442307)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOVideoView", 2, "onClick qq_gallery_danmaku_view ");
      }
      w();
    }
    else if (i == 2131442315)
    {
      localObject = this.k;
      if (localObject != null) {
        ((AIOVideoPresenter)localObject).j();
      }
    }
    else if (i == 2131430269)
    {
      x();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((AIOVideoPresenter)localObject).b(l());
      if (localObject != null) {
        ((VideoPlayMedioInfo)localObject).a = false;
      }
      this.k.a(2003, 0L);
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
    a(paramLong, this.y);
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
    a(paramInt1, paramInt3, this.y);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    this.C = paramLong2;
  }
  
  public void onScrollEnd()
  {
    AIOVideoPresenter localAIOVideoPresenter = this.k;
    if (localAIOVideoPresenter.a(localAIOVideoPresenter.c.getCurrentPosition()))
    {
      if ((this.l.mVideoView != null) && (this.l.mVideoView.isPlaying()))
      {
        this.k.c();
        return;
      }
      this.k.a(false);
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
            localObject = this.l;
            if (localObject != null) {
              ((VideoView)localObject).abandonAudioFocus();
            }
          }
          else
          {
            localObject = this.l;
            if (localObject != null)
            {
              ((VideoView)localObject).progressTime.setText(BrowserUtils.a(this.l.mVideoView.getVideoDurationMs()));
              this.l.playBar.setProgress(100);
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
      if (!this.y.mIsMute) {
        this.l.requestAudioFocus();
      }
      localObject = l();
      if (localObject != null)
      {
        this.k.c(((AIOVideoData)localObject).a);
        this.k.a(((AIOVideoData)localObject).a, false);
      }
      localObject = this.k;
      if (((AIOVideoPresenter)localObject).a(((AIOVideoPresenter)localObject).c.getCurrentPosition()))
      {
        this.k.c();
        localObject = this.k.c.getSelectedItem();
        if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) && (this.k.b() != null) && (this.l.mVideoView != null)) {
          this.k.b().b(BrowserDanmakuUtils.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).e, this.l.mVideoView.getCurPlayingPos(), this.k.b(), this.k.d));
        }
      }
    }
  }
  
  public void p()
  {
    VideoView localVideoView = this.l;
    if ((localVideoView != null) && (localVideoView.mVideoView != null) && (this.l.mVideoView.isPlaying())) {
      v();
    } else if (this.k.c != null) {
      a(this.k.c.getCurrentPosition(), false);
    }
    if (this.k.a != null) {
      this.k.a.m();
    }
    j();
  }
  
  public void q()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, handle immersion.");
    if (this.k.h())
    {
      if (this.k.g().a)
      {
        this.k.g().a = false;
        this.k.g().a();
        h();
      }
      else
      {
        this.k.g().b();
        this.k.g().a = true;
        e(true);
      }
      this.k.g().f();
      return;
    }
    this.k.j();
  }
  
  public void r()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "onItemClick, play button click.");
    AIOVideoData localAIOVideoData = this.k.r();
    if ((localAIOVideoData != null) && (localAIOVideoData.status != 7)) {
      a(this.k.c.getCurrentPosition(), false);
    }
    k();
  }
  
  public void s()
  {
    if ((this.l.mVideoView != null) && (!this.l.mVideoView.isLocalPlay()) && (this.l.mVideoView.isPlaying()))
    {
      Object localObject = this.c.getString(2131915757);
      localObject = DialogUtil.a(this.c, 230, null, (String)localObject, 2131915741, 2131915768, new AIOVideoView.6(this), new AIOVideoView.7(this));
      this.l.mVideoView.pause();
      a((Dialog)localObject);
    }
  }
  
  public long t()
  {
    VideoView localVideoView = this.l;
    if ((localVideoView != null) && (localVideoView.mVideoView != null)) {
      return this.l.mVideoView.getCurPlayingPos();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView
 * JD-Core Version:    0.7.0.1
 */