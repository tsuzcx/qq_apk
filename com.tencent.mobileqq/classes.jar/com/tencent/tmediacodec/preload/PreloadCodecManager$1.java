package com.tencent.tmediacodec.preload;

import java.util.Iterator;
import java.util.Set;

class PreloadCodecManager$1
  implements Runnable
{
  PreloadCodecManager$1(PreloadCodecManager paramPreloadCodecManager, Set paramSet) {}
  
  public void run()
  {
    Iterator localIterator = this.val$sampleMimeTypeSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (PreloadCodecManager.isInvalideMimeType(str)) {
        PreloadCodecManager.access$000(this.this$0, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.preload.PreloadCodecManager.1
 * JD-Core Version:    0.7.0.1
 */