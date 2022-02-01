package com.tencent.mobileqq.subaccount.logic;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody;

public class SubAccountBackProtocData
{
  public int a = -99999;
  public String b = null;
  public String c = null;
  public String d = null;
  public ArrayList<String> e = null;
  public ArrayList<String> f = null;
  public ArrayList<String> g = null;
  public Object h = null;
  public int i = -99999;
  public boolean j = true;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  
  public static SubAccountBackProtocData a(SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (paramSubAccountBackProtocData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clone() return, backData == null.");
      }
      return null;
    }
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    localSubAccountBackProtocData.b = paramSubAccountBackProtocData.b;
    localSubAccountBackProtocData.a = paramSubAccountBackProtocData.a;
    localSubAccountBackProtocData.c = paramSubAccountBackProtocData.c;
    localSubAccountBackProtocData.d = paramSubAccountBackProtocData.d;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSubAccountBackProtocData.e;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    localSubAccountBackProtocData.e = localArrayList1;
    localArrayList1 = new ArrayList();
    localArrayList2 = paramSubAccountBackProtocData.f;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    localSubAccountBackProtocData.f = localArrayList1;
    localArrayList1 = new ArrayList();
    localArrayList2 = paramSubAccountBackProtocData.g;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    localSubAccountBackProtocData.g = localArrayList1;
    localSubAccountBackProtocData.h = paramSubAccountBackProtocData.h;
    localSubAccountBackProtocData.i = paramSubAccountBackProtocData.i;
    localSubAccountBackProtocData.j = paramSubAccountBackProtocData.j;
    localSubAccountBackProtocData.k = paramSubAccountBackProtocData.k;
    localSubAccountBackProtocData.l = paramSubAccountBackProtocData.l;
    localSubAccountBackProtocData.m = paramSubAccountBackProtocData.m;
    return localSubAccountBackProtocData;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SubAccountBackProtocData.addNewUin subUin=");
      localStringBuilder.append(paramString);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    if (paramString != null)
    {
      if (paramString.length() < 4) {
        return;
      }
      if (this.e == null) {
        this.e = new ArrayList();
      }
      if (!this.e.contains(paramString)) {
        this.e.add(paramString);
      }
      if (this.f == null) {
        this.f = new ArrayList();
      }
      if (!this.f.contains(paramString)) {
        this.f.add(paramString);
      }
    }
  }
  
  public void a(oidb_0x7a2.RspBody paramRspBody, ArrayList<String> paramArrayList)
  {
    if (paramRspBody == null) {
      return;
    }
    Object localObject = this.e;
    if (localObject == null) {
      this.e = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    if ((paramRspBody.uint64_bind_uin.has()) && (paramRspBody.uint64_bind_uin.get() > 10000L))
    {
      this.d = Long.toString(paramRspBody.uint64_bind_uin.get());
      this.e.add(this.d);
    }
    if (paramRspBody.uint64_multi_bind_uin.has())
    {
      paramRspBody = paramRspBody.uint64_multi_bind_uin.get();
      if (paramRspBody != null)
      {
        paramRspBody = paramRspBody.iterator();
        while (paramRspBody.hasNext())
        {
          localObject = (Long)paramRspBody.next();
          if (((Long)localObject).longValue() > 10000L)
          {
            localObject = Long.toString(((Long)localObject).longValue());
            if (!this.e.contains(localObject)) {
              this.e.add(localObject);
            }
            if (this.d == null) {
              this.d = ((String)localObject);
            }
          }
        }
      }
    }
    this.g = new ArrayList();
    this.f = new ArrayList();
    this.f.addAll(this.e);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramRspBody = paramArrayList.iterator();
      while (paramRspBody.hasNext())
      {
        paramArrayList = (String)paramRspBody.next();
        if (!this.e.contains(paramArrayList)) {
          this.g.add(paramArrayList);
        }
        this.f.remove(paramArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("SubAccountBackProtocData.parseUins() figure new subUins. localSubUins is null. new SubUins=");
      paramRspBody.append(String.valueOf(this.f));
      paramRspBody.append(" overdue SubUins=");
      paramRspBody.append(String.valueOf(this.g));
      QLog.d("SUB_ACCOUNT", 2, paramRspBody.toString());
    }
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.f;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.f;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.g;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public ArrayList<String> d()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.g;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  public boolean e()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((String)localObject).length() > 4))
    {
      if (this.e == null) {
        this.e = new ArrayList();
      }
      if (!this.e.contains(this.d)) {
        this.e.add(0, this.d);
      }
    }
    localObject = this.e;
    return (localObject != null) && (((ArrayList)localObject).size() > 0);
  }
  
  public ArrayList<String> f()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((String)localObject).length() > 4))
    {
      if (this.e == null) {
        this.e = new ArrayList();
      }
      if (!this.e.contains(this.d)) {
        this.e.add(0, this.d);
      }
    }
    else
    {
      this.e = null;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUinsBinded() return null, mSubUin is null");
      }
    }
    localObject = new ArrayList();
    ArrayList localArrayList = this.e;
    if (localArrayList != null) {
      ((ArrayList)localObject).addAll(localArrayList);
    }
    return localObject;
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clearNewUins()");
    }
    ArrayList localArrayList = this.f;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    localArrayList = this.g;
    if (localArrayList != null) {
      localArrayList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData
 * JD-Core Version:    0.7.0.1
 */