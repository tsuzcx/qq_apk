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

public abstract class ohs
  extends BaseAdapter
  implements ojq, oks, okw
{
  protected bfos a;
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected List<oif> a;
  protected oft a;
  protected ogk a;
  protected ogm a;
  protected ohc a;
  protected oia a;
  protected oil a;
  protected boolean a;
  protected int c = -1;
  
  public ohs()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfos = new oht(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Ogk == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Ogk.a(j);
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
  
  public ohc a()
  {
    return this.jdField_a_of_type_Ohc;
  }
  
  abstract ohg a();
  
  abstract oil a();
  
  public void a(int paramInt)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onCommentTypeChanged | changeToType " + paramInt);
    this.c = paramInt;
    if (this.jdField_a_of_type_Oil != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Oil.a(paramInt));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Oil.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.b(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
  }
  
  public void a(Activity paramActivity, View paramView, oif paramoif, bfqj parambfqj)
  {
    if ((paramActivity == null) || (paramView == null) || (paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {
      return;
    }
    boolean bool1 = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isMyself();
    boolean bool2 = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDisliked();
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    View localView = LayoutInflater.from(paramActivity).inflate(2131559839, null);
    Object localObject = (TextView)localView.findViewById(2131378074);
    if ((localObject != null) && (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList != null) && (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.size() > 0))
    {
      if (((oie)paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.get(0)).e <= 0) {
        break label380;
      }
      ((TextView)localObject).setVisibility(8);
    }
    for (;;)
    {
      if ((localObject != null) && (!this.jdField_a_of_type_Boolean)) {
        ((TextView)localObject).setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.b) && (localObject != null)) {
        ((TextView)localObject).setVisibility(8);
      }
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcv.jdField_a_of_type_Boolean) && (localObject != null)) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          TextView localTextView1;
          TextView localTextView2;
          localNullPointerException.printStackTrace();
          continue;
          String str = "举报";
          continue;
          str = ajya.a(2131713065);
        }
      }
      localTextView1 = (TextView)localView.findViewById(2131378326);
      if (!bool1) {
        break;
      }
      localObject = "删除";
      localTextView1.setText((CharSequence)localObject);
      localTextView2 = (TextView)localView.findViewById(2131378139);
      if (!bool2) {
        break label407;
      }
      localObject = ajya.a(2131712943);
      localTextView2.setText((CharSequence)localObject);
      localBubblePopupWindow.a(localView);
      localBubblePopupWindow.c(true);
      localBubblePopupWindow.b(paramView);
      localBubblePopupWindow.a(true);
      localBubblePopupWindow.a(parambfqj);
      if ((paramActivity instanceof FastWebActivity)) {
        ((FastWebActivity)paramActivity).a(localBubblePopupWindow);
      }
      paramActivity = new ohv(this, paramoif, localTextView2, bool2, bool1, paramActivity, localBubblePopupWindow);
      localView.findViewById(2131378114).setOnClickListener(paramActivity);
      localView.findViewById(2131378074).setOnClickListener(paramActivity);
      localTextView1.setOnClickListener(paramActivity);
      localTextView2.setOnClickListener(paramActivity);
      return;
      label380:
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  public void a(Context paramContext, ohl paramohl)
  {
    if (paramContext == null) {
      return;
    }
    bfpc localbfpc = bfpc.a(paramContext);
    localbfpc.a(2131718379);
    int[] arrayOfInt = new int[5];
    int[] tmp26_24 = arrayOfInt;
    tmp26_24[0] = 2131718373;
    int[] tmp32_26 = tmp26_24;
    tmp32_26[1] = 2131718374;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[2] = 2131718375;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[3] = 2131718376;
    int[] tmp50_44 = tmp44_38;
    tmp50_44[4] = 2131718377;
    tmp50_44;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localbfpc.b(arrayOfInt[i]);
      i += 1;
    }
    localbfpc.c(2131690596);
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
    localbfpc.a(new ohx(this, localbfpc, arrayOfInt, paramContext, paramohl));
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    ohc localohc;
    if (this.jdField_a_of_type_Oil != null)
    {
      this.jdField_a_of_type_Oil.b(paramString, paramInt1);
      notifyDataSetChanged();
      paramString = this.jdField_a_of_type_Oil.a(paramString);
      if (this.jdField_a_of_type_Ohc != null)
      {
        localohc = this.jdField_a_of_type_Ohc;
        if (!(this instanceof ogn)) {
          break label94;
        }
      }
    }
    label94:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localohc.a(paramInt1, paramString);
      return;
    }
  }
  
  public void a(ogm paramogm)
  {
    this.jdField_a_of_type_Ogm = paramogm;
  }
  
  public void a(oia paramoia)
  {
    this.jdField_a_of_type_Oia = paramoia;
  }
  
  public void a(oif paramoif)
  {
    BaseCommentData localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
    for (paramoif = "";; paramoif = localBaseCommentData.nickName)
    {
      paramoif = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718370) + paramoif;
      ohf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramoif, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label111:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int)) {
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
  
  public void b(oif paramoif)
  {
    if ((paramoif == null) || (paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        ohf.b(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Ohc != null)
      {
        this.jdField_a_of_type_Ohc.b(paramoif);
        return;
        ohf.a(paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity);
      }
    }
  }
  
  public abstract void c();
  
  public void c(oif paramoif)
  {
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbfpc.a(2131718392);
    localbfpc.a(2131718391, 3);
    localbfpc.c(2131690596);
    if (!localbfpc.isShowing()) {
      localbfpc.show();
    }
    localbfpc.a(new ohu(this, paramoif, localbfpc));
    if (this.jdField_a_of_type_Ohc != null) {
      this.jdField_a_of_type_Ohc.a(paramoif);
    }
  }
  
  protected void d(oif paramoif)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramoif == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    int i = 4;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() != -1))
    {
      j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
    }
    for (;;)
    {
      String str1 = ((BaseCommentData)localObject).commentContent;
      String str2 = ((BaseCommentData)localObject).uin;
      localObject = onh.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Ohc == null) {
        break;
      }
      this.jdField_a_of_type_Ohc.c(paramoif);
      return;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qda.jdField_a_of_type_Int)) {
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
  
  public void e(oif paramoif)
  {
    int j = 1;
    if (paramoif == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramoif.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = ajya.a(2131712851);
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((oil)localObject).a(str, i);
    } while (this.jdField_a_of_type_Ohc == null);
    Object localObject = this.jdField_a_of_type_Ohc;
    if ((this instanceof ogn)) {}
    for (int i = j;; i = 2)
    {
      ((ohc)localObject).b(i, paramoif);
      return;
      localObject = ajya.a(2131712954);
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
    oif localoif = (oif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localoif == null) {
      return -1;
    }
    if (oft.a(localoif)) {
      return this.jdField_a_of_type_Oft.a(localoif);
    }
    return ((oif)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Oft != null) {}
    for (int i = this.jdField_a_of_type_Oft.a();; i = 0) {
      return i + 8;
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohs
 * JD-Core Version:    0.7.0.1
 */