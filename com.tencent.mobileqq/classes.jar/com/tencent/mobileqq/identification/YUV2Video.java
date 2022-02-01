package com.tencent.mobileqq.identification;

import android.support.annotation.RequiresApi;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.Image2VideoListener;
import com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@RequiresApi(api=18)
public class YUV2Video
  implements ConvertRunnable.ConvertRunnableListener
{
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx;
  private Image2Video.Image2VideoListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$Image2VideoListener;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  
  public YUV2Video()
  {
    a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("identification_yuv", 2, "uninit..");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(ResultInfo paramResultInfo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$Image2VideoListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$Image2VideoListener.a(paramResultInfo);
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 43
    //   8: iconst_2
    //   9: ldc 70
    //   11: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 72	com/tencent/mobileqq/identification/YUV2Video:a	()V
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: new 53	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx
    //   24: dup
    //   25: ldc 74
    //   27: aconst_null
    //   28: aload_0
    //   29: invokespecial 77	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   32: putfield 51	com/tencent/mobileqq/identification/YUV2Video:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx;
    //   35: aload_0
    //   36: getfield 51	com/tencent/mobileqq/identification/YUV2Video:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx;
    //   39: invokevirtual 80	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx:start	()V
    //   42: aload_0
    //   43: getfield 51	com/tencent/mobileqq/identification/YUV2Video:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx;
    //   46: invokevirtual 81	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx:a	()Z
    //   49: istore_1
    //   50: iload_1
    //   51: ifne +10 -> 61
    //   54: aload_0
    //   55: ldc2_w 82
    //   58: invokevirtual 86	java/lang/Object:wait	(J)V
    //   61: aload_0
    //   62: monitorexit
    //   63: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +11 -> 77
    //   69: ldc 43
    //   71: iconst_2
    //   72: ldc 88
    //   74: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_1
    //   78: ireturn
    //   79: astore_2
    //   80: ldc 43
    //   82: iconst_1
    //   83: aload_2
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   91: goto -30 -> 61
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	YUV2Video
    //   49	2	1	bool	boolean
    //   79	5	2	localInterruptedException	java.lang.InterruptedException
    //   94	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	79	java/lang/InterruptedException
    //   20	50	94	finally
    //   54	61	94	finally
    //   61	63	94	finally
    //   80	91	94	finally
    //   95	97	94	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.identification.YUV2Video
 * JD-Core Version:    0.7.0.1
 */