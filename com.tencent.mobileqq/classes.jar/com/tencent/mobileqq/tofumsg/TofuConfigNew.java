package com.tencent.mobileqq.tofumsg;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TofuConfigNew
{
  public int a;
  public long a;
  public int b = 1;
  
  public TofuConfigNew()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Long = 86400000L;
    a();
  }
  
  private void a()
  {
    a(SharedPreUtils.a());
  }
  
  public void a(String paramString)
  {
    QLog.d("TofuNew.TofuManagerConfig", 1, new Object[] { "parse config = ", paramString });
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("show_times_of_one_aio_one_bus_one_day", this.jdField_a_of_type_Int);
      this.b = paramString.optInt("show_times_of_one_aio_one_day", this.b);
      this.jdField_a_of_type_Long = paramString.optLong("show_time", this.jdField_a_of_type_Long);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuConfigNew
 * JD-Core Version:    0.7.0.1
 */