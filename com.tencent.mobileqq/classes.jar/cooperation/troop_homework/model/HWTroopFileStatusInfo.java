package cooperation.troop_homework.model;

import azqt;
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
  
  public static HWTroopFileStatusInfo parse(azqt paramazqt)
  {
    if (paramazqt == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = paramazqt.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = paramazqt.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = paramazqt.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = paramazqt.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = paramazqt.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = paramazqt.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = paramazqt.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = paramazqt.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = paramazqt.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = paramazqt.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = paramazqt.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = paramazqt.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = paramazqt.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = paramazqt.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = paramazqt.f;
    localHWTroopFileStatusInfo.FileName = paramazqt.g;
    localHWTroopFileStatusInfo.BusId = paramazqt.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = paramazqt.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = paramazqt.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public azqt toTroopFileStatusInfo()
  {
    azqt localazqt = new azqt();
    localazqt.jdField_a_of_type_JavaUtilUUID = this.Id;
    localazqt.jdField_a_of_type_Int = this.SeqId;
    localazqt.jdField_a_of_type_Long = this.uniseq;
    localazqt.jdField_b_of_type_Long = this.TroopUin;
    localazqt.jdField_b_of_type_Int = this.Status;
    localazqt.jdField_a_of_type_Boolean = this.IsNewStatus;
    localazqt.jdField_c_of_type_Int = this.ErrorCode;
    localazqt.jdField_d_of_type_Int = this.UploadTime;
    localazqt.jdField_c_of_type_Long = this.ProgressTotal;
    localazqt.jdField_d_of_type_Long = this.ProgressValue;
    localazqt.jdField_a_of_type_JavaLangString = this.LocalFile;
    localazqt.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localazqt.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localazqt.jdField_e_of_type_JavaLangString = this.FilePath;
    localazqt.f = this.sha1;
    localazqt.g = this.FileName;
    localazqt.jdField_h_of_type_Int = this.BusId;
    localazqt.jdField_e_of_type_Long = this.entrySessionID;
    localazqt.jdField_h_of_type_JavaLangString = this.NickName;
    return localazqt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */