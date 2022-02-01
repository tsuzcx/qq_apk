package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

public abstract interface ContentProviderControlSurface
{
  public abstract void attachToContentProvider(@NonNull ContentProvider paramContentProvider, @NonNull Lifecycle paramLifecycle);
  
  public abstract void detachFromContentProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface
 * JD-Core Version:    0.7.0.1
 */