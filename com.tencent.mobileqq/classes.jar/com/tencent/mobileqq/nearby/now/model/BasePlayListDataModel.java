package com.tencent.mobileqq.nearby.now.model;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public abstract class BasePlayListDataModel
{
  public int a;
  public QQAppInterface a;
  public BasePlayListDataModel.OnDataComeListener a;
  public ArrayList a;
  public boolean a;
  
  public BasePlayListDataModel()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(BasePlayListDataModel.OnDataComeListener paramOnDataComeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelBasePlayListDataModel$OnDataComeListener = paramOnDataComeListener;
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel
 * JD-Core Version:    0.7.0.1
 */