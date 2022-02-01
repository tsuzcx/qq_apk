package com.tencent.mobileqq.magicface.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import avli;
import avmr;
import avmu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class MagicfaceViewController$7$2
  implements Runnable
{
  public MagicfaceViewController$7$2(avmu paramavmu, avli paramavli) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Avmu.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.b).setBackgroundColor(0);
      this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.g();
    }
    if ((this.jdField_a_of_type_Avli != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_Avli.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131694546), false))) {
      this.jdField_a_of_type_Avmu.jdField_a_of_type_Avmr.a.turnOnShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
 * JD-Core Version:    0.7.0.1
 */