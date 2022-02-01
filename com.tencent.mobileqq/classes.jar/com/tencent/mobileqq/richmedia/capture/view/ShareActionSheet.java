package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.widget.ActionSheet;

public class ShareActionSheet
{
  protected int a;
  public ElasticHorScrView a;
  protected final ActionSheet a;
  private int b;
  public ElasticHorScrView b;
  
  private static String b(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt) + "\n" + paramString.substring(paramInt);
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet
 * JD-Core Version:    0.7.0.1
 */