import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageTracer;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.RapidNetUtils;
import java.util.HashMap;

public class pkx
  implements Runnable
{
  public pkx(DecodeImageTask paramDecodeImageTask, ImageKey paramImageKey, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    ImageTracer.startSuperResolution(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
    ProgressTracer.print(8, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      ImageManagerLog.w(DecodeImageTask.a(), "super resolution. bitmap == null before process");
      return;
    }
    int i = RapidNetUtils.getModelIdFromUrl(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
    if (i < 0)
    {
      ImageManagerLog.e(DecodeImageTask.a(), "super resolution. invalid modelId. url=" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
      return;
    }
    Object localObject1 = Runtime.getRuntime();
    long l = ((Runtime)localObject1).maxMemory() - ((Runtime)localObject1).totalMemory() + ((Runtime)localObject1).freeMemory();
    ImageManagerLog.w(DecodeImageTask.a(), "super resolution. freeMemory=" + l);
    if (l / 1024L / 1024L < ImageManagerEnv.g().getSuperResolutionMemoryThreshold())
    {
      ImageManagerLog.w(DecodeImageTask.a(), "super resolution. Low memory, ignore super resolution.");
      return;
    }
    ImageManagerLog.w(DecodeImageTask.a(), "super resolution. using model modelId=" + i + " url=" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
    l = System.currentTimeMillis();
    localObject1 = RapidNetUtils.superResolution(this.jdField_a_of_type_AndroidGraphicsBitmap, i);
    l = System.currentTimeMillis() - l;
    if (RapidNetUtils.isHighScaleUrl(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url))
    {
      ImageManagerLog.w(DecodeImageTask.a(), "high scale super resolution. Total function cost=" + l);
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "super_resolution_total_procedure_high_scale", (int)l);
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("PhoneType", Build.MODEL);
      ((HashMap)localObject2).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject2).put("modelId", String.valueOf(i));
      ((HashMap)localObject2).put("timeCost", String.valueOf(l));
      ((HashMap)localObject2).put("isHighScale", String.valueOf(RapidNetUtils.isHighScaleUrl(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url)));
      ImageManagerEnv.g().statisticCollectorReport("qzone_super_resolution", (HashMap)localObject2);
      if (localObject1 != null) {
        break;
      }
      ImageManagerLog.w(DecodeImageTask.a(), "super resolution. superResolutionBitmap == null after process. url=" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
      return;
      ImageManagerLog.w(DecodeImageTask.a(), "super resolution. Total function cost=" + l);
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "super_resolution_total_procedure", (int)l);
    }
    l = System.currentTimeMillis();
    ImageManager.getInstance().saveSuperResImage((Bitmap)localObject1, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey);
    BitmapImage localBitmapImage = new BitmapImage(BitmapReference.getBitmapReference((Bitmap)localObject1));
    if ((this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options != null) && (this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.extraProcessor != null))
    {
      localObject2 = new BitmapImageDrawable(localBitmapImage, this.jdField_a_of_type_Int, this.b);
      ImageManagerLog.w(DecodeImageTask.a(), "super resolution. check high scale after sr. url=" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
      localObject1 = localObject2;
      if (DecodeImageTask.a((Drawable)localObject2)) {
        localObject1 = DecodeImageTask.a((Drawable)localObject2);
      }
      localObject1 = this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.extraProcessor.doProcess((Drawable)localObject1);
      if ((localObject1 instanceof SpecifiedBitmapDrawable))
      {
        localObject2 = ((SpecifiedBitmapDrawable)localObject1).getBitmapRef();
        ImageManager.getInstance().a(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey, this.c, new FeedsBitmapImage((BitmapReference)localObject2), (Drawable)localObject1, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
        if (this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.listener != null) {
          DecodeImageTask.a().post(new pky(this, (Drawable)localObject1));
        }
        label661:
        l = System.currentTimeMillis() - l;
        if (!RapidNetUtils.isHighScaleUrl(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url)) {
          break label843;
        }
        ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "post_process_after_super_resolution_high_scale", (int)l);
      }
    }
    for (;;)
    {
      ImageTracer.reportDownloadTime(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url, true);
      ImageTracer.reportDecodeTime(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url, true);
      ImageTracer.endSuperResolution(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.url);
      ProgressTracer.print(9, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey);
      return;
      ImageManager.getInstance().a(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey, this.c, localBitmapImage, (Drawable)localObject1, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
      break;
      localObject1 = new SpecifiedBitmapDrawable(localBitmapImage.getBitmap());
      ImageManager.getInstance().a(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey, this.c, localBitmapImage, (Drawable)localObject1, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
      if (this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.listener == null) {
        break label661;
      }
      DecodeImageTask.a().post(new pkz(this, (Drawable)localObject1));
      break label661;
      label843:
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", "post_process_after_super_resolution", (int)l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pkx
 * JD-Core Version:    0.7.0.1
 */