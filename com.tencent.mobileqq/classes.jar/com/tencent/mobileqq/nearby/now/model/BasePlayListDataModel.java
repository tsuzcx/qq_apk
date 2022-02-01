package com.tencent.mobileqq.nearby.now.model;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

public abstract class BasePlayListDataModel
{
  protected int a;
  public AppInterface a;
  protected BasePlayListDataModel.OnDataComeListener a;
  protected ArrayList<VideoData> a;
  protected boolean a;
  
  public BasePlayListDataModel()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ArrayList<VideoData> a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.model.BasePlayListDataModel
 * JD-Core Version:    0.7.0.1
 */