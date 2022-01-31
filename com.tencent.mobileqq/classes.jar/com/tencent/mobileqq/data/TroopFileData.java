package com.tencent.mobileqq.data;

import auko;
import aumc;
import java.io.Serializable;

public class TroopFileData
  extends auko
  implements Serializable
{
  public static final long serialVersionUID = 0L;
  public String FromUin;
  public int bisID;
  public String dspFileName;
  public String dspFileSize;
  public int duration;
  public long entitySessionId;
  public String fileName;
  @aumc
  public String fileUrl;
  public int height;
  public long lastTime;
  public long lfileSize;
  public String sha1;
  public String uuid;
  public int width;
  
  public String toString()
  {
    return "TroopFileData{dspFileSize='" + this.dspFileSize + '\'' + ", dspFileName='" + this.dspFileName + '\'' + ", bisID=" + this.bisID + ", fileUrl='" + this.fileUrl + '\'' + ", fileName='" + this.fileName + '\'' + ", lfileSize=" + this.lfileSize + ", uuid='" + this.uuid + '\'' + ", FromUin='" + this.FromUin + '\'' + ", lastTime=" + this.lastTime + ", entitySessionId=" + this.entitySessionId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopFileData
 * JD-Core Version:    0.7.0.1
 */