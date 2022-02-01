import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ouc
  extends BaseAdapter
  implements owg, oyu
{
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected AbsListView.OnScrollListener a;
  protected List<ouo> a;
  protected osb a;
  protected osr a;
  protected ost a;
  protected otl a;
  protected oui a;
  protected ouu a;
  protected tty a;
  protected boolean a;
  protected int c = -1;
  
  public ouc()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new oud(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Osr == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Osr.a(j);
        j += 1;
        i = k + i;
      }
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "calculateScrollYOffsetHeight | firstVisiblePos " + paramInt + " totalHeight " + i);
      return i;
    }
  }
  
  abstract LayoutInflater a();
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localView.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
    localView.setTag("non_null_convertview");
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "createNotNullView");
    return localView;
  }
  
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
  
  public otl a()
  {
    return this.jdField_a_of_type_Otl;
  }
  
  abstract otp a();
  
  public ouo a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadinjoyCommentListBaseAdapter", 2, String.format("Click more button in  commentLineId is :" + paramString + "     mViewState is :" + paramInt, new Object[0]));
    }
    Object localObject = "";
    if (paramString.contains("-")) {
      localObject = paramString.split("-")[1];
    }
    boolean bool = ((String)localObject).contains(":");
    String str = localObject.split(":")[0];
    if (((String)localObject).contains(":")) {}
    for (paramString = localObject.split(":")[1];; paramString = "")
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ouo localouo = (ouo)((Iterator)localObject).next();
        BaseCommentData localBaseCommentData = localouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (localBaseCommentData != null) {
          if ((bool) && ((localBaseCommentData instanceof SubCommentData)))
          {
            SubCommentData localSubCommentData = (SubCommentData)localouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
            if ((localBaseCommentData.commentId.equals(paramString)) && (localSubCommentData.parentCommentId.equals(str)))
            {
              localBaseCommentData.maxLine = 100;
              this.jdField_a_of_type_Otl.a(str, paramString, localouo.b);
              return null;
            }
          }
          else if ((bool) && ((localouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (paramInt == 1))
          {
            if ((localBaseCommentData.commentId.equals(str)) && (((CommentData)localouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
            {
              this.jdField_a_of_type_Otl.b(str, paramString, localouo.b);
              return localouo;
            }
          }
          else if ((!bool) && (localBaseCommentData.commentId.equals(str)))
          {
            localBaseCommentData.maxLine = 100;
            this.jdField_a_of_type_Otl.a(str, localouo.b);
            return null;
          }
        }
      }
      return null;
    }
  }
  
  public abstract ouu a();
  
  public void a(Activity paramActivity, View paramView, ouo paramouo, bjoy parambjoy)
  {
    new oyn(paramActivity, this, paramouo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramView, parambjoy);
  }
  
  public void a(Context paramContext, otu paramotu)
  {
    if (paramContext == null) {
      return;
    }
    bjnw localbjnw = bjnw.a(paramContext);
    localbjnw.a(2131717292);
    int[] arrayOfInt = new int[5];
    int[] tmp25_23 = arrayOfInt;
    tmp25_23[0] = 2131717287;
    int[] tmp30_25 = tmp25_23;
    tmp30_25[1] = 2131717288;
    int[] tmp35_30 = tmp30_25;
    tmp35_30[2] = 2131717289;
    int[] tmp40_35 = tmp35_30;
    tmp40_35[3] = 2131717290;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[4] = 2131717291;
    tmp45_40;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localbjnw.b(arrayOfInt[i]);
      i += 1;
    }
    localbjnw.c(2131690620);
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
    localbjnw.a(new ouf(this, localbjnw, arrayOfInt, paramContext, paramotu));
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "readToBiuActivity   commonCommentData :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    otl localotl;
    if (this.jdField_a_of_type_Ouu != null)
    {
      this.jdField_a_of_type_Ouu.b(paramString, paramInt1);
      paramString = this.jdField_a_of_type_Ouu.a(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Otl != null)
      {
        localotl = this.jdField_a_of_type_Otl;
        if (!(this instanceof osu)) {
          break label105;
        }
      }
    }
    label105:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localotl.a(paramInt1, paramString);
      return;
    }
  }
  
  public void a(ost paramost)
  {
    this.jdField_a_of_type_Ost = paramost;
  }
  
  public void a(oui paramoui)
  {
    this.jdField_a_of_type_Oui = paramoui;
  }
  
  public void a(ouo paramouo)
  {
    BaseCommentData localBaseCommentData = paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    int j = 4;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label110;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      if (!TextUtils.isEmpty(localBaseCommentData.nickName)) {
        break label214;
      }
    }
    label214:
    for (paramouo = "";; paramouo = localBaseCommentData.nickName)
    {
      paramouo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717286) + paramouo;
      oto.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramouo, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label110:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Int)) {
        break;
      }
      i = 9;
      break;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == this.c;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(ouo paramouo)
  {
    if ((paramouo == null) || (paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        oto.b(paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Otl != null)
      {
        this.jdField_a_of_type_Otl.b(paramouo);
        return;
        oto.a(paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity, paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    }
  }
  
  public void c(ouo paramouo)
  {
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbjnw.a(2131717317);
    localbjnw.a(2131717316, 3);
    localbjnw.c(2131690620);
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
    localbjnw.a(new oue(this, paramouo, localbjnw));
    if (this.jdField_a_of_type_Otl != null) {
      this.jdField_a_of_type_Otl.a(paramouo);
    }
  }
  
  public void d(ouo paramouo)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramouo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject = paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
      localObject = pay.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Otl == null) {
        break;
      }
      this.jdField_a_of_type_Otl.c(paramouo);
      return;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rfj.jdField_a_of_type_Int)) {
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
  
  public void e(ouo paramouo)
  {
    int j = 1;
    if (paramouo == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramouo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = amtj.a(2131711955);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((ouu)localObject).a(str, i);
    } while (this.jdField_a_of_type_Otl == null);
    Object localObject = this.jdField_a_of_type_Otl;
    if ((this instanceof osu)) {}
    for (int i = j;; i = 2)
    {
      ((otl)localObject).b(i, paramouo);
      return;
      localObject = amtj.a(2131712058);
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
    ouo localouo = (ouo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localouo == null) {
      return -1;
    }
    if (osb.a(localouo)) {
      return this.jdField_a_of_type_Osb.a(localouo);
    }
    return ((ouo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Osb != null) {}
    for (int i = this.jdField_a_of_type_Osb.a();; i = 0) {
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
    if (this.jdField_a_of_type_Ouu != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Ouu.a(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Ouu.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Otl != null) {
      this.jdField_a_of_type_Otl.b(i);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
    if ((i == 3) && ((this instanceof osu))) {
      ((osu)this).g();
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ouc
 * JD-Core Version:    0.7.0.1
 */