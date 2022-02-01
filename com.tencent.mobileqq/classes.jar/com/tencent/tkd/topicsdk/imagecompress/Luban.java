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
  private String a;
  private boolean b;
  private int c;
  private OnRenameListener d;
  private OnCompressListener e;
  private CompressionPredicate f;
  private List<InputStreamProvider> g;
  private Handler h;
  
  private Luban(Luban.Builder paramBuilder)
  {
    this.a = Luban.Builder.a(paramBuilder);
    this.d = Luban.Builder.b(paramBuilder);
    this.g = Luban.Builder.c(paramBuilder);
    this.e = Luban.Builder.d(paramBuilder);
    this.c = Luban.Builder.e(paramBuilder);
    this.f = Luban.Builder.f(paramBuilder);
    this.h = new Handler(Looper.getMainLooper(), this);
  }
  
  public static Luban.Builder a(Context paramContext)
  {
    return new Luban.Builder(paramContext);
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
      paramInputStreamProvider.c();
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
  
  private File b(Context paramContext)
  {
    return a(paramContext, "luban_disk_cache");
  }
  
  private File b(Context paramContext, InputStreamProvider paramInputStreamProvider)
  {
    File localFile = b(paramContext, Checker.SINGLE.extSuffix(paramInputStreamProvider));
    OnRenameListener localOnRenameListener = this.d;
    if (localOnRenameListener != null) {
      localFile = c(paramContext, localOnRenameListener.a(paramInputStreamProvider.e()));
    }
    paramContext = this.f;
    if (paramContext != null)
    {
      if ((paramContext.a(paramInputStreamProvider.e())) && (Checker.SINGLE.needCompress(this.c, paramInputStreamProvider.e()))) {
        return new Engine(paramInputStreamProvider, localFile, this.b).a();
      }
      return new File(paramInputStreamProvider.e());
    }
    if (Checker.SINGLE.needCompress(this.c, paramInputStreamProvider.e())) {
      return new Engine(paramInputStreamProvider, localFile, this.b).a();
    }
    return new File(paramInputStreamProvider.e());
  }
  
  private File b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(this.a)) {
      this.a = b(paramContext).getAbsolutePath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
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
    if (TextUtils.isEmpty(this.a)) {
      this.a = b(paramContext).getAbsolutePath();
    }
    paramContext = new StringBuilder();
    paramContext.append(this.a);
    paramContext.append("/");
    paramContext.append(paramString);
    return new File(paramContext.toString());
  }
  
  private void c(Context paramContext)
  {
    Object localObject = this.g;
    if ((localObject == null) || ((((List)localObject).size() == 0) && (this.e != null))) {
      this.e.a(new NullPointerException("image file cannot be null"));
    }
    localObject = this.g.iterator();
    while (((Iterator)localObject).hasNext())
    {
      InputStreamProvider localInputStreamProvider = (InputStreamProvider)((Iterator)localObject).next();
      AsyncTask.SERIAL_EXECUTOR.execute(new Luban.1(this, paramContext, localInputStreamProvider));
      ((Iterator)localObject).remove();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.e == null) {
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
        this.e.a((Throwable)paramMessage.obj);
        return false;
      }
      this.e.a();
      return false;
    }
    this.e.a((File)paramMessage.obj);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Luban
 * JD-Core Version:    0.7.0.1
 */