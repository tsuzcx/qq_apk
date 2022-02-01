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
    this.title = ((TextView)paramView.findViewById(2131438556));
    this.sequenceNumberTextView = ((TextView)paramView.findViewById(2131438555));
  }
  
  public void update(LiveInfo paramLiveInfo, int paramInt)
  {
    this.title.setText(paramLiveInfo.mHotWords);
    paramInt = paramLiveInfo.getPosition();
    this.sequenceNumberTextView.setText(String.valueOf(paramInt + 1));
    if (paramInt == 0)
    {
      this.sequenceNumberTextView.setBackgroundResource(2130841851);
      this.sequenceNumberTextView.setTextColor(-1);
    }
    else if (paramInt == 1)
    {
      this.sequenceNumberTextView.setBackgroundResource(2130841849);
      this.sequenceNumberTextView.setTextColor(-1);
    }
    else if (paramInt == 2)
    {
      this.sequenceNumberTextView.setBackgroundResource(2130841850);
      this.sequenceNumberTextView.setTextColor(-1);
    }
    else
    {
      this.sequenceNumberTextView.setBackgroundDrawable(null);
      this.sequenceNumberTextView.setPadding(ViewUtils.dpToPx(5.0F), 0, 0, 0);
      this.sequenceNumberTextView.setTextColor(this.itemView.getContext().getResources().getColor(2131168122));
    }
    String str5 = paramLiveInfo.mJumpUrl;
    String str4 = "";
    String str3 = str4;
    String str1 = str4;
    String str2;
    try
    {
      if (str5.startsWith("https://m.q.qq.com/a/p/"))
      {
        str3 = str4;
        str4 = str5.substring(23);
        str3 = str4;
        paramInt = str4.indexOf('?');
        str1 = str4;
        if (paramInt != -1)
        {
          str3 = str4;
          str1 = str4.substring(0, paramInt);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SearchRecommendAdapter", 1, "get appid from url err", localThrowable);
      str2 = str3;
    }
    this.itemView.setOnClickListener(new SearchRecommendAdapter.LiveViewHolder.1(this, paramLiveInfo, str2));
    paramLiveInfo = new MiniAppInfo();
    paramLiveInfo.appId = str2;
    paramLiveInfo = new MiniAppConfig(paramLiveInfo);
    paramLiveInfo.launchParam.scene = 3023;
    ((MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER)).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramLiveInfo, "desktop", "hot_expo"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.LiveViewHolder
 * JD-Core Version:    0.7.0.1
 */