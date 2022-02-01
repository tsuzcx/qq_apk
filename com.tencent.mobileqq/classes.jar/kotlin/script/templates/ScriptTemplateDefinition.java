package kotlin.script.templates;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.script.dependencies.ScriptDependenciesResolver;
import kotlin.script.experimental.dependencies.DependenciesResolver.NoDependencies;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/templates/ScriptTemplateDefinition;", "", "resolver", "Lkotlin/reflect/KClass;", "Lkotlin/script/dependencies/ScriptDependenciesResolver;", "scriptFilePattern", "", "()Ljava/lang/Class;", "()Ljava/lang/String;", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS})
public @interface ScriptTemplateDefinition
{
  Class<? extends ScriptDependenciesResolver> resolver() default DependenciesResolver.NoDependencies.class;
  
  String scriptFilePattern() default ".*\\.kts";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.templates.ScriptTemplateDefinition
 * JD-Core Version:    0.7.0.1
 */