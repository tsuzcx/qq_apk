package com.tencent.mobileqq.kandian.biz.pts.loaders.file;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadAssetFile
  implements ReadFile
{
  private AssetManager a;
  private String b;
  
  public ReadAssetFile(Context paramContext, String paramString)
  {
    this.a = paramContext.getAssets();
    this.b = paramString;
  }
  
  public InputStream a(String paramString)
  {
    AssetManager localAssetManager = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localAssetManager.open(localStringBuilder.toString());
  }
  
  public List<String> a()
  {
    try
    {
      List localList = OfflineUtils.a(this.a, this.b);
      if (localList != null) {
        return localList;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadAssetFile", 1, "tryLoadTemplateFromAssets fileList size: ", localException);
      String[] arrayOfString = this.a.list(this.b);
      ArrayList localArrayList = new ArrayList();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localArrayList.add(arrayOfString[i]);
          i += 1;
        }
      }
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadAssetFile
 * JD-Core Version:    0.7.0.1
 */