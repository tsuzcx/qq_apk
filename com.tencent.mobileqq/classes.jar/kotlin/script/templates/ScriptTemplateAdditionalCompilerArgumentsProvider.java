package kotlin.script.templates;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message="temporary workaround for missing functionality, will be replaced by the new API soon")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/templates/ScriptTemplateAdditionalCompilerArgumentsProvider;", "", "arguments", "", "", "(Ljava/lang/Iterable;)V", "getArguments", "()Ljava/lang/Iterable;", "getAdditionalCompilerArguments", "environment", "", "Lkotlin/script/dependencies/Environment;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public class ScriptTemplateAdditionalCompilerArgumentsProvider
{
  @NotNull
  private final Iterable<String> arguments;
  
  public ScriptTemplateAdditionalCompilerArgumentsProvider()
  {
    this(null, 1, null);
  }
  
  public ScriptTemplateAdditionalCompilerArgumentsProvider(@NotNull Iterable<String> paramIterable)
  {
    this.arguments = paramIterable;
  }
  
  @NotNull
  public Iterable<String> getAdditionalCompilerArguments(@Nullable Map<String, ? extends Object> paramMap)
  {
    return this.arguments;
  }
  
  @NotNull
  public final Iterable<String> getArguments()
  {
    return this.arguments;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.templates.ScriptTemplateAdditionalCompilerArgumentsProvider
 * JD-Core Version:    0.7.0.1
 */