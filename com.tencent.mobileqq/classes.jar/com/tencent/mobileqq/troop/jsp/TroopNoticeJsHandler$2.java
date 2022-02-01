package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import cooperation.qzone.LargeIntentManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

final class TroopNoticeJsHandler$2
  implements Runnable
{
  TroopNoticeJsHandler$2(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean[] paramArrayOfBoolean, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArrayList paramArrayList3, ArrayList paramArrayList4, String paramString1, HashMap paramHashMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString2, String paramString3, int paramInt2) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("index", this.jdField_a_of_type_Int);
    ((Bundle)localObject1).putStringArrayList("seqNum", this.jdField_a_of_type_JavaUtilArrayList);
    Object localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
    if (localObject2 != null) {
      ((Bundle)localObject1).putStringArrayList("descs", (ArrayList)localObject2);
    }
    localObject2 = this.jdField_a_of_type_ArrayOfBoolean;
    if (localObject2 != null) {
      ((Bundle)localObject1).putBooleanArray("likes", (boolean[])localObject2);
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport;
    if ((localObject2 != null) && (((PublicAccountShowPictureReport)localObject2).isReport)) {
      ((Bundle)localObject1).putString("PublicAccountShowPictureReport", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.toString());
    }
    localObject2 = this.jdField_c_of_type_JavaUtilArrayList;
    if (localObject2 != null) {
      ((Bundle)localObject1).putStringArrayList("origin_list", (ArrayList)localObject2);
    }
    localObject2 = this.d;
    if (localObject2 != null) {
      ((Bundle)localObject1).putStringArrayList("origin_size_list", (ArrayList)localObject2);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      ((Bundle)localObject1).putString("dt_page_id", this.jdField_a_of_type_JavaLangString);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (localObject2 != null) {
        ((Bundle)localObject1).putSerializable("dt_page_params", (Serializable)localObject2);
      }
    }
    ((Bundle)localObject1).putBoolean("needBottomBar", this.jdField_a_of_type_Boolean);
    ((Bundle)localObject1).putBoolean("IS_EDIT", false);
    ((Bundle)localObject1).putBoolean("is_use_path", true);
    ((Bundle)localObject1).putBoolean("is_show_action", true);
    ((Bundle)localObject1).putBoolean("is_not_show_index", this.jdField_b_of_type_Boolean);
    ((Bundle)localObject1).putBoolean("is_need_to_aio", this.jdField_c_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
    {
      ((Bundle)localObject1).putBoolean("is_grid_image_report", true);
      ((IRIJFrameworkReportManager)QRoute.api(IRIJFrameworkReportManager.class)).makeGridImageReadArticleReport(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "", this.jdField_a_of_type_Int, (Bundle)localObject1);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      ((Bundle)localObject1).putString("src_id", this.jdField_b_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      ((Bundle)localObject1).putString("str_data_extra", this.jdField_c_of_type_JavaLangString);
    }
    localIntent.putExtras((Bundle)localObject1);
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > TroopNoticeJsHandler.a()))
    {
      LargeIntentManager.saveIntent(localIntent, this.jdField_a_of_type_AndroidAppActivity);
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
      localIntent.putExtra("save_intent_to_file", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2
 * JD-Core Version:    0.7.0.1
 */