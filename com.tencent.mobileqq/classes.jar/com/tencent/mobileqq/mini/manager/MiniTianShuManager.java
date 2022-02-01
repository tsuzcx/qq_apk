package com.tencent.mobileqq.mini.manager;

import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuAdPosItemData;
import cooperation.vip.tianshu.TianShuGetAdvCallback;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

public class MiniTianShuManager
{
  public static final String TAG = "MiniTianShuManager";
  private static List<TianShuGetAdvCallback> mCallbackList = new ArrayList();
  
  public static void requestAdv(List<TianShuAdPosItemData> paramList, TianShuGetAdvCallback paramTianShuGetAdvCallback)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (paramTianShuGetAdvCallback == null)) {
      return;
    }
    paramTianShuGetAdvCallback = new MiniTianShuManager.1(paramTianShuGetAdvCallback);
    mCallbackList.add(paramTianShuGetAdvCallback);
    QLog.i("MiniTianShuManager", 1, "add callback " + mCallbackList.size());
    TianShuManager.getInstance().requestAdv(paramList, paramTianShuGetAdvCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager
 * JD-Core Version:    0.7.0.1
 */