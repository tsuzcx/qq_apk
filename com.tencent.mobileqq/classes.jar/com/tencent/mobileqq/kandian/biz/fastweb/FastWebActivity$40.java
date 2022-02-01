package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import java.util.Map;

class FastWebActivity$40
  implements IFollowStatusObserver
{
  FastWebActivity$40(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    if (FastWebActivity.k(this.a) != null)
    {
      FastWebActivity.k(this.a).a(paramMap);
      if (FastWebActivity.z(this.a) != null) {
        FastWebActivity.z(this.a).notifyDataSetChanged();
      }
      FastWebActivity.ae(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.40
 * JD-Core Version:    0.7.0.1
 */