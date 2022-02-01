package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.search.SearchRichConfBean;
import com.tencent.mobileqq.config.business.search.SearchRichConfBean.RichBaseTemplate;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.RichSearchModelNode;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RichNodeFactory
{
  private static volatile RichNodeFactory jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeFactory;
  public static final String a;
  private Map<Integer, ArkNodeConfig> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private Map<Integer, NativeNodeConfig> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  }
  
  private IRichNode a(int paramInt)
  {
    IRichNode localIRichNode2 = c(paramInt);
    IRichNode localIRichNode1 = localIRichNode2;
    if (localIRichNode2 == null) {
      localIRichNode1 = b(paramInt);
    }
    return localIRichNode1;
  }
  
  public static RichNodeFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeFactory == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeFactory == null)
      {
        jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeFactory = new RichNodeFactory();
        jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeFactory.b();
      }
      return jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeFactory;
    }
    finally {}
  }
  
  private void a(List<NativeNodeConfig> arg1, List<ArkNodeConfig> paramList1)
  {
    if (??? != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， nativesize :" + ???.size());
      }
      synchronized (this.b)
      {
        this.b.clear();
        ??? = ???.iterator();
        if (???.hasNext())
        {
          NativeNodeConfig localNativeNodeConfig = (NativeNodeConfig)???.next();
          this.b.put(Integer.valueOf(localNativeNodeConfig.a()), localNativeNodeConfig);
        }
      }
    }
    for (;;)
    {
      if (paramList1 == null) {
        break label264;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， arksize:" + paramList1.size());
      }
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        ??? = (ArkNodeConfig)paramList1.next();
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(((ArkNodeConfig)???).a()), ???);
      }
      synchronized (this.b)
      {
        this.b.clear();
        if (QLog.isColorLevel()) {
          QLog.d("RichNodeFactory", 2, "updateConfig， nativesize = 0");
        }
      }
    }
    for (;;)
    {
      return;
      label264:
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        this.jdField_a_of_type_JavaUtilMap.clear();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RichNodeFactory", 2, "updateConfig， arksize = 0");
        return;
      }
    }
  }
  
  private IRichNode b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      ArkNodeConfig localArkNodeConfig = (ArkNodeConfig)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localArkNodeConfig != null) {
        return new ArkRichNode(localArkNodeConfig);
      }
    }
    return null;
  }
  
  private void b()
  {
    c();
  }
  
  private IRichNode c(int paramInt)
  {
    if (paramInt == 101) {
      return new NativeTemplateOneRichNode();
    }
    return null;
  }
  
  private void c()
  {
    ArrayList localArrayList = null;
    Object localObject1 = SearchRichConfBean.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = ((SearchRichConfBean)localObject1).a();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    Object localObject2 = ((SearchRichConfBean)localObject1).a("ark");
    Object localObject3 = ((SearchRichConfBean)localObject1).a("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SearchRichConfBean.RichBaseTemplate localRichBaseTemplate = (SearchRichConfBean.RichBaseTemplate)((Iterator)localObject2).next();
        ((List)localObject1).add(new ArkNodeConfig(localRichBaseTemplate.a, localRichBaseTemplate.b, localRichBaseTemplate.c, localRichBaseTemplate.d, "", null));
      }
    }
    for (;;)
    {
      localObject2 = localArrayList;
      if (localObject3 != null)
      {
        localObject2 = localArrayList;
        if (((ArrayList)localObject3).size() > 0)
        {
          localArrayList = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          for (;;)
          {
            localObject2 = localArrayList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localArrayList.add(new NativeNodeConfig(((SearchRichConfBean.RichBaseTemplate)((Iterator)localObject3).next()).a));
          }
        }
      }
      a((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public IRichNode a(QQAppInterface paramQQAppInterface, Context paramContext, IModel paramIModel)
  {
    Object localObject1 = null;
    if (paramIModel == null) {}
    Object localObject2;
    String str1;
    String str2;
    do
    {
      int i;
      do
      {
        do
        {
          return localObject1;
        } while (!(paramIModel instanceof RichSearchModelNode));
        localObject2 = (RichSearchModelNode)paramIModel;
        i = ((RichSearchModelNode)localObject2).f();
        paramIModel = a(i);
        localObject1 = paramIModel;
      } while (paramIModel == null);
      str1 = ((RichSearchModelNode)localObject2).c();
      str2 = ((RichSearchModelNode)localObject2).e();
      localObject2 = ((RichSearchModelNode)localObject2).d();
      paramIModel.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramIModel;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramIModel;
  }
  
  public void a()
  {
    c();
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "nodeExist， id:" + paramInt);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "nodeExist， switch off");
      }
      return false;
    }
    synchronized (this.b)
    {
      if (this.b.get(Integer.valueOf(paramInt)) != null) {
        return true;
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      ArkNodeConfig localArkNodeConfig = (ArkNodeConfig)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localArkNodeConfig != null)
      {
        return true;
        localObject1 = finally;
        throw localObject1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeFactory
 * JD-Core Version:    0.7.0.1
 */