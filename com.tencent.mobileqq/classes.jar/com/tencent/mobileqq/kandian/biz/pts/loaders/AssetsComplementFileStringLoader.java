package com.tencent.mobileqq.kandian.biz.pts.loaders;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.loaders.ComplementFileStringLoader;
import com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadAssetFile;
import com.tencent.mobileqq.kandian.biz.pts.util.OfflineUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class AssetsComplementFileStringLoader
  implements ComplementFileStringLoader
{
  private Context a;
  private String b;
  private ReadAssetFile c;
  
  public AssetsComplementFileStringLoader(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = new ReadAssetFile(paramContext, paramString);
  }
  
  public String loadFileAsString(String paramString)
  {
    AssetManager localAssetManager = this.a.getAssets();
    try
    {
      localObject2 = this.c.a(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = localAssetManager.open(((StringBuilder)localObject1).toString());
      }
      localObject1 = OfflineUtils.b((InputStream)localObject1);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadFileAsString: fail to include - ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("AssetsComplementFileStringLoader", 2, ((StringBuilder)localObject2).toString());
        localIOException.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.AssetsComplementFileStringLoader
 * JD-Core Version:    0.7.0.1
 */