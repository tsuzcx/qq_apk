package cooperation.vip.vipcomponent.util;

import java.lang.ref.WeakReference;

public class ZipResEntry
{
  private static final Object h = new Object();
  private static ZipResEntry i;
  private static int j = 0;
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  public WeakReference<ZipResLoadListener> f;
  private ZipResEntry g;
  
  public ZipResEntry(String paramString1, int paramInt, String paramString2, WeakReference<ZipResLoadListener> paramWeakReference)
  {
    this.b = paramString1;
    this.c = paramInt;
    paramString1 = new StringBuilder();
    paramString1.append(this.b);
    paramString1.append(" ");
    paramString1.append(paramString2);
    this.a = paramString1.toString();
    this.f = paramWeakReference;
  }
  
  public static ZipResEntry a(String paramString1, int paramInt, String paramString2, WeakReference<ZipResLoadListener> paramWeakReference)
  {
    synchronized (h)
    {
      if (i != null)
      {
        ZipResEntry localZipResEntry = i;
        i = localZipResEntry.g;
        localZipResEntry.g = null;
        localZipResEntry.b = paramString1;
        localZipResEntry.e = paramString2;
        localZipResEntry.c = paramInt;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString2);
        localZipResEntry.a = localStringBuilder.toString();
        localZipResEntry.f = paramWeakReference;
        j -= 1;
        return localZipResEntry;
      }
      return new ZipResEntry(paramString1, paramInt, paramString2, paramWeakReference);
    }
  }
  
  private void b()
  {
    this.b = null;
    this.a = null;
    this.d = null;
    this.e = null;
    this.c = -1;
    this.f = null;
  }
  
  public void a()
  {
    b();
    synchronized (h)
    {
      if (j < 100)
      {
        this.g = i;
        i = this;
        j += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.util.ZipResEntry
 * JD-Core Version:    0.7.0.1
 */