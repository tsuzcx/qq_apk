package kotlin.script.templates.standard;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/templates/standard/ScriptTemplateWithBindings;", "", "bindings", "", "", "(Ljava/util/Map;)V", "getBindings", "()Ljava/util/Map;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract class ScriptTemplateWithBindings
{
  @NotNull
  private final Map<String, Object> bindings;
  
  public ScriptTemplateWithBindings(@NotNull Map<String, ? extends Object> paramMap)
  {
    this.bindings = paramMap;
  }
  
  @NotNull
  public final Map<String, Object> getBindings()
  {
    return this.bindings;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.templates.standard.ScriptTemplateWithBindings
 * JD-Core Version:    0.7.0.1
 */