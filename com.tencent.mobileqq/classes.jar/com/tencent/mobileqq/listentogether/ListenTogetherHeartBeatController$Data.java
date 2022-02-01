package com.tencent.mobileqq.listentogether;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController$Data;", "", "type", "", "uin", "", "(ILjava/lang/String;)V", "sessionType", "getSessionType", "()I", "setSessionType", "(I)V", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "equals", "", "other", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ListenTogetherHeartBeatController$Data
{
  private int a;
  @Nullable
  private String b;
  
  public ListenTogetherHeartBeatController$Data(int paramInt, @NotNull String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool3 = paramObject instanceof Data;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Data)paramObject;
      bool1 = bool2;
      if (paramObject.a == this.a)
      {
        bool1 = bool2;
        if (StringsKt.equals$default(paramObject.b, this.b, false, 2, null)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHeartBeatController.Data
 * JD-Core Version:    0.7.0.1
 */