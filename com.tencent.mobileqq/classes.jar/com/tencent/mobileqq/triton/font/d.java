package com.tencent.mobileqq.triton.font;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class d
{
  private final Set<String> a = new HashSet();
  private a b;
  private Map<e, c> c;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  
  private boolean a(a parama, e parame, long paramLong)
  {
    parame = (c)this.c.get(parame);
    if (parame == null) {
      return false;
    }
    parama.a(parame.a() + paramLong);
    return true;
  }
  
  private void c()
  {
    this.b.c();
    int j = this.b.f();
    this.b.b(6L);
    this.c = new HashMap();
    c[] arrayOfc = new c[j];
    int i = 0;
    while (i < j)
    {
      arrayOfc[i] = new c();
      String str = arrayOfc[i].a(this.b);
      this.c.put(e.a(str), arrayOfc[i]);
      i += 1;
    }
    this.c.put(e.b, new c(0L, this.b.a()));
  }
  
  private void d()
  {
    a(this.b, e.c, 2L);
    int k = this.b.a();
    int i = this.b.f();
    int m = this.b.f();
    int j = k + 4;
    if (i > 0)
    {
      this.b.a(j);
      int n = this.b.f();
      int i1 = this.b.f();
      int i2 = this.b.f();
      int i3 = this.b.f();
      int i4 = this.b.f();
      Object localObject;
      if (((n == 1) || (n == 3)) && ((i1 == 0) || (i1 == 1)))
      {
        localObject = this.b;
        ((a)localObject).a(((a)localObject).f() + (m + k - 2));
        if (n != 3) {
          break label217;
        }
        localObject = this.b.a(i4, i1);
        label168:
        if (i3 == 0) {
          break label317;
        }
        if (i3 == 1) {
          break label302;
        }
        if (i3 == 2) {
          break label283;
        }
        if (i3 == 4) {
          break label250;
        }
        if (i3 == 6) {
          break label231;
        }
        if (i3 == 16) {
          break label302;
        }
      }
      label283:
      label302:
      label317:
      for (;;)
      {
        j += 12;
        i -= 1;
        break;
        label217:
        localObject = this.b.a(i4);
        break label168;
        label231:
        if (this.d.length() == 0)
        {
          this.d = ((String)localObject);
          continue;
          label250:
          if ((this.e.length() == 0) || ((n == 3) && (i2 == 1033)))
          {
            this.e = ((String)localObject);
            continue;
            if (this.g.length() == 0)
            {
              this.g = ((String)localObject);
              continue;
              this.a.add(localObject);
              continue;
              if (this.f.length() == 0) {
                this.f = ((String)localObject);
              }
            }
          }
        }
      }
    }
  }
  
  public Set<String> a()
  {
    return this.a;
  }
  
  void a(a parama)
  {
    this.b = parama;
    c();
    d();
  }
  
  public String b()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.d
 * JD-Core Version:    0.7.0.1
 */