package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import tencent.im.oidb.articlesummary.articlesummary.RecommendAccountInfo;
import tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos;
import tencent.im.oidb.oidb_0xc2f.GetFollowUserRecommendListRsp;
import tencent.im.oidb.oidb_0xc2f.RecommendAccountInfo;

public class RecommendFollowInfos
{
  public boolean a;
  public byte[] b;
  public List<RecommendFollowInfo> c = new ArrayList();
  public int d;
  public String e;
  public String f;
  public List<GroupRecommendAccount> g = new ArrayList();
  public HashMap<Long, RecommendFollowInfo> h = new HashMap();
  public boolean i;
  public int j;
  
  public static RecommendFollowInfos a(articlesummary.RecommendFollowInfos paramRecommendFollowInfos)
  {
    RecommendFollowInfos localRecommendFollowInfos = new RecommendFollowInfos();
    if (paramRecommendFollowInfos.uint32_show_full_card.has())
    {
      int k = paramRecommendFollowInfos.uint32_show_full_card.get();
      boolean bool = true;
      if (k != 1) {
        bool = false;
      }
      localRecommendFollowInfos.a = bool;
    }
    if (paramRecommendFollowInfos.bytes_account_next_cookie.has()) {
      localRecommendFollowInfos.b = paramRecommendFollowInfos.bytes_account_next_cookie.get().toByteArray();
    }
    localRecommendFollowInfos.d = paramRecommendFollowInfos.uint32_card_style.get();
    localRecommendFollowInfos.e = paramRecommendFollowInfos.bytes_card_title.get().toStringUtf8();
    localRecommendFollowInfos.f = paramRecommendFollowInfos.bytes_jump_url.get().toStringUtf8();
    if (paramRecommendFollowInfos.rpt_recommend_account_info.has())
    {
      paramRecommendFollowInfos = paramRecommendFollowInfos.rpt_recommend_account_info.get();
      Object localObject2 = new HashMap();
      Object localObject3 = paramRecommendFollowInfos.iterator();
      Object localObject1;
      while (((Iterator)localObject3).hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = RecommendFollowInfo.parseByPB((articlesummary.RecommendAccountInfo)((Iterator)localObject3).next());
        localRecommendFollowInfos.c.add(localRecommendFollowInfo);
        if ((localRecommendFollowInfos.d == 2) && (!TextUtils.isEmpty(localRecommendFollowInfo.className)))
        {
          localObject1 = (List)((HashMap)localObject2).get(localRecommendFollowInfo.className);
          paramRecommendFollowInfos = (articlesummary.RecommendFollowInfos)localObject1;
          if (localObject1 == null)
          {
            paramRecommendFollowInfos = new ArrayList();
            ((HashMap)localObject2).put(localRecommendFollowInfo.className, paramRecommendFollowInfos);
          }
          if (paramRecommendFollowInfos.size() < 3) {
            paramRecommendFollowInfos.add(localRecommendFollowInfo);
          }
        }
      }
      if (!((HashMap)localObject2).isEmpty())
      {
        paramRecommendFollowInfos = ((HashMap)localObject2).entrySet().iterator();
        while (paramRecommendFollowInfos.hasNext())
        {
          localObject1 = (Map.Entry)paramRecommendFollowInfos.next();
          localObject2 = (List)((Map.Entry)localObject1).getValue();
          if (((List)localObject2).size() == 3)
          {
            localObject3 = new GroupRecommendAccount();
            ((GroupRecommendAccount)localObject3).a = ((String)((Map.Entry)localObject1).getKey());
            ((GroupRecommendAccount)localObject3).b = ((List)localObject2);
            localRecommendFollowInfos.g.add(localObject3);
          }
        }
      }
    }
    return localRecommendFollowInfos;
  }
  
  public static RecommendFollowInfos a(oidb_0xc2f.GetFollowUserRecommendListRsp paramGetFollowUserRecommendListRsp)
  {
    RecommendFollowInfos localRecommendFollowInfos = new RecommendFollowInfos();
    localRecommendFollowInfos.f = paramGetFollowUserRecommendListRsp.bytes_jump_url.get().toStringUtf8();
    if (paramGetFollowUserRecommendListRsp.rpt_msg_recommend_list.has())
    {
      paramGetFollowUserRecommendListRsp = paramGetFollowUserRecommendListRsp.rpt_msg_recommend_list.get().iterator();
      while (paramGetFollowUserRecommendListRsp.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = RecommendFollowInfo.parseByPB((oidb_0xc2f.RecommendAccountInfo)paramGetFollowUserRecommendListRsp.next());
        localRecommendFollowInfos.c.add(localRecommendFollowInfo);
      }
    }
    return localRecommendFollowInfos;
  }
  
  public byte[] a()
  {
    articlesummary.RecommendFollowInfos localRecommendFollowInfos = new articlesummary.RecommendFollowInfos();
    if (this.a) {
      localRecommendFollowInfos.uint32_show_full_card.set(1);
    } else {
      localRecommendFollowInfos.uint32_show_full_card.set(0);
    }
    Object localObject = this.b;
    if ((localObject != null) && (localObject.length > 0)) {
      localRecommendFollowInfos.bytes_account_next_cookie.set(ByteStringMicro.copyFrom(this.b));
    }
    if (this.c.size() > 0)
    {
      localObject = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((RecommendFollowInfo)localIterator.next()).toPB());
      }
      localRecommendFollowInfos.rpt_recommend_account_info.set((List)localObject);
    }
    localRecommendFollowInfos.uint32_card_style.set(this.d);
    if (this.e != null) {
      localRecommendFollowInfos.bytes_card_title.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (this.f != null) {
      localRecommendFollowInfos.bytes_jump_url.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    return localRecommendFollowInfos.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos
 * JD-Core Version:    0.7.0.1
 */