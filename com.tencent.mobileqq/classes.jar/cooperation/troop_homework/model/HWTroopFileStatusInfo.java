package cooperation.troop_homework.model;

import azqv;
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
  
  public static HWTroopFileStatusInfo parse(azqv paramazqv)
  {
    if (paramazqv == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = paramazqv.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = paramazqv.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = paramazqv.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = paramazqv.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = paramazqv.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = paramazqv.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = paramazqv.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = paramazqv.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = paramazqv.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = paramazqv.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = paramazqv.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = paramazqv.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = paramazqv.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = paramazqv.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = paramazqv.f;
    localHWTroopFileStatusInfo.FileName = paramazqv.g;
    localHWTroopFileStatusInfo.BusId = paramazqv.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = paramazqv.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = paramazqv.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public azqv toTroopFileStatusInfo()
  {
    azqv localazqv = new azqv();
    localazqv.jdField_a_of_type_JavaUtilUUID = this.Id;
    localazqv.jdField_a_of_type_Int = this.SeqId;
    localazqv.jdField_a_of_type_Long = this.uniseq;
    localazqv.jdField_b_of_type_Long = this.TroopUin;
    localazqv.jdField_b_of_type_Int = this.Status;
    localazqv.jdField_a_of_type_Boolean = this.IsNewStatus;
    localazqv.jdField_c_of_type_Int = this.ErrorCode;
    localazqv.jdField_d_of_type_Int = this.UploadTime;
    localazqv.jdField_c_of_type_Long = this.ProgressTotal;
    localazqv.jdField_d_of_type_Long = this.ProgressValue;
    localazqv.jdField_a_of_type_JavaLangString = this.LocalFile;
    localazqv.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localazqv.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localazqv.jdField_e_of_type_JavaLangString = this.FilePath;
    localazqv.f = this.sha1;
    localazqv.g = this.FileName;
    localazqv.jdField_h_of_type_Int = this.BusId;
    localazqv.jdField_e_of_type_Long = this.entrySessionID;
    localazqv.jdField_h_of_type_JavaLangString = this.NickName;
    return localazqv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */