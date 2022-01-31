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
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;
import java.util.List;

public abstract class omg
  extends BaseAdapter
  implements ooe, opg
{
  protected bhpo a;
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected List<omt> a;
  protected okf a;
  protected okx a;
  protected okz a;
  protected olq a;
  protected omo a;
  protected omz a;
  protected boolean a;
  protected int c = -1;
  
  public omg()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhpo = new omh(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Okx == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Okx.a(j);
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
  
  public olq a()
  {
    return this.jdField_a_of_type_Olq;
  }
  
  abstract olu a();
  
  abstract omz a();
  
  public void a(Activity paramActivity, View paramView, omt paramomt, bhrf parambhrf)
  {
    if ((paramActivity == null) || (paramView == null) || (paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {
      return;
    }
    boolean bool1 = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isMyself();
    boolean bool2 = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isDisliked();
    BubblePopupWindow localBubblePopupWindow = new BubblePopupWindow(-2, -2);
    View localView = LayoutInflater.from(paramActivity).inflate(2131559933, null);
    Object localObject = (TextView)localView.findViewById(2131378625);
    if ((localObject != null) && (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList != null) && (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.size() > 0))
    {
      if (((oms)paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList.get(0)).e <= 0) {
        break label342;
      }
      ((TextView)localObject).setVisibility(8);
    }
    for (;;)
    {
      if ((localObject != null) && (!this.jdField_a_of_type_Boolean)) {
        ((TextView)localObject).setVisibility(8);
      }
      try
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmr.jdField_a_of_type_Boolean) && (localObject != null)) {
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
          str = alpo.a(2131713437);
        }
      }
      localTextView1 = (TextView)localView.findViewById(2131378916);
      if (!bool1) {
        break;
      }
      localObject = "删除";
      localTextView1.setText((CharSequence)localObject);
      localTextView2 = (TextView)localView.findViewById(2131378696);
      if (!bool2) {
        break label368;
      }
      localObject = alpo.a(2131713315);
      localTextView2.setText((CharSequence)localObject);
      localBubblePopupWindow.a(localView);
      localBubblePopupWindow.c(true);
      localBubblePopupWindow.b(paramView);
      localBubblePopupWindow.a(true);
      localBubblePopupWindow.a(parambhrf);
      if ((paramActivity instanceof FastWebActivity)) {
        ((FastWebActivity)paramActivity).a(localBubblePopupWindow);
      }
      paramActivity = new omj(this, paramomt, localTextView2, bool2, bool1, paramActivity, localBubblePopupWindow);
      localView.findViewById(2131378670).setOnClickListener(paramActivity);
      localView.findViewById(2131378625).setOnClickListener(paramActivity);
      localTextView1.setOnClickListener(paramActivity);
      localTextView2.setOnClickListener(paramActivity);
      return;
      label342:
      ((TextView)localObject).setVisibility(0);
    }
  }
  
  public void a(Context paramContext, olz paramolz)
  {
    if (paramContext == null) {
      return;
    }
    bhpy localbhpy = bhpy.a(paramContext);
    localbhpy.a(2131718787);
    int[] arrayOfInt = new int[5];
    int[] tmp26_24 = arrayOfInt;
    tmp26_24[0] = 2131718781;
    int[] tmp32_26 = tmp26_24;
    tmp32_26[1] = 2131718782;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[2] = 2131718783;
    int[] tmp44_38 = tmp38_32;
    tmp44_38[3] = 2131718784;
    int[] tmp50_44 = tmp44_38;
    tmp50_44[4] = 2131718785;
    tmp50_44;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localbhpy.b(arrayOfInt[i]);
      i += 1;
    }
    localbhpy.c(2131690648);
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
    localbhpy.a(new oml(this, localbhpy, arrayOfInt, paramContext, paramolz));
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    olq localolq;
    if (this.jdField_a_of_type_Omz != null)
    {
      this.jdField_a_of_type_Omz.b(paramString, paramInt1);
      notifyDataSetChanged();
      paramString = this.jdField_a_of_type_Omz.a(paramString);
      if (this.jdField_a_of_type_Olq != null)
      {
        localolq = this.jdField_a_of_type_Olq;
        if (!(this instanceof ola)) {
          break label94;
        }
      }
    }
    label94:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localolq.a(paramInt1, paramString);
      return;
    }
  }
  
  public void a(okz paramokz)
  {
    this.jdField_a_of_type_Okz = paramokz;
  }
  
  public void a(omo paramomo)
  {
    this.jdField_a_of_type_Omo = paramomo;
  }
  
  public void a(omt paramomt)
  {
    BaseCommentData localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
    for (paramomt = "";; paramomt = localBaseCommentData.nickName)
    {
      paramomt = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718778) + paramomt;
      olt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramomt, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label111:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int)) {
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
  
  public void b(omt paramomt)
  {
    if ((paramomt == null) || (paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        olt.b(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Olq != null)
      {
        this.jdField_a_of_type_Olq.b(paramomt);
        return;
        olt.a(paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity);
      }
    }
  }
  
  public void c(omt paramomt)
  {
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbhpy.a(2131718809);
    localbhpy.a(2131718808, 3);
    localbhpy.c(2131690648);
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
    localbhpy.a(new omi(this, paramomt, localbhpy));
    if (this.jdField_a_of_type_Olq != null) {
      this.jdField_a_of_type_Olq.a(paramomt);
    }
  }
  
  protected void d(omt paramomt)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramomt == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
      localObject = ors.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Olq == null) {
        break;
      }
      this.jdField_a_of_type_Olq.c(paramomt);
      return;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Int)) {
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
  
  public void e(omt paramomt)
  {
    int j = 1;
    if (paramomt == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramomt.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = alpo.a(2131713223);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((omz)localObject).a(str, i);
    } while (this.jdField_a_of_type_Olq == null);
    Object localObject = this.jdField_a_of_type_Olq;
    if ((this instanceof ola)) {}
    for (int i = j;; i = 2)
    {
      ((olq)localObject).b(i, paramomt);
      return;
      localObject = alpo.a(2131713326);
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
    omt localomt = (omt)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localomt == null) {
      return -1;
    }
    if (okf.a(localomt)) {
      return this.jdField_a_of_type_Okf.a(localomt);
    }
    return ((omt)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Okf != null) {}
    for (int i = this.jdField_a_of_type_Okf.a();; i = 0) {
      return i + 8;
    }
  }
  
  public void i()
  {
    int i = 2;
    if (this.c == 2) {
      i = 3;
    }
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "onChangeCommentTypeClick | curType " + this.c + "; changeToType " + i);
    this.c = i;
    if (this.jdField_a_of_type_Omz != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Omz.a(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Omz.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Olq != null) {
      this.jdField_a_of_type_Olq.b(i);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
    if ((i == 3) && ((this instanceof ola))) {
      ((ola)this).g();
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     omg
 * JD-Core Version:    0.7.0.1
 */