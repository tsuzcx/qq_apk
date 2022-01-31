package cooperation.troop_homework.model;

import bbpe;
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
  
  public static HWTroopFileStatusInfo parse(bbpe parambbpe)
  {
    if (parambbpe == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = parambbpe.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = parambbpe.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = parambbpe.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = parambbpe.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = parambbpe.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = parambbpe.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = parambbpe.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = parambbpe.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = parambbpe.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = parambbpe.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = parambbpe.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = parambbpe.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = parambbpe.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = parambbpe.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = parambbpe.f;
    localHWTroopFileStatusInfo.FileName = parambbpe.g;
    localHWTroopFileStatusInfo.BusId = parambbpe.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = parambbpe.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = parambbpe.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public bbpe toTroopFileStatusInfo()
  {
    bbpe localbbpe = new bbpe();
    localbbpe.jdField_a_of_type_JavaUtilUUID = this.Id;
    localbbpe.jdField_a_of_type_Int = this.SeqId;
    localbbpe.jdField_a_of_type_Long = this.uniseq;
    localbbpe.jdField_b_of_type_Long = this.TroopUin;
    localbbpe.jdField_b_of_type_Int = this.Status;
    localbbpe.jdField_a_of_type_Boolean = this.IsNewStatus;
    localbbpe.jdField_c_of_type_Int = this.ErrorCode;
    localbbpe.jdField_d_of_type_Int = this.UploadTime;
    localbbpe.jdField_c_of_type_Long = this.ProgressTotal;
    localbbpe.jdField_d_of_type_Long = this.ProgressValue;
    localbbpe.jdField_a_of_type_JavaLangString = this.LocalFile;
    localbbpe.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localbbpe.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localbbpe.jdField_e_of_type_JavaLangString = this.FilePath;
    localbbpe.f = this.sha1;
    localbbpe.g = this.FileName;
    localbbpe.jdField_h_of_type_Int = this.BusId;
    localbbpe.jdField_e_of_type_Long = this.entrySessionID;
    localbbpe.jdField_h_of_type_JavaLangString = this.NickName;
    return localbbpe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */