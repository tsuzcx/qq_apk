package com.tencent.mobileqq.magicface.view;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import awyb;
import awzk;
import awzn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class MagicfaceViewController$7$2
  implements Runnable
{
  public MagicfaceViewController$7$2(awzn paramawzn, awyb paramawyb) {}
  
  public void run()
  {
    
    if (this.jdField_a_of_type_Awzn.jdField_a_of_type_Int == 1)
    {
      ((View)this.jdField_a_of_type_Awzn.jdField_a_of_type_Awzk.b).setBackgroundColor(0);
      this.jdField_a_of_type_Awzn.jdField_a_of_type_Awzk.g();
    }
    if ((this.jdField_a_of_type_Awyb != null) && ("gravity".equalsIgnoreCase(this.jdField_a_of_type_Awyb.c)) && (PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(BaseApplicationImpl.getContext().getString(2131694432), false))) {
      this.jdField_a_of_type_Awzn.jdField_a_of_type_Awzk.a.aM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2
 * JD-Core Version:    0.7.0.1
 */