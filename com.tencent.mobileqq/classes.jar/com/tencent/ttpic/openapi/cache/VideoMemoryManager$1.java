package com.tencent.ttpic.openapi.cache;

import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.cache.LoadItemManager;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.device.LightDeviceUtils;

class VideoMemoryManager$1
  implements Runnable
{
  VideoMemoryManager$1(VideoMemoryManager paramVideoMemoryManager, VideoMaterial paramVideoMaterial, List paramList) {}
  
  public void run()
  {
    long l1 = LightDeviceUtils.getRuntimeRemainSize(1);
    if (((l1 <= 30720L) || (VideoMemoryManager.isInBlackList())) && (this.this$0.isForceLoadFromSdCard())) {
      return;
    }
    double d = l1;
    Double.isNaN(d);
    long l2 = Math.min(Math.max(Math.min(d * 0.75D, l1 - 30720L), 0.0D), DeviceInstance.getInstance().getMaxMemorySizeInKB());
    l1 = l2;
    if (VideoMemoryManager.access$000(this.this$0) > 0) {
      l1 = Math.min(l2, VideoMemoryManager.access$000(this.this$0));
    }
    l2 = VideoMemoryManager.access$100(this.this$0, this.val$material);
    VideoMemoryManager.access$202(this.this$0, l2 / 1024L);
    VideoMemoryManager.access$302(this.this$0, VideoMaterial.calSampleSize(l1, l2));
    Object localObject = VideoMemoryManager.access$400();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[heap size] = ");
    localStringBuilder.append(l1 / 1024L);
    localStringBuilder.append(" MB, [material size] = ");
    localStringBuilder.append(VideoMemoryManager.access$200(this.this$0));
    localStringBuilder.append(" MB, [sampleSize] = ");
    localStringBuilder.append(VideoMemoryManager.access$300(this.this$0));
    LogUtils.d((String)localObject, localStringBuilder.toString());
    localObject = this.this$0;
    VideoMemoryManager.access$500((VideoMemoryManager)localObject, this.val$material, VideoMemoryManager.access$300((VideoMemoryManager)localObject), this.val$items);
    localObject = this.this$0;
    VideoMemoryManager.access$600((VideoMemoryManager)localObject, this.val$material, VideoMemoryManager.access$300((VideoMemoryManager)localObject));
    localObject = VideoMemoryManager.access$700(this.this$0).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((LoadItemManager)((Iterator)localObject).next()).prepareImages();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager.1
 * JD-Core Version:    0.7.0.1
 */