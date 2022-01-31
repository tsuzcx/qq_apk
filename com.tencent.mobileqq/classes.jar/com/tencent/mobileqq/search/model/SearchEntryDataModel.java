package com.tencent.mobileqq.search.model;

import ahga;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicContentRecommend.RspBody;
import pb.unite.search.DynamicDiscovery.HotSearchItem;
import pb.unite.search.DynamicDiscovery.Result;

public abstract class SearchEntryDataModel
  implements IModel
{
  public int a;
  public QQAppInterface a;
  public final Object a;
  public byte[] a;
  public int b;
  
  public SearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public SearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = paramInt2;
  }
  
  public static SearchEntryDataModel a(QQAppInterface paramQQAppInterface, DynamicContentRecommend.RspBody paramRspBody, int paramInt)
  {
    paramQQAppInterface = new ContentRecommendDataModel(paramQQAppInterface, 4, paramRspBody.toByteArray(), paramInt);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, recommendResult = " + paramQQAppInterface);
    }
    return paramQQAppInterface;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, List paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = (DynamicDiscovery.Result)paramList.get(i);
        arrayOfInt[i] = ((DynamicDiscovery.Result)paramList.get(i)).type.get();
        int k = ((DynamicDiscovery.Result)localObject).type.get();
        switch (k)
        {
        default: 
          localObject = null;
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((SearchEntryDataModel)localObject).b();
            localArrayList.add(localObject);
          }
          i += 1;
          break;
          List localList = ((DynamicDiscovery.Result)localObject).hot_search_items.get();
          String[] arrayOfString = new String[localList.size()];
          int j = 0;
          while (j < localList.size())
          {
            arrayOfString[j] = ((DynamicDiscovery.HotSearchItem)localList.get(j)).title.get().toStringUtf8();
            j += 1;
          }
          SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
          localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, k, ((DynamicDiscovery.Result)localObject).toByteArray(), paramInt);
          continue;
          localObject = new OperationSearchEntryDataModel(paramQQAppInterface, k, ((DynamicDiscovery.Result)localObject).toByteArray(), paramInt);
          continue;
          localObject = new BusinessSearchEntryDataModel(paramQQAppInterface, k, ((DynamicDiscovery.Result)localObject).toByteArray(), paramInt);
        }
      }
      boolean bool = a(arrayOfInt, SearchEntryConfigManager.a(paramQQAppInterface, paramInt));
      SearchEntryConfigManager.a(paramQQAppInterface, paramInt, bool);
      if (bool) {
        SearchEntryConfigManager.a(paramQQAppInterface, paramInt, arrayOfInt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, modelList = " + localArrayList);
    }
    return localArrayList;
  }
  
  private static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null))
    {
      bool1 = true;
      return bool1;
    }
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayOfInt1.length) {
        break;
      }
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return true;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_ArrayOfByte = FileUtils.a(BaseApplication.getContext().getFileStreamPath("search_discovery_sp_prefixpref_search_model_data" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + this.jdField_a_of_type_Int + "_" + this.b));
      a(this.jdField_a_of_type_ArrayOfByte);
      return;
    }
  }
  
  public abstract void a(byte[] paramArrayOfByte);
  
  protected void b()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, mRawData is null");
      }
      return;
    }
    ThreadManager.post(new ahga(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */