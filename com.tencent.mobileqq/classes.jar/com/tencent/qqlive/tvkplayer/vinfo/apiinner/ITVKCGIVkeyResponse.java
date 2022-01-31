package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

import org.w3c.dom.Document;

public abstract interface ITVKCGIVkeyResponse
{
  public abstract void OnVkeyFailure(String paramString1, String paramString2, int paramInt);
  
  public abstract void OnVkeySuccess(String paramString1, String paramString2, Document paramDocument);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse
 * JD-Core Version:    0.7.0.1
 */