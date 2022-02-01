package com.tencent.mobileqq.filemanager.util;

import android.graphics.Bitmap;
import auog;
import com.tencent.qphone.base.util.QLog;
import ff;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class FileManagerUtil$10
  implements Runnable
{
  public FileManagerUtil$10(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (auog.b(this.jdField_a_of_type_JavaLangString)) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = ff.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    } while (localBitmap == null);
    try
    {
      auog.a(localBitmap, this.jdField_a_of_type_JavaLangString);
      localBitmap.recycle();
      int i = ff.a(this.jdField_b_of_type_JavaLangString);
      ff.a(this.jdField_a_of_type_JavaLangString, i);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + localFileNotFoundException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + localIOException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + localOutOfMemoryError.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.10
 * JD-Core Version:    0.7.0.1
 */