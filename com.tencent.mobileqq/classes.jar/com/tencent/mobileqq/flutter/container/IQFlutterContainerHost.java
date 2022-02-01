package com.tencent.mobileqq.flutter.container;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.FlutterShellArgs;

public abstract interface IQFlutterContainerHost
{
  public abstract View a();
  
  public abstract Activity b();
  
  public abstract FlutterShellArgs c();
  
  public abstract Bundle d();
  
  public abstract boolean e();
  
  public abstract Context getContext();
  
  public abstract Lifecycle getLifecycle();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.container.IQFlutterContainerHost
 * JD-Core Version:    0.7.0.1
 */