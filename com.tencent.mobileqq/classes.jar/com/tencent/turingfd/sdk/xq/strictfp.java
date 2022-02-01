package com.tencent.turingfd.sdk.xq;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class strictfp
{
  public static final String[] a = { "px", "dp", "sp", "pt", "in", "mm" };
  public continue b;
  public Map<String, String> c = new HashMap();
  public byte[] d;
  public String[] e;
  public int[] f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public final int a(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int k = arrayOfByte[(paramInt + 3)];
    int m = arrayOfByte[(paramInt + 2)];
    int n = arrayOfByte[(paramInt + 1)];
    return arrayOfByte[(paramInt + 0)] << 0 & 0xFF | k << 24 & 0xFF000000 | m << 16 & 0xFF0000 | n << 8 & 0xFF00;
  }
  
  public Document a(InputStream paramInputStream)
  {
    continue localcontinue = new continue();
    this.b = localcontinue;
    Object localObject1 = new byte[paramInputStream.available()];
    this.d = ((byte[])localObject1);
    paramInputStream.read((byte[])localObject1);
    paramInputStream.close();
    for (;;)
    {
      int k = this.j;
      if (k >= this.d.length) {
        break;
      }
      k = a(k);
      if (k != -1)
      {
        if (k != 524291)
        {
          int m;
          int n;
          if (k != 524672)
          {
            Object localObject2;
            int i1;
            int i2;
            int i3;
            int i4;
            if (k != 1835009)
            {
              switch (k)
              {
              default: 
                this.j += 4;
                break;
              case 1048836: 
                paramInputStream = b(a(this.j + 16));
                localObject1 = this.b;
                ((Node)((continue)localObject1).a.peek()).appendChild(((continue)localObject1).b.createCDATASection(paramInputStream));
                this.j += 28;
                break;
              case 1048835: 
                k = a(this.j + 16);
                b(a(this.j + 20));
                if (k != -1) {
                  b(k);
                }
                this.b.a.pop();
                this.j += 24;
                break;
              case 1048834: 
                k = a(this.j + 16);
                m = a(this.j + 20);
                n = this.j + 28;
                paramInputStream = this.d;
                n = 0xFF00 & paramInputStream[(n + 1)] << 8 | paramInputStream[(n + 0)] << 0 & 0xFF;
                localObject2 = b(m);
                Object localObject3;
                if (k == -1)
                {
                  localObject1 = localObject2;
                  localObject3 = "";
                }
                else
                {
                  localObject3 = b(k);
                  if (this.c.containsKey(localObject3))
                  {
                    paramInputStream = new StringBuilder();
                    paramInputStream.append((String)this.c.get(localObject3));
                    paramInputStream.append(':');
                    paramInputStream.append((String)localObject2);
                    localObject1 = paramInputStream.toString();
                  }
                  else
                  {
                    localObject1 = localObject2;
                  }
                }
                this.j += 36;
                abstract[] arrayOfabstract = new abstract[n];
                k = 0;
                while (k < n)
                {
                  m = a(this.j);
                  i1 = a(this.j + 4);
                  i2 = a(this.j + 8);
                  i3 = a(this.j + 12);
                  i4 = a(this.j + 16);
                  localObject4 = new abstract();
                  ((abstract)localObject4).a = b(i1);
                  if (m == -1)
                  {
                    ((abstract)localObject4).c = null;
                    ((abstract)localObject4).b = null;
                  }
                  else
                  {
                    paramInputStream = b(m);
                    if (this.c.containsKey(paramInputStream))
                    {
                      ((abstract)localObject4).c = paramInputStream;
                      ((abstract)localObject4).b = ((String)this.c.get(paramInputStream));
                    }
                  }
                  if (i2 == -1)
                  {
                    switch (i3)
                    {
                    default: 
                      paramInputStream = String.format("%08X/0x%08X", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
                      break;
                    case 469762056: 
                    case 486539272: 
                      paramInputStream = String.format("#%08X", new Object[] { Integer.valueOf(i4) });
                      break;
                    case 301989896: 
                      boolean bool;
                      if (i4 != 0) {
                        bool = true;
                      } else {
                        bool = false;
                      }
                      paramInputStream = Boolean.toString(bool);
                      break;
                    case 268435464: 
                    case 285212680: 
                      paramInputStream = Integer.toString(i4);
                      break;
                    case 100663304: 
                      double d1 = i4;
                      Double.isNaN(d1);
                      d1 /= 2147483647.0D;
                      paramInputStream = new DecimalFormat("#.##%").format(d1);
                      break;
                    case 83886088: 
                      paramInputStream = new StringBuilder();
                      paramInputStream.append(Integer.toString(i4 >> 8));
                      paramInputStream.append(a[(i4 & 0xFF)]);
                      paramInputStream = paramInputStream.toString();
                      break;
                    case 67108872: 
                      paramInputStream = Float.toString(Float.intBitsToFloat(i4));
                      break;
                    case 50331656: 
                      paramInputStream = b(i4);
                      break;
                    case 33554440: 
                      paramInputStream = String.format("?id/0x%08X", new Object[] { Integer.valueOf(i4) });
                      break;
                    case 16777224: 
                      paramInputStream = String.format("@id/0x%08X", new Object[] { Integer.valueOf(i4) });
                    }
                    ((abstract)localObject4).d = paramInputStream;
                  }
                  else
                  {
                    ((abstract)localObject4).d = b(i2);
                  }
                  arrayOfabstract[k] = localObject4;
                  this.j += 20;
                  k += 1;
                }
                Object localObject4 = this.b;
                localObject4.getClass();
                if ((localObject3 != null) && (!"".equals(localObject3))) {
                  k = 0;
                } else {
                  k = 1;
                }
                if (k != 0) {
                  paramInputStream = ((continue)localObject4).b.createElement((String)localObject2);
                } else {
                  paramInputStream = ((continue)localObject4).b.createElementNS((String)localObject3, (String)localObject1);
                }
                k = 0;
                while (k < n)
                {
                  localObject1 = arrayOfabstract[k];
                  localObject2 = ((abstract)localObject1).c;
                  if ((localObject2 != null) && (!"".equals(localObject2))) {
                    m = 0;
                  } else {
                    m = 1;
                  }
                  if (m != 0)
                  {
                    paramInputStream.setAttribute(((abstract)localObject1).a, ((abstract)localObject1).d);
                  }
                  else
                  {
                    localObject2 = ((abstract)localObject1).c;
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append(((abstract)localObject1).b);
                    ((StringBuilder)localObject3).append(':');
                    ((StringBuilder)localObject3).append(((abstract)localObject1).a);
                    paramInputStream.setAttributeNS((String)localObject2, ((StringBuilder)localObject3).toString(), ((abstract)localObject1).d);
                  }
                  k += 1;
                }
                ((Node)((continue)localObject4).a.peek()).appendChild(paramInputStream);
                ((continue)localObject4).a.push(paramInputStream);
                break;
              case 1048833: 
                a(false);
                break;
              case 1048832: 
                a(true);
                break;
              }
            }
            else
            {
              n = 0;
              i1 = a(this.j + 4);
              this.g = a(this.j + 8);
              this.h = a(this.j + 12);
              i2 = this.j;
              i3 = a(i2 + 20);
              i4 = a(this.j + 24);
              this.e = new String[this.g];
              k = 0;
              while (k < this.g)
              {
                int i5 = a(this.j + (k + 7) * 4) + (i2 + i3);
                localObject2 = this.e;
                paramInputStream = this.d;
                m = i5 + 1;
                if (paramInputStream[m] == paramInputStream[i5])
                {
                  i6 = paramInputStream[i5];
                  localObject1 = new byte[i6];
                  m = 0;
                  for (;;)
                  {
                    paramInputStream = (InputStream)localObject1;
                    if (m >= i6) {
                      break;
                    }
                    localObject1[m] = this.d[(i5 + 2 + m)];
                    m += 1;
                  }
                }
                m = paramInputStream[m];
                int i6 = paramInputStream[i5] & 0xFF | m << 8 & 0xFF00;
                localObject1 = new byte[i6];
                m = 0;
                for (;;)
                {
                  paramInputStream = (InputStream)localObject1;
                  if (m >= i6) {
                    break;
                  }
                  localObject1[m] = this.d[(i5 + 2 + m * 2)];
                  m += 1;
                }
                localObject2[k] = new String(paramInputStream);
                k += 1;
              }
              if (i4 > 0)
              {
                k = n;
                while (k < this.h) {
                  k += 1;
                }
              }
              this.j += i1;
            }
          }
          else
          {
            k = 0;
            m = a(this.j + 4);
            n = m / 4 - 2;
            this.i = n;
            this.f = new int[n];
            while (k < this.i)
            {
              this.f[k] = a(this.j + (k + 2) * 4);
              k += 1;
            }
            this.j += m;
          }
        }
        else
        {
          paramInputStream = this.b;
          localObject1 = paramInputStream.c.newDocument();
          paramInputStream.b = ((Document)localObject1);
          paramInputStream.a.push(localObject1);
          this.j += 8;
        }
      }
      else {
        this.b.getClass();
      }
    }
    this.b.getClass();
    return localcontinue.b;
  }
  
  public final void a(boolean paramBoolean)
  {
    int k = a(this.j + 16);
    String str1 = b(a(this.j + 20));
    String str2 = b(k);
    if (paramBoolean)
    {
      this.b.getClass();
      this.c.put(str1, str2);
    }
    else
    {
      this.b.getClass();
      this.c.remove(str1);
    }
    this.j += 24;
  }
  
  public final String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.g)) {
      return this.e[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.strictfp
 * JD-Core Version:    0.7.0.1
 */