import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class ola
  extends omg
  implements olo
{
  public static int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private olb jdField_a_of_type_Olb;
  private olv jdField_a_of_type_Olv;
  private ood jdField_a_of_type_Ood;
  public int b;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public ola(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_Olv = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Okf = new okf();
    this.jdField_a_of_type_Okf.a(a());
    this.jdField_a_of_type_Okx = new okx(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
  }
  
  public ola(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFastWebActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFastWebActivity;
    this.jdField_a_of_type_Olv = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Okf = new okf();
    this.jdField_a_of_type_Okf.a(a());
    this.jdField_a_of_type_Okx = new okx(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Olv != null) {
      this.jdField_a_of_type_Olv.b(paramInt);
    }
  }
  
  private void a(List<omt> paramList)
  {
    if (this.jdField_a_of_type_Omz.a() == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Omz.a();
      if ((((ooc)localObject).jdField_a_of_type_Boolean) && (((ooc)localObject).b != null) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (omt)paramList.next();
          if ((localObject != null) && (((omt)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (((omt)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor)) {
            ((omt)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i = 0;
    View localView;
    if ((paramBoolean) && (a() != null))
    {
      this.e = a().getFirstVisiblePosition();
      localView = a().getChildAt(0);
      if (localView != null) {
        break label43;
      }
    }
    for (;;)
    {
      this.f = i;
      return;
      label43:
      i = localView.getTop();
    }
  }
  
  private boolean b(int paramInt)
  {
    if ((this.c == 5) && ((paramInt == 3) || (paramInt == 2) || (paramInt == 5))) {
      this.c = paramInt;
    }
    while (this.c == paramInt) {
      return true;
    }
    return false;
  }
  
  private boolean c(int paramInt)
  {
    if ((paramInt == 2) && ((this.c == 2) || (this.c == 3))) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "checkCommentCreateFeedsType");
    }
    while (this.c == paramInt) {
      return true;
    }
    return false;
  }
  
  public int a()
  {
    int j;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label79;
      }
      omt localomt = (omt)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localomt.jdField_a_of_type_Int == 2) {
        break;
      }
      j = i;
      if (localomt.jdField_a_of_type_Int == 1) {
        break;
      }
      i += 1;
    }
    label79:
    return -1;
  }
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new put();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  olu a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public omt a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (omt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public omz a()
  {
    return this.jdField_a_of_type_Omz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Omz != null)
    {
      this.jdField_a_of_type_Omz.a(this.c, 1);
      QLog.d("ReadInJoyCommentListAdapter", 2, "reloadData | feedsType " + this.c);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    QLog.d("ReadInJoyCommentListAdapter", 2, "initArticleCommentInfoModule | articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + "; contentSrc : " + paramInt + " reqFeedsType Default 5 currentFeedsType " + this.c);
    a(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyCommentListAdapter", 1, "initArticleCommentInfoModule | reqFeedsType " + paramInt1 + " ; currentFeedsType " + this.c + " ; articleInfo " + paramArticleInfo + "; anchorData : " + paramAnchorData + ";feedsType ：" + paramInt1 + "; contentSrc : " + paramInt2);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.c = paramInt1;
    this.jdField_a_of_type_Omz = omz.a(paramArticleInfo, paramInt2);
    String str;
    if (this.jdField_a_of_type_Omz != null)
    {
      this.jdField_a_of_type_Omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a())) {
        this.jdField_a_of_type_Omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b(), paramInt1);
      }
      this.jdField_a_of_type_Olq = new olq(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt2);
      this.jdField_a_of_type_Omz.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
      {
        paramArticleInfo = paramAnchorData.jdField_a_of_type_JavaLangString;
        str = paramAnchorData.b;
        if (paramAnchorData.jdField_a_of_type_Boolean) {
          break label261;
        }
      }
    }
    label261:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArticleInfo = new ooc(paramArticleInfo, str, paramBoolean, paramAnchorData.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Omz.a(paramArticleInfo);
      this.jdField_a_of_type_Omz.a(paramInt1, 1);
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Omz != null)
    {
      this.jdField_a_of_type_Omz.b(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, "startLoadMore | feedsType " + this.c);
    }
    if (this.jdField_a_of_type_Olq != null) {
      this.jdField_a_of_type_Olq.b();
    }
  }
  
  public void a(olb paramolb)
  {
    this.jdField_a_of_type_Olb = paramolb;
  }
  
  public void a(omt paramomt)
  {
    super.a(paramomt);
    if (this.jdField_a_of_type_Olq != null) {
      this.jdField_a_of_type_Olq.a(1, paramomt);
    }
  }
  
  public void a(omt paramomt, SubCommentData paramSubCommentData)
  {
    if ((this.jdField_a_of_type_Olv != null) && (paramomt != null) && (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null))
    {
      String str = null;
      if (paramSubCommentData != null) {
        str = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_Olv.a(true, paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, str);
      if (this.jdField_a_of_type_Olq != null) {
        this.jdField_a_of_type_Olq.a(paramomt, paramSubCommentData);
      }
    }
  }
  
  public void a(ood paramood)
  {
    this.jdField_a_of_type_Ood = paramood;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c();
    }
  }
  
  public void d()
  {
    long l = 0L;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    if (this.jdField_a_of_type_Omz != null) {
      this.jdField_a_of_type_Omz.a(this);
    }
    if ((this.jdField_a_of_type_Olq != null) && (jdField_a_of_type_Int != 1)) {
      this.jdField_a_of_type_Olq.a(l, 2);
    }
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = null;
    }
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
  }
  
  public void g()
  {
    if ((a() != null) && (this.e > -1)) {
      a().setSelectionFromTop(this.e, this.f);
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = a();
    int i = getItemViewType(paramInt);
    if (i == 6)
    {
      paramViewGroup = this.jdField_a_of_type_Omz.a().a(paramViewGroup, paramView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a(paramInt));
      return paramViewGroup;
    }
    if (okf.a(a(paramInt)))
    {
      paramViewGroup = this.jdField_a_of_type_Okf.a(a(paramInt));
      if (paramView != null) {
        break label271;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
    }
    label271:
    for (;;)
    {
      okf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
      if (this.jdField_a_of_type_Olq != null) {
        this.jdField_a_of_type_Olq.c(paramInt);
      }
      if (this.jdField_a_of_type_Omo != null) {
        this.jdField_a_of_type_Omo.a(paramInt, paramView);
      }
      paramViewGroup = paramView;
      if (paramView != null) {
        break;
      }
      QLog.d("ReadInJoyCommentListAdapter", 2, "comment convertview is null position " + paramInt + " viewtype " + i + "\n commentItem: " + a(paramInt).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
      return paramView;
      paramViewGroup = ojm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, true, this);
      if (paramView == null)
      {
        biby.a("ReadInJoyCommentAdapter.create convertView");
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
        biby.a();
      }
      for (;;)
      {
        ojm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
        break;
      }
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    int j = a();
    if (this.d != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPosition(j);
      QLog.d("ReadInJoyCommentListAdapter", 2, "scrollToComment | contentSrc " + this.d + "; titlePos " + j);
      return;
    }
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof bhxm)) {
      localObject = ((bhxm)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof rzr))
    {
      localObject = ((rzr)localObject).a().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
      } while (!(localListAdapter instanceof rzv));
    }
    for (int i = localListAdapter.getCount();; i = -1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "scrollToComment | articleItemCnt: " + i + " titlePos : " + j);
      if (i != -1) {
        i += j;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPositionFromTop(i, 0);
        return;
        i = j;
      }
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
  
  public void onCommentCreate(boolean paramBoolean, omt paramomt, List<omt> paramList, int paramInt)
  {
    if (!c(paramInt)) {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
    }
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      int i = 2131718801;
      if (oij.a()) {
        i = 2131718746;
      }
      QQToast.a(BaseApplication.getContext(), 2, i, 0).a();
      a(4);
      if ((paramList != null) && (paramList.size() > 0))
      {
        QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentCreate commentViewItemList size " + paramList.size());
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(paramList);
          notifyDataSetChanged();
          e();
        }
      }
      if (this.jdField_a_of_type_Olb != null) {
        this.jdField_a_of_type_Olb.a(this.jdField_a_of_type_Omz.a(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
    } while (paramList == null);
    BaseCommentData localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramomt = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramomt = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    oxb.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", paramList.getInt("seq"), paramomt);
    return;
    QQToast.a(BaseApplication.getContext(), 1, alud.a(2131713179), 0).a();
  }
  
  public void onCommentCreate(boolean paramBoolean1, omt paramomt, boolean paramBoolean2, List<omt> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
      return;
    }
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramomt, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, omt paramomt, int paramInt2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Omz == null)) {
      return;
    }
    if (!a(paramInt2))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentDelete | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      paramomt = this.jdField_a_of_type_Omz.a(paramInt2);
      if ((paramomt != null) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramomt);
        notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if (getCount() <= 0) {
        a(2);
      }
      if (this.jdField_a_of_type_Olb == null) {
        break;
      }
      this.jdField_a_of_type_Olb.a(this.jdField_a_of_type_Omz.a(paramInt2));
      return;
      if ((paramInt1 == 2) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          omt localomt = (omt)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if ((localomt == null) || (localomt.jdField_a_of_type_Int != 0)) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if ((paramomt != null) && (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (TextUtils.equals(localomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId))) {
              localomt.a();
            }
          }
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<omt> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 1)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad  | isNot first level Comment");
      return;
    }
    if (!b(paramInt3))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt3);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("onCommentListLoad first comments ").append(paramBoolean1).append(" feedsType : ").append(paramInt2).append("\n commentDataListSize ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, i);
      if (paramBoolean1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.c();
      }
      a(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      a(4);
      a(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ood != null) {
        this.jdField_a_of_type_Ood.onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_Olb == null) {
        break;
      }
      long l = this.jdField_a_of_type_Omz.a(this.c);
      this.jdField_a_of_type_Olb.a(l);
      QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentListLoad | mCommentNumChangedListener onUpdate feedsType " + this.c + " count : " + l);
      return;
      a(2);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<omt> paramList, boolean paramBoolean2, int paramInt2)
  {
    if (paramInt1 != 1) {}
    do
    {
      do
      {
        return;
        if (!a(paramInt2))
        {
          QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentLoadMore | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
          return;
        }
        if (!paramBoolean1) {
          break;
        }
      } while ((this.jdField_a_of_type_JavaUtilList == null) || (paramList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null));
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
      notifyDataSetChanged();
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
  }
  
  public void onCommentReply(boolean paramBoolean, omt paramomt)
  {
    if (paramomt == null) {}
    Object localObject;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      QQToast.a(BaseApplication.getContext(), 2, alud.a(2131713516), 0).a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (omt)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject == null) || (((omt)localObject).jdField_a_of_type_Int != 0) || (((omt)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
          for (;;)
          {
            i += 1;
            break;
            if (TextUtils.equals(((omt)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId)) {
              ((omt)localObject).a();
            }
          }
        }
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Olb != null) {
        this.jdField_a_of_type_Olb.a(this.jdField_a_of_type_Omz.a(this.c));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
    } while (localObject == null);
    BaseCommentData localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramomt = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramomt = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    oxb.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramomt);
    return;
    QQToast.a(BaseApplication.getContext(), 1, alud.a(2131713279), 0).a();
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Ood != null) {
      this.jdField_a_of_type_Ood.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    ybk.a(1, 2131718787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ola
 * JD-Core Version:    0.7.0.1
 */