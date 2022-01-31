package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.b;
import com.tencent.wxop.stat.common.r;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public class d
  extends e
{
  private String a;
  private int m;
  private int n = 100;
  private Thread o = null;
  
  public d(Context paramContext, int paramInt1, int paramInt2, Throwable paramThrowable, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt1, paramStatSpecifyReportedInfo);
    a(paramInt2, paramThrowable);
  }
  
  public d(Context paramContext, int paramInt1, int paramInt2, Throwable paramThrowable, Thread paramThread, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt1, paramStatSpecifyReportedInfo);
    a(paramInt2, paramThrowable);
    this.o = paramThread;
  }
  
  public d(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Thread paramThread, StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    super(paramContext, paramInt1, paramStatSpecifyReportedInfo);
    if (paramString != null)
    {
      paramInt1 = paramInt3;
      if (paramInt3 <= 0) {
        paramInt1 = StatConfig.getMaxReportEventLength();
      }
      if (paramString.length() > paramInt1) {
        break label61;
      }
    }
    label61:
    for (this.a = paramString;; this.a = paramString.substring(0, paramInt1))
    {
      this.o = paramThread;
      this.m = paramInt2;
      return;
    }
  }
  
  private void a(int paramInt, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringWriter localStringWriter = new StringWriter();
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramThrowable.printStackTrace(localPrintWriter);
      this.a = localStringWriter.toString();
      this.m = paramInt;
      localPrintWriter.close();
    }
  }
  
  public EventType a()
  {
    return EventType.ERROR;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "er", this.a);
    paramJSONObject.put("ea", this.m);
    if ((this.m == 2) || (this.m == 3)) {
      new b(this.l).a(paramJSONObject, this.o);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.wxop.stat.event.d
 * JD-Core Version:    0.7.0.1
 */