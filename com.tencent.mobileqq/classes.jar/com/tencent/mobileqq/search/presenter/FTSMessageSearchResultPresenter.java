package com.tencent.mobileqq.search.presenter;

import android.widget.TextView;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultDetailModel;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.FTSMessageSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.util.FaceDecoder;

public class FTSMessageSearchResultPresenter
  extends SearchResultPresenter
{
  public FTSMessageSearchResultPresenter(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public void a(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.a(paramISearchResultModel, paramISearchResultView);
    TextView localTextView;
    CharSequence localCharSequence;
    if ((paramISearchResultModel instanceof FTSEntitySearchResultModel))
    {
      FTSEntitySearchResultModel localFTSEntitySearchResultModel = (FTSEntitySearchResultModel)paramISearchResultModel;
      localTextView = ((FTSMessageSearchResultView)paramISearchResultView).a();
      paramISearchResultModel = ((FTSMessageSearchResultView)paramISearchResultView).b();
      paramISearchResultView = ((FTSMessageSearchResultView)paramISearchResultView).c();
      if (localTextView != null)
      {
        localCharSequence = localFTSEntitySearchResultModel.e();
        if (localCharSequence != null) {
          break label96;
        }
        localTextView.setText("");
        if (paramISearchResultView != null) {
          paramISearchResultView.setVisibility(8);
        }
      }
      if (paramISearchResultModel != null)
      {
        paramISearchResultView = localFTSEntitySearchResultModel.f();
        if (paramISearchResultView != null) {
          break label115;
        }
        paramISearchResultModel.setText("");
      }
    }
    label96:
    label115:
    do
    {
      do
      {
        return;
        localTextView.setText(localCharSequence);
        if (paramISearchResultView == null) {
          break;
        }
        paramISearchResultView.setVisibility(0);
        break;
        paramISearchResultModel.setText(paramISearchResultView);
        return;
      } while (!(paramISearchResultModel instanceof FTSEntitySearchResultDetailModel));
      paramISearchResultModel = (FTSEntitySearchResultDetailModel)paramISearchResultModel;
      paramISearchResultView = ((FTSMessageSearchResultView)paramISearchResultView).d();
    } while (paramISearchResultView == null);
    paramISearchResultModel = paramISearchResultModel.e();
    if (paramISearchResultModel == null)
    {
      paramISearchResultView.setText("");
      return;
    }
    paramISearchResultView.setText(paramISearchResultModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.FTSMessageSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */