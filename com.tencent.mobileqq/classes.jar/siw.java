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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class siw
  extends shz
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private rqj jdField_a_of_type_Rqj;
  private scx jdField_a_of_type_Scx;
  private sjc jdField_a_of_type_Sjc = new six(this);
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
  
  public siw(Activity paramActivity, rqj paramrqj)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rqj = paramrqj;
    this.jdField_a_of_type_Scx = new scx();
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
    ((oxd)ors.a().getManager(163)).a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt, this.jdField_a_of_type_Sjc);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject;
    if (b("reportData")) {
      localObject = ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    try
    {
      localObject = ((orz)localObject).o(paramInt).d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.businessId).a();
      nrt.a(null, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.publishUin), paramString, paramString, 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), (String)localObject, false);
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
    if (!bdee.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131718824, 0).a();
      return false;
    }
    return true;
  }
  
  private boolean a(ArticleInfo paramArticleInfo)
  {
    return (paramArticleInfo != null) && (paramArticleInfo.publishUin > 0L) && (ors.a() == paramArticleInfo.publishUin);
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
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidAppActivity);
    localbhpy.a(2131718881);
    localbhpy.a(2131718880, 0);
    localbhpy.c(2131690648);
    if (!localbhpy.isShowing()) {
      localbhpy.show();
    }
    localbhpy.a(new sjb(this, localbhpy));
  }
  
  private void e()
  {
    if (!a()) {}
    while (!a("shieldFeeds")) {
      return;
    }
    scq.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Sjc);
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559911, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131376562));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131375625));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramLayoutInflater.findViewById(2131365080));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131376359));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131374267));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131380129));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370661));
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
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842484));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842483));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842484));
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
    setOnDismissListener(new sja(this));
  }
  
  public void onClick(View paramView)
  {
    this.jdField_b_of_type_Boolean = false;
    dismiss();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131376562: 
      e();
      a("0X80095D4", 5);
      return;
    case 2131375625: 
      c();
      a("0X80095D4", 7);
      return;
    case 2131365080: 
      d();
      a("0X80095D4", 6);
      return;
    case 2131376359: 
      a(0);
      a("0X80095D4", 1);
      return;
    case 2131374267: 
      a(1);
      a("0X80095D4", 2);
      return;
    case 2131380129: 
      a(2);
      a("0X80095D4", 3);
      return;
    }
    a(3);
    a("0X80095D4", 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     siw
 * JD-Core Version:    0.7.0.1
 */