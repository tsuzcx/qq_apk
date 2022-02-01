package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.KandianNegativeWindow;

class ReadInJoyHeaderPresenter$1
  implements View.OnClickListener
{
  ReadInJoyHeaderPresenter$1(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, IReadInJoyModel paramIReadInJoyModel, ReadInJoyView paramReadInJoyView) {}
  
  public void onClick(View paramView)
  {
    if (ReadInJoyHeaderPresenter.a(this.c) == null)
    {
      localObject = this.c;
      ReadInJoyHeaderPresenter.a((ReadInJoyHeaderPresenter)localObject, new KandianNegativeWindow(ReadInJoyHeaderPresenter.b((ReadInJoyHeaderPresenter)localObject)));
    }
    Object localObject = ReadInJoyHeaderPresenter.a(this.c);
    IReadInJoyModel localIReadInJoyModel = this.a;
    ((KandianNegativeWindow)localObject).a((ReadInJoyModelImpl)localIReadInJoyModel, localIReadInJoyModel.k().mDislikeInfos);
    ReadInJoyHeaderPresenter.a(this.c).a(paramView, new ReadInJoyHeaderPresenter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter.1
 * JD-Core Version:    0.7.0.1
 */