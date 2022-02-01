package org.aspectj.runtime.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.EnclosingStaticPart;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.AdviceSignature;
import org.aspectj.lang.reflect.CatchClauseSignature;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.FieldSignature;
import org.aspectj.lang.reflect.InitializerSignature;
import org.aspectj.lang.reflect.LockSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.lang.reflect.UnlockSignature;

public final class Factory
{
  private static Object[] NO_ARGS = new Object[0];
  private static final String[] NO_STRINGS;
  private static final Class[] NO_TYPES = new Class[0];
  static Hashtable prims;
  int count;
  String filename;
  Class lexicalClass;
  ClassLoader lookupClassLoader;
  
  static
  {
    NO_STRINGS = new String[0];
    prims = new Hashtable();
    prims.put("void", Void.TYPE);
    prims.put("boolean", Boolean.TYPE);
    prims.put("byte", Byte.TYPE);
    prims.put("char", Character.TYPE);
    prims.put("short", Short.TYPE);
    prims.put("int", Integer.TYPE);
    prims.put("long", Long.TYPE);
    prims.put("float", Float.TYPE);
    prims.put("double", Double.TYPE);
  }
  
  public Factory(String paramString, Class paramClass)
  {
    this.filename = paramString;
    this.lexicalClass = paramClass;
    this.count = 0;
    this.lookupClassLoader = paramClass.getClassLoader();
  }
  
  static Class makeClass(String paramString, ClassLoader paramClassLoader)
  {
    if (paramString.equals("*")) {
      return null;
    }
    Class localClass = (Class)prims.get(paramString);
    if (localClass != null) {
      return localClass;
    }
    if (paramClassLoader == null) {}
    try
    {
      return Class.forName(paramString);
    }
    catch (ClassNotFoundException paramString)
    {
      break label46;
    }
    paramString = Class.forName(paramString, false, paramClassLoader);
    return paramString;
    label46:
    return ClassNotFoundException.class;
  }
  
  public static JoinPoint.StaticPart makeEncSJP(Member paramMember)
  {
    String str;
    if ((paramMember instanceof Method))
    {
      paramMember = (Method)paramMember;
      paramMember = new MethodSignatureImpl(paramMember.getModifiers(), paramMember.getName(), paramMember.getDeclaringClass(), paramMember.getParameterTypes(), new String[paramMember.getParameterTypes().length], paramMember.getExceptionTypes(), paramMember.getReturnType());
      str = "method-execution";
    }
    else
    {
      if (!(paramMember instanceof Constructor)) {
        break label117;
      }
      paramMember = (Constructor)paramMember;
      paramMember = new ConstructorSignatureImpl(paramMember.getModifiers(), paramMember.getDeclaringClass(), paramMember.getParameterTypes(), new String[paramMember.getParameterTypes().length], paramMember.getExceptionTypes());
      str = "constructor-execution";
    }
    return new JoinPointImpl.EnclosingStaticPartImpl(-1, str, paramMember, null);
    label117:
    throw new IllegalArgumentException("member must be either a method or constructor");
  }
  
  public static JoinPoint makeJP(JoinPoint.StaticPart paramStaticPart, Object paramObject1, Object paramObject2)
  {
    return new JoinPointImpl(paramStaticPart, paramObject1, paramObject2, NO_ARGS);
  }
  
  public static JoinPoint makeJP(JoinPoint.StaticPart paramStaticPart, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new JoinPointImpl(paramStaticPart, paramObject1, paramObject2, new Object[] { paramObject3 });
  }
  
  public static JoinPoint makeJP(JoinPoint.StaticPart paramStaticPart, Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    return new JoinPointImpl(paramStaticPart, paramObject1, paramObject2, new Object[] { paramObject3, paramObject4 });
  }
  
  public static JoinPoint makeJP(JoinPoint.StaticPart paramStaticPart, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject)
  {
    return new JoinPointImpl(paramStaticPart, paramObject1, paramObject2, paramArrayOfObject);
  }
  
