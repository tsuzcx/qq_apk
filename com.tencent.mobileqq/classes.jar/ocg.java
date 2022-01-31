import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ocg
  extends ViewBase
  implements View.OnClickListener, View.OnFocusChangeListener
{
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ProteusInnerData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  
  public ocg(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    a();
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSystemService("layout_inflater")).inflate(2131559791, null);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365767));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378357));
      this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(this);
      this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    }
  }
  
  private void b()
  {
    Object localObject2 = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.b)) {
        this.jdField_a_of_type_AndroidWidgetEditText.setHint(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.b, 32));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.c)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.c, 8));
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.M))
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.M;
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.O)) {
        break label174;
      }
    }
    label174:
    for (Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.O;; localObject1 = null)
    {
      this.c = ((String)localObject1);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.P)) {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.P;
      }
      this.b = ((String)localObject1);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData == null);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.jdField_a_of_type_JavaUtilRegexPattern != null)) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.jdField_a_of_type_JavaUtilRegexPattern.matcher(str).matches();; bool = true)
    {
      if (bool)
      {
        bcpw.a(paramView.getContext(), -1, ajyc.a(2131712903), 0).b(((BaseActivity)paramView.getContext()).getTitleBarHeight());
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.jdField_a_of_type_OrgJsonJSONObject == null)) {
          break;
        }
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData.a.jdField_a_of_type_OrgJsonJSONObject.put("value", str);
          return;
        }
        catch (Exception paramView)
        {
          return;
        }
      }
      str = ajyc.a(2131712929);
      bcpw.a(paramView.getContext(), 1, str, 0).b(((BaseActivity)paramView.getContext()).getTitleBarHeight());
      return;
    }
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof Activity))) {
      ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getWindow().getAttributes().softInputMode = 4;
    }
    if ((!this.jdField_a_of_type_Boolean) && (paramBoolean))
    {
      this.jdField_a_of_type_Boolean = true;
      oas.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData, 39);
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return super.setAttribute(paramInt, paramObject);
      if ((paramObject != null) && ((paramObject instanceof ProteusInnerData)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData = ((ProteusInnerData)paramObject);
        b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocg
 * JD-Core Version:    0.7.0.1
 */