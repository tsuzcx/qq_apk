package io.flutter.embedding.android;

import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;

public class FlutterFragment$CachedEngineFragmentBuilder
{
  private boolean destroyEngineWithFragment = false;
  private final String engineId;
  private final Class<? extends FlutterFragment> fragmentClass;
  private FlutterView.RenderMode renderMode = FlutterView.RenderMode.surface;
  private boolean shouldAttachEngineToActivity = true;
  private FlutterView.TransparencyMode transparencyMode = FlutterView.TransparencyMode.transparent;
  
  protected FlutterFragment$CachedEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> paramClass, @NonNull String paramString)
  {
    this.fragmentClass = paramClass;
    this.engineId = paramString;
  }
  
  private FlutterFragment$CachedEngineFragmentBuilder(@NonNull String paramString)
  {
    this(FlutterFragment.class, paramString);
  }
  
  @NonNull
  public <T extends FlutterFragment> T build()
  {
    try
    {
      Object localObject = (FlutterFragment)this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      if (localObject != null)
      {
        ((FlutterFragment)localObject).setArguments(createArgs());
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("The FlutterFragment subclass sent in the constructor (");
      ((StringBuilder)localObject).append(this.fragmentClass.getCanonicalName());
      ((StringBuilder)localObject).append(") does not match the expected return type.");
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not instantiate FlutterFragment subclass (");
      localStringBuilder.append(this.fragmentClass.getName());
      localStringBuilder.append(")");
      throw new RuntimeException(localStringBuilder.toString(), localException);
    }
  }
  
  @NonNull
  protected Bundle createArgs()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cached_engine_id", this.engineId);
    localBundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
    if (this.renderMode != null)
    {
      localObject = this.renderMode;
      localBundle.putString("flutterview_render_mode", ((FlutterView.RenderMode)localObject).name());
      if (this.transparencyMode == null) {
        break label91;
      }
    }
    label91:
    for (Object localObject = this.transparencyMode;; localObject = FlutterView.TransparencyMode.transparent)
    {
      localBundle.putString("flutterview_transparency_mode", ((FlutterView.TransparencyMode)localObject).name());
      localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
      return localBundle;
      localObject = FlutterView.RenderMode.surface;
      break;
    }
  }
  
  @NonNull
  public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean paramBoolean)
  {
    this.destroyEngineWithFragment = paramBoolean;
    return this;
  }
  
  @NonNull
  public CachedEngineFragmentBuilder renderMode(@NonNull FlutterView.RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    return this;
  }
  
  @NonNull
  public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
  {
    this.shouldAttachEngineToActivity = paramBoolean;
    return this;
  }
  
  @NonNull
  public CachedEngineFragmentBuilder transparencyMode(@NonNull FlutterView.TransparencyMode paramTransparencyMode)
  {
    this.transparencyMode = paramTransparencyMode;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment.CachedEngineFragmentBuilder
 * JD-Core Version:    0.7.0.1
 */