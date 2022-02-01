package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import mqq.app.AppRuntime;

public class VasRes
  implements Handler.Callback, AbsVasRes
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private VasResAdapter jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter;
  private VasResController jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController;
  
  public VasRes(AppRuntime paramAppRuntime, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = new VasResController(paramInt, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  public VasResAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter;
  }
  
  public VasResController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter.c();
    }
  }
  
  public void a(VasResAdapter paramVasResAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter = paramVasResAdapter;
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter.b();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      return true;
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResAdapter.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasRes
 * JD-Core Version:    0.7.0.1
 */