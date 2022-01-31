package com.tencent.mobileqq.search.model;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import awob;
import awpn;
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
  extends awpn
{
  public final awob a;
  public final HotWordSearchEntryDataModel.GIFInfo a;
  public final List<HotWordSearchEntryDataModel.HotSearchItem> a;
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Awob = new awob(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo = new HotWordSearchEntryDataModel.GIFInfo();
  }
  
  public HotWordSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Awob = new awob(this);
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
    Object localObject;
    HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem;
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).hot_search_gif_item;
        if (paramArrayOfByte != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrl = paramArrayOfByte.gif_url.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifUrlNight = paramArrayOfByte.gif_url_night.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotSearchGifID = paramArrayOfByte.gif_id.get().toStringUtf8();
        }
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).hot_wrod_gif_item;
        if (paramArrayOfByte != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrl = paramArrayOfByte.gif_url.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$GIFInfo.hotWordGifUrlNight = paramArrayOfByte.gif_url_night.get().toStringUtf8();
        }
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).hot_search_items.get();
        localObject = (DynamicDiscovery.TitleHeaderItem)((DynamicDiscovery.Result)localObject).title_header.get();
        this.jdField_a_of_type_Awob.b = ((DynamicDiscovery.TitleHeaderItem)localObject).icon_url.get().toStringUtf8();
        this.jdField_a_of_type_Awob.jdField_a_of_type_JavaLangString = ((DynamicDiscovery.TitleHeaderItem)localObject).title.get().toStringUtf8();
        this.jdField_a_of_type_Awob.c = ((DynamicDiscovery.TitleHeaderItem)localObject).morn_text.get().toStringUtf8();
        this.jdField_a_of_type_Awob.d = ((DynamicDiscovery.TitleHeaderItem)localObject).morn_url.get().toStringUtf8();
        this.jdField_a_of_type_Awob.jdField_a_of_type_Int = ((DynamicDiscovery.TitleHeaderItem)localObject).header_type.get();
        if (((DynamicDiscovery.TitleHeaderItem)localObject).qq_index_jump_url.has()) {
          this.jdField_a_of_type_Awob.e = ((DynamicDiscovery.TitleHeaderItem)localObject).qq_index_jump_url.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        if (!a(this.b, false))
        {
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject = (DynamicDiscovery.HotSearchItem)paramArrayOfByte.next();
            localHotSearchItem = new HotWordSearchEntryDataModel.HotSearchItem();
            localHotSearchItem.title = ((DynamicDiscovery.HotSearchItem)localObject).title.get().toStringUtf8();
            localHotSearchItem.imgUrl = ((DynamicDiscovery.HotSearchItem)localObject).img_url.get().toStringUtf8();
            localHotSearchItem.detailText = ((DynamicDiscovery.HotSearchItem)localObject).detail_text.get().toStringUtf8();
            localHotSearchItem.jumpUrl = ((DynamicDiscovery.HotSearchItem)localObject).jump_url.get().toStringUtf8();
            localHotSearchItem.indexTextColor = ((DynamicDiscovery.HotSearchItem)localObject).mark_text_color.get().toStringUtf8();
            localHotSearchItem.indexBgColor = ((DynamicDiscovery.HotSearchItem)localObject).mark_bg_color.get().toStringUtf8();
            localHotSearchItem.imgBgUrl = ((DynamicDiscovery.HotSearchItem)localObject).img_bg_url.get().toStringUtf8();
            localHotSearchItem.titleTextColor = ((DynamicDiscovery.HotSearchItem)localObject).text_color.get().toStringUtf8();
            localHotSearchItem.rightIconUrl = ((DynamicDiscovery.HotSearchItem)localObject).right_icon_url.get().toStringUtf8();
            this.jdField_a_of_type_JavaUtilList.add(localHotSearchItem);
          }
        }
        localObject = new UnifySearchDiscovery.Result();
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
      ((UnifySearchDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
      localObject = (UnifySearchDiscovery.TitleHeaderItem)((UnifySearchDiscovery.Result)localObject).title_header.get();
      this.jdField_a_of_type_Awob.b = ((UnifySearchDiscovery.TitleHeaderItem)localObject).icon_url.get().toStringUtf8();
      this.jdField_a_of_type_Awob.jdField_a_of_type_JavaLangString = ((UnifySearchDiscovery.TitleHeaderItem)localObject).title.get().toStringUtf8();
      this.jdField_a_of_type_Awob.c = ((UnifySearchDiscovery.TitleHeaderItem)localObject).morn_text.get().toStringUtf8();
      this.jdField_a_of_type_Awob.d = ((UnifySearchDiscovery.TitleHeaderItem)localObject).morn_url.get().toStringUtf8();
      this.jdField_a_of_type_Awob.jdField_a_of_type_Int = ((UnifySearchDiscovery.TitleHeaderItem)localObject).header_type.get();
      if (((UnifySearchDiscovery.TitleHeaderItem)localObject).qq_index_jump_url.has()) {
        this.jdField_a_of_type_Awob.e = ((UnifySearchDiscovery.TitleHeaderItem)localObject).qq_index_jump_url.get().toStringUtf8();
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      if (!a(this.b, true))
      {
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject = (UnifySearchDiscovery.HotSearchItem)paramArrayOfByte.next();
          localHotSearchItem = new HotWordSearchEntryDataModel.HotSearchItem();
          localHotSearchItem.title = ((UnifySearchDiscovery.HotSearchItem)localObject).title.get().toStringUtf8();
          localHotSearchItem.imgUrl = ((UnifySearchDiscovery.HotSearchItem)localObject).img_url.get().toStringUtf8();
          localHotSearchItem.detailText = ((UnifySearchDiscovery.HotSearchItem)localObject).detail_text.get().toStringUtf8();
          localHotSearchItem.jumpUrl = ((UnifySearchDiscovery.HotSearchItem)localObject).jump_url.get().toStringUtf8();
          localHotSearchItem.indexTextColor = ((UnifySearchDiscovery.HotSearchItem)localObject).mark_text_color.get().toStringUtf8();
          localHotSearchItem.indexBgColor = ((UnifySearchDiscovery.HotSearchItem)localObject).mark_bg_color.get().toStringUtf8();
          localHotSearchItem.imgBgUrl = ((UnifySearchDiscovery.HotSearchItem)localObject).img_bg_url.get().toStringUtf8();
          localHotSearchItem.titleTextColor = ((UnifySearchDiscovery.HotSearchItem)localObject).text_color.get().toStringUtf8();
          localHotSearchItem.rightIconUrl = ((UnifySearchDiscovery.HotSearchItem)localObject).right_icon_url.get().toStringUtf8();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */