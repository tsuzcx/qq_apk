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
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.NetSearchTemplateUniversalView;
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
    int i = 1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchViewNetSearchTemplateUniversalView.a;
    ((ImageView)localObject).setTag(Integer.valueOf(this.jdField_a_of_type_Int));
    SearchTemplatePresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter, new WeakReference(localObject));
    if ((QQPlayerService.a() == 2) && (SearchTemplatePresenter.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter) == SearchUtils.a))
    {
      QQPlayerService.c(this.jdField_a_of_type_AndroidContentContext);
      SearchUtils.a = -1L;
      ((ImageView)localObject).clearAnimation();
      if (this.jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject).setImageResource(2130850036);
        i = 0;
      }
    }
    for (;;)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      JSONObject localJSONObject;
      if (SearchUtil.b.containsKey(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem))
      {
        localObject = (SearchUtil.ObjectItemInfo)SearchUtil.b.get(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem);
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("project", UniteSearchReportController.a());
        localJSONObject.put("event_src", "client");
        localJSONObject.put("obj_lct", ((SearchUtil.ObjectItemInfo)localObject).jdField_a_of_type_Int);
        localJSONObject.put("get_src", "web");
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528();
        if ((this.jdField_a_of_type_AndroidContentContext instanceof UniteSearchActivity))
        {
          localObject = "all_result";
          localReportModelDC02528 = localReportModelDC02528.module((String)localObject);
          if (i == 0) {
            break label504;
          }
          localObject = "play_music";
          UniteSearchReportController.a(null, localReportModelDC02528.action((String)localObject).obj1(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem.a + "").obj2(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateUniversalItem.d).ver1(UniteSearchActivity.b).ver2(UniteSearchReportController.a(UniteSearchActivity.d)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.a));
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            ((ImageView)localObject).setImageResource(2130850035);
            i = 0;
            break;
            localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject == null) || (!((QQAppInterface)localObject).isVideoChatting())) {
              break label372;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QQPlayerService", 2, "Video Chatting is going on, don't play music.");
            }
          }
          label372:
          localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, MusicPlayerActivity.class);
          ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo.b);
          ((Intent)localObject).putExtra("param_force_internal_browser", true);
          QQPlayerService.a((Intent)localObject);
          if (QQPlayerService.a() == null) {
            QQPlayerService.a(new Bundle());
          }
          QQPlayerService.a(this.jdField_a_of_type_ComTencentMobileqqSearchPresenterSearchTemplatePresenter);
          QQPlayerService.a(101);
          QQPlayerService.a(this.jdField_a_of_type_AndroidContentContext, QQPlayerService.a(), new SongInfo[] { this.jdField_a_of_type_ComTencentMobileqqMusicSongInfo });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchTemplatePresenter", 2, "e = " + localJSONException);
          continue;
          String str = "subweb_search";
          continue;
          label504:
          str = "pause_music";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.8
 * JD-Core Version:    0.7.0.1
 */