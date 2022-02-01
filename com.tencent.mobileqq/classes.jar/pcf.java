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
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class pcf
  extends BaseAdapter
  implements pfh, pia
{
  protected ReadInJoyCommentListView a;
  protected CommonCommentData a;
  protected ArticleInfo a;
  protected VafContext a;
  BaseActivity a;
  protected AbsListView.OnScrollListener a;
  protected List<pdp> a;
  protected pab a;
  protected par a;
  protected pat a;
  protected pbn a;
  protected pcm a;
  protected pdv a;
  protected uif a;
  protected boolean a;
  protected int c = -1;
  
  public pcf()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new pcg(this);
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_Par == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0) != null) {}
    for (int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0).getTop();; i = 0)
    {
      int j = 0;
      while (j < paramInt)
      {
        int k = this.jdField_a_of_type_Par.a(j);
        j += 1;
        i = k + i;
      }
      QLog.d("ReadinjoyCommentListBaseAdapter", 2, "calculateScrollYOffsetHeight | firstVisiblePos " + paramInt + " totalHeight " + i);
      return i;
    }
  }
  
  private void b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    QLog.d("ReadinjoyCommentListBaseAdapter", 2, new Object[] { "comment id : ", paramString, " like state change, new state : ", Integer.valueOf(paramInt1) });
    pbn localpbn;
    if (this.jdField_a_of_type_Pdv != null)
    {
      this.jdField_a_of_type_Pdv.b(paramString, paramInt1);
      paramString = this.jdField_a_of_type_Pdv.a(paramString);
      if ((paramString != null) && (!paramString.isAd)) {
        notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Pbn != null)
      {
        localpbn = this.jdField_a_of_type_Pbn;
        if (!(this instanceof pau)) {
          break label103;
        }
      }
    }
    label103:
    for (paramInt1 = paramInt2;; paramInt1 = 2)
    {
      localpbn.a(paramInt1, paramString);
      return;
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
  
  public pbn a()
  {
    return this.jdField_a_of_type_Pbn;
  }
  
  abstract pbs a();
  
  public pdp a(String paramString, int paramInt)
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
        pdp localpdp = (pdp)((Iterator)localObject).next();
        BaseCommentData localBaseCommentData = localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (localBaseCommentData != null) {
          if ((bool) && ((localBaseCommentData instanceof SubCommentData)))
          {
            SubCommentData localSubCommentData = (SubCommentData)localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
            if ((localBaseCommentData.commentId.equals(paramString)) && (localSubCommentData.parentCommentId.equals(str)))
            {
              localBaseCommentData.maxLine = 100;
              this.jdField_a_of_type_Pbn.a(str, paramString, localpdp.b);
              return null;
            }
          }
          else if ((bool) && ((localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) && (paramInt == 1))
          {
            if ((localBaseCommentData.commentId.equals(str)) && (((CommentData)localpdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentNum > 0))
            {
              this.jdField_a_of_type_Pbn.b(str, paramString, localpdp.b);
              return localpdp;
            }
          }
          else if ((!bool) && (localBaseCommentData.commentId.equals(str)))
          {
            localBaseCommentData.maxLine = 100;
            this.jdField_a_of_type_Pbn.a(str, localpdp.b);
            return null;
          }
        }
      }
      return null;
    }
  }
  
  public abstract pdv a();
  
  public void a(Activity paramActivity, View paramView, pdp parampdp, blak paramblak)
  {
    new phs(paramActivity, this, parampdp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramView, paramblak);
  }
  
  public void a(Context paramContext, pbx parampbx)
  {
    if (paramContext == null) {
      return;
    }
    bkzi localbkzi = bkzi.a(paramContext);
    localbkzi.a(2131717658);
    int[] arrayOfInt = new int[7];
    int[] tmp27_25 = arrayOfInt;
    tmp27_25[0] = 2131717651;
    int[] tmp33_27 = tmp27_25;
    tmp33_27[1] = 2131717652;
    int[] tmp39_33 = tmp33_27;
    tmp39_33[2] = 2131717653;
    int[] tmp45_39 = tmp39_33;
    tmp45_39[3] = 2131717654;
    int[] tmp51_45 = tmp45_39;
    tmp51_45[4] = 2131717655;
    int[] tmp57_51 = tmp51_45;
    tmp57_51[5] = 2131717656;
    int[] tmp63_57 = tmp57_51;
    tmp63_57[6] = 2131717657;
    tmp63_57;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      localbkzi.b(arrayOfInt[i]);
      i += 1;
    }
    localbkzi.c(2131690697);
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
    localbkzi.a(new pcj(this, localbkzi, arrayOfInt, paramContext, parampbx));
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
    qgx.a().a(a(), 3, new pci(this, paramString, paramInt1, paramInt2));
  }
  
  public void a(pat parampat)
  {
    this.jdField_a_of_type_Pat = parampat;
  }
  
  public void a(pcm parampcm)
  {
    this.jdField_a_of_type_Pcm = parampcm;
  }
  
  public void a(pdp parampdp)
  {
    BaseCommentData localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
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
    for (parampdp = "";; parampdp = localBaseCommentData.nickName)
    {
      parampdp = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131717650) + parampdp;
      pbq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localBaseCommentData, i, parampdp, null, false, a(), -1, this.jdField_a_of_type_Boolean);
      return;
      label110:
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (pqw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
      {
        i = 2;
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq == null) {
        break;
      }
      i = j;
      if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq.jdField_a_of_type_Int)) {
        break;
      }
      i = 9;
      break;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      return pdv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == this.c;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(pdp parampdp)
  {
    if ((parampdp == null) || (parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null)) {}
    for (;;)
    {
      return;
      if ((parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.isAuthorReply()) && (!TextUtils.isEmpty(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage))) {
        pbq.b(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.ksHomePage, BaseActivity.sTopActivity);
      }
      while (this.jdField_a_of_type_Pbn != null)
      {
        this.jdField_a_of_type_Pbn.b(parampdp);
        return;
        pbq.a(parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.uin, BaseActivity.sTopActivity, parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      }
    }
  }
  
  public void c(pdp parampdp)
  {
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localbkzi.a(2131717683);
    localbkzi.a(2131717682, 3);
    localbkzi.c(2131690697);
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
    localbkzi.a(new pch(this, parampdp, localbkzi));
    if (this.jdField_a_of_type_Pbn != null) {
      this.jdField_a_of_type_Pbn.a(parampdp);
    }
  }
  
  public void d(pdp parampdp)
  {
    QLog.d("ReadinjoyCommentListBaseAdapter", 1, "start showBiuComponent");
    if ((parampdp == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)) {}
    do
    {
      return;
      Object localObject = pbq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      int i = ((Integer)((Pair)localObject).first).intValue();
      int j = ((Integer)((Pair)localObject).second).intValue();
      localObject = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      String str1 = ((BaseCommentData)localObject).commentContent;
      String str2 = ((BaseCommentData)localObject).uin;
      localObject = pqv.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ReadInJoyDeliverBiuActivity.class), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, str1, Long.valueOf(str2).longValue(), ((BaseCommentData)localObject).nickName, 0, j);
      a((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.overridePendingTransition(0, 0);
    } while (this.jdField_a_of_type_Pbn == null);
    this.jdField_a_of_type_Pbn.c(parampdp);
  }
  
  public void e(pdp parampdp)
  {
    int j = 1;
    if (parampdp == null) {}
    label67:
    do
    {
      return;
      BaseCommentData localBaseCommentData = parampdp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if (!localBaseCommentData.isDisliked()) {
        break;
      }
      localObject = anvx.a(2131712302);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).a();
      localObject = a();
      String str = localBaseCommentData.commentId;
      if (!localBaseCommentData.isDisliked()) {
        break label116;
      }
      i = 0;
      ((pdv)localObject).a(str, i);
    } while (this.jdField_a_of_type_Pbn == null);
    Object localObject = this.jdField_a_of_type_Pbn;
    if ((this instanceof pau)) {}
    for (int i = j;; i = 2)
    {
      ((pbn)localObject).b(i, parampdp);
      return;
      localObject = anvx.a(2131712405);
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
    pdp localpdp = (pdp)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localpdp == null) {
      return -1;
    }
    if (pab.a(localpdp)) {
      return this.jdField_a_of_type_Pab.a(localpdp);
    }
    return ((pdp)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_Pab != null) {}
    for (int i = this.jdField_a_of_type_Pab.a();; i = 0) {
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
    if (this.jdField_a_of_type_Pdv != null)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_Pdv.a(i));
        notifyDataSetChanged();
      }
      this.jdField_a_of_type_Pdv.a().a(false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    }
    if (this.jdField_a_of_type_Pbn != null) {
      this.jdField_a_of_type_Pbn.b(i);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.f();
    }
    if ((i == 3) && ((this instanceof pau))) {
      ((pau)this).g();
    }
  }
  
  public void onClick(ViewBase paramViewBase) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcf
 * JD-Core Version:    0.7.0.1
 */