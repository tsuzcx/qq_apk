package com.tencent.tkd.topicsdk.coverselect;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.covergallery.CoverGalleryView;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.BaseSDKPage;
import com.tencent.tkd.topicsdk.framework.PagerAdapterProxy;
import com.tencent.tkd.topicsdk.framework.ViewPagerProxy;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectPage;", "Lcom/tencent/tkd/topicsdk/framework/BaseSDKPage;", "()V", "adapter", "Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "getAdapter", "()Lcom/tencent/tkd/topicsdk/framework/PagerAdapterProxy;", "captureIndicatorView", "Landroid/view/View;", "captureLayout", "Landroid/view/ViewGroup;", "captureTextView", "Landroid/widget/TextView;", "closeView", "confirmView", "coverGalleryView", "Lcom/tencent/tkd/topicsdk/covergallery/CoverGalleryView;", "coverPath", "", "fromPageId", "", "fromTabId", "galleryIndicatorView", "galleryLayout", "galleryTextView", "initialProgress", "", "mAdapter", "rootView", "Landroid/widget/LinearLayout;", "videoCaptureView", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView;", "videoHeight", "videoPath", "videoWidth", "viewPagerProxy", "Lcom/tencent/tkd/topicsdk/framework/ViewPagerProxy;", "changeTab", "", "tabId", "getImmersiveStatusBarStatus", "Lkotlin/Pair;", "initCaptureChangeListener", "initConfirmView", "view", "initData", "initView", "initViewPager", "onCloseItemClick", "onConfirmItemClick", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "refreshTabLayout", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
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
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  
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
    ViewPagerProxy localViewPagerProxy;
    if (paramInt == 0)
    {
      localViewPagerProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
      if (localViewPagerProxy == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
      }
      localViewPagerProxy.a(0, false);
    }
    for (;;)
    {
      b(paramInt);
      return;
      localViewPagerProxy = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
      if (localViewPagerProxy == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
      }
      localViewPagerProxy.a(1, false);
    }
  }
  
  private final void a(View paramView)
  {
    Object localObject1 = a();
    if (localObject1 != null) {}
    for (localObject1 = (Context)localObject1;; localObject1 = AppContext.a.a())
    {
      Object localObject2 = paramView.findViewById(R.id.an);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.iv_close)");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
      localObject2 = this.jdField_a_of_type_AndroidViewView;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
      }
      ((View)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.1(this));
      localObject2 = paramView.findViewById(R.id.az);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.ll_from_capture)");
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
      localObject2 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureLayout");
      }
      ((ViewGroup)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.2(this));
      localObject2 = paramView.findViewById(R.id.bE);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.tv_from_capture)");
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localObject2 = paramView.findViewById(R.id.cc);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.v…w_from_capture_indicator)");
      this.jdField_b_of_type_AndroidViewView = ((View)localObject2);
      localObject2 = paramView.findViewById(R.id.aA);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.ll_from_gallery)");
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localObject2);
      localObject2 = this.jdField_b_of_type_AndroidViewViewGroup;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryLayout");
      }
      ((ViewGroup)localObject2).setOnClickListener((View.OnClickListener)new CoverSelectPage.initView.3(this));
      localObject2 = paramView.findViewById(R.id.bF);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.tv_from_gallery)");
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localObject2 = paramView.findViewById(R.id.cd);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view.findViewById(R.id.v…w_from_gallery_indicator)");
      this.jdField_c_of_type_AndroidViewView = ((View)localObject2);
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView = new VideoCaptureView((Context)localObject1, new VideoCaptureView.CaptureVideoInfo(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Float, null, 8, null);
      this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView = new CoverGalleryView((Context)localObject1, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, null, 16, null);
      b(paramView);
      c(paramView);
      g();
      return;
    }
  }
  
  private final void a(OutputPicListener paramOutputPicListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkViewPagerProxy;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewPagerProxy");
    }
    if (((ViewPagerProxy)localObject).a() == 0)
    {
      this.jdField_d_of_type_Int = 0;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
      }
      ((VideoCaptureView)localObject).a(paramOutputPicListener);
      return;
    }
    this.jdField_d_of_type_Int = 1;
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkCovergalleryCoverGalleryView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("coverGalleryView");
    }
    ((CoverGalleryView)localObject).a(paramOutputPicListener);
  }
  
  private final void b(int paramInt)
  {
    int j = 4;
    Object localObject;
    label35:
    label68:
    label105:
    int i;
    if (paramInt == 0)
    {
      paramInt = 1;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureTextView");
      }
      if (paramInt == 0) {
        break label212;
      }
      localObject = Typeface.defaultFromStyle(1);
      localTextView.setTypeface((Typeface)localObject);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureTextView");
      }
      if (paramInt == 0) {
        break label221;
      }
      localObject = "#FFFFFF";
      localTextView.setTextColor(Color.parseColor((String)localObject));
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryTextView");
      }
      if (paramInt == 0) {
        break label229;
      }
      localObject = Typeface.defaultFromStyle(0);
      localTextView.setTypeface((Typeface)localObject);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (localTextView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryTextView");
      }
      if (paramInt == 0) {
        break label238;
      }
      localObject = "#B3B3B3";
      label138:
      localTextView.setTextColor(Color.parseColor((String)localObject));
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureIndicatorView");
      }
      if (paramInt == 0) {
        break label246;
      }
      i = 0;
      label171:
      ((View)localObject).setVisibility(i);
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("galleryIndicatorView");
      }
      if (paramInt == 0) {
        break label251;
      }
    }
    label212:
    label221:
    label229:
    label238:
    label246:
    label251:
    for (paramInt = j;; paramInt = 0)
    {
      ((View)localObject).setVisibility(paramInt);
      return;
      paramInt = 0;
      break;
      localObject = Typeface.defaultFromStyle(0);
      break label35;
      localObject = "#B3B3B3";
      break label68;
      localObject = Typeface.defaultFromStyle(1);
      break label105;
      localObject = "#FFFFFF";
      break label138;
      i = 4;
      break label171;
    }
  }
  
  private final void b(View paramView)
  {
    paramView = paramView.findViewById(R.id.bz);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view.findViewById(R.id.tv_confirm)");
    this.jdField_d_of_type_AndroidViewView = paramView;
    paramView = this.jdField_d_of_type_AndroidViewView;
    if (paramView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("confirmView");
    }
    paramView.setOnClickListener((View.OnClickListener)new CoverSelectPage.initConfirmView.1(this));
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
    int j = 0;
    Object localObject = a();
    label53:
    float f;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("from_page");
      this.jdField_a_of_type_Int = i;
      localObject = a();
      if (localObject == null) {
        break label174;
      }
      localObject = ((Bundle)localObject).getString("video_path");
      if (localObject == null) {
        break label174;
      }
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      localObject = a();
      if (localObject == null) {
        break label181;
      }
      f = ((Bundle)localObject).getFloat("initial_progress");
      label79:
      this.jdField_a_of_type_Float = f;
      localObject = a();
      if (localObject == null) {
        break label186;
      }
      localObject = ((Bundle)localObject).getString("cover_path");
      if (localObject == null) {
        break label186;
      }
      label110:
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = a();
      if (localObject == null) {
        break label193;
      }
    }
    label174:
    label181:
    label186:
    label193:
    for (int i = ((Bundle)localObject).getInt("video_width");; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      localObject = a();
      i = j;
      if (localObject != null) {
        i = ((Bundle)localObject).getInt("video_height");
      }
      this.jdField_c_of_type_Int = i;
      return;
      i = 0;
      break;
      localObject = "";
      break label53;
      f = 0.0F;
      break label79;
      localObject = "";
      break label110;
    }
  }
  
  private final void g()
  {
    VideoCaptureView localVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView;
    if (localVideoCaptureView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoCaptureView");
    }
    localVideoCaptureView.setImageUpdateListener((ImageUpdateListener)new CoverSelectPage.initCaptureChangeListener.1(this));
  }
  
  private final void h()
  {
    Activity localActivity = a();
    if (localActivity != null) {
      localActivity.finish();
    }
  }
  
  @Nullable
  public View a(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.i, paramViewGroup, false);
    if (paramLayoutInflater == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
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
  
  @NotNull
  public Pair<Integer, Integer> a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getResources();
      if (localObject == null) {}
    }
    for (localObject = Integer.valueOf(((Resources)localObject).getColor(R.color.jdField_b_of_type_Int));; localObject = null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return new Pair(localObject, Integer.valueOf(0));
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.coverselect.CoverSelectPage
 * JD-Core Version:    0.7.0.1
 */