package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.lang.ref.SoftReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "Landroid/os/AsyncTask;", "", "Landroid/graphics/Bitmap;", "type", "", "path", "", "position", "width", "height", "captureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "(ILjava/lang/String;IIILcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;)V", "captureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "getHeight", "()I", "id", "getId", "()Ljava/lang/String;", "lock", "Ljava/lang/Object;", "onTaskListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnTaskListener;", "getPath", "getPosition", "resultBitmap", "getResultBitmap", "()Landroid/graphics/Bitmap;", "resultBitmapRef", "Ljava/lang/ref/SoftReference;", "tryCount", "getType", "getWidth", "attachCaptureProxy", "iCaptureProxy", "doInBackground", "params", "", "([Lkotlin/Unit;)Landroid/graphics/Bitmap;", "notifyResultBitmap", "onCancelled", "onPostExecute", "bitmap", "onPreExecute", "release", "setOnTaskListener", "toString", "CaptureType", "Companion", "OnCaptureCallback", "OnTaskListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureTask
  extends AsyncTask<Unit, Unit, Bitmap>
{
  public static final CaptureTask.Companion a;
  private int jdField_a_of_type_Int;
  private CaptureTask.OnCaptureCallback jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback;
  private CaptureTask.OnTaskListener jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnTaskListener;
  private ICaptureProxy jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
  private final Object jdField_a_of_type_JavaLangObject;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private final int c;
  private final int d;
  private final int e;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$Companion = new CaptureTask.Companion(null);
  }
  
  public CaptureTask(int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, int paramInt4, @Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
    paramString = UUID.randomUUID().toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "UUID.randomUUID().toString()");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangObject = new Object();
  }
  
  private final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback = ((CaptureTask.OnCaptureCallback)null);
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnTaskListener = ((CaptureTask.OnTaskListener)null);
  }
  
  private final void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  public final int a()
  {
    return this.c;
  }
  
  @Nullable
  public final Bitmap a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefSoftReference;
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject3 = (Bitmap)((SoftReference)localObject1).get();
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject3).isRecycled() == true) {
          return localObject1;
        }
      }
    }
    Object localObject3 = this.jdField_a_of_type_JavaLangRefSoftReference;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = (Bitmap)((SoftReference)localObject3).get();
    }
    return localObject1;
  }
  
  @Nullable
  protected Bitmap a(@NotNull Unit... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    paramVarArgs = a();
    if (paramVarArgs != null)
    {
      if (paramVarArgs != null) {
        return paramVarArgs;
      }
      paramVarArgs = (Void)null;
    }
    this.jdField_a_of_type_Int += 1;
    paramVarArgs = new Bitmap[1];
    paramVarArgs[0] = ((Bitmap)null);
    ??? = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
    if (??? != null) {
      ((ICaptureProxy)???).a(this, (CaptureTask.OnCaptureCallback)new CaptureTask.doInBackground.2(this, paramVarArgs));
    }
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait();
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      TLog.d("CaptureTask", localInterruptedException.toString());
      Unit localUnit = Unit.INSTANCE;
      return paramVarArgs[0];
    }
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a(@Nullable Bitmap paramBitmap)
  {
    super.onPostExecute(paramBitmap);
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramBitmap);
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnTaskListener;
    if (localObject != null) {
      ((CaptureTask.OnTaskListener)localObject).b(this);
    }
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Log.d("CaptureTask", "onCaptureSuccess");
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback;
      if (localObject != null) {
        ((CaptureTask.OnCaptureCallback)localObject).a(paramBitmap, this);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCaptureFailed. null: ");
      boolean bool;
      if (paramBitmap == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", isRecycled: ");
      if (paramBitmap != null) {
        paramBitmap = Boolean.valueOf(paramBitmap.isRecycled());
      } else {
        paramBitmap = null;
      }
      ((StringBuilder)localObject).append(paramBitmap);
      Log.d("CaptureTask", ((StringBuilder)localObject).toString());
      paramBitmap = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback;
      if (paramBitmap != null) {
        paramBitmap.a();
      }
    }
    a();
  }
  
  public final void a(@NotNull CaptureTask.OnTaskListener paramOnTaskListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnTaskListener, "onTaskListener");
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnTaskListener = paramOnTaskListener;
  }
  
  public final void a(@Nullable ICaptureProxy paramICaptureProxy)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy = paramICaptureProxy;
  }
  
  public final int b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    a();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    CaptureTask.OnTaskListener localOnTaskListener = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnTaskListener;
    if (localOnTaskListener != null) {
      localOnTaskListener.a(this);
    }
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CaptureTask{ id= ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", type= ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", path= ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", position= ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", width= ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", height= ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.CaptureTask
 * JD-Core Version:    0.7.0.1
 */