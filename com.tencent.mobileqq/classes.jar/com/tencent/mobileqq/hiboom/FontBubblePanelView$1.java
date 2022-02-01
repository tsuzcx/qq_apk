package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.model.QueryTask.Query;
import java.util.List;

class FontBubblePanelView$1
  implements QueryTask.Query<T, List<FontBubble>>
{
  FontBubblePanelView$1(FontBubblePanelView paramFontBubblePanelView) {}
  
  public List<FontBubble> a(T paramT)
  {
    paramT = FontBubblePanelView.b(this.a).a(FontBubblePanelView.a(this.a).d, paramT);
    FontBubble localFontBubble = new FontBubble();
    localFontBubble.viewType = 0;
    paramT.add(localFontBubble);
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView.1
 * JD-Core Version:    0.7.0.1
 */