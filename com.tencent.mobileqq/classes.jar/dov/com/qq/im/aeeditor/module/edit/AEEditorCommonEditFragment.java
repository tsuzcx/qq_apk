package dov.com.qq.im.aeeditor.module.edit;

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
import anni;
import bgli;
import bglp;
import bgpa;
import bnyl;
import bnyo;
import bnyp;
import bnzb;
import bnzp;
import bode;
import bodg;
import bodj;
import boec;
import boed;
import boee;
import boef;
import boeg;
import boeh;
import bofu;
import bofw;
import bogc;
import boia;
import boig;
import boij;
import boip;
import boiu;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.mobileqq.app.ThreadManager;
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
  implements Handler.Callback, boia, boiu
{
  public static int a;
  private static final String c = AEEditorCommonEditFragment.class.getSimpleName();
  private Observer<List<AEEditorFilterBean>> a;
  public Context a;
  protected SparseArray<Map<String, String>> a;
  protected FrameLayout a;
  protected TextView a;
  public bgli a;
  protected boec a;
  public boig a;
  public TextEditorData a;
  public AEEditorAILoadingView a;
  protected AEEditorControlPanelContainer a;
  public AEEditorFilterControlPanel a;
  public AEEditorTextControlPanel a;
  public AEEditorToolBar a;
  public AEEditorTopBar a;
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131378990));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(c());
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar = ((AEEditorToolBar)paramView.findViewById(2131378980));
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.setToolBarListener(a());
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366667));
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer = ((AEEditorControlPanelContainer)paramView.findViewById(2131365058));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = this.jdField_a_of_type_DovComQqImAeeditorModuleControlpanelAEEditorControlPanelContainer.a(a());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(a(b()));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366615));
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel = ((AEEditorTextControlPanel)paramView.findViewById(2131378489));
    if ((this instanceof AEEditorVideoEditFragment)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setIsChooseImage(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setTextStickerControlListener(this);
      this.jdField_a_of_type_AndroidArchLifecycleObserver = new boef(this);
      bofw.a().a().observeForever(this.jdField_a_of_type_AndroidArchLifecycleObserver);
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setIsChooseImage(true);
    }
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_Boig = new boig();
    this.jdField_a_of_type_Boig.a(a());
  }
  
  private void f(View paramView) {}
  
  private void q()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(anni.a(2131689680));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.b();
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.b();
  }
  
  private void r()
  {
    if (AEEditorAILoadingView.a()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.8(this), 128, null, true);
  }
  
  protected abstract int a();
  
  protected abstract bofu a();
  
  protected abstract bogc a();
  
  protected abstract boij a();
  
  protected abstract boip a();
  
  protected abstract TAVCutSession a();
  
  public ArrayList<String> a(bode parambode)
  {
    getResources().getString(2131717453);
    Object localObject = getResources().getString(2131717454);
    String str = getResources().getString(2131717454);
    if ((parambode instanceof bodg))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689681), "", "");
      return null;
    }
    if (parambode != null)
    {
      if (!TextUtils.isEmpty(parambode.a())) {
        parambode.a();
      }
      if ((parambode instanceof bodj))
      {
        List localList = ((bodj)parambode).a;
        if (localList != null) {
          if ((localList.size() > 0) && (localList.get(0) != null))
          {
            parambode = ((YoutuResultItem)localList.get(0)).Label;
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
      ((ArrayList)localObject).add(parambode);
      ((ArrayList)localObject).add(str);
      return localObject;
      continue;
      parambode = (bode)localObject;
      break;
      parambode = (bode)localObject;
    }
  }
  
  public void a(int paramInt, AEEditorTextBean paramAEEditorTextBean)
  {
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
        paramInt = 0;
        if ((localTAVCutSession instanceof TAVCutImageSession)) {
          paramInt = ((TAVCutImageSession)localTAVCutSession).getCurrentIndex();
        }
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = this.jdField_a_of_type_Boig.a(localTAVCutSession, paramAEEditorTextBean, paramInt);
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
      String str = bofw.a().g(paramAEEditorTextBean.fontId);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setFont(str);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramAEEditorTextBean.content);
      }
      this.jdField_a_of_type_Boig.a(localTAVCutSession, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
      return;
      if (paramAEEditorTextBean.type == 0)
      {
        if (((this instanceof AEEditorImageEditFragment)) && (paramAEEditorTextBean.aiColorIndex >= 0)) {
          paramAEEditorTextBean.textColor = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean);
        }
        this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(paramAEEditorTextBean.textColor);
      }
    }
    bnzb.d(c, "[onTextStickerSelected] mCurrentTextEditorData == null");
  }
  
  protected void a(bode parambode)
  {
    String str1 = getResources().getString(2131717453);
    Object localObject1 = getResources().getString(2131717454);
    String str2 = getResources().getString(2131717454);
    if ((parambode instanceof bodg)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689681), "", "");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject2;
      if (parambode != null) {
        if (!TextUtils.isEmpty(parambode.a()))
        {
          str1 = parambode.a();
          localObject2 = localObject1;
          if ((parambode instanceof bodj))
          {
            List localList = ((bodj)parambode).a;
            localObject2 = localObject1;
            if (localList != null)
            {
              parambode = (bode)localObject1;
              if (localList.size() > 0) {
                parambode = ((YoutuResultItem)localList.get(0)).Label;
              }
              localObject2 = parambode;
              if (localList.size() > 1)
              {
                localObject2 = ((YoutuResultItem)localList.get(1)).Label;
                localObject1 = parambode;
                parambode = (bode)localObject2;
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
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(str1, (String)localObject1, parambode);
        return;
        parambode = str2;
        localObject1 = localObject2;
        continue;
        break;
        parambode = str2;
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
      bnzb.d(c, "textEditorData null.");
      return;
    }
    switch (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getType())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Boig.a(paramString2, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
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
          bnzb.d(c, "[onTextColorChoose] intelligent color bar is not ready");
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
    if (this.jdField_a_of_type_Boec != null) {
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
    bnyl.a().a().jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramList);
    bnyl.a().a().b.put(paramInt, localObject1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Boec != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.5(this, paramVarArgs));
    }
  }
  
  public boolean a()
  {
    Object localObject = getActivity();
    localObject = bglp.a((Context)localObject, 230).setTitle(anni.a(2131689705)).setMessage(((Context)localObject).getString(2131689706)).setPositiveButton(((Context)localObject).getString(2131689705), new boeh(this)).setNegativeButton(((Context)localObject).getString(2131689684), new boeg(this));
    if (localObject != null) {}
    try
    {
      if (!((bgpa)localObject).isShowing()) {
        ((bgpa)localObject).show();
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
  
  public void aQ_()
  {
    a().a(getActivity(), true);
  }
  
  public void aR_()
  {
    n();
    g();
  }
  
  protected abstract int b();
  
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
  
  protected abstract String c();
  
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
    return bnyp.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", true, 0);
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
      bnzb.a(c, "sendMessage");
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
    q();
    this.jdField_a_of_type_Bgli.removeMessages(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a();
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.d();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.a();
    this.jdField_a_of_type_DovComQqImAeeditorModuleToolbarAEEditorToolBar.c();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(null);
    this.jdField_a_of_type_Bgli.removeMessages(0);
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) {
      this.jdField_a_of_type_Bgli.sendEmptyMessageDelayed(0, 2000L);
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
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new boed(this));
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
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new boee(this));
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
    bnyp.a().a("SP_KEY_HAS_SINGLE_IMAGE_USE_AIFILTER", false, 0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    bnzb.b(c, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    bofw.a().a();
    r();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    bnzb.b(c, "onCreateView");
    c();
    jdField_a_of_type_Int = OfflineConfig.getPhonePerfLevel();
    this.jdField_a_of_type_Bgli = new bgli(Looper.getMainLooper(), this);
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    bnzb.b(c, "onDestroyView");
    super.onDestroyView();
    bofw.a().a().removeObserver(this.jdField_a_of_type_AndroidArchLifecycleObserver);
    this.jdField_a_of_type_Bgli.removeMessages(0);
    AEEditorTextControlPanel.f();
  }
  
  public void onPause()
  {
    bnzb.b(c, "onPause");
    super.onPause();
    n();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    bnzb.b(c, "onResume");
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Boig != null) {
      this.jdField_a_of_type_Boig.a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    bnzb.b(c, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    this.jdField_b_of_type_JavaLangString = getArguments().getString("editor_filter_id");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      bnzb.b(c, "jump from scheme, filterID=" + this.jdField_b_of_type_JavaLangString);
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
    f();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */