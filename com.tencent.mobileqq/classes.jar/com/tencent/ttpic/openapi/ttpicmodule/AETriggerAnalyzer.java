package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.IAIDataClassifier;
import java.util.HashMap;

public class AETriggerAnalyzer
{
  private static final AETriggerAnalyzer ourInstance = new AETriggerAnalyzer();
  private HashMap<String, IAIDataClassifier> classifierMap = new HashMap();
  
  public static AETriggerAnalyzer getInstance()
  {
    return ourInstance;
  }
  
  public void addClassifier(IAIDataClassifier paramIAIDataClassifier)
  {
    this.classifierMap.put(paramIAIDataClassifier.getClass().getName(), paramIAIDataClassifier);
    AEDependencyManager.getInstance().loadDependency(paramIAIDataClassifier.getModuleName());
  }
  
  public IAIDataClassifier getClassifier(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (IAIDataClassifier)this.classifierMap.get(paramString);
    }
    return null;
  }
  
  public boolean isTriggered(String paramString, AIAttr paramAIAttr)
  {
    paramString = paramString.split("-");
    int i = paramString.length;
    boolean bool2 = false;
    boolean bool1 = bool2;
    String str;
    if (i == 2) {
      str = paramString[0];
    }
    try
    {
      i = Integer.parseInt(paramString[1]);
      paramString = getInstance().getClassifier(str);
      bool1 = bool2;
      if (paramString != null)
      {
        int j = paramString.classifyData2Type(paramAIAttr);
        boolean bool3 = paramString.getClassifierTypeMap().containsValue(Integer.valueOf(j));
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (i == j) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (NumberFormatException paramString) {}
    return false;
  }
  
  public void removeClassifier(IAIDataClassifier paramIAIDataClassifier)
  {
    this.classifierMap.remove(paramIAIDataClassifier);
    AEDependencyManager.getInstance().unloadDependency(paramIAIDataClassifier.getModuleName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AETriggerAnalyzer
 * JD-Core Version:    0.7.0.1
 */