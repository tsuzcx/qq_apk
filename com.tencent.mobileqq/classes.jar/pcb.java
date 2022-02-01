import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pcb
  extends pcf
  implements pbl
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private String jdField_a_of_type_JavaLangString;
  private pav jdField_a_of_type_Pav;
  private pfg jdField_a_of_type_Pfg;
  private int b = 0;
  
  public pcb(FragmentActivity paramFragmentActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = paramReadInJoySecondCommentListFragment;
    this.b = paramInt;
    this.jdField_a_of_type_Pab = new pab();
    this.jdField_a_of_type_Pab.a(a());
    this.jdField_a_of_type_Par = new par(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void a(List<pdp> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        pdp localpdp = (pdp)paramList.next();
        if ((localpdp.a instanceof CommentData)) {
          localpdp.a.isAnchor = false;
        }
      }
    }
  }
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qxj();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  pbs a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
    return null;
  }
  
  public pdp a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (pdp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public pdv a()
  {
    return this.jdField_a_of_type_Pdv;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Pbn != null) {
      this.jdField_a_of_type_Pbn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
    }
    if (this.jdField_a_of_type_Pdv != null)
    {
      this.jdField_a_of_type_Pdv.a(this);
      this.jdField_a_of_type_Pdv.d();
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    this.jdField_a_of_type_Pbn = null;
    this.jdField_a_of_type_Pdv = null;
    this.jdField_a_of_type_Pav = null;
    this.jdField_a_of_type_Pfg = null;
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Pbn != null) {
      this.jdField_a_of_type_Pbn.d();
    }
    if (this.jdField_a_of_type_Pdv != null) {
      this.jdField_a_of_type_Pdv.c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString1, String paramString2, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Pdv = pdv.a(paramArticleInfo);
    this.jdField_a_of_type_Pbn = new pbn(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
    if (this.jdField_a_of_type_Pdv != null)
    {
      this.jdField_a_of_type_Pdv.a(this);
      this.jdField_a_of_type_JavaUtilList.clear();
      paramArticleInfo = this.jdField_a_of_type_Pdv.a(paramString1);
      a(paramArticleInfo);
      this.jdField_a_of_type_JavaUtilList.addAll(paramArticleInfo);
      this.jdField_a_of_type_Pdv.a(paramString1, paramString2);
      notifyDataSetChanged();
    }
  }
  
  public void a(pav parampav)
  {
    this.jdField_a_of_type_Pav = parampav;
  }
  
  public void a(pdp parampdp)
  {
    super.a(parampdp);
    if (this.jdField_a_of_type_Pbn != null) {
      this.jdField_a_of_type_Pbn.a(2, parampdp);
    }
  }
  
  public void a(pfg parampfg)
  {
    this.jdField_a_of_type_Pfg = parampfg;
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qxj();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    Object localObject1 = paramView;
    if (paramView != null)
    {
      localObject1 = paramView;
      if (paramView.getTag() != null)
      {
        localObject1 = paramView;
        if ((paramView.getTag() instanceof String))
        {
          localObject1 = paramView;
          if ("non_null_convertview".equalsIgnoreCase((String)paramView.getTag()))
          {
            localObject1 = null;
            QLog.d("ReadInJoySecondCommentListAdapter", 1, "getView | sub comment reset NonNullView");
          }
        }
      }
    }
    int i = getItemViewType(paramInt);
    label219:
    Object localObject2;
    switch (i)
    {
    case 1: 
    case 2: 
    default: 
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_Pbn != null) {
        this.jdField_a_of_type_Pbn.d(paramInt);
      }
      if (paramView == null)
      {
        localObject1 = new StringBuilder().append("getView | sub comment convertview is null ; position ").append(paramInt).append(" viewtype ").append(i).append("\n commentItem: ");
        if (a(paramInt) != null)
        {
          paramView = a(paramInt).a;
          localObject1 = paramView;
          QLog.d("ReadInJoySecondCommentListAdapter", 1, (String)localObject1);
          QLog.d("ReadInJoySecondCommentListAdapter", 1, (String)localObject1);
          paramView = a();
          AIOUtils.catchedExceptionInReleaseV2("ReadInJoySecondCommentListAdapter", "sub comment convertview is null", new NullPointerException((String)localObject1));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
        }
      }
      break;
    case 3: 
      if (localObject1 == null)
      {
        localObject2 = new pco();
        localObject1 = ((pco)localObject2).a(this, paramInt, (View)localObject1, paramViewGroup);
      }
      for (;;)
      {
        paramView = (View)localObject1;
        if (localObject2 == null) {
          break;
        }
        ((pco)localObject2).a(this, paramInt);
        paramView = (View)localObject1;
        break;
        localObject2 = (pco)((View)localObject1).getTag();
      }
    case 0: 
    case 4: 
    case 5: 
      label268:
      if (pab.a(a(paramInt)))
      {
        localObject2 = this.jdField_a_of_type_Pab.a(a(paramInt));
        if ((localObject1 != null) && ((localObject1 instanceof Container))) {
          break label505;
        }
      }
      break;
    }
    label505:
    for (paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject2);; paramView = (View)localObject1)
    {
      pab.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, (TemplateBean)localObject2, this, paramInt, i, true);
      break;
      localObject2 = ozx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, false, this);
      if ((localObject1 == null) || (!(localObject1 instanceof Container))) {}
      for (paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject2);; paramView = (View)localObject1)
      {
        ozx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, (TemplateBean)localObject2, this, paramInt, i, false);
        break;
        paramView = "commentData is null";
        break label219;
        break label268;
      }
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, pdp parampdp, List<pdp> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, pdp parampdp, boolean paramBoolean2, List<pdp> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, pdp parampdp, int paramInt2)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      if (!a(paramInt2))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentDelete | wrong firstFeedsType");
        return;
      }
      if (paramInt1 == 1) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.c();
        }
      }
      while (this.jdField_a_of_type_Pav != null)
      {
        this.jdField_a_of_type_Pav.a(this.jdField_a_of_type_Pdv.a());
        return;
        if (this.jdField_a_of_type_Pdv != null)
        {
          parampdp = this.jdField_a_of_type_Pdv.b(this.jdField_a_of_type_JavaLangString);
          if (!parampdp.isEmpty())
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(parampdp);
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 2) {}
    do
    {
      return;
      QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad sub comments " + paramBoolean1 + " flowType : " + paramInt2);
      if (!a(paramInt3))
      {
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentListLoad | wrong firstFeedsType");
        return;
      }
    } while ((!paramBoolean1) || (this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
    a(paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
    notifyDataSetChanged();
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<pdp> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 2) {}
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore sub comments " + paramBoolean1);
        if (!a(paramInt2))
        {
          QLog.d("ReadInJoySecondCommentListAdapter", 1, "onCommentLoadMore | wrong firstFeedsType");
          return;
        }
        if (!paramBoolean1) {
          break;
        }
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.c();
  }
  
  public void onCommentReply(boolean paramBoolean, pdp parampdp)
  {
    if (paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 2, anvx.a(2131712440), 0).a();
      if (this.jdField_a_of_type_Pdv != null) {}
      for (parampdp = this.jdField_a_of_type_Pdv.b(this.jdField_a_of_type_JavaLangString);; parampdp = new ArrayList())
      {
        if ((!parampdp.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(parampdp);
          notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
        }
        if ((this.jdField_a_of_type_Pav != null) && (this.jdField_a_of_type_Pdv != null)) {
          this.jdField_a_of_type_Pav.a(this.jdField_a_of_type_Pdv.a());
        }
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), 1, anvx.a(2131712285), 0).a();
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Pfg != null) {
      this.jdField_a_of_type_Pfg.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    znl.a(1, 2131717644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcb
 * JD-Core Version:    0.7.0.1
 */