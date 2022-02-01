package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.biz.ProtoUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardReq;
import java.util.List;
import mqq.manager.Manager;

public class MiniCardManager
  implements IMiniCardManager, Manager
{
  private static final QQLruCache<String, NowSummaryCard.MiniCard> b = new QQLruCache(101020, 50, 10);
  public QQAppInterface a;
  
  public MiniCardManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static void a(String paramString, NowSummaryCard.MiniCard paramMiniCard)
  {
    b.put(paramString, paramMiniCard);
  }
  
  public static boolean a(String paramString)
  {
    return b.containsKey(paramString);
  }
  
  public static NowSummaryCard.MiniCard b(String paramString)
  {
    return (NowSummaryCard.MiniCard)b.get(paramString);
  }
  
  public void a()
  {
    b.evictAll();
  }
  
  public void a(List<Long> paramList, int paramInt, IGetMiniCardCallback paramIGetMiniCardCallback)
  {
    NowSummaryCard.NearbyMiniCardReq localNearbyMiniCardReq = new NowSummaryCard.NearbyMiniCardReq();
    localNearbyMiniCardReq.target_id.set(paramList);
    localNearbyMiniCardReq.id_type.set(paramInt);
    ProtoUtils.a(this.a, new MiniCardManager.1(this, false, paramIGetMiniCardCallback, paramList), localNearbyMiniCardReq.toByteArray(), "NowSummaryCard.NearbyMiniCardReq");
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.MiniCardManager
 * JD-Core Version:    0.7.0.1
 */