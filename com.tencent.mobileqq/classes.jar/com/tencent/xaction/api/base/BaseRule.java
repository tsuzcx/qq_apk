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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/BaseRule;", "Lcom/tencent/xaction/api/ICreatRule;", "()V", "realtime", "", "getRealtime", "()Z", "setRealtime", "(Z)V", "ruleAnimParse", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "", "value", "setAnimValue", "", "floatArray", "", "setStyleValue", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "XActionCore_release"}, k=1, mv={1, 1, 16})
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
    default: 
    case 1384173150: 
      if ((paramString.equals("rotateY")) && ((paramBaseAnim instanceof Rotate)) && (paramArrayOfFloat.length == 1))
      {
        ((Rotate)paramBaseAnim).setRy(paramArrayOfFloat[0]);
        return;
      }
      break;
    case 1384173149: 
      if ((paramString.equals("rotateX")) && ((paramBaseAnim instanceof Rotate)) && (paramArrayOfFloat.length == 1))
      {
        ((Rotate)paramBaseAnim).setRx(paramArrayOfFloat[0]);
        return;
      }
      break;
    case 109250890: 
      if ((paramString.equals("scale")) && ((paramBaseAnim instanceof Scale)) && (paramArrayOfFloat.length == 2))
      {
        paramBaseAnim = (Scale)paramBaseAnim;
        paramBaseAnim.setSx(paramArrayOfFloat[0]);
        paramBaseAnim.setSy(paramArrayOfFloat[1]);
        return;
      }
      break;
    case 121: 
      if ((paramString.equals("y")) && ((paramBaseAnim instanceof Layout)) && (paramArrayOfFloat.length == 1))
      {
        ((Layout)paramBaseAnim).setY(ScreenUnit.a.e(paramArrayOfFloat[0]));
        return;
      }
      break;
    case 120: 
      if ((paramString.equals("x")) && ((paramBaseAnim instanceof Layout)) && (paramArrayOfFloat.length == 1))
      {
        ((Layout)paramBaseAnim).setX(ScreenUnit.a.e(paramArrayOfFloat[0]));
        return;
      }
      break;
    case 119: 
      if ((paramString.equals("w")) && ((paramBaseAnim instanceof Layout)) && (paramArrayOfFloat.length == 1))
      {
        ((Layout)paramBaseAnim).setW(ScreenUnit.a.e(paramArrayOfFloat[0]));
        return;
      }
      break;
    case 104: 
      if ((paramString.equals("h")) && ((paramBaseAnim instanceof Layout)) && (paramArrayOfFloat.length == 1))
      {
        ((Layout)paramBaseAnim).setH(ScreenUnit.a.e(paramArrayOfFloat[0]));
        return;
      }
      break;
    case -908189617: 
      if ((paramString.equals("scaleY")) && ((paramBaseAnim instanceof Scale)) && (paramArrayOfFloat.length == 1))
      {
        ((Scale)paramBaseAnim).setSy(paramArrayOfFloat[0]);
        return;
      }
      break;
    case -908189618: 
      if ((paramString.equals("scaleX")) && ((paramBaseAnim instanceof Scale)) && (paramArrayOfFloat.length == 1))
      {
        ((Scale)paramBaseAnim).setSx(paramArrayOfFloat[0]);
        return;
      }
      break;
    case -925180581: 
      if ((paramString.equals("rotate")) && ((paramBaseAnim instanceof Rotate)) && (paramArrayOfFloat.length == 2))
      {
        paramBaseAnim = (Rotate)paramBaseAnim;
        paramBaseAnim.setRx(paramArrayOfFloat[0]);
        paramBaseAnim.setRy(paramArrayOfFloat[1]);
        return;
      }
      break;
    case -1225497656: 
      if ((paramString.equals("translationY")) && ((paramBaseAnim instanceof Translation)) && (paramArrayOfFloat.length == 1))
      {
        ((Translation)paramBaseAnim).setTy(paramArrayOfFloat[0]);
        return;
      }
      break;
    case -1225497657: 
      if ((paramString.equals("translationX")) && ((paramBaseAnim instanceof Translation)) && (paramArrayOfFloat.length == 1))
      {
        ((Translation)paramBaseAnim).setTx(paramArrayOfFloat[0]);
        return;
      }
      break;
    case -1267206133: 
      if ((paramString.equals("opacity")) && ((paramBaseAnim instanceof Opacity)) && (paramArrayOfFloat.length == 1))
      {
        ((Opacity)paramBaseAnim).setOp(paramArrayOfFloat[0]);
        return;
      }
      break;
    case -1840647503: 
      if ((paramString.equals("translation")) && ((paramBaseAnim instanceof Translation)) && (paramArrayOfFloat.length == 2))
      {
        paramBaseAnim = (Translation)paramBaseAnim;
        paramBaseAnim.setTx(paramArrayOfFloat[0]);
        paramBaseAnim.setTy(paramArrayOfFloat[1]);
      }
      break;
    }
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
    int i = paramString.hashCode();
    if (i != 104)
    {
      if (i != 3137)
      {
        if (i != 3553)
        {
          if (i != 3793)
          {
            if (i != 3841)
            {
              if (i != 3654)
              {
                if (i != 3655)
                {
                  if (i != 3685)
                  {
                    if (i != 3686) {
                      switch (i)
                      {
                      default: 
                        return;
                      case 121: 
                        if ((!paramString.equals("y")) || (paramArrayOfFloat.length != 1)) {
                          break;
                        }
                        paramViewData.getSt().setY(ScreenUnit.a.e(paramArrayOfFloat[0]));
                        return;
                      case 120: 
                        if ((!paramString.equals("x")) || (paramArrayOfFloat.length != 1)) {
                          break;
                        }
                        paramViewData.getSt().setX(ScreenUnit.a.e(paramArrayOfFloat[0]));
                        return;
                      case 119: 
                        if ((!paramString.equals("w")) || (paramArrayOfFloat.length != 1)) {
                          break;
                        }
                        paramViewData.getSt().setW(ScreenUnit.a.e(paramArrayOfFloat[0]));
                        return;
                      }
                    } else if ((paramString.equals("sy")) && (paramArrayOfFloat.length == 1)) {
                      paramViewData.getSt().setSy(paramArrayOfFloat[0]);
                    }
                  }
                  else if ((paramString.equals("sx")) && (paramArrayOfFloat.length == 1)) {
                    paramViewData.getSt().setSy(paramArrayOfFloat[0]);
                  }
                }
                else if ((paramString.equals("ry")) && (paramArrayOfFloat.length == 1)) {
                  paramViewData.getSt().setRy((int)paramArrayOfFloat[0]);
                }
              }
              else if ((paramString.equals("rx")) && (paramArrayOfFloat.length == 1)) {
                paramViewData.getSt().setRx((int)paramArrayOfFloat[0]);
              }
            }
            else if ((paramString.equals("xy")) && (paramArrayOfFloat.length == 2))
            {
              paramViewData.getSt().setX(ScreenUnit.a.e(paramArrayOfFloat[0]));
              paramViewData.getSt().setY(ScreenUnit.a.e(paramArrayOfFloat[1]));
            }
          }
          else if ((paramString.equals("wh")) && (paramArrayOfFloat.length == 2))
          {
            paramViewData.getSt().setW(ScreenUnit.a.e(paramArrayOfFloat[0]));
            paramViewData.getSt().setH(ScreenUnit.a.e(paramArrayOfFloat[1]));
          }
        }
        else if ((paramString.equals("op")) && (paramArrayOfFloat.length == 1)) {
          paramViewData.getSt().setOp(paramArrayOfFloat[0]);
        }
      }
      else if ((paramString.equals("bc")) && (paramArrayOfFloat.length == 1))
      {
        paramViewData = paramViewData.getSt();
        paramString = new StringBuilder();
        paramString.append("#");
        paramArrayOfFloat = Integer.toString((int)paramArrayOfFloat[0], CharsKt.checkRadix(16));
        Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        paramString.append(paramArrayOfFloat);
        paramViewData.setBc(paramString.toString());
      }
    }
    else if ((paramString.equals("h")) && (paramArrayOfFloat.length == 1)) {
      paramViewData.getSt().setH(ScreenUnit.a.e(paramArrayOfFloat[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.base.BaseRule
 * JD-Core Version:    0.7.0.1
 */