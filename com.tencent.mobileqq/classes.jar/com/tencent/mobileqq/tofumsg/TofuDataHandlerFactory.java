package com.tencent.mobileqq.tofumsg;

import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tofumsg.handlers.AskAnonymouslyHandler;
import com.tencent.mobileqq.tofumsg.handlers.BaseProfileDataHandler;
import com.tencent.mobileqq.tofumsg.handlers.IntimateAnniversaryDataHandler;
import com.tencent.mobileqq.tofumsg.handlers.NewFrdMiniCardHandler;
import com.tencent.mobileqq.tofumsg.handlers.NicePicsDataHandler;

public class TofuDataHandlerFactory
{
  SparseArray<ITofuDataHandler> jdField_a_of_type_AndroidUtilSparseArray;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  TofuDataHandlerFactory(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(TofuConst.a.length);
  }
  
  ITofuDataHandler a(int paramInt)
  {
    ITofuDataHandler localITofuDataHandler = (ITofuDataHandler)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localITofuDataHandler != null) {
      ??? = localITofuDataHandler;
    }
    do
    {
      do
      {
        return ???;
        switch (paramInt)
        {
        default: 
          ??? = localITofuDataHandler;
        }
      } while (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null);
      ??? = localITofuDataHandler;
    } while (localITofuDataHandler == null);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
          break label186;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localITofuDataHandler);
        return localITofuDataHandler;
      }
      Object localObject2 = new IntimateAnniversaryDataHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new BaseProfileDataHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new NicePicsDataHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new NewFrdMiniCardHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      localObject2 = new AskAnonymouslyHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      break;
      label186:
      localObject2 = (ITofuDataHandler)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
  }
  
  void a()
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
        i = 0;
        if (i < j)
        {
          ITofuDataHandler localITofuDataHandler = (ITofuDataHandler)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
          if (localITofuDataHandler != null) {
            localITofuDataHandler.a();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.clear();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuDataHandlerFactory
 * JD-Core Version:    0.7.0.1
 */