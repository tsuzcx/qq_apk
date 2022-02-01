package io.flutter.embedding.android;

import android.os.Bundle;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterShellArgs;
import java.lang.reflect.Constructor;

public class FlutterFragment$NewEngineFragmentBuilder
{
  private String appBundlePath = null;
  private String dartEntrypoint = "main";
  private final Class<? extends FlutterFragment> fragmentClass;
  private String initialRoute = "/";
  private RenderMode renderMode = RenderMode.surface;
  private FlutterShellArgs shellArgs = null;
  private boolean shouldAttachEngineToActivity = true;
  private TransparencyMode transparencyMode = TransparencyMode.transparent;
  
  public FlutterFragment$NewEngineFragmentBuilder()
  {
    this.fragmentClass = FlutterFragment.class;
  }
  
  public FlutterFragment$NewEngineFragmentBuilder(@NonNull Class<? extends FlutterFragment> paramClass)
  {
    this.fragmentClass = paramClass;
  }
  
  @NonNull
  public NewEngineFragmentBuilder appBundlePath(@NonNull String paramString)
  {
    this.appBundlePath = paramString;
    return this;
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
    localBundle.putString("initial_route", this.initialRoute);
    localBundle.putString("app_bundle_path", this.appBundlePath);
    localBundle.putString("dart_entrypoint", this.dartEntrypoint);
    Object localObject = this.shellArgs;
    if (localObject != null) {
      localBundle.putStringArray("initialization_args", ((FlutterShellArgs)localObject).toArray());
    }
    localObject = this.renderMode;
    if (localObject == null) {
      localObject = RenderMode.surface;
    }
    localBundle.putString("flutterview_render_mode", ((RenderMode)localObject).name());
    localObject = this.transparencyMode;
    if (localObject == null) {
      localObject = TransparencyMode.transparent;
    }
    localBundle.putString("flutterview_transparency_mode", ((TransparencyMode)localObject).name());
    localBundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
    localBundle.putBoolean("destroy_engine_with_fragment", true);
    return localBundle;
  }
  
  @NonNull
  public NewEngineFragmentBuilder dartEntrypoint(@NonNull String paramString)
  {
    this.dartEntrypoint = paramString;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder flutterShellArgs(@NonNull FlutterShellArgs paramFlutterShellArgs)
  {
    this.shellArgs = paramFlutterShellArgs;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder initialRoute(@NonNull String paramString)
  {
    this.initialRoute = paramString;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder renderMode(@NonNull RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder shouldAttachEngineToActivity(boolean paramBoolean)
  {
    this.shouldAttachEngineToActivity = paramBoolean;
    return this;
  }
  
  @NonNull
  public NewEngineFragmentBuilder transparencyMode(@NonNull TransparencyMode paramTransparencyMode)
  {
    this.transparencyMode = paramTransparencyMode;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterFragment.NewEngineFragmentBuilder
 * JD-Core Version:    0.7.0.1
 */