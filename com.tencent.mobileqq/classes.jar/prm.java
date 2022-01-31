import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

public class prm
  extends ViewBase
{
  private NativeMiddleBodyView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView;
  private String jdField_a_of_type_JavaLangString = "ReadInJoyMiddleBodyView";
  
  public prm(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView = new NativeMiddleBodyView(paramVafContext.getContext());
  }
  
  public void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (a()) {
      paramLayoutParams.setMargins(0, 0, 0, 0);
    }
  }
  
  public boolean a()
  {
    return (this.mPaddingLeft > 0) || (this.mPaddingRight > 0);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof JSONArray));
      paramObject = (JSONArray)paramObject;
      bool1 = bool2;
    } while (paramObject.length() < 4);
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.setRadius(paramObject.getString(0), paramObject.getString(1), paramObject.getString(2), paramObject.getString(3));
      return true;
    }
    catch (JSONException paramObject)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "", paramObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     prm
 * JD-Core Version:    0.7.0.1
 */