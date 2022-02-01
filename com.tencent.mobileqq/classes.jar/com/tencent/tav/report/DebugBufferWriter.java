package com.tencent.tav.report;

import android.os.Build.VERSION;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class DebugBufferWriter
{
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private Path jdField_a_of_type_JavaNioFilePath;
  
  public DebugBufferWriter()
  {
    this("");
  }
  
  public DebugBufferWriter(String paramString)
  {
    this("/sdcard/tavkit_demo/buffers/", localStringBuilder.toString());
  }
  
  public DebugBufferWriter(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DebugBufferWriter@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_Long = -10086L;
    if (Build.VERSION.SDK_INT < 26)
    {
      Logger.e(this.jdField_a_of_type_JavaLangString, "DebugBufferWriter: Android O 可用");
      return;
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      paramString1.mkdirs();
    }
    paramString1 = new File(paramString1, paramString2);
    if (!paramString1.exists()) {
      try
      {
        paramString1.createNewFile();
      }
      catch (IOException paramString2)
      {
        Logger.e(this.jdField_a_of_type_JavaLangString, "DebugBufferWriter: ", paramString2);
      }
    }
    this.jdField_a_of_type_JavaNioFilePath = paramString1.toPath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.report.DebugBufferWriter
 * JD-Core Version:    0.7.0.1
 */