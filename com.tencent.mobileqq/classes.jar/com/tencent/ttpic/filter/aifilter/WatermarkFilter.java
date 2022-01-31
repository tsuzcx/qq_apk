package com.tencent.ttpic.filter.aifilter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.WMElement;
import com.tencent.ttpic.openapi.model.WMElementConfig;
import com.tencent.ttpic.openapi.model.WMElementFactory;
import com.tencent.ttpic.openapi.model.WMGroupConfig;
import java.util.List;

public class WatermarkFilter
  extends BaseFilter
{
  private VideoMaterial waterMaterial;
  
  public WatermarkFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int i = 0;
    Object localObject2;
    for (Object localObject1 = this; i < this.waterMaterial.getItemList().size(); localObject1 = localObject2)
    {
      StickerItem localStickerItem = (StickerItem)this.waterMaterial.getItemList().get(i);
      localObject2 = localObject1;
      if (localStickerItem.wmGroupConfig != null)
      {
        localObject2 = localObject1;
        if (localStickerItem.wmGroupConfig.wmElementConfigs != null)
        {
          localObject2 = localObject1;
          if (localStickerItem.wmGroupConfig.wmElementConfigs.size() > 0)
          {
            int j = 0;
            while (j < localStickerItem.wmGroupConfig.wmElementConfigs.size())
            {
              WMElement localWMElement = WMElementFactory.createWMElement((WMElementConfig)localStickerItem.wmGroupConfig.wmElementConfigs.get(j));
              localWMElement.updateBitmap(0L, true, true);
              Bitmap localBitmap = localWMElement.getBitmap();
              localObject2 = new VideoCameraBlendFilter();
              ((VideoCameraBlendFilter)localObject2).addParam(new UniformParam.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
              ((VideoCameraBlendFilter)localObject2).addParam(new UniformParam.IntParam("blendMode", localStickerItem.blendMode));
              ((VideoCameraBlendFilter)localObject2).setTop(localWMElement.offsetX / 1000.0F, localWMElement.offsetY / 1000.0F);
              float f = localWMElement.offsetX / 1000.0F;
              int k = localWMElement.offsetY;
              ((VideoCameraBlendFilter)localObject2).setBottom(f, (localWMElement.height + k) / 1000.0F);
              ((VideoCameraBlendFilter)localObject2).setPicRatio(localBitmap.getWidth() / localBitmap.getHeight());
              ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
              j += 1;
              localObject1 = localObject2;
            }
            localObject2 = localObject1;
          }
        }
      }
      i += 1;
    }
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setWatermarkMaterial(VideoMaterial paramVideoMaterial)
  {
    this.waterMaterial = paramVideoMaterial;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.WatermarkFilter
 * JD-Core Version:    0.7.0.1
 */