package com.tencent.mobileqq.triton.game;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.filesystem.GamePackage.Environment;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.internal.utils.Utils;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.FirstFrameStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/game/GameLauncher;", "", "mTritonEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "(Lcom/tencent/mobileqq/triton/engine/TTEngine;)V", "mEngineInitStatistic", "Lcom/tencent/mobileqq/triton/statistic/EngineInitStatistic;", "mGameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "mGameScriptLoadStatics", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "mLaunchAfterInit", "Ljava/lang/Runnable;", "mLaunchGameEndTime", "", "genConfig", "", "value", "getOptionConfig", "map", "", "injectGameInfo", "", "launchGame", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "callback", "onLaunchBegin", "Lkotlin/Function0;", "loadSubpackage", "name", "onProgress", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "totalBytes", "currentBytes", "onComplete", "Lkotlin/Function1;", "statistics", "notifyGameLaunched", "launchTimesMs", "gameScriptLoadStatics", "", "failure", "", "onFirstRender", "onInitDone", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "loadSoTimeMs", "loadEngineScriptTimeMs", "createEGLContextTimeMs", "initTimeMs", "statics", "engineScriptInitException", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "nativeLibraryLoadStatistics", "Lcom/tencent/mobileqq/triton/statistic/NativeLibraryLoadStatistic;", "onSubpackageLoaded", "performLaunch", "performLoadSubpackage", "result", "Lkotlin/Result;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class GameLauncher
{
  public static final GameLauncher.Companion Companion = new GameLauncher.Companion(null);
  private static final String ENV_VERSION_PREFIX = "\n__wxConfig.envVersion = ";
  private static final String GAME_JSON_PREFIX = "\n__wxConfig.gameJson = ";
  private static final String INIT_JSLIB = "\nif (typeof global.__ttObjdec__.iniJsLib === 'function') {global.__ttObjdec__.iniJsLib()}";
  private static final String INIT_WXCONFIG = "var __wxConfig = __wxConfig || {};";
  @NotNull
  public static final String TAG = "GameLauncher";
  private static final String WINDOW_UNDEFINED = "\nwindow = undefined";
  private volatile EngineInitStatistic mEngineInitStatistic;
  private GameLaunchCallback mGameLaunchCallback;
  private final ArrayList<ScriptLoadStatistic> mGameScriptLoadStatics;
  private Runnable mLaunchAfterInit;
  private long mLaunchGameEndTime;
  private final TTEngine mTritonEngine;
  
  public GameLauncher(@NotNull TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
    this.mGameScriptLoadStatics = new ArrayList();
  }
  
  private final String genConfig(Object paramObject)
  {
    if ((paramObject instanceof Map)) {
      return new JSONObject((Map)paramObject).toString();
    }
    if ((paramObject instanceof String))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(paramObject);
      localStringBuilder.append('"');
      return localStringBuilder.toString();
    }
    return String.valueOf(paramObject);
  }
  
  private final String getOptionConfig(Map<String, ? extends Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    StringBuilder localStringBuilder;
    for (paramMap = "\n//optional properties\n"; localIterator.hasNext(); paramMap = localStringBuilder.toString())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append("__wxConfig.");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(" = ");
      localStringBuilder.append(genConfig(localEntry.getValue()));
      localStringBuilder.append('\n');
    }
    return paramMap;
  }
  
  private final void injectGameInfo()
  {
    ScriptRuntime localScriptRuntime1 = this.mTritonEngine.getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.MAIN);
    ScriptRuntime localScriptRuntime2 = this.mTritonEngine.getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.OPEN_DATA);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("var __wxConfig = __wxConfig || {};");
    ((StringBuilder)localObject).append("\n__wxConfig.envVersion = ");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\'');
    localStringBuilder.append(this.mTritonEngine.getEngineContext().getGamePackage().getEnvironment().getEnvironment());
    localStringBuilder.append('\'');
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    ((StringBuilder)localObject).append("\n__wxConfig.gameJson = ");
    ((StringBuilder)localObject).append(this.mTritonEngine.getEngineContext().getGamePackage().getGameConfig());
    ((StringBuilder)localObject).append(getOptionConfig(this.mTritonEngine.getEngineContext().getGamePackage().getOptionConfig()));
    ((StringBuilder)localObject).append("\nif (typeof global.__ttObjdec__.iniJsLib === 'function') {global.__ttObjdec__.iniJsLib()}");
    ((StringBuilder)localObject).append("\nwindow = undefined");
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    localScriptRuntime1.evaluateJs((String)localObject);
    localScriptRuntime2.evaluateJs((String)localObject);
  }
  
  private final void notifyGameLaunched(long paramLong, List<ScriptLoadStatistic> paramList, Throwable paramThrowable)
  {
    this.mLaunchGameEndTime = SystemClock.uptimeMillis();
    Object localObject = this.mEngineInitStatistic;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    boolean bool;
    if ((((EngineInitStatistic)localObject).getSuccess()) && (paramThrowable == null) && (GameLauncher.Companion.access$isAllSuccess(Companion, paramList))) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramThrowable == null)
    {
      paramThrowable = this.mEngineInitStatistic;
      if (paramThrowable == null) {
        Intrinsics.throwNpe();
      }
      paramThrowable = (Throwable)paramThrowable.getException();
    }
    if (paramThrowable != null)
    {
      ErrorCodes localErrorCodes = ErrorCodes.SCRIPT_LOAD_FAIL;
      if ((paramThrowable instanceof TritonException))
      {
        paramThrowable = (TritonException)paramThrowable;
      }
      else
      {
        localObject = paramThrowable.getMessage();
        if (localObject == null) {
          localObject = "";
        }
        paramThrowable = new TritonException((String)localObject, localErrorCodes, paramThrowable);
      }
    }
    else
    {
      paramThrowable = null;
    }
    localObject = this.mEngineInitStatistic;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramList = new GameLaunchStatistic(bool, paramThrowable, paramLong, paramList, (EngineInitStatistic)localObject);
    paramThrowable = this.mGameLaunchCallback;
    if (paramThrowable == null) {
      Intrinsics.throwNpe();
    }
    paramThrowable.onGameLaunched(null, paramList);
    this.mEngineInitStatistic = ((EngineInitStatistic)null);
    if (!paramList.getSuccess())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append("launchGame failed ");
      paramThrowable.append(paramList);
      Logger.e("GameLauncher", paramThrowable.toString(), (Throwable)paramList.getException());
    }
  }
  
  private final void onSubpackageLoaded(String paramString, Function1<? super ScriptLoadStatistic, Unit> paramFunction1, ScriptLoadStatistic paramScriptLoadStatistic)
  {
    paramFunction1.invoke(paramScriptLoadStatistic);
    paramFunction1 = (SubpackageLoadStatisticsCallback)this.mTritonEngine.getEngineContext().getStatisticsManager().getSubpackageLoadStatisticsCallback().getValue();
    if (paramFunction1 != null) {
      this.mTritonEngine.getEngineContext().getMainThreadExecutor().execute((Runnable)new GameLauncher.onSubpackageLoaded..inlined.let.lambda.1(paramFunction1, this, paramString, paramScriptLoadStatistic));
    }
  }
  
  private final void performLaunch(GameLaunchCallback paramGameLaunchCallback, GameLaunchParam paramGameLaunchParam, Function0<Unit> paramFunction0)
  {
    this.mGameLaunchCallback = paramGameLaunchCallback;
    paramGameLaunchCallback = this.mEngineInitStatistic;
    if (paramGameLaunchCallback == null) {
      Intrinsics.throwNpe();
    }
    if (!paramGameLaunchCallback.getSuccess())
    {
      paramGameLaunchCallback = this.mGameLaunchCallback;
      if (paramGameLaunchCallback == null) {
        Intrinsics.throwNpe();
      }
      paramGameLaunchParam = (List)this.mGameScriptLoadStatics;
      paramFunction0 = this.mEngineInitStatistic;
      if (paramFunction0 == null) {
        Intrinsics.throwNpe();
      }
      paramGameLaunchCallback.onGameLaunched(null, new GameLaunchStatistic(false, null, 0L, paramGameLaunchParam, paramFunction0));
      return;
    }
    this.mTritonEngine.setInspectorAgent(paramGameLaunchParam.getInspectorAgent());
    this.mTritonEngine.initGameInfo();
    this.mTritonEngine.getEngineContext().getScriptSystem().runOnScriptThread((Runnable)new GameLauncher.performLaunch.1(this, paramFunction0));
  }
  
  private final void performLoadSubpackage(String paramString, Object paramObject, Function1<? super ScriptLoadStatistic, Unit> paramFunction1)
  {
    for (;;)
    {
      try
      {
        ResultKt.throwOnFailure(paramObject);
        paramObject = Utils.decorateSubPackage((ScriptPackage)paramObject, this.mTritonEngine.getEngineContext().getEnableCodeCache(), paramString);
        localObject1 = (ScriptFile)MapsKt.getValue(ScriptLoader.INSTANCE.getSubPackageScripts(paramObject), ScriptContextType.MAIN);
        if ((localObject1 != null) && (((ScriptFile)localObject1).getValid()))
        {
          paramObject = this.mTritonEngine.getEngineContext().getScriptSystem().getScriptEngine(ScriptContextType.MAIN);
          paramObject.runOnScriptThread((Runnable)new GameLauncher.performLoadSubpackage.1(this, paramObject, (ScriptFile)localObject1, paramString, paramFunction1));
          return;
        }
        localObject2 = ScriptLoadResult.SUCCESS_WITHOUT_CACHE;
        localObject3 = ScriptContextType.MAIN;
        paramObject = new StringBuilder();
        paramObject.append("subPackage ");
        paramObject.append(paramString);
        localObject4 = paramObject.toString();
        paramObject = localObject1;
        if (!(localObject1 instanceof ScriptFile.Path)) {
          paramObject = null;
        }
        paramObject = (ScriptFile.Path)paramObject;
        if (paramObject != null)
        {
          paramObject = paramObject.getPath();
          if (paramObject != null)
          {
            paramObject = paramObject.getAbsolutePath();
            if (paramObject != null)
            {
              onSubpackageLoaded(paramString, paramFunction1, new ScriptLoadStatistic((ScriptLoadResult)localObject2, (ScriptContextType)localObject3, (String)localObject4, paramObject, 0L, 0L, 0L, 0L, "no script file"));
              return;
            }
          }
        }
      }
      catch (Throwable paramObject)
      {
        Object localObject1 = ScriptLoadResult.FAIL_READ_SCRIPT;
        Object localObject2 = ScriptContextType.MAIN;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("subPackage ");
        ((StringBuilder)localObject3).append(paramString);
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramObject.getClass().getName());
        ((StringBuilder)localObject4).append(' ');
        ((StringBuilder)localObject4).append(paramObject.getMessage());
        ((StringBuilder)localObject4).append(' ');
        ((StringBuilder)localObject4).append(Log.getStackTraceString(paramObject));
        onSubpackageLoaded(paramString, paramFunction1, new ScriptLoadStatistic((ScriptLoadResult)localObject1, (ScriptContextType)localObject2, (String)localObject3, "game.js", 0L, 0L, 0L, 0L, ((StringBuilder)localObject4).toString()));
        return;
      }
      paramObject = "";
    }
  }
  
  public final void launchGame(@NotNull GameLaunchParam paramGameLaunchParam, @NotNull GameLaunchCallback paramGameLaunchCallback, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchParam, "param");
    Intrinsics.checkParameterIsNotNull(paramGameLaunchCallback, "callback");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onLaunchBegin");
    this.mTritonEngine.getRenderContext().attachGameView(paramGameLaunchParam.getGameView());
    try
    {
      paramGameLaunchParam = (Runnable)new GameLauncher.launchGame..inlined.synchronized.lambda.1(this, paramGameLaunchCallback, paramGameLaunchParam, paramFunction0);
      if (this.mEngineInitStatistic == null) {
        this.mLaunchAfterInit = paramGameLaunchParam;
      } else {
        paramGameLaunchParam.run();
      }
      paramGameLaunchParam = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public final void loadSubpackage(@NotNull String paramString, @NotNull Function2<? super Long, ? super Long, Unit> paramFunction2, @NotNull Function1<? super ScriptLoadStatistic, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onProgress");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onComplete");
    this.mTritonEngine.getEngineContext().getWorkerExecutor().execute((Runnable)new GameLauncher.loadSubpackage.1(this, paramString, paramFunction2, paramFunction1));
  }
  
  public final void onFirstRender()
  {
    GameLaunchCallback localGameLaunchCallback = this.mGameLaunchCallback;
    if (localGameLaunchCallback == null) {
      Intrinsics.throwNpe();
    }
    localGameLaunchCallback.onFirstFrame(new FirstFrameStatistic(SystemClock.uptimeMillis() - this.mLaunchGameEndTime, this.mTritonEngine.getCurrentDrawCount()));
  }
  
  public final void onInitDone(@NotNull ErrorCodes paramErrorCodes, long paramLong1, long paramLong2, long paramLong3, long paramLong4, @NotNull ArrayList<ScriptLoadStatistic> paramArrayList, @Nullable TritonException paramTritonException, @NotNull ArrayList<NativeLibraryLoadStatistic> paramArrayList1)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramErrorCodes, "error");
      Intrinsics.checkParameterIsNotNull(paramArrayList, "statics");
      Intrinsics.checkParameterIsNotNull(paramArrayList1, "nativeLibraryLoadStatistics");
      bool = GameLauncher.Companion.access$isAllSuccess(Companion, (List)paramArrayList);
      if ((paramTritonException != null) || (bool)) {
        break label282;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init engine failed to load script ");
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramTritonException = localIterator.next();
      } while (!(((ScriptLoadStatistic)paramTritonException).getLoadResult().isSuccess() ^ true));
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        for (;;)
        {
          throw paramErrorCodes;
        }
        paramTritonException = null;
        continue;
        label282:
        continue;
        boolean bool = false;
      }
    }
    ((StringBuilder)localObject).append((ScriptLoadStatistic)paramTritonException);
    paramTritonException = new TritonException(((StringBuilder)localObject).toString(), ErrorCodes.SCRIPT_LOAD_FAIL, null, 4, null);
    localObject = paramTritonException;
    if (paramTritonException == null)
    {
      localObject = paramTritonException;
      if (!paramErrorCodes.getSuccess()) {
        localObject = new TritonException("failed to Init Engine", paramErrorCodes, null, 4, null);
      }
    }
    if (localObject == null)
    {
      bool = true;
      this.mEngineInitStatistic = new EngineInitStatistic(bool, (TritonException)localObject, paramLong1, paramLong2, paramLong3, paramLong4, (List)paramArrayList, (List)paramArrayList1);
      if (this.mLaunchAfterInit != null)
      {
        paramErrorCodes = this.mLaunchAfterInit;
        if (paramErrorCodes == null) {
          Intrinsics.throwNpe();
        }
        paramErrorCodes.run();
        this.mLaunchAfterInit = ((Runnable)null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher
 * JD-Core Version:    0.7.0.1
 */