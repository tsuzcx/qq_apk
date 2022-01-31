package com.tencent.mobileqq.magicface.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import argn;
import arhw;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class MagicfaceViewController$7$2
  implements Runnable
{
  public MagicfaceViewController$7$2(arhz paramarhz, argn paramargn) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Arhz.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Arhz.jdField_a_of_type_Arhw.b).setBackgroundColor(0);
      this.jdField_a_of_type_Arhz.jdField_a_of_type_Arhw.g();
    }
    if ((this.jdField_a_of_type_Argn != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_Argn.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131629602), false))) {
      this.jdField_a_of_type_Arhz.jdField_a_of_type_Arhw.a.aL();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
 * JD-Core Version:    0.7.0.1
 */