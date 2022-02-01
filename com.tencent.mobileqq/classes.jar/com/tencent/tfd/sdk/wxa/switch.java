package com.tencent.tfd.sdk.wxa;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class switch
{
  public static final String[] rc = { "px", "dp", "sp", "pt", "in", "mm" };
  public byte[] mData;
  public static sc;
  public Map<String, String> tc = new HashMap();
  public String[] uc;
  public int[] vc;
  public int wc;
  public int xc;
  public int yc;
  public int zc;
  
  public Document a(InputStream paramInputStream)
  {
    static localstatic = new static();
    this.sc = localstatic;
    this.mData = new byte[paramInputStream.available()];
    paramInputStream.read(this.mData);
    paramInputStream.close();
    for (;;)
    {
      int i = this.zc;
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
                this.zc += 4;
                break;
              case 1048836: 
                paramInputStream = getString(f(this.zc + 16));
                localObject1 = this.sc;
                ((Node)((static)localObject1).pc.peek()).appendChild(((static)localObject1).qc.createCDATASection(paramInputStream));
                this.zc += 28;
                break;
              case 1048835: 
                i = f(this.zc + 16);
                getString(f(this.zc + 20));
                if (i != -1) {
                  getString(i);
                }
                this.sc.pc.pop();
                this.zc += 24;
                break;
              case 1048834: 
                i = f(this.zc + 16);
                k = f(this.zc + 20);
                j = this.zc + 28;
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
                } while (!this.tc.containsKey(localObject1));
                paramInputStream = new StringBuilder();
                paramInputStream.append((String)this.tc.get(localObject1));
                paramInputStream.append(':');
                paramInputStream.append(str);
                localObject2 = paramInputStream.toString();
                this.zc += 36;
                return[] arrayOfreturn = new return[j];
                i = 0;
                while (i < j)
                {
                  k = f(this.zc);
                  m = f(this.zc + 4);
                  n = f(this.zc + 8);
                  i1 = f(this.zc + 12);
                  i2 = f(this.zc + 16);
                  return localreturn = new return();
                  localreturn.mName = getString(m);
                  if (k == -1)
                  {
                    localreturn.e(null);
                    localreturn.setPrefix(null);
                  }
                  else
                  {
                    paramInputStream = getString(k);
                    if (this.tc.containsKey(paramInputStream))
                    {
                      localreturn.e(paramInputStream);
                      localreturn.setPrefix((String)this.tc.get(paramInputStream));
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
                      paramInputStream.append(rc[(i2 & 0xFF)]);
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
                    localreturn.setValue(paramInputStream);
                  }
                  else
                  {
                    localreturn.setValue(getString(n));
                  }
                  arrayOfreturn[i] = localreturn;
                  this.zc += 20;
                  i += 1;
                }
                this.sc.a((String)localObject1, str, (String)localObject2, arrayOfreturn);
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
              m = f(this.zc + 4);
              this.wc = f(this.zc + 8);
              this.xc = f(this.zc + 12);
              n = this.zc;
              i1 = f(n + 20);
              i2 = f(this.zc + 24);
              this.uc = new String[this.wc];
              i = 0;
              while (i < this.wc)
              {
                int i3 = f((i + 7) * 4 + this.zc) + (i1 + n);
                localObject2 = this.uc;
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
                while (i < this.xc) {
                  i += 1;
                }
              }
              this.zc += m;
            }
          }
          else
          {
            i = 0;
            j = f(this.zc + 4);
            this.yc = (j / 4 - 2);
            this.vc = new int[this.yc];
            while (i < this.yc)
            {
              this.vc[i] = f((i + 2) * 4 + this.zc);
              i += 1;
            }
            this.zc += j;
          }
        }
        else
        {
          paramInputStream = this.sc;
          paramInputStream.qc = paramInputStream.mBuilder.newDocument();
          paramInputStream.pc.push(paramInputStream.qc);
          this.zc += 8;
        }
      }
      else {
        this.sc.endDocument();
      }
    }
    this.sc.endDocument();
    return localstatic.qc;
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = f(this.zc + 16);
    String str1 = getString(f(this.zc + 20));
    String str2 = getString(i);
    if (paramBoolean)
    {
      this.sc.startPrefixMapping(str2, str1);
      this.tc.put(str1, str2);
    }
    else
    {
      this.sc.b(str2, str1);
      this.tc.remove(str1);
    }
    this.zc += 24;
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
    if ((paramInt >= 0) && (paramInt < this.wc)) {
      return this.uc[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.switch
 * JD-Core Version:    0.7.0.1
 */