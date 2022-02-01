package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.vas.theme.api.QueryCallback;
import java.util.List;

class FontBubblePanelView$2
  implements QueryCallback<List<FontBubble>>
{
  FontBubblePanelView$2(FontBubblePanelView paramFontBubblePanelView) {}
  
  public void a(List<FontBubble> paramList)
  {
    FontBubblePanelView.a(this.a, paramList);
    FontBubblePanelView.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView.2
 * JD-Core Version:    0.7.0.1
 */