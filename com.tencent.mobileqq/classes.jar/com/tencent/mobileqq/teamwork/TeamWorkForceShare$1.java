package com.tencent.mobileqq.teamwork;

import ajyc;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import bbct;
import bbjc;
import bcpq;
import bcpw;
import com.tencent.qphone.base.util.QLog;

class TeamWorkForceShare$1
  implements Runnable
{
  TeamWorkForceShare$1(TeamWorkForceShare paramTeamWorkForceShare, Bitmap paramBitmap) {}
  
  public void run()
  {
    TeamWorkForceShare.a(this.this$0).dismiss();
    if ((this.a == null) || (this.a.isRecycled()))
    {
      QLog.d(TeamWorkForceShare.a(), 1, "decode image failed, url = " + TeamWorkForceShare.a(this.this$0));
      bcpw.a(TeamWorkForceShare.a(this.this$0), ajyc.a(2131714795), 0).a();
      return;
    }
    if (TeamWorkForceShare.a(this.this$0) == null)
    {
      TeamWorkForceShare.a(this.this$0, new bbjc(TeamWorkForceShare.a(this.this$0)));
      TeamWorkForceShare.a(this.this$0).a(this.this$0.a());
      TeamWorkForceShare.a(this.this$0).a(this.this$0);
      TeamWorkForceShare.a(this.this$0).a(this.this$0);
    }
    View localView = TeamWorkForceShare.a(this.this$0).getLayoutInflater().inflate(2131562502, null);
    Object localObject = (ImageView)localView.findViewById(2131362014);
    ((ImageView)localObject).setImageBitmap(this.a);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
    localLayoutParams.height = ((int)(524L * bbct.j() / 1334L));
    localLayoutParams.width = (this.a.getWidth() * localLayoutParams.height / this.a.getHeight());
    ((ImageView)localObject).setLayoutParams(localLayoutParams);
    localObject = new RelativeLayout.LayoutParams(-1, -2);
    TeamWorkForceShare.a(this.this$0).a(localView, (RelativeLayout.LayoutParams)localObject);
    TeamWorkForceShare.a(this.this$0).f();
    TeamWorkForceShare.a(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkForceShare.1
 * JD-Core Version:    0.7.0.1
 */