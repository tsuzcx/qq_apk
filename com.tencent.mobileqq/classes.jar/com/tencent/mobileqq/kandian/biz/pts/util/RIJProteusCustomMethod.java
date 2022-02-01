package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/util/RIJProteusCustomMethod;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/CustomMethodsRegister$CustomMethodInterface;", "()V", "cmd", "", "data", "", "", "getData", "()[Ljava/lang/Object;", "setData", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "methodsMap", "", "Lkotlin/Function0;", "decodeEmotion", "", "getFirstItem", "hyperLinkJump", "", "invoke", "c", "d", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "registerMethod", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusCustomMethod
  implements CustomMethodsRegister.CustomMethodInterface
{
  public static final RIJProteusCustomMethod a;
  private static String b;
  @Nullable
  private static Object[] c;
  private static final Map<String, Function0<Object>> d;
  
  static
  {
    RIJProteusCustomMethod localRIJProteusCustomMethod = new RIJProteusCustomMethod();
    a = localRIJProteusCustomMethod;
    d = (Map)new LinkedHashMap();
    localRIJProteusCustomMethod.a();
  }
  
  private final void a()
  {
    d.put("decodeEmotion", RIJProteusCustomMethod.registerMethod.1.INSTANCE);
    d.put("HyperLinkClick", RIJProteusCustomMethod.registerMethod.2.INSTANCE);
  }
  
  private final CharSequence b()
  {
    Object localObject = c();
    if (localObject != null) {
      return (CharSequence)new QQText((CharSequence)localObject, 3, 16);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  private final Object c()
  {
    Object[] arrayOfObject = c;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (arrayOfObject != null)
    {
      localObject1 = localObject2;
      if (arrayOfObject.length >= 1) {
        localObject1 = EmotionCodecUtils.c(arrayOfObject[0].toString());
      }
    }
    return localObject1;
  }
  
  private final void d()
  {
    Object localObject = c();
    Context localContext = (Context)BaseApplicationImpl.getContext();
    if (localObject != null)
    {
      RIJJumpUtils.c(localContext, (String)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
  }
  
  @NotNull
  public Object invoke(@Nullable String paramString, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "d");
    b = paramString;
    c = new Object[] { paramVarArgs };
    paramString = (Function0)d.get(b);
    if (paramString != null)
    {
      paramString = paramString.invoke();
      if (paramString != null) {
        return paramString;
      }
    }
    return new Object();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusCustomMethod
 * JD-Core Version:    0.7.0.1
 */