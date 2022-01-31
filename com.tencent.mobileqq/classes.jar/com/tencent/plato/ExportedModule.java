package com.tencent.plato;

import com.tencent.plato.core.IExportedMethod;
import com.tencent.plato.core.IExportedModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExportedModule
  implements IExportedModule
{
  private static volatile Map<Class<?>, Map<String, IExportedMethod>> sExportedMethods = new HashMap();
  private static volatile Map<Class<?>, JSONObject> sModuleDesces = new HashMap();
  private final Class<?> mClazz;
  private final String mModuleName;
  
  public ExportedModule(String paramString)
  {
    this.mModuleName = paramString;
    this.mClazz = getClass();
    if ((Map)sExportedMethods.get(this.mClazz) == null)
    {
      paramString = findExportedMethods();
      sExportedMethods.put(this.mClazz, paramString);
      sModuleDesces.put(this.mClazz, calModuleDesc(paramString));
    }
  }
  
  private JSONObject calModuleDesc(Map<String, IExportedMethod> paramMap)
  {
    localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("module", getName());
      JSONArray localJSONArray = new JSONArray();
      localJSONObject1.put("methods", localJSONArray);
      paramMap = new ArrayList(paramMap.values());
      int i = 0;
      while (i < paramMap.size())
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONArray.put(localJSONObject2);
        localJSONObject2.put("method", ((IExportedMethod)paramMap.get(i)).getName());
        localJSONObject2.put("methodId", i);
        i += 1;
      }
      return localJSONObject1;
    }
    catch (JSONException paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  private Map<String, IExportedMethod> findExportedMethods()
  {
    return ExportedMethodFinder.findExportedMethods(this.mClazz);
  }
  
  public Map<String, IExportedMethod> getExportedMethods()
  {
    return (Map)sExportedMethods.get(this.mClazz);
  }
  
  public JSONObject getModuleDesc()
  {
    return (JSONObject)sModuleDesces.get(this.mClazz);
  }
  
  public String getName()
  {
    return this.mModuleName;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.ExportedModule
 * JD-Core Version:    0.7.0.1
 */