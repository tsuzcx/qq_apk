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
    if (paramView.getId() != 2131438729) {
      return false;
    }
    if ((GameWnsUtils.enablePersistentDebugVersion()) && (MainPageFragment.access$000(this.this$0) != null))
    {
      paramView = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("persistent_debug_version_");
      localStringBuilder.append(MainPageFragment.getUin());
      paramView = paramView.getSharedPreferences(localStringBuilder.toString(), 4);
      if (paramView.getBoolean("persistent", false))
      {
        paramView.edit().remove("persistent").apply();
        QLog.e("MainPageFragment", 1, "close persistent debug version");
        Toast.makeText(this.this$0.getBaseActivity(), this.this$0.getResources().getString(2131891753), 1).show();
        return false;
      }
      paramView.edit().putBoolean("persistent", true).apply();
      QLog.e("MainPageFragment", 1, "open persistent debug version");
      Toast.makeText(this.this$0.getBaseActivity(), this.this$0.getResources().getString(2131891756), 1).show();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.mainpage.MainPageFragment.7
 * JD-Core Version:    0.7.0.1
 */