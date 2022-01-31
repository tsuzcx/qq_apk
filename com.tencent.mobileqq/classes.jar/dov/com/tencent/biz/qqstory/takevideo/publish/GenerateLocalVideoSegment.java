package dov.com.tencent.biz.qqstory.takevideo.publish;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tribe.async.async.JobContext;
import dov.com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.FilterFactory;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBitmapImageRender;
import dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUImagePixelationFilter;
import java.lang.ref.WeakReference;

@TargetApi(10)
public class GenerateLocalVideoSegment
  extends MeasureJobSegment
{
  private final String a;
  public WeakReference a;
  
  public GenerateLocalVideoSegment()
  {
    this(null);
  }
  
  public GenerateLocalVideoSegment(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Bitmap a(GenerateContext paramGenerateContext, Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap == null) {
      return null;
    }
    GPUBitmapImageRender localGPUBitmapImageRender = new GPUBitmapImageRender();
    localGPUBitmapImageRender.a(paramBitmap.getWidth(), paramBitmap.getHeight());
    paramGenerateContext = (GenerateContext)localObject;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      paramGenerateContext = (GenerateContext)localObject;
      if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {}
    }
    try
    {
      paramGenerateContext = ((EditDoodleExport)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().a(0);
      localObject = paramBitmap;
      if (paramGenerateContext != null)
      {
        localObject = (GPUImagePixelationFilter)FilterFactory.a(106);
        ((GPUImagePixelationFilter)localObject).a(paramGenerateContext);
        ((GPUImagePixelationFilter)localObject).a();
        paramGenerateContext = localGPUBitmapImageRender.a(paramBitmap, (GPUBaseFilter)localObject);
        SLog.a("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, mosaicThumbBitmap = %s", paramGenerateContext);
        if (paramGenerateContext != null) {
          paramBitmap = paramGenerateContext;
        }
        ((GPUImagePixelationFilter)localObject).d();
        localObject = paramBitmap;
      }
      localGPUBitmapImageRender.a();
      return localObject;
    }
    catch (Exception paramGenerateContext)
    {
      for (;;)
      {
        SLog.e("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "generateMosaicThumbBitmap, read mosaic bitmap " + paramGenerateContext.toString());
        paramGenerateContext = (GenerateContext)localObject;
      }
    }
  }
  
  protected void a(JobContext paramJobContext, GenerateContext paramGenerateContext)
  {
    String str;
    if (((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)))
    {
      str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        break label462;
      }
      str = PublishFileManager.a(paramGenerateContext.jdField_a_of_type_Int, paramGenerateContext.b, ".jpg");
    }
    label462:
    for (;;)
    {
      long l2 = 0L;
      if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        l2 = ((EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).jdField_a_of_type_Int;
      }
      paramJobContext = paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      for (;;)
      {
        long l1;
        try
        {
          localMediaMetadataRetriever.setDataSource(paramJobContext);
          if (!paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateThumbArgs.a) {
            break;
          }
          l1 = 0L;
          if ((paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
          {
            int i = ((EditLocalVideoSource)paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource).b;
            l1 = i;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Object localObject;
          boolean bool;
          localIllegalArgumentException = localIllegalArgumentException;
          SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "Video Source is Invalid ! " + paramJobContext, localIllegalArgumentException);
          continue;
        }
        finally
        {
          if (localMediaMetadataRetriever != null) {
            localMediaMetadataRetriever.release();
          }
        }
        paramJobContext = localMediaMetadataRetriever.extractMetadata(9);
        if (paramJobContext != null) {
          l1 = Long.valueOf(paramJobContext).longValue();
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramJobContext = null;
          break;
          try
          {
            paramJobContext = localMediaMetadataRetriever.getFrameAtTime(1000L * l2);
          }
          catch (OutOfMemoryError paramJobContext)
          {
            SLog.c("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime startTime * 1000L oom", paramJobContext);
          }
        }
      }
      SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "compressToFile error");
      if (localMediaMetadataRetriever != null) {
        localMediaMetadataRetriever.release();
      }
      for (;;)
      {
        notifyError(new ErrorMessage(-1, "GenerateLocalVideoSegment error"));
        return;
        SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "getFrameAtTime error : startTime = %s", new Object[] { Long.valueOf(l2) });
        break;
        SLog.d("Q.qqstory.publish.edit.GenerateLocalVideoSegment", "parameters error : %s", new Object[] { paramGenerateContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.publish.GenerateLocalVideoSegment
 * JD-Core Version:    0.7.0.1
 */