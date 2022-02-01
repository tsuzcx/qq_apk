package com.tencent.mobileqq.winkpublish.util;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class MD5Util
{
  public static String a(File paramFile)
  {
    if (paramFile == null) {
      return "";
    }
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      int i;
      int j;
      try
      {
        localObject1 = new FileInputStream(paramFile);
        localObject2 = new byte[8192];
        paramFile = new char[16];
        paramFile[0] = 48;
        paramFile[1] = 49;
        paramFile[2] = 50;
        paramFile[3] = 51;
        paramFile[4] = 52;
        paramFile[5] = 53;
        paramFile[6] = 54;
        paramFile[7] = 55;
        paramFile[8] = 56;
        paramFile[9] = 57;
        paramFile[10] = 97;
        paramFile[11] = 98;
        paramFile[12] = 99;
        paramFile[13] = 100;
        paramFile[14] = 101;
        paramFile[15] = 102;
        paramFile;
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          i = localObject2.length;
          j = 0;
          i = ((FileInputStream)localObject1).read((byte[])localObject2, 0, i);
          if (i != -1)
          {
            localMessageDigest.update((byte[])localObject2, 0, i);
            continue;
          }
          ((FileInputStream)localObject1).close();
          localObject1 = localMessageDigest.digest();
          localObject2 = new char[32];
          i = 0;
        }
        catch (Exception paramFile)
        {
          paramFile.printStackTrace();
          return null;
        }
        paramFile = new String((char[])localObject2);
        return paramFile;
      }
      catch (Exception paramFile)
      {
        return "";
      }
      while (j < 16)
      {
        int k = localObject1[j];
        int m = i + 1;
        localObject2[i] = paramFile[(k >>> 4 & 0xF)];
        i = m + 1;
        localObject2[m] = paramFile[(k & 0xF)];
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.MD5Util
 * JD-Core Version:    0.7.0.1
 */