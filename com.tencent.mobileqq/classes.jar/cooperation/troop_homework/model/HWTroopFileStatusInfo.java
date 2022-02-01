package cooperation.troop_homework.model;

import bftf;
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
  
  public static HWTroopFileStatusInfo parse(bftf parambftf)
  {
    if (parambftf == null) {
      return null;
    }
    HWTroopFileStatusInfo localHWTroopFileStatusInfo = new HWTroopFileStatusInfo();
    localHWTroopFileStatusInfo.Id = parambftf.jdField_a_of_type_JavaUtilUUID;
    localHWTroopFileStatusInfo.SeqId = parambftf.jdField_a_of_type_Int;
    localHWTroopFileStatusInfo.uniseq = parambftf.jdField_a_of_type_Long;
    localHWTroopFileStatusInfo.TroopUin = parambftf.jdField_b_of_type_Long;
    localHWTroopFileStatusInfo.Status = parambftf.jdField_b_of_type_Int;
    localHWTroopFileStatusInfo.IsNewStatus = parambftf.jdField_a_of_type_Boolean;
    localHWTroopFileStatusInfo.ErrorCode = parambftf.jdField_c_of_type_Int;
    localHWTroopFileStatusInfo.UploadTime = parambftf.jdField_d_of_type_Int;
    localHWTroopFileStatusInfo.ProgressTotal = parambftf.jdField_c_of_type_Long;
    localHWTroopFileStatusInfo.ProgressValue = parambftf.jdField_d_of_type_Long;
    localHWTroopFileStatusInfo.LocalFile = parambftf.jdField_a_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Small = parambftf.jdField_b_of_type_JavaLangString;
    localHWTroopFileStatusInfo.ThumbnailFile_Large = parambftf.jdField_c_of_type_JavaLangString;
    localHWTroopFileStatusInfo.FilePath = parambftf.jdField_e_of_type_JavaLangString;
    localHWTroopFileStatusInfo.sha1 = parambftf.f;
    localHWTroopFileStatusInfo.FileName = parambftf.g;
    localHWTroopFileStatusInfo.BusId = parambftf.jdField_h_of_type_Int;
    localHWTroopFileStatusInfo.entrySessionID = parambftf.jdField_e_of_type_Long;
    localHWTroopFileStatusInfo.NickName = parambftf.jdField_h_of_type_JavaLangString;
    return localHWTroopFileStatusInfo;
  }
  
  public bftf toTroopFileStatusInfo()
  {
    bftf localbftf = new bftf();
    localbftf.jdField_a_of_type_JavaUtilUUID = this.Id;
    localbftf.jdField_a_of_type_Int = this.SeqId;
    localbftf.jdField_a_of_type_Long = this.uniseq;
    localbftf.jdField_b_of_type_Long = this.TroopUin;
    localbftf.jdField_b_of_type_Int = this.Status;
    localbftf.jdField_a_of_type_Boolean = this.IsNewStatus;
    localbftf.jdField_c_of_type_Int = this.ErrorCode;
    localbftf.jdField_d_of_type_Int = this.UploadTime;
    localbftf.jdField_c_of_type_Long = this.ProgressTotal;
    localbftf.jdField_d_of_type_Long = this.ProgressValue;
    localbftf.jdField_a_of_type_JavaLangString = this.LocalFile;
    localbftf.jdField_b_of_type_JavaLangString = this.ThumbnailFile_Small;
    localbftf.jdField_c_of_type_JavaLangString = this.ThumbnailFile_Large;
    localbftf.jdField_e_of_type_JavaLangString = this.FilePath;
    localbftf.f = this.sha1;
    localbftf.g = this.FileName;
    localbftf.jdField_h_of_type_Int = this.BusId;
    localbftf.jdField_e_of_type_Long = this.entrySessionID;
    localbftf.jdField_h_of_type_JavaLangString = this.NickName;
    return localbftf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.model.HWTroopFileStatusInfo
 * JD-Core Version:    0.7.0.1
 */