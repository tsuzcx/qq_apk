package com.tencent.xaction.apng;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.image.ApngImage;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAApngView$Companion$initApng$1
  implements Runnable
{
  XAApngView$Companion$initApng$1(String paramString, Bundle paramBundle, Resources paramResources, ViewData paramViewData, Function1 paramFunction1) {}
  
  public final void run()
  {
    ApngDrawable localApngDrawable = new ApngDrawable(new ApngImage(new File(this.a), true, this.b), this.c);
    Object localObject = this.d.getExts();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((HashMap)localObject).get("gravity");
    if ((localObject != null) && ((localObject instanceof Integer))) {
      localApngDrawable.setGravity(((Number)localObject).intValue());
    }
    localObject = localApngDrawable.getImage();
    if (localObject != null) {
      ((ApngImage)localObject).apngLoop = this.d.getTp().getRc();
    }
    this.e.invoke(localApngDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.XAApngView.Companion.initApng.1
 * JD-Core Version:    0.7.0.1
 */