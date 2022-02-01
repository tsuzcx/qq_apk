package com.tencent.ttpic.openapi.extrastickerutil;

import java.util.HashMap;

public class ExtraStickerParserAgent
{
  private static ExtraStickerParserAgent sInstance;
  private IExtraParserFactoryListener mPagFactoryListener;
  private HashMap<Integer, IExtraParserFactoryListener> mParsersMap;
  
  public static ExtraStickerParserAgent getInstance()
  {
    if (sInstance == null) {
      sInstance = new ExtraStickerParserAgent();
    }
    return sInstance;
  }
  
  public void clear()
  {
    HashMap localHashMap = this.mParsersMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
    this.mPagFactoryListener = null;
  }
  
  public IExtraStickerParser creatExtraParser(int paramInt)
  {
    Object localObject = this.mParsersMap;
    if (localObject != null)
    {
      localObject = (IExtraParserFactoryListener)((HashMap)localObject).get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return ((IExtraParserFactoryListener)localObject).creatExtraStickerParser();
      }
    }
    return null;
  }
  
  public IExtraStickerParser creatPagParser()
  {
    IExtraParserFactoryListener localIExtraParserFactoryListener = this.mPagFactoryListener;
    if (localIExtraParserFactoryListener != null) {
      return localIExtraParserFactoryListener.creatExtraStickerParser();
    }
    return null;
  }
  
  public boolean isInExtraParser(int paramInt)
  {
    HashMap localHashMap = this.mParsersMap;
    if (localHashMap != null) {
      return localHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
  
  public void setExtraParserFactoryListener(int paramInt, IExtraParserFactoryListener paramIExtraParserFactoryListener)
  {
    if (this.mParsersMap == null) {
      this.mParsersMap = new HashMap();
    }
    this.mParsersMap.put(Integer.valueOf(paramInt), paramIExtraParserFactoryListener);
  }
  
  public void setPagFactoryListener(IExtraParserFactoryListener paramIExtraParserFactoryListener)
  {
    this.mPagFactoryListener = paramIExtraParserFactoryListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent
 * JD-Core Version:    0.7.0.1
 */