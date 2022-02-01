package com.tencent.mtt.hippy.dom.node;

import android.text.Layout;
import com.tencent.mtt.hippy.dom.a.f;
import com.tencent.mtt.hippy.dom.a.g;
import com.tencent.mtt.hippy.dom.a.g.a;
import com.tencent.mtt.hippy.dom.a.h;
import com.tencent.mtt.hippy.utils.LogUtils;

final class TextNode$1
  implements g.a
{
  public long measure(g paramg, float paramFloat1, f paramf1, float paramFloat2, f paramf2)
  {
    paramg = (TextNode)paramg;
    int i;
    try
    {
      paramg = TextNode.access$000(paramg, paramFloat1, paramf1);
      i = 0;
    }
    catch (Throwable paramg)
    {
      LogUtils.e("TextNode", "text createLayout", paramg);
      i = 1;
      paramg = null;
    }
    if ((i == 0) && (paramg != null))
    {
      paramf1 = new StringBuilder();
      paramf1.append("measure: w: ");
      paramf1.append(paramg.getWidth());
      paramf1.append(" h: ");
      paramf1.append(paramg.getHeight());
      LogUtils.d("TextNode", paramf1.toString());
      return h.a(paramg.getWidth(), paramg.getHeight());
    }
    return h.a(paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TextNode.1
 * JD-Core Version:    0.7.0.1
 */