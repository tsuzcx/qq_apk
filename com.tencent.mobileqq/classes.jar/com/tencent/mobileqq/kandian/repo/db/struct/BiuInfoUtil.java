package com.tencent.mobileqq.kandian.repo.db.struct;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.handler.JumpInfo;
import java.util.List;

public class BiuInfoUtil
{
  public static CharSequence a(BiuInfo paramBiuInfo)
  {
    List localList = paramBiuInfo.a;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = localList.size();
    Object localObject = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).startsWith(":")) || (((String)localObject).startsWith("："))))
    {
      paramBiuInfo = ((String)localObject).substring(1);
    }
    else
    {
      paramBiuInfo = (BiuInfo)localObject;
      if (localObject == null) {
        paramBiuInfo = "";
      }
    }
    localSpannableStringBuilder.append(paramBiuInfo);
    i -= 2;
    while (i >= 0)
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
      int j = localBiuCommentInfo.mOpType;
      if ((j != 2) && (j != 3))
      {
        paramBiuInfo = ReadInJoyUserInfoModule.a(localBiuCommentInfo.mUin.longValue(), null);
        if (paramBiuInfo != null) {
          paramBiuInfo = paramBiuInfo.nick;
        } else {
          paramBiuInfo = ReadInJoyUserInfoModule.a();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("@");
        ((StringBuilder)localObject).append(paramBiuInfo);
        localObject = ((StringBuilder)localObject).toString();
        paramBiuInfo = (BiuInfo)localObject;
        if (localBiuCommentInfo.mOpType == 1)
        {
          paramBiuInfo = new StringBuilder();
          paramBiuInfo.append((String)localObject);
          paramBiuInfo.append(" ");
          paramBiuInfo = paramBiuInfo.toString();
        }
        if (localBiuCommentInfo.mBiuComment == null) {
          localObject = "";
        } else {
          localObject = localBiuCommentInfo.mBiuComment;
        }
        localSpannableStringBuilder.append(paramBiuInfo).append((CharSequence)localObject);
      }
      else if (localBiuCommentInfo.jumpInfo != null)
      {
        localObject = localBiuCommentInfo.jumpInfo.getWording();
        if (localBiuCommentInfo.mBiuComment == null) {
          paramBiuInfo = "";
        } else {
          paramBiuInfo = localBiuCommentInfo.mBiuComment;
        }
        localSpannableStringBuilder.append((CharSequence)localObject).append(paramBiuInfo);
      }
      i -= 1;
    }
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.BiuInfoUtil
 * JD-Core Version:    0.7.0.1
 */