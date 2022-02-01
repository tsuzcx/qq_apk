package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.qphone.base.util.QLog;

public abstract class IContactSearchable
  implements ISearchable
{
  public static long A = SearchConfig.indexMiddle << SearchConfig.contactSearchIndexBaseBit;
  public static long B = 72057594037927936L;
  public static long C = SearchConfig.typeDiscussionMatchMemberFull << SearchConfig.contactSearchTypeBaseBit;
  public static long D = SearchConfig.typeFriendConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long E = SearchConfig.typeDiscussionConversationMatchTitle << SearchConfig.contactSearchTypeBaseBit;
  public static long F = SearchConfig.typeDiscussionConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long G = SearchConfig.typeTroopConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long H = SearchConfig.typeFriendSpecialCare << SearchConfig.contactSearchTypeBaseBit;
  public static long I = SearchConfig.typeFriend << SearchConfig.contactSearchTypeBaseBit;
  public static long J = SearchConfig.typeFriendNotOftenContact << SearchConfig.contactSearchTypeBaseBit;
  public static long K = SearchConfig.typeNewTroopMember << SearchConfig.contactSearchTypeBaseBit;
  public static long L = SearchConfig.typeDiscussionMember << SearchConfig.contactSearchTypeBaseBit;
  public static long M = SearchConfig.typePhoneContact << SearchConfig.contactSearchTypeBaseBit;
  public static long N = SearchConfig.typeDiscussionConversationMatchMember << SearchConfig.contactSearchTypeBaseBit;
  public static long O = SearchConfig.typeNewTroop << SearchConfig.contactSearchTypeBaseBit;
  public static long P = SearchConfig.typeDiscussion << SearchConfig.contactSearchTypeBaseBit;
  public static long Q = SearchConfig.typeTroop << SearchConfig.contactSearchTypeBaseBit;
  public static long R = SearchConfig.typeTool << SearchConfig.contactSearchTypeBaseBit;
  public static long S = SearchConfig.typePublicAccountConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long T = SearchConfig.typePublicAccount << SearchConfig.contactSearchTypeBaseBit;
  public static long U = SearchConfig.typeUnbindPhoneContact << SearchConfig.contactSearchTypeBaseBit;
  public static long V = SearchConfig.typeCircleContact << SearchConfig.contactSearchTypeBaseBit;
  public static long W = SearchConfig.typeTroopMember << SearchConfig.contactSearchTypeBaseBit;
  public static long X = SearchConfig.typeGlobalTroop << SearchConfig.contactSearchTypeBaseBit;
  public static long Y = SearchConfig.typeGlobalTroopConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long Z = SearchConfig.typeGlobalTroopMember << SearchConfig.contactSearchTypeBaseBit;
  public static long aa = SearchConfig.typeQidianMaster << SearchConfig.contactSearchTypeBaseBit;
  public static long e = SearchConfig.fieldPublicAccountName << SearchConfig.contactSearchFieldBaseBit;
  public static long f = SearchConfig.fieldPublicAccountMark << SearchConfig.contactSearchFieldBaseBit;
  public static long g = SearchConfig.fieldPublicAccountSummary << SearchConfig.contactSearchFieldBaseBit;
  public static long h = SearchConfig.fieldPublicAccountDisplayName << SearchConfig.contactSearchFieldBaseBit;
  public static long i = SearchConfig.filedDiscussionName << SearchConfig.contactSearchFieldBaseBit;
  public static long j = SearchConfig.fieldTroopName << SearchConfig.contactSearchFieldBaseBit;
  public static long k = SearchConfig.fieldRemark << SearchConfig.contactSearchFieldBaseBit;
  public static long l = SearchConfig.fieldNewTroopNickName << SearchConfig.contactSearchFieldBaseBit;
  public static long m = SearchConfig.fieldNewTroopCard << SearchConfig.contactSearchFieldBaseBit;
  public static long n = SearchConfig.fieldDiscussionMemberRemark << SearchConfig.contactSearchFieldBaseBit;
  public static long o = SearchConfig.fieldInteRemark << SearchConfig.contactSearchFieldBaseBit;
  public static long p = SearchConfig.fieldNickName << SearchConfig.contactSearchFieldBaseBit;
  public static long q = SearchConfig.fieldPhoneContactName << SearchConfig.contactSearchFieldBaseBit;
  public static long r = SearchConfig.fieldAlias << SearchConfig.contactSearchFieldBaseBit;
  public static long s = SearchConfig.fieldUin << SearchConfig.contactSearchFieldBaseBit;
  public static long t = SearchConfig.fieldMobileNo << SearchConfig.contactSearchFieldBaseBit;
  public static long u = SearchConfig.fieldTroopCard << SearchConfig.contactSearchFieldBaseBit;
  public static long v = SearchConfig.stringOrigin << SearchConfig.contactSearchPinyinBaseBit;
  public static long w = SearchConfig.stringPinyin << SearchConfig.contactSearchPinyinBaseBit;
  public static long x = SearchConfig.recentTrue << SearchConfig.contactSearchRecentBaseBit;
  public static long y = SearchConfig.indexEqual << SearchConfig.contactSearchIndexBaseBit;
  public static long z = SearchConfig.indexStart << SearchConfig.contactSearchIndexBaseBit;
  protected long ab;
  protected long ac = -1L;
  protected long ad;
  protected long ae;
  
  public static void m()
  {
    e = SearchConfig.fieldPublicAccountName << SearchConfig.contactSearchFieldBaseBit;
    f = SearchConfig.fieldPublicAccountMark << SearchConfig.contactSearchFieldBaseBit;
    g = SearchConfig.fieldPublicAccountSummary << SearchConfig.contactSearchFieldBaseBit;
    h = SearchConfig.fieldPublicAccountDisplayName << SearchConfig.contactSearchFieldBaseBit;
    i = SearchConfig.filedDiscussionName << SearchConfig.contactSearchFieldBaseBit;
    j = SearchConfig.fieldTroopName << SearchConfig.contactSearchFieldBaseBit;
    k = SearchConfig.fieldRemark << SearchConfig.contactSearchFieldBaseBit;
    l = SearchConfig.fieldNewTroopNickName << SearchConfig.contactSearchFieldBaseBit;
    m = SearchConfig.fieldNewTroopCard << SearchConfig.contactSearchFieldBaseBit;
    n = SearchConfig.fieldDiscussionMemberRemark << SearchConfig.contactSearchFieldBaseBit;
    o = SearchConfig.fieldInteRemark << SearchConfig.contactSearchFieldBaseBit;
    p = SearchConfig.fieldNickName << SearchConfig.contactSearchFieldBaseBit;
    q = SearchConfig.fieldPhoneContactName << SearchConfig.contactSearchFieldBaseBit;
    r = SearchConfig.fieldAlias << SearchConfig.contactSearchFieldBaseBit;
    s = SearchConfig.fieldUin << SearchConfig.contactSearchFieldBaseBit;
    t = SearchConfig.fieldMobileNo << SearchConfig.contactSearchFieldBaseBit;
    u = SearchConfig.fieldTroopCard << SearchConfig.contactSearchFieldBaseBit;
    v = SearchConfig.stringOrigin << SearchConfig.contactSearchPinyinBaseBit;
    w = SearchConfig.stringPinyin << SearchConfig.contactSearchPinyinBaseBit;
    x = SearchConfig.recentTrue << SearchConfig.contactSearchRecentBaseBit;
    y = SearchConfig.indexEqual << SearchConfig.contactSearchIndexBaseBit;
    z = SearchConfig.indexStart << SearchConfig.contactSearchIndexBaseBit;
    A = SearchConfig.indexMiddle << SearchConfig.contactSearchIndexBaseBit;
    B = 72057594037927936L;
    C = SearchConfig.typeDiscussionMatchMemberFull << SearchConfig.contactSearchTypeBaseBit;
    D = SearchConfig.typeFriendConversation << SearchConfig.contactSearchTypeBaseBit;
    E = SearchConfig.typeDiscussionConversationMatchTitle << SearchConfig.contactSearchTypeBaseBit;
    F = SearchConfig.typeDiscussionConversation << SearchConfig.contactSearchTypeBaseBit;
    G = SearchConfig.typeTroopConversation << SearchConfig.contactSearchTypeBaseBit;
    H = SearchConfig.typeFriendSpecialCare << SearchConfig.contactSearchTypeBaseBit;
    I = SearchConfig.typeFriend << SearchConfig.contactSearchTypeBaseBit;
    J = SearchConfig.typeFriendNotOftenContact << SearchConfig.contactSearchTypeBaseBit;
    K = SearchConfig.typeNewTroopMember << SearchConfig.contactSearchTypeBaseBit;
    L = SearchConfig.typeDiscussionMember << SearchConfig.contactSearchTypeBaseBit;
    M = SearchConfig.typePhoneContact << SearchConfig.contactSearchTypeBaseBit;
    N = SearchConfig.typeDiscussionConversationMatchMember << SearchConfig.contactSearchTypeBaseBit;
    O = SearchConfig.typeNewTroop << SearchConfig.contactSearchTypeBaseBit;
    P = SearchConfig.typeDiscussion << SearchConfig.contactSearchTypeBaseBit;
    Q = SearchConfig.typeTroop << SearchConfig.contactSearchTypeBaseBit;
    R = SearchConfig.typeTool << SearchConfig.contactSearchTypeBaseBit;
    S = SearchConfig.typePublicAccountConversation << SearchConfig.contactSearchTypeBaseBit;
    T = SearchConfig.typePublicAccount << SearchConfig.contactSearchTypeBaseBit;
    U = SearchConfig.typeUnbindPhoneContact << SearchConfig.contactSearchTypeBaseBit;
    V = SearchConfig.typeCircleContact << SearchConfig.contactSearchTypeBaseBit;
    W = SearchConfig.typeTroopMember << SearchConfig.contactSearchTypeBaseBit;
    X = SearchConfig.typeGlobalTroop << SearchConfig.contactSearchTypeBaseBit;
    Y = SearchConfig.typeGlobalTroopConversation << SearchConfig.contactSearchTypeBaseBit;
    Z = SearchConfig.typeGlobalTroopMember << SearchConfig.contactSearchTypeBaseBit;
    aa = SearchConfig.typeQidianMaster << SearchConfig.contactSearchTypeBaseBit;
  }
  
  public abstract String a();
  
  public void a(long paramLong)
  {
    this.ad = paramLong;
  }
  
  public abstract String b();
  
  public abstract String c();
  
  public abstract String d();
  
  public boolean equals(Object paramObject)
  {
    return this.ab == ((IContactSearchable)paramObject).ab;
  }
  
  protected long f()
  {
    return 0L;
  }
  
  public abstract int g();
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public abstract Drawable i();
  
  public abstract String j();
  
  public abstract int k();
  
  public abstract Object l();
  
  public long n()
  {
    return q();
  }
  
  public long o()
  {
    return this.ad;
  }
  
  protected void p()
  {
    for (;;)
    {
      int i1;
      try
      {
        String str = j();
        StringBuilder localStringBuilder = new StringBuilder();
        i1 = 0;
        if (i1 < str.length())
        {
          char c = str.charAt(i1);
          if ((c >= '0') && (c <= '9')) {
            localStringBuilder.append(c);
          }
        }
        else
        {
          str = localStringBuilder.toString();
          if (!TextUtils.isEmpty(str))
          {
            this.ab = Long.parseLong(str);
            return;
          }
          this.ab = hashCode();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        this.ab = hashCode();
        return;
      }
      i1 += 1;
    }
  }
  
  public long q()
  {
    if (this.ac == -1L) {
      this.ac = f();
    }
    return this.ac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.IContactSearchable
 * JD-Core Version:    0.7.0.1
 */