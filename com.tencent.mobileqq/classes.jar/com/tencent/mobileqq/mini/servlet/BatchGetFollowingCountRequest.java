package com.tencent.mobileqq.mini.servlet;

import NS_FOLLOW.Follow.StBatchGetFollowingCountReq;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;

public class BatchGetFollowingCountRequest
  extends ProtoBufRequest
{
  public static final String APPID_SUFFIX = "|3";
  public static final String CMD_STRING = "LightAppSvc.follow_svr.BatchGetFollowingCount";
  private final Follow.StBatchGetFollowingCountReq req = new Follow.StBatchGetFollowingCountReq();
  
  public BatchGetFollowingCountRequest(List<String> paramList)
  {
    this.req.business.set("UserAppUse");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      PBRepeatField localPBRepeatField = this.req.followers;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("|3");
      localPBRepeatField.add(localStringBuilder.toString());
    }
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.BatchGetFollowingCountRequest
 * JD-Core Version:    0.7.0.1
 */