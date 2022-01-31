package io.flutter.embedding.android;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import io.flutter.embedding.engine.FlutterEngine;

@VisibleForTesting
public abstract interface FlutterView$FlutterEngineAttachmentListener
{
  public abstract void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine paramFlutterEngine);
  
  public abstract void onFlutterEngineDetachedFromFlutterView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener
 * JD-Core Version:    0.7.0.1
 */