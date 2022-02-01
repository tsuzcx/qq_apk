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
  public static final VideoCaptureView.Companion a = new VideoCaptureView.Companion(null);
  private HorizontalListView b;
  private CaptureOperateTouchLayout c;
  private ViewGroup d;
  private TextView e;
  private TextView f;
  private VideoMeasureScaleView g;
  private ImageView h;
  private CommonProgressDialog i;
  private ImageUpdateListener j;
  private PreviewImageAdapter k;
  private VideoCapturePresenter l;
  @NotNull
  private final VideoCaptureView.CaptureVideoInfo m;
  private final float n;
  
  public VideoCaptureView(@NotNull Context paramContext, @NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo, float paramFloat, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m = paramCaptureVideoInfo;
    this.n = paramFloat;
    LayoutInflater.from(paramContext).inflate(R.layout.f, (ViewGroup)this, true);
    a();
    e();
  }
  
  private final void a()
  {
    Object localObject = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i1 = ((DisplayUtils)localObject).a(localContext, 56.0F);
    localObject = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    this.l = new VideoCapturePresenter(i1, ((DisplayUtils)localObject).a(localContext, 30.0F));
    localObject = this.l;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    ((VideoCapturePresenter)localObject).a((VideoCaptureContract.IVideoCaptureView)this);
    localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    a((Context)localObject);
    localObject = findViewById(R.id.aL);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_iv_cover)");
    this.d = ((ViewGroup)localObject);
    localObject = findViewById(R.id.aO);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_operate_layout)");
    this.c = ((CaptureOperateTouchLayout)localObject);
    localObject = findViewById(R.id.aM);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_iv_indicator)");
    this.h = ((ImageView)localObject);
    localObject = findViewById(R.id.aP);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_progress_time)");
    this.e = ((TextView)localObject);
    localObject = findViewById(R.id.aR);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_tv_toast)");
    this.f = ((TextView)localObject);
    localObject = findViewById(R.id.aN);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "findViewById(R.id.video_capture_measure_layout)");
    this.g = ((VideoMeasureScaleView)localObject);
    b();
    c();
    d();
  }
  
  private final void a(Context paramContext)
  {
    this.k = new PreviewImageAdapter(paramContext);
    paramContext = findViewById(R.id.aQ);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.video_capture_recyclerview)");
    this.b = ((HorizontalListView)paramContext);
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("listView");
    }
    paramContext.setAdapter((ListAdapter)this.k);
    paramContext = this.b;
    if (paramContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("listView");
    }
    paramContext = paramContext.getLayoutParams();
    paramContext.height = getPreviewImageHeight();
    paramContext.width = (getPreviewImageWidth() * 11);
    HorizontalListView localHorizontalListView = this.b;
    if (localHorizontalListView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("listView");
    }
    localHorizontalListView.setLayoutParams(paramContext);
  }
  
  private final void b()
  {
    int i1 = getPreviewImageHeight();
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int i2 = ((ImageView)localObject).getPaddingTop();
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int i3 = ((ImageView)localObject).getPaddingBottom();
    int i4 = getPreviewImageWidth();
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int i5 = ((ImageView)localObject).getPaddingLeft();
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int i6 = ((ImageView)localObject).getPaddingRight();
    localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localObject = ((ImageView)localObject).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i1 + i2 + i3);
    ((ViewGroup.LayoutParams)localObject).width = (i4 + i5 + i6);
    ImageView localImageView = this.h;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void c()
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    ImageView localImageView = this.h;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    TextView localTextView1 = this.e;
    if (localTextView1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("progressTextView");
    }
    TextView localTextView2 = this.f;
    if (localTextView2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureToastTextView");
    }
    VideoMeasureScaleView localVideoMeasureScaleView = this.g;
    if (localVideoMeasureScaleView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("videoMeasureScaleView");
    }
    localCaptureOperateTouchLayout.setup(localImageView, localTextView1, localTextView2, localVideoMeasureScaleView, getPreviewImageCount());
    localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setEnabled(false);
    localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setOnCaptureOperateCallback((CaptureOperateTouchLayout.OnCaptureOperateCallback)new VideoCaptureView.initCaptureOperateView.1(this));
    localCaptureOperateTouchLayout = this.c;
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
      this.i = new CommonProgressDialog((Context)localObject, 2);
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      ((CommonProgressDialog)localObject).a("请稍等...");
    }
  }
  
  private final void e()
  {
    VideoCapturePresenter localVideoCapturePresenter = this.l;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a(this.m);
    localVideoCapturePresenter = this.l;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a(this.n);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.a(paramFloat, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      localObject = ((PreviewImageAdapter)localObject).a();
      if ((localObject != null) && ((((Collection)localObject).isEmpty() ^ true)))
      {
        ImageView localImageView;
        if (paramInt < ((List)localObject).size())
        {
          localObject = ((CaptureTask)((List)localObject).get(paramInt)).b();
          if (localObject != null)
          {
            localImageView = this.h;
            if (localImageView == null) {
              Intrinsics.throwUninitializedPropertyAccessException("indicator");
            }
            localImageView.setImageBitmap((Bitmap)localObject);
          }
        }
        else
        {
          localObject = ((CaptureTask)((List)localObject).get(((List)localObject).size() - 1)).b();
          if (localObject != null)
          {
            localImageView = this.h;
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
    Object localObject = this.k;
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
      paramCaptureTask = this.k;
      if (paramCaptureTask != null) {
        paramCaptureTask.a((List)localObject);
      }
    }
  }
  
  public void a(long paramLong)
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void a(@Nullable Bitmap paramBitmap)
  {
    Object localObject = this.h;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    ((ImageView)localObject).setImageBitmap(paramBitmap);
    localObject = this.j;
    if (localObject != null) {
      ((ImageUpdateListener)localObject).a(paramBitmap);
    }
  }
  
  public final void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    VideoCapturePresenter localVideoCapturePresenter = this.l;
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
    localObject2 = this.h;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    ((com.tencent.tkd.topicsdk.framework.ImageLoader)localObject1).a((ImageView)localObject2).a(paramString);
  }
  
  public void a(@NotNull List<CaptureTask> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dataList");
    PreviewImageAdapter localPreviewImageAdapter = this.k;
    if (localPreviewImageAdapter != null) {
      localPreviewImageAdapter.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localCommonProgressDialog = this.i;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      if (localCommonProgressDialog.isShowing()) {
        return;
      }
      d();
      localCommonProgressDialog = this.i;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      localCommonProgressDialog.show();
      return;
    }
    CommonProgressDialog localCommonProgressDialog = this.i;
    if (localCommonProgressDialog == null) {
      Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
    }
    if (localCommonProgressDialog.isShowing())
    {
      localCommonProgressDialog = this.i;
      if (localCommonProgressDialog == null) {
        Intrinsics.throwUninitializedPropertyAccessException("coverProcessDialog");
      }
      localCommonProgressDialog.dismiss();
    }
  }
  
  public void b(long paramLong)
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setDuration(paramLong);
    localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    localCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public void b(@NotNull List<CaptureTask> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "dataList");
    PreviewImageAdapter localPreviewImageAdapter = this.k;
    if (localPreviewImageAdapter != null) {
      localPreviewImageAdapter.a(paramList);
    }
  }
  
  @NotNull
  public ViewGroup getCandidateView()
  {
    ViewGroup localViewGroup = this.d;
    if (localViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("candidateView");
    }
    return localViewGroup;
  }
  
  public int getPreviewImageCount()
  {
    return 11;
  }
  
  public int getPreviewImageHeight()
  {
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return localDisplayUtils.a(localContext, 56.0F);
  }
  
  public int getPreviewImageWidth()
  {
    DisplayUtils localDisplayUtils = DisplayUtils.a;
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    int i1 = localDisplayUtils.a(localContext);
    localDisplayUtils = DisplayUtils.a;
    localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    return (i1 - localDisplayUtils.a(localContext, 22.5F) * 2) / 11;
  }
  
  public final float getProgress()
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    return localCaptureOperateTouchLayout.getCurrentProgress();
  }
  
  public final int getSeekVideoPosition()
  {
    CaptureOperateTouchLayout localCaptureOperateTouchLayout = this.c;
    if (localCaptureOperateTouchLayout == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureOperateLayout");
    }
    return localCaptureOperateTouchLayout.getVideoSeekPosition() + this.m.a();
  }
  
  @NotNull
  public final VideoCaptureView.CaptureVideoInfo getVideoInfo()
  {
    return this.m;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    VideoCapturePresenter localVideoCapturePresenter = this.l;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.c();
  }
  
  protected void onDetachedFromWindow()
  {
    VideoCapturePresenter localVideoCapturePresenter = this.l;
    if (localVideoCapturePresenter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("presenter");
    }
    localVideoCapturePresenter.a();
    super.onDetachedFromWindow();
  }
  
  public final void setImageUpdateListener(@NotNull ImageUpdateListener paramImageUpdateListener)
  {
    Intrinsics.checkParameterIsNotNull(paramImageUpdateListener, "imageUpdateListener");
    this.j = paramImageUpdateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCaptureView
 * JD-Core Version:    0.7.0.1
 */