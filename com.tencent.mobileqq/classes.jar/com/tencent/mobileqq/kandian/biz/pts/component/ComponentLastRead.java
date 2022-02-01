package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public class ComponentLastRead
  extends LinearLayout
  implements ComponentView
{
  CmpCtxt a;
  private Container b;
  private View c;
  private Context d;
  
  public ComponentLastRead(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentLastRead(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (this.b != null) {
      return;
    }
    int i = paramIReadInJoyModel.m();
    if ((i != 0) && (!DailyModeConfigHandler.c(i))) {
      return;
    }
    paramIReadInJoyModel = paramIReadInJoyModel.t();
    if (paramIReadInJoyModel == null) {
      return;
    }
    Object localObject = paramIReadInJoyModel.getTemplateFactory();
    if (localObject == null) {
      return;
    }
    if (!((BaseTemplateFactory)localObject).hasTemplate("ReadInjoy_last_read_cell")) {
      return;
    }
    localObject = ((BaseTemplateFactory)localObject).getTemplate("ReadInjoy_last_read_cell");
    if (localObject != null)
    {
      this.b = paramIReadInJoyModel.getViewFactory().inflate(paramIReadInJoyModel, (TemplateBean)localObject);
      if (this.b != null)
      {
        removeAllViews();
        paramIReadInJoyModel = this.b.getVirtualView().getComLayoutParams();
        paramIReadInJoyModel = new RelativeLayout.LayoutParams(paramIReadInJoyModel.mLayoutWidth, paramIReadInJoyModel.mLayoutHeight);
        addView(this.b, paramIReadInJoyModel);
      }
    }
  }
  
  private void b(Context paramContext)
  {
    this.a = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      CmpCtxt localCmpCtxt = this.a;
      paramObject = (IReadInJoyModel)paramObject;
      localCmpCtxt.a(paramObject);
      b();
      if (this.a.a.i())
      {
        a(paramObject);
        if (this.b == null)
        {
          paramObject = this.d;
          if ((paramObject != null) && (this.c == null))
          {
            this.c = LayoutInflater.from(paramObject).inflate(2131626198, null, false);
            setBackgroundResource(2131167849);
            addView(this.c);
          }
        }
        setVisibility(0);
        setOnClickListener(new ComponentLastRead.1(this));
        ThreadManager.executeOnSubThread(new ComponentLastRead.2(this));
        return;
      }
      setVisibility(8);
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentLastRead
 * JD-Core Version:    0.7.0.1
 */