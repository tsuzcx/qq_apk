package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.SpannableStringBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;
import org.json.JSONArray;

public class PTSRichTextStyleParser
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  private static TruncateAttr e;
  
  public static int a()
  {
    return a;
  }
  
  public static void a(Object paramObject, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder != null)
    {
      if (paramObject == null) {
        return;
      }
      PTSRichTextStyleParser.RichTextNode.a(PTSRichTextStyleParser.RichTextNode.a((JSONArray)paramObject), paramSpannableStringBuilder);
    }
  }
  
  public static int b()
  {
    return b;
  }
  
  public static int c()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSRichTextStyleParser
 * JD-Core Version:    0.7.0.1
 */