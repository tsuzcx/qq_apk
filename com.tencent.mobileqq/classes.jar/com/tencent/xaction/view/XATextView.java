package com.tencent.xaction.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.base.DecorView;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.impl.XAEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/view/XATextView;", "Landroid/widget/TextView;", "Lcom/tencent/xaction/api/IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "decor", "Lcom/tencent/xaction/api/base/DecorView;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorView;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorView;)V", "setFontStyle", "", "it", "Lcom/tencent/xaction/api/style/Style;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
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
  
  private final void a(Style paramStyle)
  {
    Object localObject = paramStyle.getFw();
    int i;
    switch (((String)localObject).hashCode())
    {
    default: 
      i = 0;
      label54:
      if (((Intrinsics.areEqual(paramStyle.getFf(), "") ^ true)) && (i != 0))
      {
        if (TextUtils.isEmpty((CharSequence)paramStyle.getFf())) {
          break label186;
        }
        localObject = Typeface.create(getTypeface(), i);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Typeface.create(typeface, fontWeight)");
      }
      break;
    }
    for (;;)
    {
      setTypeface((Typeface)localObject);
      if (!TextUtils.isEmpty((CharSequence)paramStyle.getFc())) {}
      try
      {
        setTextColor(Color.parseColor(paramStyle.getFc()));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        XAEngine localXAEngine = a().a();
        if (localXAEngine != null) {
          break label224;
        }
        Intrinsics.throwNpe();
        localXAEngine.logi("XATextView", 1, " it.fc:" + paramStyle.getFc() + " color format error");
      }
      if (!((String)localObject).equals("normal")) {
        break;
      }
      i = 0;
      break label54;
      if (!((String)localObject).equals("bold")) {
        break;
      }
      i = 1;
      break label54;
      if (!((String)localObject).equals("bold_italic")) {
        break;
      }
      i = 3;
      break label54;
      if (!((String)localObject).equals("italic")) {
        break;
      }
      i = 2;
      break label54;
      label186:
      localObject = Typeface.create(paramStyle.getFf(), i);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Typeface.create(it.ff, fontWeight)");
    }
    label224:
  }
  
  @NotNull
  public DecorView a()
  {
    return this.a;
  }
  
  public void setDecor(@NotNull DecorView paramDecorView)
  {
    Intrinsics.checkParameterIsNotNull(paramDecorView, "<set-?>");
    this.a = paramDecorView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.view.XATextView
 * JD-Core Version:    0.7.0.1
 */