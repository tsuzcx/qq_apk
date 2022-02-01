package com.tencent.mobileqq.scribble;

import android.view.View;
import java.lang.ref.WeakReference;

class ScribbleResMgr$CallbackPack
{
  int jdField_a_of_type_Int;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  int jdField_b_of_type_Int;
  WeakReference<ScribbleResMgr.ResCallback> jdField_b_of_type_JavaLangRefWeakReference;
  
  public ScribbleResMgr$CallbackPack(ScribbleResMgr paramScribbleResMgr, int paramInt1, int paramInt2, View paramView, ScribbleResMgr.ResCallback paramResCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramResCallback);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ScribbleResMgr.ResCallback a()
  {
    return (ScribbleResMgr.ResCallback)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.CallbackPack
 * JD-Core Version:    0.7.0.1
 */