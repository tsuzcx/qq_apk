package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.Log;

public class a$a
{
  public int a;
  public int b;
  public a.b c = new com.tencent.xweb.internal.a.c();
  public String d;
  public float e = -1.0F;
  public float f = -1.0F;
  public String g;
  public String h;
  public a.c[] i;
  public int j;
  public String k;
  public boolean l;
  public boolean m;
  public boolean n;
  public String o;
  public String p;
  public String q;
  
  public int[] a()
  {
    if (TextUtils.isEmpty(this.g)) {
      return null;
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = this.g.split(":");
    int i3 = localObject2.length;
    int i2 = 0;
    int i1 = 0;
    while (i1 < i3)
    {
      Object localObject3 = localObject2[i1];
      int i4;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = e.b((String)localObject3);
        if (!((e.a)localObject3).a) {
          break label169;
        }
        i4 = ((e.a)localObject3).b();
        if ((i4 >= 0) && (i4 <= 10000)) {
          ((List)localObject1).add(localObject3);
        }
      }
      else
      {
        i1 += 1;
        continue;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" get invalid schedule value = ");
      ((StringBuilder)localObject1).append(i4);
      ((StringBuilder)localObject1).append(", schedule str is ");
      ((StringBuilder)localObject1).append(this.g);
      Log.e("ConfigParser", ((StringBuilder)localObject1).toString());
      return null;
      label169:
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" parse schedule failed , schedule str is ");
      ((StringBuilder)localObject1).append(this.g);
      Log.e("ConfigParser", ((StringBuilder)localObject1).toString());
      return null;
    }
    if (((List)localObject1).size() == 0) {
      return null;
    }
    localObject2 = new int[((List)localObject1).size()];
    i1 = i2;
    while (i1 < ((List)localObject1).size())
    {
      i2 = ((e.a)((List)localObject1).get(i1)).b();
      if ((i1 > 0) && (i2 < localObject2[(i1 - 1)]))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" get invalid schedule this value smaller than previous one , schedule str is ");
        ((StringBuilder)localObject1).append(this.g);
        Log.e("ConfigParser", ((StringBuilder)localObject1).toString());
        return null;
      }
      localObject2[i1] = i2;
      i1 += 1;
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a.a
 * JD-Core Version:    0.7.0.1
 */