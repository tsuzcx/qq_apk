import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

class pwd
{
  private List<oidb_cmd0x80a.AttributeList> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public pwd(List<oidb_cmd0x80a.AttributeList> paramList)
  {
    Object localObject;
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList = localObject;
    }
  }
  
  public List<oidb_cmd0x80a.AttributeList> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public pwd a(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.d("CommonAttrBulder", 1, "attr value is Empty ! id : " + paramInt + ", name : " + paramString1);
      return this;
    }
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(paramInt);
    localAttributeList.att_name.set(paramString1);
    localAttributeList.att_value.set(paramString2);
    this.jdField_a_of_type_JavaUtilList.add(localAttributeList);
    return this;
  }
  
  public pwd a(int paramInt, String paramString, boolean paramBoolean)
  {
    return a(paramInt, paramString, pwr.a(paramBoolean, "1", "0"));
  }
  
  public pwd a(oidb_cmd0x80a.AttributeList paramAttributeList)
  {
    if (paramAttributeList != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramAttributeList);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwd
 * JD-Core Version:    0.7.0.1
 */