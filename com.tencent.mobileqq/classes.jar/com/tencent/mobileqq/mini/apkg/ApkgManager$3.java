package com.tencent.mobileqq.mini.apkg;

class ApkgManager$3
  implements ApkgManager.OnInitApkgListener
{
  ApkgManager$3(ApkgManager paramApkgManager, ApkgManager.OnGetApkgInfoListener paramOnGetApkgInfoListener) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    if (paramInt == 0)
    {
      ApkgManager.OnGetApkgInfoListener localOnGetApkgInfoListener = this.val$listener;
      if (localOnGetApkgInfoListener != null) {
        localOnGetApkgInfoListener.onGetApkgInfo(paramApkgInfo, paramInt, paramString);
      }
    }
    else
    {
      paramApkgInfo = this.val$listener;
      if (paramApkgInfo != null) {
        paramApkgInfo.onGetApkgInfo(null, paramInt, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgManager.3
 * JD-Core Version:    0.7.0.1
 */