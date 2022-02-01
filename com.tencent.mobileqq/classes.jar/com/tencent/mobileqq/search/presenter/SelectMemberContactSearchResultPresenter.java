package com.tencent.mobileqq.search.presenter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.ContactSearchModelDiscussion;
import com.tencent.mobileqq.search.model.ContactSearchModelNewTroop;
import com.tencent.mobileqq.search.model.ContactSearchModelTroop;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.view.ContactSearchResultView;
import com.tencent.mobileqq.search.view.ISearchResultView;
import com.tencent.mobileqq.search.view.TroopAddFrdsSrchResultView;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import java.util.Set;

public class SelectMemberContactSearchResultPresenter
  extends ContactSearchResultPresenter
{
  private Set<String> b;
  
  public SelectMemberContactSearchResultPresenter(IFaceDecoder paramIFaceDecoder, ContactSearchResultPresenter.OnActionListener paramOnActionListener, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramIFaceDecoder, paramOnActionListener, paramSet1);
    this.b = paramSet2;
  }
  
  private void e(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    if (((paramISearchResultView instanceof ContactSearchResultView)) && ((paramISearchResultModel instanceof ContactSearchModelTroop)) && (((ContactSearchModelTroop)paramISearchResultModel).a == 3) && (paramISearchResultView.a() != null))
    {
      TextView localTextView = (TextView)paramISearchResultView.a().findViewById(2131376900);
      paramISearchResultModel = ((ContactSearchModelTroop)paramISearchResultModel).f();
      if ((localTextView != null) && (!TextUtils.isEmpty(paramISearchResultModel)))
      {
        localTextView.setVisibility(0);
        localTextView.setText(paramISearchResultModel);
      }
      paramISearchResultModel = paramISearchResultView.a();
      if (paramISearchResultModel != null)
      {
        paramISearchResultView = (RelativeLayout.LayoutParams)paramISearchResultModel.getLayoutParams();
        if (paramISearchResultView != null)
        {
          paramISearchResultView.addRule(15, 0);
          paramISearchResultModel.setLayoutParams(paramISearchResultView);
        }
      }
    }
  }
  
  public void b(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView)
  {
    super.b(paramISearchResultModel, paramISearchResultView);
    if (paramISearchResultView.c() != null)
    {
      localObject = paramISearchResultModel.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        paramISearchResultView.c().setText(HardCodeUtil.a(2131713679));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = RobotUtils.b((QQAppInterface)localObject, paramISearchResultModel.b());
    if ((localObject instanceof QQAppInterface))
    {
      if ((paramISearchResultView instanceof ContactSearchResultView)) {
        ((ContactSearchResultView)paramISearchResultView).a(bool);
      }
    }
    else if (paramISearchResultView.a() != null)
    {
      if ((!(paramISearchResultModel instanceof ContactSearchModelTroop)) && (!(paramISearchResultModel instanceof ContactSearchModelDiscussion)) && (!(paramISearchResultModel instanceof ContactSearchModelNewTroop))) {
        break label189;
      }
      if (paramISearchResultView.c() != null) {
        paramISearchResultView.c().setVisibility(8);
      }
      paramISearchResultView.a().setVisibility(0);
    }
    for (;;)
    {
      e(paramISearchResultModel, paramISearchResultView);
      return;
      if (!(paramISearchResultView instanceof TroopAddFrdsSrchResultView)) {
        break;
      }
      ((TroopAddFrdsSrchResultView)paramISearchResultView).a(bool);
      break;
      label189:
      if (paramISearchResultView.c() != null) {
        paramISearchResultView.c().setVisibility(0);
      }
      paramISearchResultView.a().setVisibility(8);
    }
  }
  
  public void d(ISearchResultModel paramISearchResultModel, ISearchResultView paramISearchResultView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SelectMemberContactSearchResultPresenter
 * JD-Core Version:    0.7.0.1
 */