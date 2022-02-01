package com.tencent.mobileqq.wink.editor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import java.lang.reflect.Constructor;

public class WinkMaterialViewModelFactory
  implements ViewModelProvider.Factory
{
  private final int a;
  private final boolean b;
  
  public WinkMaterialViewModelFactory(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    try
    {
      ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Integer.TYPE, Boolean.TYPE }).newInstance(new Object[] { Integer.valueOf(this.a), Boolean.valueOf(this.b) });
      return localViewModel;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot create an instance of ");
      localStringBuilder.append(paramClass);
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkMaterialViewModelFactory
 * JD-Core Version:    0.7.0.1
 */