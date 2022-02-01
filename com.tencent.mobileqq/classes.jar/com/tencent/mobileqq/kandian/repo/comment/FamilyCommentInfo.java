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
  public String a;
  public String b;
  public int c;
  public int d;
  
  public static FamilyCommentInfo a(articlesummary.FamilyCommentInfo paramFamilyCommentInfo)
  {
    FamilyCommentInfo localFamilyCommentInfo = new FamilyCommentInfo();
    localFamilyCommentInfo.a = paramFamilyCommentInfo.icon_url.get().toStringUtf8();
    localFamilyCommentInfo.b = paramFamilyCommentInfo.jump_url.get().toStringUtf8();
    localFamilyCommentInfo.c = paramFamilyCommentInfo.medal_urls_width.get();
    localFamilyCommentInfo.d = paramFamilyCommentInfo.medal_urls_height.get();
    return localFamilyCommentInfo;
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.a));
  }
  
  public FamilyCommentInfo b()
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
    localFamilyCommentInfo.a = this.a;
    localFamilyCommentInfo.b = this.b;
    localFamilyCommentInfo.d = this.d;
    localFamilyCommentInfo.c = this.c;
    return localFamilyCommentInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FamilyCommentInfo\n familyIconUrl ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n familyJumpUrl ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("\n width ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n height ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.FamilyCommentInfo
 * JD-Core Version:    0.7.0.1
 */