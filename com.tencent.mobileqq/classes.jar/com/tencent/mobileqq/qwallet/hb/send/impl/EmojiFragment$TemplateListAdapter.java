package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class EmojiFragment$TemplateListAdapter
  extends RecyclerView.Adapter<EmojiFragment.TemplateListAdapter.TemplateItemVH>
{
  private Context b;
  private List<EmojiFragment.TemplateInfo> c = new ArrayList();
  
  public EmojiFragment$TemplateListAdapter(EmojiFragment paramEmojiFragment, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public EmojiFragment.TemplateListAdapter.TemplateItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new EmojiFragment.TemplateListAdapter.TemplateItemVH(this, new EmojiFragment.TempListItem(this.a, this.b));
  }
  
  public void a(EmojiFragment.TemplateListAdapter.TemplateItemVH paramTemplateItemVH, int paramInt)
  {
    EmojiFragment.TemplateInfo localTemplateInfo = (EmojiFragment.TemplateInfo)this.c.get(paramInt);
    if (localTemplateInfo == null) {
      return;
    }
    paramTemplateItemVH = paramTemplateItemVH.a;
    if (paramTemplateItemVH == null) {
      return;
    }
    EmojiFragment.a(this.a).put(localTemplateInfo.b, EmojiFragment.TempListItem.a(paramTemplateItemVH));
    paramTemplateItemVH.a(localTemplateInfo);
  }
  
  void a(List<EmojiFragment.TemplateInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.c.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getItemCount()
  {
    List localList = this.c;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.c.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.TemplateListAdapter
 * JD-Core Version:    0.7.0.1
 */