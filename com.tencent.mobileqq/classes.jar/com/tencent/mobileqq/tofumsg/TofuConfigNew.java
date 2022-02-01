package com.tencent.mobileqq.tofumsg;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TofuConfigNew
{
  public int a = 1;
  public int b = 1;
  public long c = 86400000L;
  
  public TofuConfigNew()
  {
    a();
  }
  
  private void a()
  {
    a(SharedPreUtils.r());
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
      this.a = paramString.optInt("show_times_of_one_aio_one_bus_one_day", this.a);
      this.b = paramString.optInt("show_times_of_one_aio_one_day", this.b);
      this.c = paramString.optLong("show_time", this.c);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuConfigNew
 * JD-Core Version:    0.7.0.1
 */