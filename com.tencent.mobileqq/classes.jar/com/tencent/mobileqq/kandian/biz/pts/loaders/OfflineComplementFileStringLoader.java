package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadFile;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class OfflineComplementFileStringLoader
  implements ComplementFileStringLoader
{
  private ReadFile a;
  
  public OfflineComplementFileStringLoader(ReadFile paramReadFile)
  {
    this.a = paramReadFile;
  }
  
  public String loadFileAsString(String paramString)
  {
    try
    {
      Object localObject = this.a.a(paramString);
      if (localObject != null) {
        return OfflineUtils.a((InputStream)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" not found");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadFileAsString: fail to include - ");
        localStringBuilder.append(paramString);
        QLog.d("OfflineComplementFileStringLoader", 2, localStringBuilder.toString());
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.OfflineComplementFileStringLoader
 * JD-Core Version:    0.7.0.1
 */