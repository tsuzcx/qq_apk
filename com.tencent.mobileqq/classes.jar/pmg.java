import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.StreamDecodeGifTask;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import java.util.HashMap;

public class pmg
  implements Runnable
{
  private ImageKey jdField_a_of_type_ComTencentComponentMediaImageImageKey = null;
  String jdField_a_of_type_JavaLangString = null;
  String b = null;
  
  public pmg(StreamDecodeGifTask paramStreamDecodeGifTask, ImageKey paramImageKey, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey = paramImageKey;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask.isCanceled()) {
      return;
    }
    label690:
    for (;;)
    {
      try
      {
        NewGifDrawable localNewGifDrawable = (NewGifDrawable)ImageManager.getInstance().a(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey);
        if (localNewGifDrawable != null)
        {
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { " isEndDownload hashcode:" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.hashCodeEx() + " filePath:" + this.b + " url:" + this.jdField_a_of_type_JavaLangString });
          if ((this.jdField_a_of_type_ComTencentComponentMediaImageImageKey == null) || (this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options == null) || (!(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
            break label690;
          }
          localNewGifDrawable = (NewGifDrawable)this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.extraProcessor.doProcess(localNewGifDrawable);
          localNewGifDrawable.isEndDownload();
          localNewGifDrawable.changeFile(this.b);
          ImageManager.getInstance().a(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.hashCodeEx(), null, localNewGifDrawable, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
          this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask.setResult(8, new Object[] { localNewGifDrawable, null, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.urlKey, Integer.valueOf(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.hashCodeEx()), null, localNewGifDrawable });
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", new Object[] { "isEndDownload hashcode:" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.hashCodeEx() + "\ncost time:" + (System.currentTimeMillis() - StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask)) + "\nwidth:" + localNewGifDrawable.getsWidth() + " height:" + localNewGifDrawable.getsHeight() + "\nframe count:" + localNewGifDrawable.getNumberOfFrames() + "\nlength:" + localNewGifDrawable.getAllocationByteCount() + "\nnetworkstate:" + ImageManagerEnv.g().getNetWorkState() + "\ncontrolsTime:" + StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask) + "\nurl:" + this.jdField_a_of_type_JavaLangString });
          if (StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask) == 0L) {
            break;
          }
          HashMap localHashMap = new HashMap();
          int i = (int)(System.currentTimeMillis() - StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask));
          if (i <= 0) {
            break;
          }
          localHashMap.put("g_costTime", String.valueOf(i));
          localHashMap.put("g_width", String.valueOf(localNewGifDrawable.getsWidth()));
          localHashMap.put("g_height", String.valueOf(localNewGifDrawable.getsHeight()));
          localHashMap.put("g_frameCount", String.valueOf(localNewGifDrawable.getNumberOfFrames()));
          localHashMap.put("g_size", String.valueOf(localNewGifDrawable.getAllocationByteCount()));
          localHashMap.put("g_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
          localHashMap.put("g_controlsTime", String.valueOf(StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask)));
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_costTime", i);
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_frameCount", localNewGifDrawable.getNumberOfFrames());
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_size", (int)localNewGifDrawable.getAllocationByteCount());
          ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_controlsTime", StreamDecodeGifTask.a(this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask));
          ImageManagerEnv.g().statisticCollectorReport("gifPlayingReportNew", localHashMap);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { "EndCloseStreamTask error :" + localThrowable.toString() });
        return;
      }
      ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { " NewGifDrawable is null url:" + this.jdField_a_of_type_JavaLangString });
      this.jdField_a_of_type_ComTencentComponentMediaImageStreamDecodeGifTask.startDecodeTask();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmg
 * JD-Core Version:    0.7.0.1
 */