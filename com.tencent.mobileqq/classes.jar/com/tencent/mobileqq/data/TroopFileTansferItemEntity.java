package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.data.TroopFileInfo.FileStatus;
import java.util.UUID;

public class TroopFileTansferItemEntity
  extends Entity
{
  public int BusId;
  public int ErrorCode;
  public String FileName;
  public String FilePath;
  public int ForwardBusId;
  public String ForwardPath;
  public long ForwardTroopuin;
  public boolean HasThumbnailFile_Large;
  public boolean HasThumbnailFile_Middle;
  public boolean HasThumbnailFile_Small;
  public UUID Id;
  public String LocalFile;
  public byte[] Md5;
  public String NameForSave;
  public String NickName;
  public String PreviewUrl;
  public long ProgressTotal;
  public long ProgressValue;
  public int RandomNum;
  public int SafeCheckRes;
  public byte[] Sha;
  public int Status;
  public long ThumbnailFileTimeMS_Large;
  public long ThumbnailFileTimeMS_Middle;
  public long ThumbnailFileTimeMS_Small;
  public int UploadTime;
  public String _sId;
  public String _sStatus;
  public long entrySessionID;
  public boolean isFromAIO;
  public String mParentId;
  public long troopuin;
  
  protected Class getClassForTable()
  {
    return TroopFileTansferItemEntity.class;
  }
  
  public String getTableName()
  {
    return "TroopFileTansferItemEntity" + this.troopuin;
  }
  
  protected void postRead()
  {
    this.Status = TroopFileInfo.FileStatus.a(this._sStatus);
    this._sStatus = null;
    this.Id = UUID.fromString(this._sId);
    this._sId = null;
  }
  
  protected void prewrite()
  {
    this._sStatus = TroopFileInfo.FileStatus.a(this.Status);
    this._sId = this.Id.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopFileTansferItemEntity
 * JD-Core Version:    0.7.0.1
 */