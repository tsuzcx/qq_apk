package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.HairSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.List;

public class HairSegmentImpl
{
  private static final String TAG = HairSegmentImpl.class.getSimpleName();
  private static int[] maskYYOffset = { 0, 1, 1, 0, 0, -1, -1, 0 };
  private PointF anchor = new PointF(0.0F, 0.0F);
  private float angle = 0.0F;
  private int faceBright = 0;
  private int faceNumber = 0;
  private PTHairAttr hairAttr = new PTHairAttr();
  private int hairBright = 0;
  private PointF[] hairRect = { new PointF(0.0F, 0.0F), new PointF(0.0F, 1.0F), new PointF(1.0F, 0.0F), new PointF(1.0F, 1.0F) };
  private PointF jawPoint = new PointF(0.0F, 0.0F);
  private PointF[] maskYYAnchor = { new PointF(0.5F, 0.0F), new PointF(0.5F, 0.3F), new PointF(0.5F, 0.6F), new PointF(0.5F, 1.0F), new PointF(0.5F, 0.0F), new PointF(0.5F, 0.3F), new PointF(0.5F, 0.6F), new PointF(0.5F, 1.0F) };
  private float materialCrop;
  private Bitmap outBitmap = null;
  
  private PTHairAttr genSegAttr(Bitmap paramBitmap, int paramInt1, int paramInt2, PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2, float paramFloat)
  {
    this.hairAttr.setMaskBitmap(paramBitmap);
    this.hairAttr.setMaskFrame(null);
    this.hairAttr.setFaceBright(paramInt1);
    this.hairAttr.setHairBright(paramInt2);
    this.hairAttr.setHairRect(paramArrayOfPointF1);
    this.hairAttr.setMaskYYAnchor(paramArrayOfPointF2);
    this.hairAttr.setMaterialCrop(paramFloat);
    return this.hairAttr;
  }
  
  private PointF rotateCoordinate(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return new PointF((float)((paramFloat1 - paramFloat4) * Math.cos(paramFloat3) - (paramFloat2 - paramFloat5) * Math.sin(paramFloat3)), (float)((paramFloat2 - paramFloat5) * Math.cos(paramFloat3) + (paramFloat1 - paramFloat4) * Math.sin(paramFloat3)));
  }
  
