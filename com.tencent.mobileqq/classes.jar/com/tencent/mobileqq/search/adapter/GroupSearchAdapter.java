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
  protected int a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private RichNodeController jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController = new RichNodeController();
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private boolean jdField_a_of_type_Boolean;
  public int b = -1;
  
  public GroupSearchAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, AbsListView.OnScrollListener paramOnScrollListener, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    paramIFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
    this.b = paramInt;
  }
  
  private IRichNode a(int paramInt)
  {
    IModel localIModel = a(paramInt);
    if (localIModel == null) {
      return null;
    }
    if (!(localIModel instanceof IRichNode)) {
      return null;
    }
    return (IRichNode)localIModel;
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
      paramIModel = (IView)paramView.getTag(2131380889);
      paramView = null;
      if ((paramIModel instanceof IRichNodeView)) {
        paramView = ((IRichNodeView)paramIModel).a();
      }
      if (paramView == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController.a(paramInt, paramView);
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
        IView localIView = (IView)paramView.getTag(2131380889);
        paramView = null;
        if ((localIView instanceof IRichNodeView)) {
          paramView = ((IRichNodeView)localIView).a();
        }
        if (paramView == null) {
          return false;
        }
        paramIModel = (RichSearchModelNode)paramIModel;
        if ((paramIModel.f() == paramView.c()) && (paramIModel.h() == paramView.b()))
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
        paramView = (IView)paramView.getTag(2131380889);
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
          Object localObject3 = a(paramInt1 - 1);
          Object localObject1 = localObject2;
          if ((localObject3 instanceof GroupSearchModeTitle))
          {
            localObject3 = (GroupSearchModeTitle)localObject3;
            localObject1 = localObject2;
            if (!((GroupSearchModeTitle)localObject3).jdField_a_of_type_Boolean) {
              localObject1 = ((GroupSearchModeTitle)localObject3).a().a();
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
      paramView = a(paramInt1 - 1);
      if (((paramView instanceof ArkRichNode)) && (((ArkRichNode)paramView).a() == 1)) {
        return true;
      }
    }
    return paramBoolean;
  }
  
  public int a(int paramInt)
  {
    Object localObject;
    if ((a(paramInt) instanceof GroupBaseNetSearchModel))
    {
      localObject = (GroupBaseNetSearchModel)a(paramInt);
      if (localObject != null) {
        return ((GroupBaseNetSearchModel)localObject).b();
      }
    }
    else if ((a(paramInt) instanceof GroupBaseNetSearchModelItem))
    {
      localObject = (GroupBaseNetSearchModelItem)a(paramInt);
      if (localObject != null) {
        return ((GroupBaseNetSearchModelItem)localObject).d();
      }
    }
    return 0;
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
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 60: 
      return new MostUseResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 59: 
      return new RichSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this);
    case 57: 
      return new EmptyViewPresenter();
    case 56: 
      return new MiniProgramSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 49: 
      return new SearchResultGroupFooterViewPresenter();
    case 46: 
      return new PublicAcntSearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 41: 
      return new FunctionSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
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
      return new SearchTemplatePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this);
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
      return new ActiveEntitySearchResultPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, a(paramInt), this);
    case 16: 
      return new SearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 15: 
      return new SearchResultGroupTitlePresenter();
    case 14: 
      return new SearchResultGroupMorePresenter();
    case 13: 
      return new ContactSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 12: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, true);
    case 11: 
      return new FileSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    case 10: 
      return new FavoriteSearchResultGroupPresenter();
    case 9: 
      return new SearchResultGroupMorePresenter();
    case 3: 
      return new SearchResultGroupMessagePresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, false);
    case 2: 
    case 8: 
      return new PublicAcntSearchResultGroupPresenter(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
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
      return new SearchResultGroupView(paramViewGroup, 2131562780);
    case 60: 
      return new MostUsedSearchResultGroupView(paramViewGroup, 2131562787);
    case 59: 
      Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = a(paramInt);
      localObject2 = RichNodeFactory.a().a((QQAppInterface)localObject2, paramViewGroup.getContext(), (IModel)localObject1);
      if ((localObject2 != null) && (localObject1 != null) && ((localObject1 instanceof RichSearchModelNode))) {
        ((RichSearchModelNode)localObject1).b(((IRichNode)localObject2).b());
      }
      if (localObject2 == null) {
        return new EmptyResultView(paramViewGroup);
      }
      return ((IRichNode)localObject2).a();
    case 57: 
      return new EmptyResultView(paramViewGroup);
    case 56: 
      return new MiniProgramSearchResultGroupView(paramViewGroup, 2131562786);
    case 49: 
      return new SearchResultGroupFooterView(paramViewGroup);
    case 46: 
      return new SearchResultView(paramViewGroup, 2131559628);
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
      localObject1 = a(paramInt);
      if ((localObject1 instanceof NetSearchTemplateBaseItem))
      {
        localObject1 = (NetSearchTemplateBaseItem)localObject1;
        switch (((NetSearchTemplateBaseItem)localObject1).d())
        {
        case 5: 
        case 10: 
        default: 
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("NetSearchTemplateBaseItem.getLayoutId() is ");
          paramViewGroup.append(((NetSearchTemplateBaseItem)localObject1).e());
          paramViewGroup.append(" which is not supported!!!");
          throw new RuntimeException(paramViewGroup.toString());
        case 19: 
          return new NetSearchTemplateIndividuateContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 18: 
          return new NetSearchTemplateMiniAppView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 17: 
          return new NetSearchTemplateNewEntranceView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 16: 
          return new NetSearchTemplateNetSeaEntranceView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 15: 
          return new NetSearchTemplateQAView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 14: 
          return new NetSearchTemplateTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 13: 
          return new NetSearchTemplateHorSlidingContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 12: 
          return new NetSearchTemplateBigImageView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 11: 
          return new NetSearchTemplateFriendUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 9: 
          return new NetSearchTemplateSubItemTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 8: 
          return new NetSearchTemplateSubItemView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 7: 
          return new NetSearchTemplateHorizontalContainerView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 6: 
          return new NetSearchTemplateUniversalView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 4: 
          return new NetSearchTemplateBannerTitleView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        case 3: 
          return new NetSearchTemplateUpdatesView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
        }
        return new NetSearchTemplateAvatarsView(paramViewGroup, ((NetSearchTemplateBaseItem)localObject1).e());
      }
      throw new RuntimeException("model type is TYPE_UNITE_TEMPLATE_NORMAL or TYPE_UNITE_TEMPLATE_NEWS, but model item is not instance NetSearchTemplateBaseItem.");
    case 29: 
    case 30: 
    case 36: 
      localObject1 = a(paramInt);
      if ((localObject1 instanceof SearchResultModelForEntrance)) {
        return new SearchResultEntranceView(paramViewGroup, ((SearchResultModelForEntrance)localObject1).d());
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
      return new SearchResultFromNetView(paramViewGroup, a(paramInt));
    case 19: 
      return new ApproximateSearchResultGroupView(paramViewGroup, 2131562832);
    case 17: 
      return new SearchResultGroupView(paramViewGroup, 2131562788);
    case 16: 
      return new SearchResultGroupView(paramViewGroup, 2131562781);
    case 14: 
      return new SearchResultGroupMoreItemView(paramViewGroup, 2131562800, 2130846216, 12);
    case 12: 
      return new SearchResultGroupFTSMessageView(paramViewGroup);
    case 10: 
      return new SearchResultView(paramViewGroup, 2131559832);
    case 9: 
      return new SearchResultGroupMoreItemView(paramViewGroup, 2131562800, 2130846216, -1);
    case 3: 
      return new SearchResultGroupMessageView(paramViewGroup);
    case 2: 
      return new SearchResultGroupView(paramViewGroup, 2131559627);
    case 1: 
    case 13: 
      return new ContactSearchResultGroupView(paramViewGroup, 2131562784);
    }
    Object localObject1 = a(paramInt);
    boolean bool1 = localObject1 instanceof GroupSearchModeTitle;
    boolean bool2 = false;
    if (bool1) {
      bool1 = ((GroupSearchModeTitle)localObject1).a();
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
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((super.a(paramInt) instanceof GroupSearchModelFunction)) {
      return 41;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelMessage)) {
      return 3;
    }
    if ((super.a(paramInt) instanceof FTSGroupSearchModelMessage)) {
      return 12;
    }
    Object localObject;
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.b != 12))
    {
      localObject = (GroupSearchModeTitle)super.a(paramInt);
      if ((localObject != null) && (((GroupSearchModeTitle)localObject).jdField_a_of_type_Boolean)) {
        return 0;
      }
      return 57;
    }
    if (((super.a(paramInt) instanceof GroupSearchModeTitle)) && (this.b == 12))
    {
      localObject = (GroupSearchModeTitle)super.a(paramInt);
      if ((localObject != null) && (((GroupSearchModeTitle)localObject).jdField_a_of_type_Boolean)) {
        return 15;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelFooter))
    {
      localObject = (GroupSearchModelFooter)super.a(paramInt);
      if ((localObject != null) && (((GroupSearchModelFooter)localObject).jdField_a_of_type_Boolean)) {
        return 49;
      }
      return 57;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelPublicAcnt)) {
      return 2;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPeople)) {
      return 5;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelMiniProgram)) {
      return 56;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelTroop)) {
      return 6;
    }
    if ((super.a(paramInt) instanceof GroupSearchModelMostUsed)) {
      return 60;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelPublicAcnt)) {
      return 8;
    }
    if ((super.a(paramInt) instanceof GroupNetSearchModelArticle)) {
      return 16;
    }
    if (((super.a(paramInt) instanceof GroupSearchModelMoreItem)) && (this.b != 12)) {
      return 9;
    }
    if (((super.a(paramInt) instanceof GroupSearchModelMoreItem)) && (this.b == 12)) {
      return 14;
    }
    if ((a(paramInt) instanceof GroupSearchModelFavorite)) {
      return 10;
    }
    if ((a(paramInt) instanceof GroupSearchModelFileEntity)) {
      return 11;
    }
    if ((!(super.a(paramInt) instanceof GroupSearchModelLocalContact)) && (!(super.a(paramInt) instanceof GroupSearchModelLocalTroop)))
    {
      if ((a(paramInt) instanceof GroupSearchModelMultiChat)) {
        return 17;
      }
      if ((a(paramInt) instanceof GroupSearchModelLocalContactApproximate)) {
        return 19;
      }
      if ((a(paramInt) instanceof RichSearchModelNode)) {
        return 59;
      }
      if ((a(paramInt) instanceof GroupBaseNetSearchModelItem))
      {
        localObject = (GroupBaseNetSearchModelItem)a(paramInt);
        if (localObject == null) {
          return 25;
        }
        paramInt = ((GroupBaseNetSearchModelItem)localObject).d();
        if (paramInt != 1001)
        {
          if (paramInt != 1002)
          {
            if (paramInt != 268435456) {
              return 25;
            }
            return 26;
          }
          return 22;
        }
        return 21;
      }
      if ((a(paramInt) instanceof SearchResultModelForEntrance))
      {
        localObject = (SearchResultModelForEntrance)a(paramInt);
        if (localObject == null) {
          return 29;
        }
        paramInt = ((SearchResultModelForEntrance)localObject).jdField_a_of_type_Int;
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
      if ((a(paramInt) instanceof NetSearchTemplateBaseItem))
      {
        localObject = (NetSearchTemplateBaseItem)a(paramInt);
        if (localObject == null) {
          return 45;
        }
        switch (((NetSearchTemplateBaseItem)localObject).d())
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
      if ((a(paramInt) instanceof PublicAccountSearchResultModel)) {
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
    //   2: invokevirtual 53	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(I)Lcom/tencent/mobileqq/search/model/IModel;
    //   5: astore 20
    //   7: aload 20
    //   9: invokestatic 444	com/tencent/mobileqq/search/SearchUtil:a	(Lcom/tencent/mobileqq/search/model/IModel;)I
    //   12: istore 4
    //   14: ldc_w 446
    //   17: astore 13
    //   19: ldc_w 448
    //   22: astore 11
    //   24: ldc 96
    //   26: astore 12
    //   28: iload 4
    //   30: ifle +1106 -> 1136
    //   33: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   36: aload 20
    //   38: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   41: ifeq +302 -> 343
    //   44: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   47: aload 20
    //   49: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   55: astore 8
    //   57: aload 8
    //   59: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   62: ifne +281 -> 343
    //   65: aload 8
    //   67: iconst_1
    //   68: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   71: new 467	org/json/JSONObject
    //   74: dup
    //   75: invokespecial 468	org/json/JSONObject:<init>	()V
    //   78: astore 9
    //   80: aload 9
    //   82: ldc_w 470
    //   85: invokestatic 474	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   88: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload 9
    //   94: ldc_w 480
    //   97: ldc_w 482
    //   100: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload 9
    //   106: ldc_w 484
    //   109: ldc_w 486
    //   112: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload 9
    //   118: ldc_w 446
    //   121: aload 8
    //   123: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   126: invokevirtual 490	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: goto +42 -> 172
    //   133: astore 10
    //   135: new 275	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   142: astore 14
    //   144: aload 14
    //   146: ldc_w 448
    //   149: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 14
    //   155: aload 10
    //   157: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 96
    //   163: iconst_2
    //   164: aload 14
    //   166: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   175: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   178: checkcast 231	com/tencent/mobileqq/app/QQAppInterface
    //   181: astore 10
    //   183: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   186: dup
    //   187: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   190: ldc_w 500
    //   193: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   196: ldc_w 506
    //   199: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   202: astore 14
    //   204: new 275	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   211: astore 15
    //   213: aload 15
    //   215: aload 8
    //   217: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   220: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 15
    //   226: ldc_w 517
    //   229: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 14
    //   235: aload 15
    //   237: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   243: aload 8
    //   245: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   248: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   251: aload 8
    //   253: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   256: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   259: aload_0
    //   260: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   263: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   266: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   269: aload 9
    //   271: invokevirtual 538	org/json/JSONObject:toString	()Ljava/lang/String;
    //   274: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   277: astore 9
    //   279: new 275	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   286: astore 14
    //   288: aload 14
    //   290: aload 10
    //   292: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   295: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 14
    //   301: getstatic 546	com/tencent/mobileqq/search/util/SearchUtils:d	J
    //   304: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 10
    //   310: aload 9
    //   312: aload 14
    //   314: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokevirtual 549	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   320: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   323: aload 8
    //   325: iconst_1
    //   326: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   329: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   332: aload 20
    //   334: aload 8
    //   336: invokevirtual 555	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   339: pop
    //   340: goto +3 -> 343
    //   343: ldc_w 482
    //   346: astore 8
    //   348: ldc_w 484
    //   351: astore 9
    //   353: ldc_w 506
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
    //   384: instanceof 117
    //   387: ifeq +722 -> 1109
    //   390: aload 20
    //   392: checkcast 117	com/tencent/mobileqq/search/model/ISearchResultGroupModel
    //   395: astore 22
    //   397: aload 22
    //   399: invokeinterface 120 1 0
    //   404: astore 21
    //   406: aload 13
    //   408: astore 15
    //   410: aload 11
    //   412: astore 19
    //   414: aload 12
    //   416: astore 14
    //   418: aload 10
    //   420: astore 18
    //   422: aload 9
    //   424: astore 17
    //   426: aload 8
    //   428: astore 16
    //   430: aload 21
    //   432: ifnull +677 -> 1109
    //   435: aload 13
    //   437: astore 15
    //   439: aload 11
    //   441: astore 19
    //   443: aload 12
    //   445: astore 14
    //   447: aload 10
    //   449: astore 18
    //   451: aload 9
    //   453: astore 17
    //   455: aload 8
    //   457: astore 16
    //   459: aload 21
    //   461: invokeinterface 558 1 0
    //   466: ifle +643 -> 1109
    //   469: aload 21
    //   471: invokeinterface 558 1 0
    //   476: aload 22
    //   478: invokeinterface 559 1 0
    //   483: invokestatic 565	java/lang/Math:min	(II)I
    //   486: istore 4
    //   488: iconst_0
    //   489: istore 5
    //   491: aload 13
    //   493: astore 15
    //   495: aload 11
    //   497: astore 19
    //   499: aload 12
    //   501: astore 14
    //   503: aload 10
    //   505: astore 18
    //   507: aload 9
    //   509: astore 17
    //   511: aload 8
    //   513: astore 16
    //   515: iload 5
    //   517: iload 4
    //   519: if_icmpge +590 -> 1109
    //   522: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   525: aload 21
    //   527: iload 5
    //   529: invokeinterface 567 2 0
    //   534: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   537: ifeq +563 -> 1100
    //   540: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   543: aload 21
    //   545: iload 5
    //   547: invokeinterface 567 2 0
    //   552: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   555: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   558: astore 15
    //   560: aload 15
    //   562: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   565: ifne +535 -> 1100
    //   568: aload 15
    //   570: iconst_1
    //   571: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   574: new 467	org/json/JSONObject
    //   577: dup
    //   578: invokespecial 468	org/json/JSONObject:<init>	()V
    //   581: astore 16
    //   583: aload 16
    //   585: ldc_w 470
    //   588: invokestatic 474	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   591: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   594: pop
    //   595: aload 16
    //   597: ldc_w 480
    //   600: aload 8
    //   602: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   605: pop
    //   606: aload 16
    //   608: aload 9
    //   610: ldc_w 486
    //   613: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   616: pop
    //   617: aload 16
    //   619: aload 13
    //   621: aload 15
    //   623: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   626: invokevirtual 490	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   629: pop
    //   630: goto +51 -> 681
    //   633: astore 14
    //   635: goto +10 -> 645
    //   638: astore 14
    //   640: goto +5 -> 645
    //   643: astore 14
    //   645: new 275	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   652: astore 17
    //   654: aload 17
    //   656: aload 11
    //   658: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: pop
    //   662: aload 17
    //   664: aload 14
    //   666: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 12
    //   672: iconst_2
    //   673: aload 17
    //   675: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: aload 21
    //   683: iload 5
    //   685: invokeinterface 567 2 0
    //   690: instanceof 569
    //   693: ifeq +230 -> 923
    //   696: aload 21
    //   698: iload 5
    //   700: invokeinterface 567 2 0
    //   705: checkcast 569	com/tencent/mobileqq/search/model/MiniProgramSearchResultModel
    //   708: astore 17
    //   710: aload 17
    //   712: invokevirtual 571	com/tencent/mobileqq/search/model/MiniProgramSearchResultModel:c	()Z
    //   715: ifeq +11 -> 726
    //   718: ldc_w 573
    //   721: astore 14
    //   723: goto +8 -> 731
    //   726: ldc_w 575
    //   729: astore 14
    //   731: aload 15
    //   733: aload 17
    //   735: invokevirtual 577	com/tencent/mobileqq/search/model/MiniProgramSearchResultModel:e	()Ljava/lang/String;
    //   738: putfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   741: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   744: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   747: checkcast 231	com/tencent/mobileqq/app/QQAppInterface
    //   750: astore 17
    //   752: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   755: dup
    //   756: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   759: ldc_w 500
    //   762: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   765: aload 10
    //   767: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   770: astore 18
    //   772: new 275	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   779: astore 19
    //   781: aload 19
    //   783: aload 15
    //   785: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   788: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: aload 19
    //   794: ldc_w 517
    //   797: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload 18
    //   803: aload 19
    //   805: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   811: aload 15
    //   813: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   816: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   819: aload 15
    //   821: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   824: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   827: aload_0
    //   828: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   831: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   834: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   837: aload 14
    //   839: invokevirtual 580	com/tencent/mobileqq/search/report/ReportModelDC02528:ver3	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   842: aload 16
    //   844: invokevirtual 538	org/json/JSONObject:toString	()Ljava/lang/String;
    //   847: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   850: astore 14
    //   852: new 275	java/lang/StringBuilder
    //   855: dup
    //   856: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   859: astore 16
    //   861: aload 16
    //   863: aload 17
    //   865: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   868: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: aload 16
    //   874: getstatic 546	com/tencent/mobileqq/search/util/SearchUtils:d	J
    //   877: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 17
    //   883: aload 14
    //   885: aload 16
    //   887: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: invokevirtual 549	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   893: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   896: aload 15
    //   898: iconst_1
    //   899: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   902: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   905: aload 21
    //   907: iload 5
    //   909: invokeinterface 567 2 0
    //   914: aload 15
    //   916: invokevirtual 555	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   919: pop
    //   920: goto +180 -> 1100
    //   923: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   926: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   929: checkcast 231	com/tencent/mobileqq/app/QQAppInterface
    //   932: astore 14
    //   934: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   937: dup
    //   938: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   941: ldc_w 500
    //   944: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   947: aload 10
    //   949: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   952: astore 17
    //   954: new 275	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   961: astore 18
    //   963: aload 18
    //   965: aload 15
    //   967: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   970: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 18
    //   976: ldc_w 517
    //   979: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload 17
    //   985: aload 18
    //   987: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   993: aload 15
    //   995: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   998: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1001: aload 15
    //   1003: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1006: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1009: aload_0
    //   1010: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   1013: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   1016: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1019: aload 16
    //   1021: invokevirtual 538	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1024: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1027: astore 16
    //   1029: new 275	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1036: astore 17
    //   1038: aload 17
    //   1040: aload 14
    //   1042: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1045: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 17
    //   1051: getstatic 546	com/tencent/mobileqq/search/util/SearchUtils:d	J
    //   1054: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload 14
    //   1060: aload 16
    //   1062: aload 17
    //   1064: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokevirtual 549	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1070: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   1073: aload 15
    //   1075: iconst_1
    //   1076: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   1079: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1082: aload 21
    //   1084: iload 5
    //   1086: invokeinterface 567 2 0
    //   1091: aload 15
    //   1093: invokevirtual 555	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1096: pop
    //   1097: goto +3 -> 1100
    //   1100: iload 5
    //   1102: iconst_1
    //   1103: iadd
    //   1104: istore 5
    //   1106: goto -615 -> 491
    //   1109: aload 19
    //   1111: astore 12
    //   1113: aload 18
    //   1115: astore 13
    //   1117: aload 17
    //   1119: astore 8
    //   1121: aload 16
    //   1123: astore 11
    //   1125: aload 15
    //   1127: astore 9
    //   1129: aload 14
    //   1131: astore 10
    //   1133: goto +32 -> 1165
    //   1136: ldc_w 446
    //   1139: astore 9
    //   1141: ldc_w 484
    //   1144: astore 8
    //   1146: ldc_w 482
    //   1149: astore 11
    //   1151: ldc_w 448
    //   1154: astore 12
    //   1156: ldc 96
    //   1158: astore 10
    //   1160: ldc_w 506
    //   1163: astore 13
    //   1165: aload_0
    //   1166: astore 17
    //   1168: aload 20
    //   1170: instanceof 135
    //   1173: ifeq +402 -> 1575
    //   1176: aload 20
    //   1178: checkcast 135	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   1181: astore 16
    //   1183: aload 16
    //   1185: invokevirtual 581	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	()Ljava/util/List;
    //   1188: ifnull +384 -> 1572
    //   1191: aload 16
    //   1193: invokevirtual 581	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	()Ljava/util/List;
    //   1196: invokeinterface 558 1 0
    //   1201: ifle +371 -> 1572
    //   1204: iconst_0
    //   1205: istore 4
    //   1207: aload 8
    //   1209: astore 14
    //   1211: aload 11
    //   1213: astore 15
    //   1215: aload 9
    //   1217: astore 8
    //   1219: aload 16
    //   1221: astore 11
    //   1223: iload 4
    //   1225: aload 11
    //   1227: invokevirtual 581	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	()Ljava/util/List;
    //   1230: invokeinterface 558 1 0
    //   1235: if_icmpge +337 -> 1572
    //   1238: aload 11
    //   1240: invokevirtual 581	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	()Ljava/util/List;
    //   1243: iload 4
    //   1245: invokeinterface 567 2 0
    //   1250: checkcast 583	com/tencent/mobileqq/search/model/IModel
    //   1253: astore 9
    //   1255: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1258: aload 9
    //   1260: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1263: ifeq +300 -> 1563
    //   1266: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1269: aload 9
    //   1271: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1274: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   1277: astore 16
    //   1279: aload 16
    //   1281: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   1284: ifne +279 -> 1563
    //   1287: aload 16
    //   1289: iconst_1
    //   1290: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   1293: new 467	org/json/JSONObject
    //   1296: dup
    //   1297: invokespecial 468	org/json/JSONObject:<init>	()V
    //   1300: astore 18
    //   1302: aload 18
    //   1304: ldc_w 470
    //   1307: invokestatic 474	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   1310: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1313: pop
    //   1314: aload 18
    //   1316: ldc_w 480
    //   1319: aload 15
    //   1321: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1324: pop
    //   1325: aload 18
    //   1327: aload 14
    //   1329: ldc_w 585
    //   1332: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1335: pop
    //   1336: aload 16
    //   1338: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   1341: istore 5
    //   1343: aload 18
    //   1345: aload 8
    //   1347: iload 5
    //   1349: invokevirtual 490	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1352: pop
    //   1353: goto +56 -> 1409
    //   1356: astore 9
    //   1358: goto +15 -> 1373
    //   1361: astore 9
    //   1363: goto +10 -> 1373
    //   1366: astore 9
    //   1368: goto +5 -> 1373
    //   1371: astore 9
    //   1373: new 275	java/lang/StringBuilder
    //   1376: dup
    //   1377: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1380: astore 19
    //   1382: aload 19
    //   1384: aload 12
    //   1386: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: pop
    //   1390: aload 19
    //   1392: aload 9
    //   1394: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1397: pop
    //   1398: aload 10
    //   1400: iconst_2
    //   1401: aload 19
    //   1403: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1412: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1415: checkcast 231	com/tencent/mobileqq/app/QQAppInterface
    //   1418: astore 9
    //   1420: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   1423: dup
    //   1424: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   1427: ldc_w 500
    //   1430: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1433: aload 13
    //   1435: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1438: astore 19
    //   1440: new 275	java/lang/StringBuilder
    //   1443: dup
    //   1444: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1447: astore 21
    //   1449: aload 21
    //   1451: aload 16
    //   1453: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   1456: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1459: pop
    //   1460: aload 21
    //   1462: ldc_w 517
    //   1465: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: pop
    //   1469: aload 19
    //   1471: aload 21
    //   1473: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1476: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1479: aload 16
    //   1481: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1484: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1487: aload 16
    //   1489: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1492: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1495: aload 17
    //   1497: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   1500: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   1503: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1506: aload 18
    //   1508: invokevirtual 538	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1511: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1514: astore 16
    //   1516: new 275	java/lang/StringBuilder
    //   1519: dup
    //   1520: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1523: astore 18
    //   1525: aload 18
    //   1527: aload 9
    //   1529: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1532: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: pop
    //   1536: aload 18
    //   1538: getstatic 546	com/tencent/mobileqq/search/util/SearchUtils:d	J
    //   1541: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1544: pop
    //   1545: aload 9
    //   1547: aload 16
    //   1549: aload 18
    //   1551: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokevirtual 549	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1557: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   1560: goto +3 -> 1563
    //   1563: iload 4
    //   1565: iconst_1
    //   1566: iadd
    //   1567: istore 4
    //   1569: goto -346 -> 1223
    //   1572: goto +1395 -> 2967
    //   1575: aload 10
    //   1577: astore 16
    //   1579: aload 20
    //   1581: instanceof 587
    //   1584: ifeq +393 -> 1977
    //   1587: aload 20
    //   1589: checkcast 587	com/tencent/mobileqq/search/model/NetSearchTemplateHorizontalContainerItem
    //   1592: getfield 590	com/tencent/mobileqq/search/model/NetSearchTemplateHorizontalContainerItem:a	Ljava/util/ArrayList;
    //   1595: astore 10
    //   1597: aload 10
    //   1599: ifnull -27 -> 1572
    //   1602: aload 10
    //   1604: invokevirtual 596	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1607: astore 14
    //   1609: aload 12
    //   1611: astore 15
    //   1613: aload 9
    //   1615: astore 10
    //   1617: aload 16
    //   1619: astore 12
    //   1621: aload 14
    //   1623: invokeinterface 601 1 0
    //   1628: ifeq -56 -> 1572
    //   1631: aload 14
    //   1633: invokeinterface 605 1 0
    //   1638: checkcast 607	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem
    //   1641: astore 16
    //   1643: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1646: aload 16
    //   1648: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1651: ifeq +323 -> 1974
    //   1654: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1657: aload 16
    //   1659: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1662: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   1665: astore 18
    //   1667: aload 18
    //   1669: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   1672: ifne +302 -> 1974
    //   1675: aload 18
    //   1677: iconst_1
    //   1678: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   1681: new 467	org/json/JSONObject
    //   1684: dup
    //   1685: invokespecial 468	org/json/JSONObject:<init>	()V
    //   1688: astore 19
    //   1690: aload 19
    //   1692: ldc_w 470
    //   1695: invokestatic 474	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   1698: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1701: pop
    //   1702: aload 19
    //   1704: ldc_w 480
    //   1707: aload 11
    //   1709: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1712: pop
    //   1713: aload 19
    //   1715: aload 8
    //   1717: ldc_w 585
    //   1720: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1723: pop
    //   1724: aload 18
    //   1726: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   1729: istore 4
    //   1731: aload 19
    //   1733: aload 10
    //   1735: iload 4
    //   1737: invokevirtual 490	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1740: pop
    //   1741: aload 19
    //   1743: ldc_w 609
    //   1746: aload 16
    //   1748: getfield 610	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1751: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1754: pop
    //   1755: aload 19
    //   1757: ldc_w 612
    //   1760: aload 16
    //   1762: getfield 614	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:f	Ljava/lang/String;
    //   1765: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1768: pop
    //   1769: goto +51 -> 1820
    //   1772: astore 9
    //   1774: goto +10 -> 1784
    //   1777: astore 9
    //   1779: goto +5 -> 1784
    //   1782: astore 9
    //   1784: new 275	java/lang/StringBuilder
    //   1787: dup
    //   1788: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1791: astore 21
    //   1793: aload 21
    //   1795: aload 15
    //   1797: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1800: pop
    //   1801: aload 21
    //   1803: aload 9
    //   1805: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1808: pop
    //   1809: aload 12
    //   1811: iconst_2
    //   1812: aload 21
    //   1814: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1817: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1820: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1823: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   1826: checkcast 231	com/tencent/mobileqq/app/QQAppInterface
    //   1829: astore 9
    //   1831: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   1834: dup
    //   1835: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   1838: ldc_w 500
    //   1841: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1844: aload 13
    //   1846: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1849: astore 21
    //   1851: new 275	java/lang/StringBuilder
    //   1854: dup
    //   1855: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1858: astore 22
    //   1860: aload 22
    //   1862: aload 16
    //   1864: getfield 615	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:jdField_a_of_type_Long	J
    //   1867: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1870: pop
    //   1871: aload 22
    //   1873: ldc_w 517
    //   1876: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: pop
    //   1880: aload 21
    //   1882: aload 22
    //   1884: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1890: aload 16
    //   1892: getfield 618	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateHorizontalBaseItem:j	Ljava/lang/String;
    //   1895: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1898: aload 18
    //   1900: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1903: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1906: aload 17
    //   1908: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   1911: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   1914: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1917: aload 19
    //   1919: invokevirtual 538	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1922: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1925: astore 16
    //   1927: new 275	java/lang/StringBuilder
    //   1930: dup
    //   1931: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   1934: astore 18
    //   1936: aload 18
    //   1938: aload 9
    //   1940: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1943: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1946: pop
    //   1947: aload 18
    //   1949: getstatic 546	com/tencent/mobileqq/search/util/SearchUtils:d	J
    //   1952: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1955: pop
    //   1956: aload 9
    //   1958: aload 16
    //   1960: aload 18
    //   1962: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1965: invokevirtual 549	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   1968: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   1971: goto +3 -> 1974
    //   1974: goto -353 -> 1621
    //   1977: aload 20
    //   1979: instanceof 620
    //   1982: ifeq +295 -> 2277
    //   1985: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1988: aload 20
    //   1990: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1993: ifeq -421 -> 1572
    //   1996: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   1999: aload 20
    //   2001: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2004: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   2007: astore 8
    //   2009: aload 20
    //   2011: checkcast 620	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem
    //   2014: astore 9
    //   2016: aload 8
    //   2018: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2021: ifne -449 -> 1572
    //   2024: aload 8
    //   2026: iconst_1
    //   2027: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2030: new 275	java/lang/StringBuilder
    //   2033: dup
    //   2034: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2037: astore 10
    //   2039: aload 9
    //   2041: getfield 623	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:a	Ljava/util/List;
    //   2044: ifnull +120 -> 2164
    //   2047: aload 9
    //   2049: getfield 623	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:a	Ljava/util/List;
    //   2052: invokeinterface 558 1 0
    //   2057: ifle +107 -> 2164
    //   2060: iconst_0
    //   2061: istore 4
    //   2063: iload 4
    //   2065: aload 9
    //   2067: getfield 623	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:a	Ljava/util/List;
    //   2070: invokeinterface 558 1 0
    //   2075: if_icmpge +89 -> 2164
    //   2078: iload 4
    //   2080: aload 9
    //   2082: getfield 623	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:a	Ljava/util/List;
    //   2085: invokeinterface 558 1 0
    //   2090: iconst_1
    //   2091: isub
    //   2092: if_icmpeq +39 -> 2131
    //   2095: aload 10
    //   2097: aload 9
    //   2099: getfield 623	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:a	Ljava/util/List;
    //   2102: iload 4
    //   2104: invokeinterface 567 2 0
    //   2109: checkcast 625	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem
    //   2112: getfield 626	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2115: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: pop
    //   2119: aload 10
    //   2121: ldc_w 628
    //   2124: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: pop
    //   2128: goto +27 -> 2155
    //   2131: aload 10
    //   2133: aload 9
    //   2135: getfield 623	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:a	Ljava/util/List;
    //   2138: iload 4
    //   2140: invokeinterface 567 2 0
    //   2145: checkcast 625	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem
    //   2148: getfield 626	com/tencent/mobileqq/search/business/net/model/NetSearchSubItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2151: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2154: pop
    //   2155: iload 4
    //   2157: iconst_1
    //   2158: iadd
    //   2159: istore 4
    //   2161: goto -98 -> 2063
    //   2164: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2167: dup
    //   2168: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2171: ldc_w 500
    //   2174: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2177: ldc_w 630
    //   2180: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2183: ldc_w 632
    //   2186: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2189: aload 8
    //   2191: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2194: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2197: aload 17
    //   2199: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2202: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2205: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2208: aload 10
    //   2210: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2213: invokevirtual 635	com/tencent/mobileqq/search/report/ReportModelDC02528:ver4	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2216: ldc_w 573
    //   2219: invokevirtual 638	com/tencent/mobileqq/search/report/ReportModelDC02528:ver5	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2222: astore 8
    //   2224: new 275	java/lang/StringBuilder
    //   2227: dup
    //   2228: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2231: astore 9
    //   2233: aload 9
    //   2235: ldc_w 640
    //   2238: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: pop
    //   2242: aload 9
    //   2244: getstatic 641	com/tencent/mobileqq/search/report/UniteSearchReportController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2247: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2250: pop
    //   2251: aload 9
    //   2253: ldc_w 643
    //   2256: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2259: pop
    //   2260: aconst_null
    //   2261: aload 8
    //   2263: aload 9
    //   2265: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2268: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2271: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2274: goto -702 -> 1572
    //   2277: aload 20
    //   2279: instanceof 272
    //   2282: ifeq +11 -> 2293
    //   2285: aload 20
    //   2287: instanceof 645
    //   2290: ifeq +32 -> 2322
    //   2293: aload 20
    //   2295: instanceof 138
    //   2298: ifne +24 -> 2322
    //   2301: aload 20
    //   2303: instanceof 351
    //   2306: ifeq -734 -> 1572
    //   2309: aload 20
    //   2311: checkcast 351	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance
    //   2314: getfield 433	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:jdField_a_of_type_Int	I
    //   2317: bipush 252
    //   2319: if_icmpne -747 -> 1572
    //   2322: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   2325: aload 20
    //   2327: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2330: ifeq -758 -> 1572
    //   2333: getstatic 453	com/tencent/mobileqq/search/util/SearchUtils:b	Ljava/util/HashMap;
    //   2336: aload 20
    //   2338: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2341: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   2344: astore 10
    //   2346: aload 20
    //   2348: instanceof 647
    //   2351: ifeq +329 -> 2680
    //   2354: aload 20
    //   2356: checkcast 647	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem
    //   2359: astore 14
    //   2361: aload 10
    //   2363: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2366: ifne +314 -> 2680
    //   2369: aload 10
    //   2371: iconst_1
    //   2372: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2375: new 275	java/lang/StringBuilder
    //   2378: dup
    //   2379: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2382: astore 15
    //   2384: aload 14
    //   2386: getfield 648	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:a	Ljava/util/List;
    //   2389: ifnull +186 -> 2575
    //   2392: aload 14
    //   2394: getfield 648	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:a	Ljava/util/List;
    //   2397: invokeinterface 558 1 0
    //   2402: ifle +173 -> 2575
    //   2405: iconst_0
    //   2406: istore 4
    //   2408: iload 4
    //   2410: aload 14
    //   2412: getfield 648	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:a	Ljava/util/List;
    //   2415: invokeinterface 558 1 0
    //   2420: if_icmpge +45 -> 2465
    //   2423: aload 15
    //   2425: aload 14
    //   2427: getfield 648	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNewEntranceItem:a	Ljava/util/List;
    //   2430: iload 4
    //   2432: invokeinterface 567 2 0
    //   2437: checkcast 650	com/tencent/mobileqq/search/business/net/model/RelativeWord
    //   2440: getfield 651	com/tencent/mobileqq/search/business/net/model/RelativeWord:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2443: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2446: pop
    //   2447: aload 15
    //   2449: ldc_w 628
    //   2452: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: pop
    //   2456: iload 4
    //   2458: iconst_1
    //   2459: iadd
    //   2460: istore 4
    //   2462: goto -54 -> 2408
    //   2465: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2468: dup
    //   2469: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2472: ldc_w 500
    //   2475: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2478: ldc_w 653
    //   2481: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2484: ldc_w 655
    //   2487: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2490: aload 10
    //   2492: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2495: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2498: aload 17
    //   2500: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2503: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2506: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2509: aload 15
    //   2511: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2514: invokevirtual 635	com/tencent/mobileqq/search/report/ReportModelDC02528:ver4	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2517: ldc_w 573
    //   2520: invokevirtual 638	com/tencent/mobileqq/search/report/ReportModelDC02528:ver5	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2523: astore 14
    //   2525: new 275	java/lang/StringBuilder
    //   2528: dup
    //   2529: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2532: astore 15
    //   2534: aload 15
    //   2536: ldc_w 640
    //   2539: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: pop
    //   2543: aload 15
    //   2545: getstatic 641	com/tencent/mobileqq/search/report/UniteSearchReportController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2548: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2551: pop
    //   2552: aload 15
    //   2554: ldc_w 643
    //   2557: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2560: pop
    //   2561: aconst_null
    //   2562: aload 14
    //   2564: aload 15
    //   2566: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2569: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2572: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2575: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2578: dup
    //   2579: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2582: ldc_w 500
    //   2585: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2588: ldc_w 630
    //   2591: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2594: ldc_w 632
    //   2597: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2600: aload 10
    //   2602: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2605: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2608: aload 17
    //   2610: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2613: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2616: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2619: ldc_w 657
    //   2622: invokevirtual 638	com/tencent/mobileqq/search/report/ReportModelDC02528:ver5	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2625: astore 14
    //   2627: new 275	java/lang/StringBuilder
    //   2630: dup
    //   2631: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2634: astore 15
    //   2636: aload 15
    //   2638: ldc_w 640
    //   2641: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2644: pop
    //   2645: aload 15
    //   2647: getstatic 641	com/tencent/mobileqq/search/report/UniteSearchReportController:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2650: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2653: pop
    //   2654: aload 15
    //   2656: ldc_w 643
    //   2659: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2662: pop
    //   2663: aconst_null
    //   2664: aload 14
    //   2666: aload 15
    //   2668: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2671: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2674: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2677: goto +3 -> 2680
    //   2680: aload 10
    //   2682: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2685: ifne +282 -> 2967
    //   2688: aload 10
    //   2690: iconst_1
    //   2691: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2694: new 467	org/json/JSONObject
    //   2697: dup
    //   2698: invokespecial 468	org/json/JSONObject:<init>	()V
    //   2701: astore 14
    //   2703: aload 14
    //   2705: ldc_w 470
    //   2708: invokestatic 474	com/tencent/mobileqq/search/report/UniteSearchReportController:a	()Ljava/lang/String;
    //   2711: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2714: pop
    //   2715: aload 14
    //   2717: ldc_w 480
    //   2720: aload 11
    //   2722: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2725: pop
    //   2726: aload 14
    //   2728: aload 8
    //   2730: ldc_w 585
    //   2733: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2736: pop
    //   2737: aload 14
    //   2739: aload 9
    //   2741: aload 10
    //   2743: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   2746: invokevirtual 490	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2749: pop
    //   2750: aload 20
    //   2752: instanceof 272
    //   2755: ifeq +61 -> 2816
    //   2758: aload 14
    //   2760: ldc_w 612
    //   2763: aload 20
    //   2765: checkcast 272	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem
    //   2768: getfield 658	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem:f	Ljava/lang/String;
    //   2771: invokevirtual 478	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2774: pop
    //   2775: goto +41 -> 2816
    //   2778: astore 8
    //   2780: new 275	java/lang/StringBuilder
    //   2783: dup
    //   2784: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2787: astore 9
    //   2789: aload 9
    //   2791: aload 12
    //   2793: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2796: pop
    //   2797: aload 9
    //   2799: aload 8
    //   2801: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2804: pop
    //   2805: aload 16
    //   2807: iconst_2
    //   2808: aload 9
    //   2810: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2813: invokestatic 495	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2816: invokestatic 225	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2819: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   2822: checkcast 231	com/tencent/mobileqq/app/QQAppInterface
    //   2825: astore 8
    //   2827: new 497	com/tencent/mobileqq/search/report/ReportModelDC02528
    //   2830: dup
    //   2831: invokespecial 498	com/tencent/mobileqq/search/report/ReportModelDC02528:<init>	()V
    //   2834: ldc_w 500
    //   2837: invokevirtual 504	com/tencent/mobileqq/search/report/ReportModelDC02528:module	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2840: aload 13
    //   2842: invokevirtual 509	com/tencent/mobileqq/search/report/ReportModelDC02528:action	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2845: astore 9
    //   2847: new 275	java/lang/StringBuilder
    //   2850: dup
    //   2851: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2854: astore 11
    //   2856: aload 11
    //   2858: aload 10
    //   2860: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   2863: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2866: pop
    //   2867: aload 11
    //   2869: ldc_w 517
    //   2872: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2875: pop
    //   2876: aload 9
    //   2878: aload 11
    //   2880: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: invokevirtual 520	com/tencent/mobileqq/search/report/ReportModelDC02528:obj1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2886: aload 10
    //   2888: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2891: invokevirtual 526	com/tencent/mobileqq/search/report/ReportModelDC02528:obj2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2894: aload 10
    //   2896: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2899: invokevirtual 531	com/tencent/mobileqq/search/report/ReportModelDC02528:ver1	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2902: aload 17
    //   2904: getfield 25	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:b	I
    //   2907: invokestatic 534	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(I)Ljava/lang/String;
    //   2910: invokevirtual 537	com/tencent/mobileqq/search/report/ReportModelDC02528:ver2	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2913: aload 14
    //   2915: invokevirtual 538	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2918: invokevirtual 541	com/tencent/mobileqq/search/report/ReportModelDC02528:ver7	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2921: astore 9
    //   2923: new 275	java/lang/StringBuilder
    //   2926: dup
    //   2927: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   2930: astore 10
    //   2932: aload 10
    //   2934: aload 8
    //   2936: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2939: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2942: pop
    //   2943: aload 10
    //   2945: getstatic 546	com/tencent/mobileqq/search/util/SearchUtils:d	J
    //   2948: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2951: pop
    //   2952: aload 8
    //   2954: aload 9
    //   2956: aload 10
    //   2958: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2961: invokevirtual 549	com/tencent/mobileqq/search/report/ReportModelDC02528:session_id	(Ljava/lang/String;)Lcom/tencent/mobileqq/search/report/ReportModelDC02528;
    //   2964: invokestatic 552	com/tencent/mobileqq/search/report/UniteSearchReportController:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/search/report/ReportModelDC02528;)V
    //   2967: getstatic 660	com/tencent/mobileqq/search/util/SearchUtils:a	Ljava/util/HashMap;
    //   2970: aload 20
    //   2972: invokevirtual 458	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   2975: ifeq +360 -> 3335
    //   2978: getstatic 660	com/tencent/mobileqq/search/util/SearchUtils:a	Ljava/util/HashMap;
    //   2981: aload 20
    //   2983: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2986: checkcast 464	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo
    //   2989: astore 8
    //   2991: aload 8
    //   2993: getfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   2996: ifne +339 -> 3335
    //   2999: aload 8
    //   3001: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   3004: invokestatic 663	com/tencent/mobileqq/search/util/SearchUtils:a	(J)Z
    //   3007: ifeq +158 -> 3165
    //   3010: aload 8
    //   3012: getfield 665	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_Boolean	Z
    //   3015: ifeq +9 -> 3024
    //   3018: iconst_2
    //   3019: istore 4
    //   3021: goto +6 -> 3027
    //   3024: iconst_1
    //   3025: istore 4
    //   3027: aload 8
    //   3029: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3032: astore 9
    //   3034: new 275	java/lang/StringBuilder
    //   3037: dup
    //   3038: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   3041: astore 10
    //   3043: aload 10
    //   3045: aload 8
    //   3047: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   3050: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3053: pop
    //   3054: aload 10
    //   3056: ldc_w 517
    //   3059: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3062: pop
    //   3063: aload 10
    //   3065: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3068: astore 10
    //   3070: aload 8
    //   3072: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3075: astore 11
    //   3077: new 275	java/lang/StringBuilder
    //   3080: dup
    //   3081: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   3084: astore 12
    //   3086: aload 12
    //   3088: aload 8
    //   3090: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   3093: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3096: pop
    //   3097: aload 12
    //   3099: ldc_w 517
    //   3102: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3105: pop
    //   3106: ldc_w 500
    //   3109: ldc_w 667
    //   3112: iload 4
    //   3114: iconst_0
    //   3115: iconst_4
    //   3116: anewarray 669	java/lang/String
    //   3119: dup
    //   3120: iconst_0
    //   3121: aload 9
    //   3123: aastore
    //   3124: dup
    //   3125: iconst_1
    //   3126: aload 10
    //   3128: aastore
    //   3129: dup
    //   3130: iconst_2
    //   3131: aload 11
    //   3133: aastore
    //   3134: dup
    //   3135: iconst_3
    //   3136: aload 12
    //   3138: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3141: aastore
    //   3142: invokestatic 672	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3145: aload 8
    //   3147: iconst_1
    //   3148: putfield 465	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Boolean	Z
    //   3151: getstatic 660	com/tencent/mobileqq/search/util/SearchUtils:a	Ljava/util/HashMap;
    //   3154: aload 20
    //   3156: checkcast 674	com/tencent/mobileqq/search/model/ISearchResultModel
    //   3159: aload 8
    //   3161: invokevirtual 555	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3164: pop
    //   3165: aload 20
    //   3167: instanceof 351
    //   3170: ifeq +165 -> 3335
    //   3173: aload 20
    //   3175: checkcast 351	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance
    //   3178: astore 9
    //   3180: aload 9
    //   3182: getfield 433	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:jdField_a_of_type_Int	I
    //   3185: bipush 253
    //   3187: if_icmpeq +13 -> 3200
    //   3190: aload 9
    //   3192: getfield 433	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:jdField_a_of_type_Int	I
    //   3195: bipush 252
    //   3197: if_icmpne +138 -> 3335
    //   3200: aload 8
    //   3202: getfield 665	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_Boolean	Z
    //   3205: ifeq +9 -> 3214
    //   3208: iconst_2
    //   3209: istore 4
    //   3211: goto +6 -> 3217
    //   3214: iconst_1
    //   3215: istore 4
    //   3217: aload 8
    //   3219: getfield 528	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3222: astore 9
    //   3224: new 275	java/lang/StringBuilder
    //   3227: dup
    //   3228: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   3231: astore 10
    //   3233: aload 10
    //   3235: aload 8
    //   3237: getfield 512	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Long	J
    //   3240: invokevirtual 515	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3243: pop
    //   3244: aload 10
    //   3246: ldc_w 517
    //   3249: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: pop
    //   3253: aload 10
    //   3255: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3258: astore 10
    //   3260: aload 8
    //   3262: getfield 523	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3265: astore 11
    //   3267: new 275	java/lang/StringBuilder
    //   3270: dup
    //   3271: invokespecial 276	java/lang/StringBuilder:<init>	()V
    //   3274: astore 12
    //   3276: aload 12
    //   3278: aload 8
    //   3280: getfield 487	com/tencent/mobileqq/search/util/SearchUtils$ObjectItemInfo:jdField_a_of_type_Int	I
    //   3283: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3286: pop
    //   3287: aload 12
    //   3289: ldc_w 517
    //   3292: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3295: pop
    //   3296: ldc_w 500
    //   3299: ldc_w 676
    //   3302: iload 4
    //   3304: iconst_0
    //   3305: iconst_4
    //   3306: anewarray 669	java/lang/String
    //   3309: dup
    //   3310: iconst_0
    //   3311: aload 9
    //   3313: aastore
    //   3314: dup
    //   3315: iconst_1
    //   3316: aload 10
    //   3318: aastore
    //   3319: dup
    //   3320: iconst_2
    //   3321: aload 11
    //   3323: aastore
    //   3324: dup
    //   3325: iconst_3
    //   3326: aload 12
    //   3328: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3331: aastore
    //   3332: invokestatic 672	com/tencent/mobileqq/search/util/SearchUtils:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3335: aload 17
    //   3337: aload_2
    //   3338: aload 20
    //   3340: invokespecial 678	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(Landroid/view/View;Lcom/tencent/mobileqq/search/model/IModel;)Z
    //   3343: ifne +8 -> 3351
    //   3346: aconst_null
    //   3347: astore_2
    //   3348: goto +3 -> 3351
    //   3351: iload_1
    //   3352: istore 4
    //   3354: aload 17
    //   3356: iload 4
    //   3358: aload_2
    //   3359: aload_3
    //   3360: invokespecial 680	com/tencent/mobileqq/search/base/adapter/BaseMvpAdapter:getView	(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    //   3363: astore 8
    //   3365: aload 17
    //   3367: iload 4
    //   3369: aload 8
    //   3371: aload 20
    //   3373: invokespecial 682	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(ILandroid/view/View;Lcom/tencent/mobileqq/search/model/IModel;)V
    //   3376: iload 4
    //   3378: ifne +9 -> 3387
    //   3381: iconst_1
    //   3382: istore 6
    //   3384: goto +6 -> 3390
    //   3387: iconst_0
    //   3388: istore 6
    //   3390: iload 6
    //   3392: istore 7
    //   3394: iload 4
    //   3396: iconst_1
    //   3397: if_icmplt +75 -> 3472
    //   3400: aload_0
    //   3401: iload_1
    //   3402: invokevirtual 144	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:getItemViewType	(I)I
    //   3405: istore 5
    //   3407: aload 17
    //   3409: iload 4
    //   3411: iconst_1
    //   3412: isub
    //   3413: invokevirtual 144	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:getItemViewType	(I)I
    //   3416: istore 4
    //   3418: iload 5
    //   3420: bipush 11
    //   3422: if_icmpeq +10 -> 3432
    //   3425: iload 5
    //   3427: bipush 10
    //   3429: if_icmpne +20 -> 3449
    //   3432: iload 4
    //   3434: bipush 11
    //   3436: if_icmpeq +16 -> 3452
    //   3439: iload 4
    //   3441: bipush 10
    //   3443: if_icmpne +6 -> 3449
    //   3446: goto +6 -> 3452
    //   3449: goto +6 -> 3455
    //   3452: iconst_1
    //   3453: istore 6
    //   3455: aload_0
    //   3456: aload 8
    //   3458: aload 20
    //   3460: iload_1
    //   3461: iload 5
    //   3463: iload 4
    //   3465: iload 6
    //   3467: invokespecial 684	com/tencent/mobileqq/search/adapter/GroupSearchAdapter:a	(Landroid/view/View;Lcom/tencent/mobileqq/search/model/IModel;IIIZ)Z
    //   3470: istore 7
    //   3472: aload 8
    //   3474: ifnull +47 -> 3521
    //   3477: aload 8
    //   3479: ldc_w 685
    //   3482: invokevirtual 689	android/view/View:findViewById	(I)Landroid/view/View;
    //   3485: ifnull +36 -> 3521
    //   3488: iload 7
    //   3490: ifeq +19 -> 3509
    //   3493: aload 8
    //   3495: ldc_w 685
    //   3498: invokevirtual 689	android/view/View:findViewById	(I)Landroid/view/View;
    //   3501: bipush 8
    //   3503: invokevirtual 692	android/view/View:setVisibility	(I)V
    //   3506: goto +15 -> 3521
    //   3509: aload 8
    //   3511: ldc_w 685
    //   3514: invokevirtual 689	android/view/View:findViewById	(I)Landroid/view/View;
    //   3517: iconst_0
    //   3518: invokevirtual 692	android/view/View:setVisibility	(I)V
    //   3521: invokestatic 698	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   3524: iload_1
    //   3525: aload_2
    //   3526: aload_3
    //   3527: aload_0
    //   3528: iload_1
    //   3529: invokevirtual 702	com/tencent/mobileqq/search/base/adapter/BaseMvpAdapter:getItemId	(I)J
    //   3532: invokevirtual 706	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   3535: aload 8
    //   3537: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3538	0	this	GroupSearchAdapter
    //   0	3538	1	paramInt	int
    //   0	3538	2	paramView	View
    //   0	3538	3	paramViewGroup	ViewGroup
    //   12	3452	4	i	int
    //   489	2973	5	j	int
    //   3382	84	6	bool1	boolean
    //   3392	97	7	bool2	boolean
    //   55	2674	8	localObject1	Object
    //   2778	22	8	localJSONException1	org.json.JSONException
    //   2825	711	8	localObject2	Object
    //   78	1192	9	localObject3	Object
    //   1356	1	9	localJSONException2	org.json.JSONException
    //   1361	1	9	localJSONException3	org.json.JSONException
    //   1366	1	9	localJSONException4	org.json.JSONException
    //   1371	22	9	localJSONException5	org.json.JSONException
    //   1418	196	9	localQQAppInterface	QQAppInterface
    //   1772	1	9	localJSONException6	org.json.JSONException
    //   1777	1	9	localJSONException7	org.json.JSONException
    //   1782	22	9	localJSONException8	org.json.JSONException
    //   1829	1483	9	localObject4	Object
    //   133	23	10	localJSONException9	org.json.JSONException
    //   181	3136	10	localObject5	Object
    //   22	3300	11	localObject6	Object
    //   26	3301	12	localObject7	Object
    //   17	2824	13	localObject8	Object
    //   142	360	14	localObject9	Object
    //   633	1	14	localJSONException10	org.json.JSONException
    //   638	1	14	localJSONException11	org.json.JSONException
    //   643	22	14	localJSONException12	org.json.JSONException
    //   721	2193	14	localObject10	Object
    //   211	2456	15	localObject11	Object
    //   380	2426	16	localObject12	Object
    //   376	3032	17	localObject13	Object
    //   372	1589	18	localObject14	Object
    //   364	1554	19	localObject15	Object
    //   5	3454	20	localIModel	IModel
    //   404	1477	21	localObject16	Object
    //   395	1488	22	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   80	130	133	org/json/JSONException
    //   606	630	633	org/json/JSONException
    //   595	606	638	org/json/JSONException
    //   583	595	643	org/json/JSONException
    //   1343	1353	1356	org/json/JSONException
    //   1325	1343	1361	org/json/JSONException
    //   1314	1325	1366	org/json/JSONException
    //   1302	1314	1371	org/json/JSONException
    //   1731	1769	1772	org/json/JSONException
    //   1713	1731	1777	org/json/JSONException
    //   1690	1713	1782	org/json/JSONException
    //   2703	2775	2778	org/json/JSONException
  }
  
  public int getViewTypeCount()
  {
    return 64;
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
      Object localObject = a(m);
      int n;
      int i;
      if ((localObject instanceof GroupSearchModeTitle))
      {
        localObject = (GroupSearchModeTitle)localObject;
        n = k + 1;
        ((GroupSearchModeTitle)localObject).a(1, n);
        k = j;
        if (((GroupSearchModeTitle)localObject).b() == 2) {
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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing());
      ((StringBuilder)localObject1).append(", mScrollState : ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      QLog.d("Q.uniteSearch.BaseMvpAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      paramInt1 = this.jdField_a_of_type_Int;
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1);
          IFaceModel localIFaceModel;
          IFacePresenter localIFacePresenter;
          Object localObject2;
          if (((((View)localObject1).getTag(2131380884) instanceof IFaceModel)) && ((((View)localObject1).getTag(2131380886) instanceof IFacePresenter)) && ((((View)localObject1).getTag(2131380889) instanceof IFaceView)))
          {
            localIFaceModel = (IFaceModel)((View)localObject1).getTag(2131380884);
            localIFacePresenter = (IFacePresenter)((View)localObject1).getTag(2131380886);
            localObject2 = (IFaceView)((View)localObject1).getTag(2131380889);
            if ((localIFaceModel.a() == paramInt2) && (paramString.equals(localIFaceModel.a()))) {
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
              localIFaceModel = (IFaceModel)((ViewGroup)localObject2).getChildAt(i).getTag(2131380884);
              if ((localIFaceModel != null) && (localIFaceModel.a() == paramInt2) && (paramString.equals(localIFaceModel.a())))
              {
                localIFacePresenter = (IFacePresenter)((ViewGroup)localObject2).getChildAt(i).getTag(2131380886);
                localObject2 = (IFaceView)((ViewGroup)localObject2).getChildAt(i).getTag(2131380889);
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
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      }
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      int i = 0;
      while (i < k)
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        if ((localObject1 instanceof ViewGroup))
        {
          int j = 0;
          for (;;)
          {
            Object localObject2 = (ViewGroup)localObject1;
            if (j >= ((ViewGroup)localObject2).getChildCount()) {
              break;
            }
            IFaceModel localIFaceModel = (IFaceModel)((ViewGroup)localObject2).getChildAt(j).getTag(2131380884);
            IFacePresenter localIFacePresenter = (IFacePresenter)((ViewGroup)localObject2).getChildAt(j).getTag(2131380886);
            localObject2 = (IFaceView)((ViewGroup)localObject2).getChildAt(j).getTag(2131380889);
            if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
              localIFacePresenter.a(localIFaceModel, (IFaceView)localObject2);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject1 != null) {
      ((AbsListView.OnScrollListener)localObject1).onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeController.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchAdapter
 * JD-Core Version:    0.7.0.1
 */