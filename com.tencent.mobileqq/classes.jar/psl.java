import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import org.json.JSONException;
import org.json.JSONObject;

public class psl
  extends NativeText
{
  private int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_b_of_type_JavaLangString;
  
  public psl(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mNative = new psm(this, paramVafContext.getContext());
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.mNative.setBackgroundColor(0);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof JSONObject)) {
      paramObject = (JSONObject)paramObject;
    }
    try
    {
      this.jdField_a_of_type_Int = paramObject.getInt("progress");
      this.jdField_a_of_type_JavaLangString = paramObject.getString("bgcolor");
      this.jdField_b_of_type_JavaLangString = paramObject.getString("fgcolor");
      return true;
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     psl
 * JD-Core Version:    0.7.0.1
 */