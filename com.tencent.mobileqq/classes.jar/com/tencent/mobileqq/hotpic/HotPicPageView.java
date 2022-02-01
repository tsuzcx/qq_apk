package com.tencent.mobileqq.hotpic;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakConstants;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@TargetApi(14)
public class HotPicPageView
  extends RelativeLayout
  implements HotPicRecyclerView.ScrollStatusChengedListener, HotVideoMongoliaRelativeLayout.OnVidoeControlListener, OnHolderItemClickListener
{
  public static boolean o = true;
  public static int p;
  public static final int t;
  public static final int u;
  public static final int v;
  public static Drawable w = new ColorDrawable(-855310);
  public static final int x;
  public static final double y;
  public static boolean z = true;
  public ArrayList<HotVideoMongoliaRelativeLayout> A = new ArrayList();
  public HotPicPageView.MyVideoViewHolder B = null;
  public HotVideoBlurTaskManager C;
  public int D = -1;
  public int E = -1;
  Handler F;
  BroadcastReceiver G;
  boolean H = false;
  protected HotPicPageView.OnHotPicItemClickListener I;
  boolean J = false;
  private int K = 0;
  private SparseArray<String> L = new SparseArray();
  HotPicMainPanel a;
  Context b;
  QQAppInterface c;
  BaseSessionInfo d;
  BaseActivity e;
  StaggeredGridLayoutManager f;
  HotPicRecyclerView g;
  HotPicPageView.HotPicAdapter h;
  HotPicPageView.HotPicFooter i;
  View j;
  View k;
  int l;
  int m;
  HotPicTagInfo n;
  HotpicDownloadDispatcher q;
  Set<Integer> r = new HashSet();
  Set<Integer> s = new HashSet();
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    u = AIOUtils.b(1.0F, localResources);
    t = (localResources.getDisplayMetrics().widthPixels - u * 8) / 3;
    v = AIOUtils.b(1.0F, localResources);
    x = localResources.getDisplayMetrics().widthPixels - u * 4;
    y = 1.777777791023254D;
    p = -1;
  }
  
  public HotPicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = w;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    boolean bool;
    if (paramHotPicData.getDataType() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    localURLDrawableOptions.mPlayGifImage = bool;
    localURLDrawableOptions.mExtraInfo = paramHotPicData;
    if (paramHotPicData.getDataType() == 2) {
      paramHotPicData = HotVideoPreviewDownloader.b((HotVideoData)paramHotPicData);
    } else {
      paramHotPicData = HotPicDownLoader.b(paramHotPicData.url);
    }
    if (paramHotPicData == null) {
      return null;
    }
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public static Size a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt2 > 0) && (paramInt3 > 0) && (paramDouble != 0.0D) && (paramInt1 > 0))
    {
      double d1 = paramInt2 / paramInt3;
      Double.isNaN(d1);
      d1 -= paramDouble;
      if (d1 > 0.01D)
      {
        if (paramInt2 != paramInt1)
        {
          d1 = paramInt1 / paramInt2;
          paramDouble = paramInt3;
          Double.isNaN(paramDouble);
          Double.isNaN(d1);
        }
      }
      else {
        for (;;)
        {
          paramInt3 = (int)(paramDouble * d1);
          break label200;
          if (d1 < 0.01D)
          {
            if (paramInt2 == paramInt1) {
              break;
            }
            d1 = paramInt1;
            Double.isNaN(d1);
            paramDouble = d1 / paramDouble;
            d1 = paramInt3;
            Double.isNaN(d1);
            if (Math.abs(d1 - paramDouble) <= 0.01D) {
              break;
            }
            Double.isNaN(d1);
            d1 = paramDouble / d1;
            double d2 = paramInt2;
            Double.isNaN(d2);
            paramInt1 = (int)(d2 * d1);
            paramInt3 = (int)paramDouble;
            break label200;
          }
          if (paramInt2 == paramInt1) {
            break;
          }
          d1 = paramInt1 / paramInt2;
          paramDouble = paramInt3;
          Double.isNaN(paramDouble);
          Double.isNaN(d1);
        }
      }
      paramInt1 = paramInt2;
      label200:
      return new Size(paramInt1, paramInt3);
    }
    return null;
  }
  
  public static int b(HotPicData paramHotPicData)
  {
    URL localURL;
    if (paramHotPicData.getDataType() == 2) {
      localURL = HotVideoPreviewDownloader.b((HotVideoData)paramHotPicData);
    } else {
      localURL = HotPicDownLoader.b(paramHotPicData.url);
    }
    if (localURL == null) {
      return -1;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    if (paramHotPicData.getDataType() == 2) {
      localObject = HotVideoPreviewDownloader.a(paramHotPicData.md5);
    } else {
      localObject = HotPicDownLoader.a(paramHotPicData.url);
    }
    if ((localObject != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath()))) {
      return 0;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      localObject = HotPicDownLoader.a(paramHotPicData.url);
      if ((localObject != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath()))) {
        return -1;
      }
      URLDrawable.removeMemoryCacheByUrl(localURL.toString());
      paramHotPicData = a(paramHotPicData);
      if (paramHotPicData != null) {
        paramHotPicData.startDownload();
      }
      return 1;
    }
    localURLDrawable.startDownload();
    return 2;
  }
  
  public static void c()
  {
    o = true;
    p = -1;
  }
  
  public static boolean p()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public void a()
  {
    if (this.H) {
      return;
    }
    l();
    this.H = true;
  }
  
  public void a(int paramInt)
  {
    p = paramInt;
    boolean bool;
    if (p <= 0) {
      bool = true;
    } else {
      bool = false;
    }
    o = bool;
  }
  
  void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay startAutoPlayTimer");
    }
    int i2 = NetworkUtil.getNetworkType(BaseApplication.getContext());
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    if (!z)
    {
      if (i1 == 0) {
        return;
      }
      h();
      this.F.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    try
    {
      HotPicData localHotPicData = (HotPicData)this.h.a.get(paramInt);
      if (localHotPicData.getDataType() == 2) {
        return;
      }
      int i1 = localHotPicData.tag;
      localObject1 = HotPicDownLoader.a(localHotPicData.originalUrl);
      if ((localObject1 != null) && (FileUtils.fileExistsAndNotEmpty(((File)localObject1).getAbsolutePath())))
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("senHotPic, urlHotPicOringinal = ");
          ((StringBuilder)localObject2).append(localHotPicData.originalUrl);
          ((StringBuilder)localObject2).append(", paths = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject2).toString());
        }
        i1 = 1;
      }
      else
      {
        if (b(localHotPicData) == 0)
        {
          localObject1 = HotPicDownLoader.a(localHotPicData.url).getAbsolutePath();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("senHotPic, urlHotPic = ");
            ((StringBuilder)localObject2).append(localHotPicData.url);
            ((StringBuilder)localObject2).append(", paths = ");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          localObject1 = null;
        }
        i1 = 0;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.n.position);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.n.tagName);
      ((StringBuilder)localObject4).append("");
      localObject4 = ((StringBuilder)localObject4).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localHotPicData.url);
      localStringBuilder.append("");
      a("0X8007EDE", (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
      localObject2 = this.I;
      if ((localObject2 != null) && (((HotPicPageView.OnHotPicItemClickListener)localObject2).a(paramView, (String)localObject1, localHotPicData))) {
        return;
      }
      if ((localObject1 == null) && (this.d.a != 1008))
      {
        QQToast.makeText(this.b, 2131896955, 0).show();
        return;
      }
      paramView = new Intent();
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
      paramView.putExtra("uin", this.d.b);
      paramView.putExtra("uintype", this.d.a);
      paramView.putExtra("troop_uin", this.d.c);
      paramView.putExtra("key_confess_topicid", this.d.v);
      paramView.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      paramView.putExtra("send_in_background", true);
      paramView.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
      paramView.putExtra("PicContants.NEED_COMPRESS", false);
      paramView.putExtra("HOT_PIC_SEND_PIC", true);
      if (i1 == 0)
      {
        paramView.putExtra("quick_send_original_md5", localHotPicData.originalMD5);
        paramView.putExtra("quick_send_original_size", localHotPicData.oringinalSize);
        paramView.putExtra("quick_send_thumb_md5", localHotPicData.md5);
      }
      paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
      ThreadManager.post(new SendPhotoTask(this.e, paramView, null), 8, null, false);
      HotPicManager.a(this.c).a(localHotPicData);
      ReportController.b(this.c, "dc00898", "", "", "0X8007B17", "0X8007B17", 0, 0, "", "", "", "");
      if (this.d.a == 3000)
      {
        ReportController.b(this.c, "dc00898", "", "", "0X8007B1A", "0X8007B1A", 0, 0, "", "", "", "");
      }
      else if (this.d.a == 1)
      {
        ReportController.b(this.c, "dc00898", "", "", "0X8007B1B", "0X8007B1B", 0, 0, "", "", "", "");
        if (this.n.tagName.equals(AIOIceBreakConstants.a)) {
          ReportController.b(this.c, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 2, 0, "", "", "", "");
        }
      }
      else
      {
        ReportController.b(this.c, "dc00898", "", "", "0X8007B19", "0X8007B19", 0, 0, "", "", "", "");
        if (this.n.tagName.equals(AIOIceBreakConstants.b)) {
          ReportController.b(this.c, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 1, 0, "", "", "", "");
        }
      }
      if (this.l == -20) {
        ReportController.b(this.c, "dc00898", "", "", "0X8007B18", "0X8007B18", 0, 0, "", "", "", "");
      }
      paramInt = localHotPicData.sourceType;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          ReportController.b(this.c, "dc00898", "", "", "0X8007B1F", "0X8007B1F", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.c, "dc00898", "", "", "0X8007B20", "0X8007B20", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.c, "dc00898", "", "", "0X8007B1E", "0X8007B1E", 0, 0, "", "", "", "");
      return;
    }
    catch (IndexOutOfBoundsException paramView)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("senHotPic, onItemClick IndexOutOfBoundsException ");
        ((StringBuilder)localObject1).append(paramView.getMessage());
        QLog.d("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(HotPicMainPanel paramHotPicMainPanel, HotPicTagInfo paramHotPicTagInfo)
  {
    this.g = ((HotPicRecyclerView)findViewById(2131444519));
    this.j = findViewById(2131437622);
    this.k = findViewById(2131435180);
    this.a = paramHotPicMainPanel;
    this.b = paramHotPicMainPanel.g;
    this.c = paramHotPicMainPanel.f;
    this.d = paramHotPicMainPanel.n;
    this.e = paramHotPicMainPanel.o;
    this.n = paramHotPicTagInfo;
    this.l = paramHotPicTagInfo.tagId;
    this.m = paramHotPicTagInfo.position;
    int i1;
    if (paramHotPicTagInfo.tagType == 2) {
      i1 = 1;
    } else {
      i1 = 3;
    }
    this.f = new StaggeredGridLayoutManager(i1, 1);
    this.g.setLayoutManager(this.f);
    this.f.mExceptionListener = new HotPicPageView.1(this);
    this.h = new HotPicPageView.HotPicAdapter(this, this.l);
    paramHotPicTagInfo = this.h;
    paramHotPicTagInfo.b = this;
    this.i = new HotPicPageView.HotPicFooter(this, paramHotPicTagInfo);
    this.g.a(this.i);
    this.g.setAdapter(this.h);
    if (this.l == -20) {
      this.i.a(2);
    }
    this.g.f = paramHotPicMainPanel;
    this.q = new HotpicDownloadDispatcher(this);
    paramHotPicMainPanel = HotPicManager.a(this.a.f);
    if (paramHotPicMainPanel.b(this.l))
    {
      this.q.a(true);
      this.C = HotVideoBlurTaskManager.a(this.b);
      e();
    }
    if (paramHotPicMainPanel.b(this.l))
    {
      z = false;
      a(0, 3000L);
    }
    this.G = new HotPicPageView.2(this);
    paramHotPicMainPanel = new IntentFilter();
    paramHotPicMainPanel.addAction("android.intent.action.SCREEN_OFF");
    paramHotPicMainPanel.addAction("android.intent.action.SCREEN_ON");
    paramHotPicMainPanel.addAction("tencent.av.v2q.StartVideoChat");
    paramHotPicMainPanel.addAction("tencent.av.v2q.StopVideoChat");
    paramHotPicMainPanel.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.b.registerReceiver(this.G, paramHotPicMainPanel);
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder)
  {
    if (paramMyVideoViewHolder == null) {
      return;
    }
    HotPicPageView.MyVideoViewHolder localMyVideoViewHolder = this.B;
    if ((localMyVideoViewHolder != null) && (localMyVideoViewHolder != paramMyVideoViewHolder))
    {
      if (localMyVideoViewHolder.n >= 1) {
        this.B.a(0);
      }
      this.B = null;
    }
    this.B = paramMyVideoViewHolder;
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    this.J = true;
    TVK_SDKMgr.installPlugin(BaseApplicationImpl.getApplication(), new HotPicPageView.4(this, paramMyVideoViewHolder, paramInt));
  }
  
  public void a(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, HotVideoData paramHotVideoData)
  {
    RelativeLayout localRelativeLayout = paramMyVideoViewHolder.b;
    paramMyVideoViewHolder.c();
    Size localSize = a(x, paramHotVideoData.originalWidth, paramHotVideoData.originalHeight, y);
    if (localSize == null)
    {
      paramMyVideoViewHolder.a(0);
      return;
    }
    Object localObject = LayoutInflater.from(this.b);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(x, localSize.b());
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(14);
    paramMyVideoViewHolder.a(2);
    localObject = (HotVideoMongoliaRelativeLayout)((LayoutInflater)localObject).inflate(2131625143, null);
    ((HotVideoMongoliaRelativeLayout)localObject).setTag("HotVideoControlTag");
    ((HotVideoMongoliaRelativeLayout)localObject).setHotVideoData(paramHotVideoData);
    ((HotVideoMongoliaRelativeLayout)localObject).setVidoeControlListener(this);
    ((HotVideoMongoliaRelativeLayout)localObject).setControlStateListener(paramMyVideoViewHolder);
    localRelativeLayout.addView((View)localObject, 0, localLayoutParams);
    paramMyVideoViewHolder = paramHotVideoData.getVideoLengthString();
    ((HotVideoMongoliaRelativeLayout)localObject).l = new Size(x, localSize.b());
    paramMyVideoViewHolder = new HotVideoMongoliaRelativeLayout.VideoInfo(paramHotVideoData.name, paramMyVideoViewHolder, paramHotVideoData.originalUrl, paramHotVideoData.mVideoUUID, paramHotVideoData.iconUrl, paramHotVideoData.videoSource, paramHotVideoData.mCertificatedIcon, localSize.a(), localSize.b(), paramHotVideoData.oringinalSize);
    paramHotVideoData = new PresenceInterfaceImpl(this.b);
    paramHotVideoData.a(this);
    ((HotVideoMongoliaRelativeLayout)localObject).a(paramHotVideoData, paramMyVideoViewHolder);
    ReportController.b(this.c, "dc00898", "", "", "0X8007ED9", "0X8007ED9", 0, 0, "", "", "", "");
    ((HotVideoMongoliaRelativeLayout)localObject).c();
  }
  
  public void a(HotVideoData paramHotVideoData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay OnVideoPlayCompleted");
    }
    this.D = paramHotVideoData.picIndex;
    z = false;
    a(1, 1500L);
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if ((localObject instanceof PublicAccountHotPicPanel))
      {
        i1 = 3;
        break label59;
      }
      if ((localObject instanceof TribeHotPicPanel))
      {
        i1 = 4;
        break label59;
      }
      if (!(localObject instanceof HotPicMainPanel))
      {
        i1 = 5;
        break label59;
      }
    }
    int i1 = 1;
    label59:
    if (i1 == 1)
    {
      localObject = this.d;
      if ((localObject != null) && (((BaseSessionInfo)localObject).b != null))
      {
        localObject = this.d.b;
        i2 = this.d.a;
        if (i2 != 0)
        {
          if (i2 != 1)
          {
            if (i2 != 3000) {
              break label147;
            }
            i2 = 3;
            break label150;
          }
          i2 = 2;
          break label150;
        }
        i2 = 1;
        break label150;
      }
    }
    localObject = "";
    label147:
    int i2 = 0;
    label150:
    ReportController.b(this.c, "dc00898", "", (String)localObject, paramString1, paramString1, i1, i2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void b()
  {
    if (!this.H) {
      return;
    }
    this.h.a();
    this.h.notifyDataSetChanged();
    this.H = false;
  }
  
  void b(int paramInt)
  {
    this.s.add(Integer.valueOf(paramInt));
    this.r.add(Integer.valueOf(paramInt));
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    HotPicData localHotPicData = (HotPicData)this.h.a.get(paramInt);
    if (localHotPicData.getDataType() == 2) {
      return;
    }
    paramInt = b(localHotPicData);
    if (paramInt != 2)
    {
      if (paramInt == -1) {
        return;
      }
      this.a.a(localHotPicData);
      paramView.getParent().requestDisallowInterceptTouchEvent(true);
      ReportController.b(this.c, "dc00898", "", "", "0X8007B22", "0X8007B22", 0, 0, "", "", "", "");
    }
  }
  
  public void b(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    if (paramMyVideoViewHolder == null) {
      return;
    }
    int i2 = paramMyVideoViewHolder.n;
    int i1 = 1;
    if ((i2 != 0) && (paramMyVideoViewHolder.n != -11) && (paramMyVideoViewHolder.n != 1)) {
      return;
    }
    paramMyVideoViewHolder.a(1);
    if (this.J)
    {
      paramMyVideoViewHolder.a(0);
      new QQToastNotifier(this.b).notifyUser(HotVideoMongoliaRelativeLayout.c, 100, 0, 1);
      return;
    }
    HotVideoUtils.a();
    if (!HotVideoUtils.b())
    {
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {
        i1 = 0;
      }
      if (i1 != 0)
      {
        a(paramMyVideoViewHolder, paramInt);
        paramMyVideoViewHolder = this.b;
        QQToast.makeText(paramMyVideoViewHolder, paramMyVideoViewHolder.getResources().getString(2131895511), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299920));
        return;
      }
      localObject = this.b;
      DialogUtil.a((Context)localObject, 232, null, ((Context)localObject).getResources().getString(2131895508), new HotPicPageView.5(this, paramMyVideoViewHolder, paramInt), new HotPicPageView.6(this, paramMyVideoViewHolder)).show();
      return;
    }
    Object localObject = (HotPicData)this.h.a.get(paramInt);
    if (((HotPicData)localObject).getDataType() == 2)
    {
      localObject = (HotVideoData)localObject;
      ((HotVideoData)localObject).GetVideoURLAsync(this.c, 0, "0", new HotPicPageView.7(this, (HotVideoData)localObject, paramMyVideoViewHolder));
      return;
    }
    paramMyVideoViewHolder.a(0);
  }
  
  public void b(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("uin", this.d.b);
    ((Intent)localObject1).putExtra("uintype", this.d.a);
    ((Intent)localObject1).putExtra("troop_uin", this.d.c);
    ((Intent)localObject1).putExtra("key_confess_topicid", this.d.v);
    ((Intent)localObject1).putExtra("file_send_size", paramHotVideoData.oringinalSize);
    ((Intent)localObject1).putExtra("file_send_business_type", 6);
    ((Intent)localObject1).putExtra("file_shortvideo_md5", paramHotVideoData.originalMD5);
    ((Intent)localObject1).putExtra("file_uuid", paramHotVideoData.mVideoUUID);
    ((Intent)localObject1).putExtra("thumbfile_send_width", paramHotVideoData.width);
    ((Intent)localObject1).putExtra("thumbfile_send_height", paramHotVideoData.height);
    ((Intent)localObject1).putExtra("thumbfile_md5", paramHotVideoData.md5);
    ((Intent)localObject1).putExtra("file_thumb_Size", paramHotVideoData.fileSize);
    ((Intent)localObject1).putExtra("support_progressive", true);
    ((Intent)localObject1).putExtra("file_width", paramHotVideoData.originalWidth);
    ((Intent)localObject1).putExtra("file_height", paramHotVideoData.originalHeight);
    ((Intent)localObject1).putExtra("file_send_duration", (int)(paramHotVideoData.videoLength / 1000L));
    ((Intent)localObject1).putExtra("hot_video_icon", paramHotVideoData.iconUrl);
    ((Intent)localObject1).putExtra("hot_video_icon_sub", paramHotVideoData.mCertificatedIcon);
    ((Intent)localObject1).putExtra("hot_video_title", paramHotVideoData.videoSource);
    ((Intent)localObject1).putExtra("hot_video_url", paramHotVideoData.jumpUrl);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramHotVideoData.name);
    ((StringBuilder)localObject2).append(".mp4");
    ((Intent)localObject1).putExtra("hot_video_name", ((StringBuilder)localObject2).toString());
    ((Intent)localObject1).putExtra("special_video_type", 1);
    localObject2 = SVBusiUtil.a(0, 6);
    localObject1 = ShortVideoBusiManager.a(6, localObject1, (ShortVideoReq)localObject2);
    ((ShortVideoUploadInfo)localObject1).C = true;
    ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject1);
    ShortVideoBusiManager.a((ShortVideoReq)localObject2, this.e.app);
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.n.position);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramHotVideoData.picIndex);
    ((StringBuilder)localObject3).append("");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.n.tagName);
    ((StringBuilder)localObject4).append("");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramHotVideoData.originalMD5);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X8007EDE", "0X8007EDE", 0, 0, (String)localObject2, (String)localObject3, (String)localObject4, localStringBuilder.toString());
    ReportController.b(this.a.f, "dc00898", "", "", "0X8007EDA", "0X8007EDA", 0, 0, "", "", paramHotVideoData.mVideoUUID, paramHotVideoData.originalMD5);
    ReportController.b(this.a.f, "dc00898", "", "", "0X8007ED4", "0X8007ED4", 0, 0, "", "", "", "");
  }
  
  public void c(HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt)
  {
    z = true;
    if (paramMyVideoViewHolder == null) {
      return;
    }
    if (this.g != null)
    {
      HotPicRecyclerView.a("onVideoItemClick");
      boolean bool = this.g.a(paramInt);
      Object localObject = this.g;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onVideoItemClick CheckItemIsNeedToScroll End isNeedScroll is ");
      ((StringBuilder)localObject).append(bool);
      HotPicRecyclerView.a(((StringBuilder)localObject).toString());
      if (bool)
      {
        this.E = paramInt;
        z = false;
        this.g.a(-1, paramInt);
        return;
      }
    }
    b(paramMyVideoViewHolder, paramInt);
  }
  
  public void d()
  {
    Object localObject = this.B;
    if ((localObject != null) && (((HotPicPageView.MyVideoViewHolder)localObject).n == 3))
    {
      localObject = this.B.b();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).d();
      }
    }
  }
  
  void e()
  {
    z = true;
    this.g.setScrollStatusChengedListener(this);
    this.F = new HotPicPageView.3(this);
  }
  
  public void f()
  {
    Object localObject = this.B;
    if (localObject == null) {
      return;
    }
    localObject = ((HotPicPageView.MyVideoViewHolder)localObject).b();
    if (localObject == null) {
      return;
    }
    ((HotVideoMongoliaRelativeLayout)localObject).a();
  }
  
  public void g()
  {
    Object localObject = this.B;
    if (localObject != null)
    {
      localObject = ((HotPicPageView.MyVideoViewHolder)localObject).b();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).b();
      }
    }
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      return;
    }
    if (z) {
      return;
    }
    int i1 = this.E;
    localObject = this.g.findViewHolderForPosition(i1);
    if ((i1 >= 0) && (localObject != null) && ((localObject instanceof HotPicPageView.MyVideoViewHolder)))
    {
      localObject = (HotPicPageView.MyVideoViewHolder)localObject;
      if (((HotPicPageView.MyVideoViewHolder)localObject).n == 0)
      {
        b((HotPicPageView.MyVideoViewHolder)localObject, i1);
        return;
      }
      ((HotPicPageView.MyVideoViewHolder)localObject).m = true;
    }
  }
  
  void h()
  {
    this.F.removeMessages(1);
    this.F.removeMessages(0);
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay tryScrollAndPlayNextVideo");
    }
    if (z) {
      return;
    }
    int i1 = this.D;
    int i2 = i1 + 1;
    if (i2 >= this.h.getItemCount()) {
      return;
    }
    this.E = i2;
    this.g.a(i1, i2);
  }
  
  public boolean j()
  {
    Object localObject1 = this.b;
    boolean bool = false;
    if (localObject1 == null) {
      return false;
    }
    if (!HotVideoDPC.c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.isBlurSwitch is false");
      }
      return false;
    }
    int i1 = HotVideoDPC.d();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" HotVideoDPC.getBlurMemory is ");
      ((StringBuilder)localObject1).append(i1);
      QLog.i("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = (ActivityManager)this.b.getSystemService("activity");
    localObject1 = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject2).getMemoryInfo((ActivityManager.MemoryInfo)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" mi.availMem is ");
      ((StringBuilder)localObject2).append(((ActivityManager.MemoryInfo)localObject1).availMem / 1024L);
      QLog.i("HotPicManagerHotPicPageView", 2, ((StringBuilder)localObject2).toString());
    }
    if (((ActivityManager.MemoryInfo)localObject1).availMem > i1 * 1024 * 1024) {
      bool = true;
    }
    return bool;
  }
  
  public void k()
  {
    Object localObject = this.C;
    if (localObject != null) {
      HotVideoBlurTaskManager.b((HotVideoBlurTaskManager)localObject);
    }
    localObject = this.B;
    if (localObject != null)
    {
      if (((HotPicPageView.MyVideoViewHolder)localObject).n > 2)
      {
        localObject = ((HotPicPageView.MyVideoViewHolder)localObject).b();
        if (localObject != null) {
          ((HotVideoMongoliaRelativeLayout)localObject).d();
        }
        return;
      }
      if (((HotPicPageView.MyVideoViewHolder)localObject).n != -10) {
        ((HotPicPageView.MyVideoViewHolder)localObject).a(0);
      }
    }
  }
  
  public void l()
  {
    HotPicManager localHotPicManager = HotPicManager.a(this.c);
    int i2 = this.l;
    int i1 = 2;
    if (i2 == -20)
    {
      this.j.setVisibility(8);
      this.g.setVisibility(8);
      this.i.a(2);
      if (localHotPicManager.c().size() <= 0)
      {
        this.k.setVisibility(0);
        return;
      }
      this.k.setVisibility(8);
      this.h.a(localHotPicManager.c());
      this.g.setVisibility(0);
      this.g.scrollToPosition(0);
      this.h.notifyDataSetChanged();
      return;
    }
    if (localHotPicManager.c(i2))
    {
      this.h.a(localHotPicManager.a(this.l));
      if (!localHotPicManager.d(this.l)) {
        i1 = 1;
      }
      this.i.a(i1);
      this.j.setVisibility(8);
      this.g.setVisibility(0);
      this.g.scrollToPosition(0);
      this.h.notifyDataSetChanged();
      return;
    }
    this.j.setVisibility(0);
    this.g.setVisibility(8);
    localHotPicManager.e(this.l);
  }
  
  void m()
  {
    this.g.f = null;
    this.q.b();
    this.q = null;
    this.a = null;
    this.r.clear();
    this.s.clear();
    this.K = 0;
    BroadcastReceiver localBroadcastReceiver = this.G;
    if (localBroadcastReceiver != null) {
      this.b.unregisterReceiver(localBroadcastReceiver);
    }
  }
  
  public void n()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      o();
      return;
    }
    ThreadManager.getUIHandler().post(new HotPicPageView.8(this));
  }
  
  void o()
  {
    try
    {
      if ((!NetworkUtil.isWifiEnabled(this.b)) || (this.r.size() != this.s.size()) || (this.K + 1 > this.r.size())) {
        break label800;
      }
      i1 = 16;
      i6 = this.h.a.size();
      if ((this.a == null) || (!HotPicManager.a(this.a.f).b(this.l))) {
        break label816;
      }
      i1 = 8;
      i4 = 1;
    }
    finally
    {
      for (;;)
      {
        int i1;
        int i6;
        int i8;
        int i7;
        int i2;
        int i3;
        int i5;
        boolean bool;
        label782:
        for (;;)
        {
          label413:
          label800:
          throw localObject;
        }
        label816:
        int i4 = 2;
      }
    }
    i8 = (this.K / i1 + 1) * i1 - 1;
    i7 = i1 + i8;
    i2 = 0;
    i1 = 0;
    i3 = 0;
    if (this.r.size() <= i8)
    {
      if (this.s.size() <= i8)
      {
        i5 = this.s.size();
        for (i1 = i3;; i1 = i2)
        {
          i2 = i1;
          if (i5 > i8) {
            break;
          }
          i2 = i1;
          if (i5 >= i6) {
            break;
          }
          bool = this.s.contains(Integer.valueOf(i5));
          i2 = i1;
          if (!bool)
          {
            i3 = i1;
            try
            {
              URLDrawable localURLDrawable1 = a((HotPicData)this.h.a.get(i5));
              if (localURLDrawable1 == null) {
                return;
              }
              i3 = i1;
              i2 = localURLDrawable1.getStatus();
              if (i2 != 1)
              {
                i2 = i1 + 1;
                if (i1 < i4) {
                  try
                  {
                    this.q.a(i5, localURLDrawable1);
                    i1 = i2;
                  }
                  catch (Exception localException1)
                  {
                    i3 = i2;
                    break label413;
                  }
                }
              }
              else
              {
                i3 = i1;
                this.r.add(Integer.valueOf(i5));
              }
              i3 = i1;
              this.s.add(Integer.valueOf(i5));
              i3 = i1;
              i2 = i1;
              if (QLog.isColorLevel())
              {
                i3 = i1;
                StringBuilder localStringBuilder1 = new StringBuilder();
                i3 = i1;
                localStringBuilder1.append("preDownload  ");
                i3 = i1;
                localStringBuilder1.append(this.l);
                i3 = i1;
                localStringBuilder1.append(" ");
                i3 = i1;
                localStringBuilder1.append(i5);
                i3 = i1;
                QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder1.toString());
                i2 = i1;
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              i2 = i3;
              if (QLog.isColorLevel())
              {
                QLog.d("HotPicManagerHotPicPageView", 2, "preDownloadOnUi !mStartDownLoadIndex.contains(index) Exception ", localException2);
                i2 = i3;
              }
            }
          }
          i5 += 1;
        }
      }
      i1 = i2;
      if (i2 != 0) {
        return;
      }
    }
    if (this.r.size() > i8)
    {
      i2 = this.l;
      if ((this.h.a.size() < i7) && (!HotPicManager.a(this.c).d(i2))) {
        HotPicManager.a(this.c).e(i2);
      }
      if (this.s.size() <= i7)
      {
        i5 = this.s.size();
        while ((i5 <= i7) && (i5 < i6))
        {
          bool = this.s.contains(Integer.valueOf(i5));
          i3 = i1;
          if (!bool)
          {
            i2 = i1;
            try
            {
              URLDrawable localURLDrawable2 = a((HotPicData)this.h.a.get(i5));
              if (localURLDrawable2 == null) {
                return;
              }
              i2 = i1;
              i3 = localURLDrawable2.getStatus();
              if (i3 != 1)
              {
                i2 = i1 + 1;
                if (i1 < i4) {
                  try
                  {
                    this.q.a(i5, localURLDrawable2);
                    i1 = i2;
                  }
                  catch (Exception localException3)
                  {
                    break label782;
                  }
                }
              }
              else
              {
                i2 = i1;
                this.r.add(Integer.valueOf(i5));
              }
              i2 = i1;
              this.s.add(Integer.valueOf(i5));
              i2 = i1;
              i3 = i1;
              if (QLog.isColorLevel())
              {
                i2 = i1;
                StringBuilder localStringBuilder2 = new StringBuilder();
                i2 = i1;
                localStringBuilder2.append("preDownload  ");
                i2 = i1;
                localStringBuilder2.append(this.l);
                i2 = i1;
                localStringBuilder2.append(" ");
                i2 = i1;
                localStringBuilder2.append(i5);
                i2 = i1;
                QLog.d("HotPicManagerHotPicPageView", 2, localStringBuilder2.toString());
                i3 = i1;
              }
            }
            catch (Exception localException4)
            {
              localException4.printStackTrace();
              i3 = i2;
            }
          }
          i5 += 1;
          i1 = i3;
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    HotPicTagInfo localHotPicTagInfo = this.n;
    if ((localHotPicTagInfo != null) && (localHotPicTagInfo.tagType == 2)) {
      z = true;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((HotPicManager.a(this.c).b(this.l)) && (paramKeyEvent.getAction() == 0)) {
      z = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = this.a;
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    if (HotPicManager.a(this.c).b(this.l))
    {
      if (paramMotionEvent.getAction() == 0) {
        z = true;
      }
      return false;
    }
    localObject = this.a.j;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = localRelativeLayout.findViewWithTag("HotPicControlTag");
      if (paramMotionEvent != null)
      {
        int i1 = ((ViewGroup.MarginLayoutParams)paramMotionEvent.getLayoutParams()).topMargin;
        paramView = new RelativeLayout.LayoutParams(paramView.getWidth(), paramView.getHeight());
        paramMotionEvent = new ImageView(localRelativeLayout.getContext());
        paramMotionEvent.setTag("HotPicPopControlTag");
        paramView.topMargin = i1;
        if (Build.VERSION.SDK_INT >= 16) {
          paramMotionEvent.setBackgroundColor(Color.parseColor("#7f000000"));
        } else {
          paramMotionEvent.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
        }
        localRelativeLayout.addView(paramMotionEvent, paramView);
      }
    }
    else if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      paramView = localRelativeLayout.findViewWithTag("HotPicPopControlTag");
      if (paramView != null) {
        localRelativeLayout.removeView(paramView);
      }
      if (((View)localObject).getVisibility() == 0) {
        this.a.h();
      }
    }
    if (((View)localObject).getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  void q()
  {
    Object localObject1 = this.C;
    if (localObject1 == null) {
      this.C = HotVideoBlurTaskManager.a(this.b);
    } else {
      HotVideoBlurTaskManager.a((HotVideoBlurTaskManager)localObject1);
    }
    int i1 = 0;
    while (i1 < this.L.size())
    {
      if (this.a != null)
      {
        int i2 = this.L.keyAt(i1);
        localObject1 = (String)this.L.valueAt(i1);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.n.position);
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append(i2);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(this.n.position);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(i2);
        ((StringBuilder)localObject4).append("");
        localObject4 = ((StringBuilder)localObject4).toString();
        Object localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(this.n.tagName);
        ((StringBuilder)localObject5).append("");
        localObject5 = ((StringBuilder)localObject5).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("");
        a("0X8007EDD", (String)localObject3, (String)localObject4, (String)localObject5, localStringBuilder.toString());
        this.a.u.add(localObject2);
      }
      i1 += 1;
    }
    this.L.clear();
  }
  
  public void setCommonMuteStatus(boolean paramBoolean)
  {
    o = paramBoolean;
    Object localObject = this.B;
    if ((localObject != null) && (((HotPicPageView.MyVideoViewHolder)localObject).n >= 2))
    {
      localObject = ((HotPicPageView.MyVideoViewHolder)localObject).b();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).a(o);
      }
    }
  }
  
  public void setOnHotPicItemClickListener(HotPicPageView.OnHotPicItemClickListener paramOnHotPicItemClickListener)
  {
    this.I = paramOnHotPicItemClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView
 * JD-Core Version:    0.7.0.1
 */