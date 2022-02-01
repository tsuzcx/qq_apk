package com.tencent.mobileqq.intervideo.lite_now_biz.permission;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class RequestPermission
  implements PermissionListener
{
  private int jdField_a_of_type_Int;
  private PermissionCallback jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionPermissionCallback;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private String[] b;
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionPermissionCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionPermissionCallback.a(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Int);
    }
  }
  
  private void a(List<String> paramList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionPermissionCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionPermissionCallback.a(paramList, this.jdField_a_of_type_Int);
    }
  }
  
  private String[] a(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(1);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (ContextCompat.checkSelfPermission(BaseApplicationImpl.getContext(), str) != 0) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public RequestPermission a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public RequestPermission a(PermissionCallback paramPermissionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizPermissionPermissionCallback = paramPermissionCallback;
    return this;
  }
  
  public RequestPermission a(String... paramVarArgs)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramVarArgs;
    return this;
  }
  
  public void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      a();
      return;
    }
    this.b = a(this.jdField_a_of_type_ArrayOfJavaLangString);
    if (this.b.length > 0)
    {
      MainProcessPermissionFragment localMainProcessPermissionFragment = MainProcessPermissionFragment.a(this.b);
      localMainProcessPermissionFragment.a(this);
      paramActivity.getFragmentManager().beginTransaction().add(localMainProcessPermissionFragment, "MainProcessPermissionFragment").commit();
      return;
    }
    a();
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfInt[i] != 0) {
        localArrayList.add(paramArrayOfString[i]);
      }
      i += 1;
    }
    if (localArrayList.isEmpty())
    {
      a();
      return;
    }
    a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.permission.RequestPermission
 * JD-Core Version:    0.7.0.1
 */