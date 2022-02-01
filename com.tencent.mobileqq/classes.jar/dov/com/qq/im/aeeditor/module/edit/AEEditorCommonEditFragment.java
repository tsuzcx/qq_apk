package dov.com.qq.im.aeeditor.module.edit;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.YoutuResultItem;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tavcut.bean.TextEditorData;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.session.TAVCutSession;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weseevideo.model.effect.StickerModel;
import common.config.service.QzoneConfig;
import dov.com.qq.im.SystemUtil;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.report.AEEditReportData;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorModuleManager;
import dov.com.qq.im.aeeditor.arch.AEEditorBaseFragment;
import dov.com.qq.im.aeeditor.manage.AEEditorDataServiceHandler;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAILoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorAIVideoLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView;
import dov.com.qq.im.aeeditor.module.aifilter.AIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterResult;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView;
import dov.com.qq.im.aeeditor.module.debug.DebugInfoPart;
import dov.com.qq.im.aeeditor.module.edit.widgets.AEEditorCheckGroupView;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.FilterControlListener;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import dov.com.qq.im.aeeditor.module.filter.FilterChangedComparator;
import dov.com.qq.im.aeeditor.module.text.AEEditorColorSelectorView;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextBean;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.TextStickerControlListener;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextPart.AEEditorTextDialogListener;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar;
import dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar.TopBarClickListener;
import dov.com.qq.im.aeeditor.util.AEEditorPagStickerUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.weseevideo.model.effect.StickerModel;>;
import java.util.Map;
import mqq.os.MqqHandler;
import org.light.device.OfflineConfig;

