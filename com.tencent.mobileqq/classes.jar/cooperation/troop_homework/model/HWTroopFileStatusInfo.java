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
    localHWTroopFileStatusInfo.Id = paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = paramTroopFileStatusInfo.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = paramTroopFileStatusInfo.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = paramTroopFileStatusInfo.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = paramTroopFileStatusInfo.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = paramTroopFileStatusInfo.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = paramTroopFileStatusInfo.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = paramTroopFileStatusInfo.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = paramTroopFileStatusInfo.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = paramTroopFileStatusInfo.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = paramTroopFileStatusInfo.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = paramTroopFileStatusInfo.f;
    localHWTroopFileStatusInfo.FileName = paramTroopFileStatusInfo.g;
    localHWTroopFileStatusInfo.BusId = paramTroopFileStatusInfo.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = paramTroopFileStatusInfo.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = paramTroopFileStatusInfo.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public TroopFileStatusInfo toTroopFileStatusInfo()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID = this.Id;
    localTroopFileStatusInfo.jdField_a_of_type_Int = this.SeqId;
    localTroopFileStatusInfo.jdField_a_of_type_Long = this.uniseq;
    localTroopFileStatusInfo.jdField_b_of_type_Long = this.TroopUin;
    localTroopFileStatusInfo.jdField_b_of_type_Int = this.Status;
    localTroopFileStatusInfo.jdField_a_of_type_Boolean = this.IsNewStatus;
    localTroopFileStatusInfo.jdField_c_of_type_Int = this.ErrorCode;
    localTroopFileStatusInfo.jdField_d_of_type_Int = this.UploadTime;
    localTroopFileStatusInfo.jdField_c_of_type_Long = this.ProgressTotal;
    localTroopFileStatusInfo.jdField_d_of_type_Long = this.ProgressValue;
    localTroopFileStatusInfo.jdField_a_of_type_JavaLangString = this.LocalFile;
    localTroopFileStatusInfo.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localTroopFileStatusInfo.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localTroopFileStatusInfo.jdField_e_of_type_JavaLangString = this.FilePath;
    localTroopFileStatusInfo.f = this.sha1;
    localTroopFileStatusInfo.g = this.FileName;
    localTroopFileStatusInfo.jdField_h_of_type_Int = this.BusId;
    localTroopFileStatusInfo.jdField_e_of_type_Long = this.entrySessionID;
    localTroopFileStatusInfo.jdField_h_of_type_JavaLangString = this.NickName;
    return localTroopFileStatusInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */