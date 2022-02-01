package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.ThreadManagerKt;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.Companion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCapturePresenter;", "defaultHeight", "", "defaultWidth", "(II)V", "candidateCaptureManager", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CandidateCaptureManager;", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "getCaptureVideoInfo", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "setCaptureVideoInfo", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;)V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "currentCapturePos", "getCurrentCapturePos", "()I", "setCurrentCapturePos", "(I)V", "currentOutputListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "expandCaptureTaskList", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "initialProgress", "", "getInitialProgress", "()F", "setInitialProgress", "(F)V", "originalVideoName", "", "getOriginalVideoName", "()Ljava/lang/String;", "outputPathAfterSave", "", "preViewCaptureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "previewCaptureManager", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewCaptureManager;", "previewCaptureTaskList", "previewHeight", "previewWidth", "view", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCaptureView;", "addCaptureTask", "", "position", "captureWidth", "captureHeight", "list", "attachView", "calculatePreviewLength", "confirmClick", "outputPicListener", "detachView", "expandCandidateImageList", "seedPosition", "initPreviewTask", "loadPreviewListCapture", "onCapturePrepared", "width", "height", "duration", "", "outputCoverPath", "path", "recoveryCandidateImageList", "saveBitmapToLocal", "bitmap", "seekCandidateImage", "Companion", "PreviewCaptureCallback", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter
  implements VideoCaptureContract.IVideoCapturePresenter
{
  public static final VideoCapturePresenter.Companion b = new VideoCapturePresenter.Companion(null);
  @NotNull
  public VideoCaptureView.CaptureVideoInfo a;
  private VideoCaptureContract.IVideoCaptureView c;
  private PreviewCaptureManager d;
  private CandidateCaptureManager e;
  private ICaptureProxy f;
  private float g;
  @Nullable
  private Bitmap h;
  private int i;
  private OutputPicListener j;
  private boolean k;
  private final List<CaptureTask> l;
  private final List<CaptureTask> m;
  private int n;
  private int o;
  private final int p;
  private final int q;
  
  public VideoCapturePresenter(int paramInt1, int paramInt2)
  {
    this.p = paramInt1;
    this.q = paramInt2;
    this.f = ((ICaptureProxy)new SystemCaptureProxy(false));
    this.l = ((List)new ArrayList());
    this.m = ((List)new ArrayList());
    this.f.a((CapturePreparedListener)this);
    this.d = new PreviewCaptureManager(this.f);
    this.e = new CandidateCaptureManager();
    this.e.a((CaptureTask.OnCaptureCallback)new VideoCapturePresenter.1(this));
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, List<CaptureTask> paramList)
  {
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    localObject = new CaptureTask(1, ((VideoCaptureView.CaptureVideoInfo)localObject).f(), paramInt1, paramInt2, paramInt3, (CaptureTask.OnCaptureCallback)new VideoCapturePresenter.PreviewCaptureCallback(this, paramList.size()));
    this.d.c((CaptureTask)localObject);
    paramList.add(localObject);
  }
  
  private final void a(Bitmap paramBitmap, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveBitmapToLocal called. position= ");
    localStringBuilder.append(paramInt);
    Log.d("VideoCapturePresenter", localStringBuilder.toString());
    if (paramBitmap != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TopicSDKHelperKt.e());
      localStringBuilder.append(e());
      localStringBuilder.append('-');
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".jpg");
      ThreadManagerKt.c((Function0)new VideoCapturePresenter.saveBitmapToLocal.1(this, localStringBuilder.toString(), paramBitmap));
    }
  }
  
  private final void a(String paramString)
  {
    OutputPicListener localOutputPicListener = this.j;
    if (localOutputPicListener != null) {
      localOutputPicListener.a(paramString);
    }
    paramString = this.c;
    if (paramString != null) {
      paramString.a(false);
    }
    this.j = ((OutputPicListener)null);
    this.k = false;
  }
  
  private final String e()
  {
    Object localObject = this.a;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    localObject = ((VideoCaptureView.CaptureVideoInfo)localObject).f();
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.a;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    int i1 = StringsKt.lastIndexOf$default((CharSequence)localCaptureVideoInfo.f(), "/", 0, false, 6, null);
    localCaptureVideoInfo = this.a;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    int i2 = StringsKt.lastIndexOf$default((CharSequence)localCaptureVideoInfo.f(), ".", 0, false, 6, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).substring(i1 + 1, i2);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void f()
  {
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.c;
    int i1;
    if (localIVideoCaptureView != null) {
      i1 = localIVideoCaptureView.getPreviewImageHeight();
    } else {
      i1 = this.p;
    }
    this.o = i1;
    localIVideoCaptureView = this.c;
    if (localIVideoCaptureView != null) {
      i1 = localIVideoCaptureView.getPreviewImageWidth();
    } else {
      i1 = this.q;
    }
    this.n = i1;
  }
  
  private final void g()
  {
    Object localObject = this.c;
    int i3 = 0;
    int i1;
    if (localObject != null) {
      i1 = ((VideoCaptureContract.IVideoCaptureView)localObject).getPreviewImageCount();
    } else {
      i1 = 0;
    }
    float f1 = 0.0F;
    int i2 = i3;
    if (i1 > 0)
    {
      f1 = (float)(this.f.a() / i1);
      i2 = i3;
    }
    while (i2 < i1)
    {
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      a((int)(((VideoCaptureView.CaptureVideoInfo)localObject).a() + i2 * f1), this.n, this.o, this.l);
      i2 += 1;
    }
    localObject = this.c;
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).a(this.l);
    }
  }
  
  public void a()
  {
    this.d.a();
    this.e.b();
    this.c = ((VideoCaptureContract.IVideoCaptureView)null);
  }
  
  public final void a(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.m.clear();
    List localList = (List)new ArrayList();
    Object localObject = this.c;
    int i2 = 0;
    int i1;
    if (localObject != null) {
      i1 = ((VideoCaptureContract.IVideoCaptureView)localObject).getPreviewImageCount();
    } else {
      i1 = 0;
    }
    while (i2 < i1)
    {
      int i3 = (i2 - paramInt2) * CaptureOperateTouchLayout.a.a() + paramInt1;
      localObject = this.a;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      a(((VideoCaptureView.CaptureVideoInfo)localObject).a() + i3, this.n, this.o, this.m);
      localList.add(Integer.valueOf(i3));
      i2 += 1;
    }
    localObject = this.c;
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).b(this.m);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expandCandidateImageList positionList: ");
    ((StringBuilder)localObject).append(localList);
    ((StringBuilder)localObject).append(" position：");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" seedPosition：");
    ((StringBuilder)localObject).append(paramInt2);
    TLog.b("VideoCapturePresenter", ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    f();
    g();
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.c;
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.a(this.f.a());
    }
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    this.h = paramBitmap;
  }
  
  public void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    this.e.a().a((Function1)new VideoCapturePresenter.confirmClick.1(paramOutputPicListener));
  }
  
  public void a(@NotNull VideoCaptureContract.IVideoCaptureView paramIVideoCaptureView)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoCaptureView, "view");
    this.c = paramIVideoCaptureView;
  }
  
  public final void a(@NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureVideoInfo, "<set-?>");
    this.a = paramCaptureVideoInfo;
  }
  
  public final float b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = this.e;
    Object localObject2 = this.a;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    ((CandidateCaptureManager)localObject1).a(((VideoCaptureView.CaptureVideoInfo)localObject2).a() + paramInt);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TopicSDKHelperKt.e());
    ((StringBuilder)localObject1).append(e());
    ((StringBuilder)localObject1).append('-');
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(".jpg");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (new File((String)localObject1).exists())
    {
      localObject2 = this.c;
      if (localObject2 != null) {
        ((VideoCaptureContract.IVideoCaptureView)localObject2).a((String)localObject1);
      }
    }
    else
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        double d1 = paramInt;
        double d2 = this.f.a();
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = ((VideoCaptureContract.IVideoCaptureView)localObject1).getPreviewImageCount();
        Double.isNaN(d2);
        ((VideoCaptureContract.IVideoCaptureView)localObject1).a((int)Math.ceil(d1 * d2));
      }
    }
  }
  
  public void c()
  {
    Object localObject2 = this.e;
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.a;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    Object localObject1 = this.c;
    if (localObject1 != null) {
      localObject1 = ((VideoCaptureContract.IVideoCaptureView)localObject1).getCandidateView();
    } else {
      localObject1 = null;
    }
    ((CandidateCaptureManager)localObject2).a(localCaptureVideoInfo, (ViewGroup)localObject1, (CapturePreparedListener)new VideoCapturePresenter.loadPreviewListCapture.1(this));
    localObject1 = this.f;
    localObject2 = this.a;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    ((ICaptureProxy)localObject1).a((VideoCaptureView.CaptureVideoInfo)localObject2, null);
  }
  
  public void d()
  {
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.c;
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.b(this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter
 * JD-Core Version:    0.7.0.1
 */