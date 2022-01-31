import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyFeedbackPopupWindow.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class rsm
  extends rrp
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private rap jdField_a_of_type_Rap;
  private rnb jdField_a_of_type_Rnb;
  private rss jdField_a_of_type_Rss = new rsn(this);
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private final String jdField_b_of_type_JavaLangString = "0X80095D4";
  private boolean jdField_b_of_type_Boolean = true;
  private final int jdField_c_of_type_Int = 2;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private final int jdField_d_of_type_Int = 3;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private final int jdField_e_of_type_Int = 4;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private final int jdField_f_of_type_Int = 5;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private final int g = 6;
  private final int h = 7;
  private final int i = 8;
  
  public rsm(Activity paramActivity, rap paramrap)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rap = paramrap;
    this.jdField_a_of_type_Rnb = new rnb();
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 4;
    }
    return 5;
  }
  
  private void a(int paramInt)
  {
    if (!a()) {
      return;
    }
    ((oso)onk.a().getManager(163)).a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt, this.jdField_a_of_type_Rss);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject;
    if (b("reportData")) {
      localObject = onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    try
    {
      localObject = ((onr)localObject).o(paramInt).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId).a();
      noo.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin), paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), (String)localObject, false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("ReadInJoyBasePopupWindow", 1, "reportData json exception.");
      paramString.printStackTrace();
    }
  }
  
  private boolean a()
  {
    if (!bbev.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131718391, 0).a();
      return false;
    }
    return true;
  }
  
  private boolean a(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.publishUin > 0L) && (onk.a() == paramArticleInfo.publishUin);
  }
  
  private boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mArticleInfo is null." });
      return false;
    }
    return true;
  }
  
  private boolean b(String paramString)
  {
    if ((a(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null)) {
      return true;
    }
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { paramString, ", mSocialFeedInfo is null" });
    return false;
  }
  
  private void c()
  {
    if (a("reportFeeds")) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyFeedbackPopupWindow.3(this));
    }
  }
  
  private void d()
  {
    bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidAppActivity);
    localbfol.a(2131718441);
    localbfol.a(2131718440, 0);
    localbfol.c(2131690596);
    if (!localbfol.isShowing()) {
      localbfol.show();
    }
    localbfol.a(new rsr(this, localbfol));
  }
  
  private void e()
  {
    if (!a()) {}
    while (!a("shieldFeeds")) {
      return;
    }
    rmu.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Rss);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559816, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131376061));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131375142));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131364996));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131375858));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131373812));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131379409));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370357));
    return paramLayoutInflater;
  }
  
  public final void a(View paramView1, ArticleInfo paramArticleInfo, int paramInt, View paramView2)
  {
    QLog.d("ReadInJoyBasePopupWindow", 2, new Object[] { "show, articleInfo = ", paramArticleInfo });
    if (!this.jdField_a_of_type_Boolean) {
      a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_AndroidViewView = paramView2;
    this.jdField_a_of_type_Int = paramInt;
    a(paramArticleInfo);
    a(paramView1);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (a(paramArticleInfo))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842314));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842313));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842314));
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    setOnDismissListener(new rsq(this));
  }
  
  public void onClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
    dismiss();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376061: 
      e();
      a("0X80095D4", 5);
      return;
    case 2131375142: 
      c();
      a("0X80095D4", 7);
      return;
    case 2131364996: 
      d();
      a("0X80095D4", 6);
      return;
    case 2131375858: 
      a(0);
      a("0X80095D4", 1);
      return;
    case 2131373812: 
      a(1);
      a("0X80095D4", 2);
      return;
    case 2131379409: 
      a(2);
      a("0X80095D4", 3);
      return;
    }
    a(3);
    a("0X80095D4", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsm
 * JD-Core Version:    0.7.0.1
 */