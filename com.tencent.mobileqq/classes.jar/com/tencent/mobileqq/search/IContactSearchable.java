package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.qphone.base.util.QLog;

public abstract class IContactSearchable
  implements ISearchable
{
  public static long A = SearchConfig.typeDiscussionConversationMatchTitle << SearchConfig.contactSearchTypeBaseBit;
  public static long B = SearchConfig.typeDiscussionConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long C = SearchConfig.typeTroopConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long D = SearchConfig.typeFriendSpecialCare << SearchConfig.contactSearchTypeBaseBit;
  public static long E = SearchConfig.typeFriend << SearchConfig.contactSearchTypeBaseBit;
  public static long F = SearchConfig.typeFriendNotOftenContact << SearchConfig.contactSearchTypeBaseBit;
  public static long G = SearchConfig.typeNewTroopMember << SearchConfig.contactSearchTypeBaseBit;
  public static long H = SearchConfig.typeDiscussionMember << SearchConfig.contactSearchTypeBaseBit;
  public static long I = SearchConfig.typePhoneContact << SearchConfig.contactSearchTypeBaseBit;
  public static long J = SearchConfig.typeDiscussionConversationMatchMember << SearchConfig.contactSearchTypeBaseBit;
  public static long K = SearchConfig.typeNewTroop << SearchConfig.contactSearchTypeBaseBit;
  public static long L = SearchConfig.typeDiscussion << SearchConfig.contactSearchTypeBaseBit;
  public static long M = SearchConfig.typeTroop << SearchConfig.contactSearchTypeBaseBit;
  public static long N = SearchConfig.typeTool << SearchConfig.contactSearchTypeBaseBit;
  public static long O = SearchConfig.typePublicAccountConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long P = SearchConfig.typePublicAccount << SearchConfig.contactSearchTypeBaseBit;
  public static long Q = SearchConfig.typeUnbindPhoneContact << SearchConfig.contactSearchTypeBaseBit;
  public static long R = SearchConfig.typeCircleContact << SearchConfig.contactSearchTypeBaseBit;
  public static long S = SearchConfig.typeTroopMember << SearchConfig.contactSearchTypeBaseBit;
  public static long T = SearchConfig.typeGlobalTroop << SearchConfig.contactSearchTypeBaseBit;
  public static long U = SearchConfig.typeGlobalTroopConversation << SearchConfig.contactSearchTypeBaseBit;
  public static long V = SearchConfig.typeGlobalTroopMember << SearchConfig.contactSearchTypeBaseBit;
  public static long W = SearchConfig.typeQidianMaster << SearchConfig.contactSearchTypeBaseBit;
  public static long a = SearchConfig.fieldPublicAccountName << SearchConfig.contactSearchFieldBaseBit;
  public static long b = SearchConfig.fieldPublicAccountMark << SearchConfig.contactSearchFieldBaseBit;
  public static long c = SearchConfig.fieldPublicAccountSummary << SearchConfig.contactSearchFieldBaseBit;
  public static long d = SearchConfig.fieldPublicAccountDisplayName << SearchConfig.contactSearchFieldBaseBit;
  public static long e = SearchConfig.filedDiscussionName << SearchConfig.contactSearchFieldBaseBit;
  public static long f = SearchConfig.fieldTroopName << SearchConfig.contactSearchFieldBaseBit;
  public static long g = SearchConfig.fieldRemark << SearchConfig.contactSearchFieldBaseBit;
  public static long h = SearchConfig.fieldNewTroopNickName << SearchConfig.contactSearchFieldBaseBit;
  public static long i = SearchConfig.fieldNewTroopCard << SearchConfig.contactSearchFieldBaseBit;
  public static long j = SearchConfig.fieldDiscussionMemberRemark << SearchConfig.contactSearchFieldBaseBit;
  public static long k = SearchConfig.fieldInteRemark << SearchConfig.contactSearchFieldBaseBit;
  public static long l = SearchConfig.fieldNickName << SearchConfig.contactSearchFieldBaseBit;
  public static long m = SearchConfig.fieldPhoneContactName << SearchConfig.contactSearchFieldBaseBit;
  public static long n = SearchConfig.fieldAlias << SearchConfig.contactSearchFieldBaseBit;
  public static long o = SearchConfig.fieldUin << SearchConfig.contactSearchFieldBaseBit;
  public static long p = SearchConfig.fieldMobileNo << SearchConfig.contactSearchFieldBaseBit;
  public static long q = SearchConfig.fieldTroopCard << SearchConfig.contactSearchFieldBaseBit;
  public static long r = SearchConfig.stringOrigin << SearchConfig.contactSearchPinyinBaseBit;
  public static long s = SearchConfig.stringPinyin << SearchConfig.contactSearchPinyinBaseBit;
  public static long t = SearchConfig.recentTrue << SearchConfig.contactSearchRecentBaseBit;
  public static long u = SearchConfig.indexEqual << SearchConfig.contactSearchIndexBaseBit;
  public static long v = SearchConfig.indexStart << SearchConfig.contactSearchIndexBaseBit;
  public static long w = SearchConfig.indexMiddle << SearchConfig.contactSearchIndexBaseBit;
  public static long x = 72057594037927936L;
  public static long y = SearchConfig.typeDiscussionMatchMemberFull << SearchConfig.contactSearchTypeBaseBit;
  public static long z = SearchConfig.typeFriendConversation << SearchConfig.contactSearchTypeBaseBit;
  protected long X;
  protected long Y = -1L;
  protected long Z;
  protected long aa;
  
  public static void a()
  {
    a = SearchConfig.fieldPublicAccountName << SearchConfig.contactSearchFieldBaseBit;
    b = SearchConfig.fieldPublicAccountMark << SearchConfig.contactSearchFieldBaseBit;
    c = SearchConfig.fieldPublicAccountSummary << SearchConfig.contactSearchFieldBaseBit;
    d = SearchConfig.fieldPublicAccountDisplayName << SearchConfig.contactSearchFieldBaseBit;
    e = SearchConfig.filedDiscussionName << SearchConfig.contactSearchFieldBaseBit;
    f = SearchConfig.fieldTroopName << SearchConfig.contactSearchFieldBaseBit;
    g = SearchConfig.fieldRemark << SearchConfig.contactSearchFieldBaseBit;
    h = SearchConfig.fieldNewTroopNickName << SearchConfig.contactSearchFieldBaseBit;
    i = SearchConfig.fieldNewTroopCard << SearchConfig.contactSearchFieldBaseBit;
    j = SearchConfig.fieldDiscussionMemberRemark << SearchConfig.contactSearchFieldBaseBit;
    k = SearchConfig.fieldInteRemark << SearchConfig.contactSearchFieldBaseBit;
    l = SearchConfig.fieldNickName << SearchConfig.contactSearchFieldBaseBit;
    m = SearchConfig.fieldPhoneContactName << SearchConfig.contactSearchFieldBaseBit;
    n = SearchConfig.fieldAlias << SearchConfig.contactSearchFieldBaseBit;
    o = SearchConfig.fieldUin << SearchConfig.contactSearchFieldBaseBit;
    p = SearchConfig.fieldMobileNo << SearchConfig.contactSearchFieldBaseBit;
    q = SearchConfig.fieldTroopCard << SearchConfig.contactSearchFieldBaseBit;
    r = SearchConfig.stringOrigin << SearchConfig.contactSearchPinyinBaseBit;
    s = SearchConfig.stringPinyin << SearchConfig.contactSearchPinyinBaseBit;
    t = SearchConfig.recentTrue << SearchConfig.contactSearchRecentBaseBit;
    u = SearchConfig.indexEqual << SearchConfig.contactSearchIndexBaseBit;
    v = SearchConfig.indexStart << SearchConfig.contactSearchIndexBaseBit;
    w = SearchConfig.indexMiddle << SearchConfig.contactSearchIndexBaseBit;
    x = 72057594037927936L;
    y = SearchConfig.typeDiscussionMatchMemberFull << SearchConfig.contactSearchTypeBaseBit;
    z = SearchConfig.typeFriendConversation << SearchConfig.contactSearchTypeBaseBit;
    A = SearchConfig.typeDiscussionConversationMatchTitle << SearchConfig.contactSearchTypeBaseBit;
    B = SearchConfig.typeDiscussionConversation << SearchConfig.contactSearchTypeBaseBit;
    C = SearchConfig.typeTroopConversation << SearchConfig.contactSearchTypeBaseBit;
    D = SearchConfig.typeFriendSpecialCare << SearchConfig.contactSearchTypeBaseBit;
    E = SearchConfig.typeFriend << SearchConfig.contactSearchTypeBaseBit;
    F = SearchConfig.typeFriendNotOftenContact << SearchConfig.contactSearchTypeBaseBit;
    G = SearchConfig.typeNewTroopMember << SearchConfig.contactSearchTypeBaseBit;
    H = SearchConfig.typeDiscussionMember << SearchConfig.contactSearchTypeBaseBit;
    I = SearchConfig.typePhoneContact << SearchConfig.contactSearchTypeBaseBit;
    J = SearchConfig.typeDiscussionConversationMatchMember << SearchConfig.contactSearchTypeBaseBit;
    K = SearchConfig.typeNewTroop << SearchConfig.contactSearchTypeBaseBit;
    L = SearchConfig.typeDiscussion << SearchConfig.contactSearchTypeBaseBit;
    M = SearchConfig.typeTroop << SearchConfig.contactSearchTypeBaseBit;
    N = SearchConfig.typeTool << SearchConfig.contactSearchTypeBaseBit;
    O = SearchConfig.typePublicAccountConversation << SearchConfig.contactSearchTypeBaseBit;
    P = SearchConfig.typePublicAccount << SearchConfig.contactSearchTypeBaseBit;
    Q = SearchConfig.typeUnbindPhoneContact << SearchConfig.contactSearchTypeBaseBit;
    R = SearchConfig.typeCircleContact << SearchConfig.contactSearchTypeBaseBit;
    S = SearchConfig.typeTroopMember << SearchConfig.contactSearchTypeBaseBit;
    T = SearchConfig.typeGlobalTroop << SearchConfig.contactSearchTypeBaseBit;
    U = SearchConfig.typeGlobalTroopConversation << SearchConfig.contactSearchTypeBaseBit;
    V = SearchConfig.typeGlobalTroopMember << SearchConfig.contactSearchTypeBaseBit;
    W = SearchConfig.typeQidianMaster << SearchConfig.contactSearchTypeBaseBit;
  }
  
  protected long a()
  {
    return 0L;
  }
  
  public abstract Drawable a();
  
  public abstract Object a();
  
  public abstract String a();
  
  public void a(long paramLong)
  {
    this.Z = paramLong;
  }
  
  public abstract int b();
  
  public long b()
  {
    return d();
  }
  
  public abstract String b();
  
  protected void b()
  {
    for (;;)
    {
      int i1;
      try
      {
        String str = e();
        StringBuilder localStringBuilder = new StringBuilder();
        i1 = 0;
        if (i1 < str.length())
        {
          char c1 = str.charAt(i1);
          if ((c1 >= '0') && (c1 <= '9')) {
            localStringBuilder.append(c1);
          }
        }
        else
        {
          str = localStringBuilder.toString();
          if (!TextUtils.isEmpty(str))
          {
            this.X = Long.parseLong(str);
            return;
          }
          this.X = hashCode();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        this.X = hashCode();
        return;
      }
      i1 += 1;
    }
  }
  
  public abstract int c();
  
  public long c()
  {
    return this.Z;
  }
  
  public abstract String c();
  
  public long d()
  {
    if (this.Y == -1L) {
      this.Y = a();
    }
    return this.Y;
  }
  
  public abstract String d();
  
  public abstract String e();
  
  public boolean equals(Object paramObject)
  {
    return this.X == ((IContactSearchable)paramObject).X;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.IContactSearchable
 * JD-Core Version:    0.7.0.1
 */