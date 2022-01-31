package dov.com.qq.im.aeeditor.module.edit;

import alpo;
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
import bdbw;
import bdcd;
import bdfq;
import blfg;
import blfr;
import blhb;
import blhd;
import blhf;
import blib;
import blic;
import blid;
import blie;
import blif;
import bljf;
import bljh;
import bljn;
import blkw;
import blla;
import blld;
import bllj;
import bmab;
import bmac;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.tavcut.TavCutVersion;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIVideoLoadingView;
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
  implements Handler.Callback, bllj
{
  private static final String b = AEEditorCommonEditFragment.class.getSimpleName();
  public Context a;
  protected FrameLayout a;
  protected TextView a;
  public bdbw a;
  protected blib a;
  public blkw a;
  private bmac<List<AEEditorFilterBean>> a;
  public AEEditorAILoadingView a;
  protected AEEditorControlPanelContainer a;
  public AEEditorFilterControlPanel a;
  public AEEditorToolBar a;
  protected AEEditorTopBar a;
  protected boolean a;
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378090));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(c());
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar = ((AEEditorToolBar)paramView.findViewById(2131378081));
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.setToolBarListener(a());
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366416));
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer = ((AEEditorControlPanelContainer)paramView.findViewById(2131364827));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.a(a());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366362));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_Bmac = new blid(this);
    bljh.a().a().a(this.jdField_a_of_type_Bmac);
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_Blkw = new blkw();
    this.jdField_a_of_type_Blkw.a(a());
  }
  
  private void f(View paramView)
  {
    a("TAVCut版本", TavCutVersion.getVersion());
  }
  
  private void i()
  {
    if (AEEditorAILoadingView.a()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.7(this), 128, null, true);
  }
  
  protected abstract int a();
  
  protected abstract bljf a();
  
  protected abstract bljn a();
  
  protected abstract blla a();
  
  protected abstract blld a();
  
  public ArrayList<String> a(blhb paramblhb)
  {
    getResources().getString(2131719398);
    Object localObject = getResources().getString(2131719399);
    String str = getResources().getString(2131719399);
    if ((paramblhb instanceof blhd))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689789), "", "");
      return null;
    }
    if (paramblhb != null)
    {
      if (!TextUtils.isEmpty(paramblhb.a())) {
        paramblhb.a();
      }
      if ((paramblhb instanceof blhf))
      {
        List localList = ((blhf)paramblhb).a;
        if (localList != null) {
          if ((localList.size() > 0) && (localList.get(0) != null))
          {
            paramblhb = ((YoutuResultItem)localList.get(0)).Label;
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
      ((ArrayList)localObject).add(paramblhb);
      ((ArrayList)localObject).add(str);
      return localObject;
      continue;
      paramblhb = (blhb)localObject;
      break;
      paramblhb = (blhb)localObject;
    }
  }
  
  protected void a(blhb paramblhb)
  {
    String str1 = getResources().getString(2131719398);
    Object localObject1 = getResources().getString(2131719399);
    String str2 = getResources().getString(2131719399);
    if ((paramblhb instanceof blhd)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689789), "", "");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject2;
      if (paramblhb != null) {
        if (!TextUtils.isEmpty(paramblhb.a()))
        {
          str1 = paramblhb.a();
          localObject2 = localObject1;
          if ((paramblhb instanceof blhf))
          {
            List localList = ((blhf)paramblhb).a;
            localObject2 = localObject1;
            if (localList != null)
            {
              paramblhb = (blhb)localObject1;
              if (localList.size() > 0) {
                paramblhb = ((YoutuResultItem)localList.get(0)).Label;
              }
              localObject2 = paramblhb;
              if (localList.size() > 1)
              {
                localObject2 = ((YoutuResultItem)localList.get(1)).Label;
                localObject1 = paramblhb;
                paramblhb = (blhb)localObject2;
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
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(str1, (String)localObject1, paramblhb);
        return;
        paramblhb = str2;
        localObject1 = localObject2;
        continue;
        break;
        paramblhb = str2;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Blib != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.3(this, paramString1, paramString2));
    }
  }
  
  public void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Blib != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.4(this, paramVarArgs));
    }
  }
  
  public boolean a()
  {
    Object localObject = getActivity();
    localObject = bdcd.a((Context)localObject, 230).setTitle(alpo.a(2131689807)).setMessage(((Context)localObject).getString(2131689808)).setPositiveButton(((Context)localObject).getString(2131689807), new blif(this)).setNegativeButton(((Context)localObject).getString(2131689792), new blie(this));
    if (localObject != null) {}
    try
    {
      if (!((bdfq)localObject).isShowing()) {
        ((bdfq)localObject).show();
      }
      label83:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  public void aV_()
  {
    a().a(getActivity(), true);
  }
  
  public void aW_()
  {
    h();
    f();
  }
  
  protected abstract int b();
  
  protected abstract boolean b();
  
  protected abstract String c();
  
  protected abstract void c();
  
  public abstract void d();
  
  protected abstract void e();
  
  protected abstract void f();
  
  protected void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if ((this instanceof AEEditorVideoEditFragment)) {}
    for (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAIVideoLoadingView(getActivity());; this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAILoadingView(getActivity()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new blic(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
      return;
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      blfg.a(b, "sendMessage");
      e();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    blfg.b(b, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    i();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    blfg.b(b, "onCreateView");
    a(2131165212);
    c();
    this.jdField_a_of_type_Bdbw = new bdbw(Looper.getMainLooper(), this);
    return paramLayoutInflater.inflate(a(), paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    blfg.b(b, "onDestroyView");
    super.onDestroyView();
    bljh.a().a().b(this.jdField_a_of_type_Bmac);
    this.jdField_a_of_type_Bdbw.removeMessages(0);
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
    blfg.b(b, "onPause");
    super.onPause();
    h();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    blfg.b(b, "onResume");
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    blfg.b(b, "onViewCreated");
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