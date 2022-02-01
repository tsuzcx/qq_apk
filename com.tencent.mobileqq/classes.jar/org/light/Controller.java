package org.light;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.light.bean.WMElement;

public abstract class Controller
{
  public static final int ControllerType_Camera = 1;
  public static final int ControllerType_Movie = 0;
  protected long nativeHandle;
  
  static
  {
    LibraryLoadUtils.loadLibrary("light-sdk");
    nativeInit();
  }
  
  private native WMElement[] getEditableItems();
  
  private native void nativeFinalize();
  
  private static native void nativeInit();
  
  public native void addEntity(int paramInt1, int paramInt2, String paramString);
  
  protected void finalize()
  {
    super.finalize();
    nativeFinalize();
  }
  
  public native AudioPlaceHolder[] getAudioPlaceHolders();
  
  public native RectF getBoundsByKey(String paramString);
  
  public native TextPlaceHolder getEditableTextUnderPoint(float paramFloat1, float paramFloat2);
  
  public List<WMElement> getEditableWMElement()
  {
    ArrayList localArrayList = new ArrayList();
    WMElement[] arrayOfWMElement = getEditableItems();
    int j = arrayOfWMElement.length;
    int i = 0;
    while (i < j)
    {
      WMElement localWMElement = arrayOfWMElement[i];
      localWMElement.controller = this;
      localArrayList.add(localWMElement);
      i += 1;
    }
    return localArrayList;
  }
  
  public native int[] getEntitiesUnderPoint(float paramFloat1, float paramFloat2);
  
  public native String[] getSoundEffectIDs();
  
  public native TextPlaceHolder[] getTextPlaceHolderByEntityId(int paramInt);
  
  public native TextPlaceHolder[] getTextPlaceHolders();
  
  public native boolean hasAudio();
  
  public native HashMap<String, String> presetData();
  
  public native void removeEntity(int paramInt);
  
  public native void replaceAudioAsset(String paramString, AudioAsset paramAudioAsset);
  
  public native void resetAsset();
  
  public native void setExternalAudioProcessor(HashMap<String, IExternalAudioProcessor> paramHashMap);
  
  public native void setMaterialClipAssets(String paramString, ClipAsset[] paramArrayOfClipAsset);
  
  public native void setPresetData(HashMap<String, String> paramHashMap);
  
  public native void setTextAsset(String paramString, TextAsset paramTextAsset);
  
  public native TimeLine[] timeLine();
  
  public abstract int type();
  
  public native void updateComponent(int paramInt, String paramString);
  
  public native void updateResource(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.Controller
 * JD-Core Version:    0.7.0.1
 */