  public JoinPoint.EnclosingStaticPart makeAdviceESJP(String paramString1, int paramInt1, String paramString2, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2, int paramInt2)
  {
    if (paramArrayOfClass1 == null) {
      paramArrayOfClass1 = NO_TYPES;
    }
    if (paramArrayOfString == null) {
      paramArrayOfString = NO_STRINGS;
    }
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass2 = NO_TYPES;
    }
    if (paramClass2 == null) {
      paramClass2 = Void.TYPE;
    }
    paramString2 = new AdviceSignatureImpl(paramInt1, paramString2, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2, paramClass2);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(paramInt1, paramString1, paramString2, makeSourceLoc(paramInt2, -1));
  }
  
  public JoinPoint.StaticPart makeAdviceSJP(String paramString1, int paramInt1, String paramString2, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2, int paramInt2)
  {
    if (paramArrayOfClass1 == null) {
      paramArrayOfClass1 = NO_TYPES;
    }
    if (paramArrayOfString == null) {
      paramArrayOfString = NO_STRINGS;
    }
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass2 = NO_TYPES;
    }
    if (paramClass2 == null) {
      paramClass2 = Void.TYPE;
    }
    paramString2 = new AdviceSignatureImpl(paramInt1, paramString2, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2, paramClass2);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.StaticPartImpl(paramInt1, paramString1, paramString2, makeSourceLoc(paramInt2, -1));
  }
  
  public AdviceSignature makeAdviceSig(int paramInt, String paramString, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2)
  {
    paramString = new AdviceSignatureImpl(paramInt, paramString, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2, paramClass2);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public AdviceSignature makeAdviceSig(String paramString)
  {
    paramString = new AdviceSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public AdviceSignature makeAdviceSig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    int k = Integer.parseInt(paramString1, 16);
    paramString1 = makeClass(paramString3, this.lookupClassLoader);
    paramString4 = new StringTokenizer(paramString4, ":");
    int m = paramString4.countTokens();
    paramString3 = new Class[m];
    int j = 0;
    int i = 0;
    while (i < m)
    {
      paramString3[i] = makeClass(paramString4.nextToken(), this.lookupClassLoader);
      i += 1;
    }
    paramString5 = new StringTokenizer(paramString5, ":");
    m = paramString5.countTokens();
    paramString4 = new String[m];
    i = 0;
    while (i < m)
    {
      paramString4[i] = paramString5.nextToken();
      i += 1;
    }
    paramString5 = new StringTokenizer(paramString6, ":");
    m = paramString5.countTokens();
    paramString6 = new Class[m];
    i = j;
    while (i < m)
    {
      paramString6[i] = makeClass(paramString5.nextToken(), this.lookupClassLoader);
      i += 1;
    }
    paramString1 = new AdviceSignatureImpl(k, paramString2, paramString1, paramString3, paramString4, paramString6, makeClass(paramString7, this.lookupClassLoader));
    paramString1.setLookupClassLoader(this.lookupClassLoader);
    return paramString1;
  }
  
  public JoinPoint.EnclosingStaticPart makeCatchClauseESJP(String paramString1, Class paramClass1, Class paramClass2, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramClass1 = new CatchClauseSignatureImpl(paramClass1, paramClass2, str);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(i, paramString1, paramClass1, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.StaticPart makeCatchClauseSJP(String paramString1, Class paramClass1, Class paramClass2, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramClass1 = new CatchClauseSignatureImpl(paramClass1, paramClass2, str);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString1, paramClass1, makeSourceLoc(paramInt, -1));
  }
  
  public CatchClauseSignature makeCatchClauseSig(Class paramClass1, Class paramClass2, String paramString)
  {
    paramClass1 = new CatchClauseSignatureImpl(paramClass1, paramClass2, paramString);
    paramClass1.setLookupClassLoader(this.lookupClassLoader);
    return paramClass1;
  }
  
  public CatchClauseSignature makeCatchClauseSig(String paramString)
  {
    paramString = new CatchClauseSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public CatchClauseSignature makeCatchClauseSig(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new CatchClauseSignatureImpl(makeClass(paramString1, this.lookupClassLoader), makeClass(new StringTokenizer(paramString2, ":").nextToken(), this.lookupClassLoader), new StringTokenizer(paramString3, ":").nextToken());
    paramString1.setLookupClassLoader(this.lookupClassLoader);
    return paramString1;
  }
  
  public JoinPoint.EnclosingStaticPart makeConstructorESJP(String paramString, int paramInt1, Class paramClass, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, int paramInt2)
  {
    Class[] arrayOfClass = paramArrayOfClass1;
    if (paramArrayOfClass1 == null) {
      arrayOfClass = NO_TYPES;
    }
    paramArrayOfClass1 = paramArrayOfString;
    if (paramArrayOfString == null) {
      paramArrayOfClass1 = NO_STRINGS;
    }
    paramArrayOfString = paramArrayOfClass2;
    if (paramArrayOfClass2 == null) {
      paramArrayOfString = NO_TYPES;
    }
    paramClass = new ConstructorSignatureImpl(paramInt1, paramClass, arrayOfClass, paramArrayOfClass1, paramArrayOfString);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(paramInt1, paramString, paramClass, makeSourceLoc(paramInt2, -1));
  }
  
  public JoinPoint.StaticPart makeConstructorSJP(String paramString, int paramInt1, Class paramClass, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, int paramInt2)
  {
    Class[] arrayOfClass = paramArrayOfClass1;
    if (paramArrayOfClass1 == null) {
      arrayOfClass = NO_TYPES;
    }
    paramArrayOfClass1 = paramArrayOfString;
    if (paramArrayOfString == null) {
      paramArrayOfClass1 = NO_STRINGS;
    }
    paramArrayOfString = paramArrayOfClass2;
    if (paramArrayOfClass2 == null) {
      paramArrayOfString = NO_TYPES;
    }
    paramClass = new ConstructorSignatureImpl(paramInt1, paramClass, arrayOfClass, paramArrayOfClass1, paramArrayOfString);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.StaticPartImpl(paramInt1, paramString, paramClass, makeSourceLoc(paramInt2, -1));
  }
  
  public ConstructorSignature makeConstructorSig(int paramInt, Class paramClass, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2)
  {
    paramClass = new ConstructorSignatureImpl(paramInt, paramClass, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2);
    paramClass.setLookupClassLoader(this.lookupClassLoader);
    return paramClass;
  }
  
  public ConstructorSignature makeConstructorSig(String paramString)
  {
    paramString = new ConstructorSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public ConstructorSignature makeConstructorSig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int k = Integer.parseInt(paramString1, 16);
    paramString1 = makeClass(paramString2, this.lookupClassLoader);
    paramString3 = new StringTokenizer(paramString3, ":");
    int m = paramString3.countTokens();
    paramString2 = new Class[m];
    int j = 0;
    int i = 0;
    while (i < m)
    {
      paramString2[i] = makeClass(paramString3.nextToken(), this.lookupClassLoader);
      i += 1;
    }
    paramString4 = new StringTokenizer(paramString4, ":");
    m = paramString4.countTokens();
    paramString3 = new String[m];
    i = 0;
    while (i < m)
    {
      paramString3[i] = paramString4.nextToken();
      i += 1;
    }
    paramString4 = new StringTokenizer(paramString5, ":");
    m = paramString4.countTokens();
    paramString5 = new Class[m];
    i = j;
    while (i < m)
    {
      paramString5[i] = makeClass(paramString4.nextToken(), this.lookupClassLoader);
      i += 1;
    }
    paramString1 = new ConstructorSignatureImpl(k, paramString1, paramString2, paramString3, paramString5);
    paramString1.setLookupClassLoader(this.lookupClassLoader);
    return paramString1;
  }
  
  public JoinPoint.EnclosingStaticPart makeESJP(String paramString, Signature paramSignature, int paramInt)
  {
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(i, paramString, paramSignature, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.EnclosingStaticPart makeESJP(String paramString, Signature paramSignature, int paramInt1, int paramInt2)
  {
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(i, paramString, paramSignature, makeSourceLoc(paramInt1, paramInt2));
  }
  
  public JoinPoint.EnclosingStaticPart makeESJP(String paramString, Signature paramSignature, SourceLocation paramSourceLocation)
  {
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(i, paramString, paramSignature, paramSourceLocation);
  }
  
  public JoinPoint.EnclosingStaticPart makeFieldESJP(String paramString1, int paramInt1, String paramString2, Class paramClass1, Class paramClass2, int paramInt2)
  {
    paramString2 = new FieldSignatureImpl(paramInt1, paramString2, paramClass1, paramClass2);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(paramInt1, paramString1, paramString2, makeSourceLoc(paramInt2, -1));
  }
  
  public JoinPoint.StaticPart makeFieldSJP(String paramString1, int paramInt1, String paramString2, Class paramClass1, Class paramClass2, int paramInt2)
  {
    paramString2 = new FieldSignatureImpl(paramInt1, paramString2, paramClass1, paramClass2);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.StaticPartImpl(paramInt1, paramString1, paramString2, makeSourceLoc(paramInt2, -1));
  }
  
  public FieldSignature makeFieldSig(int paramInt, String paramString, Class paramClass1, Class paramClass2)
  {
    paramString = new FieldSignatureImpl(paramInt, paramString, paramClass1, paramClass2);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public FieldSignature makeFieldSig(String paramString)
  {
    paramString = new FieldSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public FieldSignature makeFieldSig(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = new FieldSignatureImpl(Integer.parseInt(paramString1, 16), paramString2, makeClass(paramString3, this.lookupClassLoader), makeClass(paramString4, this.lookupClassLoader));
    paramString1.setLookupClassLoader(this.lookupClassLoader);
    return paramString1;
  }
  
  public JoinPoint.EnclosingStaticPart makeInitializerESJP(String paramString, int paramInt1, Class paramClass, int paramInt2)
  {
    paramClass = new InitializerSignatureImpl(paramInt1, paramClass);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(paramInt1, paramString, paramClass, makeSourceLoc(paramInt2, -1));
  }
  
  public JoinPoint.StaticPart makeInitializerSJP(String paramString, int paramInt1, Class paramClass, int paramInt2)
  {
    paramClass = new InitializerSignatureImpl(paramInt1, paramClass);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.StaticPartImpl(paramInt1, paramString, paramClass, makeSourceLoc(paramInt2, -1));
  }
  
  public InitializerSignature makeInitializerSig(int paramInt, Class paramClass)
  {
    paramClass = new InitializerSignatureImpl(paramInt, paramClass);
    paramClass.setLookupClassLoader(this.lookupClassLoader);
    return paramClass;
  }
  
  public InitializerSignature makeInitializerSig(String paramString)
  {
    paramString = new InitializerSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public InitializerSignature makeInitializerSig(String paramString1, String paramString2)
  {
    paramString1 = new InitializerSignatureImpl(Integer.parseInt(paramString1, 16), makeClass(paramString2, this.lookupClassLoader));
    paramString1.setLookupClassLoader(this.lookupClassLoader);
    return paramString1;
  }
  
  public JoinPoint.EnclosingStaticPart makeLockESJP(String paramString, Class paramClass, int paramInt)
  {
    paramClass = new LockSignatureImpl(paramClass);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(i, paramString, paramClass, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.StaticPart makeLockSJP(String paramString, Class paramClass, int paramInt)
  {
    paramClass = new LockSignatureImpl(paramClass);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString, paramClass, makeSourceLoc(paramInt, -1));
  }
  
  public LockSignature makeLockSig()
  {
    LockSignatureImpl localLockSignatureImpl = new LockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
    localLockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
    return localLockSignatureImpl;
  }
  
  public LockSignature makeLockSig(Class paramClass)
  {
    paramClass = new LockSignatureImpl(paramClass);
    paramClass.setLookupClassLoader(this.lookupClassLoader);
    return paramClass;
  }
  
  public LockSignature makeLockSig(String paramString)
  {
    paramString = new LockSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public JoinPoint.EnclosingStaticPart makeMethodESJP(String paramString1, int paramInt1, String paramString2, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2, int paramInt2)
  {
    if (paramArrayOfClass1 == null) {
      paramArrayOfClass1 = NO_TYPES;
    }
    if (paramArrayOfString == null) {
      paramArrayOfString = NO_STRINGS;
    }
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass2 = NO_TYPES;
    }
    if (paramClass2 == null) {
      paramClass2 = Void.TYPE;
    }
    paramString2 = makeMethodSig(paramInt1, paramString2, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2, paramClass2);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(paramInt1, paramString1, paramString2, makeSourceLoc(paramInt2, -1));
  }
  
  public JoinPoint.StaticPart makeMethodSJP(String paramString1, int paramInt1, String paramString2, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2, int paramInt2)
  {
    if (paramArrayOfClass1 == null) {
      paramArrayOfClass1 = NO_TYPES;
    }
    if (paramArrayOfString == null) {
      paramArrayOfString = NO_STRINGS;
    }
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass2 = NO_TYPES;
    }
    if (paramClass2 == null) {
      paramClass2 = Void.TYPE;
    }
    paramString2 = makeMethodSig(paramInt1, paramString2, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2, paramClass2);
    paramInt1 = this.count;
    this.count = (paramInt1 + 1);
    return new JoinPointImpl.StaticPartImpl(paramInt1, paramString1, paramString2, makeSourceLoc(paramInt2, -1));
  }
  
  public MethodSignature makeMethodSig(int paramInt, String paramString, Class paramClass1, Class[] paramArrayOfClass1, String[] paramArrayOfString, Class[] paramArrayOfClass2, Class paramClass2)
  {
    if (paramArrayOfClass1 == null) {
      paramArrayOfClass1 = NO_TYPES;
    }
    if (paramArrayOfClass2 == null) {
      paramArrayOfClass2 = NO_TYPES;
    }
    paramString = new MethodSignatureImpl(paramInt, paramString, paramClass1, paramArrayOfClass1, paramArrayOfString, paramArrayOfClass2, paramClass2);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public MethodSignature makeMethodSig(String paramString)
  {
    paramString = new MethodSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
  
  public MethodSignature makeMethodSig(String paramString1, String paramString2, Class paramClass, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    int k = Integer.parseInt(paramString1, 16);
    paramString3 = new StringTokenizer(paramString3, ":");
    int m = paramString3.countTokens();
    paramString1 = new Class[m];
    int j = 0;
    int i = 0;
    while (i < m)
    {
      paramString1[i] = makeClass(paramString3.nextToken(), this.lookupClassLoader);
      i += 1;
    }
    paramString4 = new StringTokenizer(paramString4, ":");
    m = paramString4.countTokens();
    paramString3 = new String[m];
    i = 0;
    while (i < m)
    {
      paramString3[i] = paramString4.nextToken();
      i += 1;
    }
    paramString4 = new StringTokenizer(paramString5, ":");
    m = paramString4.countTokens();
    paramString5 = new Class[m];
    i = j;
    while (i < m)
    {
      paramString5[i] = makeClass(paramString4.nextToken(), this.lookupClassLoader);
      i += 1;
    }
    return new MethodSignatureImpl(k, paramString2, paramClass, paramString1, paramString3, paramString5, makeClass(paramString6, this.lookupClassLoader));
  }
  
  public MethodSignature makeMethodSig(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return makeMethodSig(paramString1, paramString2, makeClass(paramString3, this.lookupClassLoader), paramString4, paramString5, paramString6, paramString7);
  }
  
  public JoinPoint.StaticPart makeSJP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    paramString2 = makeMethodSig(paramString2, paramString3, paramString4, paramString5, paramString6, "", paramString7);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString1, paramString2, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.StaticPart makeSJP(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    paramString2 = makeMethodSig(paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString1, paramString2, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.StaticPart makeSJP(String paramString, Signature paramSignature, int paramInt)
  {
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString, paramSignature, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.StaticPart makeSJP(String paramString, Signature paramSignature, int paramInt1, int paramInt2)
  {
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString, paramSignature, makeSourceLoc(paramInt1, paramInt2));
  }
  
  public JoinPoint.StaticPart makeSJP(String paramString, Signature paramSignature, SourceLocation paramSourceLocation)
  {
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString, paramSignature, paramSourceLocation);
  }
  
  public SourceLocation makeSourceLoc(int paramInt1, int paramInt2)
  {
    return new SourceLocationImpl(this.lexicalClass, this.filename, paramInt1);
  }
  
  public JoinPoint.EnclosingStaticPart makeUnlockESJP(String paramString, Class paramClass, int paramInt)
  {
    paramClass = new UnlockSignatureImpl(paramClass);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.EnclosingStaticPartImpl(i, paramString, paramClass, makeSourceLoc(paramInt, -1));
  }
  
  public JoinPoint.StaticPart makeUnlockSJP(String paramString, Class paramClass, int paramInt)
  {
    paramClass = new UnlockSignatureImpl(paramClass);
    int i = this.count;
    this.count = (i + 1);
    return new JoinPointImpl.StaticPartImpl(i, paramString, paramClass, makeSourceLoc(paramInt, -1));
  }
  
  public UnlockSignature makeUnlockSig()
  {
    UnlockSignatureImpl localUnlockSignatureImpl = new UnlockSignatureImpl(makeClass("Ljava/lang/Object;", this.lookupClassLoader));
    localUnlockSignatureImpl.setLookupClassLoader(this.lookupClassLoader);
    return localUnlockSignatureImpl;
  }
  
  public UnlockSignature makeUnlockSig(Class paramClass)
  {
    paramClass = new UnlockSignatureImpl(paramClass);
    paramClass.setLookupClassLoader(this.lookupClassLoader);
    return paramClass;
  }
  
  public UnlockSignature makeUnlockSig(String paramString)
  {
    paramString = new UnlockSignatureImpl(paramString);
    paramString.setLookupClassLoader(this.lookupClassLoader);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.Factory
 * JD-Core Version:    0.7.0.1
 */