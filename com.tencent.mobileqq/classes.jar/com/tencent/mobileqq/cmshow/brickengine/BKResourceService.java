package com.tencent.mobileqq.cmshow.brickengine;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineType;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.resource.exception.ScriptNotFoundException;
import com.tencent.mobileqq.cmshow.engine.resource.exception.ScriptVerifyException;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "TAG", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "scriptMap", "", "", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "destroy", "", "getResourceManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "getResourcePath", "type", "id", "getResourceUrl", "getScriptById", "businessId", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKResourceService
  implements IResourceService
{
  @Deprecated
  public static final BKResourceService.Companion a = new BKResourceService.Companion(null);
  private final String b;
  private final ReentrantLock c;
  private final Map<Integer, Script> d;
  private final EngineContext e;
  
  public BKResourceService(@NotNull EngineContext paramEngineContext)
  {
    this.e = paramEngineContext;
    paramEngineContext = new StringBuilder();
    paramEngineContext.append("[cmshow][BKCMShowEngine][BKResourceService][");
    paramEngineContext.append(this.e.k());
    paramEngineContext.append(']');
    this.b = paramEngineContext.toString();
    this.c = new ReentrantLock();
    this.d = ((Map)new LinkedHashMap());
    paramEngineContext = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.e.k());
    QLog.i(paramEngineContext, 1, localStringBuilder.toString());
    this.e.a((IResourceService)this);
  }
  
  @NotNull
  public IApolloResManager a()
  {
    return ApolloResManagerFacade.a.a(EngineType.BK);
  }
  
  @NotNull
  public Script a(int paramInt)
  {
    Object localObject1 = (Script)null;
    localObject1 = (Lock)this.c;
    ((Lock)localObject1).lock();
    try
    {
      Object localObject2 = (Script)this.d.get(Integer.valueOf(paramInt));
      Unit localUnit = Unit.INSTANCE;
      ((Lock)localObject1).unlock();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = BKResourceService.Companion.a(a, paramInt);
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          if (ScriptHelper.a.a((String)localObject1))
          {
            if (paramInt != 0)
            {
              localObject1 = ScriptHelper.a;
              localObject2 = FileUtils.readFileToString((File)localObject2);
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "FileUtils.readFileToString(file)");
              localObject1 = ((ScriptHelper)localObject1).a(paramInt, (String)localObject2);
            }
            else if (!TextUtils.isEmpty((CharSequence)ApolloManagerServiceImpl.sBasicScript))
            {
              QLog.i(this.b, 1, "succeed to read script 0 from sBasicScript cache");
              localObject1 = ApolloManagerServiceImpl.sBasicScript;
            }
            else
            {
              localObject1 = FileUtils.readFileToString((File)localObject2);
            }
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "content");
            localObject1 = new Script((String)localObject1);
            ((Script)localObject1).a(paramInt);
            localObject2 = (Lock)this.c;
            ((Lock)localObject2).lock();
          }
          try
          {
            this.d.put(Integer.valueOf(paramInt), localObject1);
            localUnit = Unit.INSTANCE;
            ((Lock)localObject2).unlock();
          }
          finally
          {
            ((Lock)localObject2).unlock();
          }
          ((StringBuilder)localObject2).append("script[businessId=");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(", path:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("] verify failed.");
          throw ((Throwable)new ScriptVerifyException(((StringBuilder)localObject2).toString(), str));
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("script[businessId=");
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(", path:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("] not found.");
          throw ((Throwable)new ScriptNotFoundException(((StringBuilder)localObject2).toString(), str));
        }
      }
      if (str == null) {
        Intrinsics.throwNpe();
      }
      return str;
    }
    finally
    {
      str.unlock();
    }
  }
  
  public final void b()
  {
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.e.k());
    QLog.i(str, 1, localStringBuilder.toString());
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKResourceService
 * JD-Core Version:    0.7.0.1
 */