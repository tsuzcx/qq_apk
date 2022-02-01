package com.tencent.mobileqq.fts.v1;

import com.tencent.mobileqq.fts.data.msg.FTSMessage;

public class FTSArgsFactory
{
  public static FTSQueryArgs a(Class<FTSMessage> paramClass, String paramString)
  {
    return new FTSQueryArgs(a(paramString), paramClass, new String[] { paramString }, false, 1);
  }
  
  public static FTSQueryArgs a(String[] paramArrayOfString1, String[] paramArrayOfString2, Class<? extends FTSEntity> paramClass, boolean paramBoolean)
  {
    return new FTSQueryArgs(a(paramArrayOfString1, paramArrayOfString2, paramBoolean), paramClass, paramArrayOfString2, paramBoolean, 1);
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("SELECT DISTINCT type, oid, content, ext1, ext2, ext3, ext4, ext5, ext6, ext7, ext8, ext9, exts FROM IndexContent WHERE IndexContent MATCH 'type:");
    localStringBuffer.append(paramInt1);
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2)
      {
        if (paramInt2 == 3)
        {
          localStringBuffer.append(" ");
          localStringBuffer.append("ext3:");
          localStringBuffer.append(paramString);
        }
      }
      else
      {
        localStringBuffer.append(" ");
        localStringBuffer.append("ext2:");
        localStringBuffer.append(paramString);
      }
    }
    else
    {
      localStringBuffer.append(" ");
      localStringBuffer.append("ext1:");
      localStringBuffer.append(paramString);
    }
    localStringBuffer.append("';");
    return localStringBuffer.toString();
  }
  
  private static String a(String paramString)
  {
    return a(1, 2, String.valueOf(paramString));
  }
  
  private static String a(String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, String paramString)
  {
    paramArrayOfString2 = new StringBuilder(256);
    paramArrayOfString2.append("SELECT DISTINCT type, oid, content, ext1, ext2, ext3, ext4, ext5, ext6, ext7, ext8, ext9, exts FROM IndexContent WHERE contentindex MATCH '");
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfString1.length - 1)
    {
      paramArrayOfString2.append("\"");
      paramString = paramArrayOfString1[paramInt1].split(" ");
      paramInt2 = 0;
      while (paramInt2 < paramString.length - 1)
      {
        if ((paramString[paramInt2].length() != 1) && ((paramString[paramInt2].charAt(0) < '0') || (paramString[paramInt2].charAt(0) > '9')) && ((paramString[paramInt2].charAt(0) < 'a') || (paramString[paramInt2].charAt(0) > 'z')))
        {
          paramArrayOfString2.append(paramString[paramInt2]);
        }
        else
        {
          paramArrayOfString2.append(paramString[paramInt2]);
          paramArrayOfString2.append("*");
        }
        paramArrayOfString2.append(" ");
        paramInt2 += 1;
      }
      if ((paramString[(paramString.length - 1)].length() != 1) && ((paramString[(paramString.length - 1)].charAt(0) < '0') || (paramString[(paramString.length - 1)].charAt(0) > '9')) && ((paramString[(paramString.length - 1)].charAt(0) < 'a') || (paramString[(paramString.length - 1)].charAt(0) > 'z')))
      {
        paramArrayOfString2.append(paramString[(paramString.length - 1)]);
      }
      else
      {
        paramArrayOfString2.append(paramString[(paramString.length - 1)]);
        paramArrayOfString2.append("*");
      }
      paramArrayOfString2.append("\"");
      paramArrayOfString2.append(" OR ");
      paramInt1 += 1;
    }
    paramArrayOfString2.append("\"");
    paramArrayOfString1 = paramArrayOfString1[(paramArrayOfString1.length - 1)].split(" ");
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfString1.length - 1)
    {
      if ((paramArrayOfString1[paramInt1].length() != 1) && ((paramArrayOfString1[paramInt1].charAt(0) < '0') || (paramArrayOfString1[paramInt1].charAt(0) > '9')) && ((paramArrayOfString1[paramInt1].charAt(0) < 'a') || (paramArrayOfString1[paramInt1].charAt(0) > 'z')))
      {
        paramArrayOfString2.append(paramArrayOfString1[paramInt1]);
      }
      else
      {
        paramArrayOfString2.append(paramArrayOfString1[paramInt1]);
        paramArrayOfString2.append("*");
      }
      paramArrayOfString2.append(" ");
      paramInt1 += 1;
    }
    if ((paramArrayOfString1[(paramArrayOfString1.length - 1)].length() != 1) && ((paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) < '0') || (paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) > '9')) && ((paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) < 'a') || (paramArrayOfString1[(paramArrayOfString1.length - 1)].charAt(0) > 'z')))
    {
      paramArrayOfString2.append(paramArrayOfString1[(paramArrayOfString1.length - 1)]);
    }
    else
    {
      paramArrayOfString2.append(paramArrayOfString1[(paramArrayOfString1.length - 1)]);
      paramArrayOfString2.append("*");
    }
    paramArrayOfString2.append("\"");
    paramArrayOfString2.append("'");
    paramArrayOfString2.append(";");
    return paramArrayOfString2.toString();
  }
  
  private static String a(String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
  {
    return a(paramArrayOfString1, paramArrayOfString2, 1, paramBoolean, true, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v1.FTSArgsFactory
 * JD-Core Version:    0.7.0.1
 */