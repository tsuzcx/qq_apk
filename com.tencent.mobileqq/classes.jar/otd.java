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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class otd
  extends BaseAdapter
  implements ovg, oxp
{
  protected blih a;
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected List<otp> a;
  protected nzj a;
  protected orc a;
  protected ors a;
  protected oru a;
  protected osm a;
  protected otj a;
  protected otv a;
  protected sph a;
  protected toa a;
  protected boolean a;
  protected int c = -1;
  
  public otd()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Blih = new ote(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Ors == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Ors.a(j);
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
  
  public nzj a()
  {
    return this.jdField_a_of_type_Nzj;
  }
  
  public osm a()
  {
    return this.jdField_a_of_type_Osm;
  }
  
  abstract osq a();
  
  public otp a(String paramString, int paramInt)
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
        otp localotp = (otp)((Iterator)localObject).next();
        BaseCommentData localBaseCommentData = localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (localBaseCommentData != null) {
          if ((bool) && ((localBaseCommentData instanceof SubCommentData)))
          {
            SubCommentData localSubCommentData = (SubCommentData)localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
            if ((localBaseCommentData.commentId.equals(paramString)) && (localSubCommentData.parentCommentId.equals(str)))
            {
              localBaseCommentData.maxLine = 100;
              this.jdField_a_of_type_Osm.a(str, paramString, localotp.b);
              return null;
            }
          }
          else if ((bool) && ((localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (paramInt == 1))
          {
            if ((localBaseCommentData.commentId.equals(str)) && (((CommentData)localotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
            {
              this.jdField_a_of_type_Osm.b(str, paramString, localotp.b);
              return localotp;
            }
          }
          else if ((!bool) && (localBaseCommentData.commentId.equals(str)))
          {
            localBaseCommentData.maxLine = 100;
            this.jdField_a_of_type_Osm.a(str, localotp.b);
            return null;
          }
        }
      }
      return null;
    }
  }
  
  public abstract otv a();
  
  public void a(Activity paramActivity, View paramView, otp paramotp, blkc paramblkc)
  {
    new oxi(paramActivity, this, paramotp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramView, paramblkc);
  }
  
  public void a(Context paramContext, osv paramosv)
  {
    if (paramContext == null) {
      return;
    }
    blir localblir = blir.a(paramContext);
    localblir.a(2131717055);
    int[] arrayOfInt = new int[5];
    int[] tmp25_23 = arrayOfInt;
    tmp25_23[0] = 2131717050;
    int[] tmp30_25 = tmp25_23;
    tmp30_25[1] = 2131717051;
    int[] tmp35_30 = tmp30_25;
    tmp35_30[2] = 2131717052;
    int[] tmp40_35 = tmp35_30;
    tmp40_35[3] = 2131717053;
    int[] tmp46_40 = tmp40_35;
    tmp46_40[4] = 2131717054;
    tmp46_40;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localblir.b(arrayOfInt[i]);
      i += 1;
    }
    localblir.c(2131690580);
    if (!localblir.isShowing()) {
      localblir.show();
    }
    localblir.a(new otg(this, localblir, arrayOfInt, paramContext, paramosv));
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
    osm localosm;
    if (this.jdField_a_of_type_Otv != null)
    {
      this.jdField_a_of_type_Otv.b(paramString, paramInt1);
      paramString = this.jdField_a_of_type_Otv.a(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Osm != null)
      {
        localosm = this.jdField_a_of_type_Osm;
        if (!(this instanceof orv)) {
          break label109;
        }
      }
    }
    label109:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localosm.a(paramInt1, paramString);
      tpk.a(paramString);
      return;
    }
  }
  
  public void a(oru paramoru)
  {
    this.jdField_a_of_type_Oru = paramoru;
  }
  
  public void a(otj paramotj)
  {
    this.jdField_a_of_type_Otj = paramotj;
  }
  
  public void a(otp paramotp)
  {
    BaseCommentData localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
    for (paramotp = "";; paramotp = localBaseCommentData.nickName)
    {
      paramotp = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717049) + paramotp;
      osp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, paramotp, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label110:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int)) {
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
  
  public void b(otp paramotp)
  {
    if ((paramotp == null) || (paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        osp.b(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Osm != null)
      {
        this.jdField_a_of_type_Osm.b(paramotp);
        return;
        osp.a(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity);
      }
    }
  }
  
  public void c(otp paramotp)
  {
    blir localblir = blir.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localblir.a(2131717080);
    localblir.a(2131717079, 3);
    localblir.c(2131690580);
    if (!localblir.isShowing()) {
      localblir.show();
    }
    localblir.a(new otf(this, paramotp, localblir));
    if (this.jdField_a_of_type_Osm != null) {
      this.jdField_a_of_type_Osm.a(paramotp);
    }
  }
  
  public void d(otp paramotp)
  {
    int j = 20;
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((paramotp == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {
      return;
    }
    Object localObject = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
      localObject = ozs.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
      if (this.jdField_a_of_type_Osm == null) {
        break;
      }
      this.jdField_a_of_type_Osm.c(paramotp);
      return;
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
      }
      else
      {
        if ((ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Int)) {
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
  
  public void e(otp paramotp)
  {
    int j = 1;
    if (paramotp == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = anzj.a(2131711723);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((otv)localObject).a(str, i);
    } while (this.jdField_a_of_type_Osm == null);
    Object localObject = this.jdField_a_of_type_Osm;
    if ((this instanceof orv)) {}
    for (int i = j;; i = 2)
    {
      ((osm)localObject).b(i, paramotp);
      return;
      localObject = anzj.a(2131711826);
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
    otp localotp = (otp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localotp == null) {
      return -1;
    }
    if (orc.a(localotp)) {
      return this.jdField_a_of_type_Orc.a(localotp);
    }
    return ((otp)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Orc != null) {}
    for (int i = this.jdField_a_of_type_Orc.a();; i = 0) {
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
    if (this.jdField_a_of_type_Otv != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Otv.a(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Otv.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Osm != null) {
      this.jdField_a_of_type_Osm.b(i);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
    if ((i == 3) && ((this instanceof orv))) {
      ((orv)this).g();
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     otd
 * JD-Core Version:    0.7.0.1
 */