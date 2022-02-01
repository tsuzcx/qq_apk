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
  private HashMap<String, ZipEntry> a;
  protected ZipFile a;
  protected boolean a;
  
  public HookDexZipFile(File paramFile1, File paramFile2, ZipFile paramZipFile)
  {
    super(paramFile1);
    this.jdField_a_of_type_JavaIoFile = paramFile2;
    this.jdField_a_of_type_JavaUtilZipZipFile = paramZipFile;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public void a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      try
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilZipZipFile.getClass().getDeclaredField("entries");
        ((Field)localObject1).setAccessible(true);
        localObject1 = ((LinkedHashMap)((Field)localObject1).get(this.jdField_a_of_type_JavaUtilZipZipFile)).entrySet().iterator();
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
  
  public boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilZipZipFile != null)
      {
        this.jdField_a_of_type_JavaUtilZipZipFile.close();
        this.jdField_a_of_type_JavaUtilZipZipFile = null;
      }
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    finally {}
  }
  
  public void close()
  {
    super.close();
    ZipFile localZipFile = this.jdField_a_of_type_JavaUtilZipZipFile;
    if (localZipFile != null) {
      localZipFile.close();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public Enumeration<? extends ZipEntry> entries()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        try
        {
          this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
          this.jdField_a_of_type_Boolean = false;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      Enumeration localEnumeration = this.jdField_a_of_type_JavaUtilZipZipFile.entries();
      return localEnumeration;
    }
    finally {}
  }
  
  public ZipEntry getEntry(String paramString)
  {
    label59:
    try
    {
      localZipEntry = (ZipEntry)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localZipEntry != null) {
        return localZipEntry;
      }
      if (this.jdField_a_of_type_Boolean) {
        MemoryClearManager.a(paramString, MemoryClearManager.l);
      }
    }
    finally {}
    try
    {
      this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
      this.jdField_a_of_type_Boolean = false;
    }
    catch (IOException paramString)
    {
      break label59;
    }
    return null;
    ZipEntry localZipEntry = this.jdField_a_of_type_JavaUtilZipZipFile.getEntry(paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localZipEntry);
    return localZipEntry;
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
        this.jdField_a_of_type_Boolean = false;
      }
      paramZipEntry = this.jdField_a_of_type_JavaUtilZipZipFile.getInputStream(paramZipEntry);
      return paramZipEntry;
    }
    finally {}
  }
  
  public String getName()
  {
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
      this.jdField_a_of_type_Boolean = false;
    }
    catch (IOException localIOException)
    {
      label30:
      break label30;
    }
    return null;
    return this.jdField_a_of_type_JavaUtilZipZipFile.getName();
  }
  
  public int size()
  {
    label34:
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (!bool) {}
    }
    finally {}
    try
    {
      this.jdField_a_of_type_JavaUtilZipZipFile = new QZipFile(this.jdField_a_of_type_JavaIoFile);
      this.jdField_a_of_type_Boolean = false;
    }
    catch (IOException localIOException)
    {
      break label34;
    }
    return 0;
    int i = this.jdField_a_of_type_JavaUtilZipZipFile.size();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.HookDexZipFile
 * JD-Core Version:    0.7.0.1
 */