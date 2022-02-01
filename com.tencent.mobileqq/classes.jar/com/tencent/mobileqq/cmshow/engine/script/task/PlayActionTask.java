package com.tencent.mobileqq.cmshow.engine.script.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;", "Lcom/tencent/mobileqq/cmshow/engine/script/task/AbsScriptTask;", "()V", "actionId", "", "getActionId", "()I", "setActionId", "(I)V", "actionType", "getActionType", "setActionType", "actions", "Lorg/json/JSONArray;", "getActions", "()Lorg/json/JSONArray;", "setActions", "(Lorg/json/JSONArray;)V", "actionsList", "", "getActionsList", "()Ljava/util/List;", "setActionsList", "(Ljava/util/List;)V", "audio", "Lorg/json/JSONObject;", "getAudio", "()Lorg/json/JSONObject;", "setAudio", "(Lorg/json/JSONObject;)V", "audioId", "getAudioId", "setAudioId", "audioStartTime", "", "getAudioStartTime", "()F", "setAudioStartTime", "(F)V", "checkRsc", "", "getCheckRsc", "()Z", "setCheckRsc", "(Z)V", "extraMsg", "", "getExtraMsg", "()Ljava/lang/String;", "setExtraMsg", "(Ljava/lang/String;)V", "frameTime", "getFrameTime", "setFrameTime", "from", "getFrom", "setFrom", "functionName", "getFunctionName", "setFunctionName", "inputText", "getInputText", "setInputText", "isHide", "setHide", "isSender", "setSender", "model", "getModel", "setModel", "msgId", "", "getMsgId", "()J", "setMsgId", "(J)V", "needRecordFrame", "getNeedRecordFrame", "setNeedRecordFrame", "recvUin", "getRecvUin", "setRecvUin", "rscType", "getRscType", "setRscType", "senderUin", "getSenderUin", "setSenderUin", "spriteNum", "getSpriteNum", "setSpriteNum", "sprites", "getSprites", "setSprites", "subType", "getSubType", "setSubType", "taskId", "getTaskId", "setTaskId", "textIsBarrage", "getTextIsBarrage", "setTextIsBarrage", "buildParams", "isWhiteFace", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract class PlayActionTask
  extends AbsScriptTask
{
  private float jdField_a_of_type_Float = (float)0.1D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  public String a;
  @Nullable
  private List<Integer> jdField_a_of_type_JavaUtilList;
  @NotNull
  protected JSONArray a;
  @Nullable
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  @Nullable
  private String jdField_b_of_type_JavaLangString;
  @Nullable
  private JSONArray jdField_b_of_type_OrgJsonJSONArray;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  @Nullable
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  @Nullable
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = 1;
  @Nullable
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  @Nullable
  private String jdField_f_of_type_JavaLangString;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public final float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final List<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  @NotNull
  protected final JSONArray a()
  {
    JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONArray;
    if (localJSONArray == null) {
      Intrinsics.throwUninitializedPropertyAccessException("sprites");
    }
    return localJSONArray;
  }
  
  @Nullable
  protected final JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public final void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable List<Integer> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected final void a(@NotNull JSONArray paramJSONArray)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONArray, "<set-?>");
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
  }
  
  protected final void a(@Nullable JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected final boolean a(int paramInt)
  {
    return paramInt == 1;
  }
  
  public final float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  @Nullable
  protected final JSONArray b()
  {
    return this.jdField_b_of_type_OrgJsonJSONArray;
  }
  
  public final void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public final void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected final void b(@Nullable JSONArray paramJSONArray)
  {
    this.jdField_b_of_type_OrgJsonJSONArray = paramJSONArray;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public final int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public final boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final int e()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @Nullable
  public final String e()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public final void e(@Nullable String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public final boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final int f()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @NotNull
  public final String f()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("model");
    }
    return str;
  }
  
  public final void f(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public final void f(@Nullable String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public final int g()
  {
    return this.jdField_e_of_type_Int;
  }
  
  @Nullable
  public final String g()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public final void g(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final int h()
  {
    return this.jdField_f_of_type_Int;
  }
  
  @Nullable
  public final String h()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public final void h(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final int i()
  {
    return this.g;
  }
  
  @Nullable
  public final String i()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public final void i(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final int j()
  {
    return this.h;
  }
  
  @Nullable
  public final String j()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public final void j(int paramInt)
  {
    this.j = paramInt;
  }
  
  public final int k()
  {
    return this.i;
  }
  
  public final int l()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask
 * JD-Core Version:    0.7.0.1
 */