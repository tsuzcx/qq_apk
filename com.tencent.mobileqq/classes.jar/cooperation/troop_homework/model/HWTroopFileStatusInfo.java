package cooperation.troop_homework.model;

import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import java.io.Serializable;
import java.util.UUID;

public class HWTroopFileStatusInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public int BusId;
  public int ErrorCode;
  public String FileName;
  public String FilePath;
  public UUID Id;
  public boolean IsNewStatus;
  public String LocalFile;
  public String NickName;
  public long ProgressTotal;
  public long ProgressValue;
  public int SeqId;
  public int Status;
  public String ThumbnailFile_Large;
  public String ThumbnailFile_Small;
  public long TroopUin;
  public int UploadTime;
  public long entrySessionID;
  public String sha1;
  public long uniseq;
  
  public static HWTroopFileStatusInfo parse(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (paramTroopFileStatusInfo == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = paramTroopFileStatusInfo.a;
    localHWTroopFileStatusInfo.SeqId = paramTroopFileStatusInfo.b;
    localHWTroopFileStatusInfo.uniseq = paramTroopFileStatusInfo.c;
    localHWTroopFileStatusInfo.TroopUin = paramTroopFileStatusInfo.d;
    localHWTroopFileStatusInfo.Status = paramTroopFileStatusInfo.e;
    localHWTroopFileStatusInfo.IsNewStatus = paramTroopFileStatusInfo.f;
    localHWTroopFileStatusInfo.ErrorCode = paramTroopFileStatusInfo.g;
    localHWTroopFileStatusInfo.UploadTime = paramTroopFileStatusInfo.h;
    localHWTroopFileStatusInfo.ProgressTotal = paramTroopFileStatusInfo.i;
    localHWTroopFileStatusInfo.ProgressValue = paramTroopFileStatusInfo.j;
    localHWTroopFileStatusInfo.LocalFile = paramTroopFileStatusInfo.k;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = paramTroopFileStatusInfo.l;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = paramTroopFileStatusInfo.m;
    localHWTroopFileStatusInfo.FilePath = paramTroopFileStatusInfo.r;
    localHWTroopFileStatusInfo.sha1 = paramTroopFileStatusInfo.s;
    localHWTroopFileStatusInfo.FileName = paramTroopFileStatusInfo.t;
    localHWTroopFileStatusInfo.BusId = paramTroopFileStatusInfo.u;
    localHWTroopFileStatusInfo.entrySessionID = paramTroopFileStatusInfo.v;
    localHWTroopFileStatusInfo.NickName = paramTroopFileStatusInfo.w;
    return localHWTroopFileStatusInfo;
  }
  
  public TroopFileStatusInfo toTroopFileStatusInfo()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.a = this.Id;
    localTroopFileStatusInfo.b = this.SeqId;
    localTroopFileStatusInfo.c = this.uniseq;
    localTroopFileStatusInfo.d = this.TroopUin;
    localTroopFileStatusInfo.e = this.Status;
    localTroopFileStatusInfo.f = this.IsNewStatus;
    localTroopFileStatusInfo.g = this.ErrorCode;
    localTroopFileStatusInfo.h = this.UploadTime;
    localTroopFileStatusInfo.i = this.ProgressTotal;
    localTroopFileStatusInfo.j = this.ProgressValue;
    localTroopFileStatusInfo.k = this.LocalFile;
    localTroopFileStatusInfo.l = this.ThumbnailFile_Small;
    localTroopFileStatusInfo.m = this.ThumbnailFile_Large;
    localTroopFileStatusInfo.r = this.FilePath;
    localTroopFileStatusInfo.s = this.sha1;
    localTroopFileStatusInfo.t = this.FileName;
    localTroopFileStatusInfo.u = this.BusId;
    localTroopFileStatusInfo.v = this.entrySessionID;
    localTroopFileStatusInfo.w = this.NickName;
    return localTroopFileStatusInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */