import android.support.annotation.Nullable;
import java.util.List;

public class pxp<BEAN, VIEW extends pxh<BEAN>>
  implements pxg<BEAN, VIEW>
{
  private pxf<BEAN> jdField_a_of_type_Pxf;
  private pxh<BEAN> jdField_a_of_type_Pxh;
  private boolean jdField_a_of_type_Boolean;
  
  public pxp(pxf<BEAN> parampxf)
  {
    this.jdField_a_of_type_Pxf = parampxf;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_Pxh != null)
      {
        this.jdField_a_of_type_Pxh.setCenterHide();
        this.jdField_a_of_type_Pxh.setListData(paramList, false);
        this.jdField_a_of_type_Pxh.setFooterNoMore();
        this.jdField_a_of_type_Pxh.setHeaderLoading();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List<BEAN> paramList)
  {
    if (paramBoolean)
    {
      a(paramList);
      return;
    }
    b(paramInt, paramList);
  }
  
  private void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Pxh != null)) {
      this.jdField_a_of_type_Pxh.setHeaderError(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_Pxh != null))
    {
      this.jdField_a_of_type_Pxh.setCenterHide();
      this.jdField_a_of_type_Pxh.setListData(paramList, false);
      this.jdField_a_of_type_Pxh.setFooterNoMore();
    }
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Pxh == null)) {
      return;
    }
    this.jdField_a_of_type_Pxh.setCenterError(paramInt, paramString);
    this.jdField_a_of_type_Pxh.setTotal(0);
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Pxh != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Pxh.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pxh = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Pxh != null)
    {
      this.jdField_a_of_type_Pxh.setTotal(paramInt);
      this.jdField_a_of_type_Pxh.setListData(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_Pxh.setCenterHide();
      if (this.jdField_a_of_type_Pxf.a()) {
        this.jdField_a_of_type_Pxh.setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Pxh.setFooterNoMore();
    return;
    label82:
    this.jdField_a_of_type_Pxh.setCenterEmpty();
    this.jdField_a_of_type_Pxh.setFooterHide();
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_Pxh = paramVIEW;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pxh != null) {
      this.jdField_a_of_type_Pxh.setCenterLoading();
    }
    this.jdField_a_of_type_Pxf.a(true, new pxq(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Pxf.a())
    {
      if (this.jdField_a_of_type_Pxh != null) {
        this.jdField_a_of_type_Pxh.setFooterNoMore();
      }
      return;
    }
    if (this.jdField_a_of_type_Pxh != null) {
      this.jdField_a_of_type_Pxh.setFooterLoading();
    }
    this.jdField_a_of_type_Pxf.a(new pxr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxp
 * JD-Core Version:    0.7.0.1
 */