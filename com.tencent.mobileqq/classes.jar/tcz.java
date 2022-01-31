public class tcz
  implements tch
{
  public final tch[] a = new tch[40];
  
  public static tch a(int paramInt)
  {
    return tdb.a.b(paramInt);
  }
  
  public static tcz a()
  {
    return tdb.a;
  }
  
  private void a(int paramInt, tch paramtch)
  {
    this.a[paramInt] = paramtch;
  }
  
  public void a() {}
  
  public tch b(int paramInt)
  {
    tch localtch1 = this.a[paramInt];
    if (localtch1 == null) {}
    for (;;)
    {
      tch localtch2;
      synchronized (this.a)
      {
        localtch2 = this.a[paramInt];
        if (localtch2 == null) {
          break label408;
        }
        return localtch2;
        if (localtch1 != null)
        {
          localtch1.a();
          ved.b("Q.qqstory.SuperManager", "onInit manager : %s", localtch1);
        }
        a(paramInt, localtch1);
        return localtch1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new tdf();
      continue;
      localObject2 = new uks();
      continue;
      localObject2 = new tdx();
      continue;
      localObject2 = new tcs();
      continue;
      localObject2 = new tes();
      continue;
      localObject2 = new vls();
      continue;
      localObject2 = new bkby();
      continue;
      localObject2 = new tdl();
      continue;
      localObject2 = new sut();
      continue;
      localObject2 = new stf();
      continue;
      localObject2 = new svl();
      continue;
      localObject2 = new tcw();
      continue;
      localObject2 = new tcp();
      continue;
      localObject2 = new swk();
      continue;
      localObject2 = new tcl();
      continue;
      localObject2 = new tcn();
      continue;
      localObject2 = new tbw();
      continue;
      localObject2 = new tcm();
      continue;
      localObject2 = new tca();
      continue;
      localObject2 = new tdk();
      continue;
      localObject2 = new tcf();
      continue;
      localObject2 = new uvx();
      continue;
      localObject2 = new uwd();
      continue;
      localObject2 = new tdh();
      continue;
      localObject2 = new umv();
      continue;
      localObject2 = new tcg();
      continue;
      localObject2 = new tdc();
      continue;
      localObject2 = new stl();
      continue;
      localObject2 = new tcx();
      continue;
      localObject2 = new spn();
      continue;
      return localObject2;
      label408:
      localObject2 = localtch2;
      switch (paramInt)
      {
      }
      localObject2 = localtch2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    tch[] arrayOftch = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        tch localtch = this.a[i];
        ved.b("Q.qqstory.SuperManager", "destroy manager : %s", localtch);
        if (localtch != null) {
          localtch.b();
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
 * Qualified Name:     tcz
 * JD-Core Version:    0.7.0.1
 */