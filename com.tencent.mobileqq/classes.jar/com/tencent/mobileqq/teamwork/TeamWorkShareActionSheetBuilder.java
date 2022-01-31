package com.tencent.mobileqq.teamwork;

import airm;
import airn;
import airo;
import airp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.AdViewManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamWorkShareActionSheetBuilder
  extends ShareActionSheetBuilder
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private SharePolicyInfo jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public TeamWorkShareActionSheetBuilder(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramContext);
      this.jdField_a_of_type_ComTencentSmttSdkWebView = ((QQBrowserActivity)paramContext).a();
    }
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b().a().a();
      paramView = (LinearLayout)paramView.findViewById(2131367706);
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_a_of_type_Boolean)) {
        break label250;
      }
      paramView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375304));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new airn(this));
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_c_of_type_Int == 1) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131439377));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131375300));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375304));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375302));
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_a_of_type_JavaLangString);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375303));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375301));
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.f)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.f, this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.jdField_d_of_type_Int);
    return;
    label250:
    paramView.setVisibility(8);
  }
  
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130971664, null);
    a(localView);
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder$AdViewManager.a((RelativeLayout)localView.findViewById(2131363838));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363839));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131363841));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131363843));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label382;
      }
      localObject1 = localObject2[0];
      label128:
      if (!((List)localObject1).isEmpty()) {
        break label899;
      }
    }
    label153:
    label342:
    label888:
    label891:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label894;
        }
      }
      label382:
      label894:
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558459));
        Object localObject4 = new StaticLayout(a(a((List)localObject1), 6), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        Object localObject5 = new StaticLayout(a(a((List)localObject2), 6), (TextPaint)localObject3, this.e, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject3 = localObject5;
        if (((StaticLayout)localObject4).getHeight() >= ((StaticLayout)localObject5).getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131559390);
        int i;
        if (j != 0)
        {
          localObject4 = (GridView)localView.findViewById(2131363842);
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject5 = ((List)localObject1).iterator();
          i = 0;
          if (((Iterator)localObject5).hasNext())
          {
            if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject5).next()).jdField_d_of_type_Int != 0) {
              break label891;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label342;
          e();
          break;
          localObject1 = new ArrayList(0);
          break label128;
          localObject2 = new ArrayList(0);
          break label153;
          int n = this.jdField_d_of_type_Int + a() + this.jdField_d_of_type_Int;
          ((GridView)localObject4).setColumnWidth(n);
          ((GridView)localObject4).setNumColumns(i);
          localObject5 = ((GridView)localObject4).getLayoutParams();
          ((GridView)localObject4).setPadding(this.h, ((GridView)localObject4).getPaddingTop(), this.h, ((GridView)localObject4).getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject5).width = (n * i + this.h + this.h);
          this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject5).width;
          ((ViewGroup.LayoutParams)localObject5).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
          ((GridView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
          ((GridView)localObject4).setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
          ((GridView)localObject4).setSelector(new ColorDrawable(0));
          ((GridView)localObject4).setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          if (k != 0)
          {
            localObject1 = (GridView)localView.findViewById(2131363844);
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            ((GridView)localObject1).setSmoothScrollbarEnabled(false);
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject4).hasNext())
            {
              if (((ShareActionSheetBuilder.ActionSheetItem)((Iterator)localObject4).next()).jdField_d_of_type_Int != 0) {
                break label888;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.jdField_d_of_type_Int + a() + this.jdField_d_of_type_Int;
            ((GridView)localObject1).setColumnWidth(n);
            ((GridView)localObject1).setNumColumns(i);
            localObject4 = ((GridView)localObject1).getLayoutParams();
            ((GridView)localObject1).setPadding(this.h, ((GridView)localObject1).getPaddingTop(), this.h, ((GridView)localObject1).getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.h + this.h);
            this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
            ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
            ((GridView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
            ((GridView)localObject1).setNumColumns(i);
            ((GridView)localObject1).setAdapter(new ShareActionSheetBuilder.ActionSheetItemAdapter(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
            ((GridView)localObject1).setSelector(new ColorDrawable(0));
            ((GridView)localObject1).setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
            localObject1 = (TextView)localView.findViewById(2131363845);
            ((TextView)localObject1).setText(2131433029);
            ((TextView)localObject1).setOnClickListener(new airo(this));
            if (j == 0) {
              this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            if (k == 0) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            localView.post(new airp(this));
            return localView;
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.g;
    if (paramInt == 0)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131439373));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new airm(this, paramString, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder
 * JD-Core Version:    0.7.0.1
 */