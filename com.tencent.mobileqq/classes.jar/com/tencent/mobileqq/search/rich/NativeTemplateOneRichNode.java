package com.tencent.mobileqq.search.rich;

import android.content.Context;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView;

public class NativeTemplateOneRichNode
  extends NativeRichNode
{
  protected IRichNodeView a(Context paramContext)
  {
    return new RichTemplateOneSearchResultView(this, paramContext);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    super.a(paramString1, paramString2, paramString3);
    paramString1 = h();
    if (paramString1 != null) {
      paramString1.j();
    }
  }
  
  public void e()
  {
    super.e();
    AbstractGifImage.pauseAll();
  }
  
  public void f()
  {
    super.f();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.NativeTemplateOneRichNode
 * JD-Core Version:    0.7.0.1
 */