package io.flutter.embedding.engine;

import android.content.ContentProvider;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;

class FlutterEnginePluginRegistry$FlutterEngineContentProviderPluginBinding
  implements ContentProviderPluginBinding
{
  @NonNull
  private final ContentProvider contentProvider;
  
  FlutterEnginePluginRegistry$FlutterEngineContentProviderPluginBinding(@NonNull ContentProvider paramContentProvider)
  {
    this.contentProvider = paramContentProvider;
  }
  
  @NonNull
  public ContentProvider getContentProvider()
  {
    return this.contentProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEnginePluginRegistry.FlutterEngineContentProviderPluginBinding
 * JD-Core Version:    0.7.0.1
 */