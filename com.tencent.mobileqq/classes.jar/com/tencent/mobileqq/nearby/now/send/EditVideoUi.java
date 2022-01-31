package com.tencent.mobileqq.nearby.now.send;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public abstract interface EditVideoUi
{
  @NonNull
  public abstract Context a();
  
  @Nullable
  public abstract FragmentActivity a();
  
  @NonNull
  public abstract View a();
  
  public abstract void a(int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3);
  
  public abstract void a(CharSequence paramCharSequence, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.EditVideoUi
 * JD-Core Version:    0.7.0.1
 */