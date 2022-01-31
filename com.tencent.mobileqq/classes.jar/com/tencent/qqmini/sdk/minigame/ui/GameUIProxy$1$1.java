package com.tencent.qqmini.sdk.minigame.ui;

import android.os.Handler;
import bdit;
import bdlq;
import bdqw;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class GameUIProxy$1$1
  implements Runnable
{
  public GameUIProxy$1$1(bdqw parambdqw, int paramInt, bdlq parambdlq, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Bdlq != null))
    {
      GameUIProxy.access$000(this.jdField_a_of_type_Bdqw.a, this.jdField_a_of_type_Bdlq);
      return;
    }
    bdit.a(MiniAppEnv.g().getContext(), "小游戏加载失败 retCode=" + this.jdField_a_of_type_Int + " " + this.jdField_a_of_type_JavaLangString, 0).a();
    GameUIProxy.access$300(this.jdField_a_of_type_Bdqw.a).postDelayed(new GameUIProxy.1.1.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.GameUIProxy.1.1
 * JD-Core Version:    0.7.0.1
 */