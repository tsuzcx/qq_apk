package com.tencent.mobileqq.transfile;

import com.tencent.qphone.base.util.QLog;

public class TransfileUtile
{
  public static final byte IMG_FMT_BMP = 1;
  public static final byte IMG_FMT_GIF = 2;
  public static final byte IMG_FMT_INVALID = 0;
  public static final byte IMG_FMT_JPG = 3;
  public static final byte IMG_FMT_PNG = 4;
  public static final int IMG_SCALE_120 = 120;
  public static final int IMG_SCALE_160 = 160;
  public static final int IMG_SCALE_640 = 640;
  public static final int IMG_SCALE_960 = 960;
  public static final int IMG_SCALE_ORG = 0;
  private static final String TAG = "TransfileUtile";
  public static final int TYPE_BILLD = 65538;
  public static final int TYPE_DISCUSSION = 4;
  public static final int TYPE_FILE = 0;
  public static final int TYPE_MARKET_FACE = 9;
  public static final int TYPE_PA_IMAGE_TEXT = 5;
  public static final int TYPE_PA_SHARE = 7;
  public static final int TYPE_PA_TEXT = 6;
  public static final int TYPE_PHOTO = 1;
  public static final int TYPE_PTT = 2;
  public static final int TYPE_PTT_CENTER = 8;
  public static final int TYPE_VIEDO = 3;
  
  public static String[] analysisTransFileProtocolData(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("\026");
    if (paramString != null)
    {
      if (paramString.length < 2) {
        return null;
      }
      return paramString[1].split("\\|");
    }
    return null;
  }
  
  public static String getForwardMsgContent(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\026');
    paramString1 = analysisTransFileProtocolData(paramString1);
    if (paramString1 == null) {
      return "";
    }
    int i = 0;
    while ((i < paramString1.length) && (i < 5))
    {
      localStringBuilder.append(paramString1[i]);
      localStringBuilder.append('|');
      i += 1;
    }
    if (paramString1.length == 4)
    {
      localStringBuilder.append("");
      localStringBuilder.append('|');
    }
    else
    {
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramLong);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt);
    }
    return localStringBuilder.toString();
  }
  
  public static byte getImgFormat(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    if (i < paramString.length())
    {
      paramString = paramString.substring(i + 1).toLowerCase();
      if ("bmp".equals(paramString)) {
        return 1;
      }
      if ("gif".equals(paramString)) {
        return 2;
      }
      if ((!"jpg".equals(paramString)) && (!"jpeg".equals(paramString)))
      {
        if ("png".equals(paramString)) {
          return 4;
        }
      }
      else {
        return 3;
      }
    }
    return 0;
  }
  
  public static String getPicMD5ByMsgContent(String paramString)
  {
    paramString = analysisTransFileProtocolData(paramString);
    if (paramString != null)
    {
      if (paramString.length < 6) {
        return null;
      }
      paramString = paramString[5];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPicMD5ByMsgContent:");
        localStringBuilder.append(paramString);
        QLog.d("TransfileUtile", 2, localStringBuilder.toString());
      }
      if (paramString.length() != 32)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent: error md5: length is not 32.");
        }
        return null;
      }
      return paramString;
    }
    return null;
  }
  
  @Deprecated
  public static String makeTransFileProtocolData(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @Deprecated
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = makeTransFileProtocolData(paramString1, paramLong, paramInt, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    paramString1 = localStringBuilder.toString();
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("null");
    return paramString2.toString();
  }
  
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = makeTransFileProtocolData(paramString1, paramLong, paramInt, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    paramString1 = localStringBuilder.toString();
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("null");
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    if ((paramString3 != null) && (paramString3.length() > 0))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString3);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("null");
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    if ((paramString4 != null) && (paramString4.length() > 0))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString4);
      return paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("null");
    return paramString2.toString();
  }
  
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3)
  {
    return makeTransFileProtocolData(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt2, paramInt3, null);
  }
  
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3, String paramString9)
  {
    paramString1 = makeTransFileProtocolData(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    if ((paramString5 != null) && (paramString5.length() > 0))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString5);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("null");
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString6);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("null");
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    if ((paramString7 != null) && (paramString7.length() > 0))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString7);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("null");
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    if ((paramString8 != null) && (paramString8.length() > 0))
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString8);
      paramString1 = paramString2.toString();
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("null");
      paramString1 = paramString2.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(paramInt2);
    paramString1 = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("|");
    paramString1 = paramString2.toString();
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(paramInt3);
    paramString2 = paramString2.toString();
    paramString1 = paramString2;
    if (paramString9 != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("|");
      paramString1 = paramString1.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(paramString9);
      paramString1 = paramString2.toString();
    }
    return paramString1;
  }
  
  public static String makeTransFileProtocolDataForForwardImage(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt)
  {
    paramString1 = makeTransFileProtocolData(paramString1, 0L, 1, true, paramString2);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('|');
    localStringBuffer.append(paramString2);
    localStringBuffer.append('|');
    localStringBuffer.append(paramString3);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(localStringBuffer.toString());
    return paramString2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransfileUtile
 * JD-Core Version:    0.7.0.1
 */