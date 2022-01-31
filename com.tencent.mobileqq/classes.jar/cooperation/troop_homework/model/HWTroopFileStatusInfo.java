package cooperation.troop_homework.model;

import ayqd;
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
  
  public static HWTroopFileStatusInfo parse(ayqd paramayqd)
  {
    if (paramayqd == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = paramayqd.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = paramayqd.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = paramayqd.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = paramayqd.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = paramayqd.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = paramayqd.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = paramayqd.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = paramayqd.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = paramayqd.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = paramayqd.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = paramayqd.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = paramayqd.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = paramayqd.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = paramayqd.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = paramayqd.f;
    localHWTroopFileStatusInfo.FileName = paramayqd.g;
    localHWTroopFileStatusInfo.BusId = paramayqd.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = paramayqd.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = paramayqd.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public ayqd toTroopFileStatusInfo()
  {
    ayqd localayqd = new ayqd();
    localayqd.jdField_a_of_type_JavaUtilUUID = this.Id;
    localayqd.jdField_a_of_type_Int = this.SeqId;
    localayqd.jdField_a_of_type_Long = this.uniseq;
    localayqd.jdField_b_of_type_Long = this.TroopUin;
    localayqd.jdField_b_of_type_Int = this.Status;
    localayqd.jdField_a_of_type_Boolean = this.IsNewStatus;
    localayqd.jdField_c_of_type_Int = this.ErrorCode;
    localayqd.jdField_d_of_type_Int = this.UploadTime;
    localayqd.jdField_c_of_type_Long = this.ProgressTotal;
    localayqd.jdField_d_of_type_Long = this.ProgressValue;
    localayqd.jdField_a_of_type_JavaLangString = this.LocalFile;
    localayqd.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localayqd.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localayqd.jdField_e_of_type_JavaLangString = this.FilePath;
    localayqd.f = this.sha1;
    localayqd.g = this.FileName;
    localayqd.jdField_h_of_type_Int = this.BusId;
    localayqd.jdField_e_of_type_Long = this.entrySessionID;
    localayqd.jdField_h_of_type_JavaLangString = this.NickName;
    return localayqd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */