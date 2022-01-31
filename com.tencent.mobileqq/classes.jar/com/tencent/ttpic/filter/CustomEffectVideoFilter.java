package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoUtil;
import java.io.File;
import java.util.List;

public class CustomEffectVideoFilter
  extends VideoEffectFilterBase
{
  private static final String TAG = CustomVideoFilter.class.getSimpleName();
  private List<String> mResourceList;
  
  public CustomEffectVideoFilter(String paramString1, String paramString2, List<String> paramList, String paramString3, VideoFilterEffect paramVideoFilterEffect)
  {
    super(paramString1, paramString2, paramVideoFilterEffect);
    this.dataPath = paramString3;
    this.mResourceList = paramList;
    initInputImageTexture();
  }
  
  public void initInputImageTexture()
  {
    if (VideoUtil.isEmpty(this.mResourceList)) {
      return;
    }
    int i = 0;
    label13:
    Object localObject;
    if (i < this.mResourceList.size())
    {
      localObject = (String)this.mResourceList.get(i);
      localObject = this.dataPath + File.separator + (String)localObject;
      if (!((String)localObject).startsWith("assets://")) {
        break label108;
      }
      localObject = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      label94:
      if (VideoBitmapUtil.isLegal((Bitmap)localObject)) {
        break label122;
      }
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label108:
      localObject = VideoBitmapUtil.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      break label94;
      label122:
      addParam(new Param.TextureBitmapParam("inputImageTexture" + (i + 2), (Bitmap)localObject, 33986 + i, true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.CustomEffectVideoFilter
 * JD-Core Version:    0.7.0.1
 */