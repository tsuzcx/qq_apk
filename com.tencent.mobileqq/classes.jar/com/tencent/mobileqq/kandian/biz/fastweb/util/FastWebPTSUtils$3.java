package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewOnClickListener;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;

final class FastWebPTSUtils$3
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if (paramProteusItemData != null) {
      FastWebPTSUtils.b(paramViewBase, paramProteusItemData.aQ, paramProteusItemData.aR, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils.3
 * JD-Core Version:    0.7.0.1
 */