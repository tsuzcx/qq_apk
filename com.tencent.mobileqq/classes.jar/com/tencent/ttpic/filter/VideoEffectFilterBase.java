package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.ttpic.face.Face;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.VideoFilterEffect;
import java.util.List;
import java.util.Map;

public class VideoEffectFilterBase
  extends VideoFilterBase
{
  private static final String TAG = VideoEffectFilterBase.class.getSimpleName();
  protected VideoFilterEffect mVideoFilterEffect;
  
  public VideoEffectFilterBase(String paramString1, String paramString2, VideoFilterEffect paramVideoFilterEffect)
  {
    super(paramString1, paramString2, null);
    this.mVideoFilterEffect = paramVideoFilterEffect;
    setDrawPartial(true);
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    setTexCords(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F });
  }
  
  public void initParams() {}
  
  public boolean shouldRender(int paramInt1, int paramInt2, List<Face> paramList)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramInt1 == -1) || (paramInt2 == 0) || (paramList == null) || (paramList.isEmpty())) {
      bool1 = true;
    }
    while (this.mVideoFilterEffect == null) {
      return bool1;
    }
    switch (this.mVideoFilterEffect.order)
    {
    default: 
      return false;
    case 1: 
      if (paramInt1 == ((Face)paramList.get(0)).faceIndex) {}
      for (bool1 = true;; bool1 = false) {
        return bool1;
      }
    }
    if (paramInt1 == ((Face)paramList.get(paramList.size() - 1)).faceIndex) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public void updatePreview(List<PointF> paramList, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, float paramFloat, long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.VideoEffectFilterBase
 * JD-Core Version:    0.7.0.1
 */