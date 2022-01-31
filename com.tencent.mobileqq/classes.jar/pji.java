import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class pji
  extends ClickableSpan
  implements qtg
{
  private int jdField_a_of_type_Int = -1;
  protected long a;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private pjg jdField_a_of_type_Pjg;
  boolean jdField_a_of_type_Boolean;
  
  public pji(long paramLong, int paramInt, pjg parampjg)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Pjg = parampjg;
  }
  
  private void a(long paramLong, Context paramContext)
  {
    if ((this.jdField_a_of_type_Pjg.a == null) || (this.jdField_a_of_type_Pjg.a.a() == null) || (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo == null) || (this.jdField_a_of_type_Pjg.a.a().mSocialFeedInfo.jdField_a_of_type_Pre == null)) {
      return;
    }
    Object localObject = obb.g + baaw.encodeToString(String.valueOf(paramLong).getBytes(), 2);
    obz.a(paramContext, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("CommonBasicComponent", 2, "personal url =" + (String)localObject);
    }
    localObject = this.jdField_a_of_type_Pjg.a.a();
    obz.a = (ArticleInfo)localObject;
    String str = obz.a("3", (ArticleInfo)localObject, paramLong);
    if (rvf.a(this.jdField_a_of_type_Pjg.a.e())) {}
    for (paramContext = "0X800935C";; paramContext = "0X8007BA3")
    {
      ndn.a(null, String.valueOf(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long), paramContext, paramContext, 0, 0, String.valueOf(this.jdField_a_of_type_Pjg.a.a().mFeedId), "0", "" + ((ArticleInfo)localObject).mStrategyId, str, false);
      qoe.a((ArticleInfo)localObject, this.jdField_a_of_type_Pjg.a.e());
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
 * Qualified Name:     pji
 * JD-Core Version:    0.7.0.1
 */