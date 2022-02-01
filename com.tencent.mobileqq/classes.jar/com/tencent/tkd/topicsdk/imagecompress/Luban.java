package com.tencent.tkd.topicsdk.imagecompress;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tkd.topicsdk.imagecompress.engine.Engine;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class Luban
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private CompressionPredicate jdField_a_of_type_ComTencentTkdTopicsdkImagecompressCompressionPredicate;
  private OnCompressListener jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener;
  private OnRenameListener jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnRenameListener;
  private String jdField_a_of_type_JavaLangString;
  private List<InputStreamProvider> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  private Luban(Luban.Builder paramBuilder)
  {
    this.jdField_a_of_type_JavaLangString = Luban.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnRenameListener = Luban.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaUtilList = Luban.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener = Luban.Builder.a(paramBuilder);
    this.jdField_a_of_type_Int = Luban.Builder.a(paramBuilder);
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressCompressionPredicate = Luban.Builder.a(paramBuilder);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static Luban.Builder a(Context paramContext)
  {
    return new Luban.Builder(paramContext);
  }
  
  private File a(Context paramContext)
  {
    return a(paramContext, "luban_disk_cache");
  }
  
  private File a(Context paramContext, InputStreamProvider paramInputStreamProvider)
  {
    try
    {
      paramContext = b(paramContext, paramInputStreamProvider);
      return paramContext;
    }
    finally
    {
      paramInputStreamProvider.a();
    }
  }
  
  private static File a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getExternalCacheDir();
    if (paramContext != null)
    {
      paramContext = new File(paramContext, paramString);
      if ((!paramContext.mkdirs()) && ((!paramContext.exists()) || (!paramContext.isDirectory()))) {
        return null;
      }
      return paramContext;
    }
    if (Log.isLoggable("Luban", 6)) {
      Log.e("Luban", "default disk cache dir is null");
    }
    return null;
  }
  
  private void a(Context paramContext)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject == null) || ((((List)localObject).size() == 0) && (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener != null))) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener.a(new NullPointerException("image file cannot be null"));
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      InputStreamProvider localInputStreamProvider = (InputStreamProvider)((Iterator)localObject).next();
      AsyncTask.SERIAL_EXECUTOR.execute(new Luban.1(this, paramContext, localInputStreamProvider));
      ((Iterator)localObject).remove();
    }
  }
  
  private File b(Context paramContext, InputStreamProvider paramInputStreamProvider)
  {
    File localFile = b(paramContext, Checker.SINGLE.extSuffix(paramInputStreamProvider));
    OnRenameListener localOnRenameListener = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnRenameListener;
    if (localOnRenameListener != null) {
      localFile = c(paramContext, localOnRenameListener.a(paramInputStreamProvider.a()));
    }
    paramContext = this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressCompressionPredicate;
    if (paramContext != null)
    {
      if ((paramContext.a(paramInputStreamProvider.a())) && (Checker.SINGLE.needCompress(this.jdField_a_of_type_Int, paramInputStreamProvider.a()))) {
        return new Engine(paramInputStreamProvider, localFile, this.jdField_a_of_type_Boolean).a();
      }
      return new File(paramInputStreamProvider.a());
    }
    if (Checker.SINGLE.needCompress(this.jdField_a_of_type_Int, paramInputStreamProvider.a())) {
      return new Engine(paramInputStreamProvider, localFile, this.jdField_a_of_type_Boolean).a();
    }
    return new File(paramInputStreamProvider.a());
  }
  
  private File b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = a(paramContext).getAbsolutePath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append((int)(Math.random() * 1000.0D));
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = ".jpg";
    }
    localStringBuilder.append(paramContext);
    return new File(localStringBuilder.toString());
  }
  
  private File c(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = a(paramContext).getAbsolutePath();
    }
    paramContext = new StringBuilder();
    paramContext.append(this.jdField_a_of_type_JavaLangString);
    paramContext.append("/");
    paramContext.append(paramString);
    return new File(paramContext.toString());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener == null) {
      return false;
    }
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return false;
        }
        this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener.a((Throwable)paramMessage.obj);
        return false;
      }
      this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener.a();
      return false;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressOnCompressListener.a((File)paramMessage.obj);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban
 * JD-Core Version:    0.7.0.1
 */