package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class FileMsg$StepTransInfo
  extends FileMsg.StepBaseInfo
{
  public String actualUrl;
  public long contentSize = 0L;
  public HashMap<String, String> extraInfo = new HashMap();
  public String firstIp;
  public long flowDown = 0L;
  public long flowUp = 0L;
  public int httpRespCode = 0;
  public boolean isBigChannel = false;
  public boolean isStream = false;
  public String lastUseIp;
  public String respHeader;
  public boolean serverExist = false;
  
  public String toJson()
  {
    if (shouldReport())
    {
      long l1 = this.flowUp;
      long l2 = this.flowDown;
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("result:");
      localStringBuilder2.append(this.result);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",elapsed:");
      localStringBuilder2.append(getTimeElapsed());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",errCode:");
      localStringBuilder2.append(this.errCode);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",retryCount:");
      localStringBuilder2.append(this.retryCount);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",flow:");
      localStringBuilder2.append(l1 + l2);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",isStream:");
      localStringBuilder2.append(this.isStream);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",httpCode:");
      localStringBuilder2.append(this.httpRespCode);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",serverExist:");
      localStringBuilder2.append(this.serverExist);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",isBigChannel:");
      localStringBuilder2.append(this.isBigChannel);
      localStringBuilder1.append(localStringBuilder2.toString());
      if (this.detailErrCode != 9223372036854775807L)
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(",detailError:");
        localStringBuilder2.append(this.detailErrCode);
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",firstIp:");
      localStringBuilder2.append(this.firstIp);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",lastUseIp:");
      localStringBuilder2.append(this.lastUseIp);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",respHeader:");
      localStringBuilder2.append(this.respHeader);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
    }
    return "{}";
  }
  
  public String toReportJson()
  {
    if (shouldReport())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("elapsed:");
      localStringBuilder2.append(getTimeElapsed());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(",tryCount:");
      localStringBuilder2.append(this.retryCount);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepTransInfo
 * JD-Core Version:    0.7.0.1
 */