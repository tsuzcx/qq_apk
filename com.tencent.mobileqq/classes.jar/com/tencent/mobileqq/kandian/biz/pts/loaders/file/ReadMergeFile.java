package com.tencent.mobileqq.kandian.biz.pts.loaders.file;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadMergeFile
  implements ReadFile
{
  private String a;
  private File b;
  private ReadAssetFile c;
  private String d;
  private boolean e;
  
  public ReadMergeFile(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.c = new ReadAssetFile(paramContext, paramString2);
      this.a = paramString1;
      this.b = new File(paramString1);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("");
    paramContext.append(paramString1);
    paramContext.append(" : ");
    paramContext.append(paramString2);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.equals(paramString, this.d)) {
      this.e = paramBoolean;
    }
  }
  
  public InputStream a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString);
    localObject = new File(((StringBuilder)localObject).toString());
    if (((File)localObject).exists()) {
      try
      {
        a(paramString, true);
        if (this.e)
        {
          localObject = new FileInputStream((File)localObject);
          return localObject;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFile:");
        localStringBuilder.append(paramString);
        QLog.e("ReadMergeFile", 2, localStringBuilder.toString(), localFileNotFoundException);
      }
    }
    InputStream localInputStream = this.c.a(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("使用兜底 file: ");
    localStringBuilder.append(paramString);
    QLog.d("TemplateFactory", 1, localStringBuilder.toString());
    a(paramString, false);
    return localInputStream;
  }
  
  public List<String> a()
  {
    Object localObject2 = this.c.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = this.b.list();
    if (localObject2 != null)
    {
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        ((List)localObject1).add(localObject2[i]);
        i += 1;
      }
    }
    return localObject1;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadMergeFile
 * JD-Core Version:    0.7.0.1
 */