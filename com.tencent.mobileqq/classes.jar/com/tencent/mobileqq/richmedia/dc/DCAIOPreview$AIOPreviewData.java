package com.tencent.mobileqq.richmedia.dc;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DCAIOPreview$AIOPreviewData
  extends DataAdapter
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String d;
  
  private void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = Math.max((SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / 1000L, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  private void b()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 0)) {
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if (this.jdField_b_of_type_Int <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(DataCollector.jdField_a_of_type_JavaLangString, 4, "View count is 0!");
      }
      return null;
    }
    if ("Pic.AioPreview".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("stay_seconds", String.valueOf(this.jdField_a_of_type_Long));
      paramString.put("gesture_double_click", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("view_count", String.valueOf(this.jdField_b_of_type_Int));
      paramString.put("send_type", this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {
        paramString.put("view_again", "1");
      }
      String str = this.jdField_b_of_type_JavaLangString;
      if (str != null) {
        paramString.put("size_type", str);
      }
      str = this.jdField_c_of_type_JavaLangString;
      if (str != null) {
        paramString.put("format_type", str);
      }
      return paramString;
    }
    if (("Pic.AioPreview.Preload".equals(paramString)) && (this.d != null))
    {
      paramString = new HashMap();
      paramString.put("preload_status", String.valueOf(this.jdField_c_of_type_Boolean));
      paramString.put("preload_fail_filetype", this.d);
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview.AIOPreviewData
 * JD-Core Version:    0.7.0.1
 */