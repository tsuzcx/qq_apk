package com.tencent.mobileqq.magicface.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import attr;
import atva;
import atvd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class MagicfaceViewController$7$2
  implements Runnable
{
  public MagicfaceViewController$7$2(atvd paramatvd, attr paramattr) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Atvd.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Atvd.jdField_a_of_type_Atva.b).setBackgroundColor(0);
      this.jdField_a_of_type_Atvd.jdField_a_of_type_Atva.g();
    }
    if ((this.jdField_a_of_type_Attr != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_Attr.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131695442), false))) {
      this.jdField_a_of_type_Atvd.jdField_a_of_type_Atva.a.aP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
 * JD-Core Version:    0.7.0.1
 */