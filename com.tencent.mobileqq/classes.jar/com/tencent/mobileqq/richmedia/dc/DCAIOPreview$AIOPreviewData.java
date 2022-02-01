package com.tencent.mobileqq.richmedia.dc;

import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DCAIOPreview$AIOPreviewData
  extends DataAdapter
{
  private int a;
  private long b;
  private int c;
  private boolean d;
  private boolean e;
  private long f;
  private String g;
  private String h;
  private String i;
  private boolean j;
  private String k;
  
  private void a()
  {
    if (this.e)
    {
      this.b = Math.max((SystemClock.uptimeMillis() - this.f) / 1000L, this.b);
      this.f = 0L;
      this.e = false;
    }
  }
  
  private void b()
  {
    if ((this.e) && (this.a == 0)) {
      this.a = 1;
    }
  }
  
  public HashMap<String, String> a(String paramString)
  {
    if (this.c <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(DataCollector.a, 4, "View count is 0!");
      }
      return null;
    }
    if ("Pic.AioPreview".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("stay_seconds", String.valueOf(this.b));
      paramString.put("gesture_double_click", String.valueOf(this.a));
      paramString.put("view_count", String.valueOf(this.c));
      paramString.put("send_type", this.g);
      if (this.d) {
        paramString.put("view_again", "1");
      }
      String str = this.h;
      if (str != null) {
        paramString.put("size_type", str);
      }
      str = this.i;
      if (str != null) {
        paramString.put("format_type", str);
      }
      return paramString;
    }
    if (("Pic.AioPreview.Preload".equals(paramString)) && (this.k != null))
    {
      paramString = new HashMap();
      paramString.put("preload_status", String.valueOf(this.j));
      paramString.put("preload_fail_filetype", this.k);
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview.AIOPreviewData
 * JD-Core Version:    0.7.0.1
 */