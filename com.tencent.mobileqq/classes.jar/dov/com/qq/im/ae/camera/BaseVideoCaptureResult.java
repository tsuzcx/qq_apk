package dov.com.qq.im.ae.camera;

import java.io.Serializable;

public class BaseVideoCaptureResult
  implements Serializable
{
  public static final int TYPE_MERGED = 1;
  public static final int TYPE_UNMERGED = 0;
  public String audioDataFilePath;
  public String bgmAudioDataFilePath;
  public int errorCode;
  public String mergedMp4FilePath;
  public int orientation;
  public int type;
  public int videoFrameCount = 0;
  public String videoMp4FilePath;
  
  public String toString()
  {
    return "VideoCaptureResult{type=" + this.type + ", errorCode=" + this.errorCode + ", mergedMp4FilePath='" + this.mergedMp4FilePath + '\'' + ", videoMp4FilePath='" + this.videoMp4FilePath + '\'' + ", audioDataFilePath='" + this.audioDataFilePath + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.BaseVideoCaptureResult
 * JD-Core Version:    0.7.0.1
 */