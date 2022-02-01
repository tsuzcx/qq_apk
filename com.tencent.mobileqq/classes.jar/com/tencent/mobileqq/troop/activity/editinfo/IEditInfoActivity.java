package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public abstract interface IEditInfoActivity
{
  public abstract Context getContext();
  
  public abstract String getText();
  
  public abstract TextView getTipsView();
  
  public abstract void hideInputMethod();
  
  public abstract void loadingProgress(boolean paramBoolean);
  
  public abstract void onFinish();
  
  public abstract void onFinishForResult(int paramInt, Intent paramIntent);
  
  public abstract void showInputMethod();
  
  public abstract void updateEditTextAndNum(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity
 * JD-Core Version:    0.7.0.1
 */