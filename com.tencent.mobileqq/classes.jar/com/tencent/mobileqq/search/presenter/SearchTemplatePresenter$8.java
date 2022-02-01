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
    Object localObject1 = this.a.c;
    ((ImageView)localObject1).setTag(Integer.valueOf(this.b));
    SearchTemplatePresenter.a(this.g, new WeakReference(localObject1));
    int j = QQPlayerService.c();
    int i = 0;
    if ((j == 2) && (SearchTemplatePresenter.a(this.g) == SearchUtils.c))
    {
      QQPlayerService.e(this.c);
      SearchUtils.c = -1L;
      ((ImageView)localObject1).clearAnimation();
      if (this.d) {
        ((ImageView)localObject1).setImageResource(2130851719);
      } else {
        ((ImageView)localObject1).setImageResource(2130851718);
      }
    }
    else
    {
      if (SearchTemplatePresenter.b(this.g)) {
        break label531;
      }
      localObject1 = new Intent(this.c, MusicPlayerActivity.class);
      ((Intent)localObject1).putExtra("url", this.e.d);
      ((Intent)localObject1).putExtra("param_force_internal_browser", true);
      QQPlayerService.a((Intent)localObject1);
      if (QQPlayerService.n() == null) {
        QQPlayerService.a(new Bundle());
      }
      QQPlayerService.a(this.g);
      QQPlayerService.b(101);
      QQPlayerService.a(this.c, QQPlayerService.o(), new SongInfo[] { this.e });
      i = 1;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (SearchUtils.l.containsKey(this.f))
    {
      localObject1 = (SearchUtils.ObjectItemInfo)SearchUtils.l.get(this.f);
      Object localObject3 = new JSONObject();
      try
      {
        ((JSONObject)localObject3).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject3).put("event_src", "client");
        ((JSONObject)localObject3).put("obj_lct", ((SearchUtils.ObjectItemInfo)localObject1).c);
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
      if ((this.c instanceof UniteSearchActivity)) {
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
      ((StringBuilder)localObject4).append(this.f.i);
      ((StringBuilder)localObject4).append("");
      localObject2 = ((ReportModelDC02528)localObject2).obj1(((StringBuilder)localObject4).toString()).obj2(this.f.h).ver1(UniteSearchActivity.g).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(((JSONObject)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject3).append(SearchUtils.j);
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject2).session_id(((StringBuilder)localObject3).toString()));
    }
    label531:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.8
 * JD-Core Version:    0.7.0.1
 */