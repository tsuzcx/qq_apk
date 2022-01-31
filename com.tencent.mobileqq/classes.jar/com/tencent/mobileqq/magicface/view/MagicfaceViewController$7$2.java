package com.tencent.mobileqq.magicface.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import atya;
import atzj;
import atzm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class MagicfaceViewController$7$2
  implements Runnable
{
  public MagicfaceViewController$7$2(atzm paramatzm, atya paramatya) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Atzm.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Atzm.jdField_a_of_type_Atzj.b).setBackgroundColor(0);
      this.jdField_a_of_type_Atzm.jdField_a_of_type_Atzj.g();
    }
    if ((this.jdField_a_of_type_Atya != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_Atya.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131695444), false))) {
      this.jdField_a_of_type_Atzm.jdField_a_of_type_Atzj.a.aP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
 * JD-Core Version:    0.7.0.1
 */