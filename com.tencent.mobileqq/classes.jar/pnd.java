import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.URL;

public abstract class pnd
  implements rxc
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  protected pms a;
  public View f;
  
  public pnd(Context paramContext, pms parampms)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Pms = parampms;
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
    ozc.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public void a(rwc paramrwc, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pnd
 * JD-Core Version:    0.7.0.1
 */