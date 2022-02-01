package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class WebProteusViewCreator$ProteusItemViewHolder$2
  implements View.OnLongClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$2(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder, ProteusItemData paramProteusItemData) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(0, HardCodeUtil.a(2131913800));
    BubbleContextMenu.a(this.b.f, paramView, new WebProteusViewCreator.ProteusItemViewHolder.2.1(this), new WebProteusViewCreator.ProteusItemViewHolder.2.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.2
 * JD-Core Version:    0.7.0.1
 */