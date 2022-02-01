package org.light.bean;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LightFaceData
{
  public int[] cameraSize = new int[2];
  public ByteBuffer imageByteBuffer;
  public byte[] imageData;
  public int[] imageSize = new int[2];
  public List<LightFaceFeature> mLightFaceFeatureList;
  public int[] renderSize = new int[2];
  
  public LightFaceData()
  {
    this.mLightFaceFeatureList = new ArrayList();
  }
  
  public LightFaceData(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    this.imageSize = paramArrayOfInt1;
    this.cameraSize = paramArrayOfInt2;
    this.renderSize = paramArrayOfInt3;
    revertFaceFeaturePoint();
  }
  
  public void revertFaceFeaturePoint()
  {
    if ((this.imageSize == null) || (this.mLightFaceFeatureList == null) || (this.mLightFaceFeatureList.size() == 0)) {
      return;
    }
    int j = this.imageSize[1];
    Iterator localIterator = this.mLightFaceFeatureList.iterator();
    while (localIterator.hasNext())
    {
      LightFaceFeature localLightFaceFeature = (LightFaceFeature)localIterator.next();
      if (localLightFaceFeature == null) {
        break;
      }
      int i = 1;
      while (i < localLightFaceFeature.facePoints.length)
      {
        localLightFaceFeature.facePoints[i] = (j - localLightFaceFeature.facePoints[i]);
        i += 2;
      }
      i = 1;
      while (i < localLightFaceFeature.faceFeaturePoints.length)
      {
        localLightFaceFeature.faceFeaturePoints[i] = (j - localLightFaceFeature.faceFeaturePoints[i]);
        i += 2;
      }
      i = 1;
      while (i < localLightFaceFeature.faceFeature256Points.length)
      {
        localLightFaceFeature.faceFeature256Points[i] = (j - localLightFaceFeature.faceFeature256Points[i]);
        i += 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.bean.LightFaceData
 * JD-Core Version:    0.7.0.1
 */