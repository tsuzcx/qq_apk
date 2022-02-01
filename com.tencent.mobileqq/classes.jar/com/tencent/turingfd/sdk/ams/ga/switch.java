package com.tencent.turingfd.sdk.ams.ga;

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
  public static final String[] Hc = { "px", "dp", "sp", "pt", "in", "mm" };
  public static Ic;
  public Map<String, String> Jc = new HashMap();
  public String[] Kc;
  public int[] Lc;
  public int Mc;
  public int Nc;
  public int Oc;
  public int Pc;
  public byte[] mData;
  
  public Document a(InputStream paramInputStream)
  {
    static localstatic = new static();
    this.Ic = localstatic;
    this.mData = new byte[paramInputStream.available()];
    paramInputStream.read(this.mData);
    paramInputStream.close();
    for (;;)
    {
      int i = this.Pc;
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
                this.Pc += 4;
                break;
              case 1048836: 
                paramInputStream = getString(f(this.Pc + 16));
                localObject1 = this.Ic;
                ((Node)((static)localObject1).Fc.peek()).appendChild(((static)localObject1).Gc.createCDATASection(paramInputStream));
                this.Pc += 28;
                break;
              case 1048835: 
                i = f(this.Pc + 16);
                getString(f(this.Pc + 20));
                if (i != -1) {
                  getString(i);
                }
                this.Ic.Fc.pop();
                this.Pc += 24;
                break;
              case 1048834: 
                i = f(this.Pc + 16);
                k = f(this.Pc + 20);
                j = this.Pc + 28;
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
                } while (!this.Jc.containsKey(localObject1));
                paramInputStream = new StringBuilder();
                paramInputStream.append((String)this.Jc.get(localObject1));
                paramInputStream.append(':');
                paramInputStream.append(str);
                localObject2 = paramInputStream.toString();
                this.Pc += 36;
                return[] arrayOfreturn = new return[j];
                i = 0;
                while (i < j)
                {
                  k = f(this.Pc);
                  m = f(this.Pc + 4);
                  n = f(this.Pc + 8);
                  i1 = f(this.Pc + 12);
                  i2 = f(this.Pc + 16);
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
                    if (this.Jc.containsKey(paramInputStream))
                    {
                      localreturn.e(paramInputStream);
                      localreturn.setPrefix((String)this.Jc.get(paramInputStream));
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
                      paramInputStream.append(Hc[(i2 & 0xFF)]);
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
                  this.Pc += 20;
                  i += 1;
                }
                this.Ic.a((String)localObject1, str, (String)localObject2, arrayOfreturn);
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
              m = f(this.Pc + 4);
              this.Mc = f(this.Pc + 8);
              this.Nc = f(this.Pc + 12);
              n = this.Pc;
              i1 = f(n + 20);
              i2 = f(this.Pc + 24);
              this.Kc = new String[this.Mc];
              i = 0;
              while (i < this.Mc)
              {
                int i3 = f((i + 7) * 4 + this.Pc) + (i1 + n);
                localObject2 = this.Kc;
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
                while (i < this.Nc) {
                  i += 1;
                }
              }
              this.Pc += m;
            }
          }
          else
          {
            i = 0;
            j = f(this.Pc + 4);
            this.Oc = (j / 4 - 2);
            this.Lc = new int[this.Oc];
            while (i < this.Oc)
            {
              this.Lc[i] = f((i + 2) * 4 + this.Pc);
              i += 1;
            }
            this.Pc += j;
          }
        }
        else
        {
          paramInputStream = this.Ic;
          paramInputStream.Gc = paramInputStream.mBuilder.newDocument();
          paramInputStream.Fc.push(paramInputStream.Gc);
          this.Pc += 8;
        }
      }
      else {
        this.Ic.endDocument();
      }
    }
    this.Ic.endDocument();
    return localstatic.Gc;
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = f(this.Pc + 16);
    String str1 = getString(f(this.Pc + 20));
    String str2 = getString(i);
    if (paramBoolean)
    {
      this.Ic.startPrefixMapping(str2, str1);
      this.Jc.put(str1, str2);
    }
    else
    {
      this.Ic.b(str2, str1);
      this.Jc.remove(str1);
    }
    this.Pc += 24;
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
    if ((paramInt >= 0) && (paramInt < this.Mc)) {
      return this.Kc[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.switch
 * JD-Core Version:    0.7.0.1
 */