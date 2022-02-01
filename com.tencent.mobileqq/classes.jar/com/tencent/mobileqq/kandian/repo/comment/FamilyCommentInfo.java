package com.tencent.mobileqq.kandian.repo.comment;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.articlesummary.FamilyCommentInfo;

public class FamilyCommentInfo
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public static FamilyCommentInfo a(articlesummary.FamilyCommentInfo paramFamilyCommentInfo)
  {
    FamilyCommentInfo localFamilyCommentInfo = new FamilyCommentInfo();
    localFamilyCommentInfo.jdField_a_of_type_JavaLangString = paramFamilyCommentInfo.icon_url.get().toStringUtf8();
    localFamilyCommentInfo.jdField_b_of_type_JavaLangString = paramFamilyCommentInfo.jump_url.get().toStringUtf8();
    localFamilyCommentInfo.jdField_a_of_type_Int = paramFamilyCommentInfo.medal_urls_width.get();
    localFamilyCommentInfo.jdField_b_of_type_Int = paramFamilyCommentInfo.medal_urls_height.get();
    return localFamilyCommentInfo;
  }
  
  public FamilyCommentInfo a()
  {
    try
    {
      super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FamilyCommentInfo", 2, new Object[] { "Clone not support: ", localCloneNotSupportedException.toString() });
      }
    }
    FamilyCommentInfo localFamilyCommentInfo = new FamilyCommentInfo();
    localFamilyCommentInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localFamilyCommentInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localFamilyCommentInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localFamilyCommentInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    return localFamilyCommentInfo;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FamilyCommentInfo\n familyIconUrl ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n familyJumpUrl ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n width ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n height ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo
 * JD-Core Version:    0.7.0.1
 */