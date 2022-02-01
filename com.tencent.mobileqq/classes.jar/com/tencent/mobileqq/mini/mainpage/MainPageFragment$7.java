package com.tencent.mobileqq.mini.mainpage;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;

class MainPageFragment$7
  implements View.OnLongClickListener
{
  MainPageFragment$7(MainPageFragment paramMainPageFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return false;
    } while ((!GameWnsUtils.enablePersistentDebugVersion()) || (MainPageFragment.access$000(this.this$0) == null));
    paramView = BaseApplicationImpl.getApplication().getSharedPreferences("persistent_debug_version_" + MainPageFragment.getUin(), 4);
    if (paramView.getBoolean("persistent", false))
    {
      paramView.edit().remove("persistent").apply();
      QLog.e("MainPageFragment", 1, "close persistent debug version");
      Toast.makeText(this.this$0.getActivity(), this.this$0.getResources().getString(2131693783), 1).show();
      return false;
    }
    paramView.edit().putBoolean("persistent", true).apply();
    QLog.e("MainPageFragment", 1, "open persistent debug version");
    Toast.makeText(this.this$0.getActivity(), this.this$0.getResources().getString(2131693786), 1).show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.7
 * JD-Core Version:    0.7.0.1
 */