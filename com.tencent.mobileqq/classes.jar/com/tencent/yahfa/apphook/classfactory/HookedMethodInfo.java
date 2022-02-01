package com.tencent.yahfa.apphook.classfactory;

import com.taobao.android.dexposed.XC_MethodHook;
import com.taobao.android.dexposed.YahfaHelpers;
import com.tencent.qa.apphook.util.BasicType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class HookedMethodInfo
{
  private boolean _hasReturn = false;
  private boolean _hasThrowable = false;
  private boolean _isStatic = false;
  private XC_MethodHook callBack = null;
  private Constructor<?> constructor = null;
  private Member member = null;
  private Method method = null;
  private Class<?>[] paramClasses;
  private BasicType retBasicType = null;
  
  public HookedMethodInfo(Member paramMember, XC_MethodHook paramXC_MethodHook)
  {
    this.member = paramMember;
    this.callBack = paramXC_MethodHook;
    if ((paramMember instanceof Method))
    {
      this.method = ((Method)paramMember);
      this.constructor = null;
      this._isStatic = Modifier.isStatic(this.method.getModifiers());
      this.paramClasses = this.method.getParameterTypes();
      if (!this.method.getReturnType().equals(Void.TYPE))
      {
        bool1 = true;
        this._hasReturn = bool1;
        if (!this._hasReturn) {
          break label173;
        }
        this.retBasicType = YahfaHelpers.getBasicTypeIfIs(this.method.getReturnType());
        label148:
        if (this.method.getExceptionTypes().length == 0) {
          break label181;
        }
      }
      label173:
      label181:
      for (bool1 = bool2;; bool1 = false)
      {
        this._hasThrowable = bool1;
        return;
        bool1 = false;
        break;
        this.retBasicType = null;
        break label148;
      }
    }
    if ((paramMember instanceof Constructor))
    {
      this.constructor = ((Constructor)paramMember);
      this.method = null;
      this._isStatic = false;
      this._hasReturn = false;
      this.retBasicType = null;
      this.paramClasses = this.constructor.getParameterTypes();
      if (this.constructor.getExceptionTypes().length != 0) {}
      for (;;)
      {
        this._hasThrowable = bool1;
        return;
        bool1 = false;
      }
    }
    if (paramMember.getDeclaringClass().isInterface()) {
      throw new IllegalArgumentException("Cannot hook interfaces: " + paramMember.toString());
    }
    if (Modifier.isAbstract(paramMember.getModifiers())) {
      throw new IllegalArgumentException("Cannot hook abstract methods: " + paramMember.toString());
    }
    throw new IllegalArgumentException("Only methods and constructors can be hooked: " + paramMember.toString());
  }
  
  public XC_MethodHook getCallback()
  {
    return this.callBack;
  }
  
  public Constructor<?> getConstructor()
  {
    return this.constructor;
  }
  
  public Member getMember()
  {
    return this.member;
  }
  
  public Method getMethod()
  {
    return this.method;
  }
  
  public Class<?>[] getParamClasses()
  {
    return this.paramClasses;
  }
  
  public int getParamNo()
  {
    return this.paramClasses.length;
  }
  
  public boolean hasReturn()
  {
    return this._hasReturn;
  }
  
  public boolean hasThrowable()
  {
    return this._hasThrowable;
  }
  
  public boolean isStatic()
  {
    return this._isStatic;
  }
  
  public void setCallBack(XC_MethodHook paramXC_MethodHook)
  {
    this.callBack = paramXC_MethodHook;
  }
  
  public String toString()
  {
    return "HookedMethodInfo [member=" + this.member + ", callBack=" + this.callBack + ", method=" + this.method + ", constructor=" + this.constructor + ", _isStatic=" + this._isStatic + ", _hasReturn=" + this._hasReturn + ", retBasicType=" + this.retBasicType + ", _hasThrowable=" + this._hasThrowable + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.classfactory.HookedMethodInfo
 * JD-Core Version:    0.7.0.1
 */