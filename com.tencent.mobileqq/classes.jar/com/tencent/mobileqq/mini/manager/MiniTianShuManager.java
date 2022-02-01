package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

public class MiniTianShuManager
{
  public static final String TAG = "MiniTianShuManager";
  private static List<TianShuGetAdvCallback> mCallbackList = new ArrayList();
  
  public static void requestAdv(List<TianShuAdPosItemData> paramList, TianShuGetAdvCallback paramTianShuGetAdvCallback)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramTianShuGetAdvCallback == null) {
        return;
      }
      paramTianShuGetAdvCallback = new MiniTianShuManager.1(paramTianShuGetAdvCallback);
      mCallbackList.add(paramTianShuGetAdvCallback);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add callback ");
      localStringBuilder.append(mCallbackList.size());
      QLog.i("MiniTianShuManager", 1, localStringBuilder.toString());
      TianShuManager.getInstance().requestAdv(paramList, paramTianShuGetAdvCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager
 * JD-Core Version:    0.7.0.1
 */