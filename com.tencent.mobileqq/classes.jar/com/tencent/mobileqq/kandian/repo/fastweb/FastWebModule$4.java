package com.tencent.mobileqq.kandian.repo.fastweb;

import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.util.List;

class FastWebModule$4
  extends QQLruCache<String, List<BaseData>>
{
  FastWebModule$4(FastWebModule paramFastWebModule, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    super.entryRemoved(paramBoolean, paramString, paramList1, paramList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.4
 * JD-Core Version:    0.7.0.1
 */