import android.support.annotation.Nullable;
import java.util.List;

public class qjt<BEAN, VIEW extends qjl<BEAN>>
  implements qjk<BEAN, VIEW>
{
  private qjj<BEAN> jdField_a_of_type_Qjj;
  private qjl<BEAN> jdField_a_of_type_Qjl;
  private boolean jdField_a_of_type_Boolean;
  
  public qjt(qjj<BEAN> paramqjj)
  {
    this.jdField_a_of_type_Qjj = paramqjj;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_Qjl != null)
      {
        this.jdField_a_of_type_Qjl.setCenterHide();
        this.jdField_a_of_type_Qjl.setListData(paramList, false);
        this.jdField_a_of_type_Qjl.setFooterNoMore();
        this.jdField_a_of_type_Qjl.setHeaderLoading();
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Qjl != null)) {
      this.jdField_a_of_type_Qjl.setHeaderError(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_Qjl != null))
    {
      this.jdField_a_of_type_Qjl.setCenterHide();
      this.jdField_a_of_type_Qjl.setListData(paramList, false);
      this.jdField_a_of_type_Qjl.setFooterNoMore();
    }
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Qjl == null)) {
      return;
    }
    this.jdField_a_of_type_Qjl.setCenterError(paramInt, paramString);
    this.jdField_a_of_type_Qjl.setTotal(0);
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Qjl != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Qjl.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Qjl = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Qjl != null)
    {
      this.jdField_a_of_type_Qjl.setTotal(paramInt);
      this.jdField_a_of_type_Qjl.setListData(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_Qjl.setCenterHide();
      if (this.jdField_a_of_type_Qjj.a()) {
        this.jdField_a_of_type_Qjl.setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Qjl.setFooterNoMore();
    return;
    label82:
    this.jdField_a_of_type_Qjl.setCenterEmpty();
    this.jdField_a_of_type_Qjl.setFooterHide();
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_Qjl = paramVIEW;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qjl != null) {
      this.jdField_a_of_type_Qjl.setCenterLoading();
    }
    this.jdField_a_of_type_Qjj.a(true, new qju(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Qjj.a())
    {
      if (this.jdField_a_of_type_Qjl != null) {
        this.jdField_a_of_type_Qjl.setFooterNoMore();
      }
      return;
    }
    if (this.jdField_a_of_type_Qjl != null) {
      this.jdField_a_of_type_Qjl.setFooterLoading();
    }
    this.jdField_a_of_type_Qjj.a(new qjv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjt
 * JD-Core Version:    0.7.0.1
 */