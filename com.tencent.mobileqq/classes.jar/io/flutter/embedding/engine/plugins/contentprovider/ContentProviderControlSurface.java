package io.flutter.embedding.engine.plugins.contentprovider;

import android.arch.lifecycle.Lifecycle;
import android.content.ContentProvider;
import android.support.annotation.NonNull;

public abstract interface ContentProviderControlSurface
{
  public abstract void attachToContentProvider(@NonNull ContentProvider paramContentProvider, @NonNull Lifecycle paramLifecycle);
  
  public abstract void detachFromContentProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface
 * JD-Core Version:    0.7.0.1
 */