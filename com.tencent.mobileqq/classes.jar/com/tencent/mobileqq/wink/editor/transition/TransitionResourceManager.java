package com.tencent.mobileqq.wink.editor.transition;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import com.tencent.videocut.model.TransitionModel;
import common.config.service.QzoneConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import mqq.os.MqqHandler;

public class TransitionResourceManager
{
  public static final ArrayList<String> a = new ArrayList(Arrays.asList(new String[] { "ZC_jichu_huadong" }));
  private static volatile TransitionResourceManager b;
  
  public static TransitionResourceManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TransitionResourceManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("winktranspag");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("winktranspag");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".pag");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.substring(paramString.lastIndexOf(File.separator) + 1, paramString.lastIndexOf(".pag"));
    }
    return null;
  }
  
  private boolean b(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        Object localObject2 = new File(a(paramContext));
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        Object localObject1 = new File((File)localObject2, paramString);
        if ((((File)localObject2).exists()) && (!((File)localObject1).exists()))
        {
          paramContext = paramContext.getAssets();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pag");
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(paramString);
          paramContext = paramContext.open(((StringBuilder)localObject2).toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("releasePagFileToData, pagName = pag");
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append(paramString);
          WinkQLog.a("TransitionResourceManager", ((StringBuilder)localObject2).toString());
          paramString = new FileOutputStream((File)localObject1);
          localObject1 = new byte[1024];
          for (;;)
          {
            int i = paramContext.read((byte[])localObject1);
            if (i == -1) {
              break;
            }
            paramString.write((byte[])localObject1, 0, i);
          }
          paramString.flush();
          paramContext.close();
          paramString.close();
        }
        return true;
      }
      catch (Exception paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("releasePagFileToData, exception = ");
        paramString.append(paramContext.toString());
        WinkQLog.a("TransitionResourceManager", paramString.toString());
      }
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return new File(paramString).exists();
    }
    return false;
  }
  
  public void a(Context paramContext, Collection<TransitionModel> paramCollection, Runnable paramRunnable)
  {
    if ((paramContext != null) && (paramCollection != null))
    {
      if (paramRunnable == null) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new TransitionResourceManager.2(this, paramCollection, paramContext, paramRunnable));
    }
  }
  
  public void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (!QzoneConfig.getWinkTransitionSwitch()) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new TransitionResourceManager.1(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.transition.TransitionResourceManager
 * JD-Core Version:    0.7.0.1
 */