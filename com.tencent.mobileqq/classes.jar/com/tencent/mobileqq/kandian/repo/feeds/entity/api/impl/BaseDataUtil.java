package com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl;

import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyFromSelf;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSDataConverter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IBaseDataUtil;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/impl/BaseDataUtil;", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IBaseDataUtil;", "()V", "getSortWeight", "", "baseData", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
@IgnoreDenyDependencyFromSelf
public final class BaseDataUtil
  implements IBaseDataUtil
{
  public static final BaseDataUtil INSTANCE = new BaseDataUtil();
  
  public float getSortWeight(@Nullable BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return 0.0F;
    }
    int i = paramBaseData.aP;
    float f = -1000.0F;
    if (i != 0)
    {
      if (i != 6) {
        if (i != 22)
        {
          if (i != 23)
          {
            if (i != 25) {
              if (i == 26) {}
            }
            switch (i)
            {
            default: 
              return -1000.0F;
            case 15: 
              return 3.0F;
            case 14: 
              return 11.0F;
            case 13: 
            case 16: 
              return 9.0F;
            case 12: 
              return 10.0F;
            case 10: 
            case 11: 
            case 17: 
              return FastWebPTSDataConverter.a(paramBaseData, false);
            case 9: 
              return FastWebPTSDataConverter.a(paramBaseData, true);
              if (!(paramBaseData instanceof ProteusItemData)) {
                break;
              }
              return paramBaseData.aV;
              return 1.5F;
            }
          }
        }
        else {
          return 2.0F;
        }
      }
      return paramBaseData.aV;
    }
    else
    {
      f = 1.0F;
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.api.impl.BaseDataUtil
 * JD-Core Version:    0.7.0.1
 */