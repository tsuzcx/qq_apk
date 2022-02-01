package com.tencent.mobileqq.kandian.repo.follow;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import tencent.im.oidb.articlesummary.articlesummary.RecommendAccountInfo;
import tencent.im.oidb.oidb_0xc2f.RecommendAccountInfo;

public class RecommendFollowInfo
  extends Entity
  implements Parcelable
{
  public static Parcelable.Creator<RecommendFollowInfo> CREATOR = new RecommendFollowInfo.1();
  public long algorithmId;
  public String className;
  public boolean hasReport;
  public String headUrl;
  public boolean isFollowed;
  public boolean isStar;
  public boolean isVip;
  public String nickName;
  public String recommendReason;
  public int strategyId;
  public int type;
  public long uin;
  
  public RecommendFollowInfo() {}
  
  public RecommendFollowInfo(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.uin = paramLong;
    this.type = paramInt;
    this.recommendReason = paramString2;
    this.nickName = paramString1;
    this.headUrl = paramString3;
    this.isVip = paramBoolean1;
    this.isStar = paramBoolean2;
  }
  
  public static RecommendFollowInfo parseByPB(articlesummary.RecommendAccountInfo paramRecommendAccountInfo)
  {
    RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
    if (paramRecommendAccountInfo.uint64_uin.has()) {
      localRecommendFollowInfo.uin = paramRecommendAccountInfo.uint64_uin.get();
    }
    if (paramRecommendAccountInfo.uint32_account_type.has()) {
      localRecommendFollowInfo.type = paramRecommendAccountInfo.uint32_account_type.get();
    }
    if (paramRecommendAccountInfo.bytes_recommend_reason.has()) {
      localRecommendFollowInfo.recommendReason = paramRecommendAccountInfo.bytes_recommend_reason.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.bytes_nick_name.has()) {
      localRecommendFollowInfo.nickName = paramRecommendAccountInfo.bytes_nick_name.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.bytes_head_img_url.has()) {
      localRecommendFollowInfo.headUrl = paramRecommendAccountInfo.bytes_head_img_url.get().toStringUtf8();
    }
    boolean bool1 = paramRecommendAccountInfo.uint32_is_vip.has();
    boolean bool2 = false;
    if (bool1)
    {
      if (paramRecommendAccountInfo.uint32_is_vip.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localRecommendFollowInfo.isVip = bool1;
    }
    if (paramRecommendAccountInfo.uint32_is_star.has())
    {
      if (paramRecommendAccountInfo.uint32_is_star.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localRecommendFollowInfo.isStar = bool1;
    }
    if (paramRecommendAccountInfo.uint32_is_followed.has())
    {
      bool1 = bool2;
      if (paramRecommendAccountInfo.uint32_is_followed.get() == 1) {
        bool1 = true;
      }
      localRecommendFollowInfo.isFollowed = bool1;
    }
    if (paramRecommendAccountInfo.uint64_algorithm_id.has()) {
      localRecommendFollowInfo.algorithmId = paramRecommendAccountInfo.uint64_algorithm_id.get();
    }
    if (paramRecommendAccountInfo.uint32_strategy_id.has()) {
      localRecommendFollowInfo.strategyId = paramRecommendAccountInfo.uint32_strategy_id.get();
    }
    if (paramRecommendAccountInfo.bytes_class.has()) {
      localRecommendFollowInfo.className = paramRecommendAccountInfo.bytes_class.get().toStringUtf8();
    }
    return localRecommendFollowInfo;
  }
  
  public static RecommendFollowInfo parseByPB(oidb_0xc2f.RecommendAccountInfo paramRecommendAccountInfo)
  {
    RecommendFollowInfo localRecommendFollowInfo = new RecommendFollowInfo();
    if (paramRecommendAccountInfo.uint64_uin.has()) {
      localRecommendFollowInfo.uin = paramRecommendAccountInfo.uint64_uin.get();
    }
    if (paramRecommendAccountInfo.uint32_account_type.has()) {
      localRecommendFollowInfo.type = paramRecommendAccountInfo.uint32_account_type.get();
    }
    if (paramRecommendAccountInfo.bytes_nick_name.has()) {
      localRecommendFollowInfo.nickName = paramRecommendAccountInfo.bytes_nick_name.get().toStringUtf8();
    }
    if (paramRecommendAccountInfo.bytes_head_img_url.has()) {
      localRecommendFollowInfo.headUrl = paramRecommendAccountInfo.bytes_head_img_url.get().toStringUtf8();
    }
    boolean bool1 = paramRecommendAccountInfo.uint32_is_vip.has();
    boolean bool2 = false;
    if (bool1)
    {
      if (paramRecommendAccountInfo.uint32_is_vip.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localRecommendFollowInfo.isVip = bool1;
    }
    if (paramRecommendAccountInfo.uint32_is_star.has())
    {
      bool1 = bool2;
      if (paramRecommendAccountInfo.uint32_is_star.get() == 1) {
        bool1 = true;
      }
      localRecommendFollowInfo.isStar = bool1;
    }
    if (paramRecommendAccountInfo.bytes_recommend_reason.has()) {
      localRecommendFollowInfo.recommendReason = paramRecommendAccountInfo.bytes_recommend_reason.get().toStringUtf8();
    }
    return localRecommendFollowInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public articlesummary.RecommendAccountInfo toPB()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecommendFollowInfo{uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", recommendReason='");
    localStringBuilder.append(this.recommendReason);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headUrl='");
    localStringBuilder.append(this.headUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isVip=");
    localStringBuilder.append(this.isVip);
    localStringBuilder.append(", isStar=");
    localStringBuilder.append(this.isStar);
    localStringBuilder.append(", algorithmID");
    localStringBuilder.append(this.algorithmId);
    localStringBuilder.append(", strategyId");
    localStringBuilder.append(this.strategyId);
    localStringBuilder.append(", isFollowed=");
    localStringBuilder.append(this.isFollowed);
    localStringBuilder.append(", className=");
    localStringBuilder.append(this.className);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo
 * JD-Core Version:    0.7.0.1
 */