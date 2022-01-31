import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class pvd
  extends ClickableSpan
  implements rfs
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private pvb jdField_a_of_type_Pvb;
  boolean jdField_a_of_type_Boolean;
  
  public pvd(long paramLong, int paramInt, pvb parampvb)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Pvb = parampvb;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.jdField_a_of_type_Pvb.a == null) || (this.jdField_a_of_type_Pvb.a.a() == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pvb.a.a().mSocialFeedInfo.jdField_a_of_type_Qdd == null)) {
      return;
    }
    Object localObject = omm.g + bbca.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    onk.a(paramContext, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CommonBasicComponent", 2, "personal url =" + (String)localObject);
    }
    localObject = this.jdField_a_of_type_Pvb.a.a();
    onk.a = (ArticleInfo)localObject;
    String str = onk.a("3", (ArticleInfo)localObject, paramLong);
    if (shx.a(this.jdField_a_of_type_Pvb.a.e())) {}
    for (paramContext = "0X800935C";; paramContext = "0X8007BA3")
    {
      noo.a(null, String.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(this.jdField_a_of_type_Pvb.a.a().mFeedId), "0", "" + ((ArticleInfo)localObject).mStrategyId, str, false);
      rap.a((ArticleInfo)localObject, this.jdField_a_of_type_Pvb.a.e());
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidTextTextPaint != null) {
      updateDrawState(this.jdField_a_of_type_AndroidTextTextPaint);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      a(this.jdField_a_of_type_Long, paramView.getContext());
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.jdField_a_of_type_AndroidTextTextPaint = paramTextPaint;
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#285c95"));
    paramTextPaint = this.jdField_a_of_type_AndroidTextTextPaint;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = -1)
    {
      paramTextPaint.bgColor = i;
      this.jdField_a_of_type_AndroidTextTextPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvd
 * JD-Core Version:    0.7.0.1
 */