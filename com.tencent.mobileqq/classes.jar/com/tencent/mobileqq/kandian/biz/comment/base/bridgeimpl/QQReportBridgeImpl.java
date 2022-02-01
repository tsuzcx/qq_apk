package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.comment.base.model.CommentArgumentModel;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.emotion.util.RIJEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.entity.SimpleCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQReportBridgeImpl
  implements QQReportBridge
{
  private final CommentArgumentModel a;
  
  public QQReportBridgeImpl(CommentArgumentModel paramCommentArgumentModel)
  {
    this.a = paramCommentArgumentModel;
  }
  
  public void asyncReport(Bundle paramBundle)
  {
    ThreadManager.getSubThreadHandler().post(new QQReportBridgeImpl.1(this, paramBundle));
  }
  
  public void fillR5OnDeliver(JSONObject paramJSONObject, Editable paramEditable)
  {
    RIJEmotionUtil.a(paramEditable, paramJSONObject);
  }
  
  public int getCommentLevel()
  {
    if ((!this.a.e) && (!(this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData instanceof SubCommentCreateData)))
    {
      if ((TextUtils.isEmpty(this.a.c)) && (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData == null)) {
        return 0;
      }
      return 1;
    }
    return 2;
  }
  
  public long getConsumeTime()
  {
    return TimeSliceHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID, false) / 1000L;
  }
  
  public int getEntry()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData != null) {
      return this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.d();
    }
    ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    if (localReadInJoyCommentDataManager != null) {
      return localReadInJoyCommentDataManager.a();
    }
    return 0;
  }
  
  public int getFolderStatus()
  {
    return RIJKanDianFolderStatus.reportFolderStatus;
  }
  
  public String getReportVersion()
  {
    return VideoReporter.a;
  }
  
  public int getScene()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData != null) {
      return this.a.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntitySimpleCommentData.b();
    }
    return 0;
  }
  
  public void report(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("toUin");
    String str2 = paramBundle.getString("subAction");
    String str3 = paramBundle.getString("actionName");
    int i = paramBundle.getInt("fromType", 0);
    int j = paramBundle.getInt("result", 0);
    String str4 = paramBundle.getString("r2", "");
    String str5 = paramBundle.getString("r3", "");
    String str6 = paramBundle.getString("r4", "");
    String str7 = paramBundle.getString("r5", "");
    boolean bool = paramBundle.getBoolean("shouldEncode", false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, str1, str2, str3, i, j, str4, str5, str6, str7, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQReportBridgeImpl
 * JD-Core Version:    0.7.0.1
 */