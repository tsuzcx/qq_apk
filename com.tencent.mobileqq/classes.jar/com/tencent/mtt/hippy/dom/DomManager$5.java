package com.tencent.mtt.hippy.dom;

import com.tencent.mtt.hippy.dom.node.b;
import com.tencent.mtt.hippy.uimanager.RenderManager;

class DomManager$5
  implements f
{
  DomManager$5(DomManager paramDomManager, float paramFloat1, float paramFloat2, b paramb) {}
  
  public void a()
  {
    int i = Math.round(this.a);
    int j = Math.round(this.b);
    int k = Math.round(this.a + this.c.getLayoutWidth());
    int m = Math.round(this.b + this.c.getLayoutHeight());
    this.d.j.a(this.c.getId(), i, j, k - i, m - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.DomManager.5
 * JD-Core Version:    0.7.0.1
 */