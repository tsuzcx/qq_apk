package com.tencent.shadow.core.runtime.container;

public class ContentProviderDelegateProviderHolder
{
  static ContentProviderDelegateProvider contentProviderDelegateProvider;
  private static ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener sPrepareListener;
  
  private static void notifyDelegateProviderHolderPrepare()
  {
    ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener localDelegateProviderHolderPrepareListener = sPrepareListener;
    if (localDelegateProviderHolderPrepareListener != null) {
      localDelegateProviderHolderPrepareListener.onPrepare();
    }
  }
  
  public static void setContentProviderDelegateProvider(ContentProviderDelegateProvider paramContentProviderDelegateProvider)
  {
    contentProviderDelegateProvider = paramContentProviderDelegateProvider;
    notifyDelegateProviderHolderPrepare();
  }
  
  public static void setDelegateProviderHolderPrepareListener(ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener paramDelegateProviderHolderPrepareListener)
  {
    sPrepareListener = paramDelegateProviderHolderPrepareListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.container.ContentProviderDelegateProviderHolder
 * JD-Core Version:    0.7.0.1
 */