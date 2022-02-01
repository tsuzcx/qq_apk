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
  public long a;
  public boolean b;
  public int c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public boolean j;
  public List<BaseCommentData.CommentRptData> k;
  
  @Nullable
  private static BaseCommentData.CommentRptData a(oidb_0xd1e.RptData paramRptData)
  {
    if (paramRptData.text_data.has())
    {
      paramRptData = (oidb_0xd1e.TextData)paramRptData.text_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.a = 0;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private static void a(oidb_0xd1e.RptData paramRptData, List<BaseCommentData.CommentRptData> paramList)
  {
    int m = RIJPBFieldUtils.a(paramRptData.data_type, 0);
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 3) {
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
        localCommentRptData.a = 3;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.d = RIJPBFieldUtils.a(paramRptData.url, "");
        localCommentRptData.e = RIJPBFieldUtils.a(paramRptData.topic_id, "");
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
        localCommentRptData.a = 1;
        localCommentRptData.b = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.c = RIJPBFieldUtils.a(paramRptData.uid, "");
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
      this.k = new ArrayList(paramCollection.size());
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        oidb_0xd1e.RptData localRptData = (oidb_0xd1e.RptData)paramCollection.next();
        if (localRptData != null) {
          a(localRptData, this.k);
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CreateCommentResult{seq=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", success=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", commentType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", commentId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentJsonStr='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentContent='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareUrl='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedsType=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isFeeds=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", commentRptDataList=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult
 * JD-Core Version:    0.7.0.1
 */