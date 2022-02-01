package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

class SearchRecommendAdapter$LiveViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView sequenceNumberTextView;
  private TextView title;
  
  public SearchRecommendAdapter$LiveViewHolder(View paramView)
  {
    super(paramView);
    this.title = ((TextView)paramView.findViewById(2131371314));
    this.sequenceNumberTextView = ((TextView)paramView.findViewById(2131371313));
  }
  
  public void update(LiveInfo paramLiveInfo, int paramInt)
  {
    this.title.setText(paramLiveInfo.mHotWords);
    paramInt = paramLiveInfo.getPosition();
    this.sequenceNumberTextView.setText(String.valueOf(paramInt + 1));
    if (paramInt == 0)
    {
      this.sequenceNumberTextView.setBackgroundResource(2130841051);
      this.sequenceNumberTextView.setTextColor(-1);
    }
    for (;;)
    {
      String str4 = paramLiveInfo.mJumpUrl;
      String str3 = "";
      String str1 = str3;
      str2 = str3;
      try
      {
        if (str4.startsWith("https://m.q.qq.com/a/p/"))
        {
          str2 = str3;
          str3 = str4.substring("https://m.q.qq.com/a/p/".length());
          str2 = str3;
          paramInt = str3.indexOf('?');
          str1 = str3;
          if (paramInt != -1)
          {
            str2 = str3;
            str1 = str3.substring(0, paramInt);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("SearchRecommendAdapter", 1, "get appid from url err", localThrowable);
          Object localObject = str2;
        }
      }
      this.itemView.setOnClickListener(new SearchRecommendAdapter.LiveViewHolder.1(this, paramLiveInfo, str1));
      paramLiveInfo = new MiniAppInfo();
      paramLiveInfo.appId = str1;
      paramLiveInfo = new MiniAppConfig(paramLiveInfo);
      paramLiveInfo.launchParam.scene = 3023;
      ((MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramLiveInfo, "desktop", "hot_expo"));
      return;
      if (paramInt == 1)
      {
        this.sequenceNumberTextView.setBackgroundResource(2130841049);
        this.sequenceNumberTextView.setTextColor(-1);
      }
      else if (paramInt == 2)
      {
        this.sequenceNumberTextView.setBackgroundResource(2130841050);
        this.sequenceNumberTextView.setTextColor(-1);
      }
      else
      {
        this.sequenceNumberTextView.setBackgroundDrawable(null);
        this.sequenceNumberTextView.setPadding(ViewUtils.dpToPx(5.0F), 0, 0, 0);
        this.sequenceNumberTextView.setTextColor(this.itemView.getContext().getResources().getColor(2131167110));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.LiveViewHolder
 * JD-Core Version:    0.7.0.1
 */