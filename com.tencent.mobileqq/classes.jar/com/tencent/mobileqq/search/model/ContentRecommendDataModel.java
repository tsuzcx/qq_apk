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
import pb.unite.search.DynamicContentRecommend.ContentRecommend;
import pb.unite.search.DynamicContentRecommend.RspBody;

public class ContentRecommendDataModel
  extends SearchEntryDataModel
{
  public List a;
  
  public ContentRecommendDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public ContentRecommendDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      Object localObject = new DynamicContentRecommend.RspBody();
      try
      {
        ((DynamicContentRecommend.RspBody)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicContentRecommend.RspBody)localObject).result_items.get();
        if (paramArrayOfByte.size() > 0)
        {
          int i = 0;
          while (i < paramArrayOfByte.size())
          {
            localObject = new ContentRecommendDataModel.ContentRecommendItem(this);
            DynamicContentRecommend.ContentRecommend localContentRecommend = (DynamicContentRecommend.ContentRecommend)paramArrayOfByte.get(i);
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).jdField_a_of_type_JavaLangString = localContentRecommend.title.get().toStringUtf8();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).b = localContentRecommend.icon_url.get().toStringUtf8();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).c = localContentRecommend.more_text.get().toStringUtf8();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).d = localContentRecommend.more_url.get().toStringUtf8();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).jdField_a_of_type_Int = localContentRecommend.type.get();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).e = localContentRecommend.info_title.get().toStringUtf8();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).f = localContentRecommend.info_content.get().toStringUtf8();
            ArrayList localArrayList = new ArrayList();
            List localList = localContentRecommend.info_pics_url.get();
            int j = 0;
            while (j < localList.size())
            {
              localArrayList.add(((ByteStringMicro)localList.get(j)).toStringUtf8());
              j += 1;
            }
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).jdField_a_of_type_JavaUtilList = localArrayList;
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).g = localContentRecommend.desc_text.get().toStringUtf8();
            ((ContentRecommendDataModel.ContentRecommendItem)localObject).h = localContentRecommend.info_jump_url.get().toStringUtf8();
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            i += 1;
          }
          if (!QLog.isColorLevel()) {}
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
    }
    QLog.e("SearchEntryDataModel", 2, "fabricateModel, InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.ContentRecommendDataModel
 * JD-Core Version:    0.7.0.1
 */