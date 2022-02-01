package com.tencent.mobileqq.search.adapter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.filemanager.data.search.FileSearchResultGroupPresenter;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.base.presenter.EntranceResultPresenter;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.presenter.IPresenter;
import com.tencent.mobileqq.search.base.presenter.SearchResultGroupFooterViewPresenter;
import com.tencent.mobileqq.search.base.view.IFaceView;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.search.base.view.SearchResultEntranceView;
import com.tencent.mobileqq.search.base.view.SearchResultGroupView;
import com.tencent.mobileqq.search.base.view.SearchResultView;
import com.tencent.mobileqq.search.business.contact.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.business.contact.view.ContactSearchResultGroupView;
import com.tencent.mobileqq.search.business.function.view.FunctionSearchResultGroupView;
import com.tencent.mobileqq.search.business.group.model.GroupNetSearchModelArticle;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalGuild;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMoreItem;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.business.group.model.SearchResultGroupModelImpl;
import com.tencent.mobileqq.search.business.group.presenter.EmptyViewPresenter;
import com.tencent.mobileqq.search.business.group.view.EmptyResultView;
import com.tencent.mobileqq.search.business.group.view.SearchResultGroupFooterView;
import com.tencent.mobileqq.search.business.group.view.SearchResultGroupMoreItemView;
import com.tencent.mobileqq.search.business.group.view.SearchResultGroupTitleView;
import com.tencent.mobileqq.search.business.miniprogram.view.MiniProgramSearchResultGroupView;
import com.tencent.mobileqq.search.business.mostused.view.MostUsedSearchResultGroupView;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateAvatarsView;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBannerTitleView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateBigImageView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateFriendUpdatesView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateMiniAppView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateTitleView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUniversalView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateUpdatesView;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroop;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.presenter.ActiveEntitySearchResultPresenter;
import com.tencent.mobileqq.search.presenter.ContactSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.FunctionSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.MiniProgramSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.MostUseResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.PublicAcntSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.RichSearchResultPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMessagePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupMorePresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupPresenter;
import com.tencent.mobileqq.search.presenter.SearchResultGroupTitlePresenter;
import com.tencent.mobileqq.search.presenter.SearchTemplatePresenter;
import com.tencent.mobileqq.search.rich.ArkRichNode;
import com.tencent.mobileqq.search.rich.IRichNode;
import com.tencent.mobileqq.search.rich.IRichNodeView;
import com.tencent.mobileqq.search.rich.RichNodeController;
import com.tencent.mobileqq.search.rich.RichNodeFactory;
import com.tencent.mobileqq.search.rich.RichNodeViewBase;
import com.tencent.mobileqq.search.view.ApproximateSearchResultGroupView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorSlidingContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateIndividuateContainerView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNetSeaEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateNewEntranceView;
import com.tencent.mobileqq.search.view.NetSearchTemplateQAView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemTitleView;
import com.tencent.mobileqq.search.view.NetSearchTemplateSubItemView;
import com.tencent.mobileqq.search.view.SearchResultFromNetView;
import com.tencent.mobileqq.search.view.SearchResultGroupFTSMessageView;
import com.tencent.mobileqq.search.view.SearchResultGroupMessageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import cooperation.qqfav.globalsearch.FavoriteSearchResultGroupPresenter;
import java.util.List;

