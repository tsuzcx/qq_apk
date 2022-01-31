import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.List;

public abstract class nwk
  extends BaseAdapter
  implements nyi, nzk, nzo
{
  protected begh a;
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected List<nwx> a;
  protected nuk a;
  protected nvc a;
  protected nve a;
  protected nvu a;
  protected nws a;
  protected nxd a;
  protected boolean a;
  protected int c = -1;
  
  public nwk()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Begh = new nwl(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Nvc == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Nvc.a(j);
        j += 1;
        i = k + i;
      }
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "calculateScrollYOffsetHeight | firstVisiblePos " + paramInt + " totalHeight " + i);
      return i;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "readToBiuActivity   commonCommentData :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  abstract LayoutInflater a();
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    return getView(paramInt, paramView, paramViewGroup);
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public nvu a()
  {
    return this.jdField_a_of_type_Nvu;
  }
  
  abstract nvy a();
  
  abstract nxd a();
  
  public void a(int paramInt)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onCommentTypeChanged | changeToType " + paramInt);
    this.c = paramInt;
    if (this.jdField_a_of_type_Nxd != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Nxd.a(paramInt));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Nxd.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Nvu != null) {
      this.jdField_a_of_type_Nvu.b(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
  }
  
  public void a(Activity paramActivity, View paramView, nwx paramnwx, behy parambehy)
  {
    if ((paramActivity == null) || (paramView == null) || (paramnwx == null) || (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {
      return;
    }
    boolean bool1 = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isMyself();
    boolean bool2 = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDisliked();
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    View localView = LayoutInflater.from(paramActivity).inflate(2131494268, null);
    Object localObject = (TextView)localView.findViewById(2131312250);
    TextView localTextView1;
    label209:
    TextView localTextView2;
    if ((localObject != null) && (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList != null) && (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.size() > 0))
    {
      if (((nww)paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.get(0)).e > 0) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    else
    {
      if ((localObject != null) && (!this.jdField_a_of_type_Boolean)) {
        ((TextView)localObject).setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.b) && (localObject != null)) {
        ((TextView)localObject).setVisibility(8);
      }
      localTextView1 = (TextView)localView.findViewById(2131312497);
      if (!bool1) {
        break label359;
      }
      localObject = "删除";
      localTextView1.setText((CharSequence)localObject);
      localTextView2 = (TextView)localView.findViewById(2131312312);
      if (!bool2) {
        break label367;
      }
    }
    label359:
    label367:
    for (localObject = ajjy.a(2131647144);; localObject = ajjy.a(2131647266))
    {
      localTextView2.setText((CharSequence)localObject);
      localBubblePopupWindow.a(localView);
      localBubblePopupWindow.c(true);
      localBubblePopupWindow.b(paramView);
      localBubblePopupWindow.a(true);
      localBubblePopupWindow.a(parambehy);
      if ((paramActivity instanceof FastWebActivity)) {
        ((FastWebActivity)paramActivity).a(localBubblePopupWindow);
      }
      paramActivity = new nwn(this, paramnwx, localTextView2, bool2, bool1, paramActivity, localBubblePopupWindow);
      localView.findViewById(2131312291).setOnClickListener(paramActivity);
      localView.findViewById(2131312250).setOnClickListener(paramActivity);
      localTextView1.setOnClickListener(paramActivity);
      localTextView2.setOnClickListener(paramActivity);
      return;
      ((TextView)localObject).setVisibility(0);
      break;
      localObject = "举报";
      break label209;
    }
  }
  
  public void a(Context paramContext, nwd paramnwd)
  {
    if (paramContext == null) {
      return;
    }
    begr localbegr = begr.a(paramContext);
    localbegr.a(2131652549);
    int[] arrayOfInt = new int[5];
    int[] tmp26_24 = arrayOfInt;
    tmp26_24[0] = 2131652543;
    int[] tmp32_26 = tmp26_24;
    tmp32_26[1] = 2131652544;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[2] = 2131652545;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[3] = 2131652546;
    int[] tmp50_44 = tmp44_38;
    tmp50_44[4] = 2131652547;
    tmp50_44;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localbegr.b(arrayOfInt[i]);
      i += 1;
    }
    localbegr.c(2131625035);
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
    localbegr.a(new nwp(this, localbegr, arrayOfInt, paramContext, paramnwd));
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    nvu localnvu;
    if (this.jdField_a_of_type_Nxd != null)
    {
      this.jdField_a_of_type_Nxd.b(paramString, paramInt1);
      notifyDataSetChanged();
      paramString = this.jdField_a_of_type_Nxd.a(paramString);
      if (this.jdField_a_of_type_Nvu != null)
      {
        localnvu = this.jdField_a_of_type_Nvu;
        if (!(this instanceof nvf)) {
          break label94;
        }
      }
    }
    label94:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localnvu.a(paramInt1, paramString);
      return;
    }
  }
  
  public void a(nve paramnve)
  {
    this.jdField_a_of_type_Nve = paramnve;
  }
  
  public void a(nws paramnws)
  {
    this.jdField_a_of_type_Nws = paramnws;
  }
  
  public void a(nwx paramnwx)
  {
    BaseCommentData localBaseCommentData = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    int j = 4;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label111;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      if (!TextUtils.isEmpty(localBaseCommentData.nickName)) {
        break label215;
      }
    }
    label215:
    for (paramnwx = "";; paramnwx = localBaseCommentData.nickName)
    {
      paramnwx = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131652540) + paramnwx;
      nvx.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramnwx, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label111:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (obz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int)) {
        break;
      }
      i = 9;
      break;
    }
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == this.c;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public abstract void b();
  
  public void b(nwx paramnwx)
  {
    if ((paramnwx == null) || (paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        nvx.b(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Nvu != null)
      {
        this.jdField_a_of_type_Nvu.b(paramnwx);
        return;
        nvx.a(paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity);
      }
    }
  }
  
  public abstract void c();
  
  public void c(nwx paramnwx)
  {
    begr localbegr = begr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbegr.a(2131652562);
    localbegr.a(2131652561, 3);
    localbegr.c(2131625035);
    if (!localbegr.isShowing()) {
      localbegr.show();
    }
    localbegr.a(new nwm(this, paramnwx, localbegr));
    if (this.jdField_a_of_type_Nvu != null) {
      this.jdField_a_of_type_Nvu.a(paramnwx);
    }
  }
  
  protected void d(nwx paramnwx)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramnwx == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject2 = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    int i = 4;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() != -1))
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
    }
    for (;;)
    {
      Object localObject1 = ((BaseCommentData)localObject2).commentContent;
      localObject2 = ((BaseCommentData)localObject2).uin;
      localObject1 = obz.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, (String)localObject1, Long.valueOf((String)localObject2).longValue(), 0, j);
      a((Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Nvu == null) {
        break;
      }
      this.jdField_a_of_type_Nvu.c(paramnwx);
      return;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (obz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Int)) {
            i = 9;
          }
        }
        else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGallery != 0)
        {
          j = 10;
          i = 17;
          continue;
        }
        j = 19;
      }
    }
  }
  
  public void e(nwx paramnwx)
  {
    int j = 1;
    if (paramnwx == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramnwx.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = ajjy.a(2131647052);
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((nxd)localObject).a(str, i);
    } while (this.jdField_a_of_type_Nvu == null);
    Object localObject = this.jdField_a_of_type_Nvu;
    if ((this instanceof nvf)) {}
    for (int i = j;; i = 2)
    {
      ((nvu)localObject).b(i, paramnwx);
      return;
      localObject = ajjy.a(2131647155);
      break;
      label116:
      i = 1;
      break label67;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return -1;
    }
    nwx localnwx = (nwx)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localnwx == null) {
      return -1;
    }
    if (nuk.a(localnwx)) {
      return this.jdField_a_of_type_Nuk.a(localnwx);
    }
    return ((nwx)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Nuk != null) {}
    for (int i = this.jdField_a_of_type_Nuk.a();; i = 0) {
      return i + 8;
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nwk
 * JD-Core Version:    0.7.0.1
 */