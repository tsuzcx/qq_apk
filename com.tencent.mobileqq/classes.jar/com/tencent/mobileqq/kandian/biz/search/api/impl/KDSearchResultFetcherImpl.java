package com.tencent.mobileqq.kandian.biz.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.kandian.biz.search.api.IKDSearchResultFetcher;
import com.tencent.mobileqq.kandian.biz.search.searchresult.KDSearchResultFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class KDSearchResultFetcherImpl
  implements IKDSearchResultFetcher
{
  public void jumpToNativeSearchResultPage(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.contains("searchbox=$SEARCHBOX$")) {
        paramString2 = paramString2.replace("$SEARCHBOX$", "native");
      } else {
        paramString2 = URLUtil.a(paramString2, "searchbox", "native");
      }
      paramString1 = KDSearchResultFragment.a(paramContext, paramString1, SearchUtils.e(paramString2));
      paramString2 = Aladdin.getConfig(313);
      if (paramString2 != null) {
        paramString1.putExtra("searchbox_style", paramString2.getIntegerFromString("SearchBox_SearchStyle", -1));
      }
      paramString2 = Aladdin.getConfig(337);
      if (paramString2 != null)
      {
        int i = paramString2.getIntegerFromString("search_ajax_switch", 0);
        paramString2 = paramString2.getString("url_prefix", "https://so.html5.qq.com/page/real").replaceAll("\\s*", "").split(",");
        paramString1.putExtra("search_ajax_switch", i);
        paramString1.putExtra("url_prefix", paramString2);
      }
      PublicFragmentActivityForTool.b(paramContext, paramString1, KDSearchResultFragment.class);
      ((Activity)paramContext).overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.SearchUtils", 2, "argument is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.api.impl.KDSearchResultFetcherImpl
 * JD-Core Version:    0.7.0.1
 */