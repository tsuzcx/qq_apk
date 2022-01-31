package com.tencent.mobileqq.search.model;

import awpp;
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
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unify.search.UnifySearchDiscovery.SpecialTopic;
import pb.unify.search.UnifySearchDiscovery.TopicImage;
import pb.unify.search.UnifySearchDiscovery.TopicItem;
import pb.unite.search.DynamicDiscovery.Result;
import pb.unite.search.DynamicDiscovery.SpecialTopic;
import pb.unite.search.DynamicDiscovery.TopicImage;
import pb.unite.search.DynamicDiscovery.TopicItem;

public class HotWordSearchSpecialDataModel
  extends awpp
{
  public final HotWordSearchSpecialDataModel.SpecialTopic a;
  
  public HotWordSearchSpecialDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic = new HotWordSearchSpecialDataModel.SpecialTopic();
  }
  
  public HotWordSearchSpecialDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic = new HotWordSearchSpecialDataModel.SpecialTopic();
    a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject2;
    Object localObject3;
    HotWordSearchSpecialDataModel.TopicItem localTopicItem;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject1).mergeFrom(paramArrayOfByte);
        if (((DynamicDiscovery.Result)localObject1).special_topic_item.has())
        {
          paramArrayOfByte = (DynamicDiscovery.SpecialTopic)((DynamicDiscovery.Result)localObject1).special_topic_item.get();
          if (paramArrayOfByte.topic_title.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.title = paramArrayOfByte.topic_title.get().toStringUtf8();
          }
          if (paramArrayOfByte.title_color.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.titleColor = paramArrayOfByte.title_color.get().toStringUtf8();
          }
          if (paramArrayOfByte.icon_url.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.iconUrl = paramArrayOfByte.icon_url.get().toStringUtf8();
          }
          if (paramArrayOfByte.jump_url.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.jumpUrl = paramArrayOfByte.jump_url.get().toStringUtf8();
          }
          if (paramArrayOfByte.show_type.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.showType = paramArrayOfByte.show_type.get();
          }
          if (paramArrayOfByte.left_icon_url.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.leftIconUrl = paramArrayOfByte.left_icon_url.get().toStringUtf8();
          }
          if (paramArrayOfByte.more_text.has()) {
            this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.moreText = paramArrayOfByte.more_text.get().toStringUtf8();
          }
          if (paramArrayOfByte.topic_items.has())
          {
            localObject2 = paramArrayOfByte.topic_items.get();
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (DynamicDiscovery.TopicItem)((Iterator)localObject2).next();
              localTopicItem = new HotWordSearchSpecialDataModel.TopicItem();
              if (((DynamicDiscovery.TopicItem)localObject3).trait_title.has()) {
                localTopicItem.title = ((DynamicDiscovery.TopicItem)localObject3).trait_title.get().toStringUtf8();
              }
              if (((DynamicDiscovery.TopicItem)localObject3).title_color.has()) {
                localTopicItem.titleColor = ((DynamicDiscovery.TopicItem)localObject3).title_color.get().toStringUtf8();
              }
              if (((DynamicDiscovery.TopicItem)localObject3).config_time.has()) {
                localTopicItem.configTime = ((DynamicDiscovery.TopicItem)localObject3).config_time.get().toStringUtf8();
              }
              if (((DynamicDiscovery.TopicItem)localObject3).config_color.has()) {
                localTopicItem.configColor = ((DynamicDiscovery.TopicItem)localObject3).config_color.get().toStringUtf8();
              }
              if (((DynamicDiscovery.TopicItem)localObject3).jump_url.has()) {
                localTopicItem.jumpUrl = ((DynamicDiscovery.TopicItem)localObject3).jump_url.get().toStringUtf8();
              }
              ((List)localObject1).add(localTopicItem);
            }
          }
        }
        else
        {
          QLog.d("SearchEntryDataModel818searchProto_old", 2, "fabricateModel");
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SearchEntryDataModel", 2, "fabricateModel,DynamicDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
        }
      }
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.topicItems = ((List)localObject1);
        if (paramArrayOfByte.topic_images.has())
        {
          localObject1 = paramArrayOfByte.topic_images.get();
          paramArrayOfByte = new ArrayList();
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (DynamicDiscovery.TopicImage)((Iterator)localObject1).next();
            localObject3 = new HotWordSearchSpecialDataModel.TopicImage();
            if (((DynamicDiscovery.TopicImage)localObject2).image_url.has()) {
              ((HotWordSearchSpecialDataModel.TopicImage)localObject3).imageUrl = ((DynamicDiscovery.TopicImage)localObject2).image_url.get().toStringUtf8();
            }
            if (((DynamicDiscovery.TopicImage)localObject2).image_text.has()) {
              ((HotWordSearchSpecialDataModel.TopicImage)localObject3).imageText = ((DynamicDiscovery.TopicImage)localObject2).image_text.get().toStringUtf8();
            }
            if (((DynamicDiscovery.TopicImage)localObject2).jump_url.has()) {
              ((HotWordSearchSpecialDataModel.TopicImage)localObject3).jumpUrl = ((DynamicDiscovery.TopicImage)localObject2).jump_url.get().toStringUtf8();
            }
            paramArrayOfByte.add(localObject3);
          }
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.topicImages = paramArrayOfByte;
        }
      }
    }
    Object localObject1 = new UnifySearchDiscovery.Result();
    try
    {
      ((UnifySearchDiscovery.Result)localObject1).mergeFrom(paramArrayOfByte);
      if (((UnifySearchDiscovery.Result)localObject1).special_topic_item.has())
      {
        paramArrayOfByte = (UnifySearchDiscovery.SpecialTopic)((UnifySearchDiscovery.Result)localObject1).special_topic_item.get();
        if (paramArrayOfByte.topic_title.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.title = paramArrayOfByte.topic_title.get().toStringUtf8();
        }
        if (paramArrayOfByte.title_color.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.titleColor = paramArrayOfByte.title_color.get().toStringUtf8();
        }
        if (paramArrayOfByte.icon_url.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.iconUrl = paramArrayOfByte.icon_url.get().toStringUtf8();
        }
        if (paramArrayOfByte.jump_url.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.jumpUrl = paramArrayOfByte.jump_url.get().toStringUtf8();
        }
        if (paramArrayOfByte.show_type.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.showType = paramArrayOfByte.show_type.get();
        }
        if (paramArrayOfByte.left_icon_url.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.leftIconUrl = paramArrayOfByte.left_icon_url.get().toStringUtf8();
        }
        if (paramArrayOfByte.more_text.has()) {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.moreText = paramArrayOfByte.more_text.get().toStringUtf8();
        }
        if (paramArrayOfByte.topic_items.has())
        {
          localObject2 = paramArrayOfByte.topic_items.get();
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (UnifySearchDiscovery.TopicItem)((Iterator)localObject2).next();
            localTopicItem = new HotWordSearchSpecialDataModel.TopicItem();
            if (((UnifySearchDiscovery.TopicItem)localObject3).trait_title.has()) {
              localTopicItem.title = ((UnifySearchDiscovery.TopicItem)localObject3).trait_title.get().toStringUtf8();
            }
            if (((UnifySearchDiscovery.TopicItem)localObject3).title_color.has()) {
              localTopicItem.titleColor = ((UnifySearchDiscovery.TopicItem)localObject3).title_color.get().toStringUtf8();
            }
            if (((UnifySearchDiscovery.TopicItem)localObject3).config_time.has()) {
              localTopicItem.configTime = ((UnifySearchDiscovery.TopicItem)localObject3).config_time.get().toStringUtf8();
            }
            if (((UnifySearchDiscovery.TopicItem)localObject3).config_color.has()) {
              localTopicItem.configColor = ((UnifySearchDiscovery.TopicItem)localObject3).config_color.get().toStringUtf8();
            }
            if (((UnifySearchDiscovery.TopicItem)localObject3).jump_url.has()) {
              localTopicItem.jumpUrl = ((UnifySearchDiscovery.TopicItem)localObject3).jump_url.get().toStringUtf8();
            }
            ((List)localObject1).add(localTopicItem);
          }
        }
      }
      else
      {
        QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchEntryDataModel", 2, "fabricateModel, UnifySearchDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.topicItems = ((List)localObject1);
      if (paramArrayOfByte.topic_images.has())
      {
        localObject1 = paramArrayOfByte.topic_images.get();
        paramArrayOfByte = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (UnifySearchDiscovery.TopicImage)((Iterator)localObject1).next();
          localObject3 = new HotWordSearchSpecialDataModel.TopicImage();
          if (((UnifySearchDiscovery.TopicImage)localObject2).image_url.has()) {
            ((HotWordSearchSpecialDataModel.TopicImage)localObject3).imageUrl = ((UnifySearchDiscovery.TopicImage)localObject2).image_url.get().toStringUtf8();
          }
          if (((UnifySearchDiscovery.TopicImage)localObject2).image_text.has()) {
            ((HotWordSearchSpecialDataModel.TopicImage)localObject3).imageText = ((UnifySearchDiscovery.TopicImage)localObject2).image_text.get().toStringUtf8();
          }
          if (((UnifySearchDiscovery.TopicImage)localObject2).jump_url.has()) {
            ((HotWordSearchSpecialDataModel.TopicImage)localObject3).jumpUrl = ((UnifySearchDiscovery.TopicImage)localObject2).jump_url.get().toStringUtf8();
          }
          paramArrayOfByte.add(localObject3);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchSpecialDataModel$SpecialTopic.topicImages = paramArrayOfByte;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchSpecialDataModel
 * JD-Core Version:    0.7.0.1
 */