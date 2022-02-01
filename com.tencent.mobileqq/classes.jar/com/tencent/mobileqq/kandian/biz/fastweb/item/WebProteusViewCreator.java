package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.data.ProteusAnimationItemData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class WebProteusViewCreator
  implements IStateChangeListener, ItemCreator
{
  private VafContext a;
  private Context b;
  private BaseAdapter c;
  private final Map<String, Integer> d = new ConcurrentHashMap();
  
  public WebProteusViewCreator(VafContext paramVafContext)
  {
    this.a = paramVafContext;
    f();
  }
  
  private void a(Container paramContainer)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      if (localViewBase != null)
      {
        paramContainer = localViewBase.findViewBaseByName("id_large_video_icon");
        localViewBase = localViewBase.findViewBaseByName("id_video_bg");
        boolean bool = NetworkState.isWifiConn();
        int i = 0;
        int j = 8;
        if (!bool)
        {
          i = 8;
          j = 0;
        }
        if (paramContainer != null) {
          paramContainer.setVisibility(i);
        }
        if (localViewBase != null) {
          localViewBase.setVisibility(j);
        }
      }
    }
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.b == null) {
      this.b = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    Object localObject1 = null;
    paramViewGroup = (ViewGroup)localObject1;
    String str;
    try
    {
      if (localProteusItemData.bd == null)
      {
        paramViewGroup = (ViewGroup)localObject1;
        localProteusItemData.b(localProteusItemData.bb);
        paramViewGroup = (ViewGroup)localObject1;
        localProteusItemData.a(TemplateFactory.a("native_article", true));
      }
      paramViewGroup = (ViewGroup)localObject1;
      localObject1 = this.a.getViewFactory().inflate(this.a, localProteusItemData.bd);
      paramViewGroup = (ViewGroup)localObject1;
      ProteusSupportUtil.a(((Container)localObject1).getVirtualView(), localProteusItemData.bd.getViewBean());
      paramViewGroup = (ViewGroup)localObject1;
      localObject2 = localProteusItemData.bb.toString();
      paramViewGroup = (ViewGroup)localObject1;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("error!! msg=");
      ((StringBuilder)localObject2).append(localException.toString());
      str = ((StringBuilder)localObject2).toString();
    }
    boolean bool = false;
    Object localObject2 = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject2 = new View(paramContext);
      bool = true;
    }
    paramContext = new StringBuilder();
    paramContext.append("createViewHolder viewIsNull=");
    paramContext.append(bool);
    paramContext.append("  proteusData=");
    paramContext.append(str);
    QLog.d("WebProteusViewCreator", 1, paramContext.toString());
    if ((paramBaseData instanceof ProteusAnimationItemData)) {
      ((ProteusAnimationItemData)paramBaseData).a((View)localObject2);
    }
    return new WebProteusViewCreator.ProteusItemViewHolder(this, (View)localObject2, localProteusItemData);
  }
  
  public void a() {}
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.c = paramBaseAdapter;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    int i = paramBaseData.aP;
    return (i == 0) || (i == 6) || (i == 23) || (i == 25) || (i == 26);
  }
  
  public int b(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusItemData))
    {
      paramBaseData = (ProteusItemData)paramBaseData;
      if (paramBaseData.bd != null)
      {
        paramBaseData = paramBaseData.bd.getStyleName();
        Object localObject = (Integer)this.d.get(paramBaseData);
        if (localObject != null) {
          return ((Integer)localObject).intValue();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getViewType error,styleName:");
        ((StringBuilder)localObject).append(paramBaseData);
        QLog.d("WebProteusViewCreator", 1, ((StringBuilder)localObject).toString());
      }
    }
    return -1;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    try
    {
      ProteusSupportUtil.a(this.a, "native_article");
      Object localObject1 = this.a.getTemplateFactory().getNameTemplateMap().keySet();
      BaseItemViewHolder.e = 32;
      int i = BaseItemViewHolder.e + 1;
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!this.d.containsKey(localObject2))
        {
          this.d.put(localObject2, Integer.valueOf(i));
          i += 1;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("VIEW_TYPE_COUNT=");
      ((StringBuilder)localObject1).append(BaseItemViewHolder.e);
      ((StringBuilder)localObject1).append(",NAME_VIEWTYPE_MAP size=");
      ((StringBuilder)localObject1).append(this.d.size());
      ((StringBuilder)localObject1).append("type=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("WebProteusViewCreator", 1, ((StringBuilder)localObject1).toString());
      BaseItemViewHolder.e += this.d.size() + 1;
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initProteusTypeCount error,msg:");
      ((StringBuilder)localObject2).append(localException.toString());
      QLog.d("WebProteusViewCreator", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebProteusViewCreator
 * JD-Core Version:    0.7.0.1
 */