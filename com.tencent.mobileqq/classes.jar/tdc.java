public class tdc
  implements tck
{
  public final tck[] a = new tck[40];
  
  public static tck a(int paramInt)
  {
    return tde.a.b(paramInt);
  }
  
  public static tdc a()
  {
    return tde.a;
  }
  
  private void a(int paramInt, tck paramtck)
  {
    this.a[paramInt] = paramtck;
  }
  
  public void a() {}
  
  public tck b(int paramInt)
  {
    tck localtck1 = this.a[paramInt];
    if (localtck1 == null) {}
    for (;;)
    {
      tck localtck2;
      synchronized (this.a)
      {
        localtck2 = this.a[paramInt];
        if (localtck2 == null) {
          break label408;
        }
        return localtck2;
        if (localtck1 != null)
        {
          localtck1.a();
          veg.b("Q.qqstory.SuperManager", "onInit manager : %s", localtck1);
        }
        a(paramInt, localtck1);
        return localtck1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new tdi();
      continue;
      localObject2 = new ukv();
      continue;
      localObject2 = new tea();
      continue;
      localObject2 = new tcv();
      continue;
      localObject2 = new tev();
      continue;
      localObject2 = new vlv();
      continue;
      localObject2 = new bkbh();
      continue;
      localObject2 = new tdo();
      continue;
      localObject2 = new suw();
      continue;
      localObject2 = new sti();
      continue;
      localObject2 = new svo();
      continue;
      localObject2 = new tcz();
      continue;
      localObject2 = new tcs();
      continue;
      localObject2 = new swn();
      continue;
      localObject2 = new tco();
      continue;
      localObject2 = new tcq();
      continue;
      localObject2 = new tbz();
      continue;
      localObject2 = new tcp();
      continue;
      localObject2 = new tcd();
      continue;
      localObject2 = new tdn();
      continue;
      localObject2 = new tci();
      continue;
      localObject2 = new uwa();
      continue;
      localObject2 = new uwg();
      continue;
      localObject2 = new tdk();
      continue;
      localObject2 = new umy();
      continue;
      localObject2 = new tcj();
      continue;
      localObject2 = new tdf();
      continue;
      localObject2 = new sto();
      continue;
      localObject2 = new tda();
      continue;
      localObject2 = new spq();
      continue;
      return localObject2;
      label408:
      localObject2 = localtck2;
      switch (paramInt)
      {
      }
      localObject2 = localtck2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    tck[] arrayOftck = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        tck localtck = this.a[i];
        veg.b("Q.qqstory.SuperManager", "destroy manager : %s", localtck);
        if (localtck != null) {
          localtck.b();
        }
        this.a[i] = null;
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tdc
 * JD-Core Version:    0.7.0.1
 */