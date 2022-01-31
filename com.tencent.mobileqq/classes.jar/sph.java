public class sph
  implements spo
{
  public final spf[] a = new spf[2];
  
  private void a(spf paramspf, int paramInt)
  {
    this.a[paramInt] = paramspf;
  }
  
  public <T extends spf> T a(int paramInt)
  {
    spf localspf = this.a[paramInt];
    if (localspf == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localspf = this.a[paramInt];
        if (localspf == null) {
          break label80;
        }
        return localspf;
        a(localspf, paramInt);
        if (localspf != null) {
          localspf.b();
        }
        return localspf;
      }
      Object localObject2 = new squ();
      continue;
      localObject2 = new soy();
      continue;
      return localObject2;
      label80:
      switch (paramInt)
      {
      }
    }
  }
  
  public void a()
  {
    urk.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    urk.b("DataProviderManager", "onDestroy");
    spf[] arrayOfspf = this.a;
    int j = arrayOfspf.length;
    int i = 0;
    while (i < j)
    {
      spf localspf = arrayOfspf[i];
      if (localspf != null) {
        localspf.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sph
 * JD-Core Version:    0.7.0.1
 */