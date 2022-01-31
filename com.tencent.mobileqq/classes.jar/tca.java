public class tca
  implements tch
{
  public final tby[] a = new tby[2];
  
  private void a(tby paramtby, int paramInt)
  {
    this.a[paramInt] = paramtby;
  }
  
  public <T extends tby> T a(int paramInt)
  {
    tby localtby = this.a[paramInt];
    if (localtby == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localtby = this.a[paramInt];
        if (localtby == null) {
          break label80;
        }
        return localtby;
        a(localtby, paramInt);
        if (localtby != null) {
          localtby.b();
        }
        return localtby;
      }
      Object localObject2 = new tdn();
      continue;
      localObject2 = new tbr();
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
    ved.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    ved.b("DataProviderManager", "onDestroy");
    tby[] arrayOftby = this.a;
    int j = arrayOftby.length;
    int i = 0;
    while (i < j)
    {
      tby localtby = arrayOftby[i];
      if (localtby != null) {
        localtby.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tca
 * JD-Core Version:    0.7.0.1
 */