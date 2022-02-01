package com.tencent.mobileqq.colornote.settings;

import android.view.View;
import com.tencent.mobileqq.widget.QQToast;

public class HeaderClickHandlerExample
  implements IOnHeaderClickHandler
{
  public String a()
  {
    return "彩签业务类型";
  }
  
  public void a(View paramView, int paramInt)
  {
    QQToast.a(paramView.getContext(), 0, "service type: " + paramInt, 1000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HeaderClickHandlerExample
 * JD-Core Version:    0.7.0.1
 */