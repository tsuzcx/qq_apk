package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unify.search.UnifySearchDiscovery.SubBusinessItem;
import tencent.im.oidb.search.DynamicDiscovery.Result;
import tencent.im.oidb.search.DynamicDiscovery.SubBusinessItem;

public class BusinessSearchEntryDataModel
  extends SearchEntryDataModel
{
  public List<BusinessSearchEntryDataModel.SearchEntry> a = new ArrayList();
  
  public BusinessSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramBoolean);
  }
  
  public BusinessSearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    super(paramQQAppInterface, paramInt1, paramArrayOfByte, paramInt2, paramBoolean);
    a(paramArrayOfByte);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fabricateModel, isFromReadInjoy mTabType= ");
      localStringBuilder.append(this.h);
      QLog.d("SearchEntryDataModel", 2, localStringBuilder.toString());
    }
    return this.h == 10;
  }
  
  private void b()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = 0;
    while (i < this.a.size())
    {
      localObject3 = (BusinessSearchEntryDataModel.SearchEntry)this.a.get(i);
      if (((BusinessSearchEntryDataModel.SearchEntry)localObject3).g == 1)
      {
        localObject4 = localObject3;
      }
      else if (((BusinessSearchEntryDataModel.SearchEntry)localObject3).g == 4)
      {
        localObject4 = localObject2;
      }
      else
      {
        localObject4 = localObject2;
        if (((BusinessSearchEntryDataModel.SearchEntry)localObject3).g == 3)
        {
          localObject1 = localObject3;
          localObject4 = localObject2;
        }
      }
      i += 1;
      localObject2 = localObject4;
    }
    Object localObject3 = new ArrayList();
    Object localObject4 = new BusinessSearchEntryDataModel.SearchEntry();
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).a = HardCodeUtil.a(2131899494);
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).b = "https://qzonestyle.gtimg.cn/aoi/sola/20190816141611_NQ31kYWAQJ.png";
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).c = new long[0];
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).d = "mqqapi://contact/search_might_know";
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).e = 0;
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).f = 0;
    ((BusinessSearchEntryDataModel.SearchEntry)localObject4).g = 104;
    ((List)localObject3).add(localObject4);
    Object localObject5;
    if (SearchConfigUtils.b("emoji"))
    {
      localObject4 = SearchConfigUtils.c("emoji");
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("fabricateModel, EmojiEntrySwitchOn url= ");
        ((StringBuilder)localObject5).append((String)localObject4);
        QLog.d("SearchEntryDataModel", 2, ((StringBuilder)localObject5).toString());
      }
      localObject5 = new BusinessSearchEntryDataModel.SearchEntry();
      ((BusinessSearchEntryDataModel.SearchEntry)localObject5).a = HardCodeUtil.a(2131899507);
      ((BusinessSearchEntryDataModel.SearchEntry)localObject5).b = "https://pub.idqqimg.com/pc/misc/files/20190522/88ab43d24bc14de9a48d3ee11471b7ea.png";
      ((BusinessSearchEntryDataModel.SearchEntry)localObject5).c = new long[0];
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        ((BusinessSearchEntryDataModel.SearchEntry)localObject5).d = ((String)localObject4);
      }
      ((BusinessSearchEntryDataModel.SearchEntry)localObject5).e = 0;
      ((BusinessSearchEntryDataModel.SearchEntry)localObject5).f = 0;
      ((BusinessSearchEntryDataModel.SearchEntry)localObject5).g = 101;
      ((List)localObject3).add(localObject5);
    }
    if (localObject2 != null)
    {
      ((BusinessSearchEntryDataModel.SearchEntry)localObject2).b = "https://pub.idqqimg.com/pc/misc/files/20190522/299abcb70f194aeab89292db649698f5.png";
      if (MiniAppConfProcessor.c())
      {
        localObject4 = MiniAppConfProcessor.d();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((BusinessSearchEntryDataModel.SearchEntry)localObject2).d = ((String)localObject4);
        } else {
          ((BusinessSearchEntryDataModel.SearchEntry)localObject2).d = "mqqapi://miniapp/open?_atype=0&_mappid=1109740431&_mvid=&_vt=3&referer=2005&via=2005_4&_sig=6ee2c9e5075a2d129ac57b0a38af3fcdab417ff1fef97908d5e4806f94eb44af";
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "expo", "2", null, null);
      }
      else
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "expo", "1", null, null);
      }
      ((List)localObject3).add(localObject2);
    }
    localObject2 = new BusinessSearchEntryDataModel.SearchEntry();
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).a = HardCodeUtil.a(2131899508);
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).b = "https://qzonestyle.gtimg.cn/aoi/sola/20190529143225_pb7ADOBDqd.png";
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).c = new long[0];
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).d = "mqqapi://miniapp/open?_atype=0&_mappid=1109875297&_mvid=&_vt=3&via=2005_1&_sig=4bf2da5e43a83ba7a9e2446bf338da983e145d8c21ed6e9a3bdcb28c3f125c12";
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).e = 0;
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).f = 0;
    ((BusinessSearchEntryDataModel.SearchEntry)localObject2).g = 103;
    ((List)localObject3).add(localObject2);
    if (SearchConfigUtils.b("heihua"))
    {
      localObject4 = SearchConfigUtils.c("heihua");
      localObject5 = SearchConfigUtils.d("heihua");
      localObject2 = SearchConfigUtils.e("heihua");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("fabricateModel, isWikiEntrySwitchOn wikiUrl= ");
        ((StringBuilder)localObject1).append((String)localObject4);
        ((StringBuilder)localObject1).append(", wikiIconUrl = ");
        ((StringBuilder)localObject1).append((String)localObject5);
        QLog.d("SearchEntryDataModel", 2, ((StringBuilder)localObject1).toString());
      }
      BusinessSearchEntryDataModel.SearchEntry localSearchEntry = new BusinessSearchEntryDataModel.SearchEntry();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = HardCodeUtil.a(2131916123);
      }
      localSearchEntry.a = ((String)localObject1);
      localSearchEntry.c = new long[0];
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        localSearchEntry.d = ((String)localObject4);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        localSearchEntry.b = ((String)localObject5);
      }
      localSearchEntry.e = 0;
      localSearchEntry.f = 0;
      localSearchEntry.g = 105;
      ((List)localObject3).add(localSearchEntry);
    }
    else if ((localObject1 != null) && (!StudyModeManager.h()))
    {
      ((BusinessSearchEntryDataModel.SearchEntry)localObject1).b = "https://pub.idqqimg.com/pc/misc/files/20190522/cd2f6f83d9814d529c5efed2b45dbecd.png";
      ((List)localObject3).add(localObject1);
    }
    localObject1 = new BusinessSearchEntryDataModel.SearchEntry();
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).a = HardCodeUtil.a(2131899489);
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).b = "https://pub.idqqimg.com/pc/misc/files/20190522/7b5f61f779db42e38d8d8b6757a72e1b.png";
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).c = new long[0];
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).d = "https://h5.qzone.qq.com/qzone/ugcsearch?_wv=17039363&_wwv=1293&_proxy=1";
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).e = 0;
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).f = 0;
    ((BusinessSearchEntryDataModel.SearchEntry)localObject1).g = 102;
    ((List)localObject3).add(localObject1);
    this.a.clear();
    this.a.addAll((Collection)localObject3);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    int i;
    BusinessSearchEntryDataModel.SearchEntry localSearchEntry;
    List localList;
    int j;
    if (!this.k)
    {
      localObject = new DynamicDiscovery.Result();
      try
      {
        ((DynamicDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((DynamicDiscovery.Result)localObject).sub_business_items.get();
        i = 0;
        while (i < paramArrayOfByte.size())
        {
          localObject = (DynamicDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
          localSearchEntry = new BusinessSearchEntryDataModel.SearchEntry();
          localSearchEntry.a = ((DynamicDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
          localSearchEntry.b = ((DynamicDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
          localList = ((DynamicDiscovery.SubBusinessItem)localObject).group_masks.get();
          localSearchEntry.c = new long[localList.size()];
          j = 0;
          while (j < localList.size())
          {
            localSearchEntry.c[j] = ((Long)localList.get(j)).longValue();
            j += 1;
          }
          localSearchEntry.d = ((DynamicDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
          localSearchEntry.e = ((DynamicDiscovery.SubBusinessItem)localObject).has_red_dot.get();
          localSearchEntry.f = ((DynamicDiscovery.SubBusinessItem)localObject).red_seq.get();
          localSearchEntry.g = ((DynamicDiscovery.SubBusinessItem)localObject).bzid.get();
          this.a.add(localSearchEntry);
          i += 1;
        }
        if (!a()) {
          b();
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fabricateModel, DynamicDiscovery InvalidProtocolBufferMicroException e = ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.e("SearchEntryDataModel", 2, ((StringBuilder)localObject).toString());
        }
      }
      QLog.d("SearchEntryDataModel818searchProto_old", 2, "fabricateModel");
      return;
    }
    Object localObject = new UnifySearchDiscovery.Result();
    try
    {
      ((UnifySearchDiscovery.Result)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = ((UnifySearchDiscovery.Result)localObject).sub_business_items.get();
      i = 0;
      while (i < paramArrayOfByte.size())
      {
        localObject = (UnifySearchDiscovery.SubBusinessItem)paramArrayOfByte.get(i);
        localSearchEntry = new BusinessSearchEntryDataModel.SearchEntry();
        localSearchEntry.a = ((UnifySearchDiscovery.SubBusinessItem)localObject).title.get().toStringUtf8();
        localSearchEntry.b = ((UnifySearchDiscovery.SubBusinessItem)localObject).icon_url.get().toStringUtf8();
        localList = ((UnifySearchDiscovery.SubBusinessItem)localObject).group_masks.get();
        localSearchEntry.c = new long[localList.size()];
        j = 0;
        while (j < localList.size())
        {
          localSearchEntry.c[j] = ((Long)localList.get(j)).longValue();
          j += 1;
        }
        localSearchEntry.d = ((UnifySearchDiscovery.SubBusinessItem)localObject).jump_url.get().toStringUtf8();
        localSearchEntry.e = ((UnifySearchDiscovery.SubBusinessItem)localObject).has_red_dot.get();
        localSearchEntry.f = ((UnifySearchDiscovery.SubBusinessItem)localObject).red_seq.get();
        localSearchEntry.g = ((UnifySearchDiscovery.SubBusinessItem)localObject).bzid.get();
        this.a.add(localSearchEntry);
        i += 1;
      }
      if (!a()) {
        b();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fabricateModel, UnifySearchDiscovery InvalidProtocolBufferMicroException e = ");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.e("SearchEntryDataModel", 2, ((StringBuilder)localObject).toString());
      }
    }
    QLog.d("SearchEntryDataModel818searchProto_new", 2, "fabricateModel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */