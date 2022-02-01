package com.tencent.mobileqq.kandian.biz.comment.base.model;

import android.content.Intent;
import androidx.annotation.CallSuper;
import com.tencent.mobileqq.utils.Base64Util;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/base/model/BasePublishScene;", "Lcom/tencent/mobileqq/kandian/biz/comment/base/model/IPublishScene;", "()V", "getInputHint", "", "onDeliver", "", "intent", "Landroid/content/Intent;", "result", "packageDataInfo", "resultJson", "Lorg/json/JSONObject;", "text", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class BasePublishScene
  implements IPublishScene
{
  @NotNull
  public String a()
  {
    return "";
  }
  
  @CallSuper
  public void a(@NotNull Intent paramIntent, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    paramIntent.putExtra("arg_result_json", paramString);
  }
  
  @CallSuper
  public void a(@NotNull JSONObject paramJSONObject, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "resultJson");
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return;
    }
    localObject = Charsets.UTF_8;
    if (paramString != null)
    {
      paramString = paramString.getBytes((Charset)localObject);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      paramString = Base64Util.encode(paramString, 0);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "Base64Util.encode(text.t…ay(), Base64Util.DEFAULT)");
      paramJSONObject.put("comment", new String(paramString, Charsets.UTF_8));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.BasePublishScene
 * JD-Core Version:    0.7.0.1
 */