package com.tencent.mobileqq.mini.manager;

import bmvg;
import bmvh;
import bmvi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MiniTianShuManager
{
  public static final String TAG = "MiniTianShuManager";
  private static List<bmvh> mCallbackList = new ArrayList();
  
  public static void requestAdv(List<bmvg> paramList, bmvh parambmvh)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (parambmvh == null)) {
      return;
    }
    parambmvh = new MiniTianShuManager.1(parambmvh);
    mCallbackList.add(parambmvh);
    QLog.i("MiniTianShuManager", 1, "add callback " + mCallbackList.size());
    bmvi.a().a(paramList, parambmvh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniTianShuManager
 * JD-Core Version:    0.7.0.1
 */