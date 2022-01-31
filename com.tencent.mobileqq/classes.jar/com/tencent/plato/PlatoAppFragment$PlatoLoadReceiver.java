package com.tencent.plato;

import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class PlatoAppFragment$PlatoLoadReceiver
  extends QQUIEventReceiver
{
  public PlatoAppFragment$PlatoLoadReceiver(@NonNull PlatoAppFragment paramPlatoAppFragment)
  {
    super(paramPlatoAppFragment);
  }
  
  public void a(@NonNull PlatoAppFragment paramPlatoAppFragment, @NonNull PlatoLoadEvent paramPlatoLoadEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlatoAppActivity", 2, "receive event:" + paramPlatoLoadEvent.toString());
    }
    if (paramPlatoLoadEvent.jdField_b_of_type_Int == 0)
    {
      paramPlatoAppFragment.jdField_a_of_type_Int = paramPlatoLoadEvent.jdField_a_of_type_Int;
      paramPlatoAppFragment.b();
    }
    if ((paramPlatoLoadEvent.jdField_b_of_type_Int == 1) && (paramPlatoAppFragment.jdField_a_of_type_JavaLangString.equals(paramPlatoLoadEvent.jdField_a_of_type_JavaLangString)))
    {
      paramPlatoAppFragment.jdField_b_of_type_Int = paramPlatoLoadEvent.jdField_a_of_type_Int;
      paramPlatoAppFragment.jdField_b_of_type_JavaLangString = paramPlatoLoadEvent.jdField_b_of_type_JavaLangString;
      paramPlatoAppFragment.b();
    }
  }
  
  public Class acceptEventClass()
  {
    return PlatoLoadEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.plato.PlatoAppFragment.PlatoLoadReceiver
 * JD-Core Version:    0.7.0.1
 */