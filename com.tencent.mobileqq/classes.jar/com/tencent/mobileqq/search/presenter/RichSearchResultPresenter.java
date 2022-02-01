package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.mobileqq.search.rich.ArkNodeView;
import com.tencent.mobileqq.search.rich.ArkRichNode;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.IRichNodeEvent;
import com.tencent.mobileqq.search.rich.IRichNodeView;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.mobileqq.search.view.RichTemplateOneSearchResultView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.lang.ref.WeakReference;

public class RichSearchResultPresenter
  extends SearchResultPresenter
  implements IRichNodeEvent
{
  private RichSearchResultPresenter.OnActionListener a = null;
  private boolean b = true;
  private WeakReference<GroupSearchAdapter> c;
  
  public RichSearchResultPresenter(IFaceDecoder paramIFaceDecoder, GroupSearchAdapter paramGroupSearchAdapter)
  {
    super(paramIFaceDecoder);
    this.c = new WeakReference(paramGroupSearchAdapter);
  }
  
  private void a()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = (GroupSearchAdapter)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((GroupSearchAdapter)localObject).notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, IRichNodeView paramIRichNodeView)
  {
    if (!(paramIRichNodeView instanceof RichNodeViewBase)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    paramIRichNodeView = (RichNodeViewBase)paramIRichNodeView;
    paramIRichNodeView.b(bool);
    if (paramInt1 == 1)
    {
      paramIRichNodeView.a(true);
      return;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        paramIRichNodeView.a(true);
        return;
      }
      paramIRichNodeView.a(true);
      return;
    }
    paramIRichNodeView.a(true);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if (!(paramISearchResultModel instanceof RichSearchModelNode)) {
      return;
    }
    if (!(paramISearchResultView instanceof IRichNodeView)) {
      return;
    }
    paramISearchResultView = ((IRichNodeView)paramISearchResultView).m();
    paramISearchResultModel = (RichSearchModelNode)paramISearchResultModel;
    paramISearchResultView.a(paramISearchResultModel.s(), paramISearchResultModel.t(), paramISearchResultModel.v());
    paramISearchResultView.a(this);
    if ((paramISearchResultView instanceof ArkRichNode)) {
      ((ArkRichNode)paramISearchResultView).a(true);
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
  }
  
  protected void a(ISearchResultPositionModel paramISearchResultPositionModel, ISearchResultView paramISearchResultView)
  {
    if ((paramISearchResultView instanceof ArkNodeView)) {
      ((ArkAppView)((ArkNodeView)paramISearchResultView).k()).setOnActionListener(new RichSearchResultPresenter.2(this, paramISearchResultPositionModel));
    }
    if ((paramISearchResultView instanceof RichTemplateOneSearchResultView))
    {
      paramISearchResultView = (RichTemplateOneSearchResultView)paramISearchResultView;
      paramISearchResultView.a(new RichSearchResultPresenter.3(this, paramISearchResultView, paramISearchResultPositionModel));
    }
  }
  
  public void a(IRichNode paramIRichNode)
  {
    a();
  }
  
  public void a(IRichNode paramIRichNode, String paramString1, String paramString2) {}
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.a != null)
    {
      if (paramISearchResultView.h() != null) {
        paramISearchResultView.h().setOnClickListener(new RichSearchResultPresenter.1(this));
      }
    }
    else
    {
      a((ISearchResultPositionModel)paramISearchResultModel, paramISearchResultView);
      super.c(paramISearchResultModel, paramISearchResultView);
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (!(paramISearchResultView instanceof IRichNodeView)) {
      return;
    }
    if (this.b) {
      a(paramISearchResultModel.ck_(), paramISearchResultModel.cl_(), (IRichNodeView)paramISearchResultView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.RichSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */