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
      if (paramString.length >= 14) {
        this.fowardOrgUin = paramString[13];
      }
      if (paramString.length < 15) {}
    }
    catch (Exception localException3)
    {
      try
      {
        this.fowardOrgUinType = Integer.parseInt(paramString[14]);
        if (paramString.length < 16) {}
      }
      catch (Exception localException3)
      {
        try
        {
          this.fowardOrgUrl = paramString[15];
          if (paramString.length < 17) {}
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              this.fowardThumbPath = paramString[16];
              if (paramString.length >= 18) {}
              try
              {
                this.fowardOrgFileSizeType = Integer.parseInt(paramString[17]);
                return;
              }
              catch (Exception paramString)
              {
                this.fowardOrgFileSizeType = -1;
              }
              localException1 = localException1;
              this.fowardOrgId = -1L;
              continue;
              localException2 = localException2;
              this.fowardOrgUinType = -1;
            }
            localException3 = localException3;
            this.fowardOrgUrl = null;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              this.fowardThumbPath = null;
            }
          }
        }
      }
    }
  }
  
  public String toExtraString()
  {
    String str = null + this.fowardOrgId;
    str = str + "|";
    str = str + this.fowardOrgUin;
    str = str + "|";
    str = str + this.fowardOrgUinType;
    str = str + "|";
    str = str + this.fowardOrgUrl;
    str = str + "|";
    str = str + this.fowardThumbPath;
    str = str + "|";
    return str + this.fowardOrgFileSizeType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.PicFowardDbRecordData
 * JD-Core Version:    0.7.0.1
 */