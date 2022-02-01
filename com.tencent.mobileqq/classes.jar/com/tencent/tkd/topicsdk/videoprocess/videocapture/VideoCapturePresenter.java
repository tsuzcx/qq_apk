package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.tkd.topicsdk.framework.TLog;
import com.tencent.tkd.topicsdk.framework.TopicSDKHelperKt;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout;
import com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout.Companion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCapturePresenter;", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCapturePresenter;", "defaultHeight", "", "defaultWidth", "(II)V", "candidateCaptureManager", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CandidateCaptureManager;", "captureVideoInfo", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "getCaptureVideoInfo", "()Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;", "setCaptureVideoInfo", "(Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureView$CaptureVideoInfo;)V", "expandCaptureTaskList", "", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "initialProgress", "", "getInitialProgress", "()F", "setInitialProgress", "(F)V", "originalVideoName", "", "getOriginalVideoName", "()Ljava/lang/String;", "outputPath", "preViewCaptureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "previewCaptureManager", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/PreviewCaptureManager;", "previewCaptureTaskList", "previewHeight", "previewWidth", "validFile", "", "getValidFile", "()Z", "setValidFile", "(Z)V", "view", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/VideoCaptureContract$IVideoCaptureView;", "addCaptureTask", "", "position", "captureWidth", "captureHeight", "list", "attachView", "calculatePreviewLength", "confirmClick", "outputPicListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/OutputPicListener;", "detachView", "expandCandidateImageList", "seedPosition", "initPreviewTask", "loadPreviewListCapture", "onCapturePrepared", "width", "height", "duration", "", "recoveryCandidateImageList", "saveBitmapToLocal", "bitmap", "Landroid/graphics/Bitmap;", "seekCandidateImage", "Companion", "PreviewCaptureCallback", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoCapturePresenter
  implements VideoCaptureContract.IVideoCapturePresenter
{
  public static final VideoCapturePresenter.Companion a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private CandidateCaptureManager jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager;
  private ICaptureProxy jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
  private PreviewCaptureManager jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager;
  private VideoCaptureContract.IVideoCaptureView jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
  @NotNull
  public VideoCaptureView.CaptureVideoInfo a;
  private String jdField_a_of_type_JavaLangString;
  private final List<CaptureTask> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final List<CaptureTask> jdField_b_of_type_JavaUtilList;
  private final int c;
  private final int d;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCapturePresenter$Companion = new VideoCapturePresenter.Companion(null);
  }
  
  public VideoCapturePresenter(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy = ((ICaptureProxy)new SystemCaptureProxy(false));
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_b_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a((CapturePreparedListener)this);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager = new CandidateCaptureManager();
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocapturePreviewCaptureManager = new PreviewCaptureManager(this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy);
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
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    localObject = ((String)localObject).substring(i + 1, j);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    return localObject;
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
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_JavaLangString = (TopicSDKHelperKt.b() + a() + '-' + paramInt + ".jpg");
      this.jdField_a_of_type_Boolean = true;
      new SavePicTask(paramBitmap, this.jdField_a_of_type_JavaLangString).a();
    }
  }
  
  private final void d()
  {
    VideoCaptureContract.IVideoCaptureView localIVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localIVideoCaptureView != null)
    {
      i = localIVideoCaptureView.b();
      this.jdField_b_of_type_Int = i;
      localIVideoCaptureView = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
      if (localIVideoCaptureView == null) {
        break label51;
      }
    }
    label51:
    for (int i = localIVideoCaptureView.c();; i = this.d)
    {
      this.jdField_a_of_type_Int = i;
      return;
      i = this.c;
      break;
    }
  }
  
  private final void e()
  {
    int k = 0;
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localObject != null) {}
    for (int i = ((VideoCaptureContract.IVideoCaptureView)localObject).a();; i = 0)
    {
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
        a((int)(((VideoCaptureView.CaptureVideoInfo)localObject).a() + j * f), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaUtilList);
        j += 1;
      }
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
  
  public void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCandidateCaptureManager;
    Object localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
    }
    ((CandidateCaptureManager)localObject1).a(((VideoCaptureView.CaptureVideoInfo)localObject2).a() + paramInt);
    localObject1 = TopicSDKHelperKt.b() + a() + '-' + paramInt + ".jpg";
    this.jdField_a_of_type_Boolean = false;
    if (new File((String)localObject1).exists())
    {
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
      if (localObject2 != null) {
        ((VideoCaptureContract.IVideoCaptureView)localObject2).a((String)localObject1);
      }
    }
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    } while (localObject1 == null);
    ((VideoCaptureContract.IVideoCaptureView)localObject1).a((int)Math.ceil(paramInt / this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy.a() * ((VideoCaptureContract.IVideoCaptureView)localObject1).a()));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = 0;
    this.jdField_b_of_type_JavaUtilList.clear();
    List localList = (List)new ArrayList();
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    int i;
    if (localObject != null) {
      i = ((VideoCaptureContract.IVideoCaptureView)localObject).a();
    }
    while (j < i)
    {
      int k = (j - paramInt2) * CaptureOperateTouchLayout.a.a() + paramInt1;
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      a(((VideoCaptureView.CaptureVideoInfo)localObject).a() + k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaUtilList);
      localList.add(Integer.valueOf(k));
      j += 1;
      continue;
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureContract$IVideoCaptureView;
    if (localObject != null) {
      ((VideoCaptureContract.IVideoCaptureView)localObject).b(this.jdField_b_of_type_JavaUtilList);
    }
    TLog.b("VideoCapturePresenter", "expandCandidateImageList positionList: " + localList + " position：" + paramInt1 + " seedPosition：" + paramInt2);
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
  
  public void a(@NotNull OutputPicListener paramOutputPicListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputPicListener, "outputPicListener");
    TLog.d("VideoCapturePresenter", "视频裁剪获取 coverPath = " + this.jdField_a_of_type_JavaLangString);
    paramOutputPicListener.a(this.jdField_a_of_type_JavaLangString);
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
    if (localObject1 != null) {}
    for (localObject1 = ((VideoCaptureContract.IVideoCaptureView)localObject1).a();; localObject1 = null)
    {
      ((CandidateCaptureManager)localObject2).a(localCaptureVideoInfo, (ViewGroup)localObject1, (CapturePreparedListener)new VideoCapturePresenter.loadPreviewListCapture.1(this));
      localObject1 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
      localObject2 = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureVideoCaptureView$CaptureVideoInfo;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("captureVideoInfo");
      }
      ((ICaptureProxy)localObject1).a((VideoCaptureView.CaptureVideoInfo)localObject2, null);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.VideoCapturePresenter
 * JD-Core Version:    0.7.0.1
 */