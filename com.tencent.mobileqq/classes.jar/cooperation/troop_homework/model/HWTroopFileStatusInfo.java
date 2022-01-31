package cooperation.troop_homework.model;

import bbtn;
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
  
  public static HWTroopFileStatusInfo parse(bbtn parambbtn)
  {
    if (parambbtn == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = parambbtn.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = parambbtn.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = parambbtn.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = parambbtn.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = parambbtn.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = parambbtn.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = parambbtn.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = parambbtn.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = parambbtn.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = parambbtn.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = parambbtn.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = parambbtn.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = parambbtn.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = parambbtn.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = parambbtn.f;
    localHWTroopFileStatusInfo.FileName = parambbtn.g;
    localHWTroopFileStatusInfo.BusId = parambbtn.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = parambbtn.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = parambbtn.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public bbtn toTroopFileStatusInfo()
  {
    bbtn localbbtn = new bbtn();
    localbbtn.jdField_a_of_type_JavaUtilUUID = this.Id;
    localbbtn.jdField_a_of_type_Int = this.SeqId;
    localbbtn.jdField_a_of_type_Long = this.uniseq;
    localbbtn.jdField_b_of_type_Long = this.TroopUin;
    localbbtn.jdField_b_of_type_Int = this.Status;
    localbbtn.jdField_a_of_type_Boolean = this.IsNewStatus;
    localbbtn.jdField_c_of_type_Int = this.ErrorCode;
    localbbtn.jdField_d_of_type_Int = this.UploadTime;
    localbbtn.jdField_c_of_type_Long = this.ProgressTotal;
    localbbtn.jdField_d_of_type_Long = this.ProgressValue;
    localbbtn.jdField_a_of_type_JavaLangString = this.LocalFile;
    localbbtn.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localbbtn.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localbbtn.jdField_e_of_type_JavaLangString = this.FilePath;
    localbbtn.f = this.sha1;
    localbbtn.g = this.FileName;
    localbbtn.jdField_h_of_type_Int = this.BusId;
    localbbtn.jdField_e_of_type_Long = this.entrySessionID;
    localbbtn.jdField_h_of_type_JavaLangString = this.NickName;
    return localbbtn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */