import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ohp
  extends ohs
  implements oha
{
  private int jdField_a_of_type_Int;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private final String jdField_a_of_type_JavaLangString = "ReadInJoySecondCommentListAdapter";
  private ogo jdField_a_of_type_Ogo;
  private ojp jdField_a_of_type_Ojp;
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  
  public ohp(FragmentActivity paramFragmentActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, ReadInJoySecondCommentListFragment paramReadInJoySecondCommentListFragment, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = paramReadInJoySecondCommentListFragment;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_Oft = new oft();
    this.jdField_a_of_type_Oft.a(a());
    this.jdField_a_of_type_Ogk = new ogk(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
  }
  
  private void a(List<oif> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oif localoif = (oif)paramList.next();
        if ((localoif.a instanceof CommentData)) {
          localoif.a.isAnchor = false;
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  ohg a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a();
    }
    return null;
  }
  
  public oif a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (oif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public oil a()
  {
    return this.jdField_a_of_type_Oil;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    this.jdField_a_of_type_Ohc = null;
    this.jdField_a_of_type_Oil = null;
    this.jdField_a_of_type_Ogo = null;
    this.jdField_a_of_type_Ojp = null;
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.e();
    }
    if (this.jdField_a_of_type_Oil != null) {
      this.jdField_a_of_type_Oil.a(this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(String paramString1, String paramString2, ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Oil = oil.a(paramArticleInfo);
    this.jdField_a_of_type_Ohc = new ohc(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
    if (this.jdField_a_of_type_Oil != null)
    {
      this.jdField_a_of_type_Oil.a(this);
      this.jdField_a_of_type_JavaUtilList.clear();
      paramArticleInfo = this.jdField_a_of_type_Oil.a(paramString1);
      a(paramArticleInfo);
      this.jdField_a_of_type_JavaUtilList.addAll(paramArticleInfo);
      this.jdField_a_of_type_Oil.a(paramString1, paramString2);
      notifyDataSetChanged();
    }
  }
  
  public void a(ogo paramogo)
  {
    this.jdField_a_of_type_Ogo = paramogo;
  }
  
  public void a(oif paramoif)
  {
    super.a(paramoif);
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.a(2, paramoif);
    }
  }
  
  public void a(ojp paramojp)
  {
    this.jdField_a_of_type_Ojp = paramojp;
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.e();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.f();
    }
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    int i = getItemViewType(paramInt);
    Object localObject = paramView;
    switch (i)
    {
    default: 
      localObject = paramView;
    case 1: 
    case 2: 
      if (this.jdField_a_of_type_Ohc != null) {
        this.jdField_a_of_type_Ohc.d(paramInt);
      }
      return localObject;
    case 3: 
      if (paramView == null)
      {
        localObject = new oic();
        paramView = ((oic)localObject).a(this, paramInt, paramView, paramViewGroup);
      }
      for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (oic)paramView.getTag())
      {
        paramViewGroup.a(this, paramInt);
        localObject = paramView;
        break;
      }
    }
    if (oft.a(a(paramInt)))
    {
      paramViewGroup = this.jdField_a_of_type_Oft.a(a(paramInt));
      if (paramView != null) {
        break label288;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
    }
    label288:
    for (;;)
    {
      oft.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
      localObject = paramView;
      break;
      paramViewGroup = ofa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, false, this);
      if (paramView == null) {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
      }
      for (;;)
      {
        ofa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, false);
        localObject = paramView;
        break;
      }
    }
  }
  
  public void onCommentCreate(boolean paramBoolean, oif paramoif, List<oif> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, oif paramoif, boolean paramBoolean2, List<oif> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, oif paramoif, int paramInt2)
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
      while (this.jdField_a_of_type_Ogo != null)
      {
        this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Oil.a());
        return;
        if (this.jdField_a_of_type_Oil != null)
        {
          paramoif = this.jdField_a_of_type_Oil.b(this.jdField_b_of_type_JavaLangString);
          if (!paramoif.isEmpty())
          {
            this.jdField_a_of_type_JavaUtilList.clear();
            this.jdField_a_of_type_JavaUtilList.addAll(paramoif);
            notifyDataSetChanged();
          }
        }
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<oif> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
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
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<oif> paramList, boolean paramBoolean2, int paramInt2)
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
  
  public void onCommentReply(boolean paramBoolean, oif paramoif)
  {
    if (paramBoolean)
    {
      bcql.a(BaseApplication.getContext(), 2, ajya.a(2131712989), 0).a();
      if (this.jdField_a_of_type_Oil != null) {}
      for (paramoif = this.jdField_a_of_type_Oil.b(this.jdField_b_of_type_JavaLangString);; paramoif = new ArrayList())
      {
        if ((!paramoif.isEmpty()) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramoif);
          notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
        }
        if ((this.jdField_a_of_type_Ogo != null) && (this.jdField_a_of_type_Oil != null)) {
          this.jdField_a_of_type_Ogo.a(this.jdField_a_of_type_Oil.a());
        }
        return;
      }
    }
    bcql.a(BaseApplication.getContext(), 1, ajya.a(2131712834), 0).a();
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Ojp != null) {
      this.jdField_a_of_type_Ojp.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    wij.a(1, 2131718368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohp
 * JD-Core Version:    0.7.0.1
 */