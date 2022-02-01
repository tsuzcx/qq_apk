package com.tencent.tkd.topicsdk.common;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class FileProvideHelper$SimplePathStrategy
  implements FileProvideHelper.PathStrategy
{
  private final String jdField_a_of_type_JavaLangString;
  private final HashMap<String, File> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  FileProvideHelper$SimplePathStrategy(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public Uri a(File paramFile)
  {
    for (;;)
    {
      String str1;
      try
      {
        str1 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator.next();
          String str2 = ((File)localEntry2.getValue()).getPath();
          if (!str1.startsWith(str2)) {
            break label277;
          }
          Map.Entry localEntry1 = localEntry2;
          if (paramFile != null)
          {
            if (str2.length() <= ((File)paramFile.getValue()).getPath().length()) {
              break label277;
            }
            localEntry1 = localEntry2;
          }
          paramFile = localEntry1;
          continue;
        }
        if (paramFile != null) {
          break label163;
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile);
      }
      throw new IllegalArgumentException("Failed to find configured root that contains " + str1);
      label163:
      Object localObject = ((File)paramFile.getValue()).getPath();
      if (((String)localObject).endsWith("/")) {}
      for (localObject = str1.substring(((String)localObject).length());; localObject = str1.substring(((String)localObject).length() + 1))
      {
        paramFile = Uri.encode((String)paramFile.getKey()) + '/' + Uri.encode((String)localObject, "/");
        return new Uri.Builder().scheme("content").authority(this.jdField_a_of_type_JavaLangString).encodedPath(paramFile).build();
      }
      label277:
      localObject = paramFile;
    }
  }
  
  void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Name must not be empty");
    }
    try
    {
      File localFile = paramFile.getCanonicalFile();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localFile);
      return;
    }
    catch (IOException paramString)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FileProvideHelper.SimplePathStrategy
 * JD-Core Version:    0.7.0.1
 */