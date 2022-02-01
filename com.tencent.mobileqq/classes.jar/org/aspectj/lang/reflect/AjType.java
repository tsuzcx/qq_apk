package org.aspectj.lang.reflect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract interface AjType<T>
  extends AnnotatedElement, Type
{
  public abstract Advice getAdvice(String paramString);
  
  public abstract Advice[] getAdvice(AdviceKind... paramVarArgs);
  
  public abstract AjType<?>[] getAjTypes();
  
  public abstract Constructor getConstructor(AjType<?>... paramVarArgs);
  
  public abstract Constructor[] getConstructors();
  
  public abstract DeclareAnnotation[] getDeclareAnnotations();
  
  public abstract DeclareErrorOrWarning[] getDeclareErrorOrWarnings();
  
  public abstract DeclareParents[] getDeclareParents();
  
  public abstract DeclarePrecedence[] getDeclarePrecedence();
  
  public abstract DeclareSoft[] getDeclareSofts();
  
  public abstract Advice getDeclaredAdvice(String paramString);
  
  public abstract Advice[] getDeclaredAdvice(AdviceKind... paramVarArgs);
  
  public abstract AjType<?>[] getDeclaredAjTypes();
  
  public abstract Constructor getDeclaredConstructor(AjType<?>... paramVarArgs);
  
  public abstract Constructor[] getDeclaredConstructors();
  
  public abstract Field getDeclaredField(String paramString);
  
  public abstract Field[] getDeclaredFields();
  
  public abstract InterTypeConstructorDeclaration getDeclaredITDConstructor(AjType<?> paramAjType, AjType<?>... paramVarArgs);
  
  public abstract InterTypeConstructorDeclaration[] getDeclaredITDConstructors();
  
  public abstract InterTypeFieldDeclaration getDeclaredITDField(String paramString, AjType<?> paramAjType);
  
  public abstract InterTypeFieldDeclaration[] getDeclaredITDFields();
  
  public abstract InterTypeMethodDeclaration getDeclaredITDMethod(String paramString, AjType<?> paramAjType, AjType<?>... paramVarArgs);
  
  public abstract InterTypeMethodDeclaration[] getDeclaredITDMethods();
  
  public abstract Method getDeclaredMethod(String paramString, AjType<?>... paramVarArgs);
  
  public abstract Method[] getDeclaredMethods();
  
  public abstract Pointcut getDeclaredPointcut(String paramString);
  
  public abstract Pointcut[] getDeclaredPointcuts();
  
  public abstract AjType<?> getDeclaringType();
  
  public abstract Constructor getEnclosingConstructor();
  
  public abstract Method getEnclosingMethod();
  
  public abstract AjType<?> getEnclosingType();
  
  public abstract T[] getEnumConstants();
  
  public abstract Field getField(String paramString);
  
  public abstract Field[] getFields();
  
  public abstract Type getGenericSupertype();
  
  public abstract InterTypeConstructorDeclaration getITDConstructor(AjType<?> paramAjType, AjType<?>... paramVarArgs);
  
  public abstract InterTypeConstructorDeclaration[] getITDConstructors();
  
  public abstract InterTypeFieldDeclaration getITDField(String paramString, AjType<?> paramAjType);
  
  public abstract InterTypeFieldDeclaration[] getITDFields();
  
  public abstract InterTypeMethodDeclaration getITDMethod(String paramString, AjType<?> paramAjType, AjType<?>... paramVarArgs);
  
  public abstract InterTypeMethodDeclaration[] getITDMethods();
  
  public abstract AjType<?>[] getInterfaces();
  
  public abstract Class<T> getJavaClass();
  
  public abstract Method getMethod(String paramString, AjType<?>... paramVarArgs);
  
  public abstract Method[] getMethods();
  
  public abstract int getModifiers();
  
  public abstract String getName();
  
  public abstract Package getPackage();
  
  public abstract PerClause getPerClause();
  
  public abstract Pointcut getPointcut(String paramString);
  
  public abstract Pointcut[] getPointcuts();
  
  public abstract AjType<?> getSupertype();
  
  public abstract TypeVariable<Class<T>>[] getTypeParameters();
  
  public abstract boolean isArray();
  
  public abstract boolean isAspect();
  
  public abstract boolean isEnum();
  
  public abstract boolean isInstance(Object paramObject);
  
  public abstract boolean isInterface();
  
  public abstract boolean isLocalClass();
  
  public abstract boolean isMemberAspect();
  
  public abstract boolean isMemberClass();
  
  public abstract boolean isPrimitive();
  
  public abstract boolean isPrivileged();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.AjType
 * JD-Core Version:    0.7.0.1
 */