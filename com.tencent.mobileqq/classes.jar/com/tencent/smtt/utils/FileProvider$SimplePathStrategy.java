package com.tencent.smtt.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class FileProvider$SimplePathStrategy
  implements FileProvider.PathStrategy
{
  private final String mAuthority;
  private final HashMap<String, File> mRoots = new HashMap();
  
  public FileProvider$SimplePathStrategy(String paramString)
  {
    this.mAuthority = paramString;
  }
  
  public void addRoot(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Name must not be empty");
    }
    try
    {
      File localFile = paramFile.getCanonicalFile();
      this.mRoots.put(paramString, localFile);
      return;
    }
    catch (IOException paramString)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramFile, paramString);
    }
  }
  
  public File getFileForUri(Uri paramUri)
  {
    Object localObject2 = paramUri.getEncodedPath();
    int i = ((String)localObject2).indexOf('/', 1);
    Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
    localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
    localObject1 = (File)this.mRoots.get(localObject1);
    if (localObject1 == null) {
      throw new IllegalArgumentException("Unable to find configured root for " + paramUri);
    }
    paramUri = new File((File)localObject1, (String)localObject2);
    try
    {
      localObject2 = paramUri.getCanonicalFile();
      if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for " + paramUri);
    }
    return localObject2;
  }
  
  public Uri getUriForFile(File paramFile)
  {
    for (;;)
    {
      String str1;
      try
      {
        str1 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.mRoots.entrySet().iterator();
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
        return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(paramFile).build();
      }
      label277:
      localObject = paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.utils.FileProvider.SimplePathStrategy
 * JD-Core Version:    0.7.0.1
 */