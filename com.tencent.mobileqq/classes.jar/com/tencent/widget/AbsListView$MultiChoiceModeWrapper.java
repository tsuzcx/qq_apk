package com.tencent.widget;

import android.annotation.SuppressLint;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

@SuppressLint({"NewApi"})
class AbsListView$MultiChoiceModeWrapper
  implements AbsListView.MultiChoiceModeListener
{
  private AbsListView.MultiChoiceModeListener mWrapped;
  
  AbsListView$MultiChoiceModeWrapper(AbsListView paramAbsListView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (this.mWrapped.onCreateActionMode(paramActionMode, paramMenu))
    {
      this.this$0.setLongClickable(false);
      return true;
    }
    return false;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrapped.onDestroyActionMode(paramActionMode);
    paramActionMode = this.this$0;
    paramActionMode.mChoiceActionMode = null;
    paramActionMode.clearChoices();
    paramActionMode = this.this$0;
    paramActionMode.mDataChanged = true;
    paramActionMode.rememberSyncState();
    this.this$0.requestLayout();
    this.this$0.setLongClickable(true);
  }
  
  public void onItemCheckedStateChanged(ActionMode paramActionMode, int paramInt, long paramLong, boolean paramBoolean)
  {
    this.mWrapped.onItemCheckedStateChanged(paramActionMode, paramInt, paramLong, paramBoolean);
    if (this.this$0.getCheckedItemCount() == 0) {
      paramActionMode.finish();
    }
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
  }
  
  public void setWrapped(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener)
  {
    this.mWrapped = paramMultiChoiceModeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AbsListView.MultiChoiceModeWrapper
 * JD-Core Version:    0.7.0.1
 */