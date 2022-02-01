package com.tencent.mobileqq.kandian.biz.pts.util;

import android.text.SpannableStringBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister.CustomMethodInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.IViewProxy;
import com.tencent.mobileqq.kandian.base.utils.api.IEmotionCodecUtils;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEmotionUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;

class RIJProteusMethod$MethodDecodeEmotion
  implements CustomMethodsRegister.CustomMethodInterface
{
  public Object invoke(String paramString, Object... paramVarArgs)
  {
    Object localObject = null;
    String str1;
    if ((paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      paramString = String.valueOf(paramVarArgs[0]);
      String str2 = ((IEmotionCodecUtils)QRoute.api(IEmotionCodecUtils.class)).decodeQQEmotion(paramString);
      str1 = str2;
      paramString = localObject;
      if (paramVarArgs.length >= 2)
      {
        str1 = str2;
        paramString = localObject;
        if ((paramVarArgs[1] instanceof IViewProxy))
        {
          paramString = (IViewProxy)paramVarArgs[1];
          str1 = str2;
        }
      }
    }
    else
    {
      str1 = "";
      paramString = localObject;
    }
    paramVarArgs = new SpannableStringBuilder(new QQText(str1, 3, 16, null, new RIJProteusMethod.MethodDecodeEmotion.1(this, paramString)));
    ((IRIJCommentEmotionUtil)QRoute.api(IRIJCommentEmotionUtil.class)).decodeCommentEmotion(paramString, paramVarArgs);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJProteusMethod.MethodDecodeEmotion
 * JD-Core Version:    0.7.0.1
 */