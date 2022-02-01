package com.tencent.mobileqq.kandian.biz.comment.rptdata.at;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil.PTSCommentModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class RIJCommentAtUtil
{
  public static void a(@NonNull View paramView, @NonNull String paramString)
  {
    paramString = paramString.substring(0, paramString.length() - 11);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onAtClick: uin=");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("RIJCommentAtUtil", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    localObject = paramView.getTag(2131376111);
    if (!(localObject instanceof RIJCommentRptDataUtil.PTSCommentModel))
    {
      paramView = new StringBuilder();
      paramView.append("onAtClick: tag is");
      paramView.append(localObject);
      QLog.d("RIJCommentAtUtil", 1, paramView.toString());
      return;
    }
    localObject = (RIJCommentRptDataUtil.PTSCommentModel)localObject;
    ReadInJoyCommentUtils.a(paramString, paramView.getContext(), ((RIJCommentRptDataUtil.PTSCommentModel)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    a((RIJCommentRptDataUtil.PTSCommentModel)localObject, paramString);
  }
  
  private static void a(RIJCommentRptDataUtil.PTSCommentModel paramPTSCommentModel, CharSequence paramCharSequence)
  {
    Iterator localIterator = paramPTSCommentModel.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentRptDataList.iterator();
    while (localIterator.hasNext())
    {
      BaseCommentData.CommentRptData localCommentRptData = (BaseCommentData.CommentRptData)localIterator.next();
      if ((localCommentRptData.a == 1) && (TextUtils.equals(paramCharSequence, localCommentRptData.b))) {
        RIJCommentRptDataUtil.a(paramPTSCommentModel, localCommentRptData, "0X800BAC2");
      }
    }
  }
  
  public static boolean a()
  {
    boolean bool = RIJCommentAtUi.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isCommentAtDisplaySwitchOn: atSwitchOn=");
    localStringBuilder.append(bool);
    QLog.d("RIJCommentAtUtil", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean a(@NonNull BaseCommentData paramBaseCommentData)
  {
    if (!a()) {
      return false;
    }
    paramBaseCommentData = paramBaseCommentData.commentRptDataList;
    if (paramBaseCommentData != null)
    {
      paramBaseCommentData = paramBaseCommentData.iterator();
      while (paramBaseCommentData.hasNext()) {
        if (((BaseCommentData.CommentRptData)paramBaseCommentData.next()).a == 1) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.at.RIJCommentAtUtil
 * JD-Core Version:    0.7.0.1
 */