package com.tencent.mobileqq.freshnews;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

class BlockableEditTextView$1
  implements ActionMode.Callback
{
  BlockableEditTextView$1(BlockableEditTextView paramBlockableEditTextView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (BlockableEditTextView.a(this.a) == 0) {
      return true;
    }
    return BlockableEditTextView.b(this.a);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.freshnews.BlockableEditTextView.1
 * JD-Core Version:    0.7.0.1
 */