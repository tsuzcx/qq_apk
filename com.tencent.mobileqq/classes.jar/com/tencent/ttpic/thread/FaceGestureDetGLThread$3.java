package com.tencent.ttpic.thread;

import android.graphics.PointF;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FaceGestureDetGLThread$3
  implements Runnable
{
  FaceGestureDetGLThread$3(FaceGestureDetGLThread paramFaceGestureDetGLThread, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = FaceGestureDetGLThread.access$100(this.this$0).getAllFaces();
    if ((localObject == null) || (((List)localObject).size() <= 0) || (((List)((List)localObject).get(0)).size() <= 0))
    {
      FaceGestureDetGLThread.access$600(this.this$0);
      return;
    }
    localObject = new ArrayList((Collection)((List)localObject).get(0));
    int i = (int)((PointF)((List)localObject).get(4)).x;
    int j = (int)((PointF)((List)localObject).get(14)).x;
    int k = (int)((PointF)((List)localObject).get(0)).y;
    int m = (int)((PointF)((List)localObject).get(3)).y;
    FaceGestureDetGLThread.access$800(this.this$0, i, j, k, m, this.val$width, this.val$height, FaceGestureDetGLThread.access$700(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread.3
 * JD-Core Version:    0.7.0.1
 */