package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

public class TroopNickNameBusiness
  extends QQVasUpdateBusiness
{
  public static TroopNickNameBusiness.Config a(String paramString)
  {
    paramString = new File(paramString, "config.json");
    if (paramString.exists()) {
      try
      {
        paramString = (TroopNickNameBusiness.Config)JSONConverter.a(FileUtils.readFileToString(paramString), TroopNickNameBusiness.Config.class);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  protected String a()
  {
    return "troopnick";
  }
  
  public void a(int paramInt)
  {
    startDownload(a(paramInt));
  }
  
  protected String b()
  {
    return "newgroupnick.android.";
  }
  
  public long getBid()
  {
    return 50L;
  }
  
  public String getFrom()
  {
    return "newgroupnick";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness
 * JD-Core Version:    0.7.0.1
 */