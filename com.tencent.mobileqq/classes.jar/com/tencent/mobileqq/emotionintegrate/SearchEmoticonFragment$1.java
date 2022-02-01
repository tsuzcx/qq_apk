package com.tencent.mobileqq.emotionintegrate;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

class SearchEmoticonFragment$1
  implements View.OnTouchListener
{
  SearchEmoticonFragment$1(SearchEmoticonFragment paramSearchEmoticonFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.a.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      if (SearchEmoticonFragment.a(this.a).d == 1)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage(this.a.getBaseActivity(), this.a.a().getAccount(), 8, SearchEmoticonFragment.a(this.a).e, false, false);
        ReportController.b(null, "dc00898", "", "", "0X8009EAF", "0X8009EAF", 0, 0, "", "", "", "");
      }
      else if (SearchEmoticonFragment.a(this.a).d == 2)
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(SearchEmoticonFragment.a(this.a), SearchEmoticonFragment.a(this.a).g, null, null, null, null, 1005, null);
        ReportController.b(null, "dc00898", "", "", "0X8009EB1", "0X8009EB1", 0, 0, "", "", "", "");
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      this.a.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
      ReportController.b(null, "dc00898", "", "", "0X8009EAE", "0X8009EAE", 0, 0, "", "", "", "");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment.1
 * JD-Core Version:    0.7.0.1
 */