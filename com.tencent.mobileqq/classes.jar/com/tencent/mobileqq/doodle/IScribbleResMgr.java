package com.tencent.mobileqq.doodle;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.scribble.ResCallback;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IScribbleResMgr
  extends QRouteApi
{
  public abstract ArrayList<Integer> GetGifVisibleIdList();
  
  public abstract ArrayList<Integer> GetPaintVisibleIdList();
  
  public abstract String GetResIconPath(int paramInt1, int paramInt2);
  
  public abstract String GetResPath(int paramInt1, int paramInt2);
  
  public abstract void StartDownloadRes(int paramInt1, int paramInt2, View paramView, ResCallback paramResCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doodle.IScribbleResMgr
 * JD-Core Version:    0.7.0.1
 */