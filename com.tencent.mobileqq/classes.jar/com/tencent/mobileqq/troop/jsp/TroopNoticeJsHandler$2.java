package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import bfhe;
import blrk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import java.util.ArrayList;
import snh;

public final class TroopNoticeJsHandler$2
  implements Runnable
{
  public TroopNoticeJsHandler$2(Activity paramActivity, int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, boolean[] paramArrayOfBoolean, PublicAccountShowPictureReport paramPublicAccountShowPictureReport, ArrayList paramArrayList3, ArrayList paramArrayList4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt2) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", this.jdField_a_of_type_Int);
    localBundle.putStringArrayList("seqNum", this.jdField_a_of_type_JavaUtilArrayList);
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      localBundle.putStringArrayList("descs", this.jdField_b_of_type_JavaUtilArrayList);
    }
    if (this.jdField_a_of_type_ArrayOfBoolean != null) {
      localBundle.putBooleanArray("likes", this.jdField_a_of_type_ArrayOfBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport != null) && (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport)) {
      localBundle.putString("PublicAccountShowPictureReport", this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.toString());
    }
    if (this.jdField_c_of_type_JavaUtilArrayList != null) {
      localBundle.putStringArrayList("origin_list", this.jdField_c_of_type_JavaUtilArrayList);
    }
    if (this.d != null) {
      localBundle.putStringArrayList("origin_size_list", this.d);
    }
    localBundle.putBoolean("needBottomBar", this.jdField_a_of_type_Boolean);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", this.jdField_b_of_type_Boolean);
    localBundle.putBoolean("is_need_to_aio", this.jdField_c_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      localBundle.putBoolean("is_grid_image_report", true);
      snh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "", this.jdField_a_of_type_Int, localBundle);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localBundle.putString("src_id", this.jdField_a_of_type_JavaLangString);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localBundle.putString("str_data_extra", this.jdField_b_of_type_JavaLangString);
    }
    localIntent.putExtras(localBundle);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > bfhe.a()))
    {
      blrk.a(localIntent, this.jdField_a_of_type_AndroidAppActivity);
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
      localIntent.putExtra("save_intent_to_file", true);
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, this.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2
 * JD-Core Version:    0.7.0.1
 */