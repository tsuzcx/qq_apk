import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;

public class ppe
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public static ppe a(articlesummary.FamilyCommentInfo paramFamilyCommentInfo)
  {
    ppe localppe = new ppe();
    localppe.jdField_a_of_type_JavaLangString = paramFamilyCommentInfo.icon_url.get().toStringUtf8();
    localppe.jdField_b_of_type_JavaLangString = paramFamilyCommentInfo.jump_url.get().toStringUtf8();
    localppe.jdField_a_of_type_Int = paramFamilyCommentInfo.medal_urls_width.get();
    localppe.jdField_b_of_type_Int = paramFamilyCommentInfo.medal_urls_height.get();
    return localppe;
  }
  
  public ppe a()
  {
    try
    {
      super.clone();
      ppe localppe = new ppe();
      localppe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localppe.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localppe.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localppe.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return localppe;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FamilyCommentInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
        }
      }
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
  }
  
  public String toString()
  {
    return "FamilyCommentInfo\n familyIconUrl " + this.jdField_a_of_type_JavaLangString + "\n familyJumpUrl " + this.jdField_b_of_type_JavaLangString + "\n width " + this.jdField_a_of_type_Int + "\n height " + this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ppe
 * JD-Core Version:    0.7.0.1
 */