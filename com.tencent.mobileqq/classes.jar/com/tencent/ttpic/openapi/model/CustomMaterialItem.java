package com.tencent.ttpic.openapi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomMaterialItem
{
  private static final String CAMERA = "$cameraTexture";
  private static final String PRESERVED = "$preservedTexture_";
  public String matName;
  public List<String> nodeNameList = new ArrayList();
  public List<CustomMaterialItem.CustomMaterialParams> params = new ArrayList();
  
  public boolean hasCameraTexture()
  {
    if (this.params == null) {
      return false;
    }
    Object localObject;
    do
    {
      Iterator localIterator = this.params.iterator();
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (CustomMaterialItem.CustomMaterialParams)localIterator.next();
        if (((CustomMaterialItem.CustomMaterialParams)localObject).value == null) {
          return false;
        }
        localObject = ((CustomMaterialItem.CustomMaterialParams)localObject).value.iterator();
      }
    } while (!((String)((Iterator)localObject).next()).equals("$cameraTexture"));
    return true;
    return false;
  }
  
  public Set<String> specialFilterFrameKeys()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = this.params.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((CustomMaterialItem.CustomMaterialParams)localIterator1.next()).value.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (str.startsWith("$preservedTexture_")) {
          localHashSet.add(str);
        }
      }
    }
    return localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.CustomMaterialItem
 * JD-Core Version:    0.7.0.1
 */