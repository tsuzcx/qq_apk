package com.tencent.mobileqq.transfile;

public class PicFowardDbRecordData
{
  public int fowardOrgFileSizeType;
  public long fowardOrgId;
  public String fowardOrgUin;
  public int fowardOrgUinType;
  public String fowardOrgUrl;
  public String fowardThumbPath;
  
  public void initFromMsg(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 12))
    {
      paramString = paramString.split("\\|");
      if ((paramString != null) && (paramString.length < 13)) {}
    }
    try
    {
      this.fowardOrgId = Long.parseLong(paramString[12]);
    }
    catch (Exception localException1)
    {
      label45:
      break label45;
    }
    this.fowardOrgId = -1L;
    if (paramString.length >= 14) {
      this.fowardOrgUin = paramString[13];
    }
    if (paramString.length >= 15) {}
    try
    {
      this.fowardOrgUinType = Integer.parseInt(paramString[14]);
    }
    catch (Exception localException2)
    {
      label88:
      break label88;
    }
    this.fowardOrgUinType = -1;
    if (paramString.length >= 16) {}
    label134:
    label158:
    try
    {
      this.fowardOrgUrl = paramString[15];
    }
    catch (Exception localException3)
    {
      label111:
      break label111;
    }
    this.fowardOrgUrl = null;
    if (paramString.length >= 17) {}
    try
    {
      this.fowardThumbPath = paramString[16];
    }
    catch (Exception localException4)
    {
      break label134;
    }
    this.fowardThumbPath = null;
    if (paramString.length >= 18) {}
    try
    {
      this.fowardOrgFileSizeType = Integer.parseInt(paramString[17]);
      return;
    }
    catch (Exception paramString)
    {
      break label158;
    }
    this.fowardOrgFileSizeType = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicFowardDbRecordData
 * JD-Core Version:    0.7.0.1
 */