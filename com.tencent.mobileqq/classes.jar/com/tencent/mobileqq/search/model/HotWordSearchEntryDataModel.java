package com.tencent.mobileqq.search.model;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pb.unite.search.DynamicDiscovery.HotSearchItem;
import pb.unite.search.DynamicDiscovery.Result;
import pb.unite.search.DynamicDiscovery.TitleHeaderItem;

public class HotWordSearchEntryDataModel
  extends SearchEntryDataModel
{
  public final HotWordSearchEntryDataModel.TitleHeaderItem a;
  public final List a;
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem = new HotWordSearchEntryDataModel.TitleHeaderItem(this);
  }
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem = new HotWordSearchEntryDataModel.TitleHeaderItem(this);
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
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).hot_search_items.get();
        localObject = (DynamicDiscovery.TitleHeaderItem)((DynamicDiscovery.Result)localObject).title_header.get();
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.b = ((DynamicDiscovery.TitleHeaderItem)localObject).icon_url.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.a = ((DynamicDiscovery.TitleHeaderItem)localObject).title.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.c = ((DynamicDiscovery.TitleHeaderItem)localObject).morn_text.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$TitleHeaderItem.d = ((DynamicDiscovery.TitleHeaderItem)localObject).morn_url.get().toStringUtf8();
        this.jdField_a_of_type_JavaUtilList.clear();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (DynamicDiscovery.HotSearchItem)paramArrayOfByte.next();
          HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = new HotWordSearchEntryDataModel.HotSearchItem();
          localHotSearchItem.showType = ((DynamicDiscovery.HotSearchItem)localObject).show_type.get();
          localHotSearchItem.title = ((DynamicDiscovery.HotSearchItem)localObject).title.get().toStringUtf8();
          localHotSearchItem.imgUrl = ((DynamicDiscovery.HotSearchItem)localObject).img_url.get().toStringUtf8();
          localHotSearchItem.detailText = ((DynamicDiscovery.HotSearchItem)localObject).detail_text.get().toStringUtf8();
          localHotSearchItem.jumpUrl = ((DynamicDiscovery.HotSearchItem)localObject).jump_url.get().toStringUtf8();
          localHotSearchItem.indexTextColor = ((DynamicDiscovery.HotSearchItem)localObject).mark_text_color.get().toStringUtf8();
          localHotSearchItem.indexBgColor = ((DynamicDiscovery.HotSearchItem)localObject).mark_bg_color.get().toStringUtf8();
          localHotSearchItem.imgBgUrl = ((DynamicDiscovery.HotSearchItem)localObject).img_bg_url.get().toStringUtf8();
          this.jdField_a_of_type_JavaUtilList.add(localHotSearchItem);
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    }
    QLog.e("SearchEntryDataModel", 2, "fabricateModel, InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */