import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class ovq
  implements ovg
{
  private int jdField_a_of_type_Int = 10;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  private void a(String paramString, ArticleInfo paramArticleInfo)
  {
    paa localpaa = new paa();
    localpaa.i().b("wording", "" + pbb.a());
    osp.a(paramString, paramArticleInfo, localpaa);
  }
  
  public View a(ViewGroup paramViewGroup, View paramView, Context paramContext, otp paramotp)
  {
    if (!a(paramotp)) {
      return paramView;
    }
    if ((!TextUtils.isEmpty(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (!this.jdField_a_of_type_JavaUtilSet.contains(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      a("0X8009FE9", paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_JavaUtilSet.add(paramotp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    this.jdField_a_of_type_Boolean = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (localLayoutParams.bottomMargin >= 0) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298721));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
    if (paramView != null) {}
    for (;;)
    {
      paramView.setOnClickListener(new ovr(this, paramotp, paramContext));
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131560304, null);
    }
  }
  
  public void a(int paramInt)
  {
    QLog.d("GuideHelper", 1, "showGuidePagerNum : " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(String paramString)
  {
    QLog.d("GuideHelper", 1, "extraInfo : " + paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).getString("app_schema");
      QLog.d("GuideHelper", 1, "scheme : " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("GuideHelper", 1, "setGuideExtraInfo : ", paramString);
    }
  }
  
  public void a(boolean paramBoolean, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = 0;
    if (paramViewGroup == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.getLayoutParams();
    if (!paramBoolean) {
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramViewGroup.getContext().getResources().getDimensionPixelOffset(2131298719));
    }
    paramViewGroup.setLayoutParams(localLayoutParams);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(List<otp> paramList)
  {
    int i = this.b;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (i > this.jdField_a_of_type_Int) && (paramList != null))
    {
      otp localotp = new otp(6, null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (((otp)localIterator.next()).jdField_a_of_type_Int == 6) {
          localIterator.remove();
        }
      }
      paramList.add(localotp);
      QLog.d("GuideHelper", 1, "addGuidePager : " + i + "  articleInfo :" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return true;
    }
    return false;
  }
  
  public boolean a(otp paramotp)
  {
    return (paramotp != null) && (paramotp.jdField_a_of_type_Int == 6);
  }
  
  public void onCommentCreate(boolean paramBoolean, otp paramotp, List<otp> paramList, int paramInt) {}
  
  public void onCommentCreate(boolean paramBoolean1, otp paramotp, boolean paramBoolean2, List<otp> paramList, int paramInt) {}
  
  public void onCommentDelete(int paramInt1, boolean paramBoolean, otp paramotp, int paramInt2) {}
  
  public void onCommentLikeOrDislike(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<otp> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.b = 1;
    a(paramList);
  }
  
  public void onCommentLoadMore(int paramInt1, boolean paramBoolean1, List<otp> paramList, boolean paramBoolean2, int paramInt2)
  {
    this.b += 1;
    a(paramList);
  }
  
  public void onCommentReply(boolean paramBoolean, otp paramotp) {}
  
  public void onCommentStateError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovq
 * JD-Core Version:    0.7.0.1
 */