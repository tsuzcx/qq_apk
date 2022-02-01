package com.tencent.mobileqq.vas.theme.diy;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.IFactoryStub;
import java.io.File;
import kotlin.jvm.functions.Function1;

final class ThemeBackground$5
  implements Function1<IFactoryStub, Drawable>
{
  ThemeBackground$5(String paramString) {}
  
  public Drawable a(IFactoryStub paramIFactoryStub)
  {
    return paramIFactoryStub.useCache(true).fromFile(new File(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.5
 * JD-Core Version:    0.7.0.1
 */