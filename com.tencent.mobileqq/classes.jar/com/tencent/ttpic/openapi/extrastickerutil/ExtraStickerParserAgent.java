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
    if (this.mParsersMap != null) {
      this.mParsersMap.clear();
    }
    this.mPagFactoryListener = null;
  }
  
  public IExtraStickerParser creatExtraParser(int paramInt)
  {
    if (this.mParsersMap != null)
    {
      IExtraParserFactoryListener localIExtraParserFactoryListener = (IExtraParserFactoryListener)this.mParsersMap.get(Integer.valueOf(paramInt));
      if (localIExtraParserFactoryListener != null) {
        return localIExtraParserFactoryListener.creatExtraStickerParser();
      }
    }
    return null;
  }
  
  public IExtraStickerParser creatPagParser()
  {
    if (this.mPagFactoryListener != null) {
      return this.mPagFactoryListener.creatExtraStickerParser();
    }
    return null;
  }
  
  public boolean isInExtraParser(int paramInt)
  {
    if (this.mParsersMap != null) {
      return this.mParsersMap.containsKey(Integer.valueOf(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent
 * JD-Core Version:    0.7.0.1
 */