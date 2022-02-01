package com.tencent.mobileqq.hiboom;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import java.util.List;

public abstract interface FontBubblePanelView$Controller<T>
{
  public abstract int a();
  
  public abstract String a(Context paramContext);
  
  public abstract String a(FontBubble paramFontBubble);
  
  public abstract List<FontBubble> a(QQAppInterface paramQQAppInterface, T paramT);
  
  public abstract void a(SVIPHandler paramSVIPHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.FontBubblePanelView.Controller
 * JD-Core Version:    0.7.0.1
 */