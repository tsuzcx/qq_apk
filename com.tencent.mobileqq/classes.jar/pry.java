import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pry
  implements prp<BEAN>
{
  pry(prw paramprw) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (prw.a(this.a) != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      prw.a(this.a).setListData(paramList, true);
      if (prw.a(this.a).a()) {
        prw.a(this.a).setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    prw.a(this.a).setFooterNoMore();
    return;
    label69:
    QLog.i("ListPresenter", 2, "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
    prw.a(this.a).setFooterError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pry
 * JD-Core Version:    0.7.0.1
 */