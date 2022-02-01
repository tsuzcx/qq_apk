package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class PreloadImgApiImpl$3
  implements Runnable
{
  PreloadImgApiImpl$3(PreloadImgApiImpl paramPreloadImgApiImpl, Set paramSet, String paramString1, String paramString2, AppInterface paramAppInterface, List paramList, String paramString3, Map paramMap, Bundle paramBundle) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = MD5.toMD5(str1);
        File localFile2 = new File(this.jdField_a_of_type_JavaLangString, str2);
        File localFile1 = localFile2;
        if (!localFile2.exists()) {
          localFile1 = new File(this.b, str2);
        }
        if ((!localFile1.exists()) || (PreloadImgApiImpl.access$000(this.this$0, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), localFile1.getPath(), str1) == null))
        {
          this.jdField_a_of_type_JavaUtilList.add(str1);
          localFile1 = new File(this.c, str2);
          this.jdField_a_of_type_JavaUtilMap.put(str1, localFile1);
          this.jdField_a_of_type_AndroidOsBundle.putString(str1, localFile1.getPath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadImgApiImpl.3
 * JD-Core Version:    0.7.0.1
 */