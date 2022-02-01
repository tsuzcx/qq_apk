package com.tencent.mobileqq.cmshow.crossengine.script.task;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.script.task.CommonInitTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CECommonInitTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/CommonInitTask;", "apolloResManager", "Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;", "(Lcom/tencent/mobileqq/cmshow/engine/resource/IApolloResManager;)V", "build3DJSON", "Lorg/json/JSONObject;", "buildBasicJSON", "getCameraConfig", "Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CECommonInitTask$CameraInfo;", "", "CameraInfo", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CECommonInitTask
  extends CommonInitTask
{
  @Deprecated
  public static final CECommonInitTask.Companion a = new CECommonInitTask.Companion(null);
  
  public CECommonInitTask(@NotNull IApolloResManager paramIApolloResManager)
  {
    super(paramIApolloResManager);
  }
  
  private final CECommonInitTask.CameraInfo f(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return null;
    }
    return new CECommonInitTask.CameraInfo(Float.valueOf(20.0F), Float.valueOf(32.0F), Float.valueOf(380.0F));
  }
  
  @Nullable
  protected JSONObject b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.a);
    ((StringBuilder)localObject1).append("/def/role/0/3D");
    Object localObject2 = new File(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.a);
    ((StringBuilder)localObject1).append("/def/role/0/3D/3DConfig.json");
    new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject2).exists())
    {
      QLog.w("[cmshow][ScriptTask][CECommonInitTask]", 1, "build3DJSON 3D dir NOT exist.");
      return null;
    }
    localObject1 = new JSONObject();
    if (new File((File)localObject2, "1/action__ANIM.nda").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("1");
      ((JSONObject)localObject1).put("wait", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "4/action__ANIM.nda").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("4");
      ((JSONObject)localObject1).put("standup", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "3/action__ANIM.nda").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("3");
      ((JSONObject)localObject1).put("think", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "2/action__ANIM.nda").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("2");
      ((JSONObject)localObject1).put("sitdown", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "ios/skeleton/Luomo_rig.nda").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("ios/skeleton");
      ((JSONObject)localObject1).put("defRole", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "transformAction/3to2/action.bin").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("transformAction/3to2");
      ((JSONObject)localObject1).put("3to2DAction", ((StringBuilder)localObject3).toString());
    }
    if ((new File((File)localObject2, "transformAction/2to3/action.atlas").exists()) && (new File((File)localObject2, "transformAction/2to3/action.png").exists()) && (new File((File)localObject2, "transformAction/2to3/action.json").exists()))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("transformAction/2to3");
      ((JSONObject)localObject1).put("2to3DAction", ((StringBuilder)localObject3).toString());
    }
    if ((i() == 2) && (new File((File)localObject2, "friendcard/1/action.bin").exists()))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("friendcard/1");
      ((JSONObject)localObject1).put("friendcard_up", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("friendcard/2");
      ((JSONObject)localObject1).put("friendcard_down", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "sayhi/1/action.nda").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("sayhi/1");
      ((JSONObject)localObject1).put("sayhi", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "bubble").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("bubble");
      ((JSONObject)localObject1).put("bubble", ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = new File((File)localObject2, "ios/dress");
    if (((File)localObject3).exists())
    {
      localObject2 = new JSONArray();
      localObject3 = ((File)localObject3).listFiles();
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        Object localObject4 = localObject3[i];
        if ((localObject4 != null) && (localObject4.exists()) && (localObject4.isDirectory()))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("def/role/0/3D/");
          localStringBuilder.append("ios/dress/");
          localStringBuilder.append(localObject4.getName());
          ((JSONArray)localObject2).put(localStringBuilder.toString());
        }
        i += 1;
      }
      ((JSONObject)localObject1).put("defDress", localObject2);
    }
    return localObject1;
  }
  
  @NotNull
  protected JSONObject c()
  {
    JSONObject localJSONObject1 = super.c();
    Object localObject = f(i());
    if (localObject != null)
    {
      JSONObject localJSONObject2 = new JSONObject();
      Float localFloat = ((CECommonInitTask.CameraInfo)localObject).a();
      if (localFloat != null) {
        localJSONObject2.put("X", Float.valueOf(((Number)localFloat).floatValue()));
      }
      localFloat = ((CECommonInitTask.CameraInfo)localObject).b();
      if (localFloat != null) {
        localJSONObject2.put("Y", Float.valueOf(((Number)localFloat).floatValue()));
      }
      localObject = ((CECommonInitTask.CameraInfo)localObject).c();
      if (localObject != null) {
        localJSONObject2.put("Z", Float.valueOf(((Number)localObject).floatValue()));
      }
      if (localJSONObject2.length() > 0) {
        localJSONObject1.put("camera", localJSONObject2);
      } else {
        QLog.w("[cmshow][ScriptTask][CECommonInitTask]", 1, "no camera config");
      }
    }
    Intrinsics.checkExpressionValueIsNotNull(localJSONObject1, "basic");
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.task.CECommonInitTask
 * JD-Core Version:    0.7.0.1
 */