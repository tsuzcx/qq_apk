package com.tencent.mobileqq.guild.chatpie.helper;

import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.widget.XEditTextEx;

class GuildInputBarHelper$3
  implements ActionMode.Callback
{
  GuildInputBarHelper$3(GuildInputBarHelper paramGuildInputBarHelper) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1)
    {
      this.a.f.getText().insert(this.a.f.getSelectionStart(), "\n");
      paramActionMode.finish();
      return true;
    }
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (!SimpleUIUtil.e()) {
      paramMenu.add(0, 1, 196608, HardCodeUtil.a(2131902951));
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper.3
 * JD-Core Version:    0.7.0.1
 */