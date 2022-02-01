package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.widget.HorizontalListView;
import com.tencent.tkd.topicsdk.widget.dialog.CommonProgressDialog;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.OnCaptureOperateCallback;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.OnIndicatorPressCallback;
import com.tencent.tkd.topicsdk.widget.videocapture.VideoMeasureScaleView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCaptureView;", "context", "Landroid/content/Context;", "videoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "initialProgress", "", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;FLandroid/util/AttributeSet;)V", "adapter", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewImageAdapter;", "candidateView", "Landroid/view/ViewGroup;", "captureOperateLayout", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout;", "captureToastTextView", "Landroid/widget/TextView;", "coverProcessDialog", "Lcom/tencent/tkd/topicsdk/widget/dialog/CommonProgressDialog;", "imageUpdateListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ImageUpdateListener;", "indicator", "Landroid/widget/ImageView;", "listView", "Lcom/tencent/tkd/topicsdk/widget/HorizontalListView;", "presenter", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter;", "progressTextView", "getVideoInfo", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "videoMeasureScaleView", "Lcom/tencent/tkd/topicsdk/widget/videocapture/VideoMeasureScaleView;", "confirmClick", "", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "getCandidateView", "getPreviewImageCount", "", "getPreviewImageHeight", "getPreviewImageWidth", "getProgress", "getSeekVideoPosition", "initCaptureOperateView", "initCoverProcessDialog", "initData", "initIndicatorView", "initListView", "initView", "onAttachedToWindow", "onCandidateVideoPrepared", "duration", "", "onDetachedFromWindow", "onIndicatorChange", "percent", "isDoingLongPress", "", "onPreviewImageListInitialized", "dataList", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "onPreviewImageListRefresh", "onPreviewImageLoaded", "dataPosition", "captureTask", "onPreviewImageUpdate", "bitmap", "Landroid/graphics/Bitmap;", "path", "", "onPreviewVideoPrepared", "durationInMills", "onSeekCandidateImage", "position", "setImageUpdateListener", "showCoverProcessDialog", "isVisible", "CaptureVideoInfo", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ViewConstructor"})
public final class VideoCaptureView
  extends LinearLayout
  implements VideoCaptureContract.IVideoCaptureView
{
  public static final VideoCaptureView.Companion a;
  private final float jdField_a_of_type_Float;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageUpdateListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureImageUpdateListener;
  private PreviewImageAdapter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter;
  private VideoCapturePresenter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
  @NotNull
  private final VideoCaptureView.CaptureVideoInfo jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
  private HorizontalListView jdField_a_of_type_ComTencentTkdTopicsdkWidgetHorizontalListView;
  private CommonProgressDialog jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
  private CaptureOperateTouchLayout jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView;
  private TextView b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$Companion = new VideoCaptureView.Companion(null);
  }
  
  public VideoCaptureView(@NotNull Context paramContext, @NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo, float paramFloat, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo = paramCaptureVideoInfo;
    this.jdField_a_of_type_Float = paramFloat;
    LayoutInflater.from(paramContext).inflate(R.layout.k, (ViewGroup)this, true);
    a();
    e();
  }
  
  private final void a()
  {
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = ((DisplayUtils)localObject).a(localContext, 56.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter = new VideoCapturePresenter(i, ((DisplayUtils)localObject).a(localContext, 30.0F));
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoCapturePresenter)localObject).a((VideoCaptureContract.IVideoCaptureView)this);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    a((Context)localObject);
    localObject = findViewById(R.id.bn);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_iv_cover)");
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject);
    localObject = findViewById(R.id.bq);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_operate_layout)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout = ((CaptureOperateTouchLayout)localObject);
    localObject = findViewById(R.id.bo);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_iv_indicator)");
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localObject = findViewById(R.id.br);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_progress_time)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    localObject = findViewById(R.id.bt);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_tv_toast)");
    this.b = ((TextView)localObject);
    localObject = findViewById(R.id.bp);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_measure_layout)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView = ((VideoMeasureScaleView)localObject);
    b();
    c();
    d();
  }
  
  private final void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter = new PreviewImageAdapter(paramContext);
    paramContext = findViewById(R.id.bs);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.video_capture_recyclerview)");
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetHorizontalListView = ((HorizontalListView)paramContext);
    paramContext = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetHorizontalListView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("listView");
    }
    paramContext.setAdapter((ListAdapter)this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter);
    paramContext = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetHorizontalListView;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("listView");
    }
    paramContext = paramContext.getLayoutParams();
    paramContext.height = b();
    paramContext.width = (c() * 11);
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetHorizontalListView;
    if (localHorizontalListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("listView");
    }
    localHorizontalListView.setLayoutParams(paramContext);
  }
  
  private final void b()
  {
    int i = b();
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int j = ((ImageView)localObject).getPaddingTop();
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int k = ((ImageView)localObject).getPaddingBottom();
    int m = c();
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int n = ((ImageView)localObject).getPaddingLeft();
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int i1 = ((ImageView)localObject).getPaddingRight();
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localObject = ((ImageView)localObject).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i + j + k);
    ((ViewGroup.LayoutParams)localObject).width = (m + n + i1);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void c()
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    TextView localTextView1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("progressTextView");
    }
    TextView localTextView2 = this.b;
    if (localTextView2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureToastTextView");
    }
    VideoMeasureScaleView localVideoMeasureScaleView = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView;
    if (localVideoMeasureScaleView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoMeasureScaleView");
    }
    localCaptureOperateTouchLayout.setup(localImageView, localTextView1, localTextView2, localVideoMeasureScaleView, a());
    localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setEnabled(false);
    localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setOnCaptureOperateCallback((CaptureOperateTouchLayout.OnCaptureOperateCallback)new VideoCaptureView.initCaptureOperateView.1(this));
    localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setOnIndicatorPressCallback((CaptureOperateTouchLayout.OnIndicatorPressCallback)new VideoCaptureView.initCaptureOperateView.2());
  }
  
  private final void d()
  {
    Object localObject = getContext();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog = new CommonProgressDialog((Context)localObject, 2);
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      ((CommonProgressDialog)localObject).a("请稍等...");
    }
  }
  
  private final void e()
  {
    VideoCapturePresenter localVideoCapturePresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo);
    localVideoCapturePresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a(this.jdField_a_of_type_Float);
  }
  
  public final float a()
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    return localCaptureOperateTouchLayout.a();
  }
  
  public int a()
  {
    return 11;
  }
  
  @NotNull
  public ViewGroup a()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("candidateView");
    }
    return localViewGroup;
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter;
    if (localObject != null)
    {
      localObject = ((PreviewImageAdapter)localObject).a();
      if ((localObject != null) && ((((Collection)localObject).isEmpty() ^ true)))
      {
        ImageView localImageView;
        if (paramInt < ((List)localObject).size())
        {
          localObject = ((CaptureTask)((List)localObject).get(paramInt)).a();
          if (localObject != null)
          {
            localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
            if (localImageView == null) {
              Intrinsics.throwUninitializedPropertyAccessException("indicator");
            }
            localImageView.setImageBitmap((Bitmap)localObject);
          }
        }
        else
        {
          localObject = ((CaptureTask)((List)localObject).get(((List)localObject).size() - 1)).a();
          if (localObject != null)
          {
            localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
            if (localImageView == null) {
              Intrinsics.throwUninitializedPropertyAccessException("indicator");
            }
            localImageView.setImageBitmap((Bitmap)localObject);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, @NotNull CaptureTask paramCaptureTask)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureTask, "captureTask");
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter;
    if (localObject != null)
    {
      localObject = ((PreviewImageAdapter)localObject).a();
      if (localObject != null)
      {
        localObject = CollectionsKt.toMutableList((Collection)localObject);
        break label38;
      }
    }
    localObject = null;
    label38:
    if ((localObject != null) && (paramInt >= 0) && (paramInt < ((List)localObject).size()))
    {
      ((List)localObject).set(paramInt, paramCaptureTask);
      paramCaptureTask = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter;
      if (paramCaptureTask != null) {
        paramCaptureTask.a((List)localObject);
      }
    }
  }
  
  public void a(long paramLong)
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void a(@Nullable Bitmap paramBitmap)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    ((ImageView)localObject).setImageBitmap(paramBitmap);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureImageUpdateListener;
    if (localObject != null) {
      ((ImageUpdateListener)localObject).a(paramBitmap);
    }
  }
  
  public final void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    VideoCapturePresenter localVideoCapturePresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a(paramOutputPicListener);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Object localObject1 = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject1 = ((com.tencent.tkd.topicsdk.framework.bridge.ImageLoader)localObject1).a((Context)localObject2);
    localObject2 = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    ((com.tencent.tkd.topicsdk.framework.ImageLoader)localObject1).a((ImageView)localObject2).a(paramString);
  }
  
  public void a(@NotNull List<CaptureTask> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dataList");
    PreviewImageAdapter localPreviewImageAdapter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter;
    if (localPreviewImageAdapter != null) {
      localPreviewImageAdapter.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      if (localCommonProgressDialog.isShowing()) {
        return;
      }
      d();
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      localCommonProgressDialog.show();
      return;
    }
    CommonProgressDialog localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
    }
    if (localCommonProgressDialog.isShowing())
    {
      localCommonProgressDialog = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetDialogCommonProgressDialog;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      localCommonProgressDialog.dismiss();
    }
  }
  
  public int b()
  {
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localDisplayUtils.a(localContext, 56.0F);
  }
  
  public void b(long paramLong)
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setDuration(paramLong);
    localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public void b(@NotNull List<CaptureTask> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dataList");
    PreviewImageAdapter localPreviewImageAdapter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewImageAdapter;
    if (localPreviewImageAdapter != null) {
      localPreviewImageAdapter.a(paramList);
    }
  }
  
  public int c()
  {
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i = localDisplayUtils.a(localContext);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return (i - localDisplayUtils.a(localContext, 22.5F) * 2) / 11;
  }
  
  public final int d()
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    return localCaptureOperateTouchLayout.a() + this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    VideoCapturePresenter localVideoCapturePresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.b();
  }
  
  protected void onDetachedFromWindow()
  {
    VideoCapturePresenter localVideoCapturePresenter = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a();
    super.onDetachedFromWindow();
  }
  
  public final void setImageUpdateListener(@NotNull ImageUpdateListener paramImageUpdateListener)
  {
    Intrinsics.checkParameterIsNotNull(paramImageUpdateListener, "imageUpdateListener");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureImageUpdateListener = paramImageUpdateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView
 * JD-Core Version:    0.7.0.1
 */