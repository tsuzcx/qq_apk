package dov.com.qq.im.aeeditor.module.edit;

import amtj;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import bfum;
import bfur;
import bmbg;
import bmbj;
import bmbk;
import bmbx;
import bmcu;
import bmgl;
import bmgn;
import bmgu;
import bmhn;
import bmho;
import bmhp;
import bmhq;
import bmhr;
import bmhs;
import bmkl;
import bmkn;
import bmkt;
import bmmr;
import bmmx;
import bmna;
import bmng;
import bmnl;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.weseevideo.model.effect.StickerModel;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIVideoLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List<Lcom.tencent.weseevideo.model.effect.StickerModel;>;
import java.util.Map;
import mqq.os.MqqHandler;

public abstract class AEEditorCommonEditFragment
  extends AEEditorBaseFragment
  implements Handler.Callback, bmmr, bmnl
{
  public static int a;
  private static final String c = AEEditorCommonEditFragment.class.getSimpleName();
  private Observer<List<AEEditorFilterBean>> a;
  public Context a;
  protected SparseArray<Map<String, String>> a;
  protected FrameLayout a;
  protected TextView a;
  public bfum a;
  protected bmhn a;
  public bmmx a;
  public TextEditorData a;
  public AEEditorAILoadingView a;
  protected AEEditorControlPanelContainer a;
  public AEEditorFilterControlPanel a;
  public AEEditorTextControlPanel a;
  public AEEditorToolBar a;
  protected AEEditorTopBar a;
  public boolean a;
  protected String b;
  protected boolean b;
  
  static
  {
    jdField_a_of_type_Int = 5;
  }
  
  public AEEditorCommonEditFragment()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378924));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar = ((AEEditorToolBar)paramView.findViewById(2131378914));
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.setToolBarListener(a());
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366747));
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer = ((AEEditorControlPanelContainer)paramView.findViewById(2131365134));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.a(a());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(a(b()));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366692));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel = ((AEEditorTextControlPanel)paramView.findViewById(2131378412));
    if ((this instanceof AEEditorVideoEditFragment)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setIsChooseImage(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setTextStickerControlListener(this);
      this.jdField_a_of_type_AndroidArchLifecycleObserver = new bmhq(this);
      bmkn.a().a().observeForever(this.jdField_a_of_type_AndroidArchLifecycleObserver);
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setIsChooseImage(true);
    }
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_Bmmx = new bmmx();
    this.jdField_a_of_type_Bmmx.a(a());
  }
  
  private void f(View paramView) {}
  
  private void r()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(amtj.a(2131689684));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
  }
  
  private void s()
  {
    if (AEEditorAILoadingView.a()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.8(this), 128, null, true);
  }
  
  protected abstract int a();
  
  protected abstract bmkl a();
  
  protected abstract bmkt a();
  
  protected abstract bmna a();
  
  protected abstract bmng a();
  
  protected abstract TAVCutSession a();
  
  public ArrayList<String> a(bmgl parambmgl)
  {
    getResources().getString(2131717820);
    Object localObject = getResources().getString(2131717821);
    String str = getResources().getString(2131717821);
    if ((parambmgl instanceof bmgn))
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689687), "", "");
      }
      return null;
    }
    if (parambmgl != null)
    {
      if (!TextUtils.isEmpty(parambmgl.a())) {
        parambmgl.a();
      }
      if ((parambmgl instanceof bmgu))
      {
        List localList = ((bmgu)parambmgl).a;
        if (localList != null) {
          if ((localList.size() > 0) && (localList.get(0) != null))
          {
            parambmgl = ((YoutuResultItem)localList.get(0)).Label;
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
      ((ArrayList)localObject).add(parambmgl);
      ((ArrayList)localObject).add(str);
      return localObject;
      continue;
      parambmgl = (bmgl)localObject;
      break;
      parambmgl = (bmgl)localObject;
    }
  }
  
  public void a(int paramInt, AEEditorTextBean paramAEEditorTextBean)
  {
    paramInt = 0;
    TAVCutSession localTAVCutSession = a();
    if (localTAVCutSession == null) {
      return;
    }
    if (!localTAVCutSession.isTavStickerSelected())
    {
      if (paramAEEditorTextBean.type == 1)
      {
        if (((this instanceof AEEditorImageEditFragment)) && (paramAEEditorTextBean.aiColorIndex >= 0))
        {
          paramAEEditorTextBean.backgroundColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean);
          paramAEEditorTextBean.textColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.b(paramAEEditorTextBean);
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean.backgroundColor);
      }
      for (;;)
      {
        if ((localTAVCutSession instanceof TAVCutImageSession)) {
          paramInt = ((TAVCutImageSession)localTAVCutSession).getCurrentIndex();
        }
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = this.jdField_a_of_type_Bmmx.a(localTAVCutSession, paramAEEditorTextBean, paramInt);
        return;
        if (paramAEEditorTextBean.type == 0)
        {
          if (((this instanceof AEEditorImageEditFragment)) && (paramAEEditorTextBean.aiColorIndex >= 0)) {
            paramAEEditorTextBean.textColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean);
          }
          this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean.textColor);
        }
      }
    }
    if (paramAEEditorTextBean.type == 1)
    {
      if (((this instanceof AEEditorImageEditFragment)) && (paramAEEditorTextBean.aiColorIndex >= 0))
      {
        paramAEEditorTextBean.backgroundColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean);
        paramAEEditorTextBean.textColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.b(paramAEEditorTextBean);
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean.backgroundColor);
    }
    while (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null)
    {
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setItemID(paramAEEditorTextBean.id);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setPagFilePath(paramAEEditorTextBean.pagFilePath);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramAEEditorTextBean.textColor);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setBackGroundColor("bgcolor", paramAEEditorTextBean.backgroundColor);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setType(paramAEEditorTextBean.type);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setStickerType(AEEditorTextBean.textBeanType2stickerConfigType(paramAEEditorTextBean));
      if (paramAEEditorTextBean.type == 3)
      {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setBlurTextPath(paramAEEditorTextBean.blurTextPath);
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setBlurTexturePath(paramAEEditorTextBean.blurTexturePath);
        paramAEEditorTextBean.content = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent();
      }
      String str = bmkn.a().a(paramAEEditorTextBean.fontId, 0);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setFont(str);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramAEEditorTextBean.content);
      }
      this.jdField_a_of_type_Bmmx.a(localTAVCutSession, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      return;
      if (paramAEEditorTextBean.type == 0)
      {
        if (((this instanceof AEEditorImageEditFragment)) && (paramAEEditorTextBean.aiColorIndex >= 0)) {
          paramAEEditorTextBean.textColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean);
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean.textColor);
      }
      else if (paramAEEditorTextBean.type == 3)
      {
        paramAEEditorTextBean.blurTextPath = bmkn.a().f(paramAEEditorTextBean.id);
        paramAEEditorTextBean.blurTexturePath = bmkn.a().g(paramAEEditorTextBean.id);
      }
    }
    bmbx.d(c, "[onTextStickerSelected] mCurrentTextEditorData == null");
  }
  
  protected void a(bmgl parambmgl)
  {
    String str1 = getResources().getString(2131717820);
    Object localObject1 = getResources().getString(2131717821);
    String str2 = getResources().getString(2131717821);
    if ((parambmgl instanceof bmgn)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689687), "", "");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject2;
      if (parambmgl != null) {
        if (!TextUtils.isEmpty(parambmgl.a()))
        {
          str1 = parambmgl.a();
          localObject2 = localObject1;
          if ((parambmgl instanceof bmgu))
          {
            List localList = ((bmgu)parambmgl).a;
            localObject2 = localObject1;
            if (localList != null)
            {
              parambmgl = (bmgl)localObject1;
              if (localList.size() > 0) {
                parambmgl = ((YoutuResultItem)localList.get(0)).Label;
              }
              localObject2 = parambmgl;
              if (localList.size() > 1)
              {
                localObject2 = ((YoutuResultItem)localList.get(1)).Label;
                localObject1 = parambmgl;
                parambmgl = (bmgl)localObject2;
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
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(str1, (String)localObject1, parambmgl);
        return;
        parambmgl = str2;
        localObject1 = localObject2;
        continue;
        break;
        parambmgl = str2;
      }
    }
  }
  
  public void a(TextEditorData paramTextEditorData)
  {
    if ((paramTextEditorData == null) || (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel == null)) {
      return;
    }
    int i = 0;
    Object localObject = a();
    if ((localObject instanceof TAVCutImageSession)) {
      i = ((TAVCutImageSession)localObject).getCurrentIndex();
    }
    localObject = (Map)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localObject == null)
    {
      localObject = new HashMap();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    for (;;)
    {
      switch (paramTextEditorData.getType())
      {
      default: 
        if (CollectionUtil.isEmptyMap(paramTextEditorData.getColorList())) {
          i = -1;
        }
        break;
      }
      for (;;)
      {
        ((Map)localObject).put(paramTextEditorData.getUniqueID(), this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(i));
        return;
        i = paramTextEditorData.getTextColor();
        continue;
        i = ((Integer)paramTextEditorData.getColorList().get("bgcolor")).intValue();
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString2 = a();
    if (paramString2 == null) {}
    while (!paramString2.isTavStickerSelected()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null)
    {
      bmbx.d(c, "textEditorData null.");
      return;
    }
    switch (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getType())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmmx.a(paramString2, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      return;
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramInt1);
      continue;
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setBackGroundColor("bgcolor", paramInt1);
      if ("adapter_extract".equals(paramString1))
      {
        paramString1 = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramInt2, null);
        if (paramString1 != null) {
          this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(paramString1.intValue());
        } else {
          bmbx.d(c, "[onTextColorChoose] intelligent color bar is not ready");
        }
      }
      else if (paramInt1 == -1)
      {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(AEEditorColorSelectorView.b);
      }
      else
      {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setTextColor(-1);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Bmhn != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.4(this, paramString1, paramString2));
    }
  }
  
  public void a(List<StickerModel> paramList, int paramInt)
  {
    StringBuilder localStringBuilder2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    Map localMap = (Map)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int i = 0;
    while (i < paramList.size())
    {
      StickerModel localStickerModel = (StickerModel)paramList.get(i);
      localObject1 = "";
      if (localMap != null) {
        localObject1 = (String)localMap.get(localStickerModel.getUniqueId());
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "none";
      }
      localStringBuilder2.append((String)localObject2);
      localStringBuilder1.append(localStickerModel.getMaterialId());
      if (i != paramList.size() - 1)
      {
        localStringBuilder2.append(",");
        localStringBuilder1.append(",");
      }
      i += 1;
    }
    Object localObject1 = localStringBuilder2.toString();
    Object localObject2 = localStringBuilder1.toString();
    paramList = (List<StickerModel>)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramList = "none";
    }
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "none";
    }
    bmbg.a().a().jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramList);
    bmbg.a().a().b.put(paramInt, localObject1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bmhn != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.5(this, paramVarArgs));
    }
  }
  
  public boolean a()
  {
    Object localObject = getActivity();
    localObject = bfur.a((Context)localObject, 230).setTitle(amtj.a(2131689720)).setMessage(((Context)localObject).getString(2131689721)).setPositiveButton(((Context)localObject).getString(2131689720), new bmhs(this)).setNegativeButton(((Context)localObject).getString(2131689690), new bmhr(this));
    if (localObject != null) {}
    try
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        ((QQCustomDialog)localObject).show();
      }
      label83:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label83;
    }
  }
  
  protected abstract boolean a(int paramInt);
  
  public void aB_()
  {
    a().a(getActivity(), true);
  }
  
  public void aC_()
  {
    n();
    g();
  }
  
  protected abstract int b();
  
  protected abstract String b();
  
  public boolean b()
  {
    return false;
  }
  
  protected boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel != null)
    {
      Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (AEEditorFilterBean)((List)localObject).get(paramInt);
        return (localObject != null) && (((AEEditorFilterBean)localObject).getEditorEffectItem().getHideApplyAll() == 1);
      }
    }
    return false;
  }
  
  protected abstract void c();
  
  public boolean c()
  {
    return (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) && (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.getVisibility() == 0);
  }
  
  protected boolean c(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel != null)
    {
      Object localObject = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (AEEditorFilterBean)((List)localObject).get(paramInt);
        return (localObject == null) || (((AEEditorFilterBean)localObject).getEditorEffectItem().getHideAlphaBar() != 1);
      }
    }
    return true;
  }
  
  public abstract void d();
  
  protected boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel != null)
    {
      AEEditorFilterBean localAEEditorFilterBean = this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      bool1 = bool2;
      if (localAEEditorFilterBean != null)
      {
        bool1 = bool2;
        if ("network".equals(localAEEditorFilterBean.getEditorEffectItem().getEffectType())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public abstract void e();
  
  protected boolean e()
  {
    return bmbk.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", true, 0);
  }
  
  protected abstract void f();
  
  protected abstract void g();
  
  protected abstract void h();
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bmbx.a(c, "sendMessage");
      f();
    }
  }
  
  public void i()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.b();
    TAVCutSession localTAVCutSession = a();
    if (localTAVCutSession != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setStickerCount(localTAVCutSession.getStickerTotalSize());
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.e();
    h();
    r();
    this.jdField_a_of_type_Bfum.removeMessages(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a();
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.d();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(null);
    this.jdField_a_of_type_Bfum.removeMessages(0);
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) {
      this.jdField_a_of_type_Bfum.sendEmptyMessageDelayed(0, 2000L);
    }
  }
  
  protected void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if ((this instanceof AEEditorVideoEditFragment)) {}
    for (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAIVideoLoadingView(getActivity());; this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAILoadingView(getActivity()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new bmho(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
      return;
    }
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorComicLoadingView(getActivity());
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new bmhp(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
  }
  
  public abstract void m();
  
  protected void n()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    d();
  }
  
  protected void o()
  {
    bmbk.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", false, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bmbx.b(c, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    bmkn.a().a();
    s();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    bmbx.b(c, "onCreateView");
    c();
    jdField_a_of_type_Int = OfflineConfig.getPhonePerfLevel();
    this.jdField_a_of_type_Bfum = new bfum(Looper.getMainLooper(), this);
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    bmbx.b(c, "onDestroyView");
    super.onDestroyView();
    bmkn.a().a().removeObserver(this.jdField_a_of_type_AndroidArchLifecycleObserver);
    this.jdField_a_of_type_Bfum.removeMessages(0);
    AEEditorTextControlPanel.g();
  }
  
  public void onPause()
  {
    bmbx.b(c, "onPause");
    super.onPause();
    n();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    bmbx.b(c, "onResume");
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bmmx != null) {
      this.jdField_a_of_type_Bmmx.a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bmbx.b(c, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    this.jdField_b_of_type_JavaLangString = getArguments().getString("editor_filter_id");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      bmbx.b(c, "jump from scheme, filterID=" + this.jdField_b_of_type_JavaLangString);
      getArguments().putString("editor_filter_id", "");
    }
    f(paramView);
    a(paramView);
    b(paramView);
    c(paramView);
    d(paramView);
    e(paramView);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.f();
    }
  }
  
  public void q()
  {
    f();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */