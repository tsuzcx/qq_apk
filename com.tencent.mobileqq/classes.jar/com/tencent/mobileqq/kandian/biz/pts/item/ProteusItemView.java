package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.IPlayableView;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentLastRead;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentPGCShortContentBig;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyVideoView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.ProteusItemHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeVideoView;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusItemView
  extends RelativeLayout
  implements IPlayableView, IProteusItemView
{
  private ViewTreeObserver.OnGlobalLayoutListener jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ProteusItemView.3(this);
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private ComponentLastRead jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead;
  private final ProteusItemHelper jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper = new ProteusItemHelper(this);
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ProteusItemView.2(this);
  private List<ProteusItemView.OnItemDrawFinishedListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ProteusItemView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public static ReadInJoyVideoView a(Container paramContainer)
  {
    if (paramContainer != null)
    {
      paramContainer = paramContainer.getViewIdMapping().entrySet().iterator();
      while (paramContainer.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContainer.next();
        if (((localEntry.getValue() instanceof ReadInJoyVideoView)) && (((ViewBase)localEntry.getValue()).isVisible())) {
          return (ReadInJoyVideoView)localEntry.getValue();
        }
      }
    }
    return null;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if ((paramView instanceof ImageView))
    {
      paramView = (ImageView)paramView;
      if (paramBoolean)
      {
        paramView.setColorFilter(Color.parseColor("#e5e6e7"));
        return;
      }
      paramView.clearColorFilter();
    }
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, View paramView)
  {
    if (paramView == null)
    {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, view is null.");
      return;
    }
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null))
    {
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      if (TextUtils.isEmpty(paramIReadInJoyModel.proteusItemsData)) {
        return;
      }
      try
      {
        paramIReadInJoyModel = new JSONObject(paramIReadInJoyModel.proteusItemsData);
        Iterator localIterator = paramIReadInJoyModel.keys();
        String str;
        Object localObject;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          str = (String)localIterator.next();
          localObject = paramIReadInJoyModel.opt(str);
        } while (!"guide_card_type".equals(str));
        if ("1".equals(String.valueOf(localObject)))
        {
          QLog.d("ProteusItemView", 1, "one class flow guide card, show separator.");
          paramView.setVisibility(0);
          return;
        }
        QLog.d("ProteusItemView", 1, "flow guide card, hide separator.");
        paramView.setVisibility(8);
        return;
      }
      catch (Exception paramIReadInJoyModel)
      {
        QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, e = ", paramIReadInJoyModel);
        return;
      }
      catch (JSONException paramIReadInJoyModel)
      {
        QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator JSONException, e = ", paramIReadInJoyModel);
        return;
      }
    }
    else
    {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, model of articleInfo is null.");
    }
  }
  
  private void a(boolean paramBoolean, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {
      return;
    }
    if ((paramViewBase instanceof Layout))
    {
      paramViewBase = ((Layout)paramViewBase).getSubViews();
      if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
      {
        paramViewBase = paramViewBase.iterator();
        while (paramViewBase.hasNext()) {
          a(paramBoolean, (ViewBase)paramViewBase.next());
        }
      }
    }
    else
    {
      String str = paramViewBase.getViewId();
      if ((str != null) && ((str.startsWith("id_top_left_mask")) || (str.startsWith("id_bottom_left_mask")) || (str.startsWith("id_top_right_mask")) || (str.startsWith("id_bottom_right_mask")))) {
        a(paramViewBase.getNativeView(), paramBoolean);
      }
    }
  }
  
  private boolean a(VideoView paramVideoView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVideoView != null)
    {
      int i = paramVideoView.getCurrentState();
      bool1 = bool2;
      if (i != 9)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(ComponentPGCShortContentBig paramComponentPGCShortContentBig, int paramInt)
  {
    QLog.d("ProteusItemView", 2, "ComponentPGCShortContentBig");
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 6)
        {
          if (paramInt != 7) {
            return false;
          }
          paramComponentPGCShortContentBig.e();
          return false;
        }
        paramComponentPGCShortContentBig.c();
        return false;
      }
      paramComponentPGCShortContentBig.d();
      return false;
    }
    QLog.d("gifvideo.ProteusItemView", 2, "shortcontent to play");
    return paramComponentPGCShortContentBig.a();
  }
  
  private boolean a(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = (ReadInJoyVideoView)paramEntry.getValue();
    if (paramEntry.a() != null)
    {
      if (paramInt != 3) {
        if (paramInt != 5)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7)
            {
              if (paramInt != 8) {
                return false;
              }
            }
            else
            {
              paramEntry.a().destroy();
              return false;
            }
          }
          else
          {
            paramEntry.a().stop();
            return false;
          }
        }
        else
        {
          paramEntry.a().pause();
          return false;
        }
      }
      return paramEntry.a().startPlay(paramInt);
    }
    return false;
  }
  
  private boolean b(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper;
    if ((localObject1 != null) && (((ProteusItemHelper)localObject1).a() != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" proteusitemhelper celltype: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper.a().d());
      QLog.d("gifvideo.ProteusItemView", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      QLog.d("gifvideo.ProteusItemView", 2, "proteusitemhelper celltype: null");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      QLog.d("ProteusItemView", 1, "type pgc gif");
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_middle_body_content");
      Object localObject2;
      if ((localObject1 instanceof ReadInJoyMiddleBodyView))
      {
        QLog.d("ProteusItemView", 2, "ReadInJoyMiddleBodyView");
        localObject1 = ((ViewBase)localObject1).getNativeView();
        if ((localObject1 instanceof NativeMiddleBodyView))
        {
          QLog.d("ProteusItemView", 2, "NativeMiddleBodyView");
          localObject1 = ((NativeMiddleBodyView)localObject1).a();
          if ((localObject1 instanceof ComponentPGCShortContentBig)) {
            return a((ComponentPGCShortContentBig)localObject1, paramInt);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(" is not ComponentPGCShortContentBig");
          QLog.d("gifvideo.ProteusItemView", 2, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(" is not NativeMiddleBodyView");
          QLog.d("gifvideo.ProteusItemView", 2, ((StringBuilder)localObject2).toString());
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getViewIdMapping().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((((Map.Entry)localObject2).getValue() instanceof ReadInJoyVideoView)) {
          return a((Map.Entry)localObject2, paramInt);
        }
        if ((((Map.Entry)localObject2).getValue() instanceof RvPolymericContainer)) {
          return c((Map.Entry)localObject2, paramInt);
        }
      }
    }
    return false;
  }
  
  private boolean b(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = ((ViewBase)paramEntry.getValue()).getNativeView();
    if ((paramEntry instanceof NativeMiddleBodyView))
    {
      paramEntry = ((NativeMiddleBodyView)paramEntry).a();
      if ((paramEntry instanceof ComponentPGCShortContentBig)) {
        return a((ComponentPGCShortContentBig)paramEntry, paramInt);
      }
    }
    return false;
  }
  
  private boolean c(Map.Entry<String, ViewBase> paramEntry, int paramInt)
  {
    paramEntry = (RvPolymericContainer)paramEntry.getValue();
    if ((paramEntry.getNativeView() instanceof RelativeLayout))
    {
      paramEntry = (RelativeLayout)paramEntry.getNativeView();
      if ((paramEntry.getChildCount() > 0) && ((paramEntry.getChildAt(0) instanceof ProteusRecycleView)))
      {
        paramEntry = (ProteusRecycleView)paramEntry.getChildAt(0);
        int j = paramEntry.getChildCount();
        int i = 0;
        while (i < j)
        {
          if ((paramEntry.getChildAt(i) instanceof Container))
          {
            Iterator localIterator = ((Container)paramEntry.getChildAt(i)).getViewIdMapping().entrySet().iterator();
            while (localIterator.hasNext())
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              if ((localEntry.getValue() instanceof ReadInJoyVideoView)) {
                return a(localEntry, paramInt);
              }
              if ((localEntry.getValue() instanceof ReadInJoyMiddleBodyView)) {
                return b(localEntry, paramInt);
              }
            }
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    QLog.d("ProteusItemView", 2, "addDestroyObserver");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  private void f()
  {
    QLog.d("ProteusItemView", 2, "removeDestroyObserver");
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  private void g()
  {
    if (getViewTreeObserver() != null) {
      getViewTreeObserver().addOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  private void h()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (getViewTreeObserver() != null)) {
      getViewTreeObserver().removeOnGlobalLayoutListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener);
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public TemplateBean a()
  {
    Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
    if (localContainer != null) {
      return (TemplateBean)localContainer.getTag(2131376110);
    }
    return null;
  }
  
  public Container a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  }
  
  public ProteusItemHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper;
  }
  
  public AbsBaseArticleInfo a()
  {
    ProteusItemHelper localProteusItemHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper;
    if ((localProteusItemHelper != null) && (localProteusItemHelper.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper.a().a();
    }
    return null;
  }
  
  @Nullable
  public IReadInJoyModel a()
  {
    ProteusItemHelper localProteusItemHelper = a();
    if (localProteusItemHelper != null) {
      return localProteusItemHelper.a();
    }
    return null;
  }
  
  public void a()
  {
    b(6);
  }
  
  public void a(Container paramContainer)
  {
    Object localObject = paramContainer.getVirtualView().getComLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = paramContainer;
    paramContainer.setId(1);
    setBackgroundColor(getResources().getColor(2131167333));
    addView(paramContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  public void a(ProteusItemView.OnItemDrawFinishedListener paramOnItemDrawFinishedListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramOnItemDrawFinishedListener);
  }
  
  public boolean a()
  {
    return a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer) != null;
  }
  
  public boolean a(int paramInt)
  {
    return b(paramInt);
  }
  
  public void b()
  {
    b(5);
  }
  
  public void c()
  {
    removeAllViews();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = null;
  }
  
  public void d()
  {
    b(7);
    f();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.jdField_a_of_type_JavaUtilList;
    if ((paramCanvas != null) && (!paramCanvas.isEmpty()))
    {
      paramCanvas = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramCanvas.hasNext()) {
        ((ProteusItemView.OnItemDrawFinishedListener)paramCanvas.next()).a();
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h();
  }
  
  public void setInternalTag(int paramInt, @NotNull Object paramObject)
  {
    setTag(paramInt, paramObject);
  }
  
  public void setInternalTag(Object paramObject)
  {
    setTag(paramObject);
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel, OnLastReadRefreshListener paramOnLastReadRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewHelperProteusItemHelper.a(paramIReadInJoyModel);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead = new ComponentLastRead(getContext());
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 1);
      addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView().findViewBaseByName("id_separator");
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
    if ((localObject != null) && (((ViewBase)localObject).getNativeView() != null)) {
      if (paramIReadInJoyModel.g())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().setVisibility(0);
        a(paramIReadInJoyModel, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead.a(paramIReadInJoyModel);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentLastRead.a(new ProteusItemView.1(this, paramOnLastReadRefreshListener));
  }
  
  public void setPressed(boolean paramBoolean)
  {
    Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
    if (localContainer == null) {
      return;
    }
    a(paramBoolean, localContainer.getVirtualView());
    super.setPressed(paramBoolean);
  }
  
  public void setTemplateBean(TemplateBean paramTemplateBean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
    if (localObject != null)
    {
      ((Container)localObject).setTag(2131376110, paramTemplateBean);
      setPressed(false);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setTemplateBean : ");
    ((StringBuilder)localObject).append(paramTemplateBean);
    QLog.d("TemplateFactory", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView
 * JD-Core Version:    0.7.0.1
 */