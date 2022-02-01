package com.tencent.ttpic.openapi.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.io.File;
import java.util.HashMap;

public class ImageWMElement
  extends WMElement
{
  private static final String TAG = ImageWMElement.class.getSimpleName();
  private long firstTimestamp;
  private boolean loadImageSuccess;
  
  public ImageWMElement(WMElementConfig paramWMElementConfig)
  {
    super(paramWMElementConfig);
  }
  
  private int getFrameIndex(long paramLong)
  {
    if (this.firstTimestamp <= 0L) {
      this.firstTimestamp = paramLong;
    }
    if (this.frames <= 0) {
      return 0;
    }
    return (int)((paramLong - this.firstTimestamp) / this.frameDuration) % this.frames;
  }
  
  private String getValue(int paramInt)
  {
    if (!TextUtils.isEmpty(this.userValue)) {
      return this.userValue;
    }
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if ((this.imgPath == null) || (!this.numberSource.equals(""))) {}
    for (;;)
    {
      try
      {
        int i = Integer.parseInt((String)LogicDataManager.getInstance().mFollowData.get(this.numberSource));
        if (((!this.showCaseMin.equals("")) || (!this.showCaseMax.equals(""))) && ((i < Integer.parseInt(this.showCaseMin)) || (i > Integer.parseInt(this.showCaseMax)))) {
          break label208;
        }
        localObject1 = this.imgPath;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      if (this.logic != null)
      {
        localObject3 = ((String)localObject1).replace("[logic]", this.logic.getValue(this.userValue, this));
        LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.logic.getDays()));
      }
      return LogicDataManager.getInstance().replaceWithData((String)localObject3, this.dataKeys, this).replace("%d", String.valueOf(paramInt));
      Object localObject2 = this.imgPath;
      continue;
      label208:
      localObject2 = "";
    }
  }
  
  private boolean needUpdateImage()
  {
    return (!this.curValue.equals(this.lastValue)) || (!this.loadImageSuccess) || (!TextUtils.isEmpty(this.animateType));
  }
  
  public Bitmap getBitmap()
  {
    this.lastValue = this.curValue;
    setContentChanged(false);
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
    setContentChanged(false);
  }
  
  public boolean updateBitmap(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool5 = false;
    bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    BenchUtil.benchStart("ImageUpdateBitmap");
    this.curValue = getValue(getFrameIndex(paramLong));
    bool1 = bool4;
    try
    {
      if (!needUpdateImage())
      {
        bool1 = bool5;
        if (!paramBoolean1) {
          break label369;
        }
      }
      localBitmap = null;
      if (!paramBoolean2) {
        break label378;
      }
      bool1 = bool4;
      if (TextUtils.isEmpty(this.dataPath)) {
        break label378;
      }
      bool1 = bool4;
      if (this.curValue.equals("")) {
        break label644;
      }
      bool1 = bool4;
      localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.itemId + File.separator + this.curValue, 1);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        Bitmap localBitmap;
        String str;
        LogUtils.e(TAG, "watermark image element load fail \n" + localOutOfMemoryError1.getMessage());
        continue;
        bool1 = paramBoolean1;
        this.loadImageSuccess = false;
        bool1 = paramBoolean1;
        continue;
        paramBoolean1 = false;
        continue;
        continue;
        localObject = null;
      }
    }
    paramBoolean1 = bool2;
    bool1 = bool4;
    if (this.isNeedShow)
    {
      paramBoolean1 = bool2;
      bool1 = bool4;
      if (!this.numberSource.equals(""))
      {
        bool1 = bool4;
        str = (String)LogicDataManager.getInstance().mFollowData.get(this.numberSource);
        paramBoolean1 = bool2;
        if (str != null) {
          bool1 = bool4;
        }
      }
    }
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(str);
        bool1 = bool4;
        if (this.showCaseMin.equals("")) {
          continue;
        }
        bool1 = bool4;
        if (this.showCaseMax.equals("")) {
          continue;
        }
        bool1 = bool4;
        int j = Integer.parseInt(this.showCaseMin);
        bool1 = bool4;
        int k = Integer.parseInt(this.showCaseMax);
        if ((i >= j) && (i <= k)) {
          continue;
        }
        bool1 = bool4;
        setContentChanged(true);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        label369:
        label378:
        Object localObject;
        paramBoolean1 = bool3;
        continue;
      }
      try
      {
        this.isNeedShow = false;
        paramBoolean1 = true;
        if (localBitmap == null) {
          continue;
        }
        bool1 = paramBoolean1;
        if (localBitmap.isRecycled()) {
          continue;
        }
        bool1 = paramBoolean1;
        setIdleBitmap(localBitmap);
        bool1 = paramBoolean1;
        swapActiveBitmap();
        bool1 = paramBoolean1;
        setContentChanged(true);
        bool1 = paramBoolean1;
        this.loadImageSuccess = true;
        bool1 = paramBoolean1;
        this.firstDrew = true;
        this.isNeedShow = true;
        bool1 = true;
        BenchUtil.benchEnd("ImageUpdateBitmap");
        return bool1;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        bool1 = true;
        continue;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        paramBoolean1 = true;
        continue;
      }
      bool1 = bool4;
      if (this.isWM260)
      {
        bool1 = bool4;
        if (!this.curValue.equals(""))
        {
          bool1 = bool4;
          localBitmap = VideoMemoryManager.getInstance().loadWM260Image(this.itemId, this.curValue);
        }
        bool1 = bool4;
        if (BitmapUtils.isLegal(localBitmap)) {
          continue;
        }
        bool1 = bool4;
        if (this.firstDrew) {
          continue;
        }
        bool1 = bool4;
        if (this.curValue.equals("")) {
          continue;
        }
        bool1 = bool4;
        localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), this.dataPath + File.separator + this.itemId + File.separator + this.curValue, 1);
        break;
      }
      bool1 = bool4;
      if (!this.curValue.equals(""))
      {
        bool1 = bool4;
        localBitmap = VideoMemoryManager.getInstance().loadImage(this.itemId, this.curValue);
        continue;
        bool1 = paramBoolean1;
        str.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.ImageWMElement
 * JD-Core Version:    0.7.0.1
 */