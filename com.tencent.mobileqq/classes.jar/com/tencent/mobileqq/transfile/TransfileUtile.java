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
    if (paramString == null) {}
    do
    {
      return null;
      paramString = paramString.split("\026");
    } while ((paramString == null) || (paramString.length < 2));
    return paramString[1].split("\\|");
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
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(paramString2);
      localStringBuilder.append('|');
      localStringBuilder.append(paramString3);
      localStringBuilder.append('|');
      localStringBuilder.append(paramLong);
      localStringBuilder.append('|');
      localStringBuilder.append(paramInt);
    }
  }
  
  public static byte getImgFormat(String paramString)
  {
    byte b2 = 0;
    int i = paramString.lastIndexOf(".");
    byte b1 = b2;
    if (i < paramString.length())
    {
      paramString = paramString.substring(i + 1).toLowerCase();
      if (!"bmp".equals(paramString)) {
        break label43;
      }
      b1 = 1;
    }
    label43:
    do
    {
      return b1;
      if ("gif".equals(paramString)) {
        return 2;
      }
      if (("jpg".equals(paramString)) || ("jpeg".equals(paramString))) {
        return 3;
      }
      b1 = b2;
    } while (!"png".equals(paramString));
    return 4;
  }
  
  public static String getPicMD5ByMsgContent(String paramString)
  {
    paramString = analysisTransFileProtocolData(paramString);
    if ((paramString == null) || (paramString.length < 6)) {}
    do
    {
      return null;
      paramString = paramString[5];
      if (QLog.isColorLevel()) {
        QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent:" + paramString);
      }
      if (paramString.length() == 32) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TransfileUtile", 2, "getPicMD5ByMsgContent: error md5: length is not 32.");
    return null;
    return paramString;
  }
  
  @Deprecated
  public static String makeTransFileProtocolData(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('\026');
    localStringBuffer.append(paramString);
    localStringBuffer.append('|');
    localStringBuffer.append(paramLong);
    localStringBuffer.append('|');
    localStringBuffer.append(paramInt);
    localStringBuffer.append('|');
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localStringBuffer.append(paramInt);
      return localStringBuffer.toString();
    }
  }
  
  @Deprecated
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = makeTransFileProtocolData(paramString1, paramLong, paramInt, paramBoolean);
    paramString1 = paramString1 + "|";
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return paramString1 + "null";
    }
    return paramString1 + paramString2;
  }
  
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = makeTransFileProtocolData(paramString1, paramLong, paramInt, paramBoolean);
    paramString1 = paramString1 + "|";
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      paramString1 = paramString1 + "null";
      paramString1 = paramString1 + "|";
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        break label191;
      }
    }
    label191:
    for (paramString1 = paramString1 + "null";; paramString1 = paramString1 + paramString3)
    {
      paramString1 = paramString1 + "|";
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        break label214;
      }
      return paramString1 + "null";
      paramString1 = paramString1 + paramString2;
      break;
    }
    label214:
    return paramString1 + paramString4;
  }
  
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3)
  {
    return makeTransFileProtocolData(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt2, paramInt3, null);
  }
  
  public static String makeTransFileProtocolData(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3, String paramString9)
  {
    paramString1 = makeTransFileProtocolData(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4);
    paramString1 = paramString1 + "|";
    if ((paramString5 == null) || (paramString5.length() <= 0))
    {
      paramString1 = paramString1 + "null";
      paramString1 = paramString1 + "|";
      if ((paramString6 != null) && (paramString6.length() > 0)) {
        break label382;
      }
      paramString1 = paramString1 + "null";
      label121:
      paramString1 = paramString1 + "|";
      if ((paramString7 != null) && (paramString7.length() > 0)) {
        break label405;
      }
      paramString1 = paramString1 + "null";
      label174:
      paramString1 = paramString1 + "|";
      if ((paramString8 != null) && (paramString8.length() > 0)) {
        break label428;
      }
    }
    label405:
    label428:
    for (paramString1 = paramString1 + "null";; paramString1 = paramString1 + paramString8)
    {
      paramString1 = paramString1 + "|";
      paramString1 = paramString1 + paramInt2;
      paramString1 = paramString1 + "|";
      paramString2 = paramString1 + paramInt3;
      paramString1 = paramString2;
      if (paramString9 != null)
      {
        paramString1 = paramString2 + "|";
        paramString1 = paramString1 + paramString9;
      }
      return paramString1;
      paramString1 = paramString1 + paramString5;
      break;
      label382:
      paramString1 = paramString1 + paramString6;
      break label121;
      paramString1 = paramString1 + paramString7;
      break label174;
    }
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
    return paramString1 + localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransfileUtile
 * JD-Core Version:    0.7.0.1
 */