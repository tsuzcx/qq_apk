package dov.com.qq.im.ae.gif.video;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.Builder;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.Util;
import dov.com.qq.im.ae.gif.filter.GifFilterProcess;
import java.util.LinkedList;
import java.util.List;

class PngsCreator$DecodeFrameListener
  implements SurfaceTexture.OnFrameAvailableListener
{
  PngsCreator$DecodeFrameListener(PngsCreator paramPngsCreator) {}
  
  private PTFaceAttr a(PTFaceAttr paramPTFaceAttr)
  {
    if (paramPTFaceAttr == null) {
      return null;
    }
    return new PTFaceAttr(new PTFaceAttr.Builder().facePoints(a(paramPTFaceAttr.getAllFacePoints())).facePoint94(a(paramPTFaceAttr.getAllFacePoints94())).faceAngles(b(paramPTFaceAttr.getAllFaceAngles())).faceDetectScale(paramPTFaceAttr.getFaceDetectScale()));
  }
  
  private List<List<PointF>> a(List<List<PointF>> paramList)
  {
    LinkedList localLinkedList1 = new LinkedList();
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      List localList = (List)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int m = localList.size();
      int j = 0;
      while (j < m)
      {
        PointF localPointF = (PointF)localList.get(j);
        localLinkedList2.add(new PointF(localPointF.x, localPointF.y));
        j += 1;
      }
      localLinkedList1.add(localLinkedList2);
      i += 1;
    }
    return localLinkedList1;
  }
  
  private List<float[]> b(List<float[]> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      float[] arrayOfFloat1 = (float[])paramList.get(i);
      float[] arrayOfFloat2 = new float[arrayOfFloat1.length];
      int j = 0;
      while (j < arrayOfFloat1.length)
      {
        arrayOfFloat2[j] = arrayOfFloat1[j];
        j += 1;
      }
      localLinkedList.add(arrayOfFloat2);
      i += 1;
    }
    return localLinkedList;
  }
  
  @TargetApi(19)
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(PngsCreator.a(), 4, "PngsCreator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    PngsCreator.a(this.a).RenderProcess(PngsCreator.a(this.a), 960, 480, -1, 0.0D, PngsCreator.a(this.a));
    GifFilterProcess localGifFilterProcess = PngsCreator.a(this.a);
    Frame localFrame = PngsCreator.a(this.a);
    if (PngsCreator.b(this.a) < PngsCreator.a(this.a).size()) {}
    for (paramSurfaceTexture = a((PTFaceAttr)PngsCreator.a(this.a).get(PngsCreator.b(this.a)));; paramSurfaceTexture = new PTFaceAttr(new PTFaceAttr.Builder()))
    {
      paramSurfaceTexture = RendererUtils.saveTexture(localGifFilterProcess.a(localFrame, 480, 480, paramSurfaceTexture));
      paramSurfaceTexture.setPremultiplied(false);
      Util.a(String.format(PngsCreator.a(this.a) + "/frame_%03d.png", new Object[] { Integer.valueOf(PngsCreator.b(this.a)) }), paramSurfaceTexture);
      paramSurfaceTexture.recycle();
      PngsCreator.c(this.a);
      if (!PngsCreator.a(this.a).a())
      {
        QLog.d(PngsCreator.a(), 4, "pngs create duration = " + (System.currentTimeMillis() - PngsCreator.a(this.a)));
        PngsCreator.a(this.a).a(PngsCreator.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.video.PngsCreator.DecodeFrameListener
 * JD-Core Version:    0.7.0.1
 */