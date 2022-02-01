import com.tencent.qphone.base.util.QLog;
import java.util.List;

class qjv
  implements qjm<BEAN>
{
  qjv(qjt paramqjt) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (qjt.a(this.a) != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      qjt.a(this.a).setListData(paramList, true);
      if (qjt.a(this.a).a()) {
        qjt.a(this.a).setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    qjt.a(this.a).setFooterNoMore();
    return;
    label69:
    QLog.i("ListPresenter", 2, "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
    qjt.a(this.a).setFooterError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjv
 * JD-Core Version:    0.7.0.1
 */