package com.tencent.mobileqq.filemanager.fileassistant.data;

import java.io.Serializable;

public class DatalineFileData
  implements Serializable
{
  public long associatedId;
  public int deviceType;
  public String filename;
  public long filesize;
  public int groupId;
  public int groupIndex;
  public int groupSize;
  public boolean issuc;
  public String localPath;
  public byte[] md5;
  public float progress;
  public String serverPath;
  public long sessionid;
  public String thumbPath;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.data.DatalineFileData
 * JD-Core Version:    0.7.0.1
 */