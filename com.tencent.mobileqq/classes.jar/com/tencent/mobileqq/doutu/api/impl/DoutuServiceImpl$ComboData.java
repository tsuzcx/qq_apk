package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DoutuServiceImpl$ComboData
{
  private int jdField_a_of_type_Int;
  private List<DoutuMsgItem> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public DoutuServiceImpl$ComboData(List<DoutuMsgItem> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = paramInt1;
    this.jdField_a_of_type_Int = paramBoolean;
    this.jdField_b_of_type_Boolean = paramInt2;
    int i;
    this.jdField_b_of_type_Int = i;
  }
  
  private int a(long paramLong)
  {
    int i = 0;
    int j = 0;
    while ((i < DoutuServiceImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl).size()) && (((DoutuMsgItem)DoutuServiceImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl).get(i)).b < paramLong))
    {
      j += 1;
      i += 1;
    }
    return j;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public ComboData a()
  {
    Object localObject;
    long l;
    if ((DoutuServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl) != 0) && (this.jdField_a_of_type_JavaUtilList.size() == DoutuServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl)))
    {
      if ((DoutuServiceImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl) != null) && (DoutuServiceImpl.access$900(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl).size() > 0))
      {
        int i = a(((DoutuMsgItem)this.jdField_a_of_type_JavaUtilList.get(0)).b);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleCombo : offset = ");
          ((StringBuilder)localObject).append(i);
          QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
        if ((i > 0) && (this.jdField_a_of_type_JavaUtilList.size() - 1 - i >= 0))
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          l = ((DoutuMsgItem)((List)localObject).get(((List)localObject).size() - 1 - i)).a;
          localObject = this.jdField_a_of_type_JavaUtilList;
          if (((DoutuMsgItem)((List)localObject).get(((List)localObject).size() - 1)).a - l < DoutuServiceImpl.access$1000(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl))
          {
            this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
            this.jdField_a_of_type_Int += i;
            this.jdField_b_of_type_Boolean = true;
            localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl;
            ((DoutuServiceImpl)localObject).recordComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl), (DoutuMsgItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
            this.jdField_a_of_type_Boolean = true;
            return this;
          }
          this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
          this.jdField_a_of_type_Int = 0;
          localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl;
          ((DoutuServiceImpl)localObject).removeComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl));
          this.jdField_a_of_type_Boolean = true;
          return this;
        }
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl;
      ((DoutuServiceImpl)localObject).recordComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl), (DoutuMsgItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    if ((DoutuServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl) != 0) && (this.jdField_a_of_type_JavaUtilList.size() > DoutuServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl)))
    {
      l = ((DoutuMsgItem)this.jdField_a_of_type_JavaUtilList.get(DoutuServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl) - 1)).a;
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (((DoutuMsgItem)((List)localObject).get(((List)localObject).size() - 1)).a - l < DoutuServiceImpl.access$1000(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl))
      {
        this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
        this.jdField_a_of_type_Int += this.jdField_a_of_type_JavaUtilList.size() - DoutuServiceImpl.access$800(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl);
        localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl;
        ((DoutuServiceImpl)localObject).recordComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl), (DoutuMsgItem)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
      this.jdField_a_of_type_Int = 0;
      localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl;
      ((DoutuServiceImpl)localObject).removeComboStamp(DoutuServiceImpl.access$1100((DoutuServiceImpl)localObject), DoutuServiceImpl.access$1200(this.jdField_a_of_type_ComTencentMobileqqDoutuApiImplDoutuServiceImpl));
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.ComboData
 * JD-Core Version:    0.7.0.1
 */