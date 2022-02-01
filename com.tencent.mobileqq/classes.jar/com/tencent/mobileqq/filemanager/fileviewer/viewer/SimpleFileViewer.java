package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.widget.DocCollectFormBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocCooperationBanner;
import com.tencent.mobileqq.filemanageraux.widget.DocQBBottomView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.reader.TbsReaderView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class SimpleFileViewer
  extends FileBrowserViewBase
{
  AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  public DocCollectFormBanner a;
  public DocCooperationBanner a;
  private DocQBBottomView jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private TbsReaderView jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
  private boolean jdField_a_of_type_Boolean = false;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private View c;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
  public SimpleFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
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
    ((ActionSheet)localObject2).setOnButtonClickListener(new SimpleFileViewer.7(this, paramQQAppInterface, paramTeamWorkFileImportInfo, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
  }
  
  private boolean a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramView1 == null)
    {
      this.jdField_d_of_type_AndroidViewView = paramView2;
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) && (paramView2 != null))
      {
        if (paramView2.getParent() != null) {
          ((ViewGroup)paramView2.getParent()).removeAllViews();
        }
        if (paramBoolean) {
          paramView1 = new SimpleFileViewer.GestureRelativeLayout(this, this.jdField_a_of_type_AndroidAppActivity);
        } else {
          paramView1 = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramView1;
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramView2, 0, paramView1);
        return true;
      }
    }
    else if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (paramView1 != null) && (paramView2 != null) && (paramView1.hashCode() != paramView2.hashCode()))
    {
      int k = this.jdField_b_of_type_AndroidWidgetRelativeLayout.indexOfChild(paramView1);
      if (k >= 0)
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(paramView1);
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramView2, k, paramView1);
        this.jdField_d_of_type_AndroidViewView = paramView2;
        return true;
      }
    }
    return false;
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
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public View a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView = new DocQBBottomView(this.jdField_a_of_type_AndroidAppActivity, new SimpleFileViewer.2(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.setTeamWorkFileImportInfo(paramTeamWorkFileImportInfo);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560835, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView;
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366798));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364278));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366792));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366789));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372125));
      this.i = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361946));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TbsReaderView localTbsReaderView = this.jdField_a_of_type_ComTencentTbsReaderTbsReaderView;
    if (localTbsReaderView != null) {
      localTbsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramSpannableString);
    this.jdField_d_of_type_AndroidWidgetTextView.setHighlightColor(17170445);
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    paramTeamWorkFileImportInfo.d = 3;
    ThreadManager.getUIHandler().post(new SimpleFileViewer.3(this, paramTeamWorkFileImportInfo));
  }
  
  public void a(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.5(this, paramString, paramLocalTbsViewManagerCallback));
  }
  
  public void a(String paramString, Object paramObject)
  {
    DocQBBottomView localDocQBBottomView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramString, paramObject);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.g == null) {
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364730));
    }
    TextView localTextView = this.g;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localTextView.setVisibility(k);
    this.g.setText(paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.h == null) {
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376880));
    }
    TextView localTextView = this.h;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localTextView.setVisibility(k);
    this.h.setText(paramString);
    if (paramInt != 0) {
      this.h.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(paramInt));
    }
    this.h.setOnClickListener(paramOnClickListener);
  }
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_d_of_type_AndroidViewView != null))
    {
      View localView = this.jdField_e_of_type_AndroidViewView;
      if ((localView != null) && (localView.getVisibility() == 0) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public View b()
  {
    return this.jdField_e_of_type_AndroidViewView;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (this.j == null) {
      this.j = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367884));
    }
    this.j.setVisibility(0);
    this.j.setOnClickListener(paramOnClickListener);
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.i;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.i.setOnClickListener(paramOnClickListener);
      d(true);
    }
  }
  
  public void b(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.6(this, paramString, paramLocalTbsViewManagerCallback));
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean) {
      d(false);
    }
  }
  
  public void c()
  {
    View localView = this.jdField_e_of_type_AndroidViewView;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText())))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setImageResource(paramInt);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_e_of_type_AndroidWidgetTextView.getMeasuredWidth() <= 0)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.post(new SimpleFileViewer.1(this, paramString));
      return;
    }
    TextView localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
    localTextView.setText(FileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.jdField_e_of_type_AndroidWidgetTextView.getPaint(), 2));
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.i != null)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      int k = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0))
        {
          this.i.setVisibility(0);
          return;
        }
        this.i.setVisibility(8);
        return;
      }
      localObject = this.i;
      if (!paramBoolean) {
        k = 8;
      }
      ((TextView)localObject).setVisibility(k);
    }
  }
  
  public void e()
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
  
  public void e(int paramInt)
  {
    DocQBBottomView localDocQBBottomView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxWidgetDocQBBottomView;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramInt);
    }
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setApkIconAsyncImage(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localTextView.setVisibility(k);
  }
  
  public void f(int paramInt)
  {
    View localView = this.jdField_f_of_type_AndroidViewView;
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
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void g(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView = this.j;
    if (localTextView != null)
    {
      int k;
      if (paramBoolean) {
        k = 0;
      } else {
        k = 8;
      }
      localTextView.setVisibility(k);
    }
  }
  
  public void h(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer
 * JD-Core Version:    0.7.0.1
 */