public class GroupSearchAdapter
  extends BaseMvpAdapter
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a = 0;
  public int b = -1;
  private IFaceDecoder c;
  private ListView d;
  private AbsListView.OnScrollListener e;
  private boolean f;
  private RichNodeController g = new RichNodeController();
  
  public GroupSearchAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    this.d = paramListView;
    this.c = paramIFaceDecoder;
    paramIFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
    this.e = paramOnScrollListener;
    this.b = paramInt;
  }
  
  private void a(int paramInt, View paramView, IModel paramIModel)
  {
    if (paramView != null)
    {
      if (paramIModel == null) {
        return;
      }
      if (!(paramIModel instanceof RichSearchModelNode)) {
        return;
      }
      paramIModel = (IView)paramView.getTag(2131449873);
      paramView = null;
      if ((paramIModel instanceof IRichNodeView)) {
        paramView = ((IRichNodeView)paramIModel).m();
      }
      if (paramView == null) {
        return;
      }
      this.g.a(paramInt, paramView);
    }
  }
  
  private boolean a(View paramView, IModel paramIModel)
  {
    if (paramView != null)
    {
      if (paramIModel == null) {
        return false;
      }
      if ((paramIModel instanceof RichSearchModelNode))
      {
        IView localIView = (IView)paramView.getTag(2131449873);
        paramView = null;
        if ((localIView instanceof IRichNodeView)) {
          paramView = ((IRichNodeView)localIView).m();
        }
        if (paramView == null) {
          return false;
        }
        paramIModel = (RichSearchModelNode)paramIModel;
        if ((paramIModel.r() == paramView.i()) && (paramIModel.w() == paramView.d()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, "reuse contentview");
          }
        }
        else {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, IModel paramIModel, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramInt2 == 59)
    {
      Object localObject2 = null;
      if (paramView != null)
      {
        paramView = (IView)paramView.getTag(2131449873);
        if ((paramView instanceof IRichNodeView))
        {
          paramView = (IRichNodeView)paramView;
          break label41;
        }
      }
      paramView = null;
      label41:
      if ((paramView != null) && ((paramView instanceof RichNodeViewBase))) {
        if (paramInt1 == 0)
        {
          ((RichNodeViewBase)paramView).a(false);
        }
        else if (paramInt1 == 1)
        {
          Object localObject3 = c(paramInt1 - 1);
          Object localObject1 = localObject2;
          if ((localObject3 instanceof GroupSearchModeTitle))
          {
            localObject3 = (GroupSearchModeTitle)localObject3;
            localObject1 = localObject2;
            if (!((GroupSearchModeTitle)localObject3).b) {
              localObject1 = ((GroupSearchModeTitle)localObject3).k().b();
            }
          }
          if ((paramIModel != null) && (localObject1 != null) && (((List)localObject1).contains(paramIModel))) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (paramInt2 != 0) {
            ((RichNodeViewBase)paramView).a(false);
          }
        }
      }
    }
    if (paramInt1 >= 1)
    {
      if (paramInt3 != 59) {
        return paramBoolean;
      }
      paramView = d(paramInt1 - 1);
      if (((paramView instanceof ArkRichNode)) && (((ArkRichNode)paramView).a() == 1)) {
        return true;
      }
    }
    return paramBoolean;
  }
  
  private IRichNode d(int paramInt)
  {
    IModel localIModel = c(paramInt);
    if (localIModel == null) {
      return null;
    }
    if (!(localIModel instanceof IRichNode)) {
      return null;
    }
    return (IRichNode)localIModel;
  }
  
  protected IPresenter a(int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new SearchResultGroupPresenter(this.c);
    case 60: 
      return new MostUseResultGroupPresenter(this.c);
    case 59: 
      return new RichSearchResultPresenter(this.c, this);
    case 57: 
      return new EmptyViewPresenter();
    case 56: 
      return new MiniProgramSearchResultGroupPresenter(this.c);
    case 49: 
      return new SearchResultGroupFooterViewPresenter();
    case 46: 
      return new PublicAcntSearchResultPresenter(this.c);
    case 41: 
      return new FunctionSearchResultGroupPresenter(this.c);
    case 38: 
    case 39: 
    case 42: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 61: 
    case 62: 
    case 63: 
      return new SearchTemplatePresenter(this.c, this);
    case 29: 
    case 30: 
    case 36: 
      return new EntranceResultPresenter();
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
    case 64: 
      return new ActiveEntitySearchResultPresenter(this.c, b(paramInt), this);
    case 16: 
      return new SearchResultGroupPresenter(this.c);
    case 15: 
      return new SearchResultGroupTitlePresenter();
    case 14: 
      return new SearchResultGroupMorePresenter();
    case 13: 
      return new ContactSearchResultGroupPresenter(this.c);
    case 12: 
      return new SearchResultGroupMessagePresenter(this.c, true);
    case 11: 
      return new FileSearchResultGroupPresenter(this.c);
    case 10: 
      return new FavoriteSearchResultGroupPresenter();
    case 9: 
      return new SearchResultGroupMorePresenter();
    case 3: 
      return new SearchResultGroupMessagePresenter(this.c, false);
    case 2: 
    case 8: 
      return new PublicAcntSearchResultGroupPresenter(this.c);
    }
    return new SearchResultGroupTitlePresenter();
  }
  
  protected IView a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 18: 
    case 20: 
    case 28: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 37: 
    case 43: 
    case 58: 
    default: 
      return new SearchResultGroupView(paramViewGroup, 2131629225);
    case 60: 
      return new MostUsedSearchResultGroupView(paramViewGroup, 2131629232);
    case 59: 
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = c(paramInt);
      localObject2 = RichNodeFactory.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (IModel)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof RichSearchModelNode))) {
        ((RichSearchModelNode)localObject1).c(((IRichNode)localObject2).d());
      }
      if (localObject2 == null) {
        return new EmptyResultView(paramViewGroup);
      }
      return ((IRichNode)localObject2).h();
    case 57: 
      return new EmptyResultView(paramViewGroup);
    case 56: 
      return new MiniProgramSearchResultGroupView(paramViewGroup, 2131629231);
    case 49: 
      return new SearchResultGroupFooterView(paramViewGroup);
    case 46: 
      return new SearchResultView(paramViewGroup, 2131625657);
    case 41: 
      return new FunctionSearchResultGroupView(paramViewGroup);
    case 38: 
    case 39: 
    case 42: 
    case 44: 
    case 45: 
    case 47: 
    case 48: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 55: 
    case 61: 
    case 62: 
    case 63: 
      localObject1 = c(paramInt);
      if ((localObject1 instanceof NetSearchTemplateBaseItem))
      {
        localObject1 = (NetSearchTemplateBaseItem)localObject1;
        switch (((NetSearchTemplateBaseItem)localObject1).m())
        {
        case 5: 
        case 10: 
        default: 
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("NetSearchTemplateBaseItem.getLayoutId() is ");
          paramViewGroup.append(((NetSearchTemplateBaseItem)localObject1).n());
          paramViewGroup.append(" which is not supported!!!");
          throw new RuntimeException(paramViewGroup.toString());
        case 19: 
          return new NetSearchTemplateIndividuateContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 18: 
          return new NetSearchTemplateMiniAppView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 17: 
          return new NetSearchTemplateNewEntranceView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 16: 
          return new NetSearchTemplateNetSeaEntranceView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 15: 
          return new NetSearchTemplateQAView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 14: 
          return new NetSearchTemplateTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 13: 
          return new NetSearchTemplateHorSlidingContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 12: 
          return new NetSearchTemplateBigImageView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 11: 
          return new NetSearchTemplateFriendUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 9: 
          return new NetSearchTemplateSubItemTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 8: 
          return new NetSearchTemplateSubItemView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 7: 
          return new NetSearchTemplateHorizontalContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 6: 
          return new NetSearchTemplateUniversalView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 4: 
          return new NetSearchTemplateBannerTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        case 3: 
          return new NetSearchTemplateUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
        }
        return new NetSearchTemplateAvatarsView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).n());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
    case 29: 
    case 30: 
    case 36: 
      localObject1 = c(paramInt);
      if ((localObject1 instanceof SearchResultModelForEntrance)) {
        return new SearchResultEntranceView(paramViewGroup, ((SearchResultModelForEntrance)localObject1).j());
      }
      throw new RuntimeException("model type is TYPE_UNITE_ENTRANCE_SUB_ITEM_COMMON_TEXT, but model item is not instance SearchResultModelForEntrance.");
    case 21: 
    case 22: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 27: 
    case 31: 
    case 40: 
    case 64: 
      return new SearchResultFromNetView(paramViewGroup, b(paramInt));
    case 19: 
      return new ApproximateSearchResultGroupView(paramViewGroup, 2131629277);
    case 17: 
      return new SearchResultGroupView(paramViewGroup, 2131629233);
    case 16: 
      return new SearchResultGroupView(paramViewGroup, 2131629226);
    case 14: 
      return new SearchResultGroupMoreItemView(paramViewGroup, 2131629245, 2130847686, 12);
    case 12: 
      return new SearchResultGroupFTSMessageView(paramViewGroup);
    case 10: 
      return new SearchResultView(paramViewGroup, 2131625875);
    case 9: 
      return new SearchResultGroupMoreItemView(paramViewGroup, 2131629245, 2130847686, -1);
    case 3: 
      return new SearchResultGroupMessageView(paramViewGroup);
    case 2: 
      return new SearchResultGroupView(paramViewGroup, 2131625656);
    case 1: 
    case 13: 
      return new ContactSearchResultGroupView(paramViewGroup, 2131629229);
    }
    Object localObject1 = c(paramInt);
    boolean bool1 = localObject1 instanceof GroupSearchModeTitle;
    boolean bool2 = false;
    if (bool1) {
      bool1 = ((GroupSearchModeTitle)localObject1).f();
    } else {
      bool1 = false;
    }
    if (paramInt != 0) {
      bool2 = true;
    }
    return new SearchResultGroupTitleView(paramViewGroup, bool2, bool1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int b(int paramInt)
  {
    Object localObject;
    if ((c(paramInt) instanceof GroupBaseNetSearchModel))
    {
      localObject = (GroupBaseNetSearchModel)c(paramInt);
      if (localObject != null) {
        return ((GroupBaseNetSearchModel)localObject).e();
      }
    }
    else if ((c(paramInt) instanceof GroupBaseNetSearchModelItem))
    {
      localObject = (GroupBaseNetSearchModelItem)c(paramInt);
      if (localObject != null) {
        return ((GroupBaseNetSearchModelItem)localObject).j();
      }
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((super.c(paramInt) instanceof GroupSearchModelFunction)) {
      return 41;
    }
    if ((super.c(paramInt) instanceof GroupSearchModelMessage)) {
      return 3;
    }
    if ((super.c(paramInt) instanceof FTSGroupSearchModelMessage)) {
      return 12;
    }
    Object localObject;
    if (((super.c(paramInt) instanceof GroupSearchModeTitle)) && (this.b != 12))
    {
      localObject = (GroupSearchModeTitle)super.c(paramInt);
      if ((localObject != null) && (((GroupSearchModeTitle)localObject).b)) {
        return 0;
      }
      return 57;
    }
    if (((super.c(paramInt) instanceof GroupSearchModeTitle)) && (this.b == 12))
    {
      localObject = (GroupSearchModeTitle)super.c(paramInt);
      if ((localObject != null) && (((GroupSearchModeTitle)localObject).b)) {
        return 15;
      }
      return 57;
    }
    if ((super.c(paramInt) instanceof GroupSearchModelFooter))
    {
      localObject = (GroupSearchModelFooter)super.c(paramInt);
      if ((localObject != null) && (((GroupSearchModelFooter)localObject).c)) {
        return 49;
      }
      return 57;
    }
    if ((super.c(paramInt) instanceof GroupSearchModelPublicAcnt)) {
      return 2;
    }
    if ((super.c(paramInt) instanceof GroupNetSearchModelPeople)) {
      return 5;
    }
    if ((super.c(paramInt) instanceof GroupSearchModelMiniProgram)) {
      return 56;
    }
    if ((super.c(paramInt) instanceof GroupNetSearchModelTroop)) {
      return 6;
    }
    if ((super.c(paramInt) instanceof GroupSearchModelMostUsed)) {
      return 60;
    }
    if ((super.c(paramInt) instanceof GroupNetSearchModelPublicAcnt)) {
      return 8;
    }
    if ((super.c(paramInt) instanceof GroupNetSearchModelArticle)) {
      return 16;
    }
    if (((super.c(paramInt) instanceof GroupSearchModelMoreItem)) && (this.b != 12)) {
      return 9;
    }
    if (((super.c(paramInt) instanceof GroupSearchModelMoreItem)) && (this.b == 12)) {
      return 14;
    }
    if ((c(paramInt) instanceof GroupSearchModelFavorite)) {
      return 10;
    }
    if ((c(paramInt) instanceof GroupSearchModelFileEntity)) {
      return 11;
    }
    if ((!(super.c(paramInt) instanceof GroupSearchModelLocalContact)) && (!(super.c(paramInt) instanceof GroupSearchModelLocalTroop)) && (!(super.c(paramInt) instanceof GroupSearchModelLocalGuild)))
    {
      if ((c(paramInt) instanceof GroupSearchModelMultiChat)) {
        return 17;
      }
      if ((c(paramInt) instanceof GroupSearchModelLocalContactApproximate)) {
        return 19;
      }
      if ((c(paramInt) instanceof RichSearchModelNode)) {
        return 59;
      }
      if ((c(paramInt) instanceof GroupBaseNetSearchModelItem))
      {
        localObject = (GroupBaseNetSearchModelItem)c(paramInt);
        if (localObject == null) {
          return 25;
        }
        paramInt = ((GroupBaseNetSearchModelItem)localObject).j();
        if (paramInt != 1001)
        {
          if (paramInt != 1002)
          {
            if (paramInt != 1107)
            {
              if (paramInt != 268435456) {
                return 25;
              }
              return 26;
            }
            return 64;
          }
          return 22;
        }
        return 21;
      }
      if ((c(paramInt) instanceof SearchResultModelForEntrance))
      {
        localObject = (SearchResultModelForEntrance)c(paramInt);
        if (localObject == null) {
          return 29;
        }
        paramInt = ((SearchResultModelForEntrance)localObject).c;
        if (paramInt != -4)
        {
          if (paramInt != -3)
          {
            if (paramInt != -1) {}
            return 29;
          }
          return 30;
        }
        return 36;
      }
      if ((c(paramInt) instanceof NetSearchTemplateBaseItem))
      {
        localObject = (NetSearchTemplateBaseItem)c(paramInt);
        if (localObject == null) {
          return 45;
        }
        switch (((NetSearchTemplateBaseItem)localObject).m())
        {
        case 5: 
        case 10: 
        default: 
          return 45;
        case 19: 
          return 63;
        case 18: 
          return 62;
        case 17: 
          return 61;
        case 16: 
          return 55;
        case 15: 
          return 54;
        case 14: 
          return 53;
        case 13: 
          return 52;
        case 12: 
          return 51;
        case 11: 
          return 50;
        case 9: 
          return 48;
        case 8: 
          return 47;
        case 7: 
          return 44;
        case 6: 
          return 45;
        case 4: 
          return 42;
        case 3: 
          return 39;
        }
        return 38;
      }
      if ((c(paramInt) instanceof PublicAccountSearchResultModel)) {
        return 46;
      }
      return 4;
    }
    return 13;
  }
  
  /* Error */
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual 112	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:c	(I)Lcom/tencent/mobileqq/search/model/IModel;
    //   5: astore 20
    //   7: aload 20
    //   9: invokestatic 459	com/tencent/mobileqq/search/SearchUtil:a	(Lcom/tencent/mobileqq/search/model/IModel;)I
    //   12: istore 4
    //   14: ldc_w 461
    //   17: astore 13
    //   19: ldc_w 463
    //   22: astore 11
    //   24: ldc 98
    //   26: astore 12
    //   28: iload 4
    //   30: ifle +1102 -> 1132
    //   33: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   36: aload 20
    //   38: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   41: ifeq +302 -> 343
    //   44: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   47: aload 20
    //   49: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   55: astore 8
    //   57: aload 8
    //   59: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   62: ifne +281 -> 343
    //   65: aload 8
    //   67: iconst_1
    //   68: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   71: new 484	org/json/JSONObject
    //   74: dup
    //   75: invokespecial 485	org/json/JSONObject:<init>	()V
    //   78: astore 9
    //   80: aload 9
    //   82: ldc_w 487
    //   85: invokestatic 491	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   88: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload 9
    //   94: ldc_w 497
    //   97: ldc_w 499
    //   100: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload 9
    //   106: ldc_w 501
    //   109: ldc_w 503
    //   112: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 9
    //   118: ldc_w 461
    //   121: aload 8
    //   123: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   126: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: goto +42 -> 172
    //   133: astore 10
    //   135: new 276	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   142: astore 14
    //   144: aload 14
    //   146: ldc_w 463
    //   149: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 14
    //   155: aload 10
    //   157: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 98
    //   163: iconst_2
    //   164: aload 14
    //   166: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 512	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   175: invokevirtual 228	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   178: checkcast 230	com/tencent/mobileqq/app/QQAppInterface
    //   181: astore 10
    //   183: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   186: dup
    //   187: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   190: ldc_w 517
    //   193: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   196: ldc_w 523
    //   199: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   202: astore 14
    //   204: new 276	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   211: astore 15
    //   213: aload 15
    //   215: aload 8
    //   217: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   220: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 15
    //   226: ldc_w 534
    //   229: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 14
    //   235: aload 15
    //   237: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   243: aload 8
    //   245: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   248: invokevirtual 543	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   251: aload 8
    //   253: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   256: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   259: aload_0
    //   260: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   263: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   266: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   269: aload 9
    //   271: invokevirtual 555	org/json/JSONObject:toString	()Ljava/lang/String;
    //   274: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   277: astore 9
    //   279: new 276	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   286: astore 14
    //   288: aload 14
    //   290: aload 10
    //   292: invokevirtual 561	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   295: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 14
    //   301: getstatic 563	com/tencent/mobileqq/search/util/SearchUtils:j	J
    //   304: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 10
    //   310: aload 9
    //   312: aload 14
    //   314: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokevirtual 566	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   320: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   323: aload 8
    //   325: iconst_1
    //   326: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   329: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   332: aload 20
    //   334: aload 8
    //   336: invokevirtual 572	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: goto +3 -> 343
    //   343: ldc_w 499
    //   346: astore 8
    //   348: ldc_w 501
    //   351: astore 9
    //   353: ldc_w 523
    //   356: astore 10
    //   358: aload 13
    //   360: astore 15
    //   362: aload 11
    //   364: astore 19
    //   366: aload 12
    //   368: astore 14
    //   370: aload 10
    //   372: astore 18
    //   374: aload 9
    //   376: astore 17
    //   378: aload 8
    //   380: astore 16
    //   382: aload 20
    //   384: instanceof 122
    //   387: ifeq +718 -> 1105
    //   390: aload 20
    //   392: checkcast 122	com/tencent/mobileqq/search/model/ISearchResultGroupModel
    //   395: astore 22
    //   397: aload 22
    //   399: invokevirtual 125	com/tencent/mobileqq/search/model/ISearchResultGroupModel:b	()Ljava/util/List;
    //   402: astore 21
    //   404: aload 13
    //   406: astore 15
    //   408: aload 11
    //   410: astore 19
    //   412: aload 12
    //   414: astore 14
    //   416: aload 10
    //   418: astore 18
    //   420: aload 9
    //   422: astore 17
    //   424: aload 8
    //   426: astore 16
    //   428: aload 21
    //   430: ifnull +675 -> 1105
    //   433: aload 13
    //   435: astore 15
    //   437: aload 11
    //   439: astore 19
    //   441: aload 12
    //   443: astore 14
    //   445: aload 10
    //   447: astore 18
    //   449: aload 9
    //   451: astore 17
    //   453: aload 8
    //   455: astore 16
    //   457: aload 21
    //   459: invokeinterface 575 1 0
    //   464: ifle +641 -> 1105
    //   467: aload 21
    //   469: invokeinterface 575 1 0
    //   474: aload 22
    //   476: invokevirtual 576	com/tencent/mobileqq/search/model/ISearchResultGroupModel:d	()I
    //   479: invokestatic 582	java/lang/Math:min	(II)I
    //   482: istore 4
    //   484: iconst_0
    //   485: istore 5
    //   487: aload 13
    //   489: astore 15
    //   491: aload 11
    //   493: astore 19
    //   495: aload 12
    //   497: astore 14
    //   499: aload 10
    //   501: astore 18
    //   503: aload 9
    //   505: astore 17
    //   507: aload 8
    //   509: astore 16
    //   511: iload 5
    //   513: iload 4
    //   515: if_icmpge +590 -> 1105
    //   518: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   521: aload 21
    //   523: iload 5
    //   525: invokeinterface 584 2 0
    //   530: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   533: ifeq +563 -> 1096
    //   536: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   539: aload 21
    //   541: iload 5
    //   543: invokeinterface 584 2 0
    //   548: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   551: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   554: astore 15
    //   556: aload 15
    //   558: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   561: ifne +535 -> 1096
    //   564: aload 15
    //   566: iconst_1
    //   567: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   570: new 484	org/json/JSONObject
    //   573: dup
    //   574: invokespecial 485	org/json/JSONObject:<init>	()V
    //   577: astore 16
    //   579: aload 16
    //   581: ldc_w 487
    //   584: invokestatic 491	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   587: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   590: pop
    //   591: aload 16
    //   593: ldc_w 497
    //   596: aload 8
    //   598: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   601: pop
    //   602: aload 16
    //   604: aload 9
    //   606: ldc_w 503
    //   609: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   612: pop
    //   613: aload 16
    //   615: aload 13
    //   617: aload 15
    //   619: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   622: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   625: pop
    //   626: goto +51 -> 677
    //   629: astore 14
    //   631: goto +10 -> 641
    //   634: astore 14
    //   636: goto +5 -> 641
    //   639: astore 14
    //   641: new 276	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   648: astore 17
    //   650: aload 17
    //   652: aload 11
    //   654: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: aload 17
    //   660: aload 14
    //   662: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 12
    //   668: iconst_2
    //   669: aload 17
    //   671: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 512	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload 21
    //   679: iload 5
    //   681: invokeinterface 584 2 0
    //   686: instanceof 586
    //   689: ifeq +230 -> 919
    //   692: aload 21
    //   694: iload 5
    //   696: invokeinterface 584 2 0
    //   701: checkcast 586	com/tencent/mobileqq/search/model/MiniProgramSearchResultModel
    //   704: astore 17
    //   706: aload 17
    //   708: invokevirtual 589	com/tencent/mobileqq/search/model/MiniProgramSearchResultModel:x	()Z
    //   711: ifeq +11 -> 722
    //   714: ldc_w 591
    //   717: astore 14
    //   719: goto +8 -> 727
    //   722: ldc_w 593
    //   725: astore 14
    //   727: aload 15
    //   729: aload 17
    //   731: invokevirtual 596	com/tencent/mobileqq/search/model/MiniProgramSearchResultModel:s	()Ljava/lang/String;
    //   734: putfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   737: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   740: invokevirtual 228	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   743: checkcast 230	com/tencent/mobileqq/app/QQAppInterface
    //   746: astore 17
    //   748: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   751: dup
    //   752: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   755: ldc_w 517
    //   758: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   761: aload 10
    //   763: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   766: astore 18
    //   768: new 276	java/lang/StringBuilder
    //   771: dup
    //   772: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   775: astore 19
    //   777: aload 19
    //   779: aload 15
    //   781: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   784: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload 19
    //   790: ldc_w 534
    //   793: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload 18
    //   799: aload 19
    //   801: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   807: aload 15
    //   809: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   812: invokevirtual 543	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   815: aload 15
    //   817: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   820: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   823: aload_0
    //   824: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   827: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   830: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   833: aload 14
    //   835: invokevirtual 599	com/tencent/mobileqq/search/report/ReportModelDC02528:ver3	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   838: aload 16
    //   840: invokevirtual 555	org/json/JSONObject:toString	()Ljava/lang/String;
    //   843: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   846: astore 14
    //   848: new 276	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   855: astore 16
    //   857: aload 16
    //   859: aload 17
    //   861: invokevirtual 561	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   864: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: pop
    //   868: aload 16
    //   870: getstatic 563	com/tencent/mobileqq/search/util/SearchUtils:j	J
    //   873: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload 17
    //   879: aload 14
    //   881: aload 16
    //   883: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: invokevirtual 566	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   889: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   892: aload 15
    //   894: iconst_1
    //   895: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   898: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   901: aload 21
    //   903: iload 5
    //   905: invokeinterface 584 2 0
    //   910: aload 15
    //   912: invokevirtual 572	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   915: pop
    //   916: goto +180 -> 1096
    //   919: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   922: invokevirtual 228	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   925: checkcast 230	com/tencent/mobileqq/app/QQAppInterface
    //   928: astore 14
    //   930: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   933: dup
    //   934: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   937: ldc_w 517
    //   940: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   943: aload 10
    //   945: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   948: astore 17
    //   950: new 276	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   957: astore 18
    //   959: aload 18
    //   961: aload 15
    //   963: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   966: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: aload 18
    //   972: ldc_w 534
    //   975: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 17
    //   981: aload 18
    //   983: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   989: aload 15
    //   991: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   994: invokevirtual 543	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   997: aload 15
    //   999: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   1002: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1005: aload_0
    //   1006: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   1009: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   1012: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1015: aload 16
    //   1017: invokevirtual 555	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1020: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1023: astore 16
    //   1025: new 276	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1032: astore 17
    //   1034: aload 17
    //   1036: aload 14
    //   1038: invokevirtual 561	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1041: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload 17
    //   1047: getstatic 563	com/tencent/mobileqq/search/util/SearchUtils:j	J
    //   1050: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload 14
    //   1056: aload 16
    //   1058: aload 17
    //   1060: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokevirtual 566	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1066: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   1069: aload 15
    //   1071: iconst_1
    //   1072: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   1075: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1078: aload 21
    //   1080: iload 5
    //   1082: invokeinterface 584 2 0
    //   1087: aload 15
    //   1089: invokevirtual 572	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1092: pop
    //   1093: goto +3 -> 1096
    //   1096: iload 5
    //   1098: iconst_1
    //   1099: iadd
    //   1100: istore 5
    //   1102: goto -615 -> 487
    //   1105: aload 19
    //   1107: astore 12
    //   1109: aload 18
    //   1111: astore 13
    //   1113: aload 17
    //   1115: astore 8
    //   1117: aload 16
    //   1119: astore 11
    //   1121: aload 15
    //   1123: astore 9
    //   1125: aload 14
    //   1127: astore 10
    //   1129: goto +32 -> 1161
    //   1132: ldc_w 461
    //   1135: astore 9
    //   1137: ldc_w 501
    //   1140: astore 8
    //   1142: ldc_w 499
    //   1145: astore 11
    //   1147: ldc_w 463
    //   1150: astore 12
    //   1152: ldc 98
    //   1154: astore 10
    //   1156: ldc_w 523
    //   1159: astore 13
    //   1161: aload_0
    //   1162: astore 17
    //   1164: aload 20
    //   1166: instanceof 399
    //   1169: ifeq +402 -> 1571
    //   1172: aload 20
    //   1174: checkcast 399	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   1177: astore 16
    //   1179: aload 16
    //   1181: invokevirtual 600	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:b	()Ljava/util/List;
    //   1184: ifnull +384 -> 1568
    //   1187: aload 16
    //   1189: invokevirtual 600	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:b	()Ljava/util/List;
    //   1192: invokeinterface 575 1 0
    //   1197: ifle +371 -> 1568
    //   1200: iconst_0
    //   1201: istore 4
    //   1203: aload 8
    //   1205: astore 14
    //   1207: aload 11
    //   1209: astore 15
    //   1211: aload 9
    //   1213: astore 8
    //   1215: aload 16
    //   1217: astore 11
    //   1219: iload 4
    //   1221: aload 11
    //   1223: invokevirtual 600	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:b	()Ljava/util/List;
    //   1226: invokeinterface 575 1 0
    //   1231: if_icmpge +337 -> 1568
    //   1234: aload 11
    //   1236: invokevirtual 600	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:b	()Ljava/util/List;
    //   1239: iload 4
    //   1241: invokeinterface 584 2 0
    //   1246: checkcast 602	com/tencent/mobileqq/search/model/IModel
    //   1249: astore 9
    //   1251: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1254: aload 9
    //   1256: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1259: ifeq +300 -> 1559
    //   1262: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1265: aload 9
    //   1267: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1270: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   1273: astore 16
    //   1275: aload 16
    //   1277: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   1280: ifne +279 -> 1559
    //   1283: aload 16
    //   1285: iconst_1
    //   1286: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   1289: new 484	org/json/JSONObject
    //   1292: dup
    //   1293: invokespecial 485	org/json/JSONObject:<init>	()V
    //   1296: astore 18
    //   1298: aload 18
    //   1300: ldc_w 487
    //   1303: invokestatic 491	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   1306: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1309: pop
    //   1310: aload 18
    //   1312: ldc_w 497
    //   1315: aload 15
    //   1317: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1320: pop
    //   1321: aload 18
    //   1323: aload 14
    //   1325: ldc_w 604
    //   1328: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1331: pop
    //   1332: aload 16
    //   1334: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   1337: istore 5
    //   1339: aload 18
    //   1341: aload 8
    //   1343: iload 5
    //   1345: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1348: pop
    //   1349: goto +56 -> 1405
    //   1352: astore 9
    //   1354: goto +15 -> 1369
    //   1357: astore 9
    //   1359: goto +10 -> 1369
    //   1362: astore 9
    //   1364: goto +5 -> 1369
    //   1367: astore 9
    //   1369: new 276	java/lang/StringBuilder
    //   1372: dup
    //   1373: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1376: astore 19
    //   1378: aload 19
    //   1380: aload 12
    //   1382: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload 19
    //   1388: aload 9
    //   1390: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1393: pop
    //   1394: aload 10
    //   1396: iconst_2
    //   1397: aload 19
    //   1399: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: invokestatic 512	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1405: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1408: invokevirtual 228	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1411: checkcast 230	com/tencent/mobileqq/app/QQAppInterface
    //   1414: astore 9
    //   1416: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   1419: dup
    //   1420: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   1423: ldc_w 517
    //   1426: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1429: aload 13
    //   1431: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1434: astore 19
    //   1436: new 276	java/lang/StringBuilder
    //   1439: dup
    //   1440: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1443: astore 21
    //   1445: aload 21
    //   1447: aload 16
    //   1449: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   1452: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload 21
    //   1458: ldc_w 534
    //   1461: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: pop
    //   1465: aload 19
    //   1467: aload 21
    //   1469: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1472: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1475: aload 16
    //   1477: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   1480: invokevirtual 543	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1483: aload 16
    //   1485: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   1488: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1491: aload 17
    //   1493: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   1496: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   1499: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1502: aload 18
    //   1504: invokevirtual 555	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1507: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1510: astore 16
    //   1512: new 276	java/lang/StringBuilder
    //   1515: dup
    //   1516: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1519: astore 18
    //   1521: aload 18
    //   1523: aload 9
    //   1525: invokevirtual 561	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1528: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: pop
    //   1532: aload 18
    //   1534: getstatic 563	com/tencent/mobileqq/search/util/SearchUtils:j	J
    //   1537: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1540: pop
    //   1541: aload 9
    //   1543: aload 16
    //   1545: aload 18
    //   1547: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1550: invokevirtual 566	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1553: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   1556: goto +3 -> 1559
    //   1559: iload 4
    //   1561: iconst_1
    //   1562: iadd
    //   1563: istore 4
    //   1565: goto -346 -> 1219
    //   1568: goto +1395 -> 2963
    //   1571: aload 10
    //   1573: astore 16
    //   1575: aload 20
    //   1577: instanceof 606
    //   1580: ifeq +393 -> 1973
    //   1583: aload 20
    //   1585: checkcast 606	com/tencent/mobileqq/search/model/NetSearchTemplateHorizontalContainerItem
    //   1588: getfield 609	com/tencent/mobileqq/search/model/NetSearchTemplateHorizontalContainerItem:c	Ljava/util/ArrayList;
    //   1591: astore 10
    //   1593: aload 10
    //   1595: ifnull -27 -> 1568
    //   1598: aload 10
    //   1600: invokevirtual 615	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1603: astore 14
    //   1605: aload 12
    //   1607: astore 15
    //   1609: aload 9
    //   1611: astore 10
    //   1613: aload 16
    //   1615: astore 12
    //   1617: aload 14
    //   1619: invokeinterface 620 1 0
    //   1624: ifeq -56 -> 1568
    //   1627: aload 14
    //   1629: invokeinterface 624 1 0
    //   1634: checkcast 626	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem
    //   1637: astore 16
    //   1639: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1642: aload 16
    //   1644: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1647: ifeq +323 -> 1970
    //   1650: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1653: aload 16
    //   1655: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1658: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   1661: astore 18
    //   1663: aload 18
    //   1665: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   1668: ifne +302 -> 1970
    //   1671: aload 18
    //   1673: iconst_1
    //   1674: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   1677: new 484	org/json/JSONObject
    //   1680: dup
    //   1681: invokespecial 485	org/json/JSONObject:<init>	()V
    //   1684: astore 19
    //   1686: aload 19
    //   1688: ldc_w 487
    //   1691: invokestatic 491	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   1694: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1697: pop
    //   1698: aload 19
    //   1700: ldc_w 497
    //   1703: aload 11
    //   1705: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1708: pop
    //   1709: aload 19
    //   1711: aload 8
    //   1713: ldc_w 604
    //   1716: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1719: pop
    //   1720: aload 18
    //   1722: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   1725: istore 4
    //   1727: aload 19
    //   1729: aload 10
    //   1731: iload 4
    //   1733: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1736: pop
    //   1737: aload 19
    //   1739: ldc_w 628
    //   1742: aload 16
    //   1744: getfield 630	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:d	Ljava/lang/String;
    //   1747: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1750: pop
    //   1751: aload 19
    //   1753: ldc_w 632
    //   1756: aload 16
    //   1758: getfield 634	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:l	Ljava/lang/String;
    //   1761: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1764: pop
    //   1765: goto +51 -> 1816
    //   1768: astore 9
    //   1770: goto +10 -> 1780
    //   1773: astore 9
    //   1775: goto +5 -> 1780
    //   1778: astore 9
    //   1780: new 276	java/lang/StringBuilder
    //   1783: dup
    //   1784: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1787: astore 21
    //   1789: aload 21
    //   1791: aload 15
    //   1793: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: aload 21
    //   1799: aload 9
    //   1801: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1804: pop
    //   1805: aload 12
    //   1807: iconst_2
    //   1808: aload 21
    //   1810: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: invokestatic 512	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1816: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1819: invokevirtual 228	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1822: checkcast 230	com/tencent/mobileqq/app/QQAppInterface
    //   1825: astore 9
    //   1827: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   1830: dup
    //   1831: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   1834: ldc_w 517
    //   1837: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1840: aload 13
    //   1842: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1845: astore 21
    //   1847: new 276	java/lang/StringBuilder
    //   1850: dup
    //   1851: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1854: astore 22
    //   1856: aload 22
    //   1858: aload 16
    //   1860: getfield 636	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:i	J
    //   1863: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1866: pop
    //   1867: aload 22
    //   1869: ldc_w 534
    //   1872: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1875: pop
    //   1876: aload 21
    //   1878: aload 22
    //   1880: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1886: aload 16
    //   1888: getfield 637	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:e	Ljava/lang/String;
    //   1891: invokevirtual 543	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1894: aload 18
    //   1896: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   1899: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1902: aload 17
    //   1904: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   1907: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   1910: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1913: aload 19
    //   1915: invokevirtual 555	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1918: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1921: astore 16
    //   1923: new 276	java/lang/StringBuilder
    //   1926: dup
    //   1927: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   1930: astore 18
    //   1932: aload 18
    //   1934: aload 9
    //   1936: invokevirtual 561	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1939: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1942: pop
    //   1943: aload 18
    //   1945: getstatic 563	com/tencent/mobileqq/search/util/SearchUtils:j	J
    //   1948: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1951: pop
    //   1952: aload 9
    //   1954: aload 16
    //   1956: aload 18
    //   1958: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1961: invokevirtual 566	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1964: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   1967: goto +3 -> 1970
    //   1970: goto -353 -> 1617
    //   1973: aload 20
    //   1975: instanceof 639
    //   1978: ifeq +295 -> 2273
    //   1981: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1984: aload 20
    //   1986: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1989: ifeq -421 -> 1568
    //   1992: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   1995: aload 20
    //   1997: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2000: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   2003: astore 8
    //   2005: aload 20
    //   2007: checkcast 639	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem
    //   2010: astore 9
    //   2012: aload 8
    //   2014: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2017: ifne -449 -> 1568
    //   2020: aload 8
    //   2022: iconst_1
    //   2023: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2026: new 276	java/lang/StringBuilder
    //   2029: dup
    //   2030: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2033: astore 10
    //   2035: aload 9
    //   2037: getfield 643	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:t	Ljava/util/List;
    //   2040: ifnull +120 -> 2160
    //   2043: aload 9
    //   2045: getfield 643	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:t	Ljava/util/List;
    //   2048: invokeinterface 575 1 0
    //   2053: ifle +107 -> 2160
    //   2056: iconst_0
    //   2057: istore 4
    //   2059: iload 4
    //   2061: aload 9
    //   2063: getfield 643	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:t	Ljava/util/List;
    //   2066: invokeinterface 575 1 0
    //   2071: if_icmpge +89 -> 2160
    //   2074: iload 4
    //   2076: aload 9
    //   2078: getfield 643	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:t	Ljava/util/List;
    //   2081: invokeinterface 575 1 0
    //   2086: iconst_1
    //   2087: isub
    //   2088: if_icmpeq +39 -> 2127
    //   2091: aload 10
    //   2093: aload 9
    //   2095: getfield 643	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:t	Ljava/util/List;
    //   2098: iload 4
    //   2100: invokeinterface 584 2 0
    //   2105: checkcast 645	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem
    //   2108: getfield 647	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem:b	Ljava/lang/String;
    //   2111: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: pop
    //   2115: aload 10
    //   2117: ldc_w 649
    //   2120: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2123: pop
    //   2124: goto +27 -> 2151
    //   2127: aload 10
    //   2129: aload 9
    //   2131: getfield 643	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:t	Ljava/util/List;
    //   2134: iload 4
    //   2136: invokeinterface 584 2 0
    //   2141: checkcast 645	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem
    //   2144: getfield 647	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem:b	Ljava/lang/String;
    //   2147: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2150: pop
    //   2151: iload 4
    //   2153: iconst_1
    //   2154: iadd
    //   2155: istore 4
    //   2157: goto -98 -> 2059
    //   2160: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2163: dup
    //   2164: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2167: ldc_w 517
    //   2170: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2173: ldc_w 651
    //   2176: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2179: ldc_w 653
    //   2182: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2185: aload 8
    //   2187: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   2190: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2193: aload 17
    //   2195: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2198: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2201: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2204: aload 10
    //   2206: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2209: invokevirtual 656	com/tencent/mobileqq/search/report/ReportModelDC02528:ver4	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2212: ldc_w 591
    //   2215: invokevirtual 659	com/tencent/mobileqq/search/report/ReportModelDC02528:ver5	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2218: astore 8
    //   2220: new 276	java/lang/StringBuilder
    //   2223: dup
    //   2224: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2227: astore 9
    //   2229: aload 9
    //   2231: ldc_w 661
    //   2234: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: pop
    //   2238: aload 9
    //   2240: getstatic 662	com/tencent/mobileqq/search/report/UniteSearchReportController:b	Ljava/lang/String;
    //   2243: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2246: pop
    //   2247: aload 9
    //   2249: ldc_w 664
    //   2252: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: pop
    //   2256: aconst_null
    //   2257: aload 8
    //   2259: aload 9
    //   2261: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2264: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2267: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2270: goto -702 -> 1568
    //   2273: aload 20
    //   2275: instanceof 272
    //   2278: ifeq +11 -> 2289
    //   2281: aload 20
    //   2283: instanceof 666
    //   2286: ifeq +32 -> 2318
    //   2289: aload 20
    //   2291: instanceof 403
    //   2294: ifne +24 -> 2318
    //   2297: aload 20
    //   2299: instanceof 352
    //   2302: ifeq -734 -> 1568
    //   2305: aload 20
    //   2307: checkcast 352	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance
    //   2310: getfield 448	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:c	I
    //   2313: bipush 252
    //   2315: if_icmpne -747 -> 1568
    //   2318: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   2321: aload 20
    //   2323: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2326: ifeq -758 -> 1568
    //   2329: getstatic 469	com/tencent/mobileqq/search/util/SearchUtils:l	Ljava/util/HashMap;
    //   2332: aload 20
    //   2334: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2337: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   2340: astore 10
    //   2342: aload 20
    //   2344: instanceof 668
    //   2347: ifeq +329 -> 2676
    //   2350: aload 20
    //   2352: checkcast 668	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem
    //   2355: astore 14
    //   2357: aload 10
    //   2359: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2362: ifne +314 -> 2676
    //   2365: aload 10
    //   2367: iconst_1
    //   2368: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2371: new 276	java/lang/StringBuilder
    //   2374: dup
    //   2375: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2378: astore 15
    //   2380: aload 14
    //   2382: getfield 669	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:t	Ljava/util/List;
    //   2385: ifnull +186 -> 2571
    //   2388: aload 14
    //   2390: getfield 669	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:t	Ljava/util/List;
    //   2393: invokeinterface 575 1 0
    //   2398: ifle +173 -> 2571
    //   2401: iconst_0
    //   2402: istore 4
    //   2404: iload 4
    //   2406: aload 14
    //   2408: getfield 669	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:t	Ljava/util/List;
    //   2411: invokeinterface 575 1 0
    //   2416: if_icmpge +45 -> 2461
    //   2419: aload 15
    //   2421: aload 14
    //   2423: getfield 669	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:t	Ljava/util/List;
    //   2426: iload 4
    //   2428: invokeinterface 584 2 0
    //   2433: checkcast 671	com/tencent/mobileqq/search/business/net/model/RelativeWord
    //   2436: getfield 672	com/tencent/mobileqq/search/business/net/model/RelativeWord:a	Ljava/lang/String;
    //   2439: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2442: pop
    //   2443: aload 15
    //   2445: ldc_w 649
    //   2448: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2451: pop
    //   2452: iload 4
    //   2454: iconst_1
    //   2455: iadd
    //   2456: istore 4
    //   2458: goto -54 -> 2404
    //   2461: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2464: dup
    //   2465: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2468: ldc_w 517
    //   2471: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2474: ldc_w 674
    //   2477: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2480: ldc_w 676
    //   2483: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2486: aload 10
    //   2488: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   2491: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2494: aload 17
    //   2496: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2499: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2502: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2505: aload 15
    //   2507: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2510: invokevirtual 656	com/tencent/mobileqq/search/report/ReportModelDC02528:ver4	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2513: ldc_w 591
    //   2516: invokevirtual 659	com/tencent/mobileqq/search/report/ReportModelDC02528:ver5	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2519: astore 14
    //   2521: new 276	java/lang/StringBuilder
    //   2524: dup
    //   2525: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2528: astore 15
    //   2530: aload 15
    //   2532: ldc_w 661
    //   2535: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2538: pop
    //   2539: aload 15
    //   2541: getstatic 662	com/tencent/mobileqq/search/report/UniteSearchReportController:b	Ljava/lang/String;
    //   2544: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2547: pop
    //   2548: aload 15
    //   2550: ldc_w 664
    //   2553: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2556: pop
    //   2557: aconst_null
    //   2558: aload 14
    //   2560: aload 15
    //   2562: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2565: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2568: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2571: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2574: dup
    //   2575: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2578: ldc_w 517
    //   2581: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2584: ldc_w 651
    //   2587: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2590: ldc_w 653
    //   2593: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2596: aload 10
    //   2598: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   2601: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2604: aload 17
    //   2606: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2609: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2612: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2615: ldc_w 678
    //   2618: invokevirtual 659	com/tencent/mobileqq/search/report/ReportModelDC02528:ver5	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2621: astore 14
    //   2623: new 276	java/lang/StringBuilder
    //   2626: dup
    //   2627: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2630: astore 15
    //   2632: aload 15
    //   2634: ldc_w 661
    //   2637: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2640: pop
    //   2641: aload 15
    //   2643: getstatic 662	com/tencent/mobileqq/search/report/UniteSearchReportController:b	Ljava/lang/String;
    //   2646: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2649: pop
    //   2650: aload 15
    //   2652: ldc_w 664
    //   2655: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2658: pop
    //   2659: aconst_null
    //   2660: aload 14
    //   2662: aload 15
    //   2664: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2667: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2670: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2673: goto +3 -> 2676
    //   2676: aload 10
    //   2678: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2681: ifne +282 -> 2963
    //   2684: aload 10
    //   2686: iconst_1
    //   2687: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2690: new 484	org/json/JSONObject
    //   2693: dup
    //   2694: invokespecial 485	org/json/JSONObject:<init>	()V
    //   2697: astore 14
    //   2699: aload 14
    //   2701: ldc_w 487
    //   2704: invokestatic 491	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   2707: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2710: pop
    //   2711: aload 14
    //   2713: ldc_w 497
    //   2716: aload 11
    //   2718: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2721: pop
    //   2722: aload 14
    //   2724: aload 8
    //   2726: ldc_w 604
    //   2729: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2732: pop
    //   2733: aload 14
    //   2735: aload 9
    //   2737: aload 10
    //   2739: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   2742: invokevirtual 507	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2745: pop
    //   2746: aload 20
    //   2748: instanceof 272
    //   2751: ifeq +61 -> 2812
    //   2754: aload 14
    //   2756: ldc_w 632
    //   2759: aload 20
    //   2761: checkcast 272	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem
    //   2764: getfield 679	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem:l	Ljava/lang/String;
    //   2767: invokevirtual 495	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2770: pop
    //   2771: goto +41 -> 2812
    //   2774: astore 8
    //   2776: new 276	java/lang/StringBuilder
    //   2779: dup
    //   2780: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2783: astore 9
    //   2785: aload 9
    //   2787: aload 12
    //   2789: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2792: pop
    //   2793: aload 9
    //   2795: aload 8
    //   2797: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2800: pop
    //   2801: aload 16
    //   2803: iconst_2
    //   2804: aload 9
    //   2806: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2809: invokestatic 512	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2812: invokestatic 224	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2815: invokevirtual 228	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2818: checkcast 230	com/tencent/mobileqq/app/QQAppInterface
    //   2821: astore 8
    //   2823: new 514	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2826: dup
    //   2827: invokespecial 515	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2830: ldc_w 517
    //   2833: invokevirtual 521	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2836: aload 13
    //   2838: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2841: astore 9
    //   2843: new 276	java/lang/StringBuilder
    //   2846: dup
    //   2847: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2850: astore 11
    //   2852: aload 11
    //   2854: aload 10
    //   2856: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   2859: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2862: pop
    //   2863: aload 11
    //   2865: ldc_w 534
    //   2868: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2871: pop
    //   2872: aload 9
    //   2874: aload 11
    //   2876: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2879: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2882: aload 10
    //   2884: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   2887: invokevirtual 543	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2890: aload 10
    //   2892: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   2895: invokevirtual 548	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2898: aload 17
    //   2900: getfield 30	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2903: invokestatic 551	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2906: invokevirtual 554	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2909: aload 14
    //   2911: invokevirtual 555	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2914: invokevirtual 558	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2917: astore 9
    //   2919: new 276	java/lang/StringBuilder
    //   2922: dup
    //   2923: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   2926: astore 10
    //   2928: aload 10
    //   2930: aload 8
    //   2932: invokevirtual 561	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2935: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2938: pop
    //   2939: aload 10
    //   2941: getstatic 563	com/tencent/mobileqq/search/util/SearchUtils:j	J
    //   2944: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2947: pop
    //   2948: aload 8
    //   2950: aload 9
    //   2952: aload 10
    //   2954: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2957: invokevirtual 566	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2960: invokestatic 569	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2963: getstatic 681	com/tencent/mobileqq/search/util/SearchUtils:k	Ljava/util/HashMap;
    //   2966: aload 20
    //   2968: invokevirtual 474	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2971: ifeq +360 -> 3331
    //   2974: getstatic 681	com/tencent/mobileqq/search/util/SearchUtils:k	Ljava/util/HashMap;
    //   2977: aload 20
    //   2979: invokevirtual 478	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2982: checkcast 480	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   2985: astore 8
    //   2987: aload 8
    //   2989: getfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   2992: ifne +339 -> 3331
    //   2995: aload 8
    //   2997: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   3000: invokestatic 684	com/tencent/mobileqq/search/util/SearchUtils:a	(J)Z
    //   3003: ifeq +158 -> 3161
    //   3006: aload 8
    //   3008: getfield 685	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:f	Z
    //   3011: ifeq +9 -> 3020
    //   3014: iconst_2
    //   3015: istore 4
    //   3017: goto +6 -> 3023
    //   3020: iconst_1
    //   3021: istore 4
    //   3023: aload 8
    //   3025: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   3028: astore 9
    //   3030: new 276	java/lang/StringBuilder
    //   3033: dup
    //   3034: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   3037: astore 10
    //   3039: aload 10
    //   3041: aload 8
    //   3043: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   3046: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3049: pop
    //   3050: aload 10
    //   3052: ldc_w 534
    //   3055: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3058: pop
    //   3059: aload 10
    //   3061: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3064: astore 10
    //   3066: aload 8
    //   3068: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   3071: astore 11
    //   3073: new 276	java/lang/StringBuilder
    //   3076: dup
    //   3077: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   3080: astore 12
    //   3082: aload 12
    //   3084: aload 8
    //   3086: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   3089: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3092: pop
    //   3093: aload 12
    //   3095: ldc_w 534
    //   3098: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3101: pop
    //   3102: ldc_w 517
    //   3105: ldc_w 687
    //   3108: iload 4
    //   3110: iconst_0
    //   3111: iconst_4
    //   3112: anewarray 689	java/lang/String
    //   3115: dup
    //   3116: iconst_0
    //   3117: aload 9
    //   3119: aastore
    //   3120: dup
    //   3121: iconst_1
    //   3122: aload 10
    //   3124: aastore
    //   3125: dup
    //   3126: iconst_2
    //   3127: aload 11
    //   3129: aastore
    //   3130: dup
    //   3131: iconst_3
    //   3132: aload 12
    //   3134: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3137: aastore
    //   3138: invokestatic 692	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3141: aload 8
    //   3143: iconst_1
    //   3144: putfield 482	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:d	Z
    //   3147: getstatic 681	com/tencent/mobileqq/search/util/SearchUtils:k	Ljava/util/HashMap;
    //   3150: aload 20
    //   3152: checkcast 694	com/tencent/mobileqq/search/model/ISearchResultModel
    //   3155: aload 8
    //   3157: invokevirtual 572	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3160: pop
    //   3161: aload 20
    //   3163: instanceof 352
    //   3166: ifeq +165 -> 3331
    //   3169: aload 20
    //   3171: checkcast 352	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance
    //   3174: astore 9
    //   3176: aload 9
    //   3178: getfield 448	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:c	I
    //   3181: bipush 253
    //   3183: if_icmpeq +13 -> 3196
    //   3186: aload 9
    //   3188: getfield 448	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:c	I
    //   3191: bipush 252
    //   3193: if_icmpne +138 -> 3331
    //   3196: aload 8
    //   3198: getfield 685	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:f	Z
    //   3201: ifeq +9 -> 3210
    //   3204: iconst_2
    //   3205: istore 4
    //   3207: goto +6 -> 3213
    //   3210: iconst_1
    //   3211: istore 4
    //   3213: aload 8
    //   3215: getfield 545	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:a	Ljava/lang/String;
    //   3218: astore 9
    //   3220: new 276	java/lang/StringBuilder
    //   3223: dup
    //   3224: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   3227: astore 10
    //   3229: aload 10
    //   3231: aload 8
    //   3233: getfield 529	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:b	J
    //   3236: invokevirtual 532	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3239: pop
    //   3240: aload 10
    //   3242: ldc_w 534
    //   3245: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3248: pop
    //   3249: aload 10
    //   3251: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3254: astore 10
    //   3256: aload 8
    //   3258: getfield 540	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:e	Ljava/lang/String;
    //   3261: astore 11
    //   3263: new 276	java/lang/StringBuilder
    //   3266: dup
    //   3267: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   3270: astore 12
    //   3272: aload 12
    //   3274: aload 8
    //   3276: getfield 504	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:c	I
    //   3279: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3282: pop
    //   3283: aload 12
    //   3285: ldc_w 534
    //   3288: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3291: pop
    //   3292: ldc_w 517
    //   3295: ldc_w 696
    //   3298: iload 4
    //   3300: iconst_0
    //   3301: iconst_4
    //   3302: anewarray 689	java/lang/String
    //   3305: dup
    //   3306: iconst_0
    //   3307: aload 9
    //   3309: aastore
    //   3310: dup
    //   3311: iconst_1
    //   3312: aload 10
    //   3314: aastore
    //   3315: dup
    //   3316: iconst_2
    //   3317: aload 11
    //   3319: aastore
    //   3320: dup
    //   3321: iconst_3
    //   3322: aload 12
    //   3324: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3327: aastore
    //   3328: invokestatic 692	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3331: aload 17
    //   3333: aload_2
    //   3334: aload 20
    //   3336: invokespecial 698	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(Landroid/view/View;Lcom/tencent/mobileqq/search/model/IModel;)Z
    //   3339: ifne +8 -> 3347
    //   3342: aconst_null
    //   3343: astore_2
    //   3344: goto +3 -> 3347
    //   3347: iload_1
    //   3348: istore 4
    //   3350: aload 17
    //   3352: iload 4
    //   3354: aload_2
    //   3355: aload_3
    //   3356: invokespecial 700	com/tencent/mobileqq/search/base/adapter/BaseMvpAdapter:getView	(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   3359: astore 8
    //   3361: aload 17
    //   3363: iload 4
    //   3365: aload 8
    //   3367: aload 20
    //   3369: invokespecial 702	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(ILandroid/view/View;Lcom/tencent/mobileqq/search/model/IModel;)V
    //   3372: iload 4
    //   3374: ifne +9 -> 3383
    //   3377: iconst_1
    //   3378: istore 6
    //   3380: goto +6 -> 3386
    //   3383: iconst_0
    //   3384: istore 6
    //   3386: iload 6
    //   3388: istore 7
    //   3390: iload 4
    //   3392: iconst_1
    //   3393: if_icmplt +75 -> 3468
    //   3396: aload_0
    //   3397: iload_1
    //   3398: invokevirtual 143	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:getItemViewType	(I)I
    //   3401: istore 5
    //   3403: aload 17
    //   3405: iload 4
    //   3407: iconst_1
    //   3408: isub
    //   3409: invokevirtual 143	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:getItemViewType	(I)I
    //   3412: istore 4
    //   3414: iload 5
    //   3416: bipush 11
    //   3418: if_icmpeq +10 -> 3428
    //   3421: iload 5
    //   3423: bipush 10
    //   3425: if_icmpne +20 -> 3445
    //   3428: iload 4
    //   3430: bipush 11
    //   3432: if_icmpeq +16 -> 3448
    //   3435: iload 4
    //   3437: bipush 10
    //   3439: if_icmpne +6 -> 3445
    //   3442: goto +6 -> 3448
    //   3445: goto +6 -> 3451
    //   3448: iconst_1
    //   3449: istore 6
    //   3451: aload_0
    //   3452: aload 8
    //   3454: aload 20
    //   3456: iload_1
    //   3457: iload 5
    //   3459: iload 4
    //   3461: iload 6
    //   3463: invokespecial 704	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(Landroid/view/View;Lcom/tencent/mobileqq/search/model/IModel;IIIZ)Z
    //   3466: istore 7
    //   3468: aload 8
    //   3470: ifnull +47 -> 3517
    //   3473: aload 8
    //   3475: ldc_w 705
    //   3478: invokevirtual 709	android/view/View:findViewById	(I)Landroid/view/View;
    //   3481: ifnull +36 -> 3517
    //   3484: iload 7
    //   3486: ifeq +19 -> 3505
    //   3489: aload 8
    //   3491: ldc_w 705
    //   3494: invokevirtual 709	android/view/View:findViewById	(I)Landroid/view/View;
    //   3497: bipush 8
    //   3499: invokevirtual 712	android/view/View:setVisibility	(I)V
    //   3502: goto +15 -> 3517
    //   3505: aload 8
    //   3507: ldc_w 705
    //   3510: invokevirtual 709	android/view/View:findViewById	(I)Landroid/view/View;
    //   3513: iconst_0
    //   3514: invokevirtual 712	android/view/View:setVisibility	(I)V
    //   3517: invokestatic 718	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   3520: iload_1
    //   3521: aload_2
    //   3522: aload_3
    //   3523: aload_0
    //   3524: iload_1
    //   3525: invokevirtual 722	com/tencent/mobileqq/search/base/adapter/BaseMvpAdapter:getItemId	(I)J
    //   3528: invokevirtual 726	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   3531: aload 8
    //   3533: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3534	0	this	GroupSearchAdapter
    //   0	3534	1	paramInt	int
    //   0	3534	2	paramView	View
    //   0	3534	3	paramViewGroup	ViewGroup
    //   12	3448	4	i	int
    //   485	2973	5	j	int
    //   3378	84	6	bool1	boolean
    //   3388	97	7	bool2	boolean
    //   55	2670	8	localObject1	Object
    //   2774	22	8	localJSONException1	org.json.JSONException
    //   2821	711	8	localObject2	Object
    //   78	1188	9	localObject3	Object
    //   1352	1	9	localJSONException2	org.json.JSONException
    //   1357	1	9	localJSONException3	org.json.JSONException
    //   1362	1	9	localJSONException4	org.json.JSONException
    //   1367	22	9	localJSONException5	org.json.JSONException
    //   1414	196	9	localQQAppInterface	QQAppInterface
    //   1768	1	9	localJSONException6	org.json.JSONException
    //   1773	1	9	localJSONException7	org.json.JSONException
    //   1778	22	9	localJSONException8	org.json.JSONException
    //   1825	1483	9	localObject4	Object
    //   133	23	10	localJSONException9	org.json.JSONException
    //   181	3132	10	localObject5	Object
    //   22	3296	11	localObject6	Object
    //   26	3297	12	localObject7	Object
    //   17	2820	13	localObject8	Object
    //   142	356	14	localObject9	Object
    //   629	1	14	localJSONException10	org.json.JSONException
    //   634	1	14	localJSONException11	org.json.JSONException
    //   639	22	14	localJSONException12	org.json.JSONException
    //   717	2193	14	localObject10	Object
    //   211	2452	15	localObject11	Object
    //   380	2422	16	localObject12	Object
    //   376	3028	17	localObject13	Object
    //   372	1585	18	localObject14	Object
    //   364	1550	19	localObject15	Object
    //   5	3450	20	localIModel	IModel
    //   402	1475	21	localObject16	Object
    //   395	1484	22	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   80	130	133	org/json/JSONException
    //   602	626	629	org/json/JSONException
    //   591	602	634	org/json/JSONException
    //   579	591	639	org/json/JSONException
    //   1339	1349	1352	org/json/JSONException
    //   1321	1339	1357	org/json/JSONException
    //   1310	1321	1362	org/json/JSONException
    //   1298	1310	1367	org/json/JSONException
    //   1727	1765	1768	org/json/JSONException
    //   1709	1727	1773	org/json/JSONException
    //   1686	1709	1778	org/json/JSONException
    //   2699	2771	2774	org/json/JSONException
  }
  
  public int getViewTypeCount()
  {
    return 65;
  }
  
  public void notifyDataSetChanged()
  {
    int i3 = getCount();
    int m = 0;
    int k = 0;
    int i1 = 0;
    int i2;
    for (int j = 0; m < i3; j = i2)
    {
      Object localObject = c(m);
      int n;
      int i;
      if ((localObject instanceof GroupSearchModeTitle))
      {
        localObject = (GroupSearchModeTitle)localObject;
        n = k + 1;
        ((GroupSearchModeTitle)localObject).a(1, n);
        k = j;
        if (((GroupSearchModeTitle)localObject).i() == 2) {
          k = j + 1;
        }
        ((GroupSearchModeTitle)localObject).a(3, k);
        ((GroupSearchModeTitle)localObject).a(0, n, k);
        i = 0;
        i2 = k;
      }
      else if ((localObject instanceof SearchResultGroupModelImpl))
      {
        localObject = (SearchResultGroupModelImpl)localObject;
        i = i1 + 1;
        ((SearchResultGroupModelImpl)localObject).a(i, k, j);
        n = k;
        i2 = j;
      }
      else
      {
        n = k;
        i = i1;
        i2 = j;
        if ((localObject instanceof GroupBaseNetSearchModelItem))
        {
          localObject = (GroupBaseNetSearchModelItem)localObject;
          i = i1 + 1;
          ((GroupBaseNetSearchModelItem)localObject).a(i, k, j);
          i2 = j;
          n = k;
        }
      }
      m += 1;
      k = n;
      i1 = i;
    }
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDecodeTaskCompleted, remainingTasks : ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", type : ");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(", uin : ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", avatar : ");
      ((StringBuilder)localObject1).append(paramBitmap);
      ((StringBuilder)localObject1).append(", mFaceDecoder.isPausing() : ");
      ((StringBuilder)localObject1).append(this.c.isPausing());
      ((StringBuilder)localObject1).append(", mScrollState : ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.c.isPausing())
    {
      paramInt1 = this.a;
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        int j = this.d.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject1 = this.d.getChildAt(paramInt1);
          IFaceModel localIFaceModel;
          IFacePresenter localIFacePresenter;
          Object localObject2;
          if (((((View)localObject1).getTag(2131449867) instanceof IFaceModel)) && ((((View)localObject1).getTag(2131449869) instanceof IFacePresenter)) && ((((View)localObject1).getTag(2131449873) instanceof IFaceView)))
          {
            localIFaceModel = (IFaceModel)((View)localObject1).getTag(2131449867);
            localIFacePresenter = (IFacePresenter)((View)localObject1).getTag(2131449869);
            localObject2 = (IFaceView)((View)localObject1).getTag(2131449873);
            if ((localIFaceModel.b() == paramInt2) && (paramString.equals(localIFaceModel.c()))) {
              localIFacePresenter.a(localIFaceModel, (IFaceView)localObject2, paramBitmap);
            }
          }
          if ((localObject1 instanceof ViewGroup))
          {
            int i = 0;
            for (;;)
            {
              localObject2 = (ViewGroup)localObject1;
              if (i >= ((ViewGroup)localObject2).getChildCount()) {
                break;
              }
              localIFaceModel = (IFaceModel)((ViewGroup)localObject2).getChildAt(i).getTag(2131449867);
              if ((localIFaceModel != null) && (localIFaceModel.b() == paramInt2) && (paramString.equals(localIFaceModel.c())))
              {
                localIFacePresenter = (IFacePresenter)((ViewGroup)localObject2).getChildAt(i).getTag(2131449869);
                localObject2 = (IFaceView)((ViewGroup)localObject2).getChildAt(i).getTag(2131449873);
                if ((localIFacePresenter != null) && (localObject2 != null)) {
                  localIFacePresenter.a(localIFaceModel, (IFaceView)localObject2, paramBitmap);
                }
              }
              i += 1;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.e;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.g.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.d == null) {
      return;
    }
    this.a = paramInt;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.c.cancelPendingRequests();
      this.c.pause();
    }
    else
    {
      if (this.c.isPausing()) {
        this.c.resume();
      }
      int k = this.d.getChildCount();
      int i = 0;
      while (i < k)
      {
        localObject1 = this.d.getChildAt(i);
        if ((localObject1 instanceof ViewGroup))
        {
          int j = 0;
          for (;;)
          {
            Object localObject2 = (ViewGroup)localObject1;
            if (j >= ((ViewGroup)localObject2).getChildCount()) {
              break;
            }
            IFaceModel localIFaceModel = (IFaceModel)((ViewGroup)localObject2).getChildAt(j).getTag(2131449867);
            IFacePresenter localIFacePresenter = (IFacePresenter)((ViewGroup)localObject2).getChildAt(j).getTag(2131449869);
            localObject2 = (IFaceView)((ViewGroup)localObject2).getChildAt(j).getTag(2131449873);
            if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
              localIFacePresenter.a(localIFaceModel, (IFaceView)localObject2);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    Object localObject1 = this.e;
    if (localObject1 != null) {
      ((AbsListView.OnScrollListener)localObject1).onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.g.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchAdapter
 * JD-Core Version:    0.7.0.1
 */