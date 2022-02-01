package com.tencent.mobileqq.data;

import com.tencent.mobileqq.mp.publicaccount_recommend.BusinessRecommend;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublicRecommendAccountInfo
  extends Entity
{
  private static final String TAG = "PublicRecommendAccountInfo";
  public int accountflag = -1;
  public String mEqqCategory;
  public String mEqqCs;
  public long mEqqKfuin;
  public String mEqqNameAccount;
  public String mEqqSi;
  public int mFilter;
  public String mIconLinkAddr;
  public String mIsVerified;
  @unique
  public int mListid;
  public String mPublicaccount;
  public String mPublicdesc;
  public String mPublicname;
  public long mPublicuin;
  public int mSource;
  
  public static PublicRecommendAccountInfo createPublicRecommendAccountInfo(publicaccount_recommend.BusinessRecommend paramBusinessRecommend)
  {
    PublicRecommendAccountInfo localPublicRecommendAccountInfo = new PublicRecommendAccountInfo();
    if (paramBusinessRecommend.id.has()) {
      localPublicRecommendAccountInfo.mListid = paramBusinessRecommend.id.get();
    }
    if (paramBusinessRecommend.source.has()) {
      localPublicRecommendAccountInfo.mSource = paramBusinessRecommend.source.get();
    }
    if (paramBusinessRecommend.uin.has()) {
      localPublicRecommendAccountInfo.mPublicuin = paramBusinessRecommend.uin.get();
    }
    if (paramBusinessRecommend.name.has()) {
      localPublicRecommendAccountInfo.mPublicname = paramBusinessRecommend.name.get();
    }
    if (paramBusinessRecommend.account.has()) {
      localPublicRecommendAccountInfo.mPublicaccount = paramBusinessRecommend.account.get();
    }
    if (paramBusinessRecommend.desc.has()) {
      localPublicRecommendAccountInfo.mPublicdesc = paramBusinessRecommend.desc.get();
    }
    if (paramBusinessRecommend.nameAccount.has()) {
      localPublicRecommendAccountInfo.mEqqNameAccount = paramBusinessRecommend.nameAccount.get();
    }
    if (paramBusinessRecommend.kfuin.has()) {
      localPublicRecommendAccountInfo.mEqqKfuin = paramBusinessRecommend.kfuin.get();
    }
    if (paramBusinessRecommend.si.has()) {
      localPublicRecommendAccountInfo.mEqqSi = paramBusinessRecommend.si.get();
    }
    if (paramBusinessRecommend.cs.has()) {
      localPublicRecommendAccountInfo.mEqqCs = paramBusinessRecommend.cs.get();
    }
    if (paramBusinessRecommend.category.has()) {
      localPublicRecommendAccountInfo.mEqqCategory = paramBusinessRecommend.category.get();
    }
    if (paramBusinessRecommend.ic.has()) {
      localPublicRecommendAccountInfo.mIconLinkAddr = paramBusinessRecommend.ic.get();
    }
    if (paramBusinessRecommend.isverified.has()) {
      localPublicRecommendAccountInfo.mIsVerified = paramBusinessRecommend.isverified.get();
    }
    if (paramBusinessRecommend.filter.has()) {
      localPublicRecommendAccountInfo.mFilter = paramBusinessRecommend.filter.get();
    }
    if (paramBusinessRecommend.account_flag.has()) {
      localPublicRecommendAccountInfo.accountflag = paramBusinessRecommend.account_flag.get();
    }
    return localPublicRecommendAccountInfo;
  }
  
  public static List<PublicRecommendAccountInfo> createPublicRecommendAccountInfoList(List<publicaccount_recommend.BusinessRecommend> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(createPublicRecommendAccountInfo((publicaccount_recommend.BusinessRecommend)localIterator.next()));
      }
    }
    paramList = null;
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PublicRecommendAccountInfo
 * JD-Core Version:    0.7.0.1
 */