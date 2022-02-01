package cooperation.troop_homework.model;

import becp;
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
  
  public static HWTroopFileStatusInfo parse(becp parambecp)
  {
    if (parambecp == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = parambecp.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = parambecp.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = parambecp.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = parambecp.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = parambecp.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = parambecp.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = parambecp.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = parambecp.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = parambecp.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = parambecp.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = parambecp.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = parambecp.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = parambecp.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = parambecp.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = parambecp.f;
    localHWTroopFileStatusInfo.FileName = parambecp.g;
    localHWTroopFileStatusInfo.BusId = parambecp.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = parambecp.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = parambecp.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public becp toTroopFileStatusInfo()
  {
    becp localbecp = new becp();
    localbecp.jdField_a_of_type_JavaUtilUUID = this.Id;
    localbecp.jdField_a_of_type_Int = this.SeqId;
    localbecp.jdField_a_of_type_Long = this.uniseq;
    localbecp.jdField_b_of_type_Long = this.TroopUin;
    localbecp.jdField_b_of_type_Int = this.Status;
    localbecp.jdField_a_of_type_Boolean = this.IsNewStatus;
    localbecp.jdField_c_of_type_Int = this.ErrorCode;
    localbecp.jdField_d_of_type_Int = this.UploadTime;
    localbecp.jdField_c_of_type_Long = this.ProgressTotal;
    localbecp.jdField_d_of_type_Long = this.ProgressValue;
    localbecp.jdField_a_of_type_JavaLangString = this.LocalFile;
    localbecp.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localbecp.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localbecp.jdField_e_of_type_JavaLangString = this.FilePath;
    localbecp.f = this.sha1;
    localbecp.g = this.FileName;
    localbecp.jdField_h_of_type_Int = this.BusId;
    localbecp.jdField_e_of_type_Long = this.entrySessionID;
    localbecp.jdField_h_of_type_JavaLangString = this.NickName;
    return localbecp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */