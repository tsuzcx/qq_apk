package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.filemanageraux.util.TencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil.DocClickTypeRunnable;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.List;

public class TencentDocConvertABTestUtilImpl
  implements ITencentDocConvertABTestUtil
{
  public int calcHeightLayoutParam(AppInterface paramAppInterface)
  {
    return TencentDocConvertABTestUtil.a(paramAppInterface);
  }
  
  public void configureABTest(AppInterface paramAppInterface, Activity paramActivity, View paramView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ITencentDocConvertABTestUtil.DocClickTypeRunnable paramDocClickTypeRunnable)
  {
    TencentDocConvertABTestUtil.a(paramAppInterface, paramActivity, paramView, paramTeamWorkFileImportInfo, paramDocClickTypeRunnable);
  }
  
  public List<TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem> getWordingConfig()
  {
    return TencentDocConvertABTestUtil.a();
  }
  
  public boolean hasConfig(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return TencentDocConvertABTestUtil.a(paramTeamWorkFileImportInfo);
  }
  
  public boolean hasConfig(String paramString)
  {
    return TencentDocConvertABTestUtil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.TencentDocConvertABTestUtilImpl
 * JD-Core Version:    0.7.0.1
 */