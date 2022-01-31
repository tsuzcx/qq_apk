package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aynp;
import aypb;
import com.tencent.common.app.BaseApplicationImpl;
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
import mqq.app.AppRuntime;
import pb.unify.search.UnifySearchDiscovery.HotSearchItem;
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unify.search.UnifySearchDiscovery.TitleHeaderItem;
import pb.unite.search.DynamicDiscovery.GifInfoItem;
import pb.unite.search.DynamicDiscovery.HotSearchItem;
import pb.unite.search.DynamicDiscovery.Result;
import pb.unite.search.DynamicDiscovery.TitleHeaderItem;

public class HotWordSearchEntryDataModel
  extends aypb
{
  public final aynp a;
  public final HotWordSearchEntryDataModel.GIFInfo a;
  public final List<HotWordSearchEntryDataModel.HotSearchItem> a;
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aynp = new aynp(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
  }
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aynp = new aynp(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
    a(paramArrayOfByte);
  }
  
  public static boolean a(int paramInt, boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (localAppRuntime != null)
    {
      if (!paramBoolean) {}
      for (long l = localSharedPreferences.getLong("search_discovery_sp_prefixlast_update_time" + localAppRuntime.getAccount() + "_" + paramInt, 0L); System.currentTimeMillis() - l > 86400000L; l = localSharedPreferences.getLong("search_discovery_sp_prefix_unifylast_update_time" + localAppRuntime.getAccount() + "_" + paramInt, 0L)) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1;
    Iterator localIterator;
    Object localObject2;
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject1).hot_search_gif_item;
        if (paramArrayOfByte != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrl = paramArrayOfByte.gif_url.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrlNight = paramArrayOfByte.gif_url_night.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID = paramArrayOfByte.gif_id.get().toStringUtf8();
        }
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject1).hot_wrod_gif_item;
        if (paramArrayOfByte != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrl = paramArrayOfByte.gif_url.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrlNight = paramArrayOfByte.gif_url_night.get().toStringUtf8();
        }
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject1).hot_search_items.get();
        localObject1 = (DynamicDiscovery.TitleHeaderItem)((DynamicDiscovery.Result)localObject1).title_header.get();
        this.jdField_a_of_type_Aynp.b = ((DynamicDiscovery.TitleHeaderItem)localObject1).icon_url.get().toStringUtf8();
        this.jdField_a_of_type_Aynp.jdField_a_of_type_JavaLangString = ((DynamicDiscovery.TitleHeaderItem)localObject1).title.get().toStringUtf8();
        this.jdField_a_of_type_Aynp.c = ((DynamicDiscovery.TitleHeaderItem)localObject1).morn_text.get().toStringUtf8();
        this.jdField_a_of_type_Aynp.d = ((DynamicDiscovery.TitleHeaderItem)localObject1).morn_url.get().toStringUtf8();
        this.jdField_a_of_type_Aynp.jdField_a_of_type_Int = ((DynamicDiscovery.TitleHeaderItem)localObject1).header_type.get();
        if (((DynamicDiscovery.TitleHeaderItem)localObject1).qq_index_jump_url.has()) {
          this.jdField_a_of_type_Aynp.e = ((DynamicDiscovery.TitleHeaderItem)localObject1).qq_index_jump_url.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        if (!a(this.b, false))
        {
          localIterator = paramArrayOfByte.iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (DynamicDiscovery.HotSearchItem)localIterator.next();
            localHotSearchItem = new HotWordSearchEntryDataModel.HotSearchItem();
            localHotSearchItem.title = ((DynamicDiscovery.HotSearchItem)localObject2).title.get().toStringUtf8();
            localObject1 = ((DynamicDiscovery.HotSearchItem)localObject2).recall_word.get().toStringUtf8();
            paramArrayOfByte = (byte[])localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramArrayOfByte = localHotSearchItem.title;
            }
            localHotSearchItem.recallWord = paramArrayOfByte;
            localHotSearchItem.imgUrl = ((DynamicDiscovery.HotSearchItem)localObject2).img_url.get().toStringUtf8();
            localHotSearchItem.detailText = ((DynamicDiscovery.HotSearchItem)localObject2).detail_text.get().toStringUtf8();
            localHotSearchItem.jumpUrl = ((DynamicDiscovery.HotSearchItem)localObject2).jump_url.get().toStringUtf8();
            localHotSearchItem.indexTextColor = ((DynamicDiscovery.HotSearchItem)localObject2).mark_text_color.get().toStringUtf8();
            localHotSearchItem.indexBgColor = ((DynamicDiscovery.HotSearchItem)localObject2).mark_bg_color.get().toStringUtf8();
            localHotSearchItem.imgBgUrl = ((DynamicDiscovery.HotSearchItem)localObject2).img_bg_url.get().toStringUtf8();
            localHotSearchItem.titleTextColor = ((DynamicDiscovery.HotSearchItem)localObject2).text_color.get().toStringUtf8();
            localHotSearchItem.rightIconUrl = ((DynamicDiscovery.HotSearchItem)localObject2).right_icon_url.get().toStringUtf8();
            this.jdField_a_of_type_JavaUtilList.add(localHotSearchItem);
          }
        }
        localObject1 = new UnifySearchDiscovery.Result();
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SearchEntryDataModel", 2, "fabricateModel, DynamicDiscovery InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
        }
        QLog.d("SearchEntryDataModel818searchProto_old", 2, "fabricateModel");
        return;
      }
    }
    try
    {
      ((UnifySearchDiscovery.Result)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = ((UnifySearchDiscovery.Result)localObject1).hot_search_items.get();
      localObject1 = (UnifySearchDiscovery.TitleHeaderItem)((UnifySearchDiscovery.Result)localObject1).title_header.get();
      this.jdField_a_of_type_Aynp.b = ((UnifySearchDiscovery.TitleHeaderItem)localObject1).icon_url.get().toStringUtf8();
      this.jdField_a_of_type_Aynp.jdField_a_of_type_JavaLangString = ((UnifySearchDiscovery.TitleHeaderItem)localObject1).title.get().toStringUtf8();
      this.jdField_a_of_type_Aynp.c = ((UnifySearchDiscovery.TitleHeaderItem)localObject1).morn_text.get().toStringUtf8();
      this.jdField_a_of_type_Aynp.d = ((UnifySearchDiscovery.TitleHeaderItem)localObject1).morn_url.get().toStringUtf8();
      this.jdField_a_of_type_Aynp.jdField_a_of_type_Int = ((UnifySearchDiscovery.TitleHeaderItem)localObject1).header_type.get();
      if (((UnifySearchDiscovery.TitleHeaderItem)localObject1).qq_index_jump_url.has()) {
        this.jdField_a_of_type_Aynp.e = ((UnifySearchDiscovery.TitleHeaderItem)localObject1).qq_index_jump_url.get().toStringUtf8();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (!a(this.b, true))
      {
        localIterator = paramArrayOfByte.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (UnifySearchDiscovery.HotSearchItem)localIterator.next();
          localHotSearchItem = new HotWordSearchEntryDataModel.HotSearchItem();
          localHotSearchItem.title = ((UnifySearchDiscovery.HotSearchItem)localObject2).title.get().toStringUtf8();
          localObject1 = ((UnifySearchDiscovery.HotSearchItem)localObject2).recall_word.get().toStringUtf8();
          paramArrayOfByte = (byte[])localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramArrayOfByte = localHotSearchItem.title;
          }
          localHotSearchItem.recallWord = paramArrayOfByte;
          localHotSearchItem.imgUrl = ((UnifySearchDiscovery.HotSearchItem)localObject2).img_url.get().toStringUtf8();
          localHotSearchItem.detailText = ((UnifySearchDiscovery.HotSearchItem)localObject2).detail_text.get().toStringUtf8();
          localHotSearchItem.jumpUrl = ((UnifySearchDiscovery.HotSearchItem)localObject2).jump_url.get().toStringUtf8();
          localHotSearchItem.indexTextColor = ((UnifySearchDiscovery.HotSearchItem)localObject2).mark_text_color.get().toStringUtf8();
          localHotSearchItem.indexBgColor = ((UnifySearchDiscovery.HotSearchItem)localObject2).mark_bg_color.get().toStringUtf8();
          localHotSearchItem.imgBgUrl = ((UnifySearchDiscovery.HotSearchItem)localObject2).img_bg_url.get().toStringUtf8();
          localHotSearchItem.titleTextColor = ((UnifySearchDiscovery.HotSearchItem)localObject2).text_color.get().toStringUtf8();
          localHotSearchItem.rightIconUrl = ((UnifySearchDiscovery.HotSearchItem)localObject2).right_icon_url.get().toStringUtf8();
          this.jdField_a_of_type_JavaUtilList.add(localHotSearchItem);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchEntryDataModel", 2, "fabricateModel, InvalidProtocolBufferMicroException e = " + paramArrayOfByte);
      }
      QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */