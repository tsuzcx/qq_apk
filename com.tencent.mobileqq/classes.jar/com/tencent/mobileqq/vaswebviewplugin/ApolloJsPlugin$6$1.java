package com.tencent.mobileqq.vaswebviewplugin;

import anfj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.filament.CmShowAssetsData;
import mqq.os.MqqHandler;

class ApolloJsPlugin$6$1
  implements anfj
{
  ApolloJsPlugin$6$1(ApolloJsPlugin.6 param6, CmShowAssetsData paramCmShowAssetsData) {}
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt)
  {
    ThreadManager.getFileThreadHandler().post(new ApolloJsPlugin.6.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin.6.1
 * JD-Core Version:    0.7.0.1
 */