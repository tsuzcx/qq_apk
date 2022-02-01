import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import org.json.JSONObject;

public class qbf
  extends ViewBase
{
  private int jdField_a_of_type_Int = Utils.dp2px(233.0D);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private TextView b;
  
  public qbf(VafContext paramVafContext)
  {
    super(paramVafContext);
    a(paramVafContext);
  }
  
  private int a(String paramString, int paramInt)
  {
    int i = Utils.dp2px(paramInt);
    paramInt = i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString)))
    {
      paramString = Utils.toDouble(this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString));
      paramInt = i;
      if (paramString != null) {
        paramInt = Utils.dp2px(paramString.doubleValue());
      }
    }
    return paramInt;
  }
  
  private void a(VafContext paramVafContext)
  {
    qbg localqbg = new qbg(paramVafContext.getContext());
    localqbg.c(10);
    localqbg.d(10);
    localqbg.a(10);
    localqbg.b(10);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = localqbg;
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramVafContext.getContext());
    this.b = new TextView(paramVafContext.getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.b.setMaxLines(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.b.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    paramVafContext = new LinearLayout.LayoutParams(Utils.dp2px(20.0D), Utils.dp2px(20.0D));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramVafContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b);
  }
  
  private void a(String paramString, TextView paramTextView, int paramInt)
  {
    paramTextView.setTextSize(0, a(paramString, paramInt));
    a();
  }
  
  private void b()
  {
    b("setLocationTextColorString:", this.jdField_a_of_type_AndroidWidgetTextView, Color.parseColor("#4D7CAF"));
    a("setLocationTextSizeString:", this.jdField_a_of_type_AndroidWidgetTextView, 12);
    b("setDistanceTextColorString:", this.b, Color.parseColor("#737373"));
    a("setDistanceTextSizeString:", this.b, 12);
    int i;
    Object localObject;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_OrgJsonJSONObject.optString("setMidMarginString:")))
    {
      i = Utils.dp2px(3.0D);
      localObject = Utils.toInteger(this.jdField_a_of_type_OrgJsonJSONObject.optString("setMidMarginString:"));
      if (localObject == null) {
        break label186;
      }
      i = Utils.dp2px(((Integer)localObject).intValue());
    }
    label186:
    for (;;)
    {
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i = a("setTopPaddingString:", 6);
      int j = a("setBottomPaddingString:", 6);
      int k = a("setLeftPaddingString:", 7);
      int m = a("setRightPaddingString:", 7);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(k, i, m, j);
      a();
      return;
    }
  }
  
  private void b(String paramString, TextView paramTextView, int paramInt)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString)))
    {
      paramTextView.setTextColor(Utils.parseColor(this.jdField_a_of_type_OrgJsonJSONObject.optString(paramString)));
      return;
    }
    paramTextView.setTextColor(paramInt);
  }
  
  public void a()
  {
    float f1 = this.b.getPaint().measureText(this.b.getText().toString());
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingLeft();
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getPaddingRight();
    int k = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).rightMargin;
    float f2 = this.jdField_a_of_type_Int;
    float f3 = i;
    float f4 = j;
    float f5 = k;
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth((int)(f2 - f1 - f3 - f4 - f5));
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.measure(paramInt1, paramInt2);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (paramObject == null);
            bool1 = bool2;
          } while (!(paramObject instanceof JSONObject));
          this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
          bool1 = bool2;
        } while (this.jdField_a_of_type_OrgJsonJSONObject == null);
        b();
        return true;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof JSONObject));
    paramObject = (JSONObject)paramObject;
    String str = paramObject.optString("ad_Location_content");
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      paramObject = paramObject.optString("ad_Location");
      if (TextUtils.isEmpty(paramObject)) {
        break;
      }
      this.b.setText(paramObject);
      this.b.setVisibility(0);
      a();
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.b.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qbf
 * JD-Core Version:    0.7.0.1
 */