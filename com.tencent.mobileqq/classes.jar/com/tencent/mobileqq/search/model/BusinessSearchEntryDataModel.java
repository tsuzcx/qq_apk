package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unite.search.DynamicDiscovery.Result;
import pb.unite.search.DynamicDiscovery.SubBusinessItem;

public class BusinessSearchEntryDataModel
  extends SearchEntryDataModel
{
  public List a = new ArrayList();
  
  public BusinessSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
  }
  
  public BusinessSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2);
    a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      Object localObject = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).sub_business_items.get();
        int i = 0;
        while (i < paramArrayOfByte.size())
        {
          localObject = (DynamicDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
          BusinessSearchEntryDataModel.SearchEntry localSearchEntry = new BusinessSearchEntryDataModel.SearchEntry();
          localSearchEntry.jdField_a_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
          localSearchEntry.jdField_b_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
          List localList = ((DynamicDiscovery.SubBusinessItem)localObject).group_masks.get();
          localSearchEntry.jdField_a_of_type_ArrayOfLong = new long[localList.size()];
          int j = 0;
          while (j < localList.size())
          {
            localSearchEntry.jdField_a_of_type_ArrayOfLong[j] = ((Long)localList.get(j)).longValue();
            j += 1;
          }
          localSearchEntry.jdField_c_of_type_JavaLangString = ((DynamicDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
          localSearchEntry.jdField_a_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).has_red_dot.get();
          localSearchEntry.jdField_b_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).red_seq.get();
          localSearchEntry.jdField_c_of_type_Int = ((DynamicDiscovery.SubBusinessItem)localObject).bzid.get();
          this.a.add(localSearchEntry);
          i += 1;
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    }
    QLog.e("SearchEntryDataModel", 2, "fabricateModel, InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */