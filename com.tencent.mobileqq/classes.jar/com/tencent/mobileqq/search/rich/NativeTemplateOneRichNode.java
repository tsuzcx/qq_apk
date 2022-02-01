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
    paramString1 = a();
    if (paramString1 != null) {
      paramString1.e();
    }
  }
  
  public void b()
  {
    super.b();
    AbstractGifImage.pauseAll();
  }
  
  public void c()
  {
    super.c();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.NativeTemplateOneRichNode
 * JD-Core Version:    0.7.0.1
 */