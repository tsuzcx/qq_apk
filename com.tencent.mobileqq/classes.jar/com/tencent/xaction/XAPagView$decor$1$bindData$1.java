package com.tencent.xaction;

import android.content.res.Resources;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.FilePathUtil;
import com.tencent.xaction.api.util.FilePathUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAPagView$decor$1$bindData$1
  implements Runnable
{
  XAPagView$decor$1$bindData$1(XAPagView.decor.1 param1, String paramString) {}
  
  public final void run()
  {
    try
    {
      QLog.a(XAPagView.access$getTAG$p(this.this$0.a), 2, "XAPagView.bindData().execute");
      Object localObject1;
      if (FileUtil.a.b(this.a))
      {
        localObject1 = this.this$0.a.getResources();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "resources");
        localObject1 = PAGFile.Load(((Resources)localObject1).getAssets(), FileUtil.a.a(this.a));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "PAGFile.Load(resources.a…laceAsserts(pagFilePath))");
      }
      else
      {
        localObject1 = FilePathUtil.a.a(this.a, "$PARENT_ROOT", this.this$0.d());
        if (!new File((String)localObject1).exists()) {
          return;
        }
        localObject1 = PAGFile.Load((String)localObject1);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "PAGFile.Load(filePath)");
      }
      this.this$0.a.addListener((PAGView.PAGViewListener)new XAPagView.decor.1.bindData.1.1(this));
      this.this$0.a.setComposition((PAGComposition)localObject1);
      Object localObject2 = this.this$0.e();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      if (((ViewData)localObject2).getTp().getRc() == ScreenUnit.a.a())
      {
        this.this$0.a.setRepeatCount(0);
      }
      else
      {
        localObject2 = this.this$0.a;
        localViewData = this.this$0.e();
        if (localViewData == null) {
          Intrinsics.throwNpe();
        }
        ((XAPagView)localObject2).setRepeatCount(localViewData.getTp().getRc() + 1);
      }
      localObject2 = this.this$0.a;
      ViewData localViewData = this.this$0.e();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      ((XAPagView)localObject2).setPAGScaleMode(localViewData, this.this$0.a);
      localObject2 = this.this$0.e();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      if (((ViewData)localObject2).getTp().getAutoPlay()) {
        this.this$0.a.post((Runnable)new XAPagView.decor.1.bindData.1.2(this));
      }
      localObject2 = this.this$0.a;
      localViewData = this.this$0.e();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      IXAEngine localIXAEngine = this.this$0.d();
      if (localIXAEngine == null) {
        Intrinsics.throwNpe();
      }
      ((XAPagView)localObject2).replacePagText(localViewData, localIXAEngine, this.this$0.a, (PAGFile)localObject1);
      localObject2 = this.this$0.a;
      localViewData = this.this$0.e();
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      localIXAEngine = this.this$0.d();
      if (localIXAEngine == null) {
        Intrinsics.throwNpe();
      }
      ((XAPagView)localObject2).replacePagImage(localViewData, localIXAEngine, this.this$0.a, (PAGFile)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XAPagView.decor.1.bindData.1
 * JD-Core Version:    0.7.0.1
 */