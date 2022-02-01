package cooperation.troop_homework.model;

import bfjs;
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
  
  public static HWTroopFileStatusInfo parse(bfjs parambfjs)
  {
    if (parambfjs == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = parambfjs.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = parambfjs.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = parambfjs.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = parambfjs.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = parambfjs.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = parambfjs.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = parambfjs.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = parambfjs.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = parambfjs.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = parambfjs.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = parambfjs.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = parambfjs.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = parambfjs.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = parambfjs.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = parambfjs.f;
    localHWTroopFileStatusInfo.FileName = parambfjs.g;
    localHWTroopFileStatusInfo.BusId = parambfjs.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = parambfjs.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = parambfjs.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public bfjs toTroopFileStatusInfo()
  {
    bfjs localbfjs = new bfjs();
    localbfjs.jdField_a_of_type_JavaUtilUUID = this.Id;
    localbfjs.jdField_a_of_type_Int = this.SeqId;
    localbfjs.jdField_a_of_type_Long = this.uniseq;
    localbfjs.jdField_b_of_type_Long = this.TroopUin;
    localbfjs.jdField_b_of_type_Int = this.Status;
    localbfjs.jdField_a_of_type_Boolean = this.IsNewStatus;
    localbfjs.jdField_c_of_type_Int = this.ErrorCode;
    localbfjs.jdField_d_of_type_Int = this.UploadTime;
    localbfjs.jdField_c_of_type_Long = this.ProgressTotal;
    localbfjs.jdField_d_of_type_Long = this.ProgressValue;
    localbfjs.jdField_a_of_type_JavaLangString = this.LocalFile;
    localbfjs.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localbfjs.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localbfjs.jdField_e_of_type_JavaLangString = this.FilePath;
    localbfjs.f = this.sha1;
    localbfjs.g = this.FileName;
    localbfjs.jdField_h_of_type_Int = this.BusId;
    localbfjs.jdField_e_of_type_Long = this.entrySessionID;
    localbfjs.jdField_h_of_type_JavaLangString = this.NickName;
    return localbfjs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */