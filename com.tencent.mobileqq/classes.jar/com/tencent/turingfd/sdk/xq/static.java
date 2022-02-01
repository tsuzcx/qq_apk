package com.tencent.turingfd.sdk.xq;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class static
{
  public static final String[] Hf = { "px", "dp", "sp", "pt", "in", "mm" };
  public return If;
  public Map<String, String> Jf = new HashMap();
  public String[] Kf;
  public int[] Lf;
  public int Mf;
  public int Nf;
  public int Of;
  public int Pf;
  public byte[] mData;
  
  public Document a(InputStream paramInputStream)
  {
    return localreturn = new return();
    this.If = localreturn;
    this.mData = new byte[paramInputStream.available()];
    paramInputStream.read(this.mData);
    paramInputStream.close();
    for (;;)
    {
      int i = this.Pf;
      if (i >= this.mData.length) {
        break;
      }
      i = e(i);
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
            label381:
            int m;
            int n;
            int i1;
            int i2;
            if (i != 1835009)
            {
              switch (i)
              {
              default: 
                this.Pf += 4;
                break;
              case 1048836: 
                paramInputStream = getString(e(this.Pf + 16));
                localObject1 = this.If;
                ((Node)((return)localObject1).Ff.peek()).appendChild(((return)localObject1).Gf.createCDATASection(paramInputStream));
                this.Pf += 28;
                break;
              case 1048835: 
                i = e(this.Pf + 16);
                getString(e(this.Pf + 20));
                if (i == -1) {}
                for (;;)
                {
                  this.If.Ff.pop();
                  this.Pf += 24;
                  break;
                  getString(i);
                }
              case 1048834: 
                i = e(this.Pf + 16);
                k = e(this.Pf + 20);
                j = this.Pf + 28;
                paramInputStream = this.mData;
                j = paramInputStream[(j + 1)] << 8 & 0xFF00 | paramInputStream[(j + 0)] << 0 & 0xFF;
                String str = getString(k);
                public[] arrayOfpublic;
                public localpublic;
                if (i == -1)
                {
                  localObject1 = str;
                  localObject2 = "";
                  this.Pf += 36;
                  arrayOfpublic = new public[j];
                  i = 0;
                  if (i >= j) {
                    break label963;
                  }
                  k = e(this.Pf);
                  m = e(this.Pf + 4);
                  n = e(this.Pf + 8);
                  i1 = e(this.Pf + 12);
                  i2 = e(this.Pf + 16);
                  localpublic = new public();
                  localpublic.mName = getString(m);
                  if (k != -1) {
                    break label722;
                  }
                  localpublic.g(null);
                  localpublic.setPrefix(null);
                  if (n != -1) {
                    break label949;
                  }
                  switch (i1)
                  {
                  default: 
                    paramInputStream = String.format("%08X/0x%08X", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
                    localpublic.setValue(paramInputStream);
                  }
                }
                for (;;)
                {
                  arrayOfpublic[i] = localpublic;
                  this.Pf += 20;
                  i += 1;
                  break label381;
                  localObject2 = getString(i);
                  if (this.Jf.containsKey(localObject2))
                  {
                    localObject1 = (String)this.Jf.get(localObject2) + ':' + str;
                    break;
                  }
                  localObject1 = str;
                  break;
                  paramInputStream = getString(k);
                  if (!this.Jf.containsKey(paramInputStream)) {
                    break label487;
                  }
                  localpublic.g(paramInputStream);
                  localpublic.setPrefix((String)this.Jf.get(paramInputStream));
                  break label487;
                  paramInputStream = String.format("#%08X", new Object[] { Integer.valueOf(i2) });
                  break label618;
                  if (i2 != 0) {}
                  for (boolean bool = true;; bool = false)
                  {
                    paramInputStream = Boolean.toString(bool);
                    break;
                  }
                  paramInputStream = Integer.toString(i2);
                  break label618;
                  double d = i2 / 2147483647.0D;
                  paramInputStream = new DecimalFormat("#.##%").format(d);
                  break label618;
                  paramInputStream = Integer.toString(i2 >> 8) + Hf[(i2 & 0xFF)];
                  break label618;
                  paramInputStream = Float.toString(Float.intBitsToFloat(i2));
                  break label618;
                  paramInputStream = getString(i2);
                  break label618;
                  paramInputStream = String.format("?id/0x%08X", new Object[] { Integer.valueOf(i2) });
                  break label618;
                  paramInputStream = String.format("@id/0x%08X", new Object[] { Integer.valueOf(i2) });
                  break label618;
                  localpublic.setValue(getString(n));
                }
                this.If.a((String)localObject2, str, (String)localObject1, arrayOfpublic);
                break;
              case 1048833: 
                label949:
                label963:
                b(false);
                break;
              case 1048832: 
                label487:
                label618:
                b(true);
                label722:
                break;
              }
            }
            else
            {
              k = e(this.Pf + 4);
              this.Mf = e(this.Pf + 8);
              this.Nf = e(this.Pf + 12);
              m = this.Pf;
              n = e(m + 20);
              i1 = e(this.Pf + 24);
              this.Kf = new String[this.Mf];
              i = 0;
              while (i < this.Mf)
              {
                i2 = e(this.Pf + (i + 7) * 4) + (n + m);
                localObject2 = this.Kf;
                paramInputStream = this.mData;
                j = i2 + 1;
                if (paramInputStream[j] == paramInputStream[i2])
                {
                  i3 = paramInputStream[i2];
                  localObject1 = new byte[i3];
                  j = 0;
                  for (;;)
                  {
                    paramInputStream = (InputStream)localObject1;
                    if (j >= i3) {
                      break;
                    }
                    localObject1[j] = this.mData[(i2 + 2 + j)];
                    j += 1;
                  }
                }
                int i3 = paramInputStream[j] << 8 & 0xFF00 | paramInputStream[i2] & 0xFF;
                localObject1 = new byte[i3];
                j = 0;
                for (;;)
                {
                  paramInputStream = (InputStream)localObject1;
                  if (j >= i3) {
                    break;
                  }
                  localObject1[j] = this.mData[(i2 + 2 + j * 2)];
                  j += 1;
                }
                localObject2[i] = new String(paramInputStream);
                i += 1;
              }
              if (i1 > 0)
              {
                i = 0;
                while (i < this.Nf) {
                  i += 1;
                }
              }
              this.Pf += k;
            }
          }
          else
          {
            j = e(this.Pf + 4);
            this.Of = (j / 4 - 2);
            this.Lf = new int[this.Of];
            i = 0;
            while (i < this.Of)
            {
              this.Lf[i] = e(this.Pf + (i + 2) * 4);
              i += 1;
            }
            this.Pf += j;
          }
        }
        else
        {
          paramInputStream = this.If;
          paramInputStream.Gf = paramInputStream.mBuilder.newDocument();
          paramInputStream.Ff.push(paramInputStream.Gf);
          this.Pf += 8;
        }
      }
      else {
        this.If.endDocument();
      }
    }
    this.If.endDocument();
    return localreturn.Gf;
  }
  
  public final void b(boolean paramBoolean)
  {
    int i = e(this.Pf + 16);
    String str1 = getString(e(this.Pf + 20));
    String str2 = getString(i);
    if (paramBoolean)
    {
      this.If.startPrefixMapping(str2, str1);
      this.Jf.put(str1, str2);
    }
    for (;;)
    {
      this.Pf += 24;
      return;
      this.If.b(str2, str1);
      this.Jf.remove(str1);
    }
  }
  
  public final int e(int paramInt)
  {
    byte[] arrayOfByte = this.mData;
    int i = arrayOfByte[(paramInt + 3)];
    int j = arrayOfByte[(paramInt + 2)];
    int k = arrayOfByte[(paramInt + 1)];
    return arrayOfByte[(paramInt + 0)] << 0 & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
  }
  
  public final String getString(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.Mf)) {
      return this.Kf[paramInt];
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.static
 * JD-Core Version:    0.7.0.1
 */