public abstract class AEEditorCommonEditFragment
  extends AEEditorBaseFragment
  implements Handler.Callback, AEEditorTextControlPanel.TextStickerControlListener, AEEditorTopBar.TopBarClickListener
{
  public static int a;
  private static final String d = AEEditorCommonEditFragment.class.getSimpleName();
  private Observer<List<AEEditorFilterBean>> a;
  protected Context a;
  protected SparseArray<Map<String, String>> a;
  protected FrameLayout a;
  protected TextView a;
  protected CustomHandler a;
  protected TextEditorData a;
  protected AEEditorAILoadingView a;
  protected DebugInfoPart a;
  protected AEEditorCheckGroupView a;
  protected AEEditorFilterControlPanel a;
  protected AEEditorTextControlPanel a;
  protected AEEditorTextPart a;
  public AEEditorTopBar a;
  protected boolean a;
  protected String b;
  protected boolean b;
  protected String c;
  
  static
  {
    jdField_a_of_type_Int = 5;
  }
  
  public AEEditorCommonEditFragment()
  {
    this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar = ((AEEditorTopBar)paramView.findViewById(2131379652));
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTitle(b());
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorTopBar.setTopBarClickListener(this);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView = ((AEEditorCheckGroupView)paramView.findViewById(2131364545));
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView.setOnCheckedChangeListener(new AEEditorCommonEditFragment.1(this));
    u();
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131367053));
  }
  
  private void e(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel = ((AEEditorFilterControlPanel)paramView.findViewById(2131366976));
    if ((this instanceof AEEditorVideoEditFragment))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setPageId(10002);
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterChangedComparator(a());
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a();
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(b());
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFilterControlListener(a());
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366991));
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel = ((AEEditorTextControlPanel)paramView.findViewById(2131379135));
      if (!(this instanceof AEEditorVideoEditFragment)) {
        break label179;
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setIsChooseImage(false);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setPageId(10002);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setTextStickerControlListener(this);
      this.jdField_a_of_type_AndroidArchLifecycleObserver = new AEEditorCommonEditFragment.4(this);
      AEEditorResourceManager.a().a().observeForever(this.jdField_a_of_type_AndroidArchLifecycleObserver);
      return;
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setPageId(10001);
      break;
      label179:
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setIsChooseImage(true);
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.setPageId(10001);
    }
  }
  
  private void f(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart = new AEEditorTextPart();
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(a());
  }
  
  private void g(View paramView) {}
  
  private void t()
  {
    if (AEEditorAILoadingView.a()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.11(this), 128, null, true);
  }
  
  private void u()
  {
    if (((this instanceof AEEditorImageEditFragment)) || (!e()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2131377163);
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditWidgetsAEEditorCheckGroupView.a(2131377155);
  }
  
  private void v()
  {
    if (AEEditorAutoTemplateLoadingView.a()) {
      return;
    }
    ThreadManager.excute(new AEEditorCommonEditFragment.12(this), 128, null, true);
  }
  
  protected abstract int a();
  
  protected abstract TAVCutSession a();
  
  protected abstract AEEditorFilterControlPanel.FilterControlListener a();
  
  protected abstract FilterChangedComparator a();
  
  protected abstract AEEditorTextPart.AEEditorTextDialogListener a();
  
  protected ArrayList<String> a(AIFilterResult paramAIFilterResult)
  {
    getResources().getString(2131718707);
    Object localObject = getResources().getString(2131718708);
    String str = getResources().getString(2131718708);
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult))
    {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689708), "", "");
      }
      return null;
    }
    if (paramAIFilterResult != null)
    {
      if (!TextUtils.isEmpty(paramAIFilterResult.a())) {
        paramAIFilterResult.a();
      }
      if ((paramAIFilterResult instanceof SingleImageAIFilterResult))
      {
        List localList = ((SingleImageAIFilterResult)paramAIFilterResult).a;
        if (localList != null) {
          if ((localList.size() > 0) && (localList.get(0) != null))
          {
            paramAIFilterResult = ((YoutuResultItem)localList.get(0)).Label;
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
      ((ArrayList)localObject).add(paramAIFilterResult);
      ((ArrayList)localObject).add(str);
      return localObject;
      continue;
      paramAIFilterResult = (AIFilterResult)localObject;
      break;
      paramAIFilterResult = (AIFilterResult)localObject;
    }
  }
  
  protected abstract void a(int paramInt);
  
  public void a(int paramInt, AEEditorTextBean paramAEEditorTextBean)
  {
    int i = 0;
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
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(localTAVCutSession, paramAEEditorTextBean, paramInt);
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
    if ((this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) && ("sticker_lyric".equals(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getStickerType())))
    {
      paramInt = i;
      if ((localTAVCutSession instanceof TAVCutImageSession)) {
        paramInt = ((TAVCutImageSession)localTAVCutSession).getCurrentIndex();
      }
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData = this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(localTAVCutSession, paramAEEditorTextBean, paramInt);
      return;
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
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setInteractive(paramAEEditorTextBean.interactive);
      if (paramAEEditorTextBean.type == 3)
      {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setBlurTextPath(paramAEEditorTextBean.blurTextPath);
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setBlurTexturePath(paramAEEditorTextBean.blurTexturePath);
        paramAEEditorTextBean.content = this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getContent();
      }
      String str = AEEditorResourceManager.a().a(paramAEEditorTextBean.fontId, 0);
      this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setFont(str);
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.setContent(paramAEEditorTextBean.content);
      }
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(localTAVCutSession, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
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
        paramAEEditorTextBean.blurTextPath = AEEditorResourceManager.a().f(paramAEEditorTextBean.id);
        paramAEEditorTextBean.blurTexturePath = AEEditorResourceManager.a().g(paramAEEditorTextBean.id);
      }
    }
    AEQLog.d(d, "[onTextStickerSelected] mCurrentTextEditorData == null");
  }
  
  protected void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (e())
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, List<StickerModel> paramList)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        if (((StickerModel)paramList.get(i)).getInteractive() > 0)
        {
          paramLocalMediaInfo.mKuolieId = ((StickerModel)paramList.get(i)).getMaterialId();
          paramLocalMediaInfo.mKuolieCenterX = ((StickerModel)paramList.get(i)).getCenterX();
          paramLocalMediaInfo.mKuolieCenterY = ((StickerModel)paramList.get(i)).getCenterY();
          paramLocalMediaInfo.mKuolieRotate = ((StickerModel)paramList.get(i)).getRotate();
          float f1 = ((StickerModel)paramList.get(i)).getScale();
          float f2 = paramLocalMediaInfo.mediaWidth * f1 * ((StickerModel)paramList.get(i)).getHeight() / ((StickerModel)paramList.get(i)).getWidth();
          paramLocalMediaInfo.mKuolieWidthScale = f1;
          paramLocalMediaInfo.mKuolieHeightScale = (f2 / paramLocalMediaInfo.mediaHeight);
          AEQLog.a(d, "[setKuolieData], localMediaInfo=" + paramLocalMediaInfo);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  protected void a(LocalMediaInfo paramLocalMediaInfo, List<StickerModel> paramList, List<AEEditorTextBean> paramList1)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return;
      }
      StickerModel localStickerModel = (StickerModel)paramList.next();
      Iterator localIterator = paramList1.iterator();
      if (localIterator.hasNext())
      {
        AEEditorTextBean localAEEditorTextBean = (AEEditorTextBean)localIterator.next();
        if (!localStickerModel.getMaterialId().equals(localAEEditorTextBean.id)) {
          break;
        }
        if (!paramLocalMediaInfo.mHashTagList.contains(localAEEditorTextBean.hashTag)) {
          paramLocalMediaInfo.mHashTagList.add(localAEEditorTextBean.hashTag);
        }
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
  
  protected void a(AIFilterResult paramAIFilterResult)
  {
    String str1 = getResources().getString(2131718707);
    Object localObject1 = getResources().getString(2131718708);
    String str2 = getResources().getString(2131718708);
    if ((paramAIFilterResult instanceof BatchImageAIFilterResult)) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(getResources().getString(2131689708), "", "");
    }
    label201:
    for (;;)
    {
      return;
      Object localObject2;
      if (paramAIFilterResult != null) {
        if (!TextUtils.isEmpty(paramAIFilterResult.a()))
        {
          str1 = paramAIFilterResult.a();
          localObject2 = localObject1;
          if ((paramAIFilterResult instanceof SingleImageAIFilterResult))
          {
            List localList = ((SingleImageAIFilterResult)paramAIFilterResult).a;
            localObject2 = localObject1;
            if (localList != null)
            {
              paramAIFilterResult = (AIFilterResult)localObject1;
              if (localList.size() > 0) {
                paramAIFilterResult = ((YoutuResultItem)localList.get(0)).Label;
              }
              localObject2 = paramAIFilterResult;
              if (localList.size() > 1)
              {
                localObject2 = ((YoutuResultItem)localList.get(1)).Label;
                localObject1 = paramAIFilterResult;
                paramAIFilterResult = (AIFilterResult)localObject2;
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
        this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setSceneText(str1, (String)localObject1, paramAIFilterResult);
        return;
        paramAIFilterResult = str2;
        localObject1 = localObject2;
        continue;
        break;
        paramAIFilterResult = str2;
      }
    }
  }
  
  protected void a(AEEditorTextBean paramAEEditorTextBean)
  {
    AEEditorPagStickerUtil.a(paramAEEditorTextBean, new AEEditorCommonEditFragment.8(this, new AEEditorCommonEditFragment.7(this)));
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
      AEQLog.d(d, "textEditorData null.");
      return;
    }
    switch (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getType())
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a(paramString2, this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData);
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
          AEQLog.d(d, "[onTextColorChoose] intelligent color bar is not ready");
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
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleDebugDebugInfoPart != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.5(this, paramString1, paramString2));
    }
  }
  
  protected void a(List<StickerModel> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (StickerModel)((Iterator)localObject).next();
      if (paramList.getInteractive() > 0)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("ext1", paramList.getMaterialId());
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 77, 2, 0, (HashMap)localObject, null, null);
      }
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
    AEBaseReportParam.a().a().jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramList);
    AEBaseReportParam.a().a().b.put(paramInt, localObject1);
  }
  
  protected abstract void a(boolean paramBoolean);
  
  protected void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleDebugDebugInfoPart != null) {
      ThreadManager.getUIHandler().post(new AEEditorCommonEditFragment.6(this, paramVarArgs));
    }
  }
  
  public boolean a()
  {
    Object localObject = getActivity();
    localObject = DialogUtil.a((Context)localObject, 230).setTitle(HardCodeUtil.a(2131689760)).setMessage(((Context)localObject).getString(2131689761)).setPositiveButton(((Context)localObject).getString(2131689715), new AEEditorCommonEditFragment.10(this)).setNegativeButton(((Context)localObject).getString(2131689713), new AEEditorCommonEditFragment.9(this));
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
  
  public boolean a(AEEditorTextBean paramAEEditorTextBean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData == null) && (paramAEEditorTextBean.id.startsWith("qiukuolie")) && (Integer.parseInt(paramAEEditorTextBean.interactive) > 0) && (a(paramAEEditorTextBean.id)))
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131693158), 0).a();
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) && (Integer.parseInt(this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData.getInteractive()) == 0) && (paramAEEditorTextBean.id.startsWith("qiukuolie")) && (Integer.parseInt(paramAEEditorTextBean.interactive) > 0) && (a(paramAEEditorTextBean.id)))
      {
        QQToast.a(getActivity(), getActivity().getResources().getString(2131693158), 0).a();
        return false;
      }
    }
    catch (Exception paramAEEditorTextBean)
    {
      AEQLog.a(d, "exception :", paramAEEditorTextBean);
    }
    return true;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  protected abstract int b();
  
  protected abstract String b();
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b()
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
  
  public void c(boolean paramBoolean) {}
  
  protected boolean c()
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
  
  protected abstract void d();
  
  protected void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a(paramBoolean);
  }
  
  protected boolean d()
  {
    return AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_TEMPLATE", true, 0);
  }
  
  protected abstract void e();
  
  protected final void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) {
      return;
    }
    if (paramBoolean) {
      d(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.c(paramBoolean);
      return;
      if (!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.a()) {
        d(false);
      }
    }
  }
  
  protected boolean e()
  {
    boolean bool = false;
    try
    {
      i = Integer.parseInt(QzoneConfig.getAEAutoTemplateMemoryLimit());
      if (i * 1024L * 1024L <= SystemUtil.a(getActivity())) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AEQLog.d(d, "parse auto template limit size error " + localException.getMessage());
        int i = 0;
      }
    }
  }
  
  protected abstract void f();
  
  protected final void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel == null) {
      return;
    }
    if (paramBoolean) {
      d(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b(paramBoolean);
      return;
      if (!this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.b()) {
        d(false);
      }
    }
  }
  
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
      AEQLog.a(d, "sendMessage");
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
    h();
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a();
  }
  
  public void j()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.a(null);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    if (this.jdField_a_of_type_ComTencentTavcutBeanTextEditorData != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.sendEmptyMessage(0);
    }
  }
  
  public void k()
  {
    d(false);
  }
  
  protected void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    if ((this instanceof AEEditorVideoEditFragment)) {}
    for (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAIVideoLoadingView(getActivity());; this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorAILoadingView(getActivity()))
    {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new AEEditorCommonEditFragment.2(this));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
      return;
    }
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView = new AEEditorComicLoadingView(getActivity());
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.setLoadingListener(new AEEditorCommonEditFragment.3(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView);
  }
  
  protected abstract void n();
  
  protected void o()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAEEditorAILoadingView.a();
    }
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AEQLog.b(d, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    AEEditorResourceManager.a().b();
    t();
    v();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AEQLog.b(d, "onCreateView");
    c();
    jdField_a_of_type_Int = OfflineConfig.getPhonePerfLevel(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler = new CustomHandler(Looper.getMainLooper(), this);
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    AEQLog.b(d, "onDestroyView");
    super.onDestroyView();
    AEEditorResourceManager.a().a().removeObserver(this.jdField_a_of_type_AndroidArchLifecycleObserver);
    this.jdField_a_of_type_ComTencentMobileqqUtilsCustomHandler.removeMessages(0);
    AEEditorTextControlPanel.f();
  }
  
  public void onPause()
  {
    AEQLog.b(d, "onPause");
    super.onPause();
    o();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    AEQLog.b(d, "onResume");
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextPart.a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AEQLog.b(d, "onViewCreated");
    super.onViewCreated(paramView, paramBundle);
    ((AEEditorDataServiceHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.e)).a("MqCircleEditor");
    this.jdField_b_of_type_JavaLangString = getArguments().getString("editor_filter_id");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      AEQLog.b(d, "jump from scheme, filterID=" + this.jdField_b_of_type_JavaLangString);
      getArguments().putString("editor_filter_id", "");
    }
    this.c = getArguments().getString("editor_text_sticker_id");
    if (!TextUtils.isEmpty(this.c))
    {
      AEQLog.b(d, "jump from scheme, schemeFilterId=" + this.c);
      getArguments().putString("editor_text_sticker_id", "");
    }
    g(paramView);
    b(paramView);
    d(paramView);
    e(paramView);
    f(paramView);
    c(paramView);
  }
  
  public void p()
  {
    a().a(getActivity(), true);
  }
  
  public void q()
  {
    o();
    g();
  }
  
  protected void r()
  {
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_TEMPLATE", false, 0);
  }
  
  protected void s()
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel != null) {
      this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment
 * JD-Core Version:    0.7.0.1
 */