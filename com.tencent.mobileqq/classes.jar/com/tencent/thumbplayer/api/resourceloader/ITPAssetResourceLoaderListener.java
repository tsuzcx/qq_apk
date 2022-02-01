package com.tencent.thumbplayer.api.resourceloader;

public abstract interface ITPAssetResourceLoaderListener
{
  public abstract void didCancelLoadingRequest(ITPAssetResourceLoadingRequest paramITPAssetResourceLoadingRequest);
  
  public abstract void fillInContentInformation(TPAssetResourceLoadingContentInformationRequest paramTPAssetResourceLoadingContentInformationRequest);
  
  public abstract boolean shouldWaitForLoadingOfRequestedResource(ITPAssetResourceLoadingRequest paramITPAssetResourceLoadingRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener
 * JD-Core Version:    0.7.0.1
 */