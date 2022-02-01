package com.tencent.mobileqq.vas.theme.diy;

import android.graphics.drawable.Drawable;
import com.tencent.android.gldrawable.api.IFactoryStub;
import java.io.File;
import kotlin.jvm.functions.Function1;

final class ThemeBackground$4
  implements Function1<IFactoryStub, Drawable>
{
  ThemeBackground$4(File paramFile) {}
  
  public Drawable a(IFactoryStub paramIFactoryStub)
  {
    return paramIFactoryStub.useCache(true).fromFile(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground.4
 * JD-Core Version:    0.7.0.1
 */