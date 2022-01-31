import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public abstract class rkg
{
  public static int a;
  public float a;
  public View a;
  public BaseData a;
  protected rki a;
  public float b = 14.0F;
  public int b;
  public int c = 16;
  public int d = 18;
  
  static
  {
    jdField_a_of_type_Int = 32;
  }
  
  public rkg() {}
  
  public rkg(View paramView, BaseData paramBaseData)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
  }
  
  public void a() {}
  
  public abstract void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean);
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(rki paramrki)
  {
    this.jdField_a_of_type_Rki = paramrki;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData2;
    a(paramBaseData1, paramBaseData2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkg
 * JD-Core Version:    0.7.0.1
 */