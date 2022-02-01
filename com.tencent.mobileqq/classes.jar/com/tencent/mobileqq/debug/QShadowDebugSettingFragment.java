package com.tencent.mobileqq.debug;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R.id;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginUpdater;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/debug/QShadowDebugSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "()V", "currentPluginType", "", "debugSPName", "", "keyBranch", "keyPluginId", "pluginTypes", "", "Lkotlin/Pair;", "getBranch", "getContentLayoutId", "getPluginId", "getPluginUrl", "pluginId", "installDebugPlugin", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "savePlugin", "branch", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QShadowDebugSettingFragment
  extends QIphoneTitleBarFragment
{
  private int jdField_a_of_type_Int = ((Number)((Pair)this.jdField_a_of_type_JavaUtilList.get(0)).getSecond()).intValue();
  private final String jdField_a_of_type_JavaLangString = "debug_plugin";
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final List<Pair<String, Integer>> jdField_a_of_type_JavaUtilList = CollectionsKt.listOf(new Pair[] { TuplesKt.to("Shadow插件", Integer.valueOf(1)), TuplesKt.to("手Q插件", Integer.valueOf(0)), TuplesKt.to("DF插件", Integer.valueOf(2)) });
  private final String b = "key_debug_id";
  private final String c = "key_branch";
  
  private final String a()
  {
    String str = requireActivity().getSharedPreferences(this.jdField_a_of_type_JavaLangString, 0).getString(this.b, "");
    if (str != null) {
      return str;
    }
    return "";
  }
  
  private final String a(String paramString)
  {
    Object localObject = (EditText)a(R.id.pluginBranchEditText);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "pluginBranchEditText");
    localObject = ((EditText)localObject).getText().toString();
    if (Intrinsics.areEqual("master", localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://downv6.qq.com/innovate/qq/plugin/master/");
      if (paramString != null)
      {
        paramString = paramString.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase()");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("-qshadow-master.zip");
        return ((StringBuilder)localObject).toString();
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://downv6.qq.com/innovate/qq/plugin/debug/");
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase()");
      localStringBuilder.append(paramString);
      localStringBuilder.append("-qshadow-debug-");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(".zip");
      return localStringBuilder.toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void a(String paramString1, String paramString2)
  {
    requireActivity().getSharedPreferences(this.jdField_a_of_type_JavaLangString, 0).edit().putString(this.b, paramString1).putString(this.c, paramString2).apply();
  }
  
  private final String b()
  {
    String str = requireActivity().getSharedPreferences(this.jdField_a_of_type_JavaLangString, 0).getString(this.c, "");
    if (str != null) {
      return str;
    }
    return "";
  }
  
  private final void c()
  {
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (!(localObject1 instanceof QQAppInterface)) {
      return;
    }
    localObject1 = ((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_PLUGIN);
    if (localObject1 != null)
    {
      localObject1 = (IPluginManager)localObject1;
      Object localObject2 = (EditText)a(R.id.pluginIdEditText);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "pluginIdEditText");
      Object localObject3 = ((EditText)localObject2).getText().toString();
      String str = a((String)localObject3);
      localObject2 = new PluginInfo();
      ((PluginInfo)localObject2).mID = ((String)localObject3);
      ((PluginInfo)localObject2).mURL = str;
      ((PluginInfo)localObject2).mMD5 = "";
      ((PluginInfo)localObject2).mSubType = this.jdField_a_of_type_Int;
      localObject3 = new AlertDialog.Builder((Context)getActivity()).setView((View)new ProgressBar((Context)getActivity())).create();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "dialog");
      ((AlertDialog)localObject3).getWindow().setBackgroundDrawable((Drawable)new ColorDrawable());
      ((AlertDialog)localObject3).show();
      ((IPluginManager)localObject1).a((PluginInfo)localObject2, (OnPluginInstallListener)new QShadowDebugSettingFragment.installDebugPlugin.1(this, (AlertDialog)localObject3, new QQToast((Context)getActivity())));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type cooperation.plugin.IPluginManager");
  }
  
  protected int a()
  {
    return 2131561863;
  }
  
  public View a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onViewCreated(@NotNull View paramView, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    a((CharSequence)"Shadow插件测试配置");
    paramView = (Spinner)a(R.id.choosePluginType);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "choosePluginType");
    paramBundle = (Context)getActivity();
    Object localObject = (Iterable)this.jdField_a_of_type_JavaUtilList;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add((String)((Pair)((Iterator)localObject).next()).getFirst());
    }
    paramView.setAdapter((SpinnerAdapter)new ArrayAdapter(paramBundle, 17367048, (List)localCollection));
    paramView = (Spinner)a(R.id.choosePluginType);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "choosePluginType");
    paramView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)new QShadowDebugSettingFragment.onViewCreated.2(this));
    paramView = a();
    paramBundle = b();
    ((EditText)a(R.id.pluginIdEditText)).setText((CharSequence)paramView);
    ((EditText)a(R.id.pluginBranchEditText)).setText((CharSequence)paramBundle);
    ((Button)a(R.id.installPlugin)).setOnClickListener((View.OnClickListener)new QShadowDebugSettingFragment.onViewCreated.3(this));
    paramView = (FormSwitchItem)a(R.id.pluginSwitch);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "pluginSwitch");
    paramView.setChecked(PluginUpdater.a((Context)getActivity()));
    ((FormSwitchItem)a(R.id.pluginSwitch)).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new QShadowDebugSettingFragment.onViewCreated.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.QShadowDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */