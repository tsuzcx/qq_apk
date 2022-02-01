package com.tencent.mobileqq.filemanager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class MPFileFailedView
  extends RelativeLayout
  implements View.OnClickListener
{
  ImageView a;
  TextView b;
  TextView c;
  TextView d;
  Button e;
  private Activity f;
  private QQAppInterface g;
  private LinearLayout h;
  private MPFileFailedView.MPFileFailedEvent i = null;
  private long j;
  
  public MPFileFailedView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.f = ((Activity)paramContext);
    this.g = paramQQAppInterface;
  }
  
  public View a(ViewGroup paramViewGroup, MPFileFailedView.MPFileFailedEvent paramMPFileFailedEvent, int paramInt1, int paramInt2)
  {
    this.i = paramMPFileFailedEvent;
    this.d.setVisibility(8);
    int k = 2131892157;
    int m = 2131891929;
    int n = 2131891915;
    int i1 = 2130845770;
    if (paramInt1 != 1001)
    {
      if (paramInt1 != 1003) {
        if (paramInt1 != 1010)
        {
          if (paramInt1 != 1101)
          {
            if (paramInt1 != 2107)
            {
              if (paramInt1 == 2109) {
                break label304;
              }
              if (paramInt1 == 2110) {}
            }
            else
            {
              switch (paramInt1)
              {
              default: 
                if (paramInt2 == 1) {
                  paramInt2 = 2131891892;
                } else {
                  if (paramInt2 != 0) {
                    break;
                  }
                }
              case 2004: 
                for (;;)
                {
                  paramInt2 = 2131891893;
                  do
                  {
                    paramInt2 = 2131891915;
                    n = paramInt2;
                    paramInt2 = 0;
                    k = 2131891891;
                    m = 2131891930;
                    break label343;
                    if (paramInt2 == 1) {
                      break;
                    }
                  } while (paramInt2 != 0);
                }
              case 2003: 
                k = 2131891914;
                paramInt2 = 0;
                break;
              case 2002: 
                k = 2131891931;
                paramInt2 = 8;
                m = 2131891930;
                i1 = 2130845773;
                break;
              }
              paramInt2 = 8;
              k = 2131891913;
              n = 2131891913;
            }
            for (;;)
            {
              i1 = 2130845775;
              break;
              if (paramInt2 == 1)
              {
                paramInt2 = 0;
                k = 2131891914;
              }
              else if (paramInt2 == 0)
              {
                paramInt2 = 8;
                k = 2131891913;
                n = 2131891903;
              }
              else
              {
                paramInt2 = 8;
                k = 2131891895;
              }
            }
          }
          else
          {
            k = 2131888348;
            paramInt2 = 8;
            m = 2131891930;
            i1 = 0;
            break label343;
          }
        }
        else
        {
          paramInt2 = 8;
          m = 2131891930;
          n = 2131892157;
          break label343;
        }
      }
      label304:
      paramInt2 = 8;
      k = 2131891912;
      m = 2131891930;
      n = 2131891912;
      i1 = 2130845774;
    }
    else
    {
      paramInt2 = 8;
      k = 2131891926;
      m = 2131891930;
      n = 2131891926;
    }
    label343:
    this.h.setVisibility(0);
    this.a.setImageResource(i1);
    this.b.setText(k);
    this.b.setVisibility(0);
    this.c.setText(n);
    this.c.setVisibility(paramInt2);
    this.d.setVisibility(8);
    this.e.setText(m);
    if (7 == paramInt1) {
      this.e.setVisibility(8);
    }
    return this.h;
  }
  
  public void a()
  {
    this.i = null;
  }
  
  public void b()
  {
    this.h = ((LinearLayout)((LayoutInflater)this.f.getSystemService("layout_inflater")).inflate(2131627104, null).findViewById(2131427340));
    this.a = ((ImageView)this.h.findViewById(2131435389));
    this.b = ((TextView)this.h.findViewById(2131447090));
    this.c = ((TextView)this.h.findViewById(2131447091));
    this.d = ((TextView)this.h.findViewById(2131447099));
    this.e = ((Button)this.h.findViewById(2131430117));
    this.e.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    this.h.setVisibility(8);
    Object localObject = (DataLineHandler)this.g.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    Button localButton = this.e;
    if (paramView == localButton) {
      if (localButton.getText().toString().equalsIgnoreCase(getResources().getString(2131891929))) {
        this.j = ((DataLineHandler)localObject).a().a(0);
      } else if (((DataLineHandler)localObject).a().b()) {
        this.j = ((DataLineHandler)localObject).a().a(1);
      } else {
        this.j = ((DataLineHandler)localObject).a().a(2);
      }
    }
    localObject = this.i;
    if (localObject != null) {
      ((MPFileFailedView.MPFileFailedEvent)localObject).a(this.j);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.MPFileFailedView
 * JD-Core Version:    0.7.0.1
 */