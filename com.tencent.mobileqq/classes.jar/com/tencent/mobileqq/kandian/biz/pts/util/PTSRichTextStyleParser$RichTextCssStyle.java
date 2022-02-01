package com.tencent.mobileqq.kandian.biz.pts.util;

import android.graphics.Color;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.pts.utils.PTSLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class PTSRichTextStyleParser$RichTextCssStyle
{
  public static CssStyleSet a(String paramString1, String paramString2, Node paramNode, JSONObject paramJSONObject)
  {
    CssStyleSet localCssStyleSet = new CssStyleSet();
    if ((paramNode != null) && (paramNode.cssStyleSet != null)) {
      localCssStyleSet.addInheritStyle(paramNode.cssStyleSet);
    }
    if ((!"div".equalsIgnoreCase(paramString1)) && (!"p".equalsIgnoreCase(paramString1)))
    {
      if ("strong".equalsIgnoreCase(paramString1)) {
        localCssStyleSet.addCssStyle(CssStyle.createStyle("font-weight", "bold"));
      } else if (("a".equalsIgnoreCase(paramString1)) && (paramJSONObject != null)) {
        localCssStyleSet.addCssStyle(CssStyle.createStyle("href", paramJSONObject.optString("href")));
      } else {
        localCssStyleSet.addCssStyle(CssStyle.getDisplay(false));
      }
    }
    else {
      localCssStyleSet.addCssStyle(CssStyle.getDisplay(true));
    }
    if (paramString2 != null)
    {
      paramString1 = paramString2.split("[;]");
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        paramString2 = paramString1[i];
        if (paramString2 != null)
        {
          paramString2 = paramString2.split(":");
          if (paramString2.length == 2) {
            localCssStyleSet.addCssStyle(CssStyle.createStyle(paramString2[0].trim(), paramString2[1].trim()));
          }
        }
        i += 1;
      }
    }
    return localCssStyleSet;
  }
  
  public static void a(Node paramNode)
  {
    Map localMap = paramNode.cssStyleSet.getCssStyleMap();
    if ((localMap != null) && (localMap.size() > 0))
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject1 = ((CssStyle)((Map.Entry)localObject2).getValue()).styleName;
        localObject2 = ((CssStyle)((Map.Entry)localObject2).getValue()).styleValue;
        double d1;
        double d2;
        int i;
        if ("line-height".equalsIgnoreCase((String)localObject1))
        {
          d1 = ((Integer)localObject2).intValue();
          d2 = paramNode.nodeRatio;
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          if (PTSRichTextStyleParser.a < i) {
            PTSRichTextStyleParser.a = i;
          }
        }
        else if ("font-size".equalsIgnoreCase((String)localObject1))
        {
          d1 = ((Integer)localObject2).intValue();
          d2 = paramNode.nodeRatio;
          Double.isNaN(d1);
          i = (int)(d1 * d2);
          if (PTSRichTextStyleParser.b < i) {
            PTSRichTextStyleParser.b = i;
          }
        }
        else if ("color".equalsIgnoreCase((String)localObject1))
        {
          i = Color.parseColor((String)localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("dealTextStyle colorInt = ");
          ((StringBuilder)localObject1).append(i);
          PTSLog.d("RichTextStyleParser", ((StringBuilder)localObject1).toString());
        }
        else if ("font-weight".equalsIgnoreCase((String)localObject1))
        {
          i = ((Integer)localObject2).intValue();
          if (PTSRichTextStyleParser.c < i) {
            PTSRichTextStyleParser.b = i;
          }
        }
        else if ("-webkit-line-clamp".equalsIgnoreCase((String)localObject1))
        {
          i = ((Integer)localObject2).intValue();
          if (PTSRichTextStyleParser.d < i) {
            PTSRichTextStyleParser.d = i;
          }
        }
        else if ("display".equalsIgnoreCase((String)localObject1))
        {
          PTSLog.d("RichTextStyleParser", "dealTextStyle DISPLAY_STYLE");
        }
        else if ("href".equalsIgnoreCase((String)localObject1))
        {
          localObject1 = String.valueOf(localObject2);
          localObject2 = (CssStyle)localMap.get("color");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("dealTextStyle href = ");
          ((StringBuilder)localObject2).append((String)localObject1);
          PTSLog.d("RichTextStyleParser", ((StringBuilder)localObject2).toString());
        }
      }
      return;
    }
    PTSLog.e("RichTextStyleParser", "RichTextCssStyle dealTextStyle node.cssStyleSet.getCssStyleMap null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSRichTextStyleParser.RichTextCssStyle
 * JD-Core Version:    0.7.0.1
 */