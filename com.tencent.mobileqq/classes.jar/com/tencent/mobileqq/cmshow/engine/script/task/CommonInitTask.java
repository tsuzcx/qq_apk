package com.tencent.mobileqq.cmshow.engine.script.task;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class CommonInitTask
  extends AbsScriptTask
{
  protected int a;
  protected boolean a;
  protected int b;
  protected int c;
  
  private void a(JSONObject paramJSONObject)
  {
    int i = b();
    if ((i != 1) && (i != 2)) {
      return;
    }
    Object localObject = ApolloUtilImpl.getQQApp();
    if (!ApolloActionHelperImpl.checkBasicActionExit((QQAppInterface)localObject)) {
      return;
    }
    paramJSONObject.put("drawer_up", "def/role/0/drawer/1/action/action");
    paramJSONObject.put("drawer_down", "def/role/0/drawer/2/action/action");
    paramJSONObject.put("friendcard_up", "def/role/0/friendcard/1/action/action");
    paramJSONObject.put("friendcard_down", "def/role/0/friendcard/2/action/action");
    paramJSONObject.put("drawer_pet_up", "def/role/0/drawer/3/action/action");
    paramJSONObject.put("drawer_pet_down", "def/role/0/drawer/4/action/action");
    localObject = (ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
    if (localObject != null) {
      paramJSONObject.put("drawerGameBoxUser", ((ApolloManagerServiceImpl)localObject).mIsDrawerGameBoxUser);
    }
  }
  
  public CommonInitTask a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public CommonInitTask a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    try
    {
      Object localObject1 = b();
      ((JSONObject)localObject1).put("defRole", ApolloActionHelperImpl.getApolloRsc(0, 0));
      Object localObject2 = a();
      if (localObject2 != null) {
        ((JSONObject)localObject1).put("defDress", localObject2);
      }
      localObject2 = b();
      if (localObject2 != null) {
        ((JSONObject)localObject1).put("shaderCodes", localObject2);
      }
      localObject2 = a();
      if ((localObject2 != null) && (((JSONObject)localObject2).length() != 0)) {
        ((JSONObject)localObject1).put("3DObject", localObject2);
      } else {
        QLog.e("[cmshow][ScriptTask][CommonInitTask]", 1, "build commonInit script without default 3D actions");
      }
      a((JSONObject)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("if (typeof commonInit == 'function') {\n    commonInit('");
      ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
      ((StringBuilder)localObject2).append("');\n}");
      localObject1 = ((StringBuilder)localObject2).toString();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("buildScript:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("[cmshow][ScriptTask][CommonInitTask]", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow][ScriptTask][CommonInitTask]", 1, "[getCommonInit], errInfo->", localThrowable);
    }
    return null;
  }
  
  protected JSONArray a()
  {
    JSONArray localJSONArray = new JSONArray();
    int[] arrayOfInt = new int[7];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 1;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 2;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 3;
    int[] tmp28_24 = tmp24_20;
    tmp28_24[3] = 4;
    int[] tmp32_28 = tmp28_24;
    tmp32_28[4] = 5;
    int[] tmp36_32 = tmp32_28;
    tmp36_32[5] = 6;
    int[] tmp41_36 = tmp36_32;
    tmp41_36[6] = 7;
    tmp41_36;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(ApolloActionHelperImpl.getApolloRsc(1, Integer.valueOf(arrayOfInt[i]).intValue()));
      i += 1;
    }
    return localJSONArray;
  }
  
  protected abstract JSONObject a();
  
  public CommonInitTask b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  protected JSONArray b()
  {
    Object localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/shader_code/");
    if (!((File)localObject1).isDirectory())
    {
      QLog.w("[cmshow][ScriptTask][CommonInitTask]", 1, "buildShaderCodeArray shaderCodes dir no exist");
      return null;
    }
    Object localObject2 = ((File)localObject1).listFiles();
    if ((localObject2 != null) && (localObject2.length != 0))
    {
      localObject1 = new JSONArray();
      int i = 0;
      while (i < localObject2.length)
      {
        String str = localObject2[i].getName();
        ((JSONArray)localObject1).put(str);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildShaderCodeArray add shaderCode:");
          localStringBuilder.append(str);
          QLog.i("[cmshow][ScriptTask][CommonInitTask]", 2, localStringBuilder.toString());
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("buildShaderCodeArray shaderCodes shaderArray:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("[cmshow][ScriptTask][CommonInitTask]", 1, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    QLog.w("[cmshow][ScriptTask][CommonInitTask]", 1, "buildShaderCodeArray shaderCodes file no exist");
    return null;
  }
  
  protected JSONObject b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public CommonInitTask c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.CommonInitTask
 * JD-Core Version:    0.7.0.1
 */