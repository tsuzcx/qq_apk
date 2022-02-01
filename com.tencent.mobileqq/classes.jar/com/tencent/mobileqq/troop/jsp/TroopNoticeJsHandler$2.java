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
    Intent localIntent = new Intent(this.a, TroopAvatarWallPreviewActivity.class);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("index", this.b);
    ((Bundle)localObject1).putStringArrayList("seqNum", this.c);
    Object localObject2 = this.d;
    if (localObject2 != null) {
      ((Bundle)localObject1).putStringArrayList("descs", (ArrayList)localObject2);
    }
    localObject2 = this.e;
    if (localObject2 != null) {
      ((Bundle)localObject1).putBooleanArray("likes", (boolean[])localObject2);
    }
    localObject2 = this.f;
    if ((localObject2 != null) && (((PublicAccountShowPictureReport)localObject2).isReport)) {
      ((Bundle)localObject1).putString("PublicAccountShowPictureReport", this.f.toString());
    }
    localObject2 = this.g;
    if (localObject2 != null) {
      ((Bundle)localObject1).putStringArrayList("origin_list", (ArrayList)localObject2);
    }
    localObject2 = this.h;
    if (localObject2 != null) {
      ((Bundle)localObject1).putStringArrayList("origin_size_list", (ArrayList)localObject2);
    }
    if (!TextUtils.isEmpty(this.i))
    {
      ((Bundle)localObject1).putString("dt_page_id", this.i);
      localObject2 = this.j;
      if (localObject2 != null) {
        ((Bundle)localObject1).putSerializable("dt_page_params", (Serializable)localObject2);
      }
    }
    ((Bundle)localObject1).putBoolean("needBottomBar", this.k);
    ((Bundle)localObject1).putBoolean("IS_EDIT", false);
    ((Bundle)localObject1).putBoolean("is_use_path", true);
    ((Bundle)localObject1).putBoolean("is_show_action", true);
    ((Bundle)localObject1).putBoolean("is_not_show_index", this.l);
    ((Bundle)localObject1).putBoolean("is_need_to_aio", this.m);
    if (this.n != null)
    {
      ((Bundle)localObject1).putBoolean("is_grid_image_report", true);
      ((IRIJFrameworkReportManager)QRoute.api(IRIJFrameworkReportManager.class)).makeGridImageReadArticleReport(this.n, "", this.b, (Bundle)localObject1);
    }
    if (!TextUtils.isEmpty(this.o)) {
      ((Bundle)localObject1).putString("src_id", this.o);
    }
    if (!TextUtils.isEmpty(this.p)) {
      ((Bundle)localObject1).putString("str_data_extra", this.p);
    }
    localIntent.putExtras((Bundle)localObject1);
    localObject1 = this.c;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > TroopNoticeJsHandler.a()))
    {
      LargeIntentManager.saveIntent(localIntent, this.a);
      localIntent = new Intent(this.a, TroopAvatarWallPreviewActivity.class);
      localIntent.putExtra("save_intent_to_file", true);
      this.a.startActivityForResult(localIntent, this.q);
      return;
    }
    this.a.startActivityForResult(localIntent, this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.2
 * JD-Core Version:    0.7.0.1
 */