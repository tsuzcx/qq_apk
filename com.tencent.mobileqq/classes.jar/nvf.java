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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.List;

public class nvf
  extends nwk
  implements nvs
{
  public static int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private nvg jdField_a_of_type_Nvg;
  private nvz jdField_a_of_type_Nvz;
  private nyh jdField_a_of_type_Nyh;
  public int b;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public nvf(FragmentActivity paramFragmentActivity, ReadInJoyCommentListFragment paramReadInJoyCommentListFragment, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_Nvz = paramReadInJoyCommentListFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Nuk = new nuk();
    this.jdField_a_of_type_Nuk.a(a());
    this.jdField_a_of_type_Nvc = new nvc(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Begh);
  }
  
  public nvf(FastWebActivity paramFastWebActivity, ReadInJoyCommentListView paramReadInJoyCommentListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramFastWebActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramFastWebActivity;
    this.jdField_a_of_type_Nvz = paramFastWebActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = paramReadInJoyCommentListView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setRefreshCallback(this);
    this.d = paramInt;
    jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Nuk = new nuk();
    this.jdField_a_of_type_Nuk.a(a());
    this.jdField_a_of_type_Nvc = new nvc(paramReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this);
    paramReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Begh);
  }
  
  private void a(List<nwx> paramList)
  {
    if (this.jdField_a_of_type_Nxd.a() == null) {}
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_Nxd.a();
      if ((((nyg)localObject).jdField_a_of_type_Boolean) && (((nyg)localObject).b != null) && (paramList != null))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject = (nwx)paramList.next();
          if ((localObject != null) && (((nwx)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null) && (((nwx)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor)) {
            ((nwx)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAnchor = false;
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
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Nvz != null) {
      this.jdField_a_of_type_Nvz.b(paramInt);
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
      nwx localnwx = (nwx)this.jdField_a_of_type_JavaUtilList.get(i);
      j = i;
      if (localnwx.jdField_a_of_type_Int == 2) {
        break;
      }
      j = i;
      if (localnwx.jdField_a_of_type_Int == 1) {
        break;
      }
      i += 1;
    }
    label79:
    return -1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_Nxd != null) {
      return this.jdField_a_of_type_Nxd.a(this.c);
    }
    return 0L;
  }
  
  LayoutInflater a()
  {
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  public VafContext a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pcw();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "comment_feeds");
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  nvy a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return null;
  }
  
  public nwx a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (nwx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public nxd a()
  {
    return this.jdField_a_of_type_Nxd;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Nxd.a(this.c, 1);
    QLog.d("ReadInJoyCommentListAdapter", 2, "reloadData | feedsType " + this.c);
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
    this.jdField_a_of_type_Nxd = nxd.a(paramArticleInfo, paramInt2);
    String str;
    if (this.jdField_a_of_type_Nxd != null)
    {
      this.jdField_a_of_type_Nxd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a())) {
        this.jdField_a_of_type_Nxd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b(), paramInt1);
      }
      this.jdField_a_of_type_Nvu = new nvu(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt2);
      this.jdField_a_of_type_Nxd.a(this);
      if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.jdField_a_of_type_JavaLangString)))
      {
        paramArticleInfo = paramAnchorData.jdField_a_of_type_JavaLangString;
        str = paramAnchorData.b;
        if (paramAnchorData.jdField_a_of_type_Boolean) {
          break label262;
        }
      }
    }
    label262:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArticleInfo = new nyg(paramArticleInfo, str, paramBoolean, paramAnchorData.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Nxd.a(paramArticleInfo);
      this.jdField_a_of_type_Nxd.a(paramInt1, 1);
      this.jdField_a_of_type_JavaUtilList.clear();
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(ListView paramListView)
  {
    if (this.jdField_a_of_type_Nxd != null)
    {
      this.jdField_a_of_type_Nxd.b(this.c);
      QLog.d("ReadInJoyCommentListAdapter", 2, "startLoadMore | feedsType " + this.c);
    }
    if (this.jdField_a_of_type_Nvu != null) {
      this.jdField_a_of_type_Nvu.c();
    }
  }
  
  public void a(nvg paramnvg)
  {
    this.jdField_a_of_type_Nvg = paramnvg;
  }
  
  public void a(nwx paramnwx)
  {
    super.a(paramnwx);
    if (this.jdField_a_of_type_Nvu != null) {
      this.jdField_a_of_type_Nvu.a(1, paramnwx);
    }
  }
  
  public void a(nwx paramnwx, SubCommentData paramSubCommentData)
  {
    if ((this.jdField_a_of_type_Nvz != null) && (paramnwx != null) && (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null))
    {
      Object localObject = null;
      if (paramSubCommentData != null) {
        localObject = paramSubCommentData.commentId;
      }
      this.jdField_a_of_type_Nvz.a(true, paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, (String)localObject);
      if (this.jdField_a_of_type_Nvu != null) {
        this.jdField_a_of_type_Nvu.a(paramnwx, paramSubCommentData);
      }
      localObject = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_Nvu != null) {
        this.jdField_a_of_type_Nvu.a(paramnwx, paramSubCommentData);
      }
    }
  }
  
  public void a(nyh paramnyh)
  {
    this.jdField_a_of_type_Nyh = paramnyh;
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
    if (this.jdField_a_of_type_Nxd != null) {
      this.jdField_a_of_type_Nxd.a(this);
    }
    if ((this.jdField_a_of_type_Nvu != null) && (jdField_a_of_type_Int != 1)) {
      this.jdField_a_of_type_Nvu.a(l, 2);
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
      paramViewGroup = this.jdField_a_of_type_Nxd.a().a(paramViewGroup, paramView, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a(paramInt));
      return paramViewGroup;
    }
    if (nuk.a(a(paramInt)))
    {
      paramViewGroup = this.jdField_a_of_type_Nuk.a(a(paramInt));
      if (paramView != null) {
        break label271;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
    }
    label271:
    for (;;)
    {
      nuk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
      if (this.jdField_a_of_type_Nvu != null) {
        this.jdField_a_of_type_Nvu.c(paramInt);
      }
      if (this.jdField_a_of_type_Nws != null) {
        this.jdField_a_of_type_Nws.a(paramInt, paramView);
      }
      paramViewGroup = paramView;
      if (paramView != null) {
        break;
      }
      QLog.d("ReadInJoyCommentListAdapter", 2, "comment convertview is null position " + paramInt + " viewtype " + i + "\n commentItem: " + a(paramInt).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData);
      return paramView;
      paramViewGroup = ntt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, a(paramInt), i, true, this);
      if (paramView == null)
      {
        beoj.a("ReadInJoyCommentAdapter.create convertView");
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup);
        beoj.a();
      }
      for (;;)
      {
        ntt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (Container)paramView, paramViewGroup, this, paramInt, i, true);
        break;
      }
    }
  }
  
  public void h()
  {
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
    if ((localListAdapter instanceof bejx)) {
      localObject = ((bejx)localListAdapter).getWrappedAdapter();
    }
    if ((localObject instanceof qxb))
    {
      localObject = ((qxb)localObject).a().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localListAdapter = (ListAdapter)((Iterator)localObject).next();
      } while (!(localListAdapter instanceof qxe));
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
  
  public void onCommentCreate(boolean paramBoolean, nwx paramnwx, List<nwx> paramList, int paramInt)
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
      b(4);
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
      if (this.jdField_a_of_type_Nvg != null) {
        this.jdField_a_of_type_Nvg.a(this.jdField_a_of_type_Nxd.a(paramInt));
      }
      paramList = a().getIntent().getBundleExtra("bundle");
    } while (paramList == null);
    BaseCommentData localBaseCommentData = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramnwx = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramnwx = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    ohb.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", paramList.getInt("seq"), paramnwx);
    return;
    bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131646996), 0).a();
  }
  
  public void onCommentCreate(boolean paramBoolean1, nwx paramnwx, boolean paramBoolean2, List<nwx> paramList, int paramInt)
  {
    if (!c(paramInt))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentCreate | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt);
      return;
    }
    a(paramBoolean2);
    onCommentCreate(paramBoolean1, paramnwx, paramList, paramInt);
  }
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, nwx paramnwx, int paramInt2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_Nxd == null)) {
      return;
    }
    if (!a(paramInt2))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentDelete | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt2);
      return;
    }
    if (paramInt1 == 1)
    {
      paramnwx = this.jdField_a_of_type_Nxd.a(paramInt2);
      if (paramnwx != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramnwx);
        notifyDataSetChanged();
      }
    }
    for (;;)
    {
      if (getCount() <= 0) {
        b(2);
      }
      if (this.jdField_a_of_type_Nvg == null) {
        break;
      }
      this.jdField_a_of_type_Nvg.a(this.jdField_a_of_type_Nxd.a(paramInt2));
      return;
      if (paramInt1 == 2)
      {
        paramInt1 = 0;
        if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          nwx localnwx = (nwx)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
          if (localnwx.jdField_a_of_type_Int != 0) {}
          for (;;)
          {
            paramInt1 += 1;
            break;
            if (TextUtils.equals(localnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId)) {
              localnwx.a();
            }
          }
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<nwx> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if ("onCommentListLoad first comments " + paramBoolean1 + " feedsType : " + paramInt2 + "\n commentDataListSize " + paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, new Object[] { Integer.valueOf(i) });
      if (paramInt1 == 1) {
        break;
      }
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad  | isNot first level Comment");
      return;
    }
    if (!b(paramInt3))
    {
      QLog.d("ReadInJoyCommentListAdapter", 1, "onCommentListLoad | wrong feedstype , currentFeedsType " + this.c + ", feedsType " + paramInt3);
      return;
    }
    if (!paramBoolean1)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.c();
      }
      b(3);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(paramBoolean2);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      b(4);
      a(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Nyh != null) {
        this.jdField_a_of_type_Nyh.onCommentListLoad(paramInt1, paramBoolean1, paramList, paramBoolean2, paramInt2, paramInt3);
      }
      if (this.jdField_a_of_type_Nvg == null) {
        break;
      }
      long l = this.jdField_a_of_type_Nxd.a(this.c);
      this.jdField_a_of_type_Nvg.a(l);
      QLog.d("ReadInJoyCommentListAdapter", 2, "onCommentListLoad | mCommentNumChangedListener onUpdate feedsType " + this.c + " count : " + l);
      return;
      b(2);
    }
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<nwx> paramList, boolean paramBoolean2, int paramInt2)
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
  
  public void onCommentReply(boolean paramBoolean, nwx paramnwx)
  {
    if (paramnwx == null) {}
    Object localObject;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      bbmy.a(BaseApplication.getContext(), 2, ajjy.a(2131647333), 0).a();
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (nwx)this.jdField_a_of_type_JavaUtilList.get(i);
          if ((localObject == null) || (((nwx)localObject).jdField_a_of_type_Int != 0) || (((nwx)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
          for (;;)
          {
            i += 1;
            break;
            if (TextUtils.equals(((nwx)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId, ((SubCommentData)paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId)) {
              ((nwx)localObject).a();
            }
          }
        }
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Nvg != null) {
        this.jdField_a_of_type_Nvg.a(this.jdField_a_of_type_Nxd.a(this.c));
      }
      localObject = a().getIntent().getBundleExtra("bundle");
    } while (localObject == null);
    BaseCommentData localBaseCommentData = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    paramnwx = "";
    if ((localBaseCommentData instanceof SubCommentData)) {
      paramnwx = ((SubCommentData)localBaseCommentData).parentCommentId;
    }
    ohb.a().a(true, localBaseCommentData.rowKey, localBaseCommentData.commentId, localBaseCommentData.commentContent, localBaseCommentData.level, "onCommentSend", ((Bundle)localObject).getInt("seq"), paramnwx);
    return;
    bbmy.a(BaseApplication.getContext(), 1, ajjy.a(2131647096), 0).a();
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (this.jdField_a_of_type_Nyh != null) {
      this.jdField_a_of_type_Nyh.onCommentStateError(paramInt);
    }
    while (paramInt != 1001) {
      return;
    }
    vvp.a(1, 2131652538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nvf
 * JD-Core Version:    0.7.0.1
 */