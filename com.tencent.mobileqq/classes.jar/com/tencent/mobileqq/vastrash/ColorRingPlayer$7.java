package com.tencent.mobileqq.vastrash;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;

class ColorRingPlayer$7
  extends OnRemoteRespObserver
{
  ColorRingPlayer$7(ColorRingPlayer paramColorRingPlayer) {}
  
  public void onBindedToClient() {}
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle arg1)
  {
    if (???.getInt("srcType") != 5) {
      return;
    }
    Object localObject1 = ???.getString("status");
    long l = ???.getLong("id");
    int i = ???.getInt("progress");
    boolean bool = ???.getBoolean("result");
    int j = ???.getInt("resourceType");
    String str = ???.getString("colorType");
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("onPushMsg,");
      ???.append(l);
      ???.append(",");
      ???.append(j);
      ???.append(",");
      ???.append((String)localObject1);
      ???.append(",");
      ???.append(i);
      ???.append(",");
      ???.append(bool);
      QLog.d("ColorRingPlayer", 2, ???.toString());
    }
    synchronized (this.a.a)
    {
      if (this.a.a.b != l)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("curId=");
          ((StringBuilder)localObject1).append(this.a.a.b);
          ((StringBuilder)localObject1).append(", pushId=");
          ((StringBuilder)localObject1).append(l);
          QLog.d("ColorRingPlayer", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if ("onStart".equals(localObject1)) {
        return;
      }
      if ("onDone".equals(localObject1))
      {
        if (bool)
        {
          if (j == 3)
          {
            if ("colorring".equals(str)) {
              this.a.l.setText(this.a.e.getResources().getString(2131916284));
            } else if ("comering".equals(str)) {
              this.a.l.setText(this.a.e.getResources().getString(2131916285));
            }
            this.a.m.setImageDrawable(this.a.e.getResources().getDrawable(2130848969));
            this.a.m.setVisibility(0);
            this.a.k.setVisibility(8);
            synchronized (this.a.a)
            {
              this.a.a.a = 3;
              if (!this.a.g) {
                break label706;
              }
              this.a.a(l, 0);
              return;
            }
          }
          if (j == 2)
          {
            this.a.a(ColorRingManager.a(l));
            return;
          }
          if ((j == 1) && (ColorRingManager.b(l) != null)) {
            this.a.j.setImageBitmap(ColorRingManager.b(l));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ???.append("onDone, failure,");
            ???.append(l);
            ???.append(",");
            ???.append(j);
            QLog.e("ColorRingPlayer", 2, ???.toString());
          }
          if (j == 3)
          {
            this.a.l.setText(this.a.e.getResources().getString(2131887864));
            this.a.m.setImageDrawable(this.a.e.getResources().getDrawable(2130848967));
            this.a.m.setVisibility(0);
            this.a.k.setVisibility(8);
            synchronized (this.a.a)
            {
              this.a.a.a = 0;
              return;
            }
          }
        }
      }
      else if (("onProgress".equals(localObject3)) && (j == 3) && (this.a.t != null))
      {
        this.a.t.setLevel(i * 100);
        this.a.t.invalidateSelf();
      }
      label706:
      return;
    }
  }
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.ColorRingPlayer.7
 * JD-Core Version:    0.7.0.1
 */