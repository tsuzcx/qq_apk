import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pib
  implements php<BEAN>
{
  pib(pia parampia) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt1, Boolean paramBoolean1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      pia.a(this.a, paramBoolean1.booleanValue(), paramInt1, paramList);
      return;
    }
    QLog.i("ListPresenter", 2, "loadFirstPage error, errorCode=" + paramInt2 + ", errorMsg= " + paramString);
    pia.a(this.a, paramBoolean1.booleanValue(), paramList, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pib
 * JD-Core Version:    0.7.0.1
 */