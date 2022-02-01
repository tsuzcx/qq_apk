package com.tencent.timi.game.initer.api;

import android.view.LayoutInflater.Factory2;
import com.tencent.timi.game.router.IService;

public abstract interface IniterService
  extends IService
{
  public abstract LayoutInflater.Factory2 a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(InitCallback paramInitCallback);
  
  public abstract void a(OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener);
  
  public abstract void a(String paramString);
  
  public abstract void b();
  
  public abstract void b(OnPAGLibraryLoadedListener paramOnPAGLibraryLoadedListener);
  
  public abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.api.IniterService
 * JD-Core Version:    0.7.0.1
 */