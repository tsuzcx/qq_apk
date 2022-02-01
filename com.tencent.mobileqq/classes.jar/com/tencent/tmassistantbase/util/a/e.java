package com.tencent.tmassistantbase.util.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.k;
import java.lang.reflect.Method;

public class e
  extends c
{
  private Context a;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public Object a(Object paramObject1, Method paramMethod, Object[] paramArrayOfObject, Object paramObject2)
  {
    return super.a(paramObject1, paramMethod, paramArrayOfObject, paramObject2);
  }
  
  public String a()
  {
    return "startActivity";
  }
  
  public boolean a(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    return false;
  }
  
  public Object b(Object paramObject, Method paramMethod, Object... paramVarArgs)
  {
    Log.i("HookManager_AMHook", "onHook---" + paramMethod.getName(), new Throwable("---------------------------------------------------------------"));
    long l = System.currentTimeMillis();
    Intent localIntent = (Intent)paramVarArgs[a.a(paramVarArgs, Intent.class)];
    Object localObject;
    if (localIntent != null)
    {
      Log.i("miles", "intent=" + localIntent);
      if (("android.intent.action.INSTALL_PACKAGE".equals(localIntent.getAction())) || (("android.intent.action.VIEW".equals(localIntent.getAction())) && ("application/vnd.android.package-archive".equals(localIntent.getType())))) {
        localObject = localIntent.getData();
      }
    }
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          this.a = GlobalUtil.getInstance().getContext();
          if (this.a == null)
          {
            Log.i("miles", "<onHook> mContext == null!");
            return paramMethod.invoke(paramObject, paramVarArgs);
          }
        }
        Log.i("miles", "step 1 time cost: " + (System.currentTimeMillis() - l) + "ms");
        PackageManager localPackageManager = this.a.getPackageManager();
        if ((localPackageManager == null) || (localObject == null))
        {
          Log.i("miles", "<onHook> pm == null || uri == null!");
          return paramMethod.invoke(paramObject, paramVarArgs);
        }
        localObject = localPackageManager.getPackageArchiveInfo(((Uri)localObject).getPath(), 1);
        if (localObject == null)
        {
          Log.i("miles", "<onHook> PackageInfo info == null!");
          return paramMethod.invoke(paramObject, paramVarArgs);
        }
        Log.i("miles", "step 2 time cost: " + (System.currentTimeMillis() - l) + "ms");
        if (!h.a(((PackageInfo)localObject).packageName))
        {
          Log.i("miles", "<onHook> pkg not allowed!!!");
          k.a().post(new f(this, (PackageInfo)localObject));
          return paramMethod.invoke(paramObject, paramVarArgs);
        }
        Log.i("miles", "step 3 time cost: " + (System.currentTimeMillis() - l) + "ms");
        if ((paramVarArgs.length > 1) && (paramVarArgs[1] != null))
        {
          paramVarArgs[1] = d.d();
          localIntent.putExtra("caller_package", d.d());
          if (GlobalUtil.isOppo()) {
            localIntent.putExtra("oppo_extra_pkg_name", d.d());
          }
          Log.i("miles", "getFakePackage." + d.d());
        }
        k.a().post(new g(this, (PackageInfo)localObject));
        Log.i("miles", "step 4 time cost: " + (System.currentTimeMillis() - l) + "ms");
      }
      catch (Exception localException)
      {
        Log.i("miles", "获取包名信息异常,不拦截");
        continue;
      }
      return paramMethod.invoke(paramObject, paramVarArgs);
      a(false);
      Log.i("miles", "非安装intent,不拦截");
      continue;
      a(false);
      Log.i("miles", "非安装intent,不拦截");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.e
 * JD-Core Version:    0.7.0.1
 */