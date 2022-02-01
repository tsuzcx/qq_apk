package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.search.SearchRichConfBean;
import com.tencent.mobileqq.config.business.search.SearchRichConfBean.RichBaseTemplate;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RichNodeFactory
{
  public static final String a;
  private static volatile RichNodeFactory d;
  private Map<Integer, ArkNodeConfig> b = new HashMap();
  private Map<Integer, NativeNodeConfig> c = new HashMap();
  private boolean e = true;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("ArkApp");
    a = localStringBuilder.toString();
  }
  
  public static RichNodeFactory a()
  {
    if (d == null) {
      try
      {
        if (d == null)
        {
          d = new RichNodeFactory();
          d.c();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(List<NativeNodeConfig> arg1, List<ArkNodeConfig> paramList1)
  {
    if (??? != null)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("updateConfig， nativesize :");
        ((StringBuilder)???).append(???.size());
        QLog.d("RichNodeFactory", 2, ((StringBuilder)???).toString());
      }
      synchronized (this.c)
      {
        this.c.clear();
        ??? = ???.iterator();
        while (???.hasNext())
        {
          NativeNodeConfig localNativeNodeConfig = (NativeNodeConfig)???.next();
          this.c.put(Integer.valueOf(localNativeNodeConfig.a()), localNativeNodeConfig);
        }
      }
    }
    synchronized (this.c)
    {
      this.c.clear();
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， nativesize = 0");
      }
      if (paramList1 != null)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("updateConfig， arksize:");
          ???.append(paramList1.size());
          QLog.d("RichNodeFactory", 2, ???.toString());
        }
        synchronized (this.b)
        {
          this.b.clear();
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            ??? = (ArkNodeConfig)paramList1.next();
            this.b.put(Integer.valueOf(((ArkNodeConfig)???).b()), ???);
          }
          return;
        }
      }
      synchronized (this.b)
      {
        this.b.clear();
        if (QLog.isColorLevel()) {
          QLog.d("RichNodeFactory", 2, "updateConfig， arksize = 0");
        }
        return;
      }
    }
    for (;;)
    {
      throw paramList1;
    }
  }
  
  private IRichNode b(int paramInt)
  {
    IRichNode localIRichNode2 = d(paramInt);
    IRichNode localIRichNode1 = localIRichNode2;
    if (localIRichNode2 == null) {
      localIRichNode1 = c(paramInt);
    }
    return localIRichNode1;
  }
  
  private IRichNode c(int paramInt)
  {
    synchronized (this.b)
    {
      ArkNodeConfig localArkNodeConfig = (ArkNodeConfig)this.b.get(Integer.valueOf(paramInt));
      if (localArkNodeConfig != null) {
        return new ArkRichNode(localArkNodeConfig);
      }
      return null;
    }
  }
  
  private void c()
  {
    d();
  }
  
  private IRichNode d(int paramInt)
  {
    if (paramInt == 101) {
      return new NativeTemplateOneRichNode();
    }
    return null;
  }
  
  private void d()
  {
    Object localObject2 = SearchRichConfBean.a();
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.e = ((SearchRichConfBean)localObject2).b();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mRichSwitchOn :");
      ((StringBuilder)localObject1).append(this.e);
      QLog.d("RichNodeFactory", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = this.e;
    ArrayList localArrayList = null;
    if (!bool)
    {
      a(null, null);
      return;
    }
    Object localObject1 = ((SearchRichConfBean)localObject2).a("ark");
    Object localObject3 = ((SearchRichConfBean)localObject2).a("native");
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject2 = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (SearchRichConfBean.RichBaseTemplate)localIterator.next();
        ((List)localObject2).add(new ArkNodeConfig(((SearchRichConfBean.RichBaseTemplate)localObject1).a, ((SearchRichConfBean.RichBaseTemplate)localObject1).c, ((SearchRichConfBean.RichBaseTemplate)localObject1).d, ((SearchRichConfBean.RichBaseTemplate)localObject1).e, "", null));
      }
    }
    localObject1 = null;
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
  }
  
  public IRichNode a(QQAppInterface paramQQAppInterface, Context paramContext, IModel paramIModel)
  {
    if (paramIModel == null) {
      return null;
    }
    if (!(paramIModel instanceof RichSearchModelNode)) {
      return null;
    }
    Object localObject = (RichSearchModelNode)paramIModel;
    int i = ((RichSearchModelNode)localObject).r();
    paramIModel = b(i);
    if (paramIModel != null)
    {
      String str1 = ((RichSearchModelNode)localObject).s();
      String str2 = ((RichSearchModelNode)localObject).v();
      localObject = ((RichSearchModelNode)localObject).t();
      paramIModel.a(paramQQAppInterface, paramContext, i, str1, (String)localObject, str2);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("create, data:");
        paramQQAppInterface.append(str1);
        paramQQAppInterface.append(" config:");
        paramQQAppInterface.append(str2);
        paramQQAppInterface.append(" extradata:");
        paramQQAppInterface.append((String)localObject);
        QLog.d("RichNodeFactory", 2, paramQQAppInterface.toString());
      }
    }
    return paramIModel;
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("nodeExist， id:");
      ((StringBuilder)???).append(paramInt);
      QLog.d("RichNodeFactory", 2, ((StringBuilder)???).toString());
    }
    if (!this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "nodeExist， switch off");
      }
      return false;
    }
    synchronized (this.c)
    {
      if (this.c.get(Integer.valueOf(paramInt)) != null) {
        return true;
      }
      synchronized (this.b)
      {
        ArkNodeConfig localArkNodeConfig = (ArkNodeConfig)this.b.get(Integer.valueOf(paramInt));
        if (localArkNodeConfig != null) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeFactory
 * JD-Core Version:    0.7.0.1
 */