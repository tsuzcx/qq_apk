package com.tencent.mobileqq.cmshow.brickengine.script.task;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.cmshow.engine.script.task.CommonInitTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class BKCommonInitTask
  extends CommonInitTask
{
  protected JSONObject a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.a);
    ((StringBuilder)localObject1).append("/def/role/0/3D");
    Object localObject2 = new File(((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ApolloConstant.a);
    ((StringBuilder)localObject1).append("/def/role/0/3D/3DConfig.json");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject2).exists())
    {
      QLog.w("[cmshow][ScriptTask][BKCommonInitTask]", 1, "build3DJSON 3D dir NOT exist.");
      return null;
    }
    if (!((File)localObject1).exists())
    {
      QLog.w("[cmshow][ScriptTask][BKCommonInitTask]", 1, "build3DJSON 3DConfig NOT exist.");
      return null;
    }
    localObject1 = new JSONObject();
    if (new File((File)localObject2, "1/action.bin").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("1");
      ((JSONObject)localObject1).put("wait", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "4/action.bin").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("4");
      ((JSONObject)localObject1).put("standup", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "3/action.bin").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("3");
      ((JSONObject)localObject1).put("think", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "2/action.bin").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("2");
      ((JSONObject)localObject1).put("sitdown", ((StringBuilder)localObject3).toString());
    }
    if (new File((File)localObject2, "android/skeleton/skeleton.bin").exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("def/role/0/3D/");
      ((StringBuilder)localObject3).append("android/skeleton");
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
    if ((b() == 2) && (new File((File)localObject2, "friendcard/1/action.bin").exists()))
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
    if (new File((File)localObject2, "sayhi/1/action.bin").exists())
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
    Object localObject3 = new File((File)localObject2, "android/dress");
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
          localStringBuilder.append("android/dress/");
          localStringBuilder.append(localObject4.getName());
          ((JSONArray)localObject2).put(localStringBuilder.toString());
        }
        i += 1;
      }
      ((JSONObject)localObject1).put("defDress", localObject2);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.script.task.BKCommonInitTask
 * JD-Core Version:    0.7.0.1
 */