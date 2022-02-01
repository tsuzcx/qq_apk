package com.tencent.timi.game;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.List;

public abstract interface IViewCreator
{
  @Nullable
  public abstract View a(String paramString, Context paramContext, AttributeSet paramAttributeSet);
  
  public abstract List<String> a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.IViewCreator
 * JD-Core Version:    0.7.0.1
 */