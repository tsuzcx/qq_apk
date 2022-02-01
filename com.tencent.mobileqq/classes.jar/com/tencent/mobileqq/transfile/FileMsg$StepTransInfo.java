package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class FileMsg$StepTransInfo
  extends FileMsg.StepBaseInfo
{
  public String actualUrl;
  public long contentSize;
  public HashMap<String, String> extraInfo = new HashMap();
  public String firstIp;
  public long flowDown;
  public long flowUp;
  public int httpRespCode;
  public boolean isBigChannel;
  public boolean isStream;
  public String lastUseIp;
  public String respHeader;
  public boolean serverExist;
  
  public String toJson()
  {
    if (shouldReport())
    {
      long l1 = this.flowUp;
      long l2 = this.flowDown;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("result:" + this.result);
      localStringBuilder.append(",elapsed:" + getTimeElapsed());
      localStringBuilder.append(",errCode:" + this.errCode);
      localStringBuilder.append(",retryCount:" + this.retryCount);
      localStringBuilder.append(",flow:" + (l1 + l2));
      localStringBuilder.append(",isStream:" + this.isStream);
      localStringBuilder.append(",httpCode:" + this.httpRespCode);
      localStringBuilder.append(",serverExist:" + this.serverExist);
      localStringBuilder.append(",isBigChannel:" + this.isBigChannel);
      if (this.detailErrCode != 9223372036854775807L) {
        localStringBuilder.append(",detailError:" + this.detailErrCode);
      }
      localStringBuilder.append(",firstIp:" + this.firstIp);
      localStringBuilder.append(",lastUseIp:" + this.lastUseIp);
      localStringBuilder.append(",respHeader:" + this.respHeader);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
  
  public String toReportJson()
  {
    if (shouldReport())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("elapsed:" + getTimeElapsed());
      localStringBuilder.append(",tryCount:" + this.retryCount);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepTransInfo
 * JD-Core Version:    0.7.0.1
 */