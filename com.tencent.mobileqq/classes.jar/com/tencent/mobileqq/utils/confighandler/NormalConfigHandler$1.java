package com.tencent.mobileqq.utils.confighandler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.SyncLoadTask.OnSyncTaskListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NormalConfigHandler$1
  implements SyncLoadTask.OnSyncTaskListener
{
  NormalConfigHandler$1(NormalConfigHandler paramNormalConfigHandler, NormalConfigHandler.GetConfigListen paramGetConfigListen, AppInterface paramAppInterface) {}
  
  public void a(boolean paramBoolean, ArrayList<SyncLoadTask> paramArrayList)
  {
    paramArrayList = (ReadConfigTask)paramArrayList.get(0);
    StringBuilder localStringBuilder;
    if ((this.c.mReadConfigTask != null) && (this.c.mReadConfigTask == paramArrayList))
    {
      localObject = this.c.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("异步加载config返回, bsuc[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], TAG[");
      localStringBuilder.append(paramArrayList.mTAG);
      localStringBuilder.append("], config[");
      localStringBuilder.append(paramArrayList.mConfigInfo);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.c.mReadConfigTask = null;
    }
    else
    {
      localObject = this.c.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("异步加载config返回[");
      localStringBuilder.append(paramArrayList.mTAG);
      localStringBuilder.append("], 但原请求取消了");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((NormalConfigHandler.GetConfigListen)localObject).onGetConfig(this.b, paramArrayList.mConfigInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.NormalConfigHandler.1
 * JD-Core Version:    0.7.0.1
 */