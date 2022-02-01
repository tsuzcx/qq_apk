package com.tencent.mobileqq.intervideo.lite_now_biz.permission;

import android.app.Activity;
import android.app.Fragment;
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
  private int a;
  private String[] b;
  private PermissionCallback c;
  private String[] d;
  
  private void a()
  {
    PermissionCallback localPermissionCallback = this.c;
    if (localPermissionCallback != null) {
      localPermissionCallback.a(this.b, this.a);
    }
  }
  
  private void a(List<String> paramList)
  {
    PermissionCallback localPermissionCallback = this.c;
    if (localPermissionCallback != null) {
      localPermissionCallback.a(paramList, this.a);
    }
  }
  
  private String[] b(String... paramVarArgs)
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
    this.a = paramInt;
    return this;
  }
  
  public RequestPermission a(PermissionCallback paramPermissionCallback)
  {
    this.c = paramPermissionCallback;
    return this;
  }
  
  public RequestPermission a(String... paramVarArgs)
  {
    this.b = paramVarArgs;
    return this;
  }
  
  public void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      a();
      return;
    }
    this.d = b(this.b);
    Object localObject = this.d;
    if (localObject.length > 0)
    {
      localObject = MainProcessPermissionFragment.a((String[])localObject);
      ((MainProcessPermissionFragment)localObject).a(this);
      paramActivity.getFragmentManager().beginTransaction().add((Fragment)localObject, "MainProcessPermissionFragment").commit();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.permission.RequestPermission
 * JD-Core Version:    0.7.0.1
 */