package com.tencent.mobileqq.kandian.biz.comment.entity;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.AtData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.HerfData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RptData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.TextData;

public final class CreateCommentResult
{
  public int a;
  public long a;
  public String a;
  public List<BaseCommentData.CommentRptData> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public String d;
  
  @Nullable
  private static BaseCommentData.CommentRptData a(oidb_0xd1e.RptData paramRptData)
  {
    if (paramRptData.text_data.has())
    {
      paramRptData = (oidb_0xd1e.TextData)paramRptData.text_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 0;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private static void a(oidb_0xd1e.RptData paramRptData, List<BaseCommentData.CommentRptData> paramList)
  {
    int i = RIJPBFieldUtils.a(paramRptData.data_type, 0);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3) {
          paramRptData = null;
        } else {
          paramRptData = b(paramRptData);
        }
      }
      else {
        paramRptData = c(paramRptData);
      }
    }
    else {
      paramRptData = a(paramRptData);
    }
    if (paramRptData != null) {
      paramList.add(paramRptData);
    }
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData b(oidb_0xd1e.RptData paramRptData)
  {
    if (paramRptData.herf_data.has())
    {
      paramRptData = (oidb_0xd1e.HerfData)paramRptData.herf_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 3;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.url, "");
        localCommentRptData.d = RIJPBFieldUtils.a(paramRptData.topic_id, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData c(oidb_0xd1e.RptData paramRptData)
  {
    if (paramRptData.at_data.has())
    {
      paramRptData = (oidb_0xd1e.AtData)paramRptData.at_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 1;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.uid, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  public void a(Collection<oidb_0xd1e.RptData> paramCollection)
  {
    if (paramCollection != null)
    {
      if (paramCollection.isEmpty()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        oidb_0xd1e.RptData localRptData = (oidb_0xd1e.RptData)paramCollection.next();
        if (localRptData != null) {
          a(localRptData, this.jdField_a_of_type_JavaUtilList);
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CreateCommentResult{seq=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", success=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", commentType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", commentId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentJsonStr='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentContent='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedsType=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", isFeeds=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", commentRptDataList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult
 * JD-Core Version:    0.7.0.1
 */