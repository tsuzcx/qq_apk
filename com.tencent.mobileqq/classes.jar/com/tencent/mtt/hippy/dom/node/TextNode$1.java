package com.tencent.mtt.hippy.dom.node;

import android.text.Layout;
import android.util.Log;
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
    paramf2 = (TextNode)paramg;
    paramg = null;
    int i = 0;
    try
    {
      paramf1 = TextNode.access$000(paramf2, paramFloat1, paramf1);
      paramg = paramf1;
    }
    catch (Throwable paramf1)
    {
      for (;;)
      {
        Log.e("TextNode", "text createLayout", paramf1);
        i = 1;
      }
      LogUtils.d("TextNode", "measure: w: " + paramg.getWidth() + " h: " + paramg.getHeight());
    }
    if ((i != 0) || (paramg == null)) {
      return h.a(paramFloat1, paramFloat2);
    }
    return h.a(paramg.getWidth(), paramg.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.node.TextNode.1
 * JD-Core Version:    0.7.0.1
 */