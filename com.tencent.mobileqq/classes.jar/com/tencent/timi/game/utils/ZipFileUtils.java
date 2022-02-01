package com.tencent.timi.game.utils;

import com.tencent.commonsdk.zip.QZipFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;

public class ZipFileUtils
{
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      b(paramString1, paramString2);
      return true;
    }
    catch (IOException paramString1)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  private static void b(String paramString1, String paramString2)
  {
    paramString1 = new QZipFile(paramString1);
    Enumeration localEnumeration = paramString1.entries();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (ZipEntry)localEnumeration.nextElement();
      Object localObject2 = ((ZipEntry)localObject1).getName();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject3 = ((StringBuilder)localObject3).toString();
      if (((ZipEntry)localObject1).isDirectory())
      {
        localObject1 = new File((String)localObject3);
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
      }
      else
      {
        localObject3 = new File(((String)localObject3).substring(0, ((String)localObject3).lastIndexOf("/")));
        if (!((File)localObject3).exists()) {
          ((File)localObject3).mkdirs();
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString2);
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = new BufferedOutputStream(new FileOutputStream(((StringBuilder)localObject3).toString()));
        try
        {
          localObject1 = new BufferedInputStream(paramString1.getInputStream((ZipEntry)localObject1));
          localObject3 = new byte[1024];
          for (int i = ((BufferedInputStream)localObject1).read((byte[])localObject3); i != -1; i = ((BufferedInputStream)localObject1).read((byte[])localObject3)) {
            ((BufferedOutputStream)localObject2).write((byte[])localObject3, 0, i);
          }
          StreamCloser.a((Closeable)localObject2);
        }
        catch (IOException paramString1)
        {
          StreamCloser.a((Closeable)localObject2);
          throw paramString1;
        }
      }
    }
    paramString1.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.ZipFileUtils
 * JD-Core Version:    0.7.0.1
 */