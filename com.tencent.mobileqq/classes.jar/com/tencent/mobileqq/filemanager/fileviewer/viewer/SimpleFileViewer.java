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
  private DocQBBottomView A;
  private QQProgressDialog B;
  private View C;
  private boolean D = true;
  private TextView E;
  AsyncImageView l;
  public DocCooperationBanner m;
  public DocCollectFormBanner n;
  private TextView o;
  private View p;
  private View q;
  private TbsReaderView r;
  private RelativeLayout s;
  private TextView t;
  private TextView u;
  private TextView v;
  private TextView w;
  private TextView x;
  private boolean y = false;
  private View z;
  
  public SimpleFileViewer(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject2 = this.c.getString(2131888840);
    String str2 = this.c.getString(2131888833);
    Object localObject3 = ((ITencentDocConvertABTestUtil)QRoute.api(ITencentDocConvertABTestUtil.class)).getWordingConfig();
    Object localObject1 = localObject2;
    String str1 = str2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (((List)localObject3).size() == 2)
      {
        if (this.D)
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
    localObject2 = (ActionSheet)ActionSheetHelper.b(this.c, null);
    ((ActionSheet)localObject2).setMainTitle((CharSequence)localObject1);
    ((ActionSheet)localObject2).addButton(str1, 5);
    ((ActionSheet)localObject2).addCancelButton(2131887648);
    ((ActionSheet)localObject2).setOnButtonClickListener(new SimpleFileViewer.7(this, paramQQAppInterface, paramTeamWorkFileImportInfo, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
  }
  
  private boolean a(View paramView1, View paramView2, boolean paramBoolean)
  {
    if (paramView1 == null)
    {
      this.q = paramView2;
      if ((this.s == null) && (paramView2 != null))
      {
        if (paramView2.getParent() != null) {
          ((ViewGroup)paramView2.getParent()).removeAllViews();
        }
        if (paramBoolean) {
          paramView1 = new SimpleFileViewer.GestureRelativeLayout(this, this.c);
        } else {
          paramView1 = new RelativeLayout(this.c);
        }
        this.s = paramView1;
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.s.addView(paramView2, 0, paramView1);
        return true;
      }
    }
    else if ((this.s != null) && (paramView1 != null) && (paramView2 != null) && (paramView1.hashCode() != paramView2.hashCode()))
    {
      int i = this.s.indexOfChild(paramView1);
      if (i >= 0)
      {
        this.s.removeView(paramView1);
        paramView1 = new RelativeLayout.LayoutParams(-1, -1);
        this.s.addView(paramView2, i, paramView1);
        this.q = paramView2;
        return true;
      }
    }
    return false;
  }
  
  private void j()
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.getParent();
    if ((localViewGroup != null) && (this.s != null))
    {
      localViewGroup.removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localViewGroup.addView(this.s, 0, localLayoutParams);
    }
  }
  
  public View a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (this.A == null)
    {
      this.A = new DocQBBottomView(this.c, new SimpleFileViewer.2(this));
      this.A.setTeamWorkFileImportInfo(paramTeamWorkFileImportInfo);
      this.A.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }
    return this.A;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: SimpleFileViewer initFileView");
    if (this.b == null)
    {
      this.b = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131627093, this.a, false);
      this.p = this.b;
      this.o = ((TextView)this.b.findViewById(2131433120));
      this.l = ((AsyncImageView)this.b.findViewById(2131430297));
      this.t = ((TextView)this.b.findViewById(2131433114));
      this.u = ((TextView)this.b.findViewById(2131433111));
      this.i = ((TextView)this.b.findViewById(2131439595));
      this.x = ((TextView)this.b.findViewById(2131427500));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TbsReaderView localTbsReaderView = this.r;
    if (localTbsReaderView != null) {
      localTbsReaderView.onSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void a(SpannableString paramSpannableString)
  {
    this.o.setMovementMethod(LinkMovementMethod.getInstance());
    this.o.setText(paramSpannableString);
    this.o.setHighlightColor(17170445);
  }
  
  public void a(String paramString, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback)
  {
    ThreadManager.getUIHandler().post(new SimpleFileViewer.5(this, paramString, paramLocalTbsViewManagerCallback));
  }
  
  public void a(String paramString, Object paramObject)
  {
    DocQBBottomView localDocQBBottomView = this.A;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramString, paramObject);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.v == null) {
      this.v = ((TextView)this.b.findViewById(2131430838));
    }
    TextView localTextView = this.v;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    this.v.setText(paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.w == null) {
      this.w = ((TextView)this.b.findViewById(2131445222));
    }
    TextView localTextView = this.w;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
    this.w.setText(paramString);
    if (paramInt != 0) {
      this.w.setTextColor(this.c.getResources().getColor(paramInt));
    }
    this.w.setOnClickListener(paramOnClickListener);
  }
  
  public View b()
  {
    if ((this.s != null) && (this.q != null))
    {
      QLog.e("FileBrowserViewBase", 2, "getInnerFileView : tbs not null");
      this.b = this.s;
    }
    return this.b;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (this.E == null) {
      this.E = ((TextView)this.b.findViewById(2131434466));
    }
    this.E.setVisibility(0);
    this.E.setOnClickListener(paramOnClickListener);
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {
      return;
    }
    paramTeamWorkFileImportInfo.n = 3;
    ThreadManager.getUIHandler().post(new SimpleFileViewer.3(this, paramTeamWorkFileImportInfo));
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    TextView localTextView = this.x;
    if (localTextView != null)
    {
      localTextView.setText(paramString);
      this.x.setOnClickListener(paramOnClickListener);
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
  
  public void c(int paramInt)
  {
    this.l.setImageResource(paramInt);
  }
  
  public void c(String paramString)
  {
    this.o.setText(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.o.getText())))
    {
      this.o.setVisibility(0);
      return;
    }
    this.o.setVisibility(8);
  }
  
  public void d(int paramInt)
  {
    this.l.setImageResource(paramInt);
  }
  
  public void d(String paramString)
  {
    if (this.t.getMeasuredWidth() <= 0)
    {
      this.t.post(new SimpleFileViewer.1(this, paramString));
      return;
    }
    TextView localTextView = this.t;
    localTextView.setText(FileManagerUtil.a(paramString, false, localTextView.getMeasuredWidth(), this.t.getPaint(), 2));
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.x != null)
    {
      Object localObject = this.d;
      int i = 0;
      if (localObject != null)
      {
        if ((paramBoolean) && (this.d.getVisibility() != 0))
        {
          this.x.setVisibility(0);
          return;
        }
        this.x.setVisibility(8);
        return;
      }
      localObject = this.x;
      if (!paramBoolean) {
        i = 8;
      }
      ((TextView)localObject).setVisibility(i);
    }
  }
  
  public void e()
  {
    View localView = this.z;
    if ((localView != null) && (localView.getVisibility() == 0)) {
      this.z.setVisibility(8);
    }
  }
  
  public void e(int paramInt)
  {
    DocQBBottomView localDocQBBottomView = this.A;
    if (localDocQBBottomView != null) {
      localDocQBBottomView.a(paramInt);
    }
  }
  
  public void e(String paramString)
  {
    this.l.setApkIconAsyncImage(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView = this.u;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public View f()
  {
    return this.z;
  }
  
  public void f(int paramInt)
  {
    View localView = this.C;
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
    this.l.setUrlIconAsyncImage(paramString);
  }
  
  public void f(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void g(String paramString)
  {
    this.u.setText(paramString);
  }
  
  public void g(boolean paramBoolean)
  {
    TextView localTextView = this.E;
    if (localTextView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localTextView.setVisibility(i);
    }
  }
  
  public boolean g()
  {
    if ((this.s != null) && (this.q != null))
    {
      View localView = this.z;
      if ((localView != null) && (localView.getVisibility() == 0) && (this.s.getVisibility() == 0) && (this.z.getVisibility() == 0)) {
        return true;
      }
    }
    return false;
  }
  
  public void h()
  {
    QQProgressDialog localQQProgressDialog = this.B;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.B.dismiss();
    }
  }
  
  public void h(String paramString)
  {
    if (this.B == null)
    {
      this.B = new QQProgressDialog(this.c);
      this.B.setCancelable(false);
    }
    if ((!this.B.isShowing()) && (!this.c.isFinishing()))
    {
      this.B.a(paramString);
      this.B.show();
    }
  }
  
  public void i()
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((TbsReaderView)localObject).onStop();
    }
    localObject = this.A;
    if (localObject != null) {
      ((DocQBBottomView)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer
 * JD-Core Version:    0.7.0.1
 */