package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;

class HealthBusinessPlugin$8
  implements View.OnClickListener
{
  HealthBusinessPlugin$8(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).isOutputMute())
    {
      ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).setOutputMute(false);
      ((ImageView)paramView).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846735));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(this.jdField_a_of_type_JavaLangString)).setOutputMute(true);
      ((ImageView)paramView).setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846734));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.8
 * JD-Core Version:    0.7.0.1
 */