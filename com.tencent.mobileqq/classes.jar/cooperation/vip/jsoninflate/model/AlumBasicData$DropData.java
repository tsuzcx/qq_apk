package cooperation.vip.jsoninflate.model;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.vip.pb.vac_adv_get.DropList;

public class AlumBasicData$DropData
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public static DropData a(vac_adv_get.DropList paramDropList)
  {
    if (paramDropList == null) {
      return null;
    }
    DropData localDropData = new DropData();
    localDropData.jdField_a_of_type_Int = paramDropList.action_type.get();
    localDropData.b = paramDropList.optext.get();
    localDropData.jdField_a_of_type_JavaLangString = paramDropList.iconurl.get();
    localDropData.c = paramDropList.jumpurl.get();
    return localDropData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.AlumBasicData.DropData
 * JD-Core Version:    0.7.0.1
 */