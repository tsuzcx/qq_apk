package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.DataReader;
import java.io.IOException;
import java.util.UnknownFormatConversionException;

public class OatHelper
{
  static String DEX2OAT_CMDLINE = "dex2oat-cmdline";
  static int EI_DATA = 5;
  static int EI_NIDENT = 16;
  static long OAT_SECTION_START = 4096L;
  static char[] e_ident = new char[EI_NIDENT];
  
  public static char[] getKeyValueStore(DataReader paramDataReader)
    throws IOException
  {
    char[] arrayOfChar1 = new char[4];
    char[] arrayOfChar2 = new char[4];
    paramDataReader.readBytes(arrayOfChar1);
    if ((arrayOfChar1[0] != 'o') || (arrayOfChar1[1] != 'a') || (arrayOfChar1[2] != 't')) {
      throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[] { Character.valueOf(arrayOfChar1[0]), Character.valueOf(arrayOfChar1[1]), Character.valueOf(arrayOfChar1[2]) }));
    }
    paramDataReader.readBytes(arrayOfChar2);
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    if (arrayOfChar2[1] <= '4')
    {
      paramDataReader.readInt();
      paramDataReader.readInt();
      paramDataReader.readInt();
    }
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    paramDataReader.readInt();
    arrayOfChar1 = new char[paramDataReader.readInt()];
    paramDataReader.readBytes(arrayOfChar1);
    return arrayOfChar1;
  }
  
  public static String getOatCommand(Context paramContext, String paramString)
    throws Exception
  {
    boolean bool = true;
    paramContext = new DataReader(paramString);
    paramContext.readBytes(e_ident);
    if (e_ident[EI_DATA] == '\001') {}
    for (;;)
    {
      paramContext.setIsLittleEndian(bool);
      paramContext.seek(OAT_SECTION_START);
      return getOatFunction(new String(getKeyValueStore(paramContext)));
      bool = false;
    }
  }
  
  private static String getOatFunction(String paramString)
  {
    paramString = paramString.split(new String(""));
    int i = 0;
    while (i < paramString.length)
    {
      int j = i + 1;
      Object localObject = paramString[i];
      i = j + 1;
      String str = paramString[j];
      if (localObject.equals(DEX2OAT_CMDLINE)) {
        return str;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.OatHelper
 * JD-Core Version:    0.7.0.1
 */