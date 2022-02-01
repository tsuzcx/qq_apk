package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

import org.w3c.dom.Document;

public abstract interface ITVKCGIVInfoResponse
{
  public abstract void OnVInfoFailure(String paramString1, String paramString2, int paramInt);
  
  public abstract void OnVInfoSuccess(String paramString1, String paramString2, Document paramDocument);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVInfoResponse
 * JD-Core Version:    0.7.0.1
 */