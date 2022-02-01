package com.tencent.tgpa.vendorpd;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;

public abstract interface GamePredownloader
{
  public abstract int combinePackage(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void enableDebug(boolean paramBoolean);
  
  public abstract void getGameVersionUpdateInfo(Context paramContext, String paramString, ArrayList<String> paramArrayList, GameCallback paramGameCallback);
  
  public abstract void reportPreDownladInfo(Context paramContext, HashMap<String, String> paramHashMap);
  
  public abstract void setApiKey(String paramString);
  
  public abstract void setApiSecret(String paramString);
  
  public abstract void setDeviceIdentifier(String paramString);
  
  public abstract void setLogAble(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.GamePredownloader
 * JD-Core Version:    0.7.0.1
 */