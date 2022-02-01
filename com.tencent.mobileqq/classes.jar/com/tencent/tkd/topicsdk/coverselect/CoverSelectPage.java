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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "()V", "adapter", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "captureEndTime", "", "captureIndicatorView", "Landroid/view/View;", "captureLayout", "Landroid/view/ViewGroup;", "captureStartTime", "captureTextView", "Landroid/widget/TextView;", "closeView", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "confirmView", "coverGalleryView", "Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;", "coverPath", "", "fromPageId", "fromTabId", "fromTabId$annotations", "galleryIndicatorView", "galleryLayout", "galleryTextView", "initialProgress", "", "mAdapter", "rootView", "Landroid/widget/LinearLayout;", "selectMode", "selectMode$annotations", "videoCaptureView", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView;", "videoHeight", "videoPath", "videoWidth", "viewPagerProxy", "Lcom/tencent/tkd/topicsdk/framework/ViewPagerProxy;", "changeTab", "", "tabId", "getImmersiveStatusBarStatus", "Lkotlin/Pair;", "initCaptureChangeListener", "initConfirmView", "view", "initData", "initTabLayout", "initView", "initViewPager", "onConfirmItemClick", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "refreshTabLayout", "reportClickConfirmCover", "reportTabSelected", "setCoverDataResult", "path", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CoverSelectPage
  extends BaseSDKPage
{
  public static final CoverSelectPage.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  private CoverGalleryView jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView;
  private PagerAdapterProxy jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy = (PagerAdapterProxy)new CoverSelectPage.mAdapter.1(this);
  private ViewPagerProxy jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
  private VideoCaptureView jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int = 2147483647;
  private View jdField_d_of_type_AndroidViewView;
  private int e;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkCoverselectCoverSelectPage$Companion = new CoverSelectPage.Companion(null);
  }
  
  private final PagerAdapterProxy a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkPagerAdapterProxy;
  }
  
  private final void a(int paramInt)
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 1) {
      paramInt = 0;
    } else if (i == 2) {
      paramInt = 1;
    }
    ViewPagerProxy localViewPagerProxy;
    if (paramInt == 0)
    {
      localViewPagerProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
      if (localViewPagerProxy == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
      }
      localViewPagerProxy.a(0, false);
    }
    else
    {
      localViewPagerProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
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
    Object localObject1 = a();
    if (localObject1 != null) {
      localObject1 = (Context)localObject1;
    } else {
      localObject1 = AppContext.a.a();
    }
    Object localObject2 = paramView.findViewById(R.id.Y);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.iv_close)");
    this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
    localObject2 = this.jdField_a_of_type_AndroidViewView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("closeView");
    }
    ((View)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.1(this));
    localObject2 = paramView.findViewById(R.id.ag);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.ll_from_capture)");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
    localObject2 = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
    }
    ((ViewGroup)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.2(this));
    localObject2 = paramView.findViewById(R.id.ba);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.tv_from_capture)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = paramView.findViewById(R.id.bw);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.v…w_from_capture_indicator)");
    this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
    localObject2 = paramView.findViewById(R.id.ah);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.ll_from_gallery)");
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
    localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
    }
    ((ViewGroup)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.3(this));
    localObject2 = paramView.findViewById(R.id.bb);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.tv_from_gallery)");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = paramView.findViewById(R.id.bx);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.v…w_from_gallery_indicator)");
    this.jdField_c_of_type_AndroidViewView = ((View)localObject2);
    localObject2 = new VideoCaptureView.CaptureVideoInfo(this.jdField_a_of_type_JavaLangString);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).a(this.jdField_c_of_type_Int);
    ((VideoCaptureView.CaptureVideoInfo)localObject2).b(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView = new VideoCaptureView((Context)localObject1, (VideoCaptureView.CaptureVideoInfo)localObject2, this.jdField_a_of_type_Float, null, 8, null);
    this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView = new CoverGalleryView((Context)localObject1, this.e, this.f, this.jdField_b_of_type_JavaLangString, null, 16, null);
    g();
    b(paramView);
    c(paramView);
    h();
  }
  
  private final void a(OutputPicListener paramOutputPicListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    if (((ViewPagerProxy)localObject).a() == 0)
    {
      this.g = 0;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
      }
      ((VideoCaptureView)localObject).a(paramOutputPicListener);
    }
    else
    {
      this.g = 1;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverGalleryView");
      }
      ((CoverGalleryView)localObject).a(paramOutputPicListener);
    }
    i();
  }
  
  private final void a(String paramString)
  {
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Intent localIntent = new Intent();
      if (this.jdField_a_of_type_Int == 0)
      {
        VideoCaptureView localVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
        if (localVideoCaptureView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
        }
        float f1 = localVideoCaptureView.a();
        localVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
        if (localVideoCaptureView == null) {
          Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
        }
        i = localVideoCaptureView.d();
        localIntent.putExtra("initial_progress", f1);
        localIntent.putExtra("seek_video_position", i);
      }
      localIntent.putExtra("result_path", paramString);
      localIntent.putExtra("from_page", this.g);
      paramString = a();
      if (paramString != null) {
        paramString.setResult(-1, localIntent);
      }
    }
    else
    {
      paramString = a();
      if (paramString != null) {
        paramString.setResult(0, null);
      }
    }
  }
  
  private final void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int != 0) {
      return;
    }
    int j = 0;
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureTextView");
    }
    if (paramInt != 0) {
      localObject1 = Typeface.defaultFromStyle(1);
    } else {
      localObject1 = Typeface.defaultFromStyle(0);
    }
    ((TextView)localObject2).setTypeface((Typeface)localObject1);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryTextView");
    }
    if (paramInt != 0) {
      localObject1 = Typeface.defaultFromStyle(0);
    } else {
      localObject1 = Typeface.defaultFromStyle(1);
    }
    localTextView.setTypeface((Typeface)localObject1);
    localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryTextView");
    }
    Object localObject1 = localObject2;
    if (paramInt != 0) {
      localObject1 = "#B3B3B3";
    }
    localTextView.setTextColor(Color.parseColor((String)localObject1));
    localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureIndicatorView");
    }
    if (paramInt != 0) {
      i = 0;
    } else {
      i = 4;
    }
    ((View)localObject1).setVisibility(i);
    localObject1 = this.jdField_c_of_type_AndroidViewView;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryIndicatorView");
    }
    int i = j;
    if (paramInt != 0) {
      i = 4;
    }
    ((View)localObject1).setVisibility(i);
  }
  
  private final void b(View paramView)
  {
    paramView = paramView.findViewById(R.id.aU);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_confirm)");
    this.jdField_d_of_type_AndroidViewView = paramView;
    paramView = this.jdField_d_of_type_AndroidViewView;
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
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_SELECT_VIDEO_COVER, localReportEventElement, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, null, null, 97, null));
  }
  
  private final void c(View paramView)
  {
    paramView = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.context");
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy = new ViewPagerProxy(paramView, TopicSDK.a.a().a().a());
    paramView = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    ViewPagerProxy localViewPagerProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
    if (localViewPagerProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    paramView.addView(localViewPagerProxy.a(), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    paramView.a(false);
    paramView = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    paramView.a(a());
    a(this.jdField_a_of_type_Int);
  }
  
  private final void f()
  {
    Bundle localBundle = a();
    if ((localBundle != null) && (localBundle != null))
    {
      this.jdField_a_of_type_Int = localBundle.getInt("from_page");
      this.jdField_b_of_type_Int = localBundle.getInt("select_mode");
      String str = localBundle.getString("cover_path");
      if (str == null) {
        str = "";
      }
      this.jdField_b_of_type_JavaLangString = str;
      this.e = localBundle.getInt("video_width");
      this.f = localBundle.getInt("video_height");
      str = localBundle.getString("video_path");
      if (str == null) {
        str = "";
      }
      this.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Float = localBundle.getFloat("initial_progress");
      this.jdField_c_of_type_Int = localBundle.getInt("capture_start_progress");
      this.jdField_d_of_type_Int = localBundle.getInt("capture_end_progress");
      this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = GlobalPublisherConfig.Companion.a(localBundle);
    }
  }
  
  private final void g()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        if (localViewGroup == null) {
          Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
        }
        localViewGroup.setVisibility(8);
        localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
        if (localViewGroup == null) {
          Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
        }
        localViewGroup.setVisibility(0);
        return;
      }
      localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
      }
      localViewGroup.setVisibility(0);
      localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
      if (localViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
      }
      localViewGroup.setVisibility(8);
      return;
    }
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
    }
    localViewGroup.setVisibility(0);
    localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
    }
    localViewGroup.setVisibility(0);
  }
  
  private final void h()
  {
    VideoCaptureView localVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
    if (localVideoCaptureView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
    }
    localVideoCaptureView.setImageUpdateListener((ImageUpdateListener)new CoverSelectPage.initCaptureChangeListener.1(this));
  }
  
  private final void i()
  {
    DispatchManager.a.a((IEvent)new UserActionEvent(null, ReportEventKey.EVENT_CLICK, ReportEventPage.PAGE_SELECT_VIDEO_COVER, ReportEventElement.BUTTON_CONFIRM, this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig, null, null, 97, null));
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.i, paramViewGroup, false);
    if (paramLayoutInflater != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater);
      f();
      paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      a((View)paramLayoutInflater);
      paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
      }
      return (View)paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
  }
  
  @NotNull
  public Pair<Integer, Integer> a()
  {
    Activity localActivity = a();
    if (localActivity == null) {
      Intrinsics.throwNpe();
    }
    return new Pair(Integer.valueOf(ContextCompat.getColor((Context)localActivity, R.color.jdField_b_of_type_Int)), Integer.valueOf(0));
  }
  
  public void a()
  {
    super.a();
    ViewPagerProxy localViewPagerProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
    if (localViewPagerProxy == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    localViewPagerProxy.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage
 * JD-Core Version:    0.7.0.1
 */