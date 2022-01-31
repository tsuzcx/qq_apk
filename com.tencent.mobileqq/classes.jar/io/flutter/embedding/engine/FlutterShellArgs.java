package io.flutter.embedding.engine;

import android.content.Intent;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterShellArgs
{
  public static final String ARG_DISABLE_SERVICE_AUTH_CODES = "--disable-service-auth-codes";
  public static final String ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "--dump-skp-on-shader-compilation";
  public static final String ARG_ENABLE_DART_PROFILING = "--enable-dart-profiling";
  public static final String ARG_ENABLE_SOFTWARE_RENDERING = "--enable-software-rendering";
  public static final String ARG_KEY_DISABLE_SERVICE_AUTH_CODES = "disable-service-auth-codes";
  public static final String ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "dump-skp-on-shader-compilation";
  public static final String ARG_KEY_ENABLE_DART_PROFILING = "enable-dart-profiling";
  public static final String ARG_KEY_ENABLE_SOFTWARE_RENDERING = "enable-software-rendering";
  public static final String ARG_KEY_OBSERVATORY_PORT = "observatory-port";
  public static final String ARG_KEY_SKIA_DETERMINISTIC_RENDERING = "skia-deterministic-rendering";
  public static final String ARG_KEY_START_PAUSED = "start-paused";
  public static final String ARG_KEY_TRACE_SKIA = "trace-skia";
  public static final String ARG_KEY_TRACE_STARTUP = "trace-startup";
  public static final String ARG_KEY_USE_TEST_FONTS = "use-test-fonts";
  public static final String ARG_KEY_VERBOSE_LOGGING = "verbose-logging";
  public static final String ARG_OBSERVATORY_PORT = "--observatory-port=";
  public static final String ARG_SKIA_DETERMINISTIC_RENDERING = "--skia-deterministic-rendering";
  public static final String ARG_START_PAUSED = "--start-paused";
  public static final String ARG_TRACE_SKIA = "--trace-skia";
  public static final String ARG_TRACE_STARTUP = "--trace-startup";
  public static final String ARG_USE_TEST_FONTS = "--use-test-fonts";
  public static final String ARG_VERBOSE_LOGGING = "--verbose-logging";
  @NonNull
  private Set<String> args;
  
  public FlutterShellArgs(@NonNull List<String> paramList)
  {
    this.args = new HashSet(paramList);
  }
  
  public FlutterShellArgs(@NonNull Set<String> paramSet)
  {
    this.args = new HashSet(paramSet);
  }
  
  public FlutterShellArgs(@NonNull String[] paramArrayOfString)
  {
    this.args = new HashSet(Arrays.asList(paramArrayOfString));
  }
  
  @NonNull
  public static FlutterShellArgs fromIntent(@NonNull Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (paramIntent.getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    int i = paramIntent.getIntExtra("observatory-port", 0);
    if (i > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--observatory-port=");
      localStringBuilder.append(Integer.toString(i));
      localArrayList.add(localStringBuilder.toString());
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (paramIntent.getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (paramIntent.getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (paramIntent.getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (paramIntent.getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    return new FlutterShellArgs(localArrayList);
  }
  
  public void add(@NonNull String paramString)
  {
    this.args.add(paramString);
  }
  
  public void remove(@NonNull String paramString)
  {
    this.args.remove(paramString);
  }
  
  @NonNull
  public String[] toArray()
  {
    String[] arrayOfString = new String[this.args.size()];
    return (String[])this.args.toArray(arrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterShellArgs
 * JD-Core Version:    0.7.0.1
 */