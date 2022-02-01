package com.tencent.util;

import antf;
import bhmi;
import bhmq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.QLog;
import fd;
import java.io.File;
import java.io.IOException;
import zom;

public final class AutoSaveUtils$1
  implements Runnable
{
  public AutoSaveUtils$1(String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = localFile.getAbsolutePath();
    String str2 = antf.bn;
    new File(str2).mkdirs();
    String str1 = Utils.Crc64String((String)localObject1);
    if (!str1.contains(".")) {
      if (this.jdField_a_of_type_Boolean) {
        localObject1 = bhmi.b((String)localObject1);
      }
    }
    Object localObject2;
    for (localObject1 = str1 + "." + (String)localObject1;; localObject2 = str1)
    {
      localObject1 = new File(str2, (String)localObject1);
      for (;;)
      {
        try
        {
          if ((!((File)localObject1).exists()) && (((File)localObject1).createNewFile()) && (fd.a(localFile, (File)localObject1)))
          {
            if (!this.jdField_a_of_type_Boolean) {
              continue;
            }
            bhmq.a(BaseApplicationImpl.getApplication(), (File)localObject1);
            FileProvider7Helper.savePhotoToSysAlbum(BaseApplicationImpl.getApplication(), (File)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("AutoSaveUtils", 2, "autoSavePic success:" + ((File)localObject1).getAbsolutePath());
            }
          }
          return;
        }
        catch (IOException localIOException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("AutoSaveUtils", 2, "autoSavePic", localIOException);
          return;
        }
        localObject1 = bhmi.a((String)localObject1);
        break;
        zom.a(BaseApplicationImpl.getApplication(), (File)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.AutoSaveUtils.1
 * JD-Core Version:    0.7.0.1
 */