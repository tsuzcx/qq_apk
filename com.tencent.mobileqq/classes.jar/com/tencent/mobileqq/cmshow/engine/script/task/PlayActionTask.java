package com.tencent.mobileqq.cmshow.engine.script.task;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.action.PlayActionScript;
import com.tencent.mobileqq.cmshow.engine.resource.IResourceService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "actionId", "", "getActionId", "()I", "setActionId", "(I)V", "actionType", "getActionType", "setActionType", "actions", "Lorg/json/JSONArray;", "getActions", "()Lorg/json/JSONArray;", "setActions", "(Lorg/json/JSONArray;)V", "actionsList", "", "getActionsList", "()Ljava/util/List;", "setActionsList", "(Ljava/util/List;)V", "audio", "Lorg/json/JSONObject;", "getAudio", "()Lorg/json/JSONObject;", "setAudio", "(Lorg/json/JSONObject;)V", "audioId", "getAudioId", "setAudioId", "audioStartTime", "", "getAudioStartTime", "()F", "setAudioStartTime", "(F)V", "checkRsc", "", "getCheckRsc", "()Z", "setCheckRsc", "(Z)V", "extraMsg", "", "getExtraMsg", "()Ljava/lang/String;", "setExtraMsg", "(Ljava/lang/String;)V", "frameTime", "getFrameTime", "setFrameTime", "from", "getFrom", "setFrom", "functionName", "getFunctionName", "setFunctionName", "inputText", "getInputText", "setInputText", "isHide", "setHide", "isSender", "setSender", "model", "getModel", "setModel", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "needRecordFrame", "getNeedRecordFrame", "setNeedRecordFrame", "recvUin", "getRecvUin", "setRecvUin", "rscType", "getRscType", "setRscType", "senderUin", "getSenderUin", "setSenderUin", "spriteNum", "getSpriteNum", "setSpriteNum", "sprites", "getSprites", "setSprites", "subType", "getSubType", "setSubType", "taskId", "getTaskId", "setTaskId", "textIsBarrage", "getTextIsBarrage", "setTextIsBarrage", "buildParams", "buildScript", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "isWhiteFace", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract class PlayActionTask
  extends AbsScriptTask
{
  @Deprecated
  public static final PlayActionTask.Companion d = new PlayActionTask.Companion(null);
  private long A;
  private final EngineContext B;
  @Nullable
  private String a;
  @NotNull
  public String b;
  @NotNull
  protected JSONArray c;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  @Nullable
  private String k;
  @Nullable
  private String l;
  @Nullable
  private String m;
  private boolean n;
  private float o;
  @Nullable
  private JSONArray p;
  @Nullable
  private List<Integer> q;
  @Nullable
  private JSONObject r;
  private int s;
  private float t;
  private boolean u;
  @Nullable
  private String v;
  private boolean w;
  private int x;
  private int y;
  private int z;
  
  public PlayActionTask(@NotNull EngineContext paramEngineContext)
  {
    super(paramEngineContext.h().a());
    this.B = paramEngineContext;
    this.i = 1;
    this.o = ((float)0.1D);
  }
  
  @NotNull
  public Script a()
  {
    Object localObject2 = b();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)this.a))
    {
      localObject1 = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("if (typeof ");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" == 'function') {\n");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("    ");
      localStringBuilder.append(this.a);
      localStringBuilder.append("('");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("');\n");
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      ((StringBuilder)localObject1).append("}");
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "StringBuilder().apply(builderAction).toString()");
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("buildScript: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.w("[cmshow][ScriptTask][PlayActionTask]", 2, ((StringBuilder)localObject2).toString());
    }
    return (Script)new PlayActionScript(this.B, (String)localObject1, this);
  }
  
  public final void a(float paramFloat)
  {
    this.o = paramFloat;
  }
  
  public final void a(long paramLong)
  {
    this.A = paramLong;
  }
  
  public final void a(@Nullable List<Integer> paramList)
  {
    this.q = paramList;
  }
  
  @NotNull
  public String b()
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("model");
    }
    localJSONObject.put("model", localObject);
    localJSONObject.put("actionId", this.e);
    localJSONObject.put("taskId", this.g);
    localJSONObject.put("actionType", this.f);
    localJSONObject.put("from", this.h);
    localJSONObject.put("isHide", this.i);
    localJSONObject.put("isSender", this.j);
    if (m(this.f))
    {
      localObject = ScriptUtils.a(this);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ScriptUtils.getWhiteFaceSprites(this)");
      this.c = ((JSONArray)localObject);
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("sprites");
      }
      localJSONObject.put("sprites", localObject);
      this.p = ScriptUtils.b(this);
      localJSONObject.put("actions", this.p);
    }
    else
    {
      localObject = ScriptUtils.c(this);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ScriptUtils.getBasicActionJs(this)");
      this.c = ((JSONArray)localObject);
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("sprites");
      }
      localJSONObject.put("sprites", localObject);
    }
    boolean bool;
    if (i() == 1) {
      bool = CmShowWnsUtils.U();
    } else {
      bool = true;
    }
    if (bool)
    {
      localObject = ScriptUtils.d(this);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableAudio: ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" in DRAWER for actionId:");
      ((StringBuilder)localObject).append(this.e);
      QLog.w("[cmshow][ScriptTask][PlayActionTask]", 1, ((StringBuilder)localObject).toString());
      localObject = null;
    }
    this.r = ((JSONObject)localObject);
    localObject = this.r;
    if (localObject != null) {
      localJSONObject.put("audio", localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)this.m)) {
      localJSONObject.put("extraMsg", new JSONObject(this.m));
    }
    localJSONObject.put("needRecordFrame", this.n);
    localJSONObject.put("frameTime", Float.valueOf(this.o));
    localObject = localJSONObject.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "actionJson.toString()");
    return localObject;
  }
  
  public final void b(float paramFloat)
  {
    this.t = paramFloat;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.a = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public final void d(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public final void e(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void e(@Nullable String paramString)
  {
    this.k = paramString;
  }
  
  public final void e(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public final void f(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void f(@Nullable String paramString)
  {
    this.l = paramString;
  }
  
  public final void g(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void g(@Nullable String paramString)
  {
    this.m = paramString;
  }
  
  public final void h(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final void h(@Nullable String paramString)
  {
    this.v = paramString;
  }
  
  public final void i(int paramInt)
  {
    this.s = paramInt;
  }
  
  public final void j(int paramInt)
  {
    this.x = paramInt;
  }
  
  public final void k(int paramInt)
  {
    this.y = paramInt;
  }
  
  public final int l()
  {
    return this.f;
  }
  
  public final void l(int paramInt)
  {
    this.z = paramInt;
  }
  
  public final int m()
  {
    return this.g;
  }
  
  protected final boolean m(int paramInt)
  {
    return paramInt == 1;
  }
  
  @Nullable
  public final String n()
  {
    return this.k;
  }
  
  @Nullable
  public final String o()
  {
    return this.l;
  }
  
  @Nullable
  public final String p()
  {
    return this.m;
  }
  
  @Nullable
  public final List<Integer> q()
  {
    return this.q;
  }
  
  public final int r()
  {
    return this.s;
  }
  
  public final float s()
  {
    return this.t;
  }
  
  public final boolean t()
  {
    return this.u;
  }
  
  @Nullable
  public final String u()
  {
    return this.v;
  }
  
  public final boolean v()
  {
    return this.w;
  }
  
  public final int w()
  {
    return this.x;
  }
  
  public final int x()
  {
    return this.y;
  }
  
  public final int y()
  {
    return this.z;
  }
  
  public final long z()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask
 * JD-Core Version:    0.7.0.1
 */