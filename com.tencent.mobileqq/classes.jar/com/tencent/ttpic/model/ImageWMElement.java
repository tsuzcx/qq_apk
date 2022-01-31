package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.ttpic.cache.ImageMemoryManager;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.BenchUtil;

public class ImageWMElement
  extends WMElement
{
  private static final String TAG = ImageWMElement.class.getSimpleName();
  private long firstTimestamp;
  
  private int getFrameIndex(long paramLong)
  {
    if (this.firstTimestamp <= 0L) {
      this.firstTimestamp = paramLong;
    }
    return (int)((paramLong - this.firstTimestamp) / this.frameDuration) % this.frames;
  }
  
  private String getValue(int paramInt)
  {
    if (!TextUtils.isEmpty(this.userValue)) {
      return this.userValue;
    }
    String str1 = "";
    if (this.imgPath != null) {
      str1 = new String(this.imgPath);
    }
    String str2 = str1;
    if (this.logic != null) {
      str2 = str1.replace("[logic]", this.logic.getValue(this.userValue));
    }
    return LogicDataManager.getInstance().replaceWithData(str2, this.dataKeys).replace("%d", String.valueOf(paramInt));
  }
  
  public Bitmap getBitmap()
  {
    this.lastValue = this.curValue;
    return super.getBitmap();
  }
  
  public void init()
  {
    super.init();
    this.curValue = getValue(0);
  }
  
  public void reset()
  {
    this.firstTimestamp = 0L;
  }
  
  public void updateBitmap(long paramLong)
  {
    BenchUtil.benchStart("ImageUpdateBitmap");
    this.curValue = getValue(getFrameIndex(paramLong));
    if (needUpdate()) {
      this.bitmap = ImageMemoryManager.getInstance().loadImage(this.itemId, this.curValue);
    }
    BenchUtil.benchEnd("ImageUpdateBitmap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.ImageWMElement
 * JD-Core Version:    0.7.0.1
 */