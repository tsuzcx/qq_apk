package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

class NoteCardProteusItem$2
  implements ViewBase.OnClickListener
{
  NoteCardProteusItem$2(NoteCardProteusItem paramNoteCardProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a.k();
    if (paramViewBase != null)
    {
      RIJJumpUtils.a(this.b.getContext(), paramViewBase.mArticleContentUrl, null);
      RIJFrameworkReportManager.b(paramViewBase, 0);
      NoteCardProteusItem.b(this.c, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NoteCardProteusItem.2
 * JD-Core Version:    0.7.0.1
 */