package com.tencent.mobileqq.mini.entry.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager.MiniAppModuleExposureData;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.utils.ViewUtils;

class SearchRecommendAdapter$LiveViewHolder
  extends RecyclerView.ViewHolder
{
  private TextView sequenceNumberTextView;
  private TextView title;
  
  public SearchRecommendAdapter$LiveViewHolder(View paramView)
  {
    super(paramView);
    this.title = ((TextView)paramView.findViewById(2131371119));
    this.sequenceNumberTextView = ((TextView)paramView.findViewById(2131371118));
  }
  
  public void update(LiveInfo paramLiveInfo, int paramInt)
  {
    this.title.setText(paramLiveInfo.mHotWords);
    paramInt = paramLiveInfo.getPosition();
    this.sequenceNumberTextView.setText(String.valueOf(paramInt + 1));
    if (paramInt == 0)
    {
      this.sequenceNumberTextView.setBackgroundResource(2130841019);
      this.sequenceNumberTextView.setTextColor(-1);
    }
    for (;;)
    {
      String str2 = paramLiveInfo.mJumpUrl;
      String str1 = "";
      if ((!TextUtils.isEmpty(str2)) || (str2.length() > "https://m.q.qq.com/a/p/".length()))
      {
        str2 = str2.substring("https://m.q.qq.com/a/p/".length());
        paramInt = str2.indexOf('?');
        str1 = str2;
        if (paramInt != -1) {
          str1 = str2.substring(0, paramInt);
        }
      }
      this.itemView.setOnClickListener(new SearchRecommendAdapter.LiveViewHolder.1(this, paramLiveInfo, str1));
      paramLiveInfo = new MiniAppInfo();
      paramLiveInfo.appId = str1;
      paramLiveInfo = new MiniAppConfig(paramLiveInfo);
      paramLiveInfo.launchParam.scene = 3023;
      ((MiniAppExposureManager)MiniAppUtils.getAppInterface().getManager(322)).addSearchItemAndCheckReport(new MiniAppExposureManager.MiniAppModuleExposureData(paramLiveInfo, "desktop", "hot_expo"));
      return;
      if (paramInt == 1)
      {
        this.sequenceNumberTextView.setBackgroundResource(2130841017);
        this.sequenceNumberTextView.setTextColor(-1);
      }
      else if (paramInt == 2)
      {
        this.sequenceNumberTextView.setBackgroundResource(2130841018);
        this.sequenceNumberTextView.setTextColor(-1);
      }
      else
      {
        this.sequenceNumberTextView.setBackgroundDrawable(null);
        this.sequenceNumberTextView.setPadding(ViewUtils.dpToPx(5.0F), 0, 0, 0);
        this.sequenceNumberTextView.setTextColor(this.itemView.getContext().getResources().getColor(2131167096));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.SearchRecommendAdapter.LiveViewHolder
 * JD-Core Version:    0.7.0.1
 */