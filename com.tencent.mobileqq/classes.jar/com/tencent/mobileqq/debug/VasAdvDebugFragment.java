package com.tencent.mobileqq.debug;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/debug/VasAdvDebugFragment;", "Lcom/tencent/mobileqq/fragment/IphoneTitleBarFragment;", "()V", "doOnCreateView", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "getContentLayoutId", "", "initView", "isEnableWebviewDebug", "", "setEnableWebviewDebug", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvDebugFragment
  extends IphoneTitleBarFragment
{
  public static final VasAdvDebugFragment.Companion a;
  private HashMap a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDebugVasAdvDebugFragment$Companion = new VasAdvDebugFragment.Companion(null);
  }
  
  private final void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putBoolean("enableWebviewDebug", paramBoolean).apply();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnableWebviewDebug: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(' ');
    QLog.d("VasAdvDebugFragment", 1, localStringBuilder.toString());
  }
  
  private final boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("enableWebviewDebug", false);
  }
  
  private final void b()
  {
    View localView = this.mContentView;
    Object localObject = (CheckBox)localView.findViewById(2131364393);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cbWebViewDebug");
    ((CheckBox)localObject).setChecked(a());
    ((CheckBox)localObject).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new VasAdvDebugFragment.initView..inlined.apply.lambda.1(this));
    ((TextView)localView.findViewById(2131379935)).setOnClickListener((View.OnClickListener)new VasAdvDebugFragment.initView..inlined.apply.lambda.2(this));
    localObject = (EditText)localView.findViewById(2131366340);
    EditText localEditText = (EditText)localView.findViewById(2131366341);
    ((TextView)localView.findViewById(2131379936)).setOnClickListener((View.OnClickListener)new VasAdvDebugFragment.initView.1.3(localView, (EditText)localObject, localEditText));
  }
  
  public void a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected void doOnCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle((CharSequence)"增值广告测试");
    b();
  }
  
  protected int getContentLayoutId()
  {
    return 2131561578;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.VasAdvDebugFragment
 * JD-Core Version:    0.7.0.1
 */