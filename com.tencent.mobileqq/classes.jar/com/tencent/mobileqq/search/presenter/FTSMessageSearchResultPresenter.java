package com.tencent.mobileqq.search.presenter;

import android.widget.TextView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.base.presenter.SearchResultPresenter;
import com.tencent.mobileqq.search.base.view.ISearchResultView;
import com.tencent.mobileqq.search.business.fts.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;

public class FTSMessageSearchResultPresenter
  extends SearchResultPresenter
{
  public FTSMessageSearchResultPresenter(IFaceDecoder paramIFaceDecoder)
  {
    super(paramIFaceDecoder);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    if ((paramISearchResultModel instanceof FTSEntitySearchResultModel))
    {
      paramISearchResultModel = (FTSEntitySearchResultModel)paramISearchResultModel;
      Object localObject = (FTSMessageSearchResultView)paramISearchResultView;
      TextView localTextView = ((FTSMessageSearchResultView)localObject).j();
      paramISearchResultView = ((FTSMessageSearchResultView)localObject).k();
      localObject = ((FTSMessageSearchResultView)localObject).l();
      if (localTextView != null)
      {
        CharSequence localCharSequence = paramISearchResultModel.i();
        if (localCharSequence == null)
        {
          localTextView.setText("");
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        else
        {
          localTextView.setText(localCharSequence);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
      }
      if (paramISearchResultView != null)
      {
        paramISearchResultModel = paramISearchResultModel.j();
        if (paramISearchResultModel == null)
        {
          paramISearchResultView.setText("");
          return;
        }
        paramISearchResultView.setText(paramISearchResultModel);
      }
    }
    else if ((paramISearchResultModel instanceof FTSEntitySearchResultDetailModel))
    {
      paramISearchResultModel = (FTSEntitySearchResultDetailModel)paramISearchResultModel;
      paramISearchResultView = ((FTSMessageSearchResultView)paramISearchResultView).m();
      if (paramISearchResultView != null)
      {
        paramISearchResultModel = paramISearchResultModel.i();
        if (paramISearchResultModel == null)
        {
          paramISearchResultView.setText("");
          return;
        }
        paramISearchResultView.setText(paramISearchResultModel);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */