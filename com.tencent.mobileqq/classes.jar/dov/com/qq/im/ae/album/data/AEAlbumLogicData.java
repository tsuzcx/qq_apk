package dov.com.qq.im.ae.album.data;

import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import java.io.Serializable;

public class AEAlbumLogicData
  implements OtherCommonData, Serializable
{
  public boolean canMixPhotoAndVideo;
  public boolean canPickVideo;
  public boolean canSwitchSelectionMode;
  public int initialHasPickedNum;
  public int maxSelectNumForMix;
  public int maxSelectNumForNormal;
  public int minSelectNumForMix;
  public int minSelectNumForNormal;
  
  public String toString()
  {
    return "AEAlbumLogicData{canMixPhotoAndVideo=" + this.canMixPhotoAndVideo + ", minSelectNumForNormal=" + this.minSelectNumForNormal + ", maxSelectNumForNormal=" + this.maxSelectNumForNormal + ", minSelectNumForMix=" + this.minSelectNumForMix + ", maxSelectNumForMix=" + this.maxSelectNumForMix + ", canSwitchSelectionMode=" + this.canSwitchSelectionMode + ", initialHasPickedNum=" + this.initialHasPickedNum + ", canPickVideo=" + this.canPickVideo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.data.AEAlbumLogicData
 * JD-Core Version:    0.7.0.1
 */