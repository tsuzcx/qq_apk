package com.tencent.mobileqq.mini.manager;

import blbu;
import blbv;
import blbw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MiniTianShuManager
{
  public static final String TAG = "MiniTianShuManager";
  private static List<blbv> mCallbackList = new ArrayList();
  
  public static void requestAdv(List<blbu> paramList, blbv paramblbv)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (paramblbv == null)) {
      return;
    }
    paramblbv = new MiniTianShuManager.1(paramblbv);
    mCallbackList.add(paramblbv);
    QLog.i("MiniTianShuManager", 1, "add callback " + mCallbackList.size());
    blbw.a().a(paramList, paramblbv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager
 * JD-Core Version:    0.7.0.1
 */