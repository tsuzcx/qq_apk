import android.support.annotation.Nullable;
import java.util.List;

public class prw<BEAN, VIEW extends pro<BEAN>>
  implements prm<BEAN, VIEW>
{
  private prl<BEAN> jdField_a_of_type_Prl;
  private pro<BEAN> jdField_a_of_type_Pro;
  private boolean jdField_a_of_type_Boolean;
  
  public prw(prl<BEAN> paramprl)
  {
    this.jdField_a_of_type_Prl = paramprl;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (this.jdField_a_of_type_Pro != null)
      {
        this.jdField_a_of_type_Pro.setCenterHide();
        this.jdField_a_of_type_Pro.setListData(paramList, false);
        this.jdField_a_of_type_Pro.setFooterNoMore();
        this.jdField_a_of_type_Pro.setHeaderLoading();
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Pro != null)) {
      this.jdField_a_of_type_Pro.setHeaderError(paramInt, paramString);
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean) && (this.jdField_a_of_type_Pro != null))
    {
      this.jdField_a_of_type_Pro.setCenterHide();
      this.jdField_a_of_type_Pro.setListData(paramList, false);
      this.jdField_a_of_type_Pro.setFooterNoMore();
    }
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Pro == null)) {
      return;
    }
    this.jdField_a_of_type_Pro.setCenterError(paramInt, paramString);
    this.jdField_a_of_type_Pro.setTotal(0);
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Pro != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Pro.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Pro = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    if (this.jdField_a_of_type_Pro != null)
    {
      this.jdField_a_of_type_Pro.setTotal(paramInt);
      this.jdField_a_of_type_Pro.setListData(paramList, false);
      if ((paramList == null) || (paramList.isEmpty())) {
        break label82;
      }
      this.jdField_a_of_type_Pro.setCenterHide();
      if (this.jdField_a_of_type_Prl.a()) {
        this.jdField_a_of_type_Pro.setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Pro.setFooterNoMore();
    return;
    label82:
    this.jdField_a_of_type_Pro.setCenterEmpty();
    this.jdField_a_of_type_Pro.setFooterHide();
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_Pro = paramVIEW;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pro != null) {
      this.jdField_a_of_type_Pro.setCenterLoading();
    }
    this.jdField_a_of_type_Prl.a(true, new prx(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Prl.a())
    {
      if (this.jdField_a_of_type_Pro != null) {
        this.jdField_a_of_type_Pro.setFooterNoMore();
      }
      return;
    }
    if (this.jdField_a_of_type_Pro != null) {
      this.jdField_a_of_type_Pro.setFooterLoading();
    }
    this.jdField_a_of_type_Prl.a(new pry(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     prw
 * JD-Core Version:    0.7.0.1
 */