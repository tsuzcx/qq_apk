package com.tencent.util;

import android.os.Debug;
import com.tencent.mobileqq.app.AppConstants;
import java.io.IOException;

public class ImageTestUtil
{
  private static boolean jdField_a_of_type_Boolean = false;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "35872667", "354653668", "270749863", "279242625", "1849510872" };
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = jdField_a_of_type_ArrayOfJavaLangString;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].equals(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_IMG_SAVE);
        ((StringBuilder)localObject).append("dump_");
        localObject = ((StringBuilder)localObject).toString();
      }
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString);
        localStringBuilder.append(System.currentTimeMillis());
        Debug.dumpHprofData(localStringBuilder.toString());
        jdField_a_of_type_Boolean = true;
        return;
      }
      catch (IOException paramString) {}
      i += 1;
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.ImageTestUtil
 * JD-Core Version:    0.7.0.1
 */