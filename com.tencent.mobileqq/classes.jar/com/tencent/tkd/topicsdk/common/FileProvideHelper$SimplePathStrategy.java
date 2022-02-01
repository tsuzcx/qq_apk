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
    try
    {
      Object localObject2 = paramFile.getCanonicalPath();
      paramFile = null;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        String str = ((File)((Map.Entry)localObject1).getValue()).getPath();
        if ((((String)localObject2).startsWith(str)) && ((paramFile == null) || (str.length() > ((File)paramFile.getValue()).getPath().length()))) {
          paramFile = (File)localObject1;
        }
      }
      if (paramFile != null)
      {
        localObject1 = ((File)paramFile.getValue()).getPath();
        if (((String)localObject1).endsWith("/")) {
          localObject1 = ((String)localObject2).substring(((String)localObject1).length());
        } else {
          localObject1 = ((String)localObject2).substring(((String)localObject1).length() + 1);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(Uri.encode((String)paramFile.getKey()));
        ((StringBuilder)localObject2).append('/');
        ((StringBuilder)localObject2).append(Uri.encode((String)localObject1, "/"));
        paramFile = ((StringBuilder)localObject2).toString();
        return new Uri.Builder().scheme("content").authority(this.jdField_a_of_type_JavaLangString).encodedPath(paramFile).build();
      }
      paramFile = new StringBuilder();
      paramFile.append("Failed to find configured root that contains ");
      paramFile.append((String)localObject2);
      throw new IllegalArgumentException(paramFile.toString());
    }
    catch (IOException localIOException)
    {
      Object localObject1;
      label254:
      break label254;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to resolve canonical path for ");
    ((StringBuilder)localObject1).append(paramFile);
    paramFile = new IllegalArgumentException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramFile;
    }
  }
  
  void a(String paramString, File paramFile)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject = paramFile.getCanonicalFile();
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
        return;
      }
      catch (IOException paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to resolve canonical path for ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString(), paramString);
      }
    }
    throw new IllegalArgumentException("Name must not be empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FileProvideHelper.SimplePathStrategy
 * JD-Core Version:    0.7.0.1
 */