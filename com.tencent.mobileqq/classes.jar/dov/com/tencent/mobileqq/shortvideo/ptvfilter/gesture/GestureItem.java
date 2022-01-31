package dov.com.tencent.mobileqq.shortvideo.ptvfilter.gesture;

import com.tencent.ttpic.model.StickerItem;
import java.util.Arrays;

public class GestureItem
  extends StickerItem
{
  public int a;
  
  public String toString()
  {
    return "StickerItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", triggerType=" + this.triggerType + ", alwaysTriggered=" + this.alwaysTriggered + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + ", anchorPoint=" + Arrays.toString(this.anchorPoint) + ", alignFacePoints=" + Arrays.toString(this.alignFacePoints) + ", scalePivots=" + Arrays.toString(this.scalePivots) + ", scaleFactor=" + this.scaleFactor + ", support3D=" + this.support3D + ", count=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureItem
 * JD-Core Version:    0.7.0.1
 */