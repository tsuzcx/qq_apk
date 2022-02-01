package com.tencent.mobileqq.mini.manager;

import bnwo;
import bnwp;
import bnwq;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MiniTianShuManager
{
  public static final String TAG = "MiniTianShuManager";
  private static List<bnwp> mCallbackList = new ArrayList();
  
  public static void requestAdv(List<bnwo> paramList, bnwp parambnwp)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (parambnwp == null)) {
      return;
    }
    parambnwp = new MiniTianShuManager.1(parambnwp);
    mCallbackList.add(parambnwp);
    QLog.i("MiniTianShuManager", 1, "add callback " + mCallbackList.size());
    bnwq.a().a(paramList, parambnwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager
 * JD-Core Version:    0.7.0.1
 */