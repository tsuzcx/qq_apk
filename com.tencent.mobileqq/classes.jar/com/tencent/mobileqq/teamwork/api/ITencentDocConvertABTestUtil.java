package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.List;

@QAPI(process={"all"})
public abstract interface ITencentDocConvertABTestUtil
  extends QRouteApi
{
  public abstract int calcHeightLayoutParam(AppInterface paramAppInterface);
  
  public abstract void configureABTest(AppInterface paramAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable);
  
  public abstract List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> getWordingConfig();
  
  public abstract boolean hasConfig(TeamWorkFileImportInfo paramTeamWorkFileImportInfo);
  
  public abstract boolean hasConfig(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil
 * JD-Core Version:    0.7.0.1
 */