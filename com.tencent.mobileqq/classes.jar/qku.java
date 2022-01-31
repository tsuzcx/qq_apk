import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;

public class qku
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public static qku a(articlesummary.FamilyCommentInfo paramFamilyCommentInfo)
  {
    qku localqku = new qku();
    localqku.jdField_a_of_type_JavaLangString = paramFamilyCommentInfo.icon_url.get().toStringUtf8();
    localqku.jdField_b_of_type_JavaLangString = paramFamilyCommentInfo.jump_url.get().toStringUtf8();
    localqku.jdField_a_of_type_Int = paramFamilyCommentInfo.medal_urls_width.get();
    localqku.jdField_b_of_type_Int = paramFamilyCommentInfo.medal_urls_height.get();
    return localqku;
  }
  
  public qku a()
  {
    try
    {
      super.clone();
      qku localqku = new qku();
      localqku.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localqku.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localqku.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localqku.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return localqku;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qku
 * JD-Core Version:    0.7.0.1
 */