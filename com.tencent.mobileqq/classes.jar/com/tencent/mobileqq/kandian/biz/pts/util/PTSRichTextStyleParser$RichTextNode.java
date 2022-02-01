package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.SpannableStringBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.htmlcss.CssStyleSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.ImgNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.LayoutNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.TextNode;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PTSRichTextStyleParser$RichTextNode
{
  private static Node a(Node paramNode, String paramString1, String paramString2, CssStyleSet paramCssStyleSet, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    boolean bool = "text".equals(paramString2);
    paramString2 = null;
    String str;
    if (bool)
    {
      str = paramJSONObject1.optString("text");
      paramString1 = paramString2;
      if (Node.valueIsLegal(str))
      {
        paramString1 = new TextNode();
        ((TextNode)paramString1).text = str;
      }
    }
    else if ("img".equals(paramString1))
    {
      str = paramJSONObject2.optString("src");
      paramString1 = paramString2;
      if (Node.valueIsLegal(str))
      {
        paramString1 = new ImgNode();
        ((ImgNode)paramString1).src = str;
      }
    }
    else
    {
      paramString1 = new LayoutNode();
    }
    a(paramNode, paramString1, paramJSONObject1, paramCssStyleSet, paramJSONObject2);
    return paramString1;
  }
  
  public static Node a(JSONArray paramJSONArray)
  {
    LayoutNode localLayoutNode = new LayoutNode();
    if (paramJSONArray == null) {
      return localLayoutNode;
    }
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null)
      {
        localObject = a((JSONObject)localObject, localLayoutNode);
        if (localObject != null) {
          localLayoutNode.children.add(localObject);
        }
      }
      i += 1;
    }
    return localLayoutNode;
  }
  
  private static Node a(JSONObject paramJSONObject, Node paramNode)
  {
    String str1 = paramJSONObject.optString("name");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("attrs");
    String str2 = paramJSONObject.optString("type");
    Object localObject;
    if (localJSONObject != null) {
      localObject = localJSONObject.optString("style");
    } else {
      localObject = null;
    }
    paramNode = a(paramNode, str1, str2, PTSRichTextStyleParser.RichTextCssStyle.a(str1, (String)localObject, paramNode, localJSONObject), paramJSONObject, localJSONObject);
    paramJSONObject = paramJSONObject.optJSONArray("children");
    if ((paramJSONObject != null) && (paramNode != null))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localObject = a(paramJSONObject.optJSONObject(i), paramNode);
        if (localObject != null) {
          paramNode.children.add(localObject);
        }
        i += 1;
      }
    }
    return paramNode;
  }
  
  public static void a(Node paramNode, SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = paramNode.nodeType;
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i == 3) && (paramNode.truncateAttr != null)) {
          PTSRichTextStyleParser.a(paramNode.truncateAttr);
        }
      }
      else {
        paramSpannableStringBuilder.append(',');
      }
    }
    else
    {
      paramSpannableStringBuilder.append(((TextNode)paramNode).text);
      PTSRichTextStyleParser.RichTextCssStyle.a(paramNode);
    }
    if (paramNode.children != null)
    {
      paramNode = paramNode.children.iterator();
      while (paramNode.hasNext()) {
        a((Node)paramNode.next(), paramSpannableStringBuilder);
      }
    }
  }
  
  private static void a(Node paramNode1, Node paramNode2, JSONObject paramJSONObject)
  {
    paramNode2.nodeRatio = paramNode1.nodeRatio;
    if ((paramJSONObject != null) && (paramJSONObject.has("ratio"))) {
      paramNode2.nodeRatio = paramJSONObject.optDouble("ratio", 1.0D);
    }
  }
  
  private static void a(Node paramNode1, Node paramNode2, JSONObject paramJSONObject1, CssStyleSet paramCssStyleSet, JSONObject paramJSONObject2)
  {
    if (paramNode2 == null) {
      return;
    }
    paramNode2.cssStyleSet = paramCssStyleSet;
    a(paramNode1, paramNode2, paramJSONObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSRichTextStyleParser.RichTextNode
 * JD-Core Version:    0.7.0.1
 */