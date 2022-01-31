package com.tencent.mobileqq.gamecenter.view;

import aepi;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import asmw;
import bkjb;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import java.util.ArrayList;
import java.util.List;

class GameSessionView$3
  implements Runnable
{
  GameSessionView$3(GameSessionView paramGameSessionView, List paramList) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.size() == 0))
    {
      GameSessionView.a(this.this$0, new ArrayList());
      this.this$0.setVisibility(8);
      this.this$0.requestLayout();
      return;
    }
    GameSessionView.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.d(GameSessionView.a, 0, "[setData] dataList size:" + this.a.size());
    }
    Object localObject;
    int i;
    if (GameSessionView.a(this.this$0).size() == 1)
    {
      GameSessionView.a(this.this$0).setVisibility(0);
      localObject = (LinearLayout.LayoutParams)GameSessionView.a(this.this$0).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(68.0F, this.this$0.getResources());
      ((LinearLayout.LayoutParams)localObject).rightMargin = aepi.a(68.0F, this.this$0.getResources());
      this.this$0.a(GameSessionView.a(this.this$0), (GameCenterSessionInfo)GameSessionView.a(this.this$0).get(0));
      GameSessionView.b(this.this$0).setVisibility(8);
      GameSessionView.c(this.this$0).setVisibility(8);
      this.this$0.setVisibility(0);
      this.this$0.requestLayout();
      i = GameSessionView.a(this.this$0).size();
      if (GameSessionView.a(this.this$0).size() <= 2) {
        break label862;
      }
      i = 3;
    }
    label862:
    for (;;)
    {
      localObject = "";
      if (GameSessionView.a(this.this$0).get(0) != null) {
        localObject = ((GameCenterSessionInfo)GameSessionView.a(this.this$0).get(0)).d();
      }
      bkjb.a().a((String)localObject, "1", "145", "920", "92001", "206341", "0", "0", "8", "" + i);
      return;
      if (GameSessionView.a(this.this$0).size() == 2)
      {
        GameSessionView.a(this.this$0).setVisibility(0);
        localObject = (LinearLayout.LayoutParams)GameSessionView.a(this.this$0).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(4.0F, this.this$0.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = aepi.a(0.0F, this.this$0.getResources());
        localObject = (LinearLayout.LayoutParams)GameSessionView.b(this.this$0).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(0.0F, this.this$0.getResources());
        ((LinearLayout.LayoutParams)localObject).rightMargin = aepi.a(4.0F, this.this$0.getResources());
        this.this$0.a(GameSessionView.a(this.this$0), (GameCenterSessionInfo)GameSessionView.a(this.this$0).get(0));
        GameSessionView.b(this.this$0).setVisibility(0);
        this.this$0.a(GameSessionView.b(this.this$0), (GameCenterSessionInfo)GameSessionView.a(this.this$0).get(1));
        GameSessionView.c(this.this$0).setVisibility(8);
        break;
      }
      GameSessionView.a(this.this$0).setVisibility(0);
      localObject = (LinearLayout.LayoutParams)GameSessionView.a(this.this$0).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(4.0F, this.this$0.getResources());
      ((LinearLayout.LayoutParams)localObject).rightMargin = aepi.a(0.0F, this.this$0.getResources());
      localObject = (LinearLayout.LayoutParams)GameSessionView.b(this.this$0).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = aepi.a(0.0F, this.this$0.getResources());
      ((LinearLayout.LayoutParams)localObject).rightMargin = aepi.a(0.0F, this.this$0.getResources());
      this.this$0.a(GameSessionView.a(this.this$0), (GameCenterSessionInfo)GameSessionView.a(this.this$0).get(0));
      GameSessionView.b(this.this$0).setVisibility(0);
      this.this$0.a(GameSessionView.b(this.this$0), (GameCenterSessionInfo)GameSessionView.a(this.this$0).get(1));
      GameSessionView.c(this.this$0).setVisibility(0);
      i = 2;
      int j = 0;
      while (i < GameSessionView.a(this.this$0).size())
      {
        j += ((GameCenterSessionInfo)GameSessionView.a(this.this$0).get(i)).c();
        i += 1;
      }
      if (j > 0)
      {
        GameSessionView.a(this.this$0).setVisibility(8);
        GameSessionView.a(this.this$0).setVisibility(0);
        GameSessionView.a(this.this$0).setText(asmw.a(j));
        break;
      }
      GameSessionView.a(this.this$0).setVisibility(0);
      GameSessionView.a(this.this$0).setVisibility(8);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView.3
 * JD-Core Version:    0.7.0.1
 */