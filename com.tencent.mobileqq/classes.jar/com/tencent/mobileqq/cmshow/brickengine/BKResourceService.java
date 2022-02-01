package com.tencent.mobileqq.cmshow.brickengine;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKResourceService;", "Lcom/tencent/mobileqq/cmshow/engine/resource/IResourceService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "TAG", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "scriptMap", "", "", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "destroy", "", "getResourcePath", "type", "id", "getResourceUrl", "getScriptById", "businessId", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKResourceService
  implements IResourceService
{
  @Deprecated
  public static final BKResourceService.Companion a;
  private final EngineContext jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext;
  private final String jdField_a_of_type_JavaLangString;
  private final Map<Integer, Script> jdField_a_of_type_JavaUtilMap;
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKResourceService$Companion = new BKResourceService.Companion(null);
  }
  
  public BKResourceService(@NotNull EngineContext paramEngineContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext = paramEngineContext;
    paramEngineContext = new StringBuilder();
    paramEngineContext.append("[cmshow][BKCMShowEngine][BKResourceService][");
    paramEngineContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    paramEngineContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramEngineContext.toString();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    paramEngineContext = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    QLog.i(paramEngineContext, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a((IResourceService)this);
  }
  
  @NotNull
  public Script a(int paramInt)
  {
    Object localObject1 = (Script)null;
    localObject1 = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject1).lock();
    try
    {
      Object localObject2 = (Script)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      Unit localUnit = Unit.INSTANCE;
      ((Lock)localObject1).unlock();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = BKResourceService.Companion.a(jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKResourceService$Companion, paramInt);
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
              QLog.i(this.jdField_a_of_type_JavaLangString, 1, "succeed to read script 0 from sBasicScript cache");
              localObject1 = ApolloManagerServiceImpl.sBasicScript;
            }
            else
            {
              localObject1 = FileUtils.readFileToString((File)localObject2);
            }
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "content");
            localObject1 = new Script((String)localObject1);
            ((Script)localObject1).a(paramInt);
            localObject2 = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
            ((Lock)localObject2).lock();
          }
          try
          {
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject1);
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
  
  public final void a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("destroy ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    QLog.i(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKResourceService
 * JD-Core Version:    0.7.0.1
 */