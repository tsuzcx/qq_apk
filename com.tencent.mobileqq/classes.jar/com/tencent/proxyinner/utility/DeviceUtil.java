package com.tencent.proxyinner.utility;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public class DeviceUtil
{
  private static final String DEVICE_ID_FILE = "DEVICE_ID";
  private static String sDeviceId = "";
  
  public static String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDeviceId)) {
      return sDeviceId;
    }
    paramContext = new File(paramContext.getFilesDir(), "DEVICE_ID");
    try
    {
      if (paramContext.exists()) {
        sDeviceId = readDeviceIdFromFile(paramContext);
      }
      for (;;)
      {
        return sDeviceId;
        sDeviceId = UUID.randomUUID().toString();
        paramContext.createNewFile();
        writeDeviceIdToFile(paramContext, sDeviceId);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static int getDeviceIdHash(Context paramContext)
  {
    return getDeviceId(paramContext).hashCode() & 0x7FFFFFFF;
  }
  
  private static String readDeviceIdFromFile(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[(int)paramFile.length()];
    paramFile.readFully(arrayOfByte);
    paramFile.close();
    return new String(arrayOfByte);
  }
  
  private static void writeDeviceIdToFile(File paramFile, String paramString)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramString.getBytes());
    paramFile.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.DeviceUtil
 * JD-Core Version:    0.7.0.1
 */