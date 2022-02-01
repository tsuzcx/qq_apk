package com.tencent.mobileqq.kandian.repo.db.struct;

import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.BiuOneLevelItem;
import tencent.im.oidb.articlesummary.articlesummary.MultiBiuSameContent;

public class MultiBiuSameContentUtils
{
  public static ArrayList<MultiBiuSameContent> a(List<articlesummary.MultiBiuSameContent> paramList)
  {
    localArrayList = new ArrayList();
    try
    {
      paramList = paramList.iterator();
      Object localObject1;
      while (paramList.hasNext())
      {
        Object localObject2 = (articlesummary.MultiBiuSameContent)paramList.next();
        localObject1 = new MultiBiuSameContent();
        ((MultiBiuSameContent)localObject1).b = ((articlesummary.MultiBiuSameContent)localObject2).bytes_biu_comments.get().toStringUtf8();
        ((MultiBiuSameContent)localObject1).a = ((articlesummary.MultiBiuSameContent)localObject2).uint64_uin.get();
        ((MultiBiuSameContent)localObject1).c = ((articlesummary.MultiBiuSameContent)localObject2).enum_uin_type.get();
        ((MultiBiuSameContent)localObject1).d = ((articlesummary.MultiBiuSameContent)localObject2).uint32_biu_time.get();
        ((MultiBiuSameContent)localObject1).e = ((articlesummary.MultiBiuSameContent)localObject2).uint64_feeds_id.get();
        ((MultiBiuSameContent)localObject1).f = ((articlesummary.MultiBiuSameContent)localObject2).uint32_feeds_type.get();
        ((MultiBiuSameContent)localObject1).g = ((articlesummary.MultiBiuSameContent)localObject2).uint32_strategy_id.get();
        ((MultiBiuSameContent)localObject1).h = ((articlesummary.MultiBiuSameContent)localObject2).uint64_algorithm_id.get();
        if ((((articlesummary.MultiBiuSameContent)localObject2).rpt_biu_mutli_level.has()) && (((articlesummary.MultiBiuSameContent)localObject2).rpt_biu_mutli_level.get() != null))
        {
          localObject2 = ((articlesummary.MultiBiuSameContent)localObject2).rpt_biu_mutli_level.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            articlesummary.BiuOneLevelItem localBiuOneLevelItem = (articlesummary.BiuOneLevelItem)((Iterator)localObject2).next();
            ((MultiBiuSameContent)localObject1).i.add(SocializeFeedsInfoUtils.a(localBiuOneLevelItem));
          }
        }
        localArrayList.add(localObject1);
      }
      return localArrayList;
    }
    catch (Exception paramList)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseFromPBBytes error:");
        ((StringBuilder)localObject1).append(paramList.toString());
        QLog.d("MultiBiuSameContentUtils", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.MultiBiuSameContentUtils
 * JD-Core Version:    0.7.0.1
 */