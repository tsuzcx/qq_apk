package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUniversalView;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class SearchTemplatePresenter$8
  implements View.OnClickListener
{
  SearchTemplatePresenter$8(SearchTemplatePresenter paramSearchTemplatePresenter, NetSearchTemplateUniversalView paramNetSearchTemplateUniversalView, int paramInt, Context paramContext, boolean paramBoolean, SongInfo paramSongInfo, NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetViewNetSearchTemplateUniversalView.c;
    ((ImageView)localObject1).setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    SearchTemplatePresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter, new WeakReference(localObject1));
    int j = QQPlayerService.a();
    int i = 0;
    if ((j == 2) && (SearchTemplatePresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter) == SearchUtils.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      SearchUtils.a = -1L;
      ((ImageView)localObject1).clearAnimation();
      if (this.jdField_a_of_type_Boolean) {
        ((ImageView)localObject1).setImageResource(2130849963);
      } else {
        ((ImageView)localObject1).setImageResource(2130849962);
      }
    }
    else
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 != null) && (((QQAppInterface)localObject1).isVideoChatting()))
      {
        if (!QLog.isColorLevel()) {
          break label559;
        }
        QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
        break label559;
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicPlayerActivity.class);
      ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b);
      ((Intent)localObject1).putExtra("param_force_internal_browser", true);
      QQPlayerService.a((Intent)localObject1);
      if (QQPlayerService.a() == null) {
        QQPlayerService.a(new Bundle());
      }
      QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter);
      QQPlayerService.a(101);
      QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(), new SongInfo[] { this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo });
      i = 1;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (SearchUtils.b.containsKey(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem))
    {
      localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.b.get(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem);
      Object localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject1).jdField_a_of_type_Int);
        ((JSONObject)localObject3).put("get_src", "web");
      }
      catch (JSONException localJSONException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("e = ");
        ((StringBuilder)localObject4).append(localJSONException);
        QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, ((StringBuilder)localObject4).toString());
      }
      Object localObject4 = new ReportModelDC02528();
      if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity)) {
        localObject2 = "all_result";
      } else {
        localObject2 = "subweb_search";
      }
      localObject4 = ((ReportModelDC02528)localObject4).module((String)localObject2);
      if (i != 0) {
        localObject2 = "play_music";
      } else {
        localObject2 = "pause_music";
      }
      Object localObject2 = ((ReportModelDC02528)localObject4).action((String)localObject2);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem.a);
      ((StringBuilder)localObject4).append("");
      localObject2 = ((ReportModelDC02528)localObject2).obj1(((StringBuilder)localObject4).toString()).obj2(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateUniversalItem.d).ver1(UniteSearchActivity.b).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(((JSONObject)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject3).append(SearchUtils.d);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject3).toString()));
    }
    label559:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.8
 * JD-Core Version:    0.7.0.1
 */