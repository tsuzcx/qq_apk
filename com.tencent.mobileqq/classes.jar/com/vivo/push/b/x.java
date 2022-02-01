package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.a;
import java.util.HashMap;

public final class x
  extends com.vivo.push.o
{
  private HashMap<String, String> a;
  private long b;
  
  public x()
  {
    super(2012);
  }
  
  public x(long paramLong)
  {
    this();
    this.b = paramLong;
  }
  
  public final void a(HashMap<String, String> paramHashMap)
  {
    this.a = paramHashMap;
  }
  
  public final void c(a parama)
  {
    parama.a("ReporterCommand.EXTRA_PARAMS", this.a);
    parama.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
  }
  
  public final void d()
  {
    if (this.a == null)
    {
      com.vivo.push.util.o.d("ReporterCommand", "reportParams is empty");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("report message reportType:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",msgId:");
    String str = (String)this.a.get("messageID");
    if (TextUtils.isEmpty(str)) {
      str = (String)this.a.get("message_id");
    }
    localStringBuilder.append(str);
    com.vivo.push.util.o.d("ReporterCommand", localStringBuilder.toString());
  }
  
  public final void d(a parama)
  {
    this.a = ((HashMap)parama.d("ReporterCommand.EXTRA_PARAMS"));
    this.b = parama.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.b);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ReporterCommand（");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.b.x
 * JD-Core Version:    0.7.0.1
 */