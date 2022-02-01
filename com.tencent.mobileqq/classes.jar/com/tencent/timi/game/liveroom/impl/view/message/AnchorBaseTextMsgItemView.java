package com.tencent.timi.game.liveroom.impl.view.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ui.utils.ResUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "getBgDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "bgDrawable$delegate", "Lkotlin/Lazy;", "contentSpannable", "Landroid/text/SpannableStringBuilder;", "nickSpan", "Landroid/text/style/ForegroundColorSpan;", "getNickSpan", "()Landroid/text/style/ForegroundColorSpan;", "roomId", "", "genImageSpan", "bmp", "Landroid/graphics/Bitmap;", "bmpWidth", "bmpHeight", "leftMargin", "rightMargin", "genTextSpan", "Landroid/text/SpannableString;", "text", "", "style", "Landroid/text/style/CharacterStyle;", "getRoomId", "setRoomId", "", "setSpanText", "spans", "", "", "NickNameLongClick", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract class AnchorBaseTextMsgItemView
  extends AppCompatTextView
{
  private final SpannableStringBuilder a = new SpannableStringBuilder();
  @NotNull
  private final ForegroundColorSpan b = new ForegroundColorSpan(ResUtils.b(2131168483));
  private long c;
  @NotNull
  private final Lazy d = LazyKt.lazy((Function0)AnchorBaseTextMsgItemView.bgDrawable.2.INSTANCE);
  
  @JvmOverloads
  public AnchorBaseTextMsgItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorBaseTextMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorBaseTextMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setShadowLayer(LayoutExKt.a(8), 0.0F, 0.0F, ResUtils.b(2131168376));
    setPadding(LayoutExKt.b(10), LayoutExKt.b(8), LayoutExKt.b(10), LayoutExKt.b(8));
    setBackgroundDrawable((Drawable)getBgDrawable());
    setTextColor(ResUtils.b(2131168464));
    LayoutExKt.a(this, 12.0F);
    setLineSpacing(0.0F, 1.3F);
    setHighlightColor(0);
    setMovementMethod(LinkMovementMethod.getInstance());
    paramContext = new ViewGroup.LayoutParams(LayoutExKt.a(this), LayoutExKt.a(this));
    setGravity(16);
    setMinHeight(LayoutExKt.b(30));
    setLayoutParams(paramContext);
  }
  
  @NotNull
  public final SpannableString a(@NotNull String paramString, @Nullable CharacterStyle paramCharacterStyle)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    if ((paramCharacterStyle instanceof CharacterStyle)) {
      localSpannableString.setSpan(paramCharacterStyle, 0, paramString.length(), 17);
    }
    return localSpannableString;
  }
  
  @NotNull
  public final SpannableStringBuilder a(@NotNull Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bmp");
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder((CharSequence)" ");
    if ((paramInt1 != paramBitmap.getWidth()) || (paramInt2 != paramBitmap.getHeight()))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      float f4 = paramInt1;
      float f1 = f4 / paramBitmap.getWidth();
      float f3 = paramInt2;
      float f2 = f3 / paramBitmap.getHeight();
      f4 /= 2.0F;
      f3 /= 2.0F;
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f1, f2, f4, f3);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.setMatrix(localMatrix);
      localCanvas.drawBitmap(paramBitmap, f4 - paramBitmap.getWidth() / 2, f3 - paramBitmap.getHeight() / 2, new Paint(7));
      paramBitmap = localBitmap;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramBitmap, "bmp.let {\n              …caledBitmap\n            }");
    localSpannableStringBuilder.setSpan(new CenterAlignSizeImageSpan(paramBitmap, paramInt3, paramInt4), 0, 1, 33);
    return localSpannableStringBuilder;
  }
  
  @NotNull
  protected final GradientDrawable getBgDrawable()
  {
    return (GradientDrawable)this.d.getValue();
  }
  
  @NotNull
  protected final ForegroundColorSpan getNickSpan()
  {
    return this.b;
  }
  
  public final long getRoomId()
  {
    return this.c;
  }
  
  public final void setRoomId(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void setSpanText(@NotNull List<? extends CharSequence> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "spans");
    this.a.clear();
    this.a.clearSpans();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      CharSequence localCharSequence = (CharSequence)paramList.next();
      this.a.append(localCharSequence);
    }
    setText((CharSequence)this.a);
    setMovementMethod((MovementMethod)LinkMovementLongClickMethod.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorBaseTextMsgItemView
 * JD-Core Version:    0.7.0.1
 */