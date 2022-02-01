package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebImageItemUtils;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import java.util.ArrayList;

class WebProteusViewCreator$ProteusItemViewHolder$8
  implements WebProteusViewCreator.ProteusItemViewOnClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$8(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if (((WebProteusViewCreator.a(this.a.a) instanceof WebFastAdapter)) && ((paramContext instanceof FastWebActivity)))
    {
      if (WebProteusViewCreator.ProteusItemViewHolder.a(this.a) == null) {
        WebProteusViewCreator.ProteusItemViewHolder.a(this.a, new ArrayList());
      }
      FastWebImageItemUtils.a(paramProteusItemData.b, paramProteusItemData.a, (FastWebActivity)paramContext, paramProteusItemData.c, ((WebFastAdapter)WebProteusViewCreator.a(this.a.a)).a(), WebProteusViewCreator.ProteusItemViewHolder.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.8
 * JD-Core Version:    0.7.0.1
 */