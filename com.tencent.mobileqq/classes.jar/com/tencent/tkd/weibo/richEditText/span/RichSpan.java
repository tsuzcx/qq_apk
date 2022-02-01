package com.tencent.tkd.weibo.richEditText.span;

import android.text.style.ForegroundColorSpan;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/richEditText/span/RichSpan;", "Landroid/text/style/ForegroundColorSpan;", "color", "", "type", "Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "id", "", "(ILcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getType", "()Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;", "setType", "(Lcom/tencent/tkd/weibo/bean/EditObject$EditObjectType;)V", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class RichSpan
  extends ForegroundColorSpan
{
  @NotNull
  private EditObject.EditObjectType a;
  @NotNull
  private String b;
  
  public RichSpan(int paramInt, @NotNull EditObject.EditObjectType paramEditObjectType, @NotNull String paramString)
  {
    super(paramInt);
    this.a = paramEditObjectType;
    this.b = paramString;
  }
  
  @NotNull
  public final EditObject.EditObjectType a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.richEditText.span.RichSpan
 * JD-Core Version:    0.7.0.1
 */