import android.support.annotation.Nullable;
import java.util.List;

public class pzl<BEAN, VIEW extends pzd<BEAN>>
  implements pzc<BEAN, VIEW>
{
  private pzb<BEAN> jdField_a_of_type_Pzb;
  private pzd<BEAN> jdField_a_of_type_Pzd;
  private boolean jdField_a_of_type_Boolean;
  
  public pzl(pzb<BEAN> parampzb)
  {
    this.jdField_a_of_type_Pzb = parampzb;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_Pzd != null)
      {
        this.jdField_a_of_type_Pzd.setCenterHide();
        this.jdField_a_of_type_Pzd.setListData(paramList, false);
        this.jdField_a_of_type_Pzd.setFooterNoMore();
        this.jdField_a_of_type_Pzd.setHeaderLoading();
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Pzd != null)) {
      this.jdField_a_of_type_Pzd.setHeaderError(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_Pzd != null))
    {
      this.jdField_a_of_type_Pzd.setCenterHide();
      this.jdField_a_of_type_Pzd.setListData(paramList, false);
      this.jdField_a_of_type_Pzd.setFooterNoMore();
    }
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Pzd == null)) {
      return;
    }
    this.jdField_a_of_type_Pzd.setCenterError(paramInt, paramString);
    this.jdField_a_of_type_Pzd.setTotal(0);
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Pzd != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Pzd.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pzd = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Pzd != null)
    {
      this.jdField_a_of_type_Pzd.setTotal(paramInt);
      this.jdField_a_of_type_Pzd.setListData(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_Pzd.setCenterHide();
      if (this.jdField_a_of_type_Pzb.a()) {
        this.jdField_a_of_type_Pzd.setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Pzd.setFooterNoMore();
    return;
    label82:
    this.jdField_a_of_type_Pzd.setCenterEmpty();
    this.jdField_a_of_type_Pzd.setFooterHide();
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_Pzd = paramVIEW;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pzd != null) {
      this.jdField_a_of_type_Pzd.setCenterLoading();
    }
    this.jdField_a_of_type_Pzb.a(true, new pzm(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Pzb.a())
    {
      if (this.jdField_a_of_type_Pzd != null) {
        this.jdField_a_of_type_Pzd.setFooterNoMore();
      }
      return;
    }
    if (this.jdField_a_of_type_Pzd != null) {
      this.jdField_a_of_type_Pzd.setFooterLoading();
    }
    this.jdField_a_of_type_Pzb.a(new pzn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pzl
 * JD-Core Version:    0.7.0.1
 */