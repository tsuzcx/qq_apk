package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HeaderInfo;

public class HeaderItem
  extends EditItemBase<HeaderItem.HeaderHolder, HeaderInfo>
{
  private LayoutInflater a;
  private Context d;
  private View e;
  
  public HeaderItem(XMediaEditor paramXMediaEditor, Context paramContext)
  {
    super(paramXMediaEditor);
    this.d = paramContext;
    this.a = LayoutInflater.from(paramContext);
  }
  
  public HeaderItem.HeaderHolder a(ViewGroup paramViewGroup)
  {
    return new HeaderItem.HeaderHolder(this.e);
  }
  
  public void a(View paramView)
  {
    this.e = paramView;
  }
  
  public void a(View paramView, HeaderItem.HeaderHolder paramHeaderHolder) {}
  
  public void a(HeaderItem.HeaderHolder paramHeaderHolder, HeaderInfo paramHeaderInfo, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.HeaderItem
 * JD-Core Version:    0.7.0.1
 */