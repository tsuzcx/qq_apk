package com.tencent.xweb.extension.video;

import com.tencent.xweb.WebView;

class e$7
  implements c.a
{
  e$7(e parame) {}
  
  public void a()
  {
    this.a.e();
    this.a.g();
  }
  
  public void a(c paramc, float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = e.a(this.a);
      double d2 = paramFloat;
      Double.isNaN(d2);
      d1 = d1 * d2 / 100.0D;
      this.a.a(d1, false);
      e.b(this.a).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(d1) }), new e.7.1(this));
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e.7
 * JD-Core Version:    0.7.0.1
 */