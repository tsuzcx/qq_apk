package com.tencent.tgpa.vendorpd;

import android.content.Context;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.util.ArrayList;
import java.util.HashMap;

public class GameHelper
{
  private static volatile GamePredownloader mInstance;
  
  public static int combinePackage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return getGamePredownloader().combinePackage(paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static void enableDebug(boolean paramBoolean)
  {
    getGamePredownloader().enableDebug(paramBoolean);
  }
  
  private static GamePredownloader getGamePredownloader()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new GamePredownloaderImpl();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public static void getGameVersionUpdateInfo(Context paramContext, String paramString, ArrayList<String> paramArrayList, GameCallback paramGameCallback)
  {
    getGamePredownloader().getGameVersionUpdateInfo(paramContext, paramString, paramArrayList, paramGameCallback);
  }
  
  public static void init(String paramString1, String paramString2)
  {
    getGamePredownloader().setApiKey(paramString1);
    getGamePredownloader().setApiSecret(paramString2);
  }
  
  public static void init(String paramString1, String paramString2, GamePredownloader.LibLoader paramLibLoader)
  {
    getGamePredownloader().setApiKey(paramString1);
    getGamePredownloader().setApiSecret(paramString2);
    GradishWrapper.tryLoadLibrary(paramLibLoader);
  }
  
  public static void init(String paramString1, String paramString2, String paramString3)
  {
    getGamePredownloader().setApiKey(paramString1);
    getGamePredownloader().setApiSecret(paramString2);
    getGamePredownloader().setDeviceIdentifier(paramString3);
  }
  
  public static void reportPreDownladInfo(Context paramContext, HashMap<String, String> paramHashMap)
  {
    getGamePredownloader().reportPreDownladInfo(paramContext, paramHashMap);
  }
  
  @Deprecated
  public static void reportPreDownladInfo(HashMap<String, String> paramHashMap)
  {
    getGamePredownloader().reportPreDownladInfo(null, paramHashMap);
  }
  
  public static void setLogAble(boolean paramBoolean)
  {
    getGamePredownloader().setLogAble(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.GameHelper
 * JD-Core Version:    0.7.0.1
 */