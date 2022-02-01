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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCapturePresenter;", "defaultHeight", "", "defaultWidth", "(II)V", "candidateCaptureManager", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CandidateCaptureManager;", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "getCaptureVideoInfo", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "setCaptureVideoInfo", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;)V", "currentBitmap", "Landroid/graphics/Bitmap;", "getCurrentBitmap", "()Landroid/graphics/Bitmap;", "setCurrentBitmap", "(Landroid/graphics/Bitmap;)V", "currentCapturePos", "getCurrentCapturePos", "()I", "setCurrentCapturePos", "(I)V", "currentOutputListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "expandCaptureTaskList", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "initialProgress", "", "getInitialProgress", "()F", "setInitialProgress", "(F)V", "originalVideoName", "", "getOriginalVideoName", "()Ljava/lang/String;", "outputPathAfterSave", "", "preViewCaptureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "previewCaptureManager", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewCaptureManager;", "previewCaptureTaskList", "previewHeight", "previewWidth", "view", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCaptureView;", "addCaptureTask", "", "position", "captureWidth", "captureHeight", "list", "attachView", "calculatePreviewLength", "confirmClick", "outputPicListener", "detachView", "expandCandidateImageList", "seedPosition", "initPreviewTask", "loadPreviewListCapture", "onCapturePrepared", "width", "height", "duration", "", "outputCoverPath", "path", "recoveryCandidateImageList", "saveBitmapToLocal", "bitmap", "seekCandidateImage", "Companion", "PreviewCaptureCallback", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter
  implements VideoCaptureContract.IVideoCapturePresenter
{
  public static final VideoCapturePresenter.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  @Nullable
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private CandidateCaptureManager jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager;
  private ICaptureProxy jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
  private OutputPicListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureOutputPicListener;
  private PreviewCaptureManager jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager;
  private VideoCaptureContract.IVideoCaptureView jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
  @NotNull
  public VideoCaptureView.CaptureVideoInfo a;
  private final List<CaptureTask> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final List<CaptureTask> jdField_b_of_type_JavaUtilList;
  private int c;
  private final int d;
  private final int e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter$Companion = new VideoCapturePresenter.Companion(null);
  }
  
  public VideoCapturePresenter(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy = ((ICaptureProxy)new SystemCaptureProxy(false));
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_b_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a((CapturePreparedListener)this);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager = new PreviewCaptureManager(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager = new CandidateCaptureManager();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager.a((CaptureTask.OnCaptureCallback)new VideoCapturePresenter.1(this));
  }
  
  private final String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    localObject = ((VideoCaptureView.CaptureVideoInfo)localObject).a();
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    int i = StringsKt.lastIndexOf$default((CharSequence)localCaptureVideoInfo.a(), "/", 0, false, 6, null);
    localCaptureVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    int j = StringsKt.lastIndexOf$default((CharSequence)localCaptureVideoInfo.a(), ".", 0, false, 6, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).substring(i + 1, j);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, List<CaptureTask> paramList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    localObject = new CaptureTask(1, ((VideoCaptureView.CaptureVideoInfo)localObject).a(), paramInt1, paramInt2, paramInt3, (CaptureTask.OnCaptureCallback)new VideoCapturePresenter.PreviewCaptureCallback(this, paramList.size()));
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager.c((CaptureTask)localObject);
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
      localStringBuilder.append(TopicSDKHelperKt.c());
      localStringBuilder.append(a());
      localStringBuilder.append('-');
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".jpg");
      ThreadManagerKt.c((Function0)new VideoCapturePresenter.saveBitmapToLocal.1(this, localStringBuilder.toString(), paramBitmap));
    }
  }
  
  private final void a(String paramString)
  {
    OutputPicListener localOutputPicListener = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureOutputPicListener;
    if (localOutputPicListener != null) {
      localOutputPicListener.a(paramString);
    }
    paramString = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (paramString != null) {
      paramString.a(false);
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureOutputPicListener = ((OutputPicListener)null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private final void d()
  {
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    int i;
    if (localIVideoCaptureView != null) {
      i = localIVideoCaptureView.b();
    } else {
      i = this.d;
    }
    this.c = i;
    localIVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localIVideoCaptureView != null) {
      i = localIVideoCaptureView.c();
    } else {
      i = this.e;
    }
    this.jdField_b_of_type_Int = i;
  }
  
  private final void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    int k = 0;
    int i;
    if (localObject != null) {
      i = ((VideoCaptureContract.IVideoCaptureView)localObject).a();
    } else {
      i = 0;
    }
    float f = 0.0F;
    int j = k;
    if (i > 0)
    {
      f = (float)(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a() / i);
      j = k;
    }
    while (j < i)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      a((int)(((VideoCaptureView.CaptureVideoInfo)localObject).a() + j * f), this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_JavaUtilList);
      j += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager.a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager.a();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView = ((VideoCaptureContract.IVideoCaptureView)null);
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = (List)new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((VideoCaptureContract.IVideoCaptureView)localObject).a();
    } else {
      i = 0;
    }
    while (j < i)
    {
      int k = (j - paramInt2) * CaptureOperateTouchLayout.a.a() + paramInt1;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      a(((VideoCaptureView.CaptureVideoInfo)localObject).a() + k, this.jdField_b_of_type_Int, this.c, this.jdField_b_of_type_JavaUtilList);
      localList.add(Integer.valueOf(k));
      j += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).b(this.jdField_b_of_type_JavaUtilList);
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
    d();
    e();
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.a(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a());
    }
  }
  
  public final void a(@Nullable Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).a(true);
    }
    if (!this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager.a())
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
      if (localObject != null) {
        ((VideoCaptureContract.IVideoCaptureView)localObject).a(false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TopicSDKHelperKt.c());
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append('-');
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(".jpg");
      paramOutputPicListener.a(((StringBuilder)localObject).toString());
      return;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureOutputPicListener = paramOutputPicListener;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(@NotNull VideoCaptureContract.IVideoCaptureView paramIVideoCaptureView)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoCaptureView, "view");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView = paramIVideoCaptureView;
  }
  
  public final void a(@NotNull VideoCaptureView.CaptureVideoInfo paramCaptureVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramCaptureVideoInfo, "<set-?>");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo = paramCaptureVideoInfo;
  }
  
  public void b()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager;
    VideoCaptureView.CaptureVideoInfo localCaptureVideoInfo = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localCaptureVideoInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localObject1 != null) {
      localObject1 = ((VideoCaptureContract.IVideoCaptureView)localObject1).a();
    } else {
      localObject1 = null;
    }
    ((CandidateCaptureManager)localObject2).a(localCaptureVideoInfo, (ViewGroup)localObject1, (CapturePreparedListener)new VideoCapturePresenter.loadPreviewListCapture.1(this));
    localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
    localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    ((ICaptureProxy)localObject1).a((VideoCaptureView.CaptureVideoInfo)localObject2, null);
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager;
    Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    ((CandidateCaptureManager)localObject1).a(((VideoCaptureView.CaptureVideoInfo)localObject2).a() + paramInt);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TopicSDKHelperKt.c());
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append('-');
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(".jpg");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (new File((String)localObject1).exists())
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
      if (localObject2 != null) {
        ((VideoCaptureContract.IVideoCaptureView)localObject2).a((String)localObject1);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
      if (localObject1 != null)
      {
        double d1 = paramInt;
        double d2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a();
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = ((VideoCaptureContract.IVideoCaptureView)localObject1).a();
        Double.isNaN(d2);
        ((VideoCaptureContract.IVideoCaptureView)localObject1).a((int)Math.ceil(d1 * d2));
      }
    }
  }
  
  public void c()
  {
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localIVideoCaptureView != null) {
      localIVideoCaptureView.b(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter
 * JD-Core Version:    0.7.0.1
 */