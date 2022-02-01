package com.tencent.mobileqq.triton.script;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptFile$Content;", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "content", "codeCache", "Ljava/io/File;", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getCodeCache", "()Ljava/io/File;", "getContent", "()Ljava/lang/String;", "getName", "valid", "", "getValid", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class ScriptFile$Content
  extends ScriptFile
{
  @Nullable
  private final File codeCache;
  @NotNull
  private final String content;
  @NotNull
  private final String name;
  
  public ScriptFile$Content(@NotNull String paramString1, @NotNull String paramString2, @Nullable File paramFile)
  {
    super(null);
    this.name = paramString1;
    this.content = paramString2;
    this.codeCache = paramFile;
  }
  
  @NotNull
  public final String component1()
  {
    return this.name;
  }
  
  @NotNull
  public final String component2()
  {
    return this.content;
  }
  
  @Nullable
  public final File component3()
  {
    return this.codeCache;
  }
  
  @NotNull
  public final Content copy(@NotNull String paramString1, @NotNull String paramString2, @Nullable File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "content");
    return new Content(paramString1, paramString2, paramFile);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof Content))
      {
        paramObject = (Content)paramObject;
        if ((!Intrinsics.areEqual(this.name, paramObject.name)) || (!Intrinsics.areEqual(this.content, paramObject.content)) || (!Intrinsics.areEqual(this.codeCache, paramObject.codeCache))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final File getCodeCache()
  {
    return this.codeCache;
  }
  
  @NotNull
  public final String getContent()
  {
    return this.content;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public boolean getValid()
  {
    return ((CharSequence)this.content).length() > 0;
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = this.name;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.content;
      if (localObject == null) {
        break label70;
      }
    }
    label70:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.codeCache;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "Content(name=" + this.name + ", content=" + this.content + ", codeCache=" + this.codeCache + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptFile.Content
 * JD-Core Version:    0.7.0.1
 */