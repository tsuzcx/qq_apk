package kotlin.script.templates.standard;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/templates/standard/ScriptTemplateWithArgs;", "", "args", "", "", "([Ljava/lang/String;)V", "getArgs", "()[Ljava/lang/String;", "[Ljava/lang/String;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract class ScriptTemplateWithArgs
{
  @NotNull
  private final String[] args;
  
  public ScriptTemplateWithArgs(@NotNull String[] paramArrayOfString)
  {
    this.args = paramArrayOfString;
  }
  
  @NotNull
  public final String[] getArgs()
  {
    return this.args;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.templates.standard.ScriptTemplateWithArgs
 * JD-Core Version:    0.7.0.1
 */