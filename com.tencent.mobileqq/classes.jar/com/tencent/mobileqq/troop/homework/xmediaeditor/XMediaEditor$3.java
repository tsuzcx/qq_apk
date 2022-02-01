package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.TextInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditItemBase.OnEditItemListener;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager.EditViewHolderBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;

class XMediaEditor$3
  implements EditItemBase.OnEditItemListener
{
  XMediaEditor$3(XMediaEditor paramXMediaEditor) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    paramInt1 = paramInt2 - paramInt1;
    if (XMediaEditor.e(this.a) != null) {
      XMediaEditor.e(this.a).a(XMediaEditor.f(this.a), XMediaEditor.f(this.a) + paramInt1);
    }
    XMediaEditor localXMediaEditor = this.a;
    XMediaEditor.a(localXMediaEditor, XMediaEditor.f(localXMediaEditor) + paramInt1);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = ((EditorViewHolderManager.EditViewHolderBase)paramViewHolder).f;
    this.a.a(paramViewHolder.g);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (XMediaEditor.b(this.a) != this.a.a.d())
    {
      paramViewHolder = this.a;
      XMediaEditor.a(paramViewHolder, XMediaEditor.b(paramViewHolder) ^ true);
      if (XMediaEditor.c(this.a) != null) {
        XMediaEditor.c(this.a).a(XMediaEditor.b(this.a));
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = ((EditorViewHolderManager.EditViewHolderBase)paramViewHolder).f.g;
    if (i == 0) {
      return;
    }
    paramViewHolder = this.a.a;
    i -= 1;
    paramViewHolder = paramViewHolder.c(i);
    if ((paramViewHolder != null) && (paramViewHolder.b() == -1)) {
      return;
    }
    this.a.a(i);
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (TextItem.TextViewHolder)paramViewHolder;
    if (XMediaEditor.a(this.a) != null) {
      XMediaEditor.a(this.a).c = false;
    }
    XMediaEditor.a(this.a, (TextInfo)paramViewHolder.f);
    if (XMediaEditor.d(this.a) != null) {
      XMediaEditor.d(this.a).a(paramViewHolder.b, true);
    }
  }
  
  public void d(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (TextItem.TextViewHolder)paramViewHolder;
    if (XMediaEditor.d(this.a) != null) {
      XMediaEditor.d(this.a).a(paramViewHolder.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.3
 * JD-Core Version:    0.7.0.1
 */