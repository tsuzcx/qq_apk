import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public abstract class rkj
{
  public static int a;
  public float a;
  public View a;
  public BaseData a;
  protected rkl a;
  public float b = 14.0F;
  public int b;
  public int c = 16;
  public int d = 18;
  
  static
  {
    jdField_a_of_type_Int = 32;
  }
  
  public rkj() {}
  
  public rkj(View paramView, BaseData paramBaseData)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData;
  }
  
  public void a() {}
  
  public abstract void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean);
  
  public void a(String paramString, Bitmap paramBitmap) {}
  
  public void a(rkl paramrkl)
  {
    this.jdField_a_of_type_Rkl = paramrkl;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData2;
    a(paramBaseData1, paramBaseData2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkj
 * JD-Core Version:    0.7.0.1
 */