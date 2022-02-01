package com.tencent.qqperf.opt.clearmemory;

import com.tencent.commonsdk.zip.QZipFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class HookDexZipFile
  extends QZipFile
{
  protected File a;
  protected ZipFile b;
  protected boolean c;
  private HashMap<String, ZipEntry> d;
  
  public HookDexZipFile(File paramFile1, File paramFile2, ZipFile paramZipFile)
  {
    super(paramFile1);
    this.a = paramFile2;
    this.b = paramZipFile;
    this.d = new HashMap();
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        return false;
      }
      if (this.b != null)
      {
        this.b.close();
        this.b = null;
      }
      this.c = true;
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        return;
      }
      try
      {
        Object localObject1 = this.b.getClass().getDeclaredField("entries");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((LinkedHashMap)((Field)localObject1).get(this.b)).entrySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (!((String)((Map.Entry)((Iterator)localObject1).next()).getKey()).endsWith(".so")) {
            ((Iterator)localObject1).remove();
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void close()
  {
    super.close();
    ZipFile localZipFile = this.b;
    if (localZipFile != null) {
      localZipFile.close();
    }
    this.d.clear();
  }
  
  public Enumeration<? extends ZipEntry> entries()
  {
    try
    {
      boolean bool = this.c;
      if (bool) {
        try
        {
          this.b = new QZipFile(this.a);
          this.c = false;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Enumeration localEnumeration = this.b.entries();
      return localEnumeration;
    }
    finally {}
  }
  
  public ZipEntry getEntry(String paramString)
  {
    label59:
    try
    {
      localZipEntry = (ZipEntry)this.d.get(paramString);
      if (localZipEntry != null) {
        return localZipEntry;
      }
      if (this.c) {
        MemoryClearManager.a(paramString, MemoryClearManager.u);
      }
    }
    finally {}
    try
    {
      this.b = new QZipFile(this.a);
      this.c = false;
    }
    catch (IOException paramString)
    {
      break label59;
    }
    return null;
    ZipEntry localZipEntry = this.b.getEntry(paramString);
    this.d.put(paramString, localZipEntry);
    return localZipEntry;
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    try
    {
      if (this.c)
      {
        this.b = new QZipFile(this.a);
        this.c = false;
      }
      paramZipEntry = this.b.getInputStream(paramZipEntry);
      return paramZipEntry;
    }
    finally {}
  }
  
  public String getName()
  {
    if (this.c) {}
    try
    {
      this.b = new QZipFile(this.a);
      this.c = false;
    }
    catch (IOException localIOException)
    {
      label30:
      break label30;
    }
    return null;
    return this.b.getName();
  }
  
  public int size()
  {
    label34:
    try
    {
      boolean bool = this.c;
      if (!bool) {}
    }
    finally {}
    try
    {
      this.b = new QZipFile(this.a);
      this.c = false;
    }
    catch (IOException localIOException)
    {
      break label34;
    }
    return 0;
    int i = this.b.size();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.HookDexZipFile
 * JD-Core Version:    0.7.0.1
 */