import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPackageGialog.4;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import org.json.JSONObject;

public class obd
  extends Dialog
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GiftServiceBean jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private String jdField_a_of_type_JavaLangString;
  private List<GiftServiceBean> jdField_a_of_type_JavaUtilList;
  private obh jdField_a_of_type_Obh;
  private obi jdField_a_of_type_Obi;
  private obj jdField_a_of_type_Obj;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean = true;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private GiftServiceBean jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean;
  private String jdField_b_of_type_JavaLangString = "";
  private List<GiftServiceBean> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private GiftServiceBean jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean;
  private String jdField_c_of_type_JavaLangString = "";
  private List<GiftServiceBean> jdField_c_of_type_JavaUtilList;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private List<GiftServiceBean> jdField_d_of_type_JavaUtilList;
  private TextView e;
  
  public obd(Context paramContext)
  {
    super(paramContext, 2131755326);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    requestWindowFeature(1);
    if (!bfnz.e()) {
      getWindow().setBackgroundDrawable(new ColorDrawable());
    }
    for (;;)
    {
      setContentView(2131559944);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378344));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378051));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378333));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378321));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363502));
      this.e = ((TextView)findViewById(2131378383));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368532));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369626));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369633));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      sgt.a(this.jdField_a_of_type_AndroidWidgetButton, actj.a(6.0F, paramContext.getResources()), Color.parseColor("#EBEDF5"));
      sgt.a(this.jdField_a_of_type_AndroidWidgetTextView, actj.a(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      sgt.a(this.jdField_b_of_type_AndroidWidgetTextView, actj.a(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      sgt.a(this.jdField_c_of_type_AndroidWidgetTextView, actj.a(4.0F, paramContext.getResources()), Color.parseColor("#F2F3F7"));
      sgt.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, actj.a(6.0F, paramContext.getResources()), Color.parseColor("#FFFFFF"));
      return;
      getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165618)));
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null) && (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null))
    {
      sgt.a(this.jdField_a_of_type_AndroidWidgetButton, actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#00CAFC"));
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      return;
    }
    sgt.a(this.jdField_a_of_type_AndroidWidgetButton, actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), Color.parseColor("#EBEDF5"));
    this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(Configuration paramConfiguration)
  {
    this.jdField_a_of_type_Int = paramConfiguration.orientation;
    if (this.jdField_a_of_type_Obj != null) {
      this.jdField_a_of_type_Obj.dismiss();
    }
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
  }
  
  public void a(List<GiftServiceBean> paramList1, List<GiftServiceBean> paramList2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.jdField_b_of_type_JavaUtilList = paramList2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_b_of_type_JavaLangString = paramString2;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      this.jdField_d_of_type_JavaLangString = paramString3;
      this.e.setText(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      this.jdField_c_of_type_JavaLangString = paramString4;
    }
    if ((!TextUtils.isEmpty(paramString5)) && ("0".equals(paramString5))) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean = new GiftServiceBean();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t = ajya.a(2131705278);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.v = "0";
    }
  }
  
  public void a(obh paramobh)
  {
    this.jdField_a_of_type_Obh = paramobh;
  }
  
  public void a(obi paramobi)
  {
    this.jdField_a_of_type_Obi = paramobi;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0));
          this.jdField_a_of_type_Obj = new obj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
          str = "";
          paramView = str;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null)
          {
            paramView = str;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t)) {
              paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t;
            }
          }
          this.jdField_a_of_type_Obj.a(this.jdField_a_of_type_JavaUtilList, new obe(this), paramView);
          this.jdField_a_of_type_Obj.show();
          return;
        } while ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() <= 0));
        this.jdField_a_of_type_Obj = new obj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
        str = "";
        paramView = str;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null)
        {
          paramView = str;
          if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t)) {
            paramView = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t;
          }
        }
        this.jdField_a_of_type_Obj.a(this.jdField_c_of_type_JavaUtilList, new obf(this), paramView);
        this.jdField_a_of_type_Obj.show();
        return;
      } while ((this.jdField_d_of_type_JavaUtilList == null) || (this.jdField_d_of_type_JavaUtilList.size() <= 0));
      this.jdField_a_of_type_Obj = new obj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetLinearLayout.getHeight());
      String str = "";
      paramView = str;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean != null)
      {
        paramView = str;
        if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t)) {
          paramView = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyAdDataGiftServiceBean.t;
        }
      }
      this.jdField_a_of_type_Obj.a(this.jdField_d_of_type_JavaUtilList, new obg(this), paramView);
      this.jdField_a_of_type_Obj.show();
      return;
      ThreadManager.executeOnNetWorkThread(new GiftPackageGialog.4(this));
      return;
      dismiss();
      return;
      dismiss();
    } while (this.jdField_a_of_type_Obi == null);
    this.jdField_a_of_type_Obi.a();
  }
  
  public void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obd
 * JD-Core Version:    0.7.0.1
 */