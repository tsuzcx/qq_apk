package com.tencent.mobileqq.kandian.glue.pts.util;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class ProteusSupportUtil$2
  implements ViewFactory.FoundClickableViewListener
{
  ProteusSupportUtil$2(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext, ProteusItemView paramProteusItemView, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    Object localObject = (ProteusItem)ProteusSupportUtil.a().get(Integer.valueOf(this.a));
    if ((localObject != null) && (((ProteusItem)localObject).a(this.a, this.b, this.c, paramViewBase))) {
      return;
    }
    if (paramViewBase.getNativeView() != null)
    {
      if (paramViewBase.getClickEvnet() == null) {
        return;
      }
      int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("configListener viewID : ");
        ((StringBuilder)localObject).append(paramViewBase.getViewId());
        ((StringBuilder)localObject).append(", cmd : ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(",, event : ");
        ((StringBuilder)localObject).append(paramViewBase.getClickEvnet());
        QLog.d("ProteusSupportUtil", 2, ((StringBuilder)localObject).toString());
      }
      if (ProteusSupportUtil.a(this.d, i, paramViewBase, this.e)) {
        paramViewBase.setOnClickListener(new ProteusSupportUtil.2.1(this, i, paramViewBase));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil.2
 * JD-Core Version:    0.7.0.1
 */