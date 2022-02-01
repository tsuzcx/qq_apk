package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.TargetApi;
import com.tencent.qapmsdk.impl.g.b;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

public class j
{
  public long e = 0L;
  public long f = 0L;
  public String g = "";
  public String h = "";
  public boolean i = false;
  public UUID j = null;
  public final UUID k;
  public long l = 0L;
  public String m = "main";
  protected volatile Set<UUID> n;
  
  public j()
  {
    b();
    this.k = new UUID(b.a().nextLong(), b.a().nextLong());
    this.l = Thread.currentThread().getId();
    this.m = Thread.currentThread().getName();
  }
  
  @TargetApi(9)
  private void b()
  {
    if (this.n == null) {
      try
      {
        if (this.n == null) {
          this.n = new ConcurrentSkipListSet();
        }
        return;
      }
      finally {}
    }
  }
  
  public void a()
  {
    this.f = System.currentTimeMillis();
    this.i = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAPMUnit{entryTimestamp=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", exitTimestamp=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", metricName='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", children=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", isComplete=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", parentUuid=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", myUuid=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", threadId=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", threadName='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.j
 * JD-Core Version:    0.7.0.1
 */