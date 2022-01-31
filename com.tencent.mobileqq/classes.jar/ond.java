import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.URL;

public abstract class ond
  implements qje
{
  public int a;
  protected Context a;
  protected View.OnClickListener a;
  public ohe a;
  protected oms a;
  public View f;
  
  public ond(Context paramContext, oms paramoms)
  {
    this.jdField_a_of_type_Ohe = new one(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Oms = paramoms;
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
    obj.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidContentContext, paramBoolean);
  }
  
  public void a(qht paramqht, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ond
 * JD-Core Version:    0.7.0.1
 */