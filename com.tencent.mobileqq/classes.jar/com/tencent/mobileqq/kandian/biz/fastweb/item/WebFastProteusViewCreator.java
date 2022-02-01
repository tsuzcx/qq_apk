package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusBookData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.widget.AbsListView;

public class WebFastProteusViewCreator
  implements IStateChangeListener, ItemCreator
{
  private static boolean c;
  private VafContext a;
  private AbsBaseArticleInfo b;
  private FastWebModule.FastWebArticleRichReqCallback d = new WebFastProteusViewCreator.1(this);
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      this.a = new ReadInjoyContext();
      this.a.setContext(paramContext);
    }
    if (this.b == null) {
      this.b = paramBaseData.aQ;
    }
    paramViewGroup = (ProteusBookData)paramBaseData;
    Container localContainer = this.a.getViewFactory().inflate(this.a, paramViewGroup.b);
    paramViewGroup = localContainer;
    if (localContainer == null) {
      paramViewGroup = new View(paramContext);
    }
    return new WebFastProteusViewCreator.TextViewHolder(paramViewGroup, paramBaseData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.aP == 18;
  }
  
  public int b(BaseData paramBaseData)
  {
    return 16;
  }
  
  public void b()
  {
    if (c)
    {
      c = false;
      FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
      if (localFastWebModule != null) {
        localFastWebModule.a(this.b, this.d, false);
      }
    }
  }
  
  public void c() {}
  
  public void d()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    if (localFastWebModule != null) {
      localFastWebModule.a(this.d);
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastProteusViewCreator
 * JD-Core Version:    0.7.0.1
 */