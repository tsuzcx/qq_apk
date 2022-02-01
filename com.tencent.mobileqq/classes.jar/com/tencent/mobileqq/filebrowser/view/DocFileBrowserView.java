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
  public DocCooperationBanner a;
  public DocCollectFormBanner b;
  private TbsReaderView n;
  private RelativeLayout o;
  private View p;
  private DocQBBottomView q;
  private QQProgressDialog r;
  private View s;
  private boolean t = true;
  
  public DocFileBrowserView(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    Object localObject = (LayoutInflater)this.e.getSystemService("layout_inflater");
    if (localObject == null) {
      return null;
    }
    localObject = ((LayoutInflater)localObject).inflate(2131627084, paramViewGroup, false);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).calcHeightLayoutParam((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)));
    localLayoutParams.addRule(12);
    ((View)localObject).setLayoutParams(localLayoutParams);
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  private void a(AppInterface paramAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = this.e.getString(2131888840);
    String str2 = this.e.getString(2131888833);
    Object localObject3 = ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).getWordingConfig();
    Object localObject1 = localObject2;
    String str1 = str2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (((List)localObject3).size() == 2)
      {
        if (this.t)
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
            if ((((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).a() == 0) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).d())) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).e())))
            {
              localObject2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).d();
              str2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).e();
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
          if ((((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).a() == 1) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).d())) && (!TextUtils.isEmpty(((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).e())))
          {
            localObject2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).d();
            str2 = ((TencentDocEditConvertConfigBean.TencentDocEditConvertConfigItem)localObject1).e();
          }
        }
      }
    }
    localObject2 = (ActionSheet)ActionSheetHelper.b(this.e, null);
    ((ActionSheet)localObject2).setMainTitle((CharSequence)localObject1);
    ((ActionSheet)localObject2).addButton(str1, 5);
    ((ActionSheet)localObject2).addCancelButton(2131887648);
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
    RelativeLayout localRelativeLayout = this.o;
    if (localRelativeLayout == null)
    {
      if ((!c) && (paramView1 != null)) {
        throw new AssertionError();
      }
      this.o = new DocFileBrowserView.GestureRelativeLayout(this, this.e);
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
      this.o.removeView(paramView1);
    }
    paramView1 = new RelativeLayout.LayoutParams(-1, -1);
    this.o.addView(paramView2, i, paramView1);
    return true;
  }
  
  private void i()
  {
    ViewGroup localViewGroup = (ViewGroup)this.d.getParent();
    if ((localViewGroup != null) && (this.o != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.o, 0, localLayoutParams);
    }
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new DocFileBrowserView.1(this));
  }
  
  public void a(int paramInt)
  {
    View localView = this.s;
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
    paramTeamWorkFileImportInfo.n = 3;
    ThreadManager.getUIHandler().post(new DocFileBrowserView.5(this, paramTeamWorkFileImportInfo));
  }
  
  public void a(String paramString)
  {
    if (this.e.isFinishing()) {
      return;
    }
    if (this.r == null)
    {
      this.r = new QQProgressDialog(this.e);
      this.r.setCancelable(false);
    }
    if (!this.r.isShowing())
    {
      this.r.a(paramString);
      this.r.show();
    }
  }
  
  public void a(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManager.getUIHandler().post(new DocFileBrowserView.3(this, paramString, paramLocalTbsViewManagerCallback));
  }
  
  public void a(String paramString, Object paramObject)
  {
    DocQBBottomView localDocQBBottomView = this.q;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramString, paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public View b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.q == null)
    {
      this.q = new DocQBBottomView(this.e, new DocFileBrowserView.6(this));
      this.q.setTeamWorkFileImportInfo(paramTeamWorkFileImportInfo);
      this.q.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
    return this.q;
  }
  
  public void b()
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((TbsReaderView)localObject).onStop();
    }
    localObject = this.q;
    if (localObject != null) {
      ((DocQBBottomView)localObject).a();
    }
  }
  
  public void b(int paramInt)
  {
    DocQBBottomView localDocQBBottomView = this.q;
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
    View localView = this.p;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public View d()
  {
    return this.p;
  }
  
  public boolean e()
  {
    RelativeLayout localRelativeLayout = this.o;
    return (localRelativeLayout != null) && (this.p != null) && (localRelativeLayout.getVisibility() == 0) && (this.p.getVisibility() == 0);
  }
  
  public void f()
  {
    QQProgressDialog localQQProgressDialog = this.r;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.r.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView
 * JD-Core Version:    0.7.0.1
 */