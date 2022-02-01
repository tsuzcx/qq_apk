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
import com.tencent.mobileqq.search.rich.ArkRichNode;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.IRichNodeEvent;
import com.tencent.mobileqq.search.rich.IRichNodeView;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.lang.ref.WeakReference;

public class RichSearchResultPresenter
  extends SearchResultPresenter
  implements IRichNodeEvent
{
  private RichSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterRichSearchResultPresenter$OnActionListener = null;
  private WeakReference<GroupSearchAdapter> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  
  public RichSearchResultPresenter(IFaceDecoder paramIFaceDecoder, GroupSearchAdapter paramGroupSearchAdapter)
  {
    super(paramIFaceDecoder);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramGroupSearchAdapter);
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    paramISearchResultView = ((IRichNodeView)paramISearchResultView).a();
    paramISearchResultModel = (RichSearchModelNode)paramISearchResultModel;
    paramISearchResultView.a(paramISearchResultModel.c(), paramISearchResultModel.d(), paramISearchResultModel.e());
    paramISearchResultView.a(this);
    if ((paramISearchResultView instanceof ArkRichNode)) {
      ((ArkRichNode)paramISearchResultView).a(true);
    }
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView, Bitmap paramBitmap)
  {
    super.a(paramISearchResultModel, paramISearchResultView, paramBitmap);
  }
  
  public void a(IRichNode paramIRichNode)
  {
    a();
  }
  
  public void a(IRichNode paramIRichNode, String paramString1, String paramString2) {}
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterRichSearchResultPresenter$OnActionListener != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new RichSearchResultPresenter.1(this));
      }
    }
    else {
      super.c(paramISearchResultModel, paramISearchResultView);
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (!(paramISearchResultView instanceof IRichNodeView)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      a(paramISearchResultModel.b(), paramISearchResultModel.f_(), (IRichNodeView)paramISearchResultView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.RichSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */