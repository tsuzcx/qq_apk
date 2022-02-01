package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.RichSearchModelNode;
import com.tencent.mobileqq.search.rich.ArkRichNode;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.IRichNodeEvent;
import com.tencent.mobileqq.search.rich.IRichNodeView;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.theme.ThemeUtil;
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    GroupSearchAdapter localGroupSearchAdapter;
    do
    {
      return;
      localGroupSearchAdapter = (GroupSearchAdapter)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localGroupSearchAdapter == null);
    localGroupSearchAdapter.notifyDataSetChanged();
  }
  
  private void a(int paramInt1, int paramInt2, IRichNodeView paramIRichNodeView)
  {
    if (!(paramIRichNodeView instanceof RichNodeViewBase)) {
      return;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    ((RichNodeViewBase)paramIRichNodeView).b(bool);
    if (paramInt1 == 1)
    {
      ((RichNodeViewBase)paramIRichNodeView).a(true);
      return;
    }
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      ((RichNodeViewBase)paramIRichNodeView).a(true);
      return;
    case 1: 
      ((RichNodeViewBase)paramIRichNodeView).a(true);
      return;
    }
    ((RichNodeViewBase)paramIRichNodeView).a(true);
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
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
    if (!(paramISearchResultModel instanceof RichSearchModelNode)) {}
    do
    {
      do
      {
        return;
      } while (!(paramISearchResultView instanceof IRichNodeView));
      paramISearchResultView = ((IRichNodeView)paramISearchResultView).a();
      paramISearchResultView.a(((RichSearchModelNode)paramISearchResultModel).c(), ((RichSearchModelNode)paramISearchResultModel).d(), ((RichSearchModelNode)paramISearchResultModel).e());
      paramISearchResultView.a(this);
    } while (!(paramISearchResultView instanceof ArkRichNode));
    ((ArkRichNode)paramISearchResultView).a(true);
  }
  
  protected void c(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchPresenterRichSearchResultPresenter$OnActionListener != null)
    {
      if (paramISearchResultView.a() != null) {
        paramISearchResultView.a().setOnClickListener(new RichSearchResultPresenter.1(this));
      }
      return;
    }
    super.c(paramISearchResultModel, paramISearchResultView);
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (!(paramISearchResultView instanceof IRichNodeView)) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    a(paramISearchResultModel.a(), paramISearchResultModel.b(), (IRichNodeView)paramISearchResultView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.RichSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */