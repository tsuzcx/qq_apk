package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopTechReportUtils
{
  public static final void a()
  {
    a("gfile", "gfile_upload", "", "", "", "");
  }
  
  public static final void a(int paramInt1, int paramInt2)
  {
    int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    a("gfile", "gfile_upload_result", (String)localObject1, (String)localObject2, localStringBuilder.toString(), "");
  }
  
  public static final void a(int paramInt1, int paramInt2, String paramString)
  {
    int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    a("gfile", "gfile_upload_result", (String)localObject1, (String)localObject2, localStringBuilder.toString(), paramString);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    TroopReportor.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static final void a(String paramString, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if ((paramVarArgs != null) && (paramVarArgs.length <= 4))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        arrayOfString[i] = paramVarArgs[i];
        i += 1;
      }
    }
    a("page_exp", paramString, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
  }
  
  public static final void b()
  {
    a("gfile", "gfile_download", "", "", "", "");
  }
  
  public static final void b(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, "");
  }
  
  public static final void b(int paramInt1, int paramInt2, String paramString)
  {
    int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(i);
    a("gfile", "gfile_download_result", (String)localObject1, (String)localObject2, localStringBuilder.toString(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTechReportUtils
 * JD-Core Version:    0.7.0.1
 */