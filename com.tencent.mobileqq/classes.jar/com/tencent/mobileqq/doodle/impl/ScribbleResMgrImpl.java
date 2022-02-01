package com.tencent.mobileqq.doodle.impl;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.doodle.IScribbleResMgr;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import java.util.ArrayList;

public class ScribbleResMgrImpl
  implements IScribbleResMgr
{
  public ArrayList<Integer> GetGifVisibleIdList()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ScribbleResMgr.a().b(localQQAppInterface);
  }
  
  public ArrayList<Integer> GetPaintVisibleIdList()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    return ScribbleResMgr.a().a(localQQAppInterface);
  }
  
  public String GetResIconPath(int paramInt1, int paramInt2)
  {
    return ScribbleResMgr.a(paramInt1, paramInt2);
  }
  
  public String GetResPath(int paramInt1, int paramInt2)
  {
    return ScribbleResMgr.b(paramInt1, paramInt2);
  }
  
  public void StartDownloadRes(int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ScribbleResMgr.a().a(localQQAppInterface, paramInt1, paramInt2, paramView, paramResCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.impl.ScribbleResMgrImpl
 * JD-Core Version:    0.7.0.1
 */