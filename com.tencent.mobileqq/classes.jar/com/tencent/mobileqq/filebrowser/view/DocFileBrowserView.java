package com.tencent.mobileqq.filebrowser.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class DocFileBrowserView
  extends SimpleFileBrowserView
{
  public DocCollectFormBanner a;
  public DocCooperationBanner a;
  private DocQBBottomView jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View d;
  
  public DocFileBrowserView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    Object localObject = (LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater");
    if (localObject == null) {
      return null;
    }
    localObject = ((LayoutInflater)localObject).inflate(2131560826, paramViewGroup, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).calcHeightLayoutParam((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)));
    localLayoutParams.addRule(12);
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  private void a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691875);
    String str2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691868);
    Object localObject3 = ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).getWordingConfig();
    Object localObject1 = localObject2;
    String str1 = str2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (((List)localObject3).size() == 2)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          localObject3 = ((List)localObject3).iterator();
          for (;;)
          {
            localObject1 = localObject2;
            str1 = str2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)((Iterator)localObject3).next();
            if ((((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).a() == 0) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).b())) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).c())))
            {
              localObject2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).b();
              str2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).c();
            }
          }
        }
        localObject3 = ((List)localObject3).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          str1 = str2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)((Iterator)localObject3).next();
          if ((((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).a() == 1) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).b())) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).c())))
          {
            localObject2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).b();
            str2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).c();
          }
        }
      }
    }
    localObject2 = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    ((ActionSheet)localObject2).setMainTitle((CharSequence)localObject1);
    ((ActionSheet)localObject2).addButton(str1, 5);
    ((ActionSheet)localObject2).addCancelButton(2131690728);
    ((ActionSheet)localObject2).setOnButtonClickListener(new DocFileBrowserView.2(this, paramAppInterface, paramTeamWorkFileImportInfo, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
  }
  
  private boolean a(View paramView1, View paramView2)
  {
    int i = 0;
    if (paramView2 == null) {
      return false;
    }
    if ((paramView1 != null) && (paramView1.hashCode() == paramView2.hashCode())) {
      return false;
    }
    if (paramView2.getParent() != null) {
      ((ViewGroup)paramView2.getParent()).removeAllViews();
    }
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout == null)
    {
      if ((!jdField_a_of_type_Boolean) && (paramView1 != null)) {
        throw new AssertionError();
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new DocFileBrowserView.GestureRelativeLayout(this, this.jdField_a_of_type_AndroidAppActivity);
    }
    else
    {
      if (paramView1 == null) {
        return false;
      }
      i = localRelativeLayout.indexOfChild(paramView1);
      if (i < 0) {
        return false;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(paramView1);
    }
    paramView1 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramView2, i, paramView1);
    return true;
  }
  
  private void f()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent();
    if ((localViewGroup != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, localLayoutParams);
    }
  }
  
  public View a()
  {
    return this.c;
  }
  
  public View a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView = new DocQBBottomView(this.jdField_a_of_type_AndroidAppActivity, new DocFileBrowserView.6(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.setTeamWorkFileImportInfo(paramTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new DocFileBrowserView.1(this));
  }
  
  public void a(int paramInt)
  {
    View localView = this.d;
    if (localView != null)
    {
      if (paramInt > 0) {
        paramInt = 0;
      } else {
        paramInt = 4;
      }
      localView.setVisibility(paramInt);
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    paramTeamWorkFileImportInfo.d = 3;
    ThreadManager.getUIHandler().post(new DocFileBrowserView.5(this, paramTeamWorkFileImportInfo));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public void a(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManager.getUIHandler().post(new DocFileBrowserView.3(this, paramString, paramLocalTbsViewManagerCallback));
  }
  
  public void a(String paramString, Object paramObject)
  {
    DocQBBottomView localDocQBBottomView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramString, paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    return (localRelativeLayout != null) && (this.c != null) && (localRelativeLayout.getVisibility() == 0) && (this.c.getVisibility() == 0);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    if (localObject != null) {
      ((TbsReaderView)localObject).onStop();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
    if (localObject != null) {
      ((DocQBBottomView)localObject).a();
    }
  }
  
  public void b(int paramInt)
  {
    DocQBBottomView localDocQBBottomView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramInt);
    }
  }
  
  public void b(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManager.getUIHandler().post(new DocFileBrowserView.4(this, paramString, paramLocalTbsViewManagerCallback));
  }
  
  public void c()
  {
    View localView = this.c;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView
 * JD-Core Version:    0.7.0.1
 */