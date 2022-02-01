package com.tencent.mobileqq.vas.updatesystem.business;

import avyx;
import bhuo;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;

public class TroopNickNameBusiness
  extends bhuo
{
  public static TroopNickNameBusiness a = new TroopNickNameBusiness();
  
  public static TroopNickNameBusiness.Config a(String paramString)
  {
    paramString = new File(paramString, "config.json");
    if (paramString.exists()) {
      try
      {
        paramString = (TroopNickNameBusiness.Config)avyx.a(FileUtils.readFileToString(paramString), TroopNickNameBusiness.Config.class);
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public String a()
  {
    return "newgroupnick.android.";
  }
  
  public void a(int paramInt)
  {
    startDownload(a(paramInt));
  }
  
  public String b()
  {
    return "troopnick";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness
 * JD-Core Version:    0.7.0.1
 */