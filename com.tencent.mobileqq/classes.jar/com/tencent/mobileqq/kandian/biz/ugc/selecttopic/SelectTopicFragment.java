package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.app.Activity;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.kandian.base.mvp.ListContract.IListModel;
import com.tencent.mobileqq.kandian.base.mvp.ListPresenter;
import com.tencent.mobileqq.kandian.biz.ugc.mycolumn.MyColumnModel;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/SelectTopicFragment;", "Lcom/tencent/mobileqq/app/BaseFragment;", "()V", "finish", "", "handleVideoAddToTopicResult", "errorCode", "", "activity", "Lcom/tencent/mobileqq/app/BaseActivity;", "topicId", "rowKey", "", "errorMsg", "needShowServerErrorMsg", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SelectTopicFragment
  extends BaseFragment
{
  public static final SelectTopicFragment.Companion a = new SelectTopicFragment.Companion(null);
  
  private final void a()
  {
    Object localObject = getBaseActivity();
    if (localObject != null)
    {
      ((BaseActivity)localObject).getSupportFragmentManager().beginTransaction().remove((Fragment)this).commit();
      localObject = ((BaseActivity)localObject).getWindow();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "window");
      localObject = ((Window)localObject).getDecorView().findViewById(16908290);
      if (localObject != null)
      {
        localObject = (ViewGroup)localObject;
        View localView = ((ViewGroup)localObject).findViewById(2131376076);
        if (localView != null) {
          ((ViewGroup)localObject).removeView(localView);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
    }
  }
  
  private final void a(int paramInt1, BaseActivity paramBaseActivity, int paramInt2, String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final boolean a(int paramInt)
  {
    return (paramInt == 100010) || (paramInt == 110010);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_rowKey");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    Object localObject = getArguments();
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((Bundle)localObject).getInt("key_from");
    } else {
      i = 0;
    }
    if (((CharSequence)paramBundle).length() > 0) {
      j = 1;
    }
    if (j != 0)
    {
      localObject = getBaseActivity();
      if (localObject != null)
      {
        SelectTopicView localSelectTopicView = new SelectTopicView((BaseActivity)localObject, new ListPresenter((ListContract.IListModel)new MyColumnModel()));
        SlidingUpDialog localSlidingUpDialog = new SlidingUpDialog((Activity)localObject, (View)localSelectTopicView, true, new RelativeLayout.LayoutParams(-1, -2));
        localSelectTopicView.setSelectCallback((Function1)new SelectTopicFragment.onCreate..inlined.let.lambda.1(localSlidingUpDialog, (BaseActivity)localObject, this, i, paramBundle));
        localSlidingUpDialog.setOnDismissListener((DialogInterface.OnDismissListener)new SelectTopicFragment.onCreate..inlined.let.lambda.2(this, i, paramBundle));
        localSlidingUpDialog.show();
      }
    }
    else
    {
      QLog.e("SelectTopicFragment", 1, "start select topic failed, rowkey isEmpty");
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.SelectTopicFragment
 * JD-Core Version:    0.7.0.1
 */