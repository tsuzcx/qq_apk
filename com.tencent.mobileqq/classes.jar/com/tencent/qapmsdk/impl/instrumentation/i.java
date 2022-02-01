package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.TargetApi;
import com.tencent.qapmsdk.impl.g.b;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

public class i
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
  
  public i()
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
    return "QAPMUnit{entryTimestamp=" + this.e + ", exitTimestamp=" + this.f + ", metricName='" + this.g + '\'' + ", children=" + this.n + ", isComplete=" + this.i + ", parentUuid=" + this.j + ", myUuid=" + this.k + ", threadId=" + this.l + ", threadName='" + this.m + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.i
 * JD-Core Version:    0.7.0.1
 */