package com.tencent.open.agent.auth.presenter;

import com.tencent.open.agent.entity.AuthMemoryCache;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SelectPermissionPresenter$2
  implements Runnable
{
  SelectPermissionPresenter$2(SelectPermissionPresenter paramSelectPermissionPresenter) {}
  
  public void run()
  {
    Object localObject1 = AuthMemoryCache.a().a(SelectPermissionPresenter.a(this.this$0));
    if (localObject1 == null)
    {
      SSOLog.a("SelectPermissionPresenter", new Object[] { "getAuthApiListResponse == null" });
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    Permission localPermission1;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localPermission1 = (Permission)((Iterator)localObject1).next();
      localObject2 = new Permission();
      ((Permission)localObject2).jdField_a_of_type_Int = localPermission1.jdField_a_of_type_Int;
      ((Permission)localObject2).jdField_b_of_type_JavaLangString = localPermission1.jdField_b_of_type_JavaLangString;
      ((Permission)localObject2).jdField_b_of_type_Int = localPermission1.jdField_b_of_type_Int;
      ((Permission)localObject2).jdField_a_of_type_Boolean = localPermission1.jdField_a_of_type_Boolean;
      ((Permission)localObject2).jdField_a_of_type_JavaLangString = localPermission1.jdField_a_of_type_JavaLangString;
      ((Permission)localObject2).jdField_b_of_type_Boolean = true;
      localArrayList.add(localObject2);
    }
    if (!SelectPermissionPresenter.a(this.this$0).isEmpty())
    {
      localObject1 = SelectPermissionPresenter.a(this.this$0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPermission1 = (Permission)((Iterator)localObject1).next();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Permission localPermission2 = (Permission)((Iterator)localObject2).next();
          if (localPermission1.jdField_b_of_type_Int == localPermission2.jdField_b_of_type_Int) {
            localPermission2.jdField_b_of_type_Boolean = localPermission1.jdField_b_of_type_Boolean;
          }
        }
      }
    }
    int i;
    if (SelectPermissionPresenter.a(this.this$0)) {
      i = 2;
    } else {
      i = 1;
    }
    AuthReporter.a("KEY_AUTHORIZE_REQUEST");
    if (0L == SelectPermissionPresenter.a(this.this$0)) {
      localObject1 = "";
    } else {
      localObject1 = String.valueOf(SelectPermissionPresenter.a(this.this$0));
    }
    new SSOSdkAuthApiPresenter().a(SelectPermissionPresenter.a(this.this$0), SelectPermissionPresenter.b(this.this$0), (String)localObject1, localArrayList, SelectPermissionPresenter.b(this.this$0), SelectPermissionPresenter.a(this.this$0), SelectPermissionPresenter.c(this.this$0));
    if (SelectPermissionPresenter.b(this.this$0) == 0L) {
      localObject1 = "0X800A117";
    } else {
      localObject1 = "0X800A116";
    }
    AuthorityUtil.a(null, (String)localObject1, 0, i, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.auth.presenter.SelectPermissionPresenter.2
 * JD-Core Version:    0.7.0.1
 */