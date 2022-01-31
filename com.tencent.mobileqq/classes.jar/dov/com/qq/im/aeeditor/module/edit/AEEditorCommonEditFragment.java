package dov.com.qq.im.aeeditor.module.edit;

import alud;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import bdgf;
import bdgm;
import bdjz;
import bljc;
import bljn;
import bljy;
import bllj;
import blll;
import bllo;
import blmk;
import blml;
import blmm;
import blmn;
import blmo;
import blmp;
import blnr;
import blnt;
import blnz;
import blpi;
import blpm;
import blpp;
import blpv;
import bmen;
import bmeo;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.TavCutVersion;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIVideoLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public abstract class AEEditorCommonEditFragment
  extends AEEditorBaseFragment
  implements Handler.Callback, blpv
{
  private static final String b = AEEditorCommonEditFragment.class.getSimpleName();
  public Context a;
  protected FrameLayout a;
  protected TextView a;
  public bdgf a;
  protected blmk a;
  public blpi a;
  private bmeo<List<AEEditorFilterBean>> a;
  public AEEditorAILoadingView a;
  protected AEEditorControlPanelContainer a;
  public AEEditorFilterControlPanel a;
  public AEEditorToolBar a;
  protected AEEditorTopBar a;
  protected boolean a;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378144));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(c());
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar = ((AEEditorToolBar)paramView.findViewById(2131378135));
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.setToolBarListener(a());
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366418));
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer = ((AEEditorControlPanelContainer)paramView.findViewById(2131364828));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.a(a());
    boolean bool = c();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(bool);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366364));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_Bmeo = new blmn(this, bool);
    blnt.a().a().a(this.jdField_a_of_type_Bmeo);
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_Blpi = new blpi();
    this.jdField_a_of_type_Blpi.a(a());
  }
  
  private void f(View paramView)
  {
    a("TAVCut版本", TavCutVersion.getVersion());
  }
  
  private void l()
  {
    if (AEEditorAILoadingView.a()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.8(this), 128, null, true);
  }
  
  protected abstract int a();
  
  protected abstract blnr a();
  
  protected abstract blnz a();
  
  protected abstract blpm a();
  
  protected abstract blpp a();
  
  public ArrayList<String> a(bllj parambllj)
  {
    getResources().getString(2131719410);
    Object localObject = getResources().getString(2131719411);
    String str = getResources().getString(2131719411);
    if ((parambllj instanceof blll))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689789), "", "");
      return null;
    }
    if (parambllj != null)
    {
      if (!TextUtils.isEmpty(parambllj.a())) {
        parambllj.a();
      }
      if ((parambllj instanceof bllo))
      {
        List localList = ((bllo)parambllj).a;
        if (localList != null) {
          if ((localList.size() > 0) && (localList.get(0) != null))
          {
            parambllj = ((YoutuResultItem)localList.get(0)).Label;
            if ((localList.size() > 1) && (localList.get(1) != null)) {
              str = ((YoutuResultItem)localList.get(1)).Label;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(parambllj);
      ((ArrayList)localObject).add(str);
      return localObject;
      continue;
      parambllj = (bllj)localObject;
      break;
      parambllj = (bllj)localObject;
    }
  }
  
  protected void a(bllj parambllj)
  {
    String str1 = getResources().getString(2131719410);
    Object localObject1 = getResources().getString(2131719411);
    String str2 = getResources().getString(2131719411);
    if ((parambllj instanceof blll)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689789), "", "");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject2;
      if (parambllj != null) {
        if (!TextUtils.isEmpty(parambllj.a()))
        {
          str1 = parambllj.a();
          localObject2 = localObject1;
          if ((parambllj instanceof bllo))
          {
            List localList = ((bllo)parambllj).a;
            localObject2 = localObject1;
            if (localList != null)
            {
              parambllj = (bllj)localObject1;
              if (localList.size() > 0) {
                parambllj = ((YoutuResultItem)localList.get(0)).Label;
              }
              localObject2 = parambllj;
              if (localList.size() > 1)
              {
                localObject2 = ((YoutuResultItem)localList.get(1)).Label;
                localObject1 = parambllj;
                parambllj = (bllj)localObject2;
              }
            }
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView == null) {
          break label201;
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(str1, (String)localObject1, parambllj);
        return;
        parambllj = str2;
        localObject1 = localObject2;
        continue;
        break;
        parambllj = str2;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Blmk != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.4(this, paramString1, paramString2));
    }
  }
  
  public void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Blmk != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.5(this, paramVarArgs));
    }
  }
  
  public boolean a()
  {
    Object localObject = getActivity();
    localObject = bdgm.a((Context)localObject, 230).setTitle(alud.a(2131689807)).setMessage(((Context)localObject).getString(2131689808)).setPositiveButton(((Context)localObject).getString(2131689807), new blmp(this)).setNegativeButton(((Context)localObject).getString(2131689792), new blmo(this));
    if (localObject != null) {}
    try
    {
      if (!((bdjz)localObject).isShowing()) {
        ((bdjz)localObject).show();
      }
      label83:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  public void aS_()
  {
    a().a(getActivity(), true);
  }
  
  public void aT_()
  {
    j();
    g();
  }
  
  protected abstract int b();
  
  protected abstract boolean b();
  
  protected abstract String c();
  
  protected abstract void c();
  
  protected boolean c()
  {
    return false;
  }
  
  public abstract void d();
  
  protected boolean d()
  {
    return bljc.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", true, 0);
  }
  
  public abstract void e();
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if ((this instanceof AEEditorVideoEditFragment)) {}
    for (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAIVideoLoadingView(getActivity());; this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAILoadingView(getActivity()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new blml(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bljn.a(b, "sendMessage");
      f();
    }
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorComicLoadingView(getActivity());
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new blmm(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
  }
  
  protected void j()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    d();
  }
  
  protected void k()
  {
    bljc.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", false, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bljn.b(b, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    l();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    bljn.b(b, "onCreateView");
    a(2131165212);
    c();
    this.jdField_a_of_type_Bdgf = new bdgf(Looper.getMainLooper(), this);
    return paramLayoutInflater.inflate(a(), paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    bljn.b(b, "onDestroyView");
    super.onDestroyView();
    blnt.a().a().b(this.jdField_a_of_type_Bmeo);
    this.jdField_a_of_type_Bdgf.removeMessages(0);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      a(2131165212);
    }
  }
  
  public void onPause()
  {
    bljn.b(b, "onPause");
    super.onPause();
    j();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    bljn.b(b, "onResume");
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bljn.b(b, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    f(paramView);
    a(paramView);
    b(paramView);
    c(paramView);
    d(paramView);
    e(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */