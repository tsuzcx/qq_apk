package cooperation.ilive.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.lang.reflect.Method;

public class ShadowContentProvider
  extends ContentProvider
{
  Class<?> jdField_a_of_type_JavaLangClass;
  Object jdField_a_of_type_JavaLangObject;
  
  public ShadowContentProvider()
  {
    try
    {
      this.jdField_a_of_type_JavaLangClass = Class.forName("com.tencent.shadow.core.runtime.container.PluginContainerContentProvider");
      this.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_JavaLangClass.newInstance();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    try
    {
      paramUri = (Integer)this.jdField_a_of_type_JavaLangClass.getMethod("bulkInsert", new Class[] { Uri.class, [Landroid.content.ContentValues.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramArrayOfContentValues });
      return paramUri.intValue();
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        paramUri.printStackTrace();
        paramUri = Integer.valueOf(0);
      }
    }
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    try
    {
      paramString1 = (Bundle)this.jdField_a_of_type_JavaLangClass.getMethod("call", new Class[] { String.class, String.class, Bundle.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramString1, paramString2, paramBundle });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramUri = (Integer)this.jdField_a_of_type_JavaLangClass.getMethod("delete", new Class[] { Uri.class, String.class, [Ljava.lang.String.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramString, paramArrayOfString });
      return paramUri.intValue();
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        paramUri.printStackTrace();
        paramUri = Integer.valueOf(0);
      }
    }
  }
  
  public String getType(Uri paramUri)
  {
    try
    {
      paramUri = (String)this.jdField_a_of_type_JavaLangClass.getMethod("getType", new Class[] { Uri.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri });
      return paramUri;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    try
    {
      paramUri = (Uri)this.jdField_a_of_type_JavaLangClass.getMethod("insert", new Class[] { Uri.class, ContentValues.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramContentValues });
      return paramUri;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return null;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    try
    {
      this.jdField_a_of_type_JavaLangClass.getMethod("onConfigurationChanged", new Class[] { Configuration.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramConfiguration });
      return;
    }
    catch (Exception paramConfiguration)
    {
      paramConfiguration.printStackTrace();
    }
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public void onLowMemory()
  {
    try
    {
      this.jdField_a_of_type_JavaLangClass.getMethod("onLowMemory", new Class[0]).invoke(this.jdField_a_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_JavaLangClass.getMethod("onTrimMemory", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    try
    {
      paramUri = (ParcelFileDescriptor)this.jdField_a_of_type_JavaLangClass.getMethod("openFile", new Class[] { Uri.class, String.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramString });
      return paramUri;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return null;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString, CancellationSignal paramCancellationSignal)
  {
    try
    {
      paramUri = (ParcelFileDescriptor)this.jdField_a_of_type_JavaLangClass.getMethod("openFile", new Class[] { Uri.class, String.class, CancellationSignal.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramString, paramCancellationSignal });
      return paramUri;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    try
    {
      paramUri = (Cursor)this.jdField_a_of_type_JavaLangClass.getMethod("query", new Class[] { Uri.class, [Ljava.lang.String.class, String.class, [Ljava.lang.String.class, String.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2 });
      return paramUri;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    try
    {
      paramUri = (Integer)this.jdField_a_of_type_JavaLangClass.getMethod("update", new Class[] { Uri.class, ContentValues.class, String.class, [Ljava.lang.String.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramUri, paramContentValues, paramString, paramArrayOfString });
      return paramUri.intValue();
    }
    catch (Exception paramUri)
    {
      for (;;)
      {
        paramUri.printStackTrace();
        paramUri = Integer.valueOf(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.ilive.provider.ShadowContentProvider
 * JD-Core Version:    0.7.0.1
 */