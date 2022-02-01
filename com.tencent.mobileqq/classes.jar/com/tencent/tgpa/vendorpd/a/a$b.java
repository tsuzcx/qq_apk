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
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<a.c> jdField_a_of_type_JavaUtilArrayList;
  
  public a$b(String paramString, ArrayList<a.c> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private boolean a(a.c paramc)
  {
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(new File(this.jdField_a_of_type_JavaLangString), "rw");
      long l1 = localRandomAccessFile.length();
      long l2 = paramc.jdField_a_of_type_Long;
      int i = paramc.jdField_b_of_type_Int;
      paramc = c.a(paramc.jdField_b_of_type_JavaLangString);
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
    if (this.jdField_a_of_type_JavaLangString == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() <= 0) {
        return false;
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.c localc = (a.c)((Iterator)localObject).next();
        String str = localc.jdField_a_of_type_JavaLangString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.a.b
 * JD-Core Version:    0.7.0.1
 */