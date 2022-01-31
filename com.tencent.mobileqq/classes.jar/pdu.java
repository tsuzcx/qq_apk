import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.URL;

public abstract class pdu
  implements rkx
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  protected pdj a;
  public View f;
  
  public pdu(Context paramContext, pdj parampdj)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Pdj = parampdj;
  }
  
  public abstract View a(int paramInt, ViewGroup paramViewGroup);
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    a(paramKandianUrlImageView, paramURL, false);
  }
  
  protected void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, boolean paramBoolean)
  {
    orc.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public void a(rjk paramrjk, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdu
 * JD-Core Version:    0.7.0.1
 */