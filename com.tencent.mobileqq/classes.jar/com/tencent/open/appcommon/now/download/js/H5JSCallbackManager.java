package com.tencent.open.appcommon.now.download.js;

import com.tencent.open.business.base.IJsCallBack;
import java.util.ArrayList;

public class H5JSCallbackManager
{
  protected static H5JSCallbackManager a;
  protected ArrayList<IJsCallBack> a;
  
  public static H5JSCallbackManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager == null)
      {
        jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager = new H5JSCallbackManager();
        jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      H5JSCallbackManager localH5JSCallbackManager = jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager;
      return localH5JSCallbackManager;
    }
    finally {}
  }
  
  public ArrayList<IJsCallBack> a()
  {
    return jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(IJsCallBack paramIJsCallBack)
  {
    int j = jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((IJsCallBack)jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList.get(i) == paramIJsCallBack) {
        return;
      }
      i += 1;
    }
    jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList.add(paramIJsCallBack);
  }
  
  public void b(IJsCallBack paramIJsCallBack)
  {
    int j = jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if ((IJsCallBack)jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList.get(i) == paramIJsCallBack)
      {
        jdField_a_of_type_ComTencentOpenAppcommonNowDownloadJsH5JSCallbackManager.jdField_a_of_type_JavaUtilArrayList.remove(i);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.H5JSCallbackManager
 * JD-Core Version:    0.7.0.1
 */