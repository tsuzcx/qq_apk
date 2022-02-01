package com.tencent.mobileqq.gamecenter.view;

import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import java.util.List;

abstract interface GameSessionView$SessionStyle
  extends View.OnClickListener
{
  public abstract void a();
  
  public abstract void a(ViewGroup paramViewGroup);
  
  public abstract void a(List<GameCenterSessionInfo> paramList, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.SessionStyle
 * JD-Core Version:    0.7.0.1
 */