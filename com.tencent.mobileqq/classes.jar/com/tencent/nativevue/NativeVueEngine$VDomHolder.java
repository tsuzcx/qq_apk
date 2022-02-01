package com.tencent.nativevue;

import java.lang.ref.WeakReference;

class NativeVueEngine$VDomHolder
{
  int converterType;
  String data;
  WeakReference<NativeVueEngine.DomResult> domResultRef;
  String vueDom;
  
  public NativeVueEngine$VDomHolder(String paramString1, String paramString2, int paramInt, NativeVueEngine.DomResult paramDomResult)
  {
    this.data = paramString1;
    this.vueDom = paramString2;
    this.converterType = paramInt;
    this.domResultRef = new WeakReference(paramDomResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.nativevue.NativeVueEngine.VDomHolder
 * JD-Core Version:    0.7.0.1
 */