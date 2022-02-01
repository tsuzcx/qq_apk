package com.tencent.mobileqq.cmshow.engine.resource.downloader;

import com.tencent.biz.common.util.ZipUtils.ZipFilenameFilter;
import java.io.File;
import java.util.zip.ZipEntry;

class AbsApolloResDownloader$1$1
  implements ZipUtils.ZipFilenameFilter
{
  AbsApolloResDownloader$1$1(AbsApolloResDownloader.1 param1, StringBuilder paramStringBuilder, String paramString) {}
  
  public boolean accept(ZipEntry paramZipEntry)
  {
    if (!paramZipEntry.isDirectory()) {
      return true;
    }
    if ((this.c.c != null) && (this.c.c.length > 0))
    {
      localObject = this.c.c;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = localObject[i];
        if (paramZipEntry.getName().equals(Integer.valueOf(k + File.separatorChar)))
        {
          localObject = this.a;
          ((StringBuilder)localObject).append(paramZipEntry.getName());
          ((StringBuilder)localObject).append(" download, ");
          return false;
        }
        i += 1;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(paramZipEntry.getName());
    localObject = new File(((StringBuilder)localObject).toString());
    if ((((File)localObject).isDirectory()) && (((File)localObject).list().length >= 3))
    {
      localObject = this.a;
      ((StringBuilder)localObject).append(paramZipEntry.getName());
      ((StringBuilder)localObject).append(" exist, ");
      return false;
    }
    localObject = this.a;
    ((StringBuilder)localObject).append(paramZipEntry.getName());
    ((StringBuilder)localObject).append(" copy, ");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.downloader.AbsApolloResDownloader.1.1
 * JD-Core Version:    0.7.0.1
 */