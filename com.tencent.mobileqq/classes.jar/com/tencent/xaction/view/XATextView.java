package com.tencent.xaction.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.impl.XAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XATextView;", "Landroid/widget/TextView;", "Lcom/tencent/xaction/api/IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "setFontStyle", "", "it", "Lcom/tencent/xaction/api/style/Style;", "setLineHeight", "setTypeface", "XActionCore_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"AppCompatCustomView"})
public final class XATextView
  extends TextView
  implements IView
{
  @NotNull
  private DecorView a = (DecorView)new XATextView.decor.1(this, (IView)this);
  
  public XATextView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  private final void setFontStyle(Style paramStyle)
  {
    setTypeface(paramStyle);
    setLineHeight(paramStyle);
    if (!TextUtils.isEmpty((CharSequence)paramStyle.getFc())) {
      try
      {
        setTextColor(Color.parseColor(paramStyle.getFc()));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        Object localObject = getDecor().d();
        if (localObject != null)
        {
          localObject = (XAEngine)localObject;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" it.fc:");
          localStringBuilder.append(paramStyle.getFc());
          localStringBuilder.append(" color format error");
          ((XAEngine)localObject).logi("XATextView", 1, localStringBuilder.toString());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
      }
    }
  }
  
  private final void setLineHeight(Style paramStyle)
  {
    if (paramStyle.getFh() > 0)
    {
      int i = getPaint().getFontMetricsInt(null);
      int j = (paramStyle.getFh() + i) / 2;
      int k = paramStyle.getPt();
      setPadding(paramStyle.getPl(), j + k, paramStyle.getPr(), paramStyle.getPb());
      if (Build.VERSION.SDK_INT >= 28)
      {
        setLineHeight(paramStyle.getFh());
        return;
      }
      if (paramStyle.getFh() != i) {
        setLineSpacing(paramStyle.getFh() - i, 1.0F);
      }
    }
  }
  
  private final void setTypeface(Style paramStyle)
  {
    String str = paramStyle.getFw();
    int j = str.hashCode();
    int i = 0;
    switch (j)
    {
    default: 
      break;
    case 1734741290: 
      if (str.equals("bold_italic")) {
        i = 3;
      }
      break;
    case 3029637: 
      if (str.equals("bold")) {
        i = 1;
      }
      break;
    case -1039745817: 
      str.equals("normal");
      break;
    case -1178781136: 
      if (str.equals("italic")) {
        i = 2;
      }
      break;
    }
    if (!TextUtils.isEmpty((CharSequence)paramStyle.getFf())) {
      paramStyle = Typeface.create(paramStyle.getFf(), i);
    } else {
      paramStyle = Typeface.create(getTypeface(), i);
    }
    setTypeface(paramStyle);
  }
  
  @NotNull
  public DecorView getDecor()
  {
    return this.a;
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.a = paramDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.view.XATextView
 * JD-Core Version:    0.7.0.1
 */