package kotlin.script.dependencies;

import java.io.File;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/ScriptContents;", "", "annotations", "", "", "getAnnotations", "()Ljava/lang/Iterable;", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "text", "", "getText", "()Ljava/lang/CharSequence;", "Position", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public abstract interface ScriptContents
{
  @NotNull
  public abstract Iterable<Annotation> getAnnotations();
  
  @Nullable
  public abstract File getFile();
  
  @Nullable
  public abstract CharSequence getText();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.ScriptContents
 * JD-Core Version:    0.7.0.1
 */