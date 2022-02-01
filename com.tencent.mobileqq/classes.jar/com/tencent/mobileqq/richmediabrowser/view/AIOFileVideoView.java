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
import android.util.SparseArray;
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
import com.tencent.mobileqq.mini.api.IMiniAppFileMaterialService;
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
  private long A = -1L;
  private String B = "";
  private IProvider C;
  public AIOFileVideoPresenter k;
  public VideoView l;
  public RelativeLayout m;
  public TextView n;
  public ImageView o;
  public SeekBar p;
  public ImageButton q;
  public ImageButton r;
  public int s;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> t;
  public String u;
  ArrayList<ShareActionSheetBuilder.ActionSheetItem> v = new ArrayList();
  ArrayList<ShareActionSheetBuilder.ActionSheetItem> w = new ArrayList();
  private View x;
  private TVKVideoController y;
  private VideoPlayParam z;
  
  public AIOFileVideoView(Context paramContext, AIOFileVideoPresenter paramAIOFileVideoPresenter)
  {
    super(paramContext, paramAIOFileVideoPresenter);
    this.k = paramAIOFileVideoPresenter;
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
  
  private void a(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    AIOFileVideoData localAIOFileVideoData = s();
    boolean bool2 = false;
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 2)
    {
      localObject1 = new AIOFileVideoModel().a(localAIOFileVideoData, localAIOFileVideoData.z);
      if ((localObject1 != null) && (((VideoPlayMedioInfo)localObject1).c != null) && (!StringUtil.isEmpty(((VideoPlayMedioInfo)localObject1).e)))
      {
        localObject2 = ((VideoPlayMedioInfo)localObject1).c;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject2[i];
          if (!StringUtil.isEmpty(str)) {
            BaseInnerDns.getInstance().reportBadIp(((VideoPlayMedioInfo)localObject1).e, BaseInnerDns.getHostFromUrl(str), ((IVideoDepend)QRoute.api(IVideoDepend.class)).getVideoIpType());
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
    if (localAIOFileVideoData != null)
    {
      if (localObject1 == null) {
        localObject1 = this.c.getString(2131915759);
      }
      localAIOFileVideoData.w = ((String)localObject1);
      localAIOFileVideoData.H += 1;
      localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handlePlayError, videoData.mPlayErrTimes = ");
      ((StringBuilder)localObject2).append(localAIOFileVideoData.H);
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
    if ((bool1) && (this.l.mVideoView != null) && (localAIOFileVideoData != null) && (localAIOFileVideoData.H < 2))
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
    Object localObject = this.k.c.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 103))
    {
      localObject = (AIOFileVideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (QLog.isColorLevel()) {
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, String.format("tryPlayVideo, position:%d , msgId:%s request:%b ", new Object[] { Integer.valueOf(paramInt), Long.valueOf(((AIOFileVideoData)localObject).a), Boolean.valueOf(((AIOFileVideoData)localObject).t) }));
      }
      ((AIOFileVideoData)localObject).y = paramBoolean;
      AIOFileVideoModel localAIOFileVideoModel = new AIOFileVideoModel();
      if ((!localAIOFileVideoModel.c((AIOFileVideoData)localObject)) && (!((AIOFileVideoData)localObject).t))
      {
        localAIOFileVideoModel.a((AIOFileVideoData)localObject, this.C);
        this.k.a((AIOFileVideoData)localObject);
        this.k.a(((AIOFileVideoData)localObject).a, ((AIOFileVideoData)localObject).b, 1);
        a();
        return;
      }
      a(localAIOFileVideoModel.a((AIOFileVideoData)localObject, ((AIOFileVideoData)localObject).z));
      if ((((AIOFileVideoData)localObject).v) && (((AIOFileVideoData)localObject).p != null)) {
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
      this.B = ((File)localObject1).getAbsolutePath();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onVideoFrameCallBack, write tmp file:");
        ((StringBuilder)localObject1).append(this.B);
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, ((StringBuilder)localObject1).toString());
      }
      RichMediaBrowserUtils.a(paramBitmap, this.B);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = ((IFileDepend)QRoute.api(IFileDepend.class)).getDetectCode(paramBitmap);
    paramBitmap = localSparseArray.get(0);
    Object localObject2 = "";
    Object localObject4 = null;
    Object localObject3 = null;
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected QRCode, build item");
      }
      if ((localSparseArray.get(0) instanceof Pair))
      {
        Pair localPair = (Pair)localSparseArray.get(0);
        try
        {
          paramBitmap = new JSONObject();
          try
          {
            paramBitmap.put("scannerType", String.valueOf(localPair.second).trim());
            paramBitmap.put("scannerResult", String.valueOf(localPair.first).trim());
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
    if (localSparseArray.get(1) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, detected MiniCode, build item");
      }
      paramBitmap = localObject4;
      if ((localSparseArray.get(1) instanceof String)) {
        try
        {
          String str = (String)localSparseArray.get(1);
          paramBitmap = new JSONObject();
          try
          {
            paramBitmap.put("strMini", str);
            if ((localSparseArray.get(2) instanceof String)) {
              paramBitmap.put("strMini", (String)localSparseArray.get(2));
            }
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
    this.z = b(paramVideoPlayMedioInfo);
    this.l.setVideoPlayCallback(this);
    if (this.l.mVideoView != null)
    {
      this.l.setVideoPlayCallback(this.z);
      this.l.mVideoView.setVideoParam(this.z);
      this.l.mVideoView.play();
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, AIOFileVideoData paramAIOFileVideoData)
  {
    int i = paramActionSheetItem.uinType;
    paramActionSheetItem = paramActionSheetItem.uin;
    if (w())
    {
      Object localObject = this.C;
      if (localObject != null)
      {
        long l1 = paramAIOFileVideoData.a;
        int j = paramAIOFileVideoData.b;
        boolean bool = false;
        localObject = ((IProvider)localObject).c(l1, j, 0);
        if (paramAIOFileVideoData.f == 1) {
          bool = true;
        }
        ((IFileDepend)QRoute.api(IFileDepend.class)).forwardToTargetFriend((Activity)this.c, (Intent)localObject, bool, paramActionSheetItem, i);
      }
    }
  }
  
  private boolean a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    if ((paramAIOFileVideoData.r == -7003L) || (paramAIOFileVideoData.r == -6101L) || (paramAIOFileVideoData.r == -103L) || (paramAIOFileVideoData.r == -301L)) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private VideoPlayParam b(VideoPlayMedioInfo paramVideoPlayMedioInfo)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    localVideoPlayParam.mIsLocal = (paramVideoPlayMedioInfo.a ^ true);
    if (!localVideoPlayParam.mIsLocal)
    {
      if (paramVideoPlayMedioInfo.r != null)
      {
        localVideoPlayParam.mSavePath = paramVideoPlayMedioInfo.r.getString("savepath");
        localVideoPlayParam.mFileID = paramVideoPlayMedioInfo.r.getString("fileid");
      }
      else
      {
        QLog.e("AIOFileVideoView<FileAssistant>XOXO", 1, "bundle is null!!!");
      }
      localVideoPlayParam.mUrls = paramVideoPlayMedioInfo.c;
      localVideoPlayParam.mCookies = paramVideoPlayMedioInfo.d;
      localVideoPlayParam.mVideoFormat = 104;
      d(1);
    }
    else
    {
      localVideoPlayParam.mVideoPath = paramVideoPlayMedioInfo.b;
      d(3);
    }
    localVideoPlayParam.mIsMute = paramVideoPlayMedioInfo.m;
    localVideoPlayParam.mSceneId = 109;
    localVideoPlayParam.mSceneName = SceneID.getSceneStr(109);
    localVideoPlayParam.mIsLoop = false;
    localVideoPlayParam.mNeedPlayProgress = true;
    return localVideoPlayParam;
  }
  
  private void b(AIOFileVideoData paramAIOFileVideoData)
  {
    if (w())
    {
      Object localObject = this.C;
      if (localObject != null)
      {
        localObject = ((IProvider)localObject).c(paramAIOFileVideoData.a, paramAIOFileVideoData.b, 0);
        boolean bool;
        if (paramAIOFileVideoData.f == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).forwardToFriend((Activity)this.c, (Intent)localObject, bool, ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).getSharePanelType(), "");
      }
    }
  }
  
  private void b(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    String str;
    if (MessageRecordInfo.b(paramAIOFileVideoData.D)) {
      str = ParamsManager.a().k();
    } else {
      str = ParamsManager.a().j();
    }
    ((IVideoDepend)QRoute.api(IVideoDepend.class)).onQRDecodeSucceed(this.c, this.u, paramAIOFileVideoData.C, true, str, null, null, paramAIOFileVideoData.E, paramInt, ParamsManager.a().k(), ParamsManager.a().j());
  }
  
  private void c(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((!PermissionUtil.a(this.c)) && ((this.c instanceof Activity)))
    {
      PermissionUtil.a((Activity)this.c, null);
      return;
    }
    if (new AIOFileVideoModel().c(paramAIOFileVideoData))
    {
      ((IFileDepend)QRoute.api(IFileDepend.class)).saveToAlbum(this.c, paramAIOFileVideoData.l);
      return;
    }
    Bundle localBundle = new Bundle();
    IProvider localIProvider = this.C;
    if (localIProvider != null) {
      localIProvider.a(paramAIOFileVideoData.a, 13, localBundle);
    }
    paramAIOFileVideoData.A = true;
    a(paramAIOFileVideoData.a, paramAIOFileVideoData.b);
    a();
  }
  
  private void d(int paramInt)
  {
    AIOFileVideoData localAIOFileVideoData = s();
    if (localAIOFileVideoData != null) {
      this.k.a(localAIOFileVideoData.a, localAIOFileVideoData.b, paramInt);
    }
  }
  
  private String e(int paramInt)
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
  
  private int f(int paramInt)
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
  
  private int g(int paramInt)
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
  
  private boolean i(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 21) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.k.c.getSelectedItem();
      if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof AIOFileVideoData)))
      {
        if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localRichMediaBrowserInfo.baseData).l)) {
          return false;
        }
        this.r.setVisibility(0);
        return true;
      }
    }
    else
    {
      this.r.setVisibility(4);
    }
    return false;
  }
  
  private void j(boolean paramBoolean)
  {
    View localView = this.x;
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
    Object localObject = this.l;
    if (localObject != null) {
      ((VideoView)localObject).pauseVideo();
    }
    localObject = this.k;
    if (((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).c.getCurrentPosition())) {
      this.k.a(true);
    }
  }
  
  private void v()
  {
    AIOFileVideoData localAIOFileVideoData = this.k.r();
    if (localAIOFileVideoData != null)
    {
      if (!FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.l)) {
        return;
      }
      TVKVideoController localTVKVideoController = this.y;
      if (localTVKVideoController != null) {
        localTVKVideoController.b();
      }
      long l1 = this.l.mVideoView.getCurPlayingPos();
      this.y = new TVKVideoController(this.c);
      this.y.a(localAIOFileVideoData.l, localAIOFileVideoData.a, l1);
      if (FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.k)) {
        this.y.a(localAIOFileVideoData.k, localAIOFileVideoData.n, localAIOFileVideoData.o);
      }
      if (this.y.a(localAIOFileVideoData.f, localAIOFileVideoData.n, localAIOFileVideoData.o)) {
        this.k.j();
      }
    }
  }
  
  private boolean w()
  {
    IProvider localIProvider = this.C;
    return (localIProvider != null) && (localIProvider.c());
  }
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    this.g = ((RelativeLayout)LayoutInflater.from(this.c).inflate(2131629206, null));
    l();
    if (this.l.videoControlContainer != null) {
      this.l.videoControlContainer.addView(this.g);
    }
    return this.l.mBrowserItemView;
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = this.k.r();
    if ((localObject1 != null) && (this.l != null))
    {
      c(g());
      d(a(this.k.c.getSelectedItem()));
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
                  this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
                  f = (float)((AIOFileVideoData)localObject1).I / (float)((AIOFileVideoData)localObject1).d * 100.0F;
                  localObject1 = new DecimalFormat("0.00").format(f);
                  localObject2 = this.n;
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(this.c.getString(2131915754));
                  localStringBuilder.append((String)localObject1);
                  localStringBuilder.append("%");
                  ((TextView)localObject2).setText(localStringBuilder.toString());
                  this.n.setVisibility(0);
                  this.p.setProgress((int)f * 100);
                  this.l.bufferPanel.setVisibility(8);
                  this.l.showPlayPanel(false);
                  g(true);
                  d(false);
                  this.l.mErrLayout.setVisibility(8);
                  this.l.mCenterPlayBtn.setVisibility(8);
                  i(false);
                  return;
                }
                this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
                this.l.showPlayPanel(false);
                if (((AIOFileVideoData)localObject1).v)
                {
                  g(false);
                }
                else
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(this.c.getString(2131915730));
                  ((StringBuilder)localObject2).append("(");
                  ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).I));
                  ((StringBuilder)localObject2).append("/");
                  ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).d));
                  ((StringBuilder)localObject2).append(")");
                  localObject2 = ((StringBuilder)localObject2).toString();
                  this.n.setText((CharSequence)localObject2);
                  this.n.setVisibility(0);
                  f = (float)((AIOFileVideoData)localObject1).I / (float)((AIOFileVideoData)localObject1).d;
                  this.p.setProgress((int)(f * 100.0F) * 100);
                  g(true);
                }
                this.l.bufferPanel.setVisibility(8);
                this.l.mErrLayout.setVisibility(0);
                this.l.mCenterPlayBtn.setVisibility(8);
                this.l.playButton.setImageResource(2130847779);
                i(false);
                return;
              }
              this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
              this.l.showPlayPanel(false);
              g(false);
              this.l.bufferPanel.setVisibility(8);
              this.l.mErrLayout.setVisibility(8);
              this.l.mCenterPlayBtn.setVisibility(0);
              this.l.playButton.setImageResource(2130847779);
              i(true);
              this.n.setVisibility(8);
              return;
            }
            this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
            this.l.showPlayPanel(true);
            g(false);
            this.l.bufferPanel.setVisibility(8);
            this.l.mErrLayout.setVisibility(8);
            this.l.mCenterPlayBtn.setVisibility(8);
            this.l.playButton.setImageResource(2130847780);
            i(true);
            this.l.coverView.setVisibility(8);
            this.n.setVisibility(8);
            if (this.l.mVideoView != null)
            {
              long l1 = this.l.mVideoView.getVideoDurationMs();
              localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("videoDuration = ");
              ((StringBuilder)localObject2).append(l1);
              ((IBrowserLog)localObject1).d("AIOFileVideoView<FileAssistant>XOXO", 4, ((StringBuilder)localObject2).toString());
              this.l.totalTime.setText(BrowserUtils.a(l1));
              this.l.progressTime.setText(BrowserUtils.a(0L));
            }
          }
          else
          {
            if (this.l.mVideoView.isPlaying()) {
              this.l.bufferPanel.setVisibility(0);
            } else {
              this.l.bufferPanel.setVisibility(8);
            }
            this.n.setVisibility(8);
            this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
            if (((AIOFileVideoData)localObject1).v)
            {
              this.l.showPlayPanel(true);
              g(false);
            }
            else
            {
              g(true);
              this.l.showPlayPanel(false);
              d(false);
            }
            this.l.mCenterPlayBtn.setVisibility(8);
            this.l.mErrLayout.setVisibility(8);
            i(true);
          }
        }
        else
        {
          this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
          this.l.showPlayPanel(false);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.c.getString(2131915730));
          ((StringBuilder)localObject2).append("(");
          ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).I));
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append(FileSizeFormat.a(((AIOFileVideoData)localObject1).d));
          ((StringBuilder)localObject2).append(")");
          localObject2 = ((StringBuilder)localObject2).toString();
          this.n.setText((CharSequence)localObject2);
          this.n.setVisibility(0);
          f = (float)((AIOFileVideoData)localObject1).I / (float)((AIOFileVideoData)localObject1).d;
          this.p.setProgress((int)(f * 100.0F) * 100);
          g(true);
          d(false);
          this.l.bufferPanel.setVisibility(8);
          this.l.mErrLayout.setVisibility(8);
          this.l.mCenterPlayBtn.setVisibility(8);
          i(false);
        }
      }
      else
      {
        this.k.c.onLoadFinish(this.k.c.getSelectedIndex(), true);
        this.l.showPlayPanel(false);
        g(false);
        this.n.setVisibility(8);
        this.l.bufferPanel.setVisibility(8);
        this.l.mErrLayout.setVisibility(8);
        localObject2 = this.l.mCenterPlayBtn;
        if (!((AIOFileVideoData)localObject1).y) {
          i = 0;
        }
        ((ImageView)localObject2).setVisibility(i);
        this.l.playButton.setImageResource(2130847779);
        this.l.progressTime.setText(BrowserUtils.a(0L));
        this.l.playBar.setProgress(0);
        if (((AIOFileVideoData)localObject1).v) {
          i(true);
        } else {
          i(false);
        }
        this.l.coverView.setVisibility(0);
      }
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.k.c.getItem(paramInt);
    if (localRichMediaBrowserInfo != null)
    {
      if (localRichMediaBrowserInfo.baseData == null) {
        return;
      }
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        Object localObject1 = this.k.p();
        if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103) && (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject1).baseData).a == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).a) && (!((RichMediaBrowserInfo)localObject1).isReport))
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
        localObject1 = (Drawable)this.k.c.mActiveDrawable.get(Integer.valueOf(paramInt));
        if (!localAIOFileVideoModel.d(localAIOFileVideoData)) {
          if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1))
          {
            this.k.c.onLoadFinish(paramInt, true);
          }
          else if (!TextUtils.isEmpty(localAIOFileVideoData.k))
          {
            Object localObject2 = new File(localAIOFileVideoData.k);
            if (((File)localObject2).exists())
            {
              localObject1 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = this.i;
              ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = this.j;
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelperConstants.a;
              ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
              ((URLDrawable.URLDrawableOptions)localObject1).mUseExifOrientation = false;
              localObject1 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject1);
              localObject2 = (URLDrawable)localObject1;
              ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
              this.k.c.mActiveDrawable.put(Integer.valueOf(paramInt), localObject2);
            }
          }
          else
          {
            localObject1 = BaseApplication.getContext().getResources().getDrawable(2130851629);
          }
        }
        this.l.coverView.setImageDrawable((Drawable)localObject1);
        if (localAIOFileVideoModel.d(localAIOFileVideoData)) {
          this.l.coverView.setImageDrawable(null);
        }
        if (localRichMediaBrowserInfo.isEnterImage) {
          localAIOFileVideoData.x = true;
        }
        localObject1 = new AIOFileVideoView.GalleryFileVideoViewHolder(this);
        ((AIOFileVideoView.GalleryFileVideoViewHolder)localObject1).a = this.l.mVideoView;
        this.l.mBrowserItemView.setTag(localObject1);
      }
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.k.c.mActiveDrawable != null) {
      this.k.c.mActiveDrawable.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(int paramInt1, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt2, Bundle paramBundle)
  {
    paramString2 = BrowserLogHelper.getInstance().getGalleryLog();
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("setVideoDrawableWithUrls position = ");
    paramMessageRecord.append(paramInt1);
    paramString2.d("AIOFileVideoView<FileAssistant>XOXO", 4, paramMessageRecord.toString());
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.k.c.getItem(paramInt1);
    if (localRichMediaBrowserInfo != null)
    {
      if (localRichMediaBrowserInfo.baseData == null) {
        return;
      }
      if (localRichMediaBrowserInfo.baseData.getType() == 103)
      {
        paramString2 = (AIOFileVideoData)localRichMediaBrowserInfo.baseData;
        paramString2.G = paramBundle;
        paramMessageRecord = new AIOFileVideoModel();
        if (paramString2.t)
        {
          paramString1 = BrowserLogHelper.getInstance().getGalleryLog();
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("fileVideo is playing:");
          paramArrayOfString.append(paramString2.id);
          paramString1.d("AIOFileVideoView<FileAssistant>XOXO", 4, paramArrayOfString.toString());
          return;
        }
        paramString2.l = paramString1;
        paramString2.t = true;
        if (!"I:E".equals(paramString1)) {}
      }
    }
    try
    {
      paramString2.r = Long.parseLong(paramArrayOfString[0]);
      paramString1 = paramArrayOfString[1];
      ((AIOFileVideoData)localRichMediaBrowserInfo.baseData).w = paramString1;
      this.k.a(paramString2.a, paramString2.b, 6);
      boolean bool;
      if (((IFileDepend)QRoute.api(IFileDepend.class)).isVideoFileError(paramString2.r))
      {
        paramString1 = this.c.getString(2131915766);
        bool = true;
      }
      else
      {
        bool = a(paramString2, false);
      }
      if (!bool) {
        break label344;
      }
      paramString1 = DialogUtil.a(this.c, 230, "", paramString1, null, this.c.getString(2131915738), new AIOFileVideoView.1(this), null);
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
    paramString2.r = -1L;
    label344:
    paramString2.s = paramArrayOfString[1];
    break label376;
    paramString2.p = paramArrayOfString[0];
    paramString2.q = paramBundle.getStringArrayList("cookies");
    label376:
    this.k.a(paramString2.a, paramString2.b, 0);
    paramString1 = paramMessageRecord.a(paramString2, paramString2.z);
    paramArrayOfString = BrowserLogHelper.getInstance().getGalleryLog();
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("setVideoDrawableWithUrls autoPlay id = ");
    paramMessageRecord.append(paramString2.id);
    paramArrayOfString.d("AIOFileVideoView<FileAssistant>XOXO", 4, paramMessageRecord.toString());
    this.k.a(paramString2.a, paramString2.b, 3);
    a(paramString1);
  }
  
  public void a(long paramLong)
  {
    super.a(paramLong);
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.k.c.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 103))
    {
      if ((this.l.mVideoView != null) && (this.l.mVideoView.isPlaying())) {
        this.l.mVideoView.pause();
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onRevokeMsg exp!");
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.k.a(paramLong, paramInt, 7);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String[] paramArrayOfString, String paramString2, MessageRecord paramMessageRecord, int paramInt3, Bundle paramBundle)
  {
    this.k.a(paramLong, paramInt1, paramInt2, paramString1);
    a(this.k.c.getSelectedIndex(), paramString1, paramArrayOfString, paramString2, paramMessageRecord, paramInt3, paramBundle);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.s = (ViewUtils.getScreenWidth() / 2);
    if ((this.k.a != null) && ((this.k.a.getParamsBuilder().a() instanceof IProvider))) {
      this.C = ((IProvider)this.k.a.getParamsBuilder().a());
    }
  }
  
  public void a(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onStopTrackingTouch");
    if (this.k.b() != null)
    {
      Object localObject = this.k;
      if ((((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).c.getCurrentPosition())) && (paramSeekBar != null))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "seek danmaku");
        this.k.b().a(paramSeekBar.getProgress());
        localObject = this.k.r();
        if (localObject != null) {
          this.k.b().b(BrowserDanmakuUtils.a(((AIOFileVideoData)localObject).e, paramSeekBar.getProgress(), this.k.b(), this.k.d));
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
  
  public void a(AIOFileVideoData paramAIOFileVideoData)
  {
    this.b.setItemClickListenerV2(new AIOFileVideoView.6(this, paramAIOFileVideoData));
  }
  
  public void a(AIOFileVideoData paramAIOFileVideoData, int paramInt)
  {
    if (((this.c instanceof Activity)) && (((Activity)this.c).getIntent() != null)) {
      ((Activity)this.c).getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
    }
    this.v.clear();
    this.w.clear();
    RichMediaBrowserUtils.a(2, this.v);
    RichMediaBrowserUtils.a(27, this.v);
    if (((paramAIOFileVideoData.isLocal) || (paramAIOFileVideoData.v)) && (((IMiniAppFileMaterialService)QRoute.api(IMiniAppFileMaterialService.class)).isFileSupported(paramAIOFileVideoData.l))) {
      RichMediaBrowserUtils.a(166, this.v);
    }
    if ((paramAIOFileVideoData.isLocal) || (paramAIOFileVideoData.v)) {
      RichMediaBrowserUtils.a(64, this.v);
    }
    RichMediaBrowserUtils.a(39, this.w);
    if (this.C.e(paramAIOFileVideoData.a)) {
      RichMediaBrowserUtils.a(6, this.w);
    }
    if ((ParamsManager.a().r()) && (!TextUtils.isEmpty(ParamsManager.a().j()))) {
      RichMediaBrowserUtils.a(54, this.w);
    }
    if (this.l.mVideoView.isPlaying())
    {
      long l1 = this.l.mVideoView.getCurPlayingPos();
      this.l.mVideoView.captureCurFrame(l1, 0, 0);
    }
    else if (this.l.playBar.getProgress() > 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheet, captureCurFrame, from:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", pos:");
        localStringBuilder.append(this.A);
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, localStringBuilder.toString());
      }
      this.l.mVideoView.captureCurFrame(this.A, 0, 0);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "showActionSheet, video is not playing, recognize thumbnail");
      }
      ThreadManager.getSubThreadHandler().post(new AIOFileVideoView.5(this));
    }
    if (((paramAIOFileVideoData.isLocal) || (paramAIOFileVideoData.v)) && (QbSdk.isInDefaultBrowser(this.c, paramAIOFileVideoData.l))) {
      RichMediaBrowserUtils.a(132, this.w);
    }
    this.t = this.w;
    this.u = null;
    a(paramAIOFileVideoData);
    if ((this.c instanceof Activity))
    {
      paramAIOFileVideoData = this.k.a(paramAIOFileVideoData, (Activity)this.c);
      if (paramAIOFileVideoData != null) {
        this.b.setIntentForStartForwardRecentActivity(paramAIOFileVideoData);
      }
    }
    this.b.setActionSheetItems(this.v, this.w);
    this.b.show();
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
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return super.a(paramRichMediaBrowserInfo);
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
    localObject1 = this.k.c.getItem(paramInt);
    if (localObject1 != null)
    {
      if (((RichMediaBrowserInfo)localObject1).baseData == null) {
        return;
      }
      if (((RichMediaBrowserInfo)localObject1).baseData.getType() == 103)
      {
        localObject2 = (AIOFileVideoData)((RichMediaBrowserInfo)localObject1).baseData;
        AIOFileVideoModel localAIOFileVideoModel = new AIOFileVideoModel();
        if ((((AIOFileVideoData)localObject2).y) && (localAIOFileVideoModel.c((AIOFileVideoData)localObject2)))
        {
          a(paramInt, true);
          return;
        }
        this.k.a(((AIOFileVideoData)localObject2).a, ((AIOFileVideoData)localObject2).b, 0);
        if (((RichMediaBrowserInfo)localObject1).isEnterImage) {
          ((AIOFileVideoData)localObject2).x = true;
        }
        if (this.C != null)
        {
          if (((AIOFileVideoData)localObject2).y)
          {
            this.k.a(((AIOFileVideoData)localObject2).a, ((AIOFileVideoData)localObject2).b, 1);
            localAIOFileVideoModel.a((AIOFileVideoData)localObject2, this.C);
          }
          if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject2).l))
          {
            localObject1 = this.k;
            if (((AIOFileVideoPresenter)localObject1).a(((AIOFileVideoPresenter)localObject1).c.getCurrentPosition())) {
              this.k.a(false);
            }
          }
          a();
          BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "FileVideo_AP onItemSelected needUrl return");
          return;
        }
        if ((this.k.c(paramInt)) && (((RichMediaBrowserInfo)localObject1).isEnterImage)) {
          a(localAIOFileVideoModel.a((AIOFileVideoData)localObject2, ((AIOFileVideoData)localObject2).z));
        }
        if (!FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject2).l))
        {
          localObject1 = this.k;
          if (((AIOFileVideoPresenter)localObject1).a(((AIOFileVideoPresenter)localObject1).c.getCurrentPosition())) {
            this.k.a(false);
          }
        }
        this.t = null;
        this.u = null;
        a();
      }
    }
  }
  
  public void c()
  {
    this.C = null;
    Object localObject = this.k;
    if (localObject != null) {
      ((AIOFileVideoPresenter)localObject).c(s());
    }
    super.c();
    localObject = this.l;
    if (localObject != null) {
      ((VideoView)localObject).onDestroy();
    }
  }
  
  public void c(int paramInt)
  {
    super.c(paramInt);
    AIOFileVideoData localAIOFileVideoData = this.k.r();
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
      if (this.k.b() != null) {
        bool = this.k.b().h();
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
      this.k.b(false);
      return;
    }
    if ((this.k.b() != null) && (this.k.b().h()))
    {
      this.k.g().a = false;
      this.k.k();
      this.k.l();
      j(false);
      return;
    }
    f(false);
    b(false);
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
    h(g());
  }
  
  public boolean g()
  {
    if (super.g())
    {
      AIOFileVideoData localAIOFileVideoData = this.k.r();
      if ((localAIOFileVideoData != null) && (!ParamsManager.a().g()) && (FileUtils.fileExistsAndNotEmpty(localAIOFileVideoData.l))) {
        return true;
      }
    }
    return false;
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.m != null)
    {
      DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      localLayoutParams.addRule(12, -1);
      if (paramBoolean)
      {
        localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 49.0F, localDisplayMetrics));
        return;
      }
      localLayoutParams.rightMargin = ((int)TypedValue.applyDimension(1, 10.0F, localDisplayMetrics));
    }
  }
  
  public void i()
  {
    j(true);
  }
  
  public void l()
  {
    if (this.g != null)
    {
      localObject = (RelativeLayout)this.g.findViewById(2131439678);
      this.r = ((ImageButton)this.g.findViewById(2131442308));
      this.r.setContentDescription(this.c.getString(2131915731));
      this.r.setOnClickListener(this);
      this.l.initContentView(this.g);
      this.m = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131449155));
      this.p = ((SeekBar)this.m.findViewById(2131449157));
      this.p.setMax(10000);
      this.n = ((TextView)this.m.findViewById(2131449156));
      this.o = ((ImageView)this.m.findViewById(2131430807));
      this.m.setVisibility(8);
      this.o.setOnClickListener(this);
      this.f = ((ImageButton)this.g.findViewById(2131442307));
      if (this.f != null) {
        this.f.setOnClickListener(this);
      }
      this.e = ((ImageButton)this.g.findViewById(2131442309));
      if (this.e != null) {
        this.e.setOnClickListener(this);
      }
      this.q = ((ImageButton)this.g.findViewById(2131442315));
      this.q.setOnClickListener(this);
      this.x = this.g.findViewById(2131449733);
      this.d = ((ImageButton)this.g.findViewById(2131442310));
      this.d.setOnClickListener(this);
      if (LiuHaiUtils.b())
      {
        localObject = (RelativeLayout.LayoutParams)this.r.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.d;
        localObject = (RelativeLayout.LayoutParams)this.q.getLayoutParams();
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
  
  public void m()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView<FileAssistant>XOXO", 4, "onResume");
    Object localObject = this.k;
    if ((((AIOFileVideoPresenter)localObject).c(((AIOFileVideoPresenter)localObject).c.getCurrentPosition())) && (this.l.mVideoView != null))
    {
      localObject = this.k.r();
      if ((localObject != null) && (((AIOFileVideoData)localObject).status == 4)) {
        this.l.mVideoView.resume();
      }
    }
  }
  
  public void n()
  {
    this.k.c(s());
  }
  
  public void o()
  {
    a(this.k.c.getCurrentPosition(), true);
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
    if (i == 2131430807)
    {
      localObject = this.k.r();
      if (localObject != null)
      {
        ((AIOFileVideoData)localObject).u = true;
        this.k.a(((AIOFileVideoData)localObject).a, ((AIOFileVideoData)localObject).b, 0);
        this.k.b((AIOFileVideoData)localObject);
        this.k.j();
      }
    }
    else if (i == 2131442308)
    {
      v();
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
        QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onClick qq_gallery_danmaku_view ");
      }
      localObject = this.k.r();
      if ((localObject != null) && ((this.c instanceof Activity)))
      {
        long l1 = this.l.mVideoView.getCurPlayingPos();
        ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).openMiniAioForDanmaku((Activity)this.c, ParamsManager.a().i(), ParamsManager.a().e(), false, ((AIOFileVideoData)localObject).e, l1);
      }
      this.k.q();
    }
    else if (i == 2131442315)
    {
      localObject = this.k;
      if (localObject != null) {
        ((AIOFileVideoPresenter)localObject).j();
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
    localObject = s();
    if (!((AIOFileVideoData)localObject).v) {
      this.k.d((AIOFileVideoData)localObject);
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
    a(paramInt1, paramInt3, this.z);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    this.A = paramLong2;
    VideoView localVideoView = this.l;
    if (localVideoView != null)
    {
      double d1 = paramLong2;
      double d2 = localVideoView.mVideoView.getVideoDurationMs();
      Double.isNaN(d1);
      Double.isNaN(d2);
      int i = (int)(d1 / d2 * 10000.0D);
      this.l.progressTime.setText(BrowserUtils.a(paramLong2));
      this.l.playBar.setProgress(i);
    }
  }
  
  public void onScrollEnd()
  {
    Object localObject = this.k;
    if (((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).c.getCurrentPosition()))
    {
      localObject = this.k.r();
      if (localObject != null) {
        FileUtils.fileExistsAndNotEmpty(((AIOFileVideoData)localObject).l);
      }
      this.k.a(false);
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 2, "onScrollHalfScreenWidth");
    }
    if ((this.l.mVideoView != null) && (this.l.mVideoView.mIsPlayVideo)) {
      this.k.c(s());
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStateChange , state = ");
      ((StringBuilder)localObject).append(e(paramInt));
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
            localObject = s();
            if (localObject != null) {
              ((AIOFileVideoData)localObject).v = true;
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
      localObject = s();
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onStateChange , state = ");
        ((StringBuilder)localObject).append(e(paramInt));
        ((StringBuilder)localObject).append(", msgUniseq=");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" get videoData is null!");
        QLog.w("AIOFileVideoView<FileAssistant>XOXO", 1, ((StringBuilder)localObject).toString());
        return;
      }
      if (((AIOFileVideoData)localObject).v) {
        d(3);
      } else {
        d(1);
      }
      a();
      this.k.c(((AIOFileVideoData)localObject).a);
      this.k.b(((AIOFileVideoData)localObject).a);
      localObject = this.k;
      if (((AIOFileVideoPresenter)localObject).a(((AIOFileVideoPresenter)localObject).c.getCurrentPosition()))
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
    AIOFileVideoData localAIOFileVideoData = this.k.r();
    if ((this.l.mVideoView != null) && (this.l.mVideoView.isPlaying()))
    {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video playing, try PAUSE!");
      u();
    }
    else
    {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "video pause, try PLAY!");
      new AIOFileVideoModel().a(localAIOFileVideoData, this.c, this);
    }
    if (this.k.a != null) {
      this.k.a.m();
    }
    j();
  }
  
  public void q()
  {
    if (this.k.h())
    {
      if (this.k.g().a)
      {
        this.k.g().f();
        this.k.g().a = false;
        h();
        this.k.g().a();
        return;
      }
      this.k.g().f();
      this.k.g().b();
      this.k.g().a = true;
      e(true);
      return;
    }
    this.k.j();
  }
  
  public void r()
  {
    AIOFileVideoData localAIOFileVideoData = this.k.r();
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
    if (localAIOFileVideoModel.c(localAIOFileVideoData)) {
      this.k.a(localAIOFileVideoData.a, localAIOFileVideoData.b, 3);
    } else {
      this.k.a(localAIOFileVideoData.a, localAIOFileVideoData.b, 1);
    }
    a(this.k.c.getCurrentPosition(), false);
    k();
    a();
  }
  
  public AIOFileVideoData s()
  {
    return this.k.r();
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
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView
 * JD-Core Version:    0.7.0.1
 */