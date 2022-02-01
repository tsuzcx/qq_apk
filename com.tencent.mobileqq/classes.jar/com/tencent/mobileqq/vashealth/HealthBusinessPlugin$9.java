package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class HealthBusinessPlugin$9
  implements View.OnClickListener
{
  HealthBusinessPlugin$9(HealthBusinessPlugin paramHealthBusinessPlugin, String paramString, HealthBusinessPlugin.SportVideoLayoutHolder paramSportVideoLayoutHolder) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.e.get(this.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SeekBar)((FrameLayout)localObject3).findViewById(2131377688);
    Object localObject2 = (TextView)((FrameLayout)localObject3).findViewById(2131374814);
    TextView localTextView = (TextView)((FrameLayout)localObject3).findViewById(2131374813);
    ImageView localImageView1 = (ImageView)((FrameLayout)localObject3).findViewById(2131374812);
    ImageView localImageView2 = (ImageView)((FrameLayout)localObject3).findViewById(2131374811);
    localObject3 = (TextView)((FrameLayout)localObject3).findViewById(2131374810);
    HealthBusinessPlugin.9.1 local1 = new HealthBusinessPlugin.9.1(this, (SeekBar)localObject1, (TextView)localObject2, localTextView, localImageView1, localImageView2, (TextView)localObject3);
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_Boolean) {
      if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
      {
        i = 2130849014;
        localImageView1.setImageResource(i);
        localImageView1.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_Boolean = true;
        ((SeekBar)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        localTextView.setVisibility(0);
        localImageView2.setVisibility(4);
        ((TextView)localObject3).setVisibility(4);
        if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
        {
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_AndroidOsHandler.postDelayed(local1, 3000L);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2130849563;
      break;
      if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString)).isPlaying())
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString)).pause();
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_Boolean = true;
        localImageView1.setImageResource(2130849563);
        localImageView1.setVisibility(0);
        if (QLog.isColorLevel()) {
          QLog.d("HealthBusinessPlugin", 2, "play onclick in video ");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_b_of_type_AndroidOsHandler.postDelayed(local1, 3000L);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.get(localObject2)).pause();
        }
        ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.jdField_d_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString)).start();
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$SportVideoLayoutHolder.a.setImageResource(2130849014);
        this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin$SportVideoLayoutHolder.a.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.9
 * JD-Core Version:    0.7.0.1
 */