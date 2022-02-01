import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;

public class qvz
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public static qvz a(articlesummary.FamilyCommentInfo paramFamilyCommentInfo)
  {
    qvz localqvz = new qvz();
    localqvz.jdField_a_of_type_JavaLangString = paramFamilyCommentInfo.icon_url.get().toStringUtf8();
    localqvz.jdField_b_of_type_JavaLangString = paramFamilyCommentInfo.jump_url.get().toStringUtf8();
    localqvz.jdField_a_of_type_Int = paramFamilyCommentInfo.medal_urls_width.get();
    localqvz.jdField_b_of_type_Int = paramFamilyCommentInfo.medal_urls_height.get();
    return localqvz;
  }
  
  public qvz a()
  {
    try
    {
      super.clone();
      qvz localqvz = new qvz();
      localqvz.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      localqvz.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localqvz.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localqvz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      return localqvz;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvz
 * JD-Core Version:    0.7.0.1
 */