package com.tencent.tkd.topicsdk.coverselect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig.Companion;
import com.tencent.tkd.topicsdk.covergallery.CoverGalleryView;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import com.tencent.tkd.topicsdk.framework.ViewPagerProxy;
import com.tencent.tkd.topicsdk.framework.eventdispatch.DispatchManager;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventElement;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventKey;
import com.tencent.tkd.topicsdk.framework.eventdispatch.report.ReportEventPage;
import com.tencent.tkd.topicsdk.framework.events.UserActionEvent;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.ImageUpdateListener;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.OutputPicListener;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView;
import com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView.CaptureVideoInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "()V", "adapter", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "captureEndTime", "", "captureIndicatorView", "Landroid/view/View;", "captureLayout", "Landroid/view/ViewGroup;", "captureStartTime", "captureTextView", "Landroid/widget/TextView;", "closeView", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "confirmView", "coverGalleryView", "Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;", "coverPath", "", "coverRatio", "", "fromPageId", "fromTabId", "fromTabId$annotations", "galleryIndicatorView", "galleryLayout", "galleryTextView", "initialProgress", "mAdapter", "rootView", "Landroid/widget/LinearLayout;", "selectMode", "selectMode$annotations", "videoCaptureView", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView;", "videoHeight", "videoPath", "videoWidth", "viewPagerProxy", "Lcom/tencent/tkd/topicsdk/framework/ViewPagerProxy;", "changeTab", "", "tabId", "getImmersiveStatusBarStatus", "Lkotlin/Pair;", "initCaptureChangeListener", "initConfirmView", "view", "initData", "initTabLayout", "initView", "initViewPager", "onConfirmItemClick", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "refreshTabLayout", "reportClickConfirmCover", "reportTabSelected", "setCoverDataResult", "path", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage
  extends BaseSDKPage
{
  public static final CoverSelectPage.Companion a = new CoverSelectPage.Companion(null);
  private PagerAdapterProxy A = (PagerAdapterProxy)new CoverSelectPage.mAdapter.1(this);
  private View c;
  private ViewGroup d;
  private TextView e;
  private View f;
  private ViewGroup g;
  private TextView h;
  private View i;
  private View j;
  private ViewPagerProxy k;
  private VideoCaptureView l;
  private CoverGalleryView m;
  private int n;
  private int o;
  private String p = "";
  private int q;
  private int r = 2147483647;
  private float s;
  private String t = "";
  private int u;
  private int v;
  private float w;
  private LinearLayout x;
  private int y;
  private GlobalPublisherConfig z;
  
  private final void a(int paramInt)
  {
    int i1 = this.o;
    if (i1 == 1) {
      paramInt = 0;
    } else if (i1 == 2) {
      paramInt = 1;
    }
    ViewPagerProxy localViewPagerProxy;
    if (paramInt == 0)
    {
      localViewPagerProxy = this.k;
      if (localViewPagerProxy == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
      }
      localViewPagerProxy.a(0, false);
    }
    else
    {
      localViewPagerProxy = this.k;
      if (localViewPagerProxy == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
      }
      localViewPagerProxy.a(1, false);
    }
    b(paramInt);
    c(paramInt);
  }
  
  private final void a(View paramView)
  {
    Object localObject1 = b();
    if (localObject1 != null) {
      localObject1 = (Context)localObject1;
    } else {
      localObject1 = AppContext.a.a();
    }
    Object localObject2 = paramView.findViewById(R.id.D);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.iv_close)");
    this.c = ((View)localObject2);
    localObject2 = this.c;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeView");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.1(this));
    localObject2 = paramView.findViewById(R.id.K);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.ll_from_capture)");
    this.d = ((ViewGroup)localObject2);
    localObject2 = this.d;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
    }
    ((ViewGroup)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.2(this));
    localObject2 = paramView.findViewById(R.id.aB);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.tv_from_capture)");
    this.e = ((TextView)localObject2);
    localObject2 = paramView.findViewById(R.id.aU);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.v…w_from_capture_indicator)");
    this.f = ((View)localObject2);
    localObject2 = paramView.findViewById(R.id.L);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.ll_from_gallery)");
    this.g = ((ViewGroup)localObject2);
    localObject2 = this.g;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
    }
    ((ViewGroup)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.3(this));
    localObject2 = paramView.findViewById(R.id.aC);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.tv_from_gallery)");
    this.h = ((TextView)localObject2);
    localObject2 = paramView.findViewById(R.id.aV);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.v…w_from_gallery_indicator)");
    this.i = ((View)localObject2);
    localObject2 = new VideoCaptureView.CaptureVideoInfo(this.p);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).a(this.q);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).b(this.r);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).c(this.u);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).d(this.v);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).a(this.w);
    this.l = new VideoCaptureView((Context)localObject1, (VideoCaptureView.CaptureVideoInfo)localObject2, this.s, null, 8, null);
    this.m = new CoverGalleryView((Context)localObject1, this.u, this.v, this.t, this.w, null, 32, null);
    p();
    b(paramView);
    c(paramView);
    q();
  }
  
  private final void a(OutputPicListener paramOutputPicListener)
  {
    Object localObject = this.k;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    if (((ViewPagerProxy)localObject).b() == 0)
    {
      this.y = 0;
      localObject = this.l;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
      }
      ((VideoCaptureView)localObject).a(paramOutputPicListener);
    }
    else
    {
      this.y = 1;
      localObject = this.m;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverGalleryView");
      }
      ((CoverGalleryView)localObject).a(paramOutputPicListener);
    }
    r();
  }
  
  private final void a(String paramString)
  {
    int i1;
    if (((CharSequence)paramString).length() > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      Intent localIntent = new Intent();
      if (this.n == 0)
      {
        VideoCaptureView localVideoCaptureView = this.l;
        if (localVideoCaptureView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
        }
        float f1 = localVideoCaptureView.getProgress();
        localVideoCaptureView = this.l;
        if (localVideoCaptureView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
        }
        i1 = localVideoCaptureView.getSeekVideoPosition();
        localIntent.putExtra("initial_progress", f1);
        localIntent.putExtra("seek_video_position", i1);
      }
      localIntent.putExtra("result_path", paramString);
      localIntent.putExtra("from_page", this.y);
      paramString = b();
      if (paramString != null) {
        paramString.setResult(-1, localIntent);
      }
    }
    else
    {
      paramString = b();
      if (paramString != null) {
        paramString.setResult(0, null);
      }
    }
  }
  
  private final void b(int paramInt)
  {
    if (this.o != 0) {
      return;
    }
    int i2 = 0;
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    Object localObject2 = this.e;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureTextView");
    }
    if (paramInt != 0) {
      localObject1 = Typeface.defaultFromStyle(1);
    } else {
      localObject1 = Typeface.defaultFromStyle(0);
    }
    ((TextView)localObject2).setTypeface((Typeface)localObject1);
    TextView localTextView = this.e;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureTextView");
    }
    localObject2 = "#FFFFFF";
    if (paramInt != 0) {
      localObject1 = "#FFFFFF";
    } else {
      localObject1 = "#B3B3B3";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject1));
    localTextView = this.h;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryTextView");
    }
    if (paramInt != 0) {
      localObject1 = Typeface.defaultFromStyle(0);
    } else {
      localObject1 = Typeface.defaultFromStyle(1);
    }
    localTextView.setTypeface((Typeface)localObject1);
    localTextView = this.h;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryTextView");
    }
    Object localObject1 = localObject2;
    if (paramInt != 0) {
      localObject1 = "#B3B3B3";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject1));
    localObject1 = this.f;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureIndicatorView");
    }
    if (paramInt != 0) {
      i1 = 0;
    } else {
      i1 = 4;
    }
    ((View)localObject1).setVisibility(i1);
    localObject1 = this.i;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryIndicatorView");
    }
    int i1 = i2;
    if (paramInt != 0) {
      i1 = 4;
    }
    ((View)localObject1).setVisibility(i1);
  }
  
  private final void b(View paramView)
  {
    paramView = paramView.findViewById(R.id.av);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_confirm)");
    this.j = paramView;
    paramView = this.j;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("confirmView");
    }
    paramView.setOnClickListener((View.OnClickListener)new CoverSelectPage.initConfirmView.1(this));
  }
  
  private final void c(int paramInt)
  {
    ReportEventElement localReportEventElement;
    if (paramInt == 0) {
      localReportEventElement = ReportEventElement.BUTTON_SELECT_COVER_CAPTURE_TAB;
    } else {
      localReportEventElement = ReportEventElement.BUTTON_SELECT_COVER_GALLERY_TAB;
    }
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_SELECT_VIDEO_COVER, localReportEventElement, this.z, null, null, 97, null));
  }
  
  private final void c(View paramView)
  {
    paramView = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.context");
    this.k = new ViewPagerProxy(paramView, TopicSDK.a.a().b().p());
    paramView = this.x;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    ViewPagerProxy localViewPagerProxy = this.k;
    if (localViewPagerProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    paramView.addView(localViewPagerProxy.a(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    paramView = this.k;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    paramView.a(false);
    paramView = this.k;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    paramView.a(n());
    a(this.n);
  }
  
  private final PagerAdapterProxy n()
  {
    return this.A;
  }
  
  private final void o()
  {
    Bundle localBundle = a();
    if ((localBundle != null) && (localBundle != null))
    {
      this.n = localBundle.getInt("from_page");
      this.o = localBundle.getInt("select_mode");
      String str = localBundle.getString("cover_path");
      if (str == null) {
        str = "";
      }
      this.t = str;
      this.u = localBundle.getInt("video_width");
      this.v = localBundle.getInt("video_height");
      this.w = localBundle.getFloat("cover_ratio", this.u / this.v);
      str = localBundle.getString("video_path");
      if (str == null) {
        str = "";
      }
      this.p = str;
      this.s = localBundle.getFloat("initial_progress");
      this.q = localBundle.getInt("capture_start_progress");
      this.r = localBundle.getInt("capture_end_progress");
      this.z = GlobalPublisherConfig.Companion.a(localBundle);
    }
  }
  
  private final void p()
  {
    int i1 = this.o;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        localViewGroup = this.d;
        if (localViewGroup == null) {
          Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
        }
        localViewGroup.setVisibility(8);
        localViewGroup = this.g;
        if (localViewGroup == null) {
          Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
        }
        localViewGroup.setVisibility(0);
        return;
      }
      localViewGroup = this.d;
      if (localViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
      }
      localViewGroup.setVisibility(0);
      localViewGroup = this.g;
      if (localViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
      }
      localViewGroup.setVisibility(8);
      return;
    }
    ViewGroup localViewGroup = this.d;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
    }
    localViewGroup.setVisibility(0);
    localViewGroup = this.g;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
    }
    localViewGroup.setVisibility(0);
  }
  
  private final void q()
  {
    VideoCaptureView localVideoCaptureView = this.l;
    if (localVideoCaptureView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
    }
    localVideoCaptureView.setImageUpdateListener((ImageUpdateListener)new CoverSelectPage.initCaptureChangeListener.1(this));
  }
  
  private final void r()
  {
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_SELECT_VIDEO_COVER, ReportEventElement.BUTTON_CONFIRM, this.z, null, null, 97, null));
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.e, paramViewGroup, false);
    if (paramLayoutInflater != null)
    {
      this.x = ((LinearLayout)paramLayoutInflater);
      o();
      paramLayoutInflater = this.x;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      a((View)paramLayoutInflater);
      paramLayoutInflater = this.x;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      return (View)paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
  }
  
  @NotNull
  public Pair<Integer, Integer> c()
  {
    Activity localActivity = b();
    if (localActivity == null) {
      Intrinsics.throwNpe();
    }
    return new Pair(Integer.valueOf(ContextCompat.getColor((Context)localActivity, R.color.b)), Integer.valueOf(0));
  }
  
  public void f()
  {
    super.f();
    ViewPagerProxy localViewPagerProxy = this.k;
    if (localViewPagerProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    localViewPagerProxy.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage
 * JD-Core Version:    0.7.0.1
 */