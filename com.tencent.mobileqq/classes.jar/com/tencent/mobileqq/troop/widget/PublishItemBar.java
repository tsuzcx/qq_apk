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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private boolean jdField_b_of_type_Boolean = false;
  private Handler jdField_c_of_type_AndroidOsHandler;
  private boolean jdField_c_of_type_Boolean = false;
  private Handler d;
  
  public PublishItemBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && (this.jdField_a_of_type_AndroidOsHandler != null))
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
                this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
              }
            }
            else
            {
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
              localObject = this.jdField_c_of_type_AndroidOsHandler;
              if (localObject != null) {
                ((Handler)localObject).sendEmptyMessage(4);
              }
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            localObject = this.jdField_b_of_type_AndroidOsHandler;
            if (localObject != null) {
              ((Handler)localObject).sendEmptyMessage(3);
            }
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
          localObject = this.d;
          if (localObject != null) {
            ((Handler)localObject).sendEmptyMessage(2);
          }
        }
      }
      else {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAudioCallback(Handler paramHandler)
  {
    this.d = paramHandler;
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
          ((ImageButton)localView).setImageResource(2130843936);
        } else {
          ((ImageButton)localView).setImageResource(2130843935);
        }
      }
      i += 1;
    }
  }
  
  public void setCallback(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setMusicCallback(Handler paramHandler)
  {
    this.jdField_c_of_type_AndroidOsHandler = paramHandler;
  }
  
  public void setVideoCallback(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemBar
 * JD-Core Version:    0.7.0.1
 */