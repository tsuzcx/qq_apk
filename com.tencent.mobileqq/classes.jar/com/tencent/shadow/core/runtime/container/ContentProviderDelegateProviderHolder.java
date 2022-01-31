package com.tencent.shadow.core.runtime.container;

public class ContentProviderDelegateProviderHolder
{
  static ContentProviderDelegateProvider contentProviderDelegateProvider;
  private static ContentProviderDelegateProviderHolder.DelegateProviderHolderPrepareListener sPrepareListener;
  
  private static void notifyDelegateProviderHolderPrepare()
  {
    if (sPrepareListener != null) {
      sPrepareListener.onPrepare();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.container.ContentProviderDelegateProviderHolder
 * JD-Core Version:    0.7.0.1
 */