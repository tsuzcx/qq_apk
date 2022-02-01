package com.tencent.mobileqq.service.message;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageUtils
{
  private static ArrayList<Integer> a;
  public static final short[] a;
  private static ArrayList<Integer> b;
  public static final short[] b;
  
  static
  {
    Integer localInteger1 = Integer.valueOf(-1002);
    Integer localInteger2 = Integer.valueOf(-1001);
    Integer localInteger3 = Integer.valueOf(-1004);
    Integer localInteger4 = Integer.valueOf(-4000);
    Integer localInteger5 = Integer.valueOf(-4001);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3, Integer.valueOf(-1047), Integer.valueOf(-1013), Integer.valueOf(-2030), Integer.valueOf(-1019), Integer.valueOf(-1018), localInteger4, localInteger5, Integer.valueOf(-3007), Integer.valueOf(-1012), Integer.valueOf(-2012), Integer.valueOf(-2013), Integer.valueOf(-3008), Integer.valueOf(-3009), Integer.valueOf(-4020), Integer.valueOf(-3010), Integer.valueOf(-3013), Integer.valueOf(-3014), Integer.valueOf(-3011), Integer.valueOf(-2015), Integer.valueOf(-2061), Integer.valueOf(-4008), Integer.valueOf(-4002), Integer.valueOf(-4003), Integer.valueOf(-4005), Integer.valueOf(-1014), Integer.valueOf(-1016), Integer.valueOf(-1017), Integer.valueOf(-1050), Integer.valueOf(-4004), Integer.valueOf(-2019), Integer.valueOf(-7006), Integer.valueOf(-1041), Integer.valueOf(-1043), Integer.valueOf(-1044), Integer.valueOf(-1045), Integer.valueOf(-5000), Integer.valueOf(-5001), Integer.valueOf(1018), Integer.valueOf(-4010), Integer.valueOf(-1024), Integer.valueOf(-1028), Integer.valueOf(-5002), Integer.valueOf(2024), Integer.valueOf(-2042), Integer.valueOf(-1026), Integer.valueOf(-1027), Integer.valueOf(-5005), Integer.valueOf(-1046), Integer.valueOf(-2027), Integer.valueOf(-2037), Integer.valueOf(-4505), Integer.valueOf(-4506), Integer.valueOf(-4507), Integer.valueOf(-4011), Integer.valueOf(-5006), Integer.valueOf(-5007), Integer.valueOf(-2029), Integer.valueOf(-2031), Integer.valueOf(-2033), Integer.valueOf(-2034), Integer.valueOf(-1048), Integer.valueOf(-2041), Integer.valueOf(-2043), Integer.valueOf(-4021), Integer.valueOf(-4022), Integer.valueOf(-5011), Integer.valueOf(-2049), Integer.valueOf(-4012), Integer.valueOf(-2060), Integer.valueOf(-2062), Integer.valueOf(-2065), Integer.valueOf(-2063), Integer.valueOf(-3016), Integer.valueOf(-4023), Integer.valueOf(-4024), Integer.valueOf(-4025), Integer.valueOf(-4026), Integer.valueOf(-2077), Integer.valueOf(-7010), Integer.valueOf(-7009), Integer.valueOf(-7011), Integer.valueOf(-7012), Integer.valueOf(-7013), Integer.valueOf(-7015), Integer.valueOf(-4027) }));
    jdField_b_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new Integer[] { localInteger1, localInteger2, localInteger3, localInteger4, localInteger5, Integer.valueOf(-3007), Integer.valueOf(-1012), Integer.valueOf(-2012), Integer.valueOf(-2013), Integer.valueOf(-3008), Integer.valueOf(-2015), Integer.valueOf(-2061), Integer.valueOf(-4002), Integer.valueOf(-4003), Integer.valueOf(-4004), Integer.valueOf(-4009), Integer.valueOf(-2021), Integer.valueOf(-5000), Integer.valueOf(-5001), Integer.valueOf(-2034), Integer.valueOf(-2033), Integer.valueOf(-1016), Integer.valueOf(-2060), Integer.valueOf(-2062), Integer.valueOf(-2065), Integer.valueOf(-2066), Integer.valueOf(-2049), Integer.valueOf(-2023), Integer.valueOf(-2063), Integer.valueOf(-3016), Integer.valueOf(-4023), Integer.valueOf(-4024), Integer.valueOf(-4025), Integer.valueOf(-4026), Integer.valueOf(-7007), Integer.valueOf(-4012), Integer.valueOf(-2077), Integer.valueOf(-7010), Integer.valueOf(-7009), Integer.valueOf(-7011), Integer.valueOf(-7012), Integer.valueOf(-7013), Integer.valueOf(-7015), Integer.valueOf(-4027) }));
    jdField_a_of_type_ArrayOfShort = new short[] { 13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 };
    jdField_b_of_type_ArrayOfShort = new short[] { 33, 40, 19, 43, 21, 9, 20, 106, 35, 250, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219 };
  }
  
  public static int a()
  {
    return Math.abs(new Random().nextInt());
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static long a(int paramInt)
  {
    return paramInt | 0x0;
  }
  
  public static long a(long paramLong, int paramInt)
  {
    if (UinTypeUtil.b(paramInt)) {
      return (short)(int)paramLong;
    }
    return 0L;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
  
  public static String a(String paramString, boolean paramBoolean, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = paramString.toCharArray();
    int m = 0;
    int n = 0;
    int i = 0;
    int k = 0;
    int i5;
    for (int i2 = 0; m < arrayOfChar.length; i2 = i5)
    {
      Object localObject = null;
      int j = i;
      paramString = localObject;
      if (paramArrayList != null) {
        for (;;)
        {
          j = i;
          paramString = localObject;
          if (i >= paramArrayList.size()) {
            break;
          }
          paramString = (AtTroopMemberInfo)paramArrayList.get(i);
          if ((paramString != null) && (paramString.isValid()))
          {
            j = i;
            break;
          }
          i += 1;
        }
      }
      int i3 = j;
      i = k;
      int i1 = i2;
      int i4;
      if (paramString != null)
      {
        i3 = j;
        i = k;
        i1 = i2;
        if (paramString.startPos <= m)
        {
          if (paramString.startPos == m) {
            k = n;
          }
          if (m < paramString.startPos + paramString.textLen)
          {
            i3 = j;
            i = k;
            i1 = i2;
            if (arrayOfChar[m] == '\024')
            {
              i5 = i2 - 2;
              i4 = n - 2;
              i2 = m + 1;
              break label418;
            }
          }
          else
          {
            paramString.startPos = ((short)(paramString.startPos + k));
            paramString.textLen = ((short)(paramString.textLen + i2));
            i3 = j + 1;
            i = 0;
            i1 = 0;
          }
        }
      }
      if ((arrayOfChar[m] == '\r') && ((!paramBoolean) || (m <= 0) || (arrayOfChar[(m - 1)] != '\024')))
      {
        arrayOfChar[(m + n)] = '\n';
        int i6 = m + 1;
        i2 = m;
        i4 = n;
        j = i3;
        k = i;
        i5 = i1;
        if (i6 < arrayOfChar.length)
        {
          i2 = m;
          i4 = n;
          j = i3;
          k = i;
          i5 = i1;
          if (arrayOfChar[i6] == '\n')
          {
            i4 = n - 1;
            i2 = i6;
            j = i3;
            k = i;
            i5 = i1;
          }
        }
      }
      else
      {
        i2 = m;
        i4 = n;
        j = i3;
        k = i;
        i5 = i1;
        if (n != 0)
        {
          arrayOfChar[(m + n)] = arrayOfChar[m];
          i5 = i1;
          k = i;
          j = i3;
          i4 = n;
          i2 = m;
        }
      }
      label418:
      m = i2 + 1;
      n = i4;
      i = j;
    }
    return new String(arrayOfChar, 0, arrayOfChar.length + n);
  }
  
  public static boolean a(int paramInt)
  {
    return jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.msgtype;
    boolean bool = true;
    if (i == -1000)
    {
      if (paramMessageRecord.msg == null) {
        return bool;
      }
      if (paramMessageRecord.msg.length() == 0) {
        return true;
      }
      if ((paramMessageRecord.msg.trim().length() == 0) && (paramMessageRecord.msg.charAt(0) != '\024')) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase();
    return (paramInt != 0) && ((paramString.endsWith(".gif")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".bmp")));
  }
  
  public static String[] a(String paramString)
  {
    String[] arrayOfString = new String[3];
    int i = paramString.indexOf("http://maps.google.com/maps?q=");
    if (i >= 0)
    {
      paramString = paramString.substring(i);
      Object localObject = Pattern.compile("\\s*(loc:)?-?\\d+(.\\d+)?\\s*,\\s*-?\\d+(.\\d+)?").matcher(paramString);
      if (((Matcher)localObject).find())
      {
        localObject = ((Matcher)localObject).group();
        if ((localObject != null) && (((String)localObject).length() > 0))
        {
          int j = ((String)localObject).indexOf(',');
          i = ((String)localObject).indexOf("loc:");
          if (j >= 0)
          {
            if (i >= 0) {
              i += 4;
            } else {
              i = 0;
            }
            arrayOfString[0] = ((String)localObject).substring(i, j);
            arrayOfString[1] = ((String)localObject).substring(j + 1, ((String)localObject).length());
          }
        }
        paramString = Pattern.compile("\\(.+\\)").matcher(paramString);
        if (paramString.find())
        {
          paramString = paramString.group();
          if ((paramString != null) && (paramString.length() > 2)) {
            arrayOfString[2] = paramString.substring(1, paramString.length() - 1);
          }
        }
      }
    }
    if (arrayOfString[2] == null) {
      arrayOfString[2] = "";
    }
    return arrayOfString;
  }
  
  public static int b(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static boolean b(int paramInt)
  {
    return jdField_b_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt)) ^ true;
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    paramString = paramString.toLowerCase();
    return (paramInt != 0) && (paramString.endsWith(".amr"));
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 31) || (paramInt == 79) || (paramInt == 97) || (paramInt == 120) || (paramInt == 132) || (paramInt == 133) || (paramInt == 166) || (paramInt == 167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageUtils
 * JD-Core Version:    0.7.0.1
 */