  private void setHairRectAndColor(Bitmap paramBitmap1, Bitmap paramBitmap2, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2)
  {
    int i1 = paramBitmap2.getWidth();
    int n = paramBitmap2.getHeight();
    float f7 = i1 * 1.0F / paramInt1;
    float f8 = n * 1.0F / paramInt2;
    if (paramPTFaceAttr.getAllFacePoints().size() > 0)
    {
      this.angle = ((float[])paramPTFaceAttr.getAllFaceAngles().get(0))[2];
      this.anchor = ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(84));
      this.jawPoint = ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(9));
    }
    float f4 = paramInt1;
    float f3 = paramInt2;
    float f2 = 0.0F;
    float f1 = 0.0F;
    int i2 = paramBitmap2.getByteCount();
    Object localObject1 = ByteBuffer.allocate(i2);
    paramBitmap2.copyPixelsToBuffer((Buffer)localObject1);
    byte[] arrayOfByte = ((ByteBuffer)localObject1).array();
    int i3 = i2 / i1 / n;
    int i = 0;
    int j;
    label186:
    float f5;
    float f6;
    if (i < i1 - 4)
    {
      j = 0;
      if (j < n - 4)
      {
        if ((arrayOfByte[((j * i1 + i) * i3)] & 0xFF) <= 35) {
          break label2590;
        }
        paramBitmap2 = rotateCoordinate(i / f7, j / f8, this.angle, this.anchor.x, this.anchor.y);
        f4 = Math.min(f4, paramBitmap2.x);
        f3 = Math.min(f3, paramBitmap2.y);
        f5 = Math.max(f2, paramBitmap2.x);
        f6 = Math.max(f1, paramBitmap2.y);
        f1 = f4;
        f2 = f3;
        f3 = f5;
        f4 = f6;
      }
    }
    for (;;)
    {
      j += 4;
      f5 = f2;
      f6 = f1;
      f1 = f4;
      f2 = f3;
      f3 = f5;
      f4 = f6;
      break label186;
      i += 4;
      break;
      paramBitmap2 = rotateCoordinate(this.jawPoint.x, this.jawPoint.y, this.angle, this.anchor.x, this.anchor.y);
      f5 = Math.max(f1, paramBitmap2.y);
      float f9 = f2 - f4;
      f6 = f5 - f3;
      f1 = (float)(f4 - f9 * 0.05D);
      f2 = (float)(f2 + f9 * 0.05D);
      f3 = (float)(f3 - f6 * 0.05D);
      f4 = (float)(f5 + f6 * 0.05D);
      this.materialCrop = ((f2 - f1) / (f4 - f3));
      this.hairRect[0] = rotateCoordinate(f1, f3, -this.angle, 0.0F, 0.0F);
      this.hairRect[1] = rotateCoordinate(f1, f4, -this.angle, 0.0F, 0.0F);
      this.hairRect[2] = rotateCoordinate(f2, f3, -this.angle, 0.0F, 0.0F);
      this.hairRect[3] = rotateCoordinate(f2, f4, -this.angle, 0.0F, 0.0F);
      localObject1 = this.hairRect;
      j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        localObject2.x = (2.0F * (localObject2.x + this.anchor.x) / paramInt1 - 1.0F);
        localObject2.y = (2.0F * (localObject2.y + this.anchor.y) / paramInt2 - 1.0F);
        i += 1;
      }
      if (paramPTFaceAttr.getAllFacePoints().size() > 0)
      {
        i = ((int)Math.toDegrees(this.angle) + 405) % 360 / 90;
        f5 = this.jawPoint.x;
        localObject1 = rotateCoordinate(maskYYOffset[(i * 2)] + f5, this.jawPoint.y + maskYYOffset[(i * 2 + 1)], this.angle, this.anchor.x, this.anchor.y);
        f5 = (((PointF)localObject1).y - paramBitmap2.y) / (((PointF)localObject1).x - paramBitmap2.x);
        f6 = ((PointF)localObject1).y;
        f5 = Math.max(Math.min((((PointF)localObject1).x * f5 + (f4 - f6)) / f5, f2), f1);
        paramBitmap2 = rotateCoordinate(f5, f4, -this.angle, 0.0F, 0.0F);
        this.maskYYAnchor[3].x = (2.0F * (paramBitmap2.x + this.anchor.x) / paramInt1 - 1.0F);
        this.maskYYAnchor[3].y = ((paramBitmap2.y + this.anchor.y) * 2.0F / paramInt2 - 1.0F);
        paramBitmap2 = (PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(86);
        localObject1 = (PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(88);
        f6 = paramBitmap2.x;
        paramBitmap2 = rotateCoordinate(((PointF)localObject1).x * 0.5F + f6 * 0.5F, paramBitmap2.y * 0.5F + ((PointF)localObject1).y * 0.5F, this.angle, this.anchor.x, this.anchor.y);
        f6 = f3 / paramBitmap2.y;
        f6 = Math.max(Math.min(paramBitmap2.x * f6, f2), f1);
        paramBitmap2 = rotateCoordinate(f6, f3, -this.angle, 0.0F, 0.0F);
        this.maskYYAnchor[0].x = (2.0F * (paramBitmap2.x + this.anchor.x) / paramInt1 - 1.0F);
        this.maskYYAnchor[0].y = ((paramBitmap2.y + this.anchor.y) * 2.0F / paramInt2 - 1.0F);
        this.maskYYAnchor[1].x = (((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(84)).x * 2.0F / paramInt1 - 1.0F);
        this.maskYYAnchor[1].y = (((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(84)).y * 2.0F / paramInt2 - 1.0F);
        this.maskYYAnchor[2].x = (((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(85)).x * 2.0F / paramInt1 - 1.0F);
        this.maskYYAnchor[2].y = (((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(85)).y * 2.0F / paramInt2 - 1.0F);
        this.maskYYAnchor[4].x = ((f6 - f1) / (f2 - f1));
        this.maskYYAnchor[7].x = ((f5 - f1) / (f2 - f1));
        this.maskYYAnchor[5].x = (-f1 / (f2 - f1));
        this.maskYYAnchor[5].y = (-f3 / (f4 - f3));
        paramBitmap2 = rotateCoordinate(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(85)).x, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(85)).y, this.angle, this.anchor.x, this.anchor.y);
        this.maskYYAnchor[6].x = ((paramBitmap2.x - f1) / (f2 - f1));
        this.maskYYAnchor[6].y = ((paramBitmap2.y - f3) / (f4 - f3));
      }
      int k;
      int m;
      if ((paramPTFaceAttr.getAllFacePoints().size() != this.faceNumber) && (paramPTFaceAttr.getAllFacePoints().size() > 0))
      {
        localObject1 = Bitmap.createScaledBitmap(paramBitmap1, i1, n, false);
        paramBitmap2 = paramBitmap1;
        if (paramBitmap1 != localObject1)
        {
          paramBitmap1.recycle();
          paramBitmap2 = (Bitmap)localObject1;
        }
        paramBitmap1 = ByteBuffer.allocate(i2);
        paramBitmap2.copyPixelsToBuffer(paramBitmap1);
        paramBitmap1 = paramBitmap1.array();
        paramInt2 = 0;
        paramInt1 = 0;
        i = 0;
        while (i < i1)
        {
          j = 0;
          k = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = k;
          while (j < n)
          {
            m = paramInt2;
            k = paramInt1;
            if ((j * i1 + i) * i3 + 2 < i2)
            {
              m = paramInt2;
              k = paramInt1;
              if ((arrayOfByte[((j * i1 + i) * i3)] & 0xFF) > 35)
              {
                k = paramInt1 + Math.max(Math.max(paramBitmap1[((j * i1 + i) * i3)] & 0xFF, paramBitmap1[((j * i1 + i) * i3 + 1)] & 0xFF), paramBitmap1[((j * i1 + i) * i3 + 2)] & 0xFF);
                m = paramInt2 + 1;
              }
            }
            j += 15;
            paramInt2 = m;
            paramInt1 = k;
          }
          i += 15;
          j = paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = j;
        }
        j = 0;
        i = 0;
        paramBitmap2 = new int[4];
        Bitmap tmp1760_1759 = paramBitmap2;
        tmp1760_1759[0] = 0;
        Bitmap tmp1764_1760 = tmp1760_1759;
        tmp1764_1760[1] = 0;
        Bitmap tmp1768_1764 = tmp1764_1760;
        tmp1768_1764[2] = 0;
        Bitmap tmp1772_1768 = tmp1768_1764;
        tmp1772_1768[3] = 0;
        tmp1772_1768;
        k = ((int)Math.toDegrees(this.angle) + 360) % 360;
        if ((k < 45) || (k > 315) || ((k > 135) && (k < 225)))
        {
          paramBitmap2[0] = ((int)Math.max(Math.min(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(4)).x, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(14)).x) * f7, 0.0F));
          paramBitmap2[1] = ((int)Math.min(Math.max(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(4)).x, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(14)).x) * f7, i1));
          paramBitmap2[2] = ((int)Math.max(Math.min(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(0)).y, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(3)).y) * f8, 0.0F));
          paramBitmap2[3] = ((int)Math.min(Math.max(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(0)).y, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(3)).y) * f8, n));
          k = paramBitmap2[0];
          label2094:
          if (k >= paramBitmap2[1]) {
            break label2514;
          }
          m = paramBitmap2[2];
          label2107:
          if (m >= paramBitmap2[3]) {
            break label2504;
          }
          if ((m * i1 + k) * i3 + 2 >= i2) {
            break label2575;
          }
          j = Math.max(Math.max(paramBitmap1[((m * i1 + k) * i3)] & 0xFF, paramBitmap1[((m * i1 + k) * i3 + 1)] & 0xFF), paramBitmap1[((m * i1 + k) * i3 + 2)] & 0xFF) + j;
          n = i + 1;
          i = j;
          j = n;
        }
      }
      for (;;)
      {
        n = m + 10;
        m = i;
        i = j;
        j = m;
        m = n;
        break label2107;
        paramBitmap2[0] = ((int)Math.max(Math.min(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(0)).x, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(3)).x) * f7, 0.0F));
        paramBitmap2[1] = ((int)Math.min(Math.max(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(0)).x, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(3)).x) * f7, i1));
        paramBitmap2[2] = ((int)Math.max(Math.min(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(4)).y, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(14)).y) * f8, 0.0F));
        paramBitmap2[3] = ((int)Math.min(Math.max(((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(4)).y, ((PointF)((List)paramPTFaceAttr.getAllFacePoints().get(0)).get(14)).y) * f8, n));
        break;
        label2504:
        k += 10;
        break label2094;
        label2514:
        if (i > 0)
        {
          this.faceBright = (j / i);
          if (paramInt1 <= 0) {
            break label2566;
          }
        }
        label2566:
        for (this.hairBright = (paramInt2 / paramInt1);; this.hairBright = 65)
        {
          this.faceNumber = paramPTFaceAttr.getAllFacePoints().size();
          return;
          this.faceBright = 200;
          break;
        }
        label2575:
        n = j;
        j = i;
        i = n;
      }
      label2590:
      f5 = f3;
      f6 = f4;
      f4 = f1;
      f3 = f2;
      f2 = f5;
      f1 = f6;
    }
  }
  
  public void clearCache()
  {
    if (this.outBitmap != null)
    {
      this.outBitmap.recycle();
      this.outBitmap = null;
    }
  }
  
  public PTHairAttr detectFrame(Bitmap paramBitmap, PTFaceAttr paramPTFaceAttr, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((PTHairSegmenter.HAIR_SEGMENT.isFunctionReady()) && (BitmapUtils.isLegal(paramBitmap)))
    {
      this.outBitmap = PTHairSegmenter.HAIR_SEGMENT.forward(paramBitmap, (-paramInt3 + 360) % 360);
      if (this.outBitmap != null) {
        setHairRectAndColor(paramBitmap, this.outBitmap, paramPTFaceAttr, paramInt1, paramInt2);
      }
      paramBitmap.recycle();
    }
    return genSegAttr(this.outBitmap, this.faceBright, this.hairBright, this.hairRect, this.maskYYAnchor, this.materialCrop);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.HairSegmentImpl
 * JD-Core Version:    0.7.0.1
 */