package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import pb.unite.search.DynamicDiscovery.OperationItem;
import pb.unite.search.DynamicDiscovery.Result;

public class OperationSearchEntryDataModel
  extends SearchEntryDataModel
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public OperationSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
  }
  
  public OperationSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2);
    a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      DynamicDiscovery.Result localResult = new DynamicDiscovery.Result();
      try
      {
        localResult.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (DynamicDiscovery.OperationItem)localResult.operation_items.get().get(0);
        this.jdField_a_of_type_JavaLangString = paramArrayOfByte.left_title.get().toStringUtf8();
        this.b = paramArrayOfByte.right_title.get().toStringUtf8();
        this.c = paramArrayOfByte.detail_text.get().toStringUtf8();
        this.d = paramArrayOfByte.img_url.get().toStringUtf8();
        this.e = paramArrayOfByte.jump_url.get().toStringUtf8();
        PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()).edit().putString("pref_operation_search_entry_title", this.jdField_a_of_type_JavaLangString).commit();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.e("SearchEntryDataModel", 2, "fabricateModel, InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.OperationSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */