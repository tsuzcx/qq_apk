package com.tencent.tkd.topicsdk.videoprocess.videocapture;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask;", "Landroid/os/AsyncTask;", "", "Landroid/graphics/Bitmap;", "type", "", "path", "", "position", "width", "height", "captureCallback", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;", "(ILjava/lang/String;IIILcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnCaptureCallback;)V", "captureProxy", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/ICaptureProxy;", "getHeight", "()I", "setHeight", "(I)V", "id", "getId", "setId", "lock", "Ljava/lang/Object;", "onTaskListener", "Lcom/tencent/tkd/topicsdk/videoprocess/videocapture/CaptureTask$OnTaskListener;", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPosition", "setPosition", "resultBitmap", "getResultBitmap", "()Landroid/graphics/Bitmap;", "resultBitmapRef", "Ljava/lang/ref/SoftReference;", "tryCount", "getType", "setType", "getWidth", "setWidth", "attachCaptureProxy", "iCaptureProxy", "doInBackground", "params", "", "([Lkotlin/Unit;)Landroid/graphics/Bitmap;", "notifyResultBitmap", "onCancelled", "onPostExecute", "bitmap", "onPreExecute", "release", "setOnTaskListener", "toString", "CaptureType", "Companion", "OnCaptureCallback", "OnTaskListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
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
  private String jdField_a_of_type_JavaLangString;
  private SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$Companion = new CaptureTask.Companion(null);
  }
  
  public CaptureTask(int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, int paramInt4, @Nullable CaptureTask.OnCaptureCallback paramOnCaptureCallback)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback = paramOnCaptureCallback;
    this.jdField_a_of_type_Int = -2147483648;
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
    return this.d;
  }
  
  @Nullable
  public final Bitmap a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefSoftReference;
    if (localObject != null)
    {
      localObject = (Bitmap)((SoftReference)localObject).get();
      if ((localObject != null) && (((Bitmap)localObject).isRecycled() == true)) {}
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangRefSoftReference;
      if (localObject != null) {
        return (Bitmap)((SoftReference)localObject).get();
      }
      return null;
    }
    return null;
  }
  
  @Nullable
  protected Bitmap a(@NotNull Unit... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "params");
    paramVarArgs = a();
    if (paramVarArgs != null) {
      return paramVarArgs;
    }
    this.b += 1;
    paramVarArgs = new Bitmap[1];
    paramVarArgs[0] = ((Bitmap)null);
    ??? = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureICaptureProxy;
    if (??? != null) {
      ((ICaptureProxy)???).a(this, (CaptureTask.OnCaptureCallback)new CaptureTask.doInBackground.1(this, paramVarArgs));
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        Unit localUnit = Unit.INSTANCE;
        return paramVarArgs[0];
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          TLog.d("CaptureTask", localInterruptedException.toString());
        }
      }
    }
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
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback;
      if (localObject != null) {
        ((CaptureTask.OnCaptureCallback)localObject).a(paramBitmap, this);
      }
    }
    for (;;)
    {
      a();
      return;
      paramBitmap = this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessVideocaptureCaptureTask$OnCaptureCallback;
      if (paramBitmap != null) {
        paramBitmap.a();
      }
    }
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
    return this.e;
  }
  
  public final int c()
  {
    return this.f;
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
    return "CaptureTask{ id= " + this.jdField_a_of_type_Int + ", type= " + this.c + ", path= " + this.jdField_a_of_type_JavaLangString + ", position= " + this.d + ", width= " + this.e + ", height= " + this.f + " }";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.videocapture.CaptureTask
 * JD-Core Version:    0.7.0.1
 */