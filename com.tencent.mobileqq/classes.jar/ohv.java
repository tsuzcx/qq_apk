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

public abstract class ohv
  extends BaseAdapter
  implements ojt, okv, okz
{
  protected bfob a;
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected List<oii> a;
  protected ofw a;
  protected ogn a;
  protected ogp a;
  protected ohf a;
  protected oid a;
  protected oio a;
  protected boolean a;
  protected int c = -1;
  
  public ohv()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfob = new ohw(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Ogn == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Ogn.a(j);
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
  
  public ohf a()
  {
    return this.jdField_a_of_type_Ohf;
  }
  
  abstract ohj a();
  
  abstract oio a();
  
  public void a(int paramInt)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onCommentTypeChanged | changeToType " + paramInt);
    this.c = paramInt;
    if (this.jdField_a_of_type_Oio != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Oio.a(paramInt));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Oio.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.b(paramInt);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
  }
  
  public void a(Activity paramActivity, View paramView, oii paramoii, bfps parambfps)
  {
    if ((paramActivity == null) || (paramView == null) || (paramoii == null) || (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {
      return;
    }
    boolean bool1 = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isMyself();
    boolean bool2 = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDisliked();
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    View localView = LayoutInflater.from(paramActivity).inflate(2131559839, null);
    Object localObject = (TextView)localView.findViewById(2131378071);
    if ((localObject != null) && (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList != null) && (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.size() > 0))
    {
      if (((oih)paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.get(0)).e <= 0) {
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
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcy.jdField_a_of_type_Boolean) && (localObject != null)) {
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
          str = ajyc.a(2131713054);
        }
      }
      localTextView1 = (TextView)localView.findViewById(2131378323);
      if (!bool1) {
        break;
      }
      localObject = "删除";
      localTextView1.setText((CharSequence)localObject);
      localTextView2 = (TextView)localView.findViewById(2131378136);
      if (!bool2) {
        break label407;
      }
      localObject = ajyc.a(2131712932);
      localTextView2.setText((CharSequence)localObject);
      localBubblePopupWindow.a(localView);
      localBubblePopupWindow.c(true);
      localBubblePopupWindow.b(paramView);
      localBubblePopupWindow.a(true);
      localBubblePopupWindow.a(parambfps);
      if ((paramActivity instanceof FastWebActivity)) {
        ((FastWebActivity)paramActivity).a(localBubblePopupWindow);
      }
      paramActivity = new ohy(this, paramoii, localTextView2, bool2, bool1, paramActivity, localBubblePopupWindow);
      localView.findViewById(2131378111).setOnClickListener(paramActivity);
      localView.findViewById(2131378071).setOnClickListener(paramActivity);
      localTextView1.setOnClickListener(paramActivity);
      localTextView2.setOnClickListener(paramActivity);
      return;
      label380:
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  public void a(Context paramContext, oho paramoho)
  {
    if (paramContext == null) {
      return;
    }
    bfol localbfol = bfol.a(paramContext);
    localbfol.a(2131718368);
    int[] arrayOfInt = new int[5];
    int[] tmp26_24 = arrayOfInt;
    tmp26_24[0] = 2131718362;
    int[] tmp32_26 = tmp26_24;
    tmp32_26[1] = 2131718363;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[2] = 2131718364;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[3] = 2131718365;
    int[] tmp50_44 = tmp44_38;
    tmp50_44[4] = 2131718366;
    tmp50_44;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localbfol.b(arrayOfInt[i]);
      i += 1;
    }
    localbfol.c(2131690596);
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
    localbfol.a(new oia(this, localbfol, arrayOfInt, paramContext, paramoho));
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    ohf localohf;
    if (this.jdField_a_of_type_Oio != null)
    {
      this.jdField_a_of_type_Oio.b(paramString, paramInt1);
      notifyDataSetChanged();
      paramString = this.jdField_a_of_type_Oio.a(paramString);
      if (this.jdField_a_of_type_Ohf != null)
      {
        localohf = this.jdField_a_of_type_Ohf;
        if (!(this instanceof ogq)) {
          break label94;
        }
      }
    }
    label94:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localohf.a(paramInt1, paramString);
      return;
    }
  }
  
  public void a(ogp paramogp)
  {
    this.jdField_a_of_type_Ogp = paramogp;
  }
  
  public void a(oid paramoid)
  {
    this.jdField_a_of_type_Oid = paramoid;
  }
  
  public void a(oii paramoii)
  {
    BaseCommentData localBaseCommentData = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
    for (paramoii = "";; paramoii = localBaseCommentData.nickName)
    {
      paramoii = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718359) + paramoii;
      ohi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramoii, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label111:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Int)) {
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
  
  public void b(oii paramoii)
  {
    if ((paramoii == null) || (paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        ohi.b(paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Ohf != null)
      {
        this.jdField_a_of_type_Ohf.b(paramoii);
        return;
        ohi.a(paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity);
      }
    }
  }
  
  public abstract void c();
  
  public void c(oii paramoii)
  {
    bfol localbfol = bfol.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbfol.a(2131718381);
    localbfol.a(2131718380, 3);
    localbfol.c(2131690596);
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
    localbfol.a(new ohx(this, paramoii, localbfol));
    if (this.jdField_a_of_type_Ohf != null) {
      this.jdField_a_of_type_Ohf.a(paramoii);
    }
  }
  
  protected void d(oii paramoii)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramoii == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
      localObject = onk.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Ohf == null) {
        break;
      }
      this.jdField_a_of_type_Ohf.c(paramoii);
      return;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Int)) {
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
  
  public void e(oii paramoii)
  {
    int j = 1;
    if (paramoii == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramoii.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = ajyc.a(2131712840);
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((oio)localObject).a(str, i);
    } while (this.jdField_a_of_type_Ohf == null);
    Object localObject = this.jdField_a_of_type_Ohf;
    if ((this instanceof ogq)) {}
    for (int i = j;; i = 2)
    {
      ((ohf)localObject).b(i, paramoii);
      return;
      localObject = ajyc.a(2131712943);
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
    oii localoii = (oii)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localoii == null) {
      return -1;
    }
    if (ofw.a(localoii)) {
      return this.jdField_a_of_type_Ofw.a(localoii);
    }
    return ((oii)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Ofw != null) {}
    for (int i = this.jdField_a_of_type_Ofw.a();; i = 0) {
      return i + 8;
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ohv
 * JD-Core Version:    0.7.0.1
 */