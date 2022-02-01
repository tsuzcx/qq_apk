package com.tencent.tgpa.vendorpd.a;

import android.util.Log;
import com.tencent.tgpa.vendorpd.b.c;
import com.tencent.tgpa.vendorpd.b.f;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

class a$b
{
  private ArrayList<a.c> a;
  private final String b;
  
  public a$b(String paramString, ArrayList<a.c> paramArrayList)
  {
    this.b = paramString;
    this.a = paramArrayList;
  }
  
  private boolean a(a.c paramc)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(new File(this.b), "rw");
      long l1 = localRandomAccessFile.length();
      long l2 = paramc.c;
      int i = paramc.d;
      paramc = c.b(paramc.e);
      if (paramc.length != i)
      {
        Log.e("TGPA", "cloud operation's content size is not matched, ple check it.");
        return false;
      }
      localRandomAccessFile.seek(l1 - l2);
      localRandomAccessFile.write(paramc, 0, i);
      localRandomAccessFile.close();
      return true;
    }
    catch (IOException paramc)
    {
      paramc.printStackTrace();
      Log.e("TGPA", "can not modify predownload file content.");
    }
    return false;
  }
  
  private boolean b(a.c paramc)
  {
    f.b("can not delete predownload file content.");
    return false;
  }
  
  private boolean c(a.c paramc)
  {
    f.b("use modify instead of insert predownload file content.");
    return a(paramc);
  }
  
  public boolean a()
  {
    if (this.b == null) {
      return false;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return false;
      }
      localObject = this.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.c localc = (a.c)((Iterator)localObject).next();
        String str = localc.b;
        int i = -1;
        int j = str.hashCode();
        if (j != -1335458389)
        {
          if (j != -1183792455)
          {
            if ((j == -1068795718) && (str.equals("modify"))) {
              i = 2;
            }
          }
          else if (str.equals("insert")) {
            i = 0;
          }
        }
        else if (str.equals("delete")) {
          i = 1;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if ((i == 2) && (!a(localc))) {
              return false;
            }
          }
          else if (!b(localc)) {
            return false;
          }
        }
        else if (!c(localc)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.a.b
 * JD-Core Version:    0.7.0.1
 */