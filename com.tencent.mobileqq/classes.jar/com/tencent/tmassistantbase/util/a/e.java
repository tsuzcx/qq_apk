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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onHook---");
    ((StringBuilder)localObject1).append(paramMethod.getName());
    Log.i("HookManager_AMHook", ((StringBuilder)localObject1).toString(), new Throwable("---------------------------------------------------------------"));
    long l = System.currentTimeMillis();
    localObject1 = (Intent)paramVarArgs[a.a(paramVarArgs, Intent.class)];
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("intent=");
      ((StringBuilder)localObject2).append(localObject1);
      Log.i("miles", ((StringBuilder)localObject2).toString());
      if ((!"android.intent.action.INSTALL_PACKAGE".equals(((Intent)localObject1).getAction())) && ((!"android.intent.action.VIEW".equals(((Intent)localObject1).getAction())) || (!"application/vnd.android.package-archive".equals(((Intent)localObject1).getType()))))
      {
        a(false);
        Log.i("miles", "非安装intent,不拦截");
        break label646;
      }
      localObject2 = ((Intent)localObject1).getData();
    }
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
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("step 1 time cost: ");
      ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject3).append("ms");
      Log.i("miles", ((StringBuilder)localObject3).toString());
      localObject3 = this.a.getPackageManager();
      if ((localObject3 != null) && (localObject2 != null))
      {
        localObject2 = ((PackageManager)localObject3).getPackageArchiveInfo(((Uri)localObject2).getPath(), 1);
        if (localObject2 == null)
        {
          Log.i("miles", "<onHook> PackageInfo info == null!");
          return paramMethod.invoke(paramObject, paramVarArgs);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("step 2 time cost: ");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject3).append("ms");
        Log.i("miles", ((StringBuilder)localObject3).toString());
        if (!h.a(((PackageInfo)localObject2).packageName))
        {
          Log.i("miles", "<onHook> pkg not allowed!!!");
          k.a().post(new f(this, (PackageInfo)localObject2));
          return paramMethod.invoke(paramObject, paramVarArgs);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("step 3 time cost: ");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject3).append("ms");
        Log.i("miles", ((StringBuilder)localObject3).toString());
        if ((paramVarArgs.length > 1) && (paramVarArgs[1] != null))
        {
          paramVarArgs[1] = d.d();
          ((Intent)localObject1).putExtra("caller_package", d.d());
          if (GlobalUtil.isOppo()) {
            ((Intent)localObject1).putExtra("oppo_extra_pkg_name", d.d());
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getFakePackage.");
          ((StringBuilder)localObject1).append(d.d());
          Log.i("miles", ((StringBuilder)localObject1).toString());
        }
        k.a().post(new g(this, (PackageInfo)localObject2));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("step 4 time cost: ");
        ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
        ((StringBuilder)localObject1).append("ms");
        Log.i("miles", ((StringBuilder)localObject1).toString());
        break label646;
      }
      Log.i("miles", "<onHook> pm == null || uri == null!");
      localObject1 = paramMethod.invoke(paramObject, paramVarArgs);
      return localObject1;
    }
    catch (Exception localException)
    {
      label622:
      break label622;
    }
    Log.i("miles", "获取包名信息异常,不拦截");
    break label646;
    a(false);
    Log.i("miles", "非安装intent,不拦截");
    label646:
    return paramMethod.invoke(paramObject, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.a.e
 * JD-Core Version:    0.7.0.1
 */