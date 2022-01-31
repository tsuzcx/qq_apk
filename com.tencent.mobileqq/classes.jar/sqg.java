public class sqg
  implements spo
{
  public final spo[] a = new spo[40];
  
  public static spo a(int paramInt)
  {
    return sqi.a.b(paramInt);
  }
  
  public static sqg a()
  {
    return sqi.a;
  }
  
  private void a(int paramInt, spo paramspo)
  {
    this.a[paramInt] = paramspo;
  }
  
  public void a() {}
  
  public spo b(int paramInt)
  {
    spo localspo1 = this.a[paramInt];
    if (localspo1 == null) {}
    for (;;)
    {
      spo localspo2;
      synchronized (this.a)
      {
        localspo2 = this.a[paramInt];
        if (localspo2 == null) {
          break label408;
        }
        return localspo2;
        if (localspo1 != null)
        {
          localspo1.a();
          urk.b("Q.qqstory.SuperManager", "onInit manager : %s", localspo1);
        }
        a(paramInt, localspo1);
        return localspo1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new sqm();
      continue;
      localObject2 = new txz();
      continue;
      localObject2 = new sre();
      continue;
      localObject2 = new spz();
      continue;
      localObject2 = new srz();
      continue;
      localObject2 = new uyz();
      continue;
      localObject2 = new bikm();
      continue;
      localObject2 = new sqs();
      continue;
      localObject2 = new sia();
      continue;
      localObject2 = new sgm();
      continue;
      localObject2 = new sis();
      continue;
      localObject2 = new sqd();
      continue;
      localObject2 = new spw();
      continue;
      localObject2 = new sjr();
      continue;
      localObject2 = new sps();
      continue;
      localObject2 = new spu();
      continue;
      localObject2 = new spd();
      continue;
      localObject2 = new spt();
      continue;
      localObject2 = new sph();
      continue;
      localObject2 = new sqr();
      continue;
      localObject2 = new spm();
      continue;
      localObject2 = new uje();
      continue;
      localObject2 = new ujk();
      continue;
      localObject2 = new sqo();
      continue;
      localObject2 = new uac();
      continue;
      localObject2 = new spn();
      continue;
      localObject2 = new sqj();
      continue;
      localObject2 = new sgs();
      continue;
      localObject2 = new sqe();
      continue;
      localObject2 = new scu();
      continue;
      return localObject2;
      label408:
      localObject2 = localspo2;
      switch (paramInt)
      {
      }
      localObject2 = localspo2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    spo[] arrayOfspo = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        spo localspo = this.a[i];
        urk.b("Q.qqstory.SuperManager", "destroy manager : %s", localspo);
        if (localspo != null) {
          localspo.b();
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
 * Qualified Name:     sqg
 * JD-Core Version:    0.7.0.1
 */