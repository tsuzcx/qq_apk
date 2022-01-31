public class tcd
  implements tck
{
  public final tcb[] a = new tcb[2];
  
  private void a(tcb paramtcb, int paramInt)
  {
    this.a[paramInt] = paramtcb;
  }
  
  public <T extends tcb> T a(int paramInt)
  {
    tcb localtcb = this.a[paramInt];
    if (localtcb == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localtcb = this.a[paramInt];
        if (localtcb == null) {
          break label80;
        }
        return localtcb;
        a(localtcb, paramInt);
        if (localtcb != null) {
          localtcb.b();
        }
        return localtcb;
      }
      Object localObject2 = new tdq();
      continue;
      localObject2 = new tbu();
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
    veg.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    veg.b("DataProviderManager", "onDestroy");
    tcb[] arrayOftcb = this.a;
    int j = arrayOftcb.length;
    int i = 0;
    while (i < j)
    {
      tcb localtcb = arrayOftcb[i];
      if (localtcb != null) {
        localtcb.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcd
 * JD-Core Version:    0.7.0.1
 */