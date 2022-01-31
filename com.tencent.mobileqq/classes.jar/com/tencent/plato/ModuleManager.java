package com.tencent.plato;

import com.tencent.plato.core.IExportedModule;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.utils.PLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ModuleManager
{
  private static final String TAG = "ModuleManager";
  private final List<ExportedModuleWrapper> mExportedModuleWrappers;
  private final Map<Class<? extends IExportedModule>, IExportedModule> mExportedModules = new HashMap();
  private final int mModuleSize;
  
  public ModuleManager(IPlatoRuntime paramIPlatoRuntime, Collection<IExportedModule> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      IExportedModule localIExportedModule = (IExportedModule)paramCollection.next();
      this.mExportedModules.put(localIExportedModule.getClass(), localIExportedModule);
      localArrayList.add(new ExportedModuleWrapper(paramIPlatoRuntime, localIExportedModule));
    }
    this.mExportedModuleWrappers = Collections.unmodifiableList(localArrayList);
    this.mModuleSize = this.mExportedModuleWrappers.size();
  }
  
  public <T extends IExportedModule> T getExportedModule(Class<T> paramClass)
  {
    return (IExportedModule)this.mExportedModules.get(paramClass);
  }
  
  public Object invoke(int paramInt1, int paramInt2, IReadableArray paramIReadableArray)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.mModuleSize))
    {
      PLog.e("ModuleManager", "callNative moduleId is not correct:" + paramInt1 + "->" + paramInt2 + " args:" + paramIReadableArray);
      return null;
    }
    return ((ExportedModuleWrapper)this.mExportedModuleWrappers.get(paramInt1)).invoke(paramInt2, paramIReadableArray);
  }
  
  public static class Arr
  {
    private static JSONArray jsonArray = new JSONArray();
    private static List<IExportedModule> mModules = new ArrayList();
    private static int moduleIndex = 0;
    private static String sAllModuleDesc;
    
    public static void addModules(List<IExportedModule> paramList)
    {
      mModules.addAll(paramList);
      int i = 0;
      int j = paramList.size();
      for (;;)
      {
        if (i < j)
        {
          JSONObject localJSONObject = ((IExportedModule)paramList.get(i)).getModuleDesc();
          try
          {
            localJSONObject.put("moduleId", moduleIndex);
            moduleIndex += 1;
            jsonArray.put(localJSONObject);
            i += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
      sAllModuleDesc = jsonArray.toString();
    }
    
    public static String getAllModuleDesc()
    {
      return sAllModuleDesc;
    }
    
    public static List<IExportedModule> getModules()
    {
      return mModules;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.plato.ModuleManager
 * JD-Core Version:    0.7.0.1
 */