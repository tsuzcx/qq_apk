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
  private AssetManager jdField_a_of_type_AndroidContentResAssetManager;
  private String jdField_a_of_type_JavaLangString;
  
  public ReadAssetFile(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentResAssetManager = paramContext.getAssets();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public InputStream a(String paramString)
  {
    AssetManager localAssetManager = this.jdField_a_of_type_AndroidContentResAssetManager;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return localAssetManager.open(localStringBuilder.toString());
  }
  
  public List<String> a()
  {
    try
    {
      List localList = OfflineUtils.a(this.jdField_a_of_type_AndroidContentResAssetManager, this.jdField_a_of_type_JavaLangString);
      if (localList != null) {
        return localList;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadAssetFile", 1, "tryLoadTemplateFromAssets fileList size: ", localException);
      String[] arrayOfString = this.jdField_a_of_type_AndroidContentResAssetManager.list(this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.file.ReadAssetFile
 * JD-Core Version:    0.7.0.1
 */