package com.tencent.xaction.api.base;

import com.tencent.xaction.anim.Layout;
import com.tencent.xaction.anim.Opacity;
import com.tencent.xaction.anim.Rotate;
import com.tencent.xaction.anim.Scale;
import com.tencent.xaction.anim.Translation;
import com.tencent.xaction.api.ICreatRule;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/BaseRule;", "Lcom/tencent/xaction/api/ICreatRule;", "()V", "realtime", "", "getRealtime", "()Z", "setRealtime", "(Z)V", "ruleAnimParse", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "", "value", "setAnimValue", "", "floatArray", "", "setStyleValue", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public abstract class BaseRule
  implements ICreatRule
{
  private boolean realtime;
  
  public final boolean getRealtime()
  {
    return this.realtime;
  }
  
  public boolean ruleAnimParse(@NotNull BaseAnim paramBaseAnim, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    return false;
  }
  
  public final void setAnimValue(@NotNull BaseAnim paramBaseAnim, @NotNull String paramString, @NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "floatArray");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                return;
                              } while ((!paramString.equals("rotate")) || (!(paramBaseAnim instanceof Rotate)) || (paramArrayOfFloat.length != 2));
                              ((Rotate)paramBaseAnim).setRx(paramArrayOfFloat[0]);
                              ((Rotate)paramBaseAnim).setRy(paramArrayOfFloat[1]);
                              return;
                            } while ((!paramString.equals("h")) || (!(paramBaseAnim instanceof Layout)) || (paramArrayOfFloat.length != 1));
                            ((Layout)paramBaseAnim).setH((int)ScreenUnit.a.a(paramArrayOfFloat[0]));
                            return;
                          } while ((!paramString.equals("scale")) || (!(paramBaseAnim instanceof Scale)) || (paramArrayOfFloat.length != 2));
                          ((Scale)paramBaseAnim).setSx(paramArrayOfFloat[0]);
                          ((Scale)paramBaseAnim).setSy(paramArrayOfFloat[1]);
                          return;
                        } while ((!paramString.equals("scaleX")) || (!(paramBaseAnim instanceof Scale)) || (paramArrayOfFloat.length != 1));
                        ((Scale)paramBaseAnim).setSx(paramArrayOfFloat[0]);
                        return;
                      } while ((!paramString.equals("scaleY")) || (!(paramBaseAnim instanceof Scale)) || (paramArrayOfFloat.length != 1));
                      ((Scale)paramBaseAnim).setSy(paramArrayOfFloat[0]);
                      return;
                    } while ((!paramString.equals("translationX")) || (!(paramBaseAnim instanceof Translation)) || (paramArrayOfFloat.length != 1));
                    ((Translation)paramBaseAnim).setTx(paramArrayOfFloat[0]);
                    return;
                  } while ((!paramString.equals("w")) || (!(paramBaseAnim instanceof Layout)) || (paramArrayOfFloat.length != 1));
                  ((Layout)paramBaseAnim).setW((int)ScreenUnit.a.a(paramArrayOfFloat[0]));
                  return;
                } while ((!paramString.equals("translation")) || (!(paramBaseAnim instanceof Translation)) || (paramArrayOfFloat.length != 2));
                ((Translation)paramBaseAnim).setTx(paramArrayOfFloat[0]);
                ((Translation)paramBaseAnim).setTy(paramArrayOfFloat[1]);
                return;
              } while ((!paramString.equals("x")) || (!(paramBaseAnim instanceof Layout)) || (paramArrayOfFloat.length != 1));
              ((Layout)paramBaseAnim).setX((int)ScreenUnit.a.a(paramArrayOfFloat[0]));
              return;
            } while ((!paramString.equals("y")) || (!(paramBaseAnim instanceof Layout)) || (paramArrayOfFloat.length != 1));
            ((Layout)paramBaseAnim).setY((int)ScreenUnit.a.a(paramArrayOfFloat[0]));
            return;
          } while ((!paramString.equals("translationY")) || (!(paramBaseAnim instanceof Translation)) || (paramArrayOfFloat.length != 1));
          ((Translation)paramBaseAnim).setTy(paramArrayOfFloat[0]);
          return;
        } while ((!paramString.equals("opacity")) || (!(paramBaseAnim instanceof Opacity)) || (paramArrayOfFloat.length != 1));
        ((Opacity)paramBaseAnim).setOp(paramArrayOfFloat[0]);
        return;
      } while ((!paramString.equals("rotateX")) || (!(paramBaseAnim instanceof Rotate)) || (paramArrayOfFloat.length != 1));
      ((Rotate)paramBaseAnim).setRx(paramArrayOfFloat[0]);
      return;
    } while ((!paramString.equals("rotateY")) || (!(paramBaseAnim instanceof Rotate)) || (paramArrayOfFloat.length != 1));
    ((Rotate)paramBaseAnim).setRy(paramArrayOfFloat[0]);
  }
  
  public final void setRealtime(boolean paramBoolean)
  {
    this.realtime = paramBoolean;
  }
  
  public final void setStyleValue(@NotNull ViewData paramViewData, @NotNull String paramString, @NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "floatArray");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                          } while ((!paramString.equals("wh")) || (paramArrayOfFloat.length != 2));
                          paramViewData.getSt().setW(ScreenUnit.a.a(paramArrayOfFloat[0]));
                          paramViewData.getSt().setH(ScreenUnit.a.a(paramArrayOfFloat[1]));
                          return;
                        } while ((!paramString.equals("xy")) || (paramArrayOfFloat.length != 2));
                        paramViewData.getSt().setX(ScreenUnit.a.a(paramArrayOfFloat[0]));
                        paramViewData.getSt().setY(ScreenUnit.a.a(paramArrayOfFloat[1]));
                        return;
                      } while ((!paramString.equals("op")) || (paramArrayOfFloat.length != 1));
                      paramViewData.getSt().setOp(paramArrayOfFloat[0]);
                      return;
                    } while ((!paramString.equals("bc")) || (paramArrayOfFloat.length != 1));
                    paramViewData = paramViewData.getSt();
                    paramString = new StringBuilder().append("#");
                    paramArrayOfFloat = Integer.toString((int)paramArrayOfFloat[0], CharsKt.checkRadix(16));
                    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    paramViewData.setBc(paramArrayOfFloat);
                    return;
                  } while ((!paramString.equals("sx")) || (paramArrayOfFloat.length != 1));
                  paramViewData.getSt().setSy(paramArrayOfFloat[0]);
                  return;
                } while ((!paramString.equals("sy")) || (paramArrayOfFloat.length != 1));
                paramViewData.getSt().setSy(paramArrayOfFloat[0]);
                return;
              } while ((!paramString.equals("rx")) || (paramArrayOfFloat.length != 1));
              paramViewData.getSt().setRx((int)paramArrayOfFloat[0]);
              return;
            } while ((!paramString.equals("w")) || (paramArrayOfFloat.length != 1));
            paramViewData.getSt().setW(ScreenUnit.a.a(paramArrayOfFloat[0]));
            return;
          } while ((!paramString.equals("ry")) || (paramArrayOfFloat.length != 1));
          paramViewData.getSt().setRy((int)paramArrayOfFloat[0]);
          return;
        } while ((!paramString.equals("h")) || (paramArrayOfFloat.length != 1));
        paramViewData.getSt().setH(ScreenUnit.a.a(paramArrayOfFloat[0]));
        return;
      } while ((!paramString.equals("x")) || (paramArrayOfFloat.length != 1));
      paramViewData.getSt().setX(ScreenUnit.a.a(paramArrayOfFloat[0]));
      return;
    } while ((!paramString.equals("y")) || (paramArrayOfFloat.length != 1));
    paramViewData.getSt().setY(ScreenUnit.a.a(paramArrayOfFloat[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.BaseRule
 * JD-Core Version:    0.7.0.1
 */