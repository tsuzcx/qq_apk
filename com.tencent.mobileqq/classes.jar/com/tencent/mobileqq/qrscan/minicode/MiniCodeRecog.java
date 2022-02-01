package com.tencent.mobileqq.qrscan.minicode;

import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.Matrix;
import com.tencent.mobileqq.minicode.RecogProxy;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.List;

public class MiniCodeRecog
{
  private final String a = "MiniRecog.recog";
  private int b = -1;
  private TextureRender c;
  private long d = 0L;
  private boolean e = false;
  private RenderBuffer f;
  private MiniParam g;
  private float h;
  private float[] i;
  private final Object j = new Object();
  
  public MiniCodeRecog(MiniParam paramMiniParam)
  {
    this.g = paramMiniParam;
    this.i = new float[16];
    this.c = new TextureRender();
    this.b = GlUtil.a(paramMiniParam.c, paramMiniParam.b);
    this.f = new RenderBuffer(paramMiniParam.c, paramMiniParam.b);
    MiniCodeUtil.b(false);
    this.d = RecogProxy.QCodeInit(this.g.a, this.g.b, this.g.c, this.g.d, this.g.e, this.g.f, this.g.g, 0.35F);
    QLog.i("MiniRecog.recog", 1, String.format("RecogProxy.QCodeInit native_handler=0x%x", new Object[] { Long.valueOf(this.d) }));
    if (this.d != 0L) {
      MiniCodeUtil.c(false);
    }
    this.e = true;
  }
  
  private Rect a(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (paramInt1 > paramInt2) {
      k = 0;
    } else {
      k = 1;
    }
    float f1 = paramArrayOfFloat[k];
    float f2 = this.h;
    paramArrayOfFloat[k] = ((f1 - 0.5F) / f2 + 0.5F);
    k += 2;
    paramArrayOfFloat[k] = ((paramArrayOfFloat[k] - 0.5F) / f2 + 0.5F);
    f1 = paramArrayOfFloat[0];
    f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    paramArrayOfFloat[0] = (1.0F - (f1 - 0.02F) * 2.0F);
    paramArrayOfFloat[1] = ((f2 - 0.02F) * 2.0F - 1.0F);
    paramArrayOfFloat[2] = (1.0F - (f3 + 0.02F) * 2.0F);
    paramArrayOfFloat[3] = ((f4 + 0.02F) * 2.0F - 1.0F);
    int k = 0;
    while (k < 4)
    {
      if (paramArrayOfFloat[k] > 1.0F) {
        paramArrayOfFloat[k] = 1.0F;
      } else if (paramArrayOfFloat[k] < -1.0F) {
        paramArrayOfFloat[k] = -1.0F;
      }
      k += 1;
    }
    f2 = paramArrayOfFloat[0];
    f1 = paramInt2;
    paramInt2 = (int)(f2 * 0.5F * f1);
    k = (int)(paramArrayOfFloat[2] * 0.5F * f1);
    f2 = paramArrayOfFloat[1];
    f3 = paramInt1;
    int m = (int)(f2 * 0.5F * f3);
    int n = (int)(paramArrayOfFloat[3] * 0.5F * f3);
    int i1 = Math.abs(n - m);
    int i2 = Math.abs(k - paramInt2);
    paramInt1 = n;
    if (m < n) {
      paramInt1 = m;
    }
    if (paramInt2 <= k) {
      paramInt2 = k;
    }
    paramInt1 = (int)(paramInt1 + f3 * 0.5F);
    paramInt2 = (int)(f1 * 0.5F - paramInt2);
    paramArrayOfFloat = new Rect();
    paramArrayOfFloat.left = paramInt1;
    paramArrayOfFloat.top = paramInt2;
    paramArrayOfFloat.right = (paramInt1 + i1);
    paramArrayOfFloat.bottom = (paramInt2 + i2);
    return paramArrayOfFloat;
  }
  
  public List<AIRect> a(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    if (!this.e) {
      return null;
    }
    Matrix.setIdentityM(this.i, 0);
    if (paramInt2 > paramInt3)
    {
      this.h = (paramInt3 / paramInt2);
      Matrix.scaleM(this.i, 0, this.h, 1.0F, 1.0F);
    }
    else
    {
      this.h = (paramInt2 / paramInt3);
      Matrix.scaleM(this.i, 0, 1.0F, this.h, 1.0F);
    }
    Matrix.rotateM(this.i, 0, 180.0F, 1.0F, 0.0F, 0.0F);
    Matrix.rotateM(this.i, 0, -90.0F, 0.0F, 0.0F, 1.0F);
    this.f.setUserTextureId(this.b);
    this.f.bind();
    GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES31.glClear(16384);
    this.c.drawTexture(3553, paramInt1, null, this.i);
    this.f.unbind();
    GLES20.glFlush();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      synchronized (this.j)
      {
        if (this.d != 0L)
        {
          RecogProxy.QCodeProcess(this.d, this.b, 0);
          m = RecogProxy.getBoxCnt(this.d);
          int k = m;
          if (m < 4) {
            break label695;
          }
          k = 4;
          break label695;
          if (m < k)
          {
            localObject2 = new float[5];
            localObject2[0] = 0.0F;
            localObject2[1] = 0.0F;
            localObject2[2] = 0.0F;
            localObject2[3] = 0.0F;
            localObject2[4] = 0.0F;
            int n = RecogProxy.getBox(this.d, m, (float[])localObject2);
            int i1 = RecogProxy.getBoxType(this.d, m);
            if ((n < 0) || (i1 < 0)) {
              break label701;
            }
            if (QLog.isDevelopLevel()) {
              QLog.i("MiniRecog.recog", 2, String.format("debug_minicode_point=[%f,%f,%f,%f,%f,%d]", new Object[] { Float.valueOf(localObject2[0]), Float.valueOf(localObject2[1]), Float.valueOf(localObject2[2]), Float.valueOf(localObject2[3]), Float.valueOf(localObject2[4]), Integer.valueOf(i1) }));
            }
            localObject3 = a(paramInt2, paramInt3, (float[])localObject2);
            AIRect localAIRect = new AIRect();
            localAIRect.b.set((Rect)localObject3);
            localAIRect.a = i1;
            localAIRect.c = localObject2[4];
            localArrayList.add(localAIRect);
            break label701;
          }
        }
        if (paramBoolean)
        {
          Matrix.setIdentityM(this.i, 0);
          if (paramInt2 > paramInt3) {
            Matrix.scaleM(this.i, 0, this.h, 1.0F, 1.0F);
          } else {
            Matrix.scaleM(this.i, 0, 1.0F, this.h, 1.0F);
          }
          this.f.setUserTextureId(this.b);
          this.f.bind();
          GLES31.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
          GLES31.glClear(16384);
          this.c.drawTexture(3553, paramInt1, null, this.i);
          this.f.unbind();
          GLES20.glFlush();
        }
      }
      label695:
      int m = 0;
      continue;
      label701:
      m += 1;
    }
  }
  
  public boolean a()
  {
    return this.d != 0L;
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    int k = this.b;
    if (k >= 0)
    {
      GlUtils.a(k);
      this.b = -1;
    }
    localObject = this.f;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    if (this.d != 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.recog", 2, String.format("RecogProxy.QCodeDestroy native_handler=0x%x", new Object[] { Long.valueOf(this.d) }));
      }
      RecogProxy.QCodeDestroy(this.d);
      this.d = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.minicode.MiniCodeRecog
 * JD-Core Version:    0.7.0.1
 */