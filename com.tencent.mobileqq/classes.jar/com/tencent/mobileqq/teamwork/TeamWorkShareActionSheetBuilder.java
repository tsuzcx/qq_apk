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
  private TextView A;
  private ImageView B;
  private WebView C;
  private SharePolicyInfo D;
  private QQBrowserActivity E;
  private RelativeLayout F;
  private TeamWorkFileImportInfo G;
  private TextView y;
  private TextView z;
  
  public TeamWorkShareActionSheetBuilder(Context paramContext)
  {
    super(paramContext, false, 2);
    setBottomBarInterface(this);
    if ((paramContext instanceof QQBrowserActivity))
    {
      paramContext = (QQBrowserActivity)paramContext;
      this.E = paramContext;
      this.C = paramContext.getHostWebView();
    }
    paramContext = new Intent();
    paramContext.putExtra("forward_type", -3);
    paramContext.putExtra("key_share_data_line_support_type", 1);
    setIntentForStartForwardRecentActivity(paramContext);
    setRowVisibility(0, 0, 0);
  }
  
  private View e()
  {
    Object localObject = this.E;
    if ((localObject != null) && (((QQBrowserActivity)localObject).getCurrentWebViewFragment() != null))
    {
      this.D = ((Share)this.E.getCurrentWebViewFragment().getShare()).a();
      localObject = (RelativeLayout)LayoutInflater.from(this.E).inflate(2131629383, null);
      SharePolicyInfo localSharePolicyInfo = this.D;
      if ((localSharePolicyInfo != null) && (localSharePolicyInfo.d))
      {
        ((RelativeLayout)localObject).setVisibility(0);
        this.y = ((TextView)((RelativeLayout)localObject).findViewById(2131448284));
        this.y.setOnClickListener(new TeamWorkShareActionSheetBuilder.2(this));
        if (this.D.h == 1) {
          this.y.setText(this.E.getText(2131887119));
        } else if (this.D.h == 2) {
          this.y.setText(this.E.getText(2131886318));
        }
        this.F = ((RelativeLayout)((RelativeLayout)localObject).findViewById(2131445216));
        this.y = ((TextView)((RelativeLayout)localObject).findViewById(2131448284));
        this.z = ((TextView)((RelativeLayout)localObject).findViewById(2131448282));
        this.z.setTextColor(Color.parseColor("#777777"));
        if (this.D.h == 2) {
          this.z.setTextColor(Color.parseColor("#fe6c6c"));
        }
        this.z.setText(this.D.a);
        this.A = ((TextView)((RelativeLayout)localObject).findViewById(2131448283));
        this.B = ((ImageView)((RelativeLayout)localObject).findViewById(2131436270));
        if (2 == this.D.h)
        {
          if (TextUtils.isEmpty(this.D.b))
          {
            this.A.setVisibility(8);
          }
          else
          {
            this.A.setVisibility(0);
            this.A.setText(this.D.b);
          }
        }
        else if (TextUtils.isEmpty(this.D.k))
        {
          this.A.setVisibility(8);
        }
        else
        {
          this.A.setVisibility(0);
          a(this.D.k, this.D.j);
        }
      }
      else
      {
        ((RelativeLayout)localObject).setVisibility(8);
      }
      ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, UIUtils.a(this.E, 70.0F)));
      return localObject;
    }
    return null;
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.G = paramTeamWorkFileImportInfo;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.D.l;
    if (paramInt == 0)
    {
      this.A.setText(this.E.getString(2131917077));
      return;
    }
    this.F.post(new TeamWorkShareActionSheetBuilder.1(this, paramString, str));
  }
  
  public View b()
  {
    return e();
  }
  
  public void setItemClickListenerV2(ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    super.setItemClickListenerV2(new TeamWorkShareActionSheetBuilder.InnerShareReportListener(this.E, this.C, this.G, paramOnItemClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */