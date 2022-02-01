package org.aspectj.internal.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.aspectj.internal.lang.annotation.ajcDeclareParents;
import org.aspectj.internal.lang.annotation.ajcDeclarePrecedence;
import org.aspectj.internal.lang.annotation.ajcDeclareSoft;
import org.aspectj.internal.lang.annotation.ajcITD;
import org.aspectj.internal.lang.annotation.ajcPrivileged;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareError;
import org.aspectj.lang.annotation.DeclareWarning;
import org.aspectj.lang.reflect.Advice;
import org.aspectj.lang.reflect.AdviceKind;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.AjTypeSystem;
import org.aspectj.lang.reflect.DeclareAnnotation;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.DeclareSoft;
import org.aspectj.lang.reflect.InterTypeConstructorDeclaration;
import org.aspectj.lang.reflect.InterTypeFieldDeclaration;
import org.aspectj.lang.reflect.InterTypeMethodDeclaration;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.aspectj.lang.reflect.NoSuchPointcutException;
import org.aspectj.lang.reflect.PerClause;
import org.aspectj.lang.reflect.PerClauseKind;

public class AjTypeImpl<T>
  implements AjType<T>
{
  private static final String ajcMagic = "ajc$";
  private Advice[] advice = null;
  private Class<T> clazz;
  private Advice[] declaredAdvice = null;
  private InterTypeConstructorDeclaration[] declaredITDCons = null;
  private InterTypeFieldDeclaration[] declaredITDFields = null;
  private InterTypeMethodDeclaration[] declaredITDMethods = null;
  private org.aspectj.lang.reflect.Pointcut[] declaredPointcuts = null;
  private InterTypeConstructorDeclaration[] itdCons = null;
  private InterTypeFieldDeclaration[] itdFields = null;
  private InterTypeMethodDeclaration[] itdMethods = null;
  private org.aspectj.lang.reflect.Pointcut[] pointcuts = null;
  
  public AjTypeImpl(Class<T> paramClass)
  {
    this.clazz = paramClass;
  }
  
  private void addAnnotationStyleDeclareParents(List<org.aspectj.lang.reflect.DeclareParents> paramList)
  {
    Field[] arrayOfField = this.clazz.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfField[i];
      if ((((Field)localObject).isAnnotationPresent(org.aspectj.lang.annotation.DeclareParents.class)) && (((Field)localObject).getType().isInterface()))
      {
        org.aspectj.lang.annotation.DeclareParents localDeclareParents = (org.aspectj.lang.annotation.DeclareParents)((Field)localObject).getAnnotation(org.aspectj.lang.annotation.DeclareParents.class);
        localObject = ((Field)localObject).getType().getName();
        paramList.add(new DeclareParentsImpl(localDeclareParents.value(), (String)localObject, false, this));
      }
      i += 1;
    }
  }
  
  private void addAnnotationStyleITDFields(List<InterTypeFieldDeclaration> paramList, boolean paramBoolean) {}
  
  private void addAnnotationStyleITDMethods(List<InterTypeMethodDeclaration> paramList, boolean paramBoolean)
  {
    if (isAspect())
    {
      Field[] arrayOfField = this.clazz.getDeclaredFields();
      int k = arrayOfField.length;
      int i = 0;
      while (i < k)
      {
        Field localField = arrayOfField[i];
        if ((localField.getType().isInterface()) && (localField.isAnnotationPresent(org.aspectj.lang.annotation.DeclareParents.class)) && (((org.aspectj.lang.annotation.DeclareParents)localField.getAnnotation(org.aspectj.lang.annotation.DeclareParents.class)).defaultImpl() != org.aspectj.lang.annotation.DeclareParents.class))
        {
          Method[] arrayOfMethod = localField.getType().getDeclaredMethods();
          int m = arrayOfMethod.length;
          int j = 0;
          while (j < m)
          {
            Method localMethod = arrayOfMethod[j];
            if ((Modifier.isPublic(localMethod.getModifiers())) || (!paramBoolean)) {
              paramList.add(new InterTypeMethodDeclarationImpl(this, AjTypeSystem.getAjType(localField.getType()), localMethod, 1));
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private Advice asAdvice(Method paramMethod)
  {
    int i = paramMethod.getAnnotations().length;
    Object localObject1 = null;
    if (i == 0) {
      return null;
    }
    Object localObject2 = (Before)paramMethod.getAnnotation(Before.class);
    if (localObject2 != null) {
      return new AdviceImpl(paramMethod, ((Before)localObject2).value(), AdviceKind.BEFORE);
    }
    localObject2 = (After)paramMethod.getAnnotation(After.class);
    if (localObject2 != null) {
      return new AdviceImpl(paramMethod, ((After)localObject2).value(), AdviceKind.AFTER);
    }
    Object localObject3 = (AfterReturning)paramMethod.getAnnotation(AfterReturning.class);
    if (localObject3 != null)
    {
      localObject2 = ((AfterReturning)localObject3).pointcut();
      localObject1 = localObject2;
      if (((String)localObject2).equals("")) {
        localObject1 = ((AfterReturning)localObject3).value();
      }
      return new AdviceImpl(paramMethod, (String)localObject1, AdviceKind.AFTER_RETURNING, ((AfterReturning)localObject3).returning());
    }
    localObject3 = (AfterThrowing)paramMethod.getAnnotation(AfterThrowing.class);
    if (localObject3 != null)
    {
      localObject2 = ((AfterThrowing)localObject3).pointcut();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((AfterThrowing)localObject3).value();
      }
      return new AdviceImpl(paramMethod, (String)localObject1, AdviceKind.AFTER_THROWING, ((AfterThrowing)localObject3).throwing());
    }
    localObject2 = (Around)paramMethod.getAnnotation(Around.class);
    if (localObject2 != null) {
      localObject1 = new AdviceImpl(paramMethod, ((Around)localObject2).value(), AdviceKind.AROUND);
    }
    return localObject1;
  }
  
  private org.aspectj.lang.reflect.Pointcut asPointcut(Method paramMethod)
  {
    org.aspectj.lang.annotation.Pointcut localPointcut = (org.aspectj.lang.annotation.Pointcut)paramMethod.getAnnotation(org.aspectj.lang.annotation.Pointcut.class);
    if (localPointcut != null)
    {
      String str2 = paramMethod.getName();
      String str1 = str2;
      if (str2.startsWith("ajc$"))
      {
        str2 = str2.substring(str2.indexOf("$$") + 2, str2.length());
        int i = str2.indexOf("$");
        str1 = str2;
        if (i != -1) {
          str1 = str2.substring(0, i);
        }
      }
      return new PointcutImpl(str1, localPointcut.value(), paramMethod, AjTypeSystem.getAjType(paramMethod.getDeclaringClass()), localPointcut.argNames());
    }
    return null;
  }
  
  private Advice[] getAdvice(Set paramSet)
  {
    if (this.advice == null) {
      initAdvice();
    }
    ArrayList localArrayList = new ArrayList();
    Advice[] arrayOfAdvice = this.advice;
    int j = arrayOfAdvice.length;
    int i = 0;
    while (i < j)
    {
      Advice localAdvice = arrayOfAdvice[i];
      if (paramSet.contains(localAdvice.getKind())) {
        localArrayList.add(localAdvice);
      }
      i += 1;
    }
    paramSet = new Advice[localArrayList.size()];
    localArrayList.toArray(paramSet);
    return paramSet;
  }
  
  private Advice[] getDeclaredAdvice(Set paramSet)
  {
    if (this.declaredAdvice == null) {
      initDeclaredAdvice();
    }
    ArrayList localArrayList = new ArrayList();
    Advice[] arrayOfAdvice = this.declaredAdvice;
    int j = arrayOfAdvice.length;
    int i = 0;
    while (i < j)
    {
      Advice localAdvice = arrayOfAdvice[i];
      if (paramSet.contains(localAdvice.getKind())) {
        localArrayList.add(localAdvice);
      }
      i += 1;
    }
    paramSet = new Advice[localArrayList.size()];
    localArrayList.toArray(paramSet);
    return paramSet;
  }
  
  private void initAdvice()
  {
    Method[] arrayOfMethod = this.clazz.getMethods();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Advice localAdvice = asAdvice(arrayOfMethod[i]);
      if (localAdvice != null) {
        localArrayList.add(localAdvice);
      }
      i += 1;
    }
    this.advice = new Advice[localArrayList.size()];
    localArrayList.toArray(this.advice);
  }
  
  private void initDeclaredAdvice()
  {
    Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Advice localAdvice = asAdvice(arrayOfMethod[i]);
      if (localAdvice != null) {
        localArrayList.add(localAdvice);
      }
      i += 1;
    }
    this.declaredAdvice = new Advice[localArrayList.size()];
    localArrayList.toArray(this.declaredAdvice);
  }
  
  private boolean isReallyAMethod(Method paramMethod)
  {
    if (paramMethod.getName().startsWith("ajc$")) {
      return false;
    }
    if (paramMethod.getAnnotations().length == 0) {
      return true;
    }
    if (paramMethod.isAnnotationPresent(org.aspectj.lang.annotation.Pointcut.class)) {
      return false;
    }
    if (paramMethod.isAnnotationPresent(Before.class)) {
      return false;
    }
    if (paramMethod.isAnnotationPresent(After.class)) {
      return false;
    }
    if (paramMethod.isAnnotationPresent(AfterReturning.class)) {
      return false;
    }
    if (paramMethod.isAnnotationPresent(AfterThrowing.class)) {
      return false;
    }
    return !paramMethod.isAnnotationPresent(Around.class);
  }
  
  private AjType<?>[] toAjTypeArray(Class<?>[] paramArrayOfClass)
  {
    AjType[] arrayOfAjType = new AjType[paramArrayOfClass.length];
    int i = 0;
    while (i < arrayOfAjType.length)
    {
      arrayOfAjType[i] = AjTypeSystem.getAjType(paramArrayOfClass[i]);
      i += 1;
    }
    return arrayOfAjType;
  }
  
  private Class<?>[] toClassArray(AjType<?>[] paramArrayOfAjType)
  {
    Class[] arrayOfClass = new Class[paramArrayOfAjType.length];
    int i = 0;
    while (i < arrayOfClass.length)
    {
      arrayOfClass[i] = paramArrayOfAjType[i].getJavaClass();
      i += 1;
    }
    return arrayOfClass;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AjTypeImpl)) {
      return false;
    }
    return ((AjTypeImpl)paramObject).clazz.equals(this.clazz);
  }
  
  public Advice getAdvice(String paramString)
  {
    if (!paramString.equals(""))
    {
      if (this.advice == null) {
        initAdvice();
      }
      Advice[] arrayOfAdvice = this.advice;
      int j = arrayOfAdvice.length;
      int i = 0;
      while (i < j)
      {
        Advice localAdvice = arrayOfAdvice[i];
        if (localAdvice.getName().equals(paramString)) {
          return localAdvice;
        }
        i += 1;
      }
      throw new NoSuchAdviceException(paramString);
    }
    paramString = new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public Advice[] getAdvice(AdviceKind... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = EnumSet.allOf(AdviceKind.class);
    }
    else
    {
      EnumSet localEnumSet = EnumSet.noneOf(AdviceKind.class);
      localEnumSet.addAll(Arrays.asList(paramVarArgs));
      paramVarArgs = localEnumSet;
    }
    return getAdvice(paramVarArgs);
  }
  
  public AjType<?>[] getAjTypes()
  {
    return toAjTypeArray(this.clazz.getClasses());
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this.clazz.getAnnotation(paramClass);
  }
  
  public Annotation[] getAnnotations()
  {
    return this.clazz.getAnnotations();
  }
  
  public Constructor getConstructor(AjType<?>... paramVarArgs)
  {
    return this.clazz.getConstructor(toClassArray(paramVarArgs));
  }
  
  public Constructor[] getConstructors()
  {
    return this.clazz.getConstructors();
  }
  
  public DeclareAnnotation[] getDeclareAnnotations()
  {
    ArrayList localArrayList = new ArrayList();
    Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
    int k = arrayOfMethod.length;
    int i = 0;
    while (i < k)
    {
      localObject = arrayOfMethod[i];
      if (((Method)localObject).isAnnotationPresent(ajcDeclareAnnotation.class))
      {
        ajcDeclareAnnotation localajcDeclareAnnotation = (ajcDeclareAnnotation)((Method)localObject).getAnnotation(ajcDeclareAnnotation.class);
        Annotation[] arrayOfAnnotation = ((Method)localObject).getAnnotations();
        int m = arrayOfAnnotation.length;
        int j = 0;
        while (j < m)
        {
          localObject = arrayOfAnnotation[j];
          if (((Annotation)localObject).annotationType() != ajcDeclareAnnotation.class) {
            break label111;
          }
          j += 1;
        }
        localObject = null;
        label111:
        localArrayList.add(new DeclareAnnotationImpl(this, localajcDeclareAnnotation.kind(), localajcDeclareAnnotation.pattern(), (Annotation)localObject, localajcDeclareAnnotation.annotation()));
      }
      i += 1;
    }
    if (getSupertype().isAspect()) {
      localArrayList.addAll(Arrays.asList(getSupertype().getDeclareAnnotations()));
    }
    Object localObject = new DeclareAnnotation[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    return localObject;
  }
  
  public DeclareErrorOrWarning[] getDeclareErrorOrWarnings()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.clazz.getDeclaredFields();
    int k = localObject1.length;
    int j = 0;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = localObject1[i];
      try
      {
        Object localObject3;
        if (((Field)localObject2).isAnnotationPresent(DeclareWarning.class))
        {
          localObject3 = (DeclareWarning)((Field)localObject2).getAnnotation(DeclareWarning.class);
          if ((Modifier.isPublic(((Field)localObject2).getModifiers())) && (Modifier.isStatic(((Field)localObject2).getModifiers())))
          {
            localObject2 = (String)((Field)localObject2).get(null);
            localArrayList.add(new DeclareErrorOrWarningImpl(((DeclareWarning)localObject3).value(), (String)localObject2, false, this));
          }
        }
        else if (((Field)localObject2).isAnnotationPresent(DeclareError.class))
        {
          localObject3 = (DeclareError)((Field)localObject2).getAnnotation(DeclareError.class);
          if ((Modifier.isPublic(((Field)localObject2).getModifiers())) && (Modifier.isStatic(((Field)localObject2).getModifiers())))
          {
            localObject2 = (String)((Field)localObject2).get(null);
            localArrayList.add(new DeclareErrorOrWarningImpl(((DeclareError)localObject3).value(), (String)localObject2, true, this));
          }
        }
      }
      catch (IllegalArgumentException|IllegalAccessException localIllegalArgumentException)
      {
        label206:
        break label206;
      }
      i += 1;
    }
    localObject1 = this.clazz.getDeclaredMethods();
    k = localObject1.length;
    i = j;
    while (i < k)
    {
      localObject2 = localObject1[i];
      if (((Method)localObject2).isAnnotationPresent(ajcDeclareEoW.class))
      {
        localObject2 = (ajcDeclareEoW)((Method)localObject2).getAnnotation(ajcDeclareEoW.class);
        localArrayList.add(new DeclareErrorOrWarningImpl(((ajcDeclareEoW)localObject2).pointcut(), ((ajcDeclareEoW)localObject2).message(), ((ajcDeclareEoW)localObject2).isError(), this));
      }
      i += 1;
    }
    localObject1 = new DeclareErrorOrWarning[localArrayList.size()];
    localArrayList.toArray((Object[])localObject1);
    return localObject1;
  }
  
  public org.aspectj.lang.reflect.DeclareParents[] getDeclareParents()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.clazz.getDeclaredMethods();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      ajcDeclareParents localajcDeclareParents = localObject[i];
      if (localajcDeclareParents.isAnnotationPresent(ajcDeclareParents.class))
      {
        localajcDeclareParents = (ajcDeclareParents)localajcDeclareParents.getAnnotation(ajcDeclareParents.class);
        localArrayList.add(new DeclareParentsImpl(localajcDeclareParents.targetTypePattern(), localajcDeclareParents.parentTypes(), localajcDeclareParents.isExtends(), this));
      }
      i += 1;
    }
    addAnnotationStyleDeclareParents(localArrayList);
    if (getSupertype().isAspect()) {
      localArrayList.addAll(Arrays.asList(getSupertype().getDeclareParents()));
    }
    localObject = new org.aspectj.lang.reflect.DeclareParents[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    return localObject;
  }
  
  public org.aspectj.lang.reflect.DeclarePrecedence[] getDeclarePrecedence()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.clazz.isAnnotationPresent(org.aspectj.lang.annotation.DeclarePrecedence.class)) {
      localArrayList.add(new DeclarePrecedenceImpl(((org.aspectj.lang.annotation.DeclarePrecedence)this.clazz.getAnnotation(org.aspectj.lang.annotation.DeclarePrecedence.class)).value(), this));
    }
    Object localObject1 = this.clazz.getDeclaredMethods();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.isAnnotationPresent(ajcDeclarePrecedence.class)) {
        localArrayList.add(new DeclarePrecedenceImpl(((ajcDeclarePrecedence)localObject2.getAnnotation(ajcDeclarePrecedence.class)).value(), this));
      }
      i += 1;
    }
    if (getSupertype().isAspect()) {
      localArrayList.addAll(Arrays.asList(getSupertype().getDeclarePrecedence()));
    }
    localObject1 = new org.aspectj.lang.reflect.DeclarePrecedence[localArrayList.size()];
    localArrayList.toArray((Object[])localObject1);
    return localObject1;
  }
  
  public DeclareSoft[] getDeclareSofts()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.clazz.getDeclaredMethods();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      ajcDeclareSoft localajcDeclareSoft = localObject[i];
      if (localajcDeclareSoft.isAnnotationPresent(ajcDeclareSoft.class))
      {
        localajcDeclareSoft = (ajcDeclareSoft)localajcDeclareSoft.getAnnotation(ajcDeclareSoft.class);
        localArrayList.add(new DeclareSoftImpl(this, localajcDeclareSoft.pointcut(), localajcDeclareSoft.exceptionType()));
      }
      i += 1;
    }
    if (getSupertype().isAspect()) {
      localArrayList.addAll(Arrays.asList(getSupertype().getDeclareSofts()));
    }
    localObject = new DeclareSoft[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    return localObject;
  }
  
  public Advice getDeclaredAdvice(String paramString)
  {
    if (!paramString.equals(""))
    {
      if (this.declaredAdvice == null) {
        initDeclaredAdvice();
      }
      Advice[] arrayOfAdvice = this.declaredAdvice;
      int j = arrayOfAdvice.length;
      int i = 0;
      while (i < j)
      {
        Advice localAdvice = arrayOfAdvice[i];
        if (localAdvice.getName().equals(paramString)) {
          return localAdvice;
        }
        i += 1;
      }
      throw new NoSuchAdviceException(paramString);
    }
    paramString = new IllegalArgumentException("use getAdvice(AdviceType...) instead for un-named advice");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public Advice[] getDeclaredAdvice(AdviceKind... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = EnumSet.allOf(AdviceKind.class);
    }
    else
    {
      EnumSet localEnumSet = EnumSet.noneOf(AdviceKind.class);
      localEnumSet.addAll(Arrays.asList(paramVarArgs));
      paramVarArgs = localEnumSet;
    }
    return getDeclaredAdvice(paramVarArgs);
  }
  
  public AjType<?>[] getDeclaredAjTypes()
  {
    return toAjTypeArray(this.clazz.getDeclaredClasses());
  }
  
  public Annotation[] getDeclaredAnnotations()
  {
    return this.clazz.getDeclaredAnnotations();
  }
  
  public Constructor getDeclaredConstructor(AjType<?>... paramVarArgs)
  {
    return this.clazz.getDeclaredConstructor(toClassArray(paramVarArgs));
  }
  
  public Constructor[] getDeclaredConstructors()
  {
    return this.clazz.getDeclaredConstructors();
  }
  
  public Field getDeclaredField(String paramString)
  {
    Field localField = this.clazz.getDeclaredField(paramString);
    if (!localField.getName().startsWith("ajc$")) {
      return localField;
    }
    throw new NoSuchFieldException(paramString);
  }
  
  public Field[] getDeclaredFields()
  {
    Field[] arrayOfField = this.clazz.getDeclaredFields();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((!localField.getName().startsWith("ajc$")) && (!localField.isAnnotationPresent(DeclareWarning.class)) && (!localField.isAnnotationPresent(DeclareError.class))) {
        localArrayList.add(localField);
      }
      i += 1;
    }
    arrayOfField = new Field[localArrayList.size()];
    localArrayList.toArray(arrayOfField);
    return arrayOfField;
  }
  
  public InterTypeConstructorDeclaration getDeclaredITDConstructor(AjType<?> paramAjType, AjType<?>... paramVarArgs)
  {
    InterTypeConstructorDeclaration[] arrayOfInterTypeConstructorDeclaration = getDeclaredITDConstructors();
    int k = arrayOfInterTypeConstructorDeclaration.length;
    int i = 0;
    while (i < k)
    {
      InterTypeConstructorDeclaration localInterTypeConstructorDeclaration = arrayOfInterTypeConstructorDeclaration[i];
      try
      {
        if (localInterTypeConstructorDeclaration.getTargetType().equals(paramAjType))
        {
          AjType[] arrayOfAjType = localInterTypeConstructorDeclaration.getParameterTypes();
          if (arrayOfAjType.length == paramVarArgs.length)
          {
            int j = 0;
            while (j < arrayOfAjType.length)
            {
              boolean bool = arrayOfAjType[j].equals(paramVarArgs[j]);
              if (!bool) {
                break label101;
              }
              j += 1;
            }
            return localInterTypeConstructorDeclaration;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label101:
        break label101;
      }
      i += 1;
    }
    paramAjType = new NoSuchMethodException();
    for (;;)
    {
      throw paramAjType;
    }
  }
  
  public InterTypeConstructorDeclaration[] getDeclaredITDConstructors()
  {
    if (this.declaredITDCons == null)
    {
      ArrayList localArrayList = new ArrayList();
      Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((localMethod.getName().contains("ajc$postInterConstructor")) && (localMethod.isAnnotationPresent(ajcITD.class)))
        {
          ajcITD localajcITD = (ajcITD)localMethod.getAnnotation(ajcITD.class);
          localArrayList.add(new InterTypeConstructorDeclarationImpl(this, localajcITD.targetType(), localajcITD.modifiers(), localMethod));
        }
        i += 1;
      }
      this.declaredITDCons = new InterTypeConstructorDeclaration[localArrayList.size()];
      localArrayList.toArray(this.declaredITDCons);
    }
    return this.declaredITDCons;
  }
  
  public InterTypeFieldDeclaration getDeclaredITDField(String paramString, AjType<?> paramAjType)
  {
    InterTypeFieldDeclaration[] arrayOfInterTypeFieldDeclaration = getDeclaredITDFields();
    int j = arrayOfInterTypeFieldDeclaration.length;
    int i = 0;
    while (i < j)
    {
      InterTypeFieldDeclaration localInterTypeFieldDeclaration = arrayOfInterTypeFieldDeclaration[i];
      if (localInterTypeFieldDeclaration.getName().equals(paramString)) {}
      try
      {
        boolean bool = localInterTypeFieldDeclaration.getTargetType().equals(paramAjType);
        if (bool) {
          return localInterTypeFieldDeclaration;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label60:
        break label60;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public InterTypeFieldDeclaration[] getDeclaredITDFields()
  {
    Object localObject1 = new ArrayList();
    if (this.declaredITDFields == null)
    {
      Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        ajcITD localajcITD;
        Object localObject2;
        if ((localMethod.isAnnotationPresent(ajcITD.class)) && (localMethod.getName().contains("ajc$interFieldInit")))
        {
          localajcITD = (ajcITD)localMethod.getAnnotation(ajcITD.class);
          localObject2 = localMethod.getName().replace("FieldInit", "FieldGetDispatch");
        }
        try
        {
          localObject2 = this.clazz.getDeclaredMethod((String)localObject2, localMethod.getParameterTypes());
          ((List)localObject1).add(new InterTypeFieldDeclarationImpl(this, localajcITD.targetType(), localajcITD.modifiers(), localajcITD.name(), AjTypeSystem.getAjType(((Method)localObject2).getReturnType()), ((Method)localObject2).getGenericReturnType()));
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          label162:
          break label162;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Can't find field get dispatch method for ");
        ((StringBuilder)localObject1).append(localMethod.getName());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
        i += 1;
      }
      addAnnotationStyleITDFields((List)localObject1, false);
      this.declaredITDFields = new InterTypeFieldDeclaration[((List)localObject1).size()];
      ((List)localObject1).toArray(this.declaredITDFields);
    }
    else
    {
      return this.declaredITDFields;
    }
  }
  
  public InterTypeMethodDeclaration getDeclaredITDMethod(String paramString, AjType<?> paramAjType, AjType<?>... paramVarArgs)
  {
    InterTypeMethodDeclaration[] arrayOfInterTypeMethodDeclaration = getDeclaredITDMethods();
    int k = arrayOfInterTypeMethodDeclaration.length;
    int i = 0;
    while (i < k)
    {
      InterTypeMethodDeclaration localInterTypeMethodDeclaration = arrayOfInterTypeMethodDeclaration[i];
      try
      {
        if ((localInterTypeMethodDeclaration.getName().equals(paramString)) && (localInterTypeMethodDeclaration.getTargetType().equals(paramAjType)))
        {
          AjType[] arrayOfAjType = localInterTypeMethodDeclaration.getParameterTypes();
          if (arrayOfAjType.length == paramVarArgs.length)
          {
            int j = 0;
            while (j < arrayOfAjType.length)
            {
              boolean bool = arrayOfAjType[j].equals(paramVarArgs[j]);
              if (!bool) {
                break label121;
              }
              j += 1;
            }
            return localInterTypeMethodDeclaration;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label121:
        break label121;
      }
      i += 1;
    }
    paramString = new NoSuchMethodException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public InterTypeMethodDeclaration[] getDeclaredITDMethods()
  {
    if (this.declaredITDMethods == null)
    {
      ArrayList localArrayList = new ArrayList();
      Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((localMethod.getName().contains("ajc$interMethodDispatch1$")) && (localMethod.isAnnotationPresent(ajcITD.class)))
        {
          ajcITD localajcITD = (ajcITD)localMethod.getAnnotation(ajcITD.class);
          localArrayList.add(new InterTypeMethodDeclarationImpl(this, localajcITD.targetType(), localajcITD.modifiers(), localajcITD.name(), localMethod));
        }
        i += 1;
      }
      addAnnotationStyleITDMethods(localArrayList, false);
      this.declaredITDMethods = new InterTypeMethodDeclaration[localArrayList.size()];
      localArrayList.toArray(this.declaredITDMethods);
    }
    return this.declaredITDMethods;
  }
  
  public Method getDeclaredMethod(String paramString, AjType<?>... paramVarArgs)
  {
    paramVarArgs = this.clazz.getDeclaredMethod(paramString, toClassArray(paramVarArgs));
    if (isReallyAMethod(paramVarArgs)) {
      return paramVarArgs;
    }
    throw new NoSuchMethodException(paramString);
  }
  
  public Method[] getDeclaredMethods()
  {
    Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (isReallyAMethod(localMethod)) {
        localArrayList.add(localMethod);
      }
      i += 1;
    }
    arrayOfMethod = new Method[localArrayList.size()];
    localArrayList.toArray(arrayOfMethod);
    return arrayOfMethod;
  }
  
  public org.aspectj.lang.reflect.Pointcut getDeclaredPointcut(String paramString)
  {
    org.aspectj.lang.reflect.Pointcut[] arrayOfPointcut = getDeclaredPointcuts();
    int j = arrayOfPointcut.length;
    int i = 0;
    while (i < j)
    {
      org.aspectj.lang.reflect.Pointcut localPointcut = arrayOfPointcut[i];
      if (localPointcut.getName().equals(paramString)) {
        return localPointcut;
      }
      i += 1;
    }
    paramString = new NoSuchPointcutException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public org.aspectj.lang.reflect.Pointcut[] getDeclaredPointcuts()
  {
    Object localObject1 = this.declaredPointcuts;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = new ArrayList();
    Object localObject2 = this.clazz.getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      org.aspectj.lang.reflect.Pointcut localPointcut = asPointcut(localObject2[i]);
      if (localPointcut != null) {
        ((List)localObject1).add(localPointcut);
      }
      i += 1;
    }
    localObject2 = new org.aspectj.lang.reflect.Pointcut[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject2);
    this.declaredPointcuts = ((org.aspectj.lang.reflect.Pointcut[])localObject2);
    return localObject2;
  }
  
  public AjType<?> getDeclaringType()
  {
    Class localClass = this.clazz.getDeclaringClass();
    if (localClass != null) {
      return new AjTypeImpl(localClass);
    }
    return null;
  }
  
  public Constructor getEnclosingConstructor()
  {
    return this.clazz.getEnclosingConstructor();
  }
  
  public Method getEnclosingMethod()
  {
    return this.clazz.getEnclosingMethod();
  }
  
  public AjType<?> getEnclosingType()
  {
    Class localClass = this.clazz.getEnclosingClass();
    if (localClass != null) {
      return new AjTypeImpl(localClass);
    }
    return null;
  }
  
  public T[] getEnumConstants()
  {
    return this.clazz.getEnumConstants();
  }
  
  public Field getField(String paramString)
  {
    Field localField = this.clazz.getField(paramString);
    if (!localField.getName().startsWith("ajc$")) {
      return localField;
    }
    throw new NoSuchFieldException(paramString);
  }
  
  public Field[] getFields()
  {
    Field[] arrayOfField = this.clazz.getFields();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((!localField.getName().startsWith("ajc$")) && (!localField.isAnnotationPresent(DeclareWarning.class)) && (!localField.isAnnotationPresent(DeclareError.class))) {
        localArrayList.add(localField);
      }
      i += 1;
    }
    arrayOfField = new Field[localArrayList.size()];
    localArrayList.toArray(arrayOfField);
    return arrayOfField;
  }
  
  public Type getGenericSupertype()
  {
    return this.clazz.getGenericSuperclass();
  }
  
  public InterTypeConstructorDeclaration getITDConstructor(AjType<?> paramAjType, AjType<?>... paramVarArgs)
  {
    InterTypeConstructorDeclaration[] arrayOfInterTypeConstructorDeclaration = getITDConstructors();
    int k = arrayOfInterTypeConstructorDeclaration.length;
    int i = 0;
    while (i < k)
    {
      InterTypeConstructorDeclaration localInterTypeConstructorDeclaration = arrayOfInterTypeConstructorDeclaration[i];
      try
      {
        if (localInterTypeConstructorDeclaration.getTargetType().equals(paramAjType))
        {
          AjType[] arrayOfAjType = localInterTypeConstructorDeclaration.getParameterTypes();
          if (arrayOfAjType.length == paramVarArgs.length)
          {
            int j = 0;
            while (j < arrayOfAjType.length)
            {
              boolean bool = arrayOfAjType[j].equals(paramVarArgs[j]);
              if (!bool) {
                break label101;
              }
              j += 1;
            }
            return localInterTypeConstructorDeclaration;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label101:
        break label101;
      }
      i += 1;
    }
    paramAjType = new NoSuchMethodException();
    for (;;)
    {
      throw paramAjType;
    }
  }
  
  public InterTypeConstructorDeclaration[] getITDConstructors()
  {
    if (this.itdCons == null)
    {
      ArrayList localArrayList = new ArrayList();
      Method[] arrayOfMethod = this.clazz.getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((localMethod.getName().contains("ajc$postInterConstructor")) && (localMethod.isAnnotationPresent(ajcITD.class)))
        {
          ajcITD localajcITD = (ajcITD)localMethod.getAnnotation(ajcITD.class);
          if (Modifier.isPublic(localajcITD.modifiers())) {
            localArrayList.add(new InterTypeConstructorDeclarationImpl(this, localajcITD.targetType(), localajcITD.modifiers(), localMethod));
          }
        }
        i += 1;
      }
      this.itdCons = new InterTypeConstructorDeclaration[localArrayList.size()];
      localArrayList.toArray(this.itdCons);
    }
    return this.itdCons;
  }
  
  public InterTypeFieldDeclaration getITDField(String paramString, AjType<?> paramAjType)
  {
    InterTypeFieldDeclaration[] arrayOfInterTypeFieldDeclaration = getITDFields();
    int j = arrayOfInterTypeFieldDeclaration.length;
    int i = 0;
    while (i < j)
    {
      InterTypeFieldDeclaration localInterTypeFieldDeclaration = arrayOfInterTypeFieldDeclaration[i];
      if (localInterTypeFieldDeclaration.getName().equals(paramString)) {}
      try
      {
        boolean bool = localInterTypeFieldDeclaration.getTargetType().equals(paramAjType);
        if (bool) {
          return localInterTypeFieldDeclaration;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label60:
        break label60;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public InterTypeFieldDeclaration[] getITDFields()
  {
    Object localObject1 = new ArrayList();
    if (this.itdFields == null)
    {
      Method[] arrayOfMethod = this.clazz.getMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        ajcITD localajcITD;
        Object localObject2;
        if (localMethod.isAnnotationPresent(ajcITD.class))
        {
          localajcITD = (ajcITD)localMethod.getAnnotation(ajcITD.class);
          if ((localMethod.getName().contains("ajc$interFieldInit")) && (Modifier.isPublic(localajcITD.modifiers()))) {
            localObject2 = localMethod.getName().replace("FieldInit", "FieldGetDispatch");
          }
        }
        try
        {
          localObject2 = localMethod.getDeclaringClass().getDeclaredMethod((String)localObject2, localMethod.getParameterTypes());
          ((List)localObject1).add(new InterTypeFieldDeclarationImpl(this, localajcITD.targetType(), localajcITD.modifiers(), localajcITD.name(), AjTypeSystem.getAjType(((Method)localObject2).getReturnType()), ((Method)localObject2).getGenericReturnType()));
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          label178:
          break label178;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Can't find field get dispatch method for ");
        ((StringBuilder)localObject1).append(localMethod.getName());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
        i += 1;
      }
      addAnnotationStyleITDFields((List)localObject1, true);
      this.itdFields = new InterTypeFieldDeclaration[((List)localObject1).size()];
      ((List)localObject1).toArray(this.itdFields);
    }
    else
    {
      return this.itdFields;
    }
  }
  
  public InterTypeMethodDeclaration getITDMethod(String paramString, AjType<?> paramAjType, AjType<?>... paramVarArgs)
  {
    InterTypeMethodDeclaration[] arrayOfInterTypeMethodDeclaration = getITDMethods();
    int k = arrayOfInterTypeMethodDeclaration.length;
    int i = 0;
    while (i < k)
    {
      InterTypeMethodDeclaration localInterTypeMethodDeclaration = arrayOfInterTypeMethodDeclaration[i];
      try
      {
        if ((localInterTypeMethodDeclaration.getName().equals(paramString)) && (localInterTypeMethodDeclaration.getTargetType().equals(paramAjType)))
        {
          AjType[] arrayOfAjType = localInterTypeMethodDeclaration.getParameterTypes();
          if (arrayOfAjType.length == paramVarArgs.length)
          {
            int j = 0;
            while (j < arrayOfAjType.length)
            {
              boolean bool = arrayOfAjType[j].equals(paramVarArgs[j]);
              if (!bool) {
                break label121;
              }
              j += 1;
            }
            return localInterTypeMethodDeclaration;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        label121:
        break label121;
      }
      i += 1;
    }
    paramString = new NoSuchMethodException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public InterTypeMethodDeclaration[] getITDMethods()
  {
    if (this.itdMethods == null)
    {
      ArrayList localArrayList = new ArrayList();
      Method[] arrayOfMethod = this.clazz.getDeclaredMethods();
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((localMethod.getName().contains("ajc$interMethod$")) && (localMethod.isAnnotationPresent(ajcITD.class)))
        {
          ajcITD localajcITD = (ajcITD)localMethod.getAnnotation(ajcITD.class);
          if (Modifier.isPublic(localajcITD.modifiers())) {
            localArrayList.add(new InterTypeMethodDeclarationImpl(this, localajcITD.targetType(), localajcITD.modifiers(), localajcITD.name(), localMethod));
          }
        }
        i += 1;
      }
      addAnnotationStyleITDMethods(localArrayList, true);
      this.itdMethods = new InterTypeMethodDeclaration[localArrayList.size()];
      localArrayList.toArray(this.itdMethods);
    }
    return this.itdMethods;
  }
  
  public AjType<?>[] getInterfaces()
  {
    return toAjTypeArray(this.clazz.getInterfaces());
  }
  
  public Class<T> getJavaClass()
  {
    return this.clazz;
  }
  
  public Method getMethod(String paramString, AjType<?>... paramVarArgs)
  {
    paramVarArgs = this.clazz.getMethod(paramString, toClassArray(paramVarArgs));
    if (isReallyAMethod(paramVarArgs)) {
      return paramVarArgs;
    }
    throw new NoSuchMethodException(paramString);
  }
  
  public Method[] getMethods()
  {
    Method[] arrayOfMethod = this.clazz.getMethods();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (isReallyAMethod(localMethod)) {
        localArrayList.add(localMethod);
      }
      i += 1;
    }
    arrayOfMethod = new Method[localArrayList.size()];
    localArrayList.toArray(arrayOfMethod);
    return arrayOfMethod;
  }
  
  public int getModifiers()
  {
    return this.clazz.getModifiers();
  }
  
  public String getName()
  {
    return this.clazz.getName();
  }
  
  public Package getPackage()
  {
    return this.clazz.getPackage();
  }
  
  public PerClause getPerClause()
  {
    if (isAspect())
    {
      String str = ((Aspect)this.clazz.getAnnotation(Aspect.class)).value();
      if (str.equals(""))
      {
        if (getSupertype().isAspect()) {
          return getSupertype().getPerClause();
        }
        return new PerClauseImpl(PerClauseKind.SINGLETON);
      }
      if (str.startsWith("perthis(")) {
        return new PointcutBasedPerClauseImpl(PerClauseKind.PERTHIS, str.substring(8, str.length() - 1));
      }
      if (str.startsWith("pertarget(")) {
        return new PointcutBasedPerClauseImpl(PerClauseKind.PERTARGET, str.substring(10, str.length() - 1));
      }
      if (str.startsWith("percflow(")) {
        return new PointcutBasedPerClauseImpl(PerClauseKind.PERCFLOW, str.substring(9, str.length() - 1));
      }
      if (str.startsWith("percflowbelow(")) {
        return new PointcutBasedPerClauseImpl(PerClauseKind.PERCFLOWBELOW, str.substring(14, str.length() - 1));
      }
      if (str.startsWith("pertypewithin")) {
        return new TypePatternBasedPerClauseImpl(PerClauseKind.PERTYPEWITHIN, str.substring(14, str.length() - 1));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Per-clause not recognized: ");
      localStringBuilder.append(str);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    return null;
  }
  
  public org.aspectj.lang.reflect.Pointcut getPointcut(String paramString)
  {
    org.aspectj.lang.reflect.Pointcut[] arrayOfPointcut = getPointcuts();
    int j = arrayOfPointcut.length;
    int i = 0;
    while (i < j)
    {
      org.aspectj.lang.reflect.Pointcut localPointcut = arrayOfPointcut[i];
      if (localPointcut.getName().equals(paramString)) {
        return localPointcut;
      }
      i += 1;
    }
    paramString = new NoSuchPointcutException(paramString);
    for (;;)
    {
      throw paramString;
    }
  }
  
  public org.aspectj.lang.reflect.Pointcut[] getPointcuts()
  {
    Object localObject1 = this.pointcuts;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = new ArrayList();
    Object localObject2 = this.clazz.getMethods();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      org.aspectj.lang.reflect.Pointcut localPointcut = asPointcut(localObject2[i]);
      if (localPointcut != null) {
        ((List)localObject1).add(localPointcut);
      }
      i += 1;
    }
    localObject2 = new org.aspectj.lang.reflect.Pointcut[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject2);
    this.pointcuts = ((org.aspectj.lang.reflect.Pointcut[])localObject2);
    return localObject2;
  }
  
  public AjType<? super T> getSupertype()
  {
    Class localClass = this.clazz.getSuperclass();
    if (localClass == null) {
      return null;
    }
    return new AjTypeImpl(localClass);
  }
  
  public TypeVariable<Class<T>>[] getTypeParameters()
  {
    return this.clazz.getTypeParameters();
  }
  
  public int hashCode()
  {
    return this.clazz.hashCode();
  }
  
  public boolean isAnnotationPresent(Class<? extends Annotation> paramClass)
  {
    return this.clazz.isAnnotationPresent(paramClass);
  }
  
  public boolean isArray()
  {
    return this.clazz.isArray();
  }
  
  public boolean isAspect()
  {
    return this.clazz.getAnnotation(Aspect.class) != null;
  }
  
  public boolean isEnum()
  {
    return this.clazz.isEnum();
  }
  
  public boolean isInstance(Object paramObject)
  {
    return this.clazz.isInstance(paramObject);
  }
  
  public boolean isInterface()
  {
    return this.clazz.isInterface();
  }
  
  public boolean isLocalClass()
  {
    return (this.clazz.isLocalClass()) && (!isAspect());
  }
  
  public boolean isMemberAspect()
  {
    return (this.clazz.isMemberClass()) && (isAspect());
  }
  
  public boolean isMemberClass()
  {
    return (this.clazz.isMemberClass()) && (!isAspect());
  }
  
  public boolean isPrimitive()
  {
    return this.clazz.isPrimitive();
  }
  
  public boolean isPrivileged()
  {
    return (isAspect()) && (this.clazz.isAnnotationPresent(ajcPrivileged.class));
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.AjTypeImpl
 * JD-Core Version:    0.7.0.1
 */