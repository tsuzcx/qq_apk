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
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadAssetFile jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersFileReadAssetFile;
  private String jdField_a_of_type_JavaLangString;
  
  public AssetsComplementFileStringLoader(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersFileReadAssetFile = new ReadAssetFile(paramContext, paramString);
  }
  
  public String loadFileAsString(String paramString)
  {
    AssetManager localAssetManager = this.jdField_a_of_type_AndroidContentContext.getAssets();
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersFileReadAssetFile.a(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = localAssetManager.open(((StringBuilder)localObject1).toString());
      }
      localObject1 = OfflineUtils.a((InputStream)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.AssetsComplementFileStringLoader
 * JD-Core Version:    0.7.0.1
 */