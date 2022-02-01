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
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
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
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
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
      paramContext = (QQBrowserActivity)paramContext;
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = paramContext;
      this.jdField_a_of_type_ComTencentSmttSdkWebView = paramContext.getHostWebView();
    }
    paramContext = new Intent();
    paramContext.putExtra("forward_type", -3);
    paramContext.putExtra("key_share_data_line_support_type", 1);
    setIntentForStartForwardRecentActivity(paramContext);
    setRowVisibility(0, 0, 0);
  }
  
  private View c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
    if ((localObject != null) && (((QQBrowserActivity)localObject).getCurrentWebViewFragment() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = ((Share)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getCurrentWebViewFragment().getShare()).a();
      localObject = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity).inflate(2131562923, null);
      SharePolicyInfo localSharePolicyInfo = this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
      if ((localSharePolicyInfo != null) && (localSharePolicyInfo.jdField_a_of_type_Boolean))
      {
        ((RelativeLayout)localObject).setVisibility(0);
        this.c = ((TextView)((RelativeLayout)localObject).findViewById(2131379533));
        this.c.setOnClickListener(new TeamWorkShareActionSheetBuilder.2(this));
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c == 1) {
          this.c.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131690219));
        } else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c == 2) {
          this.c.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131689706));
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131376876));
        this.c = ((TextView)((RelativeLayout)localObject).findViewById(2131379533));
        this.d = ((TextView)((RelativeLayout)localObject).findViewById(2131379531));
        this.d.setTextColor(Color.parseColor("#777777"));
        if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c == 2) {
          this.d.setTextColor(Color.parseColor("#fe6c6c"));
        }
        this.d.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_a_of_type_JavaLangString);
        this.e = ((TextView)((RelativeLayout)localObject).findViewById(2131379532));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((RelativeLayout)localObject).findViewById(2131369285));
        if (2 == this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.c)
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.b))
          {
            this.e.setVisibility(8);
          }
          else
          {
            this.e.setVisibility(0);
            this.e.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.b);
          }
        }
        else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.f))
        {
          this.e.setVisibility(8);
        }
        else
        {
          this.e.setVisibility(0);
          a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.f, this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.d);
        }
      }
      else
      {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 70.0F)));
      return localObject;
    }
    return null;
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.g;
    if (paramInt == 0)
    {
      this.e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131719514));
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
    super.setItemClickListenerV2(new TeamWorkShareActionSheetBuilder.InnerShareReportListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, paramOnItemClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */