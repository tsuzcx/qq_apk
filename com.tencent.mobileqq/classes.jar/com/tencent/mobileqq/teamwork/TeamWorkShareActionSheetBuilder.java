package com.tencent.mobileqq.teamwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.share.ShareActionSheet.IShareActionSheetV2BottomBar;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.smtt.sdk.WebView;

public class TeamWorkShareActionSheetBuilder
  extends ShareActionSheetBuilder
  implements ShareActionSheet.IShareActionSheetV2BottomBar
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private SharePolicyInfo jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public TeamWorkShareActionSheetBuilder(Context paramContext)
  {
    super(paramContext, false, 2);
    setBottomBarInterface(this);
    if ((paramContext instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramContext);
      this.jdField_a_of_type_ComTencentSmttSdkWebView = ((QQBrowserActivity)paramContext).getHostWebView();
    }
    paramContext = new Intent();
    paramContext.putExtra("forward_type", -3);
    paramContext.putExtra("key_share_data_line_support_type", 1);
    setIntentForStartForwardRecentActivity(paramContext);
    setRowVisibility(0, 0, 0);
  }
  
  private View c()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getCurrentWebViewFragment() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getCurrentWebViewFragment().getShare().a();
        localObject1 = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2131563097, null);
        if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_a_of_type_Boolean)) {
          break label413;
        }
        ((RelativeLayout)localObject1).setVisibility(0);
        this.c = ((TextView)((RelativeLayout)localObject1).findViewById(2131380216));
        this.c.setOnClickListener(new TeamWorkShareActionSheetBuilder.2(this));
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c != 1) {
          break label304;
        }
        this.c.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131690301));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject1).findViewById(2131377432));
        this.c = ((TextView)((RelativeLayout)localObject1).findViewById(2131380216));
        this.d = ((TextView)((RelativeLayout)localObject1).findViewById(2131380214));
        this.d.setTextColor(Color.parseColor("#777777"));
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c == 2) {
          this.d.setTextColor(Color.parseColor("#fe6c6c"));
        }
        this.d.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_a_of_type_JavaLangString);
        this.e = ((TextView)((RelativeLayout)localObject1).findViewById(2131380215));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RelativeLayout)localObject1).findViewById(2131369575));
        if (2 != this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c) {
          break label359;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.b)) {
          break label334;
        }
        this.e.setVisibility(8);
      }
    }
    label413:
    for (;;)
    {
      ((RelativeLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 70.0F)));
      return localObject1;
      label304:
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c != 2) {
        break;
      }
      this.c.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131689674));
      break;
      label334:
      this.e.setVisibility(0);
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.b);
      continue;
      label359:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.f))
      {
        this.e.setVisibility(8);
      }
      else
      {
        this.e.setVisibility(0);
        a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.f, this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.d);
        continue;
        ((RelativeLayout)localObject1).setVisibility(8);
      }
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.g;
    if (paramInt == 0)
    {
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131719790));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new TeamWorkShareActionSheetBuilder.1(this, paramString, str));
  }
  
  public View b()
  {
    return c();
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    super.setItemClickListenerV2(new TeamWorkShareActionSheetBuilder.InnerShareReportListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, paramOnItemClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */