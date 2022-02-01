package cooperation.troop_homework.model;

import bety;
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
  
  public static HWTroopFileStatusInfo parse(bety parambety)
  {
    if (parambety == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = parambety.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = parambety.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = parambety.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = parambety.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = parambety.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = parambety.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = parambety.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = parambety.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = parambety.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = parambety.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = parambety.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = parambety.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = parambety.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = parambety.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = parambety.f;
    localHWTroopFileStatusInfo.FileName = parambety.g;
    localHWTroopFileStatusInfo.BusId = parambety.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = parambety.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = parambety.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public bety toTroopFileStatusInfo()
  {
    bety localbety = new bety();
    localbety.jdField_a_of_type_JavaUtilUUID = this.Id;
    localbety.jdField_a_of_type_Int = this.SeqId;
    localbety.jdField_a_of_type_Long = this.uniseq;
    localbety.jdField_b_of_type_Long = this.TroopUin;
    localbety.jdField_b_of_type_Int = this.Status;
    localbety.jdField_a_of_type_Boolean = this.IsNewStatus;
    localbety.jdField_c_of_type_Int = this.ErrorCode;
    localbety.jdField_d_of_type_Int = this.UploadTime;
    localbety.jdField_c_of_type_Long = this.ProgressTotal;
    localbety.jdField_d_of_type_Long = this.ProgressValue;
    localbety.jdField_a_of_type_JavaLangString = this.LocalFile;
    localbety.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localbety.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localbety.jdField_e_of_type_JavaLangString = this.FilePath;
    localbety.f = this.sha1;
    localbety.g = this.FileName;
    localbety.jdField_h_of_type_Int = this.BusId;
    localbety.jdField_e_of_type_Long = this.entrySessionID;
    localbety.jdField_h_of_type_JavaLangString = this.NickName;
    return localbety;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */