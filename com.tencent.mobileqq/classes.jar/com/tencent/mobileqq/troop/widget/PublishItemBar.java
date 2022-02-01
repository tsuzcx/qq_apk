package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PublishItemBar
  extends LinearLayout
  implements View.OnClickListener
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private Handler d;
  private Handler e;
  private Handler f;
  private Handler g;
  
  public PublishItemBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && (this.d != null))
    {
      int i = ((Integer)localObject).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                this.d.sendEmptyMessage(5);
              }
            }
            else
            {
              this.d.sendEmptyMessage(4);
              localObject = this.f;
              if (localObject != null) {
                ((Handler)localObject).sendEmptyMessage(4);
              }
            }
          }
          else
          {
            this.d.sendEmptyMessage(3);
            localObject = this.e;
            if (localObject != null) {
              ((Handler)localObject).sendEmptyMessage(3);
            }
          }
        }
        else
        {
          this.d.sendEmptyMessage(2);
          localObject = this.g;
          if (localObject != null) {
            ((Handler)localObject).sendEmptyMessage(2);
          }
        }
      }
      else {
        this.d.sendEmptyMessage(1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAudioCallback(Handler paramHandler)
  {
    this.g = paramHandler;
  }
  
  public void setAudioEnable(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ImageButton)) {
        if (paramBoolean) {
          ((ImageButton)localView).setImageResource(2130844891);
        } else {
          ((ImageButton)localView).setImageResource(2130844890);
        }
      }
      i += 1;
    }
  }
  
  public void setCallback(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  public void setMusicCallback(Handler paramHandler)
  {
    this.f = paramHandler;
  }
  
  public void setVideoCallback(Handler paramHandler)
  {
    this.e = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemBar
 * JD-Core Version:    0.7.0.1
 */