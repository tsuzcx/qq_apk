package io.flutter.embedding.engine.plugins.contentprovider;

import android.support.annotation.NonNull;

public abstract interface ContentProviderAware
{
  public abstract void onAttachedToContentProvider(@NonNull ContentProviderPluginBinding paramContentProviderPluginBinding);
  
  public abstract void onDetachedFromContentProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware
 * JD-Core Version:    0.7.0.1
 */