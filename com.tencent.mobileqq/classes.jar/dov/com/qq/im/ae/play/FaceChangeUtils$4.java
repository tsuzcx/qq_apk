package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import bolh;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.LinkedList;
import java.util.List;

final class FaceChangeUtils$4
  implements Runnable
{
  FaceChangeUtils$4(PTFaceAttr[] paramArrayOfPTFaceAttr, Bitmap paramBitmap, bolh parambolh) {}
  
  public void run()
  {
    this.val$faceAttrArr[0] = FaceChangeUtils.detectFace(this.val$bitmap);
    if (FaceChangeUtils.hasValidFace(this.val$faceAttrArr[0]))
    {
      List localList = FaceChangeUtils.getMaxFacePoints(this.val$faceAttrArr[0].getAllFacePoints(), this.val$faceAttrArr[0].getFaceDetectScale());
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localList.get(0));
      localLinkedList.add(localList.get(87));
      localLinkedList.add(localList.get(18));
      localLinkedList.add(localList.get(9));
      this.val$resultPair.a = Integer.valueOf(1);
      this.val$resultPair.b = localLinkedList;
      return;
    }
    this.val$resultPair.a = Integer.valueOf(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.4
 * JD-Core Version:    0.7.0.1
 */