package com.tencent.turingfd.sdk.xq;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class throws
{
  public static final String[] _f = { "px", "dp", "sp", "pt", "in", "mm" };
  public switch ag;
  public Map<String, String> bg = new HashMap();
  public String[] cg;
  public int[] dg;
  public int eg;
  public int fg;
  public int gg;
  public int hg;
  public byte[] mData;
  
  public Document a(InputStream paramInputStream)
  {
    switch localswitch = new switch();
    this.ag = localswitch;
    this.mData = new byte[paramInputStream.available()];
    paramInputStream.read(this.mData);
    paramInputStream.close();
    for (;;)
    {
      int i = this.hg;
      if (i >= this.mData.length) {
        break;
      }
      i = f(i);
      if (i != -1)
      {
        if (i != 524291)
        {
          int j;
          if (i != 524672)
          {
            Object localObject1;
            int k;
            Object localObject2;
            int m;
            int n;
            int i1;
            int i2;
            if (i != 1835009)
            {
              switch (i)
              {
              default: 
                this.hg += 4;
                break;
              case 1048836: 
                paramInputStream = getString(f(this.hg + 16));
                localObject1 = this.ag;
                ((Node)((switch)localObject1).Yf.peek()).appendChild(((switch)localObject1).Zf.createCDATASection(paramInputStream));
                this.hg += 28;
                break;
              case 1048835: 
                i = f(this.hg + 16);
                getString(f(this.hg + 20));
                if (i != -1) {
                  getString(i);
                }
                this.ag.Yf.pop();
                this.hg += 24;
                break;
              case 1048834: 
                i = f(this.hg + 16);
                k = f(this.hg + 20);
                j = this.hg + 28;
                paramInputStream = this.mData;
                j = 0xFF00 & paramInputStream[(j + 1)] << 8 | paramInputStream[(j + 0)] << 0 & 0xFF;
                String str = getString(k);
                if (i == -1) {
                  paramInputStream = "";
                }
                do
                {
                  localObject2 = str;
                  localObject1 = paramInputStream;
                  break;
                  localObject1 = getString(i);
                  paramInputStream = (InputStream)localObject1;
                } while (!this.bg.containsKey(localObject1));
                paramInputStream = new StringBuilder();
                paramInputStream.append((String)this.bg.get(localObject1));
                paramInputStream.append(':');
                paramInputStream.append(str);
                localObject2 = paramInputStream.toString();
                this.hg += 36;
                static[] arrayOfstatic = new static[j];
                i = 0;
                while (i < j)
                {
                  k = f(this.hg);
                  m = f(this.hg + 4);
                  n = f(this.hg + 8);
                  i1 = f(this.hg + 12);
                  i2 = f(this.hg + 16);
                  static localstatic = new static();
                  localstatic.mName = getString(m);
                  if (k == -1)
                  {
                    localstatic.g(null);
                    localstatic.setPrefix(null);
                  }
                  else
                  {
                    paramInputStream = getString(k);
                    if (this.bg.containsKey(paramInputStream))
                    {
                      localstatic.g(paramInputStream);
                      localstatic.setPrefix((String)this.bg.get(paramInputStream));
                    }
                  }
                  if (n == -1)
                  {
                    switch (i1)
                    {
                    default: 
                      paramInputStream = String.format("%08X/0x%08X", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
                      break;
                    case 469762056: 
                    case 486539272: 
                      paramInputStream = String.format("#%08X", new Object[] { Integer.valueOf(i2) });
                      break;
                    case 301989896: 
                      boolean bool;
                      if (i2 != 0) {
                        bool = true;
                      } else {
                        bool = false;
                      }
                      paramInputStream = Boolean.toString(bool);
                      break;
                    case 268435464: 
                    case 285212680: 
                      paramInputStream = Integer.toString(i2);
                      break;
                    case 100663304: 
                      double d = i2;
                      Double.isNaN(d);
                      d /= 2147483647.0D;
                      paramInputStream = new DecimalFormat("#.##%").format(d);
                      break;
                    case 83886088: 
                      paramInputStream = new StringBuilder();
                      paramInputStream.append(Integer.toString(i2 >> 8));
                      paramInputStream.append(_f[(i2 & 0xFF)]);
                      paramInputStream = paramInputStream.toString();
                      break;
                    case 67108872: 
                      paramInputStream = Float.toString(Float.intBitsToFloat(i2));
                      break;
                    case 50331656: 
                      paramInputStream = getString(i2);
                      break;
                    case 33554440: 
                      paramInputStream = String.format("?id/0x%08X", new Object[] { Integer.valueOf(i2) });
                      break;
                    case 16777224: 
                      paramInputStream = String.format("@id/0x%08X", new Object[] { Integer.valueOf(i2) });
                    }
                    localstatic.setValue(paramInputStream);
                  }
                  else
                  {
                    localstatic.setValue(getString(n));
                  }
                  arrayOfstatic[i] = localstatic;
                  this.hg += 20;
                  i += 1;
                }
                this.ag.a((String)localObject1, str, (String)localObject2, arrayOfstatic);
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
              k = 0;
              m = f(this.hg + 4);
              this.eg = f(this.hg + 8);
              this.fg = f(this.hg + 12);
              n = this.hg;
              i1 = f(n + 20);
              i2 = f(this.hg + 24);
              this.cg = new String[this.eg];
              i = 0;
              while (i < this.eg)
              {
                int i3 = f((i + 7) * 4 + this.hg) + (i1 + n);
                localObject2 = this.cg;
                paramInputStream = this.mData;
                j = i3 + 1;
                if (paramInputStream[j] == paramInputStream[i3])
                {
                  i4 = paramInputStream[i3];
                  localObject1 = new byte[i4];
                  j = 0;
                  for (;;)
                  {
                    paramInputStream = (InputStream)localObject1;
                    if (j >= i4) {
                      break;
                    }
                    localObject1[j] = this.mData[(i3 + 2 + j)];
                    j += 1;
                  }
                }
                j = paramInputStream[j];
                int i4 = paramInputStream[i3] & 0xFF | j << 8 & 0xFF00;
                localObject1 = new byte[i4];
                j = 0;
                for (;;)
                {
                  paramInputStream = (InputStream)localObject1;
                  if (j >= i4) {
                    break;
                  }
                  localObject1[j] = this.mData[(j * 2 + (i3 + 2))];
                  j += 1;
                }
                localObject2[i] = new String(paramInputStream);
                i += 1;
              }
              if (i2 > 0)
              {
                i = k;
                while (i < this.fg) {
                  i += 1;
                }
              }
              this.hg += m;
            }
          }
          else
          {
            i = 0;
            j = f(this.hg + 4);
            this.gg = (j / 4 - 2);
            this.dg = new int[this.gg];
            while (i < this.gg)
            {
              this.dg[i] = f((i + 2) * 4 + this.hg);
              i += 1;
            }
            this.hg += j;
          }
        }
        else
        {
          paramInputStream = this.ag;
          paramInputStream.Zf = paramInputStream.mBuilder.newDocument();
          paramInputStream.Yf.push(paramInputStream.Zf);
          this.hg += 8;
        }
      }
      else {
        this.ag.endDocument();
      }
    }
    this.ag.endDocument();
    return localswitch.Zf;
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = f(this.hg + 16);
    String str1 = getString(f(this.hg + 20));
    String str2 = getString(i);
    if (paramBoolean)
    {
      this.ag.startPrefixMapping(str2, str1);
      this.bg.put(str1, str2);
    }
    else
    {
      this.ag.b(str2, str1);
      this.bg.remove(str1);
    }
    this.hg += 24;
  }
  
  public final int f(int paramInt)
  {
    byte[] arrayOfByte = this.mData;
    int i = arrayOfByte[(paramInt + 3)];
    int j = arrayOfByte[(paramInt + 2)];
    int k = arrayOfByte[(paramInt + 1)];
    return arrayOfByte[(paramInt + 0)] << 0 & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
  }
  
  public final String getString(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.eg)) {
      return this.cg[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.throws
 * JD-Core Version:    0.7.0.1
 */