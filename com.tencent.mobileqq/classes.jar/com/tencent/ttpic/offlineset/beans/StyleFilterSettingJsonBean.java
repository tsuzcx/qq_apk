package com.tencent.ttpic.offlineset.beans;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StyleFilterSettingJsonBean
{
  public int faceThreshold = 65;
  public int highlightThreshold = 128;
  public String id;
  public float isDenoise = 0.0F;
  public Map<String, String> lutPaths;
  public Map<String, String> materialPaths;
  public float styleParams = 0.18F;
  public int type;
  public int typeThreshold = 90;
  
  public StyleFilterSettingJsonBean() {}
  
  public StyleFilterSettingJsonBean(int paramInt)
  {
    this.type = paramInt;
  }
  
  private void updateMap(String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      if (paramMap != null)
      {
        if (!paramMap.hasNext()) {
          return;
        }
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(File.separator);
          localStringBuilder.append((String)localEntry.getValue());
          localEntry.setValue(localStringBuilder.toString());
        }
      }
    }
  }
  
  public boolean isCurrentStyle(String paramString)
  {
    String str = this.id;
    return (str != null) && (paramString != null) && (str.equals(paramString));
  }
  
  public void updatePath(String paramString)
  {
    updateMap(paramString, this.lutPaths);
    updateMap(paramString, this.materialPaths);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.offlineset.beans.StyleFilterSettingJsonBean
 * JD-Core Version:    0.7.0.1
 */