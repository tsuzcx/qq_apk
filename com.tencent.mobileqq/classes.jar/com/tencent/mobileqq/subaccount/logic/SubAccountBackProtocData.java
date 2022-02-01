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
  public int a;
  public Object a;
  public String a;
  public ArrayList<String> a;
  public boolean a;
  public int b;
  public String b;
  public ArrayList<String> b;
  public boolean b;
  public String c;
  public ArrayList<String> c;
  public boolean c;
  public boolean d = false;
  
  public SubAccountBackProtocData()
  {
    this.jdField_a_of_type_Int = -99999;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_c_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaLangObject = null;
    this.jdField_b_of_type_Int = -99999;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
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
    localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangString;
    localSubAccountBackProtocData.jdField_a_of_type_Int = paramSubAccountBackProtocData.jdField_a_of_type_Int;
    localSubAccountBackProtocData.jdField_b_of_type_JavaLangString = paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString;
    localSubAccountBackProtocData.jdField_c_of_type_JavaLangString = paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSubAccountBackProtocData.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    localSubAccountBackProtocData.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
    localArrayList1 = new ArrayList();
    localArrayList2 = paramSubAccountBackProtocData.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    localSubAccountBackProtocData.jdField_b_of_type_JavaUtilArrayList = localArrayList1;
    localArrayList1 = new ArrayList();
    localArrayList2 = paramSubAccountBackProtocData.jdField_c_of_type_JavaUtilArrayList;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    localSubAccountBackProtocData.jdField_c_of_type_JavaUtilArrayList = localArrayList1;
    localSubAccountBackProtocData.jdField_a_of_type_JavaLangObject = paramSubAccountBackProtocData.jdField_a_of_type_JavaLangObject;
    localSubAccountBackProtocData.jdField_b_of_type_Int = paramSubAccountBackProtocData.jdField_b_of_type_Int;
    localSubAccountBackProtocData.jdField_a_of_type_Boolean = paramSubAccountBackProtocData.jdField_a_of_type_Boolean;
    localSubAccountBackProtocData.jdField_b_of_type_Boolean = paramSubAccountBackProtocData.jdField_b_of_type_Boolean;
    localSubAccountBackProtocData.jdField_c_of_type_Boolean = paramSubAccountBackProtocData.jdField_c_of_type_Boolean;
    localSubAccountBackProtocData.d = paramSubAccountBackProtocData.d;
    return localSubAccountBackProtocData;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBackProtocData.clearNewUins()");
    }
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
    localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.clear();
    }
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
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      }
      if (this.jdField_b_of_type_JavaUtilArrayList == null) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramString)) {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      }
    }
  }
  
  public void a(oidb_0x7a2.RspBody paramRspBody, ArrayList<String> paramArrayList)
  {
    if (paramRspBody == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    if ((paramRspBody.uint64_bind_uin.has()) && (paramRspBody.uint64_bind_uin.get() > 10000L))
    {
      this.jdField_c_of_type_JavaLangString = Long.toString(paramRspBody.uint64_bind_uin.get());
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_JavaLangString);
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
            if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localObject)) {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
            }
            if (this.jdField_c_of_type_JavaLangString == null) {
              this.jdField_c_of_type_JavaLangString = ((String)localObject);
            }
          }
        }
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramRspBody = paramArrayList.iterator();
      while (paramRspBody.hasNext())
      {
        paramArrayList = (String)paramRspBody.next();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramArrayList)) {
          this.jdField_c_of_type_JavaUtilArrayList.add(paramArrayList);
        }
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramArrayList);
      }
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append("SubAccountBackProtocData.parseUins() figure new subUins. localSubUins is null. new SubUins=");
      paramRspBody.append(String.valueOf(this.jdField_b_of_type_JavaUtilArrayList));
      paramRspBody.append(" overdue SubUins=");
      paramRspBody.append(String.valueOf(this.jdField_c_of_type_JavaUtilArrayList));
      QLog.d("SUB_ACCOUNT", 2, paramRspBody.toString());
    }
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.jdField_c_of_type_JavaUtilArrayList;
    if (localArrayList2 != null) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  public boolean b()
  {
    ArrayList localArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.size() > 0);
  }
  
  public ArrayList<String> c()
  {
    Object localObject = this.jdField_c_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 4))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList = null;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUinsBinded() return null, mSubUin is null");
      }
    }
    localObject = new ArrayList();
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      ((ArrayList)localObject).addAll(localArrayList);
    }
    return localObject;
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_c_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 4))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_c_of_type_JavaLangString);
      }
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    return (localObject != null) && (((ArrayList)localObject).size() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData
 * JD-Core Version:    0.7.0.